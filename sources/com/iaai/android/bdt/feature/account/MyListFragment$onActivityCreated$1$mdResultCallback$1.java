package com.iaai.android.bdt.feature.account;

import android.util.Log;
import com.medallia.digital.mobilesdk.MDExternalError;
import com.medallia.digital.mobilesdk.MDResultCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, mo66933d2 = {"com/iaai/android/bdt/feature/account/MyListFragment$onActivityCreated$1$mdResultCallback$1", "Lcom/medallia/digital/mobilesdk/MDResultCallback;", "onError", "", "error", "Lcom/medallia/digital/mobilesdk/MDExternalError;", "onSuccess", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: MyListFragment.kt */
public final class MyListFragment$onActivityCreated$1$mdResultCallback$1 implements MDResultCallback {
    MyListFragment$onActivityCreated$1$mdResultCallback$1() {
    }

    public void onSuccess() {
        Log.d("Show Form", "Displayed");
    }

    public void onError(@NotNull MDExternalError mDExternalError) {
        Intrinsics.checkParameterIsNotNull(mDExternalError, "error");
        Log.d("Show Form", " show " + mDExternalError.getMessage());
    }
}
