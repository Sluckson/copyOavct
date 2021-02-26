package com.medallia.digital.mobilesdk;

public enum FormViewType {
    full,
    modal,
    none;

    protected static FormViewType fromString(String str) {
        return modal.name().equals(str) ? modal : full.name().equals(str) ? full : none;
    }
}
