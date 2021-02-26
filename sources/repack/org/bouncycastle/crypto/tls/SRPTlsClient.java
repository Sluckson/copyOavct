package repack.org.bouncycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import repack.org.bouncycastle.util.Arrays;

public abstract class SRPTlsClient implements TlsClient {
    public static final Integer EXT_SRP = new Integer(12);
    protected TlsCipherFactory cipherFactory;
    protected TlsClientContext context;
    protected byte[] identity;
    protected byte[] password;
    protected int selectedCipherSuite;
    protected int selectedCompressionMethod;

    public void notifySecureRenegotiation(boolean z) throws IOException {
    }

    public void notifySessionID(byte[] bArr) {
    }

    public void processServerExtensions(Hashtable hashtable) {
    }

    public SRPTlsClient(byte[] bArr, byte[] bArr2) {
        this(new DefaultTlsCipherFactory(), bArr, bArr2);
    }

    public SRPTlsClient(TlsCipherFactory tlsCipherFactory, byte[] bArr, byte[] bArr2) {
        this.cipherFactory = tlsCipherFactory;
        this.identity = Arrays.clone(bArr);
        this.password = Arrays.clone(bArr2);
    }

    public void init(TlsClientContext tlsClientContext) {
        this.context = tlsClientContext;
    }

    public int[] getCipherSuites() {
        return new int[]{CipherSuite.TLS_SRP_SHA_DSS_WITH_AES_256_CBC_SHA, CipherSuite.TLS_SRP_SHA_DSS_WITH_AES_128_CBC_SHA, CipherSuite.TLS_SRP_SHA_DSS_WITH_3DES_EDE_CBC_SHA, CipherSuite.TLS_SRP_SHA_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_SRP_SHA_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_SRP_SHA_RSA_WITH_3DES_EDE_CBC_SHA, CipherSuite.TLS_SRP_SHA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_SRP_SHA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_SRP_SHA_WITH_3DES_EDE_CBC_SHA};
    }

    public Hashtable getClientExtensions() throws IOException {
        Hashtable hashtable = new Hashtable();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        TlsUtils.writeOpaque8(this.identity, byteArrayOutputStream);
        hashtable.put(EXT_SRP, byteArrayOutputStream.toByteArray());
        return hashtable;
    }

    public short[] getCompressionMethods() {
        return new short[1];
    }

    public void notifySelectedCipherSuite(int i) {
        this.selectedCipherSuite = i;
    }

    public void notifySelectedCompressionMethod(short s) {
        this.selectedCompressionMethod = s;
    }

    public TlsKeyExchange getKeyExchange() throws IOException {
        switch (this.selectedCipherSuite) {
            case CipherSuite.TLS_SRP_SHA_WITH_3DES_EDE_CBC_SHA:
            case CipherSuite.TLS_SRP_SHA_WITH_AES_128_CBC_SHA:
            case CipherSuite.TLS_SRP_SHA_WITH_AES_256_CBC_SHA:
                return createSRPKeyExchange(21);
            case CipherSuite.TLS_SRP_SHA_RSA_WITH_3DES_EDE_CBC_SHA:
            case CipherSuite.TLS_SRP_SHA_RSA_WITH_AES_128_CBC_SHA:
            case CipherSuite.TLS_SRP_SHA_RSA_WITH_AES_256_CBC_SHA:
                return createSRPKeyExchange(23);
            case CipherSuite.TLS_SRP_SHA_DSS_WITH_3DES_EDE_CBC_SHA:
            case CipherSuite.TLS_SRP_SHA_DSS_WITH_AES_128_CBC_SHA:
            case CipherSuite.TLS_SRP_SHA_DSS_WITH_AES_256_CBC_SHA:
                return createSRPKeyExchange(22);
            default:
                throw new TlsFatalAlert(80);
        }
    }

    public TlsCompression getCompression() throws IOException {
        if (this.selectedCompressionMethod == 0) {
            return new TlsNullCompression();
        }
        throw new TlsFatalAlert(80);
    }

    public TlsCipher getCipher() throws IOException {
        switch (this.selectedCipherSuite) {
            case CipherSuite.TLS_SRP_SHA_WITH_3DES_EDE_CBC_SHA:
            case CipherSuite.TLS_SRP_SHA_RSA_WITH_3DES_EDE_CBC_SHA:
            case CipherSuite.TLS_SRP_SHA_DSS_WITH_3DES_EDE_CBC_SHA:
                return this.cipherFactory.createCipher(this.context, 7, 2);
            case CipherSuite.TLS_SRP_SHA_WITH_AES_128_CBC_SHA:
            case CipherSuite.TLS_SRP_SHA_RSA_WITH_AES_128_CBC_SHA:
            case CipherSuite.TLS_SRP_SHA_DSS_WITH_AES_128_CBC_SHA:
                return this.cipherFactory.createCipher(this.context, 8, 2);
            case CipherSuite.TLS_SRP_SHA_WITH_AES_256_CBC_SHA:
            case CipherSuite.TLS_SRP_SHA_RSA_WITH_AES_256_CBC_SHA:
            case CipherSuite.TLS_SRP_SHA_DSS_WITH_AES_256_CBC_SHA:
                return this.cipherFactory.createCipher(this.context, 9, 2);
            default:
                throw new TlsFatalAlert(80);
        }
    }

    /* access modifiers changed from: protected */
    public TlsKeyExchange createSRPKeyExchange(int i) {
        return new TlsSRPKeyExchange(this.context, i, this.identity, this.password);
    }
}
