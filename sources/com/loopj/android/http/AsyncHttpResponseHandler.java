package com.loopj.android.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URI;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.StatusLine;
import p052cz.msebera.android.httpclient.client.HttpResponseException;

public abstract class AsyncHttpResponseHandler implements ResponseHandlerInterface {
    protected static final int BUFFER_SIZE = 4096;
    protected static final int CANCEL_MESSAGE = 6;
    public static final String DEFAULT_CHARSET = "UTF-8";
    protected static final int FAILURE_MESSAGE = 1;
    protected static final int FINISH_MESSAGE = 3;
    private static final String LOG_TAG = "AsyncHttpRH";
    protected static final int PROGRESS_MESSAGE = 4;
    protected static final int RETRY_MESSAGE = 5;
    protected static final int START_MESSAGE = 2;
    protected static final int SUCCESS_MESSAGE = 0;
    public static final String UTF8_BOM = "﻿";
    private WeakReference<Object> TAG;
    private Handler handler;
    private Looper looper;
    private Header[] requestHeaders;
    private URI requestURI;
    private String responseCharset;
    private boolean usePoolThread;
    private boolean useSynchronousMode;

    public abstract void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th);

    public void onFinish() {
    }

    public void onPostProcessResponse(ResponseHandlerInterface responseHandlerInterface, HttpResponse httpResponse) {
    }

    public void onPreProcessResponse(ResponseHandlerInterface responseHandlerInterface, HttpResponse httpResponse) {
    }

    public void onStart() {
    }

    public abstract void onSuccess(int i, Header[] headerArr, byte[] bArr);

    public AsyncHttpResponseHandler() {
        this((Looper) null);
    }

    public AsyncHttpResponseHandler(Looper looper2) {
        this.responseCharset = "UTF-8";
        this.requestURI = null;
        this.requestHeaders = null;
        this.looper = null;
        this.TAG = new WeakReference<>((Object) null);
        this.looper = looper2 == null ? Looper.myLooper() : looper2;
        setUseSynchronousMode(false);
        setUsePoolThread(false);
    }

    public AsyncHttpResponseHandler(boolean z) {
        this.responseCharset = "UTF-8";
        this.requestURI = null;
        this.requestHeaders = null;
        this.looper = null;
        this.TAG = new WeakReference<>((Object) null);
        setUsePoolThread(z);
        if (!getUsePoolThread()) {
            this.looper = Looper.myLooper();
            setUseSynchronousMode(false);
        }
    }

    public Object getTag() {
        return this.TAG.get();
    }

    public void setTag(Object obj) {
        this.TAG = new WeakReference<>(obj);
    }

    public URI getRequestURI() {
        return this.requestURI;
    }

    public void setRequestURI(URI uri) {
        this.requestURI = uri;
    }

    public Header[] getRequestHeaders() {
        return this.requestHeaders;
    }

    public void setRequestHeaders(Header[] headerArr) {
        this.requestHeaders = headerArr;
    }

    public boolean getUseSynchronousMode() {
        return this.useSynchronousMode;
    }

    public void setUseSynchronousMode(boolean z) {
        if (!z && this.looper == null) {
            z = true;
            AsyncHttpClient.log.mo51349w(LOG_TAG, "Current thread has not called Looper.prepare(). Forcing synchronous mode.");
        }
        if (!z && this.handler == null) {
            this.handler = new ResponderHandler(this, this.looper);
        } else if (z && this.handler != null) {
            this.handler = null;
        }
        this.useSynchronousMode = z;
    }

    public boolean getUsePoolThread() {
        return this.usePoolThread;
    }

    public void setUsePoolThread(boolean z) {
        if (z) {
            this.looper = null;
            this.handler = null;
        }
        this.usePoolThread = z;
    }

    public String getCharset() {
        String str = this.responseCharset;
        return str == null ? "UTF-8" : str;
    }

    public void setCharset(String str) {
        this.responseCharset = str;
    }

    public void onProgress(long j, long j2) {
        LogInterface logInterface = AsyncHttpClient.log;
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(j);
        objArr[1] = Long.valueOf(j2);
        objArr[2] = Double.valueOf(j2 > 0 ? ((((double) j) * 1.0d) / ((double) j2)) * 100.0d : -1.0d);
        logInterface.mo51347v(LOG_TAG, String.format("Progress %d from %d (%2.0f%%)", objArr));
    }

    public void onRetry(int i) {
        AsyncHttpClient.log.mo51334d(LOG_TAG, String.format("Request retry no. %d", new Object[]{Integer.valueOf(i)}));
    }

    public void onCancel() {
        AsyncHttpClient.log.mo51334d(LOG_TAG, "Request got cancelled");
    }

    public void onUserException(Throwable th) {
        AsyncHttpClient.log.mo51337e(LOG_TAG, "User-space exception detected!", th);
        throw new RuntimeException(th);
    }

    public final void sendProgressMessage(long j, long j2) {
        sendMessage(obtainMessage(4, new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
    }

    public final void sendSuccessMessage(int i, Header[] headerArr, byte[] bArr) {
        sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i), headerArr, bArr}));
    }

    public final void sendFailureMessage(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        sendMessage(obtainMessage(1, new Object[]{Integer.valueOf(i), headerArr, bArr, th}));
    }

    public final void sendStartMessage() {
        sendMessage(obtainMessage(2, (Object) null));
    }

    public final void sendFinishMessage() {
        sendMessage(obtainMessage(3, (Object) null));
    }

    public final void sendRetryMessage(int i) {
        sendMessage(obtainMessage(5, new Object[]{Integer.valueOf(i)}));
    }

    public final void sendCancelMessage() {
        sendMessage(obtainMessage(6, (Object) null));
    }

    /* access modifiers changed from: protected */
    public void handleMessage(Message message) {
        try {
            switch (message.what) {
                case 0:
                    Object[] objArr = (Object[]) message.obj;
                    if (objArr == null || objArr.length < 3) {
                        AsyncHttpClient.log.mo51336e(LOG_TAG, "SUCCESS_MESSAGE didn't got enough params");
                        return;
                    } else {
                        onSuccess(((Integer) objArr[0]).intValue(), (Header[]) objArr[1], (byte[]) objArr[2]);
                        return;
                    }
                case 1:
                    Object[] objArr2 = (Object[]) message.obj;
                    if (objArr2 == null || objArr2.length < 4) {
                        AsyncHttpClient.log.mo51336e(LOG_TAG, "FAILURE_MESSAGE didn't got enough params");
                        return;
                    } else {
                        onFailure(((Integer) objArr2[0]).intValue(), (Header[]) objArr2[1], (byte[]) objArr2[2], (Throwable) objArr2[3]);
                        return;
                    }
                case 2:
                    onStart();
                    return;
                case 3:
                    onFinish();
                    return;
                case 4:
                    Object[] objArr3 = (Object[]) message.obj;
                    if (objArr3 == null || objArr3.length < 2) {
                        AsyncHttpClient.log.mo51336e(LOG_TAG, "PROGRESS_MESSAGE didn't got enough params");
                        return;
                    } else {
                        onProgress(((Long) objArr3[0]).longValue(), ((Long) objArr3[1]).longValue());
                        return;
                    }
                case 5:
                    Object[] objArr4 = (Object[]) message.obj;
                    if (objArr4 == null || objArr4.length != 1) {
                        AsyncHttpClient.log.mo51336e(LOG_TAG, "RETRY_MESSAGE didn't get enough params");
                        return;
                    } else {
                        onRetry(((Integer) objArr4[0]).intValue());
                        return;
                    }
                case 6:
                    onCancel();
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            onUserException(th);
        }
        onUserException(th);
    }

    /* access modifiers changed from: protected */
    public void sendMessage(Message message) {
        if (getUseSynchronousMode() || this.handler == null) {
            handleMessage(message);
        } else if (!Thread.currentThread().isInterrupted()) {
            Utils.asserts(this.handler != null, "handler should not be null!");
            this.handler.sendMessage(message);
        }
    }

    /* access modifiers changed from: protected */
    public void postRunnable(Runnable runnable) {
        Handler handler2;
        if (runnable == null) {
            return;
        }
        if (getUseSynchronousMode() || (handler2 = this.handler) == null) {
            runnable.run();
        } else {
            handler2.post(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public Message obtainMessage(int i, Object obj) {
        return Message.obtain(this.handler, i, obj);
    }

    public void sendResponseMessage(HttpResponse httpResponse) throws IOException {
        if (!Thread.currentThread().isInterrupted()) {
            StatusLine statusLine = httpResponse.getStatusLine();
            byte[] responseData = getResponseData(httpResponse.getEntity());
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            if (statusLine.getStatusCode() >= 300) {
                sendFailureMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), responseData, new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()));
            } else {
                sendSuccessMessage(statusLine.getStatusCode(), httpResponse.getAllHeaders(), responseData);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        com.loopj.android.http.AsyncHttpClient.silentCloseInputStream(r0);
        com.loopj.android.http.AsyncHttpClient.endEntityViaReflection(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return r8.toByteArray();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getResponseData(p052cz.msebera.android.httpclient.HttpEntity r12) throws java.io.IOException {
        /*
            r11 = this;
            if (r12 == 0) goto L_0x006d
            java.io.InputStream r0 = r12.getContent()
            if (r0 == 0) goto L_0x006d
            long r1 = r12.getContentLength()
            r3 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0065
            r3 = 4096(0x1000, float:5.74E-42)
            r4 = 0
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x001e
            r7 = 4096(0x1000, float:5.74E-42)
            goto L_0x001f
        L_0x001e:
            int r7 = (int) r1
        L_0x001f:
            cz.msebera.android.httpclient.util.ByteArrayBuffer r8 = new cz.msebera.android.httpclient.util.ByteArrayBuffer     // Catch:{ OutOfMemoryError -> 0x005a }
            r8.<init>(r7)     // Catch:{ OutOfMemoryError -> 0x005a }
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x0052 }
        L_0x0026:
            int r7 = r0.read(r3)     // Catch:{ all -> 0x0052 }
            r9 = -1
            if (r7 == r9) goto L_0x0047
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0052 }
            boolean r9 = r9.isInterrupted()     // Catch:{ all -> 0x0052 }
            if (r9 != 0) goto L_0x0047
            long r9 = (long) r7     // Catch:{ all -> 0x0052 }
            long r4 = r4 + r9
            r9 = 0
            r8.append((byte[]) r3, (int) r9, (int) r7)     // Catch:{ all -> 0x0052 }
            if (r6 > 0) goto L_0x0042
            r9 = 1
            goto L_0x0043
        L_0x0042:
            r9 = r1
        L_0x0043:
            r11.sendProgressMessage(r4, r9)     // Catch:{ all -> 0x0052 }
            goto L_0x0026
        L_0x0047:
            com.loopj.android.http.AsyncHttpClient.silentCloseInputStream(r0)     // Catch:{ OutOfMemoryError -> 0x005a }
            com.loopj.android.http.AsyncHttpClient.endEntityViaReflection(r12)     // Catch:{ OutOfMemoryError -> 0x005a }
            byte[] r12 = r8.toByteArray()     // Catch:{ OutOfMemoryError -> 0x005a }
            goto L_0x006e
        L_0x0052:
            r1 = move-exception
            com.loopj.android.http.AsyncHttpClient.silentCloseInputStream(r0)     // Catch:{ OutOfMemoryError -> 0x005a }
            com.loopj.android.http.AsyncHttpClient.endEntityViaReflection(r12)     // Catch:{ OutOfMemoryError -> 0x005a }
            throw r1     // Catch:{ OutOfMemoryError -> 0x005a }
        L_0x005a:
            java.lang.System.gc()
            java.io.IOException r12 = new java.io.IOException
            java.lang.String r0 = "File too large to fit into available memory"
            r12.<init>(r0)
            throw r12
        L_0x0065:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "HTTP entity too large to be buffered in memory"
            r12.<init>(r0)
            throw r12
        L_0x006d:
            r12 = 0
        L_0x006e:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loopj.android.http.AsyncHttpResponseHandler.getResponseData(cz.msebera.android.httpclient.HttpEntity):byte[]");
    }

    private static class ResponderHandler extends Handler {
        private final AsyncHttpResponseHandler mResponder;

        ResponderHandler(AsyncHttpResponseHandler asyncHttpResponseHandler, Looper looper) {
            super(looper);
            this.mResponder = asyncHttpResponseHandler;
        }

        public void handleMessage(Message message) {
            this.mResponder.handleMessage(message);
        }
    }
}
