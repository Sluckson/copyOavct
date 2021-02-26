package com.medallia.digital.mobilesdk;

enum Lifetime {
    Session,
    Application,
    Forever;

    protected static Lifetime fromString(String str) {
        if (Session.name().equals(str)) {
            return Session;
        }
        if (Application.name().equals(str)) {
            return Application;
        }
        if (Forever.name().equals(str)) {
            return Forever;
        }
        return null;
    }
}
