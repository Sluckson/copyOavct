package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.C1288R;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
@Deprecated
/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public final class GoogleServices {
    private static final Object sLock = new Object();
    @GuardedBy("sLock")
    private static GoogleServices zzbl;
    private final String zzbm;
    private final Status zzbn;
    private final boolean zzbo;
    private final boolean zzbp;

    @KeepForSdk
    @VisibleForTesting
    GoogleServices(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(C1288R.string.common_google_play_services_unknown_issue));
        boolean z = true;
        if (identifier != 0) {
            z = resources.getInteger(identifier) == 0 ? false : z;
            this.zzbp = !z;
        } else {
            this.zzbp = false;
        }
        this.zzbo = z;
        String zzd = zzp.zzd(context);
        zzd = zzd == null ? new StringResourceValueReader(context).getString("google_app_id") : zzd;
        if (TextUtils.isEmpty(zzd)) {
            this.zzbn = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.zzbm = null;
            return;
        }
        this.zzbm = zzd;
        this.zzbn = Status.RESULT_SUCCESS;
    }

    @KeepForSdk
    @VisibleForTesting
    GoogleServices(String str, boolean z) {
        this.zzbm = str;
        this.zzbn = Status.RESULT_SUCCESS;
        this.zzbo = z;
        this.zzbp = !z;
    }

    @KeepForSdk
    public static Status initialize(Context context, String str, boolean z) {
        Preconditions.checkNotNull(context, "Context must not be null.");
        Preconditions.checkNotEmpty(str, "App ID must be nonempty.");
        synchronized (sLock) {
            if (zzbl != null) {
                Status checkGoogleAppId = zzbl.checkGoogleAppId(str);
                return checkGoogleAppId;
            }
            GoogleServices googleServices = new GoogleServices(str, z);
            zzbl = googleServices;
            Status status = googleServices.zzbn;
            return status;
        }
    }

    /* access modifiers changed from: package-private */
    @KeepForSdk
    @VisibleForTesting
    public final Status checkGoogleAppId(String str) {
        String str2 = this.zzbm;
        if (str2 == null || str2.equals(str)) {
            return Status.RESULT_SUCCESS;
        }
        String str3 = this.zzbm;
        StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 97);
        sb.append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '");
        sb.append(str3);
        sb.append("'.");
        return new Status(10, sb.toString());
    }

    @KeepForSdk
    public static Status initialize(Context context) {
        Status status;
        Preconditions.checkNotNull(context, "Context must not be null.");
        synchronized (sLock) {
            if (zzbl == null) {
                zzbl = new GoogleServices(context);
            }
            status = zzbl.zzbn;
        }
        return status;
    }

    @KeepForSdk
    public static String getGoogleAppId() {
        return checkInitialized("getGoogleAppId").zzbm;
    }

    @KeepForSdk
    public static boolean isMeasurementEnabled() {
        GoogleServices checkInitialized = checkInitialized("isMeasurementEnabled");
        return checkInitialized.zzbn.isSuccess() && checkInitialized.zzbo;
    }

    @KeepForSdk
    public static boolean isMeasurementExplicitlyDisabled() {
        return checkInitialized("isMeasurementExplicitlyDisabled").zzbp;
    }

    @KeepForSdk
    @VisibleForTesting
    static void clearInstanceForTest() {
        synchronized (sLock) {
            zzbl = null;
        }
    }

    @KeepForSdk
    private static GoogleServices checkInitialized(String str) {
        GoogleServices googleServices;
        synchronized (sLock) {
            if (zzbl != null) {
                googleServices = zzbl;
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34);
                sb.append("Initialize must be called before ");
                sb.append(str);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
        }
        return googleServices;
    }
}
