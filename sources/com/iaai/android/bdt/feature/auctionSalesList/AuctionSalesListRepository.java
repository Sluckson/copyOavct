package com.iaai.android.bdt.feature.auctionSalesList;

import androidx.core.app.NotificationCompat;
import com.iaai.android.bdt.model.auctionSalesList.AuctionSaleList;
import com.iaai.android.bdt.model.auctionSalesList.AuctionSalesListResponse;
import com.iaai.android.bdt.model.auctionSalesList.RequestBody;
import com.iaai.android.bdt.network.Repository;
import com.iaai.android.bdt.network.Service;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.utils.DateHelper;
import com.iaai.android.old.utils.constants.Constants;
import java.util.Date;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0006R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionSalesList/AuctionSalesListRepository;", "Lcom/iaai/android/bdt/network/Repository;", "service", "Lcom/iaai/android/bdt/network/Service;", "(Lcom/iaai/android/bdt/network/Service;)V", "authenticationHeader", "", "getAuthenticationHeader", "()Ljava/lang/String;", "setAuthenticationHeader", "(Ljava/lang/String;)V", "getAuctionSalesList", "Lio/reactivex/Observable;", "Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListResponse;", "authHeader", "branchId", "liveDate", "Ljava/util/Date;", "getList", "body", "Lcom/iaai/android/bdt/model/auctionSalesList/RequestBody;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionSalesListRepository.kt */
public final class AuctionSalesListRepository implements Repository {
    @NotNull
    private String authenticationHeader = "";
    private final Service service;

    @Inject
    public AuctionSalesListRepository(@NotNull Service service2) {
        Intrinsics.checkParameterIsNotNull(service2, NotificationCompat.CATEGORY_SERVICE);
        this.service = service2;
    }

    @NotNull
    public final String getAuthenticationHeader() {
        return this.authenticationHeader;
    }

    public final void setAuthenticationHeader(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.authenticationHeader = str;
    }

    @NotNull
    public final Observable<AuctionSalesListResponse> getAuctionSalesList(@NotNull String str, @NotNull String str2, @NotNull Date date) {
        String str3 = str;
        Date date2 = date;
        Intrinsics.checkParameterIsNotNull(str3, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, Constants_MVVM.EXTRA_BRANCH_ID);
        Intrinsics.checkParameterIsNotNull(date2, "liveDate");
        String format = DateHelper.format(date2, Constants.DATE_PATTERN_WEBSERVICE_PARAM);
        String str4 = format;
        int parseInt = Integer.parseInt(str2);
        this.authenticationHeader = str3;
        Intrinsics.checkExpressionValueIsNotNull(format, "wsDateString");
        String language = Utils.getLanguage();
        Intrinsics.checkExpressionValueIsNotNull(language, "Utils.getLanguage()");
        return this.service.getAuctionSalesList(this.authenticationHeader, new RequestBody(new AuctionSaleList(str4, parseInt, language, "android", "", "0", 30, "", "", 30, "", 1, "", "", "", "")));
    }

    @NotNull
    public final Observable<AuctionSalesListResponse> getList(@NotNull RequestBody requestBody, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(requestBody, "body");
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        return this.service.getAuctionSalesList(str, requestBody);
    }
}
