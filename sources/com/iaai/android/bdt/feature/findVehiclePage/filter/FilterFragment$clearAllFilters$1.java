package com.iaai.android.bdt.feature.findVehiclePage.filter;

import com.iaai.android.bdt.feature.findVehiclePage.PopularCategoryListAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FilterFragment.kt */
final class FilterFragment$clearAllFilters$1 extends MutablePropertyReference0 {
    FilterFragment$clearAllFilters$1(FilterFragment filterFragment) {
        super(filterFragment);
    }

    public String getName() {
        return "popularCategoryListAdapter";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(FilterFragment.class);
    }

    public String getSignature() {
        return "getPopularCategoryListAdapter()Lcom/iaai/android/bdt/feature/findVehiclePage/PopularCategoryListAdapter;";
    }

    @Nullable
    public Object get() {
        return FilterFragment.access$getPopularCategoryListAdapter$p((FilterFragment) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((FilterFragment) this.receiver).popularCategoryListAdapter = (PopularCategoryListAdapter) obj;
    }
}
