package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.google.gson.Gson;
import com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.dataSource.RefinerSearchDataFactoryV2;
import com.iaai.android.bdt.feature.fastSearchFilter.savedSearch.SavedSearchListRepository;
import com.iaai.android.bdt.feature.watchList.WatchRepository;
import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchRequestBody;
import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchResponse2;
import com.iaai.android.bdt.model.fastSearchFilter2.FormattedResult;
import com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray;
import com.iaai.android.bdt.model.firebaseevent.WatchStatusQueryModel;
import com.iaai.android.bdt.model.profile.UpdateWatchListResponse;
import com.iaai.android.bdt.model.quickFilter.QuickFilterResponse;
import com.iaai.android.bdt.model.saveSearch.SaveSearchRequest;
import com.iaai.android.bdt.model.saveSearch.SaveSearchResponse;
import com.iaai.android.bdt.model.savedSearchList.SavedSearchListResponse;
import com.iaai.android.bdt.utils.NetworkState;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.utils.constants.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;
import p011io.reactivex.Observer;
import p011io.reactivex.android.schedulers.AndroidSchedulers;
import p011io.reactivex.disposables.CompositeDisposable;
import p011io.reactivex.observers.DisposableObserver;
import p011io.reactivex.schedulers.Schedulers;
import repack.org.bouncycastle.cms.CMSAttributeTableGenerator;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010s\u001a\u00020tJ\u0016\u0010u\u001a\u00020t2\u0006\u0010v\u001a\u00020W2\u0006\u0010w\u001a\u00020\nJ\u0016\u0010x\u001a\u00020t2\u0006\u0010v\u001a\u00020W2\u0006\u0010w\u001a\u00020\nJ\f\u0010y\u001a\b\u0012\u0004\u0012\u00020403J\u0006\u0010z\u001a\u00020tJ8\u0010{\u001a\u00020t2\u0006\u0010|\u001a\u00020\n2\u0006\u0010}\u001a\u00020\n2\u0006\u0010~\u001a\u00020\n2\u0006\u0010\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nJ\u0007\u0010\u0001\u001a\u00020tJ\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020W03J\u0017\u0010\u0001\u001a\u00020t2\u0006\u0010v\u001a\u00020W2\u0006\u0010w\u001a\u00020\nJ\u0017\u0010\u0001\u001a\u00020t2\u0006\u0010v\u001a\u00020W2\u0006\u0010w\u001a\u00020\nJ\u0013\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020j0i03J\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020l03J\t\u0010\u0001\u001a\u00020tH\u0002J \u0010\u0001\u001a\u00020t2\u0007\u0010\u0001\u001a\u00020\n2\u0006\u0010v\u001a\u00020W2\u0006\u0010w\u001a\u00020\nJ\t\u0010\u0001\u001a\u00020tH\u0014J+\u0010\u0001\u001a\u00020t2\u0007\u0010\u0001\u001a\u00020\n2\u0006\u0010w\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\b\u0010\u0001\u001a\u00030\u0001J\u0010\u0010\u0001\u001a\u00020t2\u0007\u0010\u0001\u001a\u00020_J*\u0010\u0001\u001a\u00020t2\u0006\u0010w\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nR\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000fX.¢\u0006\u0002\n\u0000R&\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0014R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0014R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R \u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R \u0010%\u001a\b\u0012\u0004\u0012\u00020\n0&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010+\u001a\b\u0012\u0004\u0012\u00020\u00100&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX.¢\u0006\u0002\n\u0000R \u0010/\u001a\b\u0012\u0004\u0012\u00020\u00100&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010(\"\u0004\b1\u0010*R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020403X.¢\u0006\u0002\n\u0000R&\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010(\"\u0004\b7\u0010*R\u000e\u00108\u001a\u000209X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R \u0010:\u001a\b\u0012\u0004\u0012\u00020\n0&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010(\"\u0004\b<\u0010*R0\u0010=\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020?0>j\b\u0012\u0004\u0012\u00020?`@0\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0012\"\u0004\bB\u0010\u0014R \u0010C\u001a\b\u0012\u0004\u0012\u00020\n0&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010(\"\u0004\bE\u0010*R0\u0010F\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020?0>j\b\u0012\u0004\u0012\u00020?`@0&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010(\"\u0004\bH\u0010*R \u0010I\u001a\b\u0012\u0004\u0012\u00020\u001d0&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010(\"\u0004\bK\u0010*R&\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0\u00180\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0012\"\u0004\bO\u0010\u0014R \u0010P\u001a\b\u0012\u0004\u0012\u00020\n0&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010(\"\u0004\bR\u0010*R&\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0\u00180&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010(\"\u0004\bU\u0010*R\u0014\u0010V\u001a\b\u0012\u0004\u0012\u00020W03X.¢\u0006\u0002\n\u0000R \u0010X\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0012\"\u0004\bZ\u0010\u0014R \u0010[\u001a\b\u0012\u0004\u0012\u00020\u00100&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010(\"\u0004\b]\u0010*R \u0010^\u001a\b\u0012\u0004\u0012\u00020_0&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010(\"\u0004\ba\u0010*R \u0010b\u001a\b\u0012\u0004\u0012\u00020\n0&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010(\"\u0004\bd\u0010*R \u0010e\u001a\b\u0012\u0004\u0012\u00020\u00100&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010(\"\u0004\bg\u0010*R\u001a\u0010h\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020j0i03X.¢\u0006\u0002\n\u0000R\u0014\u0010k\u001a\b\u0012\u0004\u0012\u00020l03X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R \u0010m\u001a\b\u0012\u0004\u0012\u00020\n0&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010(\"\u0004\bo\u0010*R \u0010p\u001a\b\u0012\u0004\u0012\u00020\u00160&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010(\"\u0004\br\u0010*¨\u0006\u0001"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterRepository;", "watchRepository", "Lcom/iaai/android/bdt/feature/watchList/WatchRepository;", "savedRepository", "Lcom/iaai/android/bdt/feature/fastSearchFilter/savedSearch/SavedSearchListRepository;", "(Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterRepository;Lcom/iaai/android/bdt/feature/watchList/WatchRepository;Lcom/iaai/android/bdt/feature/fastSearchFilter/savedSearch/SavedSearchListRepository;)V", "TAG", "", "kotlin.jvm.PlatformType", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "disposableObserver", "Lio/reactivex/observers/DisposableObserver;", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchResponse2;", "getDisposableObserver", "()Lio/reactivex/observers/DisposableObserver;", "setDisposableObserver", "(Lio/reactivex/observers/DisposableObserver;)V", "disposableObserverUpdateWatchStatus", "Lcom/iaai/android/bdt/model/profile/UpdateWatchListResponse;", "disposablePopularCategoryObserver", "", "Lcom/iaai/android/bdt/model/quickFilter/QuickFilterResponse;", "getDisposablePopularCategoryObserver", "setDisposablePopularCategoryObserver", "disposableSaveSearchObserver", "Lcom/iaai/android/bdt/model/saveSearch/SaveSearchResponse;", "getDisposableSaveSearchObserver", "setDisposableSaveSearchObserver", "executor", "Ljava/util/concurrent/Executor;", "facetDisposableObserver", "getFacetDisposableObserver", "setFacetDisposableObserver", "facetError", "Landroidx/lifecycle/MutableLiveData;", "getFacetError", "()Landroidx/lifecycle/MutableLiveData;", "setFacetError", "(Landroidx/lifecycle/MutableLiveData;)V", "facetResult", "getFacetResult", "setFacetResult", "fastSearchDisposableObserver", "fastSearchResult", "getFastSearchResult", "setFastSearchResult", "networkState", "Landroidx/lifecycle/LiveData;", "Lcom/iaai/android/bdt/utils/NetworkState;", "popularCategoryResponse", "getPopularCategoryResponse", "setPopularCategoryResponse", "refinerSearchDataFactoryV2", "Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/dataSource/RefinerSearchDataFactoryV2;", "savedSearchError", "getSavedSearchError", "setSavedSearchError", "savedSearchListDisposableObserver", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/savedSearchList/SavedSearchListResponse;", "Lkotlin/collections/ArrayList;", "getSavedSearchListDisposableObserver", "setSavedSearchListDisposableObserver", "savedSearchListError", "getSavedSearchListError", "setSavedSearchListError", "savedSearchListResponse", "getSavedSearchListResponse", "setSavedSearchListResponse", "savedSearchSuccess", "getSavedSearchSuccess", "setSavedSearchSuccess", "searchMappingDisposableObserver", "Lcom/iaai/android/bdt/model/fastSearchFilter2/SearchMappingArray;", "getSearchMappingDisposableObserver", "setSearchMappingDisposableObserver", "searchMappingError", "getSearchMappingError", "setSearchMappingError", "searchMappingResult", "getSearchMappingResult", "setSearchMappingResult", "selectedFacetsRequest", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchRequestBody;", "seriesDisposableObserver", "getSeriesDisposableObserver", "setSeriesDisposableObserver", "seriesResult", "getSeriesResult", "setSeriesResult", "showLoading", "", "getShowLoading", "setShowLoading", "swipedProductListError", "getSwipedProductListError", "setSwipedProductListError", "swipedProductListResult", "getSwipedProductListResult", "setSwipedProductListResult", "vehicleLiveData", "Landroidx/paging/PagedList;", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FormattedResult;", "vehicleTotalCount", "", "watchStatusError", "getWatchStatusError", "setWatchStatusError", "watchStatusResponse", "getWatchStatusResponse", "setWatchStatusResponse", "disposeElements", "", "fetchRefinerResultList", "requestBody", "authHeader", "getFastSearchFilterV2", "getNetworkState", "getPopularCategoriesV4", "getSavedSearchList", "authString", "deviceid", "deviceType", "ApiKey", "contentType", "appversion", "getSearchMapping", "getSelectedFacets", "getSeriesData", "getUpdatedFacetValues", "getVehicleLiveData", "getVehicleTotalCount", "initializePagingV2", "loadSwipedProductList", "onCleared", "saveSearch", "deviceID", "saveSearchRequest", "Lcom/iaai/android/bdt/model/saveSearch/SaveSearchRequest;", "updateLoadingIndicator", "status", "updateWatchStatus", "itemId", "userId", "action", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchFilterViewModel.kt */
public final class FastSearchFilterViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public final String TAG = FastSearchFilterViewModel.class.getSimpleName();
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    @NotNull
    public DisposableObserver<FastSearchResponse2> disposableObserver;
    /* access modifiers changed from: private */
    public DisposableObserver<UpdateWatchListResponse> disposableObserverUpdateWatchStatus;
    @NotNull
    public DisposableObserver<List<QuickFilterResponse>> disposablePopularCategoryObserver;
    @NotNull
    public DisposableObserver<SaveSearchResponse> disposableSaveSearchObserver;
    private Executor executor;
    @NotNull
    public DisposableObserver<FastSearchResponse2> facetDisposableObserver;
    @NotNull
    private MutableLiveData<String> facetError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<FastSearchResponse2> facetResult = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public DisposableObserver<FastSearchResponse2> fastSearchDisposableObserver;
    @NotNull
    private MutableLiveData<FastSearchResponse2> fastSearchResult = new MutableLiveData<>();
    private LiveData<NetworkState> networkState;
    @NotNull
    private MutableLiveData<List<QuickFilterResponse>> popularCategoryResponse;
    private RefinerSearchDataFactoryV2 refinerSearchDataFactoryV2;
    private final FastSearchFilterRepository repository;
    private final SavedSearchListRepository savedRepository;
    @NotNull
    private MutableLiveData<String> savedSearchError;
    @NotNull
    public DisposableObserver<ArrayList<SavedSearchListResponse>> savedSearchListDisposableObserver;
    @NotNull
    private MutableLiveData<String> savedSearchListError;
    @NotNull
    private MutableLiveData<ArrayList<SavedSearchListResponse>> savedSearchListResponse;
    @NotNull
    private MutableLiveData<SaveSearchResponse> savedSearchSuccess;
    @NotNull
    public DisposableObserver<List<SearchMappingArray>> searchMappingDisposableObserver;
    @NotNull
    private MutableLiveData<String> searchMappingError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<List<SearchMappingArray>> searchMappingResult = new MutableLiveData<>();
    private LiveData<FastSearchRequestBody> selectedFacetsRequest;
    @NotNull
    public DisposableObserver<FastSearchResponse2> seriesDisposableObserver;
    @NotNull
    private MutableLiveData<FastSearchResponse2> seriesResult = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<String> swipedProductListError;
    @NotNull
    private MutableLiveData<FastSearchResponse2> swipedProductListResult;
    private LiveData<PagedList<FormattedResult>> vehicleLiveData;
    private LiveData<Integer> vehicleTotalCount;
    private final WatchRepository watchRepository;
    @NotNull
    private MutableLiveData<String> watchStatusError;
    @NotNull
    private MutableLiveData<UpdateWatchListResponse> watchStatusResponse;

    public static final /* synthetic */ DisposableObserver access$getDisposableObserverUpdateWatchStatus$p(FastSearchFilterViewModel fastSearchFilterViewModel) {
        DisposableObserver<UpdateWatchListResponse> disposableObserver2 = fastSearchFilterViewModel.disposableObserverUpdateWatchStatus;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverUpdateWatchStatus");
        }
        return disposableObserver2;
    }

    public static final /* synthetic */ DisposableObserver access$getFastSearchDisposableObserver$p(FastSearchFilterViewModel fastSearchFilterViewModel) {
        DisposableObserver<FastSearchResponse2> disposableObserver2 = fastSearchFilterViewModel.fastSearchDisposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchDisposableObserver");
        }
        return disposableObserver2;
    }

    @Inject
    public FastSearchFilterViewModel(@NotNull FastSearchFilterRepository fastSearchFilterRepository, @NotNull WatchRepository watchRepository2, @NotNull SavedSearchListRepository savedSearchListRepository) {
        Intrinsics.checkParameterIsNotNull(fastSearchFilterRepository, "repository");
        Intrinsics.checkParameterIsNotNull(watchRepository2, "watchRepository");
        Intrinsics.checkParameterIsNotNull(savedSearchListRepository, "savedRepository");
        this.repository = fastSearchFilterRepository;
        this.watchRepository = watchRepository2;
        this.savedRepository = savedSearchListRepository;
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        Intrinsics.checkExpressionValueIsNotNull(newFixedThreadPool, "Executors.newFixedThreadPool(5)");
        this.executor = newFixedThreadPool;
        this.savedSearchSuccess = new MutableLiveData<>();
        this.savedSearchError = new MutableLiveData<>();
        this.popularCategoryResponse = new MutableLiveData<>();
        this.swipedProductListResult = new MutableLiveData<>();
        this.swipedProductListError = new MutableLiveData<>();
        this.watchStatusResponse = new MutableLiveData<>();
        this.watchStatusError = new MutableLiveData<>();
        this.savedSearchListResponse = new MutableLiveData<>();
        this.savedSearchListError = new MutableLiveData<>();
    }

    @NotNull
    public final MutableLiveData<List<SearchMappingArray>> getSearchMappingResult() {
        return this.searchMappingResult;
    }

    public final void setSearchMappingResult(@NotNull MutableLiveData<List<SearchMappingArray>> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.searchMappingResult = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getSearchMappingError() {
        return this.searchMappingError;
    }

    public final void setSearchMappingError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.searchMappingError = mutableLiveData;
    }

    @NotNull
    public final DisposableObserver<List<SearchMappingArray>> getSearchMappingDisposableObserver() {
        DisposableObserver<List<SearchMappingArray>> disposableObserver2 = this.searchMappingDisposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchMappingDisposableObserver");
        }
        return disposableObserver2;
    }

    public final void setSearchMappingDisposableObserver(@NotNull DisposableObserver<List<SearchMappingArray>> disposableObserver2) {
        Intrinsics.checkParameterIsNotNull(disposableObserver2, "<set-?>");
        this.searchMappingDisposableObserver = disposableObserver2;
    }

    @NotNull
    public final MutableLiveData<FastSearchResponse2> getFastSearchResult() {
        return this.fastSearchResult;
    }

    public final void setFastSearchResult(@NotNull MutableLiveData<FastSearchResponse2> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.fastSearchResult = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<FastSearchResponse2> getSeriesResult() {
        return this.seriesResult;
    }

    public final void setSeriesResult(@NotNull MutableLiveData<FastSearchResponse2> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.seriesResult = mutableLiveData;
    }

    @NotNull
    public final DisposableObserver<FastSearchResponse2> getSeriesDisposableObserver() {
        DisposableObserver<FastSearchResponse2> disposableObserver2 = this.seriesDisposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seriesDisposableObserver");
        }
        return disposableObserver2;
    }

    public final void setSeriesDisposableObserver(@NotNull DisposableObserver<FastSearchResponse2> disposableObserver2) {
        Intrinsics.checkParameterIsNotNull(disposableObserver2, "<set-?>");
        this.seriesDisposableObserver = disposableObserver2;
    }

    @NotNull
    public final MutableLiveData<FastSearchResponse2> getFacetResult() {
        return this.facetResult;
    }

    public final void setFacetResult(@NotNull MutableLiveData<FastSearchResponse2> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.facetResult = mutableLiveData;
    }

    @NotNull
    public final DisposableObserver<FastSearchResponse2> getFacetDisposableObserver() {
        DisposableObserver<FastSearchResponse2> disposableObserver2 = this.facetDisposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facetDisposableObserver");
        }
        return disposableObserver2;
    }

    public final void setFacetDisposableObserver(@NotNull DisposableObserver<FastSearchResponse2> disposableObserver2) {
        Intrinsics.checkParameterIsNotNull(disposableObserver2, "<set-?>");
        this.facetDisposableObserver = disposableObserver2;
    }

    @NotNull
    public final MutableLiveData<String> getFacetError() {
        return this.facetError;
    }

    public final void setFacetError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.facetError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowLoading() {
        return this.showLoading;
    }

    public final void setShowLoading(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.showLoading = mutableLiveData;
    }

    @NotNull
    public final DisposableObserver<SaveSearchResponse> getDisposableSaveSearchObserver() {
        DisposableObserver<SaveSearchResponse> disposableObserver2 = this.disposableSaveSearchObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableSaveSearchObserver");
        }
        return disposableObserver2;
    }

    public final void setDisposableSaveSearchObserver(@NotNull DisposableObserver<SaveSearchResponse> disposableObserver2) {
        Intrinsics.checkParameterIsNotNull(disposableObserver2, "<set-?>");
        this.disposableSaveSearchObserver = disposableObserver2;
    }

    @NotNull
    public final MutableLiveData<SaveSearchResponse> getSavedSearchSuccess() {
        return this.savedSearchSuccess;
    }

    public final void setSavedSearchSuccess(@NotNull MutableLiveData<SaveSearchResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.savedSearchSuccess = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getSavedSearchError() {
        return this.savedSearchError;
    }

    public final void setSavedSearchError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.savedSearchError = mutableLiveData;
    }

    @NotNull
    public final DisposableObserver<List<QuickFilterResponse>> getDisposablePopularCategoryObserver() {
        DisposableObserver<List<QuickFilterResponse>> disposableObserver2 = this.disposablePopularCategoryObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposablePopularCategoryObserver");
        }
        return disposableObserver2;
    }

    public final void setDisposablePopularCategoryObserver(@NotNull DisposableObserver<List<QuickFilterResponse>> disposableObserver2) {
        Intrinsics.checkParameterIsNotNull(disposableObserver2, "<set-?>");
        this.disposablePopularCategoryObserver = disposableObserver2;
    }

    @NotNull
    public final MutableLiveData<List<QuickFilterResponse>> getPopularCategoryResponse() {
        return this.popularCategoryResponse;
    }

    public final void setPopularCategoryResponse(@NotNull MutableLiveData<List<QuickFilterResponse>> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.popularCategoryResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<FastSearchResponse2> getSwipedProductListResult() {
        return this.swipedProductListResult;
    }

    public final void setSwipedProductListResult(@NotNull MutableLiveData<FastSearchResponse2> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.swipedProductListResult = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getSwipedProductListError() {
        return this.swipedProductListError;
    }

    public final void setSwipedProductListError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.swipedProductListError = mutableLiveData;
    }

    @NotNull
    public final DisposableObserver<FastSearchResponse2> getDisposableObserver() {
        DisposableObserver<FastSearchResponse2> disposableObserver2 = this.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        return disposableObserver2;
    }

    public final void setDisposableObserver(@NotNull DisposableObserver<FastSearchResponse2> disposableObserver2) {
        Intrinsics.checkParameterIsNotNull(disposableObserver2, "<set-?>");
        this.disposableObserver = disposableObserver2;
    }

    @NotNull
    public final MutableLiveData<UpdateWatchListResponse> getWatchStatusResponse() {
        return this.watchStatusResponse;
    }

    public final void setWatchStatusResponse(@NotNull MutableLiveData<UpdateWatchListResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.watchStatusResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getWatchStatusError() {
        return this.watchStatusError;
    }

    public final void setWatchStatusError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.watchStatusError = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<ArrayList<SavedSearchListResponse>> getSavedSearchListResponse() {
        return this.savedSearchListResponse;
    }

    public final void setSavedSearchListResponse(@NotNull MutableLiveData<ArrayList<SavedSearchListResponse>> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.savedSearchListResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getSavedSearchListError() {
        return this.savedSearchListError;
    }

    public final void setSavedSearchListError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.savedSearchListError = mutableLiveData;
    }

    @NotNull
    public final DisposableObserver<ArrayList<SavedSearchListResponse>> getSavedSearchListDisposableObserver() {
        DisposableObserver<ArrayList<SavedSearchListResponse>> disposableObserver2 = this.savedSearchListDisposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedSearchListDisposableObserver");
        }
        return disposableObserver2;
    }

    public final void setSavedSearchListDisposableObserver(@NotNull DisposableObserver<ArrayList<SavedSearchListResponse>> disposableObserver2) {
        Intrinsics.checkParameterIsNotNull(disposableObserver2, "<set-?>");
        this.savedSearchListDisposableObserver = disposableObserver2;
    }

    public final void getSearchMapping() {
        updateLoadingIndicator(true);
        this.searchMappingDisposableObserver = new FastSearchFilterViewModel$getSearchMapping$1(this);
        Observable<List<SearchMappingArray>> observeOn = this.repository.getSearchMapping().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<List<SearchMappingArray>> disposableObserver2 = this.searchMappingDisposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchMappingDisposableObserver");
        }
        observeOn.subscribe((Observer<? super List<SearchMappingArray>>) disposableObserver2);
    }

    @NotNull
    public final LiveData<Integer> getVehicleTotalCount() {
        LiveData<Integer> liveData = this.vehicleTotalCount;
        if (liveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vehicleTotalCount");
        }
        return liveData;
    }

    public final void getSavedSearchList(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkParameterIsNotNull(str, "authString");
        Intrinsics.checkParameterIsNotNull(str2, "deviceid");
        Intrinsics.checkParameterIsNotNull(str3, "deviceType");
        Intrinsics.checkParameterIsNotNull(str4, "ApiKey");
        Intrinsics.checkParameterIsNotNull(str5, CMSAttributeTableGenerator.CONTENT_TYPE);
        Intrinsics.checkParameterIsNotNull(str6, "appversion");
        updateLoadingIndicator(true);
        this.savedSearchListDisposableObserver = new FastSearchFilterViewModel$getSavedSearchList$1(this);
        Observable<ArrayList<SavedSearchListResponse>> observeOn = this.savedRepository.getSavedSearchList(str, str2, str3, str4, str5, str6).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<ArrayList<SavedSearchListResponse>> disposableObserver2 = this.savedSearchListDisposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedSearchListDisposableObserver");
        }
        observeOn.subscribe((Observer<? super ArrayList<SavedSearchListResponse>>) disposableObserver2);
    }

    public final void getFastSearchFilterV2(@NotNull FastSearchRequestBody fastSearchRequestBody, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(fastSearchRequestBody, "requestBody");
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        updateLoadingIndicator(true);
        this.fastSearchDisposableObserver = new FastSearchFilterViewModel$getFastSearchFilterV2$1(this);
        Observable<FastSearchResponse2> observeOn = this.repository.getFastSearchFilterV2("application/json", fastSearchRequestBody, str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<FastSearchResponse2> disposableObserver2 = this.fastSearchDisposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchDisposableObserver");
        }
        observeOn.subscribe((Observer<? super FastSearchResponse2>) disposableObserver2);
    }

    public final void getSeriesData(@NotNull FastSearchRequestBody fastSearchRequestBody, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(fastSearchRequestBody, "requestBody");
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        updateLoadingIndicator(true);
        this.seriesDisposableObserver = new FastSearchFilterViewModel$getSeriesData$1(this);
        Observable<FastSearchResponse2> observeOn = this.repository.getSeriesData("application/json", fastSearchRequestBody, str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<FastSearchResponse2> disposableObserver2 = this.seriesDisposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seriesDisposableObserver");
        }
        observeOn.subscribe((Observer<? super FastSearchResponse2>) disposableObserver2);
    }

    public final void fetchRefinerResultList(@NotNull FastSearchRequestBody fastSearchRequestBody, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(fastSearchRequestBody, "requestBody");
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        this.refinerSearchDataFactoryV2 = new RefinerSearchDataFactoryV2(this.repository, this.compositeDisposable, fastSearchRequestBody, str);
        initializePagingV2();
    }

    private final void initializePagingV2() {
        PagedList.Config build = new PagedList.Config.Builder().setEnablePlaceholders(false).setInitialLoadSizeHint(100).setPageSize(100).build();
        RefinerSearchDataFactoryV2 refinerSearchDataFactoryV22 = this.refinerSearchDataFactoryV2;
        if (refinerSearchDataFactoryV22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerSearchDataFactoryV2");
        }
        LiveData<PagedList<FormattedResult>> build2 = new LivePagedListBuilder(refinerSearchDataFactoryV22, build).setFetchExecutor(this.executor).build();
        if (build2 != null) {
            this.vehicleLiveData = build2;
            RefinerSearchDataFactoryV2 refinerSearchDataFactoryV23 = this.refinerSearchDataFactoryV2;
            if (refinerSearchDataFactoryV23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refinerSearchDataFactoryV2");
            }
            LiveData<NetworkState> switchMap = Transformations.switchMap(refinerSearchDataFactoryV23.getMutableLiveData(), new FastSearchFilterViewModel$initializePagingV2$1());
            Intrinsics.checkExpressionValueIsNotNull(switchMap, "Transformations.switchMa…     }\n                })");
            this.networkState = switchMap;
            RefinerSearchDataFactoryV2 refinerSearchDataFactoryV24 = this.refinerSearchDataFactoryV2;
            if (refinerSearchDataFactoryV24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refinerSearchDataFactoryV2");
            }
            LiveData<Integer> switchMap2 = Transformations.switchMap(refinerSearchDataFactoryV24.getMutableLiveData(), new FastSearchFilterViewModel$initializePagingV2$2());
            Intrinsics.checkExpressionValueIsNotNull(switchMap2, "Transformations.switchMa…     }\n                })");
            this.vehicleTotalCount = switchMap2;
            RefinerSearchDataFactoryV2 refinerSearchDataFactoryV25 = this.refinerSearchDataFactoryV2;
            if (refinerSearchDataFactoryV25 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refinerSearchDataFactoryV2");
            }
            LiveData<FastSearchRequestBody> switchMap3 = Transformations.switchMap(refinerSearchDataFactoryV25.getMutableLiveData(), new FastSearchFilterViewModel$initializePagingV2$3());
            Intrinsics.checkExpressionValueIsNotNull(switchMap3, "Transformations.switchMa…     }\n                })");
            this.selectedFacetsRequest = switchMap3;
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LiveData<androidx.paging.PagedList<com.iaai.android.bdt.model.fastSearchFilter2.FormattedResult>>");
    }

    @NotNull
    public final LiveData<PagedList<FormattedResult>> getVehicleLiveData() {
        LiveData<PagedList<FormattedResult>> liveData = this.vehicleLiveData;
        if (liveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vehicleLiveData");
        }
        return liveData;
    }

    @NotNull
    public final LiveData<NetworkState> getNetworkState() {
        LiveData<NetworkState> liveData = this.networkState;
        if (liveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkState");
        }
        return liveData;
    }

    @NotNull
    public final LiveData<FastSearchRequestBody> getSelectedFacets() {
        LiveData<FastSearchRequestBody> liveData = this.selectedFacetsRequest;
        if (liveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedFacetsRequest");
        }
        return liveData;
    }

    public final void updateLoadingIndicator(boolean z) {
        this.showLoading.postValue(Boolean.valueOf(z));
    }

    public final void loadSwipedProductList(@NotNull String str, @NotNull FastSearchRequestBody fastSearchRequestBody, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, CMSAttributeTableGenerator.CONTENT_TYPE);
        Intrinsics.checkParameterIsNotNull(fastSearchRequestBody, "requestBody");
        Intrinsics.checkParameterIsNotNull(str2, "authHeader");
        this.disposableObserver = new FastSearchFilterViewModel$loadSwipedProductList$1(this);
        Observable<FastSearchResponse2> observeOn = this.repository.getPDFastSearchFilterV2(str, fastSearchRequestBody, str2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<FastSearchResponse2> disposableObserver2 = this.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        observeOn.subscribe((Observer<? super FastSearchResponse2>) disposableObserver2);
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        FastSearchFilterViewModel fastSearchFilterViewModel = this;
        if (fastSearchFilterViewModel.searchMappingDisposableObserver != null) {
            DisposableObserver<List<SearchMappingArray>> disposableObserver2 = this.searchMappingDisposableObserver;
            if (disposableObserver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchMappingDisposableObserver");
            }
            if (!disposableObserver2.isDisposed()) {
                DisposableObserver<List<SearchMappingArray>> disposableObserver3 = this.searchMappingDisposableObserver;
                if (disposableObserver3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchMappingDisposableObserver");
                }
                disposableObserver3.dispose();
            }
        }
        if (fastSearchFilterViewModel.fastSearchDisposableObserver != null) {
            DisposableObserver<FastSearchResponse2> disposableObserver4 = this.fastSearchDisposableObserver;
            if (disposableObserver4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fastSearchDisposableObserver");
            }
            if (!disposableObserver4.isDisposed()) {
                DisposableObserver<FastSearchResponse2> disposableObserver5 = this.fastSearchDisposableObserver;
                if (disposableObserver5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fastSearchDisposableObserver");
                }
                disposableObserver5.dispose();
            }
        }
        if (fastSearchFilterViewModel.seriesDisposableObserver != null) {
            DisposableObserver<FastSearchResponse2> disposableObserver6 = this.seriesDisposableObserver;
            if (disposableObserver6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("seriesDisposableObserver");
            }
            if (!disposableObserver6.isDisposed()) {
                DisposableObserver<FastSearchResponse2> disposableObserver7 = this.seriesDisposableObserver;
                if (disposableObserver7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("seriesDisposableObserver");
                }
                disposableObserver7.dispose();
            }
        }
        if (fastSearchFilterViewModel.disposableSaveSearchObserver != null) {
            DisposableObserver<SaveSearchResponse> disposableObserver8 = this.disposableSaveSearchObserver;
            if (disposableObserver8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableSaveSearchObserver");
            }
            if (!disposableObserver8.isDisposed()) {
                DisposableObserver<SaveSearchResponse> disposableObserver9 = this.disposableSaveSearchObserver;
                if (disposableObserver9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableSaveSearchObserver");
                }
                disposableObserver9.dispose();
            }
        }
        if (fastSearchFilterViewModel.disposablePopularCategoryObserver != null) {
            DisposableObserver<List<QuickFilterResponse>> disposableObserver10 = this.disposablePopularCategoryObserver;
            if (disposableObserver10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposablePopularCategoryObserver");
            }
            if (!disposableObserver10.isDisposed()) {
                DisposableObserver<List<QuickFilterResponse>> disposableObserver11 = this.disposablePopularCategoryObserver;
                if (disposableObserver11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposablePopularCategoryObserver");
                }
                disposableObserver11.dispose();
            }
        }
        if (fastSearchFilterViewModel.disposableObserver != null) {
            DisposableObserver<FastSearchResponse2> disposableObserver12 = this.disposableObserver;
            if (disposableObserver12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
            }
            if (!disposableObserver12.isDisposed()) {
                DisposableObserver<FastSearchResponse2> disposableObserver13 = this.disposableObserver;
                if (disposableObserver13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
                }
                disposableObserver13.dispose();
            }
        }
        if (fastSearchFilterViewModel.disposableObserverUpdateWatchStatus != null) {
            DisposableObserver<UpdateWatchListResponse> disposableObserver14 = this.disposableObserverUpdateWatchStatus;
            if (disposableObserver14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverUpdateWatchStatus");
            }
            if (!disposableObserver14.isDisposed()) {
                DisposableObserver<UpdateWatchListResponse> disposableObserver15 = this.disposableObserverUpdateWatchStatus;
                if (disposableObserver15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverUpdateWatchStatus");
                }
                disposableObserver15.dispose();
            }
        }
        if (fastSearchFilterViewModel.savedSearchListDisposableObserver != null) {
            DisposableObserver<ArrayList<SavedSearchListResponse>> disposableObserver16 = this.savedSearchListDisposableObserver;
            if (disposableObserver16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("savedSearchListDisposableObserver");
            }
            if (!disposableObserver16.isDisposed()) {
                DisposableObserver<ArrayList<SavedSearchListResponse>> disposableObserver17 = this.savedSearchListDisposableObserver;
                if (disposableObserver17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("savedSearchListDisposableObserver");
                }
                disposableObserver17.dispose();
            }
        }
        if (fastSearchFilterViewModel.facetDisposableObserver != null) {
            DisposableObserver<FastSearchResponse2> disposableObserver18 = this.facetDisposableObserver;
            if (disposableObserver18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("facetDisposableObserver");
            }
            if (!disposableObserver18.isDisposed()) {
                DisposableObserver<FastSearchResponse2> disposableObserver19 = this.facetDisposableObserver;
                if (disposableObserver19 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("facetDisposableObserver");
                }
                disposableObserver19.dispose();
            }
        }
    }

    public final void disposeElements() {
        FastSearchFilterViewModel fastSearchFilterViewModel = this;
        if (fastSearchFilterViewModel.searchMappingDisposableObserver != null) {
            DisposableObserver<List<SearchMappingArray>> disposableObserver2 = this.searchMappingDisposableObserver;
            if (disposableObserver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchMappingDisposableObserver");
            }
            if (!disposableObserver2.isDisposed()) {
                DisposableObserver<List<SearchMappingArray>> disposableObserver3 = this.searchMappingDisposableObserver;
                if (disposableObserver3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchMappingDisposableObserver");
                }
                disposableObserver3.dispose();
            }
        }
        if (fastSearchFilterViewModel.fastSearchDisposableObserver != null) {
            DisposableObserver<FastSearchResponse2> disposableObserver4 = this.fastSearchDisposableObserver;
            if (disposableObserver4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fastSearchDisposableObserver");
            }
            if (!disposableObserver4.isDisposed()) {
                DisposableObserver<FastSearchResponse2> disposableObserver5 = this.fastSearchDisposableObserver;
                if (disposableObserver5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fastSearchDisposableObserver");
                }
                disposableObserver5.dispose();
            }
        }
        if (fastSearchFilterViewModel.seriesDisposableObserver != null) {
            DisposableObserver<FastSearchResponse2> disposableObserver6 = this.seriesDisposableObserver;
            if (disposableObserver6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("seriesDisposableObserver");
            }
            if (!disposableObserver6.isDisposed()) {
                DisposableObserver<FastSearchResponse2> disposableObserver7 = this.seriesDisposableObserver;
                if (disposableObserver7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("seriesDisposableObserver");
                }
                disposableObserver7.dispose();
            }
        }
        if (fastSearchFilterViewModel.disposableSaveSearchObserver != null) {
            DisposableObserver<SaveSearchResponse> disposableObserver8 = this.disposableSaveSearchObserver;
            if (disposableObserver8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableSaveSearchObserver");
            }
            if (!disposableObserver8.isDisposed()) {
                DisposableObserver<SaveSearchResponse> disposableObserver9 = this.disposableSaveSearchObserver;
                if (disposableObserver9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableSaveSearchObserver");
                }
                disposableObserver9.dispose();
            }
        }
        if (fastSearchFilterViewModel.disposablePopularCategoryObserver != null) {
            DisposableObserver<List<QuickFilterResponse>> disposableObserver10 = this.disposablePopularCategoryObserver;
            if (disposableObserver10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposablePopularCategoryObserver");
            }
            if (!disposableObserver10.isDisposed()) {
                DisposableObserver<List<QuickFilterResponse>> disposableObserver11 = this.disposablePopularCategoryObserver;
                if (disposableObserver11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposablePopularCategoryObserver");
                }
                disposableObserver11.dispose();
            }
        }
        if (fastSearchFilterViewModel.disposableObserver != null) {
            DisposableObserver<FastSearchResponse2> disposableObserver12 = this.disposableObserver;
            if (disposableObserver12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
            }
            if (!disposableObserver12.isDisposed()) {
                DisposableObserver<FastSearchResponse2> disposableObserver13 = this.disposableObserver;
                if (disposableObserver13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
                }
                disposableObserver13.dispose();
            }
        }
        if (fastSearchFilterViewModel.disposableObserverUpdateWatchStatus != null) {
            DisposableObserver<UpdateWatchListResponse> disposableObserver14 = this.disposableObserverUpdateWatchStatus;
            if (disposableObserver14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverUpdateWatchStatus");
            }
            if (!disposableObserver14.isDisposed()) {
                DisposableObserver<UpdateWatchListResponse> disposableObserver15 = this.disposableObserverUpdateWatchStatus;
                if (disposableObserver15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverUpdateWatchStatus");
                }
                disposableObserver15.dispose();
            }
        }
        if (fastSearchFilterViewModel.savedSearchListDisposableObserver != null) {
            DisposableObserver<ArrayList<SavedSearchListResponse>> disposableObserver16 = this.savedSearchListDisposableObserver;
            if (disposableObserver16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("savedSearchListDisposableObserver");
            }
            if (!disposableObserver16.isDisposed()) {
                DisposableObserver<ArrayList<SavedSearchListResponse>> disposableObserver17 = this.savedSearchListDisposableObserver;
                if (disposableObserver17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("savedSearchListDisposableObserver");
                }
                disposableObserver17.dispose();
            }
        }
        if (fastSearchFilterViewModel.facetDisposableObserver != null) {
            DisposableObserver<FastSearchResponse2> disposableObserver18 = this.facetDisposableObserver;
            if (disposableObserver18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("facetDisposableObserver");
            }
            if (!disposableObserver18.isDisposed()) {
                DisposableObserver<FastSearchResponse2> disposableObserver19 = this.facetDisposableObserver;
                if (disposableObserver19 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("facetDisposableObserver");
                }
                disposableObserver19.dispose();
            }
        }
    }

    public final void saveSearch(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull SaveSearchRequest saveSearchRequest) {
        Intrinsics.checkParameterIsNotNull(str, CMSAttributeTableGenerator.CONTENT_TYPE);
        Intrinsics.checkParameterIsNotNull(str2, "authHeader");
        Intrinsics.checkParameterIsNotNull(str3, "deviceID");
        Intrinsics.checkParameterIsNotNull(saveSearchRequest, "saveSearchRequest");
        updateLoadingIndicator(true);
        this.disposableSaveSearchObserver = new FastSearchFilterViewModel$saveSearch$1(this);
        Observable<SaveSearchResponse> observeOn = this.repository.saveSearch(str2, str3, str, saveSearchRequest).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<SaveSearchResponse> disposableObserver2 = this.disposableSaveSearchObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableSaveSearchObserver");
        }
        observeOn.subscribe((Observer<? super SaveSearchResponse>) disposableObserver2);
    }

    public final void updateWatchStatus(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, Constants.EXTRA_ITEM_ID);
        Intrinsics.checkParameterIsNotNull(str3, "userId");
        Intrinsics.checkParameterIsNotNull(str4, "action");
        WatchStatusQueryModel watchStatusQueryModel = new WatchStatusQueryModel();
        watchStatusQueryModel.setCulturecode$app_productionRelease(Utils.getLanguage());
        watchStatusQueryModel.setDevicetype$app_productionRelease("android");
        watchStatusQueryModel.setUserId$app_productionRelease(str3);
        watchStatusQueryModel.setItemId$app_productionRelease(str2);
        watchStatusQueryModel.setAuthorization$app_productionRelease(str);
        watchStatusQueryModel.setAction$app_productionRelease(str4);
        this.disposableObserverUpdateWatchStatus = new FastSearchFilterViewModel$updateWatchStatus$1(this, new Gson().toJson((Object) watchStatusQueryModel));
        Observable<UpdateWatchListResponse> observeOn = this.watchRepository.updateWatchStatus(str, str2, str3, str4).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<UpdateWatchListResponse> disposableObserver2 = this.disposableObserverUpdateWatchStatus;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverUpdateWatchStatus");
        }
        observeOn.subscribe((Observer<? super UpdateWatchListResponse>) disposableObserver2);
    }

    public final void getPopularCategoriesV4() {
        updateLoadingIndicator(true);
        this.disposablePopularCategoryObserver = new FastSearchFilterViewModel$getPopularCategoriesV4$1(this);
        Observable<List<QuickFilterResponse>> observeOn = this.repository.getPopularCategoriesV4().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<List<QuickFilterResponse>> disposableObserver2 = this.disposablePopularCategoryObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposablePopularCategoryObserver");
        }
        observeOn.subscribe((Observer<? super List<QuickFilterResponse>>) disposableObserver2);
    }

    public final void getUpdatedFacetValues(@NotNull FastSearchRequestBody fastSearchRequestBody, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(fastSearchRequestBody, "requestBody");
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        updateLoadingIndicator(true);
        this.facetDisposableObserver = new FastSearchFilterViewModel$getUpdatedFacetValues$1(this);
        Observable<FastSearchResponse2> observeOn = this.repository.getSeriesData("application/json", fastSearchRequestBody, str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<FastSearchResponse2> disposableObserver2 = this.facetDisposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facetDisposableObserver");
        }
        observeOn.subscribe((Observer<? super FastSearchResponse2>) disposableObserver2);
    }
}
