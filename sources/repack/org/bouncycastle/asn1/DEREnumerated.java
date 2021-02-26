package repack.org.bouncycastle.asn1;

import java.io.IOException;
import java.math.BigInteger;
import repack.org.bouncycastle.util.Arrays;

public class DEREnumerated extends ASN1Object {
    byte[] bytes;

    public static DEREnumerated getInstance(Object obj) {
        if (obj == null || (obj instanceof DEREnumerated)) {
            return (DEREnumerated) obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DEREnumerated getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        DERObject object = aSN1TaggedObject.getObject();
        if (z || (object instanceof DEREnumerated)) {
            return getInstance(object);
        }
        return new DEREnumerated(((ASN1OctetString) object).getOctets());
    }

    public DEREnumerated(int i) {
        this.bytes = BigInteger.valueOf((long) i).toByteArray();
    }

    public DEREnumerated(BigInteger bigInteger) {
        this.bytes = bigInteger.toByteArray();
    }

    public DEREnumerated(byte[] bArr) {
        this.bytes = bArr;
    }

    public BigInteger getValue() {
        return new BigInteger(this.bytes);
    }

    /* access modifiers changed from: package-private */
    public void encode(DEROutputStream dEROutputStream) throws IOException {
        dEROutputStream.writeEncoded(10, this.bytes);
    }

    /* access modifiers changed from: package-private */
    public boolean asn1Equals(DERObject dERObject) {
        if (!(dERObject instanceof DEREnumerated)) {
            return false;
        }
        return Arrays.areEqual(this.bytes, ((DEREnumerated) dERObject).bytes);
    }

    public int hashCode() {
        return Arrays.hashCode(this.bytes);
    }
}
