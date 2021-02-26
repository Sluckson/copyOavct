package repack.org.bouncycastle.cert.crmf;

import repack.org.bouncycastle.asn1.DERBitString;
import repack.org.bouncycastle.asn1.crmf.PKMACValue;
import repack.org.bouncycastle.asn1.crmf.POPOSigningKey;
import repack.org.bouncycastle.asn1.crmf.POPOSigningKeyInput;
import repack.org.bouncycastle.asn1.x509.GeneralName;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.operator.ContentSigner;

public class ProofOfPossessionSigningKeyBuilder {
    private GeneralName name;
    private SubjectPublicKeyInfo pubKeyInfo;
    private PKMACValue publicKeyMAC;

    public ProofOfPossessionSigningKeyBuilder(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.pubKeyInfo = subjectPublicKeyInfo;
    }

    public ProofOfPossessionSigningKeyBuilder setSender(GeneralName generalName) {
        this.name = generalName;
        return this;
    }

    public ProofOfPossessionSigningKeyBuilder setPublicKeyMac(PKMACValueGenerator pKMACValueGenerator, char[] cArr) throws CRMFException {
        this.publicKeyMAC = pKMACValueGenerator.generate(cArr, this.pubKeyInfo);
        return this;
    }

    public POPOSigningKey build(ContentSigner contentSigner) {
        POPOSigningKeyInput pOPOSigningKeyInput;
        if (this.name == null || this.publicKeyMAC == null) {
            GeneralName generalName = this.name;
            if (generalName != null) {
                pOPOSigningKeyInput = new POPOSigningKeyInput(generalName, this.pubKeyInfo);
            } else {
                pOPOSigningKeyInput = new POPOSigningKeyInput(this.publicKeyMAC, this.pubKeyInfo);
            }
            CRMFUtil.derEncodeToStream(pOPOSigningKeyInput, contentSigner.getOutputStream());
            return new POPOSigningKey(pOPOSigningKeyInput, contentSigner.getAlgorithmIdentifier(), new DERBitString(contentSigner.getSignature()));
        }
        throw new IllegalStateException("name and publicKeyMAC cannot both be set.");
    }
}
