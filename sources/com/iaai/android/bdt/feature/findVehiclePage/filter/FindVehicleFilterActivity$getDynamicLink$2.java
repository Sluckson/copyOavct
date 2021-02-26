package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo66933d2 = {"<anonymous>", "", "e", "Ljava/lang/Exception;", "onFailure"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FindVehicleFilterActivity.kt */
final class FindVehicleFilterActivity$getDynamicLink$2 implements OnFailureListener {
    final /* synthetic */ FindVehicleFilterActivity this$0;

    FindVehicleFilterActivity$getDynamicLink$2(FindVehicleFilterActivity findVehicleFilterActivity) {
        this.this$0 = findVehicleFilterActivity;
    }

    public final void onFailure(@NotNull Exception exc) {
        Intrinsics.checkParameterIsNotNull(exc, "e");
        Log.e(this.this$0.getTAG(), "getDynamicLink:onFailure", exc);
    }
}
