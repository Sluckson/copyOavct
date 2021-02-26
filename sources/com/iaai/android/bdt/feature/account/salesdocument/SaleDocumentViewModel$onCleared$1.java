package com.iaai.android.bdt.feature.account.salesdocument;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SaleDocumentViewModel.kt */
final class SaleDocumentViewModel$onCleared$1 extends MutablePropertyReference0 {
    SaleDocumentViewModel$onCleared$1(SaleDocumentViewModel saleDocumentViewModel) {
        super(saleDocumentViewModel);
    }

    public String getName() {
        return "disposableObserver";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(SaleDocumentViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserver()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return ((SaleDocumentViewModel) this.receiver).getDisposableObserver();
    }

    public void set(@Nullable Object obj) {
        ((SaleDocumentViewModel) this.receiver).setDisposableObserver((DisposableObserver) obj);
    }
}
