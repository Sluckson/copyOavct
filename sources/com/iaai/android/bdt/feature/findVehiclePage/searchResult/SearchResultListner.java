package com.iaai.android.bdt.feature.findVehiclePage.searchResult;

import android.view.View;
import com.iaai.android.bdt.model.fastSearch.Vehicle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\"\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/searchResult/SearchResultListner;", "", "onFilterItemClick", "", "position", "", "onSearchresultItemClick", "v", "Landroid/view/View;", "data", "Lcom/iaai/android/bdt/model/fastSearch/Vehicle;", "onSortItemClick", "onUnWatchItemClick", "itemClick", "onWatchItemClick", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SearchResultListner.kt */
public interface SearchResultListner {
    void onFilterItemClick(int i);

    void onSearchresultItemClick(@NotNull View view, @Nullable Vehicle vehicle, int i);

    void onSortItemClick(int i);

    void onUnWatchItemClick(@NotNull View view, int i, int i2);

    void onWatchItemClick(@NotNull View view, int i, int i2);
}
