package roboguice.event;

import android.content.Context;
import com.google.inject.Provider;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ObservesTypeListener implements TypeListener {
    protected Provider<Context> contextProvider;
    protected EventManager eventManager;

    public ObservesTypeListener(Provider<Context> provider, EventManager eventManager2) {
        this.eventManager = eventManager2;
        this.contextProvider = provider;
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [com.google.inject.TypeLiteral<I>, com.google.inject.TypeLiteral] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <I> void hear(com.google.inject.TypeLiteral<I> r9, com.google.inject.spi.TypeEncounter<I> r10) {
        /*
            r8 = this;
            java.lang.Class r9 = r9.getRawType()
        L_0x0004:
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            if (r9 == r0) goto L_0x003b
            java.lang.reflect.Method[] r0 = r9.getDeclaredMethods()
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x000f:
            if (r3 >= r1) goto L_0x0019
            r4 = r0[r3]
            r8.findContextObserver(r4, r10)
            int r3 = r3 + 1
            goto L_0x000f
        L_0x0019:
            java.lang.Class[] r0 = r9.getInterfaces()
            int r1 = r0.length
            r3 = 0
        L_0x001f:
            if (r3 >= r1) goto L_0x0036
            r4 = r0[r3]
            java.lang.reflect.Method[] r4 = r4.getDeclaredMethods()
            int r5 = r4.length
            r6 = 0
        L_0x0029:
            if (r6 >= r5) goto L_0x0033
            r7 = r4[r6]
            r8.findContextObserver(r7, r10)
            int r6 = r6 + 1
            goto L_0x0029
        L_0x0033:
            int r3 = r3 + 1
            goto L_0x001f
        L_0x0036:
            java.lang.Class r9 = r9.getSuperclass()
            goto L_0x0004
        L_0x003b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: roboguice.event.ObservesTypeListener.hear(com.google.inject.TypeLiteral, com.google.inject.spi.TypeEncounter):void");
    }

    /* access modifiers changed from: protected */
    public <I> void findContextObserver(Method method, TypeEncounter<I> typeEncounter) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (int i = 0; i < parameterAnnotations.length; i++) {
            Annotation[] annotationArr = parameterAnnotations[i];
            Class cls = method.getParameterTypes()[i];
            for (Annotation annotationType : annotationArr) {
                if (annotationType.annotationType().equals(Observes.class)) {
                    registerContextObserver(typeEncounter, method, cls);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public <I> void registerContextObserver(TypeEncounter<I> typeEncounter, Method method, Class cls) {
        checkMethodParameters(method);
        typeEncounter.register((InjectionListener<? super I>) new ContextObserverMethodInjector(this.contextProvider, this.eventManager, method, cls));
    }

    /* access modifiers changed from: protected */
    public void checkMethodParameters(Method method) {
        if (method.getParameterTypes().length > 1) {
            throw new RuntimeException("Annotation @Observes must only annotate one parameter, which must be the only parameter in the listener method.");
        }
    }

    public static class ContextObserverMethodInjector<I> implements InjectionListener<I> {
        protected Provider<Context> contextProvider;
        protected Class<?> event;
        protected EventManager eventManager;
        protected Method method;

        public ContextObserverMethodInjector(Provider<Context> provider, EventManager eventManager2, Method method2, Class<?> cls) {
            this.contextProvider = provider;
            this.eventManager = eventManager2;
            this.method = method2;
            this.event = cls;
        }

        public void afterInjection(I i) {
            this.eventManager.registerObserver(this.contextProvider.get(), i, this.method, this.event);
        }
    }
}
