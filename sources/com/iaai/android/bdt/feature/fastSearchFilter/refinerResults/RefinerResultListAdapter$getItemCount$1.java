package com.iaai.android.bdt.feature.fastSearchFilter.refinerResults;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: RefinerResultListAdapter.kt */
final class RefinerResultListAdapter$getItemCount$1 extends MutablePropertyReference0 {
    RefinerResultListAdapter$getItemCount$1(RefinerResultListAdapter refinerResultListAdapter) {
        super(refinerResultListAdapter);
    }

    public String getName() {
        return "refinerResultHeaderModel";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(RefinerResultListAdapter.class);
    }

    public String getSignature() {
        return "getRefinerResultHeaderModel()Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultHeaderModel;";
    }

    @Nullable
    public Object get() {
        return ((RefinerResultListAdapter) this.receiver).getRefinerResultHeaderModel();
    }

    public void set(@Nullable Object obj) {
        ((RefinerResultListAdapter) this.receiver).setRefinerResultHeaderModel((RefinerResultHeaderModel) obj);
    }
}
