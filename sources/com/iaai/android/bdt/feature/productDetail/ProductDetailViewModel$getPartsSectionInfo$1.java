package com.iaai.android.bdt.feature.productDetail;

import android.util.Log;
import com.google.gson.Gson;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.model.productDetail.partsSection.PartsSectionResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u000b"}, mo66933d2 = {"com/iaai/android/bdt/feature/productDetail/ProductDetailViewModel$getPartsSectionInfo$1", "Lio/reactivex/observers/DisposableObserver;", "", "Lcom/iaai/android/bdt/model/productDetail/partsSection/PartsSectionResponse;", "onComplete", "", "onError", "e", "", "onNext", "response", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailViewModel.kt */
public final class ProductDetailViewModel$getPartsSectionInfo$1 extends DisposableObserver<List<? extends PartsSectionResponse>> {
    final /* synthetic */ Integer $salvageId;
    final /* synthetic */ ProductDetailViewModel this$0;

    ProductDetailViewModel$getPartsSectionInfo$1(ProductDetailViewModel productDetailViewModel, Integer num) {
        this.this$0 = productDetailViewModel;
        this.$salvageId = num;
    }

    public void onComplete() {
        this.this$0.updateLoadingIndicator(false);
    }

    public void onNext(@NotNull List<PartsSectionResponse> list) {
        Intrinsics.checkParameterIsNotNull(list, "response");
        this.this$0.updateLoadingIndicator(false);
        this.this$0.getPartsInfoResponse().postValue(list);
        String json = new Gson().toJson((Object) String.valueOf(this.$salvageId));
        IAAAnalytics iAAAnalytics = IAAAnalytics.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(json, "queryEvent");
        iAAAnalytics.logNetworkEvent("acserviceswebapi/api/GetHollanderParts", true, json, "");
    }

    public void onError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        this.this$0.updateLoadingIndicator(false);
        this.this$0.getPartsError().postValue(th.getMessage());
        String json = new Gson().toJson((Object) String.valueOf(this.$salvageId));
        IAAAnalytics iAAAnalytics = IAAAnalytics.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(json, "queryEvent");
        iAAAnalytics.logNetworkEvent("acserviceswebapi/api/GetHollanderParts", false, json, th.getMessage());
        String access$getTAG$p = this.this$0.TAG;
        Log.e(access$getTAG$p, "getPartsSectionInfo: " + th.getMessage());
    }
}
