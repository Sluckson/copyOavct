package p011io.opencensus.trace.export;

import java.util.Collection;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* renamed from: io.opencensus.trace.export.SpanExporter */
public abstract class SpanExporter {
    private static final SpanExporter NOOP_SPAN_EXPORTER = new NoopSpanExporter();

    /* renamed from: io.opencensus.trace.export.SpanExporter$Handler */
    public static abstract class Handler {
        public abstract void export(Collection<SpanData> collection);
    }

    public abstract void registerHandler(String str, Handler handler);

    public abstract void unregisterHandler(String str);

    public static SpanExporter getNoopSpanExporter() {
        return NOOP_SPAN_EXPORTER;
    }

    /* renamed from: io.opencensus.trace.export.SpanExporter$NoopSpanExporter */
    private static final class NoopSpanExporter extends SpanExporter {
        public void registerHandler(String str, Handler handler) {
        }

        public void unregisterHandler(String str) {
        }

        private NoopSpanExporter() {
        }
    }
}
