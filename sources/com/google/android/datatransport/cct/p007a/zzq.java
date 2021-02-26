package com.google.android.datatransport.cct.p007a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.p007a.zzi;
import com.google.auto.value.AutoValue;

@AutoValue
/* renamed from: com.google.android.datatransport.cct.a.zzq */
public abstract class zzq {

    @AutoValue.Builder
    /* renamed from: com.google.android.datatransport.cct.a.zzq$zza */
    public static abstract class zza {
        @NonNull
        public abstract zza zza(long j);

        @NonNull
        public abstract zza zza(@Nullable zzt zzt);

        @NonNull
        public abstract zza zza(@Nullable Integer num);

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract zza zza(@Nullable String str);

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract zza zza(@Nullable byte[] bArr);

        @NonNull
        public abstract zzq zza();

        @NonNull
        public abstract zza zzb(long j);

        @NonNull
        public abstract zza zzc(long j);
    }

    @NonNull
    public static zza zza(@NonNull String str) {
        return new zzi.zza().zza(str);
    }

    @Nullable
    public abstract Integer zza();

    public abstract long zzb();

    public abstract long zzc();

    @Nullable
    public abstract zzt zzd();

    @Nullable
    public abstract byte[] zze();

    @Nullable
    public abstract String zzf();

    public abstract long zzg();

    @NonNull
    public static zza zza(@NonNull byte[] bArr) {
        return new zzi.zza().zza(bArr);
    }
}
