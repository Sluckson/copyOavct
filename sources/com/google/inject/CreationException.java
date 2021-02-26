package com.google.inject;

import com.google.inject.internal.Errors;
import com.google.inject.internal.ImmutableSet;
import com.google.inject.internal.Preconditions;
import com.google.inject.spi.Message;
import java.util.Collection;

public class CreationException extends RuntimeException {
    private static final long serialVersionUID = 0;
    private final ImmutableSet<Message> messages;

    public CreationException(Collection<Message> collection) {
        this.messages = ImmutableSet.copyOf(collection);
        Preconditions.checkArgument(!this.messages.isEmpty());
        initCause(Errors.getOnlyCause(this.messages));
    }

    public Collection<Message> getErrorMessages() {
        return this.messages;
    }

    public String getMessage() {
        return Errors.format("Guice creation errors", (Collection<Message>) this.messages);
    }
}
