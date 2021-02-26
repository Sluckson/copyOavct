package repack.org.bouncycastle.asn1.x509.qualified;

import repack.org.bouncycastle.asn1.ASN1Choice;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERPrintableString;

public class Iso4217CurrencyCode extends ASN1Encodable implements ASN1Choice {
    final int ALPHABETIC_MAXSIZE = 3;
    final int NUMERIC_MAXSIZE = 999;
    final int NUMERIC_MINSIZE = 1;
    int numeric;
    DEREncodable obj;

    public static Iso4217CurrencyCode getInstance(Object obj2) {
        if (obj2 == null || (obj2 instanceof Iso4217CurrencyCode)) {
            return (Iso4217CurrencyCode) obj2;
        }
        if (obj2 instanceof DERInteger) {
            return new Iso4217CurrencyCode(DERInteger.getInstance(obj2).getValue().intValue());
        }
        if (obj2 instanceof DERPrintableString) {
            return new Iso4217CurrencyCode(DERPrintableString.getInstance(obj2).getString());
        }
        throw new IllegalArgumentException("unknown object in getInstance");
    }

    public Iso4217CurrencyCode(int i) {
        if (i > 999 || i < 1) {
            throw new IllegalArgumentException("wrong size in numeric code : not in (1..999)");
        }
        this.obj = new DERInteger(i);
    }

    public Iso4217CurrencyCode(String str) {
        if (str.length() <= 3) {
            this.obj = new DERPrintableString(str);
            return;
        }
        throw new IllegalArgumentException("wrong size in alphabetic code : max size is 3");
    }

    public boolean isAlphabetic() {
        return this.obj instanceof DERPrintableString;
    }

    public String getAlphabetic() {
        return ((DERPrintableString) this.obj).getString();
    }

    public int getNumeric() {
        return ((DERInteger) this.obj).getValue().intValue();
    }

    public DERObject toASN1Object() {
        return this.obj.getDERObject();
    }
}
