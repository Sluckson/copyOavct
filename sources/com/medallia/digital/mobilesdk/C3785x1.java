package com.medallia.digital.mobilesdk;

import android.text.TextUtils;
import android.util.Pair;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* renamed from: com.medallia.digital.mobilesdk.x1 */
class C3785x1 {

    /* renamed from: a */
    protected static final String f2033a = "medalliaDigitalSDK";

    /* renamed from: b */
    private static final String f2034b = "resources";

    /* renamed from: c */
    protected static final String f2035c = "targetRuleEngine";

    /* renamed from: d */
    protected static final String f2036d = "configuration";

    /* renamed from: e */
    private static final String f2037e = "templates";

    C3785x1() {
    }

    /* renamed from: a */
    protected static synchronized Pair<String, Boolean> m1884a(String str) {
        synchronized (C3785x1.class) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Pair<String, Boolean> b = m1891b(new File(m1897d(str)));
            return b;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0058, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static synchronized java.io.File m1885a(java.lang.String r5, java.lang.String r6) {
        /*
            java.lang.Class<com.medallia.digital.mobilesdk.x1> r0 = com.medallia.digital.mobilesdk.C3785x1.class
            monitor-enter(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0059 }
            r2 = 0
            if (r1 != 0) goto L_0x0057
            if (r6 != 0) goto L_0x000d
            goto L_0x0057
        L_0x000d:
            java.lang.String r5 = m1897d((java.lang.String) r5)     // Catch:{ all -> 0x0059 }
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x0059 }
            r1.<init>(r5)     // Catch:{ all -> 0x0059 }
            java.io.File r5 = r1.getParentFile()     // Catch:{ all -> 0x0059 }
            boolean r5 = r5.exists()     // Catch:{ all -> 0x0059 }
            if (r5 != 0) goto L_0x003c
            java.io.File r5 = r1.getParentFile()     // Catch:{ all -> 0x0059 }
            boolean r5 = r5.mkdirs()     // Catch:{ all -> 0x0059 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0059 }
            r3.<init>()     // Catch:{ all -> 0x0059 }
            java.lang.String r4 = "Directory for file was created = "
            r3.append(r4)     // Catch:{ all -> 0x0059 }
            r3.append(r5)     // Catch:{ all -> 0x0059 }
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x0059 }
            com.medallia.digital.mobilesdk.C3490e3.m661b(r5)     // Catch:{ all -> 0x0059 }
        L_0x003c:
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x004d }
            r5.<init>(r1)     // Catch:{ IOException -> 0x004d }
            byte[] r6 = r6.getBytes()     // Catch:{ IOException -> 0x004d }
            r5.write(r6)     // Catch:{ IOException -> 0x004d }
            r5.close()     // Catch:{ IOException -> 0x004d }
            monitor-exit(r0)
            return r1
        L_0x004d:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x0059 }
            com.medallia.digital.mobilesdk.C3490e3.m663c(r5)     // Catch:{ all -> 0x0059 }
            monitor-exit(r0)
            return r2
        L_0x0057:
            monitor-exit(r0)
            return r2
        L_0x0059:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.medallia.digital.mobilesdk.C3785x1.m1885a(java.lang.String, java.lang.String):java.io.File");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static synchronized java.io.File m1886a(java.lang.String r5, byte[] r6) {
        /*
            java.lang.Class<com.medallia.digital.mobilesdk.x1> r0 = com.medallia.digital.mobilesdk.C3785x1.class
            monitor-enter(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0055 }
            r2 = 0
            if (r1 != 0) goto L_0x0053
            if (r6 != 0) goto L_0x000d
            goto L_0x0053
        L_0x000d:
            java.lang.String r5 = m1897d((java.lang.String) r5)     // Catch:{ all -> 0x0055 }
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x0055 }
            r1.<init>(r5)     // Catch:{ all -> 0x0055 }
            java.io.File r5 = r1.getParentFile()     // Catch:{ IOException -> 0x0051 }
            boolean r5 = r5.exists()     // Catch:{ IOException -> 0x0051 }
            if (r5 != 0) goto L_0x003c
            java.io.File r5 = r1.getParentFile()     // Catch:{ IOException -> 0x0051 }
            boolean r5 = r5.mkdirs()     // Catch:{ IOException -> 0x0051 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0051 }
            r3.<init>()     // Catch:{ IOException -> 0x0051 }
            java.lang.String r4 = "Directory for file was created = "
            r3.append(r4)     // Catch:{ IOException -> 0x0051 }
            r3.append(r5)     // Catch:{ IOException -> 0x0051 }
            java.lang.String r5 = r3.toString()     // Catch:{ IOException -> 0x0051 }
            com.medallia.digital.mobilesdk.C3490e3.m661b(r5)     // Catch:{ IOException -> 0x0051 }
        L_0x003c:
            java.io.BufferedOutputStream r5 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0051 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0051 }
            r3.<init>(r1)     // Catch:{ IOException -> 0x0051 }
            r5.<init>(r3)     // Catch:{ IOException -> 0x0051 }
            r5.write(r6)     // Catch:{ IOException -> 0x0051 }
            r5.flush()     // Catch:{ IOException -> 0x0051 }
            r5.close()     // Catch:{ IOException -> 0x0051 }
            monitor-exit(r0)
            return r1
        L_0x0051:
            monitor-exit(r0)
            return r2
        L_0x0053:
            monitor-exit(r0)
            return r2
        L_0x0055:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.medallia.digital.mobilesdk.C3785x1.m1886a(java.lang.String, byte[]):java.io.File");
    }

    /* renamed from: a */
    protected static synchronized Boolean m1887a(File file) {
        synchronized (C3785x1.class) {
            if (file == null) {
                return null;
            }
            Boolean valueOf = Boolean.valueOf(file.delete());
            return valueOf;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0047, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static synchronized java.util.ArrayList<android.util.Pair<java.lang.String, java.lang.Boolean>> m1888a(java.lang.String r6, java.io.File r7) {
        /*
            java.lang.Class<com.medallia.digital.mobilesdk.x1> r0 = com.medallia.digital.mobilesdk.C3785x1.class
            monitor-enter(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0048 }
            r2 = 0
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)
            return r2
        L_0x000c:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0048 }
            r1.<init>()     // Catch:{ all -> 0x0048 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0048 }
            java.lang.String r6 = m1897d((java.lang.String) r6)     // Catch:{ all -> 0x0048 }
            r3.<init>(r6)     // Catch:{ all -> 0x0048 }
            boolean r6 = r3.exists()     // Catch:{ all -> 0x0048 }
            if (r6 == 0) goto L_0x0046
            boolean r6 = r3.isDirectory()     // Catch:{ all -> 0x0048 }
            if (r6 == 0) goto L_0x0046
            java.io.File[] r6 = r3.listFiles()     // Catch:{ all -> 0x0048 }
            int r2 = r6.length     // Catch:{ all -> 0x0048 }
            r3 = 0
        L_0x002c:
            if (r3 >= r2) goto L_0x0044
            r4 = r6[r3]     // Catch:{ all -> 0x0048 }
            if (r4 == 0) goto L_0x0041
            boolean r5 = r4.equals(r7)     // Catch:{ all -> 0x0048 }
            if (r5 != 0) goto L_0x0041
            android.util.Pair r4 = m1891b((java.io.File) r4)     // Catch:{ all -> 0x0048 }
            if (r4 == 0) goto L_0x0041
            r1.add(r4)     // Catch:{ all -> 0x0048 }
        L_0x0041:
            int r3 = r3 + 1
            goto L_0x002c
        L_0x0044:
            monitor-exit(r0)
            return r1
        L_0x0046:
            monitor-exit(r0)
            return r2
        L_0x0048:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.medallia.digital.mobilesdk.C3785x1.m1888a(java.lang.String, java.io.File):java.util.ArrayList");
    }

    /* renamed from: a */
    protected static synchronized void m1889a() {
        synchronized (C3785x1.class) {
            C3490e3.m659a("Files");
            m1891b(new File(m1896d()));
        }
    }

    /* renamed from: b */
    protected static double m1890b() {
        File file = new File(m1896d());
        return (!file.exists() || !file.isDirectory()) ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : C3488e1.m652a(m1894c(file));
    }

    /* renamed from: b */
    private static Pair<String, Boolean> m1891b(File file) {
        if (!file.exists()) {
            return null;
        }
        if (file.isDirectory()) {
            for (File b : file.listFiles()) {
                m1891b(b);
            }
        }
        boolean delete = file.delete();
        C3490e3.m661b("File was deleted = " + delete);
        return new Pair<>(file.getPath(), Boolean.valueOf(delete));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Boolean} */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
        return r2;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static synchronized java.lang.Boolean m1892b(java.lang.String r3) {
        /*
            java.lang.Class<com.medallia.digital.mobilesdk.x1> r0 = com.medallia.digital.mobilesdk.C3785x1.class
            monitor-enter(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x003b }
            r2 = 0
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)
            return r2
        L_0x000c:
            java.lang.String r3 = m1897d((java.lang.String) r3)     // Catch:{ all -> 0x003b }
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x003b }
            r1.<init>(r3)     // Catch:{ all -> 0x003b }
            boolean r3 = r1.exists()     // Catch:{ all -> 0x003b }
            if (r3 == 0) goto L_0x0039
            boolean r3 = r1.isDirectory()     // Catch:{ all -> 0x003b }
            if (r3 == 0) goto L_0x002f
            android.util.Pair r3 = m1891b((java.io.File) r1)     // Catch:{ all -> 0x003b }
            if (r3 != 0) goto L_0x0028
            goto L_0x002d
        L_0x0028:
            java.lang.Object r3 = r3.second     // Catch:{ all -> 0x003b }
            r2 = r3
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x003b }
        L_0x002d:
            monitor-exit(r0)
            return r2
        L_0x002f:
            boolean r3 = r1.delete()     // Catch:{ all -> 0x003b }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x003b }
            monitor-exit(r0)
            return r3
        L_0x0039:
            monitor-exit(r0)
            return r2
        L_0x003b:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.medallia.digital.mobilesdk.C3785x1.m1892b(java.lang.String):java.lang.Boolean");
    }

    /* renamed from: c */
    protected static double m1893c() {
        return C3488e1.m652a(m1894c(new File(m1897d(f2034b))));
    }

    /* renamed from: c */
    private static long m1894c(File file) {
        long j = 0;
        if (file != null && file.exists()) {
            for (File file2 : file.listFiles()) {
                j += file2.isDirectory() ? m1894c(file2) : file2.length();
            }
        }
        return j;
    }

    /* renamed from: c */
    protected static synchronized File m1895c(String str) {
        synchronized (C3785x1.class) {
            if (str == null) {
                return null;
            }
            File file = new File(m1897d(str));
            return file;
        }
    }

    /* renamed from: d */
    protected static String m1896d() {
        return String.format("%s/%s", new Object[]{C3595k3.m1060d().mo55513b().getFilesDir().getPath(), f2033a});
    }

    /* renamed from: d */
    protected static String m1897d(String str) {
        if (str != null && str.startsWith(m1896d())) {
            return str;
        }
        if (str == null || !str.startsWith("/")) {
            return String.format("%s/%s", new Object[]{m1896d(), str});
        }
        return String.format("%s%s", new Object[]{m1896d(), str});
    }

    /* renamed from: d */
    protected static synchronized boolean m1898d(File file) {
        boolean z;
        synchronized (C3785x1.class) {
            if (file != null) {
                if (file.exists()) {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    /* renamed from: e */
    protected static double m1899e() {
        return C3488e1.m652a(m1894c(new File(m1897d(f2035c))));
    }

    /* renamed from: e */
    protected static synchronized String m1900e(File file) {
        synchronized (C3785x1.class) {
            if (file != null) {
                if (file.exists()) {
                    StringBuilder sb = new StringBuilder();
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        }
                        bufferedReader.close();
                    } catch (IOException e) {
                        C3490e3.m663c(e.getMessage());
                    }
                    String sb2 = sb.toString();
                    return sb2;
                }
            }
            return null;
        }
    }

    /* renamed from: f */
    protected static double m1901f() {
        return C3488e1.m652a(m1894c(new File(m1897d(f2037e))));
    }
}
