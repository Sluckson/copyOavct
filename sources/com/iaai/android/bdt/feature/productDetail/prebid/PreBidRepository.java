package com.iaai.android.bdt.feature.productDetail.prebid;

import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.iaai.android.bdt.model.productDetail.prebid.PreBidBidHistory;
import com.iaai.android.bdt.model.productDetail.prebid.PreBidPlacedResult;
import com.iaai.android.bdt.model.productDetail.prebid.RequestBody;
import com.iaai.android.bdt.network.Repository;
import com.iaai.android.bdt.network.Service;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.utils.constants.Constants;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J2\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nJL\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/prebid/PreBidRepository;", "Lcom/iaai/android/bdt/network/Repository;", "service", "Lcom/iaai/android/bdt/network/Service;", "(Lcom/iaai/android/bdt/network/Service;)V", "getBidHistory", "Lio/reactivex/Observable;", "", "Lcom/iaai/android/bdt/model/productDetail/prebid/PreBidBidHistory;", "itemId", "", "userId", "auctionId", "culturecode", "placePreBid", "Lcom/iaai/android/bdt/model/productDetail/prebid/PreBidPlacedResult;", "authString", "action", "maxbid", "Ljava/math/BigDecimal;", "currentbid", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PreBidRepository.kt */
public final class PreBidRepository implements Repository {
    private final Service service;

    @Inject
    public PreBidRepository(@NotNull Service service2) {
        Intrinsics.checkParameterIsNotNull(service2, NotificationCompat.CATEGORY_SERVICE);
        this.service = service2;
    }

    @NotNull
    public final Observable<List<PreBidBidHistory>> getBidHistory(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_ITEM_ID);
        Intrinsics.checkParameterIsNotNull(str2, "userId");
        Intrinsics.checkParameterIsNotNull(str3, Constants_MVVM.EXTRA_AUCTION_ID);
        Intrinsics.checkParameterIsNotNull(str4, "culturecode");
        return this.service.getBidHistory("18148", "31355669", "29355077", "en", "android");
    }

    @NotNull
    public final Observable<PreBidPlacedResult> placePreBid(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull BigDecimal bigDecimal, @NotNull BigDecimal bigDecimal2) {
        BigDecimal bigDecimal3 = bigDecimal;
        BigDecimal bigDecimal4 = bigDecimal2;
        Intrinsics.checkParameterIsNotNull(str, "authString");
        Intrinsics.checkParameterIsNotNull(str2, Constants.EXTRA_ITEM_ID);
        String str7 = str3;
        Intrinsics.checkParameterIsNotNull(str7, "userId");
        String str8 = str4;
        Intrinsics.checkParameterIsNotNull(str8, Constants_MVVM.EXTRA_AUCTION_ID);
        String str9 = str5;
        Intrinsics.checkParameterIsNotNull(str9, "culturecode");
        Intrinsics.checkParameterIsNotNull(str6, "action");
        Intrinsics.checkParameterIsNotNull(bigDecimal3, "maxbid");
        Intrinsics.checkParameterIsNotNull(bigDecimal4, "currentbid");
        RequestBody requestBody = new RequestBody(bigDecimal3, bigDecimal4);
        return this.service.placePreBid(str, str9, "android", "Mobileapp", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, str7, str2, str8, requestBody);
    }
}
