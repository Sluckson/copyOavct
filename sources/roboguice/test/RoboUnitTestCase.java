package roboguice.test;

import android.app.Instrumentation;
import android.content.Context;
import android.test.InstrumentationTestCase;
import com.google.inject.Injector;
import java.lang.reflect.ParameterizedType;
import roboguice.application.RoboApplication;
import roboguice.inject.ContextScope;

public class RoboUnitTestCase<AppType extends RoboApplication> extends InstrumentationTestCase {
    protected Injector injector;

    /* access modifiers changed from: protected */
    public void runTest() throws Throwable {
        Instrumentation instrumentation = getInstrumentation();
        Context targetContext = instrumentation.getTargetContext();
        this.injector = ((RoboApplication) applicationType().getConstructor(new Class[]{Instrumentation.class}).newInstance(new Object[]{instrumentation})).getInjector();
        ContextScope contextScope = (ContextScope) this.injector.getInstance(ContextScope.class);
        try {
            contextScope.enter(targetContext);
            RoboUnitTestCase.super.runTest();
        } finally {
            contextScope.exit(targetContext);
        }
    }

    /* access modifiers changed from: protected */
    public Injector getInjector() {
        return this.injector;
    }

    /* access modifiers changed from: protected */
    public Class<? extends RoboApplication> applicationType() {
        return (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
