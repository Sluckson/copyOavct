package com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p046d;

import android.annotation.SuppressLint;
import com.wowza.gocoder.sdk.support.wmstransport.p041a.C4307c;
import com.wowza.gocoder.sdk.support.wmstransport.p041a.C4308d;
import com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p043a.C4314b;

/* renamed from: com.wowza.gocoder.sdk.support.wmstransport.wms.a.d.d */
/* compiled from: GoCoderSDK */
public class C4322d extends C4323e {

    /* renamed from: a */
    protected int f4591a = 0;

    /* renamed from: b */
    protected int f4592b = 0;

    /* renamed from: c */
    protected int f4593c = 0;

    /* renamed from: d */
    protected int f4594d = 0;

    public C4322d() {
        this.f4596f = 8;
    }

    /* renamed from: a */
    public boolean mo59330a(C4322d dVar) {
        return super.mo59344b((C4323e) dVar) && this.f4591a == dVar.f4591a && this.f4592b == dVar.f4592b && this.f4593c == dVar.f4593c && this.f4594d == dVar.f4594d;
    }

    public int hashCode() {
        return (((((((super.hashCode() * 31) + this.f4591a) * 31) + this.f4592b) * 31) + this.f4593c) * 31) + this.f4594d;
    }

    /* renamed from: b */
    public void mo59333b(C4322d dVar) {
        super.mo59343a((C4323e) dVar);
        this.f4591a = dVar.f4591a;
        this.f4592b = dVar.f4592b;
        this.f4593c = dVar.f4593c;
        this.f4594d = dVar.f4594d;
    }

    /* renamed from: a */
    public int mo59328a() {
        return this.f4591a;
    }

    /* renamed from: c */
    public void mo59335c(int i) {
        this.f4591a = i;
    }

    /* renamed from: b */
    public int mo59332b() {
        return this.f4592b;
    }

    /* renamed from: d */
    public void mo59337d(int i) {
        this.f4592b = i;
    }

    /* renamed from: c */
    public int mo59334c() {
        return this.f4593c;
    }

    /* renamed from: e */
    public void mo59338e(int i) {
        this.f4593c = i;
    }

    /* renamed from: d */
    public int mo59336d() {
        return this.f4594d;
    }

    /* renamed from: f */
    public void mo59340f(int i) {
        this.f4594d = i;
    }

    /* renamed from: n */
    public int mo59327n() {
        return super.mo59327n() + 16;
    }

    /* renamed from: a */
    public int mo59317a(byte[] bArr, int i) {
        int a = super.mo59317a(bArr, i);
        C4307c.m4271a(this.f4591a, bArr, a, 4);
        int i2 = a + 4;
        C4307c.m4271a(this.f4592b, bArr, i2, 4);
        int i3 = i2 + 4;
        C4307c.m4271a(this.f4593c, bArr, i3, 4);
        int i4 = i3 + 4;
        C4307c.m4271a(this.f4594d, bArr, i4, 4);
        return i4 + 4;
    }

    /* renamed from: e */
    public byte[] mo59339e() {
        byte[] bArr = new byte[mo59327n()];
        mo59317a(bArr, 0);
        return bArr;
    }

    /* renamed from: a */
    public int mo59318a(byte[] bArr, int i, int i2) {
        int a = super.mo59318a(bArr, i, i2);
        this.f4591a = C4307c.m4292d(bArr, a, 4);
        int i3 = a + 4;
        this.f4592b = C4307c.m4292d(bArr, i3, 4);
        int i4 = i3 + 4;
        this.f4593c = C4307c.m4292d(bArr, i4, 4);
        int i5 = i4 + 4;
        this.f4594d = C4307c.m4292d(bArr, i5, 4);
        return i5 + 4;
    }

    @SuppressLint({"DefaultLocale"})
    public String toString() {
        String str;
        Object[] objArr = new Object[5];
        objArr[0] = C4308d.m4302b(this.f4597g);
        objArr[1] = Integer.valueOf(this.f4592b);
        objArr[2] = Integer.valueOf(this.f4591a);
        objArr[3] = Integer.valueOf(this.f4593c);
        if (this.f4597g == 10 || this.f4597g == 2) {
            str = C4314b.m4372c(this.f4594d);
        } else {
            str = this.f4594d + "";
        }
        objArr[4] = str;
        return String.format("{MediaCodecInfoAudio: codec:%s, channels:%d, frequency:%d, samplesPerFrame:%d, objectType:%s}", objArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo59329a(java.lang.String r5) {
        /*
            r4 = this;
            java.util.Locale r0 = java.util.Locale.ENGLISH
            java.lang.String r5 = r5.toLowerCase(r0)
            java.lang.String r0 = "."
            java.lang.String r0 = java.util.regex.Pattern.quote(r0)
            java.lang.String[] r5 = r5.split(r0)
            int r0 = r5.length
            if (r0 <= 0) goto L_0x0017
            r0 = 0
            r0 = r5[r0]
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            int r1 = r5.length
            r2 = 1
            if (r1 <= r2) goto L_0x001e
            r1 = r5[r2]
        L_0x001e:
            int r1 = r5.length
            r3 = 2
            if (r1 <= r3) goto L_0x0029
            r5 = r5[r3]     // Catch:{ Exception -> 0x0029 }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x0029 }
            goto L_0x002a
        L_0x0029:
            r5 = -1
        L_0x002a:
            if (r0 == 0) goto L_0x0056
            java.lang.String r1 = "mp4a"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0044
            r0 = 32
            if (r5 < r0) goto L_0x003f
            r0 = 34
            if (r5 > r0) goto L_0x003f
            r4.f4597g = r3
            goto L_0x0056
        L_0x003f:
            r0 = 10
            r4.f4597g = r0
            goto L_0x0056
        L_0x0044:
            java.lang.String r1 = "ac-3"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0054
            java.lang.String r1 = "ec-3"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0056
        L_0x0054:
            r4.f4597g = r2
        L_0x0056:
            if (r5 < 0) goto L_0x005a
            r4.f4594d = r5
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p046d.C4322d.mo59329a(java.lang.String):void");
    }

    /* renamed from: a_ */
    public String mo59331a_() {
        int l = mo59325l();
        if (l != 15) {
            switch (l) {
                case 0:
                    return "pcmbe";
                case 1:
                    return "ac-3";
                case 2:
                    return "mp4a.40." + mo59336d();
                case 3:
                    return "pcmle";
                case 4:
                    return "nellymoser16";
                case 5:
                    return "nellymoser8";
                case 6:
                    return "nellymoser";
                case 7:
                    return "g711.alaw";
                case 8:
                    return "g711.mulaw";
                case 9:
                    return "vorbis";
                case 10:
                    if (mo59336d() <= 0) {
                        return "mp4a.40";
                    }
                    return "mp4a.40." + mo59336d();
                case 11:
                    return "speex";
                default:
                    return "unknown";
            }
        } else {
            return "mp4a.40." + mo59336d();
        }
    }
}
