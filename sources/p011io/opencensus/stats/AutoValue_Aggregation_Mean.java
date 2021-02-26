package p011io.opencensus.stats;

import javax.annotation.concurrent.Immutable;
import p011io.opencensus.stats.Aggregation;

@Immutable
@Deprecated
/* renamed from: io.opencensus.stats.AutoValue_Aggregation_Mean */
final class AutoValue_Aggregation_Mean extends Aggregation.Mean {
    public int hashCode() {
        return 1;
    }

    public String toString() {
        return "Mean{}";
    }

    AutoValue_Aggregation_Mean() {
    }

    public boolean equals(Object obj) {
        return obj == this || (obj instanceof Aggregation.Mean);
    }
}
