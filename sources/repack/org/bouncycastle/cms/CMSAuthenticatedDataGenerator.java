package repack.org.bouncycastle.cms;

import java.io.ByteArrayOutputStream;
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
import java.util.Map;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Set;
import repack.org.bouncycastle.asn1.BERConstructedOctetString;
import repack.org.bouncycastle.asn1.BERSet;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DERSet;
import repack.org.bouncycastle.asn1.cms.AuthenticatedData;
import repack.org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import repack.org.bouncycastle.asn1.cms.ContentInfo;
import repack.org.bouncycastle.asn1.cms.OriginatorInfo;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.operator.DigestCalculator;
import repack.org.bouncycastle.operator.DigestCalculatorProvider;
import repack.org.bouncycastle.operator.GenericKey;
import repack.org.bouncycastle.operator.MacCalculator;
import repack.org.bouncycastle.operator.OperatorCreationException;
import repack.org.bouncycastle.util.p072io.TeeOutputStream;

public class CMSAuthenticatedDataGenerator extends CMSAuthenticatedGenerator {
    public CMSAuthenticatedDataGenerator() {
    }

    public CMSAuthenticatedData generate(CMSTypedData cMSTypedData, MacCalculator macCalculator) throws CMSException {
        return generate(cMSTypedData, macCalculator, (DigestCalculator) null);
    }

    public CMSAuthenticatedData generate(CMSTypedData cMSTypedData, MacCalculator macCalculator, DigestCalculator digestCalculator) throws CMSException {
        AuthenticatedData authenticatedData;
        CMSTypedData cMSTypedData2 = cMSTypedData;
        final DigestCalculator digestCalculator2 = digestCalculator;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (RecipientInfoGenerator generate : this.recipientInfoGenerators) {
            aSN1EncodableVector.add(generate.generate(macCalculator.getKey()));
        }
        BERSet bERSet = null;
        if (digestCalculator2 != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                TeeOutputStream teeOutputStream = new TeeOutputStream(digestCalculator.getOutputStream(), byteArrayOutputStream);
                cMSTypedData2.write(teeOutputStream);
                teeOutputStream.close();
                BERConstructedOctetString bERConstructedOctetString = new BERConstructedOctetString(byteArrayOutputStream.toByteArray());
                Map baseParameters = getBaseParameters(cMSTypedData.getContentType(), digestCalculator.getAlgorithmIdentifier(), digestCalculator.getDigest());
                if (this.authGen == null) {
                    this.authGen = new DefaultAuthenticatedAttributeTableGenerator();
                }
                DERSet dERSet = new DERSet(this.authGen.getAttributes(Collections.unmodifiableMap(baseParameters)).toASN1EncodableVector());
                try {
                    OutputStream outputStream = macCalculator.getOutputStream();
                    outputStream.write(dERSet.getDEREncoded());
                    outputStream.close();
                    DEROctetString dEROctetString = new DEROctetString(macCalculator.getMac());
                    if (this.unauthGen != null) {
                        bERSet = new BERSet(this.unauthGen.getAttributes(Collections.unmodifiableMap(baseParameters)).toASN1EncodableVector());
                    }
                    ContentInfo contentInfo = new ContentInfo(CMSObjectIdentifiers.data, bERConstructedOctetString);
                    authenticatedData = new AuthenticatedData((OriginatorInfo) null, new DERSet(aSN1EncodableVector), macCalculator.getAlgorithmIdentifier(), digestCalculator.getAlgorithmIdentifier(), contentInfo, dERSet, dEROctetString, bERSet);
                } catch (IOException e) {
                    throw new CMSException("exception decoding algorithm parameters.", e);
                }
            } catch (IOException e2) {
                throw new CMSException("unable to perform digest calculation: " + e2.getMessage(), e2);
            }
        } else {
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                TeeOutputStream teeOutputStream2 = new TeeOutputStream(byteArrayOutputStream2, macCalculator.getOutputStream());
                cMSTypedData2.write(teeOutputStream2);
                teeOutputStream2.close();
                BERConstructedOctetString bERConstructedOctetString2 = new BERConstructedOctetString(byteArrayOutputStream2.toByteArray());
                DEROctetString dEROctetString2 = new DEROctetString(macCalculator.getMac());
                if (this.unauthGen != null) {
                    bERSet = new BERSet(this.unauthGen.getAttributes(Collections.EMPTY_MAP).toASN1EncodableVector());
                }
                ContentInfo contentInfo2 = new ContentInfo(CMSObjectIdentifiers.data, bERConstructedOctetString2);
                authenticatedData = new AuthenticatedData((OriginatorInfo) null, new DERSet(aSN1EncodableVector), macCalculator.getAlgorithmIdentifier(), (AlgorithmIdentifier) null, contentInfo2, (ASN1Set) null, dEROctetString2, bERSet);
            } catch (IOException e3) {
                throw new CMSException("exception decoding algorithm parameters.", e3);
            }
        }
        return new CMSAuthenticatedData(new ContentInfo(CMSObjectIdentifiers.authenticatedData, authenticatedData), (DigestCalculatorProvider) new DigestCalculatorProvider() {
            public DigestCalculator get(AlgorithmIdentifier algorithmIdentifier) throws OperatorCreationException {
                return digestCalculator2;
            }
        });
    }

    public CMSAuthenticatedDataGenerator(SecureRandom secureRandom) {
        super(secureRandom);
    }

    private CMSAuthenticatedData generate(CMSProcessable cMSProcessable, String str, KeyGenerator keyGenerator, Provider provider) throws NoSuchAlgorithmException, CMSException {
        String str2 = str;
        Provider provider2 = keyGenerator.getProvider();
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        try {
            Mac mac = CMSEnvelopedHelper.INSTANCE.getMac(str2, provider2);
            SecretKey generateKey = keyGenerator.generateKey();
            AlgorithmParameterSpec generateParameterSpec = generateParameterSpec(str2, generateKey, provider2);
            mac.init(generateKey, generateParameterSpec);
            AlgorithmIdentifier algorithmIdentifier = getAlgorithmIdentifier(str2, generateParameterSpec, provider2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            TeeOutputStream teeOutputStream = new TeeOutputStream(byteArrayOutputStream, new MacOutputStream(mac));
            cMSProcessable.write(teeOutputStream);
            teeOutputStream.close();
            byteArrayOutputStream.close();
            BERConstructedOctetString bERConstructedOctetString = new BERConstructedOctetString(byteArrayOutputStream.toByteArray());
            DEROctetString dEROctetString = new DEROctetString(mac.doFinal());
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
            return new CMSAuthenticatedData(new ContentInfo(CMSObjectIdentifiers.authenticatedData, new AuthenticatedData((OriginatorInfo) null, new DERSet(aSN1EncodableVector), algorithmIdentifier, (AlgorithmIdentifier) null, new ContentInfo(CMSObjectIdentifiers.data, bERConstructedOctetString), (ASN1Set) null, dEROctetString, (ASN1Set) null)));
        } catch (InvalidKeyException e3) {
            throw new CMSException("key invalid in message.", e3);
        } catch (NoSuchPaddingException e4) {
            throw new CMSException("required padding not supported.", e4);
        } catch (InvalidAlgorithmParameterException e5) {
            throw new CMSException("algorithm parameters invalid.", e5);
        } catch (IOException e6) {
            throw new CMSException("exception decoding algorithm parameters.", e6);
        } catch (InvalidParameterSpecException e7) {
            throw new CMSException("exception setting up parameters.", e7);
        }
    }

    public CMSAuthenticatedData generate(CMSProcessable cMSProcessable, String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, CMSException {
        return generate(cMSProcessable, str, CMSUtils.getProvider(str2));
    }

    public CMSAuthenticatedData generate(CMSProcessable cMSProcessable, String str, Provider provider) throws NoSuchAlgorithmException, CMSException {
        KeyGenerator createSymmetricKeyGenerator = CMSEnvelopedHelper.INSTANCE.createSymmetricKeyGenerator(str, provider);
        createSymmetricKeyGenerator.init(this.rand);
        return generate(cMSProcessable, str, createSymmetricKeyGenerator, provider);
    }
}
