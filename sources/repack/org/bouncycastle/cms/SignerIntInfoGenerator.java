package repack.org.bouncycastle.cms;

import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.cms.SignerInfo;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

interface SignerIntInfoGenerator {
    SignerInfo generate(DERObjectIdentifier dERObjectIdentifier, AlgorithmIdentifier algorithmIdentifier, byte[] bArr) throws CMSStreamException;
}
