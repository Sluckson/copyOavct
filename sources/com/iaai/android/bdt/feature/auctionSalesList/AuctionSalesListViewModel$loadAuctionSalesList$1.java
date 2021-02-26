package com.iaai.android.bdt.feature.auctionSalesList;

import com.google.gson.Gson;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.model.auctionSalesList.AuctionSaleList;
import com.iaai.android.bdt.model.auctionSalesList.AuctionSalesListResponse;
import com.iaai.android.bdt.model.auctionSalesList.RequestBody;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.utils.DateHelper;
import com.iaai.android.old.utils.constants.Constants;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, mo66933d2 = {"com/iaai/android/bdt/feature/auctionSalesList/AuctionSalesListViewModel$loadAuctionSalesList$1", "Lio/reactivex/observers/DisposableObserver;", "Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListResponse;", "onComplete", "", "onError", "e", "", "onNext", "response", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionSalesListViewModel.kt */
public final class AuctionSalesListViewModel$loadAuctionSalesList$1 extends DisposableObserver<AuctionSalesListResponse> {
    final /* synthetic */ String $branchId;
    final /* synthetic */ Date $liveDate;
    final /* synthetic */ AuctionSalesListViewModel this$0;

    public void onComplete() {
    }

    AuctionSalesListViewModel$loadAuctionSalesList$1(AuctionSalesListViewModel auctionSalesListViewModel, Date date, String str) {
        this.this$0 = auctionSalesListViewModel;
        this.$liveDate = date;
        this.$branchId = str;
    }

    public void onNext(@NotNull AuctionSalesListResponse auctionSalesListResponse) {
        AuctionSalesListResponse auctionSalesListResponse2 = auctionSalesListResponse;
        Intrinsics.checkParameterIsNotNull(auctionSalesListResponse2, "response");
        this.this$0.getAuctionSalesResult().postValue(auctionSalesListResponse2);
        String format = DateHelper.format(this.$liveDate, Constants.DATE_PATTERN_WEBSERVICE_PARAM);
        String str = format;
        int parseInt = Integer.parseInt(this.$branchId);
        Intrinsics.checkExpressionValueIsNotNull(format, "wsDateString");
        String language = Utils.getLanguage();
        Intrinsics.checkExpressionValueIsNotNull(language, "Utils.getLanguage()");
        String json = new Gson().toJson((Object) new RequestBody(new AuctionSaleList(str, parseInt, language, "android", "", "0", 30, "", "", 30, "", 1, "", "", "", "")));
        IAAAnalytics iAAAnalytics = IAAAnalytics.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(json, "queryEvent");
        iAAAnalytics.logNetworkEvent("AuctionSaleListV2.svc/auctionsalelist", true, json, "");
    }

    public void onError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        this.this$0.getAuctionSalesError().postValue(th.getMessage());
        String format = DateHelper.format(this.$liveDate, Constants.DATE_PATTERN_WEBSERVICE_PARAM);
        String str = format;
        int parseInt = Integer.parseInt(this.$branchId);
        Intrinsics.checkExpressionValueIsNotNull(format, "wsDateString");
        String language = Utils.getLanguage();
        Intrinsics.checkExpressionValueIsNotNull(language, "Utils.getLanguage()");
        String json = new Gson().toJson((Object) new RequestBody(new AuctionSaleList(str, parseInt, language, "android", "", "0", 30, "", "", 30, "", 1, "", "", "", "")));
        IAAAnalytics iAAAnalytics = IAAAnalytics.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(json, "queryEvent");
        iAAAnalytics.logNetworkEvent("AuctionSaleListV2.svc/auctionsalelist", false, json, th.getMessage());
    }
}
