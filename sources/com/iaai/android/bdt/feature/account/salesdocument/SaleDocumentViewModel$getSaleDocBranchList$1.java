package com.iaai.android.bdt.feature.account.salesdocument;

import com.iaai.android.bdt.model.MyAccount.SaleDocBranchFilterResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u000b"}, mo66933d2 = {"com/iaai/android/bdt/feature/account/salesdocument/SaleDocumentViewModel$getSaleDocBranchList$1", "Lio/reactivex/observers/DisposableObserver;", "", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocBranchFilterResponse;", "onComplete", "", "onError", "e", "", "onNext", "response", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SaleDocumentViewModel.kt */
public final class SaleDocumentViewModel$getSaleDocBranchList$1 extends DisposableObserver<List<? extends SaleDocBranchFilterResponse>> {
    final /* synthetic */ SaleDocumentViewModel this$0;

    public void onComplete() {
    }

    SaleDocumentViewModel$getSaleDocBranchList$1(SaleDocumentViewModel saleDocumentViewModel) {
        this.this$0 = saleDocumentViewModel;
    }

    public void onNext(@NotNull List<SaleDocBranchFilterResponse> list) {
        Intrinsics.checkParameterIsNotNull(list, "response");
        this.this$0.getSaleDocBranchResponse().postValue(list);
    }

    public void onError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        this.this$0.getSaleDocBranchListError().postValue(th.getMessage());
    }
}
