package repack.org.bouncycastle.cms;

import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.BERSequenceGenerator;
import repack.org.bouncycastle.asn1.BERSet;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DERSet;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.cms.AuthenticatedData;
import repack.org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import repack.org.bouncycastle.asn1.cms.OriginatorInfo;
import repack.org.bouncycastle.operator.DigestCalculator;
import repack.org.bouncycastle.operator.GenericKey;
import repack.org.bouncycastle.operator.MacCalculator;
import repack.org.bouncycastle.util.p072io.TeeOutputStream;

public class CMSAuthenticatedDataStreamGenerator extends CMSAuthenticatedGenerator {
    private boolean berEncodeRecipientSet;
    private int bufferSize;
    private MacCalculator macCalculator;

    public CMSAuthenticatedDataStreamGenerator() {
    }

    public void setBufferSize(int i) {
        this.bufferSize = i;
    }

    public void setBEREncodeRecipients(boolean z) {
        this.berEncodeRecipientSet = z;
    }

    public OutputStream open(OutputStream outputStream, MacCalculator macCalculator2) throws CMSException {
        return open(CMSObjectIdentifiers.data, outputStream, macCalculator2);
    }

    public OutputStream open(OutputStream outputStream, MacCalculator macCalculator2, DigestCalculator digestCalculator) throws CMSException {
        return open(CMSObjectIdentifiers.data, outputStream, macCalculator2, digestCalculator);
    }

    public OutputStream open(ASN1ObjectIdentifier aSN1ObjectIdentifier, OutputStream outputStream, MacCalculator macCalculator2) throws CMSException {
        return open(aSN1ObjectIdentifier, outputStream, macCalculator2, (DigestCalculator) null);
    }

    public OutputStream open(ASN1ObjectIdentifier aSN1ObjectIdentifier, OutputStream outputStream, MacCalculator macCalculator2, DigestCalculator digestCalculator) throws CMSException {
        TeeOutputStream teeOutputStream;
        this.macCalculator = macCalculator2;
        try {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            for (RecipientInfoGenerator generate : this.recipientInfoGenerators) {
                ASN1ObjectIdentifier aSN1ObjectIdentifier2 = aSN1ObjectIdentifier;
                OutputStream outputStream2 = outputStream;
                aSN1EncodableVector.add(generate.generate(macCalculator2.getKey()));
            }
            OutputStream outputStream3 = outputStream;
            BERSequenceGenerator bERSequenceGenerator = new BERSequenceGenerator(outputStream);
            bERSequenceGenerator.addObject(CMSObjectIdentifiers.authenticatedData);
            BERSequenceGenerator bERSequenceGenerator2 = new BERSequenceGenerator(bERSequenceGenerator.getRawOutputStream(), 0, true);
            bERSequenceGenerator2.addObject(new DERInteger(AuthenticatedData.calculateVersion((OriginatorInfo) null)));
            if (this.berEncodeRecipientSet) {
                bERSequenceGenerator2.getRawOutputStream().write(new BERSet(aSN1EncodableVector).getEncoded());
            } else {
                bERSequenceGenerator2.getRawOutputStream().write(new DERSet(aSN1EncodableVector).getEncoded());
            }
            bERSequenceGenerator2.getRawOutputStream().write(macCalculator2.getAlgorithmIdentifier().getEncoded());
            if (digestCalculator != null) {
                bERSequenceGenerator2.addObject(new DERTaggedObject(false, 1, digestCalculator.getAlgorithmIdentifier()));
            }
            BERSequenceGenerator bERSequenceGenerator3 = new BERSequenceGenerator(bERSequenceGenerator2.getRawOutputStream());
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = aSN1ObjectIdentifier;
            bERSequenceGenerator3.addObject(aSN1ObjectIdentifier);
            OutputStream createBEROctetOutputStream = CMSUtils.createBEROctetOutputStream(bERSequenceGenerator3.getRawOutputStream(), 0, false, this.bufferSize);
            if (digestCalculator != null) {
                teeOutputStream = new TeeOutputStream(createBEROctetOutputStream, digestCalculator.getOutputStream());
            } else {
                teeOutputStream = new TeeOutputStream(createBEROctetOutputStream, macCalculator2.getOutputStream());
            }
            return new CmsAuthenticatedDataOutputStream(macCalculator2, digestCalculator, aSN1ObjectIdentifier, teeOutputStream, bERSequenceGenerator, bERSequenceGenerator2, bERSequenceGenerator3);
        } catch (IOException e) {
            throw new CMSException("exception decoding algorithm parameters.", e);
        }
    }

    private class CmsAuthenticatedDataOutputStream extends OutputStream {
        private BERSequenceGenerator cGen;
        private ASN1ObjectIdentifier contentType;
        private OutputStream dataStream;
        private DigestCalculator digestCalculator;
        private BERSequenceGenerator eiGen;
        private BERSequenceGenerator envGen;
        private MacCalculator macCalculator;

        public CmsAuthenticatedDataOutputStream(MacCalculator macCalculator2, DigestCalculator digestCalculator2, ASN1ObjectIdentifier aSN1ObjectIdentifier, OutputStream outputStream, BERSequenceGenerator bERSequenceGenerator, BERSequenceGenerator bERSequenceGenerator2, BERSequenceGenerator bERSequenceGenerator3) {
            this.macCalculator = macCalculator2;
            this.digestCalculator = digestCalculator2;
            this.contentType = aSN1ObjectIdentifier;
            this.dataStream = outputStream;
            this.cGen = bERSequenceGenerator;
            this.envGen = bERSequenceGenerator2;
            this.eiGen = bERSequenceGenerator3;
        }

        public void write(int i) throws IOException {
            this.dataStream.write(i);
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.dataStream.write(bArr, i, i2);
        }

        public void write(byte[] bArr) throws IOException {
            this.dataStream.write(bArr);
        }

        public void close() throws IOException {
            Map map;
            this.dataStream.close();
            this.eiGen.close();
            DigestCalculator digestCalculator2 = this.digestCalculator;
            if (digestCalculator2 != null) {
                map = Collections.unmodifiableMap(CMSAuthenticatedDataStreamGenerator.this.getBaseParameters(this.contentType, digestCalculator2.getAlgorithmIdentifier(), this.digestCalculator.getDigest()));
                if (CMSAuthenticatedDataStreamGenerator.this.authGen == null) {
                    CMSAuthenticatedDataStreamGenerator.this.authGen = new DefaultAuthenticatedAttributeTableGenerator();
                }
                DERSet dERSet = new DERSet(CMSAuthenticatedDataStreamGenerator.this.authGen.getAttributes(map).toASN1EncodableVector());
                OutputStream outputStream = this.macCalculator.getOutputStream();
                outputStream.write(dERSet.getDEREncoded());
                outputStream.close();
                this.envGen.addObject(new DERTaggedObject(false, 2, dERSet));
            } else {
                map = Collections.unmodifiableMap(new HashMap());
            }
            this.envGen.addObject(new DEROctetString(this.macCalculator.getMac()));
            if (CMSAuthenticatedDataStreamGenerator.this.unauthGen != null) {
                this.envGen.addObject(new DERTaggedObject(false, 3, new BERSet(CMSAuthenticatedDataStreamGenerator.this.unauthGen.getAttributes(map).toASN1EncodableVector())));
            }
            this.envGen.close();
            this.cGen.close();
        }
    }

    public CMSAuthenticatedDataStreamGenerator(SecureRandom secureRandom) {
        super(secureRandom);
    }

    private class OldCmsAuthenticatedDataOutputStream extends OutputStream {
        private BERSequenceGenerator cGen;
        private OutputStream dataStream;
        private BERSequenceGenerator eiGen;
        private BERSequenceGenerator envGen;
        private Mac mac;

        public OldCmsAuthenticatedDataOutputStream(OutputStream outputStream, Mac mac2, BERSequenceGenerator bERSequenceGenerator, BERSequenceGenerator bERSequenceGenerator2, BERSequenceGenerator bERSequenceGenerator3) {
            this.dataStream = outputStream;
            this.mac = mac2;
            this.cGen = bERSequenceGenerator;
            this.envGen = bERSequenceGenerator2;
            this.eiGen = bERSequenceGenerator3;
        }

        public void write(int i) throws IOException {
            this.dataStream.write(i);
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.dataStream.write(bArr, i, i2);
        }

        public void write(byte[] bArr) throws IOException {
            this.dataStream.write(bArr);
        }

        public void close() throws IOException {
            this.dataStream.close();
            this.eiGen.close();
            this.envGen.addObject(new DEROctetString(this.mac.doFinal()));
            this.envGen.close();
            this.cGen.close();
        }
    }

    private OutputStream open(OutputStream outputStream, String str, KeyGenerator keyGenerator, Provider provider) throws NoSuchAlgorithmException, CMSException {
        Provider provider2 = keyGenerator.getProvider();
        SecretKey generateKey = keyGenerator.generateKey();
        AlgorithmParameterSpec generateParameterSpec = generateParameterSpec(str, generateKey, provider2);
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (IntRecipientInfoGenerator generate : this.oldRecipientInfoGenerators) {
            try {
                aSN1EncodableVector.add(generate.generate(generateKey, this.rand, provider));
            } catch (InvalidKeyException e) {
                throw new CMSException("key inappropriate for algorithm.", e);
            } catch (GeneralSecurityException e2) {
                throw new CMSException("error making encrypted content.", e2);
            }
        }
        for (RecipientInfoGenerator generate2 : this.recipientInfoGenerators) {
            aSN1EncodableVector.add(generate2.generate(new GenericKey(generateKey)));
        }
        return open(outputStream, str, generateKey, generateParameterSpec, aSN1EncodableVector, provider2);
    }

    /* access modifiers changed from: protected */
    public OutputStream open(OutputStream outputStream, String str, SecretKey secretKey, AlgorithmParameterSpec algorithmParameterSpec, ASN1EncodableVector aSN1EncodableVector, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, CMSException {
        return open(outputStream, str, secretKey, algorithmParameterSpec, aSN1EncodableVector, CMSUtils.getProvider(str2));
    }

    /* access modifiers changed from: protected */
    public OutputStream open(OutputStream outputStream, String str, SecretKey secretKey, AlgorithmParameterSpec algorithmParameterSpec, ASN1EncodableVector aSN1EncodableVector, Provider provider) throws NoSuchAlgorithmException, CMSException {
        try {
            BERSequenceGenerator bERSequenceGenerator = new BERSequenceGenerator(outputStream);
            bERSequenceGenerator.addObject(CMSObjectIdentifiers.authenticatedData);
            BERSequenceGenerator bERSequenceGenerator2 = new BERSequenceGenerator(bERSequenceGenerator.getRawOutputStream(), 0, true);
            bERSequenceGenerator2.addObject(new DERInteger(AuthenticatedData.calculateVersion((OriginatorInfo) null)));
            if (this.berEncodeRecipientSet) {
                bERSequenceGenerator2.getRawOutputStream().write(new BERSet(aSN1EncodableVector).getEncoded());
            } else {
                bERSequenceGenerator2.getRawOutputStream().write(new DERSet(aSN1EncodableVector).getEncoded());
            }
            Mac mac = CMSEnvelopedHelper.INSTANCE.getMac(str, provider);
            mac.init(secretKey, algorithmParameterSpec);
            bERSequenceGenerator2.getRawOutputStream().write(getAlgorithmIdentifier(str, algorithmParameterSpec, provider).getEncoded());
            BERSequenceGenerator bERSequenceGenerator3 = new BERSequenceGenerator(bERSequenceGenerator2.getRawOutputStream());
            bERSequenceGenerator3.addObject(CMSObjectIdentifiers.data);
            return new OldCmsAuthenticatedDataOutputStream(new TeeOutputStream(CMSUtils.createBEROctetOutputStream(bERSequenceGenerator3.getRawOutputStream(), 0, false, this.bufferSize), new MacOutputStream(mac)), mac, bERSequenceGenerator, bERSequenceGenerator2, bERSequenceGenerator3);
        } catch (InvalidKeyException e) {
            throw new CMSException("key invalid in message.", e);
        } catch (NoSuchPaddingException e2) {
            throw new CMSException("required padding not supported.", e2);
        } catch (InvalidAlgorithmParameterException e3) {
            throw new CMSException("algorithm parameter invalid.", e3);
        } catch (InvalidParameterSpecException e4) {
            throw new CMSException("algorithm parameter spec invalid.", e4);
        } catch (IOException e5) {
            throw new CMSException("exception decoding algorithm parameters.", e5);
        }
    }

    public OutputStream open(OutputStream outputStream, String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, CMSException, IOException {
        return open(outputStream, str, CMSUtils.getProvider(str2));
    }

    public OutputStream open(OutputStream outputStream, String str, Provider provider) throws NoSuchAlgorithmException, CMSException, IOException {
        KeyGenerator createSymmetricKeyGenerator = CMSEnvelopedHelper.INSTANCE.createSymmetricKeyGenerator(str, provider);
        createSymmetricKeyGenerator.init(this.rand);
        return open(outputStream, str, createSymmetricKeyGenerator, provider);
    }

    public OutputStream open(OutputStream outputStream, String str, int i, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, CMSException, IOException {
        return open(outputStream, str, i, CMSUtils.getProvider(str2));
    }

    public OutputStream open(OutputStream outputStream, String str, int i, Provider provider) throws NoSuchAlgorithmException, CMSException, IOException {
        KeyGenerator createSymmetricKeyGenerator = CMSEnvelopedHelper.INSTANCE.createSymmetricKeyGenerator(str, provider);
        createSymmetricKeyGenerator.init(i, this.rand);
        return open(outputStream, str, createSymmetricKeyGenerator, provider);
    }
}
