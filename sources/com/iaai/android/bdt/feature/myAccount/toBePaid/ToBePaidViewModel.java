package com.iaai.android.bdt.feature.myAccount.toBePaid;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.iaai.android.bdt.feature.logIAAError.LogIAAErrorRepository;
import com.iaai.android.bdt.feature.myAccount.MyAccountRepository;
import com.iaai.android.bdt.feature.myAccount.toBePaid.dataSource.ToBePaidDataFactory;
import com.iaai.android.bdt.model.logIAAError.LogIAAErrorRequest;
import com.iaai.android.bdt.model.logIAAError.LogIAAErrorResponse;
import com.iaai.android.bdt.model.toBePaid.MakePayPalPaymentRequest;
import com.iaai.android.bdt.model.toBePaid.PayPalCheckOutResponse;
import com.iaai.android.bdt.model.toBePaid.PayPalCreateCustomerResponse;
import com.iaai.android.bdt.model.toBePaid.PayPalInfoResponse;
import com.iaai.android.bdt.model.toBePaid.PayPalPaymentRequest;
import com.iaai.android.bdt.model.toBePaid.PayPalTokenResponse;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDueListResponse;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.NetworkState;
import com.iaai.android.old.utils.constants.Constants;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
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

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J>\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u001d2\u0006\u0010O\u001a\u00020\u001d2\u0006\u0010P\u001a\u00020\u001d2\u0006\u0010Q\u001a\u00020\u001d2\u0006\u0010R\u001a\u00020\u001d2\u0006\u0010S\u001a\u00020\u001d2\u0006\u0010T\u001a\u00020UJ\u0006\u0010V\u001a\u00020MJ\f\u0010W\u001a\b\u0012\u0004\u0012\u00020(0'J\u000e\u0010\u0016\u001a\u00020M2\u0006\u0010N\u001a\u00020\u001dJ>\u0010X\u001a\u00020M2\u0006\u0010N\u001a\u00020\u001d2\u0006\u0010O\u001a\u00020\u001d2\u0006\u0010P\u001a\u00020\u001d2\u0006\u0010Q\u001a\u00020\u001d2\u0006\u0010R\u001a\u00020\u001d2\u0006\u0010S\u001a\u00020\u001d2\u0006\u0010T\u001a\u00020UJ>\u0010Y\u001a\u00020M2\u0006\u0010Z\u001a\u00020\u001d2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\\2\u0006\u0010^\u001a\u00020\u001d2\u0006\u0010_\u001a\u00020\u001d2\u0006\u0010`\u001a\u00020\u001d2\u0006\u0010a\u001a\u00020\u001dJ\f\u0010b\u001a\b\u0012\u0004\u0012\u00020C0'J\u0012\u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0E0'J8\u0010d\u001a\u00020e2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\\2\u0006\u0010^\u001a\u00020\u001d2\u0006\u0010_\u001a\u00020\u001d2\u0006\u0010`\u001a\u00020\u001d2\u0006\u0010a\u001a\u00020\u001dH\u0002J\b\u0010f\u001a\u00020MH\u0002J\u0016\u0010g\u001a\u00020M2\u0006\u0010R\u001a\u00020\u001d2\u0006\u0010h\u001a\u00020iJ>\u0010j\u001a\u00020M2\u0006\u0010N\u001a\u00020\u001d2\u0006\u0010O\u001a\u00020\u001d2\u0006\u0010P\u001a\u00020\u001d2\u0006\u0010Q\u001a\u00020\u001d2\u0006\u0010R\u001a\u00020\u001d2\u0006\u0010S\u001a\u00020\u001d2\u0006\u0010T\u001a\u00020kJ\u000e\u0010l\u001a\u00020M2\u0006\u0010m\u001a\u000209R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX.¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX.¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX.¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\nX.¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR \u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0019\"\u0004\b\"\u0010\u001bR \u0010#\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'X.¢\u0006\u0002\n\u0000R \u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0019\"\u0004\b+\u0010\u001bR \u0010,\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0019\"\u0004\b.\u0010\u001bR \u0010/\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0019\"\u0004\b1\u0010\u001bR \u00102\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0019\"\u0004\b4\u0010\u001bR<\u00105\u001a$\u0012 \u0012\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001d07j\b\u0012\u0004\u0012\u00020\u001d`8\u0012\u0004\u0012\u000209060\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0019\"\u0004\b;\u0010\u001bR \u0010<\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0019\"\u0004\b>\u0010\u001bR \u0010?\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0019\"\u0004\bA\u0010\u001bR\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020C0'X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0E0'X.¢\u0006\u0002\n\u0000R \u0010G\u001a\b\u0012\u0004\u0012\u0002090\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0019\"\u0004\bI\u0010\u001bR\u000e\u0010J\u001a\u00020KX.¢\u0006\u0002\n\u0000¨\u0006n"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/ToBePaidViewModel;", "Landroidx/lifecycle/ViewModel;", "myAccountRepository", "Lcom/iaai/android/bdt/feature/myAccount/MyAccountRepository;", "repositoryLogIAAError", "Lcom/iaai/android/bdt/feature/logIAAError/LogIAAErrorRepository;", "(Lcom/iaai/android/bdt/feature/myAccount/MyAccountRepository;Lcom/iaai/android/bdt/feature/logIAAError/LogIAAErrorRepository;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "disposableObserverCreateCustomer", "Lio/reactivex/observers/DisposableObserver;", "Lcom/iaai/android/bdt/model/toBePaid/PayPalCreateCustomerResponse;", "disposableObserverGetPayPalInfo", "Lcom/iaai/android/bdt/model/toBePaid/PayPalInfoResponse;", "disposableObserverGetPayPalToken", "Lcom/iaai/android/bdt/model/toBePaid/PayPalTokenResponse;", "disposableObserverLogIAAError", "Lcom/iaai/android/bdt/model/logIAAError/LogIAAErrorResponse;", "disposableObserverMakePayment", "Lcom/iaai/android/bdt/model/toBePaid/PayPalCheckOutResponse;", "executor", "Ljava/util/concurrent/Executor;", "getPayPalInfo", "Landroidx/lifecycle/MutableLiveData;", "getGetPayPalInfo", "()Landroidx/lifecycle/MutableLiveData;", "setGetPayPalInfo", "(Landroidx/lifecycle/MutableLiveData;)V", "getPayPalInfoError", "", "getGetPayPalInfoError", "setGetPayPalInfoError", "logIAAErrorFailure", "getLogIAAErrorFailure", "setLogIAAErrorFailure", "logIAAErrorResponse", "getLogIAAErrorResponse", "setLogIAAErrorResponse", "networkState", "Landroidx/lifecycle/LiveData;", "Lcom/iaai/android/bdt/utils/NetworkState;", "payPalCreateCustomer", "getPayPalCreateCustomer", "setPayPalCreateCustomer", "payPalCreateCustomerError", "getPayPalCreateCustomerError", "setPayPalCreateCustomerError", "payPalMakePayment", "getPayPalMakePayment", "setPayPalMakePayment", "payPalMakePaymentError", "getPayPalMakePaymentError", "setPayPalMakePaymentError", "payPalMakePaymentSalvageIds", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "", "getPayPalMakePaymentSalvageIds", "setPayPalMakePaymentSalvageIds", "payPalTokenError", "getPayPalTokenError", "setPayPalTokenError", "payPalTokenResponse", "getPayPalTokenResponse", "setPayPalTokenResponse", "paymentDueListResponse", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDueListResponse;", "resultLiveData", "Landroidx/paging/PagedList;", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "showLoading", "getShowLoading", "setShowLoading", "toBePaidDataFactory", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/dataSource/ToBePaidDataFactory;", "createPayPalCustomer", "", "authHeader", "deviceid", "devicetype", "apikey", "contentType", "appversion", "requestBody", "Lcom/iaai/android/bdt/model/toBePaid/PayPalPaymentRequest;", "disposeElements", "getNetworkState", "getPayPalToken", "getPaymentDueList", "authorizationHeader", "pageNumber", "", "count", "paymentMethod", "sortBy", "sortAsc", "onlyMyItem", "getPaymentDueListResponse", "getResultLiveData", "getTempRequestBody", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/TempRequestBody;", "initializePaging", "logIAAError", "logIAAErrorRequest", "Lcom/iaai/android/bdt/model/logIAAError/LogIAAErrorRequest;", "makePayPalCheckOut", "Lcom/iaai/android/bdt/model/toBePaid/MakePayPalPaymentRequest;", "updateLoadingIndicator", "status", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ToBePaidViewModel.kt */
public final class ToBePaidViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    /* access modifiers changed from: private */
    public DisposableObserver<PayPalCreateCustomerResponse> disposableObserverCreateCustomer;
    /* access modifiers changed from: private */
    public DisposableObserver<PayPalInfoResponse> disposableObserverGetPayPalInfo;
    /* access modifiers changed from: private */
    public DisposableObserver<PayPalTokenResponse> disposableObserverGetPayPalToken;
    /* access modifiers changed from: private */
    public DisposableObserver<LogIAAErrorResponse> disposableObserverLogIAAError;
    /* access modifiers changed from: private */
    public DisposableObserver<PayPalCheckOutResponse> disposableObserverMakePayment;
    private Executor executor;
    @NotNull
    private MutableLiveData<PayPalInfoResponse> getPayPalInfo;
    @NotNull
    private MutableLiveData<String> getPayPalInfoError;
    @NotNull
    private MutableLiveData<String> logIAAErrorFailure;
    @NotNull
    private MutableLiveData<LogIAAErrorResponse> logIAAErrorResponse;
    private final MyAccountRepository myAccountRepository;
    private LiveData<NetworkState> networkState;
    @NotNull
    private MutableLiveData<PayPalCreateCustomerResponse> payPalCreateCustomer;
    @NotNull
    private MutableLiveData<String> payPalCreateCustomerError;
    @NotNull
    private MutableLiveData<PayPalCheckOutResponse> payPalMakePayment;
    @NotNull
    private MutableLiveData<String> payPalMakePaymentError;
    @NotNull
    private MutableLiveData<Pair<ArrayList<String>, Boolean>> payPalMakePaymentSalvageIds;
    @NotNull
    private MutableLiveData<String> payPalTokenError;
    @NotNull
    private MutableLiveData<PayPalTokenResponse> payPalTokenResponse;
    private LiveData<PaymentDueListResponse> paymentDueListResponse;
    private final LogIAAErrorRepository repositoryLogIAAError;
    private LiveData<PagedList<PaymentDue>> resultLiveData;
    @NotNull
    private MutableLiveData<Boolean> showLoading;
    private ToBePaidDataFactory toBePaidDataFactory;

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverCreateCustomer$p(ToBePaidViewModel toBePaidViewModel) {
        DisposableObserver<PayPalCreateCustomerResponse> disposableObserver = toBePaidViewModel.disposableObserverCreateCustomer;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverCreateCustomer");
        }
        return disposableObserver;
    }

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverGetPayPalInfo$p(ToBePaidViewModel toBePaidViewModel) {
        DisposableObserver<PayPalInfoResponse> disposableObserver = toBePaidViewModel.disposableObserverGetPayPalInfo;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverGetPayPalInfo");
        }
        return disposableObserver;
    }

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverGetPayPalToken$p(ToBePaidViewModel toBePaidViewModel) {
        DisposableObserver<PayPalTokenResponse> disposableObserver = toBePaidViewModel.disposableObserverGetPayPalToken;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverGetPayPalToken");
        }
        return disposableObserver;
    }

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverLogIAAError$p(ToBePaidViewModel toBePaidViewModel) {
        DisposableObserver<LogIAAErrorResponse> disposableObserver = toBePaidViewModel.disposableObserverLogIAAError;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverLogIAAError");
        }
        return disposableObserver;
    }

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverMakePayment$p(ToBePaidViewModel toBePaidViewModel) {
        DisposableObserver<PayPalCheckOutResponse> disposableObserver = toBePaidViewModel.disposableObserverMakePayment;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverMakePayment");
        }
        return disposableObserver;
    }

    @Inject
    public ToBePaidViewModel(@NotNull MyAccountRepository myAccountRepository2, @NotNull LogIAAErrorRepository logIAAErrorRepository) {
        Intrinsics.checkParameterIsNotNull(myAccountRepository2, "myAccountRepository");
        Intrinsics.checkParameterIsNotNull(logIAAErrorRepository, "repositoryLogIAAError");
        this.myAccountRepository = myAccountRepository2;
        this.repositoryLogIAAError = logIAAErrorRepository;
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        Intrinsics.checkExpressionValueIsNotNull(newFixedThreadPool, "Executors.newFixedThreadPool(5)");
        this.executor = newFixedThreadPool;
        this.showLoading = new MutableLiveData<>();
        this.payPalTokenResponse = new MutableLiveData<>();
        this.payPalTokenError = new MutableLiveData<>();
        this.payPalCreateCustomer = new MutableLiveData<>();
        this.payPalCreateCustomerError = new MutableLiveData<>();
        this.payPalMakePayment = new MutableLiveData<>();
        this.payPalMakePaymentError = new MutableLiveData<>();
        this.payPalMakePaymentSalvageIds = new MutableLiveData<>();
        this.getPayPalInfo = new MutableLiveData<>();
        this.getPayPalInfoError = new MutableLiveData<>();
        this.logIAAErrorResponse = new MutableLiveData<>();
        this.logIAAErrorFailure = new MutableLiveData<>();
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
    public final MutableLiveData<PayPalTokenResponse> getPayPalTokenResponse() {
        return this.payPalTokenResponse;
    }

    public final void setPayPalTokenResponse(@NotNull MutableLiveData<PayPalTokenResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.payPalTokenResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getPayPalTokenError() {
        return this.payPalTokenError;
    }

    public final void setPayPalTokenError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.payPalTokenError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<PayPalCreateCustomerResponse> getPayPalCreateCustomer() {
        return this.payPalCreateCustomer;
    }

    public final void setPayPalCreateCustomer(@NotNull MutableLiveData<PayPalCreateCustomerResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.payPalCreateCustomer = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getPayPalCreateCustomerError() {
        return this.payPalCreateCustomerError;
    }

    public final void setPayPalCreateCustomerError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.payPalCreateCustomerError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<PayPalCheckOutResponse> getPayPalMakePayment() {
        return this.payPalMakePayment;
    }

    public final void setPayPalMakePayment(@NotNull MutableLiveData<PayPalCheckOutResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.payPalMakePayment = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getPayPalMakePaymentError() {
        return this.payPalMakePaymentError;
    }

    public final void setPayPalMakePaymentError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.payPalMakePaymentError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<Pair<ArrayList<String>, Boolean>> getPayPalMakePaymentSalvageIds() {
        return this.payPalMakePaymentSalvageIds;
    }

    public final void setPayPalMakePaymentSalvageIds(@NotNull MutableLiveData<Pair<ArrayList<String>, Boolean>> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.payPalMakePaymentSalvageIds = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<PayPalInfoResponse> getGetPayPalInfo() {
        return this.getPayPalInfo;
    }

    public final void setGetPayPalInfo(@NotNull MutableLiveData<PayPalInfoResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.getPayPalInfo = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getGetPayPalInfoError() {
        return this.getPayPalInfoError;
    }

    public final void setGetPayPalInfoError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.getPayPalInfoError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<LogIAAErrorResponse> getLogIAAErrorResponse() {
        return this.logIAAErrorResponse;
    }

    public final void setLogIAAErrorResponse(@NotNull MutableLiveData<LogIAAErrorResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.logIAAErrorResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getLogIAAErrorFailure() {
        return this.logIAAErrorFailure;
    }

    public final void setLogIAAErrorFailure(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.logIAAErrorFailure = mutableLiveData;
    }

    public final void getPaymentDueList(@NotNull String str, int i, int i2, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkParameterIsNotNull(str, "authorizationHeader");
        Intrinsics.checkParameterIsNotNull(str2, "paymentMethod");
        Intrinsics.checkParameterIsNotNull(str3, Constants_MVVM.EXTRA_SORT_BY);
        Intrinsics.checkParameterIsNotNull(str4, "sortAsc");
        Intrinsics.checkParameterIsNotNull(str5, "onlyMyItem");
        this.toBePaidDataFactory = new ToBePaidDataFactory(this.myAccountRepository, this.compositeDisposable, getTempRequestBody(i, i2, str2, str3, str4, str5), str);
        initializePaging();
    }

    private final void initializePaging() {
        PagedList.Config build = new PagedList.Config.Builder().setEnablePlaceholders(false).setInitialLoadSizeHint(25).setPageSize(25).build();
        ToBePaidDataFactory toBePaidDataFactory2 = this.toBePaidDataFactory;
        if (toBePaidDataFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toBePaidDataFactory");
        }
        LiveData<PagedList<PaymentDue>> build2 = new LivePagedListBuilder(toBePaidDataFactory2, build).setFetchExecutor(this.executor).build();
        if (build2 != null) {
            this.resultLiveData = build2;
            ToBePaidDataFactory toBePaidDataFactory3 = this.toBePaidDataFactory;
            if (toBePaidDataFactory3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toBePaidDataFactory");
            }
            LiveData<NetworkState> switchMap = Transformations.switchMap(toBePaidDataFactory3.getMutableLiveData(), new ToBePaidViewModel$initializePaging$1());
            Intrinsics.checkExpressionValueIsNotNull(switchMap, "Transformations.switchMa…     }\n                })");
            this.networkState = switchMap;
            ToBePaidDataFactory toBePaidDataFactory4 = this.toBePaidDataFactory;
            if (toBePaidDataFactory4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toBePaidDataFactory");
            }
            LiveData<PaymentDueListResponse> switchMap2 = Transformations.switchMap(toBePaidDataFactory4.getMutableLiveData(), new ToBePaidViewModel$initializePaging$2());
            Intrinsics.checkExpressionValueIsNotNull(switchMap2, "Transformations.switchMa…     }\n                })");
            this.paymentDueListResponse = switchMap2;
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LiveData<androidx.paging.PagedList<com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue>>");
    }

    @NotNull
    public final LiveData<PagedList<PaymentDue>> getResultLiveData() {
        LiveData<PagedList<PaymentDue>> liveData = this.resultLiveData;
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
    public final LiveData<PaymentDueListResponse> getPaymentDueListResponse() {
        LiveData<PaymentDueListResponse> liveData = this.paymentDueListResponse;
        if (liveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentDueListResponse");
        }
        return liveData;
    }

    private final TempRequestBody getTempRequestBody(int i, int i2, String str, String str2, String str3, String str4) {
        return new TempRequestBody(i, i2, str, str2, str3, str4);
    }

    public final void getPayPalToken(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull PayPalPaymentRequest payPalPaymentRequest) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "deviceid");
        Intrinsics.checkParameterIsNotNull(str3, Constants.DEVICETYPE_HEADER);
        Intrinsics.checkParameterIsNotNull(str4, "apikey");
        Intrinsics.checkParameterIsNotNull(str5, CMSAttributeTableGenerator.CONTENT_TYPE);
        String str7 = str6;
        Intrinsics.checkParameterIsNotNull(str7, "appversion");
        PayPalPaymentRequest payPalPaymentRequest2 = payPalPaymentRequest;
        Intrinsics.checkParameterIsNotNull(payPalPaymentRequest2, "requestBody");
        updateLoadingIndicator(true);
        this.disposableObserverGetPayPalToken = new ToBePaidViewModel$getPayPalToken$1(this);
        Observable<PayPalTokenResponse> observeOn = this.myAccountRepository.getPayPalToken(str, str2, str3, str4, str5, str7, payPalPaymentRequest2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<PayPalTokenResponse> disposableObserver = this.disposableObserverGetPayPalToken;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverGetPayPalToken");
        }
        observeOn.subscribe((Observer<? super PayPalTokenResponse>) disposableObserver);
    }

    public final void createPayPalCustomer(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull PayPalPaymentRequest payPalPaymentRequest) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "deviceid");
        Intrinsics.checkParameterIsNotNull(str3, Constants.DEVICETYPE_HEADER);
        Intrinsics.checkParameterIsNotNull(str4, "apikey");
        Intrinsics.checkParameterIsNotNull(str5, CMSAttributeTableGenerator.CONTENT_TYPE);
        String str7 = str6;
        Intrinsics.checkParameterIsNotNull(str7, "appversion");
        PayPalPaymentRequest payPalPaymentRequest2 = payPalPaymentRequest;
        Intrinsics.checkParameterIsNotNull(payPalPaymentRequest2, "requestBody");
        updateLoadingIndicator(true);
        this.disposableObserverCreateCustomer = new ToBePaidViewModel$createPayPalCustomer$1(this);
        Observable<PayPalCreateCustomerResponse> observeOn = this.myAccountRepository.createPayPalCustomerID(str, str2, str3, str4, str5, str7, payPalPaymentRequest2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<PayPalCreateCustomerResponse> disposableObserver = this.disposableObserverCreateCustomer;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverCreateCustomer");
        }
        observeOn.subscribe((Observer<? super PayPalCreateCustomerResponse>) disposableObserver);
    }

    public final void makePayPalCheckOut(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull MakePayPalPaymentRequest makePayPalPaymentRequest) {
        MakePayPalPaymentRequest makePayPalPaymentRequest2 = makePayPalPaymentRequest;
        String str7 = str;
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        String str8 = str2;
        Intrinsics.checkParameterIsNotNull(str2, "deviceid");
        String str9 = str3;
        Intrinsics.checkParameterIsNotNull(str3, Constants.DEVICETYPE_HEADER);
        Intrinsics.checkParameterIsNotNull(str4, "apikey");
        Intrinsics.checkParameterIsNotNull(str5, CMSAttributeTableGenerator.CONTENT_TYPE);
        Intrinsics.checkParameterIsNotNull(str6, "appversion");
        Intrinsics.checkParameterIsNotNull(makePayPalPaymentRequest2, "requestBody");
        updateLoadingIndicator(true);
        ArrayList arrayList = new ArrayList();
        CharSequence salvageIDs = makePayPalPaymentRequest.getSalvageIDs();
        boolean z = false;
        if (!(salvageIDs == null || salvageIDs.length() == 0)) {
            arrayList.add(makePayPalPaymentRequest.getSalvageIDs());
        }
        CharSequence salvageBuyerChargeIDs = makePayPalPaymentRequest.getSalvageBuyerChargeIDs();
        if (!(salvageBuyerChargeIDs == null || salvageBuyerChargeIDs.length() == 0)) {
            arrayList.add(makePayPalPaymentRequest.getSalvageBuyerChargeIDs());
        }
        CharSequence buyerChargeIDs = makePayPalPaymentRequest.getBuyerChargeIDs();
        if (buyerChargeIDs == null || buyerChargeIDs.length() == 0) {
            z = true;
        }
        if (!z) {
            arrayList.add(makePayPalPaymentRequest.getBuyerChargeIDs());
        }
        this.disposableObserverMakePayment = new ToBePaidViewModel$makePayPalCheckOut$1(this, makePayPalPaymentRequest2, arrayList);
        Observable<PayPalCheckOutResponse> observeOn = this.myAccountRepository.makePayPalCheckOut(str, str2, str3, str4, str5, str6, makePayPalPaymentRequest).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<PayPalCheckOutResponse> disposableObserver = this.disposableObserverMakePayment;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverMakePayment");
        }
        observeOn.subscribe((Observer<? super PayPalCheckOutResponse>) disposableObserver);
    }

    public final void updateLoadingIndicator(boolean z) {
        this.showLoading.postValue(Boolean.valueOf(z));
    }

    public final void getPayPalInfo(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        updateLoadingIndicator(true);
        this.disposableObserverGetPayPalInfo = new ToBePaidViewModel$getPayPalInfo$1(this);
        Observable<PayPalInfoResponse> observeOn = this.myAccountRepository.getPayPalInfo(str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<PayPalInfoResponse> disposableObserver = this.disposableObserverGetPayPalInfo;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverGetPayPalInfo");
        }
        observeOn.subscribe((Observer<? super PayPalInfoResponse>) disposableObserver);
    }

    public final void logIAAError(@NotNull String str, @NotNull LogIAAErrorRequest logIAAErrorRequest) {
        Intrinsics.checkParameterIsNotNull(str, CMSAttributeTableGenerator.CONTENT_TYPE);
        Intrinsics.checkParameterIsNotNull(logIAAErrorRequest, "logIAAErrorRequest");
        this.disposableObserverLogIAAError = new ToBePaidViewModel$logIAAError$1(this);
        Observable<LogIAAErrorResponse> observeOn = this.repositoryLogIAAError.logIAAError(str, logIAAErrorRequest).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<LogIAAErrorResponse> disposableObserver = this.disposableObserverLogIAAError;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverLogIAAError");
        }
        observeOn.subscribe((Observer<? super LogIAAErrorResponse>) disposableObserver);
    }

    public final void disposeElements() {
        ToBePaidViewModel toBePaidViewModel = this;
        if (toBePaidViewModel.disposableObserverGetPayPalToken != null) {
            DisposableObserver<PayPalTokenResponse> disposableObserver = this.disposableObserverGetPayPalToken;
            if (disposableObserver == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverGetPayPalToken");
            }
            if (!disposableObserver.isDisposed()) {
                DisposableObserver<PayPalTokenResponse> disposableObserver2 = this.disposableObserverGetPayPalToken;
                if (disposableObserver2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverGetPayPalToken");
                }
                disposableObserver2.dispose();
            }
        }
        if (toBePaidViewModel.disposableObserverCreateCustomer != null) {
            DisposableObserver<PayPalCreateCustomerResponse> disposableObserver3 = this.disposableObserverCreateCustomer;
            if (disposableObserver3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverCreateCustomer");
            }
            if (!disposableObserver3.isDisposed()) {
                DisposableObserver<PayPalCreateCustomerResponse> disposableObserver4 = this.disposableObserverCreateCustomer;
                if (disposableObserver4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverCreateCustomer");
                }
                disposableObserver4.dispose();
            }
        }
        if (toBePaidViewModel.disposableObserverMakePayment != null) {
            DisposableObserver<PayPalCheckOutResponse> disposableObserver5 = this.disposableObserverMakePayment;
            if (disposableObserver5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverMakePayment");
            }
            if (!disposableObserver5.isDisposed()) {
                DisposableObserver<PayPalCheckOutResponse> disposableObserver6 = this.disposableObserverMakePayment;
                if (disposableObserver6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverMakePayment");
                }
                disposableObserver6.dispose();
            }
        }
        if (toBePaidViewModel.disposableObserverGetPayPalInfo != null) {
            DisposableObserver<PayPalInfoResponse> disposableObserver7 = this.disposableObserverGetPayPalInfo;
            if (disposableObserver7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverGetPayPalInfo");
            }
            if (!disposableObserver7.isDisposed()) {
                DisposableObserver<PayPalInfoResponse> disposableObserver8 = this.disposableObserverGetPayPalInfo;
                if (disposableObserver8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverGetPayPalInfo");
                }
                disposableObserver8.dispose();
            }
        }
        if (toBePaidViewModel.disposableObserverLogIAAError != null) {
            DisposableObserver<LogIAAErrorResponse> disposableObserver9 = this.disposableObserverLogIAAError;
            if (disposableObserver9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverLogIAAError");
            }
            if (!disposableObserver9.isDisposed()) {
                DisposableObserver<LogIAAErrorResponse> disposableObserver10 = this.disposableObserverLogIAAError;
                if (disposableObserver10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverLogIAAError");
                }
                disposableObserver10.dispose();
            }
        }
    }
}
