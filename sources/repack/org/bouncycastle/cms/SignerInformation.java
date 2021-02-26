package repack.org.bouncycastle.cms;

import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.crypto.Cipher;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.ASN1Null;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1Set;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DERSet;
import repack.org.bouncycastle.asn1.cms.Attribute;
import repack.org.bouncycastle.asn1.cms.AttributeTable;
import repack.org.bouncycastle.asn1.cms.CMSAttributes;
import repack.org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import repack.org.bouncycastle.asn1.cms.SignerIdentifier;
import repack.org.bouncycastle.asn1.cms.SignerInfo;
import repack.org.bouncycastle.asn1.cms.Time;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.DigestInfo;
import repack.org.bouncycastle.operator.ContentVerifier;
import repack.org.bouncycastle.operator.DefaultSignatureAlgorithmIdentifierFinder;
import repack.org.bouncycastle.operator.DigestCalculator;
import repack.org.bouncycastle.operator.OperatorCreationException;
import repack.org.bouncycastle.operator.RawContentVerifier;
import repack.org.bouncycastle.operator.SignatureAlgorithmIdentifierFinder;
import repack.org.bouncycastle.util.Arrays;

public class SignerInformation {
    private CMSProcessable content;
    private ASN1ObjectIdentifier contentType;
    private AlgorithmIdentifier digestAlgorithm;
    private IntDigestCalculator digestCalculator;
    private AlgorithmIdentifier encryptionAlgorithm;
    private SignerInfo info;
    private boolean isCounterSignature;
    private byte[] resultDigest;
    private SignerId sid;
    private SignatureAlgorithmIdentifierFinder sigAlgFinder;
    private byte[] signature;
    private final ASN1Set signedAttributeSet;
    private AttributeTable signedAttributeValues;
    private final ASN1Set unsignedAttributeSet;
    private AttributeTable unsignedAttributeValues;

    SignerInformation(SignerInfo signerInfo, ASN1ObjectIdentifier aSN1ObjectIdentifier, CMSProcessable cMSProcessable, IntDigestCalculator intDigestCalculator, SignatureAlgorithmIdentifierFinder signatureAlgorithmIdentifierFinder) {
        this.info = signerInfo;
        this.contentType = aSN1ObjectIdentifier;
        this.sigAlgFinder = signatureAlgorithmIdentifierFinder;
        this.isCounterSignature = aSN1ObjectIdentifier == null;
        SignerIdentifier sid2 = signerInfo.getSID();
        if (sid2.isTagged()) {
            this.sid = new SignerId(ASN1OctetString.getInstance(sid2.getId()).getOctets());
        } else {
            IssuerAndSerialNumber instance = IssuerAndSerialNumber.getInstance(sid2.getId());
            this.sid = new SignerId(instance.getName(), instance.getSerialNumber().getValue());
        }
        this.digestAlgorithm = signerInfo.getDigestAlgorithm();
        this.signedAttributeSet = signerInfo.getAuthenticatedAttributes();
        this.unsignedAttributeSet = signerInfo.getUnauthenticatedAttributes();
        this.encryptionAlgorithm = signerInfo.getDigestEncryptionAlgorithm();
        this.signature = signerInfo.getEncryptedDigest().getOctets();
        this.content = cMSProcessable;
        this.digestCalculator = intDigestCalculator;
    }

    public boolean isCounterSignature() {
        return this.isCounterSignature;
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.contentType;
    }

    private byte[] encodeObj(DEREncodable dEREncodable) throws IOException {
        if (dEREncodable != null) {
            return dEREncodable.getDERObject().getEncoded();
        }
        return null;
    }

    public SignerId getSID() {
        return this.sid;
    }

    public int getVersion() {
        return this.info.getVersion().getValue().intValue();
    }

    public AlgorithmIdentifier getDigestAlgorithmID() {
        return this.digestAlgorithm;
    }

    public String getDigestAlgOID() {
        return this.digestAlgorithm.getObjectId().getId();
    }

    public byte[] getDigestAlgParams() {
        try {
            return encodeObj(this.digestAlgorithm.getParameters());
        } catch (Exception e) {
            throw new RuntimeException("exception getting digest parameters " + e);
        }
    }

    public byte[] getContentDigest() {
        byte[] bArr = this.resultDigest;
        if (bArr != null) {
            return (byte[]) bArr.clone();
        }
        throw new IllegalStateException("method can only be called after verify.");
    }

    public String getEncryptionAlgOID() {
        return this.encryptionAlgorithm.getObjectId().getId();
    }

    public byte[] getEncryptionAlgParams() {
        try {
            return encodeObj(this.encryptionAlgorithm.getParameters());
        } catch (Exception e) {
            throw new RuntimeException("exception getting encryption parameters " + e);
        }
    }

    public AttributeTable getSignedAttributes() {
        ASN1Set aSN1Set = this.signedAttributeSet;
        if (aSN1Set != null && this.signedAttributeValues == null) {
            this.signedAttributeValues = new AttributeTable(aSN1Set);
        }
        return this.signedAttributeValues;
    }

    public AttributeTable getUnsignedAttributes() {
        ASN1Set aSN1Set = this.unsignedAttributeSet;
        if (aSN1Set != null && this.unsignedAttributeValues == null) {
            this.unsignedAttributeValues = new AttributeTable(aSN1Set);
        }
        return this.unsignedAttributeValues;
    }

    public byte[] getSignature() {
        return (byte[]) this.signature.clone();
    }

    public SignerInformationStore getCounterSignatures() {
        AttributeTable unsignedAttributes = getUnsignedAttributes();
        if (unsignedAttributes == null) {
            return new SignerInformationStore(new ArrayList(0));
        }
        ArrayList arrayList = new ArrayList();
        ASN1EncodableVector all = unsignedAttributes.getAll(CMSAttributes.counterSignature);
        for (int i = 0; i < all.size(); i++) {
            ASN1Set attrValues = ((Attribute) all.get(i)).getAttrValues();
            attrValues.size();
            Enumeration objects = attrValues.getObjects();
            while (objects.hasMoreElements()) {
                SignerInfo instance = SignerInfo.getInstance(objects.nextElement());
                arrayList.add(new SignerInformation(instance, (ASN1ObjectIdentifier) null, (CMSProcessable) null, new CounterSignatureDigestCalculator(CMSSignedHelper.INSTANCE.getDigestAlgName(instance.getDigestAlgorithm().getObjectId().getId()), (Provider) null, getSignature()), new DefaultSignatureAlgorithmIdentifierFinder()));
            }
        }
        return new SignerInformationStore(arrayList);
    }

    public byte[] getEncodedSignedAttributes() throws IOException {
        ASN1Set aSN1Set = this.signedAttributeSet;
        if (aSN1Set != null) {
            return aSN1Set.getEncoded(ASN1Encodable.DER);
        }
        return null;
    }

    private boolean doVerify(PublicKey publicKey, Provider provider) throws CMSException, NoSuchAlgorithmException {
        String digestAlgName = CMSSignedHelper.INSTANCE.getDigestAlgName(getDigestAlgOID());
        String encryptionAlgName = CMSSignedHelper.INSTANCE.getEncryptionAlgName(getEncryptionAlgOID());
        Signature signatureInstance = CMSSignedHelper.INSTANCE.getSignatureInstance(String.valueOf(digestAlgName) + "with" + encryptionAlgName, provider);
        MessageDigest digestInstance = CMSSignedHelper.INSTANCE.getDigestInstance(digestAlgName, provider);
        try {
            if (this.digestCalculator != null) {
                this.resultDigest = this.digestCalculator.getDigest();
            } else {
                if (this.content != null) {
                    this.content.write(new DigOutputStream(digestInstance));
                } else if (this.signedAttributeSet == null) {
                    throw new CMSException("data not encapsulated in signature - use detached constructor.");
                }
                this.resultDigest = digestInstance.digest();
            }
            DERObject singleValuedSignedAttribute = getSingleValuedSignedAttribute(CMSAttributes.contentType, "content-type");
            if (singleValuedSignedAttribute == null) {
                if (!this.isCounterSignature && this.signedAttributeSet != null) {
                    throw new CMSException("The content-type attribute type MUST be present whenever signed attributes are present in signed-data");
                }
            } else if (this.isCounterSignature) {
                throw new CMSException("[For counter signatures,] the signedAttributes field MUST NOT contain a content-type attribute");
            } else if (!(singleValuedSignedAttribute instanceof DERObjectIdentifier)) {
                throw new CMSException("content-type attribute value not of ASN.1 type 'OBJECT IDENTIFIER'");
            } else if (!((DERObjectIdentifier) singleValuedSignedAttribute).equals(this.contentType)) {
                throw new CMSException("content-type attribute value does not match eContentType");
            }
            DERObject singleValuedSignedAttribute2 = getSingleValuedSignedAttribute(CMSAttributes.messageDigest, "message-digest");
            if (singleValuedSignedAttribute2 == null) {
                if (this.signedAttributeSet != null) {
                    throw new CMSException("the message-digest signed attribute type MUST be present when there are any signed attributes present");
                }
            } else if (!(singleValuedSignedAttribute2 instanceof ASN1OctetString)) {
                throw new CMSException("message-digest attribute value not of ASN.1 type 'OCTET STRING'");
            } else if (!Arrays.constantTimeAreEqual(this.resultDigest, ((ASN1OctetString) singleValuedSignedAttribute2).getOctets())) {
                throw new CMSSignerDigestMismatchException("message-digest attribute value does not match calculated value");
            }
            AttributeTable signedAttributes = getSignedAttributes();
            if (signedAttributes == null || signedAttributes.getAll(CMSAttributes.counterSignature).size() <= 0) {
                AttributeTable unsignedAttributes = getUnsignedAttributes();
                if (unsignedAttributes != null) {
                    ASN1EncodableVector all = unsignedAttributes.getAll(CMSAttributes.counterSignature);
                    int i = 0;
                    while (i < all.size()) {
                        if (((Attribute) all.get(i)).getAttrValues().size() >= 1) {
                            i++;
                        } else {
                            throw new CMSException("A countersignature attribute MUST contain at least one AttributeValue");
                        }
                    }
                }
                try {
                    signatureInstance.initVerify(publicKey);
                    if (this.signedAttributeSet != null) {
                        signatureInstance.update(getEncodedSignedAttributes());
                    } else if (this.digestCalculator != null) {
                        return verifyDigest(this.resultDigest, publicKey, getSignature(), provider);
                    } else {
                        if (this.content != null) {
                            this.content.write(new SigOutputStream(signatureInstance));
                        }
                    }
                    return signatureInstance.verify(getSignature());
                } catch (InvalidKeyException e) {
                    throw new CMSException("key not appropriate to signature in message.", e);
                } catch (IOException e2) {
                    throw new CMSException("can't process mime object to create signature.", e2);
                } catch (SignatureException e3) {
                    throw new CMSException("invalid signature format in message: " + e3.getMessage(), e3);
                }
            } else {
                throw new CMSException("A countersignature attribute MUST NOT be a signed attribute");
            }
        } catch (IOException e4) {
            throw new CMSException("can't process mime object to create signature.", e4);
        }
    }

    private boolean doVerify(SignerInformationVerifier signerInformationVerifier) throws CMSException {
        String digestAlgName = CMSSignedHelper.INSTANCE.getDigestAlgName(getDigestAlgOID());
        String encryptionAlgName = CMSSignedHelper.INSTANCE.getEncryptionAlgName(getEncryptionAlgOID());
        String str = String.valueOf(digestAlgName) + "with" + encryptionAlgName;
        try {
            if (this.digestCalculator != null) {
                this.resultDigest = this.digestCalculator.getDigest();
            } else {
                DigestCalculator digestCalculator2 = signerInformationVerifier.getDigestCalculator(getDigestAlgorithmID());
                if (this.content != null) {
                    OutputStream outputStream = digestCalculator2.getOutputStream();
                    this.content.write(outputStream);
                    outputStream.close();
                } else if (this.signedAttributeSet == null) {
                    throw new CMSException("data not encapsulated in signature - use detached constructor.");
                }
                this.resultDigest = digestCalculator2.getDigest();
            }
            DERObject singleValuedSignedAttribute = getSingleValuedSignedAttribute(CMSAttributes.contentType, "content-type");
            if (singleValuedSignedAttribute == null) {
                if (!this.isCounterSignature && this.signedAttributeSet != null) {
                    throw new CMSException("The content-type attribute type MUST be present whenever signed attributes are present in signed-data");
                }
            } else if (this.isCounterSignature) {
                throw new CMSException("[For counter signatures,] the signedAttributes field MUST NOT contain a content-type attribute");
            } else if (!(singleValuedSignedAttribute instanceof DERObjectIdentifier)) {
                throw new CMSException("content-type attribute value not of ASN.1 type 'OBJECT IDENTIFIER'");
            } else if (!((DERObjectIdentifier) singleValuedSignedAttribute).equals(this.contentType)) {
                throw new CMSException("content-type attribute value does not match eContentType");
            }
            DERObject singleValuedSignedAttribute2 = getSingleValuedSignedAttribute(CMSAttributes.messageDigest, "message-digest");
            if (singleValuedSignedAttribute2 == null) {
                if (this.signedAttributeSet != null) {
                    throw new CMSException("the message-digest signed attribute type MUST be present when there are any signed attributes present");
                }
            } else if (!(singleValuedSignedAttribute2 instanceof ASN1OctetString)) {
                throw new CMSException("message-digest attribute value not of ASN.1 type 'OCTET STRING'");
            } else if (!Arrays.constantTimeAreEqual(this.resultDigest, ((ASN1OctetString) singleValuedSignedAttribute2).getOctets())) {
                throw new CMSSignerDigestMismatchException("message-digest attribute value does not match calculated value");
            }
            AttributeTable signedAttributes = getSignedAttributes();
            if (signedAttributes == null || signedAttributes.getAll(CMSAttributes.counterSignature).size() <= 0) {
                AttributeTable unsignedAttributes = getUnsignedAttributes();
                if (unsignedAttributes != null) {
                    ASN1EncodableVector all = unsignedAttributes.getAll(CMSAttributes.counterSignature);
                    int i = 0;
                    while (i < all.size()) {
                        if (((Attribute) all.get(i)).getAttrValues().size() >= 1) {
                            i++;
                        } else {
                            throw new CMSException("A countersignature attribute MUST contain at least one AttributeValue");
                        }
                    }
                }
                try {
                    ContentVerifier contentVerifier = signerInformationVerifier.getContentVerifier(this.sigAlgFinder.find(str));
                    OutputStream outputStream2 = contentVerifier.getOutputStream();
                    if (this.signedAttributeSet != null) {
                        outputStream2.write(getEncodedSignedAttributes());
                    } else if (this.digestCalculator != null) {
                        if (contentVerifier instanceof RawContentVerifier) {
                            RawContentVerifier rawContentVerifier = (RawContentVerifier) contentVerifier;
                            if (encryptionAlgName.equals("RSA")) {
                                return rawContentVerifier.verify(new DigestInfo(this.digestAlgorithm, this.resultDigest).getDEREncoded(), getSignature());
                            }
                            return rawContentVerifier.verify(this.resultDigest, getSignature());
                        }
                        throw new CMSException("verifier unable to process raw signature");
                    } else if (this.content != null) {
                        this.content.write(outputStream2);
                    }
                    outputStream2.close();
                    return contentVerifier.verify(getSignature());
                } catch (IOException e) {
                    throw new CMSException("can't process mime object to create signature.", e);
                } catch (OperatorCreationException e2) {
                    throw new CMSException("can't create content verifier: " + e2.getMessage(), e2);
                }
            } else {
                throw new CMSException("A countersignature attribute MUST NOT be a signed attribute");
            }
        } catch (IOException e3) {
            throw new CMSException("can't process mime object to create signature.", e3);
        } catch (NoSuchAlgorithmException e4) {
            throw new CMSException("can't find algorithm: " + e4.getMessage(), e4);
        } catch (OperatorCreationException e5) {
            throw new CMSException("can't create digest calculator: " + e5.getMessage(), e5);
        }
    }

    private boolean isNull(DEREncodable dEREncodable) {
        return (dEREncodable instanceof ASN1Null) || dEREncodable == null;
    }

    private DigestInfo derDecode(byte[] bArr) throws IOException, CMSException {
        if (bArr[0] == 48) {
            DigestInfo digestInfo = new DigestInfo((ASN1Sequence) new ASN1InputStream(bArr).readObject());
            if (digestInfo.getEncoded().length == bArr.length) {
                return digestInfo;
            }
            throw new CMSException("malformed RSA signature");
        }
        throw new IOException("not a digest info object");
    }

    private boolean verifyDigest(byte[] bArr, PublicKey publicKey, byte[] bArr2, Provider provider) throws NoSuchAlgorithmException, CMSException {
        String encryptionAlgName = CMSSignedHelper.INSTANCE.getEncryptionAlgName(getEncryptionAlgOID());
        try {
            if (encryptionAlgName.equals("RSA")) {
                Cipher createAsymmetricCipher = CMSEnvelopedHelper.INSTANCE.createAsymmetricCipher("RSA/ECB/PKCS1Padding", provider);
                createAsymmetricCipher.init(2, publicKey);
                DigestInfo derDecode = derDecode(createAsymmetricCipher.doFinal(bArr2));
                if (derDecode.getAlgorithmId().getObjectId().equals(this.digestAlgorithm.getObjectId()) && isNull(derDecode.getAlgorithmId().getParameters())) {
                    return Arrays.constantTimeAreEqual(bArr, derDecode.getDigest());
                }
                return false;
            } else if (encryptionAlgName.equals("DSA")) {
                Signature signatureInstance = CMSSignedHelper.INSTANCE.getSignatureInstance("NONEwithDSA", provider);
                signatureInstance.initVerify(publicKey);
                signatureInstance.update(bArr);
                return signatureInstance.verify(bArr2);
            } else {
                throw new CMSException("algorithm: " + encryptionAlgName + " not supported in base signatures.");
            }
        } catch (GeneralSecurityException e) {
            throw new CMSException("Exception processing signature: " + e, e);
        } catch (IOException e2) {
            throw new CMSException("Exception decoding signature: " + e2, e2);
        }
    }

    public boolean verify(PublicKey publicKey, String str) throws NoSuchAlgorithmException, NoSuchProviderException, CMSException {
        return verify(publicKey, CMSUtils.getProvider(str));
    }

    public boolean verify(PublicKey publicKey, Provider provider) throws NoSuchAlgorithmException, NoSuchProviderException, CMSException {
        getSigningTime();
        return doVerify(publicKey, provider);
    }

    public boolean verify(X509Certificate x509Certificate, String str) throws NoSuchAlgorithmException, NoSuchProviderException, CertificateExpiredException, CertificateNotYetValidException, CMSException {
        return verify(x509Certificate, CMSUtils.getProvider(str));
    }

    public boolean verify(X509Certificate x509Certificate, Provider provider) throws NoSuchAlgorithmException, CertificateExpiredException, CertificateNotYetValidException, CMSException {
        Time signingTime = getSigningTime();
        if (signingTime != null) {
            x509Certificate.checkValidity(signingTime.getDate());
        }
        return doVerify(x509Certificate.getPublicKey(), provider);
    }

    public boolean verify(SignerInformationVerifier signerInformationVerifier) throws CMSException {
        Time signingTime = getSigningTime();
        if (!signerInformationVerifier.hasAssociatedCertificate() || signingTime == null || signerInformationVerifier.getAssociatedCertificate().isValidOn(signingTime.getDate())) {
            return doVerify(signerInformationVerifier);
        }
        throw new CMSVerifierCertificateNotValidException("verifier not valid at signingTime");
    }

    public SignerInfo toSignerInfo() {
        return this.info;
    }

    public SignerInfo toASN1Structure() {
        return this.info;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0032, code lost:
        r4 = r0.getAll(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private repack.org.bouncycastle.asn1.DERObject getSingleValuedSignedAttribute(repack.org.bouncycastle.asn1.DERObjectIdentifier r4, java.lang.String r5) throws repack.org.bouncycastle.cms.CMSException {
        /*
            r3 = this;
            repack.org.bouncycastle.asn1.cms.AttributeTable r0 = r3.getUnsignedAttributes()
            if (r0 == 0) goto L_0x002a
            repack.org.bouncycastle.asn1.ASN1EncodableVector r0 = r0.getAll(r4)
            int r0 = r0.size()
            if (r0 > 0) goto L_0x0011
            goto L_0x002a
        L_0x0011:
            repack.org.bouncycastle.cms.CMSException r4 = new repack.org.bouncycastle.cms.CMSException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "The "
            r0.<init>(r1)
            r0.append(r5)
            java.lang.String r5 = " attribute MUST NOT be an unsigned attribute"
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r4.<init>(r5)
            throw r4
        L_0x002a:
            repack.org.bouncycastle.asn1.cms.AttributeTable r0 = r3.getSignedAttributes()
            r1 = 0
            if (r0 != 0) goto L_0x0032
            return r1
        L_0x0032:
            repack.org.bouncycastle.asn1.ASN1EncodableVector r4 = r0.getAll(r4)
            int r0 = r4.size()
            if (r0 == 0) goto L_0x008b
            r1 = 1
            if (r0 != r1) goto L_0x0072
            r0 = 0
            repack.org.bouncycastle.asn1.DEREncodable r4 = r4.get(r0)
            repack.org.bouncycastle.asn1.cms.Attribute r4 = (repack.org.bouncycastle.asn1.cms.Attribute) r4
            repack.org.bouncycastle.asn1.ASN1Set r4 = r4.getAttrValues()
            int r2 = r4.size()
            if (r2 != r1) goto L_0x0059
            repack.org.bouncycastle.asn1.DEREncodable r4 = r4.getObjectAt(r0)
            repack.org.bouncycastle.asn1.DERObject r4 = r4.getDERObject()
            return r4
        L_0x0059:
            repack.org.bouncycastle.cms.CMSException r4 = new repack.org.bouncycastle.cms.CMSException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "A "
            r0.<init>(r1)
            r0.append(r5)
            java.lang.String r5 = " attribute MUST have a single attribute value"
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r4.<init>(r5)
            throw r4
        L_0x0072:
            repack.org.bouncycastle.cms.CMSException r4 = new repack.org.bouncycastle.cms.CMSException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "The SignedAttributes in a signerInfo MUST NOT include multiple instances of the "
            r0.<init>(r1)
            r0.append(r5)
            java.lang.String r5 = " attribute"
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r4.<init>(r5)
            throw r4
        L_0x008b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.cms.SignerInformation.getSingleValuedSignedAttribute(repack.org.bouncycastle.asn1.DERObjectIdentifier, java.lang.String):repack.org.bouncycastle.asn1.DERObject");
    }

    private Time getSigningTime() throws CMSException {
        DERObject singleValuedSignedAttribute = getSingleValuedSignedAttribute(CMSAttributes.signingTime, "signing-time");
        if (singleValuedSignedAttribute == null) {
            return null;
        }
        try {
            return Time.getInstance(singleValuedSignedAttribute);
        } catch (IllegalArgumentException unused) {
            throw new CMSException("signing-time attribute value not a valid 'Time' structure");
        }
    }

    public static SignerInformation replaceUnsignedAttributes(SignerInformation signerInformation, AttributeTable attributeTable) {
        SignerInfo signerInfo = signerInformation.info;
        return new SignerInformation(new SignerInfo(signerInfo.getSID(), signerInfo.getDigestAlgorithm(), signerInfo.getAuthenticatedAttributes(), signerInfo.getDigestEncryptionAlgorithm(), signerInfo.getEncryptedDigest(), attributeTable != null ? new DERSet(attributeTable.toASN1EncodableVector()) : null), signerInformation.contentType, signerInformation.content, (IntDigestCalculator) null, new DefaultSignatureAlgorithmIdentifierFinder());
    }

    public static SignerInformation addCounterSigners(SignerInformation signerInformation, SignerInformationStore signerInformationStore) {
        ASN1EncodableVector aSN1EncodableVector;
        SignerInfo signerInfo = signerInformation.info;
        AttributeTable unsignedAttributes = signerInformation.getUnsignedAttributes();
        if (unsignedAttributes != null) {
            aSN1EncodableVector = unsignedAttributes.toASN1EncodableVector();
        } else {
            aSN1EncodableVector = new ASN1EncodableVector();
        }
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        for (SignerInformation signerInfo2 : signerInformationStore.getSigners()) {
            aSN1EncodableVector2.add(signerInfo2.toSignerInfo());
        }
        aSN1EncodableVector.add(new Attribute(CMSAttributes.counterSignature, new DERSet(aSN1EncodableVector2)));
        return new SignerInformation(new SignerInfo(signerInfo.getSID(), signerInfo.getDigestAlgorithm(), signerInfo.getAuthenticatedAttributes(), signerInfo.getDigestEncryptionAlgorithm(), signerInfo.getEncryptedDigest(), new DERSet(aSN1EncodableVector)), signerInformation.contentType, signerInformation.content, (IntDigestCalculator) null, new DefaultSignatureAlgorithmIdentifierFinder());
    }
}
