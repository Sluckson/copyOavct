package p052cz.msebera.android.httpclient.auth;

import java.io.Serializable;
import java.security.Principal;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.LangUtils;

@Immutable
/* renamed from: cz.msebera.android.httpclient.auth.BasicUserPrincipal */
public final class BasicUserPrincipal implements Principal, Serializable {
    private static final long serialVersionUID = -2266305184969850467L;
    private final String username;

    public BasicUserPrincipal(String str) {
        Args.notNull(str, "User name");
        this.username = str;
    }

    public String getName() {
        return this.username;
    }

    public int hashCode() {
        return LangUtils.hashCode(17, (Object) this.username);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BasicUserPrincipal) || !LangUtils.equals((Object) this.username, (Object) ((BasicUserPrincipal) obj).username)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "[principal: " + this.username + "]";
    }
}
