package roboguice.inject;

import android.content.Context;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import com.google.inject.MembersInjector;
import com.google.inject.Provider;
import com.google.inject.internal.Nullable;
import com.google.inject.internal.Preconditions;
import java.lang.reflect.Field;

/* compiled from: PreferenceListener */
class PreferenceMembersInjector<T> implements MembersInjector<T> {
    protected InjectPreference annotation;
    protected Provider<Context> contextProvider;
    protected Field field;
    protected T instance;
    protected ContextScope scope;

    public PreferenceMembersInjector(Field field2, Provider<Context> provider, InjectPreference injectPreference, ContextScope contextScope) {
        this.field = field2;
        this.annotation = injectPreference;
        this.contextProvider = provider;
        this.scope = contextScope;
    }

    public void injectMembers(T t) {
        this.instance = t;
        this.scope.registerPreferenceForInjection(this);
    }

    public void reallyInjectMembers() {
        Preconditions.checkNotNull(this.instance);
        Object obj = null;
        try {
            Preference findPreference = ((PreferenceActivity) this.contextProvider.get()).findPreference(this.annotation.value());
            if (findPreference == null) {
                if (this.field.getAnnotation(Nullable.class) == null) {
                    throw new NullPointerException(String.format("Can't inject null value into %s.%s when field is not @Nullable", new Object[]{this.field.getDeclaringClass(), this.field.getName()}));
                }
            }
            this.field.setAccessible(true);
            this.field.set(this.instance, findPreference);
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
