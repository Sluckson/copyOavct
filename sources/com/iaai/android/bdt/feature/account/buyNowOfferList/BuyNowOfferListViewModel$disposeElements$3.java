package com.iaai.android.bdt.feature.account.buyNowOfferList;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BuyNowOfferListViewModel.kt */
final class BuyNowOfferListViewModel$disposeElements$3 extends MutablePropertyReference0 {
    BuyNowOfferListViewModel$disposeElements$3(BuyNowOfferListViewModel buyNowOfferListViewModel) {
        super(buyNowOfferListViewModel);
    }

    public String getName() {
        return "disposableObserverOfferCloseTime";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(BuyNowOfferListViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserverOfferCloseTime()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return BuyNowOfferListViewModel.access$getDisposableObserverOfferCloseTime$p((BuyNowOfferListViewModel) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((BuyNowOfferListViewModel) this.receiver).disposableObserverOfferCloseTime = (DisposableObserver) obj;
    }
}
