package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.view.View;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchMoreFilterAdapter;
import com.iaai.android.bdt.model.fastSearchFilter2.FacetXX;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchMoreFilterAdapter.kt */
final class FastSearchMoreFilterAdapter$ViewHolderRadioButton$bind$1 implements View.OnClickListener {
    final /* synthetic */ FastSearchMoreFilterAdapter.ViewHolderRadioButton this$0;

    FastSearchMoreFilterAdapter$ViewHolderRadioButton$bind$1(FastSearchMoreFilterAdapter.ViewHolderRadioButton viewHolderRadioButton) {
        this.this$0 = viewHolderRadioButton;
    }

    public final void onClick(View view) {
        if (!((FacetXX) this.this$0.this$0.facetxxList.get(this.this$0.getAdapterPosition())).isSelected()) {
            List access$getFacetxxList$p = this.this$0.this$0.facetxxList;
            if (access$getFacetxxList$p != null) {
                int i = 0;
                for (Object next : access$getFacetxxList$p) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ((FacetXX) this.this$0.this$0.facetxxList.get(i)).setSelected(Intrinsics.areEqual((Object) ((FacetXX) this.this$0.this$0.facetxxList.get(this.this$0.getAdapterPosition())).getValue(), (Object) ((FacetXX) next).getValue()));
                    i = i2;
                }
            }
            FastSearchMoreFilterAdapter.access$getOnItemClickListener$p(this.this$0.this$0).onItemClick((FacetXX) this.this$0.this$0.facetxxList.get(this.this$0.getAdapterPosition()), true);
            this.this$0.this$0.notifyDataSetChanged();
        }
    }
}
