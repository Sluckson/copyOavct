package repack.org.bouncycastle.cert.crmf;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface Control {
    ASN1ObjectIdentifier getType();

    ASN1Encodable getValue();
}
