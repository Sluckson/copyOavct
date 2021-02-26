package repack.org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import repack.org.bouncycastle.asn1.x509.X509CertificateStructure;
import repack.org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import repack.org.bouncycastle.crypto.agreement.ECDHBasicAgreement;
import repack.org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import repack.org.bouncycastle.crypto.params.ECDomainParameters;
import repack.org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import repack.org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import repack.org.bouncycastle.crypto.params.ECPublicKeyParameters;
import repack.org.bouncycastle.crypto.util.PublicKeyFactory;
import repack.org.bouncycastle.util.BigIntegers;

class TlsECDHKeyExchange implements TlsKeyExchange {
    protected TlsAgreementCredentials agreementCredentials;
    protected TlsClientContext context;
    protected ECPrivateKeyParameters ecAgreeClientPrivateKey = null;
    protected ECPublicKeyParameters ecAgreeServerPublicKey;
    protected int keyExchange;
    protected AsymmetricKeyParameter serverPublicKey;
    protected TlsSigner tlsSigner;

    public void skipServerKeyExchange() throws IOException {
    }

    /* access modifiers changed from: protected */
    public ECPublicKeyParameters validateECPublicKey(ECPublicKeyParameters eCPublicKeyParameters) throws IOException {
        return eCPublicKeyParameters;
    }

    TlsECDHKeyExchange(TlsClientContext tlsClientContext, int i) {
        switch (i) {
            case 16:
            case 18:
                this.tlsSigner = null;
                break;
            case 17:
                this.tlsSigner = new TlsECDSASigner();
                break;
            case 19:
                this.tlsSigner = new TlsRSASigner();
                break;
            default:
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
                    this.ecAgreeServerPublicKey = validateECPublicKey((ECPublicKeyParameters) this.serverPublicKey);
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
        for (short s : certificateTypes) {
            if (!(s == 1 || s == 2)) {
                switch (s) {
                    case 64:
                    case 65:
                    case 66:
                        break;
                    default:
                        throw new TlsFatalAlert(47);
                }
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
            generateEphemeralClientKeyExchange(this.ecAgreeServerPublicKey.getParameters(), outputStream);
        }
    }

    public byte[] generatePremasterSecret() throws IOException {
        TlsAgreementCredentials tlsAgreementCredentials = this.agreementCredentials;
        if (tlsAgreementCredentials != null) {
            return tlsAgreementCredentials.generateAgreement(this.ecAgreeServerPublicKey);
        }
        return calculateECDHBasicAgreement(this.ecAgreeServerPublicKey, this.ecAgreeClientPrivateKey);
    }

    /* access modifiers changed from: protected */
    public boolean areOnSameCurve(ECDomainParameters eCDomainParameters, ECDomainParameters eCDomainParameters2) {
        return eCDomainParameters.getCurve().equals(eCDomainParameters2.getCurve()) && eCDomainParameters.getG().equals(eCDomainParameters2.getG()) && eCDomainParameters.getN().equals(eCDomainParameters2.getN()) && eCDomainParameters.getH().equals(eCDomainParameters2.getH());
    }

    /* access modifiers changed from: protected */
    public byte[] externalizeKey(ECPublicKeyParameters eCPublicKeyParameters) throws IOException {
        return eCPublicKeyParameters.getQ().getEncoded();
    }

    /* access modifiers changed from: protected */
    public AsymmetricCipherKeyPair generateECKeyPair(ECDomainParameters eCDomainParameters) {
        ECKeyPairGenerator eCKeyPairGenerator = new ECKeyPairGenerator();
        eCKeyPairGenerator.init(new ECKeyGenerationParameters(eCDomainParameters, this.context.getSecureRandom()));
        return eCKeyPairGenerator.generateKeyPair();
    }

    /* access modifiers changed from: protected */
    public void generateEphemeralClientKeyExchange(ECDomainParameters eCDomainParameters, OutputStream outputStream) throws IOException {
        AsymmetricCipherKeyPair generateECKeyPair = generateECKeyPair(eCDomainParameters);
        this.ecAgreeClientPrivateKey = (ECPrivateKeyParameters) generateECKeyPair.getPrivate();
        byte[] externalizeKey = externalizeKey((ECPublicKeyParameters) generateECKeyPair.getPublic());
        TlsUtils.writeUint24(externalizeKey.length + 1, outputStream);
        TlsUtils.writeOpaque8(externalizeKey, outputStream);
    }

    /* access modifiers changed from: protected */
    public byte[] calculateECDHBasicAgreement(ECPublicKeyParameters eCPublicKeyParameters, ECPrivateKeyParameters eCPrivateKeyParameters) {
        ECDHBasicAgreement eCDHBasicAgreement = new ECDHBasicAgreement();
        eCDHBasicAgreement.init(eCPrivateKeyParameters);
        return BigIntegers.asUnsignedByteArray(eCDHBasicAgreement.calculateAgreement(eCPublicKeyParameters));
    }
}
