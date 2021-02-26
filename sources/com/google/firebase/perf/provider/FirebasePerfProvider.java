package com.google.firebase.perf.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p010firebaseperf.zza;
import com.google.android.gms.internal.p010firebaseperf.zzah;
import com.google.android.gms.internal.p010firebaseperf.zzbk;
import com.google.android.gms.internal.p010firebaseperf.zzbw;
import com.google.android.gms.internal.p010firebaseperf.zzcg;
import com.google.firebase.perf.internal.SessionManager;
import com.google.firebase.perf.metrics.AppStartTrace;

@Keep
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public class FirebasePerfProvider extends ContentProvider {
    private static final zzbw zzhb = new zzbw();
    private final Handler mHandler = new zza(Looper.getMainLooper());

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Nullable
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return false;
    }

    @Nullable
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public static zzbw zzcz() {
        return zzhb;
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        Preconditions.checkNotNull(providerInfo, "FirebasePerfProvider ProviderInfo cannot be null.");
        if (!"com.google.firebase.firebaseperfprovider".equals(providerInfo.authority)) {
            super.attachInfo(context, providerInfo);
            zzah zzo = zzah.zzo();
            zzo.zzb(getContext());
            if (zzo.zzp()) {
                com.google.firebase.perf.internal.zza.zzbl().zze(getContext());
                AppStartTrace zzcq = AppStartTrace.zzcq();
                zzcq.zze(getContext());
                this.mHandler.post(new AppStartTrace.zza(zzcq));
            }
            SessionManager.zzcm().zzc(zzcg.FOREGROUND);
            return;
        }
        throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
    }

    static {
        new zzbk();
    }
}
