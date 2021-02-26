package com.iaai.android.bdt.feature.fastSearchFilter.savedSearch;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.iaai.android.bdt.model.savedSearchList.SavedSearchListResponse;
import java.util.ArrayList;
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

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J>\u0010\b\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0006J\u0006\u0010/\u001a\u00020'J6\u00100\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006J\b\u00101\u001a\u00020'H\u0014J\u000e\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020\nR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R0\u0010\u0018\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b0\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR0\u0010!\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR \u0010$\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000e¨\u00064"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/savedSearch/SavedSearchListViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/iaai/android/bdt/feature/fastSearchFilter/savedSearch/SavedSearchListRepository;", "(Lcom/iaai/android/bdt/feature/fastSearchFilter/savedSearch/SavedSearchListRepository;)V", "TAG", "", "kotlin.jvm.PlatformType", "deleteSavedSearch", "Landroidx/lifecycle/MutableLiveData;", "", "getDeleteSavedSearch", "()Landroidx/lifecycle/MutableLiveData;", "setDeleteSavedSearch", "(Landroidx/lifecycle/MutableLiveData;)V", "deleteSavedSearchDisposableObserver", "Lio/reactivex/observers/DisposableObserver;", "getDeleteSavedSearchDisposableObserver", "()Lio/reactivex/observers/DisposableObserver;", "setDeleteSavedSearchDisposableObserver", "(Lio/reactivex/observers/DisposableObserver;)V", "deleteSavedSearchError", "getDeleteSavedSearchError", "setDeleteSavedSearchError", "savedSearchListDisposableObserver", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/savedSearchList/SavedSearchListResponse;", "Lkotlin/collections/ArrayList;", "getSavedSearchListDisposableObserver", "setSavedSearchListDisposableObserver", "savedSearchListError", "getSavedSearchListError", "setSavedSearchListError", "savedSearchListResponse", "getSavedSearchListResponse", "setSavedSearchListResponse", "showLoading", "getShowLoading", "setShowLoading", "", "contentType", "authString", "deviceType", "deviceid", "ApiKey", "appversion", "savedSearch", "disposeElements", "getSavedSearchList", "onCleared", "updateLoadingIndicator", "status", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SavedSearchListViewModel.kt */
public final class SavedSearchListViewModel extends ViewModel {
    private final String TAG = SavedSearchListViewModel.class.getSimpleName();
    @NotNull
    private MutableLiveData<Boolean> deleteSavedSearch = new MutableLiveData<>();
    @NotNull
    public DisposableObserver<Boolean> deleteSavedSearchDisposableObserver;
    @NotNull
    private MutableLiveData<String> deleteSavedSearchError = new MutableLiveData<>();
    private final SavedSearchListRepository repository;
    @NotNull
    public DisposableObserver<ArrayList<SavedSearchListResponse>> savedSearchListDisposableObserver;
    @NotNull
    private MutableLiveData<String> savedSearchListError = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<ArrayList<SavedSearchListResponse>> savedSearchListResponse = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<Boolean> showLoading = new MutableLiveData<>();

    @Inject
    public SavedSearchListViewModel(@NotNull SavedSearchListRepository savedSearchListRepository) {
        Intrinsics.checkParameterIsNotNull(savedSearchListRepository, "repository");
        this.repository = savedSearchListRepository;
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
        DisposableObserver<ArrayList<SavedSearchListResponse>> disposableObserver = this.savedSearchListDisposableObserver;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedSearchListDisposableObserver");
        }
        return disposableObserver;
    }

    public final void setSavedSearchListDisposableObserver(@NotNull DisposableObserver<ArrayList<SavedSearchListResponse>> disposableObserver) {
        Intrinsics.checkParameterIsNotNull(disposableObserver, "<set-?>");
        this.savedSearchListDisposableObserver = disposableObserver;
    }

    @NotNull
    public final MutableLiveData<Boolean> getDeleteSavedSearch() {
        return this.deleteSavedSearch;
    }

    public final void setDeleteSavedSearch(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.deleteSavedSearch = mutableLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getDeleteSavedSearchError() {
        return this.deleteSavedSearchError;
    }

    public final void setDeleteSavedSearchError(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.deleteSavedSearchError = mutableLiveData;
    }

    @NotNull
    public final DisposableObserver<Boolean> getDeleteSavedSearchDisposableObserver() {
        DisposableObserver<Boolean> disposableObserver = this.deleteSavedSearchDisposableObserver;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteSavedSearchDisposableObserver");
        }
        return disposableObserver;
    }

    public final void setDeleteSavedSearchDisposableObserver(@NotNull DisposableObserver<Boolean> disposableObserver) {
        Intrinsics.checkParameterIsNotNull(disposableObserver, "<set-?>");
        this.deleteSavedSearchDisposableObserver = disposableObserver;
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowLoading() {
        return this.showLoading;
    }

    public final void setShowLoading(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.showLoading = mutableLiveData;
    }

    public final void getSavedSearchList(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkParameterIsNotNull(str, "authString");
        Intrinsics.checkParameterIsNotNull(str2, "deviceid");
        Intrinsics.checkParameterIsNotNull(str3, "deviceType");
        Intrinsics.checkParameterIsNotNull(str4, "ApiKey");
        Intrinsics.checkParameterIsNotNull(str5, CMSAttributeTableGenerator.CONTENT_TYPE);
        Intrinsics.checkParameterIsNotNull(str6, "appversion");
        updateLoadingIndicator(true);
        this.savedSearchListDisposableObserver = new SavedSearchListViewModel$getSavedSearchList$1(this);
        Observable<ArrayList<SavedSearchListResponse>> observeOn = this.repository.getSavedSearchList(str, str2, str3, str4, str5, str6).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<ArrayList<SavedSearchListResponse>> disposableObserver = this.savedSearchListDisposableObserver;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedSearchListDisposableObserver");
        }
        observeOn.subscribe((Observer<? super ArrayList<SavedSearchListResponse>>) disposableObserver);
    }

    public final void deleteSavedSearch(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkParameterIsNotNull(str, CMSAttributeTableGenerator.CONTENT_TYPE);
        Intrinsics.checkParameterIsNotNull(str2, "authString");
        Intrinsics.checkParameterIsNotNull(str3, "deviceType");
        Intrinsics.checkParameterIsNotNull(str4, "deviceid");
        Intrinsics.checkParameterIsNotNull(str5, "ApiKey");
        String str8 = str6;
        Intrinsics.checkParameterIsNotNull(str8, "appversion");
        String str9 = str7;
        Intrinsics.checkParameterIsNotNull(str9, "savedSearch");
        updateLoadingIndicator(true);
        this.deleteSavedSearchDisposableObserver = new SavedSearchListViewModel$deleteSavedSearch$1(this);
        Observable<Boolean> observeOn = this.repository.deleteSavedSearchList(str, str2, str3, str4, str5, str8, str9).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
        DisposableObserver<Boolean> disposableObserver = this.deleteSavedSearchDisposableObserver;
        if (disposableObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteSavedSearchDisposableObserver");
        }
        observeOn.subscribe((Observer<? super Boolean>) disposableObserver);
    }

    public final void updateLoadingIndicator(boolean z) {
        this.showLoading.postValue(Boolean.valueOf(z));
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        SavedSearchListViewModel savedSearchListViewModel = this;
        if (savedSearchListViewModel.savedSearchListDisposableObserver != null) {
            DisposableObserver<ArrayList<SavedSearchListResponse>> disposableObserver = this.savedSearchListDisposableObserver;
            if (disposableObserver == null) {
                Intrinsics.throwUninitializedPropertyAccessException("savedSearchListDisposableObserver");
            }
            if (!disposableObserver.isDisposed()) {
                DisposableObserver<ArrayList<SavedSearchListResponse>> disposableObserver2 = this.savedSearchListDisposableObserver;
                if (disposableObserver2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("savedSearchListDisposableObserver");
                }
                disposableObserver2.dispose();
            }
        }
        if (savedSearchListViewModel.deleteSavedSearchDisposableObserver != null) {
            DisposableObserver<Boolean> disposableObserver3 = this.deleteSavedSearchDisposableObserver;
            if (disposableObserver3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deleteSavedSearchDisposableObserver");
            }
            if (!disposableObserver3.isDisposed()) {
                DisposableObserver<Boolean> disposableObserver4 = this.deleteSavedSearchDisposableObserver;
                if (disposableObserver4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("deleteSavedSearchDisposableObserver");
                }
                disposableObserver4.dispose();
            }
        }
    }

    public final void disposeElements() {
        SavedSearchListViewModel savedSearchListViewModel = this;
        if (savedSearchListViewModel.savedSearchListDisposableObserver != null) {
            DisposableObserver<ArrayList<SavedSearchListResponse>> disposableObserver = this.savedSearchListDisposableObserver;
            if (disposableObserver == null) {
                Intrinsics.throwUninitializedPropertyAccessException("savedSearchListDisposableObserver");
            }
            if (!disposableObserver.isDisposed()) {
                DisposableObserver<ArrayList<SavedSearchListResponse>> disposableObserver2 = this.savedSearchListDisposableObserver;
                if (disposableObserver2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("savedSearchListDisposableObserver");
                }
                disposableObserver2.dispose();
            }
        }
        if (savedSearchListViewModel.deleteSavedSearchDisposableObserver != null) {
            DisposableObserver<Boolean> disposableObserver3 = this.deleteSavedSearchDisposableObserver;
            if (disposableObserver3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deleteSavedSearchDisposableObserver");
            }
            if (!disposableObserver3.isDisposed()) {
                DisposableObserver<Boolean> disposableObserver4 = this.deleteSavedSearchDisposableObserver;
                if (disposableObserver4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("deleteSavedSearchDisposableObserver");
                }
                disposableObserver4.dispose();
            }
        }
    }
}
