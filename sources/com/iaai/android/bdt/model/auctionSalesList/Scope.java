package com.iaai.android.bdt.model.auctionSalesList;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/auctionSalesList/Scope;", "", "Count", "", "LocalizedName", "", "Name", "(ILjava/lang/String;Ljava/lang/String;)V", "getCount", "()I", "getLocalizedName", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: Scope.kt */
public final class Scope {
    private final int Count;
    @NotNull
    private final String LocalizedName;
    @NotNull
    private final String Name;

    @NotNull
    public static /* synthetic */ Scope copy$default(Scope scope, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = scope.Count;
        }
        if ((i2 & 2) != 0) {
            str = scope.LocalizedName;
        }
        if ((i2 & 4) != 0) {
            str2 = scope.Name;
        }
        return scope.copy(i, str, str2);
    }

    public final int component1() {
        return this.Count;
    }

    @NotNull
    public final String component2() {
        return this.LocalizedName;
    }

    @NotNull
    public final String component3() {
        return this.Name;
    }

    @NotNull
    public final Scope copy(int i, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "LocalizedName");
        Intrinsics.checkParameterIsNotNull(str2, "Name");
        return new Scope(i, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Scope) {
                Scope scope = (Scope) obj;
                if (!(this.Count == scope.Count) || !Intrinsics.areEqual((Object) this.LocalizedName, (Object) scope.LocalizedName) || !Intrinsics.areEqual((Object) this.Name, (Object) scope.Name)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = Integer.valueOf(this.Count).hashCode() * 31;
        String str = this.LocalizedName;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.Name;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        return "Scope(Count=" + this.Count + ", LocalizedName=" + this.LocalizedName + ", Name=" + this.Name + ")";
    }

    public Scope(int i, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "LocalizedName");
        Intrinsics.checkParameterIsNotNull(str2, "Name");
        this.Count = i;
        this.LocalizedName = str;
        this.Name = str2;
    }

    public final int getCount() {
        return this.Count;
    }

    @NotNull
    public final String getLocalizedName() {
        return this.LocalizedName;
    }

    @NotNull
    public final String getName() {
        return this.Name;
    }
}
