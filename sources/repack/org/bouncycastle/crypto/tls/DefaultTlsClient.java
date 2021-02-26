package repack.org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.util.Hashtable;

public abstract class DefaultTlsClient implements TlsClient {
    protected TlsCipherFactory cipherFactory;
    protected TlsClientContext context;
    protected int selectedCipherSuite;
    protected int selectedCompressionMethod;

    public Hashtable getClientExtensions() {
        return null;
    }

    public void notifySecureRenegotiation(boolean z) throws IOException {
    }

    public void notifySessionID(byte[] bArr) {
    }

    public void processServerExtensions(Hashtable hashtable) {
    }

    public DefaultTlsClient() {
        this(new DefaultTlsCipherFactory());
    }

    public DefaultTlsClient(TlsCipherFactory tlsCipherFactory) {
        this.cipherFactory = tlsCipherFactory;
    }

    public void init(TlsClientContext tlsClientContext) {
        this.context = tlsClientContext;
    }

    public int[] getCipherSuites() {
        return new int[]{57, 56, 51, 50, 22, 19, 53, 47, 10};
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
        int i = this.selectedCipherSuite;
        if (i != 10) {
            if (i != 13) {
                if (i != 16) {
                    if (i != 19) {
                        if (i != 22) {
                            switch (i) {
                                case 47:
                                    break;
                                case 48:
                                    break;
                                case 49:
                                    break;
                                case 50:
                                    break;
                                case 51:
                                    break;
                                default:
                                    switch (i) {
                                        case 53:
                                            break;
                                        case 54:
                                            break;
                                        case 55:
                                            break;
                                        case 56:
                                            break;
                                        case 57:
                                            break;
                                        default:
                                            switch (i) {
                                                case CipherSuite.TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA:
                                                case CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA:
                                                case CipherSuite.TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA:
                                                    return createECDHKeyExchange(16);
                                                default:
                                                    switch (i) {
                                                        case CipherSuite.TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA:
                                                        case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA:
                                                        case CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA:
                                                            return createECDHEKeyExchange(17);
                                                        default:
                                                            switch (i) {
                                                                case CipherSuite.TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA:
                                                                case CipherSuite.TLS_ECDH_RSA_WITH_AES_128_CBC_SHA:
                                                                case CipherSuite.TLS_ECDH_RSA_WITH_AES_256_CBC_SHA:
                                                                    return createECDHKeyExchange(18);
                                                                default:
                                                                    switch (i) {
                                                                        case CipherSuite.TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA:
                                                                        case CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA:
                                                                        case CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA:
                                                                            return createECDHEKeyExchange(19);
                                                                        default:
                                                                            throw new TlsFatalAlert(80);
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                            }
                        }
                        return createDHEKeyExchange(5);
                    }
                    return createDHEKeyExchange(3);
                }
                return createDHKeyExchange(9);
            }
            return createDHKeyExchange(7);
        }
        return createRSAKeyExchange();
    }

    public TlsCompression getCompression() throws IOException {
        if (this.selectedCompressionMethod == 0) {
            return new TlsNullCompression();
        }
        throw new TlsFatalAlert(80);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
        return r4.cipherFactory.createCipher(r4.context, 9, 2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0046, code lost:
        return r4.cipherFactory.createCipher(r4.context, 8, 2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public repack.org.bouncycastle.crypto.tls.TlsCipher getCipher() throws java.io.IOException {
        /*
            r4 = this;
            int r0 = r4.selectedCipherSuite
            r1 = 10
            r2 = 2
            if (r0 == r1) goto L_0x0047
            r1 = 13
            if (r0 == r1) goto L_0x0047
            r1 = 16
            if (r0 == r1) goto L_0x0047
            r1 = 19
            if (r0 == r1) goto L_0x0047
            r1 = 22
            if (r0 == r1) goto L_0x0047
            switch(r0) {
                case 47: goto L_0x003c;
                case 48: goto L_0x003c;
                case 49: goto L_0x003c;
                case 50: goto L_0x003c;
                case 51: goto L_0x003c;
                default: goto L_0x001a;
            }
        L_0x001a:
            switch(r0) {
                case 53: goto L_0x0031;
                case 54: goto L_0x0031;
                case 55: goto L_0x0031;
                case 56: goto L_0x0031;
                case 57: goto L_0x0031;
                default: goto L_0x001d;
            }
        L_0x001d:
            switch(r0) {
                case 49155: goto L_0x0047;
                case 49156: goto L_0x003c;
                case 49157: goto L_0x0031;
                default: goto L_0x0020;
            }
        L_0x0020:
            switch(r0) {
                case 49160: goto L_0x0047;
                case 49161: goto L_0x003c;
                case 49162: goto L_0x0031;
                default: goto L_0x0023;
            }
        L_0x0023:
            switch(r0) {
                case 49165: goto L_0x0047;
                case 49166: goto L_0x003c;
                case 49167: goto L_0x0031;
                default: goto L_0x0026;
            }
        L_0x0026:
            switch(r0) {
                case 49170: goto L_0x0047;
                case 49171: goto L_0x003c;
                case 49172: goto L_0x0031;
                default: goto L_0x0029;
            }
        L_0x0029:
            repack.org.bouncycastle.crypto.tls.TlsFatalAlert r0 = new repack.org.bouncycastle.crypto.tls.TlsFatalAlert
            r1 = 80
            r0.<init>(r1)
            throw r0
        L_0x0031:
            repack.org.bouncycastle.crypto.tls.TlsCipherFactory r0 = r4.cipherFactory
            repack.org.bouncycastle.crypto.tls.TlsClientContext r1 = r4.context
            r3 = 9
            repack.org.bouncycastle.crypto.tls.TlsCipher r0 = r0.createCipher(r1, r3, r2)
            return r0
        L_0x003c:
            repack.org.bouncycastle.crypto.tls.TlsCipherFactory r0 = r4.cipherFactory
            repack.org.bouncycastle.crypto.tls.TlsClientContext r1 = r4.context
            r3 = 8
            repack.org.bouncycastle.crypto.tls.TlsCipher r0 = r0.createCipher(r1, r3, r2)
            return r0
        L_0x0047:
            repack.org.bouncycastle.crypto.tls.TlsCipherFactory r0 = r4.cipherFactory
            repack.org.bouncycastle.crypto.tls.TlsClientContext r1 = r4.context
            r3 = 7
            repack.org.bouncycastle.crypto.tls.TlsCipher r0 = r0.createCipher(r1, r3, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.crypto.tls.DefaultTlsClient.getCipher():repack.org.bouncycastle.crypto.tls.TlsCipher");
    }

    /* access modifiers changed from: protected */
    public TlsKeyExchange createDHKeyExchange(int i) {
        return new TlsDHKeyExchange(this.context, i);
    }

    /* access modifiers changed from: protected */
    public TlsKeyExchange createDHEKeyExchange(int i) {
        return new TlsDHEKeyExchange(this.context, i);
    }

    /* access modifiers changed from: protected */
    public TlsKeyExchange createECDHKeyExchange(int i) {
        return new TlsECDHKeyExchange(this.context, i);
    }

    /* access modifiers changed from: protected */
    public TlsKeyExchange createECDHEKeyExchange(int i) {
        return new TlsECDHEKeyExchange(this.context, i);
    }

    /* access modifiers changed from: protected */
    public TlsKeyExchange createRSAKeyExchange() {
        return new TlsRSAKeyExchange(this.context);
    }
}
