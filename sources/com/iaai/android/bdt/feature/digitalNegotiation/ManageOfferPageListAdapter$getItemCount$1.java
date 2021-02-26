package com.iaai.android.bdt.feature.digitalNegotiation;

import com.iaai.android.bdt.model.digitalNegotiation.ManageOfferListHeader;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ManageOfferPageListAdapter.kt */
final class ManageOfferPageListAdapter$getItemCount$1 extends MutablePropertyReference0 {
    ManageOfferPageListAdapter$getItemCount$1(ManageOfferPageListAdapter manageOfferPageListAdapter) {
        super(manageOfferPageListAdapter);
    }

    public String getName() {
        return "mManageOfferListHeader";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ManageOfferPageListAdapter.class);
    }

    public String getSignature() {
        return "getMManageOfferListHeader()Lcom/iaai/android/bdt/model/digitalNegotiation/ManageOfferListHeader;";
    }

    @Nullable
    public Object get() {
        return ((ManageOfferPageListAdapter) this.receiver).getMManageOfferListHeader();
    }

    public void set(@Nullable Object obj) {
        ((ManageOfferPageListAdapter) this.receiver).setMManageOfferListHeader((ManageOfferListHeader) obj);
    }
}
