package p052cz.msebera.android.httpclient.auth;

import java.io.Serializable;
import java.security.Principal;
import java.util.Locale;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.LangUtils;

@Immutable
/* renamed from: cz.msebera.android.httpclient.auth.NTUserPrincipal */
public class NTUserPrincipal implements Principal, Serializable {
    private static final long serialVersionUID = -6870169797924406894L;
    private final String domain;
    private final String ntname;
    private final String username;

    public NTUserPrincipal(String str, String str2) {
        Args.notNull(str2, "User name");
        this.username = str2;
        if (str != null) {
            this.domain = str.toUpperCase(Locale.ENGLISH);
        } else {
            this.domain = null;
        }
        String str3 = this.domain;
        if (str3 == null || str3.length() <= 0) {
            this.ntname = this.username;
            return;
        }
        this.ntname = this.domain + '\\' + this.username;
    }

    public String getName() {
        return this.ntname;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(17, (Object) this.username), (Object) this.domain);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NTUserPrincipal)) {
            return false;
        }
        NTUserPrincipal nTUserPrincipal = (NTUserPrincipal) obj;
        if (!LangUtils.equals((Object) this.username, (Object) nTUserPrincipal.username) || !LangUtils.equals((Object) this.domain, (Object) nTUserPrincipal.domain)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return this.ntname;
    }
}
