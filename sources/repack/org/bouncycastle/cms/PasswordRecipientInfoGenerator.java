package repack.org.bouncycastle.cms;

import java.security.SecureRandom;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.cms.PasswordRecipientInfo;
import repack.org.bouncycastle.asn1.cms.RecipientInfo;
import repack.org.bouncycastle.asn1.pkcs.PBKDF2Params;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.crypto.PBEParametersGenerator;
import repack.org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import repack.org.bouncycastle.crypto.params.KeyParameter;
import repack.org.bouncycastle.operator.GenericKey;

public abstract class PasswordRecipientInfoGenerator implements RecipientInfoGenerator {
    private int blockSize;
    private ASN1ObjectIdentifier kekAlgorithm;
    private AlgorithmIdentifier keyDerivationAlgorithm;
    private int keySize;
    private char[] password;
    private SecureRandom random;
    private int schemeID;

    /* access modifiers changed from: protected */
    public abstract byte[] generateEncryptedBytes(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, GenericKey genericKey) throws CMSException;

    protected PasswordRecipientInfoGenerator(ASN1ObjectIdentifier aSN1ObjectIdentifier, char[] cArr) {
        this(aSN1ObjectIdentifier, cArr, getKeySize(aSN1ObjectIdentifier), ((Integer) PasswordRecipientInformation.BLOCKSIZES.get(aSN1ObjectIdentifier)).intValue());
    }

    protected PasswordRecipientInfoGenerator(ASN1ObjectIdentifier aSN1ObjectIdentifier, char[] cArr, int i, int i2) {
        this.password = cArr;
        this.schemeID = 1;
        this.kekAlgorithm = aSN1ObjectIdentifier;
        this.keySize = i;
        this.blockSize = i2;
    }

    private static int getKeySize(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Integer num = (Integer) PasswordRecipientInformation.KEYSIZES.get(aSN1ObjectIdentifier);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("cannot find key size for algorithm: " + aSN1ObjectIdentifier);
    }

    public PasswordRecipientInfoGenerator setPasswordConversionScheme(int i) {
        this.schemeID = i;
        return this;
    }

    public PasswordRecipientInfoGenerator setSaltAndIterationCount(byte[] bArr, int i) {
        this.keyDerivationAlgorithm = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBKDF2, new PBKDF2Params(bArr, i));
        return this;
    }

    public PasswordRecipientInfoGenerator setSecureRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }

    public RecipientInfo generate(GenericKey genericKey) throws CMSException {
        byte[] bArr;
        byte[] bArr2 = new byte[this.blockSize];
        if (this.random == null) {
            this.random = new SecureRandom();
        }
        this.random.nextBytes(bArr2);
        if (this.keyDerivationAlgorithm == null) {
            byte[] bArr3 = new byte[20];
            this.random.nextBytes(bArr3);
            this.keyDerivationAlgorithm = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBKDF2, new PBKDF2Params(bArr3, 1024));
        }
        PBKDF2Params instance = PBKDF2Params.getInstance(this.keyDerivationAlgorithm.getParameters());
        if (this.schemeID == 0) {
            PKCS5S2ParametersGenerator pKCS5S2ParametersGenerator = new PKCS5S2ParametersGenerator();
            pKCS5S2ParametersGenerator.init(PBEParametersGenerator.PKCS5PasswordToBytes(this.password), instance.getSalt(), instance.getIterationCount().intValue());
            bArr = ((KeyParameter) pKCS5S2ParametersGenerator.generateDerivedParameters(this.keySize)).getKey();
        } else {
            PKCS5S2ParametersGenerator pKCS5S2ParametersGenerator2 = new PKCS5S2ParametersGenerator();
            pKCS5S2ParametersGenerator2.init(PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(this.password), instance.getSalt(), instance.getIterationCount().intValue());
            bArr = ((KeyParameter) pKCS5S2ParametersGenerator2.generateDerivedParameters(this.keySize)).getKey();
        }
        DEROctetString dEROctetString = new DEROctetString(generateEncryptedBytes(new AlgorithmIdentifier(this.kekAlgorithm, new DEROctetString(bArr2)), bArr, genericKey));
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.kekAlgorithm);
        aSN1EncodableVector.add(new DEROctetString(bArr2));
        return new RecipientInfo(new PasswordRecipientInfo(this.keyDerivationAlgorithm, new AlgorithmIdentifier(PKCSObjectIdentifiers.id_alg_PWRI_KEK, new DERSequence(aSN1EncodableVector)), dEROctetString));
    }
}
