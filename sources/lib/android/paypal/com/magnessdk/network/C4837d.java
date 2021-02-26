package lib.android.paypal.com.magnessdk.network;

import android.net.Uri;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import lib.android.paypal.com.magnessdk.network.httpclient.MagnesNetworking;

/* renamed from: lib.android.paypal.com.magnessdk.network.d */
class C4837d implements MagnesNetworking {

    /* renamed from: a */
    private final C4846k f5760a = m4724a();

    /* renamed from: b */
    private byte[] f5761b;

    /* renamed from: c */
    private String f5762c = null;

    /* renamed from: d */
    private Uri f5763d;

    /* renamed from: e */
    private Map<String, String> f5764e;

    /* renamed from: a */
    private C4846k m4724a() {
        return C4846k.m4750a();
    }

    /* renamed from: b */
    private HostnameVerifier m4725b() {
        return new HostnameVerifier() {
            public boolean verify(String str, SSLSession sSLSession) {
                return true;
            }
        };
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int execute(byte[] r9) {
        /*
            r8 = this;
            r9 = -1
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x00b1, all -> 0x00ad }
            android.net.Uri r2 = r8.f5763d     // Catch:{ Exception -> 0x00b1, all -> 0x00ad }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00b1, all -> 0x00ad }
            r1.<init>(r2)     // Catch:{ Exception -> 0x00b1, all -> 0x00ad }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x00b1, all -> 0x00ad }
            java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch:{ Exception -> 0x00b1, all -> 0x00ad }
            java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch:{ Exception -> 0x00b1, all -> 0x00ad }
            javax.net.ssl.HttpsURLConnection r1 = (javax.net.ssl.HttpsURLConnection) r1     // Catch:{ Exception -> 0x00b1, all -> 0x00ad }
            r2 = 60000(0xea60, float:8.4078E-41)
            r1.setReadTimeout(r2)     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            r1.setConnectTimeout(r2)     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            java.lang.String r2 = "GET"
            r1.setRequestMethod(r2)     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            javax.net.ssl.HostnameVerifier r2 = r8.m4725b()     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            r1.setHostnameVerifier(r2)     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            java.util.Map<java.lang.String, java.lang.String> r2 = r8.f5764e     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            java.util.Set r2 = r2.entrySet()     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
        L_0x0038:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            if (r3 == 0) goto L_0x0058
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            java.lang.Object r4 = r3.getKey()     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            r1.setRequestProperty(r4, r3)     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            goto L_0x0038
        L_0x0058:
            int r2 = r1.getResponseCode()     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            java.lang.String r3 = "correlation-id"
            java.lang.String r3 = r1.getHeaderField(r3)     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            r8.f5762c = r3     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 0
            if (r2 != r3) goto L_0x008e
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            java.io.InputStream r5 = r1.getInputStream()     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            r3.<init>(r5)     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x008c }
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x008c }
            r6.<init>()     // Catch:{ Exception -> 0x008c }
        L_0x007b:
            int r7 = r3.read(r5)     // Catch:{ Exception -> 0x008c }
            if (r7 == r9) goto L_0x0085
            r6.write(r5, r4, r7)     // Catch:{ Exception -> 0x008c }
            goto L_0x007b
        L_0x0085:
            byte[] r4 = r6.toByteArray()     // Catch:{ Exception -> 0x008c }
            r8.f5761b = r4     // Catch:{ Exception -> 0x008c }
            goto L_0x0093
        L_0x008c:
            r2 = move-exception
            goto L_0x00b4
        L_0x008e:
            byte[] r3 = new byte[r4]     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            r8.f5761b = r3     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            r3 = r0
        L_0x0093:
            java.lang.Class r9 = r8.getClass()
            lib.android.paypal.com.magnessdk.C4825c.m4658a((java.lang.Class<?>) r9, (java.io.Closeable) r3)
            java.lang.Class r9 = r8.getClass()
            lib.android.paypal.com.magnessdk.C4825c.m4658a((java.lang.Class<?>) r9, (java.io.Closeable) r0)
            if (r1 == 0) goto L_0x00a6
            r1.disconnect()
        L_0x00a6:
            return r2
        L_0x00a7:
            r9 = move-exception
            r3 = r0
            goto L_0x00d1
        L_0x00aa:
            r2 = move-exception
            r3 = r0
            goto L_0x00b4
        L_0x00ad:
            r9 = move-exception
            r1 = r0
            r3 = r1
            goto L_0x00d1
        L_0x00b1:
            r2 = move-exception
            r1 = r0
            r3 = r1
        L_0x00b4:
            java.lang.Class r4 = r8.getClass()     // Catch:{ all -> 0x00d0 }
            r5 = 3
            lib.android.paypal.com.magnessdk.p059b.C4823a.m4654a((java.lang.Class<?>) r4, (int) r5, (java.lang.Throwable) r2)     // Catch:{ all -> 0x00d0 }
            java.lang.Class r2 = r8.getClass()
            lib.android.paypal.com.magnessdk.C4825c.m4658a((java.lang.Class<?>) r2, (java.io.Closeable) r3)
            java.lang.Class r2 = r8.getClass()
            lib.android.paypal.com.magnessdk.C4825c.m4658a((java.lang.Class<?>) r2, (java.io.Closeable) r0)
            if (r1 == 0) goto L_0x00cf
            r1.disconnect()
        L_0x00cf:
            return r9
        L_0x00d0:
            r9 = move-exception
        L_0x00d1:
            java.lang.Class r2 = r8.getClass()
            lib.android.paypal.com.magnessdk.C4825c.m4658a((java.lang.Class<?>) r2, (java.io.Closeable) r3)
            java.lang.Class r2 = r8.getClass()
            lib.android.paypal.com.magnessdk.C4825c.m4658a((java.lang.Class<?>) r2, (java.io.Closeable) r0)
            if (r1 == 0) goto L_0x00e4
            r1.disconnect()
        L_0x00e4:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: lib.android.paypal.com.magnessdk.network.C4837d.execute(byte[]):int");
    }

    public String getPayPalDebugId() {
        return this.f5762c;
    }

    public byte[] getResponseContent() {
        return this.f5761b;
    }

    public void setHeader(Map<String, String> map) {
        this.f5764e = map;
    }

    public void setUri(Uri uri) {
        this.f5763d = uri;
    }
}
