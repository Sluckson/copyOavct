package p052cz.msebera.android.httpclient.impl.cookie;

import java.util.Date;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.client.utils.DateUtils;
import p052cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p052cz.msebera.android.httpclient.cookie.SetCookie;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.cookie.BasicExpiresHandler */
public class BasicExpiresHandler extends AbstractCookieAttributeHandler {
    private final String[] datepatterns;

    public BasicExpiresHandler(String[] strArr) {
        Args.notNull(strArr, "Array of date patterns");
        this.datepatterns = strArr;
    }

    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        Args.notNull(setCookie, "Cookie");
        if (str != null) {
            Date parseDate = DateUtils.parseDate(str, this.datepatterns);
            if (parseDate != null) {
                setCookie.setExpiryDate(parseDate);
                return;
            }
            throw new MalformedCookieException("Unable to parse expires attribute: " + str);
        }
        throw new MalformedCookieException("Missing value for expires attribute");
    }
}
