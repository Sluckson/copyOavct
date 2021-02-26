package repack.org.bouncycastle.tsp;

import java.text.DecimalFormat;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.tsp.Accuracy;

public class GenTimeAccuracy {
    private Accuracy accuracy;

    public GenTimeAccuracy(Accuracy accuracy2) {
        this.accuracy = accuracy2;
    }

    public int getSeconds() {
        return getTimeComponent(this.accuracy.getSeconds());
    }

    public int getMillis() {
        return getTimeComponent(this.accuracy.getMillis());
    }

    public int getMicros() {
        return getTimeComponent(this.accuracy.getMicros());
    }

    private int getTimeComponent(DERInteger dERInteger) {
        if (dERInteger != null) {
            return dERInteger.getValue().intValue();
        }
        return 0;
    }

    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("000");
        return String.valueOf(getSeconds()) + "." + decimalFormat.format((long) getMillis()) + decimalFormat.format((long) getMicros());
    }
}
