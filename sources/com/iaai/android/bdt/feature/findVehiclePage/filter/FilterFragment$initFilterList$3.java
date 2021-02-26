package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.findVehiclePage.filter.FilterListExpandableListAdapter;
import com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2;
import com.iaai.android.bdt.model.filter.FilterValues;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo66933d2 = {"com/iaai/android/bdt/feature/findVehiclePage/filter/FilterFragment$initFilterList$3", "Lcom/iaai/android/bdt/feature/findVehiclePage/filter/FilterListExpandableListAdapter$OnFilterItemClickListener;", "onChildItemClick", "", "parentPosition", "", "childPosition", "year", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FilterFragment.kt */
public final class FilterFragment$initFilterList$3 implements FilterListExpandableListAdapter.OnFilterItemClickListener {
    final /* synthetic */ FilterFragment this$0;

    FilterFragment$initFilterList$3(FilterFragment filterFragment) {
        this.this$0 = filterFragment;
    }

    public void onChildItemClick(int i, int i2, @NotNull String str) {
        String str2;
        String str3;
        Intrinsics.checkParameterIsNotNull(str, "year");
        boolean z = true;
        this.this$0.setApplyFilterBtn(true);
        RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C2723R.C2726id.rvClearFilter);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvClearFilter");
        recyclerView.setVisibility(0);
        View _$_findCachedViewById = this.this$0._$_findCachedViewById(C2723R.C2726id.borderBottomClearFilter);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "borderBottomClearFilter");
        _$_findCachedViewById.setVisibility(0);
        if (i2 != 0 || StringsKt.equals(this.this$0.getExpandableListTitle$app_productionRelease().get(i), this.this$0.getString(C2723R.string.bdt_lbl_year), true) || this.this$0.getExpandableListTitle$app_productionRelease().get(i).equals("yearfilter")) {
            List<FilterValues> list = this.this$0.getFilterExpandableList$app_productionRelease().get(this.this$0.getExpandableListTitle$app_productionRelease().get(i));
            if (list == null) {
                Intrinsics.throwNpe();
            }
            FilterValues filterValues = (FilterValues) list.get(i2);
            if (str.length() != 0) {
                z = false;
            }
            if (z) {
                str = filterValues.getValuesId();
                if (str == null) {
                    str = "";
                }
                str2 = filterValues.getDisplayText();
                if (str2 == null) {
                    str2 = "";
                }
            } else {
                str2 = "yearfilter";
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            if (str2 != null) {
                str3 = str2;
            } else {
                str3 = "";
            }
            SelectedRefinerV2 selectedRefinerV2 = new SelectedRefinerV2(str3, arrayList, false, 4, (DefaultConstructorMarker) null);
            if (!this.this$0.getExpandableListTitle$app_productionRelease().get(i).equals(this.this$0.getString(C2723R.string.bdt_lbl_year)) && !this.this$0.getExpandableListTitle$app_productionRelease().get(i).equals("yearfilter")) {
                String str4 = this.this$0.getExpandableListTitle$app_productionRelease().get(i);
                Intrinsics.checkExpressionValueIsNotNull(str4, "expandableListTitle[parentPosition]");
                this.this$0.getSelectedRefinerHashMap().put(str4, selectedRefinerV2);
            } else if (this.this$0.getSelectedRefinerHashMap().containsKey(this.this$0.getExpandableListTitle$app_productionRelease().get(i))) {
                String str5 = this.this$0.getExpandableListTitle$app_productionRelease().get(i);
                Intrinsics.checkExpressionValueIsNotNull(str5, "expandableListTitle[parentPosition]");
                this.this$0.getSelectedRefinerHashMap().put(str5, selectedRefinerV2);
            } else {
                this.this$0.getSelectedRefinerHashMap().put("yearfilter", selectedRefinerV2);
            }
            this.this$0.getSelectedRefinerList().add(selectedRefinerV2);
            if (!this.this$0.isHeaderVisible) {
                this.this$0.addHeaderView();
            }
            FilterFragment.access$getHeaderListAdapter$p(this.this$0).setHeaderListData(this.this$0.createSetFromHashMap());
            FilterFragment.access$getHeaderListAdapter$p(this.this$0).notifyDataSetChanged();
        } else {
            this.this$0.getSelectedRefinerHashMap().remove(this.this$0.getExpandableListTitle$app_productionRelease().get(i));
            if (this.this$0.createSetFromHashMap().size() > 0) {
                FilterFragment.access$getHeaderListAdapter$p(this.this$0).setHeaderListData(this.this$0.createSetFromHashMap());
                FilterFragment.access$getHeaderListAdapter$p(this.this$0).notifyDataSetChanged();
            } else {
                TextView textView = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tvClearFilter);
                Intrinsics.checkExpressionValueIsNotNull(textView, "tvClearFilter");
                textView.setVisibility(8);
                TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tvClearFilterFindVehicle);
                Intrinsics.checkExpressionValueIsNotNull(textView2, "tvClearFilterFindVehicle");
                textView2.setVisibility(8);
                RecyclerView recyclerView2 = (RecyclerView) this.this$0._$_findCachedViewById(C2723R.C2726id.rvClearFilter);
                Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvClearFilter");
                recyclerView2.setVisibility(8);
            }
        }
        this.this$0.updateSearchButtonCount();
    }
}
