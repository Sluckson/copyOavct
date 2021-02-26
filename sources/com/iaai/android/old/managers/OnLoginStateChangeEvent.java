package com.iaai.android.old.managers;

import android.content.Intent;

public class OnLoginStateChangeEvent {
    public final Intent intent;
    public final boolean isLoggedIn;

    public OnLoginStateChangeEvent(boolean z, Intent intent2) {
        this.isLoggedIn = z;
        this.intent = intent2;
    }
}
