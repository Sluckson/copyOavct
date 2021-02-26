package roboguice.application;

import com.google.inject.Injector;
import roboguice.inject.ContextScope;

public class RoboInjectableApplication extends RoboApplication {
    public void onCreate() {
        super.onCreate();
        Injector injector = getInjector();
        ((ContextScope) injector.getInstance(ContextScope.class)).enter(this);
        injector.injectMembers(this);
    }
}
