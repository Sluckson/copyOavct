package org.codehaus.jackson.p063io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* renamed from: org.codehaus.jackson.io.OutputDecorator */
public abstract class OutputDecorator {
    public abstract OutputStream decorate(IOContext iOContext, OutputStream outputStream) throws IOException;

    public abstract Writer decorate(IOContext iOContext, Writer writer) throws IOException;
}
