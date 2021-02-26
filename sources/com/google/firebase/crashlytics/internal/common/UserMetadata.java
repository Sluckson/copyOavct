package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserMetadata {
    static final int MAX_ATTRIBUTES = 64;
    static final int MAX_ATTRIBUTE_SIZE = 1024;
    private final ConcurrentHashMap<String, String> attributes = new ConcurrentHashMap<>();
    private String userId = null;

    @Nullable
    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = sanitizeAttribute(str);
    }

    @NonNull
    public Map<String, String> getCustomKeys() {
        return Collections.unmodifiableMap(this.attributes);
    }

    public void setCustomKey(String str, String str2) {
        String str3;
        if (str != null) {
            String sanitizeAttribute = sanitizeAttribute(str);
            if (this.attributes.size() < 64 || this.attributes.containsKey(sanitizeAttribute)) {
                if (str2 == null) {
                    str3 = "";
                } else {
                    str3 = sanitizeAttribute(str2);
                }
                this.attributes.put(sanitizeAttribute, str3);
                return;
            }
            Logger.getLogger().mo33257d("Exceeded maximum number of custom attributes (64)");
            return;
        }
        throw new IllegalArgumentException("Custom attribute key must not be null.");
    }

    private static String sanitizeAttribute(String str) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        return trim.length() > 1024 ? trim.substring(0, 1024) : trim;
    }
}
