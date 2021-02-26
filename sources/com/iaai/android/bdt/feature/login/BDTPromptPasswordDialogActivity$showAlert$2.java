package com.iaai.android.bdt.feature.login;

import android.content.DialogInterface;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTPromptPasswordDialogActivity.kt */
final class BDTPromptPasswordDialogActivity$showAlert$2 implements DialogInterface.OnCancelListener {
    final /* synthetic */ BDTPromptPasswordDialogActivity this$0;

    BDTPromptPasswordDialogActivity$showAlert$2(BDTPromptPasswordDialogActivity bDTPromptPasswordDialogActivity) {
        this.this$0 = bDTPromptPasswordDialogActivity;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.this$0.getPromptPasswordDialog().dismiss();
        this.this$0.finish();
    }
}
