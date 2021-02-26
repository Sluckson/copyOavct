package repack.org.bouncycastle.jce.interfaces;

import java.util.Enumeration;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;

public interface PKCS12BagAttributeCarrier {
    DEREncodable getBagAttribute(DERObjectIdentifier dERObjectIdentifier);

    Enumeration getBagAttributeKeys();

    void setBagAttribute(DERObjectIdentifier dERObjectIdentifier, DEREncodable dEREncodable);
}
