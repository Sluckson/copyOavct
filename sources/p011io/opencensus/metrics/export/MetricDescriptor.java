package p011io.opencensus.metrics.export;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.concurrent.Immutable;
import p011io.opencensus.internal.Utils;
import p011io.opencensus.metrics.LabelKey;

@Immutable
/* renamed from: io.opencensus.metrics.export.MetricDescriptor */
public abstract class MetricDescriptor {

    /* renamed from: io.opencensus.metrics.export.MetricDescriptor$Type */
    public enum Type {
        GAUGE_INT64,
        GAUGE_DOUBLE,
        GAUGE_DISTRIBUTION,
        CUMULATIVE_INT64,
        CUMULATIVE_DOUBLE,
        CUMULATIVE_DISTRIBUTION,
        SUMMARY
    }

    public abstract String getDescription();

    public abstract List<LabelKey> getLabelKeys();

    public abstract String getName();

    public abstract Type getType();

    public abstract String getUnit();

    MetricDescriptor() {
    }

    public static MetricDescriptor create(String str, String str2, String str3, Type type, List<LabelKey> list) {
        Utils.checkListElementNotNull((List) Utils.checkNotNull(list, "labelKeys"), "labelKey");
        return new AutoValue_MetricDescriptor(str, str2, str3, type, Collections.unmodifiableList(new ArrayList(list)));
    }
}
