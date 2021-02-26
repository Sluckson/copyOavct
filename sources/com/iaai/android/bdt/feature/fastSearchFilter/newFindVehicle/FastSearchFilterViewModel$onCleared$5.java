package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchFilterViewModel.kt */
final class FastSearchFilterViewModel$onCleared$5 extends MutablePropertyReference0 {
    FastSearchFilterViewModel$onCleared$5(FastSearchFilterViewModel fastSearchFilterViewModel) {
        super(fastSearchFilterViewModel);
    }

    public String getName() {
        return "disposablePopularCategoryObserver";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(FastSearchFilterViewModel.class);
    }

    public String getSignature() {
        return "getDisposablePopularCategoryObserver()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return ((FastSearchFilterViewModel) this.receiver).getDisposablePopularCategoryObserver();
    }

    public void set(@Nullable Object obj) {
        ((FastSearchFilterViewModel) this.receiver).setDisposablePopularCategoryObserver((DisposableObserver) obj);
    }
}
