package repack.org.bouncycastle.asn1;

import java.io.IOException;

public abstract class ASN1Null extends ASN1Object {
    /* access modifiers changed from: package-private */
    public abstract void encode(DEROutputStream dEROutputStream) throws IOException;

    public int hashCode() {
        return -1;
    }

    public String toString() {
        return "NULL";
    }

    /* access modifiers changed from: package-private */
    public boolean asn1Equals(DERObject dERObject) {
        return dERObject instanceof ASN1Null;
    }
}
