package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.content.Intent;
import android.view.View;
import com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity;
import com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.SelectedRefinerIndicesModel;
import com.iaai.android.bdt.model.fastSearchFilter2.FacetXX;
import com.iaai.android.bdt.utils.Constants_MVVM;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchFilterFragment.kt */
final class FastSearchFilterFragment$init$1 implements View.OnClickListener {
    final /* synthetic */ FastSearchFilterFragment this$0;

    FastSearchFilterFragment$init$1(FastSearchFilterFragment fastSearchFilterFragment) {
        this.this$0 = fastSearchFilterFragment;
    }

    public final void onClick(View view) {
        ArrayList<Triple> second;
        if (FastSearchFilterFragment.access$getFastSearchFilterActivity$p(this.this$0).isFromLandingPageSearch()) {
            Intent intent = new Intent(this.this$0.getContext(), RefinerResultActivity.class);
            RefinerHeaderAdapter access$getHeaderAdapter$p = this.this$0.headerAdapter;
            ArrayList arrayList = null;
            Pair<ArrayList<FacetXX>, ArrayList<Triple<Integer, Integer, Integer>>> headerItemData = access$getHeaderAdapter$p != null ? access$getHeaderAdapter$p.getHeaderItemData() : null;
            ArrayList arrayList2 = new ArrayList();
            if (!(headerItemData == null || (second = headerItemData.getSecond()) == null)) {
                for (Triple triple : second) {
                    arrayList2.add(new SelectedRefinerIndicesModel(((Number) triple.getFirst()).intValue(), ((Number) triple.getSecond()).intValue(), ((Number) triple.getThird()).intValue()));
                }
            }
            if (headerItemData != null) {
                arrayList = headerItemData.getFirst();
            }
            intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_FACETS, arrayList);
            intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_INDICES, arrayList2);
            FastSearchFilterFragment.access$getFastSearchFilterActivity$p(this.this$0).setResult(100, intent);
            FastSearchFilterFragment.access$getFastSearchFilterActivity$p(this.this$0).finish();
            return;
        }
        this.this$0.navigateToFilterResultScreen(false);
    }
}
