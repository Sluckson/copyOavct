package com.iaai.android.bdt.feature.auctionSalesList;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.paging.PagedList;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.model.MyAccount.WatchListModel;
import com.iaai.android.bdt.model.auctionSalesList.ResultData;
import com.iaai.android.bdt.model.auctionmainlist.AuctionLocations;
import com.iaai.android.bdt.model.sort.SortOptionData;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.CustomItemClickListener;
import com.iaai.android.bdt.utils.NewDateHelper;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import com.lowagie.text.html.HtmlTags;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000I\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\"\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J0\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\u001d\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006!"}, mo66933d2 = {"com/iaai/android/bdt/feature/auctionSalesList/AuctionSalesListFragment$initializeRecycler$1", "Lcom/iaai/android/bdt/utils/CustomItemClickListener;", "createSortOptionData", "Lcom/iaai/android/bdt/model/sort/SortOptionData;", "displayText", "", "position", "", "isSelected", "", "onAuctionListItemClick", "", "v", "Landroid/view/View;", "data", "Lcom/iaai/android/bdt/model/auctionmainlist/AuctionLocations;", "onAuctionSaleItemClick", "Lcom/iaai/android/bdt/model/MyAccount/WatchListModel;", "Lcom/iaai/android/bdt/model/auctionSalesList/ResultData;", "onBidLiveItemClick", "onClickBidSalesList", "isBidLive", "onFilterItemClick", "onReceiptItemClick", "receiptNo", "isReceipt", "receiptSubjectLine", "salvageID", "onSortItemClick", "onUnWatchItemClick", "itemClick", "", "onWatchItemClick", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionSalesListFragment.kt */
public final class AuctionSalesListFragment$initializeRecycler$1 implements CustomItemClickListener {
    final /* synthetic */ AuctionSalesListFragment this$0;

    public void onAuctionListItemClick(@NotNull View view, @NotNull AuctionLocations auctionLocations) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        Intrinsics.checkParameterIsNotNull(auctionLocations, "data");
    }

    AuctionSalesListFragment$initializeRecycler$1(AuctionSalesListFragment auctionSalesListFragment) {
        this.this$0 = auctionSalesListFragment;
    }

    public void onAuctionSaleItemClick(@NotNull View view, @Nullable WatchListModel watchListModel, int i) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        throw new NotImplementedError("An operation is not implemented: " + "not implemented");
    }

    public void onClickBidSalesList(int i, boolean z) {
        if (z) {
            Log.e("FIRE_BASE_ANALYTICS", "Sending Event: " + IAAAnalytics.IAAEvents.BID_LIVE.getId());
            IAAAnalytics.INSTANCE.logIAAEvent(IAAAnalytics.IAAEvents.BID_LIVE, (Bundle) null);
        } else {
            Log.e("FIRE_BASE_ANALYTICS", "Sending Event: " + IAAAnalytics.IAAEvents.JOIN_AUCTION.getId());
            IAAAnalytics.INSTANCE.logIAAEvent(IAAAnalytics.IAAEvents.JOIN_AUCTION, (Bundle) null);
        }
        if (!this.this$0.getSessionManager().promptForLoginIfNeedFromFragment(AuctionSalesListFragment.access$getAuctionSalesListActivity$p(this.this$0), this.this$0, 29)) {
            this.this$0.launchIBidLive();
        }
    }

    public void onReceiptItemClick(int i, @NotNull String str, boolean z, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "receiptNo");
        Intrinsics.checkParameterIsNotNull(str2, "receiptSubjectLine");
        Intrinsics.checkParameterIsNotNull(str3, Constants_MVVM.EXTRA_SALVAGE_ID);
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public void onFilterItemClick(int i) {
        Intent intent = new Intent(this.this$0.getActivity(), FilterSalesListActivity.class);
        intent.putStringArrayListExtra(Constants_MVVM.EXTRA_LANE_LIST, this.this$0.scopeList);
        intent.putStringArrayListExtra(Constants_MVVM.EXTRA_LANE_COUNT, this.this$0.scopeListLaneCount);
        intent.putExtra("screen_name", IAAAnalytics.IAAScreenName.SALE_LIST_FILTER.getValue());
        this.this$0.startActivityForResult(intent, 1);
    }

    public void onSortItemClick(int i) {
        Intent intent = new Intent(this.this$0.getActivity(), SortListActivity.class);
        ArrayList arrayList = new ArrayList();
        AuctionSalesListFragment auctionSalesListFragment = this.this$0;
        auctionSalesListFragment.lastSelectedSort = IAASharedPreference.getSortItemPositionFilterPreferencesMVVM(AuctionSalesListFragment.access$getAuctionSalesListActivity$p(auctionSalesListFragment));
        String[] stringArray = this.this$0.getResources().getStringArray(C2723R.array.sort_item_list);
        Intrinsics.checkExpressionValueIsNotNull(stringArray, "resources.getStringArray(R.array.sort_item_list)");
        int length = stringArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            String str = stringArray[i2];
            if (i2 == this.this$0.lastSelectedSort) {
                Intrinsics.checkExpressionValueIsNotNull(str, HtmlTags.f607S);
                arrayList.add(createSortOptionData(str, i2, true));
            } else {
                Intrinsics.checkExpressionValueIsNotNull(str, HtmlTags.f607S);
                arrayList.add(createSortOptionData(str, i2, false));
            }
        }
        intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SORT_LIST, arrayList);
        intent.putExtra(Constants_MVVM.EXTRA_SORT_FROM, 1);
        intent.putExtra("screen_name", IAAAnalytics.IAAScreenName.SALE_LIST_SORT.getValue());
        this.this$0.startActivityForResult(intent, 2);
    }

    private final SortOptionData createSortOptionData(String str, int i, boolean z) {
        switch (i) {
            case 0:
                return new SortOptionData(str, "Item#", "0", z);
            case 1:
                return new SortOptionData(str, "Item#", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
            case 2:
                return new SortOptionData(str, "Lane", "0", z);
            case 3:
                return new SortOptionData(str, "Lane", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
            case 4:
                return new SortOptionData(str, ExifInterface.TAG_MAKE, "0", z);
            case 5:
                return new SortOptionData(str, ExifInterface.TAG_MAKE, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
            case 6:
                return new SortOptionData(str, "Odometer", "0", z);
            case 7:
                return new SortOptionData(str, "Odometer", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
            case 8:
                return new SortOptionData(str, "Year", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
            case 9:
                return new SortOptionData(str, "Year", "0", z);
            default:
                return new SortOptionData(str, "Year", "0", z);
        }
    }

    public void onWatchItemClick(@NotNull View view, long j, int i) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        this.this$0.indexToUpdate = i + 1;
        AuctionSalesListFragment auctionSalesListFragment = this.this$0;
        Application application = AuctionSalesListFragment.access$getAuctionSalesListActivity$p(auctionSalesListFragment).getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "auctionSalesListActivity.application");
        Boolean isLoggedInPreferencesMVVM = IAASharedPreference.getIsLoggedInPreferencesMVVM(application.getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(isLoggedInPreferencesMVVM, "IAASharedPreference.getI…ation.applicationContext)");
        auctionSalesListFragment.isLoggedIn = isLoggedInPreferencesMVVM.booleanValue();
        this.this$0.itemIdWatch = j;
        if (this.this$0.isLoggedIn) {
            this.this$0.addToWatchList(j);
        } else if (this.this$0.getResources().getBoolean(C2723R.bool.isTabletPhone)) {
            this.this$0.getSessionManager().promptForLoginIfNeededTabletBDT(this.this$0.getActivity(), this.this$0, 26);
        } else {
            this.this$0.getSessionManager().promptForLoginIfNeededBDT(this.this$0.getActivity(), 26);
        }
    }

    public void onUnWatchItemClick(@NotNull View view, long j, int i) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        this.this$0.indexToUpdate = i + 1;
        this.this$0.itemIdWatch = j;
        this.this$0.removeFromWatchList(j);
    }

    public void onBidLiveItemClick(@NotNull View view, @NotNull AuctionLocations auctionLocations) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        Intrinsics.checkParameterIsNotNull(auctionLocations, "data");
        throw new NotImplementedError("An operation is not implemented: " + "not implemented");
    }

    public void onAuctionSaleItemClick(@NotNull View view, @Nullable ResultData resultData, int i) {
        PagedList<ResultData> currentList;
        Intrinsics.checkParameterIsNotNull(view, "v");
        Long l = null;
        String valueOf = String.valueOf(resultData != null ? resultData.getItemId() : null);
        Bundle bundle = new Bundle();
        bundle.putString(Constants.EXTRA_ITEM_ID, valueOf);
        if (this.this$0.isTablet()) {
            if (resultData != null) {
                l = resultData.getItemId();
            }
            AuctionSalesListFragment.access$getAuctionSalesListAdapter$p(this.this$0).setSelectedItemForTablet(l);
            AuctionSalesListFragment.access$getAuctionSalesListAdapter$p(this.this$0).notifyDataSetChanged();
            Fragment findFragmentById = this.this$0.getChildFragmentManager().findFragmentById(C2723R.C2726id.auction_sales_nav_container);
            if (findFragmentById != null) {
                NavHostFragment navHostFragment = (NavHostFragment) findFragmentById;
                navHostFragment.getNavController().popBackStack();
                navHostFragment.getNavController().navigate((int) C2723R.C2726id.PDFragment, bundle);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
        }
        ArrayList arrayList = new ArrayList();
        AuctionSalesListAdapter access$getAuctionSalesListAdapter$p = AuctionSalesListFragment.access$getAuctionSalesListAdapter$p(this.this$0);
        if (!(access$getAuctionSalesListAdapter$p == null || (currentList = access$getAuctionSalesListAdapter$p.getCurrentList()) == null)) {
            for (ResultData itemId : currentList) {
                arrayList.add(String.valueOf(itemId.getItemId()));
            }
        }
        bundle.putStringArrayList(Constants_MVVM.EXTRA_ITEM_IDS_LIST, arrayList);
        bundle.putInt(Constants_MVVM.EXTRA_ITEM_POSITION, i);
        bundle.putString(Constants_MVVM.EXTRA_AUCTION_DATE, this.this$0.live_date);
        bundle.putString(Constants_MVVM.EXTRA_BRANCH_ID, this.this$0.branchId);
        bundle.putInt(Constants_MVVM.EXTRA_CURRENT_COUNT, this.this$0.currentCount);
        bundle.putInt(Constants_MVVM.EXTRA_TOTAL_COUNT, this.this$0.totalCount);
        bundle.putInt(Constants_MVVM.EXTRA_ITEM_POSITION, i);
        bundle.putString(Constants_MVVM.EXTRA_FAST_SEARCH_PARAM, "");
        NavController findNavController = Navigation.findNavController(AuctionSalesListFragment.access$getAuctionSalesListActivity$p(this.this$0), C2723R.C2726id.main_nav_host_fragment);
        Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…d.main_nav_host_fragment)");
        findNavController.navigate((int) C2723R.C2726id.action_ACFragment_to_View_Pager_PDFragment, bundle);
        if (this.this$0.totalCount > 1) {
            RelativeLayout relativeLayout = (RelativeLayout) AuctionSalesListFragment.access$getAuctionSalesListActivity$p(this.this$0)._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "auctionSalesListActivity.toolbar_relativelayout");
            relativeLayout.setGravity(GravityCompat.END);
            RelativeLayout relativeLayout2 = (RelativeLayout) AuctionSalesListFragment.access$getAuctionSalesListActivity$p(this.this$0)._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "auctionSalesListActivity.toolbar_relativelayout");
            relativeLayout2.setGravity(5);
            TextView toolbar_title = AuctionSalesListFragment.access$getAuctionSalesListActivity$p(this.this$0).getToolbar_title();
            toolbar_title.setText(String.valueOf(i + 1) + " of " + NewDateHelper.INSTANCE.formattedVehicleCount(this.this$0.totalCount));
            AuctionSalesListFragment.access$getAuctionSalesListActivity$p(this.this$0).getToolbar_title().setTextColor(this.this$0.getResources().getColor(C2723R.C2724color.bdt_gray_darker));
            AuctionSalesListFragment.access$getAuctionSalesListActivity$p(this.this$0).getToolbar_sub_title().setVisibility(8);
            return;
        }
        AuctionSalesListFragment.access$getAuctionSalesListActivity$p(this.this$0).getToolbar_title().setText(this.this$0.year_make_model);
        AuctionSalesListFragment.access$getAuctionSalesListActivity$p(this.this$0).getToolbar_sub_title().setVisibility(8);
    }
}
