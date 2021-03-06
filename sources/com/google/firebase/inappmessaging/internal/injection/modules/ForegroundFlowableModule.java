package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.ForegroundNotifier;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import p011io.reactivex.flowables.ConnectableFlowable;

@Module
public class ForegroundFlowableModule {
    @AppForeground
    @Singleton
    @Provides
    public ConnectableFlowable<String> providesAppForegroundEventStream(Application application) {
        ForegroundNotifier foregroundNotifier = new ForegroundNotifier();
        ConnectableFlowable<String> foregroundFlowable = foregroundNotifier.foregroundFlowable();
        foregroundFlowable.connect();
        application.registerActivityLifecycleCallbacks(foregroundNotifier);
        return foregroundFlowable;
    }
}
