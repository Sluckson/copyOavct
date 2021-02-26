package repack.org.bouncycastle.asn1.p065x9;

import java.math.BigInteger;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.math.p070ec.ECCurve;
import repack.org.bouncycastle.math.p070ec.ECPoint;

/* renamed from: repack.org.bouncycastle.asn1.x9.X9ECParameters */
public class X9ECParameters extends ASN1Encodable implements X9ObjectIdentifiers {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private ECCurve curve;
    private X9FieldID fieldID;

    /* renamed from: g */
    private ECPoint f5894g;

    /* renamed from: h */
    private BigInteger f5895h;

    /* renamed from: n */
    private BigInteger f5896n;
    private byte[] seed;

    public X9ECParameters(ASN1Sequence aSN1Sequence) {
        if (!(aSN1Sequence.getObjectAt(0) instanceof DERInteger) || !((DERInteger) aSN1Sequence.getObjectAt(0)).getValue().equals(ONE)) {
            throw new IllegalArgumentException("bad version in X9ECParameters");
        }
        X9Curve x9Curve = new X9Curve(new X9FieldID((ASN1Sequence) aSN1Sequence.getObjectAt(1)), (ASN1Sequence) aSN1Sequence.getObjectAt(2));
        this.curve = x9Curve.getCurve();
        this.f5894g = new X9ECPoint(this.curve, (ASN1OctetString) aSN1Sequence.getObjectAt(3)).getPoint();
        this.f5896n = ((DERInteger) aSN1Sequence.getObjectAt(4)).getValue();
        this.seed = x9Curve.getSeed();
        if (aSN1Sequence.size() == 6) {
            this.f5895h = ((DERInteger) aSN1Sequence.getObjectAt(5)).getValue();
        }
    }

    public X9ECParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger) {
        this(eCCurve, eCPoint, bigInteger, ONE, (byte[]) null);
    }

    public X9ECParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this(eCCurve, eCPoint, bigInteger, bigInteger2, (byte[]) null);
    }

    public X9ECParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.curve = eCCurve;
        this.f5894g = eCPoint;
        this.f5896n = bigInteger;
        this.f5895h = bigInteger2;
        this.seed = bArr;
        if (eCCurve instanceof ECCurve.C5028Fp) {
            this.fieldID = new X9FieldID(((ECCurve.C5028Fp) eCCurve).getQ());
        } else if (eCCurve instanceof ECCurve.F2m) {
            ECCurve.F2m f2m = (ECCurve.F2m) eCCurve;
            this.fieldID = new X9FieldID(f2m.getM(), f2m.getK1(), f2m.getK2(), f2m.getK3());
        }
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public ECPoint getG() {
        return this.f5894g;
    }

    public BigInteger getN() {
        return this.f5896n;
    }

    public BigInteger getH() {
        BigInteger bigInteger = this.f5895h;
        return bigInteger == null ? ONE : bigInteger;
    }

    public byte[] getSeed() {
        return this.seed;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new DERInteger(1));
        aSN1EncodableVector.add(this.fieldID);
        aSN1EncodableVector.add(new X9Curve(this.curve, this.seed));
        aSN1EncodableVector.add(new X9ECPoint(this.f5894g));
        aSN1EncodableVector.add(new DERInteger(this.f5896n));
        BigInteger bigInteger = this.f5895h;
        if (bigInteger != null) {
            aSN1EncodableVector.add(new DERInteger(bigInteger));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
