package com.iaai.android.bdt.model.productDetail.chromeSection;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/chromeSection/Attribute;", "", "Name", "", "Values", "", "(Ljava/lang/String;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getValues", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: Attribute.kt */
public final class Attribute {
    @NotNull
    private final String Name;
    @NotNull
    private final List<String> Values;

    @NotNull
    public static /* synthetic */ Attribute copy$default(Attribute attribute, String str, List<String> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = attribute.Name;
        }
        if ((i & 2) != 0) {
            list = attribute.Values;
        }
        return attribute.copy(str, list);
    }

    @NotNull
    public final String component1() {
        return this.Name;
    }

    @NotNull
    public final List<String> component2() {
        return this.Values;
    }

    @NotNull
    public final Attribute copy(@NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkParameterIsNotNull(str, "Name");
        Intrinsics.checkParameterIsNotNull(list, "Values");
        return new Attribute(str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Attribute)) {
            return false;
        }
        Attribute attribute = (Attribute) obj;
        return Intrinsics.areEqual((Object) this.Name, (Object) attribute.Name) && Intrinsics.areEqual((Object) this.Values, (Object) attribute.Values);
    }

    public int hashCode() {
        String str = this.Name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this.Values;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "Attribute(Name=" + this.Name + ", Values=" + this.Values + ")";
    }

    public Attribute(@NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkParameterIsNotNull(str, "Name");
        Intrinsics.checkParameterIsNotNull(list, "Values");
        this.Name = str;
        this.Values = list;
    }

    @NotNull
    public final String getName() {
        return this.Name;
    }

    @NotNull
    public final List<String> getValues() {
        return this.Values;
    }
}
