package com.iaai.android.bdt.model.digitalNegotiation;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003J\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\rHÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u00061"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/digitalNegotiation/NegotiationsBidHistory;", "Ljava/io/Serializable;", "ASAPUser", "", "CSAUser", "Description", "EventDatetime", "Eventtype", "FormattedAmount", "NegotiationAmount", "", "NegotiationId", "SalvageID", "", "Source", "Status", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getASAPUser", "()Ljava/lang/String;", "getCSAUser", "getDescription", "getEventDatetime", "getEventtype", "getFormattedAmount", "getNegotiationAmount", "()D", "getNegotiationId", "getSalvageID", "()I", "getSource", "getStatus", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: NegotiationsBidHistory.kt */
public final class NegotiationsBidHistory implements Serializable {
    @NotNull
    private final String ASAPUser;
    @NotNull
    private final String CSAUser;
    @Nullable
    private final String Description;
    @NotNull
    private final String EventDatetime;
    @NotNull
    private final String Eventtype;
    @Nullable
    private final String FormattedAmount;
    private final double NegotiationAmount;
    @NotNull
    private final String NegotiationId;
    private final int SalvageID;
    @Nullable
    private final String Source;
    @Nullable
    private final String Status;

    @NotNull
    public static /* synthetic */ NegotiationsBidHistory copy$default(NegotiationsBidHistory negotiationsBidHistory, String str, String str2, String str3, String str4, String str5, String str6, double d, String str7, int i, String str8, String str9, int i2, Object obj) {
        NegotiationsBidHistory negotiationsBidHistory2 = negotiationsBidHistory;
        int i3 = i2;
        return negotiationsBidHistory.copy((i3 & 1) != 0 ? negotiationsBidHistory2.ASAPUser : str, (i3 & 2) != 0 ? negotiationsBidHistory2.CSAUser : str2, (i3 & 4) != 0 ? negotiationsBidHistory2.Description : str3, (i3 & 8) != 0 ? negotiationsBidHistory2.EventDatetime : str4, (i3 & 16) != 0 ? negotiationsBidHistory2.Eventtype : str5, (i3 & 32) != 0 ? negotiationsBidHistory2.FormattedAmount : str6, (i3 & 64) != 0 ? negotiationsBidHistory2.NegotiationAmount : d, (i3 & 128) != 0 ? negotiationsBidHistory2.NegotiationId : str7, (i3 & 256) != 0 ? negotiationsBidHistory2.SalvageID : i, (i3 & 512) != 0 ? negotiationsBidHistory2.Source : str8, (i3 & 1024) != 0 ? negotiationsBidHistory2.Status : str9);
    }

    @NotNull
    public final String component1() {
        return this.ASAPUser;
    }

    @Nullable
    public final String component10() {
        return this.Source;
    }

    @Nullable
    public final String component11() {
        return this.Status;
    }

    @NotNull
    public final String component2() {
        return this.CSAUser;
    }

    @Nullable
    public final String component3() {
        return this.Description;
    }

    @NotNull
    public final String component4() {
        return this.EventDatetime;
    }

    @NotNull
    public final String component5() {
        return this.Eventtype;
    }

    @Nullable
    public final String component6() {
        return this.FormattedAmount;
    }

    public final double component7() {
        return this.NegotiationAmount;
    }

    @NotNull
    public final String component8() {
        return this.NegotiationId;
    }

    public final int component9() {
        return this.SalvageID;
    }

    @NotNull
    public final NegotiationsBidHistory copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5, @Nullable String str6, double d, @NotNull String str7, int i, @Nullable String str8, @Nullable String str9) {
        Intrinsics.checkParameterIsNotNull(str, "ASAPUser");
        String str10 = str2;
        Intrinsics.checkParameterIsNotNull(str10, "CSAUser");
        String str11 = str4;
        Intrinsics.checkParameterIsNotNull(str11, "EventDatetime");
        String str12 = str5;
        Intrinsics.checkParameterIsNotNull(str12, "Eventtype");
        String str13 = str7;
        Intrinsics.checkParameterIsNotNull(str13, "NegotiationId");
        return new NegotiationsBidHistory(str, str10, str3, str11, str12, str6, d, str13, i, str8, str9);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof NegotiationsBidHistory) {
                NegotiationsBidHistory negotiationsBidHistory = (NegotiationsBidHistory) obj;
                if (Intrinsics.areEqual((Object) this.ASAPUser, (Object) negotiationsBidHistory.ASAPUser) && Intrinsics.areEqual((Object) this.CSAUser, (Object) negotiationsBidHistory.CSAUser) && Intrinsics.areEqual((Object) this.Description, (Object) negotiationsBidHistory.Description) && Intrinsics.areEqual((Object) this.EventDatetime, (Object) negotiationsBidHistory.EventDatetime) && Intrinsics.areEqual((Object) this.Eventtype, (Object) negotiationsBidHistory.Eventtype) && Intrinsics.areEqual((Object) this.FormattedAmount, (Object) negotiationsBidHistory.FormattedAmount) && Double.compare(this.NegotiationAmount, negotiationsBidHistory.NegotiationAmount) == 0 && Intrinsics.areEqual((Object) this.NegotiationId, (Object) negotiationsBidHistory.NegotiationId)) {
                    if (!(this.SalvageID == negotiationsBidHistory.SalvageID) || !Intrinsics.areEqual((Object) this.Source, (Object) negotiationsBidHistory.Source) || !Intrinsics.areEqual((Object) this.Status, (Object) negotiationsBidHistory.Status)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.ASAPUser;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.CSAUser;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.Description;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.EventDatetime;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.Eventtype;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.FormattedAmount;
        int hashCode6 = (((hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31) + Double.valueOf(this.NegotiationAmount).hashCode()) * 31;
        String str7 = this.NegotiationId;
        int hashCode7 = (((hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31) + Integer.valueOf(this.SalvageID).hashCode()) * 31;
        String str8 = this.Source;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.Status;
        if (str9 != null) {
            i = str9.hashCode();
        }
        return hashCode8 + i;
    }

    @NotNull
    public String toString() {
        return "NegotiationsBidHistory(ASAPUser=" + this.ASAPUser + ", CSAUser=" + this.CSAUser + ", Description=" + this.Description + ", EventDatetime=" + this.EventDatetime + ", Eventtype=" + this.Eventtype + ", FormattedAmount=" + this.FormattedAmount + ", NegotiationAmount=" + this.NegotiationAmount + ", NegotiationId=" + this.NegotiationId + ", SalvageID=" + this.SalvageID + ", Source=" + this.Source + ", Status=" + this.Status + ")";
    }

    public NegotiationsBidHistory(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5, @Nullable String str6, double d, @NotNull String str7, int i, @Nullable String str8, @Nullable String str9) {
        Intrinsics.checkParameterIsNotNull(str, "ASAPUser");
        Intrinsics.checkParameterIsNotNull(str2, "CSAUser");
        Intrinsics.checkParameterIsNotNull(str4, "EventDatetime");
        Intrinsics.checkParameterIsNotNull(str5, "Eventtype");
        Intrinsics.checkParameterIsNotNull(str7, "NegotiationId");
        this.ASAPUser = str;
        this.CSAUser = str2;
        this.Description = str3;
        this.EventDatetime = str4;
        this.Eventtype = str5;
        this.FormattedAmount = str6;
        this.NegotiationAmount = d;
        this.NegotiationId = str7;
        this.SalvageID = i;
        this.Source = str8;
        this.Status = str9;
    }

    @NotNull
    public final String getASAPUser() {
        return this.ASAPUser;
    }

    @NotNull
    public final String getCSAUser() {
        return this.CSAUser;
    }

    @Nullable
    public final String getDescription() {
        return this.Description;
    }

    @NotNull
    public final String getEventDatetime() {
        return this.EventDatetime;
    }

    @NotNull
    public final String getEventtype() {
        return this.Eventtype;
    }

    @Nullable
    public final String getFormattedAmount() {
        return this.FormattedAmount;
    }

    public final double getNegotiationAmount() {
        return this.NegotiationAmount;
    }

    @NotNull
    public final String getNegotiationId() {
        return this.NegotiationId;
    }

    public final int getSalvageID() {
        return this.SalvageID;
    }

    @Nullable
    public final String getSource() {
        return this.Source;
    }

    @Nullable
    public final String getStatus() {
        return this.Status;
    }
}
