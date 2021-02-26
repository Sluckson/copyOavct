package roboguice.inject;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.MembersInjector;
import com.google.inject.Provider;
import com.google.inject.internal.Nullable;
import com.google.inject.spi.TypeListener;
import com.google.inject.util.Types;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class ExtrasListener implements TypeListener {
    protected Provider<Context> contextProvider;

    public ExtrasListener(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [com.google.inject.TypeLiteral<I>, com.google.inject.TypeLiteral] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <I> void hear(com.google.inject.TypeLiteral<I> r8, com.google.inject.spi.TypeEncounter<I> r9) {
        /*
            r7 = this;
            java.lang.Class r8 = r8.getRawType()
        L_0x0004:
            if (r8 == 0) goto L_0x0032
            java.lang.reflect.Field[] r0 = r8.getDeclaredFields()
            int r1 = r0.length
            r2 = 0
        L_0x000c:
            if (r2 >= r1) goto L_0x002d
            r3 = r0[r2]
            java.lang.Class<roboguice.inject.InjectExtra> r4 = roboguice.inject.InjectExtra.class
            boolean r4 = r3.isAnnotationPresent(r4)
            if (r4 == 0) goto L_0x002a
            roboguice.inject.ExtrasListener$ExtrasMembersInjector r4 = new roboguice.inject.ExtrasListener$ExtrasMembersInjector
            com.google.inject.Provider<android.content.Context> r5 = r7.contextProvider
            java.lang.Class<roboguice.inject.InjectExtra> r6 = roboguice.inject.InjectExtra.class
            java.lang.annotation.Annotation r6 = r3.getAnnotation(r6)
            roboguice.inject.InjectExtra r6 = (roboguice.inject.InjectExtra) r6
            r4.<init>(r3, r5, r6)
            r9.register(r4)
        L_0x002a:
            int r2 = r2 + 1
            goto L_0x000c
        L_0x002d:
            java.lang.Class r8 = r8.getSuperclass()
            goto L_0x0004
        L_0x0032:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: roboguice.inject.ExtrasListener.hear(com.google.inject.TypeLiteral, com.google.inject.spi.TypeEncounter):void");
    }

    protected static class ExtrasMembersInjector<T> implements MembersInjector<T> {
        protected InjectExtra annotation;
        protected Provider<Context> contextProvider;
        protected Field field;

        public ExtrasMembersInjector(Field field2, Provider<Context> provider, InjectExtra injectExtra) {
            this.field = field2;
            this.contextProvider = provider;
            this.annotation = injectExtra;
        }

        public void injectMembers(T t) {
            Context context = this.contextProvider.get();
            if (context instanceof Activity) {
                String value = this.annotation.value();
                Bundle extras = ((Activity) context).getIntent().getExtras();
                if (extras != null && extras.containsKey(value)) {
                    Object obj = extras.get(value);
                    if (context instanceof InjectorProvider) {
                        obj = convert(this.field, obj, ((InjectorProvider) context).getInjector());
                    }
                    if (obj == null && this.field.getAnnotation(Nullable.class) == null) {
                        throw new NullPointerException(String.format("Can't inject null value into %s.%s when field is not @Nullable", new Object[]{this.field.getDeclaringClass(), this.field.getName()}));
                    }
                    this.field.setAccessible(true);
                    try {
                        this.field.set(t, obj);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (IllegalArgumentException unused) {
                        Object[] objArr = new Object[4];
                        objArr[0] = obj != null ? obj.getClass() : "(null)";
                        objArr[1] = obj;
                        objArr[2] = this.field.getType();
                        objArr[3] = this.field.getName();
                        throw new IllegalArgumentException(String.format("Can't assign %s value %s to %s field %s", objArr));
                    }
                } else if (!this.annotation.optional()) {
                    throw new IllegalStateException(String.format("Can't find the mandatory extra identified by key [%s] on field %s.%s", new Object[]{value, this.field.getDeclaringClass(), this.field.getName()}));
                }
            }
        }

        /* access modifiers changed from: protected */
        public Object convert(Field field2, Object obj, Injector injector) {
            if (obj == null || field2.getType().isPrimitive()) {
                return obj;
            }
            Key<?> key = Key.get((Type) Types.newParameterizedType(ExtraConverter.class, obj.getClass(), field2.getType()));
            return injector.getBindings().containsKey(key) ? ((ExtraConverter) injector.getInstance(key)).convert(obj) : obj;
        }
    }
}
