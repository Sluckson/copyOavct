package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.iaai.android.bdt.feature.myAccount.MyAccountRepository;
import com.iaai.android.bdt.model.toBePaid.saleDocument.GetSaleDocListRequest;
import com.iaai.android.bdt.model.toBePaid.saleDocument.defaultResponse.GetSaleDocListResponse;
import com.iaai.android.bdt.model.toBePaid.saleDocument.groupedByBranch.GetSaleDocListGroupResponse;
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

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0017\u001a\u00020\u0018J.\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fJ.\u0010 \u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X.¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X.¢\u0006\u0002\n\u0000R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/SaleDocListViewModel;", "Landroidx/lifecycle/ViewModel;", "myAccountRepository", "Lcom/iaai/android/bdt/feature/myAccount/MyAccountRepository;", "(Lcom/iaai/android/bdt/feature/myAccount/MyAccountRepository;)V", "disposableObserverGetSaleDocList", "Lio/reactivex/observers/DisposableObserver;", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/defaultResponse/GetSaleDocListResponse;", "disposableObserverGetSaleDocListGroup", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/groupedByBranch/GetSaleDocListGroupResponse;", "getSaleDocListGroupError", "Landroidx/lifecycle/MutableLiveData;", "", "getGetSaleDocListGroupError", "()Landroidx/lifecycle/MutableLiveData;", "setGetSaleDocListGroupError", "(Landroidx/lifecycle/MutableLiveData;)V", "getSaleDocListGroupResponse", "getGetSaleDocListGroupResponse", "setGetSaleDocListGroupResponse", "getSaleDocListResponse", "getGetSaleDocListResponse", "setGetSaleDocListResponse", "disposeElements", "", "getSaleDocList", "authHeader", "deviceid", "devicetype", "appversion", "requestBody", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/GetSaleDocListRequest;", "getSaleDocListGroup", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SaleDocListViewModel.kt */
public final class SaleDocListViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public DisposableObserver<GetSaleDocListResponse> disposableObserverGetSaleDocList;
    /* access modifiers changed from: private */
    public DisposableObserver<GetSaleDocListGroupResponse> disposableObserverGetSaleDocListGroup;
    @NotNull
    private MutableLiveData<String> getSaleDocListGroupError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<GetSaleDocListGroupResponse> getSaleDocListGroupResponse = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<GetSaleDocListResponse> getSaleDocListResponse = new MutableLiveData<>();
    private final MyAccountRepository myAccountRepository;

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverGetSaleDocList$p(SaleDocListViewModel saleDocListViewModel) {
        DisposableObserver<GetSaleDocListResponse> disposableObserver = saleDocListViewModel.disposableObserverGetSaleDocList;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverGetSaleDocList");
        }
        return disposableObserver;
    }

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverGetSaleDocListGroup$p(SaleDocListViewModel saleDocListViewModel) {
        DisposableObserver<GetSaleDocListGroupResponse> disposableObserver = saleDocListViewModel.disposableObserverGetSaleDocListGroup;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverGetSaleDocListGroup");
        }
        return disposableObserver;
    }

    @Inject
    public SaleDocListViewModel(@NotNull MyAccountRepository myAccountRepository2) {
        Intrinsics.checkParameterIsNotNull(myAccountRepository2, "myAccountRepository");
        this.myAccountRepository = myAccountRepository2;
    }

    @NotNull
    public final MutableLiveData<GetSaleDocListGroupResponse> getGetSaleDocListGroupResponse() {
        return this.getSaleDocListGroupResponse;
    }

    public final void setGetSaleDocListGroupResponse(@NotNull MutableLiveData<GetSaleDocListGroupResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.getSaleDocListGroupResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getGetSaleDocListGroupError() {
        return this.getSaleDocListGroupError;
    }

    public final void setGetSaleDocListGroupError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.getSaleDocListGroupError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<GetSaleDocListResponse> getGetSaleDocListResponse() {
        return this.getSaleDocListResponse;
    }

    public final void setGetSaleDocListResponse(@NotNull MutableLiveData<GetSaleDocListResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.getSaleDocListResponse = mutableLiveData;
    }

    public final void getSaleDocList(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull GetSaleDocListRequest getSaleDocListRequest) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "deviceid");
        Intrinsics.checkParameterIsNotNull(str3, Constants.DEVICETYPE_HEADER);
        Intrinsics.checkParameterIsNotNull(str4, "appversion");
        Intrinsics.checkParameterIsNotNull(getSaleDocListRequest, "requestBody");
        this.disposableObserverGetSaleDocList = new SaleDocListViewModel$getSaleDocList$1(this);
        Observable<GetSaleDocListResponse> observeOn = this.myAccountRepository.getSaleDocList(str, str2, str3, str4, getSaleDocListRequest).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<GetSaleDocListResponse> disposableObserver = this.disposableObserverGetSaleDocList;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverGetSaleDocList");
        }
        observeOn.subscribe((Observer<? super GetSaleDocListResponse>) disposableObserver);
    }

    public final void getSaleDocListGroup(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull GetSaleDocListRequest getSaleDocListRequest) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "deviceid");
        Intrinsics.checkParameterIsNotNull(str3, Constants.DEVICETYPE_HEADER);
        Intrinsics.checkParameterIsNotNull(str4, "appversion");
        Intrinsics.checkParameterIsNotNull(getSaleDocListRequest, "requestBody");
        this.disposableObserverGetSaleDocListGroup = new SaleDocListViewModel$getSaleDocListGroup$1(this);
        Observable<GetSaleDocListGroupResponse> observeOn = this.myAccountRepository.getSaleDocListGroup(str, str2, str3, str4, getSaleDocListRequest).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<GetSaleDocListGroupResponse> disposableObserver = this.disposableObserverGetSaleDocListGroup;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverGetSaleDocListGroup");
        }
        observeOn.subscribe((Observer<? super GetSaleDocListGroupResponse>) disposableObserver);
    }

    public final void disposeElements() {
        SaleDocListViewModel saleDocListViewModel = this;
        if (saleDocListViewModel.disposableObserverGetSaleDocListGroup != null) {
            DisposableObserver<GetSaleDocListGroupResponse> disposableObserver = this.disposableObserverGetSaleDocListGroup;
            if (disposableObserver == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverGetSaleDocListGroup");
            }
            if (!disposableObserver.isDisposed()) {
                DisposableObserver<GetSaleDocListGroupResponse> disposableObserver2 = this.disposableObserverGetSaleDocListGroup;
                if (disposableObserver2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverGetSaleDocListGroup");
                }
                disposableObserver2.dispose();
            }
        }
        if (saleDocListViewModel.disposableObserverGetSaleDocList != null) {
            DisposableObserver<GetSaleDocListResponse> disposableObserver3 = this.disposableObserverGetSaleDocList;
            if (disposableObserver3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverGetSaleDocList");
            }
            if (!disposableObserver3.isDisposed()) {
                DisposableObserver<GetSaleDocListResponse> disposableObserver4 = this.disposableObserverGetSaleDocList;
                if (disposableObserver4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverGetSaleDocList");
                }
                disposableObserver4.dispose();
            }
        }
    }
}
