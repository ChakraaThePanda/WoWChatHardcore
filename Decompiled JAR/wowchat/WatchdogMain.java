/*
 * WatchdogMain.java — rewritten to fix the 6-minute restart bug.
 *
 * ROOT CAUSE OF ORIGINAL BUG:
 *   CONNECTING_MARKERS fired on the very first "Connecting to realm server"
 *   log line at startup, setting lArray3[0] immediately. After exactly
 *   STUCK_TIMEOUT_SECONDS (360s) the condition (lArray3[0] > 0 && l3 >= 360)
 *   became true even on a perfectly healthy bot, killing it every 6 minutes.
 *
 * FIX:
 *   The watchdog now uses a simple, clear state machine:
 *
 *   State 1 — STARTING: bot just launched. We give it up to STARTUP_TIMEOUT_SECONDS
 *             to produce a healthy marker. If it never does, kill and restart.
 *
 *   State 2 — HEALTHY: bot has logged in successfully. We reset a "last healthy"
 *             timestamp every time a healthy marker appears. The bot is only
 *             considered stuck if it has been UN-healthy for STUCK_TIMEOUT_SECONDS
 *             with no recovery. Normal operation never triggers this.
 *
 *   State 3 — DISCONNECTED: bot printed "Disconnected from server!" — we give it
 *             RECONNECT_GRACE_SECONDS to reconnect on its own (it has internal
 *             reconnect logic). Only if it fails to recover within that window
 *             do we kill and restart.
 *
 * NOTE: The bot already has internal reconnect logic in WoWChat$.java that
 * handles normal disconnects. The Watchdog is only a last resort for hard
 * crashes or completely stuck states.
 */
package wowchat;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public final class WatchdogMain {

    private static final String CHILD_MAIN = "wowchat.WoWChat";

    // Log line markers — must match what the bot actually prints
    private static final String   MARK_DISCONNECTED  = "Disconnected from server!";
    private static final String[] HEALTHY_MARKERS    = {
        "Successfully joined the world!",
        "Successfully logged in!",
        "Connected! Authenticating...",
        "Connected! Sending account login information..."
    };

    // Timing constants (all in seconds unless noted)
    /** How long to wait for the bot to reach a healthy state on first startup. */
    private static final int STARTUP_TIMEOUT_SECONDS  = 120;

    /**
     * After the bot has been healthy at least once, how long it can go without
     * a healthy marker before we consider it stuck and kill it.
     * Set generously — this should only fire for genuine hard hangs, not
     * normal server restarts which the bot recovers from by itself.
     */
    private static final int STUCK_TIMEOUT_SECONDS    = 600; // 10 minutes

    /**
     * After a "Disconnected from server!" line, how long we wait for the bot's
     * own internal reconnect to succeed before we step in and kill/restart.
     * The bot reconnects in 10s internally, so 120s is very generous.
     */
    private static final int RECONNECT_GRACE_SECONDS  = 120;

    /** Delay between watchdog kill and restarting the child process. */
    private static final int RESTART_DELAY_SECONDS    = 30;

    /** How often the watchdog checks the child process state. */
    private static final int CHECK_INTERVAL_MS        = 3000;

    public static void main(String[] args) throws Exception {
        boolean echoToConsole = System.console() != null;
        File jarFile = getCurrentJarFile();

        System.out.println("[Watchdog] Starting. Will manage: " + CHILD_MAIN);

        while (true) {
            // --- Shared state arrays (long[] so lambdas can write to them) ---
            // [0] = timestamp of last healthy log line (-1 = never seen)
            final long[] lastHealthyTime    = { -1L };
            // [0] = timestamp of "Disconnected from server!" line (-1 = not seen)
            final long[] disconnectedTime   = { -1L };
            // [0] = System.currentTimeMillis() when process was started
            final long[] startTime          = { System.currentTimeMillis() };

            Process process = startChildProcess(jarFile, args);
            System.out.println("[Watchdog] Child process started (PID tracking not available in Java 8).");

            // Pump stdout — update state based on log lines
            Thread stdoutThread = new Thread(new StreamPump(
                process.getInputStream(),
                echoToConsole,
                line -> {
                    if (line == null) return;

                    if (containsAny(line, HEALTHY_MARKERS)) {
                        // Bot is alive and well — reset healthy timestamp and clear disconnect flag
                        lastHealthyTime[0]  = System.currentTimeMillis();
                        disconnectedTime[0] = -1L; // recovered from disconnect
                    }

                    if (line.contains(MARK_DISCONNECTED)) {
                        // Record when the disconnect happened
                        // Only set if not already set (so we track first disconnect time)
                        if (disconnectedTime[0] < 0L) {
                            disconnectedTime[0] = System.currentTimeMillis();
                        }
                    }
                }
            ), "watchdog-stdout");

            // Pump stderr — just echo it, no state changes needed
            Thread stderrThread = new Thread(new StreamPump(
                process.getErrorStream(),
                echoToConsole,
                line -> { /* stderr: no state tracking needed */ }
            ), "watchdog-stderr");

            stdoutThread.setDaemon(true);
            stderrThread.setDaemon(true);
            stdoutThread.start();
            stderrThread.start();

            // --- Watchdog monitoring loop ---
            boolean shouldRestart = false;

            while (true) {
                // Check if process exited on its own
                try {
                    int exitCode = process.exitValue();
                    System.out.println("[Watchdog] Child process exited with code " + exitCode + ". Will restart.");
                    shouldRestart = true;
                    break;
                } catch (IllegalThreadStateException e) {
                    // Process still running — check health
                }

                long now        = System.currentTimeMillis();
                long uptime     = (now - startTime[0]) / 1000L;
                long sinceHealthy = lastHealthyTime[0] < 0L
                    ? uptime                                        // never been healthy: use uptime
                    : (now - lastHealthyTime[0]) / 1000L;          // time since last healthy

                // CASE 1: Never reached a healthy state — startup timeout
                if (lastHealthyTime[0] < 0L && uptime > STARTUP_TIMEOUT_SECONDS) {
                    System.out.println("[Watchdog] Bot never reached a healthy state in "
                        + STARTUP_TIMEOUT_SECONDS + "s. Killing and restarting.");
                    shouldRestart = true;
                    break;
                }

                // CASE 2: Was healthy before, now has been unhealthy for too long
                // (covers hard crashes, infinite loops, etc.)
                if (lastHealthyTime[0] >= 0L && sinceHealthy > STUCK_TIMEOUT_SECONDS) {
                    System.out.println("[Watchdog] Bot has been unhealthy for " + sinceHealthy
                        + "s (limit: " + STUCK_TIMEOUT_SECONDS + "s). Killing and restarting.");
                    shouldRestart = true;
                    break;
                }

                // CASE 3: Disconnected and bot failed to reconnect within grace period
                if (disconnectedTime[0] >= 0L) {
                    long sinceDisconnect = (now - disconnectedTime[0]) / 1000L;
                    if (sinceDisconnect > RECONNECT_GRACE_SECONDS) {
                        System.out.println("[Watchdog] Bot disconnected " + sinceDisconnect
                            + "s ago and has not recovered (limit: " + RECONNECT_GRACE_SECONDS
                            + "s). Killing and restarting.");
                        shouldRestart = true;
                        break;
                    }
                }

                Thread.sleep(CHECK_INTERVAL_MS);
            }

            if (!shouldRestart) continue;

            // --- Kill the child process cleanly ---
            System.out.println("[Watchdog] Stopping child process...");
            try { process.destroy(); } catch (Throwable ignored) {}
            try { Thread.sleep(2000); } catch (Throwable ignored) {}
            try { process.destroyForcibly(); } catch (Throwable ignored) {}

            System.out.println("[Watchdog] Waiting " + RESTART_DELAY_SECONDS + "s before restarting...");
            Thread.sleep(RESTART_DELAY_SECONDS * 1000L);
            System.out.println("[Watchdog] Restarting child process.");
        }
    }

    // -------------------------------------------------------------------------
    // Helpers
    // -------------------------------------------------------------------------

    private static boolean containsAny(String line, String[] markers) {
        for (String marker : markers) {
            if (line.contains(marker)) return true;
        }
        return false;
    }

    private static Process startChildProcess(File jarFile, String[] args) throws IOException {
        String java = findJavaExecutable();
        List<String> cmd = new ArrayList<>();
        cmd.add(java);

        // Pass through JVM flags (e.g. -Xmx) but skip -jar since we use -cp
        for (String arg : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
            if (!"-jar".equals(arg)) cmd.add(arg);
        }

        cmd.add("-cp");
        cmd.add(jarFile.getAbsolutePath());
        cmd.add(CHILD_MAIN);

        if (args != null) {
            for (String arg : args) cmd.add(arg);
        }

        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.directory(jarFile.getParentFile());
        pb.redirectErrorStream(false);
        return pb.start();
    }

    private static File getCurrentJarFile() throws Exception {
        String path = WatchdogMain.class.getProtectionDomain()
            .getCodeSource().getLocation().getPath();
        path = path.replace("%20", " ");
        return new File(path).getAbsoluteFile();
    }

    private static String findJavaExecutable() {
        File javaHome = new File(System.getProperty("java.home"), "bin");
        File javaExe  = new File(javaHome, isWindows() ? "java.exe" : "java");
        return javaExe.exists() ? javaExe.getAbsolutePath() : "java";
    }

    private static boolean isWindows() {
        String os = System.getProperty("os.name");
        return os != null && os.toLowerCase().contains("win");
    }

    // -------------------------------------------------------------------------
    // StreamPump — reads a process stream line by line and notifies an observer
    // -------------------------------------------------------------------------

    @FunctionalInterface
    private interface LineObserver {
        void onLine(String line);
    }

    private static final class StreamPump implements Runnable {
        private final InputStream  in;
        private final boolean      echo;
        private final LineObserver observer;

        StreamPump(InputStream in, boolean echo, LineObserver observer) {
            this.in       = in;
            this.echo     = echo;
            this.observer = observer;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(in, Charset.forName("UTF-8")))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    try { observer.onLine(line); } catch (Throwable ignored) {}
                    if (echo) System.out.println(line);
                }
            } catch (Throwable ignored) {}
        }
    }
}
