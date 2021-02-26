package com.iaai.android.bdt.feature.login;

import android.view.KeyEvent;
import android.widget.TextView;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, mo66933d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "<anonymous parameter 2>", "Landroid/view/KeyEvent;", "onEditorAction"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: PromptPasswordDialog.kt */
final class PromptPasswordDialog$onCreate$1 implements TextView.OnEditorActionListener {
    final /* synthetic */ PromptPasswordDialog this$0;

    PromptPasswordDialog$onCreate$1(PromptPasswordDialog promptPasswordDialog) {
        this.this$0 = promptPasswordDialog;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 2) {
            return false;
        }
        this.this$0.checkValidPassword();
        return false;
    }
}
