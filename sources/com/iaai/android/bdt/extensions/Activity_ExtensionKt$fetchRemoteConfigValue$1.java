package com.iaai.android.bdt.extensions;

import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.remoteconfig.FetchRemoteConfigCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, mo66933d2 = {"<anonymous>", "", "task", "Lcom/google/android/gms/tasks/Task;", "", "kotlin.jvm.PlatformType", "onComplete"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: Activity+Extension.kt */
final class Activity_ExtensionKt$fetchRemoteConfigValue$1<TResult> implements OnCompleteListener<Boolean> {
    final /* synthetic */ FetchRemoteConfigCallback $callback;

    Activity_ExtensionKt$fetchRemoteConfigValue$1(FetchRemoteConfigCallback fetchRemoteConfigCallback) {
        this.$callback = fetchRemoteConfigCallback;
    }

    public final void onComplete(@NotNull Task<Boolean> task) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        if (task.isSuccessful()) {
            Log.d("FCM Fetch", "Config params updated: " + task.getResult());
            IaaiApplication instance = IaaiApplication.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
            instance.getIAARemoteConfig().fetchAndActivateRemoteConfigValues();
            this.$callback.OnRemoteConfigAvailable();
        }
    }
}
