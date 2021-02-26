package p011io.opencensus.metrics.data;

import javax.annotation.concurrent.Immutable;

/* renamed from: io.opencensus.metrics.data.AttachmentValue */
public abstract class AttachmentValue {
    public abstract String getValue();

    @Immutable
    /* renamed from: io.opencensus.metrics.data.AttachmentValue$AttachmentValueString */
    public static abstract class AttachmentValueString extends AttachmentValue {
        AttachmentValueString() {
        }

        public static AttachmentValueString create(String str) {
            return new AutoValue_AttachmentValue_AttachmentValueString(str);
        }
    }
}
