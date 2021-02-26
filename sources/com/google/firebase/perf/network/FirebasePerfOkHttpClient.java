package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.android.gms.internal.p010firebaseperf.zzbg;
import com.google.android.gms.internal.p010firebaseperf.zzbw;
import com.google.firebase.perf.internal.zzd;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public class FirebasePerfOkHttpClient {
    private FirebasePerfOkHttpClient() {
    }

    @Keep
    public static Response execute(Call call) throws IOException {
        zzbg zza = zzbg.zza(zzd.zzbs());
        zzbw zzbw = new zzbw();
        long zzdb = zzbw.zzdb();
        try {
            Response execute = call.execute();
            zza(execute, zza, zzdb, zzbw.getDurationMicros());
            return execute;
        } catch (IOException e) {
            Request request = call.request();
            if (request != null) {
                HttpUrl url = request.url();
                if (url != null) {
                    zza.zzf(url.url().toString());
                }
                if (request.method() != null) {
                    zza.zzg(request.method());
                }
            }
            zza.zzk(zzdb);
            zza.zzn(zzbw.getDurationMicros());
            zzg.zza(zza);
            throw e;
        }
    }

    @Keep
    public static void enqueue(Call call, Callback callback) {
        zzbw zzbw = new zzbw();
        Callback callback2 = callback;
        call.enqueue(new zzh(callback2, zzd.zzbs(), zzbw, zzbw.zzdb()));
    }

    static void zza(Response response, zzbg zzbg, long j, long j2) throws IOException {
        Request request = response.request();
        if (request != null) {
            zzbg.zzf(request.url().url().toString());
            zzbg.zzg(request.method());
            if (request.body() != null) {
                long contentLength = request.body().contentLength();
                if (contentLength != -1) {
                    zzbg.zzj(contentLength);
                }
            }
            ResponseBody body = response.body();
            if (body != null) {
                long contentLength2 = body.contentLength();
                if (contentLength2 != -1) {
                    zzbg.zzo(contentLength2);
                }
                MediaType contentType = body.contentType();
                if (contentType != null) {
                    zzbg.zzh(contentType.toString());
                }
            }
            zzbg.zzb(response.code());
            zzbg.zzk(j);
            zzbg.zzn(j2);
            zzbg.zzbk();
        }
    }
}
