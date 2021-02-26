package com.iaai.android.bdt.feature.landing.quickFilter;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterRepository;
import com.iaai.android.bdt.feature.fastSearchFilter.savedSearch.SavedSearchListRepository;
import com.iaai.android.bdt.feature.viewPager.FastSearchListRepository;
import com.iaai.android.bdt.model.fastSearch.FastSearchResponse;
import com.iaai.android.bdt.model.fastSearch.SearchInputV2;
import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchRequestBody;
import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchResponse2;
import com.iaai.android.bdt.model.quickFilter.QuickFilterResponse;
import com.iaai.android.bdt.model.savedSearchList.SavedSearchListResponse;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.Observable;
import p011io.reactivex.Observer;
import p011io.reactivex.android.schedulers.AndroidSchedulers;
import p011io.reactivex.observers.DisposableObserver;
import p011io.reactivex.schedulers.Schedulers;
import repack.org.bouncycastle.cms.CMSAttributeTableGenerator;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010?\u001a\u00020@J\u0016\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\fJ\u0006\u0010E\u001a\u00020@J6\u0010F\u001a\u00020@2\u0006\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\f2\u0006\u0010J\u001a\u00020\f2\u0006\u0010K\u001a\u00020\f2\u0006\u0010L\u001a\u00020\fJ\u001e\u0010M\u001a\u00020@2\u0006\u0010D\u001a\u00020\f2\u0006\u0010N\u001a\u00020\f2\u0006\u0010O\u001a\u00020PJ\u000e\u0010Q\u001a\u00020@2\u0006\u0010R\u001a\u00020<R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fX.¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000fX.¢\u0006\u0002\n\u0000R \u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR \u0010&\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001b\"\u0004\b(\u0010\u001dR \u0010)\u001a\b\u0012\u0004\u0012\u00020\f0\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010\u001dR&\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001b\"\u0004\b.\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R0\u0010/\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020100j\b\u0012\u0004\u0012\u000201`20\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0015\"\u0004\b4\u0010\u0017R \u00105\u001a\b\u0012\u0004\u0012\u00020\f0\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001b\"\u0004\b7\u0010\u001dR0\u00108\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020100j\b\u0012\u0004\u0012\u000201`20\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001b\"\u0004\b:\u0010\u001dR \u0010;\u001a\b\u0012\u0004\u0012\u00020<0\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001b\"\u0004\b>\u0010\u001d¨\u0006S"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/quickFilter/QuickFilterViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/iaai/android/bdt/feature/landing/quickFilter/QuickFilterRepository;", "repositoryFastSearch", "Lcom/iaai/android/bdt/feature/viewPager/FastSearchListRepository;", "repositoryFacets", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterRepository;", "savedRepository", "Lcom/iaai/android/bdt/feature/fastSearchFilter/savedSearch/SavedSearchListRepository;", "(Lcom/iaai/android/bdt/feature/landing/quickFilter/QuickFilterRepository;Lcom/iaai/android/bdt/feature/viewPager/FastSearchListRepository;Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterRepository;Lcom/iaai/android/bdt/feature/fastSearchFilter/savedSearch/SavedSearchListRepository;)V", "TAG", "", "kotlin.jvm.PlatformType", "disposableObserver", "Lio/reactivex/observers/DisposableObserver;", "", "Lcom/iaai/android/bdt/model/quickFilter/QuickFilterResponse;", "disposableObserverFastSearch", "Lcom/iaai/android/bdt/model/fastSearch/FastSearchResponse;", "getDisposableObserverFastSearch", "()Lio/reactivex/observers/DisposableObserver;", "setDisposableObserverFastSearch", "(Lio/reactivex/observers/DisposableObserver;)V", "facetsError", "Landroidx/lifecycle/MutableLiveData;", "getFacetsError", "()Landroidx/lifecycle/MutableLiveData;", "setFacetsError", "(Landroidx/lifecycle/MutableLiveData;)V", "facetsResult", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchResponse2;", "getFacetsResult", "setFacetsResult", "fastSearchDisposableObserver", "fastSearchListError", "getFastSearchListError", "setFastSearchListError", "fastSearchListResult", "getFastSearchListResult", "setFastSearchListResult", "quickFilterError", "getQuickFilterError", "setQuickFilterError", "quickFilterResponse", "getQuickFilterResponse", "setQuickFilterResponse", "savedSearchListDisposableObserver", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/savedSearchList/SavedSearchListResponse;", "Lkotlin/collections/ArrayList;", "getSavedSearchListDisposableObserver", "setSavedSearchListDisposableObserver", "savedSearchListError", "getSavedSearchListError", "setSavedSearchListError", "savedSearchListResponse", "getSavedSearchListResponse", "setSavedSearchListResponse", "showLoading", "", "getShowLoading", "setShowLoading", "disposeElements", "", "getFacets", "requestBody", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchRequestBody;", "authHeader", "getQuickFilter", "getSavedSearchList", "authString", "deviceid", "deviceType", "ApiKey", "contentType", "appversion", "loadFastSearchListV2", "deviceID", "fastSearchRequestBody", "Lcom/iaai/android/bdt/model/fastSearch/SearchInputV2;", "updateLoadingIndicator", "status", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: QuickFilterViewModel.kt */
public final class QuickFilterViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public final String TAG = QuickFilterViewModel.class.getSimpleName();
    /* access modifiers changed from: private */
    public DisposableObserver<List<QuickFilterResponse>> disposableObserver;
    @NotNull
    public DisposableObserver<FastSearchResponse> disposableObserverFastSearch;
    @NotNull
    private MutableLiveData<String> facetsError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<FastSearchResponse2> facetsResult = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public DisposableObserver<FastSearchResponse2> fastSearchDisposableObserver;
    @NotNull
    private MutableLiveData<String> fastSearchListError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<FastSearchResponse> fastSearchListResult = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<String> quickFilterError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<List<QuickFilterResponse>> quickFilterResponse = new MutableLiveData<>();
    private final QuickFilterRepository repository;
    private final FastSearchFilterRepository repositoryFacets;
    private final FastSearchListRepository repositoryFastSearch;
    private final SavedSearchListRepository savedRepository;
    @NotNull
    public DisposableObserver<ArrayList<SavedSearchListResponse>> savedSearchListDisposableObserver;
    @NotNull
    private MutableLiveData<String> savedSearchListError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<ArrayList<SavedSearchListResponse>> savedSearchListResponse = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();

    public static final /* synthetic */ DisposableObserver access$getDisposableObserver$p(QuickFilterViewModel quickFilterViewModel) {
        DisposableObserver<List<QuickFilterResponse>> disposableObserver2 = quickFilterViewModel.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        return disposableObserver2;
    }

    public static final /* synthetic */ DisposableObserver access$getFastSearchDisposableObserver$p(QuickFilterViewModel quickFilterViewModel) {
        DisposableObserver<FastSearchResponse2> disposableObserver2 = quickFilterViewModel.fastSearchDisposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchDisposableObserver");
        }
        return disposableObserver2;
    }

    @Inject
    public QuickFilterViewModel(@NotNull QuickFilterRepository quickFilterRepository, @NotNull FastSearchListRepository fastSearchListRepository, @NotNull FastSearchFilterRepository fastSearchFilterRepository, @NotNull SavedSearchListRepository savedSearchListRepository) {
        Intrinsics.checkParameterIsNotNull(quickFilterRepository, "repository");
        Intrinsics.checkParameterIsNotNull(fastSearchListRepository, "repositoryFastSearch");
        Intrinsics.checkParameterIsNotNull(fastSearchFilterRepository, "repositoryFacets");
        Intrinsics.checkParameterIsNotNull(savedSearchListRepository, "savedRepository");
        this.repository = quickFilterRepository;
        this.repositoryFastSearch = fastSearchListRepository;
        this.repositoryFacets = fastSearchFilterRepository;
        this.savedRepository = savedSearchListRepository;
    }

    @NotNull
    public final MutableLiveData<List<QuickFilterResponse>> getQuickFilterResponse() {
        return this.quickFilterResponse;
    }

    public final void setQuickFilterResponse(@NotNull MutableLiveData<List<QuickFilterResponse>> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.quickFilterResponse = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getQuickFilterError() {
        return this.quickFilterError;
    }

    public final void setQuickFilterError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.quickFilterError = mutableLiveData;
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

    @NotNull
    public final MutableLiveData<Boolean> getShowLoading() {
        return this.showLoading;
    }

    public final void setShowLoading(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.showLoading = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<FastSearchResponse> getFastSearchListResult() {
        return this.fastSearchListResult;
    }

    public final void setFastSearchListResult(@NotNull MutableLiveData<FastSearchResponse> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.fastSearchListResult = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getFastSearchListError() {
        return this.fastSearchListError;
    }

    public final void setFastSearchListError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.fastSearchListError = mutableLiveData;
    }

    @NotNull
    public final DisposableObserver<FastSearchResponse> getDisposableObserverFastSearch() {
        DisposableObserver<FastSearchResponse> disposableObserver2 = this.disposableObserverFastSearch;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverFastSearch");
        }
        return disposableObserver2;
    }

    public final void setDisposableObserverFastSearch(@NotNull DisposableObserver<FastSearchResponse> disposableObserver2) {
        Intrinsics.checkParameterIsNotNull(disposableObserver2, "<set-?>");
        this.disposableObserverFastSearch = disposableObserver2;
    }

    @NotNull
    public final MutableLiveData<FastSearchResponse2> getFacetsResult() {
        return this.facetsResult;
    }

    public final void setFacetsResult(@NotNull MutableLiveData<FastSearchResponse2> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.facetsResult = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getFacetsError() {
        return this.facetsError;
    }

    public final void setFacetsError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.facetsError = mutableLiveData;
    }

    public final void loadFastSearchListV2(@NotNull String str, @NotNull String str2, @NotNull SearchInputV2 searchInputV2) {
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        Intrinsics.checkParameterIsNotNull(str2, "deviceID");
        Intrinsics.checkParameterIsNotNull(searchInputV2, "fastSearchRequestBody");
        updateLoadingIndicator(true);
        this.disposableObserverFastSearch = new QuickFilterViewModel$loadFastSearchListV2$1(this);
        Observable<FastSearchResponse> observeOn = this.repositoryFastSearch.getFastSearchListV2(str, str2, searchInputV2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<FastSearchResponse> disposableObserver2 = this.disposableObserverFastSearch;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserverFastSearch");
        }
        observeOn.subscribe((Observer<? super FastSearchResponse>) disposableObserver2);
    }

    public final void getSavedSearchList(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkParameterIsNotNull(str, "authString");
        Intrinsics.checkParameterIsNotNull(str2, "deviceid");
        Intrinsics.checkParameterIsNotNull(str3, "deviceType");
        Intrinsics.checkParameterIsNotNull(str4, "ApiKey");
        Intrinsics.checkParameterIsNotNull(str5, CMSAttributeTableGenerator.CONTENT_TYPE);
        Intrinsics.checkParameterIsNotNull(str6, "appversion");
        updateLoadingIndicator(true);
        this.savedSearchListDisposableObserver = new QuickFilterViewModel$getSavedSearchList$1(this);
        Observable<ArrayList<SavedSearchListResponse>> observeOn = this.savedRepository.getSavedSearchList(str, str2, str3, str4, str5, str6).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<ArrayList<SavedSearchListResponse>> disposableObserver2 = this.savedSearchListDisposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedSearchListDisposableObserver");
        }
        observeOn.subscribe((Observer<? super ArrayList<SavedSearchListResponse>>) disposableObserver2);
    }

    public final void getQuickFilter() {
        updateLoadingIndicator(true);
        this.disposableObserver = new QuickFilterViewModel$getQuickFilter$1(this);
        Observable<List<QuickFilterResponse>> observeOn = this.repository.getQuickFilters().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<List<QuickFilterResponse>> disposableObserver2 = this.disposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
        }
        observeOn.subscribe((Observer<? super List<QuickFilterResponse>>) disposableObserver2);
    }

    public final void getFacets(@NotNull FastSearchRequestBody fastSearchRequestBody, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(fastSearchRequestBody, "requestBody");
        Intrinsics.checkParameterIsNotNull(str, "authHeader");
        updateLoadingIndicator(true);
        this.fastSearchDisposableObserver = new QuickFilterViewModel$getFacets$1(this);
        Observable<FastSearchResponse2> observeOn = this.repositoryFacets.getFastSearchFilterV2("application/json", fastSearchRequestBody, str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<FastSearchResponse2> disposableObserver2 = this.fastSearchDisposableObserver;
        if (disposableObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchDisposableObserver");
        }
        observeOn.subscribe((Observer<? super FastSearchResponse2>) disposableObserver2);
    }

    public final void disposeElements() {
        QuickFilterViewModel quickFilterViewModel = this;
        if (quickFilterViewModel.disposableObserver != null) {
            DisposableObserver<List<QuickFilterResponse>> disposableObserver2 = this.disposableObserver;
            if (disposableObserver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
            }
            if (!disposableObserver2.isDisposed()) {
                DisposableObserver<List<QuickFilterResponse>> disposableObserver3 = this.disposableObserver;
                if (disposableObserver3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserver");
                }
                disposableObserver3.dispose();
            }
        }
        if (quickFilterViewModel.fastSearchDisposableObserver != null) {
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
        if (quickFilterViewModel.disposableObserverFastSearch != null) {
            DisposableObserver<FastSearchResponse> disposableObserver6 = this.disposableObserverFastSearch;
            if (disposableObserver6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disposableObserverFastSearch");
            }
            if (!disposableObserver6.isDisposed()) {
                DisposableObserver<FastSearchResponse> disposableObserver7 = this.disposableObserverFastSearch;
                if (disposableObserver7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("disposableObserverFastSearch");
                }
                disposableObserver7.dispose();
            }
        }
        if (quickFilterViewModel.savedSearchListDisposableObserver != null) {
            DisposableObserver<ArrayList<SavedSearchListResponse>> disposableObserver8 = this.savedSearchListDisposableObserver;
            if (disposableObserver8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("savedSearchListDisposableObserver");
            }
            if (!disposableObserver8.isDisposed()) {
                DisposableObserver<ArrayList<SavedSearchListResponse>> disposableObserver9 = this.savedSearchListDisposableObserver;
                if (disposableObserver9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("savedSearchListDisposableObserver");
                }
                disposableObserver9.dispose();
            }
        }
    }

    public final void updateLoadingIndicator(boolean z) {
        this.showLoading.postValue(Boolean.valueOf(z));
    }
}
