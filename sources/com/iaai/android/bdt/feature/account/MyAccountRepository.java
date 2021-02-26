package com.iaai.android.bdt.feature.account;

import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.iaai.android.bdt.model.MyAccount.BDTDashboardResponse;
import com.iaai.android.bdt.network.Repository;
import com.iaai.android.bdt.network.Service;
import com.iaai.android.bdt.utils.Utils;
import java.util.Arrays;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0007J,\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/MyAccountRepository;", "Lcom/iaai/android/bdt/network/Repository;", "service", "Lcom/iaai/android/bdt/network/Service;", "(Lcom/iaai/android/bdt/network/Service;)V", "getBuyNowOfferCount", "Lio/reactivex/Observable;", "", "userId", "loadDashboardInfo", "Lcom/iaai/android/bdt/model/MyAccount/BDTDashboardResponse;", "username", "password", "onlyMyItems", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: MyAccountRepository.kt */
public final class MyAccountRepository implements Repository {
    private final Service service;

    @Inject
    public MyAccountRepository(@NotNull Service service2) {
        Intrinsics.checkParameterIsNotNull(service2, NotificationCompat.CATEGORY_SERVICE);
        this.service = service2;
    }

    @NotNull
    public final Observable<BDTDashboardResponse> loadDashboardInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "username");
        Intrinsics.checkParameterIsNotNull(str2, "password");
        Intrinsics.checkParameterIsNotNull(str3, "userId");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = {str, str2};
        String format = String.format("%s:%s", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        String str4 = z ? IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE : "0";
        Service service2 = this.service;
        String userAgent = Utils.getUserAgent();
        Intrinsics.checkExpressionValueIsNotNull(userAgent, "Utils.getUserAgent()");
        String language = Utils.getLanguage();
        Intrinsics.checkExpressionValueIsNotNull(language, "Utils.getLanguage()");
        return service2.getDashboardInfo(format, userAgent, str3, str4, language, "android");
    }

    @NotNull
    public final Observable<String> getBuyNowOfferCount(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "userId");
        Service service2 = this.service;
        String userAgent = Utils.getUserAgent();
        Intrinsics.checkExpressionValueIsNotNull(userAgent, "Utils.getUserAgent()");
        return service2.getBuyNowOfferCount(userAgent, str);
    }
}
