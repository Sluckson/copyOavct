package com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p044b;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.wowza.gocoder.sdk.support.wmstransport.p041a.C4308d;
import com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p046d.C4320b;

/* renamed from: com.wowza.gocoder.sdk.support.wmstransport.wms.a.b.a */
/* compiled from: GoCoderSDK */
public class C4315a implements C4320b {

    /* renamed from: A */
    public int f4454A = 0;

    /* renamed from: B */
    public int f4455B = 0;

    /* renamed from: C */
    public int f4456C = 0;

    /* renamed from: D */
    public int f4457D = 0;

    /* renamed from: E */
    public int f4458E = 0;

    /* renamed from: F */
    public int f4459F = 0;

    /* renamed from: G */
    public int f4460G = 0;

    /* renamed from: H */
    public int f4461H = 0;

    /* renamed from: I */
    public int f4462I = 0;

    /* renamed from: J */
    public int f4463J = 0;

    /* renamed from: K */
    public long f4464K = 0;

    /* renamed from: L */
    public long f4465L = 0;

    /* renamed from: M */
    public int f4466M = 0;

    /* renamed from: N */
    public double f4467N = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;

    /* renamed from: O */
    public int f4468O = 0;

    /* renamed from: P */
    public int f4469P = 0;

    /* renamed from: Q */
    public int f4470Q = 0;

    /* renamed from: R */
    public int f4471R = 0;

    /* renamed from: S */
    public int f4472S = 0;

    /* renamed from: T */
    public int f4473T = 0;

    /* renamed from: U */
    public int f4474U = 0;

    /* renamed from: V */
    public int f4475V = 0;

    /* renamed from: a */
    public int f4476a = 0;

    /* renamed from: b */
    public int f4477b = 4;

    /* renamed from: c */
    public int f4478c = 0;

    /* renamed from: d */
    public int f4479d = 0;

    /* renamed from: e */
    public int f4480e = 0;

    /* renamed from: f */
    public int f4481f = 0;

    /* renamed from: g */
    public int f4482g = 0;

    /* renamed from: h */
    public int f4483h = 0;

    /* renamed from: i */
    public int f4484i = 0;

    /* renamed from: j */
    public int f4485j = 0;

    /* renamed from: k */
    public int f4486k = 0;

    /* renamed from: l */
    public int f4487l = 0;

    /* renamed from: m */
    public int f4488m = 0;

    /* renamed from: n */
    public int f4489n = 0;

    /* renamed from: o */
    public int f4490o = 0;

    /* renamed from: p */
    public int f4491p = 0;

    /* renamed from: q */
    public int f4492q = 0;

    /* renamed from: r */
    public int[] f4493r = null;

    /* renamed from: s */
    public int f4494s = 0;

    /* renamed from: t */
    public int f4495t = 0;

    /* renamed from: u */
    public int f4496u = 0;

    /* renamed from: v */
    public int f4497v = 0;

    /* renamed from: w */
    public int f4498w = 0;

    /* renamed from: x */
    public int f4499x = 0;

    /* renamed from: y */
    public int f4500y = 0;

    /* renamed from: z */
    public int f4501z = 0;

    /* renamed from: h */
    public int mo59311h() {
        return 7;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{H264CodecConfigInfo: ");
        stringBuffer.append("codec:" + C4308d.m4304c(7) + ", ");
        stringBuffer.append("profile:" + C4317c.m4405d(this.f4476a) + ", ");
        stringBuffer.append("level:" + C4317c.m4388a(this.f4478c) + ", ");
        stringBuffer.append("frameSize:" + this.f4473T + "x" + this.f4472S + ", ");
        stringBuffer.append("displaySize:" + this.f4475V + "x" + this.f4474U + ", ");
        if (this.f4467N > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            stringBuffer.append("frameRate:" + this.f4467N + ", ");
        }
        if (this.f4468O > 0 && this.f4469P > 0) {
            stringBuffer.append("PAR:" + this.f4468O + ":" + this.f4469P + ", ");
        }
        if (this.f4456C > 0 || this.f4457D > 0 || this.f4458E > 0 || this.f4459F > 0) {
            stringBuffer.append("crop: l:" + this.f4456C + " r:" + this.f4457D + " t:" + this.f4458E + " b:" + this.f4459F + ", ");
        }
        if (this.f4499x > 0) {
            stringBuffer.append("mbAFF:true, ");
        }
        stringBuffer.setLength(stringBuffer.length() - 2);
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public int mo59304a() {
        return this.f4473T;
    }

    /* renamed from: b */
    public int mo59305b() {
        return this.f4472S;
    }

    /* renamed from: c */
    public int mo59306c() {
        return this.f4475V;
    }

    /* renamed from: d */
    public int mo59307d() {
        return this.f4474U;
    }

    /* renamed from: e */
    public int mo59308e() {
        return this.f4476a;
    }

    /* renamed from: f */
    public int mo59309f() {
        return this.f4478c;
    }

    /* renamed from: g */
    public double mo59310g() {
        return this.f4467N;
    }
}
