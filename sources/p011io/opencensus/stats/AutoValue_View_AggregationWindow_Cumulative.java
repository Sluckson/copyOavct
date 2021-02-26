package p011io.opencensus.stats;

import javax.annotation.concurrent.Immutable;
import p011io.opencensus.stats.View;

@Immutable
@Deprecated
/* renamed from: io.opencensus.stats.AutoValue_View_AggregationWindow_Cumulative */
final class AutoValue_View_AggregationWindow_Cumulative extends View.AggregationWindow.Cumulative {
    public int hashCode() {
        return 1;
    }

    public String toString() {
        return "Cumulative{}";
    }

    AutoValue_View_AggregationWindow_Cumulative() {
    }

    public boolean equals(Object obj) {
        return obj == this || (obj instanceof View.AggregationWindow.Cumulative);
    }
}
