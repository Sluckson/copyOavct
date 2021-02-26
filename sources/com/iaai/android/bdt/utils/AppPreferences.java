package com.iaai.android.bdt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0006J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0006J\u0016\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0010J\u0016\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0014J\u0016\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, mo66933d2 = {"Lcom/iaai/android/bdt/utils/AppPreferences;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "PREFS_NAME", "", "getContext", "()Landroid/content/Context;", "sharedPref", "Landroid/content/SharedPreferences;", "getSharedPref", "()Landroid/content/SharedPreferences;", "clearSharedPreference", "", "getValueBoolien", "", "KEY_NAME", "defaultValue", "getValueInt", "", "getValueString", "removeValue", "save", "status", "value", "text", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AppPreferences.kt */
public final class AppPreferences {
    private final String PREFS_NAME = "Buyer";
    @NotNull
    private final Context context;
    @NotNull
    private final SharedPreferences sharedPref;

    public AppPreferences(@NotNull Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(this.PREFS_NAME, 0);
        Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        this.sharedPref = sharedPreferences;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final SharedPreferences getSharedPref() {
        return this.sharedPref;
    }

    public final void save(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "KEY_NAME");
        Intrinsics.checkParameterIsNotNull(str2, "text");
        SharedPreferences.Editor edit = this.sharedPref.edit();
        Intrinsics.checkExpressionValueIsNotNull(edit, "sharedPref.edit()");
        edit.putString(str, str2);
        if (edit == null) {
            Intrinsics.throwNpe();
        }
        edit.commit();
    }

    public final void save(@NotNull String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "KEY_NAME");
        SharedPreferences.Editor edit = this.sharedPref.edit();
        Intrinsics.checkExpressionValueIsNotNull(edit, "sharedPref.edit()");
        edit.putInt(str, i);
        edit.commit();
    }

    public final void save(@NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "KEY_NAME");
        SharedPreferences.Editor edit = this.sharedPref.edit();
        Intrinsics.checkExpressionValueIsNotNull(edit, "sharedPref.edit()");
        edit.putBoolean(str, z);
        edit.commit();
    }

    @Nullable
    public final String getValueString(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "KEY_NAME");
        return this.sharedPref.getString(str, (String) null);
    }

    public final int getValueInt(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "KEY_NAME");
        return this.sharedPref.getInt(str, 0);
    }

    public final boolean getValueBoolien(@NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "KEY_NAME");
        return this.sharedPref.getBoolean(str, z);
    }

    public final void clearSharedPreference() {
        SharedPreferences.Editor edit = this.sharedPref.edit();
        Intrinsics.checkExpressionValueIsNotNull(edit, "sharedPref.edit()");
        edit.clear();
        edit.commit();
    }

    public final void removeValue(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "KEY_NAME");
        SharedPreferences.Editor edit = this.sharedPref.edit();
        Intrinsics.checkExpressionValueIsNotNull(edit, "sharedPref.edit()");
        edit.remove(str);
        edit.commit();
    }
}
