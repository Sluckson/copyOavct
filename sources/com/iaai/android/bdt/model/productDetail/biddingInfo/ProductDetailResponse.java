package com.iaai.android.bdt.model.productDetail.biddingInfo;

import com.iaai.android.bdt.model.productDetail.VehicledetailsNonUS;
import com.iaai.android.bdt.model.productDetail.prebid.PrebidInformation;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aJ\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010;\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0011\u0010=\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0013HÆ\u0003J¥\u0001\u0010@\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÆ\u0001J\u0013\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010D\u001a\u00020EHÖ\u0001J\t\u0010F\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010&R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b2\u00103¨\u0006G"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ProductDetailResponse;", "Ljava/io/Serializable;", "BiddingInformation", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/BiddingInformation;", "ConditionInformation", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ConditionInformation;", "VehicleGradeInformation", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/VehicleGradeInformation;", "ImageInformation", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ImageInformation;", "OverviewInfo", "", "", "SaleInformation", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/SaleInformation;", "SimilarVehicles", "VinDetails", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/VinDetails;", "PrebidInformation", "Lcom/iaai/android/bdt/model/productDetail/prebid/PrebidInformation;", "ConditionReports", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ConditionReports;", "VehicledetailsNonUS", "Lcom/iaai/android/bdt/model/productDetail/VehicledetailsNonUS;", "ErrorMessage", "", "(Lcom/iaai/android/bdt/model/productDetail/biddingInfo/BiddingInformation;Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ConditionInformation;Lcom/iaai/android/bdt/model/productDetail/biddingInfo/VehicleGradeInformation;Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ImageInformation;Ljava/util/List;Lcom/iaai/android/bdt/model/productDetail/biddingInfo/SaleInformation;Ljava/util/List;Lcom/iaai/android/bdt/model/productDetail/biddingInfo/VinDetails;Lcom/iaai/android/bdt/model/productDetail/prebid/PrebidInformation;Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ConditionReports;Lcom/iaai/android/bdt/model/productDetail/VehicledetailsNonUS;Ljava/lang/String;)V", "getBiddingInformation", "()Lcom/iaai/android/bdt/model/productDetail/biddingInfo/BiddingInformation;", "getConditionInformation", "()Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ConditionInformation;", "getConditionReports", "()Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ConditionReports;", "getErrorMessage", "()Ljava/lang/String;", "getImageInformation", "()Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ImageInformation;", "getOverviewInfo", "()Ljava/util/List;", "getPrebidInformation", "()Lcom/iaai/android/bdt/model/productDetail/prebid/PrebidInformation;", "getSaleInformation", "()Lcom/iaai/android/bdt/model/productDetail/biddingInfo/SaleInformation;", "getSimilarVehicles", "getVehicleGradeInformation", "()Lcom/iaai/android/bdt/model/productDetail/biddingInfo/VehicleGradeInformation;", "getVehicledetailsNonUS", "()Lcom/iaai/android/bdt/model/productDetail/VehicledetailsNonUS;", "setVehicledetailsNonUS", "(Lcom/iaai/android/bdt/model/productDetail/VehicledetailsNonUS;)V", "getVinDetails", "()Lcom/iaai/android/bdt/model/productDetail/biddingInfo/VinDetails;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailResponse.kt */
public final class ProductDetailResponse implements Serializable {
    @Nullable
    private final BiddingInformation BiddingInformation;
    @Nullable
    private final ConditionInformation ConditionInformation;
    @Nullable
    private final ConditionReports ConditionReports;
    @Nullable
    private final String ErrorMessage;
    @Nullable
    private final ImageInformation ImageInformation;
    @Nullable
    private final List<Object> OverviewInfo;
    @Nullable
    private final PrebidInformation PrebidInformation;
    @Nullable
    private final SaleInformation SaleInformation;
    @Nullable
    private final List<Object> SimilarVehicles;
    @Nullable
    private final VehicleGradeInformation VehicleGradeInformation;
    @Nullable
    private VehicledetailsNonUS VehicledetailsNonUS;
    @Nullable
    private final VinDetails VinDetails;

    @NotNull
    public static /* synthetic */ ProductDetailResponse copy$default(ProductDetailResponse productDetailResponse, BiddingInformation biddingInformation, ConditionInformation conditionInformation, VehicleGradeInformation vehicleGradeInformation, ImageInformation imageInformation, List list, SaleInformation saleInformation, List list2, VinDetails vinDetails, PrebidInformation prebidInformation, ConditionReports conditionReports, VehicledetailsNonUS vehicledetailsNonUS, String str, int i, Object obj) {
        ProductDetailResponse productDetailResponse2 = productDetailResponse;
        int i2 = i;
        return productDetailResponse.copy((i2 & 1) != 0 ? productDetailResponse2.BiddingInformation : biddingInformation, (i2 & 2) != 0 ? productDetailResponse2.ConditionInformation : conditionInformation, (i2 & 4) != 0 ? productDetailResponse2.VehicleGradeInformation : vehicleGradeInformation, (i2 & 8) != 0 ? productDetailResponse2.ImageInformation : imageInformation, (i2 & 16) != 0 ? productDetailResponse2.OverviewInfo : list, (i2 & 32) != 0 ? productDetailResponse2.SaleInformation : saleInformation, (i2 & 64) != 0 ? productDetailResponse2.SimilarVehicles : list2, (i2 & 128) != 0 ? productDetailResponse2.VinDetails : vinDetails, (i2 & 256) != 0 ? productDetailResponse2.PrebidInformation : prebidInformation, (i2 & 512) != 0 ? productDetailResponse2.ConditionReports : conditionReports, (i2 & 1024) != 0 ? productDetailResponse2.VehicledetailsNonUS : vehicledetailsNonUS, (i2 & 2048) != 0 ? productDetailResponse2.ErrorMessage : str);
    }

    @Nullable
    public final BiddingInformation component1() {
        return this.BiddingInformation;
    }

    @Nullable
    public final ConditionReports component10() {
        return this.ConditionReports;
    }

    @Nullable
    public final VehicledetailsNonUS component11() {
        return this.VehicledetailsNonUS;
    }

    @Nullable
    public final String component12() {
        return this.ErrorMessage;
    }

    @Nullable
    public final ConditionInformation component2() {
        return this.ConditionInformation;
    }

    @Nullable
    public final VehicleGradeInformation component3() {
        return this.VehicleGradeInformation;
    }

    @Nullable
    public final ImageInformation component4() {
        return this.ImageInformation;
    }

    @Nullable
    public final List<Object> component5() {
        return this.OverviewInfo;
    }

    @Nullable
    public final SaleInformation component6() {
        return this.SaleInformation;
    }

    @Nullable
    public final List<Object> component7() {
        return this.SimilarVehicles;
    }

    @Nullable
    public final VinDetails component8() {
        return this.VinDetails;
    }

    @Nullable
    public final PrebidInformation component9() {
        return this.PrebidInformation;
    }

    @NotNull
    public final ProductDetailResponse copy(@Nullable BiddingInformation biddingInformation, @Nullable ConditionInformation conditionInformation, @Nullable VehicleGradeInformation vehicleGradeInformation, @Nullable ImageInformation imageInformation, @Nullable List<? extends Object> list, @Nullable SaleInformation saleInformation, @Nullable List<? extends Object> list2, @Nullable VinDetails vinDetails, @Nullable PrebidInformation prebidInformation, @Nullable ConditionReports conditionReports, @Nullable VehicledetailsNonUS vehicledetailsNonUS, @Nullable String str) {
        return new ProductDetailResponse(biddingInformation, conditionInformation, vehicleGradeInformation, imageInformation, list, saleInformation, list2, vinDetails, prebidInformation, conditionReports, vehicledetailsNonUS, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailResponse)) {
            return false;
        }
        ProductDetailResponse productDetailResponse = (ProductDetailResponse) obj;
        return Intrinsics.areEqual((Object) this.BiddingInformation, (Object) productDetailResponse.BiddingInformation) && Intrinsics.areEqual((Object) this.ConditionInformation, (Object) productDetailResponse.ConditionInformation) && Intrinsics.areEqual((Object) this.VehicleGradeInformation, (Object) productDetailResponse.VehicleGradeInformation) && Intrinsics.areEqual((Object) this.ImageInformation, (Object) productDetailResponse.ImageInformation) && Intrinsics.areEqual((Object) this.OverviewInfo, (Object) productDetailResponse.OverviewInfo) && Intrinsics.areEqual((Object) this.SaleInformation, (Object) productDetailResponse.SaleInformation) && Intrinsics.areEqual((Object) this.SimilarVehicles, (Object) productDetailResponse.SimilarVehicles) && Intrinsics.areEqual((Object) this.VinDetails, (Object) productDetailResponse.VinDetails) && Intrinsics.areEqual((Object) this.PrebidInformation, (Object) productDetailResponse.PrebidInformation) && Intrinsics.areEqual((Object) this.ConditionReports, (Object) productDetailResponse.ConditionReports) && Intrinsics.areEqual((Object) this.VehicledetailsNonUS, (Object) productDetailResponse.VehicledetailsNonUS) && Intrinsics.areEqual((Object) this.ErrorMessage, (Object) productDetailResponse.ErrorMessage);
    }

    public int hashCode() {
        BiddingInformation biddingInformation = this.BiddingInformation;
        int i = 0;
        int hashCode = (biddingInformation != null ? biddingInformation.hashCode() : 0) * 31;
        ConditionInformation conditionInformation = this.ConditionInformation;
        int hashCode2 = (hashCode + (conditionInformation != null ? conditionInformation.hashCode() : 0)) * 31;
        VehicleGradeInformation vehicleGradeInformation = this.VehicleGradeInformation;
        int hashCode3 = (hashCode2 + (vehicleGradeInformation != null ? vehicleGradeInformation.hashCode() : 0)) * 31;
        ImageInformation imageInformation = this.ImageInformation;
        int hashCode4 = (hashCode3 + (imageInformation != null ? imageInformation.hashCode() : 0)) * 31;
        List<Object> list = this.OverviewInfo;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        SaleInformation saleInformation = this.SaleInformation;
        int hashCode6 = (hashCode5 + (saleInformation != null ? saleInformation.hashCode() : 0)) * 31;
        List<Object> list2 = this.SimilarVehicles;
        int hashCode7 = (hashCode6 + (list2 != null ? list2.hashCode() : 0)) * 31;
        VinDetails vinDetails = this.VinDetails;
        int hashCode8 = (hashCode7 + (vinDetails != null ? vinDetails.hashCode() : 0)) * 31;
        PrebidInformation prebidInformation = this.PrebidInformation;
        int hashCode9 = (hashCode8 + (prebidInformation != null ? prebidInformation.hashCode() : 0)) * 31;
        ConditionReports conditionReports = this.ConditionReports;
        int hashCode10 = (hashCode9 + (conditionReports != null ? conditionReports.hashCode() : 0)) * 31;
        VehicledetailsNonUS vehicledetailsNonUS = this.VehicledetailsNonUS;
        int hashCode11 = (hashCode10 + (vehicledetailsNonUS != null ? vehicledetailsNonUS.hashCode() : 0)) * 31;
        String str = this.ErrorMessage;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode11 + i;
    }

    @NotNull
    public String toString() {
        return "ProductDetailResponse(BiddingInformation=" + this.BiddingInformation + ", ConditionInformation=" + this.ConditionInformation + ", VehicleGradeInformation=" + this.VehicleGradeInformation + ", ImageInformation=" + this.ImageInformation + ", OverviewInfo=" + this.OverviewInfo + ", SaleInformation=" + this.SaleInformation + ", SimilarVehicles=" + this.SimilarVehicles + ", VinDetails=" + this.VinDetails + ", PrebidInformation=" + this.PrebidInformation + ", ConditionReports=" + this.ConditionReports + ", VehicledetailsNonUS=" + this.VehicledetailsNonUS + ", ErrorMessage=" + this.ErrorMessage + ")";
    }

    public ProductDetailResponse(@Nullable BiddingInformation biddingInformation, @Nullable ConditionInformation conditionInformation, @Nullable VehicleGradeInformation vehicleGradeInformation, @Nullable ImageInformation imageInformation, @Nullable List<? extends Object> list, @Nullable SaleInformation saleInformation, @Nullable List<? extends Object> list2, @Nullable VinDetails vinDetails, @Nullable PrebidInformation prebidInformation, @Nullable ConditionReports conditionReports, @Nullable VehicledetailsNonUS vehicledetailsNonUS, @Nullable String str) {
        this.BiddingInformation = biddingInformation;
        this.ConditionInformation = conditionInformation;
        this.VehicleGradeInformation = vehicleGradeInformation;
        this.ImageInformation = imageInformation;
        this.OverviewInfo = list;
        this.SaleInformation = saleInformation;
        this.SimilarVehicles = list2;
        this.VinDetails = vinDetails;
        this.PrebidInformation = prebidInformation;
        this.ConditionReports = conditionReports;
        this.VehicledetailsNonUS = vehicledetailsNonUS;
        this.ErrorMessage = str;
    }

    @Nullable
    public final BiddingInformation getBiddingInformation() {
        return this.BiddingInformation;
    }

    @Nullable
    public final ConditionInformation getConditionInformation() {
        return this.ConditionInformation;
    }

    @Nullable
    public final VehicleGradeInformation getVehicleGradeInformation() {
        return this.VehicleGradeInformation;
    }

    @Nullable
    public final ImageInformation getImageInformation() {
        return this.ImageInformation;
    }

    @Nullable
    public final List<Object> getOverviewInfo() {
        return this.OverviewInfo;
    }

    @Nullable
    public final SaleInformation getSaleInformation() {
        return this.SaleInformation;
    }

    @Nullable
    public final List<Object> getSimilarVehicles() {
        return this.SimilarVehicles;
    }

    @Nullable
    public final VinDetails getVinDetails() {
        return this.VinDetails;
    }

    @Nullable
    public final PrebidInformation getPrebidInformation() {
        return this.PrebidInformation;
    }

    @Nullable
    public final ConditionReports getConditionReports() {
        return this.ConditionReports;
    }

    @Nullable
    public final VehicledetailsNonUS getVehicledetailsNonUS() {
        return this.VehicledetailsNonUS;
    }

    public final void setVehicledetailsNonUS(@Nullable VehicledetailsNonUS vehicledetailsNonUS) {
        this.VehicledetailsNonUS = vehicledetailsNonUS;
    }

    @Nullable
    public final String getErrorMessage() {
        return this.ErrorMessage;
    }
}
