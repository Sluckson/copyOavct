package com.iaai.android.bdt.feature.viewPager;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.iaai.android.bdt.feature.findVehiclePage.searchResult.dataSource.SearchDataSourceV2;
import com.iaai.android.bdt.model.fastSearch.Refiner;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0001J\u001c\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, mo66933d2 = {"com/iaai/android/bdt/feature/viewPager/FastSearchViewModel$initializePagingV2$4", "Landroidx/arch/core/util/Function;", "Lcom/iaai/android/bdt/feature/findVehiclePage/searchResult/dataSource/SearchDataSourceV2;", "Landroidx/lifecycle/LiveData;", "", "Lcom/iaai/android/bdt/model/fastSearch/Refiner;", "apply", "dataSourceDataSource", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchViewModel.kt */
public final class FastSearchViewModel$initializePagingV2$4 implements Function<SearchDataSourceV2, LiveData<List<? extends Refiner>>> {
    FastSearchViewModel$initializePagingV2$4() {
    }

    @NotNull
    public LiveData<List<Refiner>> apply(@NotNull SearchDataSourceV2 searchDataSourceV2) {
        Intrinsics.checkParameterIsNotNull(searchDataSourceV2, "dataSourceDataSource");
        MutableLiveData refinerData = searchDataSourceV2.getRefinerData();
        if (refinerData != null) {
            return refinerData;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.collections.List<com.iaai.android.bdt.model.fastSearch.Refiner>>");
    }
}
