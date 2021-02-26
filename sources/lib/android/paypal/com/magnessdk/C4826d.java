package lib.android.paypal.com.magnessdk;

import android.content.Context;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import lib.android.paypal.com.magnessdk.p059b.C4823a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: lib.android.paypal.com.magnessdk.d */
abstract class C4826d {

    /* renamed from: A */
    static final int f5537A = 27;

    /* renamed from: B */
    static final int f5538B = 28;

    /* renamed from: C */
    static final int f5539C = 29;

    /* renamed from: D */
    static final int f5540D = 30;

    /* renamed from: E */
    static final int f5541E = 31;

    /* renamed from: F */
    static final int f5542F = 32;

    /* renamed from: G */
    static final int f5543G = 33;

    /* renamed from: H */
    static final int f5544H = 34;

    /* renamed from: I */
    static final int f5545I = 35;

    /* renamed from: J */
    static final int f5546J = 36;

    /* renamed from: K */
    static final int f5547K = 37;

    /* renamed from: L */
    static final int f5548L = 38;

    /* renamed from: M */
    static final int f5549M = 39;

    /* renamed from: N */
    static final int f5550N = 40;

    /* renamed from: O */
    static final int f5551O = 41;

    /* renamed from: P */
    static final int f5552P = 42;

    /* renamed from: Q */
    static final int f5553Q = 43;

    /* renamed from: R */
    static final int f5554R = 44;

    /* renamed from: S */
    static final int f5555S = 45;

    /* renamed from: T */
    static final int f5556T = 46;

    /* renamed from: U */
    static final int f5557U = 47;

    /* renamed from: V */
    static final int f5558V = 48;

    /* renamed from: W */
    static final int f5559W = 49;

    /* renamed from: X */
    static final int f5560X = 50;

    /* renamed from: Y */
    static final int f5561Y = 51;

    /* renamed from: Z */
    static final int f5562Z = 52;

    /* renamed from: a */
    static final int f5563a = 0;

    /* renamed from: aA */
    static final int f5564aA = 79;

    /* renamed from: aB */
    static final int f5565aB = 80;

    /* renamed from: aC */
    static final int f5566aC = 81;

    /* renamed from: aD */
    static final int f5567aD = 82;

    /* renamed from: aE */
    static final int f5568aE = 83;

    /* renamed from: aF */
    static final int f5569aF = 84;

    /* renamed from: aG */
    static final int f5570aG = 85;

    /* renamed from: aH */
    static final int f5571aH = 86;

    /* renamed from: aI */
    static final int f5572aI = 87;

    /* renamed from: aa */
    static final int f5573aa = 53;

    /* renamed from: ab */
    static final int f5574ab = 54;

    /* renamed from: ac */
    static final int f5575ac = 55;

    /* renamed from: ad */
    static final int f5576ad = 56;

    /* renamed from: ae */
    static final int f5577ae = 57;

    /* renamed from: af */
    static final int f5578af = 58;

    /* renamed from: ag */
    static final int f5579ag = 59;

    /* renamed from: ah */
    static final int f5580ah = 60;

    /* renamed from: ai */
    static final int f5581ai = 61;

    /* renamed from: aj */
    static final int f5582aj = 62;

    /* renamed from: ak */
    static final int f5583ak = 63;

    /* renamed from: al */
    static final int f5584al = 64;

    /* renamed from: am */
    static final int f5585am = 65;

    /* renamed from: an */
    static final int f5586an = 66;

    /* renamed from: ao */
    static final int f5587ao = 67;

    /* renamed from: ap */
    static final int f5588ap = 68;

    /* renamed from: aq */
    static final int f5589aq = 69;

    /* renamed from: ar */
    static final int f5590ar = 70;

    /* renamed from: as */
    static final int f5591as = 71;

    /* renamed from: at */
    static final int f5592at = 72;

    /* renamed from: au */
    static final int f5593au = 73;

    /* renamed from: av */
    static final int f5594av = 74;

    /* renamed from: aw */
    static final int f5595aw = 75;

    /* renamed from: ax */
    static final int f5596ax = 76;

    /* renamed from: ay */
    static final int f5597ay = 77;

    /* renamed from: az */
    static final int f5598az = 78;

    /* renamed from: b */
    static final int f5599b = 1;

    /* renamed from: c */
    static final int f5600c = 2;

    /* renamed from: d */
    static final int f5601d = 3;

    /* renamed from: e */
    static final int f5602e = 4;

    /* renamed from: f */
    static final int f5603f = 5;

    /* renamed from: g */
    static final int f5604g = 6;

    /* renamed from: h */
    static final int f5605h = 7;

    /* renamed from: i */
    static final int f5606i = 8;

    /* renamed from: j */
    static final int f5607j = 9;

    /* renamed from: k */
    static final int f5608k = 10;

    /* renamed from: l */
    static final int f5609l = 11;

    /* renamed from: m */
    static final int f5610m = 12;

    /* renamed from: n */
    static final int f5611n = 13;

    /* renamed from: o */
    static final int f5612o = 14;

    /* renamed from: p */
    static final int f5613p = 15;

    /* renamed from: q */
    static final int f5614q = 16;

    /* renamed from: r */
    static final int f5615r = 17;

    /* renamed from: s */
    static final int f5616s = 18;

    /* renamed from: t */
    static final int f5617t = 19;

    /* renamed from: u */
    static final int f5618u = 20;

    /* renamed from: v */
    static final int f5619v = 21;

    /* renamed from: w */
    static final int f5620w = 22;

    /* renamed from: x */
    static final int f5621x = 23;

    /* renamed from: y */
    static final int f5622y = 25;

    /* renamed from: z */
    static final int f5623z = 26;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: lib.android.paypal.com.magnessdk.d$a */
    @interface C4827a {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: lib.android.paypal.com.magnessdk.d$b */
    @interface C4828b {
    }

    C4826d() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract JSONObject mo68913a();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract JSONObject mo68914a(Context context);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JSONObject mo68915a(JSONObject jSONObject) {
        JSONObject a = mo68913a();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                a.put(next, jSONObject.get(next));
            } catch (JSONException e) {
                C4823a.m4654a(getClass(), 3, (Throwable) e);
            }
        }
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo68916a(int i, Context context);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo68917a(Context context, String str) {
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e) {
            C4823a.m4654a(getClass(), 3, (Throwable) e);
            return false;
        }
    }
}
