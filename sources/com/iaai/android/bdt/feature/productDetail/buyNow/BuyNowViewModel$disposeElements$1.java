package com.iaai.android.bdt.feature.productDetail.buyNow;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BuyNowViewModel.kt */
final class BuyNowViewModel$disposeElements$1 extends MutablePropertyReference0 {
    BuyNowViewModel$disposeElements$1(BuyNowViewModel buyNowViewModel) {
        super(buyNowViewModel);
    }

    public String getName() {
        return "disposableObserver";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(BuyNowViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserver()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return BuyNowViewModel.access$getDisposableObserver$p((BuyNowViewModel) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((BuyNowViewModel) this.receiver).disposableObserver = (DisposableObserver) obj;
    }
}
