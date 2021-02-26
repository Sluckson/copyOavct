package repack.org.bouncycastle.cert.crmf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.DERBitString;
import repack.org.bouncycastle.asn1.crmf.EncryptedValue;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.cert.X509CertificateHolder;
import repack.org.bouncycastle.operator.KeyWrapper;
import repack.org.bouncycastle.operator.OperatorException;
import repack.org.bouncycastle.operator.OutputEncryptor;
import repack.org.bouncycastle.util.Strings;

public class EncryptedValueBuilder {
    private OutputEncryptor encryptor;
    private EncryptedValuePadder padder;
    private KeyWrapper wrapper;

    public EncryptedValueBuilder(KeyWrapper keyWrapper, OutputEncryptor outputEncryptor) {
        this(keyWrapper, outputEncryptor, (EncryptedValuePadder) null);
    }

    public EncryptedValueBuilder(KeyWrapper keyWrapper, OutputEncryptor outputEncryptor, EncryptedValuePadder encryptedValuePadder) {
        this.wrapper = keyWrapper;
        this.encryptor = outputEncryptor;
        this.padder = encryptedValuePadder;
    }

    public EncryptedValue build(char[] cArr) throws CRMFException {
        return encryptData(padData(Strings.toUTF8ByteArray(cArr)));
    }

    public EncryptedValue build(X509CertificateHolder x509CertificateHolder) throws CRMFException {
        try {
            return encryptData(padData(x509CertificateHolder.getEncoded()));
        } catch (IOException e) {
            throw new CRMFException("cannot encode certificate: " + e.getMessage(), e);
        }
    }

    private EncryptedValue encryptData(byte[] bArr) throws CRMFException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStream outputStream = this.encryptor.getOutputStream(byteArrayOutputStream);
        try {
            outputStream.write(bArr);
            outputStream.close();
            AlgorithmIdentifier algorithmIdentifier = this.encryptor.getAlgorithmIdentifier();
            try {
                this.wrapper.generateWrappedKey(this.encryptor.getKey());
                return new EncryptedValue((AlgorithmIdentifier) null, algorithmIdentifier, new DERBitString(this.wrapper.generateWrappedKey(this.encryptor.getKey())), this.wrapper.getAlgorithmIdentifier(), (ASN1OctetString) null, new DERBitString(byteArrayOutputStream.toByteArray()));
            } catch (OperatorException e) {
                throw new CRMFException("cannot wrap key: " + e.getMessage(), e);
            }
        } catch (IOException e2) {
            throw new CRMFException("cannot process data: " + e2.getMessage(), e2);
        }
    }

    private byte[] padData(byte[] bArr) {
        EncryptedValuePadder encryptedValuePadder = this.padder;
        return encryptedValuePadder != null ? encryptedValuePadder.getPaddedData(bArr) : bArr;
    }
}
