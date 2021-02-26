package com.iaai.android.bdt.feature.account;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.iaai.android.bdt.model.MyAccount.BDTDashboardResponse;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;
import p011io.reactivex.Observer;
import p011io.reactivex.android.schedulers.AndroidSchedulers;
import p011io.reactivex.observers.DisposableObserver;
import p011io.reactivex.schedulers.Schedulers;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\rJ&\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010$\u001a\u00020\u001aR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\t\"\u0004\b\u001c\u0010\u000b¨\u0006%"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/MyAccountViewModel;", "Landroidx/lifecycle/ViewModel;", "myAccountRepository", "Lcom/iaai/android/bdt/feature/account/MyAccountRepository;", "(Lcom/iaai/android/bdt/feature/account/MyAccountRepository;)V", "BDTDashboardResponse", "Landroidx/lifecycle/MutableLiveData;", "Lcom/iaai/android/bdt/model/MyAccount/BDTDashboardResponse;", "getBDTDashboardResponse", "()Landroidx/lifecycle/MutableLiveData;", "setBDTDashboardResponse", "(Landroidx/lifecycle/MutableLiveData;)V", "BuyNowOfferResponse", "", "getBuyNowOfferResponse", "setBuyNowOfferResponse", "dashboardError", "getDashboardError", "setDashboardError", "disposableObserverDashboard", "Lio/reactivex/observers/DisposableObserver;", "disposableObserverOfferCount", "offerError", "getOfferError", "setOfferError", "showLoading", "", "getShowLoading", "setShowLoading", "disposeElements", "", "getBuyNowOfferCount", "userId", "loadDashboardData", "username", "password", "onlyMyItems", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: MyAccountViewModel.kt */
public final class MyAccountViewModel extends ViewModel {
    @NotNull
    private MutableLiveData<BDTDashboardResponse> BDTDashboardResponse = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<String> BuyNowOfferResponse = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<String> dashboardError = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public DisposableObserver<BDTDashboardResponse> disposableObserverDashboard;
    /* access modifiers changed from: private */
    public DisposableObserver<String> disposableObserverOfferCount;
    private final MyAccountRepository myAccountRepository;
    @NotNull
    private MutableLiveData<String> offerError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverDashboard$p(MyAccountViewModel myAccountViewModel) {
        DisposableObserver<BDTDashboardResponse> disposableObserver = myAccountViewModel.disposableObserverDashboard;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverDashboard");
        }
        return disposableObserver;
    }

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverOfferCount$p(MyAccountViewModel myAccountViewModel) {
        DisposableObserver<String> disposableObserver = myAccountViewModel.disposableObserverOfferCount;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverOfferCount");
        }
        return disposableObserver;
    }

    @Inject
    public MyAccountViewModel(@NotNull MyAccountRepository myAccountRepository2) {
        Intrinsics.checkParameterIsNotNull(myAccountRepository2, "myAccountRepository");
        this.myAccountRepository = myAccountRepository2;
    }

    @NotNull
    public final MutableLiveData<BDTDashboardResponse> getBDTDashboardResponse() {
        return this.BDTDashboardResponse;
    }

    public final void setBDTDashboardResponse(@NotNull MutableLiveData<BDTDashboardResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.BDTDashboardResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getDashboardError() {
        return this.dashboardError;
    }

    public final void setDashboardError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.dashboardError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getBuyNowOfferResponse() {
        return this.BuyNowOfferResponse;
    }

    public final void setBuyNowOfferResponse(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.BuyNowOfferResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getOfferError() {
        return this.offerError;
    }

    public final void setOfferError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.offerError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowLoading() {
        return this.showLoading;
    }

    public final void setShowLoading(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.showLoading = mutableLiveData;
    }

    public final void loadDashboardData(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "username");
        Intrinsics.checkParameterIsNotNull(str2, "password");
        Intrinsics.checkParameterIsNotNull(str3, "userId");
        this.showLoading.postValue(true);
        this.disposableObserverDashboard = new MyAccountViewModel$loadDashboardData$1(this);
        Observable<BDTDashboardResponse> observeOn = this.myAccountRepository.loadDashboardInfo(str, str2, str3, z).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<BDTDashboardResponse> disposableObserver = this.disposableObserverDashboard;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverDashboard");
        }
        observeOn.subscribe((Observer<? super BDTDashboardResponse>) disposableObserver);
    }

    public final void getBuyNowOfferCount(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "userId");
        this.showLoading.postValue(true);
        this.disposableObserverOfferCount = new MyAccountViewModel$getBuyNowOfferCount$1(this);
        Observable<String> observeOn = this.myAccountRepository.getBuyNowOfferCount(str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<String> disposableObserver = this.disposableObserverOfferCount;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverOfferCount");
        }
        observeOn.subscribe((Observer<? super String>) disposableObserver);
    }

    public final void disposeElements() {
        MyAccountViewModel myAccountViewModel = this;
        if (myAccountViewModel.disposableObserverDashboard != null) {
            DisposableObserver<BDTDashboardResponse> disposableObserver = this.disposableObserverDashboard;
            if (disposableObserver == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverDashboard");
            }
            if (!disposableObserver.isDisposed()) {
                DisposableObserver<BDTDashboardResponse> disposableObserver2 = this.disposableObserverDashboard;
                if (disposableObserver2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverDashboard");
                }
                disposableObserver2.dispose();
            }
        }
        if (myAccountViewModel.disposableObserverOfferCount != null) {
            DisposableObserver<String> disposableObserver3 = this.disposableObserverOfferCount;
            if (disposableObserver3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverOfferCount");
            }
            if (!disposableObserver3.isDisposed()) {
                DisposableObserver<String> disposableObserver4 = this.disposableObserverOfferCount;
                if (disposableObserver4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverOfferCount");
                }
                disposableObserver4.dispose();
            }
        }
    }
}
