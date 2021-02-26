package com.iaai.android.bdt.model.MyAccount;

import androidx.recyclerview.widget.DiffUtil;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bR\u0018\u0000 U2\u00020\u0001:\u0001UB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010T\u001a\u00020\u0004H\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR \u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR \u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR \u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR \u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR \u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR \u0010*\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR \u0010-\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR \u00100\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR \u00103\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR \u00106\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR \u00109\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR \u0010<\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR \u0010?\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR \u0010B\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR \u0010E\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR \u0010H\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\bR \u0010K\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0006\"\u0004\bM\u0010\bR \u0010N\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0006\"\u0004\bP\u0010\bR \u0010Q\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0006\"\u0004\bS\u0010\b¨\u0006V"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/ToBePickedUpVehiclesModel;", "", "()V", "actionDate", "", "getActionDate", "()Ljava/lang/String;", "setActionDate", "(Ljava/lang/String;)V", "branchCity", "getBranchCity", "setBranchCity", "branchName", "getBranchName", "setBranchName", "branchNumber", "getBranchNumber", "setBranchNumber", "branchState", "getBranchState", "setBranchState", "branchStreet", "getBranchStreet", "setBranchStreet", "branchZip", "getBranchZip", "setBranchZip", "feesAndTax", "getFeesAndTax", "setFeesAndTax", "imageUrl", "getImageUrl", "setImageUrl", "itemId", "getItemId", "setItemId", "laneItemNumber", "getLaneItemNumber", "setLaneItemNumber", "make", "getMake", "setMake", "model", "getModel", "setModel", "notes", "getNotes", "setNotes", "offsiteSaleIndicator", "getOffsiteSaleIndicator", "setOffsiteSaleIndicator", "pin", "getPin", "setPin", "pullOutQualified", "getPullOutQualified", "setPullOutQualified", "pullOutRequestID", "getPullOutRequestID", "setPullOutRequestID", "salvage", "getSalvage", "setSalvage", "salvageFeeIndicator", "getSalvageFeeIndicator", "setSalvageFeeIndicator", "stockNumber", "getStockNumber", "setStockNumber", "titileHandlingInstructions", "getTitileHandlingInstructions", "setTitileHandlingInstructions", "title", "getTitle", "setTitle", "vin", "getVin", "setVin", "year", "getYear", "setYear", "yearMakeModel", "getYearMakeModel", "setYearMakeModel", "toString", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ToBePickedUpVehiclesModel.kt */
public final class ToBePickedUpVehiclesModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static DiffUtil.ItemCallback<ToBePickedUpVehiclesModel> diffCallback = new ToBePickedUpVehiclesModel$Companion$diffCallback$1();
    @SerializedName("ActionDate")
    @Nullable
    private String actionDate;
    @SerializedName("BranchCity")
    @Nullable
    private String branchCity;
    @SerializedName("Branchname")
    @Nullable
    private String branchName;
    @SerializedName("BranchNumber")
    @Nullable
    private String branchNumber;
    @SerializedName("BranchState")
    @Nullable
    private String branchState;
    @SerializedName("BranchStreet")
    @Nullable
    private String branchStreet;
    @SerializedName("BranchZip")
    @Nullable
    private String branchZip;
    @SerializedName("feesAndTax")
    @Nullable
    private String feesAndTax;
    @SerializedName("ImageURL")
    @Nullable
    private String imageUrl;
    @SerializedName("Itemid")
    @Nullable
    private String itemId;
    @SerializedName("Lane_ItemNumber")
    @Nullable
    private String laneItemNumber;
    @SerializedName("Make")
    @Nullable
    private String make;
    @SerializedName("Model")
    @Nullable
    private String model;
    @SerializedName("Notes")
    @Nullable
    private String notes;
    @SerializedName("Offsite_Sale_Indicator")
    @Nullable
    private String offsiteSaleIndicator;
    @SerializedName("Pin")
    @Nullable
    private String pin;
    @SerializedName("PullOutQualified")
    @Nullable
    private String pullOutQualified;
    @SerializedName("PullOutRequestID")
    @Nullable
    private String pullOutRequestID;
    @SerializedName("Salvage")
    @Nullable
    private String salvage;
    @SerializedName("SalvageFeeIndicator")
    @Nullable
    private String salvageFeeIndicator;
    @SerializedName("StockNumber")
    @Nullable
    private String stockNumber;
    @SerializedName("titileHandlingInstructions")
    @Nullable
    private String titileHandlingInstructions;
    @SerializedName("Title")
    @Nullable
    private String title;
    @SerializedName("VIN")
    @Nullable
    private String vin;
    @SerializedName("Year")
    @Nullable
    private String year;
    @SerializedName("YearMakeModel")
    @Nullable
    private String yearMakeModel;

    @Nullable
    public final String getActionDate() {
        return this.actionDate;
    }

    public final void setActionDate(@Nullable String str) {
        this.actionDate = str;
    }

    @Nullable
    public final String getBranchCity() {
        return this.branchCity;
    }

    public final void setBranchCity(@Nullable String str) {
        this.branchCity = str;
    }

    @Nullable
    public final String getBranchState() {
        return this.branchState;
    }

    public final void setBranchState(@Nullable String str) {
        this.branchState = str;
    }

    @Nullable
    public final String getBranchStreet() {
        return this.branchStreet;
    }

    public final void setBranchStreet(@Nullable String str) {
        this.branchStreet = str;
    }

    @Nullable
    public final String getBranchZip() {
        return this.branchZip;
    }

    public final void setBranchZip(@Nullable String str) {
        this.branchZip = str;
    }

    @Nullable
    public final String getPullOutQualified() {
        return this.pullOutQualified;
    }

    public final void setPullOutQualified(@Nullable String str) {
        this.pullOutQualified = str;
    }

    @Nullable
    public final String getBranchName() {
        return this.branchName;
    }

    public final void setBranchName(@Nullable String str) {
        this.branchName = str;
    }

    @Nullable
    public final String getBranchNumber() {
        return this.branchNumber;
    }

    public final void setBranchNumber(@Nullable String str) {
        this.branchNumber = str;
    }

    @Nullable
    public final String getItemId() {
        return this.itemId;
    }

    public final void setItemId(@Nullable String str) {
        this.itemId = str;
    }

    @Nullable
    public final String getLaneItemNumber() {
        return this.laneItemNumber;
    }

    public final void setLaneItemNumber(@Nullable String str) {
        this.laneItemNumber = str;
    }

    @Nullable
    public final String getOffsiteSaleIndicator() {
        return this.offsiteSaleIndicator;
    }

    public final void setOffsiteSaleIndicator(@Nullable String str) {
        this.offsiteSaleIndicator = str;
    }

    @Nullable
    public final String getPin() {
        return this.pin;
    }

    public final void setPin(@Nullable String str) {
        this.pin = str;
    }

    @Nullable
    public final String getSalvage() {
        return this.salvage;
    }

    public final void setSalvage(@Nullable String str) {
        this.salvage = str;
    }

    @Nullable
    public final String getStockNumber() {
        return this.stockNumber;
    }

    public final void setStockNumber(@Nullable String str) {
        this.stockNumber = str;
    }

    @Nullable
    public final String getMake() {
        return this.make;
    }

    public final void setMake(@Nullable String str) {
        this.make = str;
    }

    @Nullable
    public final String getModel() {
        return this.model;
    }

    public final void setModel(@Nullable String str) {
        this.model = str;
    }

    @Nullable
    public final String getYear() {
        return this.year;
    }

    public final void setYear(@Nullable String str) {
        this.year = str;
    }

    @Nullable
    public final String getYearMakeModel() {
        return this.yearMakeModel;
    }

    public final void setYearMakeModel(@Nullable String str) {
        this.yearMakeModel = str;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl(@Nullable String str) {
        this.imageUrl = str;
    }

    @Nullable
    public final String getVin() {
        return this.vin;
    }

    public final void setVin(@Nullable String str) {
        this.vin = str;
    }

    @Nullable
    public final String getFeesAndTax() {
        return this.feesAndTax;
    }

    public final void setFeesAndTax(@Nullable String str) {
        this.feesAndTax = str;
    }

    @Nullable
    public final String getPullOutRequestID() {
        return this.pullOutRequestID;
    }

    public final void setPullOutRequestID(@Nullable String str) {
        this.pullOutRequestID = str;
    }

    @Nullable
    public final String getTitileHandlingInstructions() {
        return this.titileHandlingInstructions;
    }

    public final void setTitileHandlingInstructions(@Nullable String str) {
        this.titileHandlingInstructions = str;
    }

    @Nullable
    public final String getSalvageFeeIndicator() {
        return this.salvageFeeIndicator;
    }

    public final void setSalvageFeeIndicator(@Nullable String str) {
        this.salvageFeeIndicator = str;
    }

    @Nullable
    public final String getNotes() {
        return this.notes;
    }

    public final void setNotes(@Nullable String str) {
        this.notes = str;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    @NotNull
    public String toString() {
        String str = this.yearMakeModel;
        if (str == null) {
            Intrinsics.throwNpe();
        }
        return str;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/ToBePickedUpVehiclesModel$Companion;", "", "()V", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/iaai/android/bdt/model/MyAccount/ToBePickedUpVehiclesModel;", "getDiffCallback", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "setDiffCallback", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ToBePickedUpVehiclesModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DiffUtil.ItemCallback<ToBePickedUpVehiclesModel> getDiffCallback() {
            return ToBePickedUpVehiclesModel.diffCallback;
        }

        public final void setDiffCallback(@NotNull DiffUtil.ItemCallback<ToBePickedUpVehiclesModel> itemCallback) {
            Intrinsics.checkParameterIsNotNull(itemCallback, "<set-?>");
            ToBePickedUpVehiclesModel.diffCallback = itemCallback;
        }
    }
}
