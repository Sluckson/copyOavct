package com.iaai.android.bdt.feature.findVehiclePage.filter;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FilterFragment.kt */
final class FilterFragment$handleMakeModelMultiSelectRequestCode$3 extends MutablePropertyReference0 {
    FilterFragment$handleMakeModelMultiSelectRequestCode$3(FilterFragment filterFragment) {
        super(filterFragment);
    }

    public String getName() {
        return "expandableListAdapter";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(FilterFragment.class);
    }

    public String getSignature() {
        return "getExpandableListAdapter()Lcom/iaai/android/bdt/feature/findVehiclePage/filter/FilterListExpandableListAdapter;";
    }

    @Nullable
    public Object get() {
        return FilterFragment.access$getExpandableListAdapter$p((FilterFragment) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((FilterFragment) this.receiver).expandableListAdapter = (FilterListExpandableListAdapter) obj;
    }
}
