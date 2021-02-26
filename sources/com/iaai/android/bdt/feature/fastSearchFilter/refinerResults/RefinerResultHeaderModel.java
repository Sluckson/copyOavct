package com.iaai.android.bdt.feature.fastSearchFilter.refinerResults;

import com.iaai.android.bdt.model.fastSearchFilter2.FacetXX;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\b\b\u0018\u00002\u00020\u0001B}\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u0005\u0012<\b\u0002\u0010\u0006\u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00070\u0003j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007`\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u001d\u0010 \u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u0005HÆ\u0003J=\u0010!\u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00070\u0003j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007`\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003J\u0001\u0010%\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u00052<\b\u0002\u0010\u0006\u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00070\u0003j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007`\u00052\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010&\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\bHÖ\u0001J\t\u0010)\u001a\u00020\u000bHÖ\u0001R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016RN\u0010\u0006\u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00070\u0003j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007`\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u001b\"\u0004\b\u001c\u0010\u001dR.\u0010\u0002\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010\u001a¨\u0006*"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultHeaderModel;", "", "itemList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FacetXX;", "Lkotlin/collections/ArrayList;", "indicesList", "Lkotlin/Triple;", "", "filterCount", "errorMessage", "", "isError", "", "(Ljava/util/ArrayList;Ljava/util/ArrayList;ILjava/lang/String;Z)V", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "getFilterCount", "()I", "setFilterCount", "(I)V", "getIndicesList", "()Ljava/util/ArrayList;", "setIndicesList", "(Ljava/util/ArrayList;)V", "()Z", "setError", "(Z)V", "getItemList", "setItemList", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: RefinerResultHeaderModel.kt */
public final class RefinerResultHeaderModel {
    @NotNull
    private String errorMessage;
    private int filterCount;
    @NotNull
    private ArrayList<Triple<Integer, Integer, Integer>> indicesList;
    private boolean isError;
    @NotNull
    private ArrayList<FacetXX> itemList;

    @NotNull
    public static /* synthetic */ RefinerResultHeaderModel copy$default(RefinerResultHeaderModel refinerResultHeaderModel, ArrayList<FacetXX> arrayList, ArrayList<Triple<Integer, Integer, Integer>> arrayList2, int i, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = refinerResultHeaderModel.itemList;
        }
        if ((i2 & 2) != 0) {
            arrayList2 = refinerResultHeaderModel.indicesList;
        }
        ArrayList<Triple<Integer, Integer, Integer>> arrayList3 = arrayList2;
        if ((i2 & 4) != 0) {
            i = refinerResultHeaderModel.filterCount;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str = refinerResultHeaderModel.errorMessage;
        }
        String str2 = str;
        if ((i2 & 16) != 0) {
            z = refinerResultHeaderModel.isError;
        }
        return refinerResultHeaderModel.copy(arrayList, arrayList3, i3, str2, z);
    }

    @NotNull
    public final ArrayList<FacetXX> component1() {
        return this.itemList;
    }

    @NotNull
    public final ArrayList<Triple<Integer, Integer, Integer>> component2() {
        return this.indicesList;
    }

    public final int component3() {
        return this.filterCount;
    }

    @NotNull
    public final String component4() {
        return this.errorMessage;
    }

    public final boolean component5() {
        return this.isError;
    }

    @NotNull
    public final RefinerResultHeaderModel copy(@NotNull ArrayList<FacetXX> arrayList, @NotNull ArrayList<Triple<Integer, Integer, Integer>> arrayList2, int i, @NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(arrayList, "itemList");
        Intrinsics.checkParameterIsNotNull(arrayList2, "indicesList");
        Intrinsics.checkParameterIsNotNull(str, "errorMessage");
        return new RefinerResultHeaderModel(arrayList, arrayList2, i, str, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof RefinerResultHeaderModel) {
                RefinerResultHeaderModel refinerResultHeaderModel = (RefinerResultHeaderModel) obj;
                if (Intrinsics.areEqual((Object) this.itemList, (Object) refinerResultHeaderModel.itemList) && Intrinsics.areEqual((Object) this.indicesList, (Object) refinerResultHeaderModel.indicesList)) {
                    if ((this.filterCount == refinerResultHeaderModel.filterCount) && Intrinsics.areEqual((Object) this.errorMessage, (Object) refinerResultHeaderModel.errorMessage)) {
                        if (this.isError == refinerResultHeaderModel.isError) {
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
        ArrayList<FacetXX> arrayList = this.itemList;
        int i = 0;
        int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
        ArrayList<Triple<Integer, Integer, Integer>> arrayList2 = this.indicesList;
        int hashCode2 = (((hashCode + (arrayList2 != null ? arrayList2.hashCode() : 0)) * 31) + Integer.valueOf(this.filterCount).hashCode()) * 31;
        String str = this.errorMessage;
        if (str != null) {
            i = str.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.isError;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "RefinerResultHeaderModel(itemList=" + this.itemList + ", indicesList=" + this.indicesList + ", filterCount=" + this.filterCount + ", errorMessage=" + this.errorMessage + ", isError=" + this.isError + ")";
    }

    public RefinerResultHeaderModel(@NotNull ArrayList<FacetXX> arrayList, @NotNull ArrayList<Triple<Integer, Integer, Integer>> arrayList2, int i, @NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(arrayList, "itemList");
        Intrinsics.checkParameterIsNotNull(arrayList2, "indicesList");
        Intrinsics.checkParameterIsNotNull(str, "errorMessage");
        this.itemList = arrayList;
        this.indicesList = arrayList2;
        this.filterCount = i;
        this.errorMessage = str;
        this.isError = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RefinerResultHeaderModel(ArrayList arrayList, ArrayList arrayList2, int i, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new ArrayList() : arrayList, (i2 & 2) != 0 ? new ArrayList() : arrayList2, (i2 & 4) != 0 ? 0 : i, str, (i2 & 16) != 0 ? false : z);
    }

    @NotNull
    public final ArrayList<FacetXX> getItemList() {
        return this.itemList;
    }

    public final void setItemList(@NotNull ArrayList<FacetXX> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.itemList = arrayList;
    }

    @NotNull
    public final ArrayList<Triple<Integer, Integer, Integer>> getIndicesList() {
        return this.indicesList;
    }

    public final void setIndicesList(@NotNull ArrayList<Triple<Integer, Integer, Integer>> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.indicesList = arrayList;
    }

    public final int getFilterCount() {
        return this.filterCount;
    }

    public final void setFilterCount(int i) {
        this.filterCount = i;
    }

    @NotNull
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.errorMessage = str;
    }

    public final boolean isError() {
        return this.isError;
    }

    public final void setError(boolean z) {
        this.isError = z;
    }
}
