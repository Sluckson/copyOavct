package com.iaai.android.bdt.feature.landing;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.iaai.android.bdt.model.DashBoardDetails;
import com.iaai.android.bdt.model.recommendedVehicles.RecommendedVehiclesResponse;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;
import p011io.reactivex.Observer;
import p011io.reactivex.android.schedulers.AndroidSchedulers;
import p011io.reactivex.observers.DisposableObserver;
import p011io.reactivex.schedulers.Schedulers;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001f\u001a\u00020 J\u001e\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020#J\u000e\u0010&\u001a\u00020 2\u0006\u0010$\u001a\u00020\rR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u000bR&\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\t\"\u0004\b\u001e\u0010\u000b¨\u0006'"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/LandingPageViewModel;", "Landroidx/lifecycle/ViewModel;", "landingPageRepository", "Lcom/iaai/android/bdt/feature/landing/LandingPageRepository;", "(Lcom/iaai/android/bdt/feature/landing/LandingPageRepository;)V", "dashBordDetailsResult", "Landroidx/lifecycle/MutableLiveData;", "Lcom/iaai/android/bdt/model/DashBoardDetails;", "getDashBordDetailsResult", "()Landroidx/lifecycle/MutableLiveData;", "setDashBordDetailsResult", "(Landroidx/lifecycle/MutableLiveData;)V", "dashBordDetailsResultError", "", "getDashBordDetailsResultError", "setDashBordDetailsResultError", "disposableObserverDashBoard", "Lio/reactivex/observers/DisposableObserver;", "getDisposableObserverDashBoard", "()Lio/reactivex/observers/DisposableObserver;", "setDisposableObserverDashBoard", "(Lio/reactivex/observers/DisposableObserver;)V", "disposableObserverRecommended", "", "Lcom/iaai/android/bdt/model/recommendedVehicles/RecommendedVehiclesResponse;", "recommendedVehiclesError", "getRecommendedVehiclesError", "setRecommendedVehiclesError", "recommendedVehiclesResponse", "getRecommendedVehiclesResponse", "setRecommendedVehiclesResponse", "disposeElements", "", "getDashBoardDeatils", "userId", "", "authHeader", "onlyMyItems", "getRecommendedVehicles", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: LandingPageViewModel.kt */
public final class LandingPageViewModel extends ViewModel {
    @NotNull
    private MutableLiveData<DashBoardDetails> dashBordDetailsResult = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<String> dashBordDetailsResultError = new MutableLiveData<>();
    @NotNull
    public DisposableObserver<DashBoardDetails> disposableObserverDashBoard;
    /* access modifiers changed from: private */
    public DisposableObserver<List<RecommendedVehiclesResponse>> disposableObserverRecommended;
    private final LandingPageRepository landingPageRepository;
    @NotNull
    private MutableLiveData<String> recommendedVehiclesError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<List<RecommendedVehiclesResponse>> recommendedVehiclesResponse = new MutableLiveData<>();

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverRecommended$p(LandingPageViewModel landingPageViewModel) {
        DisposableObserver<List<RecommendedVehiclesResponse>> disposableObserver = landingPageViewModel.disposableObserverRecommended;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverRecommended");
        }
        return disposableObserver;
    }

    @Inject
    public LandingPageViewModel(@NotNull LandingPageRepository landingPageRepository2) {
        Intrinsics.checkParameterIsNotNull(landingPageRepository2, "landingPageRepository");
        this.landingPageRepository = landingPageRepository2;
    }

    @NotNull
    public final MutableLiveData<DashBoardDetails> getDashBordDetailsResult() {
        return this.dashBordDetailsResult;
    }

    public final void setDashBordDetailsResult(@NotNull MutableLiveData<DashBoardDetails> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.dashBordDetailsResult = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getDashBordDetailsResultError() {
        return this.dashBordDetailsResultError;
    }

    public final void setDashBordDetailsResultError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.dashBordDetailsResultError = mutableLiveData;
    }

    @NotNull
    public final DisposableObserver<DashBoardDetails> getDisposableObserverDashBoard() {
        DisposableObserver<DashBoardDetails> disposableObserver = this.disposableObserverDashBoard;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverDashBoard");
        }
        return disposableObserver;
    }

    public final void setDisposableObserverDashBoard(@NotNull DisposableObserver<DashBoardDetails> disposableObserver) {
        Intrinsics.checkParameterIsNotNull(disposableObserver, "<set-?>");
        this.disposableObserverDashBoard = disposableObserver;
    }

    @NotNull
    public final MutableLiveData<List<RecommendedVehiclesResponse>> getRecommendedVehiclesResponse() {
        return this.recommendedVehiclesResponse;
    }

    public final void setRecommendedVehiclesResponse(@NotNull MutableLiveData<List<RecommendedVehiclesResponse>> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.recommendedVehiclesResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getRecommendedVehiclesError() {
        return this.recommendedVehiclesError;
    }

    public final void setRecommendedVehiclesError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.recommendedVehiclesError = mutableLiveData;
    }

    public final void getDashBoardDeatils(int i, @NotNull String str, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        this.disposableObserverDashBoard = new LandingPageViewModel$getDashBoardDeatils$1(this);
        Observable<DashBoardDetails> observeOn = this.landingPageRepository.getDashBordDetails(i, str, i2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<DashBoardDetails> disposableObserver = this.disposableObserverDashBoard;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverDashBoard");
        }
        observeOn.subscribe((Observer<? super DashBoardDetails>) disposableObserver);
    }

    public final void getRecommendedVehicles(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        this.disposableObserverRecommended = new LandingPageViewModel$getRecommendedVehicles$1(this);
        Observable<List<RecommendedVehiclesResponse>> observeOn = this.landingPageRepository.getRecommendedVehicles(str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<List<RecommendedVehiclesResponse>> disposableObserver = this.disposableObserverRecommended;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverRecommended");
        }
        observeOn.subscribe((Observer<? super List<RecommendedVehiclesResponse>>) disposableObserver);
    }

    public final void disposeElements() {
        LandingPageViewModel landingPageViewModel = this;
        if (landingPageViewModel.disposableObserverDashBoard != null) {
            DisposableObserver<DashBoardDetails> disposableObserver = this.disposableObserverDashBoard;
            if (disposableObserver == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverDashBoard");
            }
            if (!disposableObserver.isDisposed()) {
                DisposableObserver<DashBoardDetails> disposableObserver2 = this.disposableObserverDashBoard;
                if (disposableObserver2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverDashBoard");
                }
                disposableObserver2.dispose();
            }
        }
        if (landingPageViewModel.disposableObserverRecommended != null) {
            DisposableObserver<List<RecommendedVehiclesResponse>> disposableObserver3 = this.disposableObserverRecommended;
            if (disposableObserver3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverRecommended");
            }
            if (!disposableObserver3.isDisposed()) {
                DisposableObserver<List<RecommendedVehiclesResponse>> disposableObserver4 = this.disposableObserverRecommended;
                if (disposableObserver4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverRecommended");
                }
                disposableObserver4.dispose();
            }
        }
    }
}
