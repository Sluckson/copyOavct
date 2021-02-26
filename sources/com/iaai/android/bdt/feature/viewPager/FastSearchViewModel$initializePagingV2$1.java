package com.iaai.android.bdt.feature.viewPager;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.iaai.android.bdt.feature.findVehiclePage.searchResult.dataSource.SearchDataSourceV2;
import com.iaai.android.bdt.utils.NetworkState;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, mo66933d2 = {"com/iaai/android/bdt/feature/viewPager/FastSearchViewModel$initializePagingV2$1", "Landroidx/arch/core/util/Function;", "Lcom/iaai/android/bdt/feature/findVehiclePage/searchResult/dataSource/SearchDataSourceV2;", "Landroidx/lifecycle/LiveData;", "Lcom/iaai/android/bdt/utils/NetworkState;", "apply", "dataSourceDataSource", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchViewModel.kt */
public final class FastSearchViewModel$initializePagingV2$1 implements Function<SearchDataSourceV2, LiveData<NetworkState>> {
    FastSearchViewModel$initializePagingV2$1() {
    }

    @NotNull
    public LiveData<NetworkState> apply(@NotNull SearchDataSourceV2 searchDataSourceV2) {
        Intrinsics.checkParameterIsNotNull(searchDataSourceV2, "dataSourceDataSource");
        MutableLiveData networkState = searchDataSourceV2.getNetworkState();
        if (networkState != null) {
            return networkState;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LiveData<com.iaai.android.bdt.utils.NetworkState>");
    }
}
