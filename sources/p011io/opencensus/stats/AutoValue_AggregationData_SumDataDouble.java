package p011io.opencensus.stats;

import p011io.opencensus.stats.AggregationData;

/* renamed from: io.opencensus.stats.AutoValue_AggregationData_SumDataDouble */
final class AutoValue_AggregationData_SumDataDouble extends AggregationData.SumDataDouble {
    private final double sum;

    AutoValue_AggregationData_SumDataDouble(double d) {
        this.sum = d;
    }

    public double getSum() {
        return this.sum;
    }

    public String toString() {
        return "SumDataDouble{sum=" + this.sum + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AggregationData.SumDataDouble) || Double.doubleToLongBits(this.sum) != Double.doubleToLongBits(((AggregationData.SumDataDouble) obj).getSum())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (int) (((long) 1000003) ^ ((Double.doubleToLongBits(this.sum) >>> 32) ^ Double.doubleToLongBits(this.sum)));
    }
}
