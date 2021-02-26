package com.salesforce.marketingcloud.p022d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.p022d.C4007c;
import com.salesforce.marketingcloud.p022d.p023a.C3962a;
import com.salesforce.marketingcloud.p022d.p023a.C3988c;
import com.salesforce.marketingcloud.p022d.p023a.C3992d;
import com.salesforce.marketingcloud.p022d.p023a.C3994e;
import com.salesforce.marketingcloud.p022d.p023a.C3996f;
import com.salesforce.marketingcloud.p022d.p023a.C3998g;
import com.salesforce.marketingcloud.p022d.p023a.C4000h;
import com.salesforce.marketingcloud.p022d.p023a.C4002i;
import com.salesforce.marketingcloud.p022d.p023a.C4004j;
import com.salesforce.marketingcloud.p027e.C4022a;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.d.h */
public class C4016h extends C4005b {

    /* renamed from: f */
    private static final String f2901f = C4039h.m2810a((Class<?>) C4016h.class);

    /* renamed from: g */
    private static final String f2902g = "ETStorage.version";

    /* renamed from: h */
    private static final int f2903h = 1;

    /* renamed from: i */
    private final C4007c f2904i;

    /* renamed from: j */
    private final SharedPreferences f2905j;

    /* renamed from: k */
    private final C4004j f2906k;

    /* renamed from: l */
    private C3962a f2907l;

    /* renamed from: m */
    private C3996f f2908m;

    /* renamed from: n */
    private C3998g f2909n;

    /* renamed from: o */
    private C4000h f2910o;

    /* renamed from: p */
    private C4002i f2911p;

    /* renamed from: q */
    private C3994e f2912q;

    /* renamed from: r */
    private C3988c f2913r;

    /* renamed from: s */
    private C3992d f2914s;

    public C4016h(@NonNull Context context, C4022a aVar, @NonNull String str, @NonNull String str2) {
        super(context, aVar, str, str2);
        this.f2906k = new C4004j(context, aVar, this.f2871b);
        this.f2906k.mo56513b();
        this.f2904i = new C4007c.C4008a(context, aVar, this.f2871b);
        this.f2905j = context.getSharedPreferences(m2645a(this.f2871b), 0);
        if (this.f2906k.mo56512a()) {
            this.f2904i.mo56520a();
            this.f2905j.edit().clear().apply();
        }
    }

    /* renamed from: b */
    private void m2698b(C4022a aVar) {
        this.f2905j.edit().putString("create_date", aVar.mo56544a(String.valueOf(System.currentTimeMillis()))).apply();
    }

    /* renamed from: o */
    private void m2699o() {
        m2700p();
        this.f2906k.mo56515d();
    }

    /* renamed from: p */
    private void m2700p() {
        mo56531d().mo56520a();
        mo56532e().edit().clear().apply();
        m2698b(this.f2873d);
    }

    /* renamed from: a */
    public C4022a mo56524a() {
        return this.f2873d;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0043 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo56533a(com.salesforce.marketingcloud.InitializationStatus.C3832a r5) {
        /*
            r4 = this;
            android.content.SharedPreferences r0 = r4.f2905j
            boolean r0 = r4.mo56519a((android.content.SharedPreferences) r0)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x002c
            android.content.SharedPreferences r0 = r4.f2905j
            java.lang.String r3 = "create_date"
            boolean r0 = r0.contains(r3)
            r5.mo56104b((boolean) r0)
            if (r0 == 0) goto L_0x002c
            r4.m2699o()     // Catch:{ Exception -> 0x001b }
            goto L_0x002c
        L_0x001b:
            r0 = move-exception
            r5.mo56099a((java.lang.Throwable) r0)
            r5.mo56107c(r2)
            java.lang.String r5 = f2901f
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "Failed to recover from encryption change."
            com.salesforce.marketingcloud.C4039h.m2830e(r5, r0, r2, r1)
            return
        L_0x002c:
            com.salesforce.marketingcloud.d.a.j r0 = r4.f2906k     // Catch:{ a -> 0x0043, IllegalStateException -> 0x0032 }
            r0.mo56514c()     // Catch:{ a -> 0x0043, IllegalStateException -> 0x0032 }
            goto L_0x0046
        L_0x0032:
            r0 = move-exception
            r5.mo56099a((java.lang.Throwable) r0)
            r5.mo56107c(r2)
            java.lang.String r5 = f2901f
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "Could not create the necessary database table(s)."
            com.salesforce.marketingcloud.C4039h.m2830e(r5, r0, r2, r1)
            return
        L_0x0043:
            r4.m2700p()     // Catch:{ Exception -> 0x006e }
        L_0x0046:
            android.content.SharedPreferences r5 = r4.f2905j
            r0 = -1
            java.lang.String r1 = "ETStorage.version"
            int r5 = r5.getInt(r1, r0)
            if (r5 == 0) goto L_0x006d
            if (r5 == r2) goto L_0x006d
            if (r2 >= r5) goto L_0x005b
            android.content.Context r0 = r4.f2872c
            r4.mo56529b(r0, r5, r2)
            goto L_0x0060
        L_0x005b:
            android.content.Context r0 = r4.f2872c
            r4.mo56525a((android.content.Context) r0, (int) r5, (int) r2)
        L_0x0060:
            android.content.SharedPreferences r5 = r4.f2905j
            android.content.SharedPreferences$Editor r5 = r5.edit()
            android.content.SharedPreferences$Editor r5 = r5.putInt(r1, r2)
            r5.apply()
        L_0x006d:
            return
        L_0x006e:
            r0 = move-exception
            r5.mo56099a((java.lang.Throwable) r0)
            r5.mo56107c(r2)
            java.lang.String r5 = f2901f
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "Failed to recover from data reset."
            com.salesforce.marketingcloud.C4039h.m2830e(r5, r0, r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.p022d.C4016h.mo56533a(com.salesforce.marketingcloud.InitializationStatus$a):void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo56519a(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString("create_date", (String) null);
        if (string == null) {
            return false;
        }
        try {
            this.f2873d.mo56545b(string);
            return true;
        } catch (UnsupportedEncodingException | GeneralSecurityException e) {
            C4039h.m2830e(f2901f, e, "Failed to verify existing encryption key", new Object[0]);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final Context mo56528b() {
        return this.f2872c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo56529b(Context context, int i, int i2) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public SQLiteOpenHelper mo56530c() {
        return this.f2906k;
    }

    /* renamed from: d */
    public C4007c mo56531d() {
        return this.f2904i;
    }

    /* renamed from: e */
    public SharedPreferences mo56532e() {
        return this.f2905j;
    }

    /* renamed from: f */
    public final void mo56534f() {
        this.f2906k.close();
    }

    /* renamed from: g */
    public C3961a mo56535g() {
        if (this.f2907l == null) {
            this.f2907l = new C3962a(this.f2906k.mo56513b());
        }
        return this.f2907l;
    }

    /* renamed from: h */
    public C4015g mo56536h() {
        if (this.f2912q == null) {
            this.f2912q = new C3994e(this.f2906k.mo56513b());
        }
        return this.f2912q;
    }

    /* renamed from: i */
    public C4017i mo56537i() {
        if (this.f2908m == null) {
            this.f2908m = new C3996f(this.f2906k.mo56513b());
        }
        return this.f2908m;
    }

    /* renamed from: j */
    public C4019k mo56538j() {
        if (this.f2909n == null) {
            this.f2909n = new C3998g(this.f2906k.mo56513b());
        }
        return this.f2909n;
    }

    /* renamed from: k */
    public C4018j mo56539k() {
        if (this.f2910o == null) {
            this.f2910o = new C4000h(this.f2906k.mo56513b());
        }
        return this.f2910o;
    }

    /* renamed from: l */
    public C4020l mo56540l() {
        if (this.f2911p == null) {
            this.f2911p = new C4002i(this.f2906k.mo56513b(), this.f2872c);
        }
        return this.f2911p;
    }

    /* renamed from: m */
    public C4013f mo56541m() {
        if (this.f2913r == null) {
            this.f2913r = new C3988c(this.f2906k.mo56513b());
        }
        return this.f2913r;
    }

    /* renamed from: n */
    public C4011e mo56542n() {
        if (this.f2914s == null) {
            this.f2914s = new C3992d(this.f2906k.mo56513b());
        }
        return this.f2914s;
    }
}
