package com.iaai.android.bdt.feature.account.tobepickedup;

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
import com.iaai.android.bdt.model.MyAccount.ToBePickedUpVehiclesModel;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.NewDateHelper;
import com.iaai.android.old.utils.constants.Constants;
import com.lowagie.text.html.HtmlTags;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, mo66933d2 = {"com/iaai/android/bdt/feature/account/tobepickedup/ToBePickedUpListFragment$initializeRecycler$1", "Lcom/iaai/android/bdt/feature/account/tobepickedup/OnItemClickListener;", "onItemClickListener", "", "v", "Landroid/view/View;", "data", "Lcom/iaai/android/bdt/model/MyAccount/ToBePickedUpVehiclesModel;", "position", "", "onSortItemClick", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ToBePickedUpFragment.kt */
public final class ToBePickedUpListFragment$initializeRecycler$1 implements OnItemClickListener {
    final /* synthetic */ ToBePickedUpListFragment this$0;

    ToBePickedUpListFragment$initializeRecycler$1(ToBePickedUpListFragment toBePickedUpListFragment) {
        this.this$0 = toBePickedUpListFragment;
    }

    public void onSortItemClick(int i) {
        Intent intent = new Intent(this.this$0.getActivity(), SortListActivity.class);
        ArrayList arrayList = new ArrayList();
        String[] stringArray = this.this$0.getResources().getStringArray(C2723R.array.sort_item_tobe_pickedup_list);
        Intrinsics.checkExpressionValueIsNotNull(stringArray, "resources.getStringArray…_item_tobe_pickedup_list)");
        int length = stringArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            String str = stringArray[i2];
            if (i2 == this.this$0.lastSelectedSort) {
                ToBePickedUpListFragment toBePickedUpListFragment = this.this$0;
                Intrinsics.checkExpressionValueIsNotNull(str, HtmlTags.f607S);
                arrayList.add(toBePickedUpListFragment.createSortOptionData(str, i2, true));
            } else {
                ToBePickedUpListFragment toBePickedUpListFragment2 = this.this$0;
                Intrinsics.checkExpressionValueIsNotNull(str, HtmlTags.f607S);
                arrayList.add(toBePickedUpListFragment2.createSortOptionData(str, i2, false));
            }
        }
        intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SORT_LIST, arrayList);
        intent.putExtra(Constants_MVVM.EXTRA_SORT_FROM, 3);
        intent.putExtra("screen_name", IAAAnalytics.IAAScreenName.WATCH_LIST_SORT.getValue());
        this.this$0.startActivityForResult(intent, 2);
    }

    public void onItemClickListener(@NotNull View view, @Nullable ToBePickedUpVehiclesModel toBePickedUpVehiclesModel, int i) {
        PagedList<ToBePickedUpVehiclesModel> currentList;
        String itemId;
        Intrinsics.checkParameterIsNotNull(view, "v");
        Long l = null;
        String valueOf = String.valueOf(toBePickedUpVehiclesModel != null ? toBePickedUpVehiclesModel.getItemId() : null);
        Bundle bundle = new Bundle();
        bundle.putString(Constants.EXTRA_ITEM_ID, valueOf);
        if (this.this$0.isTablet()) {
            if (!(toBePickedUpVehiclesModel == null || (itemId = toBePickedUpVehiclesModel.getItemId()) == null)) {
                l = Long.valueOf(Long.parseLong(itemId));
            }
            ToBePickedUpListFragment.access$getPreSaleAdapter$p(this.this$0).setSelectedItemForTablet(l);
            ToBePickedUpListFragment.access$getPreSaleAdapter$p(this.this$0).notifyDataSetChanged();
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
        ToBePickedUpAdapter access$getPreSaleAdapter$p = ToBePickedUpListFragment.access$getPreSaleAdapter$p(this.this$0);
        if (!(access$getPreSaleAdapter$p == null || (currentList = access$getPreSaleAdapter$p.getCurrentList()) == null)) {
            for (ToBePickedUpVehiclesModel itemId2 : currentList) {
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
        NavController findNavController = Navigation.findNavController(ToBePickedUpListFragment.access$getPreSaleListAccountActivity$p(this.this$0), C2723R.C2726id.tobe_pickedup_main_nav_host_fragment);
        Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…p_main_nav_host_fragment)");
        findNavController.navigate((int) C2723R.C2726id.action_ACFragment_to_View_Pager_PDFragment, bundle);
        if (this.this$0.totalCount > 1) {
            RelativeLayout relativeLayout = (RelativeLayout) ToBePickedUpListFragment.access$getPreSaleListAccountActivity$p(this.this$0)._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout_toPickUp);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "preSaleListAccountActivi…r_relativelayout_toPickUp");
            relativeLayout.setGravity(GravityCompat.END);
            RelativeLayout relativeLayout2 = (RelativeLayout) ToBePickedUpListFragment.access$getPreSaleListAccountActivity$p(this.this$0)._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout_toPickUp);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "preSaleListAccountActivi…r_relativelayout_toPickUp");
            relativeLayout2.setGravity(5);
            TextView toolbar_title = ToBePickedUpListFragment.access$getPreSaleListAccountActivity$p(this.this$0).getToolbar_title();
            toolbar_title.setText(String.valueOf(i + 1) + " of " + NewDateHelper.INSTANCE.formattedVehicleCount(this.this$0.totalCount));
            ToBePickedUpListFragment.access$getPreSaleListAccountActivity$p(this.this$0).getToolbar_title().setTextColor(this.this$0.getResources().getColor(C2723R.C2724color.bdt_gray_darker));
            ToBePickedUpListFragment.access$getPreSaleListAccountActivity$p(this.this$0).getToolbar_sub_title().setVisibility(8);
            return;
        }
        ToBePickedUpListFragment.access$getPreSaleListAccountActivity$p(this.this$0).getToolbar_title().setText(this.this$0.year_make_model);
        ToBePickedUpListFragment.access$getPreSaleListAccountActivity$p(this.this$0).getToolbar_sub_title().setVisibility(8);
    }
}
