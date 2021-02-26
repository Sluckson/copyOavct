package com.iaai.android.bdt.feature.productDetail.prebid;

import android.util.Log;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.model.productDetail.prebid.PreBidBidHistory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u000b"}, mo66933d2 = {"com/iaai/android/bdt/feature/productDetail/prebid/PreBidViewModel$getBidHistory$1", "Lio/reactivex/observers/DisposableObserver;", "", "Lcom/iaai/android/bdt/model/productDetail/prebid/PreBidBidHistory;", "onComplete", "", "onError", "e", "", "onNext", "response", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PreBidViewModel.kt */
public final class PreBidViewModel$getBidHistory$1 extends DisposableObserver<List<? extends PreBidBidHistory>> {
    final /* synthetic */ String $queryEvent;
    final /* synthetic */ PreBidViewModel this$0;

    PreBidViewModel$getBidHistory$1(PreBidViewModel preBidViewModel, String str) {
        this.this$0 = preBidViewModel;
        this.$queryEvent = str;
    }

    public void onComplete() {
        this.this$0.updateLoadingIndicator(false);
    }

    public void onNext(@NotNull List<PreBidBidHistory> list) {
        Intrinsics.checkParameterIsNotNull(list, "response");
        this.this$0.updateLoadingIndicator(false);
        this.this$0.getPreBidResponse().postValue(list);
        IAAAnalytics iAAAnalytics = IAAAnalytics.INSTANCE;
        String str = this.$queryEvent;
        Intrinsics.checkExpressionValueIsNotNull(str, "queryEvent");
        iAAAnalytics.logNetworkEvent("PreBidding.svc/bidhistory", true, str, "");
    }

    public void onError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        this.this$0.updateLoadingIndicator(false);
        this.this$0.getPreBidError().postValue(th.getMessage());
        IAAAnalytics iAAAnalytics = IAAAnalytics.INSTANCE;
        String str = this.$queryEvent;
        Intrinsics.checkExpressionValueIsNotNull(str, "queryEvent");
        iAAAnalytics.logNetworkEvent("PreBidding.svc/bidhistory", false, str, th.getMessage());
        String access$getTAG$p = this.this$0.TAG;
        Log.e(access$getTAG$p, "getBidHistory: " + th.getMessage());
    }
}
