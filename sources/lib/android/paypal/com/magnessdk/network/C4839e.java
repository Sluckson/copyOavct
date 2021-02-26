package lib.android.paypal.com.magnessdk.network;

import android.net.Uri;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import lib.android.paypal.com.magnessdk.network.httpclient.MagnesNetworking;

/* renamed from: lib.android.paypal.com.magnessdk.network.e */
class C4839e implements MagnesNetworking {

    /* renamed from: a */
    private final C4846k f5766a = m4726a();

    /* renamed from: b */
    private byte[] f5767b;

    /* renamed from: c */
    private String f5768c = null;

    /* renamed from: d */
    private Uri f5769d;

    /* renamed from: e */
    private Map<String, String> f5770e;

    /* renamed from: a */
    private C4846k m4726a() {
        return C4846k.m4750a();
    }

    /* renamed from: b */
    private HostnameVerifier m4727b() {
        return new HostnameVerifier() {
            public boolean verify(String str, SSLSession sSLSession) {
                return true;
            }
        };
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int execute(byte[] r9) {
        /*
            r8 = this;
            r0 = -1
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x00ce, all -> 0x00ca }
            android.net.Uri r3 = r8.f5769d     // Catch:{ Exception -> 0x00ce, all -> 0x00ca }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00ce, all -> 0x00ca }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00ce, all -> 0x00ca }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ Exception -> 0x00ce, all -> 0x00ca }
            java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ Exception -> 0x00ce, all -> 0x00ca }
            java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ Exception -> 0x00ce, all -> 0x00ca }
            javax.net.ssl.HttpsURLConnection r2 = (javax.net.ssl.HttpsURLConnection) r2     // Catch:{ Exception -> 0x00ce, all -> 0x00ca }
            r3 = 60000(0xea60, float:8.4078E-41)
            r2.setReadTimeout(r3)     // Catch:{ Exception -> 0x00c7, all -> 0x00c4 }
            r2.setConnectTimeout(r3)     // Catch:{ Exception -> 0x00c7, all -> 0x00c4 }
            javax.net.ssl.HostnameVerifier r3 = r8.m4727b()     // Catch:{ Exception -> 0x00c7, all -> 0x00c4 }
            r2.setHostnameVerifier(r3)     // Catch:{ Exception -> 0x00c7, all -> 0x00c4 }
            java.lang.String r3 = "POST"
            r2.setRequestMethod(r3)     // Catch:{ Exception -> 0x00c7, all -> 0x00c4 }
            lib.android.paypal.com.magnessdk.network.k r3 = r8.f5766a     // Catch:{ Exception -> 0x00c7, all -> 0x00c4 }
            r2.setSSLSocketFactory(r3)     // Catch:{ Exception -> 0x00c7, all -> 0x00c4 }
            r3 = 1
            r2.setDoOutput(r3)     // Catch:{ Exception -> 0x00c7, all -> 0x00c4 }
            int r3 = r9.length     // Catch:{ Exception -> 0x00c7, all -> 0x00c4 }
            r2.setFixedLengthStreamingMode(r3)     // Catch:{ Exception -> 0x00c7, all -> 0x00c4 }
            java.util.Map<java.lang.String, java.lang.String> r3 = r8.f5770e     // Catch:{ Exception -> 0x00c7, all -> 0x00c4 }
            java.util.Set r3 = r3.entrySet()     // Catch:{ Exception -> 0x00c7, all -> 0x00c4 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x00c7, all -> 0x00c4 }
        L_0x0045:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x00c7, all -> 0x00c4 }
            if (r4 == 0) goto L_0x0065
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x00c7, all -> 0x00c4 }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ Exception -> 0x00c7, all -> 0x00c4 }
            java.lang.Object r5 = r4.getKey()     // Catch:{ Exception -> 0x00c7, all -> 0x00c4 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00c7, all -> 0x00c4 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ Exception -> 0x00c7, all -> 0x00c4 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00c7, all -> 0x00c4 }
            r2.setRequestProperty(r5, r4)     // Catch:{ Exception -> 0x00c7, all -> 0x00c4 }
            goto L_0x0045
        L_0x0065:
            java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ Exception -> 0x00c7, all -> 0x00c4 }
            r3.write(r9)     // Catch:{ Exception -> 0x00c2 }
            r3.flush()     // Catch:{ Exception -> 0x00c2 }
            int r9 = r2.getResponseCode()     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r4 = "correlation-id"
            java.lang.String r4 = r2.getHeaderField(r4)     // Catch:{ Exception -> 0x00c2 }
            r8.f5768c = r4     // Catch:{ Exception -> 0x00c2 }
            r4 = 200(0xc8, float:2.8E-43)
            r5 = 0
            if (r9 != r4) goto L_0x00aa
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00c2 }
            java.io.InputStream r6 = r2.getInputStream()     // Catch:{ Exception -> 0x00c2 }
            r4.<init>(r6)     // Catch:{ Exception -> 0x00c2 }
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            r6.<init>()     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
        L_0x0092:
            int r7 = r4.read(r1)     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            if (r7 == r0) goto L_0x009c
            r6.write(r1, r5, r7)     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            goto L_0x0092
        L_0x009c:
            byte[] r1 = r6.toByteArray()     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            r8.f5767b = r1     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            r1 = r4
            goto L_0x00ae
        L_0x00a4:
            r9 = move-exception
            r1 = r4
            goto L_0x00ee
        L_0x00a7:
            r9 = move-exception
            r1 = r4
            goto L_0x00d1
        L_0x00aa:
            byte[] r4 = new byte[r5]     // Catch:{ Exception -> 0x00c2 }
            r8.f5767b = r4     // Catch:{ Exception -> 0x00c2 }
        L_0x00ae:
            java.lang.Class r0 = r8.getClass()
            lib.android.paypal.com.magnessdk.C4825c.m4658a((java.lang.Class<?>) r0, (java.io.Closeable) r1)
            java.lang.Class r0 = r8.getClass()
            lib.android.paypal.com.magnessdk.C4825c.m4658a((java.lang.Class<?>) r0, (java.io.Closeable) r3)
            if (r2 == 0) goto L_0x00c1
            r2.disconnect()
        L_0x00c1:
            return r9
        L_0x00c2:
            r9 = move-exception
            goto L_0x00d1
        L_0x00c4:
            r9 = move-exception
            r3 = r1
            goto L_0x00ee
        L_0x00c7:
            r9 = move-exception
            r3 = r1
            goto L_0x00d1
        L_0x00ca:
            r9 = move-exception
            r2 = r1
            r3 = r2
            goto L_0x00ee
        L_0x00ce:
            r9 = move-exception
            r2 = r1
            r3 = r2
        L_0x00d1:
            java.lang.Class r4 = r8.getClass()     // Catch:{ all -> 0x00ed }
            r5 = 3
            lib.android.paypal.com.magnessdk.p059b.C4823a.m4654a((java.lang.Class<?>) r4, (int) r5, (java.lang.Throwable) r9)     // Catch:{ all -> 0x00ed }
            java.lang.Class r9 = r8.getClass()
            lib.android.paypal.com.magnessdk.C4825c.m4658a((java.lang.Class<?>) r9, (java.io.Closeable) r1)
            java.lang.Class r9 = r8.getClass()
            lib.android.paypal.com.magnessdk.C4825c.m4658a((java.lang.Class<?>) r9, (java.io.Closeable) r3)
            if (r2 == 0) goto L_0x00ec
            r2.disconnect()
        L_0x00ec:
            return r0
        L_0x00ed:
            r9 = move-exception
        L_0x00ee:
            java.lang.Class r0 = r8.getClass()
            lib.android.paypal.com.magnessdk.C4825c.m4658a((java.lang.Class<?>) r0, (java.io.Closeable) r1)
            java.lang.Class r0 = r8.getClass()
            lib.android.paypal.com.magnessdk.C4825c.m4658a((java.lang.Class<?>) r0, (java.io.Closeable) r3)
            if (r2 == 0) goto L_0x0101
            r2.disconnect()
        L_0x0101:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: lib.android.paypal.com.magnessdk.network.C4839e.execute(byte[]):int");
    }

    public String getPayPalDebugId() {
        return this.f5768c;
    }

    public byte[] getResponseContent() {
        return this.f5767b;
    }

    public void setHeader(Map<String, String> map) {
        this.f5770e = map;
    }

    public void setUri(Uri uri) {
        this.f5769d = uri;
    }
}
