package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcd;

/* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
final class zzt {
    private zzcd.zzc zza;
    private Long zzb;
    private long zzc;
    private final /* synthetic */ zzo zzd;

    private zzt(zzo zzo) {
        this.zzd = zzo;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.String} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzcd.zzc zza(java.lang.String r18, com.google.android.gms.internal.measurement.zzcd.zzc r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r8 = r19
            java.lang.String r9 = r19.zzc()
            java.util.List r10 = r19.zza()
            com.google.android.gms.measurement.internal.zzo r2 = r1.zzd
            com.google.android.gms.measurement.internal.zzkt r2 = r2.mo23251f_()
            java.lang.String r3 = "_eid"
            java.lang.Object r2 = r2.zzb(r8, r3)
            r4 = r2
            java.lang.Long r4 = (java.lang.Long) r4
            r2 = 1
            r5 = 0
            if (r4 == 0) goto L_0x0023
            r6 = 1
            goto L_0x0024
        L_0x0023:
            r6 = 0
        L_0x0024:
            if (r6 == 0) goto L_0x0030
            java.lang.String r7 = "_ep"
            boolean r7 = r9.equals(r7)
            if (r7 == 0) goto L_0x0030
            r7 = 1
            goto L_0x0031
        L_0x0030:
            r7 = 0
        L_0x0031:
            r11 = 0
            if (r7 == 0) goto L_0x014b
            com.google.android.gms.measurement.internal.zzo r6 = r1.zzd
            com.google.android.gms.measurement.internal.zzkt r6 = r6.mo23251f_()
            java.lang.String r7 = "_en"
            java.lang.Object r6 = r6.zzb(r8, r7)
            r9 = r6
            java.lang.String r9 = (java.lang.String) r9
            boolean r6 = android.text.TextUtils.isEmpty(r9)
            r7 = 0
            if (r6 == 0) goto L_0x005b
            com.google.android.gms.measurement.internal.zzo r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzex r0 = r0.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzf()
            java.lang.String r2 = "Extra parameter without an event name. eventId"
            r0.zza(r2, r4)
            return r7
        L_0x005b:
            com.google.android.gms.internal.measurement.zzcd$zzc r6 = r1.zza
            if (r6 == 0) goto L_0x0071
            java.lang.Long r6 = r1.zzb
            if (r6 == 0) goto L_0x0071
            long r13 = r4.longValue()
            java.lang.Long r6 = r1.zzb
            long r15 = r6.longValue()
            int r6 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r6 == 0) goto L_0x00a3
        L_0x0071:
            com.google.android.gms.measurement.internal.zzo r6 = r1.zzd
            com.google.android.gms.measurement.internal.zzac r6 = r6.zzi()
            android.util.Pair r6 = r6.zza((java.lang.String) r0, (java.lang.Long) r4)
            if (r6 == 0) goto L_0x013b
            java.lang.Object r13 = r6.first
            if (r13 != 0) goto L_0x0083
            goto L_0x013b
        L_0x0083:
            java.lang.Object r7 = r6.first
            com.google.android.gms.internal.measurement.zzcd$zzc r7 = (com.google.android.gms.internal.measurement.zzcd.zzc) r7
            r1.zza = r7
            java.lang.Object r6 = r6.second
            java.lang.Long r6 = (java.lang.Long) r6
            long r6 = r6.longValue()
            r1.zzc = r6
            com.google.android.gms.measurement.internal.zzo r6 = r1.zzd
            com.google.android.gms.measurement.internal.zzkt r6 = r6.mo23251f_()
            com.google.android.gms.internal.measurement.zzcd$zzc r7 = r1.zza
            java.lang.Object r3 = r6.zzb(r7, r3)
            java.lang.Long r3 = (java.lang.Long) r3
            r1.zzb = r3
        L_0x00a3:
            long r6 = r1.zzc
            r13 = 1
            long r6 = r6 - r13
            r1.zzc = r6
            long r6 = r1.zzc
            int r3 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r3 > 0) goto L_0x00e3
            com.google.android.gms.measurement.internal.zzo r3 = r1.zzd
            com.google.android.gms.measurement.internal.zzac r3 = r3.zzi()
            r3.zzc()
            com.google.android.gms.measurement.internal.zzex r4 = r3.zzq()
            com.google.android.gms.measurement.internal.zzez r4 = r4.zzw()
            java.lang.String r6 = "Clearing complex main event info. appId"
            r4.zza(r6, r0)
            android.database.sqlite.SQLiteDatabase r4 = r3.mo23015c_()     // Catch:{ SQLiteException -> 0x00d4 }
            java.lang.String r6 = "delete from main_event_params where app_id=?"
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00d4 }
            r2[r5] = r0     // Catch:{ SQLiteException -> 0x00d4 }
            r4.execSQL(r6, r2)     // Catch:{ SQLiteException -> 0x00d4 }
            goto L_0x00f2
        L_0x00d4:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzex r2 = r3.zzq()
            com.google.android.gms.measurement.internal.zzez r2 = r2.zze()
            java.lang.String r3 = "Error clearing complex main event"
            r2.zza(r3, r0)
            goto L_0x00f2
        L_0x00e3:
            com.google.android.gms.measurement.internal.zzo r2 = r1.zzd
            com.google.android.gms.measurement.internal.zzac r2 = r2.zzi()
            long r5 = r1.zzc
            com.google.android.gms.internal.measurement.zzcd$zzc r7 = r1.zza
            r3 = r18
            r2.zza(r3, r4, r5, r7)
        L_0x00f2:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.google.android.gms.internal.measurement.zzcd$zzc r2 = r1.zza
            java.util.List r2 = r2.zza()
            java.util.Iterator r2 = r2.iterator()
        L_0x0101:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0120
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzcd$zze r3 = (com.google.android.gms.internal.measurement.zzcd.zze) r3
            com.google.android.gms.measurement.internal.zzo r4 = r1.zzd
            r4.mo23251f_()
            java.lang.String r4 = r3.zzb()
            com.google.android.gms.internal.measurement.zzcd$zze r4 = com.google.android.gms.measurement.internal.zzkt.zza((com.google.android.gms.internal.measurement.zzcd.zzc) r8, (java.lang.String) r4)
            if (r4 != 0) goto L_0x0101
            r0.add(r3)
            goto L_0x0101
        L_0x0120:
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x012b
            r0.addAll(r10)
            r10 = r0
            goto L_0x0191
        L_0x012b:
            com.google.android.gms.measurement.internal.zzo r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzex r0 = r0.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzf()
            java.lang.String r2 = "No unique parameters in main event. eventName"
            r0.zza(r2, r9)
            goto L_0x0191
        L_0x013b:
            com.google.android.gms.measurement.internal.zzo r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzex r0 = r0.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzf()
            java.lang.String r2 = "Extra parameter without existing main event. eventName, eventId"
            r0.zza(r2, r9, r4)
            return r7
        L_0x014b:
            if (r6 == 0) goto L_0x0191
            r1.zzb = r4
            r1.zza = r8
            com.google.android.gms.measurement.internal.zzo r2 = r1.zzd
            com.google.android.gms.measurement.internal.zzkt r2 = r2.mo23251f_()
            java.lang.Long r3 = java.lang.Long.valueOf(r11)
            java.lang.String r5 = "_epc"
            java.lang.Object r2 = r2.zzb(r8, r5)
            if (r2 != 0) goto L_0x0164
            r2 = r3
        L_0x0164:
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r1.zzc = r2
            long r2 = r1.zzc
            int r5 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r5 > 0) goto L_0x0182
            com.google.android.gms.measurement.internal.zzo r0 = r1.zzd
            com.google.android.gms.measurement.internal.zzex r0 = r0.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzf()
            java.lang.String r2 = "Complex event with zero extra param count. eventName"
            r0.zza(r2, r9)
            goto L_0x0191
        L_0x0182:
            com.google.android.gms.measurement.internal.zzo r2 = r1.zzd
            com.google.android.gms.measurement.internal.zzac r2 = r2.zzi()
            long r5 = r1.zzc
            r3 = r18
            r7 = r19
            r2.zza(r3, r4, r5, r7)
        L_0x0191:
            com.google.android.gms.internal.measurement.zzhv$zzb r0 = r19.zzbo()
            com.google.android.gms.internal.measurement.zzhv$zzb r0 = (com.google.android.gms.internal.measurement.zzhv.zzb) r0
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r0 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r0
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r0 = r0.zza((java.lang.String) r9)
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r0 = r0.zzc()
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r0 = r0.zza((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzcd.zze>) r10)
            com.google.android.gms.internal.measurement.zzjg r0 = r0.zzy()
            com.google.android.gms.internal.measurement.zzhv r0 = (com.google.android.gms.internal.measurement.zzhv) r0
            com.google.android.gms.internal.measurement.zzcd$zzc r0 = (com.google.android.gms.internal.measurement.zzcd.zzc) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzt.zza(java.lang.String, com.google.android.gms.internal.measurement.zzcd$zzc):com.google.android.gms.internal.measurement.zzcd$zzc");
    }

    /* synthetic */ zzt(zzo zzo, zzr zzr) {
        this(zzo);
    }
}
