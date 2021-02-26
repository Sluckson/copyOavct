package repack.org.bouncycastle.asn1;

import java.io.IOException;
import java.math.BigInteger;
import repack.org.bouncycastle.util.Arrays;

public class DERInteger extends ASN1Object {
    byte[] bytes;

    public static DERInteger getInstance(Object obj) {
        if (obj == null || (obj instanceof DERInteger)) {
            return (DERInteger) obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DERInteger getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        DERObject object = aSN1TaggedObject.getObject();
        if (z || (object instanceof DERInteger)) {
            return getInstance(object);
        }
        return new ASN1Integer(ASN1OctetString.getInstance(aSN1TaggedObject.getObject()).getOctets());
    }

    public DERInteger(int i) {
        this.bytes = BigInteger.valueOf((long) i).toByteArray();
    }

    public DERInteger(BigInteger bigInteger) {
        this.bytes = bigInteger.toByteArray();
    }

    public DERInteger(byte[] bArr) {
        this.bytes = bArr;
    }

    public BigInteger getValue() {
        return new BigInteger(this.bytes);
    }

    public BigInteger getPositiveValue() {
        return new BigInteger(1, this.bytes);
    }

    /* access modifiers changed from: package-private */
    public void encode(DEROutputStream dEROutputStream) throws IOException {
        dEROutputStream.writeEncoded(2, this.bytes);
    }

    public int hashCode() {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.bytes;
            if (i == bArr.length) {
                return i2;
            }
            i2 ^= (bArr[i] & 255) << (i % 4);
            i++;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean asn1Equals(DERObject dERObject) {
        if (!(dERObject instanceof DERInteger)) {
            return false;
        }
        return Arrays.areEqual(this.bytes, ((DERInteger) dERObject).bytes);
    }

    public String toString() {
        return getValue().toString();
    }
}
