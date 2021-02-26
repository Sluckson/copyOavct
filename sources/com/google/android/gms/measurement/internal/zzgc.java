package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzmb;
import com.google.android.gms.internal.measurement.zznr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
public final class zzgc extends zzeo {
    /* access modifiers changed from: private */
    public final zzkp zza;
    private Boolean zzb;
    @Nullable
    private String zzc;

    public zzgc(zzkp zzkp) {
        this(zzkp, (String) null);
    }

    private zzgc(zzkp zzkp, @Nullable String str) {
        Preconditions.checkNotNull(zzkp);
        this.zza = zzkp;
        this.zzc = null;
    }

    @BinderThread
    public final void zzb(zzn zzn) {
        zzb(zzn, false);
        zza((Runnable) new zzge(this, zzn));
    }

    @BinderThread
    public final void zze(zzn zzn) {
        if (zzmb.zzb() && this.zza.zzb().zza(zzat.zzcp)) {
            Preconditions.checkNotEmpty(zzn.zza);
            Preconditions.checkNotNull(zzn.zzw);
            zzgm zzgm = new zzgm(this, zzn);
            Preconditions.checkNotNull(zzgm);
            if (this.zza.zzp().zzf()) {
                zzgm.run();
            } else {
                this.zza.zzp().zzb((Runnable) zzgm);
            }
        }
    }

    @BinderThread
    public final void zza(zzar zzar, zzn zzn) {
        Preconditions.checkNotNull(zzar);
        zzb(zzn, false);
        zza((Runnable) new zzgp(this, zzar, zzn));
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final zzar zzb(zzar zzar, zzn zzn) {
        boolean z = false;
        if (!(!"_cmp".equals(zzar.zza) || zzar.zzb == null || zzar.zzb.zza() == 0)) {
            String zzd = zzar.zzb.zzd("_cis");
            if (!TextUtils.isEmpty(zzd) && (("referrer broadcast".equals(zzd) || "referrer API".equals(zzd)) && this.zza.zzb().zze(zzn.zza, zzat.zzar))) {
                z = true;
            }
        }
        if (!z) {
            return zzar;
        }
        this.zza.zzq().zzu().zza("Event has been filtered ", zzar.toString());
        return new zzar("_cmpx", zzar.zzb, zzar.zzc, zzar.zzd);
    }

    @BinderThread
    public final void zza(zzar zzar, String str, String str2) {
        Preconditions.checkNotNull(zzar);
        Preconditions.checkNotEmpty(str);
        zza(str, true);
        zza((Runnable) new zzgo(this, zzar, str));
    }

    @BinderThread
    public final byte[] zza(zzar zzar, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzar);
        zza(str, true);
        this.zza.zzq().zzv().zza("Log and bundle. event", this.zza.zzj().zza(zzar.zza));
        long nanoTime = this.zza.zzl().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zza.zzp().zzb(new zzgr(this, zzar, str)).get();
            if (bArr == null) {
                this.zza.zzq().zze().zza("Log and bundle returned null. appId", zzex.zza(str));
                bArr = new byte[0];
            }
            this.zza.zzq().zzv().zza("Log and bundle processed. event, size, time_ms", this.zza.zzj().zza(zzar.zza), Integer.valueOf(bArr.length), Long.valueOf((this.zza.zzl().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzq().zze().zza("Failed to log and bundle. appId, event, error", zzex.zza(str), this.zza.zzj().zza(zzar.zza), e);
            return null;
        }
    }

    @BinderThread
    public final void zza(zzkw zzkw, zzn zzn) {
        Preconditions.checkNotNull(zzkw);
        zzb(zzn, false);
        zza((Runnable) new zzgq(this, zzkw, zzn));
    }

    @BinderThread
    public final List<zzkw> zza(zzn zzn, boolean z) {
        zzb(zzn, false);
        try {
            List<zzky> list = (List) this.zza.zzp().zza(new zzgt(this, zzn)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzky zzky : list) {
                if (z || !zzkx.zzd(zzky.zzc)) {
                    arrayList.add(new zzkw(zzky));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzq().zze().zza("Failed to get user properties. appId", zzex.zza(zzn.zza), e);
            return null;
        }
    }

    @BinderThread
    public final void zza(zzn zzn) {
        zzb(zzn, false);
        zza((Runnable) new zzgs(this, zzn));
    }

    @BinderThread
    private final void zzb(zzn zzn, boolean z) {
        Preconditions.checkNotNull(zzn);
        zza(zzn.zza, false);
        this.zza.zzk().zza(zzn.zzb, zzn.zzr, zzn.zzv);
    }

    @BinderThread
    private final void zza(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.zzb == null) {
                        if (!"com.google.android.gms".equals(this.zzc) && !UidVerifier.isGooglePlayServicesUid(this.zza.zzm(), Binder.getCallingUid())) {
                            if (!GoogleSignatureVerifier.getInstance(this.zza.zzm()).isUidGoogleSigned(Binder.getCallingUid())) {
                                z2 = false;
                                this.zzb = Boolean.valueOf(z2);
                            }
                        }
                        z2 = true;
                        this.zzb = Boolean.valueOf(z2);
                    }
                    if (this.zzb.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e) {
                    this.zza.zzq().zze().zza("Measurement Service called with invalid calling package. appId", zzex.zza(str));
                    throw e;
                }
            }
            if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zzm(), Binder.getCallingUid(), str)) {
                this.zzc = str;
            }
            if (!str.equals(this.zzc)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
            return;
        }
        this.zza.zzq().zze().zza("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    @BinderThread
    public final void zza(long j, String str, String str2, String str3) {
        zza((Runnable) new zzgv(this, str2, str3, str, j));
    }

    @BinderThread
    public final void zza(Bundle bundle, zzn zzn) {
        if (zznr.zzb() && this.zza.zzb().zza(zzat.zzch)) {
            zzb(zzn, false);
            zza((Runnable) new zzgf(this, zzn, bundle));
        }
    }

    @BinderThread
    public final String zzc(zzn zzn) {
        zzb(zzn, false);
        return this.zza.zzd(zzn);
    }

    @BinderThread
    public final void zza(zzw zzw, zzn zzn) {
        Preconditions.checkNotNull(zzw);
        Preconditions.checkNotNull(zzw.zzc);
        zzb(zzn, false);
        zzw zzw2 = new zzw(zzw);
        zzw2.zza = zzn.zza;
        zza((Runnable) new zzgh(this, zzw2, zzn));
    }

    @BinderThread
    public final void zza(zzw zzw) {
        Preconditions.checkNotNull(zzw);
        Preconditions.checkNotNull(zzw.zzc);
        zza(zzw.zza, true);
        zza((Runnable) new zzgg(this, new zzw(zzw)));
    }

    @BinderThread
    public final List<zzkw> zza(String str, String str2, boolean z, zzn zzn) {
        zzb(zzn, false);
        try {
            List<zzky> list = (List) this.zza.zzp().zza(new zzgj(this, zzn, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzky zzky : list) {
                if (z || !zzkx.zzd(zzky.zzc)) {
                    arrayList.add(new zzkw(zzky));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzq().zze().zza("Failed to query user properties. appId", zzex.zza(zzn.zza), e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final List<zzkw> zza(String str, String str2, String str3, boolean z) {
        zza(str, true);
        try {
            List<zzky> list = (List) this.zza.zzp().zza(new zzgi(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzky zzky : list) {
                if (z || !zzkx.zzd(zzky.zzc)) {
                    arrayList.add(new zzkw(zzky));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzq().zze().zza("Failed to get user properties as. appId", zzex.zza(str), e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final List<zzw> zza(String str, String str2, zzn zzn) {
        zzb(zzn, false);
        try {
            return (List) this.zza.zzp().zza(new zzgl(this, zzn, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzq().zze().zza("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final List<zzw> zza(String str, String str2, String str3) {
        zza(str, true);
        try {
            return (List) this.zza.zzp().zza(new zzgk(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzq().zze().zza("Failed to get conditional user properties as", e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final void zzd(zzn zzn) {
        zza(zzn.zza, false);
        zza((Runnable) new zzgn(this, zzn));
    }

    @VisibleForTesting
    private final void zza(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzp().zzf()) {
            runnable.run();
        } else {
            this.zza.zzp().zza(runnable);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzn zzn, Bundle bundle) {
        this.zza.zze().zza(zzn.zza, bundle);
    }
}
