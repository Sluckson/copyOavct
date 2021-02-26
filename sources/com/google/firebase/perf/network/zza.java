package com.google.firebase.perf.network;

import com.google.android.gms.internal.p010firebaseperf.zzbg;
import com.google.android.gms.internal.p010firebaseperf.zzbw;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zza extends OutputStream {
    private final zzbw zzgi;
    private OutputStream zzgn;
    private long zzgo = -1;
    private zzbg zzgp;

    public zza(OutputStream outputStream, zzbg zzbg, zzbw zzbw) {
        this.zzgn = outputStream;
        this.zzgp = zzbg;
        this.zzgi = zzbw;
    }

    public final void close() throws IOException {
        long j = this.zzgo;
        if (j != -1) {
            this.zzgp.zzj(j);
        }
        this.zzgp.zzl(this.zzgi.getDurationMicros());
        try {
            this.zzgn.close();
        } catch (IOException e) {
            this.zzgp.zzn(this.zzgi.getDurationMicros());
            zzg.zza(this.zzgp);
            throw e;
        }
    }

    public final void flush() throws IOException {
        try {
            this.zzgn.flush();
        } catch (IOException e) {
            this.zzgp.zzn(this.zzgi.getDurationMicros());
            zzg.zza(this.zzgp);
            throw e;
        }
    }

    public final void write(int i) throws IOException {
        try {
            this.zzgn.write(i);
            this.zzgo++;
            this.zzgp.zzj(this.zzgo);
        } catch (IOException e) {
            this.zzgp.zzn(this.zzgi.getDurationMicros());
            zzg.zza(this.zzgp);
            throw e;
        }
    }

    public final void write(byte[] bArr) throws IOException {
        try {
            this.zzgn.write(bArr);
            this.zzgo += (long) bArr.length;
            this.zzgp.zzj(this.zzgo);
        } catch (IOException e) {
            this.zzgp.zzn(this.zzgi.getDurationMicros());
            zzg.zza(this.zzgp);
            throw e;
        }
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.zzgn.write(bArr, i, i2);
            this.zzgo += (long) i2;
            this.zzgp.zzj(this.zzgo);
        } catch (IOException e) {
            this.zzgp.zzn(this.zzgi.getDurationMicros());
            zzg.zza(this.zzgp);
            throw e;
        }
    }
}
