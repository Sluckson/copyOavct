package com.iaai.android.bdt.feature.fastSearchFilter.refinerResults;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.fragment.NavHostFragment;
import androidx.paging.PagedList;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.model.fastSearchFilter2.FormattedResult;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.utils.constants.Constants;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo66933d2 = {"<anonymous>", "", "pagedList", "Landroidx/paging/PagedList;", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FormattedResult;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: RefinerResultFragment.kt */
final class RefinerResultFragment$subscribeToViewModel$1<T> implements Observer<PagedList<FormattedResult>> {
    final /* synthetic */ RefinerResultFragment this$0;

    RefinerResultFragment$subscribeToViewModel$1(RefinerResultFragment refinerResultFragment) {
        this.this$0 = refinerResultFragment;
    }

    public final void onChanged(PagedList<FormattedResult> pagedList) {
        FormattedResult formattedResult;
        FormattedResult formattedResult2;
        Integer itemId;
        this.this$0.showLoadingIndicator(false);
        if (pagedList.size() == 0) {
            this.this$0.addHeaderOnResultList(true, BaseFragment.ErrorType.NO_STOCKS);
            this.this$0.isSingleSearchProductDeatil = false;
            if (this.this$0.isTablet()) {
                Bundle bundle = new Bundle();
                RefinerResultFragment.access$getRefinerResultListAdapter$p(this.this$0).setSelectedItemForTablet(34567845);
                RefinerResultFragment.access$getRefinerResultListAdapter$p(this.this$0).notifyDataSetChanged();
                bundle.putString(Constants.EXTRA_ITEM_ID, "34567845");
                Fragment findFragmentById = this.this$0.getChildFragmentManager().findFragmentById(C2723R.C2726id.auction_sales_nav_container);
                if (findFragmentById != null) {
                    NavHostFragment navHostFragment = (NavHostFragment) findFragmentById;
                    navHostFragment.getNavController().popBackStack();
                    navHostFragment.getNavController().navigate((int) C2723R.C2726id.PDFragment, bundle);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
            }
        } else if (pagedList.size() == 1) {
            this.this$0.isSingleSearchProductDeatil = true;
            this.this$0.navigateToProductDetailsPageForSingle(pagedList.get(0), 0);
        } else {
            this.this$0.isSingleSearchProductDeatil = false;
            this.this$0.isError = false;
            RefinerResultFragment refinerResultFragment = this.this$0;
            int access$getCurrentCount$p = refinerResultFragment.currentCount;
            Integer num = null;
            Integer valueOf = pagedList != null ? Integer.valueOf(pagedList.size()) : null;
            if (valueOf == null) {
                Intrinsics.throwNpe();
            }
            refinerResultFragment.currentCount = access$getCurrentCount$p + valueOf.intValue();
            Log.e(Constants_MVVM.EXTRA_CURRENT_COUNT, String.valueOf(this.this$0.currentCount));
            this.this$0.addHeaderOnResultList(false, BaseFragment.ErrorType.NO_QUICK_FILTER);
            if (pagedList != null) {
                for (FormattedResult formattedResult3 : pagedList) {
                    RefinerResultFragment.access$getRefinerResultListAdapter$p(this.this$0).setWatchingData(formattedResult3 != null ? formattedResult3.isWatching() : false, (formattedResult3 == null || (itemId = formattedResult3.getItemId()) == null) ? 0 : itemId.intValue());
                }
            }
            RefinerResultFragment.access$getRefinerResultListAdapter$p(this.this$0).submitList((PagedList) null);
            RefinerResultFragment.access$getRefinerResultListAdapter$p(this.this$0).notifyDataSetChanged();
            RefinerResultFragment.access$getRefinerResultListAdapter$p(this.this$0).submitList(pagedList);
            RefinerResultFragment.access$getRefinerResultListAdapter$p(this.this$0).notifyDataSetChanged();
            if (this.this$0.isTablet()) {
                String valueOf2 = String.valueOf((pagedList == null || (formattedResult2 = pagedList.get(0)) == null) ? null : formattedResult2.getItemId());
                Bundle bundle2 = new Bundle();
                if (!(pagedList == null || (formattedResult = pagedList.get(0)) == null)) {
                    num = formattedResult.getItemId();
                }
                RefinerResultFragment.access$getRefinerResultListAdapter$p(this.this$0).setSelectedItemForTablet(num);
                RefinerResultFragment.access$getRefinerResultListAdapter$p(this.this$0).notifyDataSetChanged();
                bundle2.putString(Constants.EXTRA_ITEM_ID, valueOf2);
                Fragment findFragmentById2 = this.this$0.getChildFragmentManager().findFragmentById(C2723R.C2726id.auction_sales_nav_container);
                if (findFragmentById2 != null) {
                    NavHostFragment navHostFragment2 = (NavHostFragment) findFragmentById2;
                    navHostFragment2.getNavController().popBackStack();
                    navHostFragment2.getNavController().navigate((int) C2723R.C2726id.PDFragment, bundle2);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
                }
            }
            if (pagedList.size() < 3 || this.this$0.isTablet()) {
                this.this$0.showLoadingIndicator(false);
            }
        }
    }
}
