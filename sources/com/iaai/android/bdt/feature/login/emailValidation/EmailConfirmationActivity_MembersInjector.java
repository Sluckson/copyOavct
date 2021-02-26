package com.iaai.android.bdt.feature.login.emailValidation;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class EmailConfirmationActivity_MembersInjector implements MembersInjector<EmailConfirmationActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public EmailConfirmationActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.dispatchingAndroidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static MembersInjector<EmailConfirmationActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new EmailConfirmationActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(EmailConfirmationActivity emailConfirmationActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(emailConfirmationActivity, this.dispatchingAndroidInjectorProvider.get());
        injectViewModelFactory(emailConfirmationActivity, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(EmailConfirmationActivity emailConfirmationActivity, ViewModelProvider.Factory factory) {
        emailConfirmationActivity.viewModelFactory = factory;
    }
}
