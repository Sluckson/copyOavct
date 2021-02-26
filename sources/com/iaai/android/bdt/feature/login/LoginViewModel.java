package com.iaai.android.bdt.feature.login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.iaai.android.bdt.model.login.AuctionRuleResponse;
import com.iaai.android.bdt.model.login.BDTLoginResponse;
import com.iaai.android.bdt.model.login.FCMTokenResponse;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;
import p011io.reactivex.Observer;
import p011io.reactivex.android.schedulers.AndroidSchedulers;
import p011io.reactivex.observers.DisposableObserver;
import p011io.reactivex.schedulers.Schedulers;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0007J\u0006\u0010(\u001a\u00020&J\u0016\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007J\u0016\u0010,\u001a\u00020&2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007J\u001e\u0010-\u001a\u00020&2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0011X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0011X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0011X.¢\u0006\u0002\n\u0000R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u000bR \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u000bR \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\t\"\u0004\b\u001e\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\t\"\u0004\b!\u0010\u000bR \u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\t\"\u0004\b$\u0010\u000b¨\u0006/"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/login/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "loginRepository", "Lcom/iaai/android/bdt/feature/login/LoginRepository;", "(Lcom/iaai/android/bdt/feature/login/LoginRepository;)V", "auctionRuleError", "Landroidx/lifecycle/MutableLiveData;", "", "getAuctionRuleError", "()Landroidx/lifecycle/MutableLiveData;", "setAuctionRuleError", "(Landroidx/lifecycle/MutableLiveData;)V", "auctionRuleResponse", "Lcom/iaai/android/bdt/model/login/AuctionRuleResponse;", "getAuctionRuleResponse", "setAuctionRuleResponse", "disposableObserverAuctionRuleResponse", "Lio/reactivex/observers/DisposableObserver;", "disposableObserverFCMToken", "Lcom/iaai/android/bdt/model/login/FCMTokenResponse;", "disposableObserverIsValidEmail", "", "disposableObserverLogin", "Lcom/iaai/android/bdt/model/login/BDTLoginResponse;", "isValidEmail", "setValidEmail", "isValidEmailError", "setValidEmailError", "loginError", "getLoginError", "setLoginError", "loginResponse", "getLoginResponse", "setLoginResponse", "showLoading", "getShowLoading", "setShowLoading", "checkIsValidEmail", "", "email", "disposeElements", "getTermsOfUseAuctionRule", "username", "password", "login", "registerFCMToken", "token", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: LoginViewModel.kt */
public final class LoginViewModel extends ViewModel {
    @NotNull
    private MutableLiveData<String> auctionRuleError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<AuctionRuleResponse> auctionRuleResponse = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public DisposableObserver<AuctionRuleResponse> disposableObserverAuctionRuleResponse;
    /* access modifiers changed from: private */
    public DisposableObserver<FCMTokenResponse> disposableObserverFCMToken;
    /* access modifiers changed from: private */
    public DisposableObserver<Boolean> disposableObserverIsValidEmail;
    /* access modifiers changed from: private */
    public DisposableObserver<BDTLoginResponse> disposableObserverLogin;
    @NotNull
    private MutableLiveData<Boolean> isValidEmail = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<String> isValidEmailError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<String> loginError = new MutableLiveData<>();
    private final LoginRepository loginRepository;
    @NotNull
    private MutableLiveData<BDTLoginResponse> loginResponse = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverAuctionRuleResponse$p(LoginViewModel loginViewModel) {
        DisposableObserver<AuctionRuleResponse> disposableObserver = loginViewModel.disposableObserverAuctionRuleResponse;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverAuctionRuleResponse");
        }
        return disposableObserver;
    }

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverFCMToken$p(LoginViewModel loginViewModel) {
        DisposableObserver<FCMTokenResponse> disposableObserver = loginViewModel.disposableObserverFCMToken;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverFCMToken");
        }
        return disposableObserver;
    }

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverIsValidEmail$p(LoginViewModel loginViewModel) {
        DisposableObserver<Boolean> disposableObserver = loginViewModel.disposableObserverIsValidEmail;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverIsValidEmail");
        }
        return disposableObserver;
    }

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverLogin$p(LoginViewModel loginViewModel) {
        DisposableObserver<BDTLoginResponse> disposableObserver = loginViewModel.disposableObserverLogin;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverLogin");
        }
        return disposableObserver;
    }

    @Inject
    public LoginViewModel(@NotNull LoginRepository loginRepository2) {
        Intrinsics.checkParameterIsNotNull(loginRepository2, "loginRepository");
        this.loginRepository = loginRepository2;
    }

    @NotNull
    public final MutableLiveData<BDTLoginResponse> getLoginResponse() {
        return this.loginResponse;
    }

    public final void setLoginResponse(@NotNull MutableLiveData<BDTLoginResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.loginResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getLoginError() {
        return this.loginError;
    }

    public final void setLoginError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.loginError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<AuctionRuleResponse> getAuctionRuleResponse() {
        return this.auctionRuleResponse;
    }

    public final void setAuctionRuleResponse(@NotNull MutableLiveData<AuctionRuleResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.auctionRuleResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getAuctionRuleError() {
        return this.auctionRuleError;
    }

    public final void setAuctionRuleError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.auctionRuleError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> isValidEmail() {
        return this.isValidEmail;
    }

    public final void setValidEmail(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.isValidEmail = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> isValidEmailError() {
        return this.isValidEmailError;
    }

    public final void setValidEmailError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.isValidEmailError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowLoading() {
        return this.showLoading;
    }

    public final void setShowLoading(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.showLoading = mutableLiveData;
    }

    public final void login(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "username");
        Intrinsics.checkParameterIsNotNull(str2, "password");
        this.showLoading.postValue(true);
        this.disposableObserverLogin = new LoginViewModel$login$1(this);
        Observable<BDTLoginResponse> observeOn = this.loginRepository.login(str, str2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<BDTLoginResponse> disposableObserver = this.disposableObserverLogin;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverLogin");
        }
        observeOn.subscribe((Observer<? super BDTLoginResponse>) disposableObserver);
    }

    public final void getTermsOfUseAuctionRule(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "username");
        Intrinsics.checkParameterIsNotNull(str2, "password");
        this.showLoading.postValue(true);
        this.disposableObserverAuctionRuleResponse = new LoginViewModel$getTermsOfUseAuctionRule$1(this);
        Observable<AuctionRuleResponse> observeOn = this.loginRepository.getTermsOfUseAuctionRule(str, str2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<AuctionRuleResponse> disposableObserver = this.disposableObserverAuctionRuleResponse;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverAuctionRuleResponse");
        }
        observeOn.subscribe((Observer<? super AuctionRuleResponse>) disposableObserver);
    }

    public final void checkIsValidEmail(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "email");
        this.showLoading.postValue(true);
        this.disposableObserverIsValidEmail = new LoginViewModel$checkIsValidEmail$1(this);
        Observable<Boolean> observeOn = this.loginRepository.checkIsValidEmail(str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<Boolean> disposableObserver = this.disposableObserverIsValidEmail;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverIsValidEmail");
        }
        observeOn.subscribe((Observer<? super Boolean>) disposableObserver);
    }

    public final void registerFCMToken(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "username");
        Intrinsics.checkParameterIsNotNull(str2, "password");
        Intrinsics.checkParameterIsNotNull(str3, "token");
        this.disposableObserverFCMToken = new LoginViewModel$registerFCMToken$1();
        Observable<FCMTokenResponse> observeOn = this.loginRepository.registerFCMToken(str, str2, str3).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<FCMTokenResponse> disposableObserver = this.disposableObserverFCMToken;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverFCMToken");
        }
        observeOn.subscribe((Observer<? super FCMTokenResponse>) disposableObserver);
    }

    public final void disposeElements() {
        LoginViewModel loginViewModel = this;
        if (loginViewModel.disposableObserverLogin != null) {
            DisposableObserver<BDTLoginResponse> disposableObserver = this.disposableObserverLogin;
            if (disposableObserver == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverLogin");
            }
            if (!disposableObserver.isDisposed()) {
                DisposableObserver<BDTLoginResponse> disposableObserver2 = this.disposableObserverLogin;
                if (disposableObserver2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverLogin");
                }
                disposableObserver2.dispose();
            }
        }
        if (loginViewModel.disposableObserverAuctionRuleResponse != null) {
            DisposableObserver<AuctionRuleResponse> disposableObserver3 = this.disposableObserverAuctionRuleResponse;
            if (disposableObserver3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverAuctionRuleResponse");
            }
            if (!disposableObserver3.isDisposed()) {
                DisposableObserver<AuctionRuleResponse> disposableObserver4 = this.disposableObserverAuctionRuleResponse;
                if (disposableObserver4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverAuctionRuleResponse");
                }
                disposableObserver4.dispose();
            }
        }
        if (loginViewModel.disposableObserverIsValidEmail != null) {
            DisposableObserver<Boolean> disposableObserver5 = this.disposableObserverIsValidEmail;
            if (disposableObserver5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverIsValidEmail");
            }
            if (!disposableObserver5.isDisposed()) {
                DisposableObserver<Boolean> disposableObserver6 = this.disposableObserverIsValidEmail;
                if (disposableObserver6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverIsValidEmail");
                }
                disposableObserver6.dispose();
            }
        }
        if (loginViewModel.disposableObserverFCMToken != null) {
            DisposableObserver<FCMTokenResponse> disposableObserver7 = this.disposableObserverFCMToken;
            if (disposableObserver7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverFCMToken");
            }
            if (!disposableObserver7.isDisposed()) {
                DisposableObserver<FCMTokenResponse> disposableObserver8 = this.disposableObserverFCMToken;
                if (disposableObserver8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverFCMToken");
                }
                disposableObserver8.dispose();
            }
        }
    }
}
