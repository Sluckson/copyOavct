package com.google.android.gms.internal.p010firebaseperf;

import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.p010firebaseperf.zzcx;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.internal.GaugeManager;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.internal.zza;
import com.google.firebase.perf.internal.zzc;
import com.google.firebase.perf.internal.zzd;
import com.google.firebase.perf.internal.zzr;
import com.google.firebase.perf.internal.zzw;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzbg */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzbg extends zzc implements zzw {
    private final List<zzr> zzbv;
    private final GaugeManager zzbw;
    private zzd zzbx;
    private final zzcx.zzb zzby;
    private boolean zzbz;
    private boolean zzca;
    private final WeakReference<zzw> zzcb;

    public final void zza(zzr zzr) {
        if (zzr == null) {
            Log.i("FirebasePerformance", "Unable to add new SessionId to the Network Trace. Continuing without it.");
        } else if (this.zzby.zzeq() && !this.zzby.zzew()) {
            this.zzbv.add(zzr);
        }
    }

    public static zzbg zza(@Nullable zzd zzd) {
        return new zzbg(zzd);
    }

    private zzbg(@Nullable zzd zzd) {
        this(zzd, zza.zzbl(), GaugeManager.zzby());
    }

    private zzbg(@Nullable zzd zzd, zza zza, GaugeManager gaugeManager) {
        super(zza);
        this.zzby = zzcx.zzez();
        this.zzcb = new WeakReference<>(this);
        this.zzbx = zzd;
        this.zzbw = gaugeManager;
        this.zzbv = new ArrayList();
        zzbq();
    }

    public final void zzbg() {
        this.zzca = true;
    }

    public final zzbg zzf(@Nullable String str) {
        HttpUrl parse;
        int lastIndexOf;
        if (str != null) {
            HttpUrl parse2 = HttpUrl.parse(str);
            if (parse2 != null) {
                str = parse2.newBuilder().username("").password("").query((String) null).fragment((String) null).toString();
            }
            zzcx.zzb zzb = this.zzby;
            if (str.length() > 2000) {
                if (str.charAt(2000) == '/' || (parse = HttpUrl.parse(str)) == null || parse.encodedPath().lastIndexOf(47) < 0 || (lastIndexOf = str.lastIndexOf(47, 1999)) < 0) {
                    str = str.substring(0, 2000);
                } else {
                    str = str.substring(0, lastIndexOf);
                }
            }
            zzb.zzae(str);
        }
        return this;
    }

    public final zzbg zzg(@Nullable String str) {
        zzcx.zzc zzc;
        if (str != null) {
            String upperCase = str.toUpperCase();
            char c = 65535;
            switch (upperCase.hashCode()) {
                case -531492226:
                    if (upperCase.equals("OPTIONS")) {
                        c = 6;
                        break;
                    }
                    break;
                case 70454:
                    if (upperCase.equals("GET")) {
                        c = 0;
                        break;
                    }
                    break;
                case 79599:
                    if (upperCase.equals("PUT")) {
                        c = 1;
                        break;
                    }
                    break;
                case 2213344:
                    if (upperCase.equals("HEAD")) {
                        c = 4;
                        break;
                    }
                    break;
                case 2461856:
                    if (upperCase.equals("POST")) {
                        c = 2;
                        break;
                    }
                    break;
                case 75900968:
                    if (upperCase.equals("PATCH")) {
                        c = 5;
                        break;
                    }
                    break;
                case 80083237:
                    if (upperCase.equals("TRACE")) {
                        c = 7;
                        break;
                    }
                    break;
                case 1669334218:
                    if (upperCase.equals(FirebasePerformance.HttpMethod.CONNECT)) {
                        c = 8;
                        break;
                    }
                    break;
                case 2012838315:
                    if (upperCase.equals("DELETE")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    zzc = zzcx.zzc.GET;
                    break;
                case 1:
                    zzc = zzcx.zzc.PUT;
                    break;
                case 2:
                    zzc = zzcx.zzc.POST;
                    break;
                case 3:
                    zzc = zzcx.zzc.DELETE;
                    break;
                case 4:
                    zzc = zzcx.zzc.HEAD;
                    break;
                case 5:
                    zzc = zzcx.zzc.PATCH;
                    break;
                case 6:
                    zzc = zzcx.zzc.OPTIONS;
                    break;
                case 7:
                    zzc = zzcx.zzc.TRACE;
                    break;
                case 8:
                    zzc = zzcx.zzc.CONNECT;
                    break;
                default:
                    zzc = zzcx.zzc.HTTP_METHOD_UNKNOWN;
                    break;
            }
            this.zzby.zzb(zzc);
        }
        return this;
    }

    public final zzbg zzb(int i) {
        this.zzby.zzl(i);
        return this;
    }

    public final boolean zzbh() {
        return this.zzby.zzbh();
    }

    public final zzbg zzj(long j) {
        this.zzby.zzah(j);
        return this;
    }

    public final zzbg zza(Map<String, String> map) {
        this.zzby.zzfd().zzc(map);
        return this;
    }

    public final zzbg zzk(long j) {
        zzr zzcn = SessionManager.zzcm().zzcn();
        SessionManager.zzcm().zzc(this.zzcb);
        this.zzby.zzaj(j);
        zza(zzcn);
        if (zzcn.zzcg()) {
            this.zzbw.zzj(zzcn.zzcf());
        }
        return this;
    }

    public final zzbg zzl(long j) {
        this.zzby.zzak(j);
        return this;
    }

    public final zzbg zzm(long j) {
        this.zzby.zzal(j);
        return this;
    }

    public final long zzbi() {
        return this.zzby.zzev();
    }

    public final zzbg zzn(long j) {
        this.zzby.zzam(j);
        if (SessionManager.zzcm().zzcn().zzcg()) {
            this.zzbw.zzj(SessionManager.zzcm().zzcn().zzcf());
        }
        return this;
    }

    public final zzbg zzo(long j) {
        this.zzby.zzai(j);
        return this;
    }

    public final zzbg zzh(@Nullable String str) {
        if (str == null) {
            this.zzby.zzfc();
            return this;
        }
        boolean z = false;
        if (str.length() <= 128) {
            int i = 0;
            while (true) {
                if (i >= str.length()) {
                    z = true;
                    break;
                }
                char charAt = str.charAt(i);
                if (charAt <= 31 || charAt > 127) {
                    break;
                }
                i++;
            }
        }
        if (z) {
            this.zzby.zzaf(str);
        } else {
            String valueOf = String.valueOf(str);
            Log.i("FirebasePerformance", valueOf.length() != 0 ? "The content type of the response is not a valid content-type:".concat(valueOf) : new String("The content type of the response is not a valid content-type:"));
        }
        return this;
    }

    public final zzbg zzbj() {
        this.zzby.zzb(zzcx.zzd.GENERIC_CLIENT_ERROR);
        return this;
    }

    public final zzcx zzbk() {
        SessionManager.zzcm().zzd(this.zzcb);
        zzbr();
        zzde[] zza = zzr.zza(zzj.zza(this.zzbv));
        if (zza != null) {
            this.zzby.zzb((Iterable<? extends zzde>) Arrays.asList(zza));
        }
        zzcx zzcx = (zzcx) ((zzfi) this.zzby.zzhm());
        if (!this.zzbz) {
            zzd zzd = this.zzbx;
            if (zzd != null) {
                zzd.zza(zzcx, zzbn());
            }
            this.zzbz = true;
        } else if (this.zzca) {
            Log.i("FirebasePerformance", "This metric has already been queued for transmission.  Please create a new HttpMetric for each request/response");
        }
        return zzcx;
    }
}
