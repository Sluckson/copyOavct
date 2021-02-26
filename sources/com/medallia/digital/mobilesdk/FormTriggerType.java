package com.medallia.digital.mobilesdk;

public enum FormTriggerType {
    code,
    mobileInvitation;

    protected static FormTriggerType fromString(String str) {
        if (code.name().equals(str)) {
            return code;
        }
        if (mobileInvitation.name().equals(str)) {
            return mobileInvitation;
        }
        return null;
    }
}
