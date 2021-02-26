package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryInstructionViewModel.kt */
final class DeliveryInstructionViewModel$disposeElements$1 extends MutablePropertyReference0 {
    DeliveryInstructionViewModel$disposeElements$1(DeliveryInstructionViewModel deliveryInstructionViewModel) {
        super(deliveryInstructionViewModel);
    }

    public String getName() {
        return "disposableObserverGetSaleDocListGroup";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(DeliveryInstructionViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserverGetSaleDocListGroup()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return DeliveryInstructionViewModel.access$getDisposableObserverGetSaleDocListGroup$p((DeliveryInstructionViewModel) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((DeliveryInstructionViewModel) this.receiver).disposableObserverGetSaleDocListGroup = (DisposableObserver) obj;
    }
}
