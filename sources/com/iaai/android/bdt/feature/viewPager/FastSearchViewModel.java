package com.iaai.android.bdt.feature.viewPager;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.google.gson.Gson;
import com.iaai.android.bdt.feature.findVehiclePage.searchResult.dataSource.SearchDataFactoryV2;
import com.iaai.android.bdt.feature.watchList.WatchRepository;
import com.iaai.android.bdt.model.fastSearch.FastSearchResponse;
import com.iaai.android.bdt.model.fastSearch.Refiner;
import com.iaai.android.bdt.model.fastSearch.SearchInputV2;
import com.iaai.android.bdt.model.fastSearch.Vehicle;
import com.iaai.android.bdt.model.firebaseevent.WatchStatusQueryModel;
import com.iaai.android.bdt.model.profile.UpdateWatchListResponse;
import com.iaai.android.bdt.utils.NetworkState;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.utils.constants.Constants;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;
import p011io.reactivex.Observer;
import p011io.reactivex.android.schedulers.AndroidSchedulers;
import p011io.reactivex.disposables.CompositeDisposable;
import p011io.reactivex.observers.DisposableObserver;
import p011io.reactivex.schedulers.Schedulers;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010;\u001a\u00020<J&\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020.J\f\u0010C\u001a\b\u0012\u0004\u0012\u00020&0%J\f\u0010D\u001a\b\u0012\u0004\u0012\u00020!0%J\u0012\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000203020%J\f\u0010F\u001a\b\u0012\u0004\u0012\u00020!0%J\b\u0010G\u001a\u00020<H\u0002J&\u0010H\u001a\u00020<2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\u0006\u0010I\u001a\u00020?2\u0006\u0010J\u001a\u00020.J\b\u0010K\u001a\u00020<H\u0014J\u000e\u0010L\u001a\u00020<2\u0006\u0010M\u001a\u00020.J&\u0010N\u001a\u00020<2\u0006\u0010@\u001a\u00020\b2\u0006\u0010O\u001a\u00020\b2\u0006\u0010P\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\bR\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR \u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001a\"\u0004\b#\u0010\u001cR\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X.¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0%X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020!0%X.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X.¢\u0006\u0002\n\u0000R \u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001a\"\u0004\b0\u0010\u001cR\u001a\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000203020%X.¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020!0%X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R \u00105\u001a\b\u0012\u0004\u0012\u00020\b0\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001a\"\u0004\b7\u0010\u001cR \u00108\u001a\b\u0012\u0004\u0012\u00020\u00140\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001a\"\u0004\b:\u0010\u001c¨\u0006R"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/viewPager/FastSearchViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/iaai/android/bdt/feature/viewPager/FastSearchListRepository;", "watchRepository", "Lcom/iaai/android/bdt/feature/watchList/WatchRepository;", "(Lcom/iaai/android/bdt/feature/viewPager/FastSearchListRepository;Lcom/iaai/android/bdt/feature/watchList/WatchRepository;)V", "TAG", "", "kotlin.jvm.PlatformType", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "disposableObserver", "Lio/reactivex/observers/DisposableObserver;", "Lcom/iaai/android/bdt/model/fastSearch/FastSearchResponse;", "getDisposableObserver", "()Lio/reactivex/observers/DisposableObserver;", "setDisposableObserver", "(Lio/reactivex/observers/DisposableObserver;)V", "disposableObserverUpdateWatchStatus", "Lcom/iaai/android/bdt/model/profile/UpdateWatchListResponse;", "executor", "Ljava/util/concurrent/Executor;", "fastSearchListError", "Landroidx/lifecycle/MutableLiveData;", "getFastSearchListError", "()Landroidx/lifecycle/MutableLiveData;", "setFastSearchListError", "(Landroidx/lifecycle/MutableLiveData;)V", "fastSearchListResult", "getFastSearchListResult", "setFastSearchListResult", "fastSearchResultCount", "", "getFastSearchResultCount", "setFastSearchResultCount", "networkState", "Landroidx/lifecycle/LiveData;", "Lcom/iaai/android/bdt/utils/NetworkState;", "refinerLiveData", "", "Lcom/iaai/android/bdt/model/fastSearch/Refiner;", "scrollSearchListToTop", "searchDataFactoryV2", "Lcom/iaai/android/bdt/feature/findVehiclePage/searchResult/dataSource/SearchDataFactoryV2;", "showLoading", "", "getShowLoading", "setShowLoading", "vehicleLiveData", "Landroidx/paging/PagedList;", "Lcom/iaai/android/bdt/model/fastSearch/Vehicle;", "vehicleTotalCount", "watchStatusError", "getWatchStatusError", "setWatchStatusError", "watchStatusResponse", "getWatchStatusResponse", "setWatchStatusResponse", "disposeElements", "", "fetchSearchResultListV2", "requestBody", "Lcom/iaai/android/bdt/model/fastSearch/SearchInputV2;", "authHeader", "deviceID", "isFilterApplied", "getNetworkState", "getScrollSearchListToTop", "getVehicleLiveData", "getVehicleTotalCount", "initializePagingV2", "loadFastSearchListV2", "fastSearchRequestBody", "updateVehicleCountOnly", "onCleared", "updateLoadingIndicator", "status", "updateWatchStatus", "itemId", "userId", "action", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchViewModel.kt */
public final class FastSearchViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public final String TAG;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    @NotNull
    public DisposableObserver<FastSearchResponse> disposableObserver;
    private DisposableObserver<UpdateWatchListResponse> disposableObserverUpdateWatchStatus;
    private Executor executor;
    @NotNull
    private MutableLiveData<String> fastSearchListError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<FastSearchResponse> fastSearchListResult = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Integer> fastSearchResultCount = new MutableLiveData<>();
    private LiveData<NetworkState> networkState;
    private LiveData<List<Refiner>> refinerLiveData;
    private final FastSearchListRepository repository;
    private LiveData<Integer> scrollSearchListToTop;
    private SearchDataFactoryV2 searchDataFactoryV2;
    @NotNull
    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();
    private LiveData<PagedList<Vehicle>> vehicleLiveData;
    private LiveData<Integer> vehicleTotalCount;
    private final WatchRepository watchRepository;
    @NotNull
    private MutableLiveData<String> watchStatusError;
    @NotNull
    private MutableLiveData<UpdateWatchListResponse> watchStatusResponse;

    @Inject
    public FastSearchViewModel(@NotNull FastSearchListRepository fastSearchListRepository, @NotNull WatchRepository watchRepository2) {
        Intrinsics.checkParameterIsNotNull(fastSearchListRepository, "repository");
        Intrinsics.checkParameterIsNotNull(watchRepository2, "watchRepository");
        this.repository = fastSearchListRepository;
        this.watchRepository = watchRepository2;
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        Intrinsics.checkExpressionValueIsNotNull(newFixedThreadPool, "Executors.newFixedThreadPool(5)");
        this.executor = newFixedThreadPool;
        this.watchStatusResponse = new MutableLiveData<>();
        this.watchStatusError = new MutableLiveData<>();
        this.TAG = FastSearchViewModel.class.getSimpleName();
    }

    @NotNull
    public final MutableLiveData<FastSearchResponse> getFastSearchListResult() {
        return this.fastSearchListResult;
    }

    public final void setFastSearchListResult(@NotNull MutableLiveData<FastSearchResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.fastSearchListResult = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<Integer> getFastSearchResultCount() {
        return this.fastSearchResultCount;
    }

    public final void setFastSearchResultCount(@NotNull MutableLiveData<Integer> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.fastSearchResultCount = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getFastSearchListError() {
        return this.fastSearchListError;
    }

    public final void setFastSearchListError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.fastSearchListError = mutableLiveData;
    }

    @NotNull
    public final DisposableObserver<FastSearchResponse> getDisposableObserver() {
        DisposableObserver<FastSearchResponse> disposableObserver2 = this.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        return disposableObserver2;
    }

    public final void setDisposableObserver(@NotNull DisposableObserver<FastSearchResponse> disposableObserver2) {
        Intrinsics.checkParameterIsNotNull(disposableObserver2, "<set-?>");
        this.disposableObserver = disposableObserver2;
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
    public final MutableLiveData<UpdateWatchListResponse> getWatchStatusResponse() {
        return this.watchStatusResponse;
    }

    public final void setWatchStatusResponse(@NotNull MutableLiveData<UpdateWatchListResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.watchStatusResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getWatchStatusError() {
        return this.watchStatusError;
    }

    public final void setWatchStatusError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.watchStatusError = mutableLiveData;
    }

    public final void updateLoadingIndicator(boolean z) {
        this.showLoading.postValue(Boolean.valueOf(z));
    }

    public final void loadFastSearchListV2(@NotNull String str, @NotNull String str2, @NotNull SearchInputV2 searchInputV2, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "deviceID");
        Intrinsics.checkParameterIsNotNull(searchInputV2, "fastSearchRequestBody");
        if (!z) {
            updateLoadingIndicator(true);
        }
        this.disposableObserver = new FastSearchViewModel$loadFastSearchListV2$1(this, z);
        Observable<FastSearchResponse> observeOn = this.repository.getFastSearchListV2(str, str2, searchInputV2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<FastSearchResponse> disposableObserver2 = this.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        observeOn.subscribe((Observer<? super FastSearchResponse>) disposableObserver2);
    }

    public final void fetchSearchResultListV2(@NotNull SearchInputV2 searchInputV2, @NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.checkParameterIsNotNull(searchInputV2, "requestBody");
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "deviceID");
        this.searchDataFactoryV2 = new SearchDataFactoryV2(this.repository, this.compositeDisposable, searchInputV2, str, str2, z);
        initializePagingV2();
    }

    public final void updateWatchStatus(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, Constants.EXTRA_ITEM_ID);
        Intrinsics.checkParameterIsNotNull(str3, "userId");
        Intrinsics.checkParameterIsNotNull(str4, "action");
        WatchStatusQueryModel watchStatusQueryModel = new WatchStatusQueryModel();
        watchStatusQueryModel.setCulturecode$app_productionRelease(Utils.getLanguage());
        watchStatusQueryModel.setDevicetype$app_productionRelease("android");
        watchStatusQueryModel.setUserId$app_productionRelease(str3);
        watchStatusQueryModel.setItemId$app_productionRelease(str2);
        watchStatusQueryModel.setAuthorization$app_productionRelease(str);
        watchStatusQueryModel.setAction$app_productionRelease(str4);
        this.disposableObserverUpdateWatchStatus = new FastSearchViewModel$updateWatchStatus$1(this, new Gson().toJson((Object) watchStatusQueryModel));
        Observable<UpdateWatchListResponse> observeOn = this.watchRepository.updateWatchStatus(str, str2, str3, str4).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<UpdateWatchListResponse> disposableObserver2 = this.disposableObserverUpdateWatchStatus;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverUpdateWatchStatus");
        }
        observeOn.subscribe((Observer<? super UpdateWatchListResponse>) disposableObserver2);
    }

    @NotNull
    public final LiveData<PagedList<Vehicle>> getVehicleLiveData() {
        LiveData<PagedList<Vehicle>> liveData = this.vehicleLiveData;
        if (liveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vehicleLiveData");
        }
        return liveData;
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
    public final LiveData<Integer> getVehicleTotalCount() {
        LiveData<Integer> liveData = this.vehicleTotalCount;
        if (liveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vehicleTotalCount");
        }
        return liveData;
    }

    @NotNull
    public final LiveData<Integer> getScrollSearchListToTop() {
        LiveData<Integer> liveData = this.scrollSearchListToTop;
        if (liveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollSearchListToTop");
        }
        return liveData;
    }

    private final void initializePagingV2() {
        PagedList.Config build = new PagedList.Config.Builder().setEnablePlaceholders(false).setInitialLoadSizeHint(100).setPageSize(100).build();
        SearchDataFactoryV2 searchDataFactoryV22 = this.searchDataFactoryV2;
        if (searchDataFactoryV22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchDataFactoryV2");
        }
        LiveData<PagedList<Vehicle>> build2 = new LivePagedListBuilder(searchDataFactoryV22, build).setFetchExecutor(this.executor).build();
        if (build2 != null) {
            this.vehicleLiveData = build2;
            SearchDataFactoryV2 searchDataFactoryV23 = this.searchDataFactoryV2;
            if (searchDataFactoryV23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchDataFactoryV2");
            }
            LiveData<NetworkState> switchMap = Transformations.switchMap(searchDataFactoryV23.getMutableLiveData(), new FastSearchViewModel$initializePagingV2$1());
            Intrinsics.checkExpressionValueIsNotNull(switchMap, "Transformations.switchMa…     }\n                })");
            this.networkState = switchMap;
            SearchDataFactoryV2 searchDataFactoryV24 = this.searchDataFactoryV2;
            if (searchDataFactoryV24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchDataFactoryV2");
            }
            LiveData<Integer> switchMap2 = Transformations.switchMap(searchDataFactoryV24.getMutableLiveData(), new FastSearchViewModel$initializePagingV2$2());
            Intrinsics.checkExpressionValueIsNotNull(switchMap2, "Transformations.switchMa…     }\n                })");
            this.vehicleTotalCount = switchMap2;
            SearchDataFactoryV2 searchDataFactoryV25 = this.searchDataFactoryV2;
            if (searchDataFactoryV25 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchDataFactoryV2");
            }
            LiveData<Integer> switchMap3 = Transformations.switchMap(searchDataFactoryV25.getMutableLiveData(), new FastSearchViewModel$initializePagingV2$3());
            Intrinsics.checkExpressionValueIsNotNull(switchMap3, "Transformations.switchMa…     }\n                })");
            this.scrollSearchListToTop = switchMap3;
            SearchDataFactoryV2 searchDataFactoryV26 = this.searchDataFactoryV2;
            if (searchDataFactoryV26 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchDataFactoryV2");
            }
            LiveData<List<Refiner>> switchMap4 = Transformations.switchMap(searchDataFactoryV26.getMutableLiveData(), new FastSearchViewModel$initializePagingV2$4());
            Intrinsics.checkExpressionValueIsNotNull(switchMap4, "Transformations.switchMa…     }\n                })");
            this.refinerLiveData = switchMap4;
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LiveData<androidx.paging.PagedList<com.iaai.android.bdt.model.fastSearch.Vehicle>>");
    }

    public final void disposeElements() {
        if (this.disposableObserver != null) {
            DisposableObserver<FastSearchResponse> disposableObserver2 = this.disposableObserver;
            if (disposableObserver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
            }
            if (!disposableObserver2.isDisposed()) {
                DisposableObserver<FastSearchResponse> disposableObserver3 = this.disposableObserver;
                if (disposableObserver3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
                }
                disposableObserver3.dispose();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        this.compositeDisposable.clear();
        if (this.disposableObserver != null) {
            DisposableObserver<FastSearchResponse> disposableObserver2 = this.disposableObserver;
            if (disposableObserver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
            }
            if (!disposableObserver2.isDisposed()) {
                DisposableObserver<FastSearchResponse> disposableObserver3 = this.disposableObserver;
                if (disposableObserver3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
                }
                disposableObserver3.dispose();
            }
        }
    }
}
