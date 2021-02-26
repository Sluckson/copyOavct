package com.iaai.android.bdt.model.toBePaid.getDeliveryMethod;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0001¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0001HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0001HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0001HÆ\u0003JG\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0001HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r¨\u0006#"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/GetDeliveryMethodResponse;", "", "Branches", "SalvageIds", "TitleHandlingInstructionMail", "Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/TitleHandlingInstructionMail;", "TitleHandlingMethod", "", "TitleHanldingInstructionPickup", "Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/TitleHanldingInstructionPickup;", "TitleInstructionItemList", "(Ljava/lang/Object;Ljava/lang/Object;Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/TitleHandlingInstructionMail;Ljava/lang/String;Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/TitleHanldingInstructionPickup;Ljava/lang/Object;)V", "getBranches", "()Ljava/lang/Object;", "getSalvageIds", "getTitleHandlingInstructionMail", "()Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/TitleHandlingInstructionMail;", "getTitleHandlingMethod", "()Ljava/lang/String;", "getTitleHanldingInstructionPickup", "()Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/TitleHanldingInstructionPickup;", "getTitleInstructionItemList", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: GetDeliveryMethodResponse.kt */
public final class GetDeliveryMethodResponse {
    @NotNull
    private final Object Branches;
    @NotNull
    private final Object SalvageIds;
    @NotNull
    private final TitleHandlingInstructionMail TitleHandlingInstructionMail;
    @Nullable
    private final String TitleHandlingMethod;
    @NotNull
    private final TitleHanldingInstructionPickup TitleHanldingInstructionPickup;
    @NotNull
    private final Object TitleInstructionItemList;

    @NotNull
    public static /* synthetic */ GetDeliveryMethodResponse copy$default(GetDeliveryMethodResponse getDeliveryMethodResponse, Object obj, Object obj2, TitleHandlingInstructionMail titleHandlingInstructionMail, String str, TitleHanldingInstructionPickup titleHanldingInstructionPickup, Object obj3, int i, Object obj4) {
        if ((i & 1) != 0) {
            obj = getDeliveryMethodResponse.Branches;
        }
        if ((i & 2) != 0) {
            obj2 = getDeliveryMethodResponse.SalvageIds;
        }
        Object obj5 = obj2;
        if ((i & 4) != 0) {
            titleHandlingInstructionMail = getDeliveryMethodResponse.TitleHandlingInstructionMail;
        }
        TitleHandlingInstructionMail titleHandlingInstructionMail2 = titleHandlingInstructionMail;
        if ((i & 8) != 0) {
            str = getDeliveryMethodResponse.TitleHandlingMethod;
        }
        String str2 = str;
        if ((i & 16) != 0) {
            titleHanldingInstructionPickup = getDeliveryMethodResponse.TitleHanldingInstructionPickup;
        }
        TitleHanldingInstructionPickup titleHanldingInstructionPickup2 = titleHanldingInstructionPickup;
        if ((i & 32) != 0) {
            obj3 = getDeliveryMethodResponse.TitleInstructionItemList;
        }
        return getDeliveryMethodResponse.copy(obj, obj5, titleHandlingInstructionMail2, str2, titleHanldingInstructionPickup2, obj3);
    }

    @NotNull
    public final Object component1() {
        return this.Branches;
    }

    @NotNull
    public final Object component2() {
        return this.SalvageIds;
    }

    @NotNull
    public final TitleHandlingInstructionMail component3() {
        return this.TitleHandlingInstructionMail;
    }

    @Nullable
    public final String component4() {
        return this.TitleHandlingMethod;
    }

    @NotNull
    public final TitleHanldingInstructionPickup component5() {
        return this.TitleHanldingInstructionPickup;
    }

    @NotNull
    public final Object component6() {
        return this.TitleInstructionItemList;
    }

    @NotNull
    public final GetDeliveryMethodResponse copy(@NotNull Object obj, @NotNull Object obj2, @NotNull TitleHandlingInstructionMail titleHandlingInstructionMail, @Nullable String str, @NotNull TitleHanldingInstructionPickup titleHanldingInstructionPickup, @NotNull Object obj3) {
        Intrinsics.checkParameterIsNotNull(obj, "Branches");
        Intrinsics.checkParameterIsNotNull(obj2, "SalvageIds");
        Intrinsics.checkParameterIsNotNull(titleHandlingInstructionMail, "TitleHandlingInstructionMail");
        Intrinsics.checkParameterIsNotNull(titleHanldingInstructionPickup, "TitleHanldingInstructionPickup");
        Intrinsics.checkParameterIsNotNull(obj3, "TitleInstructionItemList");
        return new GetDeliveryMethodResponse(obj, obj2, titleHandlingInstructionMail, str, titleHanldingInstructionPickup, obj3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetDeliveryMethodResponse)) {
            return false;
        }
        GetDeliveryMethodResponse getDeliveryMethodResponse = (GetDeliveryMethodResponse) obj;
        return Intrinsics.areEqual(this.Branches, getDeliveryMethodResponse.Branches) && Intrinsics.areEqual(this.SalvageIds, getDeliveryMethodResponse.SalvageIds) && Intrinsics.areEqual((Object) this.TitleHandlingInstructionMail, (Object) getDeliveryMethodResponse.TitleHandlingInstructionMail) && Intrinsics.areEqual((Object) this.TitleHandlingMethod, (Object) getDeliveryMethodResponse.TitleHandlingMethod) && Intrinsics.areEqual((Object) this.TitleHanldingInstructionPickup, (Object) getDeliveryMethodResponse.TitleHanldingInstructionPickup) && Intrinsics.areEqual(this.TitleInstructionItemList, getDeliveryMethodResponse.TitleInstructionItemList);
    }

    public int hashCode() {
        Object obj = this.Branches;
        int i = 0;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Object obj2 = this.SalvageIds;
        int hashCode2 = (hashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        TitleHandlingInstructionMail titleHandlingInstructionMail = this.TitleHandlingInstructionMail;
        int hashCode3 = (hashCode2 + (titleHandlingInstructionMail != null ? titleHandlingInstructionMail.hashCode() : 0)) * 31;
        String str = this.TitleHandlingMethod;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        TitleHanldingInstructionPickup titleHanldingInstructionPickup = this.TitleHanldingInstructionPickup;
        int hashCode5 = (hashCode4 + (titleHanldingInstructionPickup != null ? titleHanldingInstructionPickup.hashCode() : 0)) * 31;
        Object obj3 = this.TitleInstructionItemList;
        if (obj3 != null) {
            i = obj3.hashCode();
        }
        return hashCode5 + i;
    }

    @NotNull
    public String toString() {
        return "GetDeliveryMethodResponse(Branches=" + this.Branches + ", SalvageIds=" + this.SalvageIds + ", TitleHandlingInstructionMail=" + this.TitleHandlingInstructionMail + ", TitleHandlingMethod=" + this.TitleHandlingMethod + ", TitleHanldingInstructionPickup=" + this.TitleHanldingInstructionPickup + ", TitleInstructionItemList=" + this.TitleInstructionItemList + ")";
    }

    public GetDeliveryMethodResponse(@NotNull Object obj, @NotNull Object obj2, @NotNull TitleHandlingInstructionMail titleHandlingInstructionMail, @Nullable String str, @NotNull TitleHanldingInstructionPickup titleHanldingInstructionPickup, @NotNull Object obj3) {
        Intrinsics.checkParameterIsNotNull(obj, "Branches");
        Intrinsics.checkParameterIsNotNull(obj2, "SalvageIds");
        Intrinsics.checkParameterIsNotNull(titleHandlingInstructionMail, "TitleHandlingInstructionMail");
        Intrinsics.checkParameterIsNotNull(titleHanldingInstructionPickup, "TitleHanldingInstructionPickup");
        Intrinsics.checkParameterIsNotNull(obj3, "TitleInstructionItemList");
        this.Branches = obj;
        this.SalvageIds = obj2;
        this.TitleHandlingInstructionMail = titleHandlingInstructionMail;
        this.TitleHandlingMethod = str;
        this.TitleHanldingInstructionPickup = titleHanldingInstructionPickup;
        this.TitleInstructionItemList = obj3;
    }

    @NotNull
    public final Object getBranches() {
        return this.Branches;
    }

    @NotNull
    public final Object getSalvageIds() {
        return this.SalvageIds;
    }

    @NotNull
    public final TitleHandlingInstructionMail getTitleHandlingInstructionMail() {
        return this.TitleHandlingInstructionMail;
    }

    @Nullable
    public final String getTitleHandlingMethod() {
        return this.TitleHandlingMethod;
    }

    @NotNull
    public final TitleHanldingInstructionPickup getTitleHanldingInstructionPickup() {
        return this.TitleHanldingInstructionPickup;
    }

    @NotNull
    public final Object getTitleInstructionItemList() {
        return this.TitleInstructionItemList;
    }
}
