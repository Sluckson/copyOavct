package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import com.iaai.android.bdt.model.toBePaid.saleDocument.SaleDocResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, mo66933d2 = {"com/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryMethodViewModel$applyDeliveryMethods$1", "Lio/reactivex/observers/DisposableObserver;", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/SaleDocResponse;", "onComplete", "", "onError", "e", "", "onNext", "response", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryMethodViewModel.kt */
public final class DeliveryMethodViewModel$applyDeliveryMethods$1 extends DisposableObserver<SaleDocResponse> {
    final /* synthetic */ DeliveryMethodViewModel this$0;

    public void onComplete() {
    }

    DeliveryMethodViewModel$applyDeliveryMethods$1(DeliveryMethodViewModel deliveryMethodViewModel) {
        this.this$0 = deliveryMethodViewModel;
    }

    public void onNext(@NotNull SaleDocResponse saleDocResponse) {
        Intrinsics.checkParameterIsNotNull(saleDocResponse, "response");
        this.this$0.getSaveDeliveryMethodResponse().postValue(saleDocResponse);
    }

    public void onError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        this.this$0.getSaveDeliveryMethodError().postValue(th.getMessage());
    }
}
