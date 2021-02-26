package com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.dataSource;

import android.annotation.SuppressLint;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterRepository;
import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchRequestBody;
import com.iaai.android.bdt.model.fastSearchFilter2.FormattedResult;
import com.iaai.android.bdt.utils.NetworkState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.disposables.CompositeDisposable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0001*B'\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ,\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020#2\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030%H\u0017J,\u0010&\u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020#2\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030%H\u0016J,\u0010'\u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020(2\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030)H\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012XD¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0015\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u00178F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001aR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/dataSource/RefinerSearchDataSourceV2;", "Landroidx/paging/PageKeyedDataSource;", "", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FormattedResult;", "repository", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterRepository;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "body", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchRequestBody;", "authHeader", "", "(Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterRepository;Lio/reactivex/disposables/CompositeDisposable;Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchRequestBody;Ljava/lang/String;)V", "getBody", "()Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchRequestBody;", "setBody", "(Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchRequestBody;)V", "branchId", "", "currentPage", "date", "end", "networkState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/iaai/android/bdt/utils/NetworkState;", "getNetworkState", "()Landroidx/lifecycle/MutableLiveData;", "selectedFacetsRequest", "getSelectedFacetsRequest", "vehicleCount", "getVehicleCount", "vehicleTotalCount", "loadAfter", "", "params", "Landroidx/paging/PageKeyedDataSource$LoadParams;", "callback", "Landroidx/paging/PageKeyedDataSource$LoadCallback;", "loadBefore", "loadInitial", "Landroidx/paging/PageKeyedDataSource$LoadInitialParams;", "Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: RefinerSearchDataSourceV2.kt */
public final class RefinerSearchDataSourceV2 extends PageKeyedDataSource<Long, FormattedResult> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = RefinerSearchDataSourceV2.class.getSimpleName();
    private final String authHeader;
    @NotNull
    private FastSearchRequestBody body;
    private final int branchId;
    /* access modifiers changed from: private */
    public final CompositeDisposable compositeDisposable;
    private int currentPage;
    private final String date;
    /* access modifiers changed from: private */
    public final int end;
    @NotNull
    private final MutableLiveData<NetworkState> networkState = new MutableLiveData<>();
    private final FastSearchFilterRepository repository;
    @NotNull
    private final MutableLiveData<FastSearchRequestBody> selectedFacetsRequest = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<Integer> vehicleTotalCount = new MutableLiveData<>();

    public void loadBefore(@NotNull PageKeyedDataSource.LoadParams<Long> loadParams, @NotNull PageKeyedDataSource.LoadCallback<Long, FormattedResult> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, "params");
        Intrinsics.checkParameterIsNotNull(loadCallback, "callback");
    }

    @NotNull
    public final FastSearchRequestBody getBody() {
        return this.body;
    }

    public final void setBody(@NotNull FastSearchRequestBody fastSearchRequestBody) {
        Intrinsics.checkParameterIsNotNull(fastSearchRequestBody, "<set-?>");
        this.body = fastSearchRequestBody;
    }

    public RefinerSearchDataSourceV2(@NotNull FastSearchFilterRepository fastSearchFilterRepository, @NotNull CompositeDisposable compositeDisposable2, @NotNull FastSearchRequestBody fastSearchRequestBody, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(fastSearchFilterRepository, "repository");
        Intrinsics.checkParameterIsNotNull(compositeDisposable2, "compositeDisposable");
        Intrinsics.checkParameterIsNotNull(fastSearchRequestBody, "body");
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        this.repository = fastSearchFilterRepository;
        this.compositeDisposable = compositeDisposable2;
        this.body = fastSearchRequestBody;
        this.authHeader = str;
    }

    @NotNull
    public final MutableLiveData<NetworkState> getNetworkState() {
        return this.networkState;
    }

    @NotNull
    public final MutableLiveData<FastSearchRequestBody> getSelectedFacetsRequest() {
        return this.selectedFacetsRequest;
    }

    @NotNull
    public final MutableLiveData<?> getVehicleCount() {
        return this.vehicleTotalCount;
    }

    @SuppressLint({"CheckResult"})
    public void loadInitial(@NotNull PageKeyedDataSource.LoadInitialParams<Long> loadInitialParams, @NotNull PageKeyedDataSource.LoadInitialCallback<Long, FormattedResult> loadInitialCallback) {
        Intrinsics.checkParameterIsNotNull(loadInitialParams, "params");
        Intrinsics.checkParameterIsNotNull(loadInitialCallback, "callback");
        this.currentPage = this.body.getCurrentPage();
        this.repository.getFastSearchFilterV2("application/json", this.body, this.authHeader).doOnSubscribe(new RefinerSearchDataSourceV2$loadInitial$1(this)).subscribe(new RefinerSearchDataSourceV2$loadInitial$2(this, loadInitialCallback), new RefinerSearchDataSourceV2$loadInitial$3(this));
    }

    @SuppressLint({"CheckResult"})
    public void loadAfter(@NotNull PageKeyedDataSource.LoadParams<Long> loadParams, @NotNull PageKeyedDataSource.LoadCallback<Long, FormattedResult> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, "params");
        Intrinsics.checkParameterIsNotNull(loadCallback, "callback");
        this.body.setCurrentPage(this.currentPage + 1);
        this.currentPage = this.body.getCurrentPage();
        this.repository.getFastSearchFilterV2("application/json", this.body, this.authHeader).doOnSubscribe(new RefinerSearchDataSourceV2$loadAfter$1(this)).subscribe(new RefinerSearchDataSourceV2$loadAfter$2(this, loadParams, loadCallback), new RefinerSearchDataSourceV2$loadAfter$3(this));
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/dataSource/RefinerSearchDataSourceV2$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: RefinerSearchDataSourceV2.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
