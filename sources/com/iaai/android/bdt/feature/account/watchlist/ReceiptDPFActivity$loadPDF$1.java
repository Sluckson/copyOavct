package com.iaai.android.bdt.feature.account.watchlist;

import android.content.Intent;
import android.view.View;
import androidx.core.content.FileProvider;
import com.iaai.android.C2723R;
import java.io.File;
import kotlin.Metadata;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ReceiptDPFActivity.kt */
final class ReceiptDPFActivity$loadPDF$1 implements View.OnClickListener {
    final /* synthetic */ String $filePath;
    final /* synthetic */ boolean $isVehicleReceipt;
    final /* synthetic */ String $report_title;
    final /* synthetic */ ReceiptDPFActivity this$0;

    ReceiptDPFActivity$loadPDF$1(ReceiptDPFActivity receiptDPFActivity, boolean z, String str, String str2) {
        this.this$0 = receiptDPFActivity;
        this.$isVehicleReceipt = z;
        this.$filePath = str;
        this.$report_title = str2;
    }

    public final void onClick(View view) {
        File file;
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        File file2 = null;
        StringBuilder sb = new StringBuilder();
        if (this.$isVehicleReceipt) {
            file = new File(this.$filePath);
            if (this.this$0.getSubject_line_text() == null) {
                this.this$0.setSubject_line_text("");
            }
            sb.append(this.this$0.getString(C2723R.string.receipt_page_title));
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb.append(this.$report_title);
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb.append(this.this$0.getString(C2723R.string.for_email_subject_line));
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb.append(this.this$0.getSubject_line_text());
        } else {
            file = new File(this.this$0.getReportPath());
            sb.append(this.this$0.getSubject_line_text());
        }
        intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(this.this$0, this.this$0.getPackageName() + ".provider", file));
        intent.putExtra("android.intent.extra.SUBJECT", sb.toString());
        intent.setType("application/pdf");
        intent.addFlags(1);
        ReceiptDPFActivity receiptDPFActivity = this.this$0;
        receiptDPFActivity.startActivity(Intent.createChooser(intent, receiptDPFActivity.getString(C2723R.string.lbl_send)));
    }
}
