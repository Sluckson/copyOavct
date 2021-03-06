package p011io.opencensus.metrics;

import java.util.List;
import javax.annotation.concurrent.ThreadSafe;
import p011io.opencensus.common.ToLongFunction;
import p011io.opencensus.internal.Utils;

@ThreadSafe
/* renamed from: io.opencensus.metrics.DerivedLongGauge */
public abstract class DerivedLongGauge {
    public abstract void clear();

    public abstract <T> void createTimeSeries(List<LabelValue> list, T t, ToLongFunction<T> toLongFunction);

    public abstract void removeTimeSeries(List<LabelValue> list);

    static DerivedLongGauge newNoopDerivedLongGauge(String str, String str2, String str3, List<LabelKey> list) {
        return NoopDerivedLongGauge.create(str, str2, str3, list);
    }

    /* renamed from: io.opencensus.metrics.DerivedLongGauge$NoopDerivedLongGauge */
    private static final class NoopDerivedLongGauge extends DerivedLongGauge {
        private final int labelKeysSize;

        public void clear() {
        }

        static NoopDerivedLongGauge create(String str, String str2, String str3, List<LabelKey> list) {
            return new NoopDerivedLongGauge(str, str2, str3, list);
        }

        NoopDerivedLongGauge(String str, String str2, String str3, List<LabelKey> list) {
            Utils.checkNotNull(str, "name");
            Utils.checkNotNull(str2, "description");
            Utils.checkNotNull(str3, "unit");
            Utils.checkListElementNotNull((List) Utils.checkNotNull(list, "labelKeys"), "labelKey");
            this.labelKeysSize = list.size();
        }

        public <T> void createTimeSeries(List<LabelValue> list, T t, ToLongFunction<T> toLongFunction) {
            Utils.checkListElementNotNull((List) Utils.checkNotNull(list, "labelValues"), "labelValue");
            Utils.checkArgument(this.labelKeysSize == list.size(), "Label Keys and Label Values don't have same size.");
            Utils.checkNotNull(toLongFunction, "function");
        }

        public void removeTimeSeries(List<LabelValue> list) {
            Utils.checkNotNull(list, "labelValues");
        }
    }
}
