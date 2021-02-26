package com.google.firebase.inappmessaging.internal.time;

import com.google.errorprone.annotations.CanIgnoreReturnValue;

public interface Clock {
    @CanIgnoreReturnValue
    long now();
}
