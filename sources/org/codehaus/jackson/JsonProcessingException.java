package org.codehaus.jackson;

import com.iaai.android.old.utils.constants.Constants;
import java.io.IOException;

public class JsonProcessingException extends IOException {
    static final long serialVersionUID = 123;
    protected JsonLocation mLocation;

    protected JsonProcessingException(String str, JsonLocation jsonLocation, Throwable th) {
        super(str);
        if (th != null) {
            initCause(th);
        }
        this.mLocation = jsonLocation;
    }

    protected JsonProcessingException(String str) {
        super(str);
    }

    protected JsonProcessingException(String str, JsonLocation jsonLocation) {
        this(str, jsonLocation, (Throwable) null);
    }

    protected JsonProcessingException(String str, Throwable th) {
        this(str, (JsonLocation) null, th);
    }

    protected JsonProcessingException(Throwable th) {
        this((String) null, (JsonLocation) null, th);
    }

    public JsonLocation getLocation() {
        return this.mLocation;
    }

    public String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            message = Constants.STR_NA;
        }
        JsonLocation location = getLocation();
        if (location == null) {
            return message;
        }
        return message + 10 + " at " + location.toString();
    }

    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }
}
