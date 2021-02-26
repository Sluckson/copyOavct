package com.google.android.gms.internal.p010firebaseperf;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzbx */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzbx {
    private final URL zzib;

    public zzbx(URL url) {
        this.zzib = url;
    }

    public final URLConnection openConnection() throws IOException {
        return this.zzib.openConnection();
    }

    public final String toString() {
        return this.zzib.toString();
    }
}
