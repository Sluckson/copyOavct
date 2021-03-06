package p011io.opencensus.metrics.export;

import java.util.List;
import p011io.opencensus.metrics.export.Distribution;

/* renamed from: io.opencensus.metrics.export.AutoValue_Distribution_BucketOptions_ExplicitOptions */
final class AutoValue_Distribution_BucketOptions_ExplicitOptions extends Distribution.BucketOptions.ExplicitOptions {
    private final List<Double> bucketBoundaries;

    AutoValue_Distribution_BucketOptions_ExplicitOptions(List<Double> list) {
        if (list != null) {
            this.bucketBoundaries = list;
            return;
        }
        throw new NullPointerException("Null bucketBoundaries");
    }

    public List<Double> getBucketBoundaries() {
        return this.bucketBoundaries;
    }

    public String toString() {
        return "ExplicitOptions{bucketBoundaries=" + this.bucketBoundaries + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Distribution.BucketOptions.ExplicitOptions) {
            return this.bucketBoundaries.equals(((Distribution.BucketOptions.ExplicitOptions) obj).getBucketBoundaries());
        }
        return false;
    }

    public int hashCode() {
        return this.bucketBoundaries.hashCode() ^ 1000003;
    }
}
