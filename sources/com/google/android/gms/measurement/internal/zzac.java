package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbv;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzhv;
import com.google.android.gms.internal.measurement.zznq;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.salesforce.marketingcloud.p022d.p023a.C4002i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import lib.android.paypal.com.magnessdk.p058a.C4820b;
import repack.org.bouncycastle.crypto.tls.CipherSuite;

/* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
final class zzac extends zzkm {
    /* access modifiers changed from: private */
    public static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzc = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzd = {C4002i.C4003a.f2856q, "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", C4820b.f5526f, "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzah zzj = new zzah(this, zzm(), "google_app_measurement.db");
    /* access modifiers changed from: private */
    public final zzki zzk = new zzki(zzl());

    zzac(zzkp zzkp) {
        super(zzkp);
    }

    /* access modifiers changed from: protected */
    public final boolean zzd() {
        return false;
    }

    @WorkerThread
    public final void zze() {
        zzaj();
        mo23015c_().beginTransaction();
    }

    @WorkerThread
    /* renamed from: b_ */
    public final void mo23014b_() {
        zzaj();
        mo23015c_().setTransactionSuccessful();
    }

    @WorkerThread
    public final void zzg() {
        zzaj();
        mo23015c_().endTransaction();
    }

    @WorkerThread
    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = mo23015c_().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzq().zze().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    private final long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = mo23015c_().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j2 = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j2;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzq().zze().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    private final String zza(String str, String[] strArr, String str2) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = mo23015c_().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                String string = rawQuery.getString(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return string;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str2;
        } catch (SQLiteException e) {
            zzq().zze().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    /* renamed from: c_ */
    public final SQLiteDatabase mo23015c_() {
        zzc();
        try {
            return this.zzj.getWritableDatabase();
        } catch (SQLiteException e) {
            zzq().zzh().zza("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0147  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzan zza(java.lang.String r26, java.lang.String r27) {
        /*
            r25 = this;
            r15 = r27
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r26)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r27)
            r25.zzc()
            r25.zzaj()
            java.util.ArrayList r0 = new java.util.ArrayList
            java.lang.String r1 = "lifetime_count"
            java.lang.String r2 = "current_bundle_count"
            java.lang.String r3 = "last_fire_timestamp"
            java.lang.String r4 = "last_bundled_timestamp"
            java.lang.String r5 = "last_bundled_day"
            java.lang.String r6 = "last_sampled_complex_event_id"
            java.lang.String r7 = "last_sampling_rate"
            java.lang.String r8 = "last_exempt_from_sampling"
            java.lang.String r9 = "current_session_count"
            java.lang.String[] r1 = new java.lang.String[]{r1, r2, r3, r4, r5, r6, r7, r8, r9}
            java.util.List r1 = java.util.Arrays.asList(r1)
            r0.<init>(r1)
            r18 = 0
            android.database.sqlite.SQLiteDatabase r1 = r25.mo23015c_()     // Catch:{ SQLiteException -> 0x0120, all -> 0x011c }
            java.lang.String r2 = "events"
            r9 = 0
            java.lang.String[] r3 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x0120, all -> 0x011c }
            java.lang.Object[] r0 = r0.toArray(r3)     // Catch:{ SQLiteException -> 0x0120, all -> 0x011c }
            r3 = r0
            java.lang.String[] r3 = (java.lang.String[]) r3     // Catch:{ SQLiteException -> 0x0120, all -> 0x011c }
            java.lang.String r4 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0120, all -> 0x011c }
            r5[r9] = r26     // Catch:{ SQLiteException -> 0x0120, all -> 0x011c }
            r10 = 1
            r5[r10] = r15     // Catch:{ SQLiteException -> 0x0120, all -> 0x011c }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0120, all -> 0x011c }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x0118, all -> 0x0114 }
            if (r1 != 0) goto L_0x005c
            if (r14 == 0) goto L_0x005b
            r14.close()
        L_0x005b:
            return r18
        L_0x005c:
            long r4 = r14.getLong(r9)     // Catch:{ SQLiteException -> 0x0118, all -> 0x0114 }
            long r6 = r14.getLong(r10)     // Catch:{ SQLiteException -> 0x0118, all -> 0x0114 }
            long r11 = r14.getLong(r0)     // Catch:{ SQLiteException -> 0x0118, all -> 0x0114 }
            r0 = 3
            boolean r1 = r14.isNull(r0)     // Catch:{ SQLiteException -> 0x0118, all -> 0x0114 }
            r2 = 0
            if (r1 == 0) goto L_0x0074
            r16 = r2
            goto L_0x007a
        L_0x0074:
            long r0 = r14.getLong(r0)     // Catch:{ SQLiteException -> 0x0118, all -> 0x0114 }
            r16 = r0
        L_0x007a:
            r0 = 4
            boolean r1 = r14.isNull(r0)     // Catch:{ SQLiteException -> 0x0118, all -> 0x0114 }
            if (r1 == 0) goto L_0x0084
            r0 = r18
            goto L_0x008c
        L_0x0084:
            long r0 = r14.getLong(r0)     // Catch:{ SQLiteException -> 0x0118, all -> 0x0114 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ SQLiteException -> 0x0118, all -> 0x0114 }
        L_0x008c:
            r1 = 5
            boolean r8 = r14.isNull(r1)     // Catch:{ SQLiteException -> 0x0118, all -> 0x0114 }
            if (r8 == 0) goto L_0x0096
            r19 = r18
            goto L_0x00a0
        L_0x0096:
            long r19 = r14.getLong(r1)     // Catch:{ SQLiteException -> 0x0118, all -> 0x0114 }
            java.lang.Long r1 = java.lang.Long.valueOf(r19)     // Catch:{ SQLiteException -> 0x0118, all -> 0x0114 }
            r19 = r1
        L_0x00a0:
            r1 = 6
            boolean r8 = r14.isNull(r1)     // Catch:{ SQLiteException -> 0x0118, all -> 0x0114 }
            if (r8 == 0) goto L_0x00aa
            r20 = r18
            goto L_0x00b4
        L_0x00aa:
            long r20 = r14.getLong(r1)     // Catch:{ SQLiteException -> 0x0118, all -> 0x0114 }
            java.lang.Long r1 = java.lang.Long.valueOf(r20)     // Catch:{ SQLiteException -> 0x0118, all -> 0x0114 }
            r20 = r1
        L_0x00b4:
            r1 = 7
            boolean r8 = r14.isNull(r1)     // Catch:{ SQLiteException -> 0x0118, all -> 0x0114 }
            if (r8 != 0) goto L_0x00cd
            long r21 = r14.getLong(r1)     // Catch:{ SQLiteException -> 0x0118, all -> 0x0114 }
            r23 = 1
            int r1 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r1 != 0) goto L_0x00c6
            r9 = 1
        L_0x00c6:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r9)     // Catch:{ SQLiteException -> 0x0118, all -> 0x0114 }
            r21 = r1
            goto L_0x00cf
        L_0x00cd:
            r21 = r18
        L_0x00cf:
            r1 = 8
            boolean r8 = r14.isNull(r1)     // Catch:{ SQLiteException -> 0x0118, all -> 0x0114 }
            if (r8 == 0) goto L_0x00d9
            r8 = r2
            goto L_0x00de
        L_0x00d9:
            long r1 = r14.getLong(r1)     // Catch:{ SQLiteException -> 0x0118, all -> 0x0114 }
            r8 = r1
        L_0x00de:
            com.google.android.gms.measurement.internal.zzan r22 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ SQLiteException -> 0x0118, all -> 0x0114 }
            r1 = r22
            r2 = r26
            r3 = r27
            r10 = r11
            r12 = r16
            r23 = r14
            r14 = r0
            r15 = r19
            r16 = r20
            r17 = r21
            r1.<init>(r2, r3, r4, r6, r8, r10, r12, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x0112 }
            boolean r0 = r23.moveToNext()     // Catch:{ SQLiteException -> 0x0112 }
            if (r0 == 0) goto L_0x010c
            com.google.android.gms.measurement.internal.zzex r0 = r25.zzq()     // Catch:{ SQLiteException -> 0x0112 }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zze()     // Catch:{ SQLiteException -> 0x0112 }
            java.lang.String r1 = "Got multiple records for event aggregates, expected one. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r26)     // Catch:{ SQLiteException -> 0x0112 }
            r0.zza(r1, r2)     // Catch:{ SQLiteException -> 0x0112 }
        L_0x010c:
            if (r23 == 0) goto L_0x0111
            r23.close()
        L_0x0111:
            return r22
        L_0x0112:
            r0 = move-exception
            goto L_0x0123
        L_0x0114:
            r0 = move-exception
            r23 = r14
            goto L_0x0145
        L_0x0118:
            r0 = move-exception
            r23 = r14
            goto L_0x0123
        L_0x011c:
            r0 = move-exception
            r23 = r18
            goto L_0x0145
        L_0x0120:
            r0 = move-exception
            r23 = r18
        L_0x0123:
            com.google.android.gms.measurement.internal.zzex r1 = r25.zzq()     // Catch:{ all -> 0x0144 }
            com.google.android.gms.measurement.internal.zzez r1 = r1.zze()     // Catch:{ all -> 0x0144 }
            java.lang.String r2 = "Error querying events. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r26)     // Catch:{ all -> 0x0144 }
            com.google.android.gms.measurement.internal.zzev r4 = r25.zzn()     // Catch:{ all -> 0x0144 }
            r5 = r27
            java.lang.String r4 = r4.zza((java.lang.String) r5)     // Catch:{ all -> 0x0144 }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x0144 }
            if (r23 == 0) goto L_0x0143
            r23.close()
        L_0x0143:
            return r18
        L_0x0144:
            r0 = move-exception
        L_0x0145:
            if (r23 == 0) goto L_0x014a
            r23.close()
        L_0x014a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.zza(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzan");
    }

    @WorkerThread
    public final void zza(zzan zzan) {
        Preconditions.checkNotNull(zzan);
        zzc();
        zzaj();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzan.zza);
        contentValues.put("name", zzan.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzan.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzan.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzan.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzan.zzg));
        contentValues.put("last_bundled_day", zzan.zzh);
        contentValues.put("last_sampled_complex_event_id", zzan.zzi);
        contentValues.put("last_sampling_rate", zzan.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzan.zze));
        contentValues.put("last_exempt_from_sampling", (zzan.zzk == null || !zzan.zzk.booleanValue()) ? null : 1L);
        try {
            if (mo23015c_().insertWithOnConflict("events", (String) null, contentValues, 5) == -1) {
                zzq().zze().zza("Failed to insert/update event aggregates (got -1). appId", zzex.zza(zzan.zza));
            }
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing event aggregates. appId", zzex.zza(zzan.zza), e);
        }
    }

    @WorkerThread
    public final void zzb(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzc();
        zzaj();
        try {
            mo23015c_().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzq().zze().zza("Error deleting user property. appId", zzex.zza(str), zzn().zzc(str2), e);
        }
    }

    @WorkerThread
    public final boolean zza(zzky zzky) {
        Preconditions.checkNotNull(zzky);
        zzc();
        zzaj();
        if (zzc(zzky.zza, zzky.zzc) == null) {
            if (zzkx.zza(zzky.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzky.zza}) >= ((long) zzs().zzd(zzky.zza))) {
                    return false;
                }
            } else if (!"_npa".equals(zzky.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzky.zza, zzky.zzb}) >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzky.zza);
        contentValues.put("origin", zzky.zzb);
        contentValues.put("name", zzky.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzky.zzd));
        zza(contentValues, "value", zzky.zze);
        try {
            if (mo23015c_().insertWithOnConflict("user_attributes", (String) null, contentValues, 5) == -1) {
                zzq().zze().zza("Failed to insert/update user property (got -1). appId", zzex.zza(zzky.zza));
            }
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing user property. appId", zzex.zza(zzky.zza), e);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a9  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzky zzc(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            r18.zzc()
            r18.zzaj()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.mo23015c_()     // Catch:{ SQLiteException -> 0x0083, all -> 0x007e }
            java.lang.String r11 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r1 = "value"
            java.lang.String r2 = "origin"
            java.lang.String[] r12 = new java.lang.String[]{r0, r1, r2}     // Catch:{ SQLiteException -> 0x0083, all -> 0x007e }
            java.lang.String r13 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r14 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0083, all -> 0x007e }
            r1 = 0
            r14[r1] = r19     // Catch:{ SQLiteException -> 0x0083, all -> 0x007e }
            r2 = 1
            r14[r2] = r8     // Catch:{ SQLiteException -> 0x0083, all -> 0x007e }
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x0083, all -> 0x007e }
            boolean r3 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x007a, all -> 0x0076 }
            if (r3 != 0) goto L_0x003f
            if (r10 == 0) goto L_0x003e
            r10.close()
        L_0x003e:
            return r9
        L_0x003f:
            long r5 = r10.getLong(r1)     // Catch:{ SQLiteException -> 0x007a, all -> 0x0076 }
            r11 = r18
            java.lang.Object r7 = r11.zza((android.database.Cursor) r10, (int) r2)     // Catch:{ SQLiteException -> 0x0074 }
            java.lang.String r3 = r10.getString(r0)     // Catch:{ SQLiteException -> 0x0074 }
            com.google.android.gms.measurement.internal.zzky r0 = new com.google.android.gms.measurement.internal.zzky     // Catch:{ SQLiteException -> 0x0074 }
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch:{ SQLiteException -> 0x0074 }
            boolean r1 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x0074 }
            if (r1 == 0) goto L_0x006e
            com.google.android.gms.measurement.internal.zzex r1 = r18.zzq()     // Catch:{ SQLiteException -> 0x0074 }
            com.google.android.gms.measurement.internal.zzez r1 = r1.zze()     // Catch:{ SQLiteException -> 0x0074 }
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r19)     // Catch:{ SQLiteException -> 0x0074 }
            r1.zza(r2, r3)     // Catch:{ SQLiteException -> 0x0074 }
        L_0x006e:
            if (r10 == 0) goto L_0x0073
            r10.close()
        L_0x0073:
            return r0
        L_0x0074:
            r0 = move-exception
            goto L_0x0087
        L_0x0076:
            r0 = move-exception
            r11 = r18
            goto L_0x00a7
        L_0x007a:
            r0 = move-exception
            r11 = r18
            goto L_0x0087
        L_0x007e:
            r0 = move-exception
            r11 = r18
            r10 = r9
            goto L_0x00a7
        L_0x0083:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L_0x0087:
            com.google.android.gms.measurement.internal.zzex r1 = r18.zzq()     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.measurement.internal.zzez r1 = r1.zze()     // Catch:{ all -> 0x00a6 }
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r19)     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.measurement.internal.zzev r4 = r18.zzn()     // Catch:{ all -> 0x00a6 }
            java.lang.String r4 = r4.zzc(r8)     // Catch:{ all -> 0x00a6 }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x00a6 }
            if (r10 == 0) goto L_0x00a5
            r10.close()
        L_0x00a5:
            return r9
        L_0x00a6:
            r0 = move-exception
        L_0x00a7:
            if (r10 == 0) goto L_0x00ac
            r10.close()
        L_0x00ac:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.zzc(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzky");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00aa A[Catch:{ all -> 0x00ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bd  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzky> zza(java.lang.String r14) {
        /*
            r13 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            r13.zzc()
            r13.zzaj()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r13.mo23015c_()     // Catch:{ SQLiteException -> 0x0085, all -> 0x0082 }
            java.lang.String r3 = "user_attributes"
            java.lang.String r4 = "name"
            java.lang.String r5 = "origin"
            java.lang.String r6 = "set_timestamp"
            java.lang.String r7 = "value"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7}     // Catch:{ SQLiteException -> 0x0085, all -> 0x0082 }
            java.lang.String r5 = "app_id=?"
            r11 = 1
            java.lang.String[] r6 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x0085, all -> 0x0082 }
            r12 = 0
            r6[r12] = r14     // Catch:{ SQLiteException -> 0x0085, all -> 0x0082 }
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid"
            java.lang.String r10 = "1000"
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x0085, all -> 0x0082 }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0080 }
            if (r3 != 0) goto L_0x003f
            if (r2 == 0) goto L_0x003e
            r2.close()
        L_0x003e:
            return r0
        L_0x003f:
            java.lang.String r7 = r2.getString(r12)     // Catch:{ SQLiteException -> 0x0080 }
            java.lang.String r3 = r2.getString(r11)     // Catch:{ SQLiteException -> 0x0080 }
            if (r3 != 0) goto L_0x004b
            java.lang.String r3 = ""
        L_0x004b:
            r6 = r3
            r3 = 2
            long r8 = r2.getLong(r3)     // Catch:{ SQLiteException -> 0x0080 }
            r3 = 3
            java.lang.Object r10 = r13.zza((android.database.Cursor) r2, (int) r3)     // Catch:{ SQLiteException -> 0x0080 }
            if (r10 != 0) goto L_0x006a
            com.google.android.gms.measurement.internal.zzex r3 = r13.zzq()     // Catch:{ SQLiteException -> 0x0080 }
            com.google.android.gms.measurement.internal.zzez r3 = r3.zze()     // Catch:{ SQLiteException -> 0x0080 }
            java.lang.String r4 = "Read invalid user property value, ignoring it. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r14)     // Catch:{ SQLiteException -> 0x0080 }
            r3.zza(r4, r5)     // Catch:{ SQLiteException -> 0x0080 }
            goto L_0x0074
        L_0x006a:
            com.google.android.gms.measurement.internal.zzky r3 = new com.google.android.gms.measurement.internal.zzky     // Catch:{ SQLiteException -> 0x0080 }
            r4 = r3
            r5 = r14
            r4.<init>(r5, r6, r7, r8, r10)     // Catch:{ SQLiteException -> 0x0080 }
            r0.add(r3)     // Catch:{ SQLiteException -> 0x0080 }
        L_0x0074:
            boolean r3 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0080 }
            if (r3 != 0) goto L_0x003f
            if (r2 == 0) goto L_0x007f
            r2.close()
        L_0x007f:
            return r0
        L_0x0080:
            r0 = move-exception
            goto L_0x0087
        L_0x0082:
            r14 = move-exception
            r2 = r1
            goto L_0x00bb
        L_0x0085:
            r0 = move-exception
            r2 = r1
        L_0x0087:
            com.google.android.gms.measurement.internal.zzex r3 = r13.zzq()     // Catch:{ all -> 0x00ba }
            com.google.android.gms.measurement.internal.zzez r3 = r3.zze()     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = "Error querying user properties. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r14)     // Catch:{ all -> 0x00ba }
            r3.zza(r4, r5, r0)     // Catch:{ all -> 0x00ba }
            boolean r0 = com.google.android.gms.internal.measurement.zzmy.zzb()     // Catch:{ all -> 0x00ba }
            if (r0 == 0) goto L_0x00b4
            com.google.android.gms.measurement.internal.zzy r0 = r13.zzs()     // Catch:{ all -> 0x00ba }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzcm     // Catch:{ all -> 0x00ba }
            boolean r14 = r0.zze(r14, r3)     // Catch:{ all -> 0x00ba }
            if (r14 == 0) goto L_0x00b4
            java.util.List r14 = java.util.Collections.emptyList()     // Catch:{ all -> 0x00ba }
            if (r2 == 0) goto L_0x00b3
            r2.close()
        L_0x00b3:
            return r14
        L_0x00b4:
            if (r2 == 0) goto L_0x00b9
            r2.close()
        L_0x00b9:
            return r1
        L_0x00ba:
            r14 = move-exception
        L_0x00bb:
            if (r2 == 0) goto L_0x00c0
            r2.close()
        L_0x00c0:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.zza(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00fb, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00fc, code lost:
        r12 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ff, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0100, code lost:
        r12 = r20;
        r3 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x013c, code lost:
        r9.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fb A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0011] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0128 A[Catch:{ all -> 0x0138 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x013c  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzky> zza(java.lang.String r21, java.lang.String r22, java.lang.String r23) {
        /*
            r20 = this;
            r8 = r21
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r21)
            r20.zzc()
            r20.zzaj()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r9 = 0
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fb }
            r10 = 3
            r1.<init>(r10)     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fb }
            r1.add(r8)     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fb }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fb }
            java.lang.String r3 = "app_id=?"
            r2.<init>(r3)     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fb }
            boolean r3 = android.text.TextUtils.isEmpty(r22)     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fb }
            if (r3 != 0) goto L_0x0032
            r3 = r22
            r1.add(r3)     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00fb }
            java.lang.String r4 = " and origin=?"
            r2.append(r4)     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00fb }
            goto L_0x0034
        L_0x0032:
            r3 = r22
        L_0x0034:
            boolean r4 = android.text.TextUtils.isEmpty(r23)     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00fb }
            if (r4 != 0) goto L_0x004c
            java.lang.String r4 = java.lang.String.valueOf(r23)     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00fb }
            java.lang.String r5 = "*"
            java.lang.String r4 = r4.concat(r5)     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00fb }
            r1.add(r4)     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00fb }
            java.lang.String r4 = " and name glob ?"
            r2.append(r4)     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00fb }
        L_0x004c:
            int r4 = r1.size()     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00fb }
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00fb }
            java.lang.Object[] r1 = r1.toArray(r4)     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00fb }
            r15 = r1
            java.lang.String[] r15 = (java.lang.String[]) r15     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00fb }
            android.database.sqlite.SQLiteDatabase r11 = r20.mo23015c_()     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00fb }
            java.lang.String r12 = "user_attributes"
            java.lang.String r1 = "name"
            java.lang.String r4 = "set_timestamp"
            java.lang.String r5 = "value"
            java.lang.String r6 = "origin"
            java.lang.String[] r13 = new java.lang.String[]{r1, r4, r5, r6}     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00fb }
            java.lang.String r14 = r2.toString()     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00fb }
            r16 = 0
            r17 = 0
            java.lang.String r18 = "rowid"
            java.lang.String r19 = "1001"
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00fb }
            boolean r1 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00ef }
            if (r1 != 0) goto L_0x0087
            if (r11 == 0) goto L_0x0086
            r11.close()
        L_0x0086:
            return r0
        L_0x0087:
            int r1 = r0.size()     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00ef }
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r1 < r2) goto L_0x00a3
            com.google.android.gms.measurement.internal.zzex r1 = r20.zzq()     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00ef }
            com.google.android.gms.measurement.internal.zzez r1 = r1.zze()     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00ef }
            java.lang.String r4 = "Read more than the max allowed user properties, ignoring excess"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00ef }
            r1.zza(r4, r2)     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00ef }
            r12 = r20
            goto L_0x00e2
        L_0x00a3:
            r1 = 0
            java.lang.String r4 = r11.getString(r1)     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00ef }
            r1 = 1
            long r5 = r11.getLong(r1)     // Catch:{ SQLiteException -> 0x00f3, all -> 0x00ef }
            r1 = 2
            r12 = r20
            java.lang.Object r7 = r12.zza((android.database.Cursor) r11, (int) r1)     // Catch:{ SQLiteException -> 0x00ed }
            java.lang.String r13 = r11.getString(r10)     // Catch:{ SQLiteException -> 0x00ed }
            if (r7 != 0) goto L_0x00ce
            com.google.android.gms.measurement.internal.zzex r1 = r20.zzq()     // Catch:{ SQLiteException -> 0x00ea }
            com.google.android.gms.measurement.internal.zzez r1 = r1.zze()     // Catch:{ SQLiteException -> 0x00ea }
            java.lang.String r2 = "(2)Read invalid user property value, ignoring it"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r21)     // Catch:{ SQLiteException -> 0x00ea }
            r14 = r23
            r1.zza(r2, r3, r13, r14)     // Catch:{ SQLiteException -> 0x00ea }
            goto L_0x00dc
        L_0x00ce:
            r14 = r23
            com.google.android.gms.measurement.internal.zzky r15 = new com.google.android.gms.measurement.internal.zzky     // Catch:{ SQLiteException -> 0x00ea }
            r1 = r15
            r2 = r21
            r3 = r13
            r1.<init>(r2, r3, r4, r5, r7)     // Catch:{ SQLiteException -> 0x00ea }
            r0.add(r15)     // Catch:{ SQLiteException -> 0x00ea }
        L_0x00dc:
            boolean r1 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x00ea }
            if (r1 != 0) goto L_0x00e8
        L_0x00e2:
            if (r11 == 0) goto L_0x00e7
            r11.close()
        L_0x00e7:
            return r0
        L_0x00e8:
            r3 = r13
            goto L_0x0087
        L_0x00ea:
            r0 = move-exception
            r3 = r13
            goto L_0x0105
        L_0x00ed:
            r0 = move-exception
            goto L_0x0105
        L_0x00ef:
            r0 = move-exception
            r12 = r20
            goto L_0x0139
        L_0x00f3:
            r0 = move-exception
            r12 = r20
            goto L_0x0105
        L_0x00f7:
            r0 = move-exception
            r12 = r20
            goto L_0x0104
        L_0x00fb:
            r0 = move-exception
            r12 = r20
            goto L_0x013a
        L_0x00ff:
            r0 = move-exception
            r12 = r20
            r3 = r22
        L_0x0104:
            r11 = r9
        L_0x0105:
            com.google.android.gms.measurement.internal.zzex r1 = r20.zzq()     // Catch:{ all -> 0x0138 }
            com.google.android.gms.measurement.internal.zzez r1 = r1.zze()     // Catch:{ all -> 0x0138 }
            java.lang.String r2 = "(2)Error querying user properties"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r21)     // Catch:{ all -> 0x0138 }
            r1.zza(r2, r4, r3, r0)     // Catch:{ all -> 0x0138 }
            boolean r0 = com.google.android.gms.internal.measurement.zzmy.zzb()     // Catch:{ all -> 0x0138 }
            if (r0 == 0) goto L_0x0132
            com.google.android.gms.measurement.internal.zzy r0 = r20.zzs()     // Catch:{ all -> 0x0138 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzat.zzcm     // Catch:{ all -> 0x0138 }
            boolean r0 = r0.zze(r8, r1)     // Catch:{ all -> 0x0138 }
            if (r0 == 0) goto L_0x0132
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0138 }
            if (r11 == 0) goto L_0x0131
            r11.close()
        L_0x0131:
            return r0
        L_0x0132:
            if (r11 == 0) goto L_0x0137
            r11.close()
        L_0x0137:
            return r9
        L_0x0138:
            r0 = move-exception
        L_0x0139:
            r9 = r11
        L_0x013a:
            if (r9 == 0) goto L_0x013f
            r9.close()
        L_0x013f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.zza(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    @WorkerThread
    public final boolean zza(zzw zzw) {
        Preconditions.checkNotNull(zzw);
        zzc();
        zzaj();
        if (zzc(zzw.zza, zzw.zzc.zza) == null) {
            if (zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzw.zza}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzw.zza);
        contentValues.put("origin", zzw.zzb);
        contentValues.put("name", zzw.zzc.zza);
        zza(contentValues, "value", zzw.zzc.zza());
        contentValues.put("active", Boolean.valueOf(zzw.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzw.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzw.zzh));
        zzo();
        contentValues.put("timed_out_event", zzkx.zza((Parcelable) zzw.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzw.zzd));
        zzo();
        contentValues.put("triggered_event", zzkx.zza((Parcelable) zzw.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzw.zzc.zzb));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzw.zzj));
        zzo();
        contentValues.put("expired_event", zzkx.zza((Parcelable) zzw.zzk));
        try {
            if (mo23015c_().insertWithOnConflict("conditional_properties", (String) null, contentValues, 5) == -1) {
                zzq().zze().zza("Failed to insert/update conditional user property (got -1)", zzex.zza(zzw.zza));
            }
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing conditional user property", zzex.zza(zzw.zza), e);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0125  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzw zzd(java.lang.String r30, java.lang.String r31) {
        /*
            r29 = this;
            r7 = r31
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r30)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r31)
            r29.zzc()
            r29.zzaj()
            r8 = 0
            android.database.sqlite.SQLiteDatabase r9 = r29.mo23015c_()     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fa }
            java.lang.String r10 = "conditional_properties"
            java.lang.String r11 = "origin"
            java.lang.String r12 = "value"
            java.lang.String r13 = "active"
            java.lang.String r14 = "trigger_event_name"
            java.lang.String r15 = "trigger_timeout"
            java.lang.String r16 = "timed_out_event"
            java.lang.String r17 = "creation_timestamp"
            java.lang.String r18 = "triggered_event"
            java.lang.String r19 = "triggered_timestamp"
            java.lang.String r20 = "time_to_live"
            java.lang.String r21 = "expired_event"
            java.lang.String[] r11 = new java.lang.String[]{r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21}     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fa }
            java.lang.String r12 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r13 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fa }
            r1 = 0
            r13[r1] = r30     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fa }
            r2 = 1
            r13[r2] = r7     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fa }
            r14 = 0
            r15 = 0
            r16 = 0
            android.database.Cursor r9 = r9.query(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ SQLiteException -> 0x00ff, all -> 0x00fa }
            boolean r3 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00f2 }
            if (r3 != 0) goto L_0x004e
            if (r9 == 0) goto L_0x004d
            r9.close()
        L_0x004d:
            return r8
        L_0x004e:
            java.lang.String r16 = r9.getString(r1)     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00f2 }
            r10 = r29
            java.lang.Object r5 = r10.zza((android.database.Cursor) r9, (int) r2)     // Catch:{ SQLiteException -> 0x00f0 }
            int r0 = r9.getInt(r0)     // Catch:{ SQLiteException -> 0x00f0 }
            if (r0 == 0) goto L_0x0061
            r20 = 1
            goto L_0x0063
        L_0x0061:
            r20 = 0
        L_0x0063:
            r0 = 3
            java.lang.String r21 = r9.getString(r0)     // Catch:{ SQLiteException -> 0x00f0 }
            r0 = 4
            long r23 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00f0 }
            com.google.android.gms.measurement.internal.zzkt r0 = r29.mo23251f_()     // Catch:{ SQLiteException -> 0x00f0 }
            r1 = 5
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x00f0 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzar> r2 = com.google.android.gms.measurement.internal.zzar.CREATOR     // Catch:{ SQLiteException -> 0x00f0 }
            android.os.Parcelable r0 = r0.zza((byte[]) r1, r2)     // Catch:{ SQLiteException -> 0x00f0 }
            r22 = r0
            com.google.android.gms.measurement.internal.zzar r22 = (com.google.android.gms.measurement.internal.zzar) r22     // Catch:{ SQLiteException -> 0x00f0 }
            r0 = 6
            long r18 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00f0 }
            com.google.android.gms.measurement.internal.zzkt r0 = r29.mo23251f_()     // Catch:{ SQLiteException -> 0x00f0 }
            r1 = 7
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x00f0 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzar> r2 = com.google.android.gms.measurement.internal.zzar.CREATOR     // Catch:{ SQLiteException -> 0x00f0 }
            android.os.Parcelable r0 = r0.zza((byte[]) r1, r2)     // Catch:{ SQLiteException -> 0x00f0 }
            r25 = r0
            com.google.android.gms.measurement.internal.zzar r25 = (com.google.android.gms.measurement.internal.zzar) r25     // Catch:{ SQLiteException -> 0x00f0 }
            r0 = 8
            long r3 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00f0 }
            r0 = 9
            long r26 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00f0 }
            com.google.android.gms.measurement.internal.zzkt r0 = r29.mo23251f_()     // Catch:{ SQLiteException -> 0x00f0 }
            r1 = 10
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x00f0 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzar> r2 = com.google.android.gms.measurement.internal.zzar.CREATOR     // Catch:{ SQLiteException -> 0x00f0 }
            android.os.Parcelable r0 = r0.zza((byte[]) r1, r2)     // Catch:{ SQLiteException -> 0x00f0 }
            r28 = r0
            com.google.android.gms.measurement.internal.zzar r28 = (com.google.android.gms.measurement.internal.zzar) r28     // Catch:{ SQLiteException -> 0x00f0 }
            com.google.android.gms.measurement.internal.zzkw r17 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ SQLiteException -> 0x00f0 }
            r1 = r17
            r2 = r31
            r6 = r16
            r1.<init>(r2, r3, r5, r6)     // Catch:{ SQLiteException -> 0x00f0 }
            com.google.android.gms.measurement.internal.zzw r0 = new com.google.android.gms.measurement.internal.zzw     // Catch:{ SQLiteException -> 0x00f0 }
            r14 = r0
            r15 = r30
            r14.<init>(r15, r16, r17, r18, r20, r21, r22, r23, r25, r26, r28)     // Catch:{ SQLiteException -> 0x00f0 }
            boolean r1 = r9.moveToNext()     // Catch:{ SQLiteException -> 0x00f0 }
            if (r1 == 0) goto L_0x00ea
            com.google.android.gms.measurement.internal.zzex r1 = r29.zzq()     // Catch:{ SQLiteException -> 0x00f0 }
            com.google.android.gms.measurement.internal.zzez r1 = r1.zze()     // Catch:{ SQLiteException -> 0x00f0 }
            java.lang.String r2 = "Got multiple records for conditional property, expected one"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r30)     // Catch:{ SQLiteException -> 0x00f0 }
            com.google.android.gms.measurement.internal.zzev r4 = r29.zzn()     // Catch:{ SQLiteException -> 0x00f0 }
            java.lang.String r4 = r4.zzc(r7)     // Catch:{ SQLiteException -> 0x00f0 }
            r1.zza(r2, r3, r4)     // Catch:{ SQLiteException -> 0x00f0 }
        L_0x00ea:
            if (r9 == 0) goto L_0x00ef
            r9.close()
        L_0x00ef:
            return r0
        L_0x00f0:
            r0 = move-exception
            goto L_0x0103
        L_0x00f2:
            r0 = move-exception
            r10 = r29
            goto L_0x0123
        L_0x00f6:
            r0 = move-exception
            r10 = r29
            goto L_0x0103
        L_0x00fa:
            r0 = move-exception
            r10 = r29
            r9 = r8
            goto L_0x0123
        L_0x00ff:
            r0 = move-exception
            r10 = r29
            r9 = r8
        L_0x0103:
            com.google.android.gms.measurement.internal.zzex r1 = r29.zzq()     // Catch:{ all -> 0x0122 }
            com.google.android.gms.measurement.internal.zzez r1 = r1.zze()     // Catch:{ all -> 0x0122 }
            java.lang.String r2 = "Error querying conditional property"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r30)     // Catch:{ all -> 0x0122 }
            com.google.android.gms.measurement.internal.zzev r4 = r29.zzn()     // Catch:{ all -> 0x0122 }
            java.lang.String r4 = r4.zzc(r7)     // Catch:{ all -> 0x0122 }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x0122 }
            if (r9 == 0) goto L_0x0121
            r9.close()
        L_0x0121:
            return r8
        L_0x0122:
            r0 = move-exception
        L_0x0123:
            if (r9 == 0) goto L_0x0128
            r9.close()
        L_0x0128:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.zzd(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzw");
    }

    @WorkerThread
    public final int zze(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzc();
        zzaj();
        try {
            return mo23015c_().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzq().zze().zza("Error deleting conditional property", zzex.zza(str), zzn().zzc(str2), e);
            return 0;
        }
    }

    @WorkerThread
    public final List<zzw> zzb(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzc();
        zzaj();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final List<zzw> zza(String str, String[] strArr) {
        zzc();
        zzaj();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = mo23015c_().query("conditional_properties", new String[]{"app_id", "origin", "name", "value", "active", AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"}, str, strArr, (String) null, (String) null, "rowid", "1001");
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            while (true) {
                if (arrayList.size() < 1000) {
                    boolean z = false;
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    String string3 = cursor.getString(2);
                    Object zza = zza(cursor, 3);
                    if (cursor.getInt(4) != 0) {
                        z = true;
                    }
                    String string4 = cursor.getString(5);
                    long j = cursor.getLong(6);
                    long j2 = cursor.getLong(8);
                    long j3 = cursor.getLong(10);
                    boolean z2 = z;
                    zzw zzw = r3;
                    zzw zzw2 = new zzw(string, string2, new zzkw(string3, j3, zza, string2), j2, z2, string4, (zzar) mo23251f_().zza(cursor.getBlob(7), zzar.CREATOR), j, (zzar) mo23251f_().zza(cursor.getBlob(9), zzar.CREATOR), cursor.getLong(11), (zzar) mo23251f_().zza(cursor.getBlob(12), zzar.CREATOR));
                    arrayList.add(zzw);
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } else {
                    zzq().zze().zza("Read more than the max allowed conditional properties, ignoring extra", 1000);
                    break;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error querying conditional user property value", e);
            List<zzw> emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x011b A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x011f A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0159 A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0172 A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0187 A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01a3 A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01a4 A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01b3 A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01e9 A[Catch:{ SQLiteException -> 0x0200 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x022d  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzf zzb(java.lang.String r35) {
        /*
            r34 = this;
            r1 = r35
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r35)
            r34.zzc()
            r34.zzaj()
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r34.mo23015c_()     // Catch:{ SQLiteException -> 0x020f, all -> 0x020a }
            java.lang.String r4 = "apps"
            java.lang.String r5 = "app_instance_id"
            java.lang.String r6 = "gmp_app_id"
            java.lang.String r7 = "resettable_device_id_hash"
            java.lang.String r8 = "last_bundle_index"
            java.lang.String r9 = "last_bundle_start_timestamp"
            java.lang.String r10 = "last_bundle_end_timestamp"
            java.lang.String r11 = "app_version"
            java.lang.String r12 = "app_store"
            java.lang.String r13 = "gmp_version"
            java.lang.String r14 = "dev_cert_hash"
            java.lang.String r15 = "measurement_enabled"
            java.lang.String r16 = "day"
            java.lang.String r17 = "daily_public_events_count"
            java.lang.String r18 = "daily_events_count"
            java.lang.String r19 = "daily_conversions_count"
            java.lang.String r20 = "config_fetched_time"
            java.lang.String r21 = "failed_config_fetch_time"
            java.lang.String r22 = "app_version_int"
            java.lang.String r23 = "firebase_instance_id"
            java.lang.String r24 = "daily_error_events_count"
            java.lang.String r25 = "daily_realtime_events_count"
            java.lang.String r26 = "health_monitor_sample"
            java.lang.String r27 = "android_id"
            java.lang.String r28 = "adid_reporting_enabled"
            java.lang.String r29 = "ssaid_reporting_enabled"
            java.lang.String r30 = "admob_app_id"
            java.lang.String r31 = "dynamite_version"
            java.lang.String r32 = "safelisted_events"
            java.lang.String r33 = "ga_app_id"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33}     // Catch:{ SQLiteException -> 0x020f, all -> 0x020a }
            java.lang.String r6 = "app_id=?"
            r0 = 1
            java.lang.String[] r7 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x020f, all -> 0x020a }
            r11 = 0
            r7[r11] = r1     // Catch:{ SQLiteException -> 0x020f, all -> 0x020a }
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x020f, all -> 0x020a }
            boolean r4 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0206, all -> 0x0202 }
            if (r4 != 0) goto L_0x006b
            if (r3 == 0) goto L_0x006a
            r3.close()
        L_0x006a:
            return r2
        L_0x006b:
            com.google.android.gms.measurement.internal.zzf r4 = new com.google.android.gms.measurement.internal.zzf     // Catch:{ SQLiteException -> 0x0206, all -> 0x0202 }
            r5 = r34
            com.google.android.gms.measurement.internal.zzkp r6 = r5.zza     // Catch:{ SQLiteException -> 0x0200 }
            com.google.android.gms.measurement.internal.zzgb r6 = r6.zzu()     // Catch:{ SQLiteException -> 0x0200 }
            r4.<init>(r6, r1)     // Catch:{ SQLiteException -> 0x0200 }
            java.lang.String r6 = r3.getString(r11)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zza((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0200 }
            java.lang.String r6 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzb((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 2
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zze((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 3
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzg((long) r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 4
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zza((long) r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 5
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzb((long) r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 6
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzg((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 7
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzh((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 8
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzd((long) r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 9
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zze((long) r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 10
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x0200 }
            if (r7 != 0) goto L_0x00d9
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x0200 }
            if (r6 == 0) goto L_0x00d7
            goto L_0x00d9
        L_0x00d7:
            r6 = 0
            goto L_0x00da
        L_0x00d9:
            r6 = 1
        L_0x00da:
            r4.zza((boolean) r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 11
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzj(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 12
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzk(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 13
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzl(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 14
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzm(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 15
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzh((long) r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 16
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzi((long) r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 17
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x0200 }
            if (r7 == 0) goto L_0x011f
            r6 = -2147483648(0xffffffff80000000, double:NaN)
            goto L_0x0124
        L_0x011f:
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x0200 }
            long r6 = (long) r6     // Catch:{ SQLiteException -> 0x0200 }
        L_0x0124:
            r4.zzc((long) r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 18
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzf((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 19
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzo(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 20
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzn(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 21
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzi((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0200 }
            com.google.android.gms.measurement.internal.zzy r6 = r34.zzs()     // Catch:{ SQLiteException -> 0x0200 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzat.zzcf     // Catch:{ SQLiteException -> 0x0200 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r7)     // Catch:{ SQLiteException -> 0x0200 }
            r7 = 0
            if (r6 != 0) goto L_0x016a
            r6 = 22
            boolean r9 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x0200 }
            if (r9 == 0) goto L_0x0163
            r9 = r7
            goto L_0x0167
        L_0x0163:
            long r9 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0200 }
        L_0x0167:
            r4.zzp(r9)     // Catch:{ SQLiteException -> 0x0200 }
        L_0x016a:
            r6 = 23
            boolean r9 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x0200 }
            if (r9 != 0) goto L_0x017b
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x0200 }
            if (r6 == 0) goto L_0x0179
            goto L_0x017b
        L_0x0179:
            r6 = 0
            goto L_0x017c
        L_0x017b:
            r6 = 1
        L_0x017c:
            r4.zzb((boolean) r6)     // Catch:{ SQLiteException -> 0x0200 }
            r6 = 24
            boolean r9 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x0200 }
            if (r9 != 0) goto L_0x018f
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x0200 }
            if (r6 == 0) goto L_0x018e
            goto L_0x018f
        L_0x018e:
            r0 = 0
        L_0x018f:
            r4.zzc((boolean) r0)     // Catch:{ SQLiteException -> 0x0200 }
            r0 = 25
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzc((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x0200 }
            r0 = 26
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x0200 }
            if (r6 == 0) goto L_0x01a4
            goto L_0x01a8
        L_0x01a4:
            long r7 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x0200 }
        L_0x01a8:
            r4.zzf((long) r7)     // Catch:{ SQLiteException -> 0x0200 }
            r0 = 27
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x0200 }
            if (r6 != 0) goto L_0x01c5
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x0200 }
            java.lang.String r6 = ","
            r7 = -1
            java.lang.String[] r0 = r0.split(r6, r7)     // Catch:{ SQLiteException -> 0x0200 }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zza((java.util.List<java.lang.String>) r0)     // Catch:{ SQLiteException -> 0x0200 }
        L_0x01c5:
            boolean r0 = com.google.android.gms.internal.measurement.zznq.zzb()     // Catch:{ SQLiteException -> 0x0200 }
            if (r0 == 0) goto L_0x01e0
            com.google.android.gms.measurement.internal.zzy r0 = r34.zzs()     // Catch:{ SQLiteException -> 0x0200 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzat.zzbj     // Catch:{ SQLiteException -> 0x0200 }
            boolean r0 = r0.zze(r1, r6)     // Catch:{ SQLiteException -> 0x0200 }
            if (r0 == 0) goto L_0x01e0
            r0 = 28
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x0200 }
            r4.zzd((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x0200 }
        L_0x01e0:
            r4.zzb()     // Catch:{ SQLiteException -> 0x0200 }
            boolean r0 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x0200 }
            if (r0 == 0) goto L_0x01fa
            com.google.android.gms.measurement.internal.zzex r0 = r34.zzq()     // Catch:{ SQLiteException -> 0x0200 }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zze()     // Catch:{ SQLiteException -> 0x0200 }
            java.lang.String r6 = "Got multiple records for app, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r35)     // Catch:{ SQLiteException -> 0x0200 }
            r0.zza(r6, r7)     // Catch:{ SQLiteException -> 0x0200 }
        L_0x01fa:
            if (r3 == 0) goto L_0x01ff
            r3.close()
        L_0x01ff:
            return r4
        L_0x0200:
            r0 = move-exception
            goto L_0x0213
        L_0x0202:
            r0 = move-exception
            r5 = r34
            goto L_0x022b
        L_0x0206:
            r0 = move-exception
            r5 = r34
            goto L_0x0213
        L_0x020a:
            r0 = move-exception
            r5 = r34
            r3 = r2
            goto L_0x022b
        L_0x020f:
            r0 = move-exception
            r5 = r34
            r3 = r2
        L_0x0213:
            com.google.android.gms.measurement.internal.zzex r4 = r34.zzq()     // Catch:{ all -> 0x022a }
            com.google.android.gms.measurement.internal.zzez r4 = r4.zze()     // Catch:{ all -> 0x022a }
            java.lang.String r6 = "Error querying app. appId"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r35)     // Catch:{ all -> 0x022a }
            r4.zza(r6, r1, r0)     // Catch:{ all -> 0x022a }
            if (r3 == 0) goto L_0x0229
            r3.close()
        L_0x0229:
            return r2
        L_0x022a:
            r0 = move-exception
        L_0x022b:
            if (r3 == 0) goto L_0x0230
            r3.close()
        L_0x0230:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.zzb(java.lang.String):com.google.android.gms.measurement.internal.zzf");
    }

    @WorkerThread
    public final void zza(zzf zzf2) {
        Preconditions.checkNotNull(zzf2);
        zzc();
        zzaj();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzf2.zzc());
        contentValues.put("app_instance_id", zzf2.zzd());
        contentValues.put("gmp_app_id", zzf2.zze());
        contentValues.put("resettable_device_id_hash", zzf2.zzh());
        contentValues.put("last_bundle_index", Long.valueOf(zzf2.zzs()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzf2.zzj()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzf2.zzk()));
        contentValues.put(C4002i.C4003a.f2856q, zzf2.zzl());
        contentValues.put("app_store", zzf2.zzn());
        contentValues.put("gmp_version", Long.valueOf(zzf2.zzo()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzf2.zzp()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzf2.zzr()));
        contentValues.put("day", Long.valueOf(zzf2.zzw()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzf2.zzx()));
        contentValues.put("daily_events_count", Long.valueOf(zzf2.zzy()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzf2.zzz()));
        contentValues.put("config_fetched_time", Long.valueOf(zzf2.zzt()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzf2.zzu()));
        contentValues.put("app_version_int", Long.valueOf(zzf2.zzm()));
        contentValues.put("firebase_instance_id", zzf2.zzi());
        contentValues.put("daily_error_events_count", Long.valueOf(zzf2.zzab()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzf2.zzaa()));
        contentValues.put("health_monitor_sample", zzf2.zzac());
        contentValues.put(C4820b.f5526f, Long.valueOf(zzf2.zzae()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzf2.zzaf()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(zzf2.zzag()));
        contentValues.put("admob_app_id", zzf2.zzf());
        contentValues.put("dynamite_version", Long.valueOf(zzf2.zzq()));
        if (zzf2.zzai() != null) {
            if (zzf2.zzai().size() == 0) {
                zzq().zzh().zza("Safelisted events should not be an empty list. appId", zzf2.zzc());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzf2.zzai()));
            }
        }
        if (zznq.zzb() && zzs().zze(zzf2.zzc(), zzat.zzbj)) {
            contentValues.put("ga_app_id", zzf2.zzg());
        }
        try {
            SQLiteDatabase c_ = mo23015c_();
            if (((long) c_.update("apps", contentValues, "app_id = ?", new String[]{zzf2.zzc()})) == 0 && c_.insertWithOnConflict("apps", (String) null, contentValues, 5) == -1) {
                zzq().zze().zza("Failed to insert/update app (got -1). appId", zzex.zza(zzf2.zzc()));
            }
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing app. appId", zzex.zza(zzf2.zzc()), e);
        }
    }

    public final long zzc(String str) {
        Preconditions.checkNotEmpty(str);
        zzc();
        zzaj();
        try {
            return (long) mo23015c_().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zzs().zzb(str, zzat.zzo))))});
        } catch (SQLiteException e) {
            zzq().zze().zza("Error deleting over the limit events. appId", zzex.zza(str), e);
            return 0;
        }
    }

    @WorkerThread
    public final zzaf zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return zza(j, str, 1, false, false, z3, false, z5);
    }

    @WorkerThread
    public final zzaf zza(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Preconditions.checkNotEmpty(str);
        zzc();
        zzaj();
        String[] strArr = {str};
        zzaf zzaf = new zzaf();
        Cursor cursor = null;
        try {
            SQLiteDatabase c_ = mo23015c_();
            cursor = c_.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                zzq().zzh().zza("Not updating daily counts, app is not known. appId", zzex.zza(str));
                if (cursor != null) {
                    cursor.close();
                }
                return zzaf;
            }
            if (cursor.getLong(0) == j) {
                zzaf.zzb = cursor.getLong(1);
                zzaf.zza = cursor.getLong(2);
                zzaf.zzc = cursor.getLong(3);
                zzaf.zzd = cursor.getLong(4);
                zzaf.zze = cursor.getLong(5);
            }
            if (z) {
                zzaf.zzb += j2;
            }
            if (z2) {
                zzaf.zza += j2;
            }
            if (z3) {
                zzaf.zzc += j2;
            }
            if (z4) {
                zzaf.zzd += j2;
            }
            if (z5) {
                zzaf.zze += j2;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("day", Long.valueOf(j));
            contentValues.put("daily_public_events_count", Long.valueOf(zzaf.zza));
            contentValues.put("daily_events_count", Long.valueOf(zzaf.zzb));
            contentValues.put("daily_conversions_count", Long.valueOf(zzaf.zzc));
            contentValues.put("daily_error_events_count", Long.valueOf(zzaf.zzd));
            contentValues.put("daily_realtime_events_count", Long.valueOf(zzaf.zze));
            c_.update("apps", contentValues, "app_id=?", strArr);
            if (cursor != null) {
                cursor.close();
            }
            return zzaf;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error updating daily counts. appId", zzex.zza(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return zzaf;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0073  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zzd(java.lang.String r11) {
        /*
            r10 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r11)
            r10.zzc()
            r10.zzaj()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.mo23015c_()     // Catch:{ SQLiteException -> 0x0057, all -> 0x0054 }
            java.lang.String r2 = "apps"
            java.lang.String r3 = "remote_config"
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x0057, all -> 0x0054 }
            java.lang.String r4 = "app_id=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0057, all -> 0x0054 }
            r9 = 0
            r5[r9] = r11     // Catch:{ SQLiteException -> 0x0057, all -> 0x0054 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0057, all -> 0x0054 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0052 }
            if (r2 != 0) goto L_0x0031
            if (r1 == 0) goto L_0x0030
            r1.close()
        L_0x0030:
            return r0
        L_0x0031:
            byte[] r2 = r1.getBlob(r9)     // Catch:{ SQLiteException -> 0x0052 }
            boolean r3 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0052 }
            if (r3 == 0) goto L_0x004c
            com.google.android.gms.measurement.internal.zzex r3 = r10.zzq()     // Catch:{ SQLiteException -> 0x0052 }
            com.google.android.gms.measurement.internal.zzez r3 = r3.zze()     // Catch:{ SQLiteException -> 0x0052 }
            java.lang.String r4 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r11)     // Catch:{ SQLiteException -> 0x0052 }
            r3.zza(r4, r5)     // Catch:{ SQLiteException -> 0x0052 }
        L_0x004c:
            if (r1 == 0) goto L_0x0051
            r1.close()
        L_0x0051:
            return r2
        L_0x0052:
            r2 = move-exception
            goto L_0x0059
        L_0x0054:
            r11 = move-exception
            r1 = r0
            goto L_0x0071
        L_0x0057:
            r2 = move-exception
            r1 = r0
        L_0x0059:
            com.google.android.gms.measurement.internal.zzex r3 = r10.zzq()     // Catch:{ all -> 0x0070 }
            com.google.android.gms.measurement.internal.zzez r3 = r3.zze()     // Catch:{ all -> 0x0070 }
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r11)     // Catch:{ all -> 0x0070 }
            r3.zza(r4, r11, r2)     // Catch:{ all -> 0x0070 }
            if (r1 == 0) goto L_0x006f
            r1.close()
        L_0x006f:
            return r0
        L_0x0070:
            r11 = move-exception
        L_0x0071:
            if (r1 == 0) goto L_0x0076
            r1.close()
        L_0x0076:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.zzd(java.lang.String):byte[]");
    }

    @WorkerThread
    public final boolean zza(zzcd.zzg zzg2, boolean z) {
        zzc();
        zzaj();
        Preconditions.checkNotNull(zzg2);
        Preconditions.checkNotEmpty(zzg2.zzx());
        Preconditions.checkState(zzg2.zzk());
        zzu();
        long currentTimeMillis = zzl().currentTimeMillis();
        if (zzg2.zzl() < currentTimeMillis - zzy.zzi() || zzg2.zzl() > zzy.zzi() + currentTimeMillis) {
            zzq().zzh().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzex.zza(zzg2.zzx()), Long.valueOf(currentTimeMillis), Long.valueOf(zzg2.zzl()));
        }
        try {
            byte[] zzc2 = mo23251f_().zzc(zzg2.zzbk());
            zzq().zzw().zza("Saving bundle, size", Integer.valueOf(zzc2.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzg2.zzx());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzg2.zzl()));
            contentValues.put("data", zzc2);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzg2.zzaz()) {
                contentValues.put("retry_count", Integer.valueOf(zzg2.zzba()));
            }
            try {
                if (mo23015c_().insert("queue", (String) null, contentValues) != -1) {
                    return true;
                }
                zzq().zze().zza("Failed to insert bundle (got -1). appId", zzex.zza(zzg2.zzx()));
                return false;
            } catch (SQLiteException e) {
                zzq().zze().zza("Error storing bundle. appId", zzex.zza(zzg2.zzx()), e);
                return false;
            }
        } catch (IOException e2) {
            zzq().zze().zza("Data loss. Failed to serialize bundle. appId", zzex.zza(zzg2.zzx()), e2);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0041  */
    @androidx.annotation.WorkerThread
    /* renamed from: d_ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String mo23016d_() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.mo23015c_()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x0029, all -> 0x0024 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x0022 }
            if (r2 == 0) goto L_0x001c
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x0022 }
            if (r0 == 0) goto L_0x001b
            r0.close()
        L_0x001b:
            return r1
        L_0x001c:
            if (r0 == 0) goto L_0x0021
            r0.close()
        L_0x0021:
            return r1
        L_0x0022:
            r2 = move-exception
            goto L_0x002b
        L_0x0024:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x003f
        L_0x0029:
            r2 = move-exception
            r0 = r1
        L_0x002b:
            com.google.android.gms.measurement.internal.zzex r3 = r6.zzq()     // Catch:{ all -> 0x003e }
            com.google.android.gms.measurement.internal.zzez r3 = r3.zze()     // Catch:{ all -> 0x003e }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zza(r4, r2)     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x003d
            r0.close()
        L_0x003d:
            return r1
        L_0x003e:
            r1 = move-exception
        L_0x003f:
            if (r0 == 0) goto L_0x0044
            r0.close()
        L_0x0044:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.mo23016d_():java.lang.String");
    }

    /* renamed from: e_ */
    public final boolean mo23017e_() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    @WorkerThread
    public final List<Pair<zzcd.zzg, Long>> zza(String str, int i, int i2) {
        zzc();
        zzaj();
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            cursor = mo23015c_().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, (String) null, (String) null, "rowid", String.valueOf(i));
            if (!cursor.moveToFirst()) {
                List<Pair<zzcd.zzg, Long>> emptyList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList;
            }
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            do {
                long j = cursor.getLong(0);
                try {
                    byte[] zzb2 = mo23251f_().zzb(cursor.getBlob(1));
                    if (!arrayList.isEmpty() && zzb2.length + i3 > i2) {
                        break;
                    }
                    try {
                        zzcd.zzg.zza zza = (zzcd.zzg.zza) zzkt.zza(zzcd.zzg.zzbh(), zzb2);
                        if (!cursor.isNull(2)) {
                            zza.zzi(cursor.getInt(2));
                        }
                        i3 += zzb2.length;
                        arrayList.add(Pair.create((zzcd.zzg) ((zzhv) zza.zzy()), Long.valueOf(j)));
                    } catch (IOException e) {
                        zzq().zze().zza("Failed to merge queued bundle. appId", zzex.zza(str), e);
                    }
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } catch (IOException e2) {
                    zzq().zze().zza("Failed to unzip queued bundle. appId", zzex.zza(str), e2);
                }
            } while (i3 <= i2);
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (SQLiteException e3) {
            zzq().zze().zza("Error querying bundles. appId", zzex.zza(str), e3);
            List<Pair<zzcd.zzg, Long>> emptyList2 = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzu() {
        int delete;
        zzc();
        zzaj();
        if (zzal()) {
            long zza = zzr().zzf.zza();
            long elapsedRealtime = zzl().elapsedRealtime();
            if (Math.abs(elapsedRealtime - zza) > zzat.zzx.zza(null).longValue()) {
                zzr().zzf.zza(elapsedRealtime);
                zzc();
                zzaj();
                if (zzal() && (delete = mo23015c_().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzl().currentTimeMillis()), String.valueOf(zzy.zzi())})) > 0) {
                    zzq().zzw().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final void zza(List<Long> list) {
        zzc();
        zzaj();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzal()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zzb(sb3.toString(), (String[]) null) > 0) {
                zzq().zzh().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase c_ = mo23015c_();
                StringBuilder sb4 = new StringBuilder(String.valueOf(sb2).length() + 127);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                c_.execSQL(sb4.toString());
            } catch (SQLiteException e) {
                zzq().zze().zza("Error incrementing retry count. error", e);
            }
        }
    }

    @WorkerThread
    private final boolean zza(String str, int i, zzbv.zzb zzb2) {
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzb2);
        Integer num = null;
        if (TextUtils.isEmpty(zzb2.zzc())) {
            zzez zzh2 = zzq().zzh();
            Object zza = zzex.zza(str);
            Integer valueOf = Integer.valueOf(i);
            if (zzb2.zza()) {
                num = Integer.valueOf(zzb2.zzb());
            }
            zzh2.zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zza, valueOf, String.valueOf(num));
            return false;
        }
        byte[] zzbk = zzb2.zzbk();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzb2.zza() ? Integer.valueOf(zzb2.zzb()) : null);
        contentValues.put("event_name", zzb2.zzc());
        contentValues.put("session_scoped", zzb2.zzj() ? Boolean.valueOf(zzb2.zzk()) : null);
        contentValues.put("data", zzbk);
        try {
            if (mo23015c_().insertWithOnConflict("event_filters", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzq().zze().zza("Failed to insert event filter (got -1). appId", zzex.zza(str));
            return true;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing event filter. appId", zzex.zza(str), e);
            return false;
        }
    }

    @WorkerThread
    private final boolean zza(String str, int i, zzbv.zze zze2) {
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zze2);
        Integer num = null;
        if (TextUtils.isEmpty(zze2.zzc())) {
            zzez zzh2 = zzq().zzh();
            Object zza = zzex.zza(str);
            Integer valueOf = Integer.valueOf(i);
            if (zze2.zza()) {
                num = Integer.valueOf(zze2.zzb());
            }
            zzh2.zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zza, valueOf, String.valueOf(num));
            return false;
        }
        byte[] zzbk = zze2.zzbk();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zze2.zza() ? Integer.valueOf(zze2.zzb()) : null);
        contentValues.put("property_name", zze2.zzc());
        contentValues.put("session_scoped", zze2.zzg() ? Boolean.valueOf(zze2.zzh()) : null);
        contentValues.put("data", zzbk);
        try {
            if (mo23015c_().insertWithOnConflict("property_filters", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzq().zze().zza("Failed to insert property filter (got -1). appId", zzex.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing property filter. appId", zzex.zza(str), e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c0 A[Catch:{ all -> 0x00d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzbv.zzb>> zzf(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.zzaj()
            r12.zzc()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.mo23015c_()
            r9 = 0
            java.lang.String r2 = "event_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ SQLiteException -> 0x009b, all -> 0x0098 }
            java.lang.String r4 = "app_id=? AND event_name=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x009b, all -> 0x0098 }
            r10 = 0
            r5[r10] = r13     // Catch:{ SQLiteException -> 0x009b, all -> 0x0098 }
            r11 = 1
            r5[r11] = r14     // Catch:{ SQLiteException -> 0x009b, all -> 0x0098 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x009b, all -> 0x0098 }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x0096 }
            if (r1 != 0) goto L_0x0042
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0096 }
            if (r14 == 0) goto L_0x0041
            r14.close()
        L_0x0041:
            return r13
        L_0x0042:
            byte[] r1 = r14.getBlob(r11)     // Catch:{ SQLiteException -> 0x0096 }
            com.google.android.gms.internal.measurement.zzbv$zzb$zza r2 = com.google.android.gms.internal.measurement.zzbv.zzb.zzl()     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.zzjf r1 = com.google.android.gms.measurement.internal.zzkt.zza(r2, (byte[]) r1)     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.zzbv$zzb$zza r1 = (com.google.android.gms.internal.measurement.zzbv.zzb.zza) r1     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.zzjg r1 = r1.zzy()     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.zzhv r1 = (com.google.android.gms.internal.measurement.zzhv) r1     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.zzbv$zzb r1 = (com.google.android.gms.internal.measurement.zzbv.zzb) r1     // Catch:{ IOException -> 0x0078 }
            int r2 = r14.getInt(r10)     // Catch:{ SQLiteException -> 0x0096 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0096 }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ SQLiteException -> 0x0096 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ SQLiteException -> 0x0096 }
            if (r3 != 0) goto L_0x0074
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0096 }
            r3.<init>()     // Catch:{ SQLiteException -> 0x0096 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0096 }
            r0.put(r2, r3)     // Catch:{ SQLiteException -> 0x0096 }
        L_0x0074:
            r3.add(r1)     // Catch:{ SQLiteException -> 0x0096 }
            goto L_0x008a
        L_0x0078:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzex r2 = r12.zzq()     // Catch:{ SQLiteException -> 0x0096 }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zze()     // Catch:{ SQLiteException -> 0x0096 }
            java.lang.String r3 = "Failed to merge filter. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r13)     // Catch:{ SQLiteException -> 0x0096 }
            r2.zza(r3, r4, r1)     // Catch:{ SQLiteException -> 0x0096 }
        L_0x008a:
            boolean r1 = r14.moveToNext()     // Catch:{ SQLiteException -> 0x0096 }
            if (r1 != 0) goto L_0x0042
            if (r14 == 0) goto L_0x0095
            r14.close()
        L_0x0095:
            return r0
        L_0x0096:
            r0 = move-exception
            goto L_0x009d
        L_0x0098:
            r13 = move-exception
            r14 = r9
            goto L_0x00d1
        L_0x009b:
            r0 = move-exception
            r14 = r9
        L_0x009d:
            com.google.android.gms.measurement.internal.zzex r1 = r12.zzq()     // Catch:{ all -> 0x00d0 }
            com.google.android.gms.measurement.internal.zzez r1 = r1.zze()     // Catch:{ all -> 0x00d0 }
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r13)     // Catch:{ all -> 0x00d0 }
            r1.zza(r2, r3, r0)     // Catch:{ all -> 0x00d0 }
            boolean r0 = com.google.android.gms.internal.measurement.zzmy.zzb()     // Catch:{ all -> 0x00d0 }
            if (r0 == 0) goto L_0x00ca
            com.google.android.gms.measurement.internal.zzy r0 = r12.zzs()     // Catch:{ all -> 0x00d0 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzat.zzcm     // Catch:{ all -> 0x00d0 }
            boolean r13 = r0.zze(r13, r1)     // Catch:{ all -> 0x00d0 }
            if (r13 == 0) goto L_0x00ca
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x00d0 }
            if (r14 == 0) goto L_0x00c9
            r14.close()
        L_0x00c9:
            return r13
        L_0x00ca:
            if (r14 == 0) goto L_0x00cf
            r14.close()
        L_0x00cf:
            return r9
        L_0x00d0:
            r13 = move-exception
        L_0x00d1:
            if (r14 == 0) goto L_0x00d6
            r14.close()
        L_0x00d6:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.zzf(java.lang.String, java.lang.String):java.util.Map");
    }

    /* access modifiers changed from: package-private */
    public final Map<Integer, List<zzbv.zzb>> zze(String str) {
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            cursor = mo23015c_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                Map<Integer, List<zzbv.zzb>> emptyMap = Collections.emptyMap();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyMap;
            }
            do {
                try {
                    zzbv.zzb zzb2 = (zzbv.zzb) ((zzhv) ((zzbv.zzb.zza) zzkt.zza(zzbv.zzb.zzl(), cursor.getBlob(1))).zzy());
                    if (zzb2.zzf()) {
                        int i = cursor.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), list);
                        }
                        list.add(zzb2);
                    }
                } catch (IOException e) {
                    zzq().zze().zza("Failed to merge filter. appId", zzex.zza(str), e);
                }
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayMap;
        } catch (SQLiteException e2) {
            zzq().zze().zza("Database error querying filters. appId", zzex.zza(str), e2);
            Map<Integer, List<zzbv.zzb>> emptyMap2 = Collections.emptyMap();
            if (cursor != null) {
                cursor.close();
            }
            return emptyMap2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c0 A[Catch:{ all -> 0x00d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzbv.zze>> zzg(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.zzaj()
            r12.zzc()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.mo23015c_()
            r9 = 0
            java.lang.String r2 = "property_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ SQLiteException -> 0x009b, all -> 0x0098 }
            java.lang.String r4 = "app_id=? AND property_name=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x009b, all -> 0x0098 }
            r10 = 0
            r5[r10] = r13     // Catch:{ SQLiteException -> 0x009b, all -> 0x0098 }
            r11 = 1
            r5[r11] = r14     // Catch:{ SQLiteException -> 0x009b, all -> 0x0098 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x009b, all -> 0x0098 }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x0096 }
            if (r1 != 0) goto L_0x0042
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0096 }
            if (r14 == 0) goto L_0x0041
            r14.close()
        L_0x0041:
            return r13
        L_0x0042:
            byte[] r1 = r14.getBlob(r11)     // Catch:{ SQLiteException -> 0x0096 }
            com.google.android.gms.internal.measurement.zzbv$zze$zza r2 = com.google.android.gms.internal.measurement.zzbv.zze.zzi()     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.zzjf r1 = com.google.android.gms.measurement.internal.zzkt.zza(r2, (byte[]) r1)     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.zzbv$zze$zza r1 = (com.google.android.gms.internal.measurement.zzbv.zze.zza) r1     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.zzjg r1 = r1.zzy()     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.zzhv r1 = (com.google.android.gms.internal.measurement.zzhv) r1     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.zzbv$zze r1 = (com.google.android.gms.internal.measurement.zzbv.zze) r1     // Catch:{ IOException -> 0x0078 }
            int r2 = r14.getInt(r10)     // Catch:{ SQLiteException -> 0x0096 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0096 }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ SQLiteException -> 0x0096 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ SQLiteException -> 0x0096 }
            if (r3 != 0) goto L_0x0074
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0096 }
            r3.<init>()     // Catch:{ SQLiteException -> 0x0096 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0096 }
            r0.put(r2, r3)     // Catch:{ SQLiteException -> 0x0096 }
        L_0x0074:
            r3.add(r1)     // Catch:{ SQLiteException -> 0x0096 }
            goto L_0x008a
        L_0x0078:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzex r2 = r12.zzq()     // Catch:{ SQLiteException -> 0x0096 }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zze()     // Catch:{ SQLiteException -> 0x0096 }
            java.lang.String r3 = "Failed to merge filter"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r13)     // Catch:{ SQLiteException -> 0x0096 }
            r2.zza(r3, r4, r1)     // Catch:{ SQLiteException -> 0x0096 }
        L_0x008a:
            boolean r1 = r14.moveToNext()     // Catch:{ SQLiteException -> 0x0096 }
            if (r1 != 0) goto L_0x0042
            if (r14 == 0) goto L_0x0095
            r14.close()
        L_0x0095:
            return r0
        L_0x0096:
            r0 = move-exception
            goto L_0x009d
        L_0x0098:
            r13 = move-exception
            r14 = r9
            goto L_0x00d1
        L_0x009b:
            r0 = move-exception
            r14 = r9
        L_0x009d:
            com.google.android.gms.measurement.internal.zzex r1 = r12.zzq()     // Catch:{ all -> 0x00d0 }
            com.google.android.gms.measurement.internal.zzez r1 = r1.zze()     // Catch:{ all -> 0x00d0 }
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r13)     // Catch:{ all -> 0x00d0 }
            r1.zza(r2, r3, r0)     // Catch:{ all -> 0x00d0 }
            boolean r0 = com.google.android.gms.internal.measurement.zzmy.zzb()     // Catch:{ all -> 0x00d0 }
            if (r0 == 0) goto L_0x00ca
            com.google.android.gms.measurement.internal.zzy r0 = r12.zzs()     // Catch:{ all -> 0x00d0 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzat.zzcm     // Catch:{ all -> 0x00d0 }
            boolean r13 = r0.zze(r13, r1)     // Catch:{ all -> 0x00d0 }
            if (r13 == 0) goto L_0x00ca
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x00d0 }
            if (r14 == 0) goto L_0x00c9
            r14.close()
        L_0x00c9:
            return r13
        L_0x00ca:
            if (r14 == 0) goto L_0x00cf
            r14.close()
        L_0x00cf:
            return r9
        L_0x00d0:
            r13 = move-exception
        L_0x00d1:
            if (r14 == 0) goto L_0x00d6
            r14.close()
        L_0x00d6:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.zzg(java.lang.String, java.lang.String):java.util.Map");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008f A[Catch:{ all -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<java.lang.Integer>> zzf(java.lang.String r8) {
        /*
            r7 = this;
            r7.zzaj()
            r7.zzc()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r7.mo23015c_()
            r2 = 0
            java.lang.String r3 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x006a, all -> 0x0067 }
            r5 = 0
            r4[r5] = r8     // Catch:{ SQLiteException -> 0x006a, all -> 0x0067 }
            r6 = 1
            r4[r6] = r8     // Catch:{ SQLiteException -> 0x006a, all -> 0x0067 }
            android.database.Cursor r1 = r1.rawQuery(r3, r4)     // Catch:{ SQLiteException -> 0x006a, all -> 0x0067 }
            boolean r3 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0065 }
            if (r3 != 0) goto L_0x0032
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0065 }
            if (r1 == 0) goto L_0x0031
            r1.close()
        L_0x0031:
            return r8
        L_0x0032:
            int r3 = r1.getInt(r5)     // Catch:{ SQLiteException -> 0x0065 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0065 }
            java.lang.Object r4 = r0.get(r4)     // Catch:{ SQLiteException -> 0x0065 }
            java.util.List r4 = (java.util.List) r4     // Catch:{ SQLiteException -> 0x0065 }
            if (r4 != 0) goto L_0x004e
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0065 }
            r4.<init>()     // Catch:{ SQLiteException -> 0x0065 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0065 }
            r0.put(r3, r4)     // Catch:{ SQLiteException -> 0x0065 }
        L_0x004e:
            int r3 = r1.getInt(r6)     // Catch:{ SQLiteException -> 0x0065 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0065 }
            r4.add(r3)     // Catch:{ SQLiteException -> 0x0065 }
            boolean r3 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0065 }
            if (r3 != 0) goto L_0x0032
            if (r1 == 0) goto L_0x0064
            r1.close()
        L_0x0064:
            return r0
        L_0x0065:
            r0 = move-exception
            goto L_0x006c
        L_0x0067:
            r8 = move-exception
            r1 = r2
            goto L_0x00a0
        L_0x006a:
            r0 = move-exception
            r1 = r2
        L_0x006c:
            com.google.android.gms.measurement.internal.zzex r3 = r7.zzq()     // Catch:{ all -> 0x009f }
            com.google.android.gms.measurement.internal.zzez r3 = r3.zze()     // Catch:{ all -> 0x009f }
            java.lang.String r4 = "Database error querying scoped filters. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r8)     // Catch:{ all -> 0x009f }
            r3.zza(r4, r5, r0)     // Catch:{ all -> 0x009f }
            boolean r0 = com.google.android.gms.internal.measurement.zzmy.zzb()     // Catch:{ all -> 0x009f }
            if (r0 == 0) goto L_0x0099
            com.google.android.gms.measurement.internal.zzy r0 = r7.zzs()     // Catch:{ all -> 0x009f }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzcm     // Catch:{ all -> 0x009f }
            boolean r8 = r0.zze(r8, r3)     // Catch:{ all -> 0x009f }
            if (r8 == 0) goto L_0x0099
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x009f }
            if (r1 == 0) goto L_0x0098
            r1.close()
        L_0x0098:
            return r8
        L_0x0099:
            if (r1 == 0) goto L_0x009e
            r1.close()
        L_0x009e:
            return r2
        L_0x009f:
            r8 = move-exception
        L_0x00a0:
            if (r1 == 0) goto L_0x00a5
            r1.close()
        L_0x00a5:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.zzf(java.lang.String):java.util.Map");
    }

    private final boolean zzb(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzaj();
        zzc();
        SQLiteDatabase c_ = mo23015c_();
        try {
            long zzb2 = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, zzs().zzb(str, zzat.zzae)));
            if (zzb2 <= ((long) max)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA);
            sb3.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb3.append(sb2);
            sb3.append(" order by rowid desc limit -1 offset ?)");
            return c_.delete("audience_filter_values", sb3.toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e) {
            zzq().zze().zza("Database error querying filters. appId", zzex.zza(str), e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c2 A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, com.google.android.gms.internal.measurement.zzcd.zzi> zzg(java.lang.String r12) {
        /*
            r11 = this;
            r11.zzaj()
            r11.zzc()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            android.database.sqlite.SQLiteDatabase r0 = r11.mo23015c_()
            r8 = 0
            java.lang.String r1 = "audience_filter_values"
            java.lang.String r2 = "audience_id"
            java.lang.String r3 = "current_results"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch:{ SQLiteException -> 0x009d, all -> 0x009a }
            java.lang.String r3 = "app_id=?"
            r9 = 1
            java.lang.String[] r4 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x009d, all -> 0x009a }
            r10 = 0
            r4[r10] = r12     // Catch:{ SQLiteException -> 0x009d, all -> 0x009a }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x009d, all -> 0x009a }
            boolean r1 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x0098 }
            if (r1 != 0) goto L_0x004f
            boolean r1 = com.google.android.gms.internal.measurement.zzmy.zzb()     // Catch:{ SQLiteException -> 0x0098 }
            if (r1 == 0) goto L_0x0049
            com.google.android.gms.measurement.internal.zzy r1 = r11.zzs()     // Catch:{ SQLiteException -> 0x0098 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzat.zzcm     // Catch:{ SQLiteException -> 0x0098 }
            boolean r1 = r1.zze(r12, r2)     // Catch:{ SQLiteException -> 0x0098 }
            if (r1 == 0) goto L_0x0049
            java.util.Map r12 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0098 }
            if (r0 == 0) goto L_0x0048
            r0.close()
        L_0x0048:
            return r12
        L_0x0049:
            if (r0 == 0) goto L_0x004e
            r0.close()
        L_0x004e:
            return r8
        L_0x004f:
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap     // Catch:{ SQLiteException -> 0x0098 }
            r1.<init>()     // Catch:{ SQLiteException -> 0x0098 }
        L_0x0054:
            int r2 = r0.getInt(r10)     // Catch:{ SQLiteException -> 0x0098 }
            byte[] r3 = r0.getBlob(r9)     // Catch:{ SQLiteException -> 0x0098 }
            com.google.android.gms.internal.measurement.zzcd$zzi$zza r4 = com.google.android.gms.internal.measurement.zzcd.zzi.zzi()     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzjf r3 = com.google.android.gms.measurement.internal.zzkt.zza(r4, (byte[]) r3)     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzcd$zzi$zza r3 = (com.google.android.gms.internal.measurement.zzcd.zzi.zza) r3     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzjg r3 = r3.zzy()     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzhv r3 = (com.google.android.gms.internal.measurement.zzhv) r3     // Catch:{ IOException -> 0x0076 }
            com.google.android.gms.internal.measurement.zzcd$zzi r3 = (com.google.android.gms.internal.measurement.zzcd.zzi) r3     // Catch:{ IOException -> 0x0076 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0098 }
            r1.put(r2, r3)     // Catch:{ SQLiteException -> 0x0098 }
            goto L_0x008c
        L_0x0076:
            r3 = move-exception
            com.google.android.gms.measurement.internal.zzex r4 = r11.zzq()     // Catch:{ SQLiteException -> 0x0098 }
            com.google.android.gms.measurement.internal.zzez r4 = r4.zze()     // Catch:{ SQLiteException -> 0x0098 }
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r12)     // Catch:{ SQLiteException -> 0x0098 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0098 }
            r4.zza(r5, r6, r2, r3)     // Catch:{ SQLiteException -> 0x0098 }
        L_0x008c:
            boolean r2 = r0.moveToNext()     // Catch:{ SQLiteException -> 0x0098 }
            if (r2 != 0) goto L_0x0054
            if (r0 == 0) goto L_0x0097
            r0.close()
        L_0x0097:
            return r1
        L_0x0098:
            r1 = move-exception
            goto L_0x009f
        L_0x009a:
            r12 = move-exception
            r0 = r8
            goto L_0x00d3
        L_0x009d:
            r1 = move-exception
            r0 = r8
        L_0x009f:
            com.google.android.gms.measurement.internal.zzex r2 = r11.zzq()     // Catch:{ all -> 0x00d2 }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zze()     // Catch:{ all -> 0x00d2 }
            java.lang.String r3 = "Database error querying filter results. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r12)     // Catch:{ all -> 0x00d2 }
            r2.zza(r3, r4, r1)     // Catch:{ all -> 0x00d2 }
            boolean r1 = com.google.android.gms.internal.measurement.zzmy.zzb()     // Catch:{ all -> 0x00d2 }
            if (r1 == 0) goto L_0x00cc
            com.google.android.gms.measurement.internal.zzy r1 = r11.zzs()     // Catch:{ all -> 0x00d2 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzat.zzcm     // Catch:{ all -> 0x00d2 }
            boolean r12 = r1.zze(r12, r2)     // Catch:{ all -> 0x00d2 }
            if (r12 == 0) goto L_0x00cc
            java.util.Map r12 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x00d2 }
            if (r0 == 0) goto L_0x00cb
            r0.close()
        L_0x00cb:
            return r12
        L_0x00cc:
            if (r0 == 0) goto L_0x00d1
            r0.close()
        L_0x00d1:
            return r8
        L_0x00d2:
            r12 = move-exception
        L_0x00d3:
            if (r0 == 0) goto L_0x00d8
            r0.close()
        L_0x00d8:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.zzg(java.lang.String):java.util.Map");
    }

    @WorkerThread
    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            zzq().zze().zza("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i));
            }
            if (type == 3) {
                return cursor.getString(i);
            }
            if (type != 4) {
                zzq().zze().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            zzq().zze().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    @WorkerThread
    public final long zzv() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @VisibleForTesting
    public final long zzh(String str, String str2) {
        long j;
        String str3 = str;
        String str4 = str2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzc();
        zzaj();
        SQLiteDatabase c_ = mo23015c_();
        c_.beginTransaction();
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 32);
            sb.append("select ");
            sb.append(str4);
            sb.append(" from app2 where app_id=?");
            try {
                j = zza(sb.toString(), new String[]{str3}, -1);
                if (j == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str3);
                    contentValues.put("first_open_count", 0);
                    contentValues.put("previous_install_count", 0);
                    if (c_.insertWithOnConflict("app2", (String) null, contentValues, 5) == -1) {
                        zzq().zze().zza("Failed to insert column (got -1). appId", zzex.zza(str), str4);
                        c_.endTransaction();
                        return -1;
                    }
                    j = 0;
                }
            } catch (SQLiteException e) {
                e = e;
                j = 0;
                try {
                    zzq().zze().zza("Error inserting column. appId", zzex.zza(str), str4, e);
                    c_.endTransaction();
                    return j;
                } catch (Throwable th) {
                    th = th;
                    c_.endTransaction();
                    throw th;
                }
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str3);
                contentValues2.put(str4, Long.valueOf(1 + j));
                if (((long) c_.update("app2", contentValues2, "app_id = ?", new String[]{str3})) == 0) {
                    zzq().zze().zza("Failed to update column (got 0). appId", zzex.zza(str), str4);
                    c_.endTransaction();
                    return -1;
                }
                c_.setTransactionSuccessful();
                c_.endTransaction();
                return j;
            } catch (SQLiteException e2) {
                e = e2;
                zzq().zze().zza("Error inserting column. appId", zzex.zza(str), str4, e);
                c_.endTransaction();
                return j;
            }
        } catch (SQLiteException e3) {
            e = e3;
            j = 0;
            zzq().zze().zza("Error inserting column. appId", zzex.zza(str), str4, e);
            c_.endTransaction();
            return j;
        } catch (Throwable th2) {
            th = th2;
            c_.endTransaction();
            throw th;
        }
    }

    @WorkerThread
    public final long zzw() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final long zza(zzcd.zzg zzg2) throws IOException {
        zzc();
        zzaj();
        Preconditions.checkNotNull(zzg2);
        Preconditions.checkNotEmpty(zzg2.zzx());
        byte[] zzbk = zzg2.zzbk();
        long zza = mo23251f_().zza(zzbk);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzg2.zzx());
        contentValues.put("metadata_fingerprint", Long.valueOf(zza));
        contentValues.put(TtmlNode.TAG_METADATA, zzbk);
        try {
            mo23015c_().insertWithOnConflict("raw_events_metadata", (String) null, contentValues, 4);
            return zza;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing raw event metadata. appId", zzex.zza(zzg2.zzx()), e);
            throw e;
        }
    }

    public final boolean zzx() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzy() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final long zzh(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zza(long r5) {
        /*
            r4 = this;
            r4.zzc()
            r4.zzaj()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.mo23015c_()     // Catch:{ SQLiteException -> 0x0043, all -> 0x0040 }
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0043, all -> 0x0040 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0043, all -> 0x0040 }
            r6 = 0
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x0043, all -> 0x0040 }
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x0043, all -> 0x0040 }
            boolean r1 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x003e }
            if (r1 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.zzex r6 = r4.zzq()     // Catch:{ SQLiteException -> 0x003e }
            com.google.android.gms.measurement.internal.zzez r6 = r6.zzw()     // Catch:{ SQLiteException -> 0x003e }
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.zza(r1)     // Catch:{ SQLiteException -> 0x003e }
            if (r5 == 0) goto L_0x0033
            r5.close()
        L_0x0033:
            return r0
        L_0x0034:
            java.lang.String r6 = r5.getString(r6)     // Catch:{ SQLiteException -> 0x003e }
            if (r5 == 0) goto L_0x003d
            r5.close()
        L_0x003d:
            return r6
        L_0x003e:
            r6 = move-exception
            goto L_0x0045
        L_0x0040:
            r6 = move-exception
            r5 = r0
            goto L_0x0059
        L_0x0043:
            r6 = move-exception
            r5 = r0
        L_0x0045:
            com.google.android.gms.measurement.internal.zzex r1 = r4.zzq()     // Catch:{ all -> 0x0058 }
            com.google.android.gms.measurement.internal.zzez r1 = r1.zze()     // Catch:{ all -> 0x0058 }
            java.lang.String r2 = "Error selecting expired configs"
            r1.zza(r2, r6)     // Catch:{ all -> 0x0058 }
            if (r5 == 0) goto L_0x0057
            r5.close()
        L_0x0057:
            return r0
        L_0x0058:
            r6 = move-exception
        L_0x0059:
            if (r5 == 0) goto L_0x005e
            r5.close()
        L_0x005e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.zza(long):java.lang.String");
    }

    public final long zzz() {
        Cursor cursor = null;
        try {
            cursor = mo23015c_().rawQuery("select rowid from raw_events order by rowid desc limit 1;", (String[]) null);
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return -1;
            }
            long j = cursor.getLong(0);
            if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error querying raw events", e);
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzcd.zzc, java.lang.Long> zza(java.lang.String r8, java.lang.Long r9) {
        /*
            r7 = this;
            r7.zzc()
            r7.zzaj()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.mo23015c_()     // Catch:{ SQLiteException -> 0x007c, all -> 0x0079 }
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x007c, all -> 0x0079 }
            r4 = 0
            r3[r4] = r8     // Catch:{ SQLiteException -> 0x007c, all -> 0x0079 }
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch:{ SQLiteException -> 0x007c, all -> 0x0079 }
            r6 = 1
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x007c, all -> 0x0079 }
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x007c, all -> 0x0079 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0077 }
            if (r2 != 0) goto L_0x0037
            com.google.android.gms.measurement.internal.zzex r8 = r7.zzq()     // Catch:{ SQLiteException -> 0x0077 }
            com.google.android.gms.measurement.internal.zzez r8 = r8.zzw()     // Catch:{ SQLiteException -> 0x0077 }
            java.lang.String r9 = "Main event not found"
            r8.zza(r9)     // Catch:{ SQLiteException -> 0x0077 }
            if (r1 == 0) goto L_0x0036
            r1.close()
        L_0x0036:
            return r0
        L_0x0037:
            byte[] r2 = r1.getBlob(r4)     // Catch:{ SQLiteException -> 0x0077 }
            long r3 = r1.getLong(r6)     // Catch:{ SQLiteException -> 0x0077 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ SQLiteException -> 0x0077 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r4 = com.google.android.gms.internal.measurement.zzcd.zzc.zzj()     // Catch:{ IOException -> 0x005f }
            com.google.android.gms.internal.measurement.zzjf r2 = com.google.android.gms.measurement.internal.zzkt.zza(r4, (byte[]) r2)     // Catch:{ IOException -> 0x005f }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r2     // Catch:{ IOException -> 0x005f }
            com.google.android.gms.internal.measurement.zzjg r2 = r2.zzy()     // Catch:{ IOException -> 0x005f }
            com.google.android.gms.internal.measurement.zzhv r2 = (com.google.android.gms.internal.measurement.zzhv) r2     // Catch:{ IOException -> 0x005f }
            com.google.android.gms.internal.measurement.zzcd$zzc r2 = (com.google.android.gms.internal.measurement.zzcd.zzc) r2     // Catch:{ IOException -> 0x005f }
            android.util.Pair r8 = android.util.Pair.create(r2, r3)     // Catch:{ SQLiteException -> 0x0077 }
            if (r1 == 0) goto L_0x005e
            r1.close()
        L_0x005e:
            return r8
        L_0x005f:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzex r3 = r7.zzq()     // Catch:{ SQLiteException -> 0x0077 }
            com.google.android.gms.measurement.internal.zzez r3 = r3.zze()     // Catch:{ SQLiteException -> 0x0077 }
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r8)     // Catch:{ SQLiteException -> 0x0077 }
            r3.zza(r4, r8, r9, r2)     // Catch:{ SQLiteException -> 0x0077 }
            if (r1 == 0) goto L_0x0076
            r1.close()
        L_0x0076:
            return r0
        L_0x0077:
            r8 = move-exception
            goto L_0x007e
        L_0x0079:
            r8 = move-exception
            r1 = r0
            goto L_0x0092
        L_0x007c:
            r8 = move-exception
            r1 = r0
        L_0x007e:
            com.google.android.gms.measurement.internal.zzex r9 = r7.zzq()     // Catch:{ all -> 0x0091 }
            com.google.android.gms.measurement.internal.zzez r9 = r9.zze()     // Catch:{ all -> 0x0091 }
            java.lang.String r2 = "Error selecting main event"
            r9.zza(r2, r8)     // Catch:{ all -> 0x0091 }
            if (r1 == 0) goto L_0x0090
            r1.close()
        L_0x0090:
            return r0
        L_0x0091:
            r8 = move-exception
        L_0x0092:
            if (r1 == 0) goto L_0x0097
            r1.close()
        L_0x0097:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    public final boolean zza(String str, Long l, long j, zzcd.zzc zzc2) {
        zzc();
        zzaj();
        Preconditions.checkNotNull(zzc2);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] zzbk = zzc2.zzbk();
        zzq().zzw().zza("Saving complex main event, appId, data size", zzn().zza(str), Integer.valueOf(zzbk.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzbk);
        try {
            if (mo23015c_().insertWithOnConflict("main_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzq().zze().zza("Failed to insert complex main event (got -1). appId", zzex.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing complex main event. appId", zzex.zza(str), e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, Bundle bundle) {
        zzc();
        zzaj();
        byte[] zzbk = mo23251f_().zza(new zzak(this.zzy, "", str, "dep", 0, 0, bundle)).zzbk();
        zzq().zzw().zza("Saving default event parameters, appId, data size", zzn().zza(str), Integer.valueOf(zzbk.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", zzbk);
        try {
            if (mo23015c_().insertWithOnConflict("default_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzq().zze().zza("Failed to insert default event parameters (got -1). appId", zzex.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing default event parameters. appId", zzex.zza(str), e);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zzi(java.lang.String r8) {
        /*
            r7 = this;
            r7.zzc()
            r7.zzaj()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.mo23015c_()     // Catch:{ SQLiteException -> 0x00c1, all -> 0x00be }
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x00c1, all -> 0x00be }
            r4 = 0
            r3[r4] = r8     // Catch:{ SQLiteException -> 0x00c1, all -> 0x00be }
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x00c1, all -> 0x00be }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x00bc }
            if (r2 != 0) goto L_0x0030
            com.google.android.gms.measurement.internal.zzex r8 = r7.zzq()     // Catch:{ SQLiteException -> 0x00bc }
            com.google.android.gms.measurement.internal.zzez r8 = r8.zzw()     // Catch:{ SQLiteException -> 0x00bc }
            java.lang.String r2 = "Default event parameters not found"
            r8.zza(r2)     // Catch:{ SQLiteException -> 0x00bc }
            if (r1 == 0) goto L_0x002f
            r1.close()
        L_0x002f:
            return r0
        L_0x0030:
            byte[] r2 = r1.getBlob(r4)     // Catch:{ SQLiteException -> 0x00bc }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r3 = com.google.android.gms.internal.measurement.zzcd.zzc.zzj()     // Catch:{ IOException -> 0x00a4 }
            com.google.android.gms.internal.measurement.zzjf r2 = com.google.android.gms.measurement.internal.zzkt.zza(r3, (byte[]) r2)     // Catch:{ IOException -> 0x00a4 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r2     // Catch:{ IOException -> 0x00a4 }
            com.google.android.gms.internal.measurement.zzjg r2 = r2.zzy()     // Catch:{ IOException -> 0x00a4 }
            com.google.android.gms.internal.measurement.zzhv r2 = (com.google.android.gms.internal.measurement.zzhv) r2     // Catch:{ IOException -> 0x00a4 }
            com.google.android.gms.internal.measurement.zzcd$zzc r2 = (com.google.android.gms.internal.measurement.zzcd.zzc) r2     // Catch:{ IOException -> 0x00a4 }
            r7.mo23251f_()     // Catch:{ SQLiteException -> 0x00bc }
            java.util.List r8 = r2.zza()     // Catch:{ SQLiteException -> 0x00bc }
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ SQLiteException -> 0x00bc }
            r2.<init>()     // Catch:{ SQLiteException -> 0x00bc }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ SQLiteException -> 0x00bc }
        L_0x0056:
            boolean r3 = r8.hasNext()     // Catch:{ SQLiteException -> 0x00bc }
            if (r3 == 0) goto L_0x009e
            java.lang.Object r3 = r8.next()     // Catch:{ SQLiteException -> 0x00bc }
            com.google.android.gms.internal.measurement.zzcd$zze r3 = (com.google.android.gms.internal.measurement.zzcd.zze) r3     // Catch:{ SQLiteException -> 0x00bc }
            java.lang.String r4 = r3.zzb()     // Catch:{ SQLiteException -> 0x00bc }
            boolean r5 = r3.zzi()     // Catch:{ SQLiteException -> 0x00bc }
            if (r5 == 0) goto L_0x0074
            double r5 = r3.zzj()     // Catch:{ SQLiteException -> 0x00bc }
            r2.putDouble(r4, r5)     // Catch:{ SQLiteException -> 0x00bc }
            goto L_0x0056
        L_0x0074:
            boolean r5 = r3.zzg()     // Catch:{ SQLiteException -> 0x00bc }
            if (r5 == 0) goto L_0x0082
            float r3 = r3.zzh()     // Catch:{ SQLiteException -> 0x00bc }
            r2.putFloat(r4, r3)     // Catch:{ SQLiteException -> 0x00bc }
            goto L_0x0056
        L_0x0082:
            boolean r5 = r3.zzc()     // Catch:{ SQLiteException -> 0x00bc }
            if (r5 == 0) goto L_0x0090
            java.lang.String r3 = r3.zzd()     // Catch:{ SQLiteException -> 0x00bc }
            r2.putString(r4, r3)     // Catch:{ SQLiteException -> 0x00bc }
            goto L_0x0056
        L_0x0090:
            boolean r5 = r3.zze()     // Catch:{ SQLiteException -> 0x00bc }
            if (r5 == 0) goto L_0x0056
            long r5 = r3.zzf()     // Catch:{ SQLiteException -> 0x00bc }
            r2.putLong(r4, r5)     // Catch:{ SQLiteException -> 0x00bc }
            goto L_0x0056
        L_0x009e:
            if (r1 == 0) goto L_0x00a3
            r1.close()
        L_0x00a3:
            return r2
        L_0x00a4:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzex r3 = r7.zzq()     // Catch:{ SQLiteException -> 0x00bc }
            com.google.android.gms.measurement.internal.zzez r3 = r3.zze()     // Catch:{ SQLiteException -> 0x00bc }
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r8)     // Catch:{ SQLiteException -> 0x00bc }
            r3.zza(r4, r8, r2)     // Catch:{ SQLiteException -> 0x00bc }
            if (r1 == 0) goto L_0x00bb
            r1.close()
        L_0x00bb:
            return r0
        L_0x00bc:
            r8 = move-exception
            goto L_0x00c3
        L_0x00be:
            r8 = move-exception
            r1 = r0
            goto L_0x00d7
        L_0x00c1:
            r8 = move-exception
            r1 = r0
        L_0x00c3:
            com.google.android.gms.measurement.internal.zzex r2 = r7.zzq()     // Catch:{ all -> 0x00d6 }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zze()     // Catch:{ all -> 0x00d6 }
            java.lang.String r3 = "Error selecting default event parameters"
            r2.zza(r3, r8)     // Catch:{ all -> 0x00d6 }
            if (r1 == 0) goto L_0x00d5
            r1.close()
        L_0x00d5:
            return r0
        L_0x00d6:
            r8 = move-exception
        L_0x00d7:
            if (r1 == 0) goto L_0x00dc
            r1.close()
        L_0x00dc:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.zzi(java.lang.String):android.os.Bundle");
    }

    public final zzad zzj(String str) {
        Preconditions.checkNotNull(str);
        zzc();
        zzaj();
        return zzad.zza(zza("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str}, "G1"));
    }

    public final boolean zza(zzak zzak, long j, boolean z) {
        zzc();
        zzaj();
        Preconditions.checkNotNull(zzak);
        Preconditions.checkNotEmpty(zzak.zza);
        byte[] zzbk = mo23251f_().zza(zzak).zzbk();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzak.zza);
        contentValues.put("name", zzak.zzb);
        contentValues.put("timestamp", Long.valueOf(zzak.zzc));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put("data", zzbk);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (mo23015c_().insert("raw_events", (String) null, contentValues) != -1) {
                return true;
            }
            zzq().zze().zza("Failed to insert raw event (got -1). appId", zzex.zza(zzak.zza));
            return false;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing raw event. appId", zzex.zza(zzak.zza), e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(String str, List<zzbv.zza> list) {
        boolean z;
        boolean z2;
        String str2 = str;
        List<zzbv.zza> list2 = list;
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            zzbv.zza.C5076zza zza = (zzbv.zza.C5076zza) list2.get(i).zzbo();
            if (zza.zzb() != 0) {
                zzbv.zza.C5076zza zza2 = zza;
                for (int i2 = 0; i2 < zza2.zzb(); i2++) {
                    zzbv.zzb.zza zza3 = (zzbv.zzb.zza) zza2.zzb(i2).zzbo();
                    zzbv.zzb.zza zza4 = (zzbv.zzb.zza) ((zzhv.zzb) zza3.clone());
                    String zzb2 = zzgy.zzb(zza3.zza());
                    if (zzb2 != null) {
                        zza4.zza(zzb2);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    boolean z3 = z2;
                    for (int i3 = 0; i3 < zza3.zzb(); i3++) {
                        zzbv.zzc zza5 = zza3.zza(i3);
                        String zza6 = zzhb.zza(zza5.zzh());
                        if (zza6 != null) {
                            zza4.zza(i3, (zzbv.zzc) ((zzhv) ((zzbv.zzc.zza) zza5.zzbo()).zza(zza6).zzy()));
                            z3 = true;
                        }
                    }
                    if (z3) {
                        zza2 = zza2.zza(i2, zza4);
                        list2.set(i, (zzbv.zza) ((zzhv) zza2.zzy()));
                    }
                }
                zza = zza2;
            }
            if (zza.zza() != 0) {
                for (int i4 = 0; i4 < zza.zza(); i4++) {
                    zzbv.zze zza7 = zza.zza(i4);
                    String zza8 = zzha.zza(zza7.zzc());
                    if (zza8 != null) {
                        zza = zza.zza(i4, ((zzbv.zze.zza) zza7.zzbo()).zza(zza8));
                        list2.set(i, (zzbv.zza) ((zzhv) zza.zzy()));
                    }
                }
            }
        }
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase c_ = mo23015c_();
        c_.beginTransaction();
        try {
            zzaj();
            zzc();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase c_2 = mo23015c_();
            c_2.delete("property_filters", "app_id=?", new String[]{str2});
            c_2.delete("event_filters", "app_id=?", new String[]{str2});
            for (zzbv.zza next : list) {
                zzaj();
                zzc();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(next);
                if (!next.zza()) {
                    zzq().zzh().zza("Audience with no ID. appId", zzex.zza(str));
                } else {
                    int zzb3 = next.zzb();
                    Iterator<zzbv.zzb> it = next.zze().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!it.next().zza()) {
                                zzq().zzh().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzex.zza(str), Integer.valueOf(zzb3));
                                break;
                            }
                        } else {
                            Iterator<zzbv.zze> it2 = next.zzc().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!it2.next().zza()) {
                                        zzq().zzh().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzex.zza(str), Integer.valueOf(zzb3));
                                        break;
                                    }
                                } else {
                                    Iterator<zzbv.zzb> it3 = next.zze().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!zza(str2, zzb3, it3.next())) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        Iterator<zzbv.zze> it4 = next.zzc().iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                if (!zza(str2, zzb3, it4.next())) {
                                                    z = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        zzaj();
                                        zzc();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase c_3 = mo23015c_();
                                        c_3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str2, String.valueOf(zzb3)});
                                        c_3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str2, String.valueOf(zzb3)});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzbv.zza next2 : list) {
                arrayList.add(next2.zza() ? Integer.valueOf(next2.zzb()) : null);
            }
            zzb(str2, (List<Integer>) arrayList);
            c_.setTransactionSuccessful();
        } finally {
            c_.endTransaction();
        }
    }

    @VisibleForTesting
    private final boolean zzal() {
        return zzm().getDatabasePath("google_app_measurement.db").exists();
    }
}
