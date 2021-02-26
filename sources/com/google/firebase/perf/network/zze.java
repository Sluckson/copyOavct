package com.google.firebase.perf.network;

import com.google.android.gms.internal.p010firebaseperf.zzbg;
import com.google.android.gms.internal.p010firebaseperf.zzbw;
import java.io.IOException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zze<T> implements ResponseHandler<T> {
    private final zzbw zzgi;
    private final zzbg zzgp;
    private final ResponseHandler<? extends T> zzgw;

    public zze(ResponseHandler<? extends T> responseHandler, zzbw zzbw, zzbg zzbg) {
        this.zzgw = responseHandler;
        this.zzgi = zzbw;
        this.zzgp = zzbg;
    }

    public final T handleResponse(HttpResponse httpResponse) throws IOException {
        this.zzgp.zzn(this.zzgi.getDurationMicros());
        this.zzgp.zzb(httpResponse.getStatusLine().getStatusCode());
        Long zza = zzg.zza((HttpMessage) httpResponse);
        if (zza != null) {
            this.zzgp.zzo(zza.longValue());
        }
        String zza2 = zzg.zza(httpResponse);
        if (zza2 != null) {
            this.zzgp.zzh(zza2);
        }
        this.zzgp.zzbk();
        return this.zzgw.handleResponse(httpResponse);
    }
}
