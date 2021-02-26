package com.iaai.android.bdt.model.productDetail.biddingInfo;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0002\u0010\u0010J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jw\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001J\u0013\u0010'\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0017R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0017¨\u0006-"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ImageInformation;", "Ljava/io/Serializable;", "Image360Url", "", "SalvageID", "images", "", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/Image;", "isHDImage", "", "isImage360", "KeyImage", "EngineVideo", "TireTread", "TireTreadUrl", "UndercarriageInd", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Z)V", "getEngineVideo", "()Ljava/lang/String;", "getImage360Url", "getKeyImage", "getSalvageID", "getTireTread", "()Z", "getTireTreadUrl", "getUndercarriageInd", "getImages", "()Ljava/util/List;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ImageInformation.kt */
public final class ImageInformation implements Serializable {
    @Nullable
    private final String EngineVideo;
    @NotNull
    private final String Image360Url;
    @NotNull
    private final String KeyImage;
    @NotNull
    private final String SalvageID;
    private final boolean TireTread;
    @Nullable
    private final String TireTreadUrl;
    private final boolean UndercarriageInd;
    @NotNull
    private final List<Image> images;
    private final boolean isHDImage;
    private final boolean isImage360;

    @NotNull
    public static /* synthetic */ ImageInformation copy$default(ImageInformation imageInformation, String str, String str2, List list, boolean z, boolean z2, String str3, String str4, boolean z3, String str5, boolean z4, int i, Object obj) {
        ImageInformation imageInformation2 = imageInformation;
        int i2 = i;
        return imageInformation.copy((i2 & 1) != 0 ? imageInformation2.Image360Url : str, (i2 & 2) != 0 ? imageInformation2.SalvageID : str2, (i2 & 4) != 0 ? imageInformation2.images : list, (i2 & 8) != 0 ? imageInformation2.isHDImage : z, (i2 & 16) != 0 ? imageInformation2.isImage360 : z2, (i2 & 32) != 0 ? imageInformation2.KeyImage : str3, (i2 & 64) != 0 ? imageInformation2.EngineVideo : str4, (i2 & 128) != 0 ? imageInformation2.TireTread : z3, (i2 & 256) != 0 ? imageInformation2.TireTreadUrl : str5, (i2 & 512) != 0 ? imageInformation2.UndercarriageInd : z4);
    }

    @NotNull
    public final String component1() {
        return this.Image360Url;
    }

    public final boolean component10() {
        return this.UndercarriageInd;
    }

    @NotNull
    public final String component2() {
        return this.SalvageID;
    }

    @NotNull
    public final List<Image> component3() {
        return this.images;
    }

    public final boolean component4() {
        return this.isHDImage;
    }

    public final boolean component5() {
        return this.isImage360;
    }

    @NotNull
    public final String component6() {
        return this.KeyImage;
    }

    @Nullable
    public final String component7() {
        return this.EngineVideo;
    }

    public final boolean component8() {
        return this.TireTread;
    }

    @Nullable
    public final String component9() {
        return this.TireTreadUrl;
    }

    @NotNull
    public final ImageInformation copy(@NotNull String str, @NotNull String str2, @NotNull List<Image> list, boolean z, boolean z2, @NotNull String str3, @Nullable String str4, boolean z3, @Nullable String str5, boolean z4) {
        Intrinsics.checkParameterIsNotNull(str, "Image360Url");
        Intrinsics.checkParameterIsNotNull(str2, "SalvageID");
        Intrinsics.checkParameterIsNotNull(list, "images");
        String str6 = str3;
        Intrinsics.checkParameterIsNotNull(str6, "KeyImage");
        return new ImageInformation(str, str2, list, z, z2, str6, str4, z3, str5, z4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof ImageInformation) {
                ImageInformation imageInformation = (ImageInformation) obj;
                if (Intrinsics.areEqual((Object) this.Image360Url, (Object) imageInformation.Image360Url) && Intrinsics.areEqual((Object) this.SalvageID, (Object) imageInformation.SalvageID) && Intrinsics.areEqual((Object) this.images, (Object) imageInformation.images)) {
                    if (this.isHDImage == imageInformation.isHDImage) {
                        if ((this.isImage360 == imageInformation.isImage360) && Intrinsics.areEqual((Object) this.KeyImage, (Object) imageInformation.KeyImage) && Intrinsics.areEqual((Object) this.EngineVideo, (Object) imageInformation.EngineVideo)) {
                            if ((this.TireTread == imageInformation.TireTread) && Intrinsics.areEqual((Object) this.TireTreadUrl, (Object) imageInformation.TireTreadUrl)) {
                                if (this.UndercarriageInd == imageInformation.UndercarriageInd) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.Image360Url;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.SalvageID;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<Image> list = this.images;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z = this.isHDImage;
        if (z) {
            z = true;
        }
        int i2 = (hashCode3 + (z ? 1 : 0)) * 31;
        boolean z2 = this.isImage360;
        if (z2) {
            z2 = true;
        }
        int i3 = (i2 + (z2 ? 1 : 0)) * 31;
        String str3 = this.KeyImage;
        int hashCode4 = (i3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.EngineVideo;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        boolean z3 = this.TireTread;
        if (z3) {
            z3 = true;
        }
        int i4 = (hashCode5 + (z3 ? 1 : 0)) * 31;
        String str5 = this.TireTreadUrl;
        if (str5 != null) {
            i = str5.hashCode();
        }
        int i5 = (i4 + i) * 31;
        boolean z4 = this.UndercarriageInd;
        if (z4) {
            z4 = true;
        }
        return i5 + (z4 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "ImageInformation(Image360Url=" + this.Image360Url + ", SalvageID=" + this.SalvageID + ", images=" + this.images + ", isHDImage=" + this.isHDImage + ", isImage360=" + this.isImage360 + ", KeyImage=" + this.KeyImage + ", EngineVideo=" + this.EngineVideo + ", TireTread=" + this.TireTread + ", TireTreadUrl=" + this.TireTreadUrl + ", UndercarriageInd=" + this.UndercarriageInd + ")";
    }

    public ImageInformation(@NotNull String str, @NotNull String str2, @NotNull List<Image> list, boolean z, boolean z2, @NotNull String str3, @Nullable String str4, boolean z3, @Nullable String str5, boolean z4) {
        Intrinsics.checkParameterIsNotNull(str, "Image360Url");
        Intrinsics.checkParameterIsNotNull(str2, "SalvageID");
        Intrinsics.checkParameterIsNotNull(list, "images");
        Intrinsics.checkParameterIsNotNull(str3, "KeyImage");
        this.Image360Url = str;
        this.SalvageID = str2;
        this.images = list;
        this.isHDImage = z;
        this.isImage360 = z2;
        this.KeyImage = str3;
        this.EngineVideo = str4;
        this.TireTread = z3;
        this.TireTreadUrl = str5;
        this.UndercarriageInd = z4;
    }

    @NotNull
    public final String getImage360Url() {
        return this.Image360Url;
    }

    @NotNull
    public final String getSalvageID() {
        return this.SalvageID;
    }

    @NotNull
    public final List<Image> getImages() {
        return this.images;
    }

    public final boolean isHDImage() {
        return this.isHDImage;
    }

    public final boolean isImage360() {
        return this.isImage360;
    }

    @NotNull
    public final String getKeyImage() {
        return this.KeyImage;
    }

    @Nullable
    public final String getEngineVideo() {
        return this.EngineVideo;
    }

    public final boolean getTireTread() {
        return this.TireTread;
    }

    @Nullable
    public final String getTireTreadUrl() {
        return this.TireTreadUrl;
    }

    public final boolean getUndercarriageInd() {
        return this.UndercarriageInd;
    }
}
