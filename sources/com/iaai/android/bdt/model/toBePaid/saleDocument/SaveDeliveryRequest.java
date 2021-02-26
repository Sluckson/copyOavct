package com.iaai.android.bdt.model.toBePaid.saleDocument;

import com.iaai.android.bdt.model.toBePaid.getDeliveryMethod.RepresentativeInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BU\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010 \u001a\u00020\u0004HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010\"\u001a\u00020\u0004HÆ\u0003Ji\u0010#\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u0004HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013¨\u0006*"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/saleDocument/SaveDeliveryRequest;", "", "BranchNumbers", "", "", "SalvageSaleAndBuyerIds", "accountNumber", "additionalNote", "mailingAddressInfo", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/MailingAddressInfo;", "processName", "representativeInfo", "Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/RepresentativeInfo;", "titleHandlingInstructionCode", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/iaai/android/bdt/model/toBePaid/saleDocument/MailingAddressInfo;Ljava/lang/String;Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/RepresentativeInfo;Ljava/lang/String;)V", "getBranchNumbers", "()Ljava/util/List;", "getSalvageSaleAndBuyerIds", "getAccountNumber", "()Ljava/lang/String;", "getAdditionalNote", "getMailingAddressInfo", "()Lcom/iaai/android/bdt/model/toBePaid/saleDocument/MailingAddressInfo;", "getProcessName", "getRepresentativeInfo", "()Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/RepresentativeInfo;", "getTitleHandlingInstructionCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SaveDeliveryRequest.kt */
public final class SaveDeliveryRequest {
    @NotNull
    private final List<String> BranchNumbers;
    @NotNull
    private final List<String> SalvageSaleAndBuyerIds;
    @NotNull
    private final String accountNumber;
    @NotNull
    private final String additionalNote;
    @Nullable
    private final MailingAddressInfo mailingAddressInfo;
    @NotNull
    private final String processName;
    @Nullable
    private final RepresentativeInfo representativeInfo;
    @NotNull
    private final String titleHandlingInstructionCode;

    @NotNull
    public static /* synthetic */ SaveDeliveryRequest copy$default(SaveDeliveryRequest saveDeliveryRequest, List list, List list2, String str, String str2, MailingAddressInfo mailingAddressInfo2, String str3, RepresentativeInfo representativeInfo2, String str4, int i, Object obj) {
        SaveDeliveryRequest saveDeliveryRequest2 = saveDeliveryRequest;
        int i2 = i;
        return saveDeliveryRequest.copy((i2 & 1) != 0 ? saveDeliveryRequest2.BranchNumbers : list, (i2 & 2) != 0 ? saveDeliveryRequest2.SalvageSaleAndBuyerIds : list2, (i2 & 4) != 0 ? saveDeliveryRequest2.accountNumber : str, (i2 & 8) != 0 ? saveDeliveryRequest2.additionalNote : str2, (i2 & 16) != 0 ? saveDeliveryRequest2.mailingAddressInfo : mailingAddressInfo2, (i2 & 32) != 0 ? saveDeliveryRequest2.processName : str3, (i2 & 64) != 0 ? saveDeliveryRequest2.representativeInfo : representativeInfo2, (i2 & 128) != 0 ? saveDeliveryRequest2.titleHandlingInstructionCode : str4);
    }

    @NotNull
    public final List<String> component1() {
        return this.BranchNumbers;
    }

    @NotNull
    public final List<String> component2() {
        return this.SalvageSaleAndBuyerIds;
    }

    @NotNull
    public final String component3() {
        return this.accountNumber;
    }

    @NotNull
    public final String component4() {
        return this.additionalNote;
    }

    @Nullable
    public final MailingAddressInfo component5() {
        return this.mailingAddressInfo;
    }

    @NotNull
    public final String component6() {
        return this.processName;
    }

    @Nullable
    public final RepresentativeInfo component7() {
        return this.representativeInfo;
    }

    @NotNull
    public final String component8() {
        return this.titleHandlingInstructionCode;
    }

    @NotNull
    public final SaveDeliveryRequest copy(@NotNull List<String> list, @NotNull List<String> list2, @NotNull String str, @NotNull String str2, @Nullable MailingAddressInfo mailingAddressInfo2, @NotNull String str3, @Nullable RepresentativeInfo representativeInfo2, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(list, "BranchNumbers");
        Intrinsics.checkParameterIsNotNull(list2, "SalvageSaleAndBuyerIds");
        Intrinsics.checkParameterIsNotNull(str, "accountNumber");
        Intrinsics.checkParameterIsNotNull(str2, "additionalNote");
        String str5 = str3;
        Intrinsics.checkParameterIsNotNull(str5, "processName");
        String str6 = str4;
        Intrinsics.checkParameterIsNotNull(str6, "titleHandlingInstructionCode");
        return new SaveDeliveryRequest(list, list2, str, str2, mailingAddressInfo2, str5, representativeInfo2, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SaveDeliveryRequest)) {
            return false;
        }
        SaveDeliveryRequest saveDeliveryRequest = (SaveDeliveryRequest) obj;
        return Intrinsics.areEqual((Object) this.BranchNumbers, (Object) saveDeliveryRequest.BranchNumbers) && Intrinsics.areEqual((Object) this.SalvageSaleAndBuyerIds, (Object) saveDeliveryRequest.SalvageSaleAndBuyerIds) && Intrinsics.areEqual((Object) this.accountNumber, (Object) saveDeliveryRequest.accountNumber) && Intrinsics.areEqual((Object) this.additionalNote, (Object) saveDeliveryRequest.additionalNote) && Intrinsics.areEqual((Object) this.mailingAddressInfo, (Object) saveDeliveryRequest.mailingAddressInfo) && Intrinsics.areEqual((Object) this.processName, (Object) saveDeliveryRequest.processName) && Intrinsics.areEqual((Object) this.representativeInfo, (Object) saveDeliveryRequest.representativeInfo) && Intrinsics.areEqual((Object) this.titleHandlingInstructionCode, (Object) saveDeliveryRequest.titleHandlingInstructionCode);
    }

    public int hashCode() {
        List<String> list = this.BranchNumbers;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<String> list2 = this.SalvageSaleAndBuyerIds;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str = this.accountNumber;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.additionalNote;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        MailingAddressInfo mailingAddressInfo2 = this.mailingAddressInfo;
        int hashCode5 = (hashCode4 + (mailingAddressInfo2 != null ? mailingAddressInfo2.hashCode() : 0)) * 31;
        String str3 = this.processName;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        RepresentativeInfo representativeInfo2 = this.representativeInfo;
        int hashCode7 = (hashCode6 + (representativeInfo2 != null ? representativeInfo2.hashCode() : 0)) * 31;
        String str4 = this.titleHandlingInstructionCode;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode7 + i;
    }

    @NotNull
    public String toString() {
        return "SaveDeliveryRequest(BranchNumbers=" + this.BranchNumbers + ", SalvageSaleAndBuyerIds=" + this.SalvageSaleAndBuyerIds + ", accountNumber=" + this.accountNumber + ", additionalNote=" + this.additionalNote + ", mailingAddressInfo=" + this.mailingAddressInfo + ", processName=" + this.processName + ", representativeInfo=" + this.representativeInfo + ", titleHandlingInstructionCode=" + this.titleHandlingInstructionCode + ")";
    }

    public SaveDeliveryRequest(@NotNull List<String> list, @NotNull List<String> list2, @NotNull String str, @NotNull String str2, @Nullable MailingAddressInfo mailingAddressInfo2, @NotNull String str3, @Nullable RepresentativeInfo representativeInfo2, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(list, "BranchNumbers");
        Intrinsics.checkParameterIsNotNull(list2, "SalvageSaleAndBuyerIds");
        Intrinsics.checkParameterIsNotNull(str, "accountNumber");
        Intrinsics.checkParameterIsNotNull(str2, "additionalNote");
        Intrinsics.checkParameterIsNotNull(str3, "processName");
        Intrinsics.checkParameterIsNotNull(str4, "titleHandlingInstructionCode");
        this.BranchNumbers = list;
        this.SalvageSaleAndBuyerIds = list2;
        this.accountNumber = str;
        this.additionalNote = str2;
        this.mailingAddressInfo = mailingAddressInfo2;
        this.processName = str3;
        this.representativeInfo = representativeInfo2;
        this.titleHandlingInstructionCode = str4;
    }

    @NotNull
    public final List<String> getBranchNumbers() {
        return this.BranchNumbers;
    }

    @NotNull
    public final List<String> getSalvageSaleAndBuyerIds() {
        return this.SalvageSaleAndBuyerIds;
    }

    @NotNull
    public final String getAccountNumber() {
        return this.accountNumber;
    }

    @NotNull
    public final String getAdditionalNote() {
        return this.additionalNote;
    }

    @Nullable
    public final MailingAddressInfo getMailingAddressInfo() {
        return this.mailingAddressInfo;
    }

    @NotNull
    public final String getProcessName() {
        return this.processName;
    }

    @Nullable
    public final RepresentativeInfo getRepresentativeInfo() {
        return this.representativeInfo;
    }

    @NotNull
    public final String getTitleHandlingInstructionCode() {
        return this.titleHandlingInstructionCode;
    }
}
