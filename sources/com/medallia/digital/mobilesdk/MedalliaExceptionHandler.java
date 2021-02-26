package com.medallia.digital.mobilesdk;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import org.json.JSONObject;

class MedalliaExceptionHandler implements Thread.UncaughtExceptionHandler {
    protected static final String CRASHES_FOLDER = ".crashes";
    private static final String FILE_NAME = "crash.txt";
    protected static final String FILE_PATH = ".crashes/crash.txt";
    private Thread.UncaughtExceptionHandler defaultExceptionHandler;
    private String filePath;
    private boolean isRegistered;

    MedalliaExceptionHandler(Context context) {
        if (context != null) {
            this.filePath = getPath(CRASHES_FOLDER, context);
        }
    }

    private String getPath(String str, Context context) {
        if (context == null) {
            return null;
        }
        return String.format("%s/%s", new Object[]{getSdkDirectoryPath(context), str});
    }

    private String getSdkDirectoryPath(Context context) {
        if (context == null) {
            return null;
        }
        return String.format("%s/%s", new Object[]{context.getFilesDir().getPath(), "medalliaDigitalSDK"});
    }

    private String getStackTrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        String obj = stringWriter.toString();
        printWriter.close();
        return obj;
    }

    private void saveCrashReport(Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("stacktrace", getStackTrace(th));
            writeToFile(FILE_NAME, jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeToFile(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str2 != null && this.filePath != null) {
            File file = new File(this.filePath + "/" + str);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(str2.getBytes());
                fileOutputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean isRegistered() {
        return this.isRegistered;
    }

    /* access modifiers changed from: protected */
    public void register() {
        if (!this.isRegistered) {
            this.isRegistered = true;
            this.defaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        saveCrashReport(th);
        this.defaultExceptionHandler.uncaughtException(thread, th);
    }

    /* access modifiers changed from: protected */
    public void unregister() {
        if (this.isRegistered) {
            Thread.setDefaultUncaughtExceptionHandler(this.defaultExceptionHandler);
            this.isRegistered = false;
        }
    }

    /* access modifiers changed from: protected */
    public void updateFilePath(Context context) {
        if (context != null) {
            this.filePath = getPath(CRASHES_FOLDER, context);
        }
    }
}
