package p011io.opencensus.stats;

import p011io.opencensus.stats.Aggregation;

/* renamed from: io.opencensus.stats.AutoValue_Aggregation_Count */
final class AutoValue_Aggregation_Count extends Aggregation.Count {
    public int hashCode() {
        return 1;
    }

    public String toString() {
        return "Count{}";
    }

    AutoValue_Aggregation_Count() {
    }

    public boolean equals(Object obj) {
        return obj == this || (obj instanceof Aggregation.Count);
    }
}
