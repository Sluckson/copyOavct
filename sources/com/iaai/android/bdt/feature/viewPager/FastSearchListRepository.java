package com.iaai.android.bdt.feature.viewPager;

import androidx.core.app.NotificationCompat;
import com.iaai.android.bdt.model.fastSearch.FastSearchResponse;
import com.iaai.android.bdt.model.fastSearch.SearchInputV2;
import com.iaai.android.bdt.network.Repository;
import com.iaai.android.bdt.network.Service;
import com.iaai.android.bdt.utils.Constants_MVVM;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/viewPager/FastSearchListRepository;", "Lcom/iaai/android/bdt/network/Repository;", "service", "Lcom/iaai/android/bdt/network/Service;", "(Lcom/iaai/android/bdt/network/Service;)V", "getFastSearchListV2", "Lio/reactivex/Observable;", "Lcom/iaai/android/bdt/model/fastSearch/FastSearchResponse;", "authHeader", "", "deviceID", "fastSearchParam", "Lcom/iaai/android/bdt/model/fastSearch/SearchInputV2;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchListRepository.kt */
public final class FastSearchListRepository implements Repository {
    private final Service service;

    @Inject
    public FastSearchListRepository(@NotNull Service service2) {
        Intrinsics.checkParameterIsNotNull(service2, NotificationCompat.CATEGORY_SERVICE);
        this.service = service2;
    }

    @NotNull
    public final Observable<FastSearchResponse> getFastSearchListV2(@NotNull String str, @NotNull String str2, @NotNull SearchInputV2 searchInputV2) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "deviceID");
        Intrinsics.checkParameterIsNotNull(searchInputV2, Constants_MVVM.EXTRA_FAST_SEARCH_PARAM);
        return this.service.loadFastSearchV2(str, "android", str2, Constants_MVVM.SEARCH_API_KEY, "11.81376", searchInputV2);
    }
}
