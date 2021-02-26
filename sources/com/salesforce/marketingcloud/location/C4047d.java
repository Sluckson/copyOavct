package com.salesforce.marketingcloud.location;

import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;
import com.google.auto.value.AutoValue;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@AutoValue
@SuppressLint({"UnknownNullness"})
/* renamed from: com.salesforce.marketingcloud.location.d */
public abstract class C4047d {

    /* renamed from: a */
    public static final int f2972a = 1;

    /* renamed from: b */
    public static final int f2973b = 2;

    /* renamed from: c */
    public static final int f2974c = 4;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.salesforce.marketingcloud.location.d$a */
    public @interface C4048a {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.salesforce.marketingcloud.location.d$b */
    public @interface C4049b {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public static C4047d m2871a(String str, float f, double d, double d2, int i) {
        return new C4044a(str, f, d, d2, i);
    }

    /* renamed from: a */
    public abstract String mo56563a();

    /* renamed from: b */
    public abstract float mo56564b();

    /* renamed from: c */
    public abstract double mo56565c();

    /* renamed from: d */
    public abstract double mo56566d();

    /* renamed from: e */
    public abstract int mo56567e();
}
