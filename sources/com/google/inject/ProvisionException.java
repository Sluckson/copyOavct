package com.google.inject;

import com.google.inject.internal.Errors;
import com.google.inject.internal.ImmutableList;
import com.google.inject.internal.ImmutableSet;
import com.google.inject.internal.Preconditions;
import com.google.inject.spi.Message;
import java.util.Collection;

public final class ProvisionException extends RuntimeException {
    private static final long serialVersionUID = 0;
    private final ImmutableSet<Message> messages;

    public ProvisionException(Iterable<Message> iterable) {
        this.messages = ImmutableSet.copyOf(iterable);
        Preconditions.checkArgument(!this.messages.isEmpty());
        initCause(Errors.getOnlyCause(this.messages));
    }

    public ProvisionException(String str, Throwable th) {
        super(th);
        this.messages = ImmutableSet.m349of(new Message(ImmutableList.m335of(), str, th));
    }

    public ProvisionException(String str) {
        this.messages = ImmutableSet.m349of(new Message(str));
    }

    public Collection<Message> getErrorMessages() {
        return this.messages;
    }

    public String getMessage() {
        return Errors.format("Guice provision errors", (Collection<Message>) this.messages);
    }
}
