package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchFilterActivity.kt */
final class FastSearchFilterActivity$updateUIForFindVehicle$1 extends MutablePropertyReference0 {
    FastSearchFilterActivity$updateUIForFindVehicle$1(FastSearchFilterActivity fastSearchFilterActivity) {
        super(fastSearchFilterActivity);
    }

    public String getName() {
        return "fastSearchFilterFragment";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(FastSearchFilterActivity.class);
    }

    public String getSignature() {
        return "getFastSearchFilterFragment()Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterFragment;";
    }

    @Nullable
    public Object get() {
        return FastSearchFilterActivity.access$getFastSearchFilterFragment$p((FastSearchFilterActivity) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((FastSearchFilterActivity) this.receiver).fastSearchFilterFragment = (FastSearchFilterFragment) obj;
    }
}
