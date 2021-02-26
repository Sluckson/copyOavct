package com.lowagie.text.pdf;

import com.lowagie.text.DocWriter;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.pdf.crypto.ARCFOUREncryption;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import kotlin.text.Typography;

public class PdfEncryption {
    public static final int AES_128 = 4;
    public static final int STANDARD_ENCRYPTION_128 = 3;
    public static final int STANDARD_ENCRYPTION_40 = 2;
    private static final byte[] metadataPad = {-1, -1, -1, -1};
    private static final byte[] pad;
    private static final byte[] salt = {115, 65, 108, 84};
    static long seq = System.currentTimeMillis();
    private ARCFOUREncryption arcfour;
    private int cryptoMode;
    byte[] documentID;
    private boolean embeddedFilesOnly;
    private boolean encryptMetadata;
    byte[] extra;
    byte[] key;
    private int keyLength;
    int keySize;
    MessageDigest md5;
    byte[] mkey;
    byte[] ownerKey;
    int permissions;
    protected PdfPublicKeySecurityHandler publicKeyHandler;
    private int revision;
    byte[] userKey;

    static {
        byte[] bArr = new byte[32];
        bArr[0] = 40;
        bArr[1] = -65;
        bArr[2] = 78;
        bArr[3] = 94;
        bArr[4] = 78;
        bArr[5] = 117;
        bArr[6] = -118;
        bArr[7] = 65;
        bArr[8] = 100;
        bArr[10] = 78;
        bArr[11] = 86;
        bArr[12] = -1;
        bArr[13] = -6;
        bArr[14] = 1;
        bArr[15] = 8;
        bArr[16] = 46;
        bArr[17] = 46;
        bArr[19] = -74;
        bArr[20] = -48;
        bArr[21] = 104;
        bArr[22] = DocWriter.f569GT;
        bArr[23] = Byte.MIN_VALUE;
        bArr[24] = DocWriter.FORWARD;
        bArr[25] = 12;
        bArr[26] = -87;
        bArr[27] = -2;
        bArr[28] = 100;
        bArr[29] = 83;
        bArr[30] = 105;
        bArr[31] = 122;
        pad = bArr;
    }

    public PdfEncryption() {
        this.extra = new byte[5];
        this.ownerKey = new byte[32];
        this.userKey = new byte[32];
        this.publicKeyHandler = null;
        this.arcfour = new ARCFOUREncryption();
        try {
            this.md5 = MessageDigest.getInstance("MD5");
            this.publicKeyHandler = new PdfPublicKeySecurityHandler();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public PdfEncryption(PdfEncryption pdfEncryption) {
        this();
        this.mkey = (byte[]) pdfEncryption.mkey.clone();
        this.ownerKey = (byte[]) pdfEncryption.ownerKey.clone();
        this.userKey = (byte[]) pdfEncryption.userKey.clone();
        this.permissions = pdfEncryption.permissions;
        byte[] bArr = pdfEncryption.documentID;
        if (bArr != null) {
            this.documentID = (byte[]) bArr.clone();
        }
        this.revision = pdfEncryption.revision;
        this.keyLength = pdfEncryption.keyLength;
        this.encryptMetadata = pdfEncryption.encryptMetadata;
        this.embeddedFilesOnly = pdfEncryption.embeddedFilesOnly;
        this.publicKeyHandler = pdfEncryption.publicKeyHandler;
    }

    public void setCryptoMode(int i, int i2) {
        this.cryptoMode = i;
        this.encryptMetadata = (i & 8) == 0;
        this.embeddedFilesOnly = (i & 24) != 0;
        int i3 = i & 7;
        if (i3 == 0) {
            this.encryptMetadata = true;
            this.embeddedFilesOnly = false;
            this.keyLength = 40;
            this.revision = 2;
        } else if (i3 == 1) {
            this.embeddedFilesOnly = false;
            if (i2 > 0) {
                this.keyLength = i2;
            } else {
                this.keyLength = 128;
            }
            this.revision = 3;
        } else if (i3 == 2) {
            this.keyLength = 128;
            this.revision = 4;
        } else {
            throw new IllegalArgumentException("No valid encryption mode");
        }
    }

    public int getCryptoMode() {
        return this.cryptoMode;
    }

    public boolean isMetadataEncrypted() {
        return this.encryptMetadata;
    }

    public boolean isEmbeddedFilesOnly() {
        return this.embeddedFilesOnly;
    }

    private byte[] padPassword(byte[] bArr) {
        byte[] bArr2 = new byte[32];
        if (bArr == null) {
            System.arraycopy(pad, 0, bArr2, 0, 32);
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, 32));
            if (bArr.length < 32) {
                System.arraycopy(pad, 0, bArr2, bArr.length, 32 - bArr.length);
            }
        }
        return bArr2;
    }

    private byte[] computeOwnerKey(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[32];
        byte[] digest = this.md5.digest(bArr2);
        int i = this.revision;
        if (i == 3 || i == 4) {
            byte[] bArr4 = new byte[(this.keyLength / 8)];
            for (int i2 = 0; i2 < 50; i2++) {
                System.arraycopy(this.md5.digest(digest), 0, digest, 0, bArr4.length);
            }
            System.arraycopy(bArr, 0, bArr3, 0, 32);
            for (int i3 = 0; i3 < 20; i3++) {
                for (int i4 = 0; i4 < bArr4.length; i4++) {
                    bArr4[i4] = (byte) (digest[i4] ^ i3);
                }
                this.arcfour.prepareARCFOURKey(bArr4);
                this.arcfour.encryptARCFOUR(bArr3);
            }
        } else {
            this.arcfour.prepareARCFOURKey(digest, 0, 5);
            this.arcfour.encryptARCFOUR(bArr, bArr3);
        }
        return bArr3;
    }

    private void setupGlobalEncryptionKey(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        this.documentID = bArr;
        this.ownerKey = bArr3;
        this.permissions = i;
        this.mkey = new byte[(this.keyLength / 8)];
        this.md5.reset();
        this.md5.update(bArr2);
        this.md5.update(bArr3);
        this.md5.update(new byte[]{(byte) i, (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)}, 0, 4);
        if (bArr != null) {
            this.md5.update(bArr);
        }
        if (!this.encryptMetadata) {
            this.md5.update(metadataPad);
        }
        byte[] bArr4 = new byte[this.mkey.length];
        System.arraycopy(this.md5.digest(), 0, bArr4, 0, this.mkey.length);
        int i2 = this.revision;
        if (i2 == 3 || i2 == 4) {
            for (int i3 = 0; i3 < 50; i3++) {
                System.arraycopy(this.md5.digest(bArr4), 0, bArr4, 0, this.mkey.length);
            }
        }
        byte[] bArr5 = this.mkey;
        System.arraycopy(bArr4, 0, bArr5, 0, bArr5.length);
    }

    private void setupUserKey() {
        byte[] bArr;
        int i = this.revision;
        if (i == 3 || i == 4) {
            this.md5.update(pad);
            byte[] digest = this.md5.digest(this.documentID);
            System.arraycopy(digest, 0, this.userKey, 0, 16);
            for (int i2 = 16; i2 < 32; i2++) {
                this.userKey[i2] = 0;
            }
            for (int i3 = 0; i3 < 20; i3++) {
                int i4 = 0;
                while (true) {
                    bArr = this.mkey;
                    if (i4 >= bArr.length) {
                        break;
                    }
                    digest[i4] = (byte) (bArr[i4] ^ i3);
                    i4++;
                }
                this.arcfour.prepareARCFOURKey(digest, 0, bArr.length);
                this.arcfour.encryptARCFOUR(this.userKey, 0, 16);
            }
            return;
        }
        this.arcfour.prepareARCFOURKey(this.mkey);
        this.arcfour.encryptARCFOUR(pad, this.userKey);
    }

    public void setupAllKeys(byte[] bArr, byte[] bArr2, int i) {
        if (bArr2 == null || bArr2.length == 0) {
            bArr2 = this.md5.digest(createDocumentId());
        }
        int i2 = this.revision;
        int i3 = (i2 == 3 || i2 == 4) ? -3904 : -64;
        byte[] padPassword = padPassword(bArr);
        this.ownerKey = computeOwnerKey(padPassword, padPassword(bArr2));
        this.documentID = createDocumentId();
        setupByUserPad(this.documentID, padPassword, this.ownerKey, (i | i3) & -4);
    }

    public static byte[] createDocumentId() {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            long currentTimeMillis = System.currentTimeMillis();
            long freeMemory = Runtime.getRuntime().freeMemory();
            StringBuilder sb = new StringBuilder(String.valueOf(currentTimeMillis));
            sb.append("+");
            sb.append(freeMemory);
            sb.append("+");
            long j = seq;
            seq = 1 + j;
            sb.append(j);
            return instance.digest(sb.toString().getBytes());
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public void setupByUserPassword(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        setupByUserPad(bArr, padPassword(bArr2), bArr3, i);
    }

    private void setupByUserPad(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        setupGlobalEncryptionKey(bArr, bArr2, bArr3, i);
        setupUserKey();
    }

    public void setupByOwnerPassword(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i) {
        setupByOwnerPad(bArr, padPassword(bArr2), bArr3, bArr4, i);
    }

    private void setupByOwnerPad(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i) {
        setupGlobalEncryptionKey(bArr, computeOwnerKey(bArr4, bArr2), bArr4, i);
        setupUserKey();
    }

    public void setupByEncryptionKey(byte[] bArr, int i) {
        this.mkey = new byte[(i / 8)];
        byte[] bArr2 = this.mkey;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
    }

    public void setHashKey(int i, int i2) {
        this.md5.reset();
        byte[] bArr = this.extra;
        bArr[0] = (byte) i;
        bArr[1] = (byte) (i >> 8);
        bArr[2] = (byte) (i >> 16);
        bArr[3] = (byte) i2;
        bArr[4] = (byte) (i2 >> 8);
        this.md5.update(this.mkey);
        this.md5.update(this.extra);
        if (this.revision == 4) {
            this.md5.update(salt);
        }
        this.key = this.md5.digest();
        this.keySize = this.mkey.length + 5;
        if (this.keySize > 16) {
            this.keySize = 16;
        }
    }

    public static PdfObject createInfoId(byte[] bArr) {
        ByteBuffer byteBuffer = new ByteBuffer(90);
        byteBuffer.append('[').append((char) Typography.less);
        for (int i = 0; i < 16; i++) {
            byteBuffer.appendHex(bArr[i]);
        }
        byteBuffer.append((char) Typography.greater).append((char) Typography.less);
        byte[] createDocumentId = createDocumentId();
        for (int i2 = 0; i2 < 16; i2++) {
            byteBuffer.appendHex(createDocumentId[i2]);
        }
        byteBuffer.append((char) Typography.greater).append(']');
        return new PdfLiteral(byteBuffer.toByteArray());
    }

    public PdfDictionary getEncryptionDictionary() {
        PdfDictionary pdfDictionary = new PdfDictionary();
        if (this.publicKeyHandler.getRecipientsSize() > 0) {
            pdfDictionary.put(PdfName.FILTER, PdfName.PUBSEC);
            pdfDictionary.put(PdfName.f715R, new PdfNumber(this.revision));
            try {
                PdfArray encodedRecipients = this.publicKeyHandler.getEncodedRecipients();
                int i = this.revision;
                if (i == 2) {
                    pdfDictionary.put(PdfName.f736V, new PdfNumber(1));
                    pdfDictionary.put(PdfName.SUBFILTER, PdfName.ADBE_PKCS7_S4);
                    pdfDictionary.put(PdfName.RECIPIENTS, encodedRecipients);
                } else if (i != 3 || !this.encryptMetadata) {
                    pdfDictionary.put(PdfName.f715R, new PdfNumber(4));
                    pdfDictionary.put(PdfName.f736V, new PdfNumber(4));
                    pdfDictionary.put(PdfName.SUBFILTER, PdfName.ADBE_PKCS7_S5);
                    PdfDictionary pdfDictionary2 = new PdfDictionary();
                    pdfDictionary2.put(PdfName.RECIPIENTS, encodedRecipients);
                    if (!this.encryptMetadata) {
                        pdfDictionary2.put(PdfName.ENCRYPTMETADATA, PdfBoolean.PDFFALSE);
                    }
                    if (this.revision == 4) {
                        pdfDictionary2.put(PdfName.CFM, PdfName.AESV2);
                    } else {
                        pdfDictionary2.put(PdfName.CFM, PdfName.f737V2);
                    }
                    PdfDictionary pdfDictionary3 = new PdfDictionary();
                    pdfDictionary3.put(PdfName.DEFAULTCRYPTFILTER, pdfDictionary2);
                    pdfDictionary.put(PdfName.f656CF, pdfDictionary3);
                    if (this.embeddedFilesOnly) {
                        pdfDictionary.put(PdfName.EFF, PdfName.DEFAULTCRYPTFILTER);
                        pdfDictionary.put(PdfName.STRF, PdfName.IDENTITY);
                        pdfDictionary.put(PdfName.STMF, PdfName.IDENTITY);
                    } else {
                        pdfDictionary.put(PdfName.STRF, PdfName.DEFAULTCRYPTFILTER);
                        pdfDictionary.put(PdfName.STMF, PdfName.DEFAULTCRYPTFILTER);
                    }
                } else {
                    pdfDictionary.put(PdfName.f736V, new PdfNumber(2));
                    pdfDictionary.put(PdfName.LENGTH, new PdfNumber(128));
                    pdfDictionary.put(PdfName.SUBFILTER, PdfName.ADBE_PKCS7_S4);
                    pdfDictionary.put(PdfName.RECIPIENTS, encodedRecipients);
                }
                try {
                    MessageDigest instance = MessageDigest.getInstance("SHA-1");
                    instance.update(this.publicKeyHandler.getSeed());
                    for (int i2 = 0; i2 < this.publicKeyHandler.getRecipientsSize(); i2++) {
                        instance.update(this.publicKeyHandler.getEncodedRecipient(i2));
                    }
                    if (!this.encryptMetadata) {
                        instance.update(new byte[]{-1, -1, -1, -1});
                    }
                    setupByEncryptionKey(instance.digest(), this.keyLength);
                } catch (Exception e) {
                    throw new ExceptionConverter(e);
                }
            } catch (Exception e2) {
                throw new ExceptionConverter(e2);
            }
        } else {
            pdfDictionary.put(PdfName.FILTER, PdfName.STANDARD);
            pdfDictionary.put(PdfName.f703O, new PdfLiteral(PdfContentByte.escapeString(this.ownerKey)));
            pdfDictionary.put(PdfName.f733U, new PdfLiteral(PdfContentByte.escapeString(this.userKey)));
            pdfDictionary.put(PdfName.f707P, new PdfNumber(this.permissions));
            pdfDictionary.put(PdfName.f715R, new PdfNumber(this.revision));
            int i3 = this.revision;
            if (i3 == 2) {
                pdfDictionary.put(PdfName.f736V, new PdfNumber(1));
            } else if (i3 != 3 || !this.encryptMetadata) {
                if (!this.encryptMetadata) {
                    pdfDictionary.put(PdfName.ENCRYPTMETADATA, PdfBoolean.PDFFALSE);
                }
                pdfDictionary.put(PdfName.f715R, new PdfNumber(4));
                pdfDictionary.put(PdfName.f736V, new PdfNumber(4));
                pdfDictionary.put(PdfName.LENGTH, new PdfNumber(128));
                PdfDictionary pdfDictionary4 = new PdfDictionary();
                pdfDictionary4.put(PdfName.LENGTH, new PdfNumber(16));
                if (this.embeddedFilesOnly) {
                    pdfDictionary4.put(PdfName.AUTHEVENT, PdfName.EFOPEN);
                    pdfDictionary.put(PdfName.EFF, PdfName.STDCF);
                    pdfDictionary.put(PdfName.STRF, PdfName.IDENTITY);
                    pdfDictionary.put(PdfName.STMF, PdfName.IDENTITY);
                } else {
                    pdfDictionary4.put(PdfName.AUTHEVENT, PdfName.DOCOPEN);
                    pdfDictionary.put(PdfName.STRF, PdfName.STDCF);
                    pdfDictionary.put(PdfName.STMF, PdfName.STDCF);
                }
                if (this.revision == 4) {
                    pdfDictionary4.put(PdfName.CFM, PdfName.AESV2);
                } else {
                    pdfDictionary4.put(PdfName.CFM, PdfName.f737V2);
                }
                PdfDictionary pdfDictionary5 = new PdfDictionary();
                pdfDictionary5.put(PdfName.STDCF, pdfDictionary4);
                pdfDictionary.put(PdfName.f656CF, pdfDictionary5);
            } else {
                pdfDictionary.put(PdfName.f736V, new PdfNumber(2));
                pdfDictionary.put(PdfName.LENGTH, new PdfNumber(128));
            }
        }
        return pdfDictionary;
    }

    public PdfObject getFileID() {
        return createInfoId(this.documentID);
    }

    public OutputStreamEncryption getEncryptionStream(OutputStream outputStream) {
        return new OutputStreamEncryption(outputStream, this.key, 0, this.keySize, this.revision);
    }

    public int calculateStreamSize(int i) {
        return this.revision == 4 ? (i & 2147483632) + 32 : i;
    }

    public byte[] encryptByteArray(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStreamEncryption encryptionStream = getEncryptionStream(byteArrayOutputStream);
            encryptionStream.write(bArr);
            encryptionStream.finish();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public StandardDecryption getDecryptor() {
        return new StandardDecryption(this.key, 0, this.keySize, this.revision);
    }

    public byte[] decryptByteArray(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            StandardDecryption decryptor = getDecryptor();
            byte[] update = decryptor.update(bArr, 0, bArr.length);
            if (update != null) {
                byteArrayOutputStream.write(update);
            }
            byte[] finish = decryptor.finish();
            if (finish != null) {
                byteArrayOutputStream.write(finish);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public void addRecipient(Certificate certificate, int i) {
        this.documentID = createDocumentId();
        this.publicKeyHandler.addRecipient(new PdfPublicKeyRecipient(certificate, i));
    }

    public byte[] computeUserPassword(byte[] bArr) {
        boolean z;
        byte[] computeOwnerKey = computeOwnerKey(this.ownerKey, padPassword(bArr));
        int i = 0;
        while (i < computeOwnerKey.length) {
            int i2 = 0;
            while (true) {
                if (i2 >= computeOwnerKey.length - i) {
                    z = true;
                    break;
                } else if (computeOwnerKey[i + i2] != pad[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                i++;
            } else {
                byte[] bArr2 = new byte[i];
                System.arraycopy(computeOwnerKey, 0, bArr2, 0, i);
                return bArr2;
            }
        }
        return computeOwnerKey;
    }
}
