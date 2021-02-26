package com.iaai.android.bdt.extensions;

import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo66933d2 = {"<anonymous>", "", "it", "Ljava/lang/Exception;", "onFailure"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: Activity+Extension.kt */
final class Activity_ExtensionKt$createDynamicLinkForProduct$2 implements OnFailureListener {
    public static final Activity_ExtensionKt$createDynamicLinkForProduct$2 INSTANCE = new Activity_ExtensionKt$createDynamicLinkForProduct$2();

    Activity_ExtensionKt$createDynamicLinkForProduct$2() {
    }

    public final void onFailure(@NotNull Exception exc) {
        Intrinsics.checkParameterIsNotNull(exc, "it");
        Log.e("createDynamicLink:", "Error " + exc.getLocalizedMessage());
    }
}
