package com.google.firebase.perf.network;

import com.google.android.gms.internal.p010firebaseperf.zzbg;
import com.google.android.gms.internal.p010firebaseperf.zzbw;
import com.google.firebase.perf.internal.zzd;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzh implements Callback {
    private final zzbw zzgi;
    private final zzbg zzgp;
    private final Callback zzgz;
    private final long zzha;

    public zzh(Callback callback, zzd zzd, zzbw zzbw, long j) {
        this.zzgz = callback;
        this.zzgp = zzbg.zza(zzd);
        this.zzha = j;
        this.zzgi = zzbw;
    }

    public final void onFailure(Call call, IOException iOException) {
        Request request = call.request();
        if (request != null) {
            HttpUrl url = request.url();
            if (url != null) {
                this.zzgp.zzf(url.url().toString());
            }
            if (request.method() != null) {
                this.zzgp.zzg(request.method());
            }
        }
        this.zzgp.zzk(this.zzha);
        this.zzgp.zzn(this.zzgi.getDurationMicros());
        zzg.zza(this.zzgp);
        this.zzgz.onFailure(call, iOException);
    }

    public final void onResponse(Call call, Response response) throws IOException {
        Response response2 = response;
        FirebasePerfOkHttpClient.zza(response2, this.zzgp, this.zzha, this.zzgi.getDurationMicros());
        this.zzgz.onResponse(call, response);
    }
}
