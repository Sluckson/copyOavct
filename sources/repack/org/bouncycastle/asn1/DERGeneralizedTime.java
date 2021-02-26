package repack.org.bouncycastle.asn1;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class DERGeneralizedTime extends ASN1Object {
    String time;

    public static DERGeneralizedTime getInstance(Object obj) {
        if (obj == null || (obj instanceof DERGeneralizedTime)) {
            return (DERGeneralizedTime) obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DERGeneralizedTime getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        DERObject object = aSN1TaggedObject.getObject();
        if (z || (object instanceof DERGeneralizedTime)) {
            return getInstance(object);
        }
        return new DERGeneralizedTime(((ASN1OctetString) object).getOctets());
    }

    public DERGeneralizedTime(String str) {
        this.time = str;
        try {
            getDate();
        } catch (ParseException e) {
            throw new IllegalArgumentException("invalid date string: " + e.getMessage());
        }
    }

    public DERGeneralizedTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = simpleDateFormat.format(date);
    }

    DERGeneralizedTime(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        for (int i = 0; i != cArr.length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        this.time = new String(cArr);
    }

    public String getTimeString() {
        return this.time;
    }

    public String getTime() {
        String str = this.time;
        if (str.charAt(str.length() - 1) == 'Z') {
            String str2 = this.time;
            return String.valueOf(str2.substring(0, str2.length() - 1)) + "GMT+00:00";
        }
        int length = this.time.length() - 5;
        char charAt = this.time.charAt(length);
        if (charAt == '-' || charAt == '+') {
            StringBuilder sb = new StringBuilder(String.valueOf(this.time.substring(0, length)));
            sb.append("GMT");
            int i = length + 3;
            sb.append(this.time.substring(length, i));
            sb.append(":");
            sb.append(this.time.substring(i));
            return sb.toString();
        }
        int length2 = this.time.length() - 3;
        char charAt2 = this.time.charAt(length2);
        if (charAt2 == '-' || charAt2 == '+') {
            return String.valueOf(this.time.substring(0, length2)) + "GMT" + this.time.substring(length2) + ":00";
        }
        return String.valueOf(this.time) + calculateGMTOffset();
    }

    private String calculateGMTOffset() {
        String str;
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = timeZone.getRawOffset();
        if (rawOffset < 0) {
            rawOffset = -rawOffset;
            str = "-";
        } else {
            str = "+";
        }
        int i = rawOffset / 3600000;
        int i2 = (rawOffset - (((i * 60) * 60) * 1000)) / 60000;
        try {
            if (timeZone.useDaylightTime() && timeZone.inDaylightTime(getDate())) {
                i += str.equals("+") ? 1 : -1;
            }
        } catch (ParseException unused) {
        }
        return "GMT" + str + convert(i) + ":" + convert(i2);
    }

    private String convert(int i) {
        if (i >= 10) {
            return Integer.toString(i);
        }
        return "0" + i;
    }

    public Date getDate() throws ParseException {
        SimpleDateFormat simpleDateFormat;
        SimpleDateFormat simpleDateFormat2;
        SimpleDateFormat simpleDateFormat3;
        String str = this.time;
        if (str.endsWith("Z")) {
            if (hasFractionalSeconds()) {
                simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss.SSS'Z'");
            } else {
                simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
            }
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        } else if (this.time.indexOf(45) > 0 || this.time.indexOf(43) > 0) {
            str = getTime();
            if (hasFractionalSeconds()) {
                simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss.SSSz");
            } else {
                simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHHmmssz");
            }
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        } else {
            if (hasFractionalSeconds()) {
                simpleDateFormat3 = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
            } else {
                simpleDateFormat3 = new SimpleDateFormat("yyyyMMddHHmmss");
            }
            simpleDateFormat = simpleDateFormat3;
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, TimeZone.getDefault().getID()));
        }
        if (hasFractionalSeconds()) {
            String substring = str.substring(14);
            int i = 1;
            while (i < substring.length() && '0' <= (r7 = substring.charAt(i)) && r7 <= '9') {
                i++;
            }
            int i2 = i - 1;
            if (i2 > 3) {
                str = String.valueOf(str.substring(0, 14)) + (String.valueOf(substring.substring(0, 4)) + substring.substring(i));
            } else if (i2 == 1) {
                str = String.valueOf(str.substring(0, 14)) + (String.valueOf(substring.substring(0, i)) + "00" + substring.substring(i));
            } else if (i2 == 2) {
                str = String.valueOf(str.substring(0, 14)) + (String.valueOf(substring.substring(0, i)) + "0" + substring.substring(i));
            }
        }
        return simpleDateFormat.parse(str);
    }

    private boolean hasFractionalSeconds() {
        return this.time.indexOf(46) == 14;
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
        dEROutputStream.writeEncoded(24, getOctets());
    }

    /* access modifiers changed from: package-private */
    public boolean asn1Equals(DERObject dERObject) {
        if (!(dERObject instanceof DERGeneralizedTime)) {
            return false;
        }
        return this.time.equals(((DERGeneralizedTime) dERObject).time);
    }

    public int hashCode() {
        return this.time.hashCode();
    }
}
