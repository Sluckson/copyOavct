package com.iaai.android.bdt.feature.productDetail;

import android.util.Log;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.model.productDetail.biddingInfo.BiddingInformation;
import com.iaai.android.bdt.model.productDetail.biddingInfo.ProductDetailErrorModel;
import com.iaai.android.bdt.model.productDetail.biddingInfo.ProductDetailResponse;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, mo66933d2 = {"com/iaai/android/bdt/feature/productDetail/ProductDetailViewModel$getProductDetail$1", "Lio/reactivex/observers/DisposableObserver;", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ProductDetailResponse;", "onComplete", "", "onError", "e", "", "onNext", "response", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailViewModel.kt */
public final class ProductDetailViewModel$getProductDetail$1 extends DisposableObserver<ProductDetailResponse> {
    final /* synthetic */ String $queryEvent;
    final /* synthetic */ String $tenantCode;
    final /* synthetic */ ProductDetailViewModel this$0;

    ProductDetailViewModel$getProductDetail$1(ProductDetailViewModel productDetailViewModel, String str, String str2) {
        this.this$0 = productDetailViewModel;
        this.$tenantCode = str;
        this.$queryEvent = str2;
    }

    public void onComplete() {
        this.this$0.updateLoadingIndicator(false);
    }

    public void onNext(@NotNull ProductDetailResponse productDetailResponse) {
        List<String> list;
        List<String> list2;
        Intrinsics.checkParameterIsNotNull(productDetailResponse, "response");
        this.this$0.updateLoadingIndicator(false);
        CharSequence errorMessage = productDetailResponse.getErrorMessage();
        if (!(errorMessage == null || errorMessage.length() == 0)) {
            this.this$0.getShowEmptyState().postValue(true);
            this.this$0.getProductDetailError().postValue(new ProductDetailErrorModel(false, productDetailResponse.getErrorMessage()));
        } else if (Intrinsics.areEqual((Object) this.$tenantCode, (Object) "UK") || Intrinsics.areEqual((Object) this.$tenantCode, (Object) "CA")) {
            this.this$0.getNonUsProductDetailResponse().postValue(productDetailResponse);
        } else {
            this.this$0.getProductDetailResponse().postValue(productDetailResponse);
            this.this$0.getImagesResponse().postValue(productDetailResponse.getImageInformation());
            ProductDetailViewModel productDetailViewModel = this.this$0;
            BiddingInformation biddingInformation = productDetailResponse.getBiddingInformation();
            if (biddingInformation == null || (list = biddingInformation.getBiddingNotes()) == null) {
                list = new ArrayList<>();
            }
            productDetailViewModel.getBiddingNotes(list);
            ProductDetailViewModel productDetailViewModel2 = this.this$0;
            BiddingInformation biddingInformation2 = productDetailResponse.getBiddingInformation();
            if (biddingInformation2 == null || (list2 = biddingInformation2.getBiddingWarnings()) == null) {
                list2 = new ArrayList<>();
            }
            productDetailViewModel2.getBiddingWarnings(list2, productDetailResponse);
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
        this.this$0.getShowEmptyState().postValue(true);
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        ProductDetailErrorModel productDetailErrorModel = new ProductDetailErrorModel(true, message);
        if (Intrinsics.areEqual((Object) this.$tenantCode, (Object) "US")) {
            this.this$0.getProductDetailError().postValue(productDetailErrorModel);
        } else {
            this.this$0.getNonUsProductDetailError().postValue(productDetailErrorModel);
        }
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
