package com.iaai.android.bdt.model.productDetail.biddingInfo;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006 "}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/biddingInfo/Image;", "Ljava/io/Serializable;", "BigThumbImageUrl", "", "DeapZoomUrl", "ThumbImageUrl", "Url", "height", "", "width", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getBigThumbImageUrl", "()Ljava/lang/String;", "getDeapZoomUrl", "getThumbImageUrl", "getUrl", "getHeight", "()I", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: Image.kt */
public final class Image implements Serializable {
    @NotNull
    private final String BigThumbImageUrl;
    @NotNull
    private final String DeapZoomUrl;
    @NotNull
    private final String ThumbImageUrl;
    @NotNull
    private final String Url;
    private final int height;
    private final int width;

    @NotNull
    public static /* synthetic */ Image copy$default(Image image, String str, String str2, String str3, String str4, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = image.BigThumbImageUrl;
        }
        if ((i3 & 2) != 0) {
            str2 = image.DeapZoomUrl;
        }
        String str5 = str2;
        if ((i3 & 4) != 0) {
            str3 = image.ThumbImageUrl;
        }
        String str6 = str3;
        if ((i3 & 8) != 0) {
            str4 = image.Url;
        }
        String str7 = str4;
        if ((i3 & 16) != 0) {
            i = image.height;
        }
        int i4 = i;
        if ((i3 & 32) != 0) {
            i2 = image.width;
        }
        return image.copy(str, str5, str6, str7, i4, i2);
    }

    @NotNull
    public final String component1() {
        return this.BigThumbImageUrl;
    }

    @NotNull
    public final String component2() {
        return this.DeapZoomUrl;
    }

    @NotNull
    public final String component3() {
        return this.ThumbImageUrl;
    }

    @NotNull
    public final String component4() {
        return this.Url;
    }

    public final int component5() {
        return this.height;
    }

    public final int component6() {
        return this.width;
    }

    @NotNull
    public final Image copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "BigThumbImageUrl");
        Intrinsics.checkParameterIsNotNull(str2, "DeapZoomUrl");
        Intrinsics.checkParameterIsNotNull(str3, "ThumbImageUrl");
        Intrinsics.checkParameterIsNotNull(str4, "Url");
        return new Image(str, str2, str3, str4, i, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Image) {
                Image image = (Image) obj;
                if (Intrinsics.areEqual((Object) this.BigThumbImageUrl, (Object) image.BigThumbImageUrl) && Intrinsics.areEqual((Object) this.DeapZoomUrl, (Object) image.DeapZoomUrl) && Intrinsics.areEqual((Object) this.ThumbImageUrl, (Object) image.ThumbImageUrl) && Intrinsics.areEqual((Object) this.Url, (Object) image.Url)) {
                    if (this.height == image.height) {
                        if (this.width == image.width) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.BigThumbImageUrl;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.DeapZoomUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.ThumbImageUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.Url;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return ((((hashCode3 + i) * 31) + Integer.valueOf(this.height).hashCode()) * 31) + Integer.valueOf(this.width).hashCode();
    }

    @NotNull
    public String toString() {
        return "Image(BigThumbImageUrl=" + this.BigThumbImageUrl + ", DeapZoomUrl=" + this.DeapZoomUrl + ", ThumbImageUrl=" + this.ThumbImageUrl + ", Url=" + this.Url + ", height=" + this.height + ", width=" + this.width + ")";
    }

    public Image(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "BigThumbImageUrl");
        Intrinsics.checkParameterIsNotNull(str2, "DeapZoomUrl");
        Intrinsics.checkParameterIsNotNull(str3, "ThumbImageUrl");
        Intrinsics.checkParameterIsNotNull(str4, "Url");
        this.BigThumbImageUrl = str;
        this.DeapZoomUrl = str2;
        this.ThumbImageUrl = str3;
        this.Url = str4;
        this.height = i;
        this.width = i2;
    }

    @NotNull
    public final String getBigThumbImageUrl() {
        return this.BigThumbImageUrl;
    }

    @NotNull
    public final String getDeapZoomUrl() {
        return this.DeapZoomUrl;
    }

    @NotNull
    public final String getThumbImageUrl() {
        return this.ThumbImageUrl;
    }

    @NotNull
    public final String getUrl() {
        return this.Url;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }
}
