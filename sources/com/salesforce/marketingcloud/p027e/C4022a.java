package com.salesforce.marketingcloud.p027e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.salesforce.marketingcloud.tozny.AesCbcWithIntegrity;
import java.security.GeneralSecurityException;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.e.a */
public class C4022a extends AesCbcWithIntegrity {

    /* renamed from: a */
    private static final String f2915a = "F6389234-1024-481F-9173-37D9D7F5051F";

    /* renamed from: b */
    private static final String f2916b = "com.salesforce.marketingcloud.storagePrefs";

    /* renamed from: c */
    private static final String f2917c = "install_date_enc";

    /* renamed from: d */
    private static final int f2918d = 500;

    /* renamed from: e */
    private final AesCbcWithIntegrity.SecretKeys f2919e;

    public C4022a(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        this(context, str, str2, str3, 500);
    }

    protected C4022a(Context context, String str, String str2, String str3, int i) {
        this.f2919e = AesCbcWithIntegrity.generateKeyFromPassword(m2747a(str, str2, str3), mo56543a(context, str), i);
        m2748a();
    }

    /* renamed from: a */
    private String m2747a(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        return Base64.encodeToString(C4029h.m2775b(str + "--" + C4029h.m2775b(str2) + "__" + C4029h.m2775b(str3)).getBytes(), 2);
    }

    /* renamed from: a */
    private void m2748a() {
        if (!mo56545b(mo56544a(f2915a)).equals(f2915a)) {
            throw new GeneralSecurityException("Encryption/decryption test failed");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo56543a(@NonNull Context context, @NonNull String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f2916b, 0);
        String string = sharedPreferences.getString(f2917c, (String) null);
        if (string != null) {
            return string;
        }
        String saltString = saltString(generateSalt());
        sharedPreferences.edit().putString(f2917c, saltString).apply();
        return saltString;
    }

    /* renamed from: a */
    public String mo56544a(String str) {
        if (str == null) {
            return null;
        }
        return encrypt(str, this.f2919e).toString();
    }

    /* renamed from: b */
    public String mo56545b(String str) {
        if (str == null) {
            return null;
        }
        return decryptString(new AesCbcWithIntegrity.CipherTextIvMac(str), this.f2919e);
    }
}
