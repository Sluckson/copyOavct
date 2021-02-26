package com.iaai.android.bdt.feature.productDetail.reports;

import android.widget.LinearLayout;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.productDetail.reports.IAAConditionReportActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo66933d2 = {"<anonymous>", "", "run"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* renamed from: com.iaai.android.bdt.feature.productDetail.reports.IAAConditionReportActivity$IJavascriptHandler$sendTotalNoOfPage$1 */
/* compiled from: IAAConditionReportActivity.kt */
final class C2756x63779b6f implements Runnable {
    final /* synthetic */ int $noofpage;
    final /* synthetic */ IAAConditionReportActivity.IJavascriptHandler this$0;

    C2756x63779b6f(IAAConditionReportActivity.IJavascriptHandler iJavascriptHandler, int i) {
        this.this$0 = iJavascriptHandler;
        this.$noofpage = i;
    }

    public final void run() {
        if (this.$noofpage <= 1) {
            LinearLayout linearLayout = (LinearLayout) this.this$0.this$0._$_findCachedViewById(C2723R.C2726id.llPDFNavigation);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llPDFNavigation");
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout2 = (LinearLayout) this.this$0.this$0._$_findCachedViewById(C2723R.C2726id.llPDFNavigation);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "llPDFNavigation");
        linearLayout2.setVisibility(0);
    }
}
