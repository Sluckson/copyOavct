package com.iaai.android.bdt.feature.productDetail.reports;

import android.print.PdfPrint;
import android.widget.ProgressBar;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo66933d2 = {"<anonymous>", "", "onPDFCreationDone"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: IAAConditionReportActivity.kt */
final class IAAConditionReportActivity$savePDF$pdfPrint$1 implements PdfPrint.OnPDFWriteComplete {
    final /* synthetic */ IAAConditionReportActivity this$0;

    IAAConditionReportActivity$savePDF$pdfPrint$1(IAAConditionReportActivity iAAConditionReportActivity) {
        this.this$0 = iAAConditionReportActivity;
    }

    public final void onPDFCreationDone() {
        ProgressBar progressBar = (ProgressBar) this.this$0._$_findCachedViewById(C2723R.C2726id.ic_pbLoading);
        Intrinsics.checkExpressionValueIsNotNull(progressBar, "ic_pbLoading");
        progressBar.setVisibility(8);
        this.this$0.sharePDF();
    }
}
