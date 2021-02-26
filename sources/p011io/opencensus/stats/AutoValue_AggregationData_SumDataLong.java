package p011io.opencensus.stats;

import p011io.opencensus.stats.AggregationData;

/* renamed from: io.opencensus.stats.AutoValue_AggregationData_SumDataLong */
final class AutoValue_AggregationData_SumDataLong extends AggregationData.SumDataLong {
    private final long sum;

    AutoValue_AggregationData_SumDataLong(long j) {
        this.sum = j;
    }

    public long getSum() {
        return this.sum;
    }

    public String toString() {
        return "SumDataLong{sum=" + this.sum + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AggregationData.SumDataLong) || this.sum != ((AggregationData.SumDataLong) obj).getSum()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.sum;
        return (int) (((long) 1000003) ^ (j ^ (j >>> 32)));
    }
}
