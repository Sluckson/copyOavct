package com.iaai.android.bdt.feature.productDetail.prebid;

import android.util.Log;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.model.productDetail.biddingInfo.ProductDetailErrorModel;
import com.iaai.android.bdt.model.productDetail.biddingInfo.ProductDetailResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, mo66933d2 = {"com/iaai/android/bdt/feature/productDetail/prebid/PreBidViewModel$getProductDetail$1", "Lio/reactivex/observers/DisposableObserver;", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ProductDetailResponse;", "onComplete", "", "onError", "e", "", "onNext", "response", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PreBidViewModel.kt */
public final class PreBidViewModel$getProductDetail$1 extends DisposableObserver<ProductDetailResponse> {
    final /* synthetic */ String $queryEvent;
    final /* synthetic */ PreBidViewModel this$0;

    PreBidViewModel$getProductDetail$1(PreBidViewModel preBidViewModel, String str) {
        this.this$0 = preBidViewModel;
        this.$queryEvent = str;
    }

    public void onComplete() {
        this.this$0.updateLoadingIndicator(false);
    }

    public void onNext(@NotNull ProductDetailResponse productDetailResponse) {
        Intrinsics.checkParameterIsNotNull(productDetailResponse, "response");
        this.this$0.updateLoadingIndicator(false);
        CharSequence errorMessage = productDetailResponse.getErrorMessage();
        if (errorMessage == null || errorMessage.length() == 0) {
            this.this$0.getProductDetailResponse().postValue(productDetailResponse);
        } else {
            this.this$0.getProductDetailError().postValue(new ProductDetailErrorModel(false, productDetailResponse.getErrorMessage()));
        }
        IAAAnalytics iAAAnalytics = IAAAnalytics.INSTANCE;
        String str = this.$queryEvent;
        if (str == null) {
            Intrinsics.throwNpe();
        }
        iAAAnalytics.logNetworkEvent("acserviceswebapi/api/GetVehicleDetailsV2", true, str, "");
    }

    public void onError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        this.this$0.updateLoadingIndicator(false);
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        this.this$0.getProductDetailError().postValue(new ProductDetailErrorModel(true, message));
        IAAAnalytics iAAAnalytics = IAAAnalytics.INSTANCE;
        String str = this.$queryEvent;
        if (str == null) {
            Intrinsics.throwNpe();
        }
        iAAAnalytics.logNetworkEvent("acserviceswebapi/api/GetVehicleDetailsV2", true, str, th.getMessage());
        String access$getTAG$p = this.this$0.TAG;
        Log.e(access$getTAG$p, "getProductDetail: " + th.getMessage());
    }
}
