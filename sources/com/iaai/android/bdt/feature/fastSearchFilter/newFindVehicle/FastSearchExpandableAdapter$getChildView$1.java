package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.view.View;
import android.widget.ImageView;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchExpandableAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchExpandableAdapter.kt */
final class FastSearchExpandableAdapter$getChildView$1 implements View.OnClickListener {
    final /* synthetic */ int $expandedListPosition;
    final /* synthetic */ ImageView $ivCheck;
    final /* synthetic */ int $listPosition;
    final /* synthetic */ FastSearchExpandableAdapter this$0;

    FastSearchExpandableAdapter$getChildView$1(FastSearchExpandableAdapter fastSearchExpandableAdapter, ImageView imageView, int i, int i2) {
        this.this$0 = fastSearchExpandableAdapter;
        this.$ivCheck = imageView;
        this.$listPosition = i;
        this.$expandedListPosition = i2;
    }

    public final void onClick(View view) {
        ImageView imageView = this.$ivCheck;
        Intrinsics.checkExpressionValueIsNotNull(imageView, "ivCheck");
        ImageView imageView2 = this.$ivCheck;
        Intrinsics.checkExpressionValueIsNotNull(imageView2, "ivCheck");
        imageView.setSelected(!imageView2.isSelected());
        this.this$0.updateListOnSelectItem(this.$listPosition, this.$expandedListPosition, false);
        FastSearchExpandableAdapter.OnFilterItemClickListener onItemClickListener = this.this$0.getOnItemClickListener();
        int i = this.$listPosition;
        int i2 = this.$expandedListPosition;
        ImageView imageView3 = this.$ivCheck;
        Intrinsics.checkExpressionValueIsNotNull(imageView3, "ivCheck");
        onItemClickListener.onMultiSelectItemClick(i, i2, imageView3.isSelected());
    }
}
