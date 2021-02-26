package p011io.opencensus.metrics.export;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import p011io.opencensus.common.Timestamp;
import p011io.opencensus.internal.Utils;
import p011io.opencensus.metrics.LabelValue;

@Immutable
/* renamed from: io.opencensus.metrics.export.TimeSeries */
public abstract class TimeSeries {
    public abstract List<LabelValue> getLabelValues();

    public abstract List<Point> getPoints();

    @Nullable
    public abstract Timestamp getStartTimestamp();

    TimeSeries() {
    }

    public static TimeSeries create(List<LabelValue> list, List<Point> list2, @Nullable Timestamp timestamp) {
        Utils.checkListElementNotNull((List) Utils.checkNotNull(list2, "points"), "point");
        return createInternal(list, Collections.unmodifiableList(new ArrayList(list2)), timestamp);
    }

    public static TimeSeries create(List<LabelValue> list) {
        return createInternal(list, Collections.emptyList(), (Timestamp) null);
    }

    public static TimeSeries createWithOnePoint(List<LabelValue> list, Point point, @Nullable Timestamp timestamp) {
        Utils.checkNotNull(point, "point");
        return createInternal(list, Collections.singletonList(point), timestamp);
    }

    public TimeSeries setPoint(Point point) {
        Utils.checkNotNull(point, "point");
        return new AutoValue_TimeSeries(getLabelValues(), Collections.singletonList(point), (Timestamp) null);
    }

    private static TimeSeries createInternal(List<LabelValue> list, List<Point> list2, @Nullable Timestamp timestamp) {
        Utils.checkListElementNotNull((List) Utils.checkNotNull(list, "labelValues"), "labelValue");
        return new AutoValue_TimeSeries(Collections.unmodifiableList(new ArrayList(list)), list2, timestamp);
    }
}
