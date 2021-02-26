package p011io.opencensus.trace.unsafe;

import javax.annotation.Nullable;
import p011io.grpc.Context;
import p011io.opencensus.internal.Utils;
import p011io.opencensus.trace.BlankSpan;
import p011io.opencensus.trace.Span;

/* renamed from: io.opencensus.trace.unsafe.ContextUtils */
public final class ContextUtils {
    @Deprecated
    public static final Context.Key<Span> CONTEXT_SPAN_KEY = Context.key("opencensus-trace-span-key");

    private ContextUtils() {
    }

    public static Context withValue(Context context, @Nullable Span span) {
        return ((Context) Utils.checkNotNull(context, "context")).withValue(CONTEXT_SPAN_KEY, span);
    }

    public static Span getValue(Context context) {
        Span span = CONTEXT_SPAN_KEY.get((Context) Utils.checkNotNull(context, "context"));
        return span == null ? BlankSpan.INSTANCE : span;
    }
}
