package com.iaai.android.bdt.feature.account;

import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AccountSettingFragment_MembersInjector implements MembersInjector<AccountSettingFragment> {
    private final Provider<SessionManager> sessionManagerProvider;

    public AccountSettingFragment_MembersInjector(Provider<SessionManager> provider) {
        this.sessionManagerProvider = provider;
    }

    public static MembersInjector<AccountSettingFragment> create(Provider<SessionManager> provider) {
        return new AccountSettingFragment_MembersInjector(provider);
    }

    public void injectMembers(AccountSettingFragment accountSettingFragment) {
        injectSessionManager(accountSettingFragment, this.sessionManagerProvider.get());
    }

    public static void injectSessionManager(AccountSettingFragment accountSettingFragment, SessionManager sessionManager) {
        accountSettingFragment.sessionManager = sessionManager;
    }
}
