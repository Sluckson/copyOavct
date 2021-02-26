package com.iaai.android.bdt.feature.login;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: LoginViewModel.kt */
final class LoginViewModel$disposeElements$2 extends MutablePropertyReference0 {
    LoginViewModel$disposeElements$2(LoginViewModel loginViewModel) {
        super(loginViewModel);
    }

    public String getName() {
        return "disposableObserverAuctionRuleResponse";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(LoginViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserverAuctionRuleResponse()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return LoginViewModel.access$getDisposableObserverAuctionRuleResponse$p((LoginViewModel) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((LoginViewModel) this.receiver).disposableObserverAuctionRuleResponse = (DisposableObserver) obj;
    }
}
