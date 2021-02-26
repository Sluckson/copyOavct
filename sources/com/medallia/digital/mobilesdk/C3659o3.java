package com.medallia.digital.mobilesdk;

import android.annotation.TargetApi;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.medallia.digital.mobilesdk.C3815z4;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;

/* renamed from: com.medallia.digital.mobilesdk.o3 */
class C3659o3 implements C3713r5 {

    /* renamed from: b */
    private static final String f1599b = "AndroidKeyStore";

    /* renamed from: c */
    private static final String f1600c = "AES/GCM/NoPadding";

    /* renamed from: d */
    private static final String f1601d = "RSA/ECB/PKCS1Padding";

    /* renamed from: e */
    private static final String f1602e = "MD_SDK_KEYSTORE_V2";

    /* renamed from: f */
    private static final String f1603f = "MD_SDK_KEYSTORE";

    /* renamed from: g */
    private static final String f1604g = "CN=MD_SDK_KEYSTORE_V2";

    /* renamed from: h */
    private static final String f1605h = "AndroidOpenSSL";

    /* renamed from: i */
    private static final int f1606i = 30;

    /* renamed from: j */
    private static final int f1607j = 16;

    /* renamed from: k */
    private static final int f1608k = 12;

    /* renamed from: l */
    private static final int f1609l = 128;

    /* renamed from: m */
    private static final String f1610m = "AES";

    /* renamed from: n */
    private static final String f1611n = "RSA";

    /* renamed from: o */
    private static C3659o3 f1612o;

    /* renamed from: a */
    private KeyStore f1613a;

    private C3659o3() {
        m1388c();
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            m1397l();
        } else if (i >= 18) {
            m1396k();
        } else {
            m1386b();
        }
    }

    /* renamed from: a */
    private void m1384a() {
        try {
            if (this.f1613a.containsAlias(f1603f)) {
                this.f1613a.deleteEntry(f1603f);
            }
        } catch (KeyStoreException e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* renamed from: a */
    private byte[] m1385a(byte[] bArr) {
        try {
            Cipher instance = Cipher.getInstance(f1601d, f1605h);
            instance.init(2, ((KeyStore.PrivateKeyEntry) this.f1613a.getEntry(f1602e, (KeyStore.ProtectionParameter) null)).getPrivateKey());
            CipherInputStream cipherInputStream = new CipherInputStream(new ByteArrayInputStream(bArr), instance);
            ArrayList arrayList = new ArrayList();
            while (true) {
                int read = cipherInputStream.read();
                if (read == -1) {
                    break;
                }
                arrayList.add(Byte.valueOf((byte) read));
            }
            byte[] bArr2 = new byte[arrayList.size()];
            for (int i = 0; i < bArr2.length; i++) {
                bArr2[i] = ((Byte) arrayList.get(i)).byteValue();
            }
            return bArr2;
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return new byte[0];
        }
    }

    /* renamed from: b */
    private void m1386b() {
        try {
            C3815z4.m2010d().mo55980b().edit().remove("MD_KEY_IV").commit();
            C3815z4.m2010d().mo55980b().edit().remove("MD_KEY_AES").commit();
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* renamed from: b */
    private byte[] m1387b(byte[] bArr) {
        try {
            Cipher instance = Cipher.getInstance(f1601d, f1605h);
            instance.init(1, ((KeyStore.PrivateKeyEntry) this.f1613a.getEntry(f1602e, (KeyStore.ProtectionParameter) null)).getCertificate().getPublicKey());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, instance);
            cipherOutputStream.write(bArr);
            cipherOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return new byte[0];
        }
    }

    /* renamed from: c */
    private void m1388c() {
        if (C3815z4.m2010d().mo55975a(C3815z4.C3816a.LENNY, "").equals("")) {
            byte[] bArr = new byte[12];
            new SecureRandom().nextBytes(bArr);
            C3815z4.m2010d().mo55984b(C3815z4.C3816a.LENNY, Base64.encodeToString(bArr, 0));
        }
    }

    /* renamed from: d */
    private void m1389d() {
        if (C3815z4.m2010d().mo55975a(C3815z4.C3816a.NALA, (String) null) == null) {
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            C3815z4.m2010d().mo55984b(C3815z4.C3816a.NALA, Base64.encodeToString(m1387b(bArr), 0));
        }
    }

    /* renamed from: e */
    private byte[] m1390e() {
        return Base64.decode(C3815z4.m2010d().mo55975a(C3815z4.C3816a.LENNY, ""), 0);
    }

    /* renamed from: f */
    protected static C3659o3 m1391f() {
        if (f1612o == null) {
            f1612o = new C3659o3();
        }
        return f1612o;
    }

    /* renamed from: g */
    private Key m1392g() {
        int i = Build.VERSION.SDK_INT;
        return i >= 23 ? m1394i() : i >= 18 ? m1393h() : m1395j();
    }

    /* renamed from: h */
    private Key m1393h() {
        String a = C3815z4.m2010d().mo55975a(C3815z4.C3816a.NALA, (String) null);
        if (a == null) {
            m1389d();
        }
        return new SecretKeySpec(m1385a(Base64.decode(a, 0)), f1610m);
    }

    /* renamed from: i */
    private Key m1394i() {
        try {
            return this.f1613a.getKey(f1602e, (char[]) null);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return null;
        }
    }

    /* renamed from: j */
    private Key m1395j() {
        try {
            String l = Long.toString(C3595k3.m1060d().mo55513b().getPackageManager().getPackageInfo(C3595k3.m1060d().mo55513b().getPackageName(), 0).firstInstallTime);
            byte[] bArr = new byte[16];
            for (int i = 0; i < Math.min(l.length(), bArr.length); i++) {
                bArr[i] = l.getBytes()[i];
            }
            return new SecretKeySpec(bArr, f1610m);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return null;
        }
    }

    @TargetApi(18)
    /* renamed from: k */
    private void m1396k() {
        try {
            this.f1613a = KeyStore.getInstance(f1599b);
            this.f1613a.load((KeyStore.LoadStoreParameter) null);
            if (!this.f1613a.containsAlias(f1602e)) {
                m1384a();
                m1386b();
                Calendar instance = Calendar.getInstance();
                Calendar instance2 = Calendar.getInstance();
                instance2.add(1, 30);
                KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(C3595k3.m1060d().mo55513b()).setAlias(f1602e).setSubject(new X500Principal(f1604g)).setSerialNumber(BigInteger.TEN).setStartDate(instance.getTime()).setEndDate(instance2.getTime()).build();
                KeyPairGenerator instance3 = KeyPairGenerator.getInstance(f1611n, f1599b);
                instance3.initialize(build);
                instance3.generateKeyPair();
                m1389d();
            }
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    @TargetApi(23)
    /* renamed from: l */
    private void m1397l() {
        try {
            this.f1613a = KeyStore.getInstance(f1599b);
            this.f1613a.load((KeyStore.LoadStoreParameter) null);
            if (!this.f1613a.containsAlias(f1602e)) {
                m1384a();
                m1386b();
                KeyGenerator instance = KeyGenerator.getInstance(f1610m, f1599b);
                instance.init(new KeyGenParameterSpec.Builder(f1602e, 3).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).setRandomizedEncryptionRequired(false).build());
                instance.generateKey();
            }
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo55687a(C3815z4.C3816a aVar) {
        String a = C3815z4.m2010d().mo55975a(aVar, (String) null);
        if (!TextUtils.isEmpty(a)) {
            return mo55688a(a);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo55688a(String str) {
        Key g;
        AlgorithmParameterSpec ivParameterSpec;
        try {
            Cipher instance = Cipher.getInstance(f1600c);
            if (Build.VERSION.SDK_INT >= 21) {
                g = m1392g();
                ivParameterSpec = new GCMParameterSpec(128, m1390e());
            } else {
                g = m1392g();
                ivParameterSpec = new IvParameterSpec(m1390e());
            }
            instance.init(2, g, ivParameterSpec);
            return new String(instance.doFinal(Base64.decode(str, 0)));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return "";
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55689a(C3815z4.C3816a aVar, String str) {
        C3815z4.m2010d().mo55984b(aVar, !TextUtils.isEmpty(str) ? mo55690b(str) : null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo55690b(String str) {
        Key g;
        AlgorithmParameterSpec ivParameterSpec;
        try {
            Cipher instance = Cipher.getInstance(f1600c);
            if (Build.VERSION.SDK_INT >= 21) {
                g = m1392g();
                ivParameterSpec = new GCMParameterSpec(128, m1390e());
            } else {
                g = m1392g();
                ivParameterSpec = new IvParameterSpec(m1390e());
            }
            instance.init(1, g, ivParameterSpec);
            return Base64.encodeToString(instance.doFinal(str.getBytes()), 0);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return "";
        }
    }

    public void clearAndDisconnect() {
        f1612o = null;
    }
}
