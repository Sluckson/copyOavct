package com.iaai.android.bdt.feature.auctionMainPage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.google.gson.Gson;
import com.iaai.android.bdt.model.auctionmainlist.AuctionLocations;
import com.iaai.android.bdt.model.auctionmainlist.AuctionMainListResponse;
import com.iaai.android.bdt.model.firebaseevent.GetMainAuctionListQuery;
import com.iaai.android.bdt.utils.NetworkState;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.utils.constants.Constants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;
import p011io.reactivex.Observer;
import p011io.reactivex.android.schedulers.AndroidSchedulers;
import p011io.reactivex.observers.DisposableObserver;
import p011io.reactivex.schedulers.Schedulers;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010$\u001a\u00020%J&\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0006J\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0019J\u000e\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020\u001eR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0016X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0019X.¢\u0006\u0002\n\u0000R \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000b\"\u0004\b \u0010\rR \u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000b\"\u0004\b#\u0010\r¨\u0006/"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionMainPage/AuctionMainListViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/iaai/android/bdt/feature/auctionMainPage/AuctionMainListRepository;", "(Lcom/iaai/android/bdt/feature/auctionMainPage/AuctionMainListRepository;)V", "TAG", "", "kotlin.jvm.PlatformType", "auctionMainListError", "Landroidx/lifecycle/MutableLiveData;", "getAuctionMainListError", "()Landroidx/lifecycle/MutableLiveData;", "setAuctionMainListError", "(Landroidx/lifecycle/MutableLiveData;)V", "auctionMainListResult", "Lcom/iaai/android/bdt/model/auctionmainlist/AuctionMainListResponse;", "getAuctionMainListResult", "setAuctionMainListResult", "auctionNowIndicatorError", "getAuctionNowIndicatorError", "setAuctionNowIndicatorError", "disposableObserver", "Lio/reactivex/observers/DisposableObserver;", "disposableObserverANIndicator", "networkState", "Landroidx/lifecycle/LiveData;", "Lcom/iaai/android/bdt/utils/NetworkState;", "resultLiveData", "Lcom/iaai/android/bdt/model/auctionmainlist/AuctionLocations;", "showEmptyState", "", "getShowEmptyState", "setShowEmptyState", "showLoading", "getShowLoading", "setShowLoading", "disposeElements", "", "getAuctionMainList", "query", "date", "latitude", "longitude", "getNetworkState", "getResultLiveData", "updateLoadingIndicator", "status", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionMainListViewModel.kt */
public final class AuctionMainListViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public final String TAG = AuctionMainListViewModel.class.getSimpleName();
    @NotNull
    private MutableLiveData<String> auctionMainListError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<AuctionMainListResponse> auctionMainListResult = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<String> auctionNowIndicatorError = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public DisposableObserver<AuctionMainListResponse> disposableObserver;
    /* access modifiers changed from: private */
    public DisposableObserver<String> disposableObserverANIndicator;
    private LiveData<NetworkState> networkState;
    private final AuctionMainListRepository repository;
    private LiveData<AuctionLocations> resultLiveData;
    @NotNull
    private MutableLiveData<Boolean> showEmptyState = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();

    public static final /* synthetic */ DisposableObserver access$getDisposableObserver$p(AuctionMainListViewModel auctionMainListViewModel) {
        DisposableObserver<AuctionMainListResponse> disposableObserver2 = auctionMainListViewModel.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        return disposableObserver2;
    }

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverANIndicator$p(AuctionMainListViewModel auctionMainListViewModel) {
        DisposableObserver<String> disposableObserver2 = auctionMainListViewModel.disposableObserverANIndicator;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverANIndicator");
        }
        return disposableObserver2;
    }

    @Inject
    public AuctionMainListViewModel(@NotNull AuctionMainListRepository auctionMainListRepository) {
        Intrinsics.checkParameterIsNotNull(auctionMainListRepository, "repository");
        this.repository = auctionMainListRepository;
    }

    @NotNull
    public final MutableLiveData<AuctionMainListResponse> getAuctionMainListResult() {
        return this.auctionMainListResult;
    }

    public final void setAuctionMainListResult(@NotNull MutableLiveData<AuctionMainListResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.auctionMainListResult = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getAuctionMainListError() {
        return this.auctionMainListError;
    }

    public final void setAuctionMainListError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.auctionMainListError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getAuctionNowIndicatorError() {
        return this.auctionNowIndicatorError;
    }

    public final void setAuctionNowIndicatorError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.auctionNowIndicatorError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowLoading() {
        return this.showLoading;
    }

    public final void setShowLoading(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.showLoading = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowEmptyState() {
        return this.showEmptyState;
    }

    public final void setShowEmptyState(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.showEmptyState = mutableLiveData;
    }

    public final void getAuctionMainList(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "query");
        Intrinsics.checkParameterIsNotNull(str2, Constants.EXTRA_DATE);
        Intrinsics.checkParameterIsNotNull(str3, "latitude");
        Intrinsics.checkParameterIsNotNull(str4, "longitude");
        updateLoadingIndicator(true);
        GetMainAuctionListQuery getMainAuctionListQuery = new GetMainAuctionListQuery();
        getMainAuctionListQuery.setCulturecode$app_productionRelease(Utils.getLanguage());
        getMainAuctionListQuery.setDevicetype$app_productionRelease("android");
        getMainAuctionListQuery.setSortAscending$app_productionRelease(true);
        getMainAuctionListQuery.setQuery$app_productionRelease(str);
        getMainAuctionListQuery.setDate$app_productionRelease(str2);
        getMainAuctionListQuery.setLatitude$app_productionRelease(str3);
        getMainAuctionListQuery.setLongitude$app_productionRelease(str4);
        this.disposableObserver = new AuctionMainListViewModel$getAuctionMainList$1(this, new Gson().toJson((Object) getMainAuctionListQuery));
        Observable<AuctionMainListResponse> observeOn = this.repository.getAuctionMainList(str, str2, str3, str4).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<AuctionMainListResponse> disposableObserver2 = this.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        observeOn.subscribe((Observer<? super AuctionMainListResponse>) disposableObserver2);
    }

    public final void disposeElements() {
        AuctionMainListViewModel auctionMainListViewModel = this;
        if (auctionMainListViewModel.disposableObserver != null) {
            DisposableObserver<AuctionMainListResponse> disposableObserver2 = this.disposableObserver;
            if (disposableObserver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
            }
            if (!disposableObserver2.isDisposed()) {
                DisposableObserver<AuctionMainListResponse> disposableObserver3 = this.disposableObserver;
                if (disposableObserver3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
                }
                disposableObserver3.dispose();
            }
        }
        if (auctionMainListViewModel.disposableObserverANIndicator != null) {
            DisposableObserver<String> disposableObserver4 = this.disposableObserverANIndicator;
            if (disposableObserver4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverANIndicator");
            }
            if (!disposableObserver4.isDisposed()) {
                DisposableObserver<String> disposableObserver5 = this.disposableObserverANIndicator;
                if (disposableObserver5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverANIndicator");
                }
                disposableObserver5.dispose();
            }
        }
    }

    @NotNull
    public final LiveData<NetworkState> getNetworkState() {
        LiveData<NetworkState> liveData = this.networkState;
        if (liveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkState");
        }
        return liveData;
    }

    @NotNull
    public final LiveData<AuctionLocations> getResultLiveData() {
        LiveData<AuctionLocations> liveData = this.resultLiveData;
        if (liveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultLiveData");
        }
        return liveData;
    }

    public final void updateLoadingIndicator(boolean z) {
        this.showLoading.postValue(Boolean.valueOf(z));
    }
}
