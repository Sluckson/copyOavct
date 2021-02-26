package com.salesforce.marketingcloud.p017a;

import android.annotation.SuppressLint;
import androidx.annotation.CheckResult;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import com.salesforce.marketingcloud.p022d.C4016h;
import com.salesforce.marketingcloud.registration.C4131c;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.a.a */
public abstract class C3848a {
    @NonNull

    /* renamed from: a */
    private final String f2210a;

    /* renamed from: b */
    private final long f2211b;

    /* renamed from: c */
    private final double f2212c;

    /* renamed from: d */
    private final long f2213d;
    @NonNull

    /* renamed from: e */
    private final String f2214e;

    /* renamed from: f */
    private final int f2215f;

    /* renamed from: g */
    private final boolean f2216g;

    /* renamed from: h */
    private final boolean f2217h;

    /* renamed from: com.salesforce.marketingcloud.a.a$a */
    public enum C3850a {
        REGISTRATION(909100) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public boolean mo56198a(@NonNull C4016h hVar) {
                return C4131c.m3421a(hVar);
            }

            /* access modifiers changed from: protected */
            /* renamed from: b */
            public C3848a mo56199b() {
                return new C3870j(mo56197a());
            }
        },
        PI_ANALYTICS(909101) {
            /* access modifiers changed from: protected */
            /* renamed from: b */
            public C3848a mo56199b() {
                return new C3868h(mo56197a());
            }
        },
        ET_ANALYTICS(909102) {
            /* access modifiers changed from: protected */
            /* renamed from: b */
            public C3848a mo56199b() {
                return new C3862b(mo56197a());
            }
        },
        FETCH_BEACON_MESSAGES(909103) {
            /* access modifiers changed from: protected */
            /* renamed from: b */
            public C3848a mo56199b() {
                return new C3865e(mo56197a());
            }
        },
        FETCH_FENCE_MESSAGES(909104) {
            /* access modifiers changed from: protected */
            /* renamed from: b */
            public C3848a mo56199b() {
                return new C3866f(mo56197a());
            }
        },
        FETCH_BEACON_MESSAGES_DAILY(909105) {
            /* access modifiers changed from: protected */
            /* renamed from: b */
            public C3848a mo56199b() {
                return new C3863c(mo56197a());
            }
        },
        FETCH_FENCE_MESSAGES_DAILY(909106) {
            /* access modifiers changed from: protected */
            /* renamed from: b */
            public C3848a mo56199b() {
                return new C3864d(mo56197a());
            }
        },
        FETCH_INBOX_MESSAGES(909107) {
            /* access modifiers changed from: protected */
            /* renamed from: b */
            public C3848a mo56199b() {
                return new C3867g(mo56197a());
            }
        },
        FETCH_PUSH_TOKEN(909108) {
            /* access modifiers changed from: protected */
            /* renamed from: b */
            public C3848a mo56199b() {
                return new C3869i(mo56197a());
            }
        },
        UPDATE_INBOX_MESSAGE_STATUS(909110) {
            /* access modifiers changed from: protected */
            /* renamed from: b */
            public C3848a mo56199b() {
                return new C3871k(mo56197a());
            }
        };
        

        /* renamed from: k */
        private final int f2229k;

        @VisibleForTesting
        /* renamed from: com.salesforce.marketingcloud.a.a$a$a */
        static class C3861a {

            /* renamed from: a */
            static final int f2230a = 909110;

            /* renamed from: b */
            static final int f2231b = 909109;

            /* renamed from: c */
            static final int f2232c = 909108;

            /* renamed from: d */
            static final int f2233d = 909107;

            /* renamed from: e */
            static final int f2234e = 909106;

            /* renamed from: f */
            static final int f2235f = 909105;

            /* renamed from: g */
            static final int f2236g = 909104;

            /* renamed from: h */
            static final int f2237h = 909103;

            /* renamed from: i */
            static final int f2238i = 909102;

            /* renamed from: j */
            static final int f2239j = 909101;

            /* renamed from: k */
            static final int f2240k = 909100;

            C3861a() {
            }
        }

        private C3850a(int i) {
            this.f2229k = i;
        }

        /* renamed from: a */
        public int mo56197a() {
            return this.f2229k;
        }

        /* access modifiers changed from: protected */
        @CheckResult
        /* renamed from: a */
        public boolean mo56198a(@NonNull C4016h hVar) {
            return true;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public abstract C3848a mo56199b();
    }

    /* renamed from: com.salesforce.marketingcloud.a.a$b */
    private static final class C3862b extends C3848a {
        private C3862b(int i) {
            this(i, "et_etanalytic_alarm_created_date", "et_etanalytic_next_alarm_interval", 15000, 2.0d, 86400000, false, false);
        }

        private C3862b(int i, String str, String str2, long j, double d, long j2, boolean z, boolean z2) {
            super(i, str, str2, j, d, j2, z, z2);
        }
    }

    /* renamed from: com.salesforce.marketingcloud.a.a$c */
    private static final class C3863c extends C3848a {
        private C3863c(int i) {
            this(i, "et_fetch_background_beacon_messages_alarm_created_date", "et_fetch_background_beacon_messages_next_alarm_interval", 86400000, 1.0d, 86400000, false, true);
        }

        private C3863c(int i, String str, String str2, long j, double d, long j2, boolean z, boolean z2) {
            super(i, str, str2, j, d, j2, z, z2);
        }
    }

    /* renamed from: com.salesforce.marketingcloud.a.a$d */
    private static final class C3864d extends C3848a {
        private C3864d(int i) {
            this(i, "et_fetch_background_fence_messages_alarm_created_date", "et_fetch_background_fence_messages_next_alarm_interval", 86400000, 1.0d, 86400000, false, true);
        }

        private C3864d(int i, String str, String str2, long j, double d, long j2, boolean z, boolean z2) {
            super(i, str, str2, j, d, j2, z, z2);
        }
    }

    /* renamed from: com.salesforce.marketingcloud.a.a$e */
    private static final class C3865e extends C3848a {
        private C3865e(int i) {
            this(i, "et_fetch_beacon_messages_alarm_created_date", "et_fetch_beacon_messages_next_alarm_interval", 60000, 2.0d, 86400000, false, false);
        }

        private C3865e(int i, String str, String str2, long j, double d, long j2, boolean z, boolean z2) {
            super(i, str, str2, j, d, j2, z, z2);
        }
    }

    /* renamed from: com.salesforce.marketingcloud.a.a$f */
    private static final class C3866f extends C3848a {
        private C3866f(int i) {
            this(i, "et_fetch_fence_messages_alarm_created_date", "et_fetch_fence_messages_next_alarm_interval", 60000, 2.0d, 86400000, false, false);
        }

        private C3866f(int i, String str, String str2, long j, double d, long j2, boolean z, boolean z2) {
            super(i, str, str2, j, d, j2, z, z2);
        }
    }

    /* renamed from: com.salesforce.marketingcloud.a.a$g */
    private static final class C3867g extends C3848a {
        private C3867g(int i) {
            this(i, "et_fetch_cloud_messages_alarm_created_date", "et_fetch_cloud_messages_next_alarm_interval", 60000, 2.0d, 86400000, true, false);
        }

        private C3867g(int i, String str, String str2, long j, double d, long j2, boolean z, boolean z2) {
            super(i, str, str2, j, d, j2, z, z2);
        }
    }

    /* renamed from: com.salesforce.marketingcloud.a.a$h */
    private static final class C3868h extends C3848a {
        private C3868h(int i) {
            this(i, "et_wama_alarm_created_date", "et_wama_next_alarm_interval", 15000, 2.0d, 86400000, false, false);
        }

        private C3868h(int i, String str, String str2, long j, double d, long j2, boolean z, boolean z2) {
            super(i, str, str2, j, d, j2, z, z2);
        }
    }

    /* renamed from: com.salesforce.marketingcloud.a.a$i */
    private static final class C3869i extends C3848a {
        private C3869i(int i) {
            this(i, "et_register_for_remote_notifications_alarm_created_date", "et_register_for_remote_notifications_next_alarm_interval", 60000, 2.0d, 86400000, false, false);
        }

        private C3869i(int i, String str, String str2, long j, double d, long j2, boolean z, boolean z2) {
            super(i, str, str2, j, d, j2, z, z2);
        }
    }

    /* renamed from: com.salesforce.marketingcloud.a.a$j */
    private static final class C3870j extends C3848a {
        private C3870j(int i) {
            this(i, "et_registration_alarm_created_date", "et_registration_next_alarm_interval", 60000, 2.0d, 86400000, false, false);
        }

        private C3870j(int i, String str, String str2, long j, double d, long j2, boolean z, boolean z2) {
            super(i, str, str2, j, d, j2, z, z2);
        }
    }

    /* renamed from: com.salesforce.marketingcloud.a.a$k */
    private static final class C3871k extends C3848a {
        private C3871k(int i) {
            this(i, "et_update_inbox_message_status_alarm_created_date", "et_update_inbox_message_status_next_alarm_interval", 60000, 2.0d, 86400000, true, false);
        }

        private C3871k(int i, String str, String str2, long j, double d, long j2, boolean z, boolean z2) {
            super(i, str, str2, j, d, j2, z, z2);
        }
    }

    @VisibleForTesting
    C3848a(@IntRange(from = 1, mo669to = 2147483647L) int i, @Size(min = 1) @NonNull String str, @Size(min = 1) @NonNull String str2, @IntRange(from = 1, mo669to = 86400000) long j, @FloatRange(from = 1.0d, mo651to = 10.0d) double d, @IntRange(from = 1, mo669to = 86400000) long j2, boolean z, boolean z2) {
        this.f2215f = i;
        this.f2214e = str;
        this.f2210a = str2;
        this.f2211b = j;
        this.f2212c = d;
        this.f2213d = j2;
        this.f2216g = z;
        this.f2217h = z2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo56189a() {
        return this.f2217h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo56190b() {
        return this.f2216g;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: c */
    public final String mo56191c() {
        return this.f2210a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final long mo56192d() {
        return this.f2211b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final double mo56193e() {
        return this.f2212c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final long mo56194f() {
        return this.f2213d;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: g */
    public final String mo56195g() {
        return this.f2214e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final int mo56196h() {
        return this.f2215f;
    }
}
