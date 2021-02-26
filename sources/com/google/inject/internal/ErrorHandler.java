package com.google.inject.internal;

import com.google.inject.spi.Message;

public interface ErrorHandler {
    void handle(Message message);

    void handle(Object obj, Errors errors);
}
