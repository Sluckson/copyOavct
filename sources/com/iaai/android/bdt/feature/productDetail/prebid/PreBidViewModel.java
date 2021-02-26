package com.iaai.android.bdt.feature.productDetail.prebid;

import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.google.gson.Gson;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.feature.productDetail.ProductDetailRepository;
import com.iaai.android.bdt.model.firebaseevent.PlacePreBidQueryModel;
import com.iaai.android.bdt.model.firebaseevent.PreBidHistoryQueryModel;
import com.iaai.android.bdt.model.firebaseevent.ProductDetailQueryModel;
import com.iaai.android.bdt.model.productDetail.biddingInfo.ProductDetailErrorModel;
import com.iaai.android.bdt.model.productDetail.biddingInfo.ProductDetailResponse;
import com.iaai.android.bdt.model.productDetail.prebid.PreBidBidHistory;
import com.iaai.android.bdt.model.productDetail.prebid.PreBidPlacedResult;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.utils.constants.Constants;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;
import p011io.reactivex.Observer;
import p011io.reactivex.android.schedulers.AndroidSchedulers;
import p011io.reactivex.observers.DisposableObserver;
import p011io.reactivex.schedulers.Schedulers;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010,\u001a\u00020-J&\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\bJ\u0016\u00103\u001a\u00020-2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\bJN\u00104\u001a\u00020-2\u0006\u00105\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\b2\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020)J\u001e\u0010;\u001a\u00020-2\u0006\u0010/\u001a\u00020\b2\u0006\u00107\u001a\u0002082\u0006\u0010:\u001a\u00020)J\u000e\u0010<\u001a\u00020-2\u0006\u0010=\u001a\u00020)R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX.¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bX.¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bX.¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R&\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R \u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R \u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017¨\u0006>"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/prebid/PreBidViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/iaai/android/bdt/feature/productDetail/prebid/PreBidRepository;", "productDetailRepository", "Lcom/iaai/android/bdt/feature/productDetail/ProductDetailRepository;", "(Lcom/iaai/android/bdt/feature/productDetail/prebid/PreBidRepository;Lcom/iaai/android/bdt/feature/productDetail/ProductDetailRepository;)V", "TAG", "", "kotlin.jvm.PlatformType", "disposableObserver", "Lio/reactivex/observers/DisposableObserver;", "", "Lcom/iaai/android/bdt/model/productDetail/prebid/PreBidBidHistory;", "disposableObserverProductDetail", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ProductDetailResponse;", "disposableObserverResult", "Lcom/iaai/android/bdt/model/productDetail/prebid/PreBidPlacedResult;", "preBidError", "Landroidx/lifecycle/MutableLiveData;", "getPreBidError", "()Landroidx/lifecycle/MutableLiveData;", "setPreBidError", "(Landroidx/lifecycle/MutableLiveData;)V", "preBidResponse", "getPreBidResponse", "setPreBidResponse", "preBidResultError", "getPreBidResultError", "setPreBidResultError", "preBidResultResponse", "getPreBidResultResponse", "setPreBidResultResponse", "productDetailError", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ProductDetailErrorModel;", "getProductDetailError", "setProductDetailError", "productDetailResponse", "getProductDetailResponse", "setProductDetailResponse", "showLoading", "", "getShowLoading", "setShowLoading", "disposeElements", "", "getBidHistory", "itemId", "userId", "auctionId", "culturecode", "getProductDetail", "placePreBid", "authString", "action", "maxBid", "Ljava/math/BigDecimal;", "currentBid", "isTimedAuction", "sendFireBaseEventBidSuccess", "updateLoadingIndicator", "status", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PreBidViewModel.kt */
public final class PreBidViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public final String TAG = PreBidViewModel.class.getSimpleName();
    /* access modifiers changed from: private */
    public DisposableObserver<List<PreBidBidHistory>> disposableObserver;
    /* access modifiers changed from: private */
    public DisposableObserver<ProductDetailResponse> disposableObserverProductDetail;
    /* access modifiers changed from: private */
    public DisposableObserver<PreBidPlacedResult> disposableObserverResult;
    @NotNull
    private MutableLiveData<String> preBidError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<List<PreBidBidHistory>> preBidResponse = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<String> preBidResultError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<PreBidPlacedResult> preBidResultResponse = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<ProductDetailErrorModel> productDetailError = new MutableLiveData<>();
    private final ProductDetailRepository productDetailRepository;
    @NotNull
    private MutableLiveData<ProductDetailResponse> productDetailResponse = new MutableLiveData<>();
    private final PreBidRepository repository;
    @NotNull
    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();

    public static final /* synthetic */ DisposableObserver access$getDisposableObserver$p(PreBidViewModel preBidViewModel) {
        DisposableObserver<List<PreBidBidHistory>> disposableObserver2 = preBidViewModel.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        return disposableObserver2;
    }

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverProductDetail$p(PreBidViewModel preBidViewModel) {
        DisposableObserver<ProductDetailResponse> disposableObserver2 = preBidViewModel.disposableObserverProductDetail;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverProductDetail");
        }
        return disposableObserver2;
    }

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverResult$p(PreBidViewModel preBidViewModel) {
        DisposableObserver<PreBidPlacedResult> disposableObserver2 = preBidViewModel.disposableObserverResult;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverResult");
        }
        return disposableObserver2;
    }

    @Inject
    public PreBidViewModel(@NotNull PreBidRepository preBidRepository, @NotNull ProductDetailRepository productDetailRepository2) {
        Intrinsics.checkParameterIsNotNull(preBidRepository, "repository");
        Intrinsics.checkParameterIsNotNull(productDetailRepository2, "productDetailRepository");
        this.repository = preBidRepository;
        this.productDetailRepository = productDetailRepository2;
    }

    @NotNull
    public final MutableLiveData<List<PreBidBidHistory>> getPreBidResponse() {
        return this.preBidResponse;
    }

    public final void setPreBidResponse(@NotNull MutableLiveData<List<PreBidBidHistory>> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.preBidResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getPreBidError() {
        return this.preBidError;
    }

    public final void setPreBidError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.preBidError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<PreBidPlacedResult> getPreBidResultResponse() {
        return this.preBidResultResponse;
    }

    public final void setPreBidResultResponse(@NotNull MutableLiveData<PreBidPlacedResult> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.preBidResultResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getPreBidResultError() {
        return this.preBidResultError;
    }

    public final void setPreBidResultError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.preBidResultError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<ProductDetailResponse> getProductDetailResponse() {
        return this.productDetailResponse;
    }

    public final void setProductDetailResponse(@NotNull MutableLiveData<ProductDetailResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.productDetailResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<ProductDetailErrorModel> getProductDetailError() {
        return this.productDetailError;
    }

    public final void setProductDetailError(@NotNull MutableLiveData<ProductDetailErrorModel> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.productDetailError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowLoading() {
        return this.showLoading;
    }

    public final void setShowLoading(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.showLoading = mutableLiveData;
    }

    public final void getBidHistory(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_ITEM_ID);
        Intrinsics.checkParameterIsNotNull(str2, "userId");
        Intrinsics.checkParameterIsNotNull(str3, Constants_MVVM.EXTRA_AUCTION_ID);
        Intrinsics.checkParameterIsNotNull(str4, "culturecode");
        updateLoadingIndicator(true);
        PreBidHistoryQueryModel preBidHistoryQueryModel = new PreBidHistoryQueryModel();
        preBidHistoryQueryModel.setCulturecode$app_productionRelease(Utils.getLanguage());
        preBidHistoryQueryModel.setDevicetype$app_productionRelease("android");
        preBidHistoryQueryModel.setUserId$app_productionRelease(str2);
        preBidHistoryQueryModel.setItemId$app_productionRelease(str);
        preBidHistoryQueryModel.setAuctionid$app_productionRelease(str3);
        this.disposableObserver = new PreBidViewModel$getBidHistory$1(this, new Gson().toJson((Object) preBidHistoryQueryModel));
        Observable<List<PreBidBidHistory>> observeOn = this.repository.getBidHistory(str2, str, str3, str4).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<List<PreBidBidHistory>> disposableObserver2 = this.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        observeOn.subscribe((Observer<? super List<PreBidBidHistory>>) disposableObserver2);
    }

    public final void updateLoadingIndicator(boolean z) {
        this.showLoading.postValue(Boolean.valueOf(z));
    }

    public final void placePreBid(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull BigDecimal bigDecimal, @NotNull BigDecimal bigDecimal2, boolean z) {
        String str7 = str;
        String str8 = str2;
        String str9 = str3;
        String str10 = str4;
        String str11 = str6;
        Intrinsics.checkParameterIsNotNull(str7, "authString");
        Intrinsics.checkParameterIsNotNull(str8, Constants.EXTRA_ITEM_ID);
        Intrinsics.checkParameterIsNotNull(str9, "userId");
        Intrinsics.checkParameterIsNotNull(str10, Constants_MVVM.EXTRA_AUCTION_ID);
        String str12 = str5;
        Intrinsics.checkParameterIsNotNull(str12, "culturecode");
        Intrinsics.checkParameterIsNotNull(str11, "action");
        BigDecimal bigDecimal3 = bigDecimal;
        Intrinsics.checkParameterIsNotNull(bigDecimal3, "maxBid");
        BigDecimal bigDecimal4 = bigDecimal2;
        Intrinsics.checkParameterIsNotNull(bigDecimal4, Constants_MVVM.EXTRA_PRE_BID_CURRENT_BID);
        updateLoadingIndicator(true);
        PlacePreBidQueryModel placePreBidQueryModel = new PlacePreBidQueryModel();
        placePreBidQueryModel.setCulturecode$app_productionRelease(Utils.getLanguage());
        placePreBidQueryModel.setDevicetype$app_productionRelease("android");
        placePreBidQueryModel.setUserId$app_productionRelease(str9);
        placePreBidQueryModel.setItemId$app_productionRelease(str8);
        placePreBidQueryModel.setAuctionid$app_productionRelease(str10);
        placePreBidQueryModel.setAction$app_productionRelease(str11);
        placePreBidQueryModel.setAuthorization$app_productionRelease(str7);
        placePreBidQueryModel.setLogger$app_productionRelease("Mobileapp");
        this.disposableObserverResult = new PreBidViewModel$placePreBid$1(this, new Gson().toJson((Object) placePreBidQueryModel), str2, bigDecimal, z);
        Observable<PreBidPlacedResult> observeOn = this.repository.placePreBid(str7, str8, str9, str10, str12, str11, bigDecimal3, bigDecimal4).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<PreBidPlacedResult> disposableObserver2 = this.disposableObserverResult;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverResult");
        }
        observeOn.subscribe((Observer<? super PreBidPlacedResult>) disposableObserver2);
    }

    public final void disposeElements() {
        PreBidViewModel preBidViewModel = this;
        if (preBidViewModel.disposableObserver != null) {
            DisposableObserver<List<PreBidBidHistory>> disposableObserver2 = this.disposableObserver;
            if (disposableObserver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
            }
            if (!disposableObserver2.isDisposed()) {
                DisposableObserver<List<PreBidBidHistory>> disposableObserver3 = this.disposableObserver;
                if (disposableObserver3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
                }
                disposableObserver3.dispose();
            }
        }
        if (preBidViewModel.disposableObserverResult != null) {
            DisposableObserver<PreBidPlacedResult> disposableObserver4 = this.disposableObserverResult;
            if (disposableObserver4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverResult");
            }
            if (!disposableObserver4.isDisposed()) {
                DisposableObserver<PreBidPlacedResult> disposableObserver5 = this.disposableObserverResult;
                if (disposableObserver5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverResult");
                }
                disposableObserver5.dispose();
            }
        }
        if (preBidViewModel.disposableObserverProductDetail != null) {
            DisposableObserver<ProductDetailResponse> disposableObserver6 = this.disposableObserverProductDetail;
            if (disposableObserver6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverProductDetail");
            }
            if (!disposableObserver6.isDisposed()) {
                DisposableObserver<ProductDetailResponse> disposableObserver7 = this.disposableObserverProductDetail;
                if (disposableObserver7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverProductDetail");
                }
                disposableObserver7.dispose();
            }
        }
    }

    public final void getProductDetail(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_ITEM_ID);
        Intrinsics.checkParameterIsNotNull(str2, "userId");
        updateLoadingIndicator(true);
        ProductDetailQueryModel productDetailQueryModel = new ProductDetailQueryModel();
        productDetailQueryModel.setCulturecode$app_productionRelease(Utils.getLanguage());
        productDetailQueryModel.setDevicetype$app_productionRelease("android");
        productDetailQueryModel.setUserId$app_productionRelease(str2);
        productDetailQueryModel.setItemId$app_productionRelease(str);
        this.disposableObserverProductDetail = new PreBidViewModel$getProductDetail$1(this, new Gson().toJson((Object) productDetailQueryModel));
        Observable observeOn = ProductDetailRepository.getProductDetail$default(this.productDetailRepository, str, str2, (String) null, 4, (Object) null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<ProductDetailResponse> disposableObserver2 = this.disposableObserverProductDetail;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverProductDetail");
        }
        observeOn.subscribe(disposableObserver2);
    }

    public final void sendFireBaseEventBidSuccess(@NotNull String str, @NotNull BigDecimal bigDecimal, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_ITEM_ID);
        Intrinsics.checkParameterIsNotNull(bigDecimal, "maxBid");
        Bundle bundle = new Bundle();
        bundle.putDouble(IAAAnalytics.FireBaseKeyNames.VALUE.getId(), bigDecimal.doubleValue());
        bundle.putString(IAAAnalytics.FireBaseKeyNames.CURRENCY.getId(), IAAAnalytics.FireBaseValueNames.USD.getId());
        bundle.putString(IAAAnalytics.FireBaseKeyNames.ITEM_ID.getId(), str);
        if (z) {
            bundle.putString(IAAAnalytics.FireBaseKeyNames.ORIGIN.getId(), IAAAnalytics.FireBaseValueNames.TIMED_AUCTION.getId());
            Log.e("FIRE_BASE_ANALYTICS", "Sending Event: " + IAAAnalytics.IAAEvents.TIMED_AUCTION.getId() + ' ' + bundle);
        } else {
            bundle.putString(IAAAnalytics.FireBaseKeyNames.ORIGIN.getId(), IAAAnalytics.FireBaseValueNames.PRE_BID.getId());
            Log.e("FIRE_BASE_ANALYTICS", "Sending Event: " + IAAAnalytics.IAAEvents.PRE_BID.getId() + " :" + bundle);
        }
        IAAAnalytics.INSTANCE.logIAAEvent(IAAAnalytics.IAAEvents.ADD_TO_CART, bundle);
    }
}
