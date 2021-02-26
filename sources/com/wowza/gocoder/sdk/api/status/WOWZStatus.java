package com.wowza.gocoder.sdk.api.status;

import com.wowza.gocoder.sdk.api.errors.WOWZError;

/* compiled from: GoCoderSDK */
public class WOWZStatus {

    /* renamed from: a */
    private int f3905a;

    /* renamed from: b */
    private WOWZError f3906b;

    public WOWZStatus() {
        this(0, (WOWZError) null);
    }

    public WOWZStatus(int i, WOWZError wOWZError) {
        if (WOWZState.isValidState(i)) {
            this.f3905a = i;
        } else {
            this.f3905a = 11;
        }
        if (wOWZError != null) {
            this.f3906b = new WOWZError(wOWZError);
        } else {
            this.f3906b = null;
        }
    }

    public WOWZStatus(int i) {
        this(i, (WOWZError) null);
    }

    public WOWZStatus(WOWZStatus wOWZStatus) {
        this();
        set(wOWZStatus);
    }

    public synchronized int getState() {
        return this.f3905a;
    }

    public synchronized void setState(int i) {
        if (WOWZState.isValidState(i)) {
            this.f3905a = i;
            notifyAll();
        } else {
            this.f3905a = 11;
            notifyAll();
        }
    }

    public WOWZError getLastError() {
        return getLastError(false);
    }

    public WOWZError getLastError(boolean z) {
        WOWZError wOWZError = this.f3906b;
        if (wOWZError == null) {
            return null;
        }
        return z ? clearLastError() : new WOWZError(wOWZError);
    }

    public void setError(WOWZError wOWZError) {
        if (wOWZError == null) {
            this.f3906b = null;
        } else {
            this.f3906b = new WOWZError(wOWZError);
        }
    }

    public WOWZError clearLastError() {
        WOWZError wOWZError = this.f3906b;
        WOWZError wOWZError2 = wOWZError != null ? new WOWZError(wOWZError) : null;
        this.f3906b = null;
        return wOWZError2;
    }

    public WOWZError clearLastError(int i) {
        WOWZError wOWZError = new WOWZError(this.f3906b);
        if (WOWZState.isValidState(i)) {
            WOWZError clearLastError = clearLastError();
            setState(i);
            return clearLastError;
        }
        setState(11);
        return wOWZError;
    }

    public void set(int i, WOWZError wOWZError) {
        setState(i);
        setError(new WOWZError(wOWZError));
    }

    public void set(WOWZStatus wOWZStatus) {
        if (wOWZStatus != null) {
            this.f3906b = null;
            WOWZError wOWZError = wOWZStatus.f3906b;
            if (wOWZError != null) {
                this.f3906b = new WOWZError(wOWZError);
            }
            setState(wOWZStatus.getState());
        }
    }

    public int setAndWaitForState(int i, int i2) {
        setState(i);
        return waitForState(i2);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0001 */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x0001 A[LOOP:0: B:1:0x0001->B:15:0x0001, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int waitForState(int r2) {
        /*
            r1 = this;
            monitor-enter(r1)
        L_0x0001:
            int r0 = r1.f3905a     // Catch:{ all -> 0x0011 }
            if (r0 == r2) goto L_0x000d
            int r0 = r1.f3905a     // Catch:{ all -> 0x0011 }
            if (r0 == 0) goto L_0x000d
            r1.wait()     // Catch:{ InterruptedException -> 0x0001 }
            goto L_0x0001
        L_0x000d:
            int r2 = r1.f3905a     // Catch:{ all -> 0x0011 }
            monitor-exit(r1)
            return r2
        L_0x0011:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.api.status.WOWZStatus.waitForState(int):int");
    }

    public synchronized boolean isIdle() {
        return this.f3905a == 0;
    }

    public synchronized boolean isStarting() {
        boolean z;
        z = true;
        if (this.f3905a != 1) {
            z = false;
        }
        return z;
    }

    public synchronized boolean isReady() {
        return this.f3905a == 2;
    }

    public synchronized boolean isRunning() {
        return this.f3905a == 3;
    }

    public synchronized boolean isPaused() {
        return this.f3905a == 5;
    }

    public synchronized boolean isStopping() {
        return this.f3905a == 4;
    }

    public synchronized boolean isStopped() {
        return this.f3905a == 6;
    }

    public synchronized boolean isComplete() {
        return this.f3905a == 7;
    }

    public synchronized boolean isShutdown() {
        return this.f3905a == 9;
    }

    public synchronized boolean isUnknown() {
        return this.f3905a == 11;
    }

    public synchronized boolean isBuffering() {
        return this.f3905a == 12;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("state                     : " + WOWZState.toLabel(this.f3905a));
        if (this.f3906b != null) {
            stringBuffer.append("\n" + this.f3906b.toString());
        }
        return stringBuffer.toString();
    }
}
