package com.iaai.android.bdt.feature.account.watchlist;

import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.iaai.android.bdt.model.MyAccount.VehicleReceiptPDFResponse;
import com.iaai.android.bdt.model.MyAccount.WatchListResponse;
import com.iaai.android.bdt.network.Repository;
import com.iaai.android.bdt.network.Service;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.Utils;
import java.util.Arrays;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JT\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\tJ4\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tJT\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListRepository;", "Lcom/iaai/android/bdt/network/Repository;", "service", "Lcom/iaai/android/bdt/network/Service;", "(Lcom/iaai/android/bdt/network/Service;)V", "getList", "Lio/reactivex/Observable;", "Lcom/iaai/android/bdt/model/MyAccount/WatchListResponse;", "authenticationHeader", "", "userId", "onlymyitems", "", "lbsParentID", "", "startIndex", "status", "sortBy", "sortDirection", "keyword", "getVehicleReceipt", "Lcom/iaai/android/bdt/model/MyAccount/VehicleReceiptPDFResponse;", "username", "password", "receiptnumber", "receipttype", "salvageid", "getWatchList", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PreSaleListRepository.kt */
public final class PreSaleListRepository implements Repository {
    private final Service service;

    @Inject
    public PreSaleListRepository(@NotNull Service service2) {
        Intrinsics.checkParameterIsNotNull(service2, NotificationCompat.CATEGORY_SERVICE);
        this.service = service2;
    }

    @NotNull
    public final Observable<WatchListResponse> getWatchList(@NotNull String str, @NotNull String str2, boolean z, int i, int i2, @NotNull String str3, @NotNull String str4, int i3, @NotNull String str5) {
        String str6 = str;
        Intrinsics.checkParameterIsNotNull(str, "authenticationHeader");
        Intrinsics.checkParameterIsNotNull(str2, "userId");
        Intrinsics.checkParameterIsNotNull(str3, "status");
        Intrinsics.checkParameterIsNotNull(str4, Constants_MVVM.EXTRA_SORT_BY);
        Intrinsics.checkParameterIsNotNull(str5, "keyword");
        String str7 = z ? IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE : "0";
        Service service2 = this.service;
        String language = Utils.getLanguage();
        Intrinsics.checkExpressionValueIsNotNull(language, "Utils.getLanguage()");
        return service2.getWatchingList(str, str2, language, "android", str7, i, i2, 30, str3, str4, i3, str5);
    }

    @NotNull
    public final Observable<WatchListResponse> getList(@NotNull String str, @NotNull String str2, boolean z, int i, int i2, @NotNull String str3, @NotNull String str4, int i3, @NotNull String str5) {
        String str6 = str;
        Intrinsics.checkParameterIsNotNull(str, "authenticationHeader");
        Intrinsics.checkParameterIsNotNull(str2, "userId");
        Intrinsics.checkParameterIsNotNull(str3, "status");
        Intrinsics.checkParameterIsNotNull(str4, Constants_MVVM.EXTRA_SORT_BY);
        Intrinsics.checkParameterIsNotNull(str5, "keyword");
        String str7 = z ? IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE : "0";
        Service service2 = this.service;
        String language = Utils.getLanguage();
        Intrinsics.checkExpressionValueIsNotNull(language, "Utils.getLanguage()");
        return service2.getWatchingList(str, str2, language, "android", str7, i, i2, 30, str3, str4, i3, str5);
    }

    @NotNull
    public final Observable<VehicleReceiptPDFResponse> getVehicleReceipt(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkParameterIsNotNull(str, "username");
        Intrinsics.checkParameterIsNotNull(str2, "password");
        Intrinsics.checkParameterIsNotNull(str3, "receiptnumber");
        Intrinsics.checkParameterIsNotNull(str4, "receipttype");
        Intrinsics.checkParameterIsNotNull(str5, "salvageid");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = {str, str2};
        String format = String.format("%s:%s", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        Service service2 = this.service;
        String language = Utils.getLanguage();
        Intrinsics.checkExpressionValueIsNotNull(language, "Utils.getLanguage()");
        return service2.getReceiptData(format, str3, str4, str5, language, "android");
    }
}
