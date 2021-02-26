package p011io.opencensus.trace.export;

import p011io.opencensus.trace.export.RunningSpanStore;

/* renamed from: io.opencensus.trace.export.AutoValue_RunningSpanStore_PerSpanNameSummary */
final class AutoValue_RunningSpanStore_PerSpanNameSummary extends RunningSpanStore.PerSpanNameSummary {
    private final int numRunningSpans;

    AutoValue_RunningSpanStore_PerSpanNameSummary(int i) {
        this.numRunningSpans = i;
    }

    public int getNumRunningSpans() {
        return this.numRunningSpans;
    }

    public String toString() {
        return "PerSpanNameSummary{numRunningSpans=" + this.numRunningSpans + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RunningSpanStore.PerSpanNameSummary) || this.numRunningSpans != ((RunningSpanStore.PerSpanNameSummary) obj).getNumRunningSpans()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.numRunningSpans ^ 1000003;
    }
}