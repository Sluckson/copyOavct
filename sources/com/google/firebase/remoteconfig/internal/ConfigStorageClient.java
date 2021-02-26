package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import androidx.annotation.AnyThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@AnyThread
/* compiled from: com.google.firebase:firebase-config@@19.1.4 */
public class ConfigStorageClient {
    private static final String JSON_STRING_ENCODING = "UTF-8";
    @GuardedBy("ConfigStorageClient.class")
    private static final Map<String, ConfigStorageClient> clientInstances = new HashMap();
    private final Context context;
    private final String fileName;

    private ConfigStorageClient(Context context2, String str) {
        this.context = context2;
        this.fileName = str;
    }

    public synchronized Void write(ConfigContainer configContainer) throws IOException {
        FileOutputStream openFileOutput = this.context.openFileOutput(this.fileName, 0);
        try {
            openFileOutput.write(configContainer.toString().getBytes("UTF-8"));
        } finally {
            openFileOutput.close();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0036 A[SYNTHETIC, Splitter:B:16:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003d A[Catch:{ FileNotFoundException | JSONException -> 0x003a, all -> 0x0030 }] */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.google.firebase.remoteconfig.internal.ConfigContainer read() throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            android.content.Context r1 = r6.context     // Catch:{ FileNotFoundException | JSONException -> 0x003a, all -> 0x0030 }
            java.lang.String r2 = r6.fileName     // Catch:{ FileNotFoundException | JSONException -> 0x003a, all -> 0x0030 }
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch:{ FileNotFoundException | JSONException -> 0x003a, all -> 0x0030 }
            int r2 = r1.available()     // Catch:{ FileNotFoundException | JSONException -> 0x002e, all -> 0x002c }
            byte[] r2 = new byte[r2]     // Catch:{ FileNotFoundException | JSONException -> 0x002e, all -> 0x002c }
            r3 = 0
            int r4 = r2.length     // Catch:{ FileNotFoundException | JSONException -> 0x002e, all -> 0x002c }
            r1.read(r2, r3, r4)     // Catch:{ FileNotFoundException | JSONException -> 0x002e, all -> 0x002c }
            java.lang.String r3 = new java.lang.String     // Catch:{ FileNotFoundException | JSONException -> 0x002e, all -> 0x002c }
            java.lang.String r4 = "UTF-8"
            r3.<init>(r2, r4)     // Catch:{ FileNotFoundException | JSONException -> 0x002e, all -> 0x002c }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ FileNotFoundException | JSONException -> 0x002e, all -> 0x002c }
            r2.<init>(r3)     // Catch:{ FileNotFoundException | JSONException -> 0x002e, all -> 0x002c }
            com.google.firebase.remoteconfig.internal.ConfigContainer r0 = com.google.firebase.remoteconfig.internal.ConfigContainer.copyOf(r2)     // Catch:{ FileNotFoundException | JSONException -> 0x002e, all -> 0x002c }
            if (r1 == 0) goto L_0x002a
            r1.close()     // Catch:{ all -> 0x0041 }
        L_0x002a:
            monitor-exit(r6)
            return r0
        L_0x002c:
            r0 = move-exception
            goto L_0x0034
        L_0x002e:
            goto L_0x003b
        L_0x0030:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x0034:
            if (r1 == 0) goto L_0x0039
            r1.close()     // Catch:{ all -> 0x0041 }
        L_0x0039:
            throw r0     // Catch:{ all -> 0x0041 }
        L_0x003a:
            r1 = r0
        L_0x003b:
            if (r1 == 0) goto L_0x0044
            r1.close()     // Catch:{ all -> 0x0041 }
            goto L_0x0044
        L_0x0041:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        L_0x0044:
            monitor-exit(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigStorageClient.read():com.google.firebase.remoteconfig.internal.ConfigContainer");
    }

    public synchronized Void clear() {
        this.context.deleteFile(this.fileName);
        return null;
    }

    public static synchronized ConfigStorageClient getInstance(Context context2, String str) {
        ConfigStorageClient configStorageClient;
        synchronized (ConfigStorageClient.class) {
            if (!clientInstances.containsKey(str)) {
                clientInstances.put(str, new ConfigStorageClient(context2, str));
            }
            configStorageClient = clientInstances.get(str);
        }
        return configStorageClient;
    }

    @VisibleForTesting
    public static synchronized void clearInstancesForTest() {
        synchronized (ConfigStorageClient.class) {
            clientInstances.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public String getFileName() {
        return this.fileName;
    }
}
