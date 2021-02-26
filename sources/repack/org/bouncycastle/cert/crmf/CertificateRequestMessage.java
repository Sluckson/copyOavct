package repack.org.bouncycastle.cert.crmf;

import java.io.IOException;
import repack.org.bouncycastle.asn1.ASN1Object;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.DERUTF8String;
import repack.org.bouncycastle.asn1.crmf.AttributeTypeAndValue;
import repack.org.bouncycastle.asn1.crmf.CRMFObjectIdentifiers;
import repack.org.bouncycastle.asn1.crmf.CertReqMsg;
import repack.org.bouncycastle.asn1.crmf.CertTemplate;
import repack.org.bouncycastle.asn1.crmf.Controls;
import repack.org.bouncycastle.asn1.crmf.PKIArchiveOptions;
import repack.org.bouncycastle.asn1.crmf.POPOSigningKey;
import repack.org.bouncycastle.asn1.crmf.ProofOfPossession;
import repack.org.bouncycastle.cert.CertIOException;
import repack.org.bouncycastle.operator.ContentVerifier;
import repack.org.bouncycastle.operator.ContentVerifierProvider;
import repack.org.bouncycastle.operator.OperatorCreationException;

public class CertificateRequestMessage {
    public static final int popKeyAgreement = 3;
    public static final int popKeyEncipherment = 2;
    public static final int popRaVerified = 0;
    public static final int popSigningKey = 1;
    private final CertReqMsg certReqMsg;
    private final Controls controls;

    private static CertReqMsg parseBytes(byte[] bArr) throws IOException {
        try {
            return CertReqMsg.getInstance(ASN1Object.fromByteArray(bArr));
        } catch (ClassCastException e) {
            throw new CertIOException("malformed data: " + e.getMessage(), e);
        } catch (IllegalArgumentException e2) {
            throw new CertIOException("malformed data: " + e2.getMessage(), e2);
        }
    }

    public CertificateRequestMessage(byte[] bArr) throws IOException {
        this(parseBytes(bArr));
    }

    public CertificateRequestMessage(CertReqMsg certReqMsg2) {
        this.certReqMsg = certReqMsg2;
        this.controls = certReqMsg2.getCertReq().getControls();
    }

    public CertReqMsg toASN1Structure() {
        return this.certReqMsg;
    }

    public CertTemplate getCertTemplate() {
        return this.certReqMsg.getCertReq().getCertTemplate();
    }

    public boolean hasControls() {
        return this.controls != null;
    }

    public boolean hasControl(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return findControl(aSN1ObjectIdentifier) != null;
    }

    public Control getControl(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        AttributeTypeAndValue findControl = findControl(aSN1ObjectIdentifier);
        if (findControl == null) {
            return null;
        }
        if (findControl.getType().equals(CRMFObjectIdentifiers.id_regCtrl_pkiArchiveOptions)) {
            return new PKIArchiveControl(PKIArchiveOptions.getInstance(findControl.getValue()));
        }
        if (findControl.getType().equals(CRMFObjectIdentifiers.id_regCtrl_regToken)) {
            return new RegTokenControl(DERUTF8String.getInstance(findControl.getValue()));
        }
        if (findControl.getType().equals(CRMFObjectIdentifiers.id_regCtrl_authenticator)) {
            return new AuthenticatorControl(DERUTF8String.getInstance(findControl.getValue()));
        }
        return null;
    }

    private AttributeTypeAndValue findControl(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Controls controls2 = this.controls;
        if (controls2 == null) {
            return null;
        }
        AttributeTypeAndValue[] attributeTypeAndValueArray = controls2.toAttributeTypeAndValueArray();
        for (int i = 0; i != attributeTypeAndValueArray.length; i++) {
            if (attributeTypeAndValueArray[i].getType().equals(aSN1ObjectIdentifier)) {
                return attributeTypeAndValueArray[i];
            }
        }
        return null;
    }

    public boolean hasProofOfPossession() {
        return this.certReqMsg.getPopo() != null;
    }

    public int getProofOfPossessionType() {
        return this.certReqMsg.getPopo().getType();
    }

    public boolean hasSigningKeyProofOfPossessionWithPKMAC() {
        ProofOfPossession popo = this.certReqMsg.getPopo();
        return popo.getType() == 1 && POPOSigningKey.getInstance(popo.getObject()).getPoposkInput().getPublicKeyMAC() != null;
    }

    public boolean isValidSigningKeyPOP(ContentVerifierProvider contentVerifierProvider) throws CRMFException, IllegalStateException {
        ProofOfPossession popo = this.certReqMsg.getPopo();
        if (popo.getType() == 1) {
            POPOSigningKey instance = POPOSigningKey.getInstance(popo.getObject());
            if (instance.getPoposkInput().getPublicKeyMAC() == null) {
                return verifySignature(contentVerifierProvider, instance);
            }
            throw new IllegalStateException("verification requires password check");
        }
        throw new IllegalStateException("not Signing Key type of proof of possession");
    }

    public boolean isValidSigningKeyPOP(ContentVerifierProvider contentVerifierProvider, PKMACBuilder pKMACBuilder, char[] cArr) throws CRMFException, IllegalStateException {
        ProofOfPossession popo = this.certReqMsg.getPopo();
        if (popo.getType() == 1) {
            POPOSigningKey instance = POPOSigningKey.getInstance(popo.getObject());
            if (instance.getPoposkInput().getSender() == null) {
                if (new PKMACValueVerifier(pKMACBuilder).isValid(instance.getPoposkInput().getPublicKeyMAC(), cArr, getCertTemplate().getPublicKey())) {
                    return verifySignature(contentVerifierProvider, instance);
                }
                return false;
            }
            throw new IllegalStateException("no PKMAC present in proof of possession");
        }
        throw new IllegalStateException("not Signing Key type of proof of possession");
    }

    private boolean verifySignature(ContentVerifierProvider contentVerifierProvider, POPOSigningKey pOPOSigningKey) throws CRMFException {
        try {
            ContentVerifier contentVerifier = contentVerifierProvider.get(pOPOSigningKey.getAlgorithmIdentifier());
            CRMFUtil.derEncodeToStream(pOPOSigningKey.getPoposkInput(), contentVerifier.getOutputStream());
            return contentVerifier.verify(pOPOSigningKey.getSignature().getBytes());
        } catch (OperatorCreationException e) {
            throw new CRMFException("unable to create verifier: " + e.getMessage(), e);
        }
    }

    public byte[] getEncoded() throws IOException {
        return this.certReqMsg.getEncoded();
    }
}
