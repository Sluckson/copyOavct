package com.iaai.android.bdt.feature.account;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, mo66933d2 = {"com/iaai/android/bdt/feature/account/MyAccountViewModel$getBuyNowOfferCount$1", "Lio/reactivex/observers/DisposableObserver;", "", "onComplete", "", "onError", "e", "", "onNext", "response", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: MyAccountViewModel.kt */
public final class MyAccountViewModel$getBuyNowOfferCount$1 extends DisposableObserver<String> {
    final /* synthetic */ MyAccountViewModel this$0;

    public void onComplete() {
    }

    MyAccountViewModel$getBuyNowOfferCount$1(MyAccountViewModel myAccountViewModel) {
        this.this$0 = myAccountViewModel;
    }

    public void onNext(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "response");
        this.this$0.getShowLoading().postValue(false);
        this.this$0.getBuyNowOfferResponse().postValue(str);
    }

    public void onError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        this.this$0.getShowLoading().postValue(false);
        this.this$0.getOfferError().postValue(th.getMessage());
    }
}
