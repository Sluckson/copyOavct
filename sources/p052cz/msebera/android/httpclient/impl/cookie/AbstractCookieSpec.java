package p052cz.msebera.android.httpclient.impl.cookie;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.cookie.CookieAttributeHandler;
import p052cz.msebera.android.httpclient.cookie.CookieSpec;
import p052cz.msebera.android.httpclient.util.Args;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.cookie.AbstractCookieSpec */
public abstract class AbstractCookieSpec implements CookieSpec {
    private final Map<String, CookieAttributeHandler> attribHandlerMap = new HashMap(10);

    public void registerAttribHandler(String str, CookieAttributeHandler cookieAttributeHandler) {
        Args.notNull(str, "Attribute name");
        Args.notNull(cookieAttributeHandler, "Attribute handler");
        this.attribHandlerMap.put(str, cookieAttributeHandler);
    }

    /* access modifiers changed from: protected */
    public CookieAttributeHandler findAttribHandler(String str) {
        return this.attribHandlerMap.get(str);
    }

    /* access modifiers changed from: protected */
    public CookieAttributeHandler getAttribHandler(String str) {
        CookieAttributeHandler findAttribHandler = findAttribHandler(str);
        if (findAttribHandler != null) {
            return findAttribHandler;
        }
        throw new IllegalStateException("Handler not registered for " + str + " attribute.");
    }

    /* access modifiers changed from: protected */
    public Collection<CookieAttributeHandler> getAttribHandlers() {
        return this.attribHandlerMap.values();
    }
}
