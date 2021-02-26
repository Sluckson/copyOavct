package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.iaai.android.bdt.feature.myAccount.MyAccountRepository;
import com.iaai.android.bdt.model.toBePaid.getDeliveryMethod.GetDeliveryMethodRequest;
import com.iaai.android.bdt.model.toBePaid.getDeliveryMethod.GetDeliveryMethodResponse;
import com.iaai.android.bdt.model.toBePaid.saleDocument.SaleDocResponse;
import com.iaai.android.bdt.model.toBePaid.saleDocument.SaveDeliveryRequest;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;
import p011io.reactivex.Observer;
import p011io.reactivex.android.schedulers.AndroidSchedulers;
import p011io.reactivex.observers.DisposableObserver;
import p011io.reactivex.schedulers.Schedulers;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001bJ\u001e\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\"R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X.¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X.¢\u0006\u0002\n\u0000R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010¨\u0006#"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryMethodViewModel;", "Landroidx/lifecycle/ViewModel;", "myAccountRepository", "Lcom/iaai/android/bdt/feature/myAccount/MyAccountRepository;", "(Lcom/iaai/android/bdt/feature/myAccount/MyAccountRepository;)V", "disposableObserverGetDeliveryMethod", "Lio/reactivex/observers/DisposableObserver;", "Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/GetDeliveryMethodResponse;", "disposableObserverSaveDeliveryMethod", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/SaleDocResponse;", "getDeliveryMethodError", "Landroidx/lifecycle/MutableLiveData;", "", "getGetDeliveryMethodError", "()Landroidx/lifecycle/MutableLiveData;", "setGetDeliveryMethodError", "(Landroidx/lifecycle/MutableLiveData;)V", "getDeliveryMethodResponse", "getGetDeliveryMethodResponse", "setGetDeliveryMethodResponse", "saveDeliveryMethodError", "getSaveDeliveryMethodError", "setSaveDeliveryMethodError", "saveDeliveryMethodResponse", "getSaveDeliveryMethodResponse", "setSaveDeliveryMethodResponse", "applyDeliveryMethods", "", "authHeader", "deviceType", "requestBody", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/SaveDeliveryRequest;", "disposeElements", "getDeliveryMethods", "Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/GetDeliveryMethodRequest;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryMethodViewModel.kt */
public final class DeliveryMethodViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public DisposableObserver<GetDeliveryMethodResponse> disposableObserverGetDeliveryMethod;
    /* access modifiers changed from: private */
    public DisposableObserver<SaleDocResponse> disposableObserverSaveDeliveryMethod;
    @NotNull
    private MutableLiveData<String> getDeliveryMethodError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<GetDeliveryMethodResponse> getDeliveryMethodResponse = new MutableLiveData<>();
    private final MyAccountRepository myAccountRepository;
    @NotNull
    private MutableLiveData<String> saveDeliveryMethodError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<SaleDocResponse> saveDeliveryMethodResponse = new MutableLiveData<>();

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverGetDeliveryMethod$p(DeliveryMethodViewModel deliveryMethodViewModel) {
        DisposableObserver<GetDeliveryMethodResponse> disposableObserver = deliveryMethodViewModel.disposableObserverGetDeliveryMethod;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverGetDeliveryMethod");
        }
        return disposableObserver;
    }

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverSaveDeliveryMethod$p(DeliveryMethodViewModel deliveryMethodViewModel) {
        DisposableObserver<SaleDocResponse> disposableObserver = deliveryMethodViewModel.disposableObserverSaveDeliveryMethod;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverSaveDeliveryMethod");
        }
        return disposableObserver;
    }

    @Inject
    public DeliveryMethodViewModel(@NotNull MyAccountRepository myAccountRepository2) {
        Intrinsics.checkParameterIsNotNull(myAccountRepository2, "myAccountRepository");
        this.myAccountRepository = myAccountRepository2;
    }

    @NotNull
    public final MutableLiveData<GetDeliveryMethodResponse> getGetDeliveryMethodResponse() {
        return this.getDeliveryMethodResponse;
    }

    public final void setGetDeliveryMethodResponse(@NotNull MutableLiveData<GetDeliveryMethodResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.getDeliveryMethodResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getGetDeliveryMethodError() {
        return this.getDeliveryMethodError;
    }

    public final void setGetDeliveryMethodError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.getDeliveryMethodError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<SaleDocResponse> getSaveDeliveryMethodResponse() {
        return this.saveDeliveryMethodResponse;
    }

    public final void setSaveDeliveryMethodResponse(@NotNull MutableLiveData<SaleDocResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.saveDeliveryMethodResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getSaveDeliveryMethodError() {
        return this.saveDeliveryMethodError;
    }

    public final void setSaveDeliveryMethodError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.saveDeliveryMethodError = mutableLiveData;
    }

    public final void getDeliveryMethods(@NotNull String str, @NotNull String str2, @NotNull GetDeliveryMethodRequest getDeliveryMethodRequest) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "deviceType");
        Intrinsics.checkParameterIsNotNull(getDeliveryMethodRequest, "requestBody");
        this.disposableObserverGetDeliveryMethod = new DeliveryMethodViewModel$getDeliveryMethods$1(this);
        Observable<GetDeliveryMethodResponse> observeOn = this.myAccountRepository.getDeliveryMethods(str, str2, getDeliveryMethodRequest).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<GetDeliveryMethodResponse> disposableObserver = this.disposableObserverGetDeliveryMethod;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverGetDeliveryMethod");
        }
        observeOn.subscribe((Observer<? super GetDeliveryMethodResponse>) disposableObserver);
    }

    public final void applyDeliveryMethods(@NotNull String str, @NotNull String str2, @NotNull SaveDeliveryRequest saveDeliveryRequest) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "deviceType");
        Intrinsics.checkParameterIsNotNull(saveDeliveryRequest, "requestBody");
        this.disposableObserverSaveDeliveryMethod = new DeliveryMethodViewModel$applyDeliveryMethods$1(this);
        Observable<SaleDocResponse> observeOn = this.myAccountRepository.applyDeliveryMethod(str, str2, saveDeliveryRequest).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<SaleDocResponse> disposableObserver = this.disposableObserverSaveDeliveryMethod;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverSaveDeliveryMethod");
        }
        observeOn.subscribe((Observer<? super SaleDocResponse>) disposableObserver);
    }

    public final void disposeElements() {
        DeliveryMethodViewModel deliveryMethodViewModel = this;
        if (deliveryMethodViewModel.disposableObserverGetDeliveryMethod != null) {
            DisposableObserver<GetDeliveryMethodResponse> disposableObserver = this.disposableObserverGetDeliveryMethod;
            if (disposableObserver == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverGetDeliveryMethod");
            }
            if (!disposableObserver.isDisposed()) {
                DisposableObserver<GetDeliveryMethodResponse> disposableObserver2 = this.disposableObserverGetDeliveryMethod;
                if (disposableObserver2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverGetDeliveryMethod");
                }
                disposableObserver2.dispose();
            }
        }
        if (deliveryMethodViewModel.disposableObserverSaveDeliveryMethod != null) {
            DisposableObserver<SaleDocResponse> disposableObserver3 = this.disposableObserverSaveDeliveryMethod;
            if (disposableObserver3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverSaveDeliveryMethod");
            }
            if (!disposableObserver3.isDisposed()) {
                DisposableObserver<SaleDocResponse> disposableObserver4 = this.disposableObserverSaveDeliveryMethod;
                if (disposableObserver4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverSaveDeliveryMethod");
                }
                disposableObserver4.dispose();
            }
        }
    }
}
