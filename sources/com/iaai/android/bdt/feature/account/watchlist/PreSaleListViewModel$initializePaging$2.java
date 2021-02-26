package com.iaai.android.bdt.feature.account.watchlist;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.iaai.android.bdt.feature.account.watchlist.datasource.PreSaleListDataSource;
import com.iaai.android.bdt.model.MyAccount.WatchListResponse;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, mo66933d2 = {"com/iaai/android/bdt/feature/account/watchlist/PreSaleListViewModel$initializePaging$2", "Landroidx/arch/core/util/Function;", "Lcom/iaai/android/bdt/feature/account/watchlist/datasource/PreSaleListDataSource;", "Landroidx/lifecycle/LiveData;", "Lcom/iaai/android/bdt/model/MyAccount/WatchListResponse;", "apply", "dataSourceDataSource", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PreSaleListViewModel.kt */
public final class PreSaleListViewModel$initializePaging$2 implements Function<PreSaleListDataSource, LiveData<WatchListResponse>> {
    PreSaleListViewModel$initializePaging$2() {
    }

    @NotNull
    public LiveData<WatchListResponse> apply(@NotNull PreSaleListDataSource preSaleListDataSource) {
        Intrinsics.checkParameterIsNotNull(preSaleListDataSource, "dataSourceDataSource");
        MutableLiveData preSaleListResponse = preSaleListDataSource.getPreSaleListResponse();
        if (preSaleListResponse != null) {
            return preSaleListResponse;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LiveData<com.iaai.android.bdt.model.MyAccount.WatchListResponse>");
    }
}
