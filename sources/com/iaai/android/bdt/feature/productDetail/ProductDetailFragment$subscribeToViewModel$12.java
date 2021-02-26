package com.iaai.android.bdt.feature.productDetail;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.Observer;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.extensions.Context_ExtensionKt;
import com.iaai.android.bdt.model.profile.UpdateWatchListResponse;
import com.iaai.android.old.utils.IAASharedPreference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "watchListResponse", "Lcom/iaai/android/bdt/model/profile/UpdateWatchListResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailFragment.kt */
final class ProductDetailFragment$subscribeToViewModel$12<T> implements Observer<UpdateWatchListResponse> {
    final /* synthetic */ ProductDetailFragment this$0;

    ProductDetailFragment$subscribeToViewModel$12(ProductDetailFragment productDetailFragment) {
        this.this$0 = productDetailFragment;
    }

    public final void onChanged(UpdateWatchListResponse updateWatchListResponse) {
        if (updateWatchListResponse != null && this.this$0.isAdded() && this.this$0.isViewAvalibale) {
            if (updateWatchListResponse.getIsSuccessful()) {
                if (Intrinsics.areEqual((Object) this.this$0.action, (Object) this.this$0.getResources().getString(C2723R.string.lbl_watch_action_add))) {
                    this.this$0.updateWatchUI(true);
                } else if (Intrinsics.areEqual((Object) this.this$0.action, (Object) this.this$0.getResources().getString(C2723R.string.lbl_watch_action_delete))) {
                    this.this$0.updateWatchUI(false);
                }
                if (this.this$0.isWatchingButtonClick) {
                    this.this$0.isWatchingButtonClick = false;
                    this.this$0.fetchProductDetail();
                }
            } else {
                Context context = this.this$0.getContext();
                if (context != null) {
                    Context_ExtensionKt.showToast(context, updateWatchListResponse.getMessage());
                }
            }
            this.this$0.isWatchingButtonClick = false;
            BaseActivity access$getBaseActivity$p = this.this$0.baseActivity;
            if (access$getBaseActivity$p == null) {
                Intrinsics.throwNpe();
            }
            Application application = access$getBaseActivity$p.getApplication();
            Intrinsics.checkExpressionValueIsNotNull(application, "baseActivity!!.application");
            IAASharedPreference.setWatchStatus(application.getApplicationContext(), true);
        }
    }
}
