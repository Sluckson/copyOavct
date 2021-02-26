package com.iaai.android.bdt.model.fastSearchFilter2;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b)\b\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0002\u0010\u0012J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010.\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\"J\t\u0010/\u001a\u00020\tHÆ\u0003J\u0019\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fHÆ\u0003J\t\u00101\u001a\u00020\u0006HÆ\u0003J\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u00020\u00062\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\tHÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u001a\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0014\"\u0004\b\u001b\u0010\u001cR*\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010#\u001a\u0004\b$\u0010\"R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u00068"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearchFilter2/SearchMappingGroup;", "", "displayname", "", "group", "multiselect", "", "filtertype", "minvalue", "", "maxvalue", "sortorder", "listFacet", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FacetXX;", "Lkotlin/collections/ArrayList;", "isEnabled", "Custom", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/util/ArrayList;ZZ)V", "getCustom", "()Z", "getDisplayname", "()Ljava/lang/String;", "setDisplayname", "(Ljava/lang/String;)V", "getFiltertype", "getGroup", "setEnabled", "(Z)V", "getListFacet", "()Ljava/util/ArrayList;", "setListFacet", "(Ljava/util/ArrayList;)V", "getMaxvalue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMinvalue", "getMultiselect", "getSortorder", "()I", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/util/ArrayList;ZZ)Lcom/iaai/android/bdt/model/fastSearchFilter2/SearchMappingGroup;", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SearchMappingGroup.kt */
public final class SearchMappingGroup {
    private final boolean Custom;
    @NotNull
    private String displayname;
    @NotNull
    private final String filtertype;
    @NotNull
    private final String group;
    private boolean isEnabled;
    @NotNull
    private ArrayList<FacetXX> listFacet;
    @Nullable
    private final Integer maxvalue;
    @Nullable
    private final Integer minvalue;
    private final boolean multiselect;
    private final int sortorder;

    @NotNull
    public static /* synthetic */ SearchMappingGroup copy$default(SearchMappingGroup searchMappingGroup, String str, String str2, boolean z, String str3, Integer num, Integer num2, int i, ArrayList arrayList, boolean z2, boolean z3, int i2, Object obj) {
        SearchMappingGroup searchMappingGroup2 = searchMappingGroup;
        int i3 = i2;
        return searchMappingGroup.copy((i3 & 1) != 0 ? searchMappingGroup2.displayname : str, (i3 & 2) != 0 ? searchMappingGroup2.group : str2, (i3 & 4) != 0 ? searchMappingGroup2.multiselect : z, (i3 & 8) != 0 ? searchMappingGroup2.filtertype : str3, (i3 & 16) != 0 ? searchMappingGroup2.minvalue : num, (i3 & 32) != 0 ? searchMappingGroup2.maxvalue : num2, (i3 & 64) != 0 ? searchMappingGroup2.sortorder : i, (i3 & 128) != 0 ? searchMappingGroup2.listFacet : arrayList, (i3 & 256) != 0 ? searchMappingGroup2.isEnabled : z2, (i3 & 512) != 0 ? searchMappingGroup2.Custom : z3);
    }

    @NotNull
    public final String component1() {
        return this.displayname;
    }

    public final boolean component10() {
        return this.Custom;
    }

    @NotNull
    public final String component2() {
        return this.group;
    }

    public final boolean component3() {
        return this.multiselect;
    }

    @NotNull
    public final String component4() {
        return this.filtertype;
    }

    @Nullable
    public final Integer component5() {
        return this.minvalue;
    }

    @Nullable
    public final Integer component6() {
        return this.maxvalue;
    }

    public final int component7() {
        return this.sortorder;
    }

    @NotNull
    public final ArrayList<FacetXX> component8() {
        return this.listFacet;
    }

    public final boolean component9() {
        return this.isEnabled;
    }

    @NotNull
    public final SearchMappingGroup copy(@NotNull String str, @NotNull String str2, boolean z, @NotNull String str3, @Nullable Integer num, @Nullable Integer num2, int i, @NotNull ArrayList<FacetXX> arrayList, boolean z2, boolean z3) {
        Intrinsics.checkParameterIsNotNull(str, "displayname");
        Intrinsics.checkParameterIsNotNull(str2, "group");
        String str4 = str3;
        Intrinsics.checkParameterIsNotNull(str4, "filtertype");
        ArrayList<FacetXX> arrayList2 = arrayList;
        Intrinsics.checkParameterIsNotNull(arrayList2, "listFacet");
        return new SearchMappingGroup(str, str2, z, str4, num, num2, i, arrayList2, z2, z3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SearchMappingGroup) {
                SearchMappingGroup searchMappingGroup = (SearchMappingGroup) obj;
                if (Intrinsics.areEqual((Object) this.displayname, (Object) searchMappingGroup.displayname) && Intrinsics.areEqual((Object) this.group, (Object) searchMappingGroup.group)) {
                    if ((this.multiselect == searchMappingGroup.multiselect) && Intrinsics.areEqual((Object) this.filtertype, (Object) searchMappingGroup.filtertype) && Intrinsics.areEqual((Object) this.minvalue, (Object) searchMappingGroup.minvalue) && Intrinsics.areEqual((Object) this.maxvalue, (Object) searchMappingGroup.maxvalue)) {
                        if ((this.sortorder == searchMappingGroup.sortorder) && Intrinsics.areEqual((Object) this.listFacet, (Object) searchMappingGroup.listFacet)) {
                            if (this.isEnabled == searchMappingGroup.isEnabled) {
                                if (this.Custom == searchMappingGroup.Custom) {
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
        String str = this.displayname;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.group;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.multiselect;
        if (z) {
            z = true;
        }
        int i2 = (hashCode2 + (z ? 1 : 0)) * 31;
        String str3 = this.filtertype;
        int hashCode3 = (i2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.minvalue;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.maxvalue;
        int hashCode5 = (((hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 31) + Integer.valueOf(this.sortorder).hashCode()) * 31;
        ArrayList<FacetXX> arrayList = this.listFacet;
        if (arrayList != null) {
            i = arrayList.hashCode();
        }
        int i3 = (hashCode5 + i) * 31;
        boolean z2 = this.isEnabled;
        if (z2) {
            z2 = true;
        }
        int i4 = (i3 + (z2 ? 1 : 0)) * 31;
        boolean z3 = this.Custom;
        if (z3) {
            z3 = true;
        }
        return i4 + (z3 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "SearchMappingGroup(displayname=" + this.displayname + ", group=" + this.group + ", multiselect=" + this.multiselect + ", filtertype=" + this.filtertype + ", minvalue=" + this.minvalue + ", maxvalue=" + this.maxvalue + ", sortorder=" + this.sortorder + ", listFacet=" + this.listFacet + ", isEnabled=" + this.isEnabled + ", Custom=" + this.Custom + ")";
    }

    public SearchMappingGroup(@NotNull String str, @NotNull String str2, boolean z, @NotNull String str3, @Nullable Integer num, @Nullable Integer num2, int i, @NotNull ArrayList<FacetXX> arrayList, boolean z2, boolean z3) {
        Intrinsics.checkParameterIsNotNull(str, "displayname");
        Intrinsics.checkParameterIsNotNull(str2, "group");
        Intrinsics.checkParameterIsNotNull(str3, "filtertype");
        Intrinsics.checkParameterIsNotNull(arrayList, "listFacet");
        this.displayname = str;
        this.group = str2;
        this.multiselect = z;
        this.filtertype = str3;
        this.minvalue = num;
        this.maxvalue = num2;
        this.sortorder = i;
        this.listFacet = arrayList;
        this.isEnabled = z2;
        this.Custom = z3;
    }

    @NotNull
    public final String getDisplayname() {
        return this.displayname;
    }

    public final void setDisplayname(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.displayname = str;
    }

    @NotNull
    public final String getGroup() {
        return this.group;
    }

    public final boolean getMultiselect() {
        return this.multiselect;
    }

    @NotNull
    public final String getFiltertype() {
        return this.filtertype;
    }

    @Nullable
    public final Integer getMinvalue() {
        return this.minvalue;
    }

    @Nullable
    public final Integer getMaxvalue() {
        return this.maxvalue;
    }

    public final int getSortorder() {
        return this.sortorder;
    }

    @NotNull
    public final ArrayList<FacetXX> getListFacet() {
        return this.listFacet;
    }

    public final void setListFacet(@NotNull ArrayList<FacetXX> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.listFacet = arrayList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchMappingGroup(String str, String str2, boolean z, String str3, Integer num, Integer num2, int i, ArrayList arrayList, boolean z2, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z, str3, num, num2, i, arrayList, (i2 & 256) != 0 ? true : z2, z3);
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    public final boolean getCustom() {
        return this.Custom;
    }
}
