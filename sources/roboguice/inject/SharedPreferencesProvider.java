package roboguice.inject;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class SharedPreferencesProvider implements Provider<SharedPreferences> {
    protected static final String DEFAULT = "default";
    @Inject
    protected Provider<Context> contextProvider;
    protected String preferencesName;

    public static class PreferencesNameHolder {
        @SharedPreferencesName
        @Inject(optional = true)
        protected String value = "default";
    }

    public SharedPreferencesProvider() {
        this.preferencesName = "default";
    }

    @Inject
    public SharedPreferencesProvider(PreferencesNameHolder preferencesNameHolder) {
        this.preferencesName = preferencesNameHolder.value;
    }

    public SharedPreferencesProvider(String str) {
        this.preferencesName = str;
    }

    public SharedPreferences get() {
        return this.contextProvider.get().getSharedPreferences(this.preferencesName, 0);
    }
}
