package com.iaai.android.bdt.feature.login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.iaai.android.bdt.model.termsofuse.TermsOfUseResponse;
import com.iaai.android.old.utils.constants.Constants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.Observable;
import p011io.reactivex.Observer;
import p011io.reactivex.android.schedulers.AndroidSchedulers;
import p011io.reactivex.observers.DisposableObserver;
import p011io.reactivex.schedulers.Schedulers;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u001e\u001a\u00020\u001bR\"\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012¨\u0006\u001f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/login/TermsOfUseViewModel;", "Landroidx/lifecycle/ViewModel;", "loginRepository", "Lcom/iaai/android/bdt/feature/login/LoginRepository;", "(Lcom/iaai/android/bdt/feature/login/LoginRepository;)V", "disposableObserver", "Lio/reactivex/observers/DisposableObserver;", "Lcom/iaai/android/bdt/model/termsofuse/TermsOfUseResponse;", "getDisposableObserver", "()Lio/reactivex/observers/DisposableObserver;", "setDisposableObserver", "(Lio/reactivex/observers/DisposableObserver;)V", "error", "Landroidx/lifecycle/MutableLiveData;", "", "getError", "()Landroidx/lifecycle/MutableLiveData;", "setError", "(Landroidx/lifecycle/MutableLiveData;)V", "showLoading", "", "getShowLoading", "setShowLoading", "termsOfUseResponse", "getTermsOfUseResponse", "setTermsOfUseResponse", "acceptTermsOfUse", "", "deviceId", "userId", "disposeElements", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: TermsOfUseViewModel.kt */
public final class TermsOfUseViewModel extends ViewModel {
    @NotNull
    public DisposableObserver<TermsOfUseResponse> disposableObserver;
    @NotNull
    private MutableLiveData<String> error = new MutableLiveData<>();
    private final LoginRepository loginRepository;
    @NotNull
    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<TermsOfUseResponse> termsOfUseResponse = new MutableLiveData<>();

    @Inject
    public TermsOfUseViewModel(@NotNull LoginRepository loginRepository2) {
        Intrinsics.checkParameterIsNotNull(loginRepository2, "loginRepository");
        this.loginRepository = loginRepository2;
    }

    @NotNull
    public final MutableLiveData<TermsOfUseResponse> getTermsOfUseResponse() {
        return this.termsOfUseResponse;
    }

    public final void setTermsOfUseResponse(@NotNull MutableLiveData<TermsOfUseResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.termsOfUseResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getError() {
        return this.error;
    }

    public final void setError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.error = mutableLiveData;
    }

    @NotNull
    public final DisposableObserver<TermsOfUseResponse> getDisposableObserver() {
        DisposableObserver<TermsOfUseResponse> disposableObserver2 = this.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        return disposableObserver2;
    }

    public final void setDisposableObserver(@NotNull DisposableObserver<TermsOfUseResponse> disposableObserver2) {
        Intrinsics.checkParameterIsNotNull(disposableObserver2, "<set-?>");
        this.disposableObserver = disposableObserver2;
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowLoading() {
        return this.showLoading;
    }

    public final void setShowLoading(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.showLoading = mutableLiveData;
    }

    public final void acceptTermsOfUse(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkParameterIsNotNull(str, Constants.DEVICEID_HEADER);
        this.showLoading.postValue(true);
        this.disposableObserver = new TermsOfUseViewModel$acceptTermsOfUse$1(this);
        Observable<TermsOfUseResponse> observeOn = this.loginRepository.acceptTermsOfUse(str, str2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<TermsOfUseResponse> disposableObserver2 = this.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        observeOn.subscribe((Observer<? super TermsOfUseResponse>) disposableObserver2);
    }

    public final void disposeElements() {
        if (this.disposableObserver != null) {
            DisposableObserver<TermsOfUseResponse> disposableObserver2 = this.disposableObserver;
            if (disposableObserver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
            }
            if (!disposableObserver2.isDisposed()) {
                DisposableObserver<TermsOfUseResponse> disposableObserver3 = this.disposableObserver;
                if (disposableObserver3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
                }
                disposableObserver3.dispose();
            }
        }
    }
}
