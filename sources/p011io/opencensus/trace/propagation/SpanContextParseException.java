package p011io.opencensus.trace.propagation;

/* renamed from: io.opencensus.trace.propagation.SpanContextParseException */
public final class SpanContextParseException extends Exception {
    private static final long serialVersionUID = 0;

    public SpanContextParseException(String str) {
        super(str);
    }

    public SpanContextParseException(String str, Throwable th) {
        super(str, th);
    }
}
