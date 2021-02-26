package com.google.firebase.perf.internal;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.p010firebaseperf.zzby;
import com.google.android.gms.internal.p010firebaseperf.zzcx;
import java.net.URI;
import p052cz.msebera.android.httpclient.HttpHost;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzm extends zzs {
    private final Context zzdc;
    private final zzcx zzds;

    zzm(@NonNull zzcx zzcx, Context context) {
        this.zzdc = context;
        this.zzds = zzcx;
    }

    private static boolean zzp(long j) {
        return j >= 0;
    }

    private static boolean zzq(long j) {
        return j >= 0;
    }

    public final boolean zzbx() {
        boolean z;
        if (zzj(this.zzds.getUrl())) {
            String valueOf = String.valueOf(this.zzds.getUrl());
            Log.i("FirebasePerformance", valueOf.length() != 0 ? "URL is missing:".concat(valueOf) : new String("URL is missing:"));
            return false;
        }
        URI zzi = zzi(this.zzds.getUrl());
        if (zzi == null) {
            Log.i("FirebasePerformance", "URL cannot be parsed");
            return false;
        }
        Context context = this.zzdc;
        if (zzi == null) {
            z = false;
        } else {
            z = zzby.zza(zzi, context);
        }
        if (!z) {
            String valueOf2 = String.valueOf(zzi);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 26);
            sb.append("URL fails whitelist rule: ");
            sb.append(valueOf2);
            Log.i("FirebasePerformance", sb.toString());
            return false;
        }
        String host = zzi.getHost();
        if (!(host != null && !zzj(host) && host.length() <= 255)) {
            Log.i("FirebasePerformance", "URL host is null or invalid");
            return false;
        }
        String scheme = zzi.getScheme();
        if (!(scheme != null && (HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)))) {
            Log.i("FirebasePerformance", "URL scheme is null or invalid");
            return false;
        }
        if (!(zzi.getUserInfo() == null)) {
            Log.i("FirebasePerformance", "URL user info is null");
            return false;
        }
        int port = zzi.getPort();
        if (!(port == -1 || port > 0)) {
            Log.i("FirebasePerformance", "URL port is less than or equal to 0");
            return false;
        }
        zzcx.zzc zzej = this.zzds.zzei() ? this.zzds.zzej() : null;
        if (!((zzej == null || zzej == zzcx.zzc.HTTP_METHOD_UNKNOWN) ? false : true)) {
            String valueOf3 = String.valueOf(this.zzds.zzej());
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf3).length() + 32);
            sb2.append("HTTP Method is null or invalid: ");
            sb2.append(valueOf3);
            Log.i("FirebasePerformance", sb2.toString());
            return false;
        }
        if (this.zzds.zzbh()) {
            if (!(this.zzds.zzeo() > 0)) {
                int zzeo = this.zzds.zzeo();
                StringBuilder sb3 = new StringBuilder(49);
                sb3.append("HTTP ResponseCode is a negative value:");
                sb3.append(zzeo);
                Log.i("FirebasePerformance", sb3.toString());
                return false;
            }
        }
        if (this.zzds.zzek() && !zzq(this.zzds.zzel())) {
            long zzel = this.zzds.zzel();
            StringBuilder sb4 = new StringBuilder(56);
            sb4.append("Request Payload is a negative value:");
            sb4.append(zzel);
            Log.i("FirebasePerformance", sb4.toString());
            return false;
        } else if (this.zzds.zzem() && !zzq(this.zzds.zzen())) {
            long zzen = this.zzds.zzen();
            StringBuilder sb5 = new StringBuilder(57);
            sb5.append("Response Payload is a negative value:");
            sb5.append(zzen);
            Log.i("FirebasePerformance", sb5.toString());
            return false;
        } else if (!this.zzds.zzeq() || this.zzds.zzer() <= 0) {
            long zzer = this.zzds.zzer();
            StringBuilder sb6 = new StringBuilder(84);
            sb6.append("Start time of the request is null, or zero, or a negative value:");
            sb6.append(zzer);
            Log.i("FirebasePerformance", sb6.toString());
            return false;
        } else if (this.zzds.zzes() && !zzp(this.zzds.zzet())) {
            long zzet = this.zzds.zzet();
            StringBuilder sb7 = new StringBuilder(69);
            sb7.append("Time to complete the request is a negative value:");
            sb7.append(zzet);
            Log.i("FirebasePerformance", sb7.toString());
            return false;
        } else if (this.zzds.zzeu() && !zzp(this.zzds.zzev())) {
            long zzev = this.zzds.zzev();
            StringBuilder sb8 = new StringBuilder(112);
            sb8.append("Time from the start of the request to the start of the response is null or a negative value:");
            sb8.append(zzev);
            Log.i("FirebasePerformance", sb8.toString());
            return false;
        } else if (!this.zzds.zzew() || this.zzds.zzex() <= 0) {
            long zzex = this.zzds.zzex();
            StringBuilder sb9 = new StringBuilder(108);
            sb9.append("Time from the start of the request to the end of the response is null, negative or zero:");
            sb9.append(zzex);
            Log.i("FirebasePerformance", sb9.toString());
            return false;
        } else if (this.zzds.zzbh()) {
            return true;
        } else {
            Log.i("FirebasePerformance", "Did not receive a HTTP Response Code");
            return false;
        }
    }

    @Nullable
    private static URI zzi(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            return URI.create(str);
        } catch (IllegalArgumentException | IllegalStateException e) {
            Log.w("FirebasePerformance", "getResultUrl throws exception", e);
            return null;
        }
    }

    private static boolean zzj(@Nullable String str) {
        if (str == null) {
            return true;
        }
        return str.trim().isEmpty();
    }
}
