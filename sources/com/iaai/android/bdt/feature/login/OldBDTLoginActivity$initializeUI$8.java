package com.iaai.android.bdt.feature.login;

import android.view.KeyEvent;
import android.widget.TextView;
import com.iaai.android.old.utils.p016ui.ActivityHelper;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, mo66933d2 = {"<anonymous>", "", "view", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "<anonymous parameter 2>", "Landroid/view/KeyEvent;", "onEditorAction"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: OldBDTLoginActivity.kt */
final class OldBDTLoginActivity$initializeUI$8 implements TextView.OnEditorActionListener {
    final /* synthetic */ OldBDTLoginActivity this$0;

    OldBDTLoginActivity$initializeUI$8(OldBDTLoginActivity oldBDTLoginActivity) {
        this.this$0 = oldBDTLoginActivity;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        ActivityHelper.closeSoftKeyboard(this.this$0, textView);
        if (i != 2 && i != 6) {
            return false;
        }
        this.this$0.login();
        return true;
    }
}
