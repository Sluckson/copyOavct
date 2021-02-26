package com.iaai.android.bdt.extensions;

import android.content.DialogInterface;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo66933d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: Activity+Extension.kt */
final class Activity_ExtensionKt$showAlertWithTitle$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ OnAlertButtonClick $onAlertButtonClick;

    Activity_ExtensionKt$showAlertWithTitle$1(OnAlertButtonClick onAlertButtonClick) {
        this.$onAlertButtonClick = onAlertButtonClick;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
        this.$onAlertButtonClick.onOKClick();
    }
}
