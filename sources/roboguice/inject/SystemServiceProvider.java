package roboguice.inject;

import android.content.Context;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class SystemServiceProvider<T> implements Provider<T> {
    @Inject
    protected Provider<Context> contextProvider;
    protected String serviceName;

    public SystemServiceProvider(String str) {
        this.serviceName = str;
    }

    public T get() {
        return this.contextProvider.get().getSystemService(this.serviceName);
    }
}
