package com.iaai.android.bdt.model.productDetail.biddingInfo;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001b"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/biddingInfo/DisplayValue;", "Ljava/io/Serializable;", "Highlight", "", "Label", "", "Meta", "", "Text", "(ZLjava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "getHighlight", "()Z", "getLabel", "()Ljava/lang/String;", "getMeta", "()Ljava/lang/Object;", "getText", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: DisplayValue.kt */
public final class DisplayValue implements Serializable {
    private final boolean Highlight;
    @NotNull
    private final String Label;
    @NotNull
    private final Object Meta;
    @NotNull
    private final String Text;

    @NotNull
    public static /* synthetic */ DisplayValue copy$default(DisplayValue displayValue, boolean z, String str, Object obj, String str2, int i, Object obj2) {
        if ((i & 1) != 0) {
            z = displayValue.Highlight;
        }
        if ((i & 2) != 0) {
            str = displayValue.Label;
        }
        if ((i & 4) != 0) {
            obj = displayValue.Meta;
        }
        if ((i & 8) != 0) {
            str2 = displayValue.Text;
        }
        return displayValue.copy(z, str, obj, str2);
    }

    public final boolean component1() {
        return this.Highlight;
    }

    @NotNull
    public final String component2() {
        return this.Label;
    }

    @NotNull
    public final Object component3() {
        return this.Meta;
    }

    @NotNull
    public final String component4() {
        return this.Text;
    }

    @NotNull
    public final DisplayValue copy(boolean z, @NotNull String str, @NotNull Object obj, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "Label");
        Intrinsics.checkParameterIsNotNull(obj, "Meta");
        Intrinsics.checkParameterIsNotNull(str2, "Text");
        return new DisplayValue(z, str, obj, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof DisplayValue) {
                DisplayValue displayValue = (DisplayValue) obj;
                if (!(this.Highlight == displayValue.Highlight) || !Intrinsics.areEqual((Object) this.Label, (Object) displayValue.Label) || !Intrinsics.areEqual(this.Meta, displayValue.Meta) || !Intrinsics.areEqual((Object) this.Text, (Object) displayValue.Text)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.Highlight;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        String str = this.Label;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        Object obj = this.Meta;
        int hashCode2 = (hashCode + (obj != null ? obj.hashCode() : 0)) * 31;
        String str2 = this.Text;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    @NotNull
    public String toString() {
        return "DisplayValue(Highlight=" + this.Highlight + ", Label=" + this.Label + ", Meta=" + this.Meta + ", Text=" + this.Text + ")";
    }

    public DisplayValue(boolean z, @NotNull String str, @NotNull Object obj, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "Label");
        Intrinsics.checkParameterIsNotNull(obj, "Meta");
        Intrinsics.checkParameterIsNotNull(str2, "Text");
        this.Highlight = z;
        this.Label = str;
        this.Meta = obj;
        this.Text = str2;
    }

    public final boolean getHighlight() {
        return this.Highlight;
    }

    @NotNull
    public final String getLabel() {
        return this.Label;
    }

    @NotNull
    public final Object getMeta() {
        return this.Meta;
    }

    @NotNull
    public final String getText() {
        return this.Text;
    }
}
