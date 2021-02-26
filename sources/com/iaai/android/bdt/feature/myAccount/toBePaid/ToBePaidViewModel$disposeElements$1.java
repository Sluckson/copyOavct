package com.iaai.android.bdt.feature.myAccount.toBePaid;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ToBePaidViewModel.kt */
final class ToBePaidViewModel$disposeElements$1 extends MutablePropertyReference0 {
    ToBePaidViewModel$disposeElements$1(ToBePaidViewModel toBePaidViewModel) {
        super(toBePaidViewModel);
    }

    public String getName() {
        return "disposableObserverGetPayPalToken";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ToBePaidViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserverGetPayPalToken()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return ToBePaidViewModel.access$getDisposableObserverGetPayPalToken$p((ToBePaidViewModel) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((ToBePaidViewModel) this.receiver).disposableObserverGetPayPalToken = (DisposableObserver) obj;
    }
}
