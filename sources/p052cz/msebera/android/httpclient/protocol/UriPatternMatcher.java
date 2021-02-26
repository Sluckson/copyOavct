package p052cz.msebera.android.httpclient.protocol;

import java.util.HashMap;
import java.util.Map;
import p052cz.msebera.android.httpclient.annotation.GuardedBy;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.util.Args;

@ThreadSafe
/* renamed from: cz.msebera.android.httpclient.protocol.UriPatternMatcher */
public class UriPatternMatcher<T> {
    @GuardedBy("this")
    private final Map<String, T> map = new HashMap();

    public synchronized void register(String str, T t) {
        Args.notNull(str, "URI request pattern");
        this.map.put(str, t);
    }

    public synchronized void unregister(String str) {
        if (str != null) {
            this.map.remove(str);
        }
    }

    @Deprecated
    public synchronized void setHandlers(Map<String, T> map2) {
        Args.notNull(map2, "Map of handlers");
        this.map.clear();
        this.map.putAll(map2);
    }

    @Deprecated
    public synchronized void setObjects(Map<String, T> map2) {
        Args.notNull(map2, "Map of handlers");
        this.map.clear();
        this.map.putAll(map2);
    }

    @Deprecated
    public synchronized Map<String, T> getObjects() {
        return this.map;
    }

    public synchronized T lookup(String str) {
        T t;
        Args.notNull(str, "Request path");
        t = this.map.get(str);
        if (t == null) {
            String str2 = null;
            for (String next : this.map.keySet()) {
                if (matchUriRequestPattern(next, str) && (str2 == null || str2.length() < next.length() || (str2.length() == next.length() && next.endsWith("*")))) {
                    t = this.map.get(next);
                    str2 = next;
                }
            }
        }
        return t;
    }

    /* access modifiers changed from: protected */
    public boolean matchUriRequestPattern(String str, String str2) {
        if (str.equals("*")) {
            return true;
        }
        if (str.endsWith("*") && str2.startsWith(str.substring(0, str.length() - 1))) {
            return true;
        }
        if (!str.startsWith("*") || !str2.endsWith(str.substring(1, str.length()))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return this.map.toString();
    }
}
