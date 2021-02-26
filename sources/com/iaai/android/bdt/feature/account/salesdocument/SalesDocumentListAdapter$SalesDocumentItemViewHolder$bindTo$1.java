package com.iaai.android.bdt.feature.account.salesdocument;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentListAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SalesDocumentListAdapter.kt */
final class SalesDocumentListAdapter$SalesDocumentItemViewHolder$bindTo$1 implements View.OnClickListener {
    final /* synthetic */ SalesDocumentListAdapter.SalesDocumentItemViewHolder this$0;

    SalesDocumentListAdapter$SalesDocumentItemViewHolder$bindTo$1(SalesDocumentListAdapter.SalesDocumentItemViewHolder salesDocumentItemViewHolder) {
        this.this$0 = salesDocumentItemViewHolder;
    }

    public final void onClick(View view) {
        ConstraintLayout constraintLayout = this.this$0.getBinding().ClReviewDetailsContainer;
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "binding.ClReviewDetailsContainer");
        if (constraintLayout.getVisibility() == 0) {
            ConstraintLayout constraintLayout2 = this.this$0.getBinding().ClReviewDetailsContainer;
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "binding.ClReviewDetailsContainer");
            constraintLayout2.setVisibility(8);
            ImageView imageView = this.this$0.getBinding().ivTotalDueArrow;
            Intrinsics.checkExpressionValueIsNotNull(imageView, "binding.ivTotalDueArrow");
            imageView.setSelected(false);
            return;
        }
        ConstraintLayout constraintLayout3 = this.this$0.getBinding().ClReviewDetailsContainer;
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout3, "binding.ClReviewDetailsContainer");
        constraintLayout3.setVisibility(0);
        ImageView imageView2 = this.this$0.getBinding().ivTotalDueArrow;
        Intrinsics.checkExpressionValueIsNotNull(imageView2, "binding.ivTotalDueArrow");
        imageView2.setSelected(true);
    }
}
