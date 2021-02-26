package repack.org.bouncycastle.asn1.p065x9;

import java.math.BigInteger;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.math.p070ec.ECFieldElement;

/* renamed from: repack.org.bouncycastle.asn1.x9.X9FieldElement */
public class X9FieldElement extends ASN1Encodable {
    private static X9IntegerConverter converter = new X9IntegerConverter();

    /* renamed from: f */
    protected ECFieldElement f5898f;

    public X9FieldElement(ECFieldElement eCFieldElement) {
        this.f5898f = eCFieldElement;
    }

    public X9FieldElement(BigInteger bigInteger, ASN1OctetString aSN1OctetString) {
        this(new ECFieldElement.C5029Fp(bigInteger, new BigInteger(1, aSN1OctetString.getOctets())));
    }

    public X9FieldElement(int i, int i2, int i3, int i4, ASN1OctetString aSN1OctetString) {
        this(new ECFieldElement.F2m(i, i2, i3, i4, new BigInteger(1, aSN1OctetString.getOctets())));
    }

    public ECFieldElement getValue() {
        return this.f5898f;
    }

    public DERObject toASN1Object() {
        return new DEROctetString(converter.integerToBytes(this.f5898f.toBigInteger(), converter.getByteLength(this.f5898f)));
    }
}
