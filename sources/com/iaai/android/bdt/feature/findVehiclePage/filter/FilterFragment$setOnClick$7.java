package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.content.Intent;
import android.view.View;
import com.iaai.android.bdt.feature.findVehiclePage.SearchPanelFindVehicleActivity;
import com.iaai.android.bdt.utils.Constants_MVVM;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FilterFragment.kt */
final class FilterFragment$setOnClick$7 implements View.OnClickListener {
    final /* synthetic */ FilterFragment this$0;

    FilterFragment$setOnClick$7(FilterFragment filterFragment) {
        this.this$0 = filterFragment;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.this$0.getActivity(), SearchPanelFindVehicleActivity.class);
        intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_FILTER_DATA, this.this$0.getSelectedRefinerList());
        intent.putExtra(Constants_MVVM.EXTRA_MAKE_MODEL_GROUP_POSITION, this.this$0.getMakeModelGroupPosition());
        intent.putExtra(Constants_MVVM.EXTRA_SEARCH_BY_VEHICLE, true);
        intent.putExtra(Constants_MVVM.EXTRA_IS_FILTERPAGE, true);
        intent.putExtra(Constants_MVVM.EXTRA_IS_FROM_FIND_VEHICLE_PAGE, this.this$0.isFromFindVehiclePage);
        intent.putExtra(Constants_MVVM.EXTRA_THIS_WEEK, this.this$0.thisWeek);
        intent.putExtra(Constants_MVVM.EXTRA_NEXT_WEEK, this.this$0.nextWeek);
        intent.putExtra(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY, this.this$0.keywordSearch);
        this.this$0.startActivityForResult(intent, 104);
    }
}
