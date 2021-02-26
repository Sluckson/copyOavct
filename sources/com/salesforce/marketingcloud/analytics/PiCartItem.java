package com.salesforce.marketingcloud.analytics;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.salesforce.marketingcloud.MCKeep;
import org.json.JSONObject;

@AutoValue
public abstract class PiCartItem implements Parcelable {
    @NonNull
    @MCKeep
    public static PiCartItem create(@NonNull String str, int i, double d) {
        return new C3916g(str, i, d, (String) null);
    }

    @NonNull
    @MCKeep
    public static PiCartItem create(@NonNull String str, int i, double d, @Nullable String str2) {
        return new C3916g(str, i, d, str2);
    }

    @NonNull
    /* renamed from: a */
    public abstract JSONObject mo56248a();

    @NonNull
    @MCKeep
    public abstract String item();

    @NonNull
    @MCKeep
    public abstract double price();

    @NonNull
    @MCKeep
    public abstract int quantity();

    @Nullable
    @MCKeep
    public abstract String uniqueId();
}
