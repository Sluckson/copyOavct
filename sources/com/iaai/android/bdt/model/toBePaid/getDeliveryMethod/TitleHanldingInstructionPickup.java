package com.iaai.android.bdt.model.toBePaid.getDeliveryMethod;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J6\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/TitleHanldingInstructionPickup;", "", "RepresentativeInfo", "", "Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/RepresentativeInfo;", "TitleInstructionID", "", "TitleInstructionTypeCode", "", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;)V", "getRepresentativeInfo", "()Ljava/util/List;", "getTitleInstructionID", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitleInstructionTypeCode", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;)Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/TitleHanldingInstructionPickup;", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: TitleHanldingInstructionPickup.kt */
public final class TitleHanldingInstructionPickup {
    @NotNull
    private final List<RepresentativeInfo> RepresentativeInfo;
    @Nullable
    private final Integer TitleInstructionID;
    @Nullable
    private final String TitleInstructionTypeCode;

    @NotNull
    public static /* synthetic */ TitleHanldingInstructionPickup copy$default(TitleHanldingInstructionPickup titleHanldingInstructionPickup, List<RepresentativeInfo> list, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = titleHanldingInstructionPickup.RepresentativeInfo;
        }
        if ((i & 2) != 0) {
            num = titleHanldingInstructionPickup.TitleInstructionID;
        }
        if ((i & 4) != 0) {
            str = titleHanldingInstructionPickup.TitleInstructionTypeCode;
        }
        return titleHanldingInstructionPickup.copy(list, num, str);
    }

    @NotNull
    public final List<RepresentativeInfo> component1() {
        return this.RepresentativeInfo;
    }

    @Nullable
    public final Integer component2() {
        return this.TitleInstructionID;
    }

    @Nullable
    public final String component3() {
        return this.TitleInstructionTypeCode;
    }

    @NotNull
    public final TitleHanldingInstructionPickup copy(@NotNull List<RepresentativeInfo> list, @Nullable Integer num, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(list, "RepresentativeInfo");
        return new TitleHanldingInstructionPickup(list, num, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TitleHanldingInstructionPickup)) {
            return false;
        }
        TitleHanldingInstructionPickup titleHanldingInstructionPickup = (TitleHanldingInstructionPickup) obj;
        return Intrinsics.areEqual((Object) this.RepresentativeInfo, (Object) titleHanldingInstructionPickup.RepresentativeInfo) && Intrinsics.areEqual((Object) this.TitleInstructionID, (Object) titleHanldingInstructionPickup.TitleInstructionID) && Intrinsics.areEqual((Object) this.TitleInstructionTypeCode, (Object) titleHanldingInstructionPickup.TitleInstructionTypeCode);
    }

    public int hashCode() {
        List<RepresentativeInfo> list = this.RepresentativeInfo;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Integer num = this.TitleInstructionID;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.TitleInstructionTypeCode;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        return "TitleHanldingInstructionPickup(RepresentativeInfo=" + this.RepresentativeInfo + ", TitleInstructionID=" + this.TitleInstructionID + ", TitleInstructionTypeCode=" + this.TitleInstructionTypeCode + ")";
    }

    public TitleHanldingInstructionPickup(@NotNull List<RepresentativeInfo> list, @Nullable Integer num, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(list, "RepresentativeInfo");
        this.RepresentativeInfo = list;
        this.TitleInstructionID = num;
        this.TitleInstructionTypeCode = str;
    }

    @NotNull
    public final List<RepresentativeInfo> getRepresentativeInfo() {
        return this.RepresentativeInfo;
    }

    @Nullable
    public final Integer getTitleInstructionID() {
        return this.TitleInstructionID;
    }

    @Nullable
    public final String getTitleInstructionTypeCode() {
        return this.TitleInstructionTypeCode;
    }
}
