package com.salesforce.marketingcloud;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.auto.value.AutoValue;
import com.salesforce.marketingcloud.C3845a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AutoValue
@MCKeep
public abstract class InitializationStatus {

    @MCKeep
    public enum Status {
        SUCCESS,
        COMPLETED_WITH_DEGRADED_FUNCTIONALITY,
        FAILED
    }

    @SuppressLint({"UnknownNullness"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @AutoValue.Builder
    /* renamed from: com.salesforce.marketingcloud.InitializationStatus$a */
    public static abstract class C3832a {

        /* renamed from: a */
        private List<String> f2143a;

        /* renamed from: b */
        private String f2144b = null;

        /* renamed from: a */
        public abstract C3832a mo56095a(int i);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract C3832a mo56096a(Status status);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final C3832a mo56097a(C4021e eVar) {
            if (eVar != null) {
                if (this.f2143a == null) {
                    this.f2143a = new ArrayList();
                }
                this.f2143a.add(eVar.mo56210b());
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        @Nullable
        /* renamed from: a */
        public abstract C3832a mo56098a(String str);

        /* renamed from: a */
        public abstract C3832a mo56099a(Throwable th);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract C3832a mo56100a(List<String> list);

        /* renamed from: a */
        public abstract C3832a mo56101a(boolean z);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract Throwable mo56102a();

        /* renamed from: b */
        public C3832a mo56103b(@NonNull String str) {
            if (!TextUtils.isEmpty(this.f2144b)) {
                str = this.f2144b + "\n" + str;
            }
            this.f2144b = str;
            return this;
        }

        /* renamed from: b */
        public abstract C3832a mo56104b(boolean z);

        @VisibleForTesting(otherwise = 3)
        /* renamed from: b */
        public abstract boolean mo56105b();

        /* renamed from: c */
        public abstract int mo56106c();

        /* renamed from: c */
        public abstract C3832a mo56107c(boolean z);

        /* renamed from: d */
        public abstract C3832a mo56108d(boolean z);

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public abstract boolean mo56109d();

        /* renamed from: e */
        public abstract C3832a mo56110e(boolean z);

        @VisibleForTesting
        /* renamed from: e */
        public abstract boolean mo56111e();

        /* renamed from: f */
        public abstract C3832a mo56112f(boolean z);

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public abstract boolean mo56113f();

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public abstract boolean mo56114g();

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public abstract InitializationStatus mo56115h();

        @Nullable
        /* renamed from: i */
        public String mo56116i() {
            return this.f2144b;
        }

        /* renamed from: j */
        public final boolean mo56117j() {
            return mo56102a() == null;
        }

        /* renamed from: k */
        public final InitializationStatus mo56118k() {
            mo56096a(mo56117j() ? (mo56105b() || mo56109d() || mo56113f() || mo56111e() || mo56114g()) ? Status.COMPLETED_WITH_DEGRADED_FUNCTIONALITY : Status.SUCCESS : Status.FAILED);
            if (!TextUtils.isEmpty(this.f2144b)) {
                mo56098a(this.f2144b);
            }
            List<String> list = this.f2143a;
            mo56100a((List<String>) list == null ? Collections.emptyList() : Collections.unmodifiableList(list));
            return mo56115h();
        }
    }

    static InitializationStatus amazonDeviceStatus() {
        return builder().mo56099a((Throwable) new IllegalStateException("Amazon devices are not supported")).mo56118k();
    }

    static C3832a builder() {
        return new C3845a.C3847a().mo56101a(false).mo56095a(-1).mo56112f(false).mo56104b(false).mo56110e(false).mo56108d(false).mo56107c(false);
    }

    public abstract boolean encryptionChanged();

    @NonNull
    public abstract List<String> initializedComponents();

    public final boolean isUsable() {
        return status() != Status.FAILED;
    }

    public abstract boolean locationsError();

    public abstract boolean messagingPermissionError();

    @Nullable
    public abstract String playServicesMessage();

    public abstract int playServicesStatus();

    public abstract boolean proximityError();

    public abstract boolean sslProviderEnablementError();

    @NonNull
    public abstract Status status();

    public abstract boolean storageError();

    @Nullable
    public abstract Throwable unrecoverableException();
}
