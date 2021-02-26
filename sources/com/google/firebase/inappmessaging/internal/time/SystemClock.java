package com.google.firebase.inappmessaging.internal.time;

import com.google.errorprone.annotations.CanIgnoreReturnValue;

public class SystemClock implements Clock {
    @CanIgnoreReturnValue
    public long now() {
        return System.currentTimeMillis();
    }
}
