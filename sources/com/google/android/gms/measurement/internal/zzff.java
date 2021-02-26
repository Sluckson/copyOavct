package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import java.util.Map;

@WorkerThread
/* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
final class zzff implements Runnable {
    private final zzfc zza;
    private final int zzb;
    private final Throwable zzc;
    private final byte[] zzd;
    private final String zze;
    private final Map<String, List<String>> zzf;

    private zzff(String str, zzfc zzfc, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        Preconditions.checkNotNull(zzfc);
        this.zza = zzfc;
        this.zzb = i;
        this.zzc = th;
        this.zzd = bArr;
        this.zze = str;
        this.zzf = map;
    }

    public final void run() {
        this.zza.zza(this.zze, this.zzb, this.zzc, this.zzd, this.zzf);
    }
}
