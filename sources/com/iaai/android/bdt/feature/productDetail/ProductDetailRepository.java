package com.iaai.android.bdt.feature.productDetail;

import androidx.core.app.NotificationCompat;
import com.iaai.android.bdt.model.productDetail.biddingInfo.ProductDetailResponse;
import com.iaai.android.bdt.model.productDetail.buyNowOffer.BDTBuyNowOfferResult;
import com.iaai.android.bdt.model.productDetail.partsSection.PartsSectionResponse;
import com.iaai.android.bdt.network.Repository;
import com.iaai.android.bdt.network.Service;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.utils.constants.Constants;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J4\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tJ4\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tJ\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00062\u0006\u0010\u0012\u001a\u00020\tJ&\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/ProductDetailRepository;", "Lcom/iaai/android/bdt/network/Repository;", "service", "Lcom/iaai/android/bdt/network/Service;", "(Lcom/iaai/android/bdt/network/Service;)V", "acceptBuyNowOffer", "Lio/reactivex/Observable;", "Lcom/iaai/android/bdt/model/productDetail/buyNowOffer/BDTBuyNowOfferResult;", "userId", "", "itemId", "auctionId", "branchId", "stockId", "declineBuyNowOffer", "getPartsSectionInfo", "", "Lcom/iaai/android/bdt/model/productDetail/partsSection/PartsSectionResponse;", "salvageId", "getProductDetail", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ProductDetailResponse;", "tenantCode", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailRepository.kt */
public final class ProductDetailRepository implements Repository {
    private final Service service;

    @Inject
    public ProductDetailRepository(@NotNull Service service2) {
        Intrinsics.checkParameterIsNotNull(service2, NotificationCompat.CATEGORY_SERVICE);
        this.service = service2;
    }

    @NotNull
    public static /* synthetic */ Observable getProductDetail$default(ProductDetailRepository productDetailRepository, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        return productDetailRepository.getProductDetail(str, str2, str3);
    }

    @NotNull
    public final Observable<ProductDetailResponse> getProductDetail(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_ITEM_ID);
        Intrinsics.checkParameterIsNotNull(str2, "userId");
        Intrinsics.checkParameterIsNotNull(str3, "tenantCode");
        Service service2 = this.service;
        String language = Utils.getLanguage();
        Intrinsics.checkExpressionValueIsNotNull(language, "Utils.getLanguage()");
        return service2.getProductDetail(str, str2, language, "android", str3);
    }

    @NotNull
    public final Observable<List<PartsSectionResponse>> getPartsSectionInfo(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "salvageId");
        return this.service.getPartsSection(str);
    }

    @NotNull
    public final Observable<BDTBuyNowOfferResult> acceptBuyNowOffer(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkParameterIsNotNull(str, "userId");
        Intrinsics.checkParameterIsNotNull(str2, Constants.EXTRA_ITEM_ID);
        Intrinsics.checkParameterIsNotNull(str3, Constants_MVVM.EXTRA_AUCTION_ID);
        Intrinsics.checkParameterIsNotNull(str4, Constants_MVVM.EXTRA_BRANCH_ID);
        Intrinsics.checkParameterIsNotNull(str5, "stockId");
        return this.service.acceptBuyNowOffer(str, str2, str3, str4, str5);
    }

    @NotNull
    public final Observable<String> declineBuyNowOffer(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkParameterIsNotNull(str, "userId");
        Intrinsics.checkParameterIsNotNull(str2, Constants.EXTRA_ITEM_ID);
        Intrinsics.checkParameterIsNotNull(str3, Constants_MVVM.EXTRA_AUCTION_ID);
        Intrinsics.checkParameterIsNotNull(str4, Constants_MVVM.EXTRA_BRANCH_ID);
        Intrinsics.checkParameterIsNotNull(str5, "stockId");
        return this.service.declineBuyNowOffer(str, str2, str3, str4, str5);
    }
}
