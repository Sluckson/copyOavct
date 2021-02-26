package com.google.firebase.perf.network;

import com.google.android.gms.internal.p010firebaseperf.zzbg;
import com.google.android.gms.internal.p010firebaseperf.zzbw;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzb extends InputStream {
    private final zzbw zzgi;
    private final zzbg zzgp;
    private final InputStream zzgq;
    private long zzgr = -1;
    private long zzgs;
    private long zzgt = -1;

    public zzb(InputStream inputStream, zzbg zzbg, zzbw zzbw) {
        this.zzgi = zzbw;
        this.zzgq = inputStream;
        this.zzgp = zzbg;
        this.zzgs = this.zzgp.zzbi();
    }

    public final int available() throws IOException {
        try {
            return this.zzgq.available();
        } catch (IOException e) {
            this.zzgp.zzn(this.zzgi.getDurationMicros());
            zzg.zza(this.zzgp);
            throw e;
        }
    }

    public final void close() throws IOException {
        long durationMicros = this.zzgi.getDurationMicros();
        if (this.zzgt == -1) {
            this.zzgt = durationMicros;
        }
        try {
            this.zzgq.close();
            if (this.zzgr != -1) {
                this.zzgp.zzo(this.zzgr);
            }
            if (this.zzgs != -1) {
                this.zzgp.zzm(this.zzgs);
            }
            this.zzgp.zzn(this.zzgt);
            this.zzgp.zzbk();
        } catch (IOException e) {
            this.zzgp.zzn(this.zzgi.getDurationMicros());
            zzg.zza(this.zzgp);
            throw e;
        }
    }

    public final void mark(int i) {
        this.zzgq.mark(i);
    }

    public final boolean markSupported() {
        return this.zzgq.markSupported();
    }

    public final int read() throws IOException {
        try {
            int read = this.zzgq.read();
            long durationMicros = this.zzgi.getDurationMicros();
            if (this.zzgs == -1) {
                this.zzgs = durationMicros;
            }
            if (read == -1 && this.zzgt == -1) {
                this.zzgt = durationMicros;
                this.zzgp.zzn(this.zzgt);
                this.zzgp.zzbk();
            } else {
                this.zzgr++;
                this.zzgp.zzo(this.zzgr);
            }
            return read;
        } catch (IOException e) {
            this.zzgp.zzn(this.zzgi.getDurationMicros());
            zzg.zza(this.zzgp);
            throw e;
        }
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            int read = this.zzgq.read(bArr, i, i2);
            long durationMicros = this.zzgi.getDurationMicros();
            if (this.zzgs == -1) {
                this.zzgs = durationMicros;
            }
            if (read == -1 && this.zzgt == -1) {
                this.zzgt = durationMicros;
                this.zzgp.zzn(this.zzgt);
                this.zzgp.zzbk();
            } else {
                this.zzgr += (long) read;
                this.zzgp.zzo(this.zzgr);
            }
            return read;
        } catch (IOException e) {
            this.zzgp.zzn(this.zzgi.getDurationMicros());
            zzg.zza(this.zzgp);
            throw e;
        }
    }

    public final int read(byte[] bArr) throws IOException {
        try {
            int read = this.zzgq.read(bArr);
            long durationMicros = this.zzgi.getDurationMicros();
            if (this.zzgs == -1) {
                this.zzgs = durationMicros;
            }
            if (read == -1 && this.zzgt == -1) {
                this.zzgt = durationMicros;
                this.zzgp.zzn(this.zzgt);
                this.zzgp.zzbk();
            } else {
                this.zzgr += (long) read;
                this.zzgp.zzo(this.zzgr);
            }
            return read;
        } catch (IOException e) {
            this.zzgp.zzn(this.zzgi.getDurationMicros());
            zzg.zza(this.zzgp);
            throw e;
        }
    }

    public final void reset() throws IOException {
        try {
            this.zzgq.reset();
        } catch (IOException e) {
            this.zzgp.zzn(this.zzgi.getDurationMicros());
            zzg.zza(this.zzgp);
            throw e;
        }
    }

    public final long skip(long j) throws IOException {
        try {
            long skip = this.zzgq.skip(j);
            long durationMicros = this.zzgi.getDurationMicros();
            if (this.zzgs == -1) {
                this.zzgs = durationMicros;
            }
            if (skip == -1 && this.zzgt == -1) {
                this.zzgt = durationMicros;
                this.zzgp.zzn(this.zzgt);
            } else {
                this.zzgr += skip;
                this.zzgp.zzo(this.zzgr);
            }
            return skip;
        } catch (IOException e) {
            this.zzgp.zzn(this.zzgi.getDurationMicros());
            zzg.zza(this.zzgp);
            throw e;
        }
    }
}
