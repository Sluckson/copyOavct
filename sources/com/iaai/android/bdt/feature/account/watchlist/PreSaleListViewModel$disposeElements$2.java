package com.iaai.android.bdt.feature.account.watchlist;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: PreSaleListViewModel.kt */
final class PreSaleListViewModel$disposeElements$2 extends MutablePropertyReference0 {
    PreSaleListViewModel$disposeElements$2(PreSaleListViewModel preSaleListViewModel) {
        super(preSaleListViewModel);
    }

    public String getName() {
        return "disposableReceiptPDFResult";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(PreSaleListViewModel.class);
    }

    public String getSignature() {
        return "getDisposableReceiptPDFResult()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return ((PreSaleListViewModel) this.receiver).getDisposableReceiptPDFResult();
    }

    public void set(@Nullable Object obj) {
        ((PreSaleListViewModel) this.receiver).setDisposableReceiptPDFResult((DisposableObserver) obj);
    }
}
