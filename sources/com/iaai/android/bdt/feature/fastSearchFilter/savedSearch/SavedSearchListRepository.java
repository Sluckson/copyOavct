package com.iaai.android.bdt.feature.fastSearchFilter.savedSearch;

import androidx.core.app.NotificationCompat;
import com.iaai.android.bdt.model.savedSearchList.SavedSearchListResponse;
import com.iaai.android.bdt.network.Repository;
import com.iaai.android.bdt.network.Service;
import com.iaai.android.old.utils.constants.Constants;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;
import repack.org.bouncycastle.cms.CMSAttributeTableGenerator;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JD\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tJL\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00130\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/savedSearch/SavedSearchListRepository;", "Lcom/iaai/android/bdt/network/Repository;", "service", "Lcom/iaai/android/bdt/network/Service;", "(Lcom/iaai/android/bdt/network/Service;)V", "deleteSavedSearchList", "Lio/reactivex/Observable;", "", "contentType", "", "authHeader", "devicetype", "deviceid", "apikey", "appversion", "savedSearch", "getSavedSearchList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/savedSearchList/SavedSearchListResponse;", "Lkotlin/collections/ArrayList;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SavedSearchListRepository.kt */
public final class SavedSearchListRepository implements Repository {
    private final Service service;

    @Inject
    public SavedSearchListRepository(@NotNull Service service2) {
        Intrinsics.checkParameterIsNotNull(service2, NotificationCompat.CATEGORY_SERVICE);
        this.service = service2;
    }

    @NotNull
    public final Observable<ArrayList<SavedSearchListResponse>> getSavedSearchList(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "deviceid");
        Intrinsics.checkParameterIsNotNull(str3, Constants.DEVICETYPE_HEADER);
        Intrinsics.checkParameterIsNotNull(str4, "apikey");
        Intrinsics.checkParameterIsNotNull(str5, CMSAttributeTableGenerator.CONTENT_TYPE);
        Intrinsics.checkParameterIsNotNull(str6, "appversion");
        return this.service.getSavedSearchList(str, str2, str3, str4, str5, str6);
    }

    @NotNull
    public final Observable<Boolean> deleteSavedSearchList(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkParameterIsNotNull(str, CMSAttributeTableGenerator.CONTENT_TYPE);
        Intrinsics.checkParameterIsNotNull(str2, "authHeader");
        Intrinsics.checkParameterIsNotNull(str3, Constants.DEVICETYPE_HEADER);
        Intrinsics.checkParameterIsNotNull(str4, "deviceid");
        Intrinsics.checkParameterIsNotNull(str5, "apikey");
        Intrinsics.checkParameterIsNotNull(str6, "appversion");
        String str8 = str7;
        Intrinsics.checkParameterIsNotNull(str8, "savedSearch");
        return this.service.deleteSavedSearchList(str, str2, str3, str4, str5, str6, str8);
    }
}
