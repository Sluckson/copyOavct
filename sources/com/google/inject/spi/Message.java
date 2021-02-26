package com.google.inject.spi;

import com.google.inject.Binder;
import com.google.inject.internal.Errors;
import com.google.inject.internal.ImmutableList;
import com.google.inject.internal.Objects;
import com.google.inject.internal.Preconditions;
import com.google.inject.internal.SourceProvider;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.List;

public final class Message implements Serializable, Element {
    private static final long serialVersionUID = 0;
    private final Throwable cause;
    private final String message;
    private final List<Object> sources;

    public Message(List<Object> list, String str, Throwable th) {
        this.sources = ImmutableList.copyOf(list);
        this.message = (String) Preconditions.checkNotNull(str, "message");
        this.cause = th;
    }

    public Message(Object obj, String str) {
        this(ImmutableList.m336of(obj), str, (Throwable) null);
    }

    public Message(String str) {
        this(ImmutableList.m335of(), str, (Throwable) null);
    }

    public String getSource() {
        Object obj;
        if (this.sources.isEmpty()) {
            obj = SourceProvider.UNKNOWN_SOURCE;
        } else {
            List<Object> list = this.sources;
            obj = Errors.convert(list.get(list.size() - 1));
        }
        return obj.toString();
    }

    public List<Object> getSources() {
        return this.sources;
    }

    public String getMessage() {
        return this.message;
    }

    public <T> T acceptVisitor(ElementVisitor<T> elementVisitor) {
        return elementVisitor.visit(this);
    }

    public Throwable getCause() {
        return this.cause;
    }

    public String toString() {
        return this.message;
    }

    public int hashCode() {
        return this.message.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message2 = (Message) obj;
        if (!this.message.equals(message2.message) || !Objects.equal(this.cause, message2.cause) || !this.sources.equals(message2.sources)) {
            return false;
        }
        return true;
    }

    public void applyTo(Binder binder) {
        binder.withSource(getSource()).addError(this);
    }

    private Object writeReplace() throws ObjectStreamException {
        Object[] array = this.sources.toArray();
        for (int i = 0; i < array.length; i++) {
            array[i] = Errors.convert(array[i]).toString();
        }
        return new Message(ImmutableList.m341of((E[]) array), this.message, this.cause);
    }
}
