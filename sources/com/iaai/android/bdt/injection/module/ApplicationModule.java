package com.iaai.android.bdt.injection.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0003H\u0001¢\u0006\u0002\b\u0006J\r\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\tJ\r\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\b\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/injection/module/ApplicationModule;", "", "mApplication", "Landroid/app/Application;", "(Landroid/app/Application;)V", "provideApplication", "provideApplication$app_productionRelease", "provideContext", "Landroid/content/Context;", "provideContext$app_productionRelease", "provideSharedPreferences", "Landroid/content/SharedPreferences;", "provideSharedPreferences$app_productionRelease", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Module
/* compiled from: ApplicationModule.kt */
public final class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(@NotNull Application application) {
        Intrinsics.checkParameterIsNotNull(application, "mApplication");
        this.mApplication = application;
    }

    @NotNull
    @Provides
    public final Context provideContext$app_productionRelease() {
        return this.mApplication;
    }

    @NotNull
    @Provides
    public final Application provideApplication$app_productionRelease() {
        return this.mApplication;
    }

    @Singleton
    @NotNull
    @Provides
    public final SharedPreferences provideSharedPreferences$app_productionRelease() {
        SharedPreferences sharedPreferences = this.mApplication.getSharedPreferences("Buyer_Preferences", 0);
        Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "mApplication.getSharedPr…s\", Context.MODE_PRIVATE)");
        return sharedPreferences;
    }
}
