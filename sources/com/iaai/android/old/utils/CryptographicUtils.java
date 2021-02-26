package com.iaai.android.old.utils;

import android.util.Base64;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CryptographicUtils {
    private final String aesEncryptionAlgorithm = "AES";
    private final String characterEncoding = "UTF-8";
    private final String cipherTransformation = "AES/CBC/PKCS5Padding";

    private byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(bArr3));
        return instance.doFinal(bArr);
    }

    private byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(bArr3));
        return instance.doFinal(bArr);
    }

    private byte[] getKeyBytes(String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[16];
        byte[] bytes = str.getBytes("UTF-8");
        System.arraycopy(bytes, 0, bArr, 0, Math.min(bytes.length, bArr.length));
        return bArr;
    }

    public String encrypt(String str, String str2) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] bytes = str.getBytes("UTF-8");
        byte[] keyBytes = getKeyBytes(str2);
        return Base64.encodeToString(encrypt(bytes, keyBytes, keyBytes), 2);
    }

    public String decrypt(String str, String str2) throws KeyException, GeneralSecurityException, GeneralSecurityException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, IOException {
        byte[] decode = Base64.decode(str, 0);
        byte[] keyBytes = getKeyBytes(str2);
        return new String(decrypt(decode, keyBytes, keyBytes), "UTF-8");
    }
}
