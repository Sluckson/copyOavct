package com.iaai.android.bdt.feature.login;

import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;

public final class SessionManager_Companion_MembersInjector implements MembersInjector<SessionManager.Companion> {
    public static MembersInjector<SessionManager.Companion> create() {
        return new SessionManager_Companion_MembersInjector();
    }

    public void injectMembers(SessionManager.Companion companion) {
        injectGet(companion);
    }

    public static SessionManager injectGet(SessionManager.Companion companion) {
        return companion.get();
    }
}
