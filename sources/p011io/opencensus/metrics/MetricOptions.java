package p011io.opencensus.metrics;

import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.Immutable;
import p011io.opencensus.internal.Utils;
import p011io.opencensus.metrics.AutoValue_MetricOptions;

@Immutable
/* renamed from: io.opencensus.metrics.MetricOptions */
public abstract class MetricOptions {
    public abstract Map<LabelKey, LabelValue> getConstantLabels();

    public abstract String getDescription();

    public abstract List<LabelKey> getLabelKeys();

    public abstract String getUnit();

    public static Builder builder() {
        return new AutoValue_MetricOptions.Builder().setDescription("").setUnit(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE).setLabelKeys(Collections.emptyList()).setConstantLabels(Collections.emptyMap());
    }

    /* renamed from: io.opencensus.metrics.MetricOptions$Builder */
    public static abstract class Builder {
        /* access modifiers changed from: package-private */
        public abstract MetricOptions autoBuild();

        /* access modifiers changed from: package-private */
        public abstract Map<LabelKey, LabelValue> getConstantLabels();

        /* access modifiers changed from: package-private */
        public abstract List<LabelKey> getLabelKeys();

        public abstract Builder setConstantLabels(Map<LabelKey, LabelValue> map);

        public abstract Builder setDescription(String str);

        public abstract Builder setLabelKeys(List<LabelKey> list);

        public abstract Builder setUnit(String str);

        public MetricOptions build() {
            setLabelKeys(Collections.unmodifiableList(new ArrayList(getLabelKeys())));
            setConstantLabels(Collections.unmodifiableMap(new LinkedHashMap(getConstantLabels())));
            MetricOptions autoBuild = autoBuild();
            Utils.checkListElementNotNull(autoBuild.getLabelKeys(), "labelKeys elements");
            Utils.checkMapElementNotNull(autoBuild.getConstantLabels(), "constantLabels elements");
            HashSet hashSet = new HashSet();
            for (LabelKey next : autoBuild.getLabelKeys()) {
                if (!hashSet.contains(next.getKey())) {
                    hashSet.add(next.getKey());
                } else {
                    throw new IllegalArgumentException("Invalid LabelKey in labelKeys");
                }
            }
            for (Map.Entry next2 : autoBuild.getConstantLabels().entrySet()) {
                if (!hashSet.contains(((LabelKey) next2.getKey()).getKey())) {
                    hashSet.add(((LabelKey) next2.getKey()).getKey());
                } else {
                    throw new IllegalArgumentException("Invalid LabelKey in constantLabels");
                }
            }
            return autoBuild;
        }

        Builder() {
        }
    }

    MetricOptions() {
    }
}
