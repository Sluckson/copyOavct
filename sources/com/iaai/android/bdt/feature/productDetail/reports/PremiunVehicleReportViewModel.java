package com.iaai.android.bdt.feature.productDetail.reports;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.iaai.android.bdt.model.productDetail.reports.PremiumVehicleReportModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;
import p011io.reactivex.Observer;
import p011io.reactivex.android.schedulers.AndroidSchedulers;
import p011io.reactivex.observers.DisposableObserver;
import p011io.reactivex.schedulers.Schedulers;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006J\u000e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0015R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX.¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010¨\u0006\u001f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/reports/PremiunVehicleReportViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/iaai/android/bdt/feature/productDetail/reports/PremiumVehicleReportRepository;", "(Lcom/iaai/android/bdt/feature/productDetail/reports/PremiumVehicleReportRepository;)V", "TAG", "", "kotlin.jvm.PlatformType", "disposableObserverResult", "Lio/reactivex/observers/DisposableObserver;", "Lcom/iaai/android/bdt/model/productDetail/reports/PremiumVehicleReportModel;", "pvrReportResultError", "Landroidx/lifecycle/MutableLiveData;", "getPvrReportResultError", "()Landroidx/lifecycle/MutableLiveData;", "setPvrReportResultError", "(Landroidx/lifecycle/MutableLiveData;)V", "pvrReportResultResponse", "getPvrReportResultResponse", "setPvrReportResultResponse", "showLoading", "", "getShowLoading", "setShowLoading", "disposeElements", "", "getPremiumVehicleReport", "url", "authHeader", "updateLoadingIndicator", "status", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PremiunVehicleReportViewModel.kt */
public final class PremiunVehicleReportViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public final String TAG = PremiunVehicleReportViewModel.class.getSimpleName();
    /* access modifiers changed from: private */
    public DisposableObserver<PremiumVehicleReportModel> disposableObserverResult;
    @NotNull
    private MutableLiveData<String> pvrReportResultError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<PremiumVehicleReportModel> pvrReportResultResponse = new MutableLiveData<>();
    private final PremiumVehicleReportRepository repository;
    @NotNull
    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverResult$p(PremiunVehicleReportViewModel premiunVehicleReportViewModel) {
        DisposableObserver<PremiumVehicleReportModel> disposableObserver = premiunVehicleReportViewModel.disposableObserverResult;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverResult");
        }
        return disposableObserver;
    }

    @Inject
    public PremiunVehicleReportViewModel(@NotNull PremiumVehicleReportRepository premiumVehicleReportRepository) {
        Intrinsics.checkParameterIsNotNull(premiumVehicleReportRepository, "repository");
        this.repository = premiumVehicleReportRepository;
    }

    @NotNull
    public final MutableLiveData<PremiumVehicleReportModel> getPvrReportResultResponse() {
        return this.pvrReportResultResponse;
    }

    public final void setPvrReportResultResponse(@NotNull MutableLiveData<PremiumVehicleReportModel> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.pvrReportResultResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getPvrReportResultError() {
        return this.pvrReportResultError;
    }

    public final void setPvrReportResultError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.pvrReportResultError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowLoading() {
        return this.showLoading;
    }

    public final void setShowLoading(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.showLoading = mutableLiveData;
    }

    public final void updateLoadingIndicator(boolean z) {
        this.showLoading.postValue(Boolean.valueOf(z));
    }

    public final void getPremiumVehicleReport(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        Intrinsics.checkParameterIsNotNull(str2, "authHeader");
        updateLoadingIndicator(true);
        this.disposableObserverResult = new PremiunVehicleReportViewModel$getPremiumVehicleReport$1(this);
        Observable<PremiumVehicleReportModel> observeOn = this.repository.getPremiumVehicleReport(str, str2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<PremiumVehicleReportModel> disposableObserver = this.disposableObserverResult;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverResult");
        }
        observeOn.subscribe((Observer<? super PremiumVehicleReportModel>) disposableObserver);
    }

    public final void disposeElements() {
        if (this.disposableObserverResult != null) {
            DisposableObserver<PremiumVehicleReportModel> disposableObserver = this.disposableObserverResult;
            if (disposableObserver == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverResult");
            }
            if (!disposableObserver.isDisposed()) {
                DisposableObserver<PremiumVehicleReportModel> disposableObserver2 = this.disposableObserverResult;
                if (disposableObserver2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverResult");
                }
                disposableObserver2.dispose();
            }
        }
    }
}
