package com.salesforce.marketingcloud.tozny;

import android.os.Build;
import android.os.Process;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.SecureRandomSpi;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

@Keep
public class AesCbcWithIntegrity {
    private static final int AES_KEY_LENGTH_BITS = 128;
    private static final boolean ALLOW_BROKEN_PRNG = false;
    public static final int BASE64_FLAGS = 2;
    private static final String CIPHER = "AES";
    private static final String CIPHER_TRANSFORMATION = "AES/CBC/PKCS5Padding";
    private static final String HMAC_ALGORITHM = "HmacSHA256";
    private static final int HMAC_KEY_LENGTH_BITS = 256;
    private static final int IV_LENGTH_BYTES = 16;
    private static final String PBE_ALGORITHM = "PBKDF2WithHmacSHA1";
    private static final int PBE_SALT_LENGTH_BITS = 128;
    static final AtomicBoolean prngFixed = new AtomicBoolean(false);

    @Keep
    public static class CipherTextIvMac {
        private final byte[] cipherText;

        /* renamed from: iv */
        private final byte[] f3446iv;
        private final byte[] mac;

        public CipherTextIvMac(String str) {
            String[] split = str.split(":");
            if (split.length == 3) {
                this.f3446iv = Base64.decode(split[0], 2);
                this.mac = Base64.decode(split[1], 2);
                this.cipherText = Base64.decode(split[2], 2);
                return;
            }
            throw new IllegalArgumentException("Cannot parse iv:ciphertext:mac");
        }

        public CipherTextIvMac(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            this.cipherText = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.cipherText, 0, bArr.length);
            this.f3446iv = new byte[bArr2.length];
            System.arraycopy(bArr2, 0, this.f3446iv, 0, bArr2.length);
            this.mac = new byte[bArr3.length];
            System.arraycopy(bArr3, 0, this.mac, 0, bArr3.length);
        }

        public static byte[] ivCipherConcat(byte[] bArr, byte[] bArr2) {
            byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            return bArr3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            CipherTextIvMac cipherTextIvMac = (CipherTextIvMac) obj;
            return Arrays.equals(this.cipherText, cipherTextIvMac.cipherText) && Arrays.equals(this.f3446iv, cipherTextIvMac.f3446iv) && Arrays.equals(this.mac, cipherTextIvMac.mac);
        }

        public byte[] getCipherText() {
            return this.cipherText;
        }

        public byte[] getIv() {
            return this.f3446iv;
        }

        public byte[] getMac() {
            return this.mac;
        }

        public int hashCode() {
            return ((((Arrays.hashCode(this.cipherText) + 31) * 31) + Arrays.hashCode(this.f3446iv)) * 31) + Arrays.hashCode(this.mac);
        }

        public String toString() {
            String encodeToString = Base64.encodeToString(this.f3446iv, 2);
            String encodeToString2 = Base64.encodeToString(this.cipherText, 2);
            String encodeToString3 = Base64.encodeToString(this.mac, 2);
            return String.format(encodeToString + ":" + encodeToString3 + ":" + encodeToString2, new Object[0]);
        }
    }

    public static final class PrngFixes {

        /* renamed from: a */
        private static final int f3447a = 16;

        /* renamed from: b */
        private static final int f3448b = 18;

        /* renamed from: c */
        private static final byte[] f3449c = m3466g();

        @Keep
        public static class LinuxPRNGSecureRandom extends SecureRandomSpi {
            private static final File URANDOM_FILE = new File("/dev/urandom");
            private static final Object sLock = new Object();
            private static DataInputStream sUrandomIn;
            private static OutputStream sUrandomOut;
            private boolean mSeeded;

            private DataInputStream getUrandomInputStream() {
                DataInputStream dataInputStream;
                synchronized (sLock) {
                    if (sUrandomIn == null) {
                        try {
                            sUrandomIn = new DataInputStream(new FileInputStream(URANDOM_FILE));
                        } catch (IOException e) {
                            throw new SecurityException("Failed to open " + URANDOM_FILE + " for reading", e);
                        }
                    }
                    dataInputStream = sUrandomIn;
                }
                return dataInputStream;
            }

            private OutputStream getUrandomOutputStream() {
                OutputStream outputStream;
                synchronized (sLock) {
                    if (sUrandomOut == null) {
                        sUrandomOut = new FileOutputStream(URANDOM_FILE);
                    }
                    outputStream = sUrandomOut;
                }
                return outputStream;
            }

            /* access modifiers changed from: protected */
            public byte[] engineGenerateSeed(int i) {
                byte[] bArr = new byte[i];
                engineNextBytes(bArr);
                return bArr;
            }

            /* access modifiers changed from: protected */
            public void engineNextBytes(byte[] bArr) {
                DataInputStream urandomInputStream;
                if (!this.mSeeded) {
                    engineSetSeed(PrngFixes.m3464e());
                }
                try {
                    synchronized (sLock) {
                        urandomInputStream = getUrandomInputStream();
                    }
                    synchronized (urandomInputStream) {
                        urandomInputStream.readFully(bArr);
                    }
                } catch (IOException e) {
                    throw new SecurityException("Failed to read from " + URANDOM_FILE, e);
                }
            }

            /* access modifiers changed from: protected */
            public void engineSetSeed(byte[] bArr) {
                OutputStream urandomOutputStream;
                try {
                    synchronized (sLock) {
                        urandomOutputStream = getUrandomOutputStream();
                    }
                    urandomOutputStream.write(bArr);
                    urandomOutputStream.flush();
                } catch (IOException unused) {
                    try {
                        String simpleName = PrngFixes.class.getSimpleName();
                        Log.w(simpleName, "Failed to mix seed into " + URANDOM_FILE);
                    } catch (Throwable th) {
                        this.mSeeded = true;
                        throw th;
                    }
                }
                this.mSeeded = true;
            }
        }

        @Keep
        private static class LinuxPRNGSecureRandomProvider extends Provider {
            public LinuxPRNGSecureRandomProvider() {
                super("LinuxPRNG", 1.0d, "A Linux-specific random number provider that uses /dev/urandom");
                put("SecureRandom.SHA1PRNG", LinuxPRNGSecureRandom.class.getName());
                put("SecureRandom.SHA1PRNG ImplementedIn", ExifInterface.TAG_SOFTWARE);
            }
        }

        private PrngFixes() {
        }

        /* renamed from: a */
        public static void m3460a() {
            m3462c();
            m3463d();
        }

        /* renamed from: c */
        private static void m3462c() {
            if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 18) {
                try {
                    Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_seed", new Class[]{byte[].class}).invoke((Object) null, new Object[]{m3464e()});
                    int intValue = ((Integer) Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_load_file", new Class[]{String.class, Long.TYPE}).invoke((Object) null, new Object[]{"/dev/urandom", 1024})).intValue();
                    if (intValue != 1024) {
                        throw new IOException("Unexpected number of bytes read from Linux PRNG: " + intValue);
                    }
                } catch (Exception e) {
                    throw new SecurityException("Failed to seed OpenSSL PRNG", e);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            if (r0[0].getClass().getSimpleName().equals("LinuxPRNGSecureRandomProvider") != false) goto L_0x0031;
         */
        /* renamed from: d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static void m3463d() {
            /*
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 18
                if (r0 <= r1) goto L_0x0007
                return
            L_0x0007:
                java.lang.String r0 = "SecureRandom.SHA1PRNG"
                java.security.Provider[] r0 = java.security.Security.getProviders(r0)
                java.lang.Class<java.security.Security> r1 = java.security.Security.class
                monitor-enter(r1)
                r2 = 1
                if (r0 == 0) goto L_0x0029
                int r3 = r0.length     // Catch:{ all -> 0x00ae }
                if (r3 < r2) goto L_0x0029
                r3 = 0
                r0 = r0[r3]     // Catch:{ all -> 0x00ae }
                java.lang.Class r0 = r0.getClass()     // Catch:{ all -> 0x00ae }
                java.lang.String r0 = r0.getSimpleName()     // Catch:{ all -> 0x00ae }
                java.lang.String r3 = "LinuxPRNGSecureRandomProvider"
                boolean r0 = r0.equals(r3)     // Catch:{ all -> 0x00ae }
                if (r0 != 0) goto L_0x0031
            L_0x0029:
                com.salesforce.marketingcloud.tozny.AesCbcWithIntegrity$PrngFixes$LinuxPRNGSecureRandomProvider r0 = new com.salesforce.marketingcloud.tozny.AesCbcWithIntegrity$PrngFixes$LinuxPRNGSecureRandomProvider     // Catch:{ all -> 0x00ae }
                r0.<init>()     // Catch:{ all -> 0x00ae }
                java.security.Security.insertProviderAt(r0, r2)     // Catch:{ all -> 0x00ae }
            L_0x0031:
                java.security.SecureRandom r0 = new java.security.SecureRandom     // Catch:{ all -> 0x00ae }
                r0.<init>()     // Catch:{ all -> 0x00ae }
                java.security.Provider r2 = r0.getProvider()     // Catch:{ all -> 0x00ae }
                java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x00ae }
                java.lang.String r2 = r2.getSimpleName()     // Catch:{ all -> 0x00ae }
                java.lang.String r3 = "LinuxPRNGSecureRandomProvider"
                boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x00ae }
                if (r2 == 0) goto L_0x008f
                r0 = 0
                java.lang.String r2 = "SHA1PRNG"
                java.security.SecureRandom r0 = java.security.SecureRandom.getInstance(r2)     // Catch:{ NoSuchAlgorithmException -> 0x0052 }
                goto L_0x005a
            L_0x0052:
                r2 = move-exception
                java.lang.SecurityException r3 = new java.lang.SecurityException     // Catch:{ all -> 0x00ae }
                java.lang.String r4 = "SHA1PRNG not available"
                r3.<init>(r4, r2)     // Catch:{ all -> 0x00ae }
            L_0x005a:
                java.security.Provider r2 = r0.getProvider()     // Catch:{ all -> 0x00ae }
                java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x00ae }
                java.lang.String r2 = r2.getSimpleName()     // Catch:{ all -> 0x00ae }
                java.lang.String r3 = "LinuxPRNGSecureRandomProvider"
                boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x00ae }
                if (r2 == 0) goto L_0x0070
                monitor-exit(r1)     // Catch:{ all -> 0x00ae }
                return
            L_0x0070:
                java.lang.SecurityException r2 = new java.lang.SecurityException     // Catch:{ all -> 0x00ae }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ae }
                r3.<init>()     // Catch:{ all -> 0x00ae }
                java.lang.String r4 = "SecureRandom.getInstance(\"SHA1PRNG\") backed by wrong Provider: "
                r3.append(r4)     // Catch:{ all -> 0x00ae }
                java.security.Provider r0 = r0.getProvider()     // Catch:{ all -> 0x00ae }
                java.lang.Class r0 = r0.getClass()     // Catch:{ all -> 0x00ae }
                r3.append(r0)     // Catch:{ all -> 0x00ae }
                java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00ae }
                r2.<init>(r0)     // Catch:{ all -> 0x00ae }
                throw r2     // Catch:{ all -> 0x00ae }
            L_0x008f:
                java.lang.SecurityException r2 = new java.lang.SecurityException     // Catch:{ all -> 0x00ae }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ae }
                r3.<init>()     // Catch:{ all -> 0x00ae }
                java.lang.String r4 = "new SecureRandom() backed by wrong Provider: "
                r3.append(r4)     // Catch:{ all -> 0x00ae }
                java.security.Provider r0 = r0.getProvider()     // Catch:{ all -> 0x00ae }
                java.lang.Class r0 = r0.getClass()     // Catch:{ all -> 0x00ae }
                r3.append(r0)     // Catch:{ all -> 0x00ae }
                java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00ae }
                r2.<init>(r0)     // Catch:{ all -> 0x00ae }
                throw r2     // Catch:{ all -> 0x00ae }
            L_0x00ae:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00ae }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.tozny.AesCbcWithIntegrity.PrngFixes.m3463d():void");
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public static byte[] m3464e() {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeLong(System.currentTimeMillis());
                dataOutputStream.writeLong(System.nanoTime());
                dataOutputStream.writeInt(Process.myPid());
                dataOutputStream.writeInt(Process.myUid());
                dataOutputStream.write(f3449c);
                dataOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                throw new SecurityException("Failed to generate seed", e);
            }
        }

        /* renamed from: f */
        private static String m3465f() {
            try {
                return (String) Build.class.getField("SERIAL").get((Object) null);
            } catch (Exception unused) {
                return null;
            }
        }

        /* renamed from: g */
        private static byte[] m3466g() {
            StringBuilder sb = new StringBuilder();
            String str = Build.FINGERPRINT;
            if (str != null) {
                sb.append(str);
            }
            String f = m3465f();
            if (f != null) {
                sb.append(f);
            }
            try {
                return sb.toString().getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
                throw new RuntimeException("UTF-8 encoding not supported");
            }
        }
    }

    @Keep
    public static class SecretKeys {
        private SecretKey confidentialityKey;
        private SecretKey integrityKey;

        public SecretKeys(SecretKey secretKey, SecretKey secretKey2) {
            setConfidentialityKey(secretKey);
            setIntegrityKey(secretKey2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SecretKeys secretKeys = (SecretKeys) obj;
            return this.integrityKey.equals(secretKeys.integrityKey) && this.confidentialityKey.equals(secretKeys.confidentialityKey);
        }

        public SecretKey getConfidentialityKey() {
            return this.confidentialityKey;
        }

        public SecretKey getIntegrityKey() {
            return this.integrityKey;
        }

        public int hashCode() {
            return ((this.confidentialityKey.hashCode() + 31) * 31) + this.integrityKey.hashCode();
        }

        public void setConfidentialityKey(SecretKey secretKey) {
            this.confidentialityKey = secretKey;
        }

        public void setIntegrityKey(SecretKey secretKey) {
            this.integrityKey = secretKey;
        }

        public String toString() {
            return Base64.encodeToString(getConfidentialityKey().getEncoded(), 2) + ":" + Base64.encodeToString(getIntegrityKey().getEncoded(), 2);
        }
    }

    public static boolean constantTimeEq(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        byte b = 0;
        for (int i = 0; i < bArr.length; i++) {
            b |= bArr[i] ^ bArr2[i];
        }
        return b == 0;
    }

    private static byte[] copyOfRange(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        return bArr2;
    }

    public static byte[] decrypt(CipherTextIvMac cipherTextIvMac, SecretKeys secretKeys) {
        if (constantTimeEq(generateMac(CipherTextIvMac.ivCipherConcat(cipherTextIvMac.getIv(), cipherTextIvMac.getCipherText()), secretKeys.getIntegrityKey()), cipherTextIvMac.getMac())) {
            Cipher instance = Cipher.getInstance(CIPHER_TRANSFORMATION);
            instance.init(2, secretKeys.getConfidentialityKey(), new IvParameterSpec(cipherTextIvMac.getIv()));
            return instance.doFinal(cipherTextIvMac.getCipherText());
        }
        throw new GeneralSecurityException("MAC stored in civ does not match computed MAC.");
    }

    public static String decryptString(CipherTextIvMac cipherTextIvMac, SecretKeys secretKeys) {
        return decryptString(cipherTextIvMac, secretKeys, "UTF-8");
    }

    public static String decryptString(CipherTextIvMac cipherTextIvMac, SecretKeys secretKeys, String str) {
        return new String(decrypt(cipherTextIvMac, secretKeys), str);
    }

    public static CipherTextIvMac encrypt(String str, SecretKeys secretKeys) {
        return encrypt(str, secretKeys, "UTF-8");
    }

    public static CipherTextIvMac encrypt(String str, SecretKeys secretKeys, String str2) {
        return encrypt(str.getBytes(str2), secretKeys);
    }

    public static CipherTextIvMac encrypt(byte[] bArr, SecretKeys secretKeys) {
        byte[] generateIv = generateIv();
        Cipher instance = Cipher.getInstance(CIPHER_TRANSFORMATION);
        instance.init(1, secretKeys.getConfidentialityKey(), new IvParameterSpec(generateIv));
        byte[] iv = instance.getIV();
        byte[] doFinal = instance.doFinal(bArr);
        return new CipherTextIvMac(doFinal, iv, generateMac(CipherTextIvMac.ivCipherConcat(iv, doFinal), secretKeys.getIntegrityKey()));
    }

    private static void fixPrng() {
        if (!prngFixed.get()) {
            synchronized (PrngFixes.class) {
                if (!prngFixed.get()) {
                    PrngFixes.m3460a();
                    prngFixed.set(true);
                }
            }
        }
    }

    public static byte[] generateIv() {
        return randomBytes(16);
    }

    public static SecretKeys generateKey() {
        fixPrng();
        KeyGenerator instance = KeyGenerator.getInstance(CIPHER);
        instance.init(128);
        return new SecretKeys(instance.generateKey(), new SecretKeySpec(randomBytes(32), HMAC_ALGORITHM));
    }

    public static SecretKeys generateKeyFromPassword(String str, String str2, int i) {
        return generateKeyFromPassword(str, Base64.decode(str2, 2), i);
    }

    public static SecretKeys generateKeyFromPassword(String str, byte[] bArr, int i) {
        fixPrng();
        byte[] encoded = SecretKeyFactory.getInstance(PBE_ALGORITHM).generateSecret(new PBEKeySpec(str.toCharArray(), bArr, i, 384)).getEncoded();
        return new SecretKeys(new SecretKeySpec(copyOfRange(encoded, 0, 16), CIPHER), new SecretKeySpec(copyOfRange(encoded, 16, 48), HMAC_ALGORITHM));
    }

    public static byte[] generateMac(byte[] bArr, SecretKey secretKey) {
        Mac instance = Mac.getInstance(HMAC_ALGORITHM);
        instance.init(secretKey);
        return instance.doFinal(bArr);
    }

    public static byte[] generateSalt() {
        return randomBytes(128);
    }

    public static String keyString(SecretKeys secretKeys) {
        return secretKeys.toString();
    }

    public static SecretKeys keys(String str) {
        String[] split = str.split(":");
        if (split.length == 2) {
            byte[] decode = Base64.decode(split[0], 2);
            if (decode.length == 16) {
                byte[] decode2 = Base64.decode(split[1], 2);
                if (decode2.length == 32) {
                    return new SecretKeys(new SecretKeySpec(decode, 0, decode.length, CIPHER), new SecretKeySpec(decode2, HMAC_ALGORITHM));
                }
                throw new InvalidKeyException("Base64 decoded key is not 256 bytes");
            }
            throw new InvalidKeyException("Base64 decoded key is not 128 bytes");
        }
        throw new IllegalArgumentException("Cannot parse aesKey:hmacKey");
    }

    private static byte[] randomBytes(int i) {
        fixPrng();
        byte[] bArr = new byte[i];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    public static String saltString(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }
}
