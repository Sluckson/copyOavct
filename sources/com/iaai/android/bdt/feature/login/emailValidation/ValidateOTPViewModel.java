package com.iaai.android.bdt.feature.login.emailValidation;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.iaai.android.bdt.feature.login.LoginRepository;
import com.iaai.android.bdt.model.login.GenerateOTPResponse;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;
import p011io.reactivex.Observer;
import p011io.reactivex.android.schedulers.AndroidSchedulers;
import p011io.reactivex.observers.DisposableObserver;
import p011io.reactivex.schedulers.Schedulers;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0016\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0018J\u0016\u0010#\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0018R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X.¢\u0006\u0002\n\u0000R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012¨\u0006%"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/login/emailValidation/ValidateOTPViewModel;", "Landroidx/lifecycle/ViewModel;", "loginRepository", "Lcom/iaai/android/bdt/feature/login/LoginRepository;", "(Lcom/iaai/android/bdt/feature/login/LoginRepository;)V", "disposableObserverGenerateOTP", "Lio/reactivex/observers/DisposableObserver;", "Lcom/iaai/android/bdt/model/login/GenerateOTPResponse;", "disposableObserverValidateOTP", "getDisposableObserverValidateOTP", "()Lio/reactivex/observers/DisposableObserver;", "setDisposableObserverValidateOTP", "(Lio/reactivex/observers/DisposableObserver;)V", "generateOTPResponse", "Landroidx/lifecycle/MutableLiveData;", "getGenerateOTPResponse", "()Landroidx/lifecycle/MutableLiveData;", "setGenerateOTPResponse", "(Landroidx/lifecycle/MutableLiveData;)V", "showLoading", "", "getShowLoading", "setShowLoading", "validateOTPError", "", "getValidateOTPError", "setValidateOTPError", "validateOTPResponse", "getValidateOTPResponse", "setValidateOTPResponse", "disposeElements", "", "generateOTP", "userId", "email", "validateOTP", "otp", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ValidateOTPViewModel.kt */
public final class ValidateOTPViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public DisposableObserver<GenerateOTPResponse> disposableObserverGenerateOTP;
    @NotNull
    public DisposableObserver<GenerateOTPResponse> disposableObserverValidateOTP;
    @NotNull
    private MutableLiveData<GenerateOTPResponse> generateOTPResponse = new MutableLiveData<>();
    private final LoginRepository loginRepository;
    @NotNull
    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<String> validateOTPError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<GenerateOTPResponse> validateOTPResponse = new MutableLiveData<>();

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverGenerateOTP$p(ValidateOTPViewModel validateOTPViewModel) {
        DisposableObserver<GenerateOTPResponse> disposableObserver = validateOTPViewModel.disposableObserverGenerateOTP;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverGenerateOTP");
        }
        return disposableObserver;
    }

    @Inject
    public ValidateOTPViewModel(@NotNull LoginRepository loginRepository2) {
        Intrinsics.checkParameterIsNotNull(loginRepository2, "loginRepository");
        this.loginRepository = loginRepository2;
    }

    @NotNull
    public final MutableLiveData<GenerateOTPResponse> getValidateOTPResponse() {
        return this.validateOTPResponse;
    }

    public final void setValidateOTPResponse(@NotNull MutableLiveData<GenerateOTPResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.validateOTPResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getValidateOTPError() {
        return this.validateOTPError;
    }

    public final void setValidateOTPError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.validateOTPError = mutableLiveData;
    }

    @NotNull
    public final DisposableObserver<GenerateOTPResponse> getDisposableObserverValidateOTP() {
        DisposableObserver<GenerateOTPResponse> disposableObserver = this.disposableObserverValidateOTP;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverValidateOTP");
        }
        return disposableObserver;
    }

    public final void setDisposableObserverValidateOTP(@NotNull DisposableObserver<GenerateOTPResponse> disposableObserver) {
        Intrinsics.checkParameterIsNotNull(disposableObserver, "<set-?>");
        this.disposableObserverValidateOTP = disposableObserver;
    }

    @NotNull
    public final MutableLiveData<GenerateOTPResponse> getGenerateOTPResponse() {
        return this.generateOTPResponse;
    }

    public final void setGenerateOTPResponse(@NotNull MutableLiveData<GenerateOTPResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.generateOTPResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowLoading() {
        return this.showLoading;
    }

    public final void setShowLoading(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.showLoading = mutableLiveData;
    }

    public final void validateOTP(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "userId");
        Intrinsics.checkParameterIsNotNull(str2, "otp");
        this.showLoading.postValue(true);
        this.disposableObserverValidateOTP = new ValidateOTPViewModel$validateOTP$1(this);
        Observable<GenerateOTPResponse> observeOn = this.loginRepository.validateOTP(str, str2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<GenerateOTPResponse> disposableObserver = this.disposableObserverValidateOTP;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverValidateOTP");
        }
        observeOn.subscribe((Observer<? super GenerateOTPResponse>) disposableObserver);
    }

    public final void generateOTP(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "userId");
        Intrinsics.checkParameterIsNotNull(str2, "email");
        this.showLoading.postValue(true);
        this.disposableObserverGenerateOTP = new ValidateOTPViewModel$generateOTP$1(this);
        Observable<GenerateOTPResponse> observeOn = this.loginRepository.generateOTP(str, str2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<GenerateOTPResponse> disposableObserver = this.disposableObserverGenerateOTP;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverGenerateOTP");
        }
        observeOn.subscribe((Observer<? super GenerateOTPResponse>) disposableObserver);
    }

    public final void disposeElements() {
        ValidateOTPViewModel validateOTPViewModel = this;
        if (validateOTPViewModel.disposableObserverValidateOTP != null) {
            DisposableObserver<GenerateOTPResponse> disposableObserver = this.disposableObserverValidateOTP;
            if (disposableObserver == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverValidateOTP");
            }
            if (!disposableObserver.isDisposed()) {
                DisposableObserver<GenerateOTPResponse> disposableObserver2 = this.disposableObserverValidateOTP;
                if (disposableObserver2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverValidateOTP");
                }
                disposableObserver2.dispose();
            }
        }
        if (validateOTPViewModel.disposableObserverGenerateOTP != null) {
            DisposableObserver<GenerateOTPResponse> disposableObserver3 = this.disposableObserverGenerateOTP;
            if (disposableObserver3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverGenerateOTP");
            }
            if (!disposableObserver3.isDisposed()) {
                DisposableObserver<GenerateOTPResponse> disposableObserver4 = this.disposableObserverGenerateOTP;
                if (disposableObserver4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverGenerateOTP");
                }
                disposableObserver4.dispose();
            }
        }
    }
}
