package com.iaai.android.bdt.feature.account.tobepickedup;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ToBePickedUpViewModel.kt */
final class ToBePickedUpViewModel$disposeElements$1 extends MutablePropertyReference0 {
    ToBePickedUpViewModel$disposeElements$1(ToBePickedUpViewModel toBePickedUpViewModel) {
        super(toBePickedUpViewModel);
    }

    public String getName() {
        return "disposableObserver";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ToBePickedUpViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserver()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return ((ToBePickedUpViewModel) this.receiver).getDisposableObserver();
    }

    public void set(@Nullable Object obj) {
        ((ToBePickedUpViewModel) this.receiver).setDisposableObserver((DisposableObserver) obj);
    }
}
