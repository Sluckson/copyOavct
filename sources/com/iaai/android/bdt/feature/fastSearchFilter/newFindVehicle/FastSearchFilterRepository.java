package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import androidx.core.app.NotificationCompat;
import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchRequestBody;
import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchResponse2;
import com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray;
import com.iaai.android.bdt.model.quickFilter.QuickFilterResponse;
import com.iaai.android.bdt.model.saveSearch.SaveSearchRequest;
import com.iaai.android.bdt.model.saveSearch.SaveSearchResponse;
import com.iaai.android.bdt.network.Repository;
import com.iaai.android.bdt.network.Service;
import com.iaai.android.bdt.utils.Constants_MVVM;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;
import repack.org.bouncycastle.cms.CMSAttributeTableGenerator;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tJ$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tJ\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0006J\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000f0\u0006J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tJ,\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterRepository;", "Lcom/iaai/android/bdt/network/Repository;", "service", "Lcom/iaai/android/bdt/network/Service;", "(Lcom/iaai/android/bdt/network/Service;)V", "getFastSearchFilterV2", "Lio/reactivex/Observable;", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchResponse2;", "contentType", "", "requestBody", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchRequestBody;", "authHeader", "getPDFastSearchFilterV2", "getPopularCategoriesV4", "", "Lcom/iaai/android/bdt/model/quickFilter/QuickFilterResponse;", "getSearchMapping", "Lcom/iaai/android/bdt/model/fastSearchFilter2/SearchMappingArray;", "getSeriesData", "saveSearch", "Lcom/iaai/android/bdt/model/saveSearch/SaveSearchResponse;", "deviceID", "saveSearchRequest", "Lcom/iaai/android/bdt/model/saveSearch/SaveSearchRequest;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchFilterRepository.kt */
public final class FastSearchFilterRepository implements Repository {
    private final Service service;

    @Inject
    public FastSearchFilterRepository(@NotNull Service service2) {
        Intrinsics.checkParameterIsNotNull(service2, NotificationCompat.CATEGORY_SERVICE);
        this.service = service2;
    }

    @NotNull
    public final Observable<List<SearchMappingArray>> getSearchMapping() {
        return this.service.getSearchMapping();
    }

    @NotNull
    public final Observable<FastSearchResponse2> getFastSearchFilterV2(@NotNull String str, @NotNull FastSearchRequestBody fastSearchRequestBody, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, CMSAttributeTableGenerator.CONTENT_TYPE);
        Intrinsics.checkParameterIsNotNull(fastSearchRequestBody, "requestBody");
        Intrinsics.checkParameterIsNotNull(str2, "authHeader");
        return this.service.fastSearchV2(str, fastSearchRequestBody, str2);
    }

    @NotNull
    public final Observable<FastSearchResponse2> getSeriesData(@NotNull String str, @NotNull FastSearchRequestBody fastSearchRequestBody, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, CMSAttributeTableGenerator.CONTENT_TYPE);
        Intrinsics.checkParameterIsNotNull(fastSearchRequestBody, "requestBody");
        Intrinsics.checkParameterIsNotNull(str2, "authHeader");
        return this.service.fastSearchV2(str, fastSearchRequestBody, str2);
    }

    @NotNull
    public final Observable<SaveSearchResponse> saveSearch(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull SaveSearchRequest saveSearchRequest) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "deviceID");
        Intrinsics.checkParameterIsNotNull(str3, CMSAttributeTableGenerator.CONTENT_TYPE);
        Intrinsics.checkParameterIsNotNull(saveSearchRequest, "saveSearchRequest");
        return this.service.saveSearch(str, "android", str2, Constants_MVVM.SEARCH_API_KEY, "11.81376", str3, saveSearchRequest);
    }

    @NotNull
    public final Observable<List<QuickFilterResponse>> getPopularCategoriesV4() {
        return this.service.getPopularCategoriesV4();
    }

    @NotNull
    public final Observable<FastSearchResponse2> getPDFastSearchFilterV2(@NotNull String str, @NotNull FastSearchRequestBody fastSearchRequestBody, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, CMSAttributeTableGenerator.CONTENT_TYPE);
        Intrinsics.checkParameterIsNotNull(fastSearchRequestBody, "requestBody");
        Intrinsics.checkParameterIsNotNull(str2, "authHeader");
        return this.service.fastSearchV2(str, fastSearchRequestBody, str2);
    }
}
