package com.iaai.android.bdt.feature.productDetail.reports;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class IAAConditionReportActivity_MembersInjector implements MembersInjector<IAAConditionReportActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public IAAConditionReportActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.dispatchingAndroidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static MembersInjector<IAAConditionReportActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new IAAConditionReportActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(IAAConditionReportActivity iAAConditionReportActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(iAAConditionReportActivity, this.dispatchingAndroidInjectorProvider.get());
        injectViewModelFactory(iAAConditionReportActivity, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(IAAConditionReportActivity iAAConditionReportActivity, ViewModelProvider.Factory factory) {
        iAAConditionReportActivity.viewModelFactory = factory;
    }
}
