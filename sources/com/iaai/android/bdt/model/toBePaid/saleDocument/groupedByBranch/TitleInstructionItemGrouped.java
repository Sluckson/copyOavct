package com.iaai.android.bdt.model.toBePaid.saleDocument.groupedByBranch;

import com.lowagie.text.ElementTags;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/saleDocument/groupedByBranch/TitleInstructionItemGrouped;", "", "BranchCode", "", "BranchName", "", "list", "", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/groupedByBranch/X;", "(ILjava/lang/String;Ljava/util/List;)V", "getBranchCode", "()I", "getBranchName", "()Ljava/lang/String;", "getList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: TitleInstructionItemGrouped.kt */
public final class TitleInstructionItemGrouped {
    private final int BranchCode;
    @NotNull
    private final String BranchName;
    @NotNull
    private final List<C2888X> list;

    @NotNull
    public static /* synthetic */ TitleInstructionItemGrouped copy$default(TitleInstructionItemGrouped titleInstructionItemGrouped, int i, String str, List<C2888X> list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = titleInstructionItemGrouped.BranchCode;
        }
        if ((i2 & 2) != 0) {
            str = titleInstructionItemGrouped.BranchName;
        }
        if ((i2 & 4) != 0) {
            list2 = titleInstructionItemGrouped.list;
        }
        return titleInstructionItemGrouped.copy(i, str, list2);
    }

    public final int component1() {
        return this.BranchCode;
    }

    @NotNull
    public final String component2() {
        return this.BranchName;
    }

    @NotNull
    public final List<C2888X> component3() {
        return this.list;
    }

    @NotNull
    public final TitleInstructionItemGrouped copy(int i, @NotNull String str, @NotNull List<C2888X> list2) {
        Intrinsics.checkParameterIsNotNull(str, "BranchName");
        Intrinsics.checkParameterIsNotNull(list2, ElementTags.LIST);
        return new TitleInstructionItemGrouped(i, str, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof TitleInstructionItemGrouped) {
                TitleInstructionItemGrouped titleInstructionItemGrouped = (TitleInstructionItemGrouped) obj;
                if (!(this.BranchCode == titleInstructionItemGrouped.BranchCode) || !Intrinsics.areEqual((Object) this.BranchName, (Object) titleInstructionItemGrouped.BranchName) || !Intrinsics.areEqual((Object) this.list, (Object) titleInstructionItemGrouped.list)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = Integer.valueOf(this.BranchCode).hashCode() * 31;
        String str = this.BranchName;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<C2888X> list2 = this.list;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        return "TitleInstructionItemGrouped(BranchCode=" + this.BranchCode + ", BranchName=" + this.BranchName + ", list=" + this.list + ")";
    }

    public TitleInstructionItemGrouped(int i, @NotNull String str, @NotNull List<C2888X> list2) {
        Intrinsics.checkParameterIsNotNull(str, "BranchName");
        Intrinsics.checkParameterIsNotNull(list2, ElementTags.LIST);
        this.BranchCode = i;
        this.BranchName = str;
        this.list = list2;
    }

    public final int getBranchCode() {
        return this.BranchCode;
    }

    @NotNull
    public final String getBranchName() {
        return this.BranchName;
    }

    @NotNull
    public final List<C2888X> getList() {
        return this.list;
    }
}
