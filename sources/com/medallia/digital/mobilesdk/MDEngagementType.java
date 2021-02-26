package com.medallia.digital.mobilesdk;

public enum MDEngagementType {
    form,
    appRating;

    protected static MDEngagementType fromString(String str) {
        if (form.name().equals(str)) {
            return form;
        }
        if (appRating.name().equals(str)) {
            return appRating;
        }
        return null;
    }
}
