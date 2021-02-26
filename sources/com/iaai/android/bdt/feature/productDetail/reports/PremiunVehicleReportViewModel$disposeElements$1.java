package com.iaai.android.bdt.feature.productDetail.reports;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: PremiunVehicleReportViewModel.kt */
final class PremiunVehicleReportViewModel$disposeElements$1 extends MutablePropertyReference0 {
    PremiunVehicleReportViewModel$disposeElements$1(PremiunVehicleReportViewModel premiunVehicleReportViewModel) {
        super(premiunVehicleReportViewModel);
    }

    public String getName() {
        return "disposableObserverResult";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(PremiunVehicleReportViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserverResult()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return PremiunVehicleReportViewModel.access$getDisposableObserverResult$p((PremiunVehicleReportViewModel) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((PremiunVehicleReportViewModel) this.receiver).disposableObserverResult = (DisposableObserver) obj;
    }
}
