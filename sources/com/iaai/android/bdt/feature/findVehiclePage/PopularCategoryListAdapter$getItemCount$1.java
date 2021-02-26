package com.iaai.android.bdt.feature.findVehiclePage;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: PopularCategoryListAdapter.kt */
final class PopularCategoryListAdapter$getItemCount$1 extends MutablePropertyReference0 {
    PopularCategoryListAdapter$getItemCount$1(PopularCategoryListAdapter popularCategoryListAdapter) {
        super(popularCategoryListAdapter);
    }

    public String getName() {
        return "itemList";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(PopularCategoryListAdapter.class);
    }

    public String getSignature() {
        return "getItemList()Ljava/util/ArrayList;";
    }

    @Nullable
    public Object get() {
        return PopularCategoryListAdapter.access$getItemList$p((PopularCategoryListAdapter) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((PopularCategoryListAdapter) this.receiver).itemList = (ArrayList) obj;
    }
}
