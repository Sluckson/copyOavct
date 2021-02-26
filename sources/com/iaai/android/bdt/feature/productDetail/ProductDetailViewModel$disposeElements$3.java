package com.iaai.android.bdt.feature.productDetail;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailViewModel.kt */
final class ProductDetailViewModel$disposeElements$3 extends MutablePropertyReference0 {
    ProductDetailViewModel$disposeElements$3(ProductDetailViewModel productDetailViewModel) {
        super(productDetailViewModel);
    }

    public String getName() {
        return "disposableObserverUpdateWatchStatus";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ProductDetailViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserverUpdateWatchStatus()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return ProductDetailViewModel.access$getDisposableObserverUpdateWatchStatus$p((ProductDetailViewModel) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((ProductDetailViewModel) this.receiver).disposableObserverUpdateWatchStatus = (DisposableObserver) obj;
    }
}
