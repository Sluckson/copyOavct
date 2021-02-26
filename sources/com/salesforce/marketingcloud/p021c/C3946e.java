package com.salesforce.marketingcloud.p021c;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.p021c.C3939b;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import repack.org.bouncycastle.cms.CMSAttributeTableGenerator;

@AutoValue
@SuppressLint({"UnknownNullness"})
/* renamed from: com.salesforce.marketingcloud.c.e */
public abstract class C3946e {

    /* renamed from: a */
    public static final String f2537a = "GET";

    /* renamed from: b */
    public static final String f2538b = "POST";

    /* renamed from: c */
    public static final String f2539c = "PATCH";

    /* renamed from: d */
    public static final int f2540d = -100;

    /* renamed from: e */
    private static final long f2541e = 30000;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final String f2542f = C4039h.m2810a((Class<?>) C3946e.class);

    /* renamed from: g */
    private String f2543g;

    @AutoValue.Builder
    /* renamed from: com.salesforce.marketingcloud.c.e$a */
    public static abstract class C3947a {

        /* renamed from: a */
        private Map<String, String> f2544a;

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract C3947a mo56386a(long j);

        /* renamed from: a */
        public abstract C3947a mo56387a(C3944d dVar);

        /* renamed from: a */
        public abstract C3947a mo56388a(String str);

        /* renamed from: a */
        public final C3947a mo56412a(String str, String str2) {
            if (str == null || str2 == null) {
                C4039h.m2820b(C3946e.f2542f, "header [%s:%s] had null key or value.", str, str2);
                return this;
            }
            if (this.f2544a == null) {
                this.f2544a = new HashMap();
            }
            this.f2544a.put(str, str2.trim());
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract C3947a mo56389a(List<String> list);

        /* renamed from: a */
        public abstract C3947a mo56390a(boolean z);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract String mo56391a();

        /* renamed from: b */
        public abstract C3947a mo56392b(String str);

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract C3946e mo56393b();

        /* renamed from: c */
        public abstract C3947a mo56394c(String str);

        /* renamed from: c */
        public final C3946e mo56413c() {
            Map<String, String> map = this.f2544a;
            int i = 0;
            if (map != null) {
                ArrayList arrayList = new ArrayList(map.size() * 2);
                for (Map.Entry next : this.f2544a.entrySet()) {
                    int i2 = i * 2;
                    arrayList.add(i2, next.getKey());
                    arrayList.add(i2 + 1, next.getValue());
                    i++;
                }
                mo56389a((List<String>) arrayList);
            } else {
                mo56389a((List<String>) new ArrayList(0));
            }
            if (mo56391a() == null) {
                mo56394c("");
            }
            return mo56393b();
        }

        /* renamed from: d */
        public abstract C3947a mo56395d(String str);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.salesforce.marketingcloud.c.e$b */
    public @interface C3948b {
    }

    /* renamed from: a */
    public static C3946e m2395a(Bundle bundle) {
        return m2398i().mo56388a(bundle.getString(FirebaseAnalytics.Param.METHOD)).mo56392b(bundle.getString("requestBody")).mo56386a(bundle.getLong("connectionTimeout")).mo56394c(bundle.getString(CMSAttributeTableGenerator.CONTENT_TYPE)).mo56390a(bundle.getBoolean("gzipRequest")).mo56395d(bundle.getString("url")).mo56389a((List<String>) bundle.getStringArrayList("headers")).mo56387a(C3944d.values()[bundle.getInt("mcRequestId", 0)]).mo56393b().mo56408a(bundle.getString("tag"));
    }

    /* renamed from: a */
    private static String m2396a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append(10);
                } else {
                    try {
                        break;
                    } catch (Exception e) {
                    }
                }
            } finally {
                try {
                    inputStream.close();
                    bufferedReader.close();
                } catch (Exception e2) {
                    C4039h.m2830e(f2542f, e2, "Failed while closing stream.", new Object[0]);
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static void m2397a(HttpURLConnection httpURLConnection, List<String> list) {
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                httpURLConnection.setRequestProperty(list.get(i), list.get(i + 1));
            }
        }
    }

    /* renamed from: i */
    public static C3947a m2398i() {
        return new C3939b.C3941a().mo56386a(30000).mo56390a(false);
    }

    /* renamed from: a */
    public C3946e mo56408a(String str) {
        this.f2543g = str;
        return this;
    }

    /* renamed from: a */
    public abstract String mo56375a();

    @Nullable
    /* renamed from: b */
    public abstract String mo56376b();

    /* renamed from: c */
    public abstract long mo56377c();

    /* renamed from: d */
    public abstract String mo56378d();

    /* renamed from: e */
    public abstract boolean mo56379e();

    /* renamed from: f */
    public abstract String mo56381f();

    /* renamed from: g */
    public abstract List<String> mo56382g();

    /* renamed from: h */
    public abstract C3944d mo56383h();

    @Nullable
    /* renamed from: j */
    public String mo56409j() {
        return this.f2543g;
    }

    /* renamed from: k */
    public Bundle mo56410k() {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.METHOD, mo56375a());
        bundle.putString("requestBody", mo56376b());
        bundle.putLong("connectionTimeout", mo56377c());
        bundle.putString(CMSAttributeTableGenerator.CONTENT_TYPE, mo56378d());
        bundle.putBoolean("gzipRequest", mo56379e());
        bundle.putString("url", mo56381f());
        bundle.putStringArrayList("headers", (ArrayList) mo56382g());
        bundle.putString("tag", mo56409j());
        bundle.putInt("mcRequestId", mo56383h().ordinal());
        return bundle;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(17:1|2|3|4|(3:8|9|10)|14|(1:20)(1:18)|19|21|(4:23|24|(3:26|27|28)(1:30)|29)|31|32|33|34|35|36|(1:38)) */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0111, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0113, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0114, code lost:
        r4 = r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x00f0 */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0111 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0144  */
    /* renamed from: l */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.salesforce.marketingcloud.p021c.C3953g mo56411l() {
        /*
            r10 = this;
            java.lang.String r0 = "PATCH"
            long r1 = java.lang.System.currentTimeMillis()
            r3 = 0
            r4 = 0
            java.net.URL r5 = new java.net.URL     // Catch:{ Exception -> 0x0119 }
            java.lang.String r6 = r10.mo56381f()     // Catch:{ Exception -> 0x0119 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x0119 }
            java.net.URLConnection r5 = r5.openConnection()     // Catch:{ Exception -> 0x0119 }
            java.lang.Object r5 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r5)     // Catch:{ Exception -> 0x0119 }
            java.net.URLConnection r5 = (java.net.URLConnection) r5     // Catch:{ Exception -> 0x0119 }
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ Exception -> 0x0119 }
            boolean r4 = r5 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            r6 = 21
            if (r4 == 0) goto L_0x003d
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            if (r4 >= r6) goto L_0x003d
            r4 = r5
            javax.net.ssl.HttpsURLConnection r4 = (javax.net.ssl.HttpsURLConnection) r4     // Catch:{ Exception -> 0x0033, all -> 0x0111 }
            com.salesforce.marketingcloud.c.h r7 = new com.salesforce.marketingcloud.c.h     // Catch:{ Exception -> 0x0033, all -> 0x0111 }
            r7.<init>()     // Catch:{ Exception -> 0x0033, all -> 0x0111 }
            r4.setSSLSocketFactory(r7)     // Catch:{ Exception -> 0x0033, all -> 0x0111 }
            goto L_0x003d
        L_0x0033:
            r4 = move-exception
            java.lang.String r7 = f2542f     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            java.lang.String r8 = "Exception thrown while setting SSL socket factory."
            java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            com.salesforce.marketingcloud.C4039h.m2830e(r7, r4, r8, r9)     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
        L_0x003d:
            java.lang.String r4 = r10.mo56375a()     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            boolean r4 = r4.equals(r0)     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            if (r4 == 0) goto L_0x0056
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            if (r4 >= r6) goto L_0x0056
            java.lang.String r4 = "X-HTTP-Method-Override"
            r5.setRequestProperty(r4, r0)     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            java.lang.String r0 = "POST"
        L_0x0052:
            r5.setRequestMethod(r0)     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            goto L_0x005b
        L_0x0056:
            java.lang.String r0 = r10.mo56375a()     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            goto L_0x0052
        L_0x005b:
            r0 = 1
            r5.setDoInput(r0)     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            r5.setUseCaches(r3)     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            r5.setAllowUserInteraction(r3)     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            long r6 = r10.mo56377c()     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            int r4 = (int) r6     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            r5.setConnectTimeout(r4)     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            java.util.List r4 = r10.mo56382g()     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            m2397a(r5, r4)     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            java.lang.String r4 = r10.mo56376b()     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            if (r4 == 0) goto L_0x00c8
            r5.setDoOutput(r0)     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            java.lang.String r0 = "Content-Type"
            java.lang.String r4 = r10.mo56378d()     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            r5.setRequestProperty(r0, r4)     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            boolean r0 = r10.mo56379e()     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            java.lang.String r4 = "UTF-8"
            if (r0 == 0) goto L_0x00b4
            java.lang.String r0 = "Content-Encoding"
            java.lang.String r6 = "gzip"
            r5.setRequestProperty(r0, r6)     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            java.io.OutputStream r0 = r5.getOutputStream()     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            java.util.zip.GZIPOutputStream r6 = new java.util.zip.GZIPOutputStream     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            r6.<init>(r0)     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            java.io.OutputStreamWriter r7 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            r7.<init>(r6, r4)     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            java.lang.String r4 = r10.mo56376b()     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            r7.write(r4)     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            r7.close()     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            r6.close()     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
        L_0x00b0:
            r0.close()     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            goto L_0x00c8
        L_0x00b4:
            java.io.OutputStream r0 = r5.getOutputStream()     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            java.io.OutputStreamWriter r6 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            r6.<init>(r0, r4)     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            java.lang.String r4 = r10.mo56376b()     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            r6.write(r4)     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            r6.close()     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            goto L_0x00b0
        L_0x00c8:
            com.salesforce.marketingcloud.c.g$a r0 = com.salesforce.marketingcloud.p021c.C3953g.m2437g()     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            int r4 = r5.getResponseCode()     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            com.salesforce.marketingcloud.c.g$a r0 = r0.mo56368a((int) r4)     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            java.lang.String r4 = r5.getResponseMessage()     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            com.salesforce.marketingcloud.c.g$a r0 = r0.mo56374b((java.lang.String) r4)     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            java.util.Map r4 = r5.getHeaderFields()     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            com.salesforce.marketingcloud.c.g$a r0 = r0.mo56371a((java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r4)     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            java.io.InputStream r4 = r5.getInputStream()     // Catch:{ IOException -> 0x00f0 }
            java.lang.String r4 = m2396a((java.io.InputStream) r4)     // Catch:{ IOException -> 0x00f0 }
            r0.mo56370a((java.lang.String) r4)     // Catch:{ IOException -> 0x00f0 }
            goto L_0x00fb
        L_0x00f0:
            java.io.InputStream r4 = r5.getErrorStream()     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            java.lang.String r4 = m2396a((java.io.InputStream) r4)     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            r0.mo56370a((java.lang.String) r4)     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
        L_0x00fb:
            com.salesforce.marketingcloud.c.g$a r0 = r0.mo56369a((long) r1)     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            com.salesforce.marketingcloud.c.g$a r0 = r0.mo56373b((long) r1)     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            com.salesforce.marketingcloud.c.g r0 = r0.mo56372a()     // Catch:{ Exception -> 0x0113, all -> 0x0111 }
            if (r5 == 0) goto L_0x0141
            r5.disconnect()
            goto L_0x0141
        L_0x0111:
            r0 = move-exception
            goto L_0x0142
        L_0x0113:
            r0 = move-exception
            r4 = r5
            goto L_0x011a
        L_0x0116:
            r0 = move-exception
            r5 = r4
            goto L_0x0142
        L_0x0119:
            r0 = move-exception
        L_0x011a:
            java.lang.String r1 = "Unable to complete request: "
            java.lang.String r2 = f2542f     // Catch:{ all -> 0x0116 }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0116 }
            com.salesforce.marketingcloud.C4039h.m2830e(r2, r0, r1, r3)     // Catch:{ all -> 0x0116 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0116 }
            r2.<init>()     // Catch:{ all -> 0x0116 }
            r2.append(r1)     // Catch:{ all -> 0x0116 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0116 }
            r2.append(r0)     // Catch:{ all -> 0x0116 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0116 }
            r1 = -100
            com.salesforce.marketingcloud.c.g r0 = com.salesforce.marketingcloud.p021c.C3953g.m2436a(r0, r1)     // Catch:{ all -> 0x0116 }
            if (r4 == 0) goto L_0x0141
            r4.disconnect()
        L_0x0141:
            return r0
        L_0x0142:
            if (r5 == 0) goto L_0x0147
            r5.disconnect()
        L_0x0147:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.p021c.C3946e.mo56411l():com.salesforce.marketingcloud.c.g");
    }
}
