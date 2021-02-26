package repack.org.bouncycastle.asn1;

import java.util.Date;

public class ASN1GeneralizedTime extends DERGeneralizedTime {
    ASN1GeneralizedTime(byte[] bArr) {
        super(bArr);
    }

    public ASN1GeneralizedTime(Date date) {
        super(date);
    }

    public ASN1GeneralizedTime(String str) {
        super(str);
    }
}
