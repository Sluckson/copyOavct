package p052cz.msebera.android.httpclient.config;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;

@ThreadSafe
/* renamed from: cz.msebera.android.httpclient.config.Registry */
public final class Registry<I> implements Lookup<I> {
    private final Map<String, I> map;

    Registry(Map<String, I> map2) {
        this.map = new ConcurrentHashMap(map2);
    }

    public I lookup(String str) {
        if (str == null) {
            return null;
        }
        return this.map.get(str.toLowerCase(Locale.ENGLISH));
    }

    public String toString() {
        return this.map.toString();
    }
}
