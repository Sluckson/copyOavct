package repack.org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import repack.org.bouncycastle.crypto.Signer;
import repack.org.bouncycastle.crypto.p067io.SignerInputStream;
import repack.org.bouncycastle.crypto.params.ECDomainParameters;
import repack.org.bouncycastle.crypto.params.ECPublicKeyParameters;

class TlsECDHEKeyExchange extends TlsECDHKeyExchange {
    TlsECDHEKeyExchange(TlsClientContext tlsClientContext, int i) {
        super(tlsClientContext, i);
    }

    public void skipServerKeyExchange() throws IOException {
        throw new TlsFatalAlert(10);
    }

    public void processServerKeyExchange(InputStream inputStream) throws IOException {
        Signer initSigner = initSigner(this.tlsSigner, this.context.getSecurityParameters());
        SignerInputStream signerInputStream = new SignerInputStream(inputStream, initSigner);
        if (TlsUtils.readUint8(signerInputStream) == 3) {
            ECDomainParameters eCParameters = NamedCurve.getECParameters(TlsUtils.readUint16(signerInputStream));
            byte[] readOpaque8 = TlsUtils.readOpaque8(signerInputStream);
            if (initSigner.verifySignature(TlsUtils.readOpaque16(inputStream))) {
                this.ecAgreeServerPublicKey = validateECPublicKey(new ECPublicKeyParameters(eCParameters.getCurve().decodePoint(readOpaque8), eCParameters));
                return;
            }
            throw new TlsFatalAlert(42);
        }
        throw new TlsFatalAlert(40);
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

    /* access modifiers changed from: protected */
    public Signer initSigner(TlsSigner tlsSigner, SecurityParameters securityParameters) {
        Signer createVerifyer = tlsSigner.createVerifyer(this.serverPublicKey);
        createVerifyer.update(securityParameters.clientRandom, 0, securityParameters.clientRandom.length);
        createVerifyer.update(securityParameters.serverRandom, 0, securityParameters.serverRandom.length);
        return createVerifyer;
    }
}
