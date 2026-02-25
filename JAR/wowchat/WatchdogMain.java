/*
 * Decompiled with CFR 0.152.
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
    private static final String MARK_DISCONNECTED = "Disconnected from server!";
    private static final String[] HEALTHY_MARKERS = new String[]{"Successfully joined the world!", "Successfully logged in!", "Connected! Authenticating...", "Connected! Sending account login information..."};
    private static final String[] CONNECTING_MARKERS = new String[]{"Connecting", "Reconnecting", "Attempting to connect", "Trying to connect"};
    private static final int RESTART_DELAY_SECONDS = 30;
    private static final int STUCK_TIMEOUT_SECONDS = 360;
    private static final int MIN_DISCONNECT_GRACE_SECONDS = 30;
    private static final int CHECK_INTERVAL_MS = 2000;

    public static void main(String[] stringArray) throws Exception {
        boolean bl = System.console() != null;
        File file = WatchdogMain.getCurrentJarFile();
        while (true) {
            long l = System.currentTimeMillis();
            long[] lArray = new long[]{l};
            long[] lArray2 = new long[]{-1L};
            long[] lArray3 = new long[]{-1L};
            Process process = WatchdogMain.startChildProcess(file, stringArray);
            Thread thread2 = new Thread((Runnable)new StreamPump(process.getInputStream(), bl, new LineObserver(){

                @Override
                public void onLine(String string) {
                    if (string == null) {
                        return;
                    }
                    if (WatchdogMain.containsAny(string, HEALTHY_MARKERS)) {
                        lArray[0] = System.currentTimeMillis();
                    }
                    if (string.contains(WatchdogMain.MARK_DISCONNECTED)) {
                        lArray2[0] = System.currentTimeMillis();
                    }
                    if (WatchdogMain.containsAny(string, CONNECTING_MARKERS)) {
                        lArray3[0] = System.currentTimeMillis();
                    }
                }
            }), "watchdog-stdout");
            Thread thread3 = new Thread((Runnable)new StreamPump(process.getErrorStream(), bl, new LineObserver(){

                @Override
                public void onLine(String string) {
                }
            }), "watchdog-stderr");
            thread2.setDaemon(true);
            thread3.setDaemon(true);
            thread2.start();
            thread3.start();
            boolean bl2 = false;
            while (true) {
                try {
                    process.exitValue();
                    bl2 = true;
                }
                catch (IllegalThreadStateException illegalThreadStateException) {
                    long l2 = System.currentTimeMillis();
                    long l3 = (l2 - lArray[0]) / 1000L;
                    if (lArray2[0] > 0L) {
                        long l4 = (l2 - lArray2[0]) / 1000L;
                        if (l4 > 30L && l3 >= 360L) {
                            bl2 = true;
                            break;
                        }
                    } else if (lArray3[0] > 0L && l3 >= 360L) {
                        bl2 = true;
                        break;
                    }
                    Thread.sleep(2000L);
                    continue;
                }
                break;
            }
            if (!bl2) continue;
            try {
                process.destroy();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            try {
                Thread.sleep(2000L);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            try {
                process.destroyForcibly();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            Thread.sleep(30000L);
        }
    }

    private static boolean containsAny(String string, String[] stringArray) {
        for (int i = 0; i < stringArray.length; ++i) {
            if (!string.contains(stringArray[i])) continue;
            return true;
        }
        return false;
    }

    private static Process startChildProcess(File file, String[] stringArray) throws IOException {
        String string = WatchdogMain.findJavaExecutable();
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(string);
        List<String> list = ManagementFactory.getRuntimeMXBean().getInputArguments();
        for (String string2 : list) {
            if ("-jar".equals(string2)) continue;
            arrayList.add(string2);
        }
        arrayList.add("-cp");
        arrayList.add(file.getAbsolutePath());
        arrayList.add(CHILD_MAIN);
        if (stringArray != null) {
            for (int i = 0; i < stringArray.length; ++i) {
                arrayList.add(stringArray[i]);
            }
        }
        ProcessBuilder processBuilder = new ProcessBuilder(arrayList);
        processBuilder.directory(file.getParentFile());
        processBuilder.redirectErrorStream(false);
        return processBuilder.start();
    }

    private static File getCurrentJarFile() throws Exception {
        String string = WatchdogMain.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        string = string.replace("%20", " ");
        return new File(string).getAbsoluteFile();
    }

    private static String findJavaExecutable() {
        String string = System.getProperty("java.home");
        File file = new File(string, "bin");
        File file2 = new File(file, WatchdogMain.isWindows() ? "java.exe" : "java");
        if (file2.exists()) {
            return file2.getAbsolutePath();
        }
        return "java";
    }

    private static boolean isWindows() {
        String string = System.getProperty("os.name");
        return string != null && string.toLowerCase().contains("win");
    }

    private static final class StreamPump
    implements Runnable {
        private final InputStream in;
        private final boolean echo;
        private final LineObserver observer;

        StreamPump(InputStream inputStream2, boolean bl, LineObserver lineObserver) {
            this.in = inputStream2;
            this.echo = bl;
            this.observer = lineObserver;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void run() {
            BufferedReader bufferedReader = null;
            try {
                String string;
                bufferedReader = new BufferedReader(new InputStreamReader(this.in, Charset.forName("UTF-8")));
                while ((string = bufferedReader.readLine()) != null) {
                    try {
                        this.observer.onLine(string);
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                    if (!this.echo) continue;
                    System.out.println(string);
                }
            }
            catch (Throwable throwable) {
            }
            finally {
                try {
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                }
                catch (Throwable throwable) {}
            }
        }
    }

    private static interface LineObserver {
        public void onLine(String var1);
    }
}

