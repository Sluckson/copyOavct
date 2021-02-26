package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryMethodViewModel.kt */
final class DeliveryMethodViewModel$disposeElements$1 extends MutablePropertyReference0 {
    DeliveryMethodViewModel$disposeElements$1(DeliveryMethodViewModel deliveryMethodViewModel) {
        super(deliveryMethodViewModel);
    }

    public String getName() {
        return "disposableObserverGetDeliveryMethod";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(DeliveryMethodViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserverGetDeliveryMethod()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return DeliveryMethodViewModel.access$getDisposableObserverGetDeliveryMethod$p((DeliveryMethodViewModel) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((DeliveryMethodViewModel) this.receiver).disposableObserverGetDeliveryMethod = (DisposableObserver) obj;
    }
}
