package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.zzao;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* compiled from: com.google.firebase:firebase-messaging@@20.2.1 */
public class FirebaseMessaging {
    public static final String INSTANCE_ID_SCOPE = "FCM";
    @VisibleForTesting
    @SuppressLint({"FirebaseUnknownNullness"})
    @Nullable
    static TransportFactory zza;
    private final Context zzb;
    private final FirebaseInstanceId zzc;
    private final Task<zzab> zzd;

    @NonNull
    public static synchronized FirebaseMessaging getInstance() {
        FirebaseMessaging instance;
        synchronized (FirebaseMessaging.class) {
            instance = getInstance(FirebaseApp.getInstance());
        }
        return instance;
    }

    @NonNull
    @Keep
    static synchronized FirebaseMessaging getInstance(@NonNull FirebaseApp firebaseApp) {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = (FirebaseMessaging) firebaseApp.get(FirebaseMessaging.class);
        }
        return firebaseMessaging;
    }

    FirebaseMessaging(FirebaseApp firebaseApp, FirebaseInstanceId firebaseInstanceId, UserAgentPublisher userAgentPublisher, HeartBeatInfo heartBeatInfo, FirebaseInstallationsApi firebaseInstallationsApi, @Nullable TransportFactory transportFactory) {
        zza = transportFactory;
        this.zzc = firebaseInstanceId;
        this.zzb = firebaseApp.getApplicationContext();
        this.zzd = zzab.zza(firebaseApp, firebaseInstanceId, new zzao(this.zzb), userAgentPublisher, heartBeatInfo, firebaseInstallationsApi, this.zzb, zzi.zza(), new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-Messaging-Topics-Io")));
        this.zzd.addOnSuccessListener(zzi.zzb(), new zzk(this));
    }

    public boolean isAutoInitEnabled() {
        return this.zzc.zzh();
    }

    public void setAutoInitEnabled(boolean z) {
        this.zzc.zzb(z);
    }

    @NonNull
    public boolean deliveryMetricsExportToBigQueryEnabled() {
        return zzr.zza();
    }

    public void setDeliveryMetricsExportToBigQuery(boolean z) {
        zzr.zza(z);
    }

    @NonNull
    public Task<Void> subscribeToTopic(@NonNull String str) {
        return this.zzd.onSuccessTask(new zzm(str));
    }

    @NonNull
    public Task<Void> unsubscribeFromTopic(@NonNull String str) {
        return this.zzd.onSuccessTask(new zzl(str));
    }

    public void send(@NonNull RemoteMessage remoteMessage) {
        if (!TextUtils.isEmpty(remoteMessage.getTo())) {
            Intent intent = new Intent("com.google.android.gcm.intent.SEND");
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            intent.putExtra("app", PendingIntent.getBroadcast(this.zzb, 0, intent2, 0));
            intent.setPackage("com.google.android.gms");
            intent.putExtras(remoteMessage.zza);
            this.zzb.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
            return;
        }
        throw new IllegalArgumentException("Missing 'to'");
    }
}
