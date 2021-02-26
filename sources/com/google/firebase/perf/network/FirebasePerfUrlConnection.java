package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.android.gms.internal.p010firebaseperf.zzbg;
import com.google.android.gms.internal.p010firebaseperf.zzbw;
import com.google.android.gms.internal.p010firebaseperf.zzbx;
import com.google.firebase.perf.internal.zzd;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public class FirebasePerfUrlConnection {
    private FirebasePerfUrlConnection() {
    }

    @Keep
    public static InputStream openStream(URL url) throws IOException {
        return zza(new zzbx(url), zzd.zzbs(), new zzbw());
    }

    private static InputStream zza(zzbx zzbx, zzd zzd, zzbw zzbw) throws IOException {
        zzbw.reset();
        long zzdb = zzbw.zzdb();
        zzbg zza = zzbg.zza(zzd);
        try {
            URLConnection openConnection = zzbx.openConnection();
            if (openConnection instanceof HttpsURLConnection) {
                return new zzc((HttpsURLConnection) openConnection, zzbw, zza).getInputStream();
            }
            if (openConnection instanceof HttpURLConnection) {
                return new zzd((HttpURLConnection) openConnection, zzbw, zza).getInputStream();
            }
            return openConnection.getInputStream();
        } catch (IOException e) {
            zza.zzk(zzdb);
            zza.zzn(zzbw.getDurationMicros());
            zza.zzf(zzbx.toString());
            zzg.zza(zza);
            throw e;
        }
    }

    @Keep
    public static Object getContent(URL url) throws IOException {
        return zzb(new zzbx(url), zzd.zzbs(), new zzbw());
    }

    @Keep
    public static Object getContent(URL url, Class[] clsArr) throws IOException {
        return zza(new zzbx(url), clsArr, zzd.zzbs(), new zzbw());
    }

    private static Object zzb(zzbx zzbx, zzd zzd, zzbw zzbw) throws IOException {
        zzbw.reset();
        long zzdb = zzbw.zzdb();
        zzbg zza = zzbg.zza(zzd);
        try {
            URLConnection openConnection = zzbx.openConnection();
            if (openConnection instanceof HttpsURLConnection) {
                return new zzc((HttpsURLConnection) openConnection, zzbw, zza).getContent();
            }
            if (openConnection instanceof HttpURLConnection) {
                return new zzd((HttpURLConnection) openConnection, zzbw, zza).getContent();
            }
            return openConnection.getContent();
        } catch (IOException e) {
            zza.zzk(zzdb);
            zza.zzn(zzbw.getDurationMicros());
            zza.zzf(zzbx.toString());
            zzg.zza(zza);
            throw e;
        }
    }

    private static Object zza(zzbx zzbx, Class[] clsArr, zzd zzd, zzbw zzbw) throws IOException {
        zzbw.reset();
        long zzdb = zzbw.zzdb();
        zzbg zza = zzbg.zza(zzd);
        try {
            URLConnection openConnection = zzbx.openConnection();
            if (openConnection instanceof HttpsURLConnection) {
                return new zzc((HttpsURLConnection) openConnection, zzbw, zza).getContent(clsArr);
            }
            if (openConnection instanceof HttpURLConnection) {
                return new zzd((HttpURLConnection) openConnection, zzbw, zza).getContent(clsArr);
            }
            return openConnection.getContent(clsArr);
        } catch (IOException e) {
            zza.zzk(zzdb);
            zza.zzn(zzbw.getDurationMicros());
            zza.zzf(zzbx.toString());
            zzg.zza(zza);
            throw e;
        }
    }

    @Keep
    public static Object instrument(Object obj) throws IOException {
        if (obj instanceof HttpsURLConnection) {
            return new zzc((HttpsURLConnection) obj, new zzbw(), zzbg.zza(zzd.zzbs()));
        }
        return obj instanceof HttpURLConnection ? new zzd((HttpURLConnection) obj, new zzbw(), zzbg.zza(zzd.zzbs())) : obj;
    }
}
