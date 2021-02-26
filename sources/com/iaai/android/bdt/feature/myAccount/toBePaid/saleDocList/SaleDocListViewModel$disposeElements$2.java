package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SaleDocListViewModel.kt */
final class SaleDocListViewModel$disposeElements$2 extends MutablePropertyReference0 {
    SaleDocListViewModel$disposeElements$2(SaleDocListViewModel saleDocListViewModel) {
        super(saleDocListViewModel);
    }

    public String getName() {
        return "disposableObserverGetSaleDocList";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(SaleDocListViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserverGetSaleDocList()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return SaleDocListViewModel.access$getDisposableObserverGetSaleDocList$p((SaleDocListViewModel) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((SaleDocListViewModel) this.receiver).disposableObserverGetSaleDocList = (DisposableObserver) obj;
    }
}
