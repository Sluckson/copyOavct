package p011io.opencensus.stats;

import javax.annotation.concurrent.NotThreadSafe;
import p011io.opencensus.internal.Utils;
import p011io.opencensus.metrics.data.AttachmentValue;
import p011io.opencensus.stats.Measure;
import p011io.opencensus.tags.TagContext;

@NotThreadSafe
/* renamed from: io.opencensus.stats.MeasureMap */
public abstract class MeasureMap {
    public abstract MeasureMap put(Measure.MeasureDouble measureDouble, double d);

    public abstract MeasureMap put(Measure.MeasureLong measureLong, long j);

    public abstract void record();

    public abstract void record(TagContext tagContext);

    @Deprecated
    public MeasureMap putAttachment(String str, String str2) {
        return putAttachment(str, (AttachmentValue) AttachmentValue.AttachmentValueString.create(str2));
    }

    public MeasureMap putAttachment(String str, AttachmentValue attachmentValue) {
        Utils.checkNotNull(str, "key");
        Utils.checkNotNull(attachmentValue, "value");
        return this;
    }
}
