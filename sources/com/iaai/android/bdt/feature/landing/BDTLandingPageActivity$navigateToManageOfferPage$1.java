package com.iaai.android.bdt.feature.landing;

import com.iaai.android.bdt.model.DashBoardDetails;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTLandingPageActivity.kt */
final class BDTLandingPageActivity$navigateToManageOfferPage$1 extends MutablePropertyReference0 {
    BDTLandingPageActivity$navigateToManageOfferPage$1(BDTLandingPageActivity bDTLandingPageActivity) {
        super(bDTLandingPageActivity);
    }

    public String getName() {
        return "dashBoardDetails";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(BDTLandingPageActivity.class);
    }

    public String getSignature() {
        return "getDashBoardDetails()Lcom/iaai/android/bdt/model/DashBoardDetails;";
    }

    @Nullable
    public Object get() {
        return ((BDTLandingPageActivity) this.receiver).getDashBoardDetails();
    }

    public void set(@Nullable Object obj) {
        ((BDTLandingPageActivity) this.receiver).setDashBoardDetails((DashBoardDetails) obj);
    }
}
