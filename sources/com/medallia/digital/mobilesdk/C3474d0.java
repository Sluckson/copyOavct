package com.medallia.digital.mobilesdk;

import androidx.annotation.VisibleForTesting;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.medallia.digital.mobilesdk.C3667p4;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.d0 */
abstract class C3474d0<T> implements Runnable {

    /* renamed from: h */
    private static final String f979h = "Content-Type";

    /* renamed from: i */
    private static final int f980i = 600;

    /* renamed from: j */
    private static final String f981j = "application/json";

    /* renamed from: k */
    static final int f982k = -44;

    /* renamed from: l */
    private static final String f983l = "BaseRequest: Error parsing server response ";

    /* renamed from: m */
    static final int f984m = -45;

    /* renamed from: n */
    private static final String f985n = "BaseRequest: Error no Connection Available";

    /* renamed from: o */
    static final int f986o = -46;

    /* renamed from: p */
    private static final String f987p = "BaseRequest: Error timeout";

    /* renamed from: q */
    private static final String f988q = "https";

    /* renamed from: a */
    private final C3478d f989a;

    /* renamed from: b */
    private final String f990b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C3667p4.C3668a f991c;

    /* renamed from: d */
    private Map<String, String> f992d;

    /* renamed from: e */
    private JSONObject f993e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f994f;

    /* renamed from: g */
    private final int f995g;

    /* renamed from: com.medallia.digital.mobilesdk.d0$a */
    class C3475a extends C3666p3 {

        /* renamed from: a */
        final /* synthetic */ String f996a;

        C3475a(String str) {
            this.f996a = str;
        }

        /* renamed from: a */
        public void mo55177a() {
            StringBuilder sb = new StringBuilder();
            sb.append("Message: ");
            String str = this.f996a;
            if (str == null) {
                str = "Unknown network error";
            }
            sb.append(str);
            sb.append(" StatusCode ");
            int i = 600;
            sb.append(this.f996a != null ? C3474d0.this.f994f : 600);
            C3490e3.m663c(sb.toString());
            if (C3474d0.this.f991c != null) {
                C3667p4.C3668a b = C3474d0.this.f991c;
                if (this.f996a != null) {
                    i = C3474d0.this.f994f;
                }
                b.mo55241a(new C3588j4(i));
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.d0$b */
    static /* synthetic */ class C3476b {

        /* renamed from: a */
        static final /* synthetic */ int[] f998a = new int[C3477c.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.medallia.digital.mobilesdk.d0$c[] r0 = com.medallia.digital.mobilesdk.C3474d0.C3477c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f998a = r0
                int[] r0 = f998a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.medallia.digital.mobilesdk.d0$c r1 = com.medallia.digital.mobilesdk.C3474d0.C3477c.ContentType     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f998a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.medallia.digital.mobilesdk.d0$c r1 = com.medallia.digital.mobilesdk.C3474d0.C3477c.Accept     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.medallia.digital.mobilesdk.C3474d0.C3476b.<clinit>():void");
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.d0$c */
    private enum C3477c {
        ContentType,
        Accept;

        public String toString() {
            int i = C3476b.f998a[ordinal()];
            return i != 1 ? i != 2 ? "" : "Accept" : "Content-Type";
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.d0$d */
    enum C3478d {
        DEPRECATED_GET_OR_POST,
        GET,
        POST,
        PUT,
        DELETE,
        HEAD,
        OPTIONS,
        TRACE,
        PATCH
    }

    C3474d0(C3478d dVar, String str, HashMap<String, String> hashMap, JSONObject jSONObject, int i, C3667p4.C3668a aVar) {
        this.f989a = dVar;
        this.f990b = str;
        this.f991c = aVar;
        this.f993e = jSONObject;
        this.f992d = m608a(hashMap);
        this.f995g = i;
    }

    /* renamed from: a */
    private Map<String, String> m608a(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        hashMap.put(C3477c.Accept.toString(), "application/json");
        return hashMap;
    }

    /* renamed from: b */
    private String m610b(InputStream inputStream) {
        try {
            return C3802y5.m1953a(inputStream).toString("UTF-8");
        } catch (Exception unused) {
            mo55298a((int) f982k);
            return null;
        }
    }

    /* renamed from: f */
    private byte[] m611f() {
        try {
            if (this.f993e == null) {
                return null;
            }
            return this.f993e.toString().getBytes();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: g */
    private String m612g() {
        return "application/json";
    }

    /* renamed from: h */
    private Map<String, String> m613h() {
        Map<String, String> map = this.f992d;
        return map != null ? map : new HashMap();
    }

    /* renamed from: i */
    private C3478d m614i() {
        return this.f989a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract T mo55209a(InputStream inputStream);

    @VisibleForTesting
    /* renamed from: a */
    public HttpURLConnection mo55297a() {
        URL url = new URL(mo55302d());
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
        if (f988q.equals(url.getProtocol())) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new C3484d5());
        }
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setConnectTimeout(this.f995g);
        httpURLConnection.setReadTimeout(this.f995g);
        httpURLConnection.setRequestMethod(m614i().name());
        if (m613h() != null && m613h().size() > 0) {
            for (String next : m613h().keySet()) {
                httpURLConnection.setRequestProperty(next, m613h().get(next));
            }
        }
        if (m611f() != null && m611f().length > 0) {
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty("Content-Type", m612g());
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(m611f());
            outputStream.close();
        }
        httpURLConnection.connect();
        return httpURLConnection;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55298a(int i) {
        this.f994f = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo55210a(T t);

    /* renamed from: a */
    public void mo55299a(String str) {
        C3561h5.m954c().mo55465a().execute(new C3475a(str));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C3667p4.C3668a mo55300b() {
        return this.f991c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo55301c() {
        return this.f994f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo55302d() {
        return this.f990b;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: java.net.HttpURLConnection} */
    /* JADX WARNING: type inference failed for: r1v0, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048 A[SYNTHETIC, Splitter:B:15:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0067 A[SYNTHETIC, Splitter:B:28:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0085 A[SYNTHETIC, Splitter:B:41:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0099 A[SYNTHETIC, Splitter:B:48:0x0099] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.VisibleForTesting
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo55303e() {
        /*
            r5 = this;
            boolean r0 = com.medallia.digital.mobilesdk.C3802y5.m1954a()
            if (r0 == 0) goto L_0x00ab
            r0 = 0
            java.net.HttpURLConnection r1 = r5.mo55297a()     // Catch:{ SocketTimeoutException -> 0x0078, Exception -> 0x005c, all -> 0x0059 }
            int r2 = r1.getResponseCode()     // Catch:{ SocketTimeoutException -> 0x0079, Exception -> 0x0057 }
            r5.f994f = r2     // Catch:{ SocketTimeoutException -> 0x0079, Exception -> 0x0057 }
            int r2 = r5.f994f     // Catch:{ SocketTimeoutException -> 0x0079, Exception -> 0x0057 }
            r3 = 400(0x190, float:5.6E-43)
            if (r2 >= r3) goto L_0x003b
            java.io.InputStream r0 = r1.getInputStream()     // Catch:{ SocketTimeoutException -> 0x0079, Exception -> 0x0057 }
            java.lang.Object r2 = r5.mo55209a((java.io.InputStream) r0)     // Catch:{ SocketTimeoutException -> 0x0079, Exception -> 0x0057 }
            int r3 = r5.f994f     // Catch:{ SocketTimeoutException -> 0x0079, Exception -> 0x0057 }
            r4 = -44
            if (r3 != r4) goto L_0x0037
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x0079, Exception -> 0x0057 }
            r3.<init>()     // Catch:{ SocketTimeoutException -> 0x0079, Exception -> 0x0057 }
            java.lang.String r4 = "BaseRequest: Error parsing server response "
            r3.append(r4)     // Catch:{ SocketTimeoutException -> 0x0079, Exception -> 0x0057 }
            r3.append(r2)     // Catch:{ SocketTimeoutException -> 0x0079, Exception -> 0x0057 }
            java.lang.String r2 = r3.toString()     // Catch:{ SocketTimeoutException -> 0x0079, Exception -> 0x0057 }
            goto L_0x0043
        L_0x0037:
            r5.mo55210a(r2)     // Catch:{ SocketTimeoutException -> 0x0079, Exception -> 0x0057 }
            goto L_0x0046
        L_0x003b:
            java.io.InputStream r2 = r1.getErrorStream()     // Catch:{ SocketTimeoutException -> 0x0079, Exception -> 0x0057 }
            java.lang.String r2 = r5.m610b((java.io.InputStream) r2)     // Catch:{ SocketTimeoutException -> 0x0079, Exception -> 0x0057 }
        L_0x0043:
            r5.mo55299a((java.lang.String) r2)     // Catch:{ SocketTimeoutException -> 0x0079, Exception -> 0x0057 }
        L_0x0046:
            if (r0 == 0) goto L_0x0054
            r0.close()     // Catch:{ IOException -> 0x004c }
            goto L_0x0054
        L_0x004c:
            r0 = move-exception
            java.lang.String r0 = r0.toString()
            r5.mo55299a((java.lang.String) r0)
        L_0x0054:
            if (r1 == 0) goto L_0x00b5
            goto L_0x0093
        L_0x0057:
            r2 = move-exception
            goto L_0x005e
        L_0x0059:
            r2 = move-exception
            r1 = r0
            goto L_0x0097
        L_0x005c:
            r2 = move-exception
            r1 = r0
        L_0x005e:
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0076 }
            r5.mo55299a((java.lang.String) r2)     // Catch:{ all -> 0x0076 }
            if (r0 == 0) goto L_0x0073
            r0.close()     // Catch:{ IOException -> 0x006b }
            goto L_0x0073
        L_0x006b:
            r0 = move-exception
            java.lang.String r0 = r0.toString()
            r5.mo55299a((java.lang.String) r0)
        L_0x0073:
            if (r1 == 0) goto L_0x00b5
            goto L_0x0093
        L_0x0076:
            r2 = move-exception
            goto L_0x0097
        L_0x0078:
            r1 = r0
        L_0x0079:
            r2 = -46
            r5.mo55298a((int) r2)     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = "BaseRequest: Error timeout"
            r5.mo55299a((java.lang.String) r2)     // Catch:{ all -> 0x0076 }
            if (r0 == 0) goto L_0x0091
            r0.close()     // Catch:{ IOException -> 0x0089 }
            goto L_0x0091
        L_0x0089:
            r0 = move-exception
            java.lang.String r0 = r0.toString()
            r5.mo55299a((java.lang.String) r0)
        L_0x0091:
            if (r1 == 0) goto L_0x00b5
        L_0x0093:
            r1.disconnect()
            goto L_0x00b5
        L_0x0097:
            if (r0 == 0) goto L_0x00a5
            r0.close()     // Catch:{ IOException -> 0x009d }
            goto L_0x00a5
        L_0x009d:
            r0 = move-exception
            java.lang.String r0 = r0.toString()
            r5.mo55299a((java.lang.String) r0)
        L_0x00a5:
            if (r1 == 0) goto L_0x00aa
            r1.disconnect()
        L_0x00aa:
            throw r2
        L_0x00ab:
            r0 = -45
            r5.mo55298a((int) r0)
            java.lang.String r0 = "BaseRequest: Error no Connection Available"
            r5.mo55299a((java.lang.String) r0)
        L_0x00b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.medallia.digital.mobilesdk.C3474d0.mo55303e():void");
    }

    public void run() {
        mo55303e();
    }
}
