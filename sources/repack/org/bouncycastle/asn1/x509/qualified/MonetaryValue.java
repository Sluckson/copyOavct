package repack.org.bouncycastle.asn1.x509.qualified;

import java.math.BigInteger;
import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;

public class MonetaryValue extends ASN1Encodable {
    DERInteger amount;
    Iso4217CurrencyCode currency;
    DERInteger exponent;

    public static MonetaryValue getInstance(Object obj) {
        if (obj == null || (obj instanceof MonetaryValue)) {
            return (MonetaryValue) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new MonetaryValue(ASN1Sequence.getInstance(obj));
        }
        throw new IllegalArgumentException("unknown object in getInstance");
    }

    public MonetaryValue(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.currency = Iso4217CurrencyCode.getInstance(objects.nextElement());
        this.amount = DERInteger.getInstance(objects.nextElement());
        this.exponent = DERInteger.getInstance(objects.nextElement());
    }

    public MonetaryValue(Iso4217CurrencyCode iso4217CurrencyCode, int i, int i2) {
        this.currency = iso4217CurrencyCode;
        this.amount = new DERInteger(i);
        this.exponent = new DERInteger(i2);
    }

    public Iso4217CurrencyCode getCurrency() {
        return this.currency;
    }

    public BigInteger getAmount() {
        return this.amount.getValue();
    }

    public BigInteger getExponent() {
        return this.exponent.getValue();
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.currency);
        aSN1EncodableVector.add(this.amount);
        aSN1EncodableVector.add(this.exponent);
        return new DERSequence(aSN1EncodableVector);
    }
}
