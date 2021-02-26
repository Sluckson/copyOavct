package com.iaai.android.bdt.feature.productDetail.chromeSection;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ChromeSectionViewModel.kt */
final class ChromeSectionViewModel$disposeElements$1 extends MutablePropertyReference0 {
    ChromeSectionViewModel$disposeElements$1(ChromeSectionViewModel chromeSectionViewModel) {
        super(chromeSectionViewModel);
    }

    public String getName() {
        return "disposableObserver";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ChromeSectionViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserver()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return ChromeSectionViewModel.access$getDisposableObserver$p((ChromeSectionViewModel) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((ChromeSectionViewModel) this.receiver).disposableObserver = (DisposableObserver) obj;
    }
}
