package p011io.opencensus.trace;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import p011io.opencensus.trace.AutoValue_EndSpanOptions;

@Immutable
/* renamed from: io.opencensus.trace.EndSpanOptions */
public abstract class EndSpanOptions {
    public static final EndSpanOptions DEFAULT = builder().build();

    public abstract boolean getSampleToLocalSpanStore();

    @Nullable
    public abstract Status getStatus();

    public static Builder builder() {
        return new AutoValue_EndSpanOptions.Builder().setSampleToLocalSpanStore(false);
    }

    /* renamed from: io.opencensus.trace.EndSpanOptions$Builder */
    public static abstract class Builder {
        public abstract EndSpanOptions build();

        public abstract Builder setSampleToLocalSpanStore(boolean z);

        public abstract Builder setStatus(Status status);

        Builder() {
        }
    }

    EndSpanOptions() {
    }
}
