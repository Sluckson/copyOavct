package p011io.opencensus.trace.propagation;

import java.text.ParseException;
import p011io.opencensus.internal.Utils;
import p011io.opencensus.trace.SpanContext;

/* renamed from: io.opencensus.trace.propagation.BinaryFormat */
public abstract class BinaryFormat {
    static final NoopBinaryFormat NOOP_BINARY_FORMAT = new NoopBinaryFormat();

    @Deprecated
    public byte[] toBinaryValue(SpanContext spanContext) {
        return toByteArray(spanContext);
    }

    public byte[] toByteArray(SpanContext spanContext) {
        return toBinaryValue(spanContext);
    }

    @Deprecated
    public SpanContext fromBinaryValue(byte[] bArr) throws ParseException {
        try {
            return fromByteArray(bArr);
        } catch (SpanContextParseException e) {
            throw new ParseException(e.toString(), 0);
        }
    }

    public SpanContext fromByteArray(byte[] bArr) throws SpanContextParseException {
        try {
            return fromBinaryValue(bArr);
        } catch (ParseException e) {
            throw new SpanContextParseException("Error while parsing.", e);
        }
    }

    static BinaryFormat getNoopBinaryFormat() {
        return NOOP_BINARY_FORMAT;
    }

    /* renamed from: io.opencensus.trace.propagation.BinaryFormat$NoopBinaryFormat */
    private static final class NoopBinaryFormat extends BinaryFormat {
        public byte[] toByteArray(SpanContext spanContext) {
            Utils.checkNotNull(spanContext, "spanContext");
            return new byte[0];
        }

        public SpanContext fromByteArray(byte[] bArr) {
            Utils.checkNotNull(bArr, "bytes");
            return SpanContext.INVALID;
        }

        private NoopBinaryFormat() {
        }
    }
}
