package com.salesforce.marketingcloud;

import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: com.salesforce.marketingcloud.j */
interface C4041j {
    @NonNull

    /* renamed from: a */
    public static final String f2954a = "openDirect";
    @NonNull

    /* renamed from: b */
    public static final String f2955b = "cloudPage";

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.salesforce.marketingcloud.j$a */
    public @interface C4042a {
    }

    @Nullable
    /* renamed from: a */
    PendingIntent mo56554a(@NonNull Context context, @NonNull String str, @NonNull String str2);
}
