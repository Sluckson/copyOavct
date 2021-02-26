package com.iaai.android.bdt.feature.landing;

import androidx.core.app.NotificationCompat;
import com.iaai.android.bdt.model.DashBoardDetails;
import com.iaai.android.bdt.model.recommendedVehicles.RecommendedVehiclesResponse;
import com.iaai.android.bdt.network.Repository;
import com.iaai.android.bdt.network.Service;
import com.iaai.android.bdt.utils.Utils;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tJ\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00062\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/LandingPageRepository;", "Lcom/iaai/android/bdt/network/Repository;", "service", "Lcom/iaai/android/bdt/network/Service;", "(Lcom/iaai/android/bdt/network/Service;)V", "getDashBordDetails", "Lio/reactivex/Observable;", "Lcom/iaai/android/bdt/model/DashBoardDetails;", "userId", "", "authheader", "", "onlymyitems", "getRecommendedVehicles", "", "Lcom/iaai/android/bdt/model/recommendedVehicles/RecommendedVehiclesResponse;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: LandingPageRepository.kt */
public final class LandingPageRepository implements Repository {
    private final Service service;

    @Inject
    public LandingPageRepository(@NotNull Service service2) {
        Intrinsics.checkParameterIsNotNull(service2, NotificationCompat.CATEGORY_SERVICE);
        this.service = service2;
    }

    @NotNull
    public final Observable<DashBoardDetails> getDashBordDetails(int i, @NotNull String str, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "authheader");
        Service service2 = this.service;
        String language = Utils.getLanguage();
        Intrinsics.checkExpressionValueIsNotNull(language, "Utils.getLanguage()");
        return service2.getDashBoardDeatils(i, str, language, "android", i2);
    }

    @NotNull
    public final Observable<List<RecommendedVehiclesResponse>> getRecommendedVehicles(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "authheader");
        return this.service.getRecommendedVehicles(str);
    }
}
