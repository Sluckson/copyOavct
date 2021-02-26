package com.lowagie.tools;

import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class Executable {
    public static String acroread;

    private static Process action(String str, String str2, boolean z) throws IOException {
        String str3;
        Process process;
        if (str2.trim().length() > 0) {
            str3 = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str2.trim();
        } else {
            str3 = "";
        }
        if (acroread != null) {
            process = Runtime.getRuntime().exec(String.valueOf(acroread) + str3 + " \"" + str + "\"");
        } else if (isWindows()) {
            if (isWindows9X()) {
                process = Runtime.getRuntime().exec("command.com /C start acrord32" + str3 + " \"" + str + "\"");
            } else {
                process = Runtime.getRuntime().exec("cmd /c start acrord32" + str3 + " \"" + str + "\"");
            }
        } else if (!isMac()) {
            process = null;
        } else if (str3.trim().length() == 0) {
            process = Runtime.getRuntime().exec(new String[]{"/usr/bin/open", str});
        } else {
            process = Runtime.getRuntime().exec(new String[]{"/usr/bin/open", str3.trim(), str});
        }
        if (process != null && z) {
            try {
                process.waitFor();
            } catch (InterruptedException unused) {
            }
        }
        return process;
    }

    public static final Process openDocument(String str, boolean z) throws IOException {
        return action(str, "", z);
    }

    public static final Process openDocument(File file, boolean z) throws IOException {
        return openDocument(file.getAbsolutePath(), z);
    }

    public static final Process openDocument(String str) throws IOException {
        return openDocument(str, false);
    }

    public static final Process openDocument(File file) throws IOException {
        return openDocument(file, false);
    }

    public static final Process printDocument(String str, boolean z) throws IOException {
        return action(str, "/p", z);
    }

    public static final Process printDocument(File file, boolean z) throws IOException {
        return printDocument(file.getAbsolutePath(), z);
    }

    public static final Process printDocument(String str) throws IOException {
        return printDocument(str, false);
    }

    public static final Process printDocument(File file) throws IOException {
        return printDocument(file, false);
    }

    public static final Process printDocumentSilent(String str, boolean z) throws IOException {
        return action(str, "/p /h", z);
    }

    public static final Process printDocumentSilent(File file, boolean z) throws IOException {
        return printDocumentSilent(file.getAbsolutePath(), z);
    }

    public static final Process printDocumentSilent(String str) throws IOException {
        return printDocumentSilent(str, false);
    }

    public static final Process printDocumentSilent(File file) throws IOException {
        return printDocumentSilent(file, false);
    }

    public static final void launchBrowser(String str) throws IOException {
        try {
            if (isMac()) {
                Class.forName("com.apple.mrj.MRJFileUtils").getDeclaredMethod("openURL", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
            } else if (isWindows()) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + str);
            } else {
                String[] strArr = {"firefox", "opera", "konqueror", "mozilla", "netscape"};
                String str2 = null;
                int i = 0;
                while (true) {
                    if (i >= strArr.length) {
                        break;
                    } else if (str2 != null) {
                        break;
                    } else {
                        if (Runtime.getRuntime().exec(new String[]{"which", strArr[i]}).waitFor() == 0) {
                            str2 = strArr[i];
                        }
                        i++;
                    }
                }
                if (str2 != null) {
                    Runtime.getRuntime().exec(new String[]{str2, str});
                    return;
                }
                throw new Exception("Could not find web browser.");
            }
        } catch (Exception unused) {
            throw new IOException("Error attempting to launch web browser");
        }
    }

    public static boolean isWindows() {
        String lowerCase = System.getProperty("os.name").toLowerCase();
        return (lowerCase.indexOf("windows") == -1 && lowerCase.indexOf("nt") == -1) ? false : true;
    }

    public static boolean isWindows9X() {
        String lowerCase = System.getProperty("os.name").toLowerCase();
        return lowerCase.equals("windows 95") || lowerCase.equals("windows 98");
    }

    public static boolean isMac() {
        return System.getProperty("os.name").toLowerCase().indexOf("mac") != -1;
    }

    public static boolean isLinux() {
        return System.getProperty("os.name").toLowerCase().indexOf("linux") != -1;
    }
}
