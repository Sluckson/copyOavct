package com.iaai.android.bdt.feature.account.tobepickedup;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.iaai.android.bdt.feature.account.tobepickedup.datasource.ToBePickedUpListDataFactory;
import com.iaai.android.bdt.model.MyAccount.ToBePickedUpResponse;
import com.iaai.android.bdt.model.MyAccount.ToBePickedUpVehiclesModel;
import com.iaai.android.bdt.utils.Constants_MVVM;
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

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010'\u001a\u00020(J6\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u001aJ\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\f\u00102\u001a\b\u0012\u0004\u0012\u00020\f0\u0014J\u0012\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0014J\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0014J\b\u00105\u001a\u00020(H\u0002JF\u00106\u001a\u00020(2\u0006\u00107\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\u0006\u0010-\u001a\u00020.2\u0006\u00108\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u001a2\u0006\u00109\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u001aJ\b\u0010:\u001a\u00020(H\u0014R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0014X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0014X.¢\u0006\u0002\n\u0000R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u000e\u0010$\u001a\u00020%X.¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u0014X.¢\u0006\u0002\n\u0000¨\u0006;"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/tobepickedup/ToBePickedUpViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/iaai/android/bdt/feature/account/tobepickedup/ToBePickedUpRepository;", "(Lcom/iaai/android/bdt/feature/account/tobepickedup/ToBePickedUpRepository;)V", "TAG", "", "kotlin.jvm.PlatformType", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "disposableObserver", "Lio/reactivex/observers/DisposableObserver;", "Lcom/iaai/android/bdt/model/MyAccount/ToBePickedUpResponse;", "getDisposableObserver", "()Lio/reactivex/observers/DisposableObserver;", "setDisposableObserver", "(Lio/reactivex/observers/DisposableObserver;)V", "executor", "Ljava/util/concurrent/Executor;", "networkState", "Landroidx/lifecycle/LiveData;", "Lcom/iaai/android/bdt/utils/NetworkState;", "resultLiveData", "Landroidx/paging/PagedList;", "Lcom/iaai/android/bdt/model/MyAccount/ToBePickedUpVehiclesModel;", "scrollSearchListToTop", "", "swipedProductListError", "Landroidx/lifecycle/MutableLiveData;", "getSwipedProductListError", "()Landroidx/lifecycle/MutableLiveData;", "setSwipedProductListError", "(Landroidx/lifecycle/MutableLiveData;)V", "swipedProductListResult", "getSwipedProductListResult", "setSwipedProductListResult", "toBePickedUpListDataFactory", "Lcom/iaai/android/bdt/feature/account/tobepickedup/datasource/ToBePickedUpListDataFactory;", "toBePickedupResponse", "disposeElements", "", "fetchToBePickedUpList", "authorizationHeader", "userId", "startIndex", "onlymyitems", "", "sortBy", "sortDirection", "getNetworkState", "getPreSalesListResponse", "getResultLiveData", "getScrollSearchListToTop", "initializePaging", "loadSwipedProductList", "authenticationHeader", "lbsParentID", "status", "onCleared", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ToBePickedUpViewModel.kt */
public final class ToBePickedUpViewModel extends ViewModel {
    private final String TAG;
    private final CompositeDisposable compositeDisposable;
    @NotNull
    public DisposableObserver<ToBePickedUpResponse> disposableObserver;
    private Executor executor;
    private LiveData<NetworkState> networkState;
    private final ToBePickedUpRepository repository;
    private LiveData<PagedList<ToBePickedUpVehiclesModel>> resultLiveData;
    private LiveData<Integer> scrollSearchListToTop;
    @NotNull
    private MutableLiveData<String> swipedProductListError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<ToBePickedUpResponse> swipedProductListResult = new MutableLiveData<>();
    private ToBePickedUpListDataFactory toBePickedUpListDataFactory;
    private LiveData<ToBePickedUpResponse> toBePickedupResponse;

    @Inject
    public ToBePickedUpViewModel(@NotNull ToBePickedUpRepository toBePickedUpRepository) {
        Intrinsics.checkParameterIsNotNull(toBePickedUpRepository, "repository");
        this.repository = toBePickedUpRepository;
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        Intrinsics.checkExpressionValueIsNotNull(newFixedThreadPool, "Executors.newFixedThreadPool(5)");
        this.executor = newFixedThreadPool;
        this.compositeDisposable = new CompositeDisposable();
        this.TAG = ToBePickedUpViewModel.class.getSimpleName();
    }

    @NotNull
    public final MutableLiveData<ToBePickedUpResponse> getSwipedProductListResult() {
        return this.swipedProductListResult;
    }

    public final void setSwipedProductListResult(@NotNull MutableLiveData<ToBePickedUpResponse> mutableLiveData) {
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
    public final DisposableObserver<ToBePickedUpResponse> getDisposableObserver() {
        DisposableObserver<ToBePickedUpResponse> disposableObserver2 = this.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        return disposableObserver2;
    }

    public final void setDisposableObserver(@NotNull DisposableObserver<ToBePickedUpResponse> disposableObserver2) {
        Intrinsics.checkParameterIsNotNull(disposableObserver2, "<set-?>");
        this.disposableObserver = disposableObserver2;
    }

    public final void fetchToBePickedUpList(@NotNull String str, @NotNull String str2, int i, boolean z, @NotNull String str3, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "authorizationHeader");
        Intrinsics.checkParameterIsNotNull(str2, "userId");
        String str4 = str3;
        Intrinsics.checkParameterIsNotNull(str4, Constants_MVVM.EXTRA_SORT_BY);
        this.toBePickedUpListDataFactory = new ToBePickedUpListDataFactory(this.repository, this.compositeDisposable, str, str2, Integer.valueOf(i), Boolean.valueOf(z), str4, Integer.valueOf(i2));
        initializePaging();
    }

    public final void disposeElements() {
        if (this.disposableObserver != null) {
            DisposableObserver<ToBePickedUpResponse> disposableObserver2 = this.disposableObserver;
            if (disposableObserver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
            }
            if (!disposableObserver2.isDisposed()) {
                DisposableObserver<ToBePickedUpResponse> disposableObserver3 = this.disposableObserver;
                if (disposableObserver3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
                }
                disposableObserver3.dispose();
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
    public final LiveData<ToBePickedUpResponse> getPreSalesListResponse() {
        LiveData<ToBePickedUpResponse> liveData = this.toBePickedupResponse;
        if (liveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toBePickedupResponse");
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
    public final LiveData<PagedList<ToBePickedUpVehiclesModel>> getResultLiveData() {
        LiveData<PagedList<ToBePickedUpVehiclesModel>> liveData = this.resultLiveData;
        if (liveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultLiveData");
        }
        return liveData;
    }

    private final void initializePaging() {
        PagedList.Config build = new PagedList.Config.Builder().setEnablePlaceholders(false).setInitialLoadSizeHint(30).setPageSize(30).build();
        ToBePickedUpListDataFactory toBePickedUpListDataFactory2 = this.toBePickedUpListDataFactory;
        if (toBePickedUpListDataFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toBePickedUpListDataFactory");
        }
        LiveData<PagedList<ToBePickedUpVehiclesModel>> build2 = new LivePagedListBuilder(toBePickedUpListDataFactory2, build).setFetchExecutor(this.executor).build();
        if (build2 != null) {
            this.resultLiveData = build2;
            ToBePickedUpListDataFactory toBePickedUpListDataFactory3 = this.toBePickedUpListDataFactory;
            if (toBePickedUpListDataFactory3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toBePickedUpListDataFactory");
            }
            LiveData<Integer> switchMap = Transformations.switchMap(toBePickedUpListDataFactory3.getMutableLiveData(), new ToBePickedUpViewModel$initializePaging$1());
            Intrinsics.checkExpressionValueIsNotNull(switchMap, "Transformations.switchMa…     }\n                })");
            this.scrollSearchListToTop = switchMap;
            ToBePickedUpListDataFactory toBePickedUpListDataFactory4 = this.toBePickedUpListDataFactory;
            if (toBePickedUpListDataFactory4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toBePickedUpListDataFactory");
            }
            LiveData<ToBePickedUpResponse> switchMap2 = Transformations.switchMap(toBePickedUpListDataFactory4.getMutableLiveData(), new ToBePickedUpViewModel$initializePaging$2());
            Intrinsics.checkExpressionValueIsNotNull(switchMap2, "Transformations.switchMa…     }\n                })");
            this.toBePickedupResponse = switchMap2;
            ToBePickedUpListDataFactory toBePickedUpListDataFactory5 = this.toBePickedUpListDataFactory;
            if (toBePickedUpListDataFactory5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toBePickedUpListDataFactory");
            }
            LiveData<NetworkState> switchMap3 = Transformations.switchMap(toBePickedUpListDataFactory5.getMutableLiveData(), new ToBePickedUpViewModel$initializePaging$3());
            Intrinsics.checkExpressionValueIsNotNull(switchMap3, "Transformations.switchMa…     }\n                })");
            this.networkState = switchMap3;
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LiveData<androidx.paging.PagedList<com.iaai.android.bdt.model.MyAccount.ToBePickedUpVehiclesModel>>");
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        this.compositeDisposable.clear();
        if (this.disposableObserver != null) {
            DisposableObserver<ToBePickedUpResponse> disposableObserver2 = this.disposableObserver;
            if (disposableObserver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
            }
            if (!disposableObserver2.isDisposed()) {
                DisposableObserver<ToBePickedUpResponse> disposableObserver3 = this.disposableObserver;
                if (disposableObserver3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
                }
                disposableObserver3.dispose();
            }
        }
    }

    public final void loadSwipedProductList(@NotNull String str, @NotNull String str2, boolean z, int i, int i2, @NotNull String str3, @NotNull String str4, int i3) {
        Intrinsics.checkParameterIsNotNull(str, "authenticationHeader");
        Intrinsics.checkParameterIsNotNull(str2, "userId");
        Intrinsics.checkParameterIsNotNull(str3, "status");
        Intrinsics.checkParameterIsNotNull(str4, Constants_MVVM.EXTRA_SORT_BY);
        this.disposableObserver = new ToBePickedUpViewModel$loadSwipedProductList$1(this);
        Observable<ToBePickedUpResponse> observeOn = this.repository.getList(str, str2, z, i2, str4, i3).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<ToBePickedUpResponse> disposableObserver2 = this.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        observeOn.subscribe((Observer<? super ToBePickedUpResponse>) disposableObserver2);
    }
}
