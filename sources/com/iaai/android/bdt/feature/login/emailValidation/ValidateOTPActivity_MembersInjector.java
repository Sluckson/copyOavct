package com.iaai.android.bdt.feature.login.emailValidation;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class ValidateOTPActivity_MembersInjector implements MembersInjector<ValidateOTPActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public ValidateOTPActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.dispatchingAndroidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static MembersInjector<ValidateOTPActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new ValidateOTPActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(ValidateOTPActivity validateOTPActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(validateOTPActivity, this.dispatchingAndroidInjectorProvider.get());
        injectViewModelFactory(validateOTPActivity, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(ValidateOTPActivity validateOTPActivity, ViewModelProvider.Factory factory) {
        validateOTPActivity.viewModelFactory = factory;
    }
}
