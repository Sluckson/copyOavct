package com.iaai.android.bdt.feature.account.salesdocument;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.iaai.android.bdt.feature.account.salesdocument.dataSource.SaleDocumentDataFactory;
import com.iaai.android.bdt.model.MyAccount.MBRequestBody;
import com.iaai.android.bdt.model.MyAccount.ManageBranchPrefResponse;
import com.iaai.android.bdt.model.MyAccount.SaleDocBranchFilterResponse;
import com.iaai.android.bdt.model.MyAccount.SaleDocumentListModel;
import com.iaai.android.bdt.model.MyAccount.SaleDocumentListResponse;
import com.iaai.android.bdt.model.MyAccount.SaleDocumentRequestBody;
import com.iaai.android.bdt.utils.NetworkState;
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
import repack.org.bouncycastle.cms.CMSAttributeTableGenerator;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010A\u001a\u00020BJ\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ\u0012\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001aJ6\u0010E\u001a\u00020B2\u0006\u0010F\u001a\u00020!2\u0006\u0010G\u001a\u00020!2\u0006\u0010H\u001a\u00020!2\u0006\u0010I\u001a\u00020!2\u0006\u0010J\u001a\u00020!2\u0006\u0010K\u001a\u00020!J>\u0010L\u001a\u00020B2\u0006\u0010F\u001a\u00020!2\u0006\u0010G\u001a\u00020!2\u0006\u0010H\u001a\u00020!2\u0006\u0010I\u001a\u00020!2\u0006\u0010J\u001a\u00020!2\u0006\u0010K\u001a\u00020!2\u0006\u0010M\u001a\u00020NJF\u0010O\u001a\u00020B2\u0006\u0010P\u001a\u00020!2\u0006\u0010G\u001a\u00020!2\u0006\u0010Q\u001a\u00020!2\u0006\u0010R\u001a\u00020!2\u0006\u0010J\u001a\u00020!2\u0006\u0010K\u001a\u00020!2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u000208J\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\t0\u001aJ\f\u0010W\u001a\b\u0012\u0004\u0012\u0002060\u001aJ\b\u0010X\u001a\u00020BH\u0002J>\u0010Y\u001a\u00020B2\u0006\u0010F\u001a\u00020!2\u0006\u0010G\u001a\u00020!2\u0006\u0010H\u001a\u00020!2\u0006\u0010I\u001a\u00020!2\u0006\u0010J\u001a\u00020!2\u0006\u0010K\u001a\u00020!2\u0006\u0010M\u001a\u00020TJ\b\u0010Z\u001a\u00020BH\u0014J\u000e\u0010[\u001a\u00020B2\u0006\u0010\\\u001a\u000208R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX.¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001aX.¢\u0006\u0002\n\u0000R \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R&\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R \u0010)\u001a\b\u0012\u0004\u0012\u00020!0 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R \u0010,\u001a\b\u0012\u0004\u0012\u00020\u00140 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010#\"\u0004\b.\u0010%R\u000e\u0010/\u001a\u000200X.¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\t0\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u00102\u001a\b\u0012\u0004\u0012\u00020!0 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010#\"\u0004\b4\u0010%R\u0014\u00105\u001a\b\u0012\u0004\u0012\u0002060\u001aX.¢\u0006\u0002\n\u0000R \u00107\u001a\b\u0012\u0004\u0012\u0002080 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010#\"\u0004\b:\u0010%R \u0010;\u001a\b\u0012\u0004\u0012\u00020!0 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010#\"\u0004\b=\u0010%R \u0010>\u001a\b\u0012\u0004\u0012\u00020\t0 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010#\"\u0004\b@\u0010%¨\u0006]"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/salesdocument/SaleDocumentViewModel;", "Landroidx/lifecycle/ViewModel;", "saleDocumentRepository", "Lcom/iaai/android/bdt/feature/account/salesdocument/SaleDocumentRepository;", "(Lcom/iaai/android/bdt/feature/account/salesdocument/SaleDocumentRepository;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "disposableObserver", "Lio/reactivex/observers/DisposableObserver;", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocumentListResponse;", "getDisposableObserver", "()Lio/reactivex/observers/DisposableObserver;", "setDisposableObserver", "(Lio/reactivex/observers/DisposableObserver;)V", "disposableObserverSaleDocBranch", "", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocBranchFilterResponse;", "getDisposableObserverSaleDocBranch", "setDisposableObserverSaleDocBranch", "disposableObserverSaleDocManageBranch", "Lcom/iaai/android/bdt/model/MyAccount/ManageBranchPrefResponse;", "getDisposableObserverSaleDocManageBranch", "setDisposableObserverSaleDocManageBranch", "executor", "Ljava/util/concurrent/Executor;", "networkState", "Landroidx/lifecycle/LiveData;", "Lcom/iaai/android/bdt/utils/NetworkState;", "resultLiveData", "Landroidx/paging/PagedList;", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocumentListModel;", "saleDocBranchListError", "Landroidx/lifecycle/MutableLiveData;", "", "getSaleDocBranchListError", "()Landroidx/lifecycle/MutableLiveData;", "setSaleDocBranchListError", "(Landroidx/lifecycle/MutableLiveData;)V", "saleDocBranchResponse", "getSaleDocBranchResponse", "setSaleDocBranchResponse", "saleDocManageBranchListError", "getSaleDocManageBranchListError", "setSaleDocManageBranchListError", "saleDocManageBranchResponse", "getSaleDocManageBranchResponse", "setSaleDocManageBranchResponse", "saleDocumentDataFactory", "Lcom/iaai/android/bdt/feature/account/salesdocument/dataSource/SaleDocumentDataFactory;", "saleDocumentListResponse", "salesDocumentListError", "getSalesDocumentListError", "setSalesDocumentListError", "scrollSearchListToTop", "", "showLoading", "", "getShowLoading", "setShowLoading", "swipedProductListError", "getSwipedProductListError", "setSwipedProductListError", "swipedProductListResult", "getSwipedProductListResult", "setSwipedProductListResult", "disposeElements", "", "getNetworkState", "getResultLiveData", "getSaleDocBranchList", "authString", "deviceid", "deviceType", "paypalApiKey", "contentType", "appversion", "getSaleDocManageBranchList", "makeRequestBody", "Lcom/iaai/android/bdt/model/MyAccount/MBRequestBody;", "getSaleDocumentList", "authHeader", "devicetype", "apikey", "requestBody", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocumentRequestBody;", "isFilterApplied", "getSaleDocumentListResponse", "getScrollSearchListToTop", "initializePaging", "loadSwipedProductList", "onCleared", "updateLoadingIndicator", "status", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SaleDocumentViewModel.kt */
public final class SaleDocumentViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    @NotNull
    public DisposableObserver<SaleDocumentListResponse> disposableObserver;
    @NotNull
    public DisposableObserver<List<SaleDocBranchFilterResponse>> disposableObserverSaleDocBranch;
    @NotNull
    public DisposableObserver<ManageBranchPrefResponse> disposableObserverSaleDocManageBranch;
    private Executor executor;
    private LiveData<NetworkState> networkState;
    private LiveData<PagedList<SaleDocumentListModel>> resultLiveData;
    @NotNull
    private MutableLiveData<String> saleDocBranchListError;
    @NotNull
    private MutableLiveData<List<SaleDocBranchFilterResponse>> saleDocBranchResponse;
    @NotNull
    private MutableLiveData<String> saleDocManageBranchListError;
    @NotNull
    private MutableLiveData<ManageBranchPrefResponse> saleDocManageBranchResponse;
    private SaleDocumentDataFactory saleDocumentDataFactory;
    private LiveData<SaleDocumentListResponse> saleDocumentListResponse;
    private final SaleDocumentRepository saleDocumentRepository;
    @NotNull
    private MutableLiveData<String> salesDocumentListError;
    private LiveData<Integer> scrollSearchListToTop;
    @NotNull
    private MutableLiveData<Boolean> showLoading;
    @NotNull
    private MutableLiveData<String> swipedProductListError;
    @NotNull
    private MutableLiveData<SaleDocumentListResponse> swipedProductListResult;

    @Inject
    public SaleDocumentViewModel(@NotNull SaleDocumentRepository saleDocumentRepository2) {
        Intrinsics.checkParameterIsNotNull(saleDocumentRepository2, "saleDocumentRepository");
        this.saleDocumentRepository = saleDocumentRepository2;
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        Intrinsics.checkExpressionValueIsNotNull(newFixedThreadPool, "Executors.newFixedThreadPool(5)");
        this.executor = newFixedThreadPool;
        this.salesDocumentListError = new MutableLiveData<>();
        this.swipedProductListResult = new MutableLiveData<>();
        this.swipedProductListError = new MutableLiveData<>();
        this.saleDocBranchResponse = new MutableLiveData<>();
        this.saleDocBranchListError = new MutableLiveData<>();
        this.saleDocManageBranchResponse = new MutableLiveData<>();
        this.saleDocManageBranchListError = new MutableLiveData<>();
        this.showLoading = new MutableLiveData<>();
    }

    @NotNull
    public final MutableLiveData<String> getSalesDocumentListError() {
        return this.salesDocumentListError;
    }

    public final void setSalesDocumentListError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.salesDocumentListError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<SaleDocumentListResponse> getSwipedProductListResult() {
        return this.swipedProductListResult;
    }

    public final void setSwipedProductListResult(@NotNull MutableLiveData<SaleDocumentListResponse> mutableLiveData) {
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
    public final DisposableObserver<SaleDocumentListResponse> getDisposableObserver() {
        DisposableObserver<SaleDocumentListResponse> disposableObserver2 = this.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        return disposableObserver2;
    }

    public final void setDisposableObserver(@NotNull DisposableObserver<SaleDocumentListResponse> disposableObserver2) {
        Intrinsics.checkParameterIsNotNull(disposableObserver2, "<set-?>");
        this.disposableObserver = disposableObserver2;
    }

    @NotNull
    public final DisposableObserver<List<SaleDocBranchFilterResponse>> getDisposableObserverSaleDocBranch() {
        DisposableObserver<List<SaleDocBranchFilterResponse>> disposableObserver2 = this.disposableObserverSaleDocBranch;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverSaleDocBranch");
        }
        return disposableObserver2;
    }

    public final void setDisposableObserverSaleDocBranch(@NotNull DisposableObserver<List<SaleDocBranchFilterResponse>> disposableObserver2) {
        Intrinsics.checkParameterIsNotNull(disposableObserver2, "<set-?>");
        this.disposableObserverSaleDocBranch = disposableObserver2;
    }

    @NotNull
    public final MutableLiveData<List<SaleDocBranchFilterResponse>> getSaleDocBranchResponse() {
        return this.saleDocBranchResponse;
    }

    public final void setSaleDocBranchResponse(@NotNull MutableLiveData<List<SaleDocBranchFilterResponse>> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.saleDocBranchResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getSaleDocBranchListError() {
        return this.saleDocBranchListError;
    }

    public final void setSaleDocBranchListError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.saleDocBranchListError = mutableLiveData;
    }

    @NotNull
    public final DisposableObserver<ManageBranchPrefResponse> getDisposableObserverSaleDocManageBranch() {
        DisposableObserver<ManageBranchPrefResponse> disposableObserver2 = this.disposableObserverSaleDocManageBranch;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverSaleDocManageBranch");
        }
        return disposableObserver2;
    }

    public final void setDisposableObserverSaleDocManageBranch(@NotNull DisposableObserver<ManageBranchPrefResponse> disposableObserver2) {
        Intrinsics.checkParameterIsNotNull(disposableObserver2, "<set-?>");
        this.disposableObserverSaleDocManageBranch = disposableObserver2;
    }

    @NotNull
    public final MutableLiveData<ManageBranchPrefResponse> getSaleDocManageBranchResponse() {
        return this.saleDocManageBranchResponse;
    }

    public final void setSaleDocManageBranchResponse(@NotNull MutableLiveData<ManageBranchPrefResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.saleDocManageBranchResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getSaleDocManageBranchListError() {
        return this.saleDocManageBranchListError;
    }

    public final void setSaleDocManageBranchListError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.saleDocManageBranchListError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowLoading() {
        return this.showLoading;
    }

    public final void setShowLoading(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.showLoading = mutableLiveData;
    }

    public final void getSaleDocumentList(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull SaleDocumentRequestBody saleDocumentRequestBody, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "deviceid");
        String str7 = str3;
        Intrinsics.checkParameterIsNotNull(str7, Constants.DEVICETYPE_HEADER);
        String str8 = str4;
        Intrinsics.checkParameterIsNotNull(str8, "apikey");
        String str9 = str5;
        Intrinsics.checkParameterIsNotNull(str9, CMSAttributeTableGenerator.CONTENT_TYPE);
        String str10 = str6;
        Intrinsics.checkParameterIsNotNull(str10, "appversion");
        SaleDocumentRequestBody saleDocumentRequestBody2 = saleDocumentRequestBody;
        Intrinsics.checkParameterIsNotNull(saleDocumentRequestBody2, "requestBody");
        this.saleDocumentDataFactory = new SaleDocumentDataFactory(str, str2, str7, str8, str9, str10, this.saleDocumentRepository, this.compositeDisposable, saleDocumentRequestBody2, z);
        initializePaging();
    }

    private final void initializePaging() {
        PagedList.Config build = new PagedList.Config.Builder().setEnablePlaceholders(false).setInitialLoadSizeHint(25).setPageSize(25).build();
        SaleDocumentDataFactory saleDocumentDataFactory2 = this.saleDocumentDataFactory;
        if (saleDocumentDataFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saleDocumentDataFactory");
        }
        LiveData<PagedList<SaleDocumentListModel>> build2 = new LivePagedListBuilder(saleDocumentDataFactory2, build).setFetchExecutor(this.executor).build();
        if (build2 != null) {
            this.resultLiveData = build2;
            SaleDocumentDataFactory saleDocumentDataFactory3 = this.saleDocumentDataFactory;
            if (saleDocumentDataFactory3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("saleDocumentDataFactory");
            }
            LiveData<NetworkState> switchMap = Transformations.switchMap(saleDocumentDataFactory3.getMutableLiveData(), new SaleDocumentViewModel$initializePaging$1());
            Intrinsics.checkExpressionValueIsNotNull(switchMap, "Transformations.switchMa…     }\n                })");
            this.networkState = switchMap;
            SaleDocumentDataFactory saleDocumentDataFactory4 = this.saleDocumentDataFactory;
            if (saleDocumentDataFactory4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("saleDocumentDataFactory");
            }
            LiveData<SaleDocumentListResponse> switchMap2 = Transformations.switchMap(saleDocumentDataFactory4.getMutableLiveData(), new SaleDocumentViewModel$initializePaging$2());
            Intrinsics.checkExpressionValueIsNotNull(switchMap2, "Transformations.switchMa…     }\n                })");
            this.saleDocumentListResponse = switchMap2;
            SaleDocumentDataFactory saleDocumentDataFactory5 = this.saleDocumentDataFactory;
            if (saleDocumentDataFactory5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("saleDocumentDataFactory");
            }
            LiveData<Integer> switchMap3 = Transformations.switchMap(saleDocumentDataFactory5.getMutableLiveData(), new SaleDocumentViewModel$initializePaging$3());
            Intrinsics.checkExpressionValueIsNotNull(switchMap3, "Transformations.switchMa…     }\n                })");
            this.scrollSearchListToTop = switchMap3;
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LiveData<androidx.paging.PagedList<com.iaai.android.bdt.model.MyAccount.SaleDocumentListModel>>");
    }

    @NotNull
    public final LiveData<PagedList<SaleDocumentListModel>> getResultLiveData() {
        LiveData<PagedList<SaleDocumentListModel>> liveData = this.resultLiveData;
        if (liveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultLiveData");
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
    public final LiveData<SaleDocumentListResponse> getSaleDocumentListResponse() {
        LiveData<SaleDocumentListResponse> liveData = this.saleDocumentListResponse;
        if (liveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saleDocumentListResponse");
        }
        return liveData;
    }

    public final void updateLoadingIndicator(boolean z) {
        this.showLoading.postValue(Boolean.valueOf(z));
    }

    @NotNull
    public final LiveData<Integer> getScrollSearchListToTop() {
        LiveData<Integer> liveData = this.scrollSearchListToTop;
        if (liveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollSearchListToTop");
        }
        return liveData;
    }

    public final void loadSwipedProductList(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull SaleDocumentRequestBody saleDocumentRequestBody) {
        Intrinsics.checkParameterIsNotNull(str, "authString");
        Intrinsics.checkParameterIsNotNull(str2, "deviceid");
        Intrinsics.checkParameterIsNotNull(str3, "deviceType");
        Intrinsics.checkParameterIsNotNull(str4, "paypalApiKey");
        Intrinsics.checkParameterIsNotNull(str5, CMSAttributeTableGenerator.CONTENT_TYPE);
        String str7 = str6;
        Intrinsics.checkParameterIsNotNull(str7, "appversion");
        SaleDocumentRequestBody saleDocumentRequestBody2 = saleDocumentRequestBody;
        Intrinsics.checkParameterIsNotNull(saleDocumentRequestBody2, "makeRequestBody");
        this.disposableObserver = new SaleDocumentViewModel$loadSwipedProductList$1(this);
        Observable<SaleDocumentListResponse> observeOn = this.saleDocumentRepository.getSaleDocumentList(str, str2, str3, str4, str5, str7, saleDocumentRequestBody2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<SaleDocumentListResponse> disposableObserver2 = this.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        observeOn.subscribe((Observer<? super SaleDocumentListResponse>) disposableObserver2);
    }

    public final void getSaleDocBranchList(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkParameterIsNotNull(str, "authString");
        Intrinsics.checkParameterIsNotNull(str2, "deviceid");
        Intrinsics.checkParameterIsNotNull(str3, "deviceType");
        Intrinsics.checkParameterIsNotNull(str4, "paypalApiKey");
        Intrinsics.checkParameterIsNotNull(str5, CMSAttributeTableGenerator.CONTENT_TYPE);
        Intrinsics.checkParameterIsNotNull(str6, "appversion");
        this.disposableObserverSaleDocBranch = new SaleDocumentViewModel$getSaleDocBranchList$1(this);
        Observable<List<SaleDocBranchFilterResponse>> observeOn = this.saleDocumentRepository.getSaleDocumentBranchList(str, str2, str3, str4, str5, str6).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<List<SaleDocBranchFilterResponse>> disposableObserver2 = this.disposableObserverSaleDocBranch;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverSaleDocBranch");
        }
        observeOn.subscribe((Observer<? super List<SaleDocBranchFilterResponse>>) disposableObserver2);
    }

    public final void getSaleDocManageBranchList(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull MBRequestBody mBRequestBody) {
        Intrinsics.checkParameterIsNotNull(str, "authString");
        Intrinsics.checkParameterIsNotNull(str2, "deviceid");
        Intrinsics.checkParameterIsNotNull(str3, "deviceType");
        Intrinsics.checkParameterIsNotNull(str4, "paypalApiKey");
        Intrinsics.checkParameterIsNotNull(str5, CMSAttributeTableGenerator.CONTENT_TYPE);
        String str7 = str6;
        Intrinsics.checkParameterIsNotNull(str7, "appversion");
        MBRequestBody mBRequestBody2 = mBRequestBody;
        Intrinsics.checkParameterIsNotNull(mBRequestBody2, "makeRequestBody");
        this.disposableObserverSaleDocManageBranch = new SaleDocumentViewModel$getSaleDocManageBranchList$1(this);
        Observable<ManageBranchPrefResponse> observeOn = this.saleDocumentRepository.getManageBranchPrefList(str, str2, str3, str4, str5, str7, mBRequestBody2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<ManageBranchPrefResponse> disposableObserver2 = this.disposableObserverSaleDocManageBranch;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverSaleDocManageBranch");
        }
        observeOn.subscribe((Observer<? super ManageBranchPrefResponse>) disposableObserver2);
    }

    public final void disposeElements() {
        SaleDocumentViewModel saleDocumentViewModel = this;
        if (saleDocumentViewModel.disposableObserver != null) {
            DisposableObserver<SaleDocumentListResponse> disposableObserver2 = this.disposableObserver;
            if (disposableObserver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
            }
            if (!disposableObserver2.isDisposed()) {
                DisposableObserver<SaleDocumentListResponse> disposableObserver3 = this.disposableObserver;
                if (disposableObserver3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
                }
                disposableObserver3.dispose();
            }
        }
        if (saleDocumentViewModel.disposableObserverSaleDocBranch != null) {
            DisposableObserver<List<SaleDocBranchFilterResponse>> disposableObserver4 = this.disposableObserverSaleDocBranch;
            if (disposableObserver4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverSaleDocBranch");
            }
            if (!disposableObserver4.isDisposed()) {
                DisposableObserver<List<SaleDocBranchFilterResponse>> disposableObserver5 = this.disposableObserverSaleDocBranch;
                if (disposableObserver5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverSaleDocBranch");
                }
                disposableObserver5.dispose();
            }
        }
        if (saleDocumentViewModel.disposableObserverSaleDocManageBranch != null) {
            DisposableObserver<ManageBranchPrefResponse> disposableObserver6 = this.disposableObserverSaleDocManageBranch;
            if (disposableObserver6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverSaleDocManageBranch");
            }
            if (!disposableObserver6.isDisposed()) {
                DisposableObserver<ManageBranchPrefResponse> disposableObserver7 = this.disposableObserverSaleDocManageBranch;
                if (disposableObserver7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverSaleDocManageBranch");
                }
                disposableObserver7.dispose();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        this.compositeDisposable.clear();
        SaleDocumentViewModel saleDocumentViewModel = this;
        if (saleDocumentViewModel.disposableObserver != null) {
            DisposableObserver<SaleDocumentListResponse> disposableObserver2 = this.disposableObserver;
            if (disposableObserver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
            }
            if (!disposableObserver2.isDisposed()) {
                DisposableObserver<SaleDocumentListResponse> disposableObserver3 = this.disposableObserver;
                if (disposableObserver3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
                }
                disposableObserver3.dispose();
            }
        }
        if (saleDocumentViewModel.disposableObserverSaleDocBranch != null) {
            DisposableObserver<List<SaleDocBranchFilterResponse>> disposableObserver4 = this.disposableObserverSaleDocBranch;
            if (disposableObserver4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverSaleDocBranch");
            }
            if (!disposableObserver4.isDisposed()) {
                DisposableObserver<List<SaleDocBranchFilterResponse>> disposableObserver5 = this.disposableObserverSaleDocBranch;
                if (disposableObserver5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverSaleDocBranch");
                }
                disposableObserver5.dispose();
            }
        }
        if (saleDocumentViewModel.disposableObserverSaleDocManageBranch != null) {
            DisposableObserver<ManageBranchPrefResponse> disposableObserver6 = this.disposableObserverSaleDocManageBranch;
            if (disposableObserver6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverSaleDocManageBranch");
            }
            if (!disposableObserver6.isDisposed()) {
                DisposableObserver<ManageBranchPrefResponse> disposableObserver7 = this.disposableObserverSaleDocManageBranch;
                if (disposableObserver7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverSaleDocManageBranch");
                }
                disposableObserver7.dispose();
            }
        }
    }
}
