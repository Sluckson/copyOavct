package com.iaai.android.bdt.feature.findVehiclePage.searchResult;

import android.app.Application;
import android.content.Intent;
import android.view.View;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.feature.auctionSalesList.SortListActivity;
import com.iaai.android.bdt.feature.findVehiclePage.filter.FilterActivity;
import com.iaai.android.bdt.model.fastSearch.Vehicle;
import com.iaai.android.bdt.model.sort.SortOptionData;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.utils.IAASharedPreference;
import com.lowagie.text.html.HtmlTags;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, mo66933d2 = {"com/iaai/android/bdt/feature/findVehiclePage/searchResult/SearchResultListFragment$initializeRecycler$4", "Lcom/iaai/android/bdt/feature/findVehiclePage/searchResult/SearchResultListner;", "onFilterItemClick", "", "position", "", "onSearchresultItemClick", "v", "Landroid/view/View;", "data", "Lcom/iaai/android/bdt/model/fastSearch/Vehicle;", "onSortItemClick", "onUnWatchItemClick", "itemClick", "onWatchItemClick", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SearchResultListFragment.kt */
public final class SearchResultListFragment$initializeRecycler$4 implements SearchResultListner {
    final /* synthetic */ SearchResultListFragment this$0;

    SearchResultListFragment$initializeRecycler$4(SearchResultListFragment searchResultListFragment) {
        this.this$0 = searchResultListFragment;
    }

    public void onUnWatchItemClick(@NotNull View view, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        this.this$0.indexToUpdate = i2 + 1;
        this.this$0.itemIdWatch = i;
        this.this$0.removeFromWatchList(i);
    }

    public void onWatchItemClick(@NotNull View view, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        this.this$0.indexToUpdate = i2 + 1;
        SearchResultListFragment searchResultListFragment = this.this$0;
        Application application = SearchResultListFragment.access$getSearchResultActivity$p(searchResultListFragment).getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "searchResultActivity.application");
        Boolean isLoggedInPreferencesMVVM = IAASharedPreference.getIsLoggedInPreferencesMVVM(application.getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(isLoggedInPreferencesMVVM, "IAASharedPreference.getI…ation.applicationContext)");
        searchResultListFragment.isLoggedIn = isLoggedInPreferencesMVVM.booleanValue();
        this.this$0.itemIdWatch = i;
        if (this.this$0.isLoggedIn) {
            this.this$0.addToWatchList(i);
        } else if (this.this$0.getResources().getBoolean(C2723R.bool.isTabletPhone)) {
            this.this$0.getSessionManager().promptForLoginIfNeededTabletBDT(this.this$0.getActivity(), this.this$0, 26);
        } else {
            this.this$0.getSessionManager().promptForLoginIfNeededBDT(this.this$0.getActivity(), 26);
        }
    }

    public void onSearchresultItemClick(@NotNull View view, @Nullable Vehicle vehicle, int i) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        this.this$0.navigateToProductDetailsPage(vehicle, i);
    }

    public void onFilterItemClick(int i) {
        Intent intent = new Intent(this.this$0.getActivity(), FilterActivity.class);
        intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_FILTER_DATA, this.this$0.getSelectedRefinerList());
        intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_MAKE_MODEL_DATA, this.this$0.getHashMapMakeModelArray());
        intent.putExtra(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY, this.this$0.searchInputKey);
        intent.putExtra(Constants_MVVM.EXTRA_MAKE_MODEL_GROUP_POSITION, this.this$0.groupPostion);
        intent.putExtra("screen_name", IAAAnalytics.IAAScreenName.SEARCH_RESULT_LIST_FILTER.getValue());
        this.this$0.startActivityForResult(intent, 101);
    }

    public void onSortItemClick(int i) {
        Intent intent = new Intent(this.this$0.getActivity(), SortListActivity.class);
        ArrayList arrayList = new ArrayList();
        if (this.this$0.lastSelectedSort != 0 || this.this$0.sortOptionData == null) {
            arrayList.add(new SortOptionData("", "", "", false));
        } else {
            SortOptionData access$getSortOptionData$p = this.this$0.sortOptionData;
            if (access$getSortOptionData$p == null) {
                Intrinsics.throwNpe();
            }
            arrayList.add(access$getSortOptionData$p);
        }
        String[] stringArray = this.this$0.getResources().getStringArray(C2723R.array.search_sort_item_list);
        Intrinsics.checkExpressionValueIsNotNull(stringArray, "resources.getStringArray…ay.search_sort_item_list)");
        int length = stringArray.length;
        int i2 = 0;
        while (i2 < length) {
            String str = stringArray[i2];
            int i3 = i2 + 1;
            if (i3 == this.this$0.lastSelectedSort) {
                SearchResultListFragment searchResultListFragment = this.this$0;
                Intrinsics.checkExpressionValueIsNotNull(str, HtmlTags.f607S);
                arrayList.add(searchResultListFragment.createSortOptionData(str, i2, true));
            } else {
                SearchResultListFragment searchResultListFragment2 = this.this$0;
                Intrinsics.checkExpressionValueIsNotNull(str, HtmlTags.f607S);
                arrayList.add(searchResultListFragment2.createSortOptionData(str, i2, false));
            }
            i2 = i3;
        }
        intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SORT_LIST, arrayList);
        intent.putExtra(Constants_MVVM.EXTRA_SORT_LIST_POSTION, this.this$0.lastSelectedSort);
        intent.putExtra(Constants_MVVM.EXTRA_SORT_FROM, 2);
        intent.putExtra("screen_name", IAAAnalytics.IAAScreenName.SEARCH_RESULT_LIST_SORT.getValue());
        this.this$0.startActivityForResult(intent, 105);
    }
}
