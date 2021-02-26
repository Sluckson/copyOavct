package com.iaai.android.bdt.feature.login;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ForgotPasswordViewModel.kt */
final class ForgotPasswordViewModel$disposeElements$1 extends MutablePropertyReference0 {
    ForgotPasswordViewModel$disposeElements$1(ForgotPasswordViewModel forgotPasswordViewModel) {
        super(forgotPasswordViewModel);
    }

    public String getName() {
        return "disposableObserver";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ForgotPasswordViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserver()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return ((ForgotPasswordViewModel) this.receiver).getDisposableObserver();
    }

    public void set(@Nullable Object obj) {
        ((ForgotPasswordViewModel) this.receiver).setDisposableObserver((DisposableObserver) obj);
    }
}
