package com.iaai.android.bdt.feature.landing.quickFilter;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: QuickFilterViewModel.kt */
final class QuickFilterViewModel$disposeElements$4 extends MutablePropertyReference0 {
    QuickFilterViewModel$disposeElements$4(QuickFilterViewModel quickFilterViewModel) {
        super(quickFilterViewModel);
    }

    public String getName() {
        return "savedSearchListDisposableObserver";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(QuickFilterViewModel.class);
    }

    public String getSignature() {
        return "getSavedSearchListDisposableObserver()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return ((QuickFilterViewModel) this.receiver).getSavedSearchListDisposableObserver();
    }

    public void set(@Nullable Object obj) {
        ((QuickFilterViewModel) this.receiver).setSavedSearchListDisposableObserver((DisposableObserver) obj);
    }
}
