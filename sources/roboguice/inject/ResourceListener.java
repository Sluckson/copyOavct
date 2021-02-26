package roboguice.inject;

import android.app.Application;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.google.inject.MembersInjector;
import com.google.inject.internal.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ResourceListener implements StaticTypeListener {
    protected Application application;

    public ResourceListener(Application application2) {
        this.application = application2;
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [com.google.inject.TypeLiteral<I>, com.google.inject.TypeLiteral] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <I> void hear(com.google.inject.TypeLiteral<I> r8, com.google.inject.spi.TypeEncounter<I> r9) {
        /*
            r7 = this;
            java.lang.Class r8 = r8.getRawType()
        L_0x0004:
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            if (r8 == r0) goto L_0x003e
            java.lang.reflect.Field[] r0 = r8.getDeclaredFields()
            int r1 = r0.length
            r2 = 0
        L_0x000e:
            if (r2 >= r1) goto L_0x0039
            r3 = r0[r2]
            int r4 = r3.getModifiers()
            boolean r4 = java.lang.reflect.Modifier.isStatic(r4)
            if (r4 != 0) goto L_0x0036
            java.lang.Class<roboguice.inject.InjectResource> r4 = roboguice.inject.InjectResource.class
            boolean r4 = r3.isAnnotationPresent(r4)
            if (r4 == 0) goto L_0x0036
            roboguice.inject.ResourceListener$ResourceMembersInjector r4 = new roboguice.inject.ResourceListener$ResourceMembersInjector
            android.app.Application r5 = r7.application
            java.lang.Class<roboguice.inject.InjectResource> r6 = roboguice.inject.InjectResource.class
            java.lang.annotation.Annotation r6 = r3.getAnnotation(r6)
            roboguice.inject.InjectResource r6 = (roboguice.inject.InjectResource) r6
            r4.<init>(r3, r5, r6)
            r9.register(r4)
        L_0x0036:
            int r2 = r2 + 1
            goto L_0x000e
        L_0x0039:
            java.lang.Class r8 = r8.getSuperclass()
            goto L_0x0004
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: roboguice.inject.ResourceListener.hear(com.google.inject.TypeLiteral, com.google.inject.spi.TypeEncounter):void");
    }

    public void requestStaticInjection(Class<?>... clsArr) {
        int length = clsArr.length;
        for (int i = 0; i < length; i++) {
            for (Class<? super Object> cls = clsArr[i]; cls != Object.class; cls = cls.getSuperclass()) {
                for (Field field : cls.getDeclaredFields()) {
                    if (Modifier.isStatic(field.getModifiers()) && field.isAnnotationPresent(InjectResource.class)) {
                        new ResourceMembersInjector(field, this.application, (InjectResource) field.getAnnotation(InjectResource.class)).injectMembers(null);
                    }
                }
            }
        }
    }

    protected static class ResourceMembersInjector<T> implements MembersInjector<T> {
        protected InjectResource annotation;
        protected Application application;
        protected Field field;

        public ResourceMembersInjector(Field field2, Application application2, InjectResource injectResource) {
            this.field = field2;
            this.application = application2;
            this.annotation = injectResource;
        }

        public void injectMembers(T t) {
            Object obj = null;
            try {
                int value = this.annotation.value();
                Class<?> type = this.field.getType();
                Resources resources = this.application.getResources();
                if (String.class.isAssignableFrom(type)) {
                    obj = resources.getString(value);
                } else {
                    if (!Boolean.TYPE.isAssignableFrom(type)) {
                        if (!Boolean.class.isAssignableFrom(type)) {
                            if (ColorStateList.class.isAssignableFrom(type)) {
                                obj = resources.getColorStateList(value);
                            } else {
                                if (!Integer.TYPE.isAssignableFrom(type)) {
                                    if (!Integer.class.isAssignableFrom(type)) {
                                        if (Drawable.class.isAssignableFrom(type)) {
                                            obj = resources.getDrawable(value);
                                        } else if (String[].class.isAssignableFrom(type)) {
                                            obj = resources.getStringArray(value);
                                        } else {
                                            if (!int[].class.isAssignableFrom(type)) {
                                                if (!Integer[].class.isAssignableFrom(type)) {
                                                    if (Animation.class.isAssignableFrom(type)) {
                                                        obj = AnimationUtils.loadAnimation(this.application, value);
                                                    } else if (Movie.class.isAssignableFrom(type)) {
                                                        obj = resources.getMovie(value);
                                                    }
                                                }
                                            }
                                            obj = resources.getIntArray(value);
                                        }
                                    }
                                }
                                obj = Integer.valueOf(resources.getInteger(value));
                            }
                        }
                    }
                    obj = Boolean.valueOf(resources.getBoolean(value));
                }
                if (obj == null) {
                    if (this.field.getAnnotation(Nullable.class) == null) {
                        throw new NullPointerException(String.format("Can't inject null value into %s.%s when field is not @Nullable", new Object[]{this.field.getDeclaringClass(), this.field.getName()}));
                    }
                }
                this.field.setAccessible(true);
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
        }
    }
}
