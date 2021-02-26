package com.google.firebase.iid;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-iid@@20.2.1 */
public final class zzt {
    private final FirebaseApp zza;
    private final zzao zzb;
    private final zzau zzc;
    private final Executor zzd;
    private final UserAgentPublisher zze;
    private final HeartBeatInfo zzf;
    private final FirebaseInstallationsApi zzg;

    public zzt(FirebaseApp firebaseApp, zzao zzao, Executor executor, UserAgentPublisher userAgentPublisher, HeartBeatInfo heartBeatInfo, FirebaseInstallationsApi firebaseInstallationsApi) {
        this(firebaseApp, zzao, executor, new zzau(firebaseApp.getApplicationContext(), zzao), userAgentPublisher, heartBeatInfo, firebaseInstallationsApi);
    }

    @VisibleForTesting
    private zzt(FirebaseApp firebaseApp, zzao zzao, Executor executor, zzau zzau, UserAgentPublisher userAgentPublisher, HeartBeatInfo heartBeatInfo, FirebaseInstallationsApi firebaseInstallationsApi) {
        this.zza = firebaseApp;
        this.zzb = zzao;
        this.zzc = zzau;
        this.zzd = executor;
        this.zze = userAgentPublisher;
        this.zzf = heartBeatInfo;
        this.zzg = firebaseInstallationsApi;
    }

    public final Task<String> zza(String str, String str2, String str3) {
        return zzb(zza(str, str2, str3, new Bundle()));
    }

    public final Task<Void> zzb(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("delete", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
        return zza(zzb(zza(str, str2, str3, bundle)));
    }

    public final Task<Void> zzc(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        String valueOf2 = String.valueOf(str3);
        return zza(zzb(zza(str, str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle)));
    }

    public final Task<Void> zzd(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        bundle.putString("delete", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
        String valueOf2 = String.valueOf(str3);
        return zza(zzb(zza(str, str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle)));
    }

    private final Task<Bundle> zza(String str, String str2, String str3, Bundle bundle) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zzd.execute(new zzs(this, str, str2, str3, bundle, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private final String zza() {
        try {
            return Base64.encodeToString(MessageDigest.getInstance("SHA-1").digest(this.zza.getName().getBytes()), 11);
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    private final Bundle zzb(String str, String str2, String str3, Bundle bundle) {
        bundle.putString("scope", str3);
        bundle.putString("sender", str2);
        bundle.putString("subtype", str2);
        bundle.putString("appid", str);
        bundle.putString("gmp_app_id", this.zza.getOptions().getApplicationId());
        bundle.putString("gmsv", Integer.toString(this.zzb.zze()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.zzb.zzc());
        bundle.putString("app_ver_name", this.zzb.zzd());
        bundle.putString("firebase-app-name-hash", zza());
        try {
            String token = ((InstallationTokenResult) Tasks.await(this.zzg.getToken(false))).getToken();
            if (!TextUtils.isEmpty(token)) {
                bundle.putString("Goog-Firebase-Installations-Auth", token);
            } else {
                Log.w("FirebaseInstanceId", "FIS auth token is empty");
            }
        } catch (InterruptedException | ExecutionException e) {
            Log.e("FirebaseInstanceId", "Failed to get FIS auth token", e);
        }
        bundle.putString("cliv", "20.2.1".length() != 0 ? "fiid-".concat("20.2.1") : new String("fiid-"));
        HeartBeatInfo.HeartBeat heartBeatCode = this.zzf.getHeartBeatCode("fire-iid");
        if (heartBeatCode != HeartBeatInfo.HeartBeat.NONE) {
            bundle.putString("Firebase-Client-Log-Type", Integer.toString(heartBeatCode.getCode()));
            bundle.putString("Firebase-Client", this.zze.getUserAgent());
        }
        return bundle;
    }

    private static <T> Task<Void> zza(Task<T> task) {
        return task.continueWith(zzh.zza(), zzv.zza);
    }

    private final Task<String> zzb(Task<Bundle> task) {
        return task.continueWith(this.zzd, new zzu(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str, String str2, String str3, Bundle bundle, TaskCompletionSource taskCompletionSource) {
        try {
            zzb(str, str2, str3, bundle);
            taskCompletionSource.setResult(this.zzc.zza(bundle));
        } catch (IOException e) {
            taskCompletionSource.setException(e);
        }
    }
}
