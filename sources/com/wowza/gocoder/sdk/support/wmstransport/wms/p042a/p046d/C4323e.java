package com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p046d;

import com.lowagie.text.pdf.codec.wmf.MetaDo;
import com.wowza.gocoder.sdk.support.wmstransport.p041a.C4307c;
import java.util.Arrays;

/* renamed from: com.wowza.gocoder.sdk.support.wmstransport.wms.a.d.e */
/* compiled from: GoCoderSDK */
public abstract class C4323e implements C4321c {

    /* renamed from: e */
    protected int f4595e = -1;

    /* renamed from: f */
    protected int f4596f = -1;

    /* renamed from: g */
    protected int f4597g = -1;

    /* renamed from: h */
    protected byte[] f4598h = null;

    /* renamed from: a_ */
    public String mo59331a_() {
        return "unknown";
    }

    /* renamed from: a */
    public void mo59343a(C4323e eVar) {
        this.f4596f = eVar.f4596f;
        this.f4597g = eVar.f4597g;
        this.f4598h = null;
        byte[] bArr = eVar.f4598h;
        if (bArr != null) {
            this.f4598h = new byte[bArr.length];
            byte[] bArr2 = eVar.f4598h;
            byte[] bArr3 = this.f4598h;
            System.arraycopy(bArr2, 0, bArr3, 0, bArr3.length);
        }
    }

    /* renamed from: b */
    public boolean mo59344b(C4323e eVar) {
        if (eVar != null && this.f4596f == eVar.f4596f && this.f4597g == eVar.f4597g && Arrays.equals(this.f4598h, eVar.f4598h)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((MetaDo.META_OFFSETWINDOWORG + this.f4596f) * 31) + this.f4597g) * 31) + Arrays.hashCode(this.f4598h);
    }

    /* renamed from: a */
    public void mo59319a(int i) {
        this.f4596f = i;
    }

    /* renamed from: i */
    public int mo59322i() {
        return this.f4596f;
    }

    /* renamed from: j */
    public boolean mo59323j() {
        return this.f4596f == 8;
    }

    /* renamed from: k */
    public boolean mo59324k() {
        return this.f4596f == 9;
    }

    /* renamed from: l */
    public int mo59325l() {
        return this.f4597g;
    }

    /* renamed from: b */
    public void mo59321b(int i) {
        this.f4597g = i;
    }

    /* renamed from: m */
    public byte[] mo59326m() {
        return this.f4598h;
    }

    /* renamed from: a */
    public void mo59320a(byte[] bArr) {
        this.f4598h = bArr;
    }

    /* renamed from: n */
    public int mo59327n() {
        byte[] bArr = this.f4598h;
        return (bArr != null ? bArr.length : 0) + 3 + 9;
    }

    /* renamed from: a */
    public int mo59317a(byte[] bArr, int i) {
        bArr[i] = 2;
        int i2 = i + 1;
        C4307c.m4271a(this.f4596f, bArr, i2, 4);
        int i3 = i2 + 4;
        C4307c.m4271a(this.f4597g, bArr, i3, 4);
        int i4 = i3 + 4;
        byte[] bArr2 = this.f4598h;
        if (bArr2 != null) {
            C4307c.m4271a(bArr2.length, bArr, i4, 3);
            int i5 = i4 + 3;
            byte[] bArr3 = this.f4598h;
            System.arraycopy(bArr3, 0, bArr, i5, bArr3.length);
            return i5 + this.f4598h.length;
        }
        C4307c.m4271a(0, bArr, i4, 3);
        return i4 + 3;
    }

    /* renamed from: a */
    public int mo59318a(byte[] bArr, int i, int i2) {
        this.f4595e = bArr[i];
        int i3 = i + 1;
        this.f4596f = C4307c.m4292d(bArr, i3, 4);
        int i4 = i3 + 4;
        this.f4597g = C4307c.m4292d(bArr, i4, 4);
        int i5 = i4 + 4;
        int d = C4307c.m4292d(bArr, i5, 3);
        int i6 = i5 + 3;
        if (d <= 0) {
            return i6;
        }
        this.f4598h = new byte[d];
        System.arraycopy(bArr, i6, this.f4598h, 0, d);
        return i6 + d;
    }
}
