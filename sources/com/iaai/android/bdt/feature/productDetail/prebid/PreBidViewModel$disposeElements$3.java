package com.iaai.android.bdt.feature.productDetail.prebid;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: PreBidViewModel.kt */
final class PreBidViewModel$disposeElements$3 extends MutablePropertyReference0 {
    PreBidViewModel$disposeElements$3(PreBidViewModel preBidViewModel) {
        super(preBidViewModel);
    }

    public String getName() {
        return "disposableObserverProductDetail";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(PreBidViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserverProductDetail()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return PreBidViewModel.access$getDisposableObserverProductDetail$p((PreBidViewModel) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((PreBidViewModel) this.receiver).disposableObserverProductDetail = (DisposableObserver) obj;
    }
}
