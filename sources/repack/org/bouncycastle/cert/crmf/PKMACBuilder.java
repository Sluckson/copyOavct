package repack.org.bouncycastle.cert.crmf;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.cmp.CMPObjectIdentifiers;
import repack.org.bouncycastle.asn1.cmp.PBMParameter;
import repack.org.bouncycastle.asn1.iana.IANAObjectIdentifiers;
import repack.org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.operator.GenericKey;
import repack.org.bouncycastle.operator.MacCalculator;
import repack.org.bouncycastle.operator.RuntimeOperatorException;
import repack.org.bouncycastle.util.Strings;

public class PKMACBuilder {
    /* access modifiers changed from: private */
    public PKMACValuesCalculator calculator;
    private int iterationCount;
    private AlgorithmIdentifier mac;
    private int maxIterations;
    private AlgorithmIdentifier owf;
    private PBMParameter parameters;
    private SecureRandom random;
    private int saltLength;

    public PKMACBuilder(PKMACValuesCalculator pKMACValuesCalculator) {
        this(new AlgorithmIdentifier((DERObjectIdentifier) OIWObjectIdentifiers.idSHA1), 1000, new AlgorithmIdentifier(IANAObjectIdentifiers.hmacSHA1, DERNull.INSTANCE), pKMACValuesCalculator);
    }

    public PKMACBuilder(PKMACValuesCalculator pKMACValuesCalculator, int i) {
        this.saltLength = 20;
        this.maxIterations = i;
        this.calculator = pKMACValuesCalculator;
    }

    private PKMACBuilder(AlgorithmIdentifier algorithmIdentifier, int i, AlgorithmIdentifier algorithmIdentifier2, PKMACValuesCalculator pKMACValuesCalculator) {
        this.saltLength = 20;
        this.owf = algorithmIdentifier;
        this.iterationCount = i;
        this.mac = algorithmIdentifier2;
        this.calculator = pKMACValuesCalculator;
    }

    public PKMACBuilder setSaltLength(int i) {
        if (i >= 8) {
            this.saltLength = i;
            return this;
        }
        throw new IllegalArgumentException("salt length must be at least 8 bytes");
    }

    public PKMACBuilder setIterationCount(int i) {
        if (i >= 100) {
            checkIterationCountCeiling(i);
            this.iterationCount = i;
            return this;
        }
        throw new IllegalArgumentException("iteration count must be at least 100");
    }

    public PKMACBuilder setSecureRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }

    public PKMACBuilder setParameters(PBMParameter pBMParameter) {
        checkIterationCountCeiling(pBMParameter.getIterationCount().getValue().intValue());
        this.parameters = pBMParameter;
        return this;
    }

    public MacCalculator build(char[] cArr) throws CRMFException {
        PBMParameter pBMParameter = this.parameters;
        if (pBMParameter != null) {
            return genCalculator(pBMParameter, cArr);
        }
        byte[] bArr = new byte[this.saltLength];
        if (this.random == null) {
            this.random = new SecureRandom();
        }
        this.random.nextBytes(bArr);
        return genCalculator(new PBMParameter(bArr, this.owf, this.iterationCount, this.mac), cArr);
    }

    private void checkIterationCountCeiling(int i) {
        int i2 = this.maxIterations;
        if (i2 > 0 && i > i2) {
            throw new IllegalArgumentException("iteration count exceeds limit (" + i + " > " + this.maxIterations + ")");
        }
    }

    private MacCalculator genCalculator(final PBMParameter pBMParameter, char[] cArr) throws CRMFException {
        byte[] uTF8ByteArray = Strings.toUTF8ByteArray(cArr);
        byte[] octets = pBMParameter.getSalt().getOctets();
        final byte[] bArr = new byte[(uTF8ByteArray.length + octets.length)];
        System.arraycopy(uTF8ByteArray, 0, bArr, 0, uTF8ByteArray.length);
        System.arraycopy(octets, 0, bArr, uTF8ByteArray.length, octets.length);
        this.calculator.setup(pBMParameter.getOwf(), pBMParameter.getMac());
        int intValue = pBMParameter.getIterationCount().getValue().intValue();
        do {
            bArr = this.calculator.calculateDigest(bArr);
            intValue--;
        } while (intValue > 0);
        return new MacCalculator() {
            ByteArrayOutputStream bOut = new ByteArrayOutputStream();

            public AlgorithmIdentifier getAlgorithmIdentifier() {
                return new AlgorithmIdentifier(CMPObjectIdentifiers.passwordBasedMac, pBMParameter);
            }

            public GenericKey getKey() {
                return new GenericKey(bArr);
            }

            public OutputStream getOutputStream() {
                return this.bOut;
            }

            public byte[] getMac() {
                try {
                    return PKMACBuilder.this.calculator.calculateMac(bArr, this.bOut.toByteArray());
                } catch (CRMFException e) {
                    throw new RuntimeOperatorException("exception calculating mac: " + e.getMessage(), e);
                }
            }
        };
    }
}
