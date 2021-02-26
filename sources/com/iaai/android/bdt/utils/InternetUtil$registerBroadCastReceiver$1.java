package com.iaai.android.bdt.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo66933d2 = {"com/iaai/android/bdt/utils/InternetUtil$registerBroadCastReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "_context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: InternetUtil.kt */
public final class InternetUtil$registerBroadCastReceiver$1 extends BroadcastReceiver {
    InternetUtil$registerBroadCastReceiver$1() {
    }

    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(context, "_context");
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        NetworkInfo networkInfo = (NetworkInfo) intent.getExtras().getParcelable("networkInfo");
        InternetUtil internetUtil = InternetUtil.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(networkInfo, "info");
        internetUtil.setValue(Boolean.valueOf(networkInfo.getState() == NetworkInfo.State.CONNECTED));
    }
}
