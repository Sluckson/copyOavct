package com.iaai.android.bdt.feature.account.buyNowOfferList;

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
import com.iaai.android.bdt.model.MyAccount.BuyNowOfferListModel;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.NewDateHelper;
import com.iaai.android.old.utils.constants.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, mo66933d2 = {"com/iaai/android/bdt/feature/account/buyNowOfferList/BuyNowOfferListFragment$initializeRecycler$1", "Lcom/iaai/android/bdt/feature/account/buyNowOfferList/BuyNowItemClickListener;", "onBuyNowItemClick", "", "v", "Landroid/view/View;", "data", "Lcom/iaai/android/bdt/model/MyAccount/BuyNowOfferListModel;", "position", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BuyNowOfferListFragment.kt */
public final class BuyNowOfferListFragment$initializeRecycler$1 implements BuyNowItemClickListener {
    final /* synthetic */ BuyNowOfferListFragment this$0;

    BuyNowOfferListFragment$initializeRecycler$1(BuyNowOfferListFragment buyNowOfferListFragment) {
        this.this$0 = buyNowOfferListFragment;
    }

    public void onBuyNowItemClick(@NotNull View view, @Nullable BuyNowOfferListModel buyNowOfferListModel, int i) {
        PagedList<BuyNowOfferListModel> currentList;
        String itemId;
        Intrinsics.checkParameterIsNotNull(view, "v");
        Long l = null;
        String valueOf = String.valueOf(buyNowOfferListModel != null ? buyNowOfferListModel.getItemId() : null);
        Bundle bundle = new Bundle();
        bundle.putString(Constants.EXTRA_ITEM_ID, valueOf);
        if (this.this$0.isTablet()) {
            if (!(buyNowOfferListModel == null || (itemId = buyNowOfferListModel.getItemId()) == null)) {
                l = Long.valueOf(Long.parseLong(itemId));
            }
            BuyNowOfferListFragment.access$getBuyNowOfferListAdapter$p(this.this$0).setSelectedItemForTablet(l);
            BuyNowOfferListFragment.access$getBuyNowOfferListAdapter$p(this.this$0).notifyDataSetChanged();
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
        BuyNowOfferListAdapter access$getBuyNowOfferListAdapter$p = BuyNowOfferListFragment.access$getBuyNowOfferListAdapter$p(this.this$0);
        if (!(access$getBuyNowOfferListAdapter$p == null || (currentList = access$getBuyNowOfferListAdapter$p.getCurrentList()) == null)) {
            for (BuyNowOfferListModel itemId2 : currentList) {
                arrayList.add(String.valueOf(itemId2.getItemId()));
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
        NavController findNavController = Navigation.findNavController(BuyNowOfferListFragment.access$getBuyNowOfferListActivity$p(this.this$0), C2723R.C2726id.buy_now_main_nav_host_fragment);
        Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…w_main_nav_host_fragment)");
        findNavController.navigate((int) C2723R.C2726id.action_ACFragment_to_View_Pager_PDFragment, bundle);
        if (this.this$0.totalCount > 1) {
            RelativeLayout relativeLayout = (RelativeLayout) BuyNowOfferListFragment.access$getBuyNowOfferListActivity$p(this.this$0)._$_findCachedViewById(C2723R.C2726id.buynow_toolbar_relativelayout);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "buyNowOfferListActivity.…ow_toolbar_relativelayout");
            relativeLayout.setGravity(GravityCompat.END);
            RelativeLayout relativeLayout2 = (RelativeLayout) BuyNowOfferListFragment.access$getBuyNowOfferListActivity$p(this.this$0)._$_findCachedViewById(C2723R.C2726id.buynow_toolbar_relativelayout);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "buyNowOfferListActivity.…ow_toolbar_relativelayout");
            relativeLayout2.setGravity(5);
            TextView toolbar_title = BuyNowOfferListFragment.access$getBuyNowOfferListActivity$p(this.this$0).getToolbar_title();
            toolbar_title.setText(String.valueOf(i + 1) + " of " + NewDateHelper.INSTANCE.formattedVehicleCount(this.this$0.totalCount));
            BuyNowOfferListFragment.access$getBuyNowOfferListActivity$p(this.this$0).getToolbar_title().setTextColor(this.this$0.getResources().getColor(C2723R.C2724color.bdt_gray_darker));
            BuyNowOfferListFragment.access$getBuyNowOfferListActivity$p(this.this$0).getToolbar_sub_title().setVisibility(8);
            return;
        }
        BuyNowOfferListFragment.access$getBuyNowOfferListActivity$p(this.this$0).getToolbar_title().setText(this.this$0.year_make_model);
        BuyNowOfferListFragment.access$getBuyNowOfferListActivity$p(this.this$0).getToolbar_sub_title().setVisibility(8);
    }
}
