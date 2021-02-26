package com.iaai.android.bdt.injection.component;

import android.app.Application;
import android.content.Context;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.injection.module.ActivityModule;
import com.iaai.android.bdt.injection.module.ApplicationModule;
import com.iaai.android.bdt.injection.module.FragmentModule;
import com.iaai.android.bdt.injection.module.NetworkModule;
import com.iaai.android.bdt.injection.module.PersistenceModule;
import com.iaai.android.bdt.injection.module.UserSessionModule;
import com.iaai.android.bdt.injection.module.ViewModelModule;
import com.iaai.android.bdt.utils.SharedPrefsHelper;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import javax.inject.Singleton;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Component(modules = {AndroidInjectionModule.class, ActivityModule.class, FragmentModule.class, ViewModelModule.class, NetworkModule.class, PersistenceModule.class, UserSessionModule.class, ApplicationModule.class})
@Singleton
@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, mo66933d2 = {"Lcom/iaai/android/bdt/injection/component/AppComponent;", "Ldagger/android/AndroidInjector;", "Ldagger/android/DaggerApplication;", "getApplication", "Landroid/app/Application;", "getContext", "Landroid/content/Context;", "getPreferenceHelper", "Lcom/iaai/android/bdt/utils/SharedPrefsHelper;", "inject", "", "iaaiApplication", "Lcom/iaai/android/IaaiApplication;", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AppComponent.kt */
public interface AppComponent extends AndroidInjector<DaggerApplication> {
    @NotNull
    Application getApplication();

    @NotNull
    Context getContext();

    @NotNull
    SharedPrefsHelper getPreferenceHelper();

    void inject(@NotNull IaaiApplication iaaiApplication);

    @NotNull
    SessionManager sessionManager();
}
