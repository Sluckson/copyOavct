package com.iaai.android.bdt.feature.account.tobepickedup;

import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.iaai.android.bdt.model.MyAccount.ToBePickedUpResponse;
import com.iaai.android.bdt.network.Repository;
import com.iaai.android.bdt.network.Service;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.Utils;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J<\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000eJ<\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/tobepickedup/ToBePickedUpRepository;", "Lcom/iaai/android/bdt/network/Repository;", "service", "Lcom/iaai/android/bdt/network/Service;", "(Lcom/iaai/android/bdt/network/Service;)V", "getList", "Lio/reactivex/Observable;", "Lcom/iaai/android/bdt/model/MyAccount/ToBePickedUpResponse;", "authenticationHeader", "", "userId", "onlymyitems", "", "startIndex", "", "sortBy", "sortDirection", "getTopPickedUpList", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ToBePickedUpRepository.kt */
public final class ToBePickedUpRepository implements Repository {
    private final Service service;

    @Inject
    public ToBePickedUpRepository(@NotNull Service service2) {
        Intrinsics.checkParameterIsNotNull(service2, NotificationCompat.CATEGORY_SERVICE);
        this.service = service2;
    }

    @NotNull
    public final Observable<ToBePickedUpResponse> getTopPickedUpList(@NotNull String str, @NotNull String str2, boolean z, int i, @NotNull String str3, int i2) {
        String str4 = str;
        Intrinsics.checkParameterIsNotNull(str, "authenticationHeader");
        String str5 = str2;
        Intrinsics.checkParameterIsNotNull(str2, "userId");
        Intrinsics.checkParameterIsNotNull(str3, Constants_MVVM.EXTRA_SORT_BY);
        String str6 = z ? IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE : "0";
        Service service2 = this.service;
        String language = Utils.getLanguage();
        Intrinsics.checkExpressionValueIsNotNull(language, "Utils.getLanguage()");
        return service2.getToBePickedUpList(str, str2, language, "android", str6, i, 30, str3, i2);
    }

    @NotNull
    public final Observable<ToBePickedUpResponse> getList(@NotNull String str, @NotNull String str2, boolean z, int i, @NotNull String str3, int i2) {
        String str4 = str;
        Intrinsics.checkParameterIsNotNull(str, "authenticationHeader");
        String str5 = str2;
        Intrinsics.checkParameterIsNotNull(str2, "userId");
        Intrinsics.checkParameterIsNotNull(str3, Constants_MVVM.EXTRA_SORT_BY);
        String str6 = z ? IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE : "0";
        Service service2 = this.service;
        String language = Utils.getLanguage();
        Intrinsics.checkExpressionValueIsNotNull(language, "Utils.getLanguage()");
        return service2.getToBePickedUpList(str, str2, language, "android", str6, i, 30, str3, i2);
    }
}
