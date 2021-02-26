package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.content.Intent;
import android.widget.ExpandableListView;
import com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2;
import com.iaai.android.bdt.model.filter.FilterValues;
import com.iaai.android.bdt.utils.Constants_MVVM;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo66933d2 = {"<anonymous>", "", "groupPosition", "", "onGroupCollapse"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FilterFragment.kt */
final class FilterFragment$initFilterList$2 implements ExpandableListView.OnGroupCollapseListener {
    final /* synthetic */ FilterFragment this$0;

    FilterFragment$initFilterList$2(FilterFragment filterFragment) {
        this.this$0 = filterFragment;
    }

    public final void onGroupCollapse(int i) {
        this.this$0.setGroupPosition(i);
        List<FilterValues> filterValues = this.this$0.getFilterDataList().get(i).getFilterValues();
        if (filterValues == null) {
            Intrinsics.throwNpe();
        }
        if (filterValues.size() > 10) {
            String str = "";
            if (StringsKt.equals(this.this$0.getFilterDataList().get(i).getFilterId(), "make", true) || StringsKt.equals(this.this$0.getFilterDataList().get(i).getFilterId(), "model", true)) {
                Intent intent = new Intent(FilterFragment.access$getFilterActivity$p(this.this$0), MakeModelFilterActivity.class);
                intent.putExtra(Constants_MVVM.EXTRA_MAKE_MODEL_FILTER_DATA, FilterFragment.access$getFilterDataMakeModel$p(this.this$0));
                intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_RECENTALY_USED_MAKE_MODEL_FILTER_DATA, this.this$0.recentlyUsedModels);
                FilterFragment filterFragment = this.this$0;
                String displayText = filterFragment.getFilterDataList().get(i).getDisplayText();
                if (displayText != null) {
                    str = displayText;
                }
                intent.putExtra(Constants_MVVM.EXTRA_DISPLAY_FILTER_TITLE, filterFragment.getDisplayName(str));
                intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_LAST_SELECTED_MAKE_MODEL, this.this$0.lastSelectedMakeModel);
                this.this$0.startActivityForResult(intent, 102);
                this.this$0.setMakeModelGroupPosition(i);
                return;
            }
            Intent intent2 = new Intent(FilterFragment.access$getFilterActivity$p(this.this$0), SubFilterActivity.class);
            intent2.putExtra(Constants_MVVM.EXTRA_SUB_FILTER_DATA, this.this$0.getFilterDataList().get(i));
            intent2.putExtra(Constants_MVVM.EXTRA_FILTER_TITLE, this.this$0.getFilterDataList().get(i).getDisplayText());
            FilterFragment filterFragment2 = this.this$0;
            String displayText2 = filterFragment2.getFilterDataList().get(i).getDisplayText();
            if (displayText2 != null) {
                str = displayText2;
            }
            intent2.putExtra(Constants_MVVM.EXTRA_DISPLAY_FILTER_TITLE, filterFragment2.getDisplayName(str));
            Map selectedRefinerHashMap = this.this$0.getSelectedRefinerHashMap();
            String displayText3 = this.this$0.getFilterDataList().get(i).getDisplayText();
            if (selectedRefinerHashMap != null) {
                if (selectedRefinerHashMap.containsKey(displayText3)) {
                    Object obj = this.this$0.getSelectedRefinerHashMap().get(this.this$0.getFilterDataList().get(i).getDisplayText());
                    if (obj != null) {
                        intent2.putExtra(Constants_MVVM.EXTRA_SELECTED_FILTER_VALUE, ((SelectedRefinerV2) obj).getRefinerValue().get(0));
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2");
                    }
                }
                this.this$0.startActivityForResult(intent2, 101);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        } else if (StringsKt.equals(this.this$0.getFilterDataList().get(i).getFilterId(), "make", true) || StringsKt.equals(this.this$0.getFilterDataList().get(i).getFilterId(), "Make & Model", true)) {
            Intent intent3 = new Intent(FilterFragment.access$getFilterActivity$p(this.this$0), MakeModelFilterActivity.class);
            intent3.putExtra(Constants_MVVM.EXTRA_MAKE_MODEL_FILTER_DATA, FilterFragment.access$getFilterDataMakeModel$p(this.this$0));
            intent3.putParcelableArrayListExtra(Constants_MVVM.EXTRA_RECENTALY_USED_MAKE_MODEL_FILTER_DATA, this.this$0.recentlyUsedModels);
            intent3.putParcelableArrayListExtra(Constants_MVVM.EXTRA_LAST_SELECTED_MAKE_MODEL, this.this$0.lastSelectedMakeModel);
            this.this$0.startActivityForResult(intent3, 102);
            this.this$0.setMakeModelGroupPosition(i);
        }
    }
}
