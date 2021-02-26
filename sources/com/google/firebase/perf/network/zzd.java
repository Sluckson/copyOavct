package com.google.firebase.perf.network;

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
public final class zzd extends HttpURLConnection {
    private final zzf zzgu;

    zzd(HttpURLConnection httpURLConnection, zzbw zzbw, zzbg zzbg) {
        super(httpURLConnection.getURL());
        this.zzgu = new zzf(httpURLConnection, zzbw, zzbg);
    }

    public final void connect() throws IOException {
        this.zzgu.connect();
    }

    public final void disconnect() {
        this.zzgu.disconnect();
    }

    public final Object getContent() throws IOException {
        return this.zzgu.getContent();
    }

    public final Object getContent(Class[] clsArr) throws IOException {
        return this.zzgu.getContent(clsArr);
    }

    public final InputStream getInputStream() throws IOException {
        return this.zzgu.getInputStream();
    }

    public final long getLastModified() {
        return this.zzgu.getLastModified();
    }

    public final OutputStream getOutputStream() throws IOException {
        return this.zzgu.getOutputStream();
    }

    public final Permission getPermission() throws IOException {
        return this.zzgu.getPermission();
    }

    public final int getResponseCode() throws IOException {
        return this.zzgu.getResponseCode();
    }

    public final String getResponseMessage() throws IOException {
        return this.zzgu.getResponseMessage();
    }

    public final long getExpiration() {
        return this.zzgu.getExpiration();
    }

    public final String getHeaderField(int i) {
        return this.zzgu.getHeaderField(i);
    }

    public final String getHeaderField(String str) {
        return this.zzgu.getHeaderField(str);
    }

    public final long getHeaderFieldDate(String str, long j) {
        return this.zzgu.getHeaderFieldDate(str, j);
    }

    public final int getHeaderFieldInt(String str, int i) {
        return this.zzgu.getHeaderFieldInt(str, i);
    }

    public final long getHeaderFieldLong(String str, long j) {
        return this.zzgu.getHeaderFieldLong(str, j);
    }

    public final String getHeaderFieldKey(int i) {
        return this.zzgu.getHeaderFieldKey(i);
    }

    public final Map<String, List<String>> getHeaderFields() {
        return this.zzgu.getHeaderFields();
    }

    public final String getContentEncoding() {
        return this.zzgu.getContentEncoding();
    }

    public final int getContentLength() {
        return this.zzgu.getContentLength();
    }

    public final long getContentLengthLong() {
        return this.zzgu.getContentLengthLong();
    }

    public final String getContentType() {
        return this.zzgu.getContentType();
    }

    public final long getDate() {
        return this.zzgu.getDate();
    }

    public final void addRequestProperty(String str, String str2) {
        this.zzgu.addRequestProperty(str, str2);
    }

    public final boolean equals(Object obj) {
        return this.zzgu.equals(obj);
    }

    public final boolean getAllowUserInteraction() {
        return this.zzgu.getAllowUserInteraction();
    }

    public final int getConnectTimeout() {
        return this.zzgu.getConnectTimeout();
    }

    public final boolean getDefaultUseCaches() {
        return this.zzgu.getDefaultUseCaches();
    }

    public final boolean getDoInput() {
        return this.zzgu.getDoInput();
    }

    public final boolean getDoOutput() {
        return this.zzgu.getDoOutput();
    }

    public final InputStream getErrorStream() {
        return this.zzgu.getErrorStream();
    }

    public final long getIfModifiedSince() {
        return this.zzgu.getIfModifiedSince();
    }

    public final boolean getInstanceFollowRedirects() {
        return this.zzgu.getInstanceFollowRedirects();
    }

    public final int getReadTimeout() {
        return this.zzgu.getReadTimeout();
    }

    public final String getRequestMethod() {
        return this.zzgu.getRequestMethod();
    }

    public final Map<String, List<String>> getRequestProperties() {
        return this.zzgu.getRequestProperties();
    }

    public final String getRequestProperty(String str) {
        return this.zzgu.getRequestProperty(str);
    }

    public final URL getURL() {
        return this.zzgu.getURL();
    }

    public final boolean getUseCaches() {
        return this.zzgu.getUseCaches();
    }

    public final int hashCode() {
        return this.zzgu.hashCode();
    }

    public final void setAllowUserInteraction(boolean z) {
        this.zzgu.setAllowUserInteraction(z);
    }

    public final void setChunkedStreamingMode(int i) {
        this.zzgu.setChunkedStreamingMode(i);
    }

    public final void setConnectTimeout(int i) {
        this.zzgu.setConnectTimeout(i);
    }

    public final void setDefaultUseCaches(boolean z) {
        this.zzgu.setDefaultUseCaches(z);
    }

    public final void setDoInput(boolean z) {
        this.zzgu.setDoInput(z);
    }

    public final void setDoOutput(boolean z) {
        this.zzgu.setDoOutput(z);
    }

    public final void setFixedLengthStreamingMode(int i) {
        this.zzgu.setFixedLengthStreamingMode(i);
    }

    public final void setFixedLengthStreamingMode(long j) {
        this.zzgu.setFixedLengthStreamingMode(j);
    }

    public final void setIfModifiedSince(long j) {
        this.zzgu.setIfModifiedSince(j);
    }

    public final void setInstanceFollowRedirects(boolean z) {
        this.zzgu.setInstanceFollowRedirects(z);
    }

    public final void setReadTimeout(int i) {
        this.zzgu.setReadTimeout(i);
    }

    public final void setRequestMethod(String str) throws ProtocolException {
        this.zzgu.setRequestMethod(str);
    }

    public final void setRequestProperty(String str, String str2) {
        this.zzgu.setRequestProperty(str, str2);
    }

    public final void setUseCaches(boolean z) {
        this.zzgu.setUseCaches(z);
    }

    public final String toString() {
        return this.zzgu.toString();
    }

    public final boolean usingProxy() {
        return this.zzgu.usingProxy();
    }
}
