package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.iaai.android.bdt.feature.myAccount.MyAccountRepository;
import com.iaai.android.bdt.model.MyAccount.InsertRepOrAddressRequest;
import com.iaai.android.bdt.model.MyAccount.InsertRepOrAddressResponse;
import com.iaai.android.bdt.model.MyAccount.SaleDocCountryStateParentModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;
import p011io.reactivex.Observer;
import p011io.reactivex.android.schedulers.AndroidSchedulers;
import p011io.reactivex.observers.DisposableObserver;
import p011io.reactivex.schedulers.Schedulers;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u001e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000bR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u000bR\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0018X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/InsertRepOrAddViewModel;", "Landroidx/lifecycle/ViewModel;", "myAccountRepository", "Lcom/iaai/android/bdt/feature/myAccount/MyAccountRepository;", "(Lcom/iaai/android/bdt/feature/myAccount/MyAccountRepository;)V", "addRepAddressError", "Landroidx/lifecycle/MutableLiveData;", "", "getAddRepAddressError", "()Landroidx/lifecycle/MutableLiveData;", "setAddRepAddressError", "(Landroidx/lifecycle/MutableLiveData;)V", "addRepAddressResponse", "Lcom/iaai/android/bdt/model/MyAccount/InsertRepOrAddressResponse;", "getAddRepAddressResponse", "setAddRepAddressResponse", "countryStateError", "getCountryStateError", "setCountryStateError", "countryStateResponse", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocCountryStateParentModel;", "getCountryStateResponse", "setCountryStateResponse", "disposableObserverCountryState", "Lio/reactivex/observers/DisposableObserver;", "disposableObserverInsert", "disposeElements", "", "getCountryStateList", "insertRepOrAddress", "authHeader", "deviceType", "requestBody", "Lcom/iaai/android/bdt/model/MyAccount/InsertRepOrAddressRequest;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: InsertRepOrAddViewModel.kt */
public final class InsertRepOrAddViewModel extends ViewModel {
    @NotNull
    private MutableLiveData<String> addRepAddressError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<InsertRepOrAddressResponse> addRepAddressResponse = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<String> countryStateError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<SaleDocCountryStateParentModel> countryStateResponse = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public DisposableObserver<SaleDocCountryStateParentModel> disposableObserverCountryState;
    /* access modifiers changed from: private */
    public DisposableObserver<InsertRepOrAddressResponse> disposableObserverInsert;
    private final MyAccountRepository myAccountRepository;

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverCountryState$p(InsertRepOrAddViewModel insertRepOrAddViewModel) {
        DisposableObserver<SaleDocCountryStateParentModel> disposableObserver = insertRepOrAddViewModel.disposableObserverCountryState;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverCountryState");
        }
        return disposableObserver;
    }

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverInsert$p(InsertRepOrAddViewModel insertRepOrAddViewModel) {
        DisposableObserver<InsertRepOrAddressResponse> disposableObserver = insertRepOrAddViewModel.disposableObserverInsert;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverInsert");
        }
        return disposableObserver;
    }

    @Inject
    public InsertRepOrAddViewModel(@NotNull MyAccountRepository myAccountRepository2) {
        Intrinsics.checkParameterIsNotNull(myAccountRepository2, "myAccountRepository");
        this.myAccountRepository = myAccountRepository2;
    }

    @NotNull
    public final MutableLiveData<SaleDocCountryStateParentModel> getCountryStateResponse() {
        return this.countryStateResponse;
    }

    public final void setCountryStateResponse(@NotNull MutableLiveData<SaleDocCountryStateParentModel> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.countryStateResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getCountryStateError() {
        return this.countryStateError;
    }

    public final void setCountryStateError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.countryStateError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<InsertRepOrAddressResponse> getAddRepAddressResponse() {
        return this.addRepAddressResponse;
    }

    public final void setAddRepAddressResponse(@NotNull MutableLiveData<InsertRepOrAddressResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.addRepAddressResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getAddRepAddressError() {
        return this.addRepAddressError;
    }

    public final void setAddRepAddressError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.addRepAddressError = mutableLiveData;
    }

    public final void getCountryStateList() {
        this.disposableObserverCountryState = new InsertRepOrAddViewModel$getCountryStateList$1(this);
        Observable<SaleDocCountryStateParentModel> observeOn = this.myAccountRepository.getCountryStateList().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<SaleDocCountryStateParentModel> disposableObserver = this.disposableObserverCountryState;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverCountryState");
        }
        observeOn.subscribe((Observer<? super SaleDocCountryStateParentModel>) disposableObserver);
    }

    public final void insertRepOrAddress(@NotNull String str, @NotNull String str2, @NotNull InsertRepOrAddressRequest insertRepOrAddressRequest) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "deviceType");
        Intrinsics.checkParameterIsNotNull(insertRepOrAddressRequest, "requestBody");
        this.disposableObserverInsert = new InsertRepOrAddViewModel$insertRepOrAddress$1(this);
        Observable<InsertRepOrAddressResponse> observeOn = this.myAccountRepository.insertRepOrAddress(str, str2, insertRepOrAddressRequest).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<InsertRepOrAddressResponse> disposableObserver = this.disposableObserverInsert;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverInsert");
        }
        observeOn.subscribe((Observer<? super InsertRepOrAddressResponse>) disposableObserver);
    }

    public final void disposeElements() {
        InsertRepOrAddViewModel insertRepOrAddViewModel = this;
        if (insertRepOrAddViewModel.disposableObserverCountryState != null) {
            DisposableObserver<SaleDocCountryStateParentModel> disposableObserver = this.disposableObserverCountryState;
            if (disposableObserver == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverCountryState");
            }
            if (!disposableObserver.isDisposed()) {
                DisposableObserver<SaleDocCountryStateParentModel> disposableObserver2 = this.disposableObserverCountryState;
                if (disposableObserver2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverCountryState");
                }
                disposableObserver2.dispose();
            }
        }
        if (insertRepOrAddViewModel.disposableObserverInsert != null) {
            DisposableObserver<InsertRepOrAddressResponse> disposableObserver3 = this.disposableObserverInsert;
            if (disposableObserver3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverInsert");
            }
            if (!disposableObserver3.isDisposed()) {
                DisposableObserver<InsertRepOrAddressResponse> disposableObserver4 = this.disposableObserverInsert;
                if (disposableObserver4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverInsert");
                }
                disposableObserver4.dispose();
            }
        }
    }
}
