package p011io.opencensus.trace;

import javax.annotation.concurrent.Immutable;
import p011io.opencensus.internal.Utils;
import p011io.opencensus.trace.AutoValue_MessageEvent;

@Immutable
/* renamed from: io.opencensus.trace.MessageEvent */
public abstract class MessageEvent extends BaseMessageEvent {

    /* renamed from: io.opencensus.trace.MessageEvent$Type */
    public enum Type {
        SENT,
        RECEIVED
    }

    public abstract long getCompressedMessageSize();

    public abstract long getMessageId();

    public abstract Type getType();

    public abstract long getUncompressedMessageSize();

    public static Builder builder(Type type, long j) {
        return new AutoValue_MessageEvent.Builder().setType((Type) Utils.checkNotNull(type, "type")).setMessageId(j).setUncompressedMessageSize(0).setCompressedMessageSize(0);
    }

    /* renamed from: io.opencensus.trace.MessageEvent$Builder */
    public static abstract class Builder {
        public abstract MessageEvent build();

        public abstract Builder setCompressedMessageSize(long j);

        /* access modifiers changed from: package-private */
        public abstract Builder setMessageId(long j);

        /* access modifiers changed from: package-private */
        public abstract Builder setType(Type type);

        public abstract Builder setUncompressedMessageSize(long j);

        Builder() {
        }
    }

    MessageEvent() {
    }
}
