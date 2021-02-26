package com.iaai.android.bdt.feature.productDetail.prebid;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: PreBidViewModel.kt */
final class PreBidViewModel$disposeElements$2 extends MutablePropertyReference0 {
    PreBidViewModel$disposeElements$2(PreBidViewModel preBidViewModel) {
        super(preBidViewModel);
    }

    public String getName() {
        return "disposableObserverResult";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(PreBidViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserverResult()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return PreBidViewModel.access$getDisposableObserverResult$p((PreBidViewModel) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((PreBidViewModel) this.receiver).disposableObserverResult = (DisposableObserver) obj;
    }
}
