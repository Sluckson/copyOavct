package p011io.opencensus.metrics.data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.Immutable;
import p011io.opencensus.common.Timestamp;
import p011io.opencensus.internal.Utils;

@Immutable
/* renamed from: io.opencensus.metrics.data.Exemplar */
public abstract class Exemplar {
    public abstract Map<String, AttachmentValue> getAttachments();

    public abstract Timestamp getTimestamp();

    public abstract double getValue();

    Exemplar() {
    }

    public static Exemplar create(double d, Timestamp timestamp, Map<String, AttachmentValue> map) {
        Utils.checkNotNull(map, "attachments");
        Map unmodifiableMap = Collections.unmodifiableMap(new HashMap(map));
        for (Map.Entry entry : unmodifiableMap.entrySet()) {
            Utils.checkNotNull(entry.getKey(), "key of attachments");
            Utils.checkNotNull(entry.getValue(), "value of attachments");
        }
        return new AutoValue_Exemplar(d, timestamp, unmodifiableMap);
    }
}
