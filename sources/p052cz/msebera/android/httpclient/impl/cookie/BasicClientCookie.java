package p052cz.msebera.android.httpclient.impl.cookie;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.cookie.ClientCookie;
import p052cz.msebera.android.httpclient.cookie.SetCookie;
import p052cz.msebera.android.httpclient.util.Args;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.cookie.BasicClientCookie */
public class BasicClientCookie implements SetCookie, ClientCookie, Cloneable, Serializable {
    private static final long serialVersionUID = -3869795591041535538L;
    private Map<String, String> attribs = new HashMap();
    private String cookieComment;
    private String cookieDomain;
    private Date cookieExpiryDate;
    private String cookiePath;
    private int cookieVersion;
    private boolean isSecure;
    private final String name;
    private String value;

    public String getCommentURL() {
        return null;
    }

    public int[] getPorts() {
        return null;
    }

    public BasicClientCookie(String str, String str2) {
        Args.notNull(str, "Name");
        this.name = str;
        this.value = str2;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getComment() {
        return this.cookieComment;
    }

    public void setComment(String str) {
        this.cookieComment = str;
    }

    public Date getExpiryDate() {
        return this.cookieExpiryDate;
    }

    public void setExpiryDate(Date date) {
        this.cookieExpiryDate = date;
    }

    public boolean isPersistent() {
        return this.cookieExpiryDate != null;
    }

    public String getDomain() {
        return this.cookieDomain;
    }

    public void setDomain(String str) {
        if (str != null) {
            this.cookieDomain = str.toLowerCase(Locale.ENGLISH);
        } else {
            this.cookieDomain = null;
        }
    }

    public String getPath() {
        return this.cookiePath;
    }

    public void setPath(String str) {
        this.cookiePath = str;
    }

    public boolean isSecure() {
        return this.isSecure;
    }

    public void setSecure(boolean z) {
        this.isSecure = z;
    }

    public int getVersion() {
        return this.cookieVersion;
    }

    public void setVersion(int i) {
        this.cookieVersion = i;
    }

    public boolean isExpired(Date date) {
        Args.notNull(date, "Date");
        Date date2 = this.cookieExpiryDate;
        return date2 != null && date2.getTime() <= date.getTime();
    }

    public void setAttribute(String str, String str2) {
        this.attribs.put(str, str2);
    }

    public String getAttribute(String str) {
        return this.attribs.get(str);
    }

    public boolean containsAttribute(String str) {
        return this.attribs.get(str) != null;
    }

    public Object clone() throws CloneNotSupportedException {
        BasicClientCookie basicClientCookie = (BasicClientCookie) super.clone();
        basicClientCookie.attribs = new HashMap(this.attribs);
        return basicClientCookie;
    }

    public String toString() {
        return "[version: " + Integer.toString(this.cookieVersion) + "]" + "[name: " + this.name + "]" + "[value: " + this.value + "]" + "[domain: " + this.cookieDomain + "]" + "[path: " + this.cookiePath + "]" + "[expiry: " + this.cookieExpiryDate + "]";
    }
}
