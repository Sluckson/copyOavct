package com.iaai.android.bdt.feature.auctionMainPage;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: AuctionMainListViewModel.kt */
final class AuctionMainListViewModel$disposeElements$2 extends MutablePropertyReference0 {
    AuctionMainListViewModel$disposeElements$2(AuctionMainListViewModel auctionMainListViewModel) {
        super(auctionMainListViewModel);
    }

    public String getName() {
        return "disposableObserverANIndicator";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(AuctionMainListViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserverANIndicator()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return AuctionMainListViewModel.access$getDisposableObserverANIndicator$p((AuctionMainListViewModel) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((AuctionMainListViewModel) this.receiver).disposableObserverANIndicator = (DisposableObserver) obj;
    }
}
