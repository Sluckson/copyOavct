package p011io.opencensus.stats;

import javax.annotation.concurrent.Immutable;
import p011io.opencensus.common.Function;
import p011io.opencensus.stats.Measure;

@Immutable
/* renamed from: io.opencensus.stats.Measurement */
public abstract class Measurement {
    public abstract Measure getMeasure();

    public abstract <T> T match(Function<? super MeasurementDouble, T> function, Function<? super MeasurementLong, T> function2, Function<? super Measurement, T> function3);

    private Measurement() {
    }

    @Immutable
    /* renamed from: io.opencensus.stats.Measurement$MeasurementDouble */
    public static abstract class MeasurementDouble extends Measurement {
        public abstract Measure.MeasureDouble getMeasure();

        public abstract double getValue();

        MeasurementDouble() {
            super();
        }

        public static MeasurementDouble create(Measure.MeasureDouble measureDouble, double d) {
            return new AutoValue_Measurement_MeasurementDouble(measureDouble, d);
        }

        public <T> T match(Function<? super MeasurementDouble, T> function, Function<? super MeasurementLong, T> function2, Function<? super Measurement, T> function3) {
            return function.apply(this);
        }
    }

    @Immutable
    /* renamed from: io.opencensus.stats.Measurement$MeasurementLong */
    public static abstract class MeasurementLong extends Measurement {
        public abstract Measure.MeasureLong getMeasure();

        public abstract long getValue();

        MeasurementLong() {
            super();
        }

        public static MeasurementLong create(Measure.MeasureLong measureLong, long j) {
            return new AutoValue_Measurement_MeasurementLong(measureLong, j);
        }

        public <T> T match(Function<? super MeasurementDouble, T> function, Function<? super MeasurementLong, T> function2, Function<? super Measurement, T> function3) {
            return function2.apply(this);
        }
    }
}
