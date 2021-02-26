package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@20.2.1 */
public class FirebaseInstanceId {
    private static final long zza = TimeUnit.HOURS.toSeconds(8);
    private static zzaz zzb;
    private static final Pattern zzc = Pattern.compile("\\AA[\\w-]{38}\\z");
    @GuardedBy("FirebaseInstanceId.class")
    @VisibleForTesting
    private static ScheduledExecutorService zzd;
    @VisibleForTesting
    private final Executor zze;
    /* access modifiers changed from: private */
    public final FirebaseApp zzf;
    private final zzao zzg;
    private final zzt zzh;
    private final zzat zzi;
    private final FirebaseInstallationsApi zzj;
    @GuardedBy("this")
    private boolean zzk;
    private final zza zzl;

    @NonNull
    public static FirebaseInstanceId getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    @NonNull
    @Keep
    public static FirebaseInstanceId getInstance(@NonNull FirebaseApp firebaseApp) {
        zza(firebaseApp);
        return (FirebaseInstanceId) firebaseApp.get(FirebaseInstanceId.class);
    }

    /* compiled from: com.google.firebase:firebase-iid@@20.2.1 */
    private class zza {
        private boolean zzb;
        private final Subscriber zzc;
        @GuardedBy("this")
        private boolean zzd;
        @GuardedBy("this")
        @Nullable
        private EventHandler<DataCollectionDefaultChange> zze;
        @GuardedBy("this")
        @Nullable
        private Boolean zzf;

        zza(Subscriber subscriber) {
            this.zzc = subscriber;
        }

        private final synchronized void zzb() {
            if (!this.zzd) {
                this.zzb = zzd();
                this.zzf = zzc();
                if (this.zzf == null && this.zzb) {
                    this.zze = new zzq(this);
                    this.zzc.subscribe(DataCollectionDefaultChange.class, this.zze);
                }
                this.zzd = true;
            }
        }

        /* access modifiers changed from: package-private */
        public final synchronized boolean zza() {
            zzb();
            if (this.zzf == null) {
                return this.zzb && FirebaseInstanceId.this.zzf.isDataCollectionDefaultEnabled();
            }
            return this.zzf.booleanValue();
        }

        /* access modifiers changed from: package-private */
        public final synchronized void zza(boolean z) {
            zzb();
            if (this.zze != null) {
                this.zzc.unsubscribe(DataCollectionDefaultChange.class, this.zze);
                this.zze = null;
            }
            SharedPreferences.Editor edit = FirebaseInstanceId.this.zzf.getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit();
            edit.putBoolean("auto_init", z);
            edit.apply();
            if (z) {
                FirebaseInstanceId.this.zzj();
            }
            this.zzf = Boolean.valueOf(z);
        }

        @Nullable
        private final Boolean zzc() {
            ApplicationInfo applicationInfo;
            Context applicationContext = FirebaseInstanceId.this.zzf.getApplicationContext();
            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = applicationContext.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        private final boolean zzd() {
            try {
                Class.forName("com.google.firebase.messaging.FirebaseMessaging");
                return true;
            } catch (ClassNotFoundException unused) {
                Context applicationContext = FirebaseInstanceId.this.zzf.getApplicationContext();
                Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent.setPackage(applicationContext.getPackageName());
                ResolveInfo resolveService = applicationContext.getPackageManager().resolveService(intent, 0);
                if (resolveService == null || resolveService.serviceInfo == null) {
                    return false;
                }
                return true;
            }
        }
    }

    FirebaseInstanceId(FirebaseApp firebaseApp, Subscriber subscriber, UserAgentPublisher userAgentPublisher, HeartBeatInfo heartBeatInfo, FirebaseInstallationsApi firebaseInstallationsApi) {
        this(firebaseApp, new zzao(firebaseApp.getApplicationContext()), zzh.zzb(), zzh.zzb(), subscriber, userAgentPublisher, heartBeatInfo, firebaseInstallationsApi);
    }

    private FirebaseInstanceId(FirebaseApp firebaseApp, zzao zzao, Executor executor, Executor executor2, Subscriber subscriber, UserAgentPublisher userAgentPublisher, HeartBeatInfo heartBeatInfo, FirebaseInstallationsApi firebaseInstallationsApi) {
        Executor executor3 = executor2;
        this.zzk = false;
        if (zzao.zza(firebaseApp) != null) {
            synchronized (FirebaseInstanceId.class) {
                if (zzb == null) {
                    zzb = new zzaz(firebaseApp.getApplicationContext());
                }
            }
            this.zzf = firebaseApp;
            this.zzg = zzao;
            this.zzh = new zzt(firebaseApp, zzao, executor, userAgentPublisher, heartBeatInfo, firebaseInstallationsApi);
            this.zze = executor3;
            this.zzl = new zza(subscriber);
            Executor executor4 = executor;
            this.zzi = new zzat(executor);
            this.zzj = firebaseInstallationsApi;
            executor3.execute(new zzl(this));
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }

    /* access modifiers changed from: private */
    public final void zzj() {
        if (zza(zzb())) {
            zzk();
        }
    }

    /* access modifiers changed from: package-private */
    public final FirebaseApp zza() {
        return this.zzf;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(boolean z) {
        this.zzk = z;
    }

    private final synchronized void zzk() {
        if (!this.zzk) {
            zza(0);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(long j) {
        zza((Runnable) new zzbb(this, Math.min(Math.max(30, j << 1), zza)), j);
        this.zzk = true;
    }

    static void zza(Runnable runnable, long j) {
        synchronized (FirebaseInstanceId.class) {
            if (zzd == null) {
                zzd = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("FirebaseInstanceId"));
            }
            zzd.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    @WorkerThread
    @NonNull
    public String getId() {
        zza(this.zzf);
        zzj();
        return zzl();
    }

    private static void zza(@NonNull FirebaseApp firebaseApp) {
        Preconditions.checkNotEmpty(firebaseApp.getOptions().getProjectId(), "Please set your project ID. A valid Firebase project ID is required to communicate with Firebase server APIs: It identifies your project with Google.");
        Preconditions.checkNotEmpty(firebaseApp.getOptions().getApplicationId(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.");
        Preconditions.checkNotEmpty(firebaseApp.getOptions().getApiKey(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.");
        Preconditions.checkArgument(firebaseApp.getOptions().getApplicationId().contains(":"), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(zzc.matcher(firebaseApp.getOptions().getApiKey()).matches(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    private final String zzl() {
        try {
            zzb.zzb(this.zzf.getPersistenceKey());
            Task<String> id = this.zzj.getId();
            Preconditions.checkNotNull(id, "Task must not be null");
            CountDownLatch countDownLatch = new CountDownLatch(1);
            id.addOnCompleteListener(zzn.zza, (OnCompleteListener<String>) new zzm(countDownLatch));
            countDownLatch.await(30000, TimeUnit.MILLISECONDS);
            if (id.isSuccessful()) {
                return id.getResult();
            }
            if (id.isCanceled()) {
                throw new CancellationException("Task is already canceled");
            } else if (id.isComplete()) {
                throw new IllegalStateException(id.getException());
            } else {
                throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    public long getCreationTime() {
        return zzb.zza(this.zzf.getPersistenceKey());
    }

    @NonNull
    public Task<InstanceIdResult> getInstanceId() {
        zza(this.zzf);
        return zza(zzao.zza(this.zzf), "*");
    }

    private final Task<InstanceIdResult> zza(String str, String str2) {
        return Tasks.forResult(null).continueWithTask(this.zze, new zzk(this, str, zza(str2)));
    }

    @WorkerThread
    public void deleteInstanceId() throws IOException {
        zza(this.zzf);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            zza(this.zzj.delete());
            zze();
            return;
        }
        throw new IOException("MAIN_THREAD");
    }

    @Deprecated
    @Nullable
    public String getToken() {
        zza(this.zzf);
        zzay zzb2 = zzb();
        if (zza(zzb2)) {
            zzk();
        }
        return zzay.zza(zzb2);
    }

    @WorkerThread
    @Nullable
    public String getToken(@NonNull String str, @NonNull String str2) throws IOException {
        zza(this.zzf);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return ((InstanceIdResult) zza(zza(str, str2))).getToken();
        }
        throw new IOException("MAIN_THREAD");
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final zzay zzb() {
        return zzb(zzao.zza(this.zzf), "*");
    }

    @Nullable
    @VisibleForTesting
    private final zzay zzb(String str, String str2) {
        return zzb.zza(zzm(), str, str2);
    }

    /* access modifiers changed from: package-private */
    public final String zzc() throws IOException {
        return getToken(zzao.zza(this.zzf), "*");
    }

    private final <T> T zza(Task<T> task) throws IOException {
        try {
            return Tasks.await(task, 30000, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    zze();
                }
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e);
            }
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
    }

    @WorkerThread
    public void deleteToken(@NonNull String str, @NonNull String str2) throws IOException {
        zza(this.zzf);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            String zza2 = zza(str2);
            zza(this.zzh.zzb(zzl(), str, zza2));
            zzb.zzb(zzm(), str, zza2);
            return;
        }
        throw new IOException("MAIN_THREAD");
    }

    static boolean zzd() {
        if (!Log.isLoggable("FirebaseInstanceId", 3)) {
            return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zze() {
        zzb.zza();
        if (this.zzl.zza()) {
            zzk();
        }
    }

    @VisibleForTesting
    public final boolean zzf() {
        return this.zzg.zza();
    }

    /* access modifiers changed from: package-private */
    public final void zzg() {
        zzb.zzc(zzm());
        zzk();
    }

    @VisibleForTesting
    public final boolean zzh() {
        return this.zzl.zza();
    }

    @VisibleForTesting
    public final void zzb(boolean z) {
        this.zzl.zza(z);
    }

    private static String zza(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase("fcm") || str.equalsIgnoreCase(GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE)) ? "*" : str;
    }

    private final String zzm() {
        if (FirebaseApp.DEFAULT_APP_NAME.equals(this.zzf.getName())) {
            return "";
        }
        return this.zzf.getPersistenceKey();
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(@Nullable zzay zzay) {
        return zzay == null || zzay.zzb(this.zzg.zzc());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Task zza(String str, String str2, Task task) throws Exception {
        String zzl2 = zzl();
        zzay zzb2 = zzb(str, str2);
        if (!zza(zzb2)) {
            return Tasks.forResult(new zzaa(zzl2, zzb2.zza));
        }
        return this.zzi.zza(str, str2, new zzp(this, zzl2, str, str2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Task zza(String str, String str2, String str3) {
        return this.zzh.zza(str, str2, str3).onSuccessTask(this.zze, new zzo(this, str2, str3, str));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Task zza(String str, String str2, String str3, String str4) throws Exception {
        zzb.zza(zzm(), str, str2, str4, this.zzg.zzc());
        return Tasks.forResult(new zzaa(str3, str4));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi() {
        if (this.zzl.zza()) {
            zzj();
        }
    }
}
