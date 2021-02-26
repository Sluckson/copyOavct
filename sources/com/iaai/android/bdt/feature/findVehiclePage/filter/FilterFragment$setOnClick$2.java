package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.google.gson.Gson;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.utils.IAASharedPreference;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FilterFragment.kt */
final class FilterFragment$setOnClick$2 implements View.OnClickListener {
    final /* synthetic */ FilterFragment this$0;

    FilterFragment$setOnClick$2(FilterFragment filterFragment) {
        this.this$0 = filterFragment;
    }

    public final void onClick(View view) {
        this.this$0.splitMakeModelArrayAndUpdateMainRefinerList();
        Gson gson = new Gson();
        String json = gson.toJson((Object) this.this$0.getSelectedRefinerList());
        String json2 = gson.toJson((Object) this.this$0.getHashMapMakeModelArray());
        IAASharedPreference.setSelectedFilter(FilterFragment.access$getFilterActivity$p(this.this$0), json);
        IAASharedPreference.setSelectedMakeModelFilter(FilterFragment.access$getFilterActivity$p(this.this$0), json2);
        if (this.this$0.getHashMapMakeModelArray().size() > 0) {
            Bundle bundle = new Bundle();
            bundle.putString(IAAAnalytics.FireBaseKeyNames.COUNT.getId(), String.valueOf(this.this$0.getHashMapMakeModelArray().size()));
            Log.e("FIRE_BASE_ANALYTICS", "Sending Event: " + IAAAnalytics.IAAEvents.MAKE_AND_MODEL_FILTER_USAGE.getId() + " :" + bundle);
            IAAAnalytics.INSTANCE.logIAAEvent(IAAAnalytics.IAAEvents.MAKE_AND_MODEL_FILTER_USAGE, bundle);
        }
        if (this.this$0.isFromFilterPage) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(IAAAnalytics.FireBaseKeyNames.COUNT.getId(), String.valueOf(this.this$0.getSelectedRefinerHashMap().size()));
            Log.e("FIRE_BASE_ANALYTICS", "Sending Event: " + IAAAnalytics.IAAEvents.SEARCH_RESULT_FILTER_USAGE.getId() + " :" + bundle2);
            IAAAnalytics.INSTANCE.logIAAEvent(IAAAnalytics.IAAEvents.SEARCH_RESULT_FILTER_USAGE, bundle2);
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_FILTER_DATA, this.this$0.getSelectedRefinerList());
            intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_MAKE_MODEL_DATA, this.this$0.getHashMapMakeModelArray());
            intent.putExtra(Constants_MVVM.EXTRA_MAKE_MODEL_GROUP_POSITION, this.this$0.getMakeModelGroupPosition());
            intent.putExtra(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY, this.this$0.keywordSearch);
            intent.putExtra(Constants_MVVM.EXTRA_IS_FROM_FIND_VEHICLE_PAGE, this.this$0.isFromFindVehiclePage);
            intent.putExtra(Constants_MVVM.EXTRA_THIS_WEEK, this.this$0.thisWeek);
            intent.putExtra(Constants_MVVM.EXTRA_NEXT_WEEK, this.this$0.nextWeek);
            FilterFragment.access$getFilterActivity$p(this.this$0).setResult(101, intent);
            FilterFragment.access$getFilterActivity$p(this.this$0).finish();
            return;
        }
        Bundle bundle3 = new Bundle();
        bundle3.putString(IAAAnalytics.FireBaseKeyNames.COUNT.getId(), String.valueOf(this.this$0.getSelectedRefinerHashMap().size()));
        Log.e("FIRE_BASE_ANALYTICS", "Sending Event: " + IAAAnalytics.IAAEvents.FIND_VEHICLE_FILTER_USAGE.getId() + " :" + bundle3);
        IAAAnalytics.INSTANCE.logIAAEvent(IAAAnalytics.IAAEvents.FIND_VEHICLE_FILTER_USAGE, bundle3);
        Intent intent2 = new Intent(this.this$0.getContext(), SearchResultActivity.class);
        intent2.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_FILTER_DATA, this.this$0.getSelectedRefinerList());
        intent2.putExtra(Constants_MVVM.EXTRA_IS_FROM_FIND_VEHICLE_PAGE, this.this$0.isFromFindVehiclePage);
        intent2.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_MAKE_MODEL_DATA, this.this$0.getHashMapMakeModelArray());
        intent2.putExtra(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY, this.this$0.keywordSearch);
        intent2.putExtra(Constants_MVVM.EXTRA_MAKE_MODEL_GROUP_POSITION, this.this$0.getMakeModelGroupPosition());
        intent2.putExtra(Constants_MVVM.EXTRA_THIS_WEEK, this.this$0.thisWeek);
        intent2.putExtra(Constants_MVVM.EXTRA_NEXT_WEEK, this.this$0.nextWeek);
        this.this$0.startActivity(intent2);
    }
}
