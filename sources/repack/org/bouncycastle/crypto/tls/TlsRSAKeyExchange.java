package repack.org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import repack.org.bouncycastle.asn1.x509.X509CertificateStructure;
import repack.org.bouncycastle.crypto.InvalidCipherTextException;
import repack.org.bouncycastle.crypto.encodings.PKCS1Encoding;
import repack.org.bouncycastle.crypto.engines.RSABlindedEngine;
import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import repack.org.bouncycastle.crypto.params.ParametersWithRandom;
import repack.org.bouncycastle.crypto.params.RSAKeyParameters;
import repack.org.bouncycastle.crypto.util.PublicKeyFactory;

class TlsRSAKeyExchange implements TlsKeyExchange {
    protected TlsClientContext context;
    protected byte[] premasterSecret;
    protected RSAKeyParameters rsaServerPublicKey = null;
    protected AsymmetricKeyParameter serverPublicKey = null;

    public void skipClientCredentials() throws IOException {
    }

    public void skipServerKeyExchange() throws IOException {
    }

    TlsRSAKeyExchange(TlsClientContext tlsClientContext) {
        this.context = tlsClientContext;
    }

    public void skipServerCertificate() throws IOException {
        throw new TlsFatalAlert(10);
    }

    public void processServerCertificate(Certificate certificate) throws IOException {
        X509CertificateStructure x509CertificateStructure = certificate.certs[0];
        try {
            this.serverPublicKey = PublicKeyFactory.createKey(x509CertificateStructure.getSubjectPublicKeyInfo());
            if (!this.serverPublicKey.isPrivate()) {
                this.rsaServerPublicKey = validateRSAPublicKey((RSAKeyParameters) this.serverPublicKey);
                TlsUtils.validateKeyUsage(x509CertificateStructure, 32);
                return;
            }
            throw new TlsFatalAlert(80);
        } catch (RuntimeException unused) {
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
            if (s == 1 || s == 2 || s == 64) {
                i++;
            } else {
                throw new TlsFatalAlert(47);
            }
        }
    }

    public void processClientCredentials(TlsCredentials tlsCredentials) throws IOException {
        if (!(tlsCredentials instanceof TlsSignerCredentials)) {
            throw new TlsFatalAlert(80);
        }
    }

    public void generateClientKeyExchange(OutputStream outputStream) throws IOException {
        this.premasterSecret = new byte[48];
        this.context.getSecureRandom().nextBytes(this.premasterSecret);
        TlsUtils.writeVersion(this.premasterSecret, 0);
        PKCS1Encoding pKCS1Encoding = new PKCS1Encoding(new RSABlindedEngine());
        pKCS1Encoding.init(true, new ParametersWithRandom(this.rsaServerPublicKey, this.context.getSecureRandom()));
        try {
            byte[] processBlock = pKCS1Encoding.processBlock(this.premasterSecret, 0, this.premasterSecret.length);
            TlsUtils.writeUint24(processBlock.length + 2, outputStream);
            TlsUtils.writeOpaque16(processBlock, outputStream);
        } catch (InvalidCipherTextException unused) {
            throw new TlsFatalAlert(80);
        }
    }

    public byte[] generatePremasterSecret() throws IOException {
        byte[] bArr = this.premasterSecret;
        this.premasterSecret = null;
        return bArr;
    }

    /* access modifiers changed from: protected */
    public RSAKeyParameters validateRSAPublicKey(RSAKeyParameters rSAKeyParameters) throws IOException {
        if (rSAKeyParameters.getExponent().isProbablePrime(2)) {
            return rSAKeyParameters;
        }
        throw new TlsFatalAlert(47);
    }
}
