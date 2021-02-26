package com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p046d;

import android.annotation.SuppressLint;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.wowza.gocoder.sdk.support.wmstransport.p041a.C4307c;
import com.wowza.gocoder.sdk.support.wmstransport.p041a.C4308d;
import com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p044b.C4317c;

/* renamed from: com.wowza.gocoder.sdk.support.wmstransport.wms.a.d.f */
/* compiled from: GoCoderSDK */
public class C4324f extends C4323e implements C4320b {

    /* renamed from: a */
    protected int f4599a = 0;

    /* renamed from: b */
    protected int f4600b = 0;

    /* renamed from: c */
    protected int f4601c = 0;

    /* renamed from: d */
    protected int f4602d = 0;

    /* renamed from: i */
    protected int f4603i = 0;

    /* renamed from: j */
    protected int f4604j = 0;

    /* renamed from: k */
    protected double f4605k = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;

    public C4324f() {
        this.f4596f = 9;
    }

    /* renamed from: a */
    public void mo59346a(C4324f fVar) {
        super.mo59343a((C4323e) fVar);
        this.f4599a = fVar.f4599a;
        this.f4600b = fVar.f4600b;
        this.f4601c = fVar.f4601c;
        this.f4602d = fVar.f4602d;
        this.f4603i = fVar.f4603i;
        this.f4604j = fVar.f4604j;
        this.f4605k = fVar.f4605k;
    }

    /* renamed from: b */
    public boolean mo59348b(C4324f fVar) {
        return super.mo59344b((C4323e) fVar) && this.f4599a == fVar.f4599a && this.f4600b == fVar.f4600b && this.f4601c == fVar.f4601c && this.f4602d == fVar.f4602d && this.f4603i == fVar.f4603i && this.f4604j == fVar.f4604j && this.f4605k == fVar.f4605k;
    }

    public int hashCode() {
        int hashCode = (((((((((((super.hashCode() * 31) + this.f4599a) * 31) + this.f4600b) * 31) + this.f4601c) * 31) + this.f4602d) * 31) + this.f4603i) * 31) + this.f4604j;
        long doubleToLongBits = Double.doubleToLongBits(this.f4605k);
        return (((hashCode * 31) + ((int) (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits & -1));
    }

    /* renamed from: o */
    public int mo59355o() {
        return this.f4599a;
    }

    /* renamed from: c */
    public void mo59349c(int i) {
        this.f4599a = i;
    }

    /* renamed from: p */
    public int mo59356p() {
        return this.f4600b;
    }

    /* renamed from: d */
    public void mo59350d(int i) {
        this.f4600b = i;
    }

    /* renamed from: q */
    public int mo59357q() {
        return this.f4603i;
    }

    /* renamed from: e */
    public void mo59351e(int i) {
        this.f4603i = i;
    }

    /* renamed from: r */
    public int mo59358r() {
        return this.f4604j;
    }

    /* renamed from: f */
    public void mo59352f(int i) {
        this.f4604j = i;
    }

    /* renamed from: n */
    public int mo59327n() {
        return super.mo59327n() + 24 + 8;
    }

    /* renamed from: a */
    public int mo59317a(byte[] bArr, int i) {
        int a = super.mo59317a(bArr, i);
        C4307c.m4271a(this.f4599a, bArr, a, 4);
        int i2 = a + 4;
        C4307c.m4271a(this.f4600b, bArr, i2, 4);
        int i3 = i2 + 4;
        C4307c.m4271a(this.f4601c, bArr, i3, 4);
        int i4 = i3 + 4;
        C4307c.m4271a(this.f4602d, bArr, i4, 4);
        int i5 = i4 + 4;
        C4307c.m4271a(this.f4603i, bArr, i5, 4);
        int i6 = i5 + 4;
        C4307c.m4271a(this.f4604j, bArr, i6, 4);
        int i7 = i6 + 4;
        C4307c.m4273a(Double.doubleToLongBits(this.f4605k), bArr, i7, 8);
        return i7 + 8;
    }

    /* renamed from: s */
    public byte[] mo59359s() {
        byte[] bArr = new byte[mo59327n()];
        mo59317a(bArr, 0);
        return bArr;
    }

    /* renamed from: a */
    public int mo59318a(byte[] bArr, int i, int i2) {
        int i3;
        int a = super.mo59318a(bArr, i, i2);
        this.f4599a = C4307c.m4292d(bArr, a, 4);
        int i4 = a + 4;
        this.f4600b = C4307c.m4292d(bArr, i4, 4);
        int i5 = i4 + 4;
        this.f4601c = C4307c.m4292d(bArr, i5, 4);
        int i6 = i5 + 4;
        this.f4602d = C4307c.m4292d(bArr, i6, 4);
        int i7 = i6 + 4;
        this.f4603i = C4307c.m4292d(bArr, i7, 4);
        int i8 = i7 + 4;
        this.f4604j = C4307c.m4292d(bArr, i8, 4);
        int i9 = i8 + 4;
        if (this.f4595e <= 1 || (i3 = i9 + 8) > i2) {
            return i9;
        }
        this.f4605k = Double.longBitsToDouble(C4307c.m4289c(bArr, i9, 8));
        return i3;
    }

    /* renamed from: c */
    public int mo59306c() {
        return this.f4601c;
    }

    /* renamed from: g */
    public void mo59353g(int i) {
        this.f4601c = i;
    }

    /* renamed from: d */
    public int mo59307d() {
        return this.f4602d;
    }

    /* renamed from: h */
    public void mo59354h(int i) {
        this.f4602d = i;
    }

    /* renamed from: g */
    public double mo59310g() {
        return this.f4605k;
    }

    /* renamed from: a */
    public void mo59345a(double d) {
        this.f4605k = d;
    }

    @SuppressLint({"DefaultLocale"})
    public String toString() {
        String str;
        String str2;
        Object[] objArr = new Object[8];
        objArr[0] = C4308d.m4304c(this.f4597g);
        if (this.f4597g == 7) {
            str = C4317c.m4405d(this.f4603i);
        } else {
            str = this.f4603i + "";
        }
        objArr[1] = str;
        if (this.f4597g == 7) {
            str2 = C4317c.m4388a(this.f4604j);
        } else {
            str2 = this.f4604j + "";
        }
        objArr[2] = str2;
        objArr[3] = Integer.valueOf(this.f4599a);
        objArr[4] = Integer.valueOf(this.f4600b);
        objArr[5] = Integer.valueOf(this.f4601c);
        objArr[6] = Integer.valueOf(this.f4602d);
        objArr[7] = Double.valueOf(this.f4605k);
        return String.format("{MediaCodecInfoVideo: codec:%s, profile:%s, level:%s, frameSize:%dx%d, displaySize:%dx%d, frameRate:%f}", objArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo59347a(java.lang.String r7) {
        /*
            r6 = this;
            java.util.Locale r0 = java.util.Locale.ENGLISH
            java.lang.String r7 = r7.toLowerCase(r0)
            java.lang.String r0 = "."
            java.lang.String r0 = java.util.regex.Pattern.quote(r0)
            java.lang.String[] r7 = r7.split(r0)
            int r0 = r7.length
            r1 = 0
            r2 = 0
            if (r0 <= 0) goto L_0x0018
            r0 = r7[r1]
            goto L_0x0019
        L_0x0018:
            r0 = r2
        L_0x0019:
            int r3 = r7.length
            r4 = 1
            if (r3 <= r4) goto L_0x001f
            r2 = r7[r4]
        L_0x001f:
            int r3 = r7.length
            r4 = 2
            r5 = -1
            if (r3 <= r4) goto L_0x002b
            r7 = r7[r4]     // Catch:{ Exception -> 0x002b }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x002b }
            goto L_0x002c
        L_0x002b:
            r7 = -1
        L_0x002c:
            if (r7 < 0) goto L_0x0030
            r6.f4604j = r7
        L_0x0030:
            if (r0 == 0) goto L_0x00db
            java.lang.String r7 = "avc1"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x00cf
            r7 = 7
            r6.f4597g = r7
            if (r2 == 0) goto L_0x00db
            java.lang.String r7 = "66"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x004d
            r7 = 66
            r6.f4603i = r7
            goto L_0x00db
        L_0x004d:
            java.lang.String r7 = "77"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x005b
            r7 = 77
            r6.f4603i = r7
            goto L_0x00db
        L_0x005b:
            java.lang.String r7 = "88"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x0069
            r7 = 88
            r6.f4603i = r7
            goto L_0x00db
        L_0x0069:
            java.lang.String r7 = "100"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x0076
            r7 = 100
            r6.f4603i = r7
            goto L_0x00db
        L_0x0076:
            java.lang.String r7 = "110"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x0083
            r7 = 110(0x6e, float:1.54E-43)
            r6.f4603i = r7
            goto L_0x00db
        L_0x0083:
            java.lang.String r7 = "122"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x0090
            r7 = 122(0x7a, float:1.71E-43)
            r6.f4603i = r7
            goto L_0x00db
        L_0x0090:
            java.lang.String r7 = "244"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x009d
            r7 = 244(0xf4, float:3.42E-43)
            r6.f4603i = r7
            goto L_0x00db
        L_0x009d:
            java.lang.String r7 = "44"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x00aa
            r7 = 44
            r6.f4603i = r7
            goto L_0x00db
        L_0x00aa:
            int r7 = r2.length()
            r0 = 6
            if (r7 < r0) goto L_0x00db
            r7 = 16
            java.lang.String r1 = r2.substring(r1, r4)     // Catch:{ Exception -> 0x00bc }
            int r1 = java.lang.Integer.parseInt(r1, r7)     // Catch:{ Exception -> 0x00bc }
            goto L_0x00bd
        L_0x00bc:
            r1 = -1
        L_0x00bd:
            r3 = 4
            java.lang.String r0 = r2.substring(r3, r0)     // Catch:{ Exception -> 0x00c6 }
            int r5 = java.lang.Integer.parseInt(r0, r7)     // Catch:{ Exception -> 0x00c6 }
        L_0x00c6:
            if (r1 <= 0) goto L_0x00ca
            r6.f4603i = r1
        L_0x00ca:
            if (r5 <= 0) goto L_0x00db
            r6.f4604j = r5
            goto L_0x00db
        L_0x00cf:
            java.lang.String r7 = "hvc1"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x00db
            r7 = 12
            r6.f4597g = r7
        L_0x00db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p046d.C4324f.mo59347a(java.lang.String):void");
    }

    /* renamed from: a_ */
    public String mo59331a_() {
        switch (mo59325l()) {
            case 2:
                return "spark";
            case 3:
                return "screen";
            case 4:
                return "vp6";
            case 5:
                return "vp6a";
            case 6:
                return "screen2";
            case 7:
                int r = mo59358r();
                int q = mo59357q();
                if (r <= 0 || q <= 0) {
                    return C4317c.f4533b;
                }
                return "avc1." + q + "." + r;
            case 8:
                return "vp8";
            case 9:
                return "h263";
            case 10:
                return "mpeg4";
            case 11:
                return "mpeg2";
            default:
                return "unknown";
        }
    }

    /* renamed from: a */
    public int mo59304a() {
        return this.f4599a;
    }

    /* renamed from: b */
    public int mo59305b() {
        return this.f4600b;
    }

    /* renamed from: e */
    public int mo59308e() {
        return this.f4603i;
    }

    /* renamed from: f */
    public int mo59309f() {
        return this.f4604j;
    }

    /* renamed from: h */
    public int mo59311h() {
        return this.f4597g;
    }
}
