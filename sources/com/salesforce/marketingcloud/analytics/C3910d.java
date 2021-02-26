package com.salesforce.marketingcloud.analytics;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.salesforce.marketingcloud.p027e.C4028g;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.analytics.d */
public final class C3910d {

    /* renamed from: a */
    public static final int f2379a = 2;

    /* renamed from: b */
    public static final int f2380b = 3;

    /* renamed from: c */
    public static final int f2381c = 4;

    /* renamed from: d */
    public static final int f2382d = 5;

    /* renamed from: e */
    public static final int f2383e = 5;

    /* renamed from: f */
    public static final int f2384f = 6;

    /* renamed from: g */
    public static final int f2385g = 7;

    /* renamed from: h */
    public static final int f2386h = 10;

    /* renamed from: i */
    public static final int f2387i = 11;

    /* renamed from: j */
    public static final int f2388j = 12;

    /* renamed from: k */
    public static final int f2389k = 13;

    /* renamed from: l */
    public static final int f2390l = 14;

    /* renamed from: m */
    public static final int f2391m = 15;

    /* renamed from: n */
    public static final int f2392n = 16;

    /* renamed from: o */
    public static final int f2393o = 88888;

    /* renamed from: p */
    public static final int f2394p = 888;

    /* renamed from: q */
    public static final int f2395q = 8888;

    /* renamed from: r */
    public static final List<Integer> f2396r = Collections.unmodifiableList(Arrays.asList(new Integer[]{3, 14}));

    /* renamed from: s */
    public static final int f2397s = 0;

    /* renamed from: t */
    public static final int f2398t = 1;

    /* renamed from: A */
    private boolean f2399A;

    /* renamed from: B */
    private String f2400B;

    /* renamed from: C */
    private String f2401C;

    /* renamed from: u */
    private final Date f2402u;

    /* renamed from: v */
    private final int f2403v;

    /* renamed from: w */
    private final int f2404w;

    /* renamed from: x */
    private final List<String> f2405x = new ArrayList();

    /* renamed from: y */
    private int f2406y;

    /* renamed from: z */
    private int f2407z;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.salesforce.marketingcloud.analytics.d$a */
    public @interface C3911a {
    }

    @SuppressLint({"UniqueConstants"})
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.salesforce.marketingcloud.analytics.d$b */
    public @interface C3912b {
    }

    private C3910d(Date date, int i, int i2, List<String> list, String str, boolean z) {
        this.f2402u = (Date) C4028g.m2762a(date, "The Date is null.");
        boolean z2 = false;
        C4028g.m2764a(i == 0 || i == 1, "The Product Type must be one of AnalyticProductType");
        this.f2403v = i;
        C4028g.m2764a(i2 > 0 ? true : z2, "AnalyticType must be a valid int > 0.");
        this.f2404w = i2;
        if (list != null && !list.isEmpty()) {
            this.f2405x.addAll(list);
        }
        this.f2401C = str;
        this.f2399A = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public static C3910d m2281a(@NonNull Date date, int i, int i2) {
        return m2282a(date, i, i2, Collections.emptyList(), (String) null, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public static C3910d m2282a(@NonNull Date date, int i, int i2, List<String> list, String str, boolean z) {
        return new C3910d(date, i, i2, list, str, z);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public static C3910d m2283a(@NonNull Date date, int i, int i2, List<String> list, boolean z) {
        return m2282a(date, i, i2, list, (String) null, z);
    }

    /* renamed from: a */
    public int mo56307a() {
        return this.f2406y;
    }

    /* renamed from: a */
    public void mo56308a(int i) {
        this.f2406y = i;
    }

    /* renamed from: a */
    public void mo56309a(String str) {
        this.f2400B = str;
    }

    /* renamed from: a */
    public void mo56310a(boolean z) {
        this.f2399A = z;
    }

    /* renamed from: b */
    public Date mo56311b() {
        return this.f2402u;
    }

    /* renamed from: b */
    public void mo56312b(int i) {
        this.f2407z = i;
    }

    /* renamed from: c */
    public int mo56313c() {
        return this.f2403v;
    }

    /* renamed from: d */
    public int mo56314d() {
        return this.f2404w;
    }

    /* renamed from: e */
    public int mo56315e() {
        return this.f2407z;
    }

    /* renamed from: f */
    public List<String> mo56316f() {
        List<String> list;
        synchronized (this.f2405x) {
            list = this.f2405x;
        }
        return list;
    }

    /* renamed from: g */
    public boolean mo56317g() {
        return this.f2399A;
    }

    /* renamed from: h */
    public String mo56318h() {
        return this.f2400B;
    }

    /* renamed from: i */
    public String mo56319i() {
        return this.f2401C;
    }
}
