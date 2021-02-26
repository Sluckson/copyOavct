package p011io.opencensus.trace.export;

import java.util.Map;
import p011io.opencensus.trace.export.RunningSpanStore;

/* renamed from: io.opencensus.trace.export.AutoValue_RunningSpanStore_Summary */
final class AutoValue_RunningSpanStore_Summary extends RunningSpanStore.Summary {
    private final Map<String, RunningSpanStore.PerSpanNameSummary> perSpanNameSummary;

    AutoValue_RunningSpanStore_Summary(Map<String, RunningSpanStore.PerSpanNameSummary> map) {
        if (map != null) {
            this.perSpanNameSummary = map;
            return;
        }
        throw new NullPointerException("Null perSpanNameSummary");
    }

    public Map<String, RunningSpanStore.PerSpanNameSummary> getPerSpanNameSummary() {
        return this.perSpanNameSummary;
    }

    public String toString() {
        return "Summary{perSpanNameSummary=" + this.perSpanNameSummary + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RunningSpanStore.Summary) {
            return this.perSpanNameSummary.equals(((RunningSpanStore.Summary) obj).getPerSpanNameSummary());
        }
        return false;
    }

    public int hashCode() {
        return this.perSpanNameSummary.hashCode() ^ 1000003;
    }
}
