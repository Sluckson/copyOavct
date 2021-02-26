package com.iaai.android.bdt.feature.productDetail.costCalculator;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: CostCalculatorViewModel.kt */
final class CostCalculatorViewModel$disposeElements$1 extends MutablePropertyReference0 {
    CostCalculatorViewModel$disposeElements$1(CostCalculatorViewModel costCalculatorViewModel) {
        super(costCalculatorViewModel);
    }

    public String getName() {
        return "disposableObserverResult";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(CostCalculatorViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserverResult()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return CostCalculatorViewModel.access$getDisposableObserverResult$p((CostCalculatorViewModel) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((CostCalculatorViewModel) this.receiver).disposableObserverResult = (DisposableObserver) obj;
    }
}
