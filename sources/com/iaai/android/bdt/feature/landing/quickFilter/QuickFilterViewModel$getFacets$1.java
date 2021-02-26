package com.iaai.android.bdt.feature.landing.quickFilter;

import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchResponse2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, mo66933d2 = {"com/iaai/android/bdt/feature/landing/quickFilter/QuickFilterViewModel$getFacets$1", "Lio/reactivex/observers/DisposableObserver;", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchResponse2;", "onComplete", "", "onError", "e", "", "onNext", "response", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: QuickFilterViewModel.kt */
public final class QuickFilterViewModel$getFacets$1 extends DisposableObserver<FastSearchResponse2> {
    final /* synthetic */ QuickFilterViewModel this$0;

    public void onComplete() {
    }

    QuickFilterViewModel$getFacets$1(QuickFilterViewModel quickFilterViewModel) {
        this.this$0 = quickFilterViewModel;
    }

    public void onNext(@NotNull FastSearchResponse2 fastSearchResponse2) {
        Intrinsics.checkParameterIsNotNull(fastSearchResponse2, "response");
        this.this$0.updateLoadingIndicator(false);
        this.this$0.getFacetsResult().postValue(fastSearchResponse2);
    }

    public void onError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        this.this$0.updateLoadingIndicator(false);
        this.this$0.getFacetsError().postValue(th.getMessage());
    }
}
