package com.salesforce.marketingcloud.p021c;

import android.annotation.SuppressLint;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.salesforce.marketingcloud.p021c.C3937a;
import java.util.List;
import java.util.Map;

@AutoValue
@SuppressLint({"UnknownNullness"})
/* renamed from: com.salesforce.marketingcloud.c.g */
public abstract class C3953g implements Parcelable {

    @AutoValue.Builder
    /* renamed from: com.salesforce.marketingcloud.c.g$a */
    public static abstract class C3954a {
        /* renamed from: a */
        public abstract C3954a mo56368a(int i);

        /* renamed from: a */
        public abstract C3954a mo56369a(long j);

        /* renamed from: a */
        public abstract C3954a mo56370a(String str);

        /* renamed from: a */
        public abstract C3954a mo56371a(Map<String, List<String>> map);

        /* renamed from: a */
        public abstract C3953g mo56372a();

        /* renamed from: b */
        public abstract C3954a mo56373b(long j);

        /* renamed from: b */
        public abstract C3954a mo56374b(String str);
    }

    /* renamed from: a */
    public static C3953g m2436a(String str, int i) {
        return m2437g().mo56374b(str).mo56368a(i).mo56369a(0).mo56373b(0).mo56372a();
    }

    /* renamed from: g */
    public static C3954a m2437g() {
        return new C3937a.C3938a().mo56369a(0).mo56373b(0);
    }

    @Nullable
    /* renamed from: a */
    public abstract String mo56359a();

    @Nullable
    /* renamed from: b */
    public abstract String mo56360b();

    /* renamed from: c */
    public abstract int mo56361c();

    /* renamed from: d */
    public abstract long mo56362d();

    /* renamed from: e */
    public abstract long mo56363e();

    @Nullable
    /* renamed from: f */
    public abstract Map<String, List<String>> mo56365f();

    /* renamed from: h */
    public final boolean mo56419h() {
        return mo56361c() >= 200 && mo56361c() < 300;
    }

    /* renamed from: i */
    public long mo56420i() {
        return mo56363e() - mo56362d();
    }
}
