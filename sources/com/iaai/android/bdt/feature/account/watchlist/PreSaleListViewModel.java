package com.iaai.android.bdt.feature.account.watchlist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.google.gson.Gson;
import com.iaai.android.bdt.feature.account.watchlist.datasource.PreSaleListDataFactory;
import com.iaai.android.bdt.feature.watchList.WatchRepository;
import com.iaai.android.bdt.model.MyAccount.VehicleReceiptPDFResponse;
import com.iaai.android.bdt.model.MyAccount.WatchListModel;
import com.iaai.android.bdt.model.MyAccount.WatchListResponse;
import com.iaai.android.bdt.model.firebaseevent.WatchStatusQueryModel;
import com.iaai.android.bdt.model.profile.UpdateWatchListResponse;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.NetworkState;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.utils.constants.Constants;
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

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010A\u001a\u00020BJF\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020,2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020,2\u0006\u0010L\u001a\u00020\bJ\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001cJ\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001cJ\u0012\u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\u001cJ\f\u0010P\u001a\b\u0012\u0004\u0012\u00020,0\u001cJ\b\u0010Q\u001a\u00020BH\u0002J.\u0010R\u001a\u00020B2\u0006\u0010S\u001a\u00020\b2\u0006\u0010T\u001a\u00020\b2\u0006\u0010U\u001a\u00020\b2\u0006\u0010V\u001a\u00020\b2\u0006\u0010W\u001a\u00020\bJN\u0010X\u001a\u00020B2\u0006\u0010Y\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b2\u0006\u0010H\u001a\u00020I2\u0006\u0010Z\u001a\u00020,2\u0006\u0010G\u001a\u00020,2\u0006\u0010F\u001a\u00020\b2\u0006\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020,2\u0006\u0010L\u001a\u00020\bJ\b\u0010[\u001a\u00020BH\u0014J&\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u00020\b2\u0006\u0010^\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b2\u0006\u0010_\u001a\u00020\bR\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\rX.¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001cX.¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001cX.¢\u0006\u0002\n\u0000R \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00160 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010%\u001a\b\u0012\u0004\u0012\u00020\b0 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\u001cX.¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u001cX.¢\u0006\u0002\n\u0000R \u0010-\u001a\b\u0012\u0004\u0012\u00020\b0 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\"\"\u0004\b/\u0010$R \u00100\u001a\b\u0012\u0004\u0012\u00020\u000e0 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\"\"\u0004\b2\u0010$R \u00103\u001a\b\u0012\u0004\u0012\u00020\b0 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\"\"\u0004\b5\u0010$R \u00106\u001a\b\u0012\u0004\u0012\u00020\u000e0 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\"\"\u0004\b8\u0010$R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R \u00109\u001a\b\u0012\u0004\u0012\u00020\b0 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\"\"\u0004\b;\u0010$R \u0010<\u001a\b\u0012\u0004\u0012\u00020\u00140 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\"\"\u0004\b>\u0010$R\u000e\u0010?\u001a\u00020@X.¢\u0006\u0002\n\u0000¨\u0006`"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListRepository;", "watchRepository", "Lcom/iaai/android/bdt/feature/watchList/WatchRepository;", "(Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListRepository;Lcom/iaai/android/bdt/feature/watchList/WatchRepository;)V", "TAG", "", "kotlin.jvm.PlatformType", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "disposableObserver", "Lio/reactivex/observers/DisposableObserver;", "Lcom/iaai/android/bdt/model/MyAccount/WatchListResponse;", "getDisposableObserver", "()Lio/reactivex/observers/DisposableObserver;", "setDisposableObserver", "(Lio/reactivex/observers/DisposableObserver;)V", "disposableObserverUpdateWatchStatus", "Lcom/iaai/android/bdt/model/profile/UpdateWatchListResponse;", "disposableReceiptPDFResult", "Lcom/iaai/android/bdt/model/MyAccount/VehicleReceiptPDFResponse;", "getDisposableReceiptPDFResult", "setDisposableReceiptPDFResult", "executor", "Ljava/util/concurrent/Executor;", "getPreSaleListResponse", "Landroidx/lifecycle/LiveData;", "networkState", "Lcom/iaai/android/bdt/utils/NetworkState;", "receiptPDFResult", "Landroidx/lifecycle/MutableLiveData;", "getReceiptPDFResult", "()Landroidx/lifecycle/MutableLiveData;", "setReceiptPDFResult", "(Landroidx/lifecycle/MutableLiveData;)V", "receiptPDFResultError", "getReceiptPDFResultError", "setReceiptPDFResultError", "resultLiveData", "Landroidx/paging/PagedList;", "Lcom/iaai/android/bdt/model/MyAccount/WatchListModel;", "scrollSearchListToTop", "", "swipedProductListError", "getSwipedProductListError", "setSwipedProductListError", "swipedProductListResult", "getSwipedProductListResult", "setSwipedProductListResult", "watchListError", "getWatchListError", "setWatchListError", "watchListResult", "getWatchListResult", "setWatchListResult", "watchStatusError", "getWatchStatusError", "setWatchStatusError", "watchStatusResponse", "getWatchStatusResponse", "setWatchStatusResponse", "watchingListDataFactory", "Lcom/iaai/android/bdt/feature/account/watchlist/datasource/PreSaleListDataFactory;", "disposeElements", "", "fetchWatchingList", "authorizationHeader", "userId", "status", "startIndex", "onlymyitems", "", "sortBy", "sortDirection", "keyword", "getNetworkState", "getPreSalesListResponse", "getResultLiveData", "getScrollSearchListToTop", "initializePaging", "loadReceiptPDF", "username", "password", "receiptnumber", "receipttype", "salvageid", "loadSwipedProductList", "authenticationHeader", "lbsParentID", "onCleared", "updateWatchStatus", "authHeader", "itemId", "action", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PreSaleListViewModel.kt */
public final class PreSaleListViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public final String TAG;
    private final CompositeDisposable compositeDisposable;
    @NotNull
    public DisposableObserver<WatchListResponse> disposableObserver;
    private DisposableObserver<UpdateWatchListResponse> disposableObserverUpdateWatchStatus;
    @NotNull
    public DisposableObserver<VehicleReceiptPDFResponse> disposableReceiptPDFResult;
    private Executor executor;
    private LiveData<WatchListResponse> getPreSaleListResponse;
    private LiveData<NetworkState> networkState;
    @NotNull
    private MutableLiveData<VehicleReceiptPDFResponse> receiptPDFResult = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<String> receiptPDFResultError = new MutableLiveData<>();
    private final PreSaleListRepository repository;
    private LiveData<PagedList<WatchListModel>> resultLiveData;
    private LiveData<Integer> scrollSearchListToTop;
    @NotNull
    private MutableLiveData<String> swipedProductListError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WatchListResponse> swipedProductListResult = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<String> watchListError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WatchListResponse> watchListResult = new MutableLiveData<>();
    private final WatchRepository watchRepository;
    @NotNull
    private MutableLiveData<String> watchStatusError;
    @NotNull
    private MutableLiveData<UpdateWatchListResponse> watchStatusResponse;
    private PreSaleListDataFactory watchingListDataFactory;

    @Inject
    public PreSaleListViewModel(@NotNull PreSaleListRepository preSaleListRepository, @NotNull WatchRepository watchRepository2) {
        Intrinsics.checkParameterIsNotNull(preSaleListRepository, "repository");
        Intrinsics.checkParameterIsNotNull(watchRepository2, "watchRepository");
        this.repository = preSaleListRepository;
        this.watchRepository = watchRepository2;
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        Intrinsics.checkExpressionValueIsNotNull(newFixedThreadPool, "Executors.newFixedThreadPool(5)");
        this.executor = newFixedThreadPool;
        this.compositeDisposable = new CompositeDisposable();
        this.watchStatusResponse = new MutableLiveData<>();
        this.watchStatusError = new MutableLiveData<>();
        this.TAG = PreSaleListViewModel.class.getSimpleName();
    }

    @NotNull
    public final MutableLiveData<WatchListResponse> getWatchListResult() {
        return this.watchListResult;
    }

    public final void setWatchListResult(@NotNull MutableLiveData<WatchListResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.watchListResult = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getWatchListError() {
        return this.watchListError;
    }

    public final void setWatchListError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.watchListError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<WatchListResponse> getSwipedProductListResult() {
        return this.swipedProductListResult;
    }

    public final void setSwipedProductListResult(@NotNull MutableLiveData<WatchListResponse> mutableLiveData) {
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
    public final DisposableObserver<WatchListResponse> getDisposableObserver() {
        DisposableObserver<WatchListResponse> disposableObserver2 = this.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        return disposableObserver2;
    }

    public final void setDisposableObserver(@NotNull DisposableObserver<WatchListResponse> disposableObserver2) {
        Intrinsics.checkParameterIsNotNull(disposableObserver2, "<set-?>");
        this.disposableObserver = disposableObserver2;
    }

    @NotNull
    public final MutableLiveData<VehicleReceiptPDFResponse> getReceiptPDFResult() {
        return this.receiptPDFResult;
    }

    public final void setReceiptPDFResult(@NotNull MutableLiveData<VehicleReceiptPDFResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.receiptPDFResult = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getReceiptPDFResultError() {
        return this.receiptPDFResultError;
    }

    public final void setReceiptPDFResultError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.receiptPDFResultError = mutableLiveData;
    }

    @NotNull
    public final DisposableObserver<VehicleReceiptPDFResponse> getDisposableReceiptPDFResult() {
        DisposableObserver<VehicleReceiptPDFResponse> disposableObserver2 = this.disposableReceiptPDFResult;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableReceiptPDFResult");
        }
        return disposableObserver2;
    }

    public final void setDisposableReceiptPDFResult(@NotNull DisposableObserver<VehicleReceiptPDFResponse> disposableObserver2) {
        Intrinsics.checkParameterIsNotNull(disposableObserver2, "<set-?>");
        this.disposableReceiptPDFResult = disposableObserver2;
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

    public final void fetchWatchingList(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, boolean z, @NotNull String str4, int i2, @NotNull String str5) {
        Intrinsics.checkParameterIsNotNull(str, "authorizationHeader");
        Intrinsics.checkParameterIsNotNull(str2, "userId");
        String str6 = str3;
        Intrinsics.checkParameterIsNotNull(str6, "status");
        String str7 = str4;
        Intrinsics.checkParameterIsNotNull(str7, Constants_MVVM.EXTRA_SORT_BY);
        String str8 = str5;
        Intrinsics.checkParameterIsNotNull(str8, "keyword");
        this.watchingListDataFactory = new PreSaleListDataFactory(this.repository, this.compositeDisposable, str, str2, str6, Integer.valueOf(i), Boolean.valueOf(z), str7, Integer.valueOf(i2), str8);
        initializePaging();
    }

    public final void disposeElements() {
        PreSaleListViewModel preSaleListViewModel = this;
        if (preSaleListViewModel.disposableObserver != null) {
            DisposableObserver<WatchListResponse> disposableObserver2 = this.disposableObserver;
            if (disposableObserver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
            }
            if (!disposableObserver2.isDisposed()) {
                DisposableObserver<WatchListResponse> disposableObserver3 = this.disposableObserver;
                if (disposableObserver3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
                }
                disposableObserver3.dispose();
            }
        }
        if (preSaleListViewModel.disposableReceiptPDFResult != null) {
            DisposableObserver<VehicleReceiptPDFResponse> disposableObserver4 = this.disposableReceiptPDFResult;
            if (disposableObserver4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableReceiptPDFResult");
            }
            if (!disposableObserver4.isDisposed()) {
                DisposableObserver<VehicleReceiptPDFResponse> disposableObserver5 = this.disposableReceiptPDFResult;
                if (disposableObserver5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableReceiptPDFResult");
                }
                disposableObserver5.dispose();
            }
        }
    }

    @NotNull
    public final LiveData<Integer> getScrollSearchListToTop() {
        LiveData<Integer> liveData = this.scrollSearchListToTop;
        if (liveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollSearchListToTop");
        }
        return liveData;
    }

    @NotNull
    public final LiveData<WatchListResponse> getPreSalesListResponse() {
        LiveData<WatchListResponse> liveData = this.getPreSaleListResponse;
        if (liveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("getPreSaleListResponse");
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
    public final LiveData<PagedList<WatchListModel>> getResultLiveData() {
        LiveData<PagedList<WatchListModel>> liveData = this.resultLiveData;
        if (liveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultLiveData");
        }
        return liveData;
    }

    private final void initializePaging() {
        PagedList.Config build = new PagedList.Config.Builder().setEnablePlaceholders(false).setInitialLoadSizeHint(30).setPageSize(30).build();
        PreSaleListDataFactory preSaleListDataFactory = this.watchingListDataFactory;
        if (preSaleListDataFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("watchingListDataFactory");
        }
        LiveData<PagedList<WatchListModel>> build2 = new LivePagedListBuilder(preSaleListDataFactory, build).setFetchExecutor(this.executor).build();
        if (build2 != null) {
            this.resultLiveData = build2;
            PreSaleListDataFactory preSaleListDataFactory2 = this.watchingListDataFactory;
            if (preSaleListDataFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("watchingListDataFactory");
            }
            LiveData<Integer> switchMap = Transformations.switchMap(preSaleListDataFactory2.getMutableLiveData(), new PreSaleListViewModel$initializePaging$1());
            Intrinsics.checkExpressionValueIsNotNull(switchMap, "Transformations.switchMa…     }\n                })");
            this.scrollSearchListToTop = switchMap;
            PreSaleListDataFactory preSaleListDataFactory3 = this.watchingListDataFactory;
            if (preSaleListDataFactory3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("watchingListDataFactory");
            }
            LiveData<WatchListResponse> switchMap2 = Transformations.switchMap(preSaleListDataFactory3.getMutableLiveData(), new PreSaleListViewModel$initializePaging$2());
            Intrinsics.checkExpressionValueIsNotNull(switchMap2, "Transformations.switchMa…     }\n                })");
            this.getPreSaleListResponse = switchMap2;
            PreSaleListDataFactory preSaleListDataFactory4 = this.watchingListDataFactory;
            if (preSaleListDataFactory4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("watchingListDataFactory");
            }
            LiveData<NetworkState> switchMap3 = Transformations.switchMap(preSaleListDataFactory4.getMutableLiveData(), new PreSaleListViewModel$initializePaging$3());
            Intrinsics.checkExpressionValueIsNotNull(switchMap3, "Transformations.switchMa…     }\n                })");
            this.networkState = switchMap3;
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LiveData<androidx.paging.PagedList<com.iaai.android.bdt.model.MyAccount.WatchListModel>>");
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        this.compositeDisposable.clear();
        PreSaleListViewModel preSaleListViewModel = this;
        if (preSaleListViewModel.disposableObserver != null) {
            DisposableObserver<WatchListResponse> disposableObserver2 = this.disposableObserver;
            if (disposableObserver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
            }
            if (!disposableObserver2.isDisposed()) {
                DisposableObserver<WatchListResponse> disposableObserver3 = this.disposableObserver;
                if (disposableObserver3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
                }
                disposableObserver3.dispose();
            }
        }
        if (preSaleListViewModel.disposableReceiptPDFResult != null) {
            DisposableObserver<VehicleReceiptPDFResponse> disposableObserver4 = this.disposableReceiptPDFResult;
            if (disposableObserver4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableReceiptPDFResult");
            }
            if (!disposableObserver4.isDisposed()) {
                DisposableObserver<VehicleReceiptPDFResponse> disposableObserver5 = this.disposableReceiptPDFResult;
                if (disposableObserver5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableReceiptPDFResult");
                }
                disposableObserver5.dispose();
            }
        }
    }

    public final void loadSwipedProductList(@NotNull String str, @NotNull String str2, boolean z, int i, int i2, @NotNull String str3, @NotNull String str4, int i3, @NotNull String str5) {
        Intrinsics.checkParameterIsNotNull(str, "authenticationHeader");
        Intrinsics.checkParameterIsNotNull(str2, "userId");
        String str6 = str3;
        Intrinsics.checkParameterIsNotNull(str6, "status");
        String str7 = str4;
        Intrinsics.checkParameterIsNotNull(str7, Constants_MVVM.EXTRA_SORT_BY);
        String str8 = str5;
        Intrinsics.checkParameterIsNotNull(str8, "keyword");
        this.disposableObserver = new PreSaleListViewModel$loadSwipedProductList$1(this);
        Observable<WatchListResponse> observeOn = this.repository.getList(str, str2, z, i, i2, str6, str7, i3, str8).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<WatchListResponse> disposableObserver2 = this.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        observeOn.subscribe((Observer<? super WatchListResponse>) disposableObserver2);
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
        this.disposableObserverUpdateWatchStatus = new PreSaleListViewModel$updateWatchStatus$1(this, new Gson().toJson((Object) watchStatusQueryModel));
        Observable<UpdateWatchListResponse> observeOn = this.watchRepository.updateWatchStatus(str, str2, str3, str4).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<UpdateWatchListResponse> disposableObserver2 = this.disposableObserverUpdateWatchStatus;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverUpdateWatchStatus");
        }
        observeOn.subscribe((Observer<? super UpdateWatchListResponse>) disposableObserver2);
    }

    public final void loadReceiptPDF(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkParameterIsNotNull(str, "username");
        Intrinsics.checkParameterIsNotNull(str2, "password");
        Intrinsics.checkParameterIsNotNull(str3, "receiptnumber");
        Intrinsics.checkParameterIsNotNull(str4, "receipttype");
        Intrinsics.checkParameterIsNotNull(str5, "salvageid");
        this.disposableReceiptPDFResult = new PreSaleListViewModel$loadReceiptPDF$1(this);
        Observable<VehicleReceiptPDFResponse> observeOn = this.repository.getVehicleReceipt(str, str2, str3, str4, str5).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<VehicleReceiptPDFResponse> disposableObserver2 = this.disposableReceiptPDFResult;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableReceiptPDFResult");
        }
        observeOn.subscribe((Observer<? super VehicleReceiptPDFResponse>) disposableObserver2);
    }
}
