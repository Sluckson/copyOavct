package repack.org.bouncycastle.asn1;

import java.io.IOException;

public abstract class DERObject extends ASN1Encodable implements DERTags {
    /* access modifiers changed from: package-private */
    public abstract void encode(DEROutputStream dEROutputStream) throws IOException;

    public abstract boolean equals(Object obj);

    public abstract int hashCode();

    public DERObject toASN1Object() {
        return this;
    }
}
