package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryInstructionViewModel.kt */
final class DeliveryInstructionViewModel$disposeElements$2 extends MutablePropertyReference0 {
    DeliveryInstructionViewModel$disposeElements$2(DeliveryInstructionViewModel deliveryInstructionViewModel) {
        super(deliveryInstructionViewModel);
    }

    public String getName() {
        return "disposableObserverGetSaleDocList";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(DeliveryInstructionViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserverGetSaleDocList()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return DeliveryInstructionViewModel.access$getDisposableObserverGetSaleDocList$p((DeliveryInstructionViewModel) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((DeliveryInstructionViewModel) this.receiver).disposableObserverGetSaleDocList = (DisposableObserver) obj;
    }
}
