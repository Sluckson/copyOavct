package com.iaai.android.bdt.injection.module;

import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, mo66933d2 = {"Lcom/iaai/android/bdt/injection/module/UserSessionModule;", "", "()V", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Module
/* compiled from: UserSessionModule.kt */
public final class UserSessionModule {
    @Singleton
    @NotNull
    @Provides
    public final SessionManager sessionManager() {
        return SessionManager.Companion.get();
    }
}
