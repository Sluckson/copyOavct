package com.wowza.gocoder.sdk.api.errors;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

/* compiled from: GoCoderSDK */
public class WOWZError {
    protected static final String ERRORS_RESOURCE_FOLDER = "wowza/errors/";
    protected static final String KEY_PATTERN = "0x[0-9a-fA-F]+";

    /* renamed from: a */
    private static final HashMap<String, HashMap<Integer, String>> f3725a = new HashMap<>();
    protected String mErrorClass;
    protected int mErrorCode;
    protected String mErrorDescription;
    protected Exception mException;
    protected boolean mWarning;

    public WOWZError(String str, int i, Exception exc, boolean z) {
        this.mErrorClass = str;
        this.mErrorCode = i;
        this.mException = exc;
        this.mWarning = z;
        if (str == null) {
            return;
        }
        if (f3725a.get(str) != null) {
            this.mErrorDescription = (String) f3725a.get(str).get(Integer.valueOf(i));
            return;
        }
        this.mErrorDescription = "An unknown error occurred (code: " + i + ")";
    }

    public WOWZError(String str, int i, boolean z) {
        this(str, i, (Exception) null, z);
    }

    public WOWZError(String str, int i) {
        this(str, i, (Exception) null, false);
    }

    public WOWZError(String str, int i, Exception exc) {
        this(str, i, exc, false);
    }

    public WOWZError(String str, boolean z) {
        this((String) null, 0, (Exception) null, z);
        this.mErrorDescription = str;
    }

    public WOWZError(String str, Exception exc) {
        this((String) null, 0, exc, false);
        this.mErrorDescription = str;
    }

    public WOWZError(Exception exc) {
        this((String) null, 0, exc, false);
        this.mErrorDescription = exc.getLocalizedMessage();
    }

    public WOWZError(String str) {
        this(str, false);
    }

    public WOWZError(WOWZError wOWZError) {
        set(wOWZError);
    }

    public void set(WOWZError wOWZError) {
        if (wOWZError != null) {
            this.mErrorClass = wOWZError.getErrorClass();
            this.mErrorCode = wOWZError.getErrorCode();
            this.mErrorDescription = wOWZError.getErrorDescription();
            this.mWarning = wOWZError.isWarning();
            this.mException = wOWZError.getException();
        }
    }

    public void setErrorDescription(String str) {
        if (str != null && str.trim().length() > 0) {
            this.mErrorDescription = str;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder sb = new StringBuilder();
        sb.append("severity                  : ");
        sb.append(this.mWarning ? "WARNING" : "ERROR");
        stringBuffer.append(sb.toString());
        stringBuffer.append("\nerror class               : " + this.mErrorClass);
        stringBuffer.append("\nerror code                : " + this.mErrorCode);
        if (this.mErrorDescription != null) {
            stringBuffer.append("\ndescription               : " + this.mErrorDescription);
        }
        if (this.mException != null) {
            stringBuffer.append("\nexception                 : " + this.mException.toString());
        }
        return stringBuffer.toString();
    }

    public boolean isWarning() {
        return this.mWarning;
    }

    public String getErrorClass() {
        return this.mErrorClass;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorDescription() {
        return this.mErrorDescription;
    }

    public Exception getException() {
        return this.mException;
    }

    public static void registerErrors(String str) {
        if (!f3725a.containsKey(str)) {
            try {
                ResourceBundle bundle = ResourceBundle.getBundle(ERRORS_RESOURCE_FOLDER + str, Locale.getDefault());
                if (m3613a(bundle)) {
                    Set<String> keySet = bundle.keySet();
                    if (keySet.size() > 0) {
                        HashMap hashMap = new HashMap(keySet.size());
                        for (String next : keySet) {
                            hashMap.put(Integer.decode(next), bundle.getString(next));
                        }
                        f3725a.put(str, hashMap);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("resource bundle keys must match the pattern 0x[0-9a-fA-F]+");
            } catch (Exception unused) {
                throw new IllegalArgumentException("invalid error resource bundle (wowza/errors/" + str + ")");
            }
        } else {
            throw new RuntimeException("error class already exists");
        }
    }

    /* renamed from: a */
    private static boolean m3613a(ResourceBundle resourceBundle) {
        Enumeration<String> keys = resourceBundle.getKeys();
        while (keys.hasMoreElements()) {
            if (!keys.nextElement().matches(KEY_PATTERN)) {
                return false;
            }
        }
        return true;
    }
}
