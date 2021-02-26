package p011io.opencensus.trace.samplers;

import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import p011io.opencensus.trace.Sampler;
import p011io.opencensus.trace.Span;
import p011io.opencensus.trace.SpanContext;
import p011io.opencensus.trace.SpanId;
import p011io.opencensus.trace.TraceId;

@Immutable
/* renamed from: io.opencensus.trace.samplers.NeverSampleSampler */
final class NeverSampleSampler extends Sampler {
    public boolean shouldSample(@Nullable SpanContext spanContext, @Nullable Boolean bool, TraceId traceId, SpanId spanId, String str, List<Span> list) {
        return false;
    }

    public String toString() {
        return "NeverSampleSampler";
    }

    NeverSampleSampler() {
    }

    public String getDescription() {
        return toString();
    }
}
