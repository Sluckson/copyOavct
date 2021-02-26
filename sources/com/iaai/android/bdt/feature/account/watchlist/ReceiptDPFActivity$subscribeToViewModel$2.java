package com.iaai.android.bdt.feature.account.watchlist;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ReceiptDPFActivity.kt */
final class ReceiptDPFActivity$subscribeToViewModel$2<T> implements Observer<String> {
    final /* synthetic */ ReceiptDPFActivity this$0;

    ReceiptDPFActivity$subscribeToViewModel$2(ReceiptDPFActivity receiptDPFActivity) {
        this.this$0 = receiptDPFActivity;
    }

    public final void onChanged(String str) {
        LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.pd_receipt);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "pd_receipt");
        linearLayout.setVisibility(8);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.this$0);
        builder.setMessage(C2723R.string.no_receipt_avaliable_at_this_time);
        builder.setPositiveButton(C2723R.string.lbl_OK_lower, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ ReceiptDPFActivity$subscribeToViewModel$2 this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.this$0.this$0.finish();
            }
        });
        builder.create().show();
    }
}
