package repack.org.bouncycastle.cms;

import java.io.IOException;
import java.io.InputStream;
import java.security.AlgorithmParameters;
import java.security.NoSuchProviderException;
import java.security.Provider;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Set;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.cms.AttributeTable;
import repack.org.bouncycastle.asn1.cms.AuthenticatedData;
import repack.org.bouncycastle.asn1.cms.CMSAttributes;
import repack.org.bouncycastle.asn1.cms.ContentInfo;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.cms.CMSEnvelopedHelper;
import repack.org.bouncycastle.operator.DigestCalculatorProvider;
import repack.org.bouncycastle.operator.OperatorCreationException;
import repack.org.bouncycastle.util.Arrays;

public class CMSAuthenticatedData {
    /* access modifiers changed from: private */
    public ASN1Set authAttrs;
    ContentInfo contentInfo;
    private byte[] mac;
    private AlgorithmIdentifier macAlg;
    RecipientInformationStore recipientInfoStore;
    private ASN1Set unauthAttrs;

    public CMSAuthenticatedData(byte[] bArr) throws CMSException {
        this(CMSUtils.readContentInfo(bArr));
    }

    public CMSAuthenticatedData(byte[] bArr, DigestCalculatorProvider digestCalculatorProvider) throws CMSException {
        this(CMSUtils.readContentInfo(bArr), digestCalculatorProvider);
    }

    public CMSAuthenticatedData(InputStream inputStream) throws CMSException {
        this(CMSUtils.readContentInfo(inputStream));
    }

    public CMSAuthenticatedData(InputStream inputStream, DigestCalculatorProvider digestCalculatorProvider) throws CMSException {
        this(CMSUtils.readContentInfo(inputStream), digestCalculatorProvider);
    }

    public CMSAuthenticatedData(ContentInfo contentInfo2) throws CMSException {
        this(contentInfo2, (DigestCalculatorProvider) null);
    }

    public CMSAuthenticatedData(ContentInfo contentInfo2, DigestCalculatorProvider digestCalculatorProvider) throws CMSException {
        this.contentInfo = contentInfo2;
        AuthenticatedData instance = AuthenticatedData.getInstance(contentInfo2.getContent());
        ASN1Set recipientInfos = instance.getRecipientInfos();
        this.macAlg = instance.getMacAlgorithm();
        this.authAttrs = instance.getAuthAttrs();
        this.mac = instance.getMac().getOctets();
        this.unauthAttrs = instance.getUnauthAttrs();
        CMSProcessableByteArray cMSProcessableByteArray = new CMSProcessableByteArray(ASN1OctetString.getInstance(instance.getEncapsulatedContentInfo().getContent()).getOctets());
        if (this.authAttrs == null) {
            this.recipientInfoStore = CMSEnvelopedHelper.buildRecipientInformationStore(recipientInfos, this.macAlg, new CMSEnvelopedHelper.CMSAuthenticatedSecureReadable(this.macAlg, cMSProcessableByteArray));
        } else if (digestCalculatorProvider != null) {
            try {
                this.recipientInfoStore = CMSEnvelopedHelper.buildRecipientInformationStore(recipientInfos, this.macAlg, new CMSEnvelopedHelper.CMSDigestAuthenticatedSecureReadable(digestCalculatorProvider.get(instance.getDigestAlgorithm()), cMSProcessableByteArray), new AuthAttributesProvider() {
                    public ASN1Set getAuthAttributes() {
                        return CMSAuthenticatedData.this.authAttrs;
                    }
                });
            } catch (OperatorCreationException e) {
                throw new CMSException("unable to create digest calculator: " + e.getMessage(), e);
            }
        } else {
            throw new CMSException("a digest calculator provider is required if authenticated attributes are present");
        }
    }

    public byte[] getMac() {
        return Arrays.clone(this.mac);
    }

    private byte[] encodeObj(DEREncodable dEREncodable) throws IOException {
        if (dEREncodable != null) {
            return dEREncodable.getDERObject().getEncoded();
        }
        return null;
    }

    public String getMacAlgOID() {
        return this.macAlg.getObjectId().getId();
    }

    public byte[] getMacAlgParams() {
        try {
            return encodeObj(this.macAlg.getParameters());
        } catch (Exception e) {
            throw new RuntimeException("exception getting encryption parameters " + e);
        }
    }

    public AlgorithmParameters getMacAlgorithmParameters(String str) throws CMSException, NoSuchProviderException {
        return getMacAlgorithmParameters(CMSUtils.getProvider(str));
    }

    public AlgorithmParameters getMacAlgorithmParameters(Provider provider) throws CMSException {
        return CMSEnvelopedHelper.INSTANCE.getEncryptionAlgorithmParameters(getMacAlgOID(), getMacAlgParams(), provider);
    }

    public RecipientInformationStore getRecipientInfos() {
        return this.recipientInfoStore;
    }

    public ContentInfo getContentInfo() {
        return this.contentInfo;
    }

    public AttributeTable getAuthAttrs() {
        ASN1Set aSN1Set = this.authAttrs;
        if (aSN1Set == null) {
            return null;
        }
        return new AttributeTable(aSN1Set);
    }

    public AttributeTable getUnauthAttrs() {
        ASN1Set aSN1Set = this.unauthAttrs;
        if (aSN1Set == null) {
            return null;
        }
        return new AttributeTable(aSN1Set);
    }

    public byte[] getEncoded() throws IOException {
        return this.contentInfo.getEncoded();
    }

    public byte[] getContentDigest() {
        if (this.authAttrs != null) {
            return ASN1OctetString.getInstance(getAuthAttrs().get(CMSAttributes.messageDigest).getAttrValues().getObjectAt(0)).getOctets();
        }
        return null;
    }
}
