package repack.org.bouncycastle.crypto.tls;

import java.security.SecureRandom;
import repack.org.bouncycastle.crypto.BlockCipher;
import repack.org.bouncycastle.crypto.Digest;
import repack.org.bouncycastle.crypto.params.KeyParameter;
import repack.org.bouncycastle.crypto.params.ParametersWithIV;

public class TlsBlockCipher implements TlsCipher {
    protected TlsClientContext context;
    protected BlockCipher decryptCipher;
    protected BlockCipher encryptCipher;
    protected TlsMac readMac;
    protected TlsMac writeMac;

    /* access modifiers changed from: protected */
    public int lowestBitSet(int i) {
        if (i == 0) {
            return 32;
        }
        int i2 = 0;
        while ((i & 1) == 0) {
            i2++;
            i >>= 1;
        }
        return i2;
    }

    public TlsBlockCipher(TlsClientContext tlsClientContext, BlockCipher blockCipher, BlockCipher blockCipher2, Digest digest, Digest digest2, int i) {
        this.context = tlsClientContext;
        this.encryptCipher = blockCipher;
        this.decryptCipher = blockCipher2;
        int i2 = i * 2;
        int digestSize = digest.getDigestSize() + i2 + digest2.getDigestSize() + blockCipher.getBlockSize() + blockCipher2.getBlockSize();
        SecurityParameters securityParameters = tlsClientContext.getSecurityParameters();
        byte[] PRF = TlsUtils.PRF(securityParameters.masterSecret, "key expansion", TlsUtils.concat(securityParameters.serverRandom, securityParameters.clientRandom), digestSize);
        this.writeMac = new TlsMac(digest, PRF, 0, digest.getDigestSize());
        int digestSize2 = digest.getDigestSize() + 0;
        this.readMac = new TlsMac(digest2, PRF, digestSize2, digest2.getDigestSize());
        int digestSize3 = digestSize2 + digest2.getDigestSize();
        byte[] bArr = PRF;
        int i3 = i;
        initCipher(true, blockCipher, bArr, i3, digestSize3, digestSize3 + i2);
        int i4 = digestSize3 + i;
        initCipher(false, blockCipher2, bArr, i3, i4, i4 + i + blockCipher.getBlockSize());
    }

    /* access modifiers changed from: protected */
    public void initCipher(boolean z, BlockCipher blockCipher, byte[] bArr, int i, int i2, int i3) {
        blockCipher.init(z, new ParametersWithIV(new KeyParameter(bArr, i2, i), bArr, i3, blockCipher.getBlockSize()));
    }

    public byte[] encodePlaintext(short s, byte[] bArr, int i, int i2) {
        int blockSize = this.encryptCipher.getBlockSize();
        int size = blockSize - (((this.writeMac.getSize() + i2) + 1) % blockSize);
        int chooseExtraPadBlocks = size + (chooseExtraPadBlocks(this.context.getSecureRandom(), (255 - size) / blockSize) * blockSize);
        int size2 = this.writeMac.getSize() + i2 + chooseExtraPadBlocks + 1;
        byte[] bArr2 = new byte[size2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        byte[] calculateMac = this.writeMac.calculateMac(s, bArr, i, i2);
        System.arraycopy(calculateMac, 0, bArr2, i2, calculateMac.length);
        int length = i2 + calculateMac.length;
        for (int i3 = 0; i3 <= chooseExtraPadBlocks; i3++) {
            bArr2[i3 + length] = (byte) chooseExtraPadBlocks;
        }
        for (int i4 = 0; i4 < size2; i4 += blockSize) {
            this.encryptCipher.processBlock(bArr2, i4, bArr2, i4);
        }
        return bArr2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] decodeCiphertext(short r10, byte[] r11, int r12, int r13) throws java.io.IOException {
        /*
            r9 = this;
            repack.org.bouncycastle.crypto.tls.TlsMac r0 = r9.readMac
            int r0 = r0.getSize()
            r1 = 1
            int r0 = r0 + r1
            repack.org.bouncycastle.crypto.BlockCipher r2 = r9.decryptCipher
            int r2 = r2.getBlockSize()
            if (r13 < r0) goto L_0x0070
            int r3 = r13 % r2
            if (r3 != 0) goto L_0x0068
            r3 = 0
            r4 = 0
        L_0x0016:
            if (r4 < r13) goto L_0x005f
            int r2 = r12 + r13
            int r5 = r2 + -1
            byte r6 = r11[r5]
            r7 = r6 & 255(0xff, float:3.57E-43)
            int r8 = r13 - r0
            if (r7 <= r8) goto L_0x0027
        L_0x0024:
            r13 = 1
            r7 = 0
            goto L_0x0030
        L_0x0027:
            int r13 = r5 - r7
            r0 = 0
        L_0x002a:
            if (r13 < r5) goto L_0x0057
            if (r0 == 0) goto L_0x002f
            goto L_0x0024
        L_0x002f:
            r13 = 0
        L_0x0030:
            int r8 = r8 - r7
            repack.org.bouncycastle.crypto.tls.TlsMac r0 = r9.readMac
            byte[] r10 = r0.calculateMac(r10, r11, r12, r8)
            int r0 = r10.length
            byte[] r0 = new byte[r0]
            int r2 = r12 + r8
            int r4 = r10.length
            java.lang.System.arraycopy(r11, r2, r0, r3, r4)
            boolean r10 = repack.org.bouncycastle.util.Arrays.constantTimeAreEqual(r10, r0)
            if (r10 != 0) goto L_0x0047
            r13 = 1
        L_0x0047:
            if (r13 != 0) goto L_0x004f
            byte[] r10 = new byte[r8]
            java.lang.System.arraycopy(r11, r12, r10, r3, r8)
            return r10
        L_0x004f:
            repack.org.bouncycastle.crypto.tls.TlsFatalAlert r10 = new repack.org.bouncycastle.crypto.tls.TlsFatalAlert
            r11 = 20
            r10.<init>(r11)
            throw r10
        L_0x0057:
            byte r2 = r11[r13]
            r2 = r2 ^ r6
            r0 = r0 | r2
            byte r0 = (byte) r0
            int r13 = r13 + 1
            goto L_0x002a
        L_0x005f:
            repack.org.bouncycastle.crypto.BlockCipher r5 = r9.decryptCipher
            int r6 = r4 + r12
            r5.processBlock(r11, r6, r11, r6)
            int r4 = r4 + r2
            goto L_0x0016
        L_0x0068:
            repack.org.bouncycastle.crypto.tls.TlsFatalAlert r10 = new repack.org.bouncycastle.crypto.tls.TlsFatalAlert
            r11 = 21
            r10.<init>(r11)
            throw r10
        L_0x0070:
            repack.org.bouncycastle.crypto.tls.TlsFatalAlert r10 = new repack.org.bouncycastle.crypto.tls.TlsFatalAlert
            r11 = 50
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.crypto.tls.TlsBlockCipher.decodeCiphertext(short, byte[], int, int):byte[]");
    }

    /* access modifiers changed from: protected */
    public int chooseExtraPadBlocks(SecureRandom secureRandom, int i) {
        return Math.min(lowestBitSet(secureRandom.nextInt()), i);
    }
}
