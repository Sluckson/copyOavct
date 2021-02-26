package com.iaai.android.bdt.feature.landing;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: LandingPageViewModel.kt */
final class LandingPageViewModel$disposeElements$1 extends MutablePropertyReference0 {
    LandingPageViewModel$disposeElements$1(LandingPageViewModel landingPageViewModel) {
        super(landingPageViewModel);
    }

    public String getName() {
        return "disposableObserverDashBoard";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(LandingPageViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserverDashBoard()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return ((LandingPageViewModel) this.receiver).getDisposableObserverDashBoard();
    }

    public void set(@Nullable Object obj) {
        ((LandingPageViewModel) this.receiver).setDisposableObserverDashBoard((DisposableObserver) obj);
    }
}
