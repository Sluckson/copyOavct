package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-iid@@20.2.1 */
final class zzaz {
    private final SharedPreferences zza;
    private final Context zzb;
    @GuardedBy("this")
    private final Map<String, Long> zzc = new ArrayMap();

    public zzaz(Context context) {
        this.zzb = context;
        this.zza = context.getSharedPreferences("com.google.android.gms.appid", 0);
        File file = new File(ContextCompat.getNoBackupFilesDir(this.zzb), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !zzb()) {
                    Log.i("FirebaseInstanceId", "App restored, clearing state");
                    zza();
                    FirebaseInstanceId.getInstance().zze();
                }
            } catch (IOException e) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(e.getMessage());
                    Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(valueOf) : new String("Error creating file in no backup dir: "));
                }
            }
        }
    }

    private final synchronized boolean zzb() {
        return this.zza.getAll().isEmpty();
    }

    private static String zzc(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        return sb.toString();
    }

    private static String zza(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("|S|");
        sb.append(str2);
        return sb.toString();
    }

    public final synchronized void zza() {
        this.zzc.clear();
        this.zza.edit().clear().commit();
    }

    public final synchronized zzay zza(String str, String str2, String str3) {
        return zzay.zza(this.zza.getString(zzc(str, str2, str3), (String) null));
    }

    public final synchronized void zza(String str, String str2, String str3, String str4, String str5) {
        String zza2 = zzay.zza(str4, str5, System.currentTimeMillis());
        if (zza2 != null) {
            SharedPreferences.Editor edit = this.zza.edit();
            edit.putString(zzc(str, str2, str3), zza2);
            edit.commit();
        }
    }

    public final synchronized void zzb(String str, String str2, String str3) {
        String zzc2 = zzc(str, str2, str3);
        SharedPreferences.Editor edit = this.zza.edit();
        edit.remove(zzc2);
        edit.commit();
    }

    public final synchronized long zza(String str) {
        Long l = this.zzc.get(str);
        if (l != null) {
            return l.longValue();
        }
        return zzd(str);
    }

    private final long zzd(String str) {
        String string = this.zza.getString(zza(str, "cre"), (String) null);
        if (string == null) {
            return 0;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public final synchronized long zzb(String str) {
        long currentTimeMillis;
        currentTimeMillis = System.currentTimeMillis();
        if (!this.zza.contains(zza(str, "cre"))) {
            SharedPreferences.Editor edit = this.zza.edit();
            edit.putString(zza(str, "cre"), String.valueOf(currentTimeMillis));
            edit.commit();
        } else {
            currentTimeMillis = zzd(str);
        }
        this.zzc.put(str, Long.valueOf(currentTimeMillis));
        return currentTimeMillis;
    }

    public final synchronized void zzc(String str) {
        String concat = String.valueOf(str).concat("|T|");
        SharedPreferences.Editor edit = this.zza.edit();
        for (String next : this.zza.getAll().keySet()) {
            if (next.startsWith(concat)) {
                edit.remove(next);
            }
        }
        edit.commit();
    }
}
