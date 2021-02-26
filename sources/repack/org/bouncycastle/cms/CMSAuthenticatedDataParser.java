package repack.org.bouncycastle.cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.AlgorithmParameters;
import java.security.NoSuchProviderException;
import java.security.Provider;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1OctetStringParser;
import repack.org.bouncycastle.asn1.ASN1SequenceParser;
import repack.org.bouncycastle.asn1.ASN1Set;
import repack.org.bouncycastle.asn1.ASN1SetParser;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERSet;
import repack.org.bouncycastle.asn1.cms.AttributeTable;
import repack.org.bouncycastle.asn1.cms.AuthenticatedDataParser;
import repack.org.bouncycastle.asn1.cms.CMSAttributes;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.cms.CMSEnvelopedHelper;
import repack.org.bouncycastle.operator.DigestCalculatorProvider;
import repack.org.bouncycastle.operator.OperatorCreationException;
import repack.org.bouncycastle.util.Arrays;

public class CMSAuthenticatedDataParser extends CMSContentInfoParser {
    private boolean authAttrNotRead;
    private ASN1Set authAttrSet;
    private AttributeTable authAttrs;
    AuthenticatedDataParser authData;
    private byte[] mac;
    private AlgorithmIdentifier macAlg;
    RecipientInformationStore recipientInfoStore;
    private boolean unauthAttrNotRead;
    private AttributeTable unauthAttrs;

    public CMSAuthenticatedDataParser(byte[] bArr) throws CMSException, IOException {
        this((InputStream) new ByteArrayInputStream(bArr));
    }

    public CMSAuthenticatedDataParser(byte[] bArr, DigestCalculatorProvider digestCalculatorProvider) throws CMSException, IOException {
        this((InputStream) new ByteArrayInputStream(bArr), digestCalculatorProvider);
    }

    public CMSAuthenticatedDataParser(InputStream inputStream) throws CMSException, IOException {
        this(inputStream, (DigestCalculatorProvider) null);
    }

    public CMSAuthenticatedDataParser(InputStream inputStream, DigestCalculatorProvider digestCalculatorProvider) throws CMSException, IOException {
        super(inputStream);
        this.authAttrNotRead = true;
        this.authData = new AuthenticatedDataParser((ASN1SequenceParser) this._contentInfo.getContent(16));
        ASN1Set instance = ASN1Set.getInstance(this.authData.getRecipientInfos().getDERObject());
        this.macAlg = this.authData.getMacAlgorithm();
        AlgorithmIdentifier digestAlgorithm = this.authData.getDigestAlgorithm();
        if (digestAlgorithm == null) {
            this.recipientInfoStore = CMSEnvelopedHelper.buildRecipientInformationStore(instance, this.macAlg, new CMSEnvelopedHelper.CMSAuthenticatedSecureReadable(this.macAlg, new CMSProcessableInputStream(((ASN1OctetStringParser) this.authData.getEnapsulatedContentInfo().getContent(4)).getOctetStream())));
        } else if (digestCalculatorProvider != null) {
            try {
                this.recipientInfoStore = CMSEnvelopedHelper.buildRecipientInformationStore(instance, this.macAlg, new CMSEnvelopedHelper.CMSDigestAuthenticatedSecureReadable(digestCalculatorProvider.get(digestAlgorithm), new CMSProcessableInputStream(((ASN1OctetStringParser) this.authData.getEnapsulatedContentInfo().getContent(4)).getOctetStream())), new AuthAttributesProvider() {
                    public ASN1Set getAuthAttributes() {
                        try {
                            return CMSAuthenticatedDataParser.this.getAuthAttrSet();
                        } catch (IOException e) {
                            e.printStackTrace();
                            throw new IllegalStateException("can't parse authenticated attributes!");
                        }
                    }
                });
            } catch (OperatorCreationException e) {
                throw new CMSException("unable to create digest calculator: " + e.getMessage(), e);
            }
        } else {
            throw new CMSException("a digest calculator provider is required if authenticated attributes are present");
        }
    }

    public String getMacAlgOID() {
        return this.macAlg.getObjectId().toString();
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

    public byte[] getMac() throws IOException {
        if (this.mac == null) {
            getAuthAttrs();
            this.mac = this.authData.getMac().getOctets();
        }
        return Arrays.clone(this.mac);
    }

    /* access modifiers changed from: private */
    public ASN1Set getAuthAttrSet() throws IOException {
        if (this.authAttrs == null && this.authAttrNotRead) {
            ASN1SetParser authAttrs2 = this.authData.getAuthAttrs();
            if (authAttrs2 != null) {
                this.authAttrSet = (ASN1Set) authAttrs2.getDERObject();
            }
            this.authAttrNotRead = false;
        }
        return this.authAttrSet;
    }

    public AttributeTable getAuthAttrs() throws IOException {
        ASN1Set authAttrSet2;
        if (this.authAttrs == null && this.authAttrNotRead && (authAttrSet2 = getAuthAttrSet()) != null) {
            this.authAttrs = new AttributeTable(authAttrSet2);
        }
        return this.authAttrs;
    }

    public AttributeTable getUnauthAttrs() throws IOException {
        if (this.unauthAttrs == null && this.unauthAttrNotRead) {
            ASN1SetParser unauthAttrs2 = this.authData.getUnauthAttrs();
            this.unauthAttrNotRead = false;
            if (unauthAttrs2 != null) {
                ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                while (true) {
                    DEREncodable readObject = unauthAttrs2.readObject();
                    if (readObject == null) {
                        break;
                    }
                    aSN1EncodableVector.add(((ASN1SequenceParser) readObject).getDERObject());
                }
                this.unauthAttrs = new AttributeTable((ASN1Set) new DERSet(aSN1EncodableVector));
            }
        }
        return this.unauthAttrs;
    }

    private byte[] encodeObj(DEREncodable dEREncodable) throws IOException {
        if (dEREncodable != null) {
            return dEREncodable.getDERObject().getEncoded();
        }
        return null;
    }

    public byte[] getContentDigest() {
        AttributeTable attributeTable = this.authAttrs;
        if (attributeTable != null) {
            return ASN1OctetString.getInstance(attributeTable.get(CMSAttributes.messageDigest).getAttrValues().getObjectAt(0)).getOctets();
        }
        return null;
    }
}
