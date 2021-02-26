package repack.org.bouncycastle.cert.crmf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import repack.org.bouncycastle.asn1.crmf.EncryptedValue;
import repack.org.bouncycastle.asn1.x509.X509CertificateStructure;
import repack.org.bouncycastle.cert.X509CertificateHolder;
import repack.org.bouncycastle.util.Strings;
import repack.org.bouncycastle.util.p072io.Streams;

public class EncryptedValueParser {
    private EncryptedValuePadder padder;
    private EncryptedValue value;

    public EncryptedValueParser(EncryptedValue encryptedValue) {
        this.value = encryptedValue;
    }

    public EncryptedValueParser(EncryptedValue encryptedValue, EncryptedValuePadder encryptedValuePadder) {
        this.value = encryptedValue;
        this.padder = encryptedValuePadder;
    }

    private byte[] decryptValue(ValueDecryptorGenerator valueDecryptorGenerator) throws CRMFException {
        if (this.value.getIntendedAlg() != null) {
            throw new UnsupportedOperationException();
        } else if (this.value.getValueHint() == null) {
            try {
                byte[] readAll = Streams.readAll(valueDecryptorGenerator.getValueDecryptor(this.value.getKeyAlg(), this.value.getSymmAlg(), this.value.getEncSymmKey().getBytes()).getInputStream(new ByteArrayInputStream(this.value.getEncValue().getBytes())));
                return this.padder != null ? this.padder.getUnpaddedData(readAll) : readAll;
            } catch (IOException e) {
                throw new CRMFException("Cannot parse decrypted data: " + e.getMessage(), e);
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public X509CertificateHolder readCertificateHolder(ValueDecryptorGenerator valueDecryptorGenerator) throws CRMFException {
        return new X509CertificateHolder(X509CertificateStructure.getInstance(decryptValue(valueDecryptorGenerator)));
    }

    public char[] readPassphrase(ValueDecryptorGenerator valueDecryptorGenerator) throws CRMFException {
        return Strings.fromUTF8ByteArray(decryptValue(valueDecryptorGenerator)).toCharArray();
    }
}
