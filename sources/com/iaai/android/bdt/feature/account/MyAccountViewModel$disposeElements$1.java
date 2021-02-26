package com.iaai.android.bdt.feature.account;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: MyAccountViewModel.kt */
final class MyAccountViewModel$disposeElements$1 extends MutablePropertyReference0 {
    MyAccountViewModel$disposeElements$1(MyAccountViewModel myAccountViewModel) {
        super(myAccountViewModel);
    }

    public String getName() {
        return "disposableObserverDashboard";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(MyAccountViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserverDashboard()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return MyAccountViewModel.access$getDisposableObserverDashboard$p((MyAccountViewModel) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((MyAccountViewModel) this.receiver).disposableObserverDashboard = (DisposableObserver) obj;
    }
}
