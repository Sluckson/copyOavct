package com.lowagie.text;

import java.io.PrintStream;
import java.io.PrintWriter;

public class ExceptionConverter extends RuntimeException {
    private static final long serialVersionUID = 8657630363395849399L;

    /* renamed from: ex */
    private Exception f573ex;
    private String prefix;

    public Throwable fillInStackTrace() {
        return this;
    }

    public ExceptionConverter(Exception exc) {
        this.f573ex = exc;
        this.prefix = exc instanceof RuntimeException ? "" : "ExceptionConverter: ";
    }

    public static final RuntimeException convertException(Exception exc) {
        if (exc instanceof RuntimeException) {
            return (RuntimeException) exc;
        }
        return new ExceptionConverter(exc);
    }

    public Exception getException() {
        return this.f573ex;
    }

    public String getMessage() {
        return this.f573ex.getMessage();
    }

    public String getLocalizedMessage() {
        return this.f573ex.getLocalizedMessage();
    }

    public String toString() {
        return String.valueOf(this.prefix) + this.f573ex;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        synchronized (printStream) {
            printStream.print(this.prefix);
            this.f573ex.printStackTrace(printStream);
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        synchronized (printWriter) {
            printWriter.print(this.prefix);
            this.f573ex.printStackTrace(printWriter);
        }
    }
}
