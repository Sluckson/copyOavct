package repack.org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import repack.org.bouncycastle.asn1.x509.X509CertificateStructure;
import repack.org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import repack.org.bouncycastle.crypto.agreement.DHBasicAgreement;
import repack.org.bouncycastle.crypto.generators.DHBasicKeyPairGenerator;
import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import repack.org.bouncycastle.crypto.params.DHKeyGenerationParameters;
import repack.org.bouncycastle.crypto.params.DHParameters;
import repack.org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import repack.org.bouncycastle.crypto.params.DHPublicKeyParameters;
import repack.org.bouncycastle.crypto.util.PublicKeyFactory;
import repack.org.bouncycastle.util.BigIntegers;

class TlsDHKeyExchange implements TlsKeyExchange {
    protected static final BigInteger ONE = BigInteger.valueOf(1);
    protected static final BigInteger TWO = BigInteger.valueOf(2);
    protected TlsAgreementCredentials agreementCredentials;
    protected TlsClientContext context;
    protected DHPrivateKeyParameters dhAgreeClientPrivateKey = null;
    protected DHPublicKeyParameters dhAgreeServerPublicKey = null;
    protected int keyExchange;
    protected AsymmetricKeyParameter serverPublicKey = null;
    protected TlsSigner tlsSigner;

    public void skipServerKeyExchange() throws IOException {
    }

    TlsDHKeyExchange(TlsClientContext tlsClientContext, int i) {
        if (i == 3) {
            this.tlsSigner = new TlsDSSSigner();
        } else if (i == 5) {
            this.tlsSigner = new TlsRSASigner();
        } else if (i == 7 || i == 9) {
            this.tlsSigner = null;
        } else {
            throw new IllegalArgumentException("unsupported key exchange algorithm");
        }
        this.context = tlsClientContext;
        this.keyExchange = i;
    }

    public void skipServerCertificate() throws IOException {
        throw new TlsFatalAlert(10);
    }

    public void processServerCertificate(Certificate certificate) throws IOException {
        X509CertificateStructure x509CertificateStructure = certificate.certs[0];
        try {
            this.serverPublicKey = PublicKeyFactory.createKey(x509CertificateStructure.getSubjectPublicKeyInfo());
            TlsSigner tlsSigner2 = this.tlsSigner;
            if (tlsSigner2 == null) {
                try {
                    this.dhAgreeServerPublicKey = validateDHPublicKey((DHPublicKeyParameters) this.serverPublicKey);
                    TlsUtils.validateKeyUsage(x509CertificateStructure, 8);
                } catch (ClassCastException unused) {
                    throw new TlsFatalAlert(46);
                }
            } else if (tlsSigner2.isValidPublicKey(this.serverPublicKey)) {
                TlsUtils.validateKeyUsage(x509CertificateStructure, 128);
            } else {
                throw new TlsFatalAlert(46);
            }
        } catch (RuntimeException unused2) {
            throw new TlsFatalAlert(43);
        }
    }

    public void processServerKeyExchange(InputStream inputStream) throws IOException {
        throw new TlsFatalAlert(10);
    }

    public void validateCertificateRequest(CertificateRequest certificateRequest) throws IOException {
        short[] certificateTypes = certificateRequest.getCertificateTypes();
        int i = 0;
        while (i < certificateTypes.length) {
            short s = certificateTypes[i];
            if (s == 1 || s == 2 || s == 3 || s == 4 || s == 64) {
                i++;
            } else {
                throw new TlsFatalAlert(47);
            }
        }
    }

    public void skipClientCredentials() throws IOException {
        this.agreementCredentials = null;
    }

    public void processClientCredentials(TlsCredentials tlsCredentials) throws IOException {
        if (tlsCredentials instanceof TlsAgreementCredentials) {
            this.agreementCredentials = (TlsAgreementCredentials) tlsCredentials;
        } else if (!(tlsCredentials instanceof TlsSignerCredentials)) {
            throw new TlsFatalAlert(80);
        }
    }

    public void generateClientKeyExchange(OutputStream outputStream) throws IOException {
        if (this.agreementCredentials != null) {
            TlsUtils.writeUint24(0, outputStream);
        } else {
            generateEphemeralClientKeyExchange(this.dhAgreeServerPublicKey.getParameters(), outputStream);
        }
    }

    public byte[] generatePremasterSecret() throws IOException {
        TlsAgreementCredentials tlsAgreementCredentials = this.agreementCredentials;
        if (tlsAgreementCredentials != null) {
            return tlsAgreementCredentials.generateAgreement(this.dhAgreeServerPublicKey);
        }
        return calculateDHBasicAgreement(this.dhAgreeServerPublicKey, this.dhAgreeClientPrivateKey);
    }

    /* access modifiers changed from: protected */
    public boolean areCompatibleParameters(DHParameters dHParameters, DHParameters dHParameters2) {
        return dHParameters.getP().equals(dHParameters2.getP()) && dHParameters.getG().equals(dHParameters2.getG());
    }

    /* access modifiers changed from: protected */
    public byte[] calculateDHBasicAgreement(DHPublicKeyParameters dHPublicKeyParameters, DHPrivateKeyParameters dHPrivateKeyParameters) {
        DHBasicAgreement dHBasicAgreement = new DHBasicAgreement();
        dHBasicAgreement.init(this.dhAgreeClientPrivateKey);
        return BigIntegers.asUnsignedByteArray(dHBasicAgreement.calculateAgreement(this.dhAgreeServerPublicKey));
    }

    /* access modifiers changed from: protected */
    public AsymmetricCipherKeyPair generateDHKeyPair(DHParameters dHParameters) {
        DHBasicKeyPairGenerator dHBasicKeyPairGenerator = new DHBasicKeyPairGenerator();
        dHBasicKeyPairGenerator.init(new DHKeyGenerationParameters(this.context.getSecureRandom(), dHParameters));
        return dHBasicKeyPairGenerator.generateKeyPair();
    }

    /* access modifiers changed from: protected */
    public void generateEphemeralClientKeyExchange(DHParameters dHParameters, OutputStream outputStream) throws IOException {
        AsymmetricCipherKeyPair generateDHKeyPair = generateDHKeyPair(dHParameters);
        this.dhAgreeClientPrivateKey = (DHPrivateKeyParameters) generateDHKeyPair.getPrivate();
        byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(((DHPublicKeyParameters) generateDHKeyPair.getPublic()).getY());
        TlsUtils.writeUint24(asUnsignedByteArray.length + 2, outputStream);
        TlsUtils.writeOpaque16(asUnsignedByteArray, outputStream);
    }

    /* access modifiers changed from: protected */
    public DHPublicKeyParameters validateDHPublicKey(DHPublicKeyParameters dHPublicKeyParameters) throws IOException {
        BigInteger y = dHPublicKeyParameters.getY();
        DHParameters parameters = dHPublicKeyParameters.getParameters();
        BigInteger p = parameters.getP();
        BigInteger g = parameters.getG();
        if (!p.isProbablePrime(2)) {
            throw new TlsFatalAlert(47);
        } else if (g.compareTo(TWO) < 0 || g.compareTo(p.subtract(TWO)) > 0) {
            throw new TlsFatalAlert(47);
        } else if (y.compareTo(TWO) >= 0 && y.compareTo(p.subtract(ONE)) <= 0) {
            return dHPublicKeyParameters;
        } else {
            throw new TlsFatalAlert(47);
        }
    }
}
