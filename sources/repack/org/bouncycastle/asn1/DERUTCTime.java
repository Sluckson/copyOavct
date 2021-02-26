package repack.org.bouncycastle.asn1;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class DERUTCTime extends ASN1Object {
    String time;

    public static DERUTCTime getInstance(Object obj) {
        if (obj == null || (obj instanceof DERUTCTime)) {
            return (DERUTCTime) obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DERUTCTime getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        DERObject object = aSN1TaggedObject.getObject();
        if (z || (object instanceof DERUTCTime)) {
            return getInstance(object);
        }
        return new DERUTCTime(((ASN1OctetString) object).getOctets());
    }

    public DERUTCTime(String str) {
        this.time = str;
        try {
            getDate();
        } catch (ParseException e) {
            throw new IllegalArgumentException("invalid date string: " + e.getMessage());
        }
    }

    public DERUTCTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss'Z'");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = simpleDateFormat.format(date);
    }

    DERUTCTime(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        for (int i = 0; i != cArr.length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        this.time = new String(cArr);
    }

    public Date getDate() throws ParseException {
        return new SimpleDateFormat("yyMMddHHmmssz").parse(getTime());
    }

    public Date getAdjustedDate() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssz");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        return simpleDateFormat.parse(getAdjustedTime());
    }

    public String getTime() {
        if (this.time.indexOf(45) >= 0 || this.time.indexOf(43) >= 0) {
            int indexOf = this.time.indexOf(45);
            if (indexOf < 0) {
                indexOf = this.time.indexOf(43);
            }
            String str = this.time;
            if (indexOf == str.length() - 3) {
                str = String.valueOf(str) + "00";
            }
            if (indexOf == 10) {
                return String.valueOf(str.substring(0, 10)) + "00GMT" + str.substring(10, 13) + ":" + str.substring(13, 15);
            }
            return String.valueOf(str.substring(0, 12)) + "GMT" + str.substring(12, 15) + ":" + str.substring(15, 17);
        } else if (this.time.length() == 11) {
            return String.valueOf(this.time.substring(0, 10)) + "00GMT+00:00";
        } else {
            return String.valueOf(this.time.substring(0, 12)) + "GMT+00:00";
        }
    }

    public String getAdjustedTime() {
        String time2 = getTime();
        if (time2.charAt(0) < '5') {
            return "20" + time2;
        }
        return "19" + time2;
    }

    private byte[] getOctets() {
        char[] charArray = this.time.toCharArray();
        byte[] bArr = new byte[charArray.length];
        for (int i = 0; i != charArray.length; i++) {
            bArr[i] = (byte) charArray[i];
        }
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public void encode(DEROutputStream dEROutputStream) throws IOException {
        dEROutputStream.writeEncoded(23, getOctets());
    }

    /* access modifiers changed from: package-private */
    public boolean asn1Equals(DERObject dERObject) {
        if (!(dERObject instanceof DERUTCTime)) {
            return false;
        }
        return this.time.equals(((DERUTCTime) dERObject).time);
    }

    public int hashCode() {
        return this.time.hashCode();
    }

    public String toString() {
        return this.time;
    }
}
