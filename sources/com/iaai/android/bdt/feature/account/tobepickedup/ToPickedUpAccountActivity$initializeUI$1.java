package com.iaai.android.bdt.feature.account.tobepickedup;

import android.content.Intent;
import android.view.View;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.digitalNegotiation.DNToolTipActivity;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.ToolTipActvityStatus;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ToPickedUpAccountActivity.kt */
final class ToPickedUpAccountActivity$initializeUI$1 implements View.OnClickListener {
    final /* synthetic */ ToPickedUpAccountActivity this$0;

    ToPickedUpAccountActivity$initializeUI$1(ToPickedUpAccountActivity toPickedUpAccountActivity) {
        this.this$0 = toPickedUpAccountActivity;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.this$0, DNToolTipActivity.class);
        intent.putExtra(Constants_MVVM.EXTRA_TOOLBAR_TITLE, this.this$0.getString(C2723R.string.lbl_to_be_pickedup_tooltip));
        intent.putExtra(Constants_MVVM.EXTRA_TOOLTIP_STATUS, ToolTipActvityStatus.ToBePickedUP_ToolTip.getValue());
        this.this$0.startActivity(intent);
    }
}
