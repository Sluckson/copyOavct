package com.iaai.android.bdt.feature.findVehiclePage.filter;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: HeaderListAdapter.kt */
final class HeaderListAdapter$getItemCount$1 extends MutablePropertyReference0 {
    HeaderListAdapter$getItemCount$1(HeaderListAdapter headerListAdapter) {
        super(headerListAdapter);
    }

    public String getName() {
        return "itemList";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(HeaderListAdapter.class);
    }

    public String getSignature() {
        return "getItemList()Ljava/util/ArrayList;";
    }

    @Nullable
    public Object get() {
        return HeaderListAdapter.access$getItemList$p((HeaderListAdapter) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((HeaderListAdapter) this.receiver).itemList = (ArrayList) obj;
    }
}
