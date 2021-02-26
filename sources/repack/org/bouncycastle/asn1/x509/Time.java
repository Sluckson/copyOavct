package repack.org.bouncycastle.asn1.x509;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import repack.org.bouncycastle.asn1.ASN1Choice;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERGeneralizedTime;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERUTCTime;

public class Time extends ASN1Encodable implements ASN1Choice {
    DERObject time;

    public static Time getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    public Time(DERObject dERObject) {
        if ((dERObject instanceof DERUTCTime) || (dERObject instanceof DERGeneralizedTime)) {
            this.time = dERObject;
            return;
        }
        throw new IllegalArgumentException("unknown object passed to Time");
    }

    public Time(Date date) {
        SimpleTimeZone simpleTimeZone = new SimpleTimeZone(0, "Z");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        simpleDateFormat.setTimeZone(simpleTimeZone);
        String str = String.valueOf(simpleDateFormat.format(date)) + "Z";
        int parseInt = Integer.parseInt(str.substring(0, 4));
        if (parseInt < 1950 || parseInt > 2049) {
            this.time = new DERGeneralizedTime(str);
        } else {
            this.time = new DERUTCTime(str.substring(2));
        }
    }

    public static Time getInstance(Object obj) {
        if (obj == null || (obj instanceof Time)) {
            return (Time) obj;
        }
        if (obj instanceof DERUTCTime) {
            return new Time((DERObject) (DERUTCTime) obj);
        }
        if (obj instanceof DERGeneralizedTime) {
            return new Time((DERObject) (DERGeneralizedTime) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public String getTime() {
        DERObject dERObject = this.time;
        if (dERObject instanceof DERUTCTime) {
            return ((DERUTCTime) dERObject).getAdjustedTime();
        }
        return ((DERGeneralizedTime) dERObject).getTime();
    }

    public Date getDate() {
        try {
            if (this.time instanceof DERUTCTime) {
                return ((DERUTCTime) this.time).getAdjustedDate();
            }
            return ((DERGeneralizedTime) this.time).getDate();
        } catch (ParseException e) {
            throw new IllegalStateException("invalid date string: " + e.getMessage());
        }
    }

    public DERObject toASN1Object() {
        return this.time;
    }

    public String toString() {
        return getTime();
    }
}
