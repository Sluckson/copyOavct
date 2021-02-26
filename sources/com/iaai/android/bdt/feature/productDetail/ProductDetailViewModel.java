package com.iaai.android.bdt.feature.productDetail;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.google.gson.Gson;
import com.iaai.android.bdt.feature.watchList.WatchRepository;
import com.iaai.android.bdt.model.firebaseevent.BuyNowOfferQueryModel;
import com.iaai.android.bdt.model.firebaseevent.ProductDetailQueryModel;
import com.iaai.android.bdt.model.firebaseevent.WatchStatusQueryModel;
import com.iaai.android.bdt.model.productDetail.biddingInfo.ImageInformation;
import com.iaai.android.bdt.model.productDetail.biddingInfo.ProductDetailErrorModel;
import com.iaai.android.bdt.model.productDetail.biddingInfo.ProductDetailResponse;
import com.iaai.android.bdt.model.productDetail.biddingInfo.WarningTextModel;
import com.iaai.android.bdt.model.productDetail.buyNowOffer.BDTBuyNowOfferResult;
import com.iaai.android.bdt.model.productDetail.partsSection.PartsSectionResponse;
import com.iaai.android.bdt.model.profile.UpdateWatchListResponse;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.utils.DateHelper;
import com.iaai.android.old.utils.constants.Constants;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.Observable;
import p011io.reactivex.Observer;
import p011io.reactivex.android.schedulers.AndroidSchedulers;
import p011io.reactivex.observers.DisposableObserver;
import p011io.reactivex.schedulers.Schedulers;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J.\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\b2\u0006\u0010W\u001a\u00020\b2\u0006\u0010X\u001a\u00020\b2\u0006\u0010Y\u001a\u00020\b2\u0006\u0010Z\u001a\u00020\bJ.\u0010[\u001a\u00020U2\u0006\u0010V\u001a\u00020\b2\u0006\u0010W\u001a\u00020\b2\u0006\u0010X\u001a\u00020\b2\u0006\u0010Y\u001a\u00020\b2\u0006\u0010Z\u001a\u00020\bJ\u0006\u0010\\\u001a\u00020UJ\u0010\u0010]\u001a\u00020U2\b\u0010^\u001a\u0004\u0018\u00010\bJ\u0016\u0010_\u001a\u00020U2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\b0,H\u0002J\u001e\u0010a\u001a\u00020U2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010D\u001a\u00020(H\u0002J\u0015\u0010c\u001a\u00020U2\b\u0010d\u001a\u0004\u0018\u00010e¢\u0006\u0002\u0010fJ\u001e\u0010g\u001a\u00020U2\u0006\u0010W\u001a\u00020\b2\u0006\u0010V\u001a\u00020\b2\u0006\u0010h\u001a\u00020\bJ\u000e\u0010i\u001a\u00020U2\u0006\u0010j\u001a\u00020HJ&\u0010k\u001a\u00020U2\u0006\u0010l\u001a\u00020\b2\u0006\u0010W\u001a\u00020\b2\u0006\u0010V\u001a\u00020\b2\u0006\u0010m\u001a\u00020\bR\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR \u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000fR \u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'X.¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00110'X.¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\b0'X.¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0'X.¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020/0'X.¢\u0006\u0002\n\u0000R \u00100\u001a\b\u0012\u0004\u0012\u0002010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\r\"\u0004\b3\u0010\u000fR \u00104\u001a\b\u0012\u0004\u0012\u0002050\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\r\"\u0004\b7\u0010\u000fR \u00108\u001a\b\u0012\u0004\u0012\u00020(0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fR \u0010;\u001a\b\u0012\u0004\u0012\u00020\b0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\r\"\u0004\b=\u0010\u000fR&\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\r\"\u0004\b@\u0010\u000fR \u0010A\u001a\b\u0012\u0004\u0012\u0002050\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\r\"\u0004\bC\u0010\u000fR \u0010D\u001a\b\u0012\u0004\u0012\u00020(0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\r\"\u0004\bF\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010G\u001a\b\u0012\u0004\u0012\u00020H0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\r\"\u0004\bJ\u0010\u000fR \u0010K\u001a\b\u0012\u0004\u0012\u00020H0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\r\"\u0004\bM\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R \u0010N\u001a\b\u0012\u0004\u0012\u00020\b0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\r\"\u0004\bP\u0010\u000fR \u0010Q\u001a\b\u0012\u0004\u0012\u00020/0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\r\"\u0004\bS\u0010\u000f¨\u0006n"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/ProductDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/iaai/android/bdt/feature/productDetail/ProductDetailRepository;", "watchRepository", "Lcom/iaai/android/bdt/feature/watchList/WatchRepository;", "(Lcom/iaai/android/bdt/feature/productDetail/ProductDetailRepository;Lcom/iaai/android/bdt/feature/watchList/WatchRepository;)V", "TAG", "", "kotlin.jvm.PlatformType", "acceptBuyNowOfferError", "Landroidx/lifecycle/MutableLiveData;", "getAcceptBuyNowOfferError", "()Landroidx/lifecycle/MutableLiveData;", "setAcceptBuyNowOfferError", "(Landroidx/lifecycle/MutableLiveData;)V", "acceptBuyNowOfferResponse", "Lcom/iaai/android/bdt/model/productDetail/buyNowOffer/BDTBuyNowOfferResult;", "getAcceptBuyNowOfferResponse", "setAcceptBuyNowOfferResponse", "bidLiveData", "Lcom/iaai/android/bdt/utils/Constants_MVVM$BidAction;", "getBidLiveData", "setBidLiveData", "biddingNotesText", "Landroid/text/Spanned;", "getBiddingNotesText", "setBiddingNotesText", "biddingWarningText", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/WarningTextModel;", "getBiddingWarningText", "setBiddingWarningText", "declineBuyNowOfferError", "getDeclineBuyNowOfferError", "setDeclineBuyNowOfferError", "declineBuyNowOfferResponse", "getDeclineBuyNowOfferResponse", "setDeclineBuyNowOfferResponse", "disposableObserver", "Lio/reactivex/observers/DisposableObserver;", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ProductDetailResponse;", "disposableObserverAcceptBuyNowOffer", "disposableObserverDeclineBuyNowOffer", "disposableObserverParts", "", "Lcom/iaai/android/bdt/model/productDetail/partsSection/PartsSectionResponse;", "disposableObserverUpdateWatchStatus", "Lcom/iaai/android/bdt/model/profile/UpdateWatchListResponse;", "imagesResponse", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ImageInformation;", "getImagesResponse", "setImagesResponse", "nonUsProductDetailError", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ProductDetailErrorModel;", "getNonUsProductDetailError", "setNonUsProductDetailError", "nonUsProductDetailResponse", "getNonUsProductDetailResponse", "setNonUsProductDetailResponse", "partsError", "getPartsError", "setPartsError", "partsInfoResponse", "getPartsInfoResponse", "setPartsInfoResponse", "productDetailError", "getProductDetailError", "setProductDetailError", "productDetailResponse", "getProductDetailResponse", "setProductDetailResponse", "showEmptyState", "", "getShowEmptyState", "setShowEmptyState", "showLoading", "getShowLoading", "setShowLoading", "watchStatusError", "getWatchStatusError", "setWatchStatusError", "watchStatusResponse", "getWatchStatusResponse", "setWatchStatusResponse", "acceptBuyNowOffer", "", "userId", "itemId", "auctionId", "branchId", "stockId", "declineBuyNowOffer", "disposeElements", "getBidLiveStatus", "liveData", "getBiddingNotes", "notes", "getBiddingWarnings", "warnings", "getPartsSectionInfo", "salvageId", "", "(Ljava/lang/Integer;)V", "getProductDetail", "tenantCode", "updateLoadingIndicator", "status", "updateWatchStatus", "authHeader", "action", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailViewModel.kt */
public final class ProductDetailViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public final String TAG = ProductDetailViewModel.class.getSimpleName();
    @NotNull
    private MutableLiveData<String> acceptBuyNowOfferError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<BDTBuyNowOfferResult> acceptBuyNowOfferResponse = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Constants_MVVM.BidAction> bidLiveData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Spanned> biddingNotesText = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<WarningTextModel> biddingWarningText = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<String> declineBuyNowOfferError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<String> declineBuyNowOfferResponse = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public DisposableObserver<ProductDetailResponse> disposableObserver;
    /* access modifiers changed from: private */
    public DisposableObserver<BDTBuyNowOfferResult> disposableObserverAcceptBuyNowOffer;
    /* access modifiers changed from: private */
    public DisposableObserver<String> disposableObserverDeclineBuyNowOffer;
    /* access modifiers changed from: private */
    public DisposableObserver<List<PartsSectionResponse>> disposableObserverParts;
    /* access modifiers changed from: private */
    public DisposableObserver<UpdateWatchListResponse> disposableObserverUpdateWatchStatus;
    @NotNull
    private MutableLiveData<ImageInformation> imagesResponse = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<ProductDetailErrorModel> nonUsProductDetailError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<ProductDetailResponse> nonUsProductDetailResponse = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<String> partsError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<List<PartsSectionResponse>> partsInfoResponse = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<ProductDetailErrorModel> productDetailError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<ProductDetailResponse> productDetailResponse = new MutableLiveData<>();
    private final ProductDetailRepository repository;
    @NotNull
    private MutableLiveData<Boolean> showEmptyState = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();
    private final WatchRepository watchRepository;
    @NotNull
    private MutableLiveData<String> watchStatusError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<UpdateWatchListResponse> watchStatusResponse = new MutableLiveData<>();

    public static final /* synthetic */ DisposableObserver access$getDisposableObserver$p(ProductDetailViewModel productDetailViewModel) {
        DisposableObserver<ProductDetailResponse> disposableObserver2 = productDetailViewModel.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        return disposableObserver2;
    }

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverAcceptBuyNowOffer$p(ProductDetailViewModel productDetailViewModel) {
        DisposableObserver<BDTBuyNowOfferResult> disposableObserver2 = productDetailViewModel.disposableObserverAcceptBuyNowOffer;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverAcceptBuyNowOffer");
        }
        return disposableObserver2;
    }

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverDeclineBuyNowOffer$p(ProductDetailViewModel productDetailViewModel) {
        DisposableObserver<String> disposableObserver2 = productDetailViewModel.disposableObserverDeclineBuyNowOffer;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverDeclineBuyNowOffer");
        }
        return disposableObserver2;
    }

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverParts$p(ProductDetailViewModel productDetailViewModel) {
        DisposableObserver<List<PartsSectionResponse>> disposableObserver2 = productDetailViewModel.disposableObserverParts;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverParts");
        }
        return disposableObserver2;
    }

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverUpdateWatchStatus$p(ProductDetailViewModel productDetailViewModel) {
        DisposableObserver<UpdateWatchListResponse> disposableObserver2 = productDetailViewModel.disposableObserverUpdateWatchStatus;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverUpdateWatchStatus");
        }
        return disposableObserver2;
    }

    @Inject
    public ProductDetailViewModel(@NotNull ProductDetailRepository productDetailRepository, @NotNull WatchRepository watchRepository2) {
        Intrinsics.checkParameterIsNotNull(productDetailRepository, "repository");
        Intrinsics.checkParameterIsNotNull(watchRepository2, "watchRepository");
        this.repository = productDetailRepository;
        this.watchRepository = watchRepository2;
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

    @NotNull
    public final MutableLiveData<Boolean> getShowEmptyState() {
        return this.showEmptyState;
    }

    public final void setShowEmptyState(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.showEmptyState = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<WarningTextModel> getBiddingWarningText() {
        return this.biddingWarningText;
    }

    public final void setBiddingWarningText(@NotNull MutableLiveData<WarningTextModel> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.biddingWarningText = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<Spanned> getBiddingNotesText() {
        return this.biddingNotesText;
    }

    public final void setBiddingNotesText(@NotNull MutableLiveData<Spanned> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.biddingNotesText = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<ImageInformation> getImagesResponse() {
        return this.imagesResponse;
    }

    public final void setImagesResponse(@NotNull MutableLiveData<ImageInformation> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.imagesResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<List<PartsSectionResponse>> getPartsInfoResponse() {
        return this.partsInfoResponse;
    }

    public final void setPartsInfoResponse(@NotNull MutableLiveData<List<PartsSectionResponse>> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.partsInfoResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getPartsError() {
        return this.partsError;
    }

    public final void setPartsError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.partsError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<UpdateWatchListResponse> getWatchStatusResponse() {
        return this.watchStatusResponse;
    }

    public final void setWatchStatusResponse(@NotNull MutableLiveData<UpdateWatchListResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.watchStatusResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getWatchStatusError() {
        return this.watchStatusError;
    }

    public final void setWatchStatusError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.watchStatusError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<BDTBuyNowOfferResult> getAcceptBuyNowOfferResponse() {
        return this.acceptBuyNowOfferResponse;
    }

    public final void setAcceptBuyNowOfferResponse(@NotNull MutableLiveData<BDTBuyNowOfferResult> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.acceptBuyNowOfferResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getAcceptBuyNowOfferError() {
        return this.acceptBuyNowOfferError;
    }

    public final void setAcceptBuyNowOfferError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.acceptBuyNowOfferError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getDeclineBuyNowOfferResponse() {
        return this.declineBuyNowOfferResponse;
    }

    public final void setDeclineBuyNowOfferResponse(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.declineBuyNowOfferResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getDeclineBuyNowOfferError() {
        return this.declineBuyNowOfferError;
    }

    public final void setDeclineBuyNowOfferError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.declineBuyNowOfferError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<Constants_MVVM.BidAction> getBidLiveData() {
        return this.bidLiveData;
    }

    public final void setBidLiveData(@NotNull MutableLiveData<Constants_MVVM.BidAction> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.bidLiveData = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<ProductDetailResponse> getNonUsProductDetailResponse() {
        return this.nonUsProductDetailResponse;
    }

    public final void setNonUsProductDetailResponse(@NotNull MutableLiveData<ProductDetailResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.nonUsProductDetailResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<ProductDetailErrorModel> getNonUsProductDetailError() {
        return this.nonUsProductDetailError;
    }

    public final void setNonUsProductDetailError(@NotNull MutableLiveData<ProductDetailErrorModel> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.nonUsProductDetailError = mutableLiveData;
    }

    public final void getProductDetail(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_ITEM_ID);
        Intrinsics.checkParameterIsNotNull(str2, "userId");
        Intrinsics.checkParameterIsNotNull(str3, "tenantCode");
        updateLoadingIndicator(true);
        ProductDetailQueryModel productDetailQueryModel = new ProductDetailQueryModel();
        productDetailQueryModel.setCulturecode$app_productionRelease(Utils.getLanguage());
        productDetailQueryModel.setDevicetype$app_productionRelease("android");
        productDetailQueryModel.setUserId$app_productionRelease(str2);
        productDetailQueryModel.setItemId$app_productionRelease(str);
        productDetailQueryModel.setTenant$app_productionRelease(str3);
        this.disposableObserver = new ProductDetailViewModel$getProductDetail$1(this, str3, new Gson().toJson((Object) productDetailQueryModel));
        Observable<ProductDetailResponse> observeOn = this.repository.getProductDetail(str, str2, str3).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<ProductDetailResponse> disposableObserver2 = this.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        observeOn.subscribe((Observer<? super ProductDetailResponse>) disposableObserver2);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a3, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) "") != false) goto L_0x00b1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void getBiddingWarnings(java.util.List<java.lang.String> r10, com.iaai.android.bdt.model.productDetail.biddingInfo.ProductDetailResponse r11) {
        /*
            r9 = this;
            com.iaai.android.bdt.model.productDetail.prebid.PrebidInformation r0 = r11.getPrebidInformation()
            r1 = 0
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = r0.getPrebidPopupErrorMessage()
            goto L_0x000d
        L_0x000c:
            r0 = r1
        L_0x000d:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x001c
            int r0 = r0.length()
            if (r0 != 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r0 = 0
            goto L_0x001d
        L_0x001c:
            r0 = 1
        L_0x001d:
            java.lang.String r4 = ""
            if (r0 != 0) goto L_0x002e
            com.iaai.android.bdt.model.productDetail.prebid.PrebidInformation r0 = r11.getPrebidInformation()
            if (r0 == 0) goto L_0x002e
            java.lang.String r0 = r0.getPrebidPopupErrorMessage()
            if (r0 == 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r0 = r4
        L_0x002f:
            r5 = r10
            java.util.Collection r5 = (java.util.Collection) r5
            if (r5 == 0) goto L_0x003d
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r5 = 0
            goto L_0x003e
        L_0x003d:
            r5 = 1
        L_0x003e:
            if (r5 != 0) goto L_0x006b
            java.lang.Object r5 = r10.get(r2)
            java.lang.String r5 = (java.lang.String) r5
            int r6 = r10.size()
            r7 = r5
            r5 = 1
        L_0x004c:
            if (r5 >= r6) goto L_0x006c
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            java.lang.String r7 = "<br>"
            r8.append(r7)
            java.lang.Object r7 = r10.get(r5)
            java.lang.String r7 = (java.lang.String) r7
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            int r5 = r5 + 1
            goto L_0x004c
        L_0x006b:
            r7 = r4
        L_0x006c:
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r4)
            r10 = r10 ^ r3
            if (r10 != 0) goto L_0x00b1
            com.iaai.android.bdt.model.productDetail.biddingInfo.BiddingInformation r10 = r11.getBiddingInformation()
            if (r10 == 0) goto L_0x00a6
            boolean r10 = r10.getTimedAuctionInd()
            if (r10 != r3) goto L_0x00a6
            com.iaai.android.bdt.model.productDetail.biddingInfo.BiddingInformation r10 = r11.getBiddingInformation()
            if (r10 == 0) goto L_0x008e
            int r10 = r10.getTimedAuctionBuyNowOfferstatus()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            goto L_0x008f
        L_0x008e:
            r10 = r1
        L_0x008f:
            int r10 = r10.intValue()
            if (r10 != 0) goto L_0x00a6
            com.iaai.android.bdt.model.productDetail.prebid.PrebidInformation r10 = r11.getPrebidInformation()
            if (r10 == 0) goto L_0x009f
            java.lang.String r1 = r10.getTimedAuctionClosingStatus()
        L_0x009f:
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r4)
            if (r10 == 0) goto L_0x00a6
            goto L_0x00b1
        L_0x00a6:
            com.iaai.android.bdt.model.productDetail.biddingInfo.WarningTextModel r10 = new com.iaai.android.bdt.model.productDetail.biddingInfo.WarningTextModel
            r10.<init>(r7, r0, r2)
            androidx.lifecycle.MutableLiveData<com.iaai.android.bdt.model.productDetail.biddingInfo.WarningTextModel> r11 = r9.biddingWarningText
            r11.postValue(r10)
            goto L_0x00c5
        L_0x00b1:
            com.iaai.android.bdt.model.productDetail.biddingInfo.WarningTextModel r10 = new com.iaai.android.bdt.model.productDetail.biddingInfo.WarningTextModel
            com.iaai.android.bdt.model.productDetail.biddingInfo.BiddingInformation r11 = r11.getBiddingInformation()
            if (r11 == 0) goto L_0x00bd
            boolean r2 = r11.getTimedAuctionInd()
        L_0x00bd:
            r10.<init>(r7, r0, r2)
            androidx.lifecycle.MutableLiveData<com.iaai.android.bdt.model.productDetail.biddingInfo.WarningTextModel> r11 = r9.biddingWarningText
            r11.postValue(r10)
        L_0x00c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.productDetail.ProductDetailViewModel.getBiddingWarnings(java.util.List, com.iaai.android.bdt.model.productDetail.biddingInfo.ProductDetailResponse):void");
    }

    /* access modifiers changed from: private */
    public final void getBiddingNotes(List<String> list) {
        Collection collection = list;
        if (!(collection == null || collection.isEmpty())) {
            String str = Typography.bullet + list.get(0);
            for (int i = 1; i < list.size(); i++) {
                str = str + "<br>•" + list.get(i);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                this.biddingNotesText.postValue(Html.fromHtml(str, 0));
            } else {
                this.biddingNotesText.postValue(Html.fromHtml(str));
            }
        }
    }

    public final void getPartsSectionInfo(@Nullable Integer num) {
        updateLoadingIndicator(true);
        this.disposableObserverParts = new ProductDetailViewModel$getPartsSectionInfo$1(this, num);
        if (num != null) {
            Observable<List<PartsSectionResponse>> observeOn = this.repository.getPartsSectionInfo(String.valueOf(num.intValue())).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
            DisposableObserver<List<PartsSectionResponse>> disposableObserver2 = this.disposableObserverParts;
            if (disposableObserver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverParts");
            }
            observeOn.subscribe((Observer<? super List<PartsSectionResponse>>) disposableObserver2);
        }
    }

    public final void disposeElements() {
        ProductDetailViewModel productDetailViewModel = this;
        if (productDetailViewModel.disposableObserver != null) {
            DisposableObserver<ProductDetailResponse> disposableObserver2 = this.disposableObserver;
            if (disposableObserver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
            }
            if (!disposableObserver2.isDisposed()) {
                DisposableObserver<ProductDetailResponse> disposableObserver3 = this.disposableObserver;
                if (disposableObserver3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
                }
                disposableObserver3.dispose();
            }
        }
        if (productDetailViewModel.disposableObserverParts != null) {
            DisposableObserver<List<PartsSectionResponse>> disposableObserver4 = this.disposableObserverParts;
            if (disposableObserver4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverParts");
            }
            if (!disposableObserver4.isDisposed()) {
                DisposableObserver<List<PartsSectionResponse>> disposableObserver5 = this.disposableObserverParts;
                if (disposableObserver5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverParts");
                }
                disposableObserver5.dispose();
            }
        }
        if (productDetailViewModel.disposableObserverUpdateWatchStatus != null) {
            DisposableObserver<UpdateWatchListResponse> disposableObserver6 = this.disposableObserverUpdateWatchStatus;
            if (disposableObserver6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverUpdateWatchStatus");
            }
            if (!disposableObserver6.isDisposed()) {
                DisposableObserver<UpdateWatchListResponse> disposableObserver7 = this.disposableObserverUpdateWatchStatus;
                if (disposableObserver7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverUpdateWatchStatus");
                }
                disposableObserver7.dispose();
            }
        }
        if (productDetailViewModel.disposableObserverAcceptBuyNowOffer != null) {
            DisposableObserver<BDTBuyNowOfferResult> disposableObserver8 = this.disposableObserverAcceptBuyNowOffer;
            if (disposableObserver8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverAcceptBuyNowOffer");
            }
            if (!disposableObserver8.isDisposed()) {
                DisposableObserver<BDTBuyNowOfferResult> disposableObserver9 = this.disposableObserverAcceptBuyNowOffer;
                if (disposableObserver9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverAcceptBuyNowOffer");
                }
                disposableObserver9.dispose();
            }
        }
        if (productDetailViewModel.disposableObserverDeclineBuyNowOffer != null) {
            DisposableObserver<String> disposableObserver10 = this.disposableObserverDeclineBuyNowOffer;
            if (disposableObserver10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverDeclineBuyNowOffer");
            }
            if (!disposableObserver10.isDisposed()) {
                DisposableObserver<String> disposableObserver11 = this.disposableObserverDeclineBuyNowOffer;
                if (disposableObserver11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverDeclineBuyNowOffer");
                }
                disposableObserver11.dispose();
            }
        }
    }

    public final void updateLoadingIndicator(boolean z) {
        this.showLoading.postValue(Boolean.valueOf(z));
    }

    public final void updateWatchStatus(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, Constants.EXTRA_ITEM_ID);
        Intrinsics.checkParameterIsNotNull(str3, "userId");
        Intrinsics.checkParameterIsNotNull(str4, "action");
        updateLoadingIndicator(true);
        WatchStatusQueryModel watchStatusQueryModel = new WatchStatusQueryModel();
        watchStatusQueryModel.setCulturecode$app_productionRelease(Utils.getLanguage());
        watchStatusQueryModel.setDevicetype$app_productionRelease("android");
        watchStatusQueryModel.setUserId$app_productionRelease(str3);
        watchStatusQueryModel.setItemId$app_productionRelease(str2);
        watchStatusQueryModel.setAuthorization$app_productionRelease(str);
        watchStatusQueryModel.setAction$app_productionRelease(str4);
        this.disposableObserverUpdateWatchStatus = new ProductDetailViewModel$updateWatchStatus$1(this, new Gson().toJson((Object) watchStatusQueryModel));
        Observable<UpdateWatchListResponse> observeOn = this.watchRepository.updateWatchStatus(str, str2, str3, str4).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<UpdateWatchListResponse> disposableObserver2 = this.disposableObserverUpdateWatchStatus;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverUpdateWatchStatus");
        }
        observeOn.subscribe((Observer<? super UpdateWatchListResponse>) disposableObserver2);
    }

    public final void acceptBuyNowOffer(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkParameterIsNotNull(str, "userId");
        Intrinsics.checkParameterIsNotNull(str2, Constants.EXTRA_ITEM_ID);
        Intrinsics.checkParameterIsNotNull(str3, Constants_MVVM.EXTRA_AUCTION_ID);
        Intrinsics.checkParameterIsNotNull(str4, Constants_MVVM.EXTRA_BRANCH_ID);
        Intrinsics.checkParameterIsNotNull(str5, "stockId");
        updateLoadingIndicator(true);
        BuyNowOfferQueryModel buyNowOfferQueryModel = new BuyNowOfferQueryModel();
        buyNowOfferQueryModel.setUserId$app_productionRelease(str);
        buyNowOfferQueryModel.setItemId$app_productionRelease(str2);
        buyNowOfferQueryModel.setBranchId$app_productionRelease(str4);
        buyNowOfferQueryModel.setAuctionId$app_productionRelease(str3);
        buyNowOfferQueryModel.setStockId$app_productionRelease(str5);
        buyNowOfferQueryModel.setAcceptBNO$app_productionRelease(true);
        this.disposableObserverAcceptBuyNowOffer = new ProductDetailViewModel$acceptBuyNowOffer$1(this, new Gson().toJson((Object) buyNowOfferQueryModel));
        Observable<BDTBuyNowOfferResult> observeOn = this.repository.acceptBuyNowOffer(str, str2, str3, str4, str5).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<BDTBuyNowOfferResult> disposableObserver2 = this.disposableObserverAcceptBuyNowOffer;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverAcceptBuyNowOffer");
        }
        observeOn.subscribe((Observer<? super BDTBuyNowOfferResult>) disposableObserver2);
    }

    public final void declineBuyNowOffer(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkParameterIsNotNull(str, "userId");
        Intrinsics.checkParameterIsNotNull(str2, Constants.EXTRA_ITEM_ID);
        Intrinsics.checkParameterIsNotNull(str3, Constants_MVVM.EXTRA_AUCTION_ID);
        Intrinsics.checkParameterIsNotNull(str4, Constants_MVVM.EXTRA_BRANCH_ID);
        Intrinsics.checkParameterIsNotNull(str5, "stockId");
        updateLoadingIndicator(true);
        BuyNowOfferQueryModel buyNowOfferQueryModel = new BuyNowOfferQueryModel();
        buyNowOfferQueryModel.setUserId$app_productionRelease(str);
        buyNowOfferQueryModel.setItemId$app_productionRelease(str2);
        buyNowOfferQueryModel.setBranchId$app_productionRelease(str4);
        buyNowOfferQueryModel.setAuctionId$app_productionRelease(str3);
        buyNowOfferQueryModel.setStockId$app_productionRelease(str5);
        buyNowOfferQueryModel.setAcceptBNO$app_productionRelease(false);
        this.disposableObserverDeclineBuyNowOffer = new ProductDetailViewModel$declineBuyNowOffer$1(this, new Gson().toJson((Object) buyNowOfferQueryModel));
        Observable<String> observeOn = this.repository.declineBuyNowOffer(str, str2, str3, str4, str5).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<String> disposableObserver2 = this.disposableObserverDeclineBuyNowOffer;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverDeclineBuyNowOffer");
        }
        observeOn.subscribe((Observer<? super String>) disposableObserver2);
    }

    public final void getBidLiveStatus(@Nullable String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            DateHelper.TimeDiff calculateDateTimeDiffWithoutAbs = DateHelper.calculateDateTimeDiffWithoutAbs(new Date(), DateHelper.parseDateInServerTimezone(str));
            if (calculateDateTimeDiffWithoutAbs.days == 0 && calculateDateTimeDiffWithoutAbs.hours == 0 && calculateDateTimeDiffWithoutAbs.minutes <= 0 && calculateDateTimeDiffWithoutAbs.seconds <= 0) {
                this.bidLiveData.postValue(Constants_MVVM.BidAction.BID_LIVE);
            } else if (calculateDateTimeDiffWithoutAbs.days > 0 || calculateDateTimeDiffWithoutAbs.hours > 0) {
                this.bidLiveData.postValue(Constants_MVVM.BidAction.DEFAULT);
            } else {
                int i = calculateDateTimeDiffWithoutAbs.minutes;
                if (i >= 0 && 59 >= i) {
                    this.bidLiveData.postValue(Constants_MVVM.BidAction.JOIN);
                }
            }
        }
    }
}
