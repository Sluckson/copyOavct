package com.iaai.android.bdt.model.fastSearch;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b(\b\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0002\u0010\u0014J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\t\u00102\u001a\u00020\u000eHÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0003HÆ\u0001J\u0013\u00105\u001a\u00020\u000e2\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0003HÖ\u0001J\t\u00108\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u001a\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0016¨\u00069"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearch/SearchInput;", "", "CountOfVehicles", "", "Keyword", "", "Latitude", "Longitude", "RequestedApp", "Scope", "SelectedRefiners", "", "Lcom/iaai/android/bdt/model/fastSearch/SelectedRefiner;", "SortAscending", "", "SortField", "SortRule", "Lcom/iaai/android/bdt/model/fastSearch/SortRule;", "StartIndex", "TimeZoneID", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;ZLjava/lang/String;Ljava/util/List;II)V", "getCountOfVehicles", "()I", "setCountOfVehicles", "(I)V", "getKeyword", "()Ljava/lang/String;", "getLatitude", "getLongitude", "getRequestedApp", "getScope", "getSelectedRefiners", "()Ljava/util/List;", "getSortAscending", "()Z", "getSortField", "getSortRule", "getStartIndex", "setStartIndex", "getTimeZoneID", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SearchInput.kt */
public final class SearchInput {
    private int CountOfVehicles;
    @NotNull
    private final String Keyword;
    @NotNull
    private final String Latitude;
    @NotNull
    private final String Longitude;
    private final int RequestedApp;
    @NotNull
    private final String Scope;
    @NotNull
    private final List<SelectedRefiner> SelectedRefiners;
    private final boolean SortAscending;
    @NotNull
    private final String SortField;
    @NotNull
    private final List<SortRule> SortRule;
    private int StartIndex;
    private final int TimeZoneID;

    @NotNull
    public static /* synthetic */ SearchInput copy$default(SearchInput searchInput, int i, String str, String str2, String str3, int i2, String str4, List list, boolean z, String str5, List list2, int i3, int i4, int i5, Object obj) {
        SearchInput searchInput2 = searchInput;
        int i6 = i5;
        return searchInput.copy((i6 & 1) != 0 ? searchInput2.CountOfVehicles : i, (i6 & 2) != 0 ? searchInput2.Keyword : str, (i6 & 4) != 0 ? searchInput2.Latitude : str2, (i6 & 8) != 0 ? searchInput2.Longitude : str3, (i6 & 16) != 0 ? searchInput2.RequestedApp : i2, (i6 & 32) != 0 ? searchInput2.Scope : str4, (i6 & 64) != 0 ? searchInput2.SelectedRefiners : list, (i6 & 128) != 0 ? searchInput2.SortAscending : z, (i6 & 256) != 0 ? searchInput2.SortField : str5, (i6 & 512) != 0 ? searchInput2.SortRule : list2, (i6 & 1024) != 0 ? searchInput2.StartIndex : i3, (i6 & 2048) != 0 ? searchInput2.TimeZoneID : i4);
    }

    public final int component1() {
        return this.CountOfVehicles;
    }

    @NotNull
    public final List<SortRule> component10() {
        return this.SortRule;
    }

    public final int component11() {
        return this.StartIndex;
    }

    public final int component12() {
        return this.TimeZoneID;
    }

    @NotNull
    public final String component2() {
        return this.Keyword;
    }

    @NotNull
    public final String component3() {
        return this.Latitude;
    }

    @NotNull
    public final String component4() {
        return this.Longitude;
    }

    public final int component5() {
        return this.RequestedApp;
    }

    @NotNull
    public final String component6() {
        return this.Scope;
    }

    @NotNull
    public final List<SelectedRefiner> component7() {
        return this.SelectedRefiners;
    }

    public final boolean component8() {
        return this.SortAscending;
    }

    @NotNull
    public final String component9() {
        return this.SortField;
    }

    @NotNull
    public final SearchInput copy(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, int i2, @NotNull String str4, @NotNull List<SelectedRefiner> list, boolean z, @NotNull String str5, @NotNull List<SortRule> list2, int i3, int i4) {
        String str6 = str;
        Intrinsics.checkParameterIsNotNull(str6, "Keyword");
        String str7 = str2;
        Intrinsics.checkParameterIsNotNull(str7, "Latitude");
        String str8 = str3;
        Intrinsics.checkParameterIsNotNull(str8, "Longitude");
        String str9 = str4;
        Intrinsics.checkParameterIsNotNull(str9, "Scope");
        List<SelectedRefiner> list3 = list;
        Intrinsics.checkParameterIsNotNull(list3, "SelectedRefiners");
        String str10 = str5;
        Intrinsics.checkParameterIsNotNull(str10, "SortField");
        List<SortRule> list4 = list2;
        Intrinsics.checkParameterIsNotNull(list4, "SortRule");
        return new SearchInput(i, str6, str7, str8, i2, str9, list3, z, str10, list4, i3, i4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SearchInput) {
                SearchInput searchInput = (SearchInput) obj;
                if ((this.CountOfVehicles == searchInput.CountOfVehicles) && Intrinsics.areEqual((Object) this.Keyword, (Object) searchInput.Keyword) && Intrinsics.areEqual((Object) this.Latitude, (Object) searchInput.Latitude) && Intrinsics.areEqual((Object) this.Longitude, (Object) searchInput.Longitude)) {
                    if ((this.RequestedApp == searchInput.RequestedApp) && Intrinsics.areEqual((Object) this.Scope, (Object) searchInput.Scope) && Intrinsics.areEqual((Object) this.SelectedRefiners, (Object) searchInput.SelectedRefiners)) {
                        if ((this.SortAscending == searchInput.SortAscending) && Intrinsics.areEqual((Object) this.SortField, (Object) searchInput.SortField) && Intrinsics.areEqual((Object) this.SortRule, (Object) searchInput.SortRule)) {
                            if (this.StartIndex == searchInput.StartIndex) {
                                if (this.TimeZoneID == searchInput.TimeZoneID) {
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
        int hashCode = Integer.valueOf(this.CountOfVehicles).hashCode() * 31;
        String str = this.Keyword;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.Latitude;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.Longitude;
        int hashCode4 = (((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + Integer.valueOf(this.RequestedApp).hashCode()) * 31;
        String str4 = this.Scope;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<SelectedRefiner> list = this.SelectedRefiners;
        int hashCode6 = (hashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z = this.SortAscending;
        if (z) {
            z = true;
        }
        int i2 = (hashCode6 + (z ? 1 : 0)) * 31;
        String str5 = this.SortField;
        int hashCode7 = (i2 + (str5 != null ? str5.hashCode() : 0)) * 31;
        List<SortRule> list2 = this.SortRule;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return ((((hashCode7 + i) * 31) + Integer.valueOf(this.StartIndex).hashCode()) * 31) + Integer.valueOf(this.TimeZoneID).hashCode();
    }

    @NotNull
    public String toString() {
        return "SearchInput(CountOfVehicles=" + this.CountOfVehicles + ", Keyword=" + this.Keyword + ", Latitude=" + this.Latitude + ", Longitude=" + this.Longitude + ", RequestedApp=" + this.RequestedApp + ", Scope=" + this.Scope + ", SelectedRefiners=" + this.SelectedRefiners + ", SortAscending=" + this.SortAscending + ", SortField=" + this.SortField + ", SortRule=" + this.SortRule + ", StartIndex=" + this.StartIndex + ", TimeZoneID=" + this.TimeZoneID + ")";
    }

    public SearchInput(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, int i2, @NotNull String str4, @NotNull List<SelectedRefiner> list, boolean z, @NotNull String str5, @NotNull List<SortRule> list2, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(str, "Keyword");
        Intrinsics.checkParameterIsNotNull(str2, "Latitude");
        Intrinsics.checkParameterIsNotNull(str3, "Longitude");
        Intrinsics.checkParameterIsNotNull(str4, "Scope");
        Intrinsics.checkParameterIsNotNull(list, "SelectedRefiners");
        Intrinsics.checkParameterIsNotNull(str5, "SortField");
        Intrinsics.checkParameterIsNotNull(list2, "SortRule");
        this.CountOfVehicles = i;
        this.Keyword = str;
        this.Latitude = str2;
        this.Longitude = str3;
        this.RequestedApp = i2;
        this.Scope = str4;
        this.SelectedRefiners = list;
        this.SortAscending = z;
        this.SortField = str5;
        this.SortRule = list2;
        this.StartIndex = i3;
        this.TimeZoneID = i4;
    }

    public final int getCountOfVehicles() {
        return this.CountOfVehicles;
    }

    public final void setCountOfVehicles(int i) {
        this.CountOfVehicles = i;
    }

    @NotNull
    public final String getKeyword() {
        return this.Keyword;
    }

    @NotNull
    public final String getLatitude() {
        return this.Latitude;
    }

    @NotNull
    public final String getLongitude() {
        return this.Longitude;
    }

    public final int getRequestedApp() {
        return this.RequestedApp;
    }

    @NotNull
    public final String getScope() {
        return this.Scope;
    }

    @NotNull
    public final List<SelectedRefiner> getSelectedRefiners() {
        return this.SelectedRefiners;
    }

    public final boolean getSortAscending() {
        return this.SortAscending;
    }

    @NotNull
    public final String getSortField() {
        return this.SortField;
    }

    @NotNull
    public final List<SortRule> getSortRule() {
        return this.SortRule;
    }

    public final int getStartIndex() {
        return this.StartIndex;
    }

    public final void setStartIndex(int i) {
        this.StartIndex = i;
    }

    public final int getTimeZoneID() {
        return this.TimeZoneID;
    }
}
