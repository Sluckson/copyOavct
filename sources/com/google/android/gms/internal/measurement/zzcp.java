package com.google.android.gms.internal.measurement;

import android.content.Context;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzcp extends zzdk {
    private final Context zza;
    private final zzeb<zzdx<zzcy>> zzb;

    zzcp(Context context, @Nullable zzeb<zzdx<zzcy>> zzeb) {
        if (context != null) {
            this.zza = context;
            this.zzb = zzeb;
            return;
        }
        throw new NullPointerException("Null context");
    }

    /* access modifiers changed from: package-private */
    public final Context zza() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final zzeb<zzdx<zzcy>> zzb() {
        return this.zzb;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 46 + String.valueOf(valueOf2).length());
        sb.append("FlagsContext{context=");
        sb.append(valueOf);
        sb.append(", hermeticFileOverrides=");
        sb.append(valueOf2);
        sb.append("}");
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r1 = r4.zzb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.android.gms.internal.measurement.zzdk
            r2 = 0
            if (r1 == 0) goto L_0x002d
            com.google.android.gms.internal.measurement.zzdk r5 = (com.google.android.gms.internal.measurement.zzdk) r5
            android.content.Context r1 = r4.zza
            android.content.Context r3 = r5.zza()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x002d
            com.google.android.gms.internal.measurement.zzeb<com.google.android.gms.internal.measurement.zzdx<com.google.android.gms.internal.measurement.zzcy>> r1 = r4.zzb
            if (r1 != 0) goto L_0x0022
            com.google.android.gms.internal.measurement.zzeb r5 = r5.zzb()
            if (r5 != 0) goto L_0x002d
            goto L_0x002c
        L_0x0022:
            com.google.android.gms.internal.measurement.zzeb r5 = r5.zzb()
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x002d
        L_0x002c:
            return r0
        L_0x002d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzcp.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        zzeb<zzdx<zzcy>> zzeb = this.zzb;
        return hashCode ^ (zzeb == null ? 0 : zzeb.hashCode());
    }
}
