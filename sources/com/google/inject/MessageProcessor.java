package com.google.inject;

import com.google.inject.internal.Errors;
import com.google.inject.spi.Message;
import java.util.logging.Level;
import java.util.logging.Logger;

class MessageProcessor extends AbstractProcessor {
    private static final Logger logger = Logger.getLogger(Guice.class.getName());

    MessageProcessor(Errors errors) {
        super(errors);
    }

    public Boolean visit(Message message) {
        if (message.getCause() != null) {
            String rootMessage = getRootMessage(message.getCause());
            Logger logger2 = logger;
            Level level = Level.INFO;
            logger2.log(level, "An exception was caught and reported. Message: " + rootMessage, message.getCause());
        }
        this.errors.addMessage(message);
        return true;
    }

    public static String getRootMessage(Throwable th) {
        Throwable cause = th.getCause();
        return cause == null ? th.toString() : getRootMessage(cause);
    }
}
