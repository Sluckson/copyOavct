package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.termsofuse.TermsOfUseAuctionRuleActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {TermsOfUseAuctionRuleActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeTermsOfUseAuctionRuleActivity$app_productionRelease */
public abstract class C2867xe32272e0 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeTermsOfUseAuctionRuleActivity$app_productionRelease$TermsOfUseAuctionRuleActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeTermsOfUseAuctionRuleActivity$app_productionRelease */
    public interface TermsOfUseAuctionRuleActivitySubcomponent extends AndroidInjector<TermsOfUseAuctionRuleActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeTermsOfUseAuctionRuleActivity$app_productionRelease$TermsOfUseAuctionRuleActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeTermsOfUseAuctionRuleActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<TermsOfUseAuctionRuleActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(TermsOfUseAuctionRuleActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(TermsOfUseAuctionRuleActivitySubcomponent.Builder builder);

    private C2867xe32272e0() {
    }
}
