package com.google.firebase.dynamiclinks.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;

final class zzi extends zzh {
    @Nullable
    private final AnalyticsConnector zzr;
    private final TaskCompletionSource<PendingDynamicLinkData> zzt;

    public zzi(AnalyticsConnector analyticsConnector, TaskCompletionSource<PendingDynamicLinkData> taskCompletionSource) {
        this.zzr = analyticsConnector;
        this.zzt = taskCompletionSource;
    }

    public final void zza(Status status, DynamicLinkData dynamicLinkData) {
        Bundle bundle;
        TaskUtil.setResultOrApiException(status, dynamicLinkData == null ? null : new PendingDynamicLinkData(dynamicLinkData), this.zzt);
        if (dynamicLinkData != null && (bundle = dynamicLinkData.zzf().getBundle("scionData")) != null && bundle.keySet() != null && this.zzr != null) {
            for (String str : bundle.keySet()) {
                this.zzr.logEvent("fdl", str, bundle.getBundle(str));
            }
        }
    }
}
