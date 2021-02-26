package com.google.inject.internal;

import java.util.Timer;

class ExpirationTimer {
    static Timer instance = new Timer(true);

    ExpirationTimer() {
    }
}
