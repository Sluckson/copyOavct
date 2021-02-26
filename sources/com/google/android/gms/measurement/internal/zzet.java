package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.WorkerThread;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzet extends zzg {
    private final zzes zza = new zzes(this, zzm(), "google_app_measurement_local.db");
    private boolean zzb;

    zzet(zzgb zzgb) {
        super(zzgb);
    }

    /* access modifiers changed from: protected */
    public final boolean zzy() {
        return false;
    }

    @WorkerThread
    public final void zzaa() {
        zzc();
        try {
            int delete = zzad().delete("messages", (String) null, (String[]) null) + 0;
            if (delete > 0) {
                zzq().zzw().zza("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzq().zze().zza("Error resetting local analytics data. error", e);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r7v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r7v6 */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c2 A[SYNTHETIC, Splitter:B:47:0x00c2] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0117 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0117 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0117 A[SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(int r17, byte[] r18) {
        /*
            r16 = this;
            r1 = r16
            r16.zzc()
            boolean r0 = r1.zzb
            r2 = 0
            if (r0 == 0) goto L_0x000b
            return r2
        L_0x000b:
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r17)
            java.lang.String r4 = "type"
            r3.put(r4, r0)
            java.lang.String r0 = "entry"
            r4 = r18
            r3.put(r0, r4)
            r4 = 5
            r5 = 0
            r6 = 5
        L_0x0023:
            if (r5 >= r4) goto L_0x012a
            r7 = 0
            r8 = 1
            android.database.sqlite.SQLiteDatabase r9 = r16.zzad()     // Catch:{ SQLiteFullException -> 0x00fb, SQLiteDatabaseLockedException -> 0x00e9, SQLiteException -> 0x00be, all -> 0x00ba }
            if (r9 != 0) goto L_0x0035
            r1.zzb = r8     // Catch:{ SQLiteFullException -> 0x00b8, SQLiteDatabaseLockedException -> 0x00ea, SQLiteException -> 0x00b4 }
            if (r9 == 0) goto L_0x0034
            r9.close()
        L_0x0034:
            return r2
        L_0x0035:
            r9.beginTransaction()     // Catch:{ SQLiteFullException -> 0x00b8, SQLiteDatabaseLockedException -> 0x00ea, SQLiteException -> 0x00b4 }
            r10 = 0
            java.lang.String r0 = "select count(1) from messages"
            android.database.Cursor r12 = r9.rawQuery(r0, r7)     // Catch:{ SQLiteFullException -> 0x00b8, SQLiteDatabaseLockedException -> 0x00ea, SQLiteException -> 0x00b4 }
            if (r12 == 0) goto L_0x0056
            boolean r0 = r12.moveToFirst()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            if (r0 == 0) goto L_0x0056
            long r10 = r12.getLong(r2)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            goto L_0x0056
        L_0x004d:
            r0 = move-exception
            goto L_0x011f
        L_0x0050:
            r0 = move-exception
            goto L_0x00b6
        L_0x0052:
            r0 = move-exception
            r7 = r12
            goto L_0x00fd
        L_0x0056:
            java.lang.String r0 = "messages"
            r13 = 100000(0x186a0, double:4.94066E-319)
            int r15 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r15 < 0) goto L_0x009d
            com.google.android.gms.measurement.internal.zzex r15 = r16.zzq()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            com.google.android.gms.measurement.internal.zzez r15 = r15.zze()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.String r4 = "Data loss, local db full"
            r15.zza(r4)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            long r13 = r13 - r10
            r10 = 1
            long r13 = r13 + r10
            java.lang.String r4 = "rowid in (select rowid from messages order by rowid asc limit ?)"
            java.lang.String[] r10 = new java.lang.String[r8]     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.String r11 = java.lang.Long.toString(r13)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            r10[r2] = r11     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            int r4 = r9.delete(r0, r4, r10)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            long r10 = (long) r4     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            int r4 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x009d
            com.google.android.gms.measurement.internal.zzex r4 = r16.zzq()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            com.google.android.gms.measurement.internal.zzez r4 = r4.zze()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.String r15 = "Different delete count than expected in local db. expected, received, difference"
            java.lang.Long r2 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.Long r8 = java.lang.Long.valueOf(r10)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            long r13 = r13 - r10
            java.lang.Long r10 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            r4.zza(r15, r2, r8, r10)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
        L_0x009d:
            r9.insertOrThrow(r0, r7, r3)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            r9.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            r9.endTransaction()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            if (r12 == 0) goto L_0x00ab
            r12.close()
        L_0x00ab:
            if (r9 == 0) goto L_0x00b0
            r9.close()
        L_0x00b0:
            r2 = 1
            return r2
        L_0x00b2:
            r7 = r12
            goto L_0x00ea
        L_0x00b4:
            r0 = move-exception
            r12 = r7
        L_0x00b6:
            r7 = r9
            goto L_0x00c0
        L_0x00b8:
            r0 = move-exception
            goto L_0x00fd
        L_0x00ba:
            r0 = move-exception
            r9 = r7
            r12 = r9
            goto L_0x011f
        L_0x00be:
            r0 = move-exception
            r12 = r7
        L_0x00c0:
            if (r7 == 0) goto L_0x00cb
            boolean r2 = r7.inTransaction()     // Catch:{ all -> 0x00e6 }
            if (r2 == 0) goto L_0x00cb
            r7.endTransaction()     // Catch:{ all -> 0x00e6 }
        L_0x00cb:
            com.google.android.gms.measurement.internal.zzex r2 = r16.zzq()     // Catch:{ all -> 0x00e6 }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zze()     // Catch:{ all -> 0x00e6 }
            java.lang.String r4 = "Error writing entry to local database"
            r2.zza(r4, r0)     // Catch:{ all -> 0x00e6 }
            r2 = 1
            r1.zzb = r2     // Catch:{ all -> 0x00e6 }
            if (r12 == 0) goto L_0x00e0
            r12.close()
        L_0x00e0:
            if (r7 == 0) goto L_0x0117
            r7.close()
            goto L_0x0117
        L_0x00e6:
            r0 = move-exception
            r9 = r7
            goto L_0x011f
        L_0x00e9:
            r9 = r7
        L_0x00ea:
            long r10 = (long) r6
            android.os.SystemClock.sleep(r10)     // Catch:{ all -> 0x011d }
            int r6 = r6 + 20
            if (r7 == 0) goto L_0x00f5
            r7.close()
        L_0x00f5:
            if (r9 == 0) goto L_0x0117
            r9.close()
            goto L_0x0117
        L_0x00fb:
            r0 = move-exception
            r9 = r7
        L_0x00fd:
            com.google.android.gms.measurement.internal.zzex r2 = r16.zzq()     // Catch:{ all -> 0x011d }
            com.google.android.gms.measurement.internal.zzez r2 = r2.zze()     // Catch:{ all -> 0x011d }
            java.lang.String r4 = "Error writing entry; local database full"
            r2.zza(r4, r0)     // Catch:{ all -> 0x011d }
            r2 = 1
            r1.zzb = r2     // Catch:{ all -> 0x011d }
            if (r7 == 0) goto L_0x0112
            r7.close()
        L_0x0112:
            if (r9 == 0) goto L_0x0117
            r9.close()
        L_0x0117:
            int r5 = r5 + 1
            r2 = 0
            r4 = 5
            goto L_0x0023
        L_0x011d:
            r0 = move-exception
            r12 = r7
        L_0x011f:
            if (r12 == 0) goto L_0x0124
            r12.close()
        L_0x0124:
            if (r9 == 0) goto L_0x0129
            r9.close()
        L_0x0129:
            throw r0
        L_0x012a:
            com.google.android.gms.measurement.internal.zzex r0 = r16.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzw()
            java.lang.String r2 = "Failed to write entry to local database"
            r0.zza(r2)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzet.zza(int, byte[]):boolean");
    }

    public final boolean zza(zzar zzar) {
        Parcel obtain = Parcel.obtain();
        zzar.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(0, marshall);
        }
        zzq().zzf().zza("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zza(zzkw zzkw) {
        Parcel obtain = Parcel.obtain();
        zzkw.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(1, marshall);
        }
        zzq().zzf().zza("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zza(zzw zzw) {
        zzo();
        byte[] zza2 = zzkx.zza((Parcelable) zzw);
        if (zza2.length <= 131072) {
            return zza(2, zza2);
        }
        zzq().zzf().zza("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:64|65|66|67) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:79|80|81|82) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:51|52|53|54|172) */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0195, code lost:
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
        r10 = null;
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0033, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        r10 = null;
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0038, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
        r10 = null;
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        zzq().zze().zza("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        zzq().zze().zza("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        r11.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        zzq().zze().zza("Failed to load conditional user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        r11.recycle();
        r0 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00aa */
    /* JADX WARNING: Missing exception handler attribute for start block: B:64:0x00da */
    /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x0110 */
    /* JADX WARNING: Removed duplicated region for block: B:112:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:12:0x0026] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01a5 A[SYNTHETIC, Splitter:B:123:0x01a5] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x01f3 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x01f3 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x01f3 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> zza(int r22) {
        /*
            r21 = this;
            r1 = r21
            java.lang.String r2 = "Error reading entries from local database"
            r21.zzc()
            boolean r0 = r1.zzb
            r3 = 0
            if (r0 == 0) goto L_0x000d
            return r3
        L_0x000d:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r0 = r21.zzae()
            if (r0 != 0) goto L_0x0019
            return r4
        L_0x0019:
            r5 = 5
            r6 = 0
            r7 = 0
            r8 = 5
        L_0x001d:
            if (r7 >= r5) goto L_0x0204
            r9 = 1
            android.database.sqlite.SQLiteDatabase r15 = r21.zzad()     // Catch:{ SQLiteFullException -> 0x01d9, SQLiteDatabaseLockedException -> 0x01c6, SQLiteException -> 0x01a0, all -> 0x019c }
            if (r15 != 0) goto L_0x003d
            r1.zzb = r9     // Catch:{ SQLiteFullException -> 0x0038, SQLiteDatabaseLockedException -> 0x0195, SQLiteException -> 0x0033, all -> 0x002e }
            if (r15 == 0) goto L_0x002d
            r15.close()
        L_0x002d:
            return r3
        L_0x002e:
            r0 = move-exception
            r10 = r3
            r5 = r15
            goto L_0x01f9
        L_0x0033:
            r0 = move-exception
            r10 = r3
            r5 = r15
            goto L_0x01a3
        L_0x0038:
            r0 = move-exception
            r10 = r3
            r5 = r15
            goto L_0x01dc
        L_0x003d:
            r15.beginTransaction()     // Catch:{ SQLiteFullException -> 0x0198, SQLiteDatabaseLockedException -> 0x0195, SQLiteException -> 0x0191, all -> 0x018c }
            long r10 = zza((android.database.sqlite.SQLiteDatabase) r15)     // Catch:{ SQLiteFullException -> 0x0198, SQLiteDatabaseLockedException -> 0x0195, SQLiteException -> 0x0191, all -> 0x018c }
            r19 = -1
            int r0 = (r10 > r19 ? 1 : (r10 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x0057
            java.lang.String r0 = "rowid<?"
            java.lang.String[] r12 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x0038, SQLiteDatabaseLockedException -> 0x0195, SQLiteException -> 0x0033, all -> 0x002e }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ SQLiteFullException -> 0x0038, SQLiteDatabaseLockedException -> 0x0195, SQLiteException -> 0x0033, all -> 0x002e }
            r12[r6] = r10     // Catch:{ SQLiteFullException -> 0x0038, SQLiteDatabaseLockedException -> 0x0195, SQLiteException -> 0x0033, all -> 0x002e }
            r13 = r0
            r14 = r12
            goto L_0x0059
        L_0x0057:
            r13 = r3
            r14 = r13
        L_0x0059:
            java.lang.String r11 = "messages"
            java.lang.String r0 = "rowid"
            java.lang.String r10 = "type"
            java.lang.String r12 = "entry"
            java.lang.String[] r12 = new java.lang.String[]{r0, r10, r12}     // Catch:{ SQLiteFullException -> 0x0198, SQLiteDatabaseLockedException -> 0x0195, SQLiteException -> 0x0191, all -> 0x018c }
            r0 = 0
            r16 = 0
            java.lang.String r17 = "rowid asc"
            r10 = 100
            java.lang.String r18 = java.lang.Integer.toString(r10)     // Catch:{ SQLiteFullException -> 0x0198, SQLiteDatabaseLockedException -> 0x0195, SQLiteException -> 0x0191, all -> 0x018c }
            r10 = r15
            r5 = r15
            r15 = r0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteFullException -> 0x018a, SQLiteDatabaseLockedException -> 0x0196, SQLiteException -> 0x0188, all -> 0x0186 }
        L_0x0077:
            boolean r0 = r10.moveToNext()     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            if (r0 == 0) goto L_0x014d
            long r19 = r10.getLong(r6)     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            int r0 = r10.getInt(r9)     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            r11 = 2
            byte[] r12 = r10.getBlob(r11)     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            if (r0 != 0) goto L_0x00bf
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            int r0 = r12.length     // Catch:{ ParseException -> 0x00aa }
            r11.unmarshall(r12, r6, r0)     // Catch:{ ParseException -> 0x00aa }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x00aa }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzar> r0 = com.google.android.gms.measurement.internal.zzar.CREATOR     // Catch:{ ParseException -> 0x00aa }
            java.lang.Object r0 = r0.createFromParcel(r11)     // Catch:{ ParseException -> 0x00aa }
            com.google.android.gms.measurement.internal.zzar r0 = (com.google.android.gms.measurement.internal.zzar) r0     // Catch:{ ParseException -> 0x00aa }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            if (r0 == 0) goto L_0x0077
            r4.add(r0)     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            goto L_0x0077
        L_0x00a8:
            r0 = move-exception
            goto L_0x00bb
        L_0x00aa:
            com.google.android.gms.measurement.internal.zzex r0 = r21.zzq()     // Catch:{ all -> 0x00a8 }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zze()     // Catch:{ all -> 0x00a8 }
            java.lang.String r12 = "Failed to load event from local database"
            r0.zza(r12)     // Catch:{ all -> 0x00a8 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            goto L_0x0077
        L_0x00bb:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            throw r0     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
        L_0x00bf:
            if (r0 != r9) goto L_0x00f5
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            int r0 = r12.length     // Catch:{ ParseException -> 0x00da }
            r11.unmarshall(r12, r6, r0)     // Catch:{ ParseException -> 0x00da }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x00da }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzkw> r0 = com.google.android.gms.measurement.internal.zzkw.CREATOR     // Catch:{ ParseException -> 0x00da }
            java.lang.Object r0 = r0.createFromParcel(r11)     // Catch:{ ParseException -> 0x00da }
            com.google.android.gms.measurement.internal.zzkw r0 = (com.google.android.gms.measurement.internal.zzkw) r0     // Catch:{ ParseException -> 0x00da }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            goto L_0x00eb
        L_0x00d8:
            r0 = move-exception
            goto L_0x00f1
        L_0x00da:
            com.google.android.gms.measurement.internal.zzex r0 = r21.zzq()     // Catch:{ all -> 0x00d8 }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zze()     // Catch:{ all -> 0x00d8 }
            java.lang.String r12 = "Failed to load user property from local database"
            r0.zza(r12)     // Catch:{ all -> 0x00d8 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            r0 = r3
        L_0x00eb:
            if (r0 == 0) goto L_0x0077
            r4.add(r0)     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            goto L_0x0077
        L_0x00f1:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            throw r0     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
        L_0x00f5:
            if (r0 != r11) goto L_0x012c
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            int r0 = r12.length     // Catch:{ ParseException -> 0x0110 }
            r11.unmarshall(r12, r6, r0)     // Catch:{ ParseException -> 0x0110 }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x0110 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzw> r0 = com.google.android.gms.measurement.internal.zzw.CREATOR     // Catch:{ ParseException -> 0x0110 }
            java.lang.Object r0 = r0.createFromParcel(r11)     // Catch:{ ParseException -> 0x0110 }
            com.google.android.gms.measurement.internal.zzw r0 = (com.google.android.gms.measurement.internal.zzw) r0     // Catch:{ ParseException -> 0x0110 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            goto L_0x0121
        L_0x010e:
            r0 = move-exception
            goto L_0x0128
        L_0x0110:
            com.google.android.gms.measurement.internal.zzex r0 = r21.zzq()     // Catch:{ all -> 0x010e }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zze()     // Catch:{ all -> 0x010e }
            java.lang.String r12 = "Failed to load conditional user property from local database"
            r0.zza(r12)     // Catch:{ all -> 0x010e }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            r0 = r3
        L_0x0121:
            if (r0 == 0) goto L_0x0077
            r4.add(r0)     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            goto L_0x0077
        L_0x0128:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            throw r0     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
        L_0x012c:
            r11 = 3
            if (r0 != r11) goto L_0x013e
            com.google.android.gms.measurement.internal.zzex r0 = r21.zzq()     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzh()     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            java.lang.String r11 = "Skipping app launch break"
            r0.zza(r11)     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            goto L_0x0077
        L_0x013e:
            com.google.android.gms.measurement.internal.zzex r0 = r21.zzq()     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zze()     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            java.lang.String r11 = "Unknown record type in local database"
            r0.zza(r11)     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            goto L_0x0077
        L_0x014d:
            java.lang.String r0 = "messages"
            java.lang.String r11 = "rowid <= ?"
            java.lang.String[] r12 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            java.lang.String r13 = java.lang.Long.toString(r19)     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            r12[r6] = r13     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            int r0 = r5.delete(r0, r11, r12)     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            int r11 = r4.size()     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            if (r0 >= r11) goto L_0x0170
            com.google.android.gms.measurement.internal.zzex r0 = r21.zzq()     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zze()     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            java.lang.String r11 = "Fewer entries removed from local database than expected"
            r0.zza(r11)     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
        L_0x0170:
            r5.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            r5.endTransaction()     // Catch:{ SQLiteFullException -> 0x0183, SQLiteDatabaseLockedException -> 0x01c8, SQLiteException -> 0x0181 }
            if (r10 == 0) goto L_0x017b
            r10.close()
        L_0x017b:
            if (r5 == 0) goto L_0x0180
            r5.close()
        L_0x0180:
            return r4
        L_0x0181:
            r0 = move-exception
            goto L_0x01a3
        L_0x0183:
            r0 = move-exception
            goto L_0x01dc
        L_0x0186:
            r0 = move-exception
            goto L_0x018e
        L_0x0188:
            r0 = move-exception
            goto L_0x0193
        L_0x018a:
            r0 = move-exception
            goto L_0x019a
        L_0x018c:
            r0 = move-exception
            r5 = r15
        L_0x018e:
            r10 = r3
            goto L_0x01f9
        L_0x0191:
            r0 = move-exception
            r5 = r15
        L_0x0193:
            r10 = r3
            goto L_0x01a3
        L_0x0195:
            r5 = r15
        L_0x0196:
            r10 = r3
            goto L_0x01c8
        L_0x0198:
            r0 = move-exception
            r5 = r15
        L_0x019a:
            r10 = r3
            goto L_0x01dc
        L_0x019c:
            r0 = move-exception
            r5 = r3
            r10 = r5
            goto L_0x01f9
        L_0x01a0:
            r0 = move-exception
            r5 = r3
            r10 = r5
        L_0x01a3:
            if (r5 == 0) goto L_0x01ae
            boolean r11 = r5.inTransaction()     // Catch:{ all -> 0x01f8 }
            if (r11 == 0) goto L_0x01ae
            r5.endTransaction()     // Catch:{ all -> 0x01f8 }
        L_0x01ae:
            com.google.android.gms.measurement.internal.zzex r11 = r21.zzq()     // Catch:{ all -> 0x01f8 }
            com.google.android.gms.measurement.internal.zzez r11 = r11.zze()     // Catch:{ all -> 0x01f8 }
            r11.zza(r2, r0)     // Catch:{ all -> 0x01f8 }
            r1.zzb = r9     // Catch:{ all -> 0x01f8 }
            if (r10 == 0) goto L_0x01c0
            r10.close()
        L_0x01c0:
            if (r5 == 0) goto L_0x01f3
            r5.close()
            goto L_0x01f3
        L_0x01c6:
            r5 = r3
            r10 = r5
        L_0x01c8:
            long r11 = (long) r8
            android.os.SystemClock.sleep(r11)     // Catch:{ all -> 0x01f8 }
            int r8 = r8 + 20
            if (r10 == 0) goto L_0x01d3
            r10.close()
        L_0x01d3:
            if (r5 == 0) goto L_0x01f3
            r5.close()
            goto L_0x01f3
        L_0x01d9:
            r0 = move-exception
            r5 = r3
            r10 = r5
        L_0x01dc:
            com.google.android.gms.measurement.internal.zzex r11 = r21.zzq()     // Catch:{ all -> 0x01f8 }
            com.google.android.gms.measurement.internal.zzez r11 = r11.zze()     // Catch:{ all -> 0x01f8 }
            r11.zza(r2, r0)     // Catch:{ all -> 0x01f8 }
            r1.zzb = r9     // Catch:{ all -> 0x01f8 }
            if (r10 == 0) goto L_0x01ee
            r10.close()
        L_0x01ee:
            if (r5 == 0) goto L_0x01f3
            r5.close()
        L_0x01f3:
            int r7 = r7 + 1
            r5 = 5
            goto L_0x001d
        L_0x01f8:
            r0 = move-exception
        L_0x01f9:
            if (r10 == 0) goto L_0x01fe
            r10.close()
        L_0x01fe:
            if (r5 == 0) goto L_0x0203
            r5.close()
        L_0x0203:
            throw r0
        L_0x0204:
            com.google.android.gms.measurement.internal.zzex r0 = r21.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzh()
            java.lang.String r2 = "Failed to read events from database in reasonable time"
            r0.zza(r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzet.zza(int):java.util.List");
    }

    @WorkerThread
    public final boolean zzab() {
        return zza(3, new byte[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0086, code lost:
        r3 = r3 + 1;
     */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzac() {
        /*
            r11 = this;
            java.lang.String r0 = "Error deleting app launch break from local database"
            r11.zzc()
            boolean r1 = r11.zzb
            r2 = 0
            if (r1 == 0) goto L_0x000b
            return r2
        L_0x000b:
            boolean r1 = r11.zzae()
            if (r1 != 0) goto L_0x0012
            return r2
        L_0x0012:
            r1 = 5
            r3 = 0
            r4 = 5
        L_0x0015:
            if (r3 >= r1) goto L_0x008f
            r5 = 0
            r6 = 1
            android.database.sqlite.SQLiteDatabase r5 = r11.zzad()     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            if (r5 != 0) goto L_0x0027
            r11.zzb = r6     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            if (r5 == 0) goto L_0x0026
            r5.close()
        L_0x0026:
            return r2
        L_0x0027:
            r5.beginTransaction()     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            java.lang.String r7 = "messages"
            java.lang.String r8 = "type == ?"
            java.lang.String[] r9 = new java.lang.String[r6]     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            r10 = 3
            java.lang.String r10 = java.lang.Integer.toString(r10)     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            r9[r2] = r10     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            r5.delete(r7, r8, r9)     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            r5.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            r5.endTransaction()     // Catch:{ SQLiteFullException -> 0x0073, SQLiteDatabaseLockedException -> 0x0067, SQLiteException -> 0x0048 }
            if (r5 == 0) goto L_0x0045
            r5.close()
        L_0x0045:
            return r6
        L_0x0046:
            r0 = move-exception
            goto L_0x0089
        L_0x0048:
            r7 = move-exception
            if (r5 == 0) goto L_0x0054
            boolean r8 = r5.inTransaction()     // Catch:{ all -> 0x0046 }
            if (r8 == 0) goto L_0x0054
            r5.endTransaction()     // Catch:{ all -> 0x0046 }
        L_0x0054:
            com.google.android.gms.measurement.internal.zzex r8 = r11.zzq()     // Catch:{ all -> 0x0046 }
            com.google.android.gms.measurement.internal.zzez r8 = r8.zze()     // Catch:{ all -> 0x0046 }
            r8.zza(r0, r7)     // Catch:{ all -> 0x0046 }
            r11.zzb = r6     // Catch:{ all -> 0x0046 }
            if (r5 == 0) goto L_0x0086
            r5.close()
            goto L_0x0086
        L_0x0067:
            long r6 = (long) r4
            android.os.SystemClock.sleep(r6)     // Catch:{ all -> 0x0046 }
            int r4 = r4 + 20
            if (r5 == 0) goto L_0x0086
            r5.close()
            goto L_0x0086
        L_0x0073:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzex r8 = r11.zzq()     // Catch:{ all -> 0x0046 }
            com.google.android.gms.measurement.internal.zzez r8 = r8.zze()     // Catch:{ all -> 0x0046 }
            r8.zza(r0, r7)     // Catch:{ all -> 0x0046 }
            r11.zzb = r6     // Catch:{ all -> 0x0046 }
            if (r5 == 0) goto L_0x0086
            r5.close()
        L_0x0086:
            int r3 = r3 + 1
            goto L_0x0015
        L_0x0089:
            if (r5 == 0) goto L_0x008e
            r5.close()
        L_0x008e:
            throw r0
        L_0x008f:
            com.google.android.gms.measurement.internal.zzex r0 = r11.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzh()
            java.lang.String r1 = "Error deleting app launch break from local database in reasonable time"
            r0.zza(r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzet.zzac():boolean");
    }

    private static long zza(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{ExifInterface.GPS_MEASUREMENT_3D}, (String) null, (String) null, "rowid desc", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
            if (cursor.moveToFirst()) {
                return cursor.getLong(0);
            }
            if (cursor == null) {
                return -1;
            }
            cursor.close();
            return -1;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final SQLiteDatabase zzad() throws SQLiteException {
        if (this.zzb) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zza.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzb = true;
        return null;
    }

    @VisibleForTesting
    private final boolean zzae() {
        return zzm().getDatabasePath("google_app_measurement_local.db").exists();
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ zza zzd() {
        return super.zzd();
    }

    public final /* bridge */ /* synthetic */ zzhe zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzeq zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zziv zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzim zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zzet zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzkb zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzal zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzev zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzkx zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzfu zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzex zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzfj zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzy zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }
}
