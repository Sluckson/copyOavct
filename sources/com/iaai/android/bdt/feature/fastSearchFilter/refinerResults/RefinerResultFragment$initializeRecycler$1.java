package com.iaai.android.bdt.feature.fastSearchFilter.refinerResults;

import android.app.Application;
import android.content.Intent;
import android.view.View;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.feature.auctionSalesList.SortListActivity;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterActivity;
import com.iaai.android.bdt.model.fastSearchFilter2.FormattedResult;
import com.iaai.android.bdt.model.sort.SortOptionData;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.utils.IAASharedPreference;
import com.lowagie.text.html.HtmlTags;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, mo66933d2 = {"com/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultFragment$initializeRecycler$1", "Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultListener;", "onFilterItemClick", "", "position", "", "onRefinerResultItemClick", "v", "Landroid/view/View;", "data", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FormattedResult;", "onSortItemClick", "onUnWatchItemClick", "itemClick", "onWatchItemClick", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: RefinerResultFragment.kt */
public final class RefinerResultFragment$initializeRecycler$1 implements RefinerResultListener {
    final /* synthetic */ RefinerResultFragment this$0;

    RefinerResultFragment$initializeRecycler$1(RefinerResultFragment refinerResultFragment) {
        this.this$0 = refinerResultFragment;
    }

    public void onUnWatchItemClick(@NotNull View view, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        this.this$0.indexToUpdate = i2 + 1;
        this.this$0.itemIdWatch = i;
        RefinerResultFragment refinerResultFragment = this.this$0;
        String string = refinerResultFragment.getResources().getString(C2723R.string.lbl_watch_action_delete);
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.st….lbl_watch_action_delete)");
        refinerResultFragment.action = string;
        this.this$0.updateWatchStatus();
    }

    public void onWatchItemClick(@NotNull View view, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        this.this$0.indexToUpdate = i2 + 1;
        RefinerResultFragment refinerResultFragment = this.this$0;
        Application application = RefinerResultFragment.access$getRefinerResultActivity$p(refinerResultFragment).getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "refinerResultActivity.application");
        Boolean isLoggedInPreferencesMVVM = IAASharedPreference.getIsLoggedInPreferencesMVVM(application.getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(isLoggedInPreferencesMVVM, "IAASharedPreference.getI…ation.applicationContext)");
        refinerResultFragment.isLoggedIn = isLoggedInPreferencesMVVM.booleanValue();
        this.this$0.itemIdWatch = i;
        RefinerResultFragment refinerResultFragment2 = this.this$0;
        String string = refinerResultFragment2.getResources().getString(C2723R.string.lbl_watch_action_add);
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.string.lbl_watch_action_add)");
        refinerResultFragment2.action = string;
        if (this.this$0.isLoggedIn) {
            this.this$0.updateWatchStatus();
        } else if (this.this$0.getResources().getBoolean(C2723R.bool.isTabletPhone)) {
            this.this$0.getSessionManager().promptForLoginIfNeededTabletBDT(this.this$0.getActivity(), this.this$0, 26);
        } else {
            this.this$0.getSessionManager().promptForLoginIfNeededBDT(this.this$0.getActivity(), 26);
        }
    }

    public void onRefinerResultItemClick(@NotNull View view, @Nullable FormattedResult formattedResult, int i) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        this.this$0.navigateToProductDetailsPage(formattedResult, i);
    }

    public void onFilterItemClick(int i) {
        IaaiApplication.isBackPressedFromRefinerResult = true;
        Intent intent = new Intent(this.this$0.getActivity(), FastSearchFilterActivity.class);
        intent.putExtra(Constants_MVVM.EXTRA_IS_FILTERPAGE, true);
        intent.putExtra(Constants_MVVM.EXTRA_IS_FROM_LANDING_PAGE_SEARCH, this.this$0.isFromLandingPageSearch);
        if (this.this$0.isFromLandingPageSearch) {
            this.this$0.startActivityForResult(intent, 100);
        } else {
            this.this$0.startActivity(intent);
        }
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
        String[] stringArray = this.this$0.getResources().getStringArray(C2723R.array.new_search_sort_item_list);
        Intrinsics.checkExpressionValueIsNotNull(stringArray, "resources.getStringArray…ew_search_sort_item_list)");
        int length = stringArray.length;
        int i2 = 0;
        while (i2 < length) {
            String str = stringArray[i2];
            int i3 = i2 + 1;
            if (i3 == this.this$0.lastSelectedSort) {
                RefinerResultFragment refinerResultFragment = this.this$0;
                Intrinsics.checkExpressionValueIsNotNull(str, HtmlTags.f607S);
                arrayList.add(refinerResultFragment.createSortOptionData(str, i2, true));
            } else {
                RefinerResultFragment refinerResultFragment2 = this.this$0;
                Intrinsics.checkExpressionValueIsNotNull(str, HtmlTags.f607S);
                arrayList.add(refinerResultFragment2.createSortOptionData(str, i2, false));
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
