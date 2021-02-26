package repack.org.bouncycastle.cert.crmf;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Integer;
import repack.org.bouncycastle.asn1.ASN1Null;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.crmf.AttributeTypeAndValue;
import repack.org.bouncycastle.asn1.crmf.CertReqMsg;
import repack.org.bouncycastle.asn1.crmf.CertRequest;
import repack.org.bouncycastle.asn1.crmf.CertTemplateBuilder;
import repack.org.bouncycastle.asn1.crmf.POPOPrivKey;
import repack.org.bouncycastle.asn1.crmf.ProofOfPossession;
import repack.org.bouncycastle.asn1.crmf.SubsequentMessage;
import repack.org.bouncycastle.asn1.x500.X500Name;
import repack.org.bouncycastle.asn1.x509.GeneralName;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.asn1.x509.X509ExtensionsGenerator;
import repack.org.bouncycastle.operator.ContentSigner;

public class CertificateRequestMessageBuilder {
    private final BigInteger certReqId;
    private List controls = new ArrayList();
    private X509ExtensionsGenerator extGenerator = new X509ExtensionsGenerator();
    private char[] password;
    private PKMACBuilder pkmacBuilder;
    private ASN1Null popRaVerified;
    private ContentSigner popSigner;
    private POPOPrivKey popoPrivKey;
    private GeneralName sender;
    private CertTemplateBuilder templateBuilder = new CertTemplateBuilder();

    public CertificateRequestMessageBuilder(BigInteger bigInteger) {
        this.certReqId = bigInteger;
    }

    public CertificateRequestMessageBuilder setPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        if (subjectPublicKeyInfo != null) {
            this.templateBuilder.setPublicKey(subjectPublicKeyInfo);
        }
        return this;
    }

    public CertificateRequestMessageBuilder setIssuer(X500Name x500Name) {
        if (x500Name != null) {
            this.templateBuilder.setIssuer(x500Name);
        }
        return this;
    }

    public CertificateRequestMessageBuilder setSubject(X500Name x500Name) {
        if (x500Name != null) {
            this.templateBuilder.setSubject(x500Name);
        }
        return this;
    }

    public CertificateRequestMessageBuilder setSerialNumber(BigInteger bigInteger) {
        if (bigInteger != null) {
            this.templateBuilder.setSerialNumber(new ASN1Integer(bigInteger));
        }
        return this;
    }

    public CertificateRequestMessageBuilder addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, ASN1Encodable aSN1Encodable) {
        this.extGenerator.addExtension((DERObjectIdentifier) aSN1ObjectIdentifier, z, (DEREncodable) aSN1Encodable);
        return this;
    }

    public CertificateRequestMessageBuilder addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, byte[] bArr) {
        this.extGenerator.addExtension((DERObjectIdentifier) aSN1ObjectIdentifier, z, bArr);
        return this;
    }

    public CertificateRequestMessageBuilder addControl(Control control) {
        this.controls.add(control);
        return this;
    }

    public CertificateRequestMessageBuilder setProofOfPossessionSigningKeySigner(ContentSigner contentSigner) {
        if (this.popoPrivKey == null && this.popRaVerified == null) {
            this.popSigner = contentSigner;
            return this;
        }
        throw new IllegalStateException("only one proof of possession allowed");
    }

    public CertificateRequestMessageBuilder setProofOfPossessionSubsequentMessage(SubsequentMessage subsequentMessage) {
        if (this.popSigner == null && this.popRaVerified == null) {
            this.popoPrivKey = new POPOPrivKey(subsequentMessage);
            return this;
        }
        throw new IllegalStateException("only one proof of possession allowed");
    }

    public CertificateRequestMessageBuilder setProofOfPossessionRaVerified() {
        if (this.popSigner == null && this.popoPrivKey == null) {
            this.popRaVerified = DERNull.INSTANCE;
            return this;
        }
        throw new IllegalStateException("only one proof of possession allowed");
    }

    public CertificateRequestMessageBuilder setAuthInfoPKMAC(PKMACBuilder pKMACBuilder, char[] cArr) {
        this.pkmacBuilder = pKMACBuilder;
        this.password = cArr;
        return this;
    }

    public CertificateRequestMessageBuilder setAuthInfoSender(X500Name x500Name) {
        return setAuthInfoSender(new GeneralName(x500Name));
    }

    public CertificateRequestMessageBuilder setAuthInfoSender(GeneralName generalName) {
        this.sender = generalName;
        return this;
    }

    public CertificateRequestMessage build() throws CRMFException {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new DERInteger(this.certReqId));
        if (!this.extGenerator.isEmpty()) {
            this.templateBuilder.setExtensions(this.extGenerator.generate());
        }
        aSN1EncodableVector.add(this.templateBuilder.build());
        if (!this.controls.isEmpty()) {
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            for (Control control : this.controls) {
                aSN1EncodableVector2.add(new AttributeTypeAndValue((DERObjectIdentifier) control.getType(), control.getValue()));
            }
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        }
        CertRequest instance = CertRequest.getInstance(new DERSequence(aSN1EncodableVector));
        ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
        aSN1EncodableVector3.add(instance);
        if (this.popSigner != null) {
            ProofOfPossessionSigningKeyBuilder proofOfPossessionSigningKeyBuilder = new ProofOfPossessionSigningKeyBuilder(instance.getCertTemplate().getPublicKey());
            GeneralName generalName = this.sender;
            if (generalName != null) {
                proofOfPossessionSigningKeyBuilder.setSender(generalName);
            } else {
                proofOfPossessionSigningKeyBuilder.setPublicKeyMac(new PKMACValueGenerator(this.pkmacBuilder), this.password);
            }
            aSN1EncodableVector3.add(new ProofOfPossession(proofOfPossessionSigningKeyBuilder.build(this.popSigner)));
        } else {
            POPOPrivKey pOPOPrivKey = this.popoPrivKey;
            if (pOPOPrivKey != null) {
                aSN1EncodableVector3.add(new ProofOfPossession(2, pOPOPrivKey));
            } else if (this.popRaVerified != null) {
                aSN1EncodableVector3.add(new ProofOfPossession());
            }
        }
        return new CertificateRequestMessage(CertReqMsg.getInstance(new DERSequence(aSN1EncodableVector3)));
    }
}
