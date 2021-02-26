package roboguice.inject;

import android.app.Application;
import android.content.Context;
import com.google.inject.Provider;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class PreferenceListener implements StaticTypeListener {
    protected Application application;
    protected Provider<Context> contextProvider;
    protected ContextScope scope;

    public PreferenceListener(Provider<Context> provider, Application application2, ContextScope contextScope) {
        this.contextProvider = provider;
        this.application = application2;
        this.scope = contextScope;
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [com.google.inject.TypeLiteral<I>, com.google.inject.TypeLiteral] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <I> void hear(com.google.inject.TypeLiteral<I> r9, com.google.inject.spi.TypeEncounter<I> r10) {
        /*
            r8 = this;
            java.lang.Class r9 = r9.getRawType()
        L_0x0004:
            if (r9 == 0) goto L_0x003e
            java.lang.reflect.Field[] r0 = r9.getDeclaredFields()
            int r1 = r0.length
            r2 = 0
        L_0x000c:
            if (r2 >= r1) goto L_0x0039
            r3 = r0[r2]
            int r4 = r3.getModifiers()
            boolean r4 = java.lang.reflect.Modifier.isStatic(r4)
            if (r4 != 0) goto L_0x0036
            java.lang.Class<roboguice.inject.InjectPreference> r4 = roboguice.inject.InjectPreference.class
            boolean r4 = r3.isAnnotationPresent(r4)
            if (r4 == 0) goto L_0x0036
            roboguice.inject.PreferenceMembersInjector r4 = new roboguice.inject.PreferenceMembersInjector
            com.google.inject.Provider<android.content.Context> r5 = r8.contextProvider
            java.lang.Class<roboguice.inject.InjectPreference> r6 = roboguice.inject.InjectPreference.class
            java.lang.annotation.Annotation r6 = r3.getAnnotation(r6)
            roboguice.inject.InjectPreference r6 = (roboguice.inject.InjectPreference) r6
            roboguice.inject.ContextScope r7 = r8.scope
            r4.<init>(r3, r5, r6, r7)
            r10.register(r4)
        L_0x0036:
            int r2 = r2 + 1
            goto L_0x000c
        L_0x0039:
            java.lang.Class r9 = r9.getSuperclass()
            goto L_0x0004
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: roboguice.inject.PreferenceListener.hear(com.google.inject.TypeLiteral, com.google.inject.spi.TypeEncounter):void");
    }

    public void requestStaticInjection(Class<?>... clsArr) {
        for (Class<? super Object> cls : clsArr) {
            while (cls != null) {
                for (Field field : cls.getDeclaredFields()) {
                    if (Modifier.isStatic(field.getModifiers()) && field.isAnnotationPresent(InjectPreference.class)) {
                        new PreferenceMembersInjector(field, this.contextProvider, (InjectPreference) field.getAnnotation(InjectPreference.class), this.scope).injectMembers(null);
                    }
                }
                cls = cls.getSuperclass();
            }
        }
    }
}
