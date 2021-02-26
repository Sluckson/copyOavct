package com.iaai.android.bdt.feature.productDetail.chromeSection;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.iaai.android.bdt.model.productDetail.chromeSection.ChromeData;
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

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0015R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006\u001e"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/chromeSection/ChromeSectionViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/iaai/android/bdt/feature/productDetail/chromeSection/ChromeSectionRepository;", "(Lcom/iaai/android/bdt/feature/productDetail/chromeSection/ChromeSectionRepository;)V", "TAG", "", "kotlin.jvm.PlatformType", "chromeDataError", "Landroidx/lifecycle/MutableLiveData;", "getChromeDataError", "()Landroidx/lifecycle/MutableLiveData;", "setChromeDataError", "(Landroidx/lifecycle/MutableLiveData;)V", "chromeDataResponse", "Lcom/iaai/android/bdt/model/productDetail/chromeSection/ChromeData;", "getChromeDataResponse", "setChromeDataResponse", "disposableObserver", "Lio/reactivex/observers/DisposableObserver;", "showLoading", "", "getShowLoading", "setShowLoading", "disposeElements", "", "getChromeDataByItemId", "itemId", "updateLoadingIndicator", "status", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ChromeSectionViewModel.kt */
public final class ChromeSectionViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public final String TAG = ChromeSectionViewModel.class.getSimpleName();
    @NotNull
    private MutableLiveData<String> chromeDataError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<ChromeData> chromeDataResponse = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public DisposableObserver<ChromeData> disposableObserver;
    private final ChromeSectionRepository repository;
    @NotNull
    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();

    public static final /* synthetic */ DisposableObserver access$getDisposableObserver$p(ChromeSectionViewModel chromeSectionViewModel) {
        DisposableObserver<ChromeData> disposableObserver2 = chromeSectionViewModel.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        return disposableObserver2;
    }

    @Inject
    public ChromeSectionViewModel(@NotNull ChromeSectionRepository chromeSectionRepository) {
        Intrinsics.checkParameterIsNotNull(chromeSectionRepository, "repository");
        this.repository = chromeSectionRepository;
    }

    @NotNull
    public final MutableLiveData<ChromeData> getChromeDataResponse() {
        return this.chromeDataResponse;
    }

    public final void setChromeDataResponse(@NotNull MutableLiveData<ChromeData> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.chromeDataResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getChromeDataError() {
        return this.chromeDataError;
    }

    public final void setChromeDataError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.chromeDataError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowLoading() {
        return this.showLoading;
    }

    public final void setShowLoading(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.showLoading = mutableLiveData;
    }

    public final void updateLoadingIndicator(boolean z) {
        this.showLoading.postValue(Boolean.valueOf(z));
    }

    public final void getChromeDataByItemId(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_ITEM_ID);
        updateLoadingIndicator(true);
        this.disposableObserver = new ChromeSectionViewModel$getChromeDataByItemId$1(this);
        Observable<ChromeData> observeOn = this.repository.getChromeDataByItemId(str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<ChromeData> disposableObserver2 = this.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        observeOn.subscribe((Observer<? super ChromeData>) disposableObserver2);
    }

    public final void disposeElements() {
        if (this.disposableObserver != null) {
            DisposableObserver<ChromeData> disposableObserver2 = this.disposableObserver;
            if (disposableObserver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
            }
            if (!disposableObserver2.isDisposed()) {
                DisposableObserver<ChromeData> disposableObserver3 = this.disposableObserver;
                if (disposableObserver3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
                }
                disposableObserver3.dispose();
            }
        }
    }
}
