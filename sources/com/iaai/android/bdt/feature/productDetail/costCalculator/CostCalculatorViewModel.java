package com.iaai.android.bdt.feature.productDetail.costCalculator;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.iaai.android.bdt.model.productDetail.costCalculator.CostCalculatorResponse;
import com.iaai.android.bdt.utils.Constants_MVVM;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;
import p011io.reactivex.Observer;
import p011io.reactivex.android.schedulers.AndroidSchedulers;
import p011io.reactivex.observers.DisposableObserver;
import p011io.reactivex.schedulers.Schedulers;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J^\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0006J\u0006\u0010(\u001a\u00020\u0019J\u000e\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u0015R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006+"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/costCalculator/CostCalculatorViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/iaai/android/bdt/feature/productDetail/costCalculator/CostCalculatorRepository;", "(Lcom/iaai/android/bdt/feature/productDetail/costCalculator/CostCalculatorRepository;)V", "TAG", "", "kotlin.jvm.PlatformType", "costCalculatorResultError", "Landroidx/lifecycle/MutableLiveData;", "getCostCalculatorResultError", "()Landroidx/lifecycle/MutableLiveData;", "setCostCalculatorResultError", "(Landroidx/lifecycle/MutableLiveData;)V", "costCalculatorResultResponse", "Lcom/iaai/android/bdt/model/productDetail/costCalculator/CostCalculatorResponse;", "getCostCalculatorResultResponse", "setCostCalculatorResultResponse", "disposableObserverResult", "Lio/reactivex/observers/DisposableObserver;", "showLoading", "", "getShowLoading", "setShowLoading", "costCalculator", "", "salvageId", "Ljava/math/BigDecimal;", "stockNumber", "bidAmount", "Ljava/math/BigInteger;", "buyerId", "", "userId", "pikUpZip", "dropOffZip", "vin", "runAndDrive", "employeeId", "branchCode", "disposeElements", "updateLoadingIndicator", "status", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: CostCalculatorViewModel.kt */
public final class CostCalculatorViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public final String TAG = CostCalculatorViewModel.class.getSimpleName();
    @NotNull
    private MutableLiveData<String> costCalculatorResultError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<CostCalculatorResponse> costCalculatorResultResponse = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public DisposableObserver<CostCalculatorResponse> disposableObserverResult;
    private final CostCalculatorRepository repository;
    @NotNull
    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverResult$p(CostCalculatorViewModel costCalculatorViewModel) {
        DisposableObserver<CostCalculatorResponse> disposableObserver = costCalculatorViewModel.disposableObserverResult;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverResult");
        }
        return disposableObserver;
    }

    @Inject
    public CostCalculatorViewModel(@NotNull CostCalculatorRepository costCalculatorRepository) {
        Intrinsics.checkParameterIsNotNull(costCalculatorRepository, "repository");
        this.repository = costCalculatorRepository;
    }

    @NotNull
    public final MutableLiveData<CostCalculatorResponse> getCostCalculatorResultResponse() {
        return this.costCalculatorResultResponse;
    }

    public final void setCostCalculatorResultResponse(@NotNull MutableLiveData<CostCalculatorResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.costCalculatorResultResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getCostCalculatorResultError() {
        return this.costCalculatorResultError;
    }

    public final void setCostCalculatorResultError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.costCalculatorResultError = mutableLiveData;
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

    public final void costCalculator(@NotNull BigDecimal bigDecimal, @NotNull BigDecimal bigDecimal2, @NotNull BigInteger bigInteger, int i, int i2, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkParameterIsNotNull(bigDecimal, "salvageId");
        BigDecimal bigDecimal3 = bigDecimal2;
        Intrinsics.checkParameterIsNotNull(bigDecimal3, "stockNumber");
        BigInteger bigInteger2 = bigInteger;
        Intrinsics.checkParameterIsNotNull(bigInteger2, "bidAmount");
        String str7 = str;
        Intrinsics.checkParameterIsNotNull(str7, "pikUpZip");
        String str8 = str2;
        Intrinsics.checkParameterIsNotNull(str8, "dropOffZip");
        String str9 = str3;
        Intrinsics.checkParameterIsNotNull(str9, Constants_MVVM.EXTRA_VIN);
        String str10 = str4;
        Intrinsics.checkParameterIsNotNull(str10, "runAndDrive");
        String str11 = str5;
        Intrinsics.checkParameterIsNotNull(str11, "employeeId");
        String str12 = str6;
        Intrinsics.checkParameterIsNotNull(str12, Constants_MVVM.EXTRA_BRANCH_CODE);
        updateLoadingIndicator(true);
        this.disposableObserverResult = new CostCalculatorViewModel$costCalculator$1(this);
        Observable<CostCalculatorResponse> observeOn = this.repository.getCostCalValue(bigDecimal, bigDecimal3, bigInteger2, i, i2, str7, str8, str9, str10, str11, str12).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<CostCalculatorResponse> disposableObserver = this.disposableObserverResult;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverResult");
        }
        observeOn.subscribe((Observer<? super CostCalculatorResponse>) disposableObserver);
    }

    public final void disposeElements() {
        if (this.disposableObserverResult != null) {
            DisposableObserver<CostCalculatorResponse> disposableObserver = this.disposableObserverResult;
            if (disposableObserver == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverResult");
            }
            if (!disposableObserver.isDisposed()) {
                DisposableObserver<CostCalculatorResponse> disposableObserver2 = this.disposableObserverResult;
                if (disposableObserver2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverResult");
                }
                disposableObserver2.dispose();
            }
        }
    }
}
