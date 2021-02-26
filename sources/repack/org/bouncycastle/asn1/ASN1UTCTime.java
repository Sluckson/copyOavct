package repack.org.bouncycastle.asn1;

import java.util.Date;

public class ASN1UTCTime extends DERUTCTime {
    ASN1UTCTime(byte[] bArr) {
        super(bArr);
    }

    public ASN1UTCTime(Date date) {
        super(date);
    }

    public ASN1UTCTime(String str) {
        super(str);
    }
}
