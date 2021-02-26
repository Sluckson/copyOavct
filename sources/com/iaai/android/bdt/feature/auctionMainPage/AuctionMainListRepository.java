package com.iaai.android.bdt.feature.auctionMainPage;

import androidx.core.app.NotificationCompat;
import com.iaai.android.bdt.model.auctionmainlist.AuctionMainListResponse;
import com.iaai.android.bdt.network.Repository;
import com.iaai.android.bdt.network.Service;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.utils.constants.Constants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionMainPage/AuctionMainListRepository;", "Lcom/iaai/android/bdt/network/Repository;", "service", "Lcom/iaai/android/bdt/network/Service;", "(Lcom/iaai/android/bdt/network/Service;)V", "getAuctionMainList", "Lio/reactivex/Observable;", "Lcom/iaai/android/bdt/model/auctionmainlist/AuctionMainListResponse;", "query", "", "date", "latitude", "longitude", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionMainListRepository.kt */
public final class AuctionMainListRepository implements Repository {
    private final Service service;

    @Inject
    public AuctionMainListRepository(@NotNull Service service2) {
        Intrinsics.checkParameterIsNotNull(service2, NotificationCompat.CATEGORY_SERVICE);
        this.service = service2;
    }

    @NotNull
    public final Observable<AuctionMainListResponse> getAuctionMainList(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "query");
        Intrinsics.checkParameterIsNotNull(str2, Constants.EXTRA_DATE);
        Intrinsics.checkParameterIsNotNull(str3, "latitude");
        Intrinsics.checkParameterIsNotNull(str4, "longitude");
        Service service2 = this.service;
        String language = Utils.getLanguage();
        Intrinsics.checkExpressionValueIsNotNull(language, "Utils.getLanguage()");
        return service2.getAuctionMainList(language, "android", true, str, str2, str3, str4);
    }
}
