package com.iaai.android.bdt.feature.account.watchlist;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.paging.PagedList;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.feature.auctionSalesList.SortListActivity;
import com.iaai.android.bdt.model.MyAccount.WatchListModel;
import com.iaai.android.bdt.model.auctionSalesList.ResultData;
import com.iaai.android.bdt.model.auctionmainlist.AuctionLocations;
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

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000G\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J0\u0010\u0012\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u001d"}, mo66933d2 = {"com/iaai/android/bdt/feature/account/watchlist/PreSaleListFragment$initializeRecycler$1", "Lcom/iaai/android/bdt/utils/CustomItemClickListener;", "onAuctionListItemClick", "", "v", "Landroid/view/View;", "data", "Lcom/iaai/android/bdt/model/auctionmainlist/AuctionLocations;", "onAuctionSaleItemClick", "Lcom/iaai/android/bdt/model/MyAccount/WatchListModel;", "position", "", "Lcom/iaai/android/bdt/model/auctionSalesList/ResultData;", "onBidLiveItemClick", "onClickBidSalesList", "isBidLive", "", "onFilterItemClick", "onReceiptItemClick", "receiptNo", "", "isReceipt", "receiptSubjectLine", "salvageID", "onSortItemClick", "onUnWatchItemClick", "itemClick", "", "onWatchItemClick", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PreSaleListFragment.kt */
public final class PreSaleListFragment$initializeRecycler$1 implements CustomItemClickListener {
    final /* synthetic */ PreSaleListFragment this$0;

    public void onAuctionListItemClick(@NotNull View view, @NotNull AuctionLocations auctionLocations) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        Intrinsics.checkParameterIsNotNull(auctionLocations, "data");
    }

    public void onClickBidSalesList(int i, boolean z) {
    }

    public void onFilterItemClick(int i) {
    }

    PreSaleListFragment$initializeRecycler$1(PreSaleListFragment preSaleListFragment) {
        this.this$0 = preSaleListFragment;
    }

    public void onReceiptItemClick(int i, @NotNull String str, boolean z, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "receiptNo");
        Intrinsics.checkParameterIsNotNull(str2, "receiptSubjectLine");
        Intrinsics.checkParameterIsNotNull(str3, Constants_MVVM.EXTRA_SALVAGE_ID);
        this.this$0.checkWriteStoragePermission(str, z, str2, str3);
    }

    public void onSortItemClick(int i) {
        Intent intent = new Intent(this.this$0.getActivity(), SortListActivity.class);
        ArrayList arrayList = new ArrayList();
        int parseInt = Integer.parseInt(this.this$0.myAccountStatus);
        if (parseInt == PreSaleListStatus.WATCHING_LIST.getValue()) {
            String[] stringArray = this.this$0.getResources().getStringArray(C2723R.array.sort_item_watch_list);
            Intrinsics.checkExpressionValueIsNotNull(stringArray, "resources.getStringArray…ray.sort_item_watch_list)");
            int length = stringArray.length;
            for (int i2 = 0; i2 < length; i2++) {
                String str = stringArray[i2];
                if (i2 == this.this$0.lastSelectedSort) {
                    PreSaleListFragment preSaleListFragment = this.this$0;
                    Intrinsics.checkExpressionValueIsNotNull(str, HtmlTags.f607S);
                    arrayList.add(preSaleListFragment.createSortOptionData(str, i2, true));
                } else {
                    PreSaleListFragment preSaleListFragment2 = this.this$0;
                    Intrinsics.checkExpressionValueIsNotNull(str, HtmlTags.f607S);
                    arrayList.add(preSaleListFragment2.createSortOptionData(str, i2, false));
                }
            }
        } else if (parseInt == PreSaleListStatus.PRE_BID.getValue()) {
            String[] stringArray2 = this.this$0.getResources().getStringArray(C2723R.array.sort_item_watch_list);
            Intrinsics.checkExpressionValueIsNotNull(stringArray2, "resources.getStringArray…ray.sort_item_watch_list)");
            int length2 = stringArray2.length;
            for (int i3 = 0; i3 < length2; i3++) {
                String str2 = stringArray2[i3];
                if (i3 == this.this$0.lastSelectedSort) {
                    PreSaleListFragment preSaleListFragment3 = this.this$0;
                    Intrinsics.checkExpressionValueIsNotNull(str2, HtmlTags.f607S);
                    arrayList.add(preSaleListFragment3.createSortOptionData(str2, i3, true));
                } else {
                    PreSaleListFragment preSaleListFragment4 = this.this$0;
                    Intrinsics.checkExpressionValueIsNotNull(str2, HtmlTags.f607S);
                    arrayList.add(preSaleListFragment4.createSortOptionData(str2, i3, false));
                }
            }
        } else if (parseInt == PreSaleListStatus.AWARD_PENDING.getValue()) {
            String[] stringArray3 = this.this$0.getResources().getStringArray(C2723R.array.sort_item_Award_list);
            Intrinsics.checkExpressionValueIsNotNull(stringArray3, "resources.getStringArray…ray.sort_item_Award_list)");
            int length3 = stringArray3.length;
            for (int i4 = 0; i4 < length3; i4++) {
                String str3 = stringArray3[i4];
                if (i4 == this.this$0.lastSelectedSort) {
                    PreSaleListFragment preSaleListFragment5 = this.this$0;
                    Intrinsics.checkExpressionValueIsNotNull(str3, HtmlTags.f607S);
                    arrayList.add(preSaleListFragment5.createSortOptionAwardData(str3, i4, true));
                } else {
                    PreSaleListFragment preSaleListFragment6 = this.this$0;
                    Intrinsics.checkExpressionValueIsNotNull(str3, HtmlTags.f607S);
                    arrayList.add(preSaleListFragment6.createSortOptionAwardData(str3, i4, false));
                }
            }
        } else if (parseInt == PreSaleListStatus.LOST_PREBID.getValue()) {
            String[] stringArray4 = this.this$0.getResources().getStringArray(C2723R.array.sort_item_lost_pre_bid_list);
            Intrinsics.checkExpressionValueIsNotNull(stringArray4, "resources.getStringArray…t_item_lost_pre_bid_list)");
            int length4 = stringArray4.length;
            for (int i5 = 0; i5 < length4; i5++) {
                String str4 = stringArray4[i5];
                if (i5 == this.this$0.lastSelectedSort) {
                    PreSaleListFragment preSaleListFragment7 = this.this$0;
                    Intrinsics.checkExpressionValueIsNotNull(str4, HtmlTags.f607S);
                    arrayList.add(preSaleListFragment7.createSortOptionLostPreBidData(str4, i5, true));
                } else {
                    PreSaleListFragment preSaleListFragment8 = this.this$0;
                    Intrinsics.checkExpressionValueIsNotNull(str4, HtmlTags.f607S);
                    arrayList.add(preSaleListFragment8.createSortOptionLostPreBidData(str4, i5, false));
                }
            }
        } else if (parseInt == PreSaleListStatus.PURCHASE_HISTORY.getValue()) {
            String[] stringArray5 = this.this$0.getResources().getStringArray(C2723R.array.sort_item_purchase_history_list);
            Intrinsics.checkExpressionValueIsNotNull(stringArray5, "resources.getStringArray…em_purchase_history_list)");
            int length5 = stringArray5.length;
            for (int i6 = 0; i6 < length5; i6++) {
                String str5 = stringArray5[i6];
                if (i6 == this.this$0.lastSelectedPurchaseSort) {
                    PreSaleListFragment preSaleListFragment9 = this.this$0;
                    Intrinsics.checkExpressionValueIsNotNull(str5, HtmlTags.f607S);
                    arrayList.add(preSaleListFragment9.createSortOptionPurchaseHistoryData(str5, i6, true));
                } else {
                    PreSaleListFragment preSaleListFragment10 = this.this$0;
                    Intrinsics.checkExpressionValueIsNotNull(str5, HtmlTags.f607S);
                    arrayList.add(preSaleListFragment10.createSortOptionPurchaseHistoryData(str5, i6, false));
                }
            }
        }
        intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SORT_LIST, arrayList);
        intent.putExtra(Constants_MVVM.EXTRA_SORT_FROM, 3);
        intent.putExtra("screen_name", IAAAnalytics.IAAScreenName.WATCH_LIST_SORT.getValue());
        this.this$0.startActivityForResult(intent, 2);
    }

    public void onWatchItemClick(@NotNull View view, long j, int i) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        this.this$0.indexToUpdate = i + 1;
        PreSaleListFragment preSaleListFragment = this.this$0;
        Application application = PreSaleListFragment.access$getPreSaleListActivity$p(preSaleListFragment).getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "preSaleListActivity.application");
        Boolean isLoggedInPreferencesMVVM = IAASharedPreference.getIsLoggedInPreferencesMVVM(application.getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(isLoggedInPreferencesMVVM, "IAASharedPreference.getI…ation.applicationContext)");
        preSaleListFragment.isLoggedIn = isLoggedInPreferencesMVVM.booleanValue();
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
        Intrinsics.checkParameterIsNotNull(view, "v");
        throw new NotImplementedError("An operation is not implemented: " + "not implemented");
    }

    public void onAuctionSaleItemClick(@NotNull View view, @Nullable WatchListModel watchListModel, int i) {
        PagedList<WatchListModel> currentList;
        String itemid;
        Intrinsics.checkParameterIsNotNull(view, "v");
        Long l = null;
        String valueOf = String.valueOf(watchListModel != null ? watchListModel.getItemid() : null);
        Bundle bundle = new Bundle();
        bundle.putString(Constants.EXTRA_ITEM_ID, valueOf);
        if (this.this$0.isTablet()) {
            if (!(watchListModel == null || (itemid = watchListModel.getItemid()) == null)) {
                l = Long.valueOf(Long.parseLong(itemid));
            }
            PreSaleListFragment.access$getPreSaleAdapter$p(this.this$0).setSelectedItemForTablet(l);
            PreSaleListFragment.access$getPreSaleAdapter$p(this.this$0).notifyDataSetChanged();
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
        PreSaleListAdapter access$getPreSaleAdapter$p = PreSaleListFragment.access$getPreSaleAdapter$p(this.this$0);
        if (!(access$getPreSaleAdapter$p == null || (currentList = access$getPreSaleAdapter$p.getCurrentList()) == null)) {
            for (WatchListModel itemid2 : currentList) {
                arrayList.add(String.valueOf(itemid2.getItemid()));
            }
        }
        bundle.putStringArrayList(Constants_MVVM.EXTRA_ITEM_IDS_LIST, arrayList);
        bundle.putInt(Constants_MVVM.EXTRA_ITEM_POSITION, i);
        bundle.putString(Constants_MVVM.EXTRA_AUCTION_DATE, "");
        bundle.putString(Constants_MVVM.EXTRA_BRANCH_ID, "");
        bundle.putInt(Constants_MVVM.EXTRA_CURRENT_COUNT, this.this$0.currentCount);
        bundle.putInt(Constants_MVVM.EXTRA_TOTAL_COUNT, this.this$0.totalCount);
        bundle.putInt(Constants_MVVM.EXTRA_ITEM_POSITION, i);
        bundle.putString(Constants_MVVM.EXTRA_FAST_SEARCH_PARAM, "");
        NavController findNavController = Navigation.findNavController(PreSaleListFragment.access$getPreSaleListActivity$p(this.this$0), C2723R.C2726id.watch_main_nav_host_fragment);
        Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…h_main_nav_host_fragment)");
        findNavController.navigate((int) C2723R.C2726id.action_ACFragment_to_View_Pager_PDFragment, bundle);
        if (this.this$0.totalCount > 1) {
            RelativeLayout relativeLayout = (RelativeLayout) PreSaleListFragment.access$getPreSaleListActivity$p(this.this$0)._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "preSaleListActivity.toolbar_relativelayout");
            relativeLayout.setGravity(GravityCompat.END);
            RelativeLayout relativeLayout2 = (RelativeLayout) PreSaleListFragment.access$getPreSaleListActivity$p(this.this$0)._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "preSaleListActivity.toolbar_relativelayout");
            relativeLayout2.setGravity(5);
            TextView toolbar_title = PreSaleListFragment.access$getPreSaleListActivity$p(this.this$0).getToolbar_title();
            toolbar_title.setText(String.valueOf(i + 1) + " of " + NewDateHelper.INSTANCE.formattedVehicleCount(this.this$0.totalCount));
            PreSaleListFragment.access$getPreSaleListActivity$p(this.this$0).getToolbar_title().setTextColor(this.this$0.getResources().getColor(C2723R.C2724color.bdt_gray_darker));
            PreSaleListFragment.access$getPreSaleListActivity$p(this.this$0).getToolbar_sub_title().setVisibility(8);
            return;
        }
        PreSaleListFragment.access$getPreSaleListActivity$p(this.this$0).getToolbar_title().setText(this.this$0.year_make_model);
        PreSaleListFragment.access$getPreSaleListActivity$p(this.this$0).getToolbar_sub_title().setVisibility(8);
    }
}
