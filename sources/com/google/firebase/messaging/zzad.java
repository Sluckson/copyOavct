package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import androidx.annotation.GuardedBy;
import com.google.firebase.iid.zzao;
import java.io.IOException;
import repack.org.bouncycastle.crypto.tls.CipherSuite;

/* compiled from: com.google.firebase:firebase-messaging@@20.2.1 */
final class zzad implements Runnable {
    private static final Object zzf = new Object();
    @GuardedBy("TOPIC_SYNC_TASK_LOCK")
    private static Boolean zzg = null;
    @GuardedBy("TOPIC_SYNC_TASK_LOCK")
    private static Boolean zzh = null;
    private final Context zza;
    private final zzao zzb;
    private final PowerManager.WakeLock zzc;
    /* access modifiers changed from: private */
    public final zzab zzd;
    private final long zze;

    zzad(zzab zzab, Context context, zzao zzao, long j) {
        this.zzd = zzab;
        this.zza = context;
        this.zze = j;
        this.zzb = zzao;
        this.zzc = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    @SuppressLint({"Wakelock"})
    public final void run() {
        if (zza(this.zza)) {
            this.zzc.acquire(zzd.zza);
        }
        try {
            boolean z = true;
            this.zzd.zza(true);
            if (!this.zzb.zza()) {
                this.zzd.zza(false);
                if (zza(this.zza)) {
                    try {
                        this.zzc.release();
                    } catch (RuntimeException unused) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            } else if (!zzb(this.zza) || zzb()) {
                if (this.zzd.zzb()) {
                    this.zzd.zza(false);
                } else {
                    this.zzd.zza(this.zze);
                }
                if (zza(this.zza)) {
                    try {
                        this.zzc.release();
                    } catch (RuntimeException unused2) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            } else {
                zzac zzac = new zzac(this, this);
                if (!Log.isLoggable("FirebaseMessaging", 3)) {
                    if (Build.VERSION.SDK_INT != 23 || !Log.isLoggable("FirebaseMessaging", 3)) {
                        z = false;
                    }
                }
                if (z) {
                    Log.d("FirebaseMessaging", "Connectivity change received registered");
                }
                zzac.zza.zza.registerReceiver(zzac, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                if (zza(this.zza)) {
                    try {
                        this.zzc.release();
                    } catch (RuntimeException unused3) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            }
        } catch (IOException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.e("FirebaseMessaging", valueOf.length() != 0 ? "Failed to sync topics. Won't retry sync. ".concat(valueOf) : new String("Failed to sync topics. Won't retry sync. "));
            this.zzd.zza(false);
            if (zza(this.zza)) {
                try {
                    this.zzc.release();
                } catch (RuntimeException unused4) {
                    Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                }
            }
        } catch (Throwable th) {
            if (zza(this.zza)) {
                try {
                    this.zzc.release();
                } catch (RuntimeException unused5) {
                    Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                }
            }
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public final synchronized boolean zzb() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.zza.getSystemService("connectivity");
        activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* access modifiers changed from: private */
    public static boolean zzc() {
        if (!Log.isLoggable("FirebaseMessaging", 3)) {
            return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3);
        }
        return true;
    }

    private static boolean zza(Context context) {
        boolean z;
        boolean booleanValue;
        synchronized (zzf) {
            if (zzg == null) {
                z = zza(context, "android.permission.WAKE_LOCK", zzg);
            } else {
                z = zzg.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(z);
            zzg = valueOf;
            booleanValue = valueOf.booleanValue();
        }
        return booleanValue;
    }

    private static boolean zzb(Context context) {
        boolean z;
        boolean booleanValue;
        synchronized (zzf) {
            if (zzh == null) {
                z = zza(context, "android.permission.ACCESS_NETWORK_STATE", zzh);
            } else {
                z = zzh.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(z);
            zzh = valueOf;
            booleanValue = valueOf.booleanValue();
        }
        return booleanValue;
    }

    private static boolean zza(Context context, String str, Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = context.checkCallingOrSelfPermission(str) == 0;
        if (!z && Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + CipherSuite.TLS_DHE_PSK_WITH_RC4_128_SHA);
            sb.append("Missing Permission: ");
            sb.append(str);
            sb.append(". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest");
            Log.d("FirebaseMessaging", sb.toString());
        }
        return z;
    }
}
