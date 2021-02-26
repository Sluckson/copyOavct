package com.iaai.android.bdt.feature.productDetail.buyNow;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.iaai.android.bdt.model.productDetail.buyNow.BuyNowResult;
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

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J.\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0015J\u0006\u0010\u001f\u001a\u00020\u0019J\u000e\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0015R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006\""}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/buyNow/BuyNowViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/iaai/android/bdt/feature/productDetail/buyNow/BuyNowRepository;", "(Lcom/iaai/android/bdt/feature/productDetail/buyNow/BuyNowRepository;)V", "TAG", "", "kotlin.jvm.PlatformType", "buyNowError", "Landroidx/lifecycle/MutableLiveData;", "getBuyNowError", "()Landroidx/lifecycle/MutableLiveData;", "setBuyNowError", "(Landroidx/lifecycle/MutableLiveData;)V", "buyNowResponse", "Lcom/iaai/android/bdt/model/productDetail/buyNow/BuyNowResult;", "getBuyNowResponse", "setBuyNowResponse", "disposableObserver", "Lio/reactivex/observers/DisposableObserver;", "showLoading", "", "getShowLoading", "setShowLoading", "buyNow", "", "authHeader", "itemId", "userId", "auctionId", "isUpstreamBranchStock", "disposeElements", "updateLoadingIndicator", "status", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BuyNowViewModel.kt */
public final class BuyNowViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public final String TAG = BuyNowViewModel.class.getSimpleName();
    @NotNull
    private MutableLiveData<String> buyNowError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<BuyNowResult> buyNowResponse = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public DisposableObserver<BuyNowResult> disposableObserver;
    private final BuyNowRepository repository;
    @NotNull
    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();

    public static final /* synthetic */ DisposableObserver access$getDisposableObserver$p(BuyNowViewModel buyNowViewModel) {
        DisposableObserver<BuyNowResult> disposableObserver2 = buyNowViewModel.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        return disposableObserver2;
    }

    @Inject
    public BuyNowViewModel(@NotNull BuyNowRepository buyNowRepository) {
        Intrinsics.checkParameterIsNotNull(buyNowRepository, "repository");
        this.repository = buyNowRepository;
    }

    @NotNull
    public final MutableLiveData<BuyNowResult> getBuyNowResponse() {
        return this.buyNowResponse;
    }

    public final void setBuyNowResponse(@NotNull MutableLiveData<BuyNowResult> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.buyNowResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getBuyNowError() {
        return this.buyNowError;
    }

    public final void setBuyNowError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.buyNowError = mutableLiveData;
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

    public final void buyNow(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, Constants.EXTRA_ITEM_ID);
        Intrinsics.checkParameterIsNotNull(str3, "userId");
        Intrinsics.checkParameterIsNotNull(str4, Constants_MVVM.EXTRA_AUCTION_ID);
        updateLoadingIndicator(true);
        this.disposableObserver = new BuyNowViewModel$buyNow$1(this);
        Observable<BuyNowResult> observeOn = this.repository.buyNowSubmit(str, str2, str3, str4, z).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<BuyNowResult> disposableObserver2 = this.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        observeOn.subscribe((Observer<? super BuyNowResult>) disposableObserver2);
    }

    public final void disposeElements() {
        if (this.disposableObserver != null) {
            DisposableObserver<BuyNowResult> disposableObserver2 = this.disposableObserver;
            if (disposableObserver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
            }
            if (!disposableObserver2.isDisposed()) {
                DisposableObserver<BuyNowResult> disposableObserver3 = this.disposableObserver;
                if (disposableObserver3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
                }
                disposableObserver3.dispose();
            }
        }
    }
}
