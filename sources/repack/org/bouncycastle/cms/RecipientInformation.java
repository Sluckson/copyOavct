package repack.org.bouncycastle.cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.cms.CMSEnvelopedHelper;
import repack.org.bouncycastle.util.p072io.Streams;

public abstract class RecipientInformation {
    private AuthAttributesProvider additionalData;
    protected AlgorithmIdentifier keyEncAlg;
    protected AlgorithmIdentifier messageAlgorithm;
    private RecipientOperator operator;
    private byte[] resultMac;
    protected RecipientId rid;
    private CMSSecureReadable secureReadable;

    public abstract CMSTypedStream getContentStream(Key key, Provider provider) throws CMSException;

    /* access modifiers changed from: protected */
    public abstract RecipientOperator getRecipientOperator(Recipient recipient) throws CMSException, IOException;

    RecipientInformation(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, CMSSecureReadable cMSSecureReadable, AuthAttributesProvider authAttributesProvider) {
        this.keyEncAlg = algorithmIdentifier;
        this.messageAlgorithm = algorithmIdentifier2;
        this.secureReadable = cMSSecureReadable;
        this.additionalData = authAttributesProvider;
    }

    /* access modifiers changed from: package-private */
    public String getContentAlgorithmName() {
        return CMSEnvelopedHelper.INSTANCE.getSymmetricCipherName(this.secureReadable.getAlgorithm().getObjectId().getId());
    }

    public RecipientId getRID() {
        return this.rid;
    }

    private byte[] encodeObj(DEREncodable dEREncodable) throws IOException {
        if (dEREncodable != null) {
            return dEREncodable.getDERObject().getEncoded();
        }
        return null;
    }

    public String getKeyEncryptionAlgOID() {
        return this.keyEncAlg.getObjectId().getId();
    }

    public byte[] getKeyEncryptionAlgParams() {
        try {
            return encodeObj(this.keyEncAlg.getParameters());
        } catch (Exception e) {
            throw new RuntimeException("exception getting encryption parameters " + e);
        }
    }

    public AlgorithmParameters getKeyEncryptionAlgorithmParameters(String str) throws CMSException, NoSuchProviderException {
        return getKeyEncryptionAlgorithmParameters(CMSUtils.getProvider(str));
    }

    public AlgorithmParameters getKeyEncryptionAlgorithmParameters(Provider provider) throws CMSException {
        try {
            byte[] encodeObj = encodeObj(this.keyEncAlg.getParameters());
            if (encodeObj == null) {
                return null;
            }
            AlgorithmParameters createAlgorithmParameters = CMSEnvelopedHelper.INSTANCE.createAlgorithmParameters(getKeyEncryptionAlgOID(), provider);
            createAlgorithmParameters.init(encodeObj, "ASN.1");
            return createAlgorithmParameters;
        } catch (NoSuchAlgorithmException e) {
            throw new CMSException("can't find parameters for algorithm", e);
        } catch (IOException e2) {
            throw new CMSException("can't find parse parameters", e2);
        }
    }

    /* access modifiers changed from: protected */
    public CMSTypedStream getContentFromSessionKey(Key key, Provider provider) throws CMSException {
        try {
            return new CMSTypedStream(this.secureReadable.getReadable((SecretKey) key, provider).getInputStream());
        } catch (IOException e) {
            throw new CMSException("error getting .", e);
        }
    }

    public byte[] getContent(Key key, String str) throws CMSException, NoSuchProviderException {
        return getContent(key, CMSUtils.getProvider(str));
    }

    public byte[] getContent(Key key, Provider provider) throws CMSException {
        try {
            return CMSUtils.streamToByteArray(getContentStream(key, provider).getContentStream());
        } catch (IOException e) {
            throw new RuntimeException("unable to parse internal stream: " + e);
        }
    }

    public byte[] getContentDigest() {
        CMSSecureReadable cMSSecureReadable = this.secureReadable;
        if (cMSSecureReadable instanceof CMSEnvelopedHelper.CMSDigestAuthenticatedSecureReadable) {
            return ((CMSEnvelopedHelper.CMSDigestAuthenticatedSecureReadable) cMSSecureReadable).getDigest();
        }
        return null;
    }

    public byte[] getMac() {
        if (this.resultMac == null) {
            RecipientOperator recipientOperator = this.operator;
            if (recipientOperator == null) {
                Object cryptoObject = this.secureReadable.getCryptoObject();
                if (cryptoObject instanceof Mac) {
                    this.resultMac = ((Mac) cryptoObject).doFinal();
                }
            } else if (recipientOperator.isMacBased()) {
                AuthAttributesProvider authAttributesProvider = this.additionalData;
                if (authAttributesProvider != null) {
                    try {
                        Streams.drain(this.operator.getInputStream(new ByteArrayInputStream(authAttributesProvider.getAuthAttributes().getDEREncoded())));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                this.resultMac = this.operator.getMac();
            }
        }
        return this.resultMac;
    }

    public byte[] getContent(Recipient recipient) throws CMSException {
        try {
            return CMSUtils.streamToByteArray(getContentStream(recipient).getContentStream());
        } catch (IOException e) {
            throw new CMSException("unable to parse internal stream: " + e.getMessage(), e);
        }
    }

    public CMSTypedStream getContentStream(Key key, String str) throws CMSException, NoSuchProviderException {
        return getContentStream(key, CMSUtils.getProvider(str));
    }

    public CMSTypedStream getContentStream(Recipient recipient) throws CMSException, IOException {
        this.operator = getRecipientOperator(recipient);
        if (this.additionalData != null) {
            return new CMSTypedStream(this.secureReadable.getInputStream());
        }
        return new CMSTypedStream(this.operator.getInputStream(this.secureReadable.getInputStream()));
    }
}
