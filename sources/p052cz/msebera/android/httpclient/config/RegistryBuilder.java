package p052cz.msebera.android.httpclient.config;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.util.Args;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.config.RegistryBuilder */
public final class RegistryBuilder<I> {
    private final Map<String, I> items = new HashMap();

    public static <I> RegistryBuilder<I> create() {
        return new RegistryBuilder<>();
    }

    RegistryBuilder() {
    }

    public RegistryBuilder<I> register(String str, I i) {
        Args.notEmpty(str, "ID");
        Args.notNull(i, "Item");
        this.items.put(str.toLowerCase(Locale.ENGLISH), i);
        return this;
    }

    public Registry<I> build() {
        return new Registry<>(this.items);
    }

    public String toString() {
        return this.items.toString();
    }
}
