package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.view.View;
import com.iaai.android.bdt.model.fastSearchFilter2.FacetXX;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: RefinerHeaderAdapter.kt */
final class RefinerHeaderAdapter$onBindViewHolder$1 implements View.OnClickListener {
    final /* synthetic */ int $position;
    final /* synthetic */ FacetXX $result;
    final /* synthetic */ RefinerHeaderAdapter this$0;

    RefinerHeaderAdapter$onBindViewHolder$1(RefinerHeaderAdapter refinerHeaderAdapter, int i, FacetXX facetXX) {
        this.this$0 = refinerHeaderAdapter;
        this.$position = i;
        this.$result = facetXX;
    }

    public final void onClick(View view) {
        RefinerHeaderAdapter refinerHeaderAdapter = this.this$0;
        refinerHeaderAdapter.setSelectedIndicesCount(refinerHeaderAdapter.getSelectedIndicesCount() - 1);
        Object obj = this.this$0.indicesList.get(this.$position);
        Intrinsics.checkExpressionValueIsNotNull(obj, "indicesList[position]");
        this.this$0.itemList.remove(this.$position);
        this.this$0.indicesList.remove(this.$position);
        RefinerHeaderAdapter.access$getOnRefinerHeaderItemClickListener$p(this.this$0).onItemClick((Triple) obj, this.$result, this.$position);
        this.this$0.notifyDataSetChanged();
    }
}
