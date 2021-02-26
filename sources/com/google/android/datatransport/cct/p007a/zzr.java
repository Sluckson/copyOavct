package com.google.android.datatransport.cct.p007a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.p007a.zzk;
import com.google.auto.value.AutoValue;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

@AutoValue
/* renamed from: com.google.android.datatransport.cct.a.zzr */
public abstract class zzr {

    @AutoValue.Builder
    /* renamed from: com.google.android.datatransport.cct.a.zzr$zza */
    public static abstract class zza {
        @NonNull
        public zza zza(int i) {
            return zza(Integer.valueOf(i));
        }

        @NonNull
        public abstract zza zza(long j);

        @NonNull
        public abstract zza zza(@Nullable zzp zzp);

        @NonNull
        public abstract zza zza(@Nullable zzu zzu);

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract zza zza(@Nullable Integer num);

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract zza zza(@Nullable String str);

        @NonNull
        public abstract zza zza(@Nullable List<zzq> list);

        @NonNull
        public abstract zzr zza();

        @NonNull
        public abstract zza zzb(long j);

        @NonNull
        public zza zzb(@NonNull String str) {
            return zza(str);
        }
    }

    @NonNull
    public static zza zza() {
        return new zzk.zza();
    }

    @Nullable
    public abstract zzp zzb();

    @Nullable
    @Encodable.Field(name = "logEvent")
    public abstract List<zzq> zzc();

    @Nullable
    public abstract Integer zzd();

    @Nullable
    public abstract String zze();

    @Nullable
    public abstract zzu zzf();

    public abstract long zzg();

    public abstract long zzh();
}
