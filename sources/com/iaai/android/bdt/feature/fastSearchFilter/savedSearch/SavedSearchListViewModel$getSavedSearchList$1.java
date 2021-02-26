package com.iaai.android.bdt.feature.fastSearchFilter.savedSearch;

import com.iaai.android.bdt.model.savedSearchList.SavedSearchListResponse;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u00062\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016¨\u0006\f"}, mo66933d2 = {"com/iaai/android/bdt/feature/fastSearchFilter/savedSearch/SavedSearchListViewModel$getSavedSearchList$1", "Lio/reactivex/observers/DisposableObserver;", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/savedSearchList/SavedSearchListResponse;", "Lkotlin/collections/ArrayList;", "onComplete", "", "onError", "e", "", "onNext", "response", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SavedSearchListViewModel.kt */
public final class SavedSearchListViewModel$getSavedSearchList$1 extends DisposableObserver<ArrayList<SavedSearchListResponse>> {
    final /* synthetic */ SavedSearchListViewModel this$0;

    public void onComplete() {
    }

    SavedSearchListViewModel$getSavedSearchList$1(SavedSearchListViewModel savedSearchListViewModel) {
        this.this$0 = savedSearchListViewModel;
    }

    public void onNext(@NotNull ArrayList<SavedSearchListResponse> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "response");
        this.this$0.updateLoadingIndicator(false);
        this.this$0.getSavedSearchListResponse().postValue(arrayList);
    }

    public void onError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        this.this$0.updateLoadingIndicator(false);
        this.this$0.getSavedSearchListError().postValue(th.getMessage());
    }
}
