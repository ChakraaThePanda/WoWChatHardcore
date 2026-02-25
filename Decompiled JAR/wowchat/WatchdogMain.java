/*
 * WatchdogMain.java — rewritten to fix the 6-minute restart bug.
 *
 * ROOT CAUSE OF ORIGINAL BUG:
 *   CONNECTING_MARKERS fired on the very first "Connecting to realm server"
 *   log line at startup, setting lArray3[0] immediately. After exactly
 *   STUCK_TIMEOUT_SECONDS (360s) the condition became true even on a perfectly
 *   healthy bot, killing it every 6 minutes.
 *
 * FIX — FILE-BASED HEALTH CHECK:
 *   Rather than relying on log lines (which stop flowing during guild silence),
 *   the Watchdog reads a health file written by GuildOnlineListPublisher every
 *   30 seconds. The file contains the timestamp of the last WoW packet received
 *   by GamePacketHandler. This means:
 *
 *   - Guild silence does NOT trigger a restart (WoW keepalive packets still flow)
 *   - Silent WoW server crash DOES trigger a restart (packets stop, file goes stale)
 *   - Internet drop DOES trigger a restart (same)
 *   - Bot hard crash DOES trigger a restart (file stops being written)
 *
 *   State 1 — STARTING: health file does not exist yet. We give the bot up to
 *             STARTUP_TIMEOUT_SECONDS to create it. If it never does, restart.
 *
 *   State 2 — HEALTHY: health file exists and timestamp is recent (within
 *             STALE_TIMEOUT_SECONDS). Normal operation.
 *
 *   State 3 — STALE: health file exists but timestamp is too old, OR file
 *             has disappeared. Bot is dead or WoW connection is lost. Restart.
 *
 * NOTE: The bot already has internal reconnect logic in WoWChat$.java that
 * handles normal disconnects. The Watchdog is only a last resort.
 */
package wowchat;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public final class WatchdogMain {

    private static final String CHILD_MAIN = "wowchat.WoWChat";

    /** Health file written by GuildOnlineListPublisher every 30s. */
    private static final String HEALTH_FILE = "watchdog.health";

    // Timing constants (all in seconds unless noted)
    /**
     * How long to wait for the health file to appear after startup.
     * The bot needs time to connect to WoW before packets flow.
     */
    private static final int STARTUP_TIMEOUT_SECONDS  = 120;

    /**
     * How old the health file timestamp can be before we consider the bot dead.
     * The guild roster is requested every 60s, so 3 minutes allows 3 missed cycles.
     * The file is written every 30s, so 3 minutes is very generous —
     * it allows for up to 6 missed writes before triggering a restart.
     */
    private static final int STALE_TIMEOUT_SECONDS    = 180; // 3 minutes

    /** Delay between watchdog kill and restarting the child process. */
    private static final int RESTART_DELAY_SECONDS    = 30;

    /** How often the watchdog checks the health file. */
    private static final int CHECK_INTERVAL_MS        = 10000; // 10 seconds

    public static void main(String[] args) throws Exception {
        boolean echoToConsole = System.console() != null;
        File jarFile = getCurrentJarFile();

        System.out.println("[Watchdog] Starting. Will manage: " + CHILD_MAIN);

        while (true) {
            long startTime = System.currentTimeMillis();

            // Delete any stale health file from a previous run
            try { Files.deleteIfExists(Paths.get(HEALTH_FILE)); } catch (Throwable ignored) {}

            Process process = startChildProcess(jarFile, args);
            System.out.println("[Watchdog] Child process started (PID tracking not available in Java 8).");

            // Pump stdout and stderr — just echo to console, no state tracking needed
            // Health is determined entirely by the health file, not log lines
            Thread stdoutThread = new Thread(new StreamPump(
                process.getInputStream(), echoToConsole, line -> {}
            ), "watchdog-stdout");
            Thread stderrThread = new Thread(new StreamPump(
                process.getErrorStream(), echoToConsole, line -> {}
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
                    // Process still running — check health file
                }

                long now    = System.currentTimeMillis();
                long uptime = (now - startTime) / 1000L;

                File healthFile = new File(HEALTH_FILE);

                // CASE 1: Health file doesn't exist yet — bot hasn't connected to WoW
                if (!healthFile.exists()) {
                    if (uptime > STARTUP_TIMEOUT_SECONDS) {
                        System.out.println("[Watchdog] Bot never created health file in "
                            + STARTUP_TIMEOUT_SECONDS + "s. Killing and restarting.");
                        shouldRestart = true;
                        break;
                    }
                    // Still within startup window — keep waiting
                    Thread.sleep(CHECK_INTERVAL_MS);
                    continue;
                }

                // CASE 2: Health file exists — read the last WoW packet timestamp
                long lastPacketMs = 0L;
                try {
                    String raw = new String(Files.readAllBytes(Paths.get(HEALTH_FILE)), "UTF-8").trim();
                    lastPacketMs = Long.parseLong(raw);
                } catch (Throwable t) {
                    System.err.println("[Watchdog] Could not read health file: " + t.getMessage());
                    Thread.sleep(CHECK_INTERVAL_MS);
                    continue;
                }

                long staleSeconds = (now - lastPacketMs) / 1000L;
                if (staleSeconds > STALE_TIMEOUT_SECONDS) {
                    System.out.println("[Watchdog] Health file is stale by " + staleSeconds
                        + "s (limit: " + STALE_TIMEOUT_SECONDS + "s). "
                        + "WoW connection appears dead. Killing and restarting.");
                    shouldRestart = true;
                    break;
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
