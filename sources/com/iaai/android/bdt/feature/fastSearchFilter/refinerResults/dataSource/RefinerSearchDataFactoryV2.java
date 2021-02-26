package com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.dataSource;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterRepository;
import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchRequestBody;
import com.iaai.android.bdt.model.fastSearchFilter2.FormattedResult;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.disposables.CompositeDisposable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0016\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/dataSource/RefinerSearchDataFactoryV2;", "Landroidx/paging/DataSource$Factory;", "", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FormattedResult;", "repository", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterRepository;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "body", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchRequestBody;", "authHeader", "", "(Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterRepository;Lio/reactivex/disposables/CompositeDisposable;Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchRequestBody;Ljava/lang/String;)V", "mutableLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/dataSource/RefinerSearchDataSourceV2;", "getMutableLiveData", "()Landroidx/lifecycle/MutableLiveData;", "refinerDataSourceSearch", "requestBody", "create", "Landroidx/paging/DataSource;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: RefinerSearchDataFactoryV2.kt */
public final class RefinerSearchDataFactoryV2 extends DataSource.Factory<Long, FormattedResult> {
    private final String authHeader;
    private final CompositeDisposable compositeDisposable;
    @NotNull
    private final MutableLiveData<RefinerSearchDataSourceV2> mutableLiveData = new MutableLiveData<>();
    private RefinerSearchDataSourceV2 refinerDataSourceSearch;
    private final FastSearchFilterRepository repository;
    private final FastSearchRequestBody requestBody;

    public RefinerSearchDataFactoryV2(@NotNull FastSearchFilterRepository fastSearchFilterRepository, @NotNull CompositeDisposable compositeDisposable2, @NotNull FastSearchRequestBody fastSearchRequestBody, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(fastSearchFilterRepository, "repository");
        Intrinsics.checkParameterIsNotNull(compositeDisposable2, "compositeDisposable");
        Intrinsics.checkParameterIsNotNull(fastSearchRequestBody, "body");
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        this.repository = fastSearchFilterRepository;
        this.compositeDisposable = compositeDisposable2;
        this.requestBody = fastSearchRequestBody;
        this.authHeader = str;
    }

    @NotNull
    public final MutableLiveData<RefinerSearchDataSourceV2> getMutableLiveData() {
        return this.mutableLiveData;
    }

    @Nullable
    public DataSource<Long, FormattedResult> create() {
        this.refinerDataSourceSearch = new RefinerSearchDataSourceV2(this.repository, this.compositeDisposable, this.requestBody, this.authHeader);
        this.mutableLiveData.postValue(this.refinerDataSourceSearch);
        RefinerSearchDataSourceV2 refinerSearchDataSourceV2 = this.refinerDataSourceSearch;
        if (refinerSearchDataSourceV2 == null) {
            Intrinsics.throwNpe();
        }
        if (refinerSearchDataSourceV2 != null) {
            return refinerSearchDataSourceV2;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.paging.DataSource<kotlin.Long, com.iaai.android.bdt.model.fastSearchFilter2.FormattedResult>");
    }
}
