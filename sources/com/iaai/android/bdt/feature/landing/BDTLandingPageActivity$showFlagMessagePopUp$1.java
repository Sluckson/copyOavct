package com.iaai.android.bdt.feature.landing;

import com.iaai.android.bdt.model.BrokerHelpInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTLandingPageActivity.kt */
final class BDTLandingPageActivity$showFlagMessagePopUp$1 extends MutablePropertyReference0 {
    BDTLandingPageActivity$showFlagMessagePopUp$1(BDTLandingPageActivity bDTLandingPageActivity) {
        super(bDTLandingPageActivity);
    }

    public String getName() {
        return "brokerHelpInfo";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(BDTLandingPageActivity.class);
    }

    public String getSignature() {
        return "getBrokerHelpInfo()Lcom/iaai/android/bdt/model/BrokerHelpInfo;";
    }

    @Nullable
    public Object get() {
        return ((BDTLandingPageActivity) this.receiver).getBrokerHelpInfo();
    }

    public void set(@Nullable Object obj) {
        ((BDTLandingPageActivity) this.receiver).setBrokerHelpInfo((BrokerHelpInfo) obj);
    }
}
