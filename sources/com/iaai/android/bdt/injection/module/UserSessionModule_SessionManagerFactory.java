package com.iaai.android.bdt.injection.module;

import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class UserSessionModule_SessionManagerFactory implements Factory<SessionManager> {
    private final UserSessionModule module;

    public UserSessionModule_SessionManagerFactory(UserSessionModule userSessionModule) {
        this.module = userSessionModule;
    }

    public SessionManager get() {
        return provideInstance(this.module);
    }

    public static SessionManager provideInstance(UserSessionModule userSessionModule) {
        return proxySessionManager(userSessionModule);
    }

    public static UserSessionModule_SessionManagerFactory create(UserSessionModule userSessionModule) {
        return new UserSessionModule_SessionManagerFactory(userSessionModule);
    }

    public static SessionManager proxySessionManager(UserSessionModule userSessionModule) {
        return (SessionManager) Preconditions.checkNotNull(userSessionModule.sessionManager(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
