package com.iaai.android.bdt.feature.digitalNegotiation;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.iaai.android.bdt.model.digitalNegotiation.DigitalNegotiationListClass;
import com.iaai.android.bdt.model.digitalNegotiation.ManageOfferSendActionRequestBody;
import com.iaai.android.bdt.model.digitalNegotiation.ManageOfferSendActionResponse;
import com.iaai.android.bdt.utils.Constants_MVVM;
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
import repack.org.bouncycastle.cms.CMSAttributeTableGenerator;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010&\u001a\u00020'J\u001e\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006J\b\u0010,\u001a\u00020'H\u0014J>\u0010-\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u000204J\u000e\u00105\u001a\u00020'2\u0006\u00106\u001a\u00020#R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014R \u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014¨\u00067"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListRepository;", "(Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListRepository;)V", "TAG", "", "kotlin.jvm.PlatformType", "manageOfferDisposableObserver", "Lio/reactivex/observers/DisposableObserver;", "Lcom/iaai/android/bdt/model/digitalNegotiation/DigitalNegotiationListClass;", "getManageOfferDisposableObserver", "()Lio/reactivex/observers/DisposableObserver;", "setManageOfferDisposableObserver", "(Lio/reactivex/observers/DisposableObserver;)V", "manageOfferError", "Landroidx/lifecycle/MutableLiveData;", "getManageOfferError", "()Landroidx/lifecycle/MutableLiveData;", "setManageOfferError", "(Landroidx/lifecycle/MutableLiveData;)V", "manageOfferResult", "getManageOfferResult", "setManageOfferResult", "sendActionDisposableObserver", "Lcom/iaai/android/bdt/model/digitalNegotiation/ManageOfferSendActionResponse;", "getSendActionDisposableObserver", "setSendActionDisposableObserver", "sendActionError", "getSendActionError", "setSendActionError", "sendActionResult", "getSendActionResult", "setSendActionResult", "showLoading", "", "getShowLoading", "setShowLoading", "disposeElements", "", "loadManageOfferList", "authHeader", "culturecode", "salvageID", "onCleared", "sendManageOfferAction", "deviceid", "devicetype", "apikey", "contentType", "appversion", "requestBody", "Lcom/iaai/android/bdt/model/digitalNegotiation/ManageOfferSendActionRequestBody;", "updateLoadingIndicator", "status", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ManageOfferListViewModel.kt */
public final class ManageOfferListViewModel extends ViewModel {
    private final String TAG = ManageOfferListViewModel.class.getSimpleName();
    @NotNull
    public DisposableObserver<DigitalNegotiationListClass> manageOfferDisposableObserver;
    @NotNull
    private MutableLiveData<String> manageOfferError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<DigitalNegotiationListClass> manageOfferResult = new MutableLiveData<>();
    private final ManageOfferListRepository repository;
    @NotNull
    public DisposableObserver<ManageOfferSendActionResponse> sendActionDisposableObserver;
    @NotNull
    private MutableLiveData<String> sendActionError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<ManageOfferSendActionResponse> sendActionResult = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();

    @Inject
    public ManageOfferListViewModel(@NotNull ManageOfferListRepository manageOfferListRepository) {
        Intrinsics.checkParameterIsNotNull(manageOfferListRepository, "repository");
        this.repository = manageOfferListRepository;
    }

    @NotNull
    public final MutableLiveData<DigitalNegotiationListClass> getManageOfferResult() {
        return this.manageOfferResult;
    }

    public final void setManageOfferResult(@NotNull MutableLiveData<DigitalNegotiationListClass> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.manageOfferResult = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getManageOfferError() {
        return this.manageOfferError;
    }

    public final void setManageOfferError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.manageOfferError = mutableLiveData;
    }

    @NotNull
    public final DisposableObserver<DigitalNegotiationListClass> getManageOfferDisposableObserver() {
        DisposableObserver<DigitalNegotiationListClass> disposableObserver = this.manageOfferDisposableObserver;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferDisposableObserver");
        }
        return disposableObserver;
    }

    public final void setManageOfferDisposableObserver(@NotNull DisposableObserver<DigitalNegotiationListClass> disposableObserver) {
        Intrinsics.checkParameterIsNotNull(disposableObserver, "<set-?>");
        this.manageOfferDisposableObserver = disposableObserver;
    }

    @NotNull
    public final MutableLiveData<ManageOfferSendActionResponse> getSendActionResult() {
        return this.sendActionResult;
    }

    public final void setSendActionResult(@NotNull MutableLiveData<ManageOfferSendActionResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.sendActionResult = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getSendActionError() {
        return this.sendActionError;
    }

    public final void setSendActionError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.sendActionError = mutableLiveData;
    }

    @NotNull
    public final DisposableObserver<ManageOfferSendActionResponse> getSendActionDisposableObserver() {
        DisposableObserver<ManageOfferSendActionResponse> disposableObserver = this.sendActionDisposableObserver;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendActionDisposableObserver");
        }
        return disposableObserver;
    }

    public final void setSendActionDisposableObserver(@NotNull DisposableObserver<ManageOfferSendActionResponse> disposableObserver) {
        Intrinsics.checkParameterIsNotNull(disposableObserver, "<set-?>");
        this.sendActionDisposableObserver = disposableObserver;
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowLoading() {
        return this.showLoading;
    }

    public final void setShowLoading(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.showLoading = mutableLiveData;
    }

    public final void loadManageOfferList(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "culturecode");
        Intrinsics.checkParameterIsNotNull(str3, Constants_MVVM.EXTRA_SALVAGE_ID);
        updateLoadingIndicator(true);
        this.manageOfferDisposableObserver = new ManageOfferListViewModel$loadManageOfferList$1(this);
        Observable<DigitalNegotiationListClass> observeOn = this.repository.getNegotiationList(str, str2, str3).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<DigitalNegotiationListClass> disposableObserver = this.manageOfferDisposableObserver;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferDisposableObserver");
        }
        observeOn.subscribe((Observer<? super DigitalNegotiationListClass>) disposableObserver);
    }

    public final void sendManageOfferAction(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull ManageOfferSendActionRequestBody manageOfferSendActionRequestBody) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "deviceid");
        Intrinsics.checkParameterIsNotNull(str3, Constants.DEVICETYPE_HEADER);
        Intrinsics.checkParameterIsNotNull(str4, "apikey");
        Intrinsics.checkParameterIsNotNull(str5, CMSAttributeTableGenerator.CONTENT_TYPE);
        String str7 = str6;
        Intrinsics.checkParameterIsNotNull(str7, "appversion");
        ManageOfferSendActionRequestBody manageOfferSendActionRequestBody2 = manageOfferSendActionRequestBody;
        Intrinsics.checkParameterIsNotNull(manageOfferSendActionRequestBody2, "requestBody");
        updateLoadingIndicator(true);
        this.sendActionDisposableObserver = new ManageOfferListViewModel$sendManageOfferAction$1(this);
        Observable<ManageOfferSendActionResponse> observeOn = this.repository.sendManageOfferAction(str, str2, str3, str4, str5, str7, manageOfferSendActionRequestBody2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<ManageOfferSendActionResponse> disposableObserver = this.sendActionDisposableObserver;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendActionDisposableObserver");
        }
        observeOn.subscribe((Observer<? super ManageOfferSendActionResponse>) disposableObserver);
    }

    public final void updateLoadingIndicator(boolean z) {
        this.showLoading.postValue(Boolean.valueOf(z));
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        ManageOfferListViewModel manageOfferListViewModel = this;
        if (manageOfferListViewModel.manageOfferDisposableObserver != null) {
            DisposableObserver<DigitalNegotiationListClass> disposableObserver = this.manageOfferDisposableObserver;
            if (disposableObserver == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manageOfferDisposableObserver");
            }
            if (!disposableObserver.isDisposed()) {
                DisposableObserver<DigitalNegotiationListClass> disposableObserver2 = this.manageOfferDisposableObserver;
                if (disposableObserver2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("manageOfferDisposableObserver");
                }
                disposableObserver2.dispose();
            }
        }
        if (manageOfferListViewModel.sendActionDisposableObserver != null) {
            DisposableObserver<ManageOfferSendActionResponse> disposableObserver3 = this.sendActionDisposableObserver;
            if (disposableObserver3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sendActionDisposableObserver");
            }
            if (!disposableObserver3.isDisposed()) {
                DisposableObserver<ManageOfferSendActionResponse> disposableObserver4 = this.sendActionDisposableObserver;
                if (disposableObserver4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sendActionDisposableObserver");
                }
                disposableObserver4.dispose();
            }
        }
    }

    public final void disposeElements() {
        ManageOfferListViewModel manageOfferListViewModel = this;
        if (manageOfferListViewModel.manageOfferDisposableObserver != null) {
            DisposableObserver<DigitalNegotiationListClass> disposableObserver = this.manageOfferDisposableObserver;
            if (disposableObserver == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manageOfferDisposableObserver");
            }
            if (!disposableObserver.isDisposed()) {
                DisposableObserver<DigitalNegotiationListClass> disposableObserver2 = this.manageOfferDisposableObserver;
                if (disposableObserver2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("manageOfferDisposableObserver");
                }
                disposableObserver2.dispose();
            }
        }
        if (manageOfferListViewModel.sendActionDisposableObserver != null) {
            DisposableObserver<ManageOfferSendActionResponse> disposableObserver3 = this.sendActionDisposableObserver;
            if (disposableObserver3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sendActionDisposableObserver");
            }
            if (!disposableObserver3.isDisposed()) {
                DisposableObserver<ManageOfferSendActionResponse> disposableObserver4 = this.sendActionDisposableObserver;
                if (disposableObserver4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sendActionDisposableObserver");
                }
                disposableObserver4.dispose();
            }
        }
    }
}
