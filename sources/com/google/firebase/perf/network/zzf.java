package com.google.firebase.perf.network;

import android.util.Log;
import com.google.android.gms.internal.p010firebaseperf.zzbg;
import com.google.android.gms.internal.p010firebaseperf.zzbw;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzf {
    private final zzbw zzgi;
    private final zzbg zzgp;
    private long zzgs = -1;
    private final HttpURLConnection zzgx;
    private long zzgy = -1;

    public zzf(HttpURLConnection httpURLConnection, zzbw zzbw, zzbg zzbg) {
        this.zzgx = httpURLConnection;
        this.zzgp = zzbg;
        this.zzgi = zzbw;
        this.zzgp.zzf(this.zzgx.getURL().toString());
    }

    public final void connect() throws IOException {
        if (this.zzgy == -1) {
            this.zzgi.reset();
            this.zzgy = this.zzgi.zzdb();
            this.zzgp.zzk(this.zzgy);
        }
        try {
            this.zzgx.connect();
        } catch (IOException e) {
            this.zzgp.zzn(this.zzgi.getDurationMicros());
            zzg.zza(this.zzgp);
            throw e;
        }
    }

    public final void disconnect() {
        this.zzgp.zzn(this.zzgi.getDurationMicros());
        this.zzgp.zzbk();
        this.zzgx.disconnect();
    }

    public final Object getContent() throws IOException {
        zzcy();
        this.zzgp.zzb(this.zzgx.getResponseCode());
        try {
            Object content = this.zzgx.getContent();
            if (content instanceof InputStream) {
                this.zzgp.zzh(this.zzgx.getContentType());
                return new zzb((InputStream) content, this.zzgp, this.zzgi);
            }
            this.zzgp.zzh(this.zzgx.getContentType());
            this.zzgp.zzo((long) this.zzgx.getContentLength());
            this.zzgp.zzn(this.zzgi.getDurationMicros());
            this.zzgp.zzbk();
            return content;
        } catch (IOException e) {
            this.zzgp.zzn(this.zzgi.getDurationMicros());
            zzg.zza(this.zzgp);
            throw e;
        }
    }

    public final Object getContent(Class[] clsArr) throws IOException {
        zzcy();
        this.zzgp.zzb(this.zzgx.getResponseCode());
        try {
            Object content = this.zzgx.getContent(clsArr);
            if (content instanceof InputStream) {
                this.zzgp.zzh(this.zzgx.getContentType());
                return new zzb((InputStream) content, this.zzgp, this.zzgi);
            }
            this.zzgp.zzh(this.zzgx.getContentType());
            this.zzgp.zzo((long) this.zzgx.getContentLength());
            this.zzgp.zzn(this.zzgi.getDurationMicros());
            this.zzgp.zzbk();
            return content;
        } catch (IOException e) {
            this.zzgp.zzn(this.zzgi.getDurationMicros());
            zzg.zza(this.zzgp);
            throw e;
        }
    }

    public final InputStream getInputStream() throws IOException {
        zzcy();
        this.zzgp.zzb(this.zzgx.getResponseCode());
        this.zzgp.zzh(this.zzgx.getContentType());
        try {
            return new zzb(this.zzgx.getInputStream(), this.zzgp, this.zzgi);
        } catch (IOException e) {
            this.zzgp.zzn(this.zzgi.getDurationMicros());
            zzg.zza(this.zzgp);
            throw e;
        }
    }

    public final long getLastModified() {
        zzcy();
        return this.zzgx.getLastModified();
    }

    public final OutputStream getOutputStream() throws IOException {
        try {
            return new zza(this.zzgx.getOutputStream(), this.zzgp, this.zzgi);
        } catch (IOException e) {
            this.zzgp.zzn(this.zzgi.getDurationMicros());
            zzg.zza(this.zzgp);
            throw e;
        }
    }

    public final Permission getPermission() throws IOException {
        try {
            return this.zzgx.getPermission();
        } catch (IOException e) {
            this.zzgp.zzn(this.zzgi.getDurationMicros());
            zzg.zza(this.zzgp);
            throw e;
        }
    }

    public final int getResponseCode() throws IOException {
        zzcy();
        if (this.zzgs == -1) {
            this.zzgs = this.zzgi.getDurationMicros();
            this.zzgp.zzm(this.zzgs);
        }
        try {
            int responseCode = this.zzgx.getResponseCode();
            this.zzgp.zzb(responseCode);
            return responseCode;
        } catch (IOException e) {
            this.zzgp.zzn(this.zzgi.getDurationMicros());
            zzg.zza(this.zzgp);
            throw e;
        }
    }

    public final String getResponseMessage() throws IOException {
        zzcy();
        if (this.zzgs == -1) {
            this.zzgs = this.zzgi.getDurationMicros();
            this.zzgp.zzm(this.zzgs);
        }
        try {
            String responseMessage = this.zzgx.getResponseMessage();
            this.zzgp.zzb(this.zzgx.getResponseCode());
            return responseMessage;
        } catch (IOException e) {
            this.zzgp.zzn(this.zzgi.getDurationMicros());
            zzg.zza(this.zzgp);
            throw e;
        }
    }

    public final long getExpiration() {
        zzcy();
        return this.zzgx.getExpiration();
    }

    public final String getHeaderField(int i) {
        zzcy();
        return this.zzgx.getHeaderField(i);
    }

    public final String getHeaderField(String str) {
        zzcy();
        return this.zzgx.getHeaderField(str);
    }

    public final long getHeaderFieldDate(String str, long j) {
        zzcy();
        return this.zzgx.getHeaderFieldDate(str, j);
    }

    public final int getHeaderFieldInt(String str, int i) {
        zzcy();
        return this.zzgx.getHeaderFieldInt(str, i);
    }

    public final long getHeaderFieldLong(String str, long j) {
        zzcy();
        return this.zzgx.getHeaderFieldLong(str, j);
    }

    public final String getHeaderFieldKey(int i) {
        zzcy();
        return this.zzgx.getHeaderFieldKey(i);
    }

    public final Map<String, List<String>> getHeaderFields() {
        zzcy();
        return this.zzgx.getHeaderFields();
    }

    public final String getContentEncoding() {
        zzcy();
        return this.zzgx.getContentEncoding();
    }

    public final int getContentLength() {
        zzcy();
        return this.zzgx.getContentLength();
    }

    public final long getContentLengthLong() {
        zzcy();
        return this.zzgx.getContentLengthLong();
    }

    public final String getContentType() {
        zzcy();
        return this.zzgx.getContentType();
    }

    public final long getDate() {
        zzcy();
        return this.zzgx.getDate();
    }

    public final void addRequestProperty(String str, String str2) {
        this.zzgx.addRequestProperty(str, str2);
    }

    public final boolean equals(Object obj) {
        return this.zzgx.equals(obj);
    }

    public final boolean getAllowUserInteraction() {
        return this.zzgx.getAllowUserInteraction();
    }

    public final int getConnectTimeout() {
        return this.zzgx.getConnectTimeout();
    }

    public final boolean getDefaultUseCaches() {
        return this.zzgx.getDefaultUseCaches();
    }

    public final boolean getDoInput() {
        return this.zzgx.getDoInput();
    }

    public final boolean getDoOutput() {
        return this.zzgx.getDoOutput();
    }

    public final InputStream getErrorStream() {
        zzcy();
        try {
            this.zzgp.zzb(this.zzgx.getResponseCode());
        } catch (IOException unused) {
            Log.d("FirebasePerformance", "IOException thrown trying to obtain the response code");
        }
        InputStream errorStream = this.zzgx.getErrorStream();
        return errorStream != null ? new zzb(errorStream, this.zzgp, this.zzgi) : errorStream;
    }

    public final long getIfModifiedSince() {
        return this.zzgx.getIfModifiedSince();
    }

    public final boolean getInstanceFollowRedirects() {
        return this.zzgx.getInstanceFollowRedirects();
    }

    public final int getReadTimeout() {
        return this.zzgx.getReadTimeout();
    }

    public final String getRequestMethod() {
        return this.zzgx.getRequestMethod();
    }

    public final Map<String, List<String>> getRequestProperties() {
        return this.zzgx.getRequestProperties();
    }

    public final String getRequestProperty(String str) {
        return this.zzgx.getRequestProperty(str);
    }

    public final URL getURL() {
        return this.zzgx.getURL();
    }

    public final boolean getUseCaches() {
        return this.zzgx.getUseCaches();
    }

    public final int hashCode() {
        return this.zzgx.hashCode();
    }

    public final void setAllowUserInteraction(boolean z) {
        this.zzgx.setAllowUserInteraction(z);
    }

    public final void setChunkedStreamingMode(int i) {
        this.zzgx.setChunkedStreamingMode(i);
    }

    public final void setConnectTimeout(int i) {
        this.zzgx.setConnectTimeout(i);
    }

    public final void setDefaultUseCaches(boolean z) {
        this.zzgx.setDefaultUseCaches(z);
    }

    public final void setDoInput(boolean z) {
        this.zzgx.setDoInput(z);
    }

    public final void setDoOutput(boolean z) {
        this.zzgx.setDoOutput(z);
    }

    public final void setFixedLengthStreamingMode(int i) {
        this.zzgx.setFixedLengthStreamingMode(i);
    }

    public final void setFixedLengthStreamingMode(long j) {
        this.zzgx.setFixedLengthStreamingMode(j);
    }

    public final void setIfModifiedSince(long j) {
        this.zzgx.setIfModifiedSince(j);
    }

    public final void setInstanceFollowRedirects(boolean z) {
        this.zzgx.setInstanceFollowRedirects(z);
    }

    public final void setReadTimeout(int i) {
        this.zzgx.setReadTimeout(i);
    }

    public final void setRequestMethod(String str) throws ProtocolException {
        this.zzgx.setRequestMethod(str);
    }

    public final void setRequestProperty(String str, String str2) {
        this.zzgx.setRequestProperty(str, str2);
    }

    public final void setUseCaches(boolean z) {
        this.zzgx.setUseCaches(z);
    }

    public final String toString() {
        return this.zzgx.toString();
    }

    public final boolean usingProxy() {
        return this.zzgx.usingProxy();
    }

    private final void zzcy() {
        if (this.zzgy == -1) {
            this.zzgi.reset();
            this.zzgy = this.zzgi.zzdb();
            this.zzgp.zzk(this.zzgy);
        }
        String requestMethod = this.zzgx.getRequestMethod();
        if (requestMethod != null) {
            this.zzgp.zzg(requestMethod);
        } else if (this.zzgx.getDoOutput()) {
            this.zzgp.zzg("POST");
        } else {
            this.zzgp.zzg("GET");
        }
    }
}
