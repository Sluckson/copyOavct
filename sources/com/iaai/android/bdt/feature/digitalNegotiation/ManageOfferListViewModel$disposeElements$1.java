package com.iaai.android.bdt.feature.digitalNegotiation;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ManageOfferListViewModel.kt */
final class ManageOfferListViewModel$disposeElements$1 extends MutablePropertyReference0 {
    ManageOfferListViewModel$disposeElements$1(ManageOfferListViewModel manageOfferListViewModel) {
        super(manageOfferListViewModel);
    }

    public String getName() {
        return "manageOfferDisposableObserver";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ManageOfferListViewModel.class);
    }

    public String getSignature() {
        return "getManageOfferDisposableObserver()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return ((ManageOfferListViewModel) this.receiver).getManageOfferDisposableObserver();
    }

    public void set(@Nullable Object obj) {
        ((ManageOfferListViewModel) this.receiver).setManageOfferDisposableObserver((DisposableObserver) obj);
    }
}
