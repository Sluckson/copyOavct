package com.iaai.android.bdt.feature.account.watchlist;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.MyAccount.VehicleReceiptPDFResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/MyAccount/VehicleReceiptPDFResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ReceiptDPFActivity.kt */
final class ReceiptDPFActivity$subscribeToViewModel$1<T> implements Observer<VehicleReceiptPDFResponse> {
    final /* synthetic */ ReceiptDPFActivity this$0;

    ReceiptDPFActivity$subscribeToViewModel$1(ReceiptDPFActivity receiptDPFActivity) {
        this.this$0 = receiptDPFActivity;
    }

    public final void onChanged(VehicleReceiptPDFResponse vehicleReceiptPDFResponse) {
        byte[] bArr;
        String str;
        if (vehicleReceiptPDFResponse.getErrorMessage() == null) {
            byte[] bArr2 = null;
            if (this.this$0.isReceipt) {
                str = this.this$0.getString(C2723R.string.bdt_receipt_page_title);
                Intrinsics.checkExpressionValueIsNotNull(str, "getString(R.string.bdt_receipt_page_title)");
                bArr = vehicleReceiptPDFResponse.getOrderReceiptImage();
            } else {
                str = this.this$0.getString(C2723R.string.bdt_stock_receipt_title);
                Intrinsics.checkExpressionValueIsNotNull(str, "getString(R.string.bdt_stock_receipt_title)");
                bArr = vehicleReceiptPDFResponse.getStockReceiptImage();
            }
            if (bArr != null) {
                if (this.this$0.createReceiptPDF(bArr, str + "_" + this.this$0.report_title + "_" + this.this$0.salavgeID + ".pdf")) {
                    ReceiptDPFActivity receiptDPFActivity = this.this$0;
                    receiptDPFActivity.loadPDF(receiptDPFActivity.report_title, true, this.this$0.getReceipt_file_path());
                    LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.pd_receipt);
                    Intrinsics.checkExpressionValueIsNotNull(linearLayout, "pd_receipt");
                    linearLayout.setVisibility(8);
                    return;
                }
            }
            LinearLayout linearLayout2 = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.pd_receipt);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "pd_receipt");
            linearLayout2.setVisibility(8);
            if (!this.this$0.isFinishing()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this.this$0);
                builder.setMessage(C2723R.string.no_receipt_avaliable_at_this_time);
                builder.setPositiveButton(C2723R.string.lbl_OK_lower, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ ReceiptDPFActivity$subscribeToViewModel$1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.this$0.this$0.finish();
                    }
                });
                builder.create().show();
            }
        } else if (!this.this$0.isFinishing()) {
            AlertDialog.Builder builder2 = new AlertDialog.Builder(this.this$0);
            builder2.setMessage(vehicleReceiptPDFResponse.getErrorMessage());
            builder2.setPositiveButton(C2723R.string.lbl_OK_lower, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ ReceiptDPFActivity$subscribeToViewModel$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.this$0.this$0.finish();
                }
            });
            builder2.create().show();
        }
    }
}
