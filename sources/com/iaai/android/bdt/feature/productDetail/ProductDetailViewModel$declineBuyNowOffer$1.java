package com.iaai.android.bdt.feature.productDetail;

import android.util.Log;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, mo66933d2 = {"com/iaai/android/bdt/feature/productDetail/ProductDetailViewModel$declineBuyNowOffer$1", "Lio/reactivex/observers/DisposableObserver;", "", "onComplete", "", "onError", "e", "", "onNext", "response", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailViewModel.kt */
public final class ProductDetailViewModel$declineBuyNowOffer$1 extends DisposableObserver<String> {
    final /* synthetic */ String $queryEvent;
    final /* synthetic */ ProductDetailViewModel this$0;

    ProductDetailViewModel$declineBuyNowOffer$1(ProductDetailViewModel productDetailViewModel, String str) {
        this.this$0 = productDetailViewModel;
        this.$queryEvent = str;
    }

    public void onComplete() {
        this.this$0.updateLoadingIndicator(false);
    }

    public void onNext(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "response");
        this.this$0.updateLoadingIndicator(false);
        this.this$0.getDeclineBuyNowOfferResponse().postValue(str);
        IAAAnalytics iAAAnalytics = IAAAnalytics.INSTANCE;
        String str2 = this.$queryEvent;
        if (str2 == null) {
            Intrinsics.throwNpe();
        }
        iAAAnalytics.logNetworkEvent("acserviceswebapi/api/DeclineBuyNowOffer", true, str2, "");
    }

    public void onError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        this.this$0.updateLoadingIndicator(false);
        this.this$0.getShowEmptyState().postValue(true);
        this.this$0.getDeclineBuyNowOfferError().postValue(th.getMessage());
        IAAAnalytics iAAAnalytics = IAAAnalytics.INSTANCE;
        String str = this.$queryEvent;
        if (str == null) {
            Intrinsics.throwNpe();
        }
        iAAAnalytics.logNetworkEvent("acserviceswebapi/api/DeclineBuyNowOffer", true, str, th.getMessage());
        String access$getTAG$p = this.this$0.TAG;
        Log.e(access$getTAG$p, "declineBuyNowOffer: " + th.getMessage());
    }
}
