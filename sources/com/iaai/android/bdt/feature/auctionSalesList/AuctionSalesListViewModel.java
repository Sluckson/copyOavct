package com.iaai.android.bdt.feature.auctionSalesList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.google.gson.Gson;
import com.iaai.android.bdt.feature.auctionSalesList.dataSource.AuctionSaleDataFactory;
import com.iaai.android.bdt.feature.watchList.WatchRepository;
import com.iaai.android.bdt.model.auctionSalesList.AuctionSaleList;
import com.iaai.android.bdt.model.auctionSalesList.AuctionSalesListResponse;
import com.iaai.android.bdt.model.auctionSalesList.RequestBody;
import com.iaai.android.bdt.model.auctionSalesList.ResultData;
import com.iaai.android.bdt.model.firebaseevent.WatchStatusQueryModel;
import com.iaai.android.bdt.model.profile.UpdateWatchListResponse;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.NetworkState;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.utils.DateHelper;
import com.iaai.android.old.utils.constants.Constants;
import java.util.Date;
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

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u00106\u001a\u000207J\u001e\u00108\u001a\u0002072\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020=J\f\u0010>\u001a\b\u0012\u0004\u0012\u00020$0#J\u0018\u0010?\u001a\u00020:2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020BH\u0002J\u0012\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0&0#J\f\u0010D\u001a\b\u0012\u0004\u0012\u00020)0#J\b\u0010E\u001a\u000207H\u0002J\u001e\u0010F\u001a\u0002072\u0006\u0010G\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b2\u0006\u0010H\u001a\u00020BJ\u000e\u0010I\u001a\u0002072\u0006\u0010J\u001a\u00020:J\b\u0010K\u001a\u000207H\u0014J&\u0010L\u001a\u0002072\u0006\u0010G\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\bR\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0&0#X.¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0#X.¢\u0006\u0002\n\u0000R \u0010*\u001a\b\u0012\u0004\u0012\u00020\b0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011R \u0010-\u001a\b\u0012\u0004\u0012\u00020\u00130\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R \u00100\u001a\b\u0012\u0004\u0012\u00020\b0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010\u0011R \u00103\u001a\b\u0012\u0004\u0012\u00020\u001f0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u000f\"\u0004\b5\u0010\u0011¨\u0006P"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionSalesList/AuctionSalesListViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/iaai/android/bdt/feature/auctionSalesList/AuctionSalesListRepository;", "watchRepository", "Lcom/iaai/android/bdt/feature/watchList/WatchRepository;", "(Lcom/iaai/android/bdt/feature/auctionSalesList/AuctionSalesListRepository;Lcom/iaai/android/bdt/feature/watchList/WatchRepository;)V", "TAG", "", "kotlin.jvm.PlatformType", "auctionSaleDataFactory", "Lcom/iaai/android/bdt/feature/auctionSalesList/dataSource/AuctionSaleDataFactory;", "auctionSalesError", "Landroidx/lifecycle/MutableLiveData;", "getAuctionSalesError", "()Landroidx/lifecycle/MutableLiveData;", "setAuctionSalesError", "(Landroidx/lifecycle/MutableLiveData;)V", "auctionSalesResult", "Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListResponse;", "getAuctionSalesResult", "setAuctionSalesResult", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "disposableObserver", "Lio/reactivex/observers/DisposableObserver;", "getDisposableObserver", "()Lio/reactivex/observers/DisposableObserver;", "setDisposableObserver", "(Lio/reactivex/observers/DisposableObserver;)V", "disposableObserverUpdateWatchStatus", "Lcom/iaai/android/bdt/model/profile/UpdateWatchListResponse;", "executor", "Ljava/util/concurrent/Executor;", "networkState", "Landroidx/lifecycle/LiveData;", "Lcom/iaai/android/bdt/utils/NetworkState;", "resultLiveData", "Landroidx/paging/PagedList;", "Lcom/iaai/android/bdt/model/auctionSalesList/ResultData;", "scrollSearchListToTop", "", "swipedProductListError", "getSwipedProductListError", "setSwipedProductListError", "swipedProductListResult", "getSwipedProductListResult", "setSwipedProductListResult", "watchStatusError", "getWatchStatusError", "setWatchStatusError", "watchStatusResponse", "getWatchStatusResponse", "setWatchStatusResponse", "disposeElements", "", "fetchAuctionSalesList", "requestBody", "Lcom/iaai/android/bdt/model/auctionSalesList/RequestBody;", "authorizationHeader", "isFilterApplied", "", "getNetworkState", "getRequestBody", "branchId", "date", "Ljava/util/Date;", "getResultLiveData", "getScrollSearchListToTop", "initializePaging", "loadAuctionSalesList", "authHeader", "liveDate", "loadSwipedProductList", "body", "onCleared", "updateWatchStatus", "itemId", "userId", "action", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionSalesListViewModel.kt */
public final class AuctionSalesListViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public final String TAG;
    private AuctionSaleDataFactory auctionSaleDataFactory;
    @NotNull
    private MutableLiveData<String> auctionSalesError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<AuctionSalesListResponse> auctionSalesResult = new MutableLiveData<>();
    private final CompositeDisposable compositeDisposable;
    @NotNull
    public DisposableObserver<AuctionSalesListResponse> disposableObserver;
    private DisposableObserver<UpdateWatchListResponse> disposableObserverUpdateWatchStatus;
    private Executor executor;
    private LiveData<NetworkState> networkState;
    private final AuctionSalesListRepository repository;
    private LiveData<PagedList<ResultData>> resultLiveData;
    private LiveData<Integer> scrollSearchListToTop;
    @NotNull
    private MutableLiveData<String> swipedProductListError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<AuctionSalesListResponse> swipedProductListResult = new MutableLiveData<>();
    private final WatchRepository watchRepository;
    @NotNull
    private MutableLiveData<String> watchStatusError;
    @NotNull
    private MutableLiveData<UpdateWatchListResponse> watchStatusResponse;

    @Inject
    public AuctionSalesListViewModel(@NotNull AuctionSalesListRepository auctionSalesListRepository, @NotNull WatchRepository watchRepository2) {
        Intrinsics.checkParameterIsNotNull(auctionSalesListRepository, "repository");
        Intrinsics.checkParameterIsNotNull(watchRepository2, "watchRepository");
        this.repository = auctionSalesListRepository;
        this.watchRepository = watchRepository2;
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        Intrinsics.checkExpressionValueIsNotNull(newFixedThreadPool, "Executors.newFixedThreadPool(5)");
        this.executor = newFixedThreadPool;
        this.compositeDisposable = new CompositeDisposable();
        this.watchStatusResponse = new MutableLiveData<>();
        this.watchStatusError = new MutableLiveData<>();
        this.TAG = AuctionSalesListViewModel.class.getSimpleName();
    }

    @NotNull
    public final MutableLiveData<AuctionSalesListResponse> getAuctionSalesResult() {
        return this.auctionSalesResult;
    }

    public final void setAuctionSalesResult(@NotNull MutableLiveData<AuctionSalesListResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.auctionSalesResult = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getAuctionSalesError() {
        return this.auctionSalesError;
    }

    public final void setAuctionSalesError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.auctionSalesError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<AuctionSalesListResponse> getSwipedProductListResult() {
        return this.swipedProductListResult;
    }

    public final void setSwipedProductListResult(@NotNull MutableLiveData<AuctionSalesListResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.swipedProductListResult = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getSwipedProductListError() {
        return this.swipedProductListError;
    }

    public final void setSwipedProductListError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.swipedProductListError = mutableLiveData;
    }

    @NotNull
    public final DisposableObserver<AuctionSalesListResponse> getDisposableObserver() {
        DisposableObserver<AuctionSalesListResponse> disposableObserver2 = this.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        return disposableObserver2;
    }

    public final void setDisposableObserver(@NotNull DisposableObserver<AuctionSalesListResponse> disposableObserver2) {
        Intrinsics.checkParameterIsNotNull(disposableObserver2, "<set-?>");
        this.disposableObserver = disposableObserver2;
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

    public final void loadAuctionSalesList(@NotNull String str, @NotNull String str2, @NotNull Date date) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, Constants_MVVM.EXTRA_BRANCH_ID);
        Intrinsics.checkParameterIsNotNull(date, "liveDate");
        this.disposableObserver = new AuctionSalesListViewModel$loadAuctionSalesList$1(this, date, str2);
        Observable<AuctionSalesListResponse> observeOn = this.repository.getAuctionSalesList(str, str2, date).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<AuctionSalesListResponse> disposableObserver2 = this.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        observeOn.subscribe((Observer<? super AuctionSalesListResponse>) disposableObserver2);
    }

    public final void fetchAuctionSalesList(@NotNull RequestBody requestBody, @NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(requestBody, "requestBody");
        Intrinsics.checkParameterIsNotNull(str, "authorizationHeader");
        this.auctionSaleDataFactory = new AuctionSaleDataFactory(this.repository, this.compositeDisposable, requestBody, str, z);
        initializePaging();
    }

    public final void disposeElements() {
        if (this.disposableObserver != null) {
            DisposableObserver<AuctionSalesListResponse> disposableObserver2 = this.disposableObserver;
            if (disposableObserver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
            }
            if (!disposableObserver2.isDisposed()) {
                DisposableObserver<AuctionSalesListResponse> disposableObserver3 = this.disposableObserver;
                if (disposableObserver3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
                }
                disposableObserver3.dispose();
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
    public final LiveData<PagedList<ResultData>> getResultLiveData() {
        LiveData<PagedList<ResultData>> liveData = this.resultLiveData;
        if (liveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultLiveData");
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

    private final void initializePaging() {
        PagedList.Config build = new PagedList.Config.Builder().setEnablePlaceholders(false).setInitialLoadSizeHint(30).setPageSize(30).build();
        AuctionSaleDataFactory auctionSaleDataFactory2 = this.auctionSaleDataFactory;
        if (auctionSaleDataFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSaleDataFactory");
        }
        LiveData<PagedList<ResultData>> build2 = new LivePagedListBuilder(auctionSaleDataFactory2, build).setFetchExecutor(this.executor).build();
        if (build2 != null) {
            this.resultLiveData = build2;
            AuctionSaleDataFactory auctionSaleDataFactory3 = this.auctionSaleDataFactory;
            if (auctionSaleDataFactory3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("auctionSaleDataFactory");
            }
            LiveData<NetworkState> switchMap = Transformations.switchMap(auctionSaleDataFactory3.getMutableLiveData(), new AuctionSalesListViewModel$initializePaging$1());
            Intrinsics.checkExpressionValueIsNotNull(switchMap, "Transformations.switchMa…     }\n                })");
            this.networkState = switchMap;
            AuctionSaleDataFactory auctionSaleDataFactory4 = this.auctionSaleDataFactory;
            if (auctionSaleDataFactory4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("auctionSaleDataFactory");
            }
            LiveData<Integer> switchMap2 = Transformations.switchMap(auctionSaleDataFactory4.getMutableLiveData(), new AuctionSalesListViewModel$initializePaging$2());
            Intrinsics.checkExpressionValueIsNotNull(switchMap2, "Transformations.switchMa…     }\n                })");
            this.scrollSearchListToTop = switchMap2;
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LiveData<androidx.paging.PagedList<com.iaai.android.bdt.model.auctionSalesList.ResultData>>");
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        this.compositeDisposable.clear();
        if (this.disposableObserver != null) {
            DisposableObserver<AuctionSalesListResponse> disposableObserver2 = this.disposableObserver;
            if (disposableObserver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
            }
            if (!disposableObserver2.isDisposed()) {
                DisposableObserver<AuctionSalesListResponse> disposableObserver3 = this.disposableObserver;
                if (disposableObserver3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
                }
                disposableObserver3.dispose();
            }
        }
    }

    private final RequestBody getRequestBody(String str, Date date) {
        int parseInt = Integer.parseInt(str);
        String format = DateHelper.format(date, Constants.DATE_PATTERN_WEBSERVICE_PARAM);
        Intrinsics.checkExpressionValueIsNotNull(format, "wsDateString");
        String language = Utils.getLanguage();
        Intrinsics.checkExpressionValueIsNotNull(language, "Utils.getLanguage()");
        AuctionSaleList auctionSaleList = r0;
        AuctionSaleList auctionSaleList2 = new AuctionSaleList(format, parseInt, language, "android", "", "0", 30, "", "", 30, "", 1, "", "", "", "");
        return new RequestBody(auctionSaleList);
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
        this.disposableObserverUpdateWatchStatus = new AuctionSalesListViewModel$updateWatchStatus$1(this, new Gson().toJson((Object) watchStatusQueryModel));
        Observable<UpdateWatchListResponse> observeOn = this.watchRepository.updateWatchStatus(str, str2, str3, str4).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<UpdateWatchListResponse> disposableObserver2 = this.disposableObserverUpdateWatchStatus;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverUpdateWatchStatus");
        }
        observeOn.subscribe((Observer<? super UpdateWatchListResponse>) disposableObserver2);
    }

    public final void loadSwipedProductList(@NotNull RequestBody requestBody) {
        Intrinsics.checkParameterIsNotNull(requestBody, "body");
        this.disposableObserver = new AuctionSalesListViewModel$loadSwipedProductList$1(this, requestBody);
        Observable<AuctionSalesListResponse> observeOn = this.repository.getList(requestBody, "").subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<AuctionSalesListResponse> disposableObserver2 = this.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        observeOn.subscribe((Observer<? super AuctionSalesListResponse>) disposableObserver2);
    }
}
