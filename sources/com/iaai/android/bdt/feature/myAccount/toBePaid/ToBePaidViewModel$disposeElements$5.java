package com.iaai.android.bdt.feature.myAccount.toBePaid;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ToBePaidViewModel.kt */
final class ToBePaidViewModel$disposeElements$5 extends MutablePropertyReference0 {
    ToBePaidViewModel$disposeElements$5(ToBePaidViewModel toBePaidViewModel) {
        super(toBePaidViewModel);
    }

    public String getName() {
        return "disposableObserverLogIAAError";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ToBePaidViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserverLogIAAError()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return ToBePaidViewModel.access$getDisposableObserverLogIAAError$p((ToBePaidViewModel) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((ToBePaidViewModel) this.receiver).disposableObserverLogIAAError = (DisposableObserver) obj;
    }
}
