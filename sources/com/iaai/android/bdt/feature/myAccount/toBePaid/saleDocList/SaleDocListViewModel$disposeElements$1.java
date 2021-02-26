package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SaleDocListViewModel.kt */
final class SaleDocListViewModel$disposeElements$1 extends MutablePropertyReference0 {
    SaleDocListViewModel$disposeElements$1(SaleDocListViewModel saleDocListViewModel) {
        super(saleDocListViewModel);
    }

    public String getName() {
        return "disposableObserverGetSaleDocListGroup";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(SaleDocListViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserverGetSaleDocListGroup()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return SaleDocListViewModel.access$getDisposableObserverGetSaleDocListGroup$p((SaleDocListViewModel) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((SaleDocListViewModel) this.receiver).disposableObserverGetSaleDocListGroup = (DisposableObserver) obj;
    }
}
