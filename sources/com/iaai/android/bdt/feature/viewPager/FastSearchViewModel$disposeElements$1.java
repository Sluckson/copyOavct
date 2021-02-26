package com.iaai.android.bdt.feature.viewPager;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchViewModel.kt */
final class FastSearchViewModel$disposeElements$1 extends MutablePropertyReference0 {
    FastSearchViewModel$disposeElements$1(FastSearchViewModel fastSearchViewModel) {
        super(fastSearchViewModel);
    }

    public String getName() {
        return "disposableObserver";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(FastSearchViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserver()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return ((FastSearchViewModel) this.receiver).getDisposableObserver();
    }

    public void set(@Nullable Object obj) {
        ((FastSearchViewModel) this.receiver).setDisposableObserver((DisposableObserver) obj);
    }
}
