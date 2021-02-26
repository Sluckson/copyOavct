package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.android.gms.internal.p010firebaseperf.zzbg;
import com.google.android.gms.internal.p010firebaseperf.zzbw;
import com.google.firebase.perf.internal.zzd;
import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public class FirebasePerfHttpClient {
    private FirebasePerfHttpClient() {
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest) throws IOException {
        return zza(httpClient, httpUriRequest, new zzbw(), zzd.zzbs());
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        return zza(httpClient, httpUriRequest, httpContext, new zzbw(), zzd.zzbs());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler) throws IOException {
        return zza(httpClient, httpUriRequest, responseHandler, new zzbw(), zzd.zzbs());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, HttpContext httpContext) throws IOException {
        return zza(httpClient, httpUriRequest, responseHandler, httpContext, new zzbw(), zzd.zzbs());
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        return zza(httpClient, httpHost, httpRequest, new zzbw(), zzd.zzbs());
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        return zza(httpClient, httpHost, httpRequest, httpContext, new zzbw(), zzd.zzbs());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        return zza(httpClient, httpHost, httpRequest, responseHandler, new zzbw(), zzd.zzbs());
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        return zza(httpClient, httpHost, httpRequest, responseHandler, httpContext, new zzbw(), zzd.zzbs());
    }

    private static HttpResponse zza(HttpClient httpClient, HttpUriRequest httpUriRequest, zzbw zzbw, zzd zzd) throws IOException {
        zzbg zza = zzbg.zza(zzd);
        try {
            zza.zzf(httpUriRequest.getURI().toString()).zzg(httpUriRequest.getMethod());
            Long zza2 = zzg.zza((HttpMessage) httpUriRequest);
            if (zza2 != null) {
                zza.zzj(zza2.longValue());
            }
            zzbw.reset();
            zza.zzk(zzbw.zzdb());
            HttpResponse execute = httpClient.execute(httpUriRequest);
            zza.zzn(zzbw.getDurationMicros());
            zza.zzb(execute.getStatusLine().getStatusCode());
            Long zza3 = zzg.zza((HttpMessage) execute);
            if (zza3 != null) {
                zza.zzo(zza3.longValue());
            }
            String zza4 = zzg.zza(execute);
            if (zza4 != null) {
                zza.zzh(zza4);
            }
            zza.zzbk();
            return execute;
        } catch (IOException e) {
            zza.zzn(zzbw.getDurationMicros());
            zzg.zza(zza);
            throw e;
        }
    }

    private static HttpResponse zza(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext, zzbw zzbw, zzd zzd) throws IOException {
        zzbg zza = zzbg.zza(zzd);
        try {
            zza.zzf(httpUriRequest.getURI().toString()).zzg(httpUriRequest.getMethod());
            Long zza2 = zzg.zza((HttpMessage) httpUriRequest);
            if (zza2 != null) {
                zza.zzj(zza2.longValue());
            }
            zzbw.reset();
            zza.zzk(zzbw.zzdb());
            HttpResponse execute = httpClient.execute(httpUriRequest, httpContext);
            zza.zzn(zzbw.getDurationMicros());
            zza.zzb(execute.getStatusLine().getStatusCode());
            Long zza3 = zzg.zza((HttpMessage) execute);
            if (zza3 != null) {
                zza.zzo(zza3.longValue());
            }
            String zza4 = zzg.zza(execute);
            if (zza4 != null) {
                zza.zzh(zza4);
            }
            zza.zzbk();
            return execute;
        } catch (IOException e) {
            zza.zzn(zzbw.getDurationMicros());
            zzg.zza(zza);
            throw e;
        }
    }

    private static <T> T zza(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, zzbw zzbw, zzd zzd) throws IOException {
        zzbg zza = zzbg.zza(zzd);
        try {
            zza.zzf(httpUriRequest.getURI().toString()).zzg(httpUriRequest.getMethod());
            Long zza2 = zzg.zza((HttpMessage) httpUriRequest);
            if (zza2 != null) {
                zza.zzj(zza2.longValue());
            }
            zzbw.reset();
            zza.zzk(zzbw.zzdb());
            return httpClient.execute(httpUriRequest, new zze(responseHandler, zzbw, zza));
        } catch (IOException e) {
            zza.zzn(zzbw.getDurationMicros());
            zzg.zza(zza);
            throw e;
        }
    }

    private static <T> T zza(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, HttpContext httpContext, zzbw zzbw, zzd zzd) throws IOException {
        zzbg zza = zzbg.zza(zzd);
        try {
            zza.zzf(httpUriRequest.getURI().toString()).zzg(httpUriRequest.getMethod());
            Long zza2 = zzg.zza((HttpMessage) httpUriRequest);
            if (zza2 != null) {
                zza.zzj(zza2.longValue());
            }
            zzbw.reset();
            zza.zzk(zzbw.zzdb());
            return httpClient.execute(httpUriRequest, new zze(responseHandler, zzbw, zza), httpContext);
        } catch (IOException e) {
            zza.zzn(zzbw.getDurationMicros());
            zzg.zza(zza);
            throw e;
        }
    }

    private static HttpResponse zza(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, zzbw zzbw, zzd zzd) throws IOException {
        zzbg zza = zzbg.zza(zzd);
        try {
            String valueOf = String.valueOf(httpHost.toURI());
            String valueOf2 = String.valueOf(httpRequest.getRequestLine().getUri());
            zza.zzf(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).zzg(httpRequest.getRequestLine().getMethod());
            Long zza2 = zzg.zza((HttpMessage) httpRequest);
            if (zza2 != null) {
                zza.zzj(zza2.longValue());
            }
            zzbw.reset();
            zza.zzk(zzbw.zzdb());
            HttpResponse execute = httpClient.execute(httpHost, httpRequest);
            zza.zzn(zzbw.getDurationMicros());
            zza.zzb(execute.getStatusLine().getStatusCode());
            Long zza3 = zzg.zza((HttpMessage) execute);
            if (zza3 != null) {
                zza.zzo(zza3.longValue());
            }
            String zza4 = zzg.zza(execute);
            if (zza4 != null) {
                zza.zzh(zza4);
            }
            zza.zzbk();
            return execute;
        } catch (IOException e) {
            zza.zzn(zzbw.getDurationMicros());
            zzg.zza(zza);
            throw e;
        }
    }

    private static HttpResponse zza(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext, zzbw zzbw, zzd zzd) throws IOException {
        zzbg zza = zzbg.zza(zzd);
        try {
            String valueOf = String.valueOf(httpHost.toURI());
            String valueOf2 = String.valueOf(httpRequest.getRequestLine().getUri());
            zza.zzf(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).zzg(httpRequest.getRequestLine().getMethod());
            Long zza2 = zzg.zza((HttpMessage) httpRequest);
            if (zza2 != null) {
                zza.zzj(zza2.longValue());
            }
            zzbw.reset();
            zza.zzk(zzbw.zzdb());
            HttpResponse execute = httpClient.execute(httpHost, httpRequest, httpContext);
            zza.zzn(zzbw.getDurationMicros());
            zza.zzb(execute.getStatusLine().getStatusCode());
            Long zza3 = zzg.zza((HttpMessage) execute);
            if (zza3 != null) {
                zza.zzo(zza3.longValue());
            }
            String zza4 = zzg.zza(execute);
            if (zza4 != null) {
                zza.zzh(zza4);
            }
            zza.zzbk();
            return execute;
        } catch (IOException e) {
            zza.zzn(zzbw.getDurationMicros());
            zzg.zza(zza);
            throw e;
        }
    }

    private static <T> T zza(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, zzbw zzbw, zzd zzd) throws IOException {
        zzbg zza = zzbg.zza(zzd);
        try {
            String valueOf = String.valueOf(httpHost.toURI());
            String valueOf2 = String.valueOf(httpRequest.getRequestLine().getUri());
            zza.zzf(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).zzg(httpRequest.getRequestLine().getMethod());
            Long zza2 = zzg.zza((HttpMessage) httpRequest);
            if (zza2 != null) {
                zza.zzj(zza2.longValue());
            }
            zzbw.reset();
            zza.zzk(zzbw.zzdb());
            return httpClient.execute(httpHost, httpRequest, new zze(responseHandler, zzbw, zza));
        } catch (IOException e) {
            zza.zzn(zzbw.getDurationMicros());
            zzg.zza(zza);
            throw e;
        }
    }

    private static <T> T zza(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext, zzbw zzbw, zzd zzd) throws IOException {
        zzbg zza = zzbg.zza(zzd);
        try {
            String valueOf = String.valueOf(httpHost.toURI());
            String valueOf2 = String.valueOf(httpRequest.getRequestLine().getUri());
            zza.zzf(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).zzg(httpRequest.getRequestLine().getMethod());
            Long zza2 = zzg.zza((HttpMessage) httpRequest);
            if (zza2 != null) {
                zza.zzj(zza2.longValue());
            }
            zzbw.reset();
            zza.zzk(zzbw.zzdb());
            return httpClient.execute(httpHost, httpRequest, new zze(responseHandler, zzbw, zza), httpContext);
        } catch (IOException e) {
            zza.zzn(zzbw.getDurationMicros());
            zzg.zza(zza);
            throw e;
        }
    }
}
