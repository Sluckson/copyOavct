package com.salesforce.marketingcloud.p027e;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import java.security.GeneralSecurityException;
import java.text.NumberFormat;

@SuppressLint({"UnknownNullness"})
/* renamed from: com.salesforce.marketingcloud.e.f */
public class C4027f extends C4022a {

    /* renamed from: a */
    private static final String f2925a = "ETPush";

    public C4027f(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        super(context, str, str2, str3, 10000);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final String mo56543a(@NonNull Context context, @NonNull String str) {
        int i;
        String string = context.getSharedPreferences(f2925a, 0).getString("install_date_enc", (String) null);
        if (string != null) {
            try {
                i = NumberFormat.getInstance().parse(C4029h.m2775b(str + "29200FA5-DF79-4C3F-BC0F-E2FF3CE6199A")).intValue();
            } catch (Exception unused) {
                i = 200;
            }
            return C4029h.m2775b(string.substring(Integer.valueOf(String.valueOf(i).substring(0, 1)).intValue()));
        }
        throw new GeneralSecurityException("Unable to get old salt.");
    }
}
