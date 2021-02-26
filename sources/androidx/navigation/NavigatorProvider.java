package androidx.navigation;

import android.annotation.SuppressLint;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigator;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"TypeParameterUnusedInFormals"})
public class NavigatorProvider {
    private static final HashMap<Class<?>, String> sAnnotationNames = new HashMap<>();
    private final HashMap<String, Navigator<? extends NavDestination>> mNavigators = new HashMap<>();

    private static boolean validateName(String str) {
        return str != null && !str.isEmpty();
    }

    @NonNull
    static String getNameForNavigator(@NonNull Class<? extends Navigator> cls) {
        String str = sAnnotationNames.get(cls);
        if (str == null) {
            Navigator.Name name = (Navigator.Name) cls.getAnnotation(Navigator.Name.class);
            str = name != null ? name.value() : null;
            if (validateName(str)) {
                sAnnotationNames.put(cls, str);
            } else {
                throw new IllegalArgumentException("No @Navigator.Name annotation found for " + cls.getSimpleName());
            }
        }
        return str;
    }

    @NonNull
    public final <T extends Navigator<?>> T getNavigator(@NonNull Class<T> cls) {
        return getNavigator(getNameForNavigator(cls));
    }

    @CallSuper
    @NonNull
    public <T extends Navigator<?>> T getNavigator(@NonNull String str) {
        if (validateName(str)) {
            T t = (Navigator) this.mNavigators.get(str);
            if (t != null) {
                return t;
            }
            throw new IllegalStateException("Could not find Navigator with name \"" + str + "\". You must call NavController.addNavigator() for each navigation type.");
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }

    @Nullable
    public final Navigator<? extends NavDestination> addNavigator(@NonNull Navigator<? extends NavDestination> navigator) {
        return addNavigator(getNameForNavigator(navigator.getClass()), navigator);
    }

    @CallSuper
    @Nullable
    public Navigator<? extends NavDestination> addNavigator(@NonNull String str, @NonNull Navigator<? extends NavDestination> navigator) {
        if (validateName(str)) {
            return this.mNavigators.put(str, navigator);
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }

    /* access modifiers changed from: package-private */
    public Map<String, Navigator<? extends NavDestination>> getNavigators() {
        return this.mNavigators;
    }
}
