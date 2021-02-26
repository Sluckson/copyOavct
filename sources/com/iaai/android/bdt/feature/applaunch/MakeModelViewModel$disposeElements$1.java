package com.iaai.android.bdt.feature.applaunch;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: MakeModelViewModel.kt */
final class MakeModelViewModel$disposeElements$1 extends MutablePropertyReference0 {
    MakeModelViewModel$disposeElements$1(MakeModelViewModel makeModelViewModel) {
        super(makeModelViewModel);
    }

    public String getName() {
        return "disposableObserver";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(MakeModelViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserver()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return MakeModelViewModel.access$getDisposableObserver$p((MakeModelViewModel) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((MakeModelViewModel) this.receiver).disposableObserver = (DisposableObserver) obj;
    }
}
