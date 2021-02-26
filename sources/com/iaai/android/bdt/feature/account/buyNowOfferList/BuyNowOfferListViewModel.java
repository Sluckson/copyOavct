package com.iaai.android.bdt.feature.account.buyNowOfferList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.iaai.android.bdt.feature.account.buyNowOfferList.datasource.BuyNowOfferListDataFactory;
import com.iaai.android.bdt.model.MyAccount.BuyNowOfferListModel;
import com.iaai.android.bdt.model.MyAccount.BuyNowOfferListResponse;
import com.iaai.android.bdt.utils.NetworkState;
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

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u00103\u001a\u000204J\u0016\u00105\u001a\u0002042\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020,J\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00140\"J\f\u00109\u001a\b\u0012\u0004\u0012\u00020$0\"J\u0012\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\"J\f\u0010;\u001a\b\u0012\u0004\u0012\u00020,0\"J\b\u0010<\u001a\u000204H\u0002J\u0006\u0010=\u001a\u000204J\u0016\u0010>\u001a\u0002042\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020,J\b\u0010?\u001a\u000204H\u0014R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u001aX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\"X.¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\"X.¢\u0006\u0002\n\u0000R \u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u000b\"\u0004\b'\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\"X.¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\"X.¢\u0006\u0002\n\u0000R \u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000b\"\u0004\b/\u0010\rR \u00100\u001a\b\u0012\u0004\u0012\u00020\u00140\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000b\"\u0004\b2\u0010\r¨\u0006@"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/buyNowOfferList/BuyNowOfferListViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/iaai/android/bdt/feature/account/buyNowOfferList/BuyNowOfferListRepository;", "(Lcom/iaai/android/bdt/feature/account/buyNowOfferList/BuyNowOfferListRepository;)V", "TAG", "", "kotlin.jvm.PlatformType", "buyNowOfferCloseTime", "Landroidx/lifecycle/MutableLiveData;", "getBuyNowOfferCloseTime", "()Landroidx/lifecycle/MutableLiveData;", "setBuyNowOfferCloseTime", "(Landroidx/lifecycle/MutableLiveData;)V", "buyNowOfferListDataFactory", "Lcom/iaai/android/bdt/feature/account/buyNowOfferList/datasource/BuyNowOfferListDataFactory;", "buyNowOfferListError", "getBuyNowOfferListError", "setBuyNowOfferListError", "buyNowOfferListResponse", "Lcom/iaai/android/bdt/model/MyAccount/BuyNowOfferListResponse;", "getBuyNowOfferListResponse", "setBuyNowOfferListResponse", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "disposableObserver", "Lio/reactivex/observers/DisposableObserver;", "getDisposableObserver", "()Lio/reactivex/observers/DisposableObserver;", "setDisposableObserver", "(Lio/reactivex/observers/DisposableObserver;)V", "disposableObserverOfferCloseTime", "executor", "Ljava/util/concurrent/Executor;", "Landroidx/lifecycle/LiveData;", "networkState", "Lcom/iaai/android/bdt/utils/NetworkState;", "offerError", "getOfferError", "setOfferError", "resultLiveData", "Landroidx/paging/PagedList;", "Lcom/iaai/android/bdt/model/MyAccount/BuyNowOfferListModel;", "scrollSearchListToTop", "", "swipedProductListError", "getSwipedProductListError", "setSwipedProductListError", "swipedProductListResult", "getSwipedProductListResult", "setSwipedProductListResult", "disposeElements", "", "fetchBuyNowOfferList", "userId", "startIndex", "getBuyNowListResponse", "getNetworkState", "getResultLiveData", "getScrollSearchListToTop", "initializePaging", "loadBuyNowOfferCloseTime", "loadSwipedProductList", "onCleared", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BuyNowOfferListViewModel.kt */
public final class BuyNowOfferListViewModel extends ViewModel {
    private final String TAG;
    @NotNull
    private MutableLiveData<String> buyNowOfferCloseTime;
    private BuyNowOfferListDataFactory buyNowOfferListDataFactory;
    @NotNull
    private MutableLiveData<String> buyNowOfferListError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<BuyNowOfferListResponse> buyNowOfferListResponse = new MutableLiveData<>();
    private final CompositeDisposable compositeDisposable;
    @NotNull
    public DisposableObserver<BuyNowOfferListResponse> disposableObserver;
    /* access modifiers changed from: private */
    public DisposableObserver<String> disposableObserverOfferCloseTime;
    private Executor executor;
    private LiveData<BuyNowOfferListResponse> getBuyNowOfferListResponse;
    private LiveData<NetworkState> networkState;
    @NotNull
    private MutableLiveData<String> offerError;
    private final BuyNowOfferListRepository repository;
    private LiveData<PagedList<BuyNowOfferListModel>> resultLiveData;
    private LiveData<Integer> scrollSearchListToTop;
    @NotNull
    private MutableLiveData<String> swipedProductListError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<BuyNowOfferListResponse> swipedProductListResult = new MutableLiveData<>();

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverOfferCloseTime$p(BuyNowOfferListViewModel buyNowOfferListViewModel) {
        DisposableObserver<String> disposableObserver2 = buyNowOfferListViewModel.disposableObserverOfferCloseTime;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverOfferCloseTime");
        }
        return disposableObserver2;
    }

    @Inject
    public BuyNowOfferListViewModel(@NotNull BuyNowOfferListRepository buyNowOfferListRepository) {
        Intrinsics.checkParameterIsNotNull(buyNowOfferListRepository, "repository");
        this.repository = buyNowOfferListRepository;
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        Intrinsics.checkExpressionValueIsNotNull(newFixedThreadPool, "Executors.newFixedThreadPool(5)");
        this.executor = newFixedThreadPool;
        this.compositeDisposable = new CompositeDisposable();
        this.buyNowOfferCloseTime = new MutableLiveData<>();
        this.offerError = new MutableLiveData<>();
        this.TAG = BuyNowOfferListViewModel.class.getSimpleName();
    }

    @NotNull
    public final MutableLiveData<BuyNowOfferListResponse> getBuyNowOfferListResponse() {
        return this.buyNowOfferListResponse;
    }

    public final void setBuyNowOfferListResponse(@NotNull MutableLiveData<BuyNowOfferListResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.buyNowOfferListResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getBuyNowOfferListError() {
        return this.buyNowOfferListError;
    }

    public final void setBuyNowOfferListError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.buyNowOfferListError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<BuyNowOfferListResponse> getSwipedProductListResult() {
        return this.swipedProductListResult;
    }

    public final void setSwipedProductListResult(@NotNull MutableLiveData<BuyNowOfferListResponse> mutableLiveData) {
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
    public final DisposableObserver<BuyNowOfferListResponse> getDisposableObserver() {
        DisposableObserver<BuyNowOfferListResponse> disposableObserver2 = this.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        return disposableObserver2;
    }

    public final void setDisposableObserver(@NotNull DisposableObserver<BuyNowOfferListResponse> disposableObserver2) {
        Intrinsics.checkParameterIsNotNull(disposableObserver2, "<set-?>");
        this.disposableObserver = disposableObserver2;
    }

    @NotNull
    public final MutableLiveData<String> getBuyNowOfferCloseTime() {
        return this.buyNowOfferCloseTime;
    }

    public final void setBuyNowOfferCloseTime(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.buyNowOfferCloseTime = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getOfferError() {
        return this.offerError;
    }

    public final void setOfferError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.offerError = mutableLiveData;
    }

    public final void fetchBuyNowOfferList(@NotNull String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "userId");
        this.buyNowOfferListDataFactory = new BuyNowOfferListDataFactory(this.repository, this.compositeDisposable, str, Integer.valueOf(i));
        initializePaging();
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
    public final LiveData<BuyNowOfferListResponse> getBuyNowListResponse() {
        LiveData<BuyNowOfferListResponse> liveData = this.getBuyNowOfferListResponse;
        if (liveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("getBuyNowOfferListResponse");
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
    public final LiveData<PagedList<BuyNowOfferListModel>> getResultLiveData() {
        LiveData<PagedList<BuyNowOfferListModel>> liveData = this.resultLiveData;
        if (liveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultLiveData");
        }
        return liveData;
    }

    private final void initializePaging() {
        PagedList.Config build = new PagedList.Config.Builder().setEnablePlaceholders(false).setInitialLoadSizeHint(30).setPageSize(30).build();
        BuyNowOfferListDataFactory buyNowOfferListDataFactory2 = this.buyNowOfferListDataFactory;
        if (buyNowOfferListDataFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyNowOfferListDataFactory");
        }
        LiveData<PagedList<BuyNowOfferListModel>> build2 = new LivePagedListBuilder(buyNowOfferListDataFactory2, build).setFetchExecutor(this.executor).build();
        if (build2 != null) {
            this.resultLiveData = build2;
            BuyNowOfferListDataFactory buyNowOfferListDataFactory3 = this.buyNowOfferListDataFactory;
            if (buyNowOfferListDataFactory3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("buyNowOfferListDataFactory");
            }
            LiveData<Integer> switchMap = Transformations.switchMap(buyNowOfferListDataFactory3.getMutableLiveData(), new BuyNowOfferListViewModel$initializePaging$1());
            Intrinsics.checkExpressionValueIsNotNull(switchMap, "Transformations.switchMa…     }\n                })");
            this.scrollSearchListToTop = switchMap;
            BuyNowOfferListDataFactory buyNowOfferListDataFactory4 = this.buyNowOfferListDataFactory;
            if (buyNowOfferListDataFactory4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("buyNowOfferListDataFactory");
            }
            LiveData<BuyNowOfferListResponse> switchMap2 = Transformations.switchMap(buyNowOfferListDataFactory4.getMutableLiveData(), new BuyNowOfferListViewModel$initializePaging$2());
            Intrinsics.checkExpressionValueIsNotNull(switchMap2, "Transformations.switchMa…     }\n                })");
            this.getBuyNowOfferListResponse = switchMap2;
            BuyNowOfferListDataFactory buyNowOfferListDataFactory5 = this.buyNowOfferListDataFactory;
            if (buyNowOfferListDataFactory5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("buyNowOfferListDataFactory");
            }
            LiveData<NetworkState> switchMap3 = Transformations.switchMap(buyNowOfferListDataFactory5.getMutableLiveData(), new BuyNowOfferListViewModel$initializePaging$3());
            Intrinsics.checkExpressionValueIsNotNull(switchMap3, "Transformations.switchMa…     }\n                })");
            this.networkState = switchMap3;
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LiveData<androidx.paging.PagedList<com.iaai.android.bdt.model.MyAccount.BuyNowOfferListModel>>");
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        this.compositeDisposable.clear();
        BuyNowOfferListViewModel buyNowOfferListViewModel = this;
        if (buyNowOfferListViewModel.disposableObserver != null) {
            DisposableObserver<BuyNowOfferListResponse> disposableObserver2 = this.disposableObserver;
            if (disposableObserver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
            }
            if (!disposableObserver2.isDisposed()) {
                DisposableObserver<BuyNowOfferListResponse> disposableObserver3 = this.disposableObserver;
                if (disposableObserver3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
                }
                disposableObserver3.dispose();
            }
        }
        if (buyNowOfferListViewModel.disposableObserverOfferCloseTime != null) {
            DisposableObserver<String> disposableObserver4 = this.disposableObserverOfferCloseTime;
            if (disposableObserver4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverOfferCloseTime");
            }
            if (!disposableObserver4.isDisposed()) {
                DisposableObserver<String> disposableObserver5 = this.disposableObserverOfferCloseTime;
                if (disposableObserver5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverOfferCloseTime");
                }
                disposableObserver5.dispose();
            }
        }
    }

    public final void disposeElements() {
        BuyNowOfferListViewModel buyNowOfferListViewModel = this;
        if (buyNowOfferListViewModel.disposableObserver != null) {
            DisposableObserver<BuyNowOfferListResponse> disposableObserver2 = this.disposableObserver;
            if (disposableObserver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
            }
            if (!disposableObserver2.isDisposed()) {
                DisposableObserver<BuyNowOfferListResponse> disposableObserver3 = this.disposableObserver;
                if (disposableObserver3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
                }
                disposableObserver3.dispose();
            }
        }
        if (buyNowOfferListViewModel.disposableObserver != null) {
            DisposableObserver<BuyNowOfferListResponse> disposableObserver4 = this.disposableObserver;
            if (disposableObserver4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
            }
            if (!disposableObserver4.isDisposed()) {
                DisposableObserver<BuyNowOfferListResponse> disposableObserver5 = this.disposableObserver;
                if (disposableObserver5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
                }
                disposableObserver5.dispose();
            }
        }
        if (buyNowOfferListViewModel.disposableObserverOfferCloseTime != null) {
            DisposableObserver<String> disposableObserver6 = this.disposableObserverOfferCloseTime;
            if (disposableObserver6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverOfferCloseTime");
            }
            if (!disposableObserver6.isDisposed()) {
                DisposableObserver<String> disposableObserver7 = this.disposableObserverOfferCloseTime;
                if (disposableObserver7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverOfferCloseTime");
                }
                disposableObserver7.dispose();
            }
        }
    }

    public final void loadSwipedProductList(@NotNull String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "userId");
        this.disposableObserver = new BuyNowOfferListViewModel$loadSwipedProductList$1(this);
        Observable<BuyNowOfferListResponse> observeOn = this.repository.getBuyNowList(str, i).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<BuyNowOfferListResponse> disposableObserver2 = this.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        observeOn.subscribe((Observer<? super BuyNowOfferListResponse>) disposableObserver2);
    }

    public final void loadBuyNowOfferCloseTime() {
        this.disposableObserverOfferCloseTime = new BuyNowOfferListViewModel$loadBuyNowOfferCloseTime$1(this);
        Observable<String> observeOn = this.repository.getBuyNowOfferCloseTime().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<String> disposableObserver2 = this.disposableObserverOfferCloseTime;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverOfferCloseTime");
        }
        observeOn.subscribe((Observer<? super String>) disposableObserver2);
    }
}
