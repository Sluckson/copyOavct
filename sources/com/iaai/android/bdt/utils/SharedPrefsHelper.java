package com.iaai.android.bdt.utils;

import android.content.SharedPreferences;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Singleton
@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\nJ \u0010\u0005\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\fJ \u0010\u0005\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u000eJ \u0010\u0005\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u0010J\u0019\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0006J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000bJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\rJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000fJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo66933d2 = {"Lcom/iaai/android/bdt/utils/SharedPrefsHelper;", "", "mSharedPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "get", "", "key", "", "defaultValue", "(Ljava/lang/String;Z)Ljava/lang/Boolean;", "", "(Ljava/lang/String;F)Ljava/lang/Float;", "", "(Ljava/lang/String;I)Ljava/lang/Integer;", "", "(Ljava/lang/String;J)Ljava/lang/Long;", "put", "", "value", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SharedPrefsHelper.kt */
public final class SharedPrefsHelper {
    private final SharedPreferences mSharedPreferences;

    @Inject
    public SharedPrefsHelper(@NotNull SharedPreferences sharedPreferences) {
        Intrinsics.checkParameterIsNotNull(sharedPreferences, "mSharedPreferences");
        this.mSharedPreferences = sharedPreferences;
    }

    public final void put(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(str2, "value");
        this.mSharedPreferences.edit().putString(str, str2).apply();
    }

    public final void put(@NotNull String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        this.mSharedPreferences.edit().putInt(str, i).apply();
    }

    public final void put(@NotNull String str, long j) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        this.mSharedPreferences.edit().putLong(str, j).apply();
    }

    public final void put(@NotNull String str, float f) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        this.mSharedPreferences.edit().putFloat(str, f).apply();
    }

    public final void put(@NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        this.mSharedPreferences.edit().putBoolean(str, z).apply();
    }

    @NotNull
    public final String get(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(str2, "defaultValue");
        String string = this.mSharedPreferences.getString(str, str2);
        Intrinsics.checkExpressionValueIsNotNull(string, "mSharedPreferences.getString(key, defaultValue)");
        return string;
    }

    @Nullable
    public final Integer get(@NotNull String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        return Integer.valueOf(this.mSharedPreferences.getInt(str, i));
    }

    @Nullable
    public final Float get(@NotNull String str, float f) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        return Float.valueOf(this.mSharedPreferences.getFloat(str, f));
    }

    @Nullable
    public final Boolean get(@NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        return Boolean.valueOf(this.mSharedPreferences.getBoolean(str, z));
    }

    @Nullable
    public final Long get(@NotNull String str, long j) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        return Long.valueOf(this.mSharedPreferences.getLong(str, j));
    }
}
