package p011io.opencensus.stats;

import javax.annotation.concurrent.Immutable;
import p011io.opencensus.common.Duration;
import p011io.opencensus.stats.View;

@Immutable
@Deprecated
/* renamed from: io.opencensus.stats.AutoValue_View_AggregationWindow_Interval */
final class AutoValue_View_AggregationWindow_Interval extends View.AggregationWindow.Interval {
    private final Duration duration;

    AutoValue_View_AggregationWindow_Interval(Duration duration2) {
        if (duration2 != null) {
            this.duration = duration2;
            return;
        }
        throw new NullPointerException("Null duration");
    }

    public Duration getDuration() {
        return this.duration;
    }

    public String toString() {
        return "Interval{duration=" + this.duration + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof View.AggregationWindow.Interval) {
            return this.duration.equals(((View.AggregationWindow.Interval) obj).getDuration());
        }
        return false;
    }

    public int hashCode() {
        return this.duration.hashCode() ^ 1000003;
    }
}
