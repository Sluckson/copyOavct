package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.old.utils.IAASharedPreference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FilterFragment.kt */
final class FilterFragment$setOnClick$3 implements View.OnClickListener {
    final /* synthetic */ FilterFragment this$0;

    FilterFragment$setOnClick$3(FilterFragment filterFragment) {
        this.this$0 = filterFragment;
    }

    public final void onClick(View view) {
        RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C2723R.C2726id.rvClearFilter);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvClearFilter");
        recyclerView.setVisibility(8);
        View _$_findCachedViewById = this.this$0._$_findCachedViewById(C2723R.C2726id.borderBottomClearFilter);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "borderBottomClearFilter");
        _$_findCachedViewById.setVisibility(8);
        this.this$0.keywordSearch = "";
        ((TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.filterFragmentSearch)).setText("");
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.filterFragmentSearch);
        Intrinsics.checkExpressionValueIsNotNull(textView, "filterFragmentSearch");
        textView.setHint(this.this$0.getString(C2723R.string.hint_search_vehicle));
        IAASharedPreference.setRefinerSearch(FilterFragment.access$getFilterActivity$p(this.this$0), "");
        this.this$0.clearAllFilters();
    }
}
