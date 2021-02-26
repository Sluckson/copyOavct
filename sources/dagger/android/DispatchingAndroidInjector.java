package dagger.android;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import dagger.android.AndroidInjector;
import dagger.internal.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

public final class DispatchingAndroidInjector<T> implements AndroidInjector<T> {
    private static final String NO_SUPERTYPES_BOUND_FORMAT = "No injector factory bound for Class<%s>";
    private static final String SUPERTYPES_BOUND_FORMAT = "No injector factory bound for Class<%1$s>. Injector factories were bound for supertypes of %1$s: %2$s. Did you mean to bind an injector factory for the subtype?";
    private final Map<Class<? extends T>, Provider<AndroidInjector.Factory<? extends T>>> injectorFactories;

    @Inject
    DispatchingAndroidInjector(Map<Class<? extends T>, Provider<AndroidInjector.Factory<? extends T>>> map) {
        this.injectorFactories = map;
    }

    @CanIgnoreReturnValue
    public boolean maybeInject(T t) {
        Provider provider = this.injectorFactories.get(t.getClass());
        if (provider == null) {
            return false;
        }
        AndroidInjector.Factory factory = (AndroidInjector.Factory) provider.get();
        try {
            ((AndroidInjector) Preconditions.checkNotNull(factory.create(t), "%s.create(I) should not return null.", factory.getClass())).inject(t);
            return true;
        } catch (ClassCastException e) {
            throw new InvalidInjectorBindingException(String.format("%s does not implement AndroidInjector.Factory<%s>", new Object[]{factory.getClass().getCanonicalName(), t.getClass().getCanonicalName()}), e);
        }
    }

    public void inject(T t) {
        if (!maybeInject(t)) {
            throw new IllegalArgumentException(errorMessageSuggestions(t));
        }
    }

    public static final class InvalidInjectorBindingException extends RuntimeException {
        InvalidInjectorBindingException(String str, ClassCastException classCastException) {
            super(str, classCastException);
        }
    }

    private String errorMessageSuggestions(T t) {
        ArrayList arrayList = new ArrayList();
        for (Class next : this.injectorFactories.keySet()) {
            if (next.isInstance(t)) {
                arrayList.add(next.getCanonicalName());
            }
        }
        Collections.sort(arrayList);
        if (arrayList.isEmpty()) {
            return String.format(NO_SUPERTYPES_BOUND_FORMAT, new Object[]{t.getClass().getCanonicalName()});
        }
        return String.format(SUPERTYPES_BOUND_FORMAT, new Object[]{t.getClass().getCanonicalName(), arrayList});
    }
}
