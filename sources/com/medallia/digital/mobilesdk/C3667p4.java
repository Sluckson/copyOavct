package com.medallia.digital.mobilesdk;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.medallia.digital.mobilesdk.C3474d0;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.p4 */
class C3667p4 {

    /* renamed from: e */
    private static final int f1615e = 10;

    /* renamed from: f */
    private static final int f1616f = 2;

    /* renamed from: g */
    private static final int f1617g = 5000;

    /* renamed from: h */
    private static final int f1618h = 3;

    /* renamed from: i */
    private static final long f1619i = 3600000;

    /* renamed from: a */
    private int f1620a = 5000;

    /* renamed from: b */
    private int f1621b = 3;

    /* renamed from: c */
    private long f1622c = 3600000;

    /* renamed from: d */
    private ExecutorService f1623d;

    /* renamed from: com.medallia.digital.mobilesdk.p4$a */
    protected interface C3668a {
        /* renamed from: a */
        void mo55240a();

        /* renamed from: a */
        void mo55241a(C3588j4 j4Var);

        /* renamed from: a */
        void mo55242a(C3609l4 l4Var);
    }

    /* renamed from: com.medallia.digital.mobilesdk.p4$b */
    protected enum C3669b {
        String,
        BYTES
    }

    protected C3667p4(int i, int i2) {
        this.f1621b = i;
        this.f1620a = i2;
        this.f1623d = mo55702c();
    }

    /* renamed from: a */
    private void m1421a(C3669b bVar, C3474d0.C3478d dVar, String str, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, JSONObject jSONObject, @NonNull C3668a aVar) {
        aVar.mo55240a();
        C3669b bVar2 = bVar;
        C3474d0.C3478d dVar2 = dVar;
        new C3596k4(this.f1623d, bVar2, dVar2, mo55694a(str, hashMap2), hashMap, jSONObject, this.f1621b, this.f1620a, aVar, this.f1622c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo55693a() {
        return this.f1621b;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public String mo55694a(String str, HashMap<String, String> hashMap) {
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (hashMap != null && !hashMap.isEmpty()) {
            sb.append("?");
            int i = 0;
            for (Map.Entry next : hashMap.entrySet()) {
                if (!(next.getKey() == null || next.getValue() == null)) {
                    sb.append((String) next.getKey());
                    sb.append("=");
                    sb.append((String) next.getValue());
                    if (i < hashMap.size() - 1) {
                        sb.append("&");
                    }
                }
                i++;
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55695a(int i, int i2, long j) {
        if (((long) i2) > 1000) {
            this.f1620a = i2;
        }
        if (i >= 0) {
            this.f1621b = i;
        }
        this.f1622c = j;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007e  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo55696a(java.lang.String r7, java.lang.String r8, java.util.HashMap<java.lang.String, java.lang.String> r9, java.util.HashMap<java.lang.String, java.lang.String> r10, org.json.JSONObject r11, com.medallia.digital.mobilesdk.C3667p4.C3668a r12) {
        /*
            r6 = this;
            java.lang.String r0 = r7.toLowerCase()
            int r1 = r0.hashCode()
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = -1335458389(0xffffffffb06685ab, float:-8.3863466E-10)
            if (r1 == r5) goto L_0x003e
            r5 = 102230(0x18f56, float:1.43255E-40)
            if (r1 == r5) goto L_0x0034
            r5 = 111375(0x1b30f, float:1.5607E-40)
            if (r1 == r5) goto L_0x002a
            r5 = 3446944(0x3498a0, float:4.830197E-39)
            if (r1 == r5) goto L_0x0020
            goto L_0x0048
        L_0x0020:
            java.lang.String r1 = "post"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0048
            r0 = 1
            goto L_0x0049
        L_0x002a:
            java.lang.String r1 = "put"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0048
            r0 = 0
            goto L_0x0049
        L_0x0034:
            java.lang.String r1 = "get"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0048
            r0 = 3
            goto L_0x0049
        L_0x003e:
            java.lang.String r1 = "delete"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0048
            r0 = 2
            goto L_0x0049
        L_0x0048:
            r0 = -1
        L_0x0049:
            if (r0 == 0) goto L_0x007e
            if (r0 == r4) goto L_0x0074
            if (r0 == r3) goto L_0x006a
            if (r0 == r2) goto L_0x0066
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Request type is undefined: "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            com.medallia.digital.mobilesdk.C3490e3.m663c(r7)
            goto L_0x0087
        L_0x0066:
            r6.mo55698a(r8, r9, r10, r12)
            goto L_0x0087
        L_0x006a:
            r0 = r6
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r0.mo55699a(r1, r2, r3, r4, r5)
            goto L_0x0087
        L_0x0074:
            r0 = r6
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r0.mo55701b(r1, r2, r3, r4, r5)
            goto L_0x0087
        L_0x007e:
            r0 = r6
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r0.mo55703c(r1, r2, r3, r4, r5)
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.medallia.digital.mobilesdk.C3667p4.mo55696a(java.lang.String, java.lang.String, java.util.HashMap, java.util.HashMap, org.json.JSONObject, com.medallia.digital.mobilesdk.p4$a):void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55697a(String str, HashMap<String, String> hashMap, C3668a aVar) {
        m1421a(C3669b.BYTES, C3474d0.C3478d.GET, str, hashMap, (HashMap<String, String>) null, (JSONObject) null, aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55698a(String str, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, C3668a aVar) {
        m1421a(C3669b.String, C3474d0.C3478d.GET, str, hashMap2, hashMap, (JSONObject) null, aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55699a(String str, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, JSONObject jSONObject, C3668a aVar) {
        m1421a(C3669b.String, C3474d0.C3478d.DELETE, str, hashMap2, hashMap, jSONObject, aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public long mo55700b() {
        return this.f1622c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo55701b(String str, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, JSONObject jSONObject, C3668a aVar) {
        m1421a(C3669b.String, C3474d0.C3478d.POST, str, hashMap2, hashMap, jSONObject, aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public ExecutorService mo55702c() {
        return Executors.newFixedThreadPool(Math.min(10, Math.max(2, Build.VERSION.SDK_INT >= 17 ? Runtime.getRuntime().availableProcessors() : 2)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo55703c(String str, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, JSONObject jSONObject, C3668a aVar) {
        m1421a(C3669b.String, C3474d0.C3478d.PUT, str, hashMap2, hashMap, jSONObject, aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo55704d() {
        return this.f1620a;
    }
}
