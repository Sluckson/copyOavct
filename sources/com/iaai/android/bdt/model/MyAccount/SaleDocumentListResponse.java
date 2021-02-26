package com.iaai.android.bdt.model.MyAccount;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\bHÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006&"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/SaleDocumentListResponse;", "Landroid/os/Parcelable;", "Error", "", "TitleInstructionItemList", "", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocumentListModel;", "ItemCount", "", "ShowTitleHandlingInstructionInfoScreen", "BuyerGlobalInstructionNote", "(Ljava/lang/String;Ljava/util/List;IILjava/lang/String;)V", "getBuyerGlobalInstructionNote", "()Ljava/lang/String;", "getError", "getItemCount", "()I", "getShowTitleHandlingInstructionInfoScreen", "getTitleInstructionItemList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Parcelize
/* compiled from: SaleDocumentListResponse.kt */
public final class SaleDocumentListResponse implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @Nullable
    private final String BuyerGlobalInstructionNote;
    @NotNull
    private final String Error;
    private final int ItemCount;
    private final int ShowTitleHandlingInstructionInfoScreen;
    @NotNull
    private final List<SaleDocumentListModel> TitleInstructionItemList;

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((SaleDocumentListModel) SaleDocumentListModel.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new SaleDocumentListResponse(readString, arrayList, parcel.readInt(), parcel.readInt(), parcel.readString());
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new SaleDocumentListResponse[i];
        }
    }

    @NotNull
    public static /* synthetic */ SaleDocumentListResponse copy$default(SaleDocumentListResponse saleDocumentListResponse, String str, List<SaleDocumentListModel> list, int i, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = saleDocumentListResponse.Error;
        }
        if ((i3 & 2) != 0) {
            list = saleDocumentListResponse.TitleInstructionItemList;
        }
        List<SaleDocumentListModel> list2 = list;
        if ((i3 & 4) != 0) {
            i = saleDocumentListResponse.ItemCount;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = saleDocumentListResponse.ShowTitleHandlingInstructionInfoScreen;
        }
        int i5 = i2;
        if ((i3 & 16) != 0) {
            str2 = saleDocumentListResponse.BuyerGlobalInstructionNote;
        }
        return saleDocumentListResponse.copy(str, list2, i4, i5, str2);
    }

    @NotNull
    public final String component1() {
        return this.Error;
    }

    @NotNull
    public final List<SaleDocumentListModel> component2() {
        return this.TitleInstructionItemList;
    }

    public final int component3() {
        return this.ItemCount;
    }

    public final int component4() {
        return this.ShowTitleHandlingInstructionInfoScreen;
    }

    @Nullable
    public final String component5() {
        return this.BuyerGlobalInstructionNote;
    }

    @NotNull
    public final SaleDocumentListResponse copy(@NotNull String str, @NotNull List<SaleDocumentListModel> list, int i, int i2, @Nullable String str2) {
        Intrinsics.checkParameterIsNotNull(str, "Error");
        Intrinsics.checkParameterIsNotNull(list, "TitleInstructionItemList");
        return new SaleDocumentListResponse(str, list, i, i2, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SaleDocumentListResponse) {
                SaleDocumentListResponse saleDocumentListResponse = (SaleDocumentListResponse) obj;
                if (Intrinsics.areEqual((Object) this.Error, (Object) saleDocumentListResponse.Error) && Intrinsics.areEqual((Object) this.TitleInstructionItemList, (Object) saleDocumentListResponse.TitleInstructionItemList)) {
                    if (this.ItemCount == saleDocumentListResponse.ItemCount) {
                        if (!(this.ShowTitleHandlingInstructionInfoScreen == saleDocumentListResponse.ShowTitleHandlingInstructionInfoScreen) || !Intrinsics.areEqual((Object) this.BuyerGlobalInstructionNote, (Object) saleDocumentListResponse.BuyerGlobalInstructionNote)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.Error;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<SaleDocumentListModel> list = this.TitleInstructionItemList;
        int hashCode2 = (((((hashCode + (list != null ? list.hashCode() : 0)) * 31) + Integer.valueOf(this.ItemCount).hashCode()) * 31) + Integer.valueOf(this.ShowTitleHandlingInstructionInfoScreen).hashCode()) * 31;
        String str2 = this.BuyerGlobalInstructionNote;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        return "SaleDocumentListResponse(Error=" + this.Error + ", TitleInstructionItemList=" + this.TitleInstructionItemList + ", ItemCount=" + this.ItemCount + ", ShowTitleHandlingInstructionInfoScreen=" + this.ShowTitleHandlingInstructionInfoScreen + ", BuyerGlobalInstructionNote=" + this.BuyerGlobalInstructionNote + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.Error);
        List<SaleDocumentListModel> list = this.TitleInstructionItemList;
        parcel.writeInt(list.size());
        for (SaleDocumentListModel writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, 0);
        }
        parcel.writeInt(this.ItemCount);
        parcel.writeInt(this.ShowTitleHandlingInstructionInfoScreen);
        parcel.writeString(this.BuyerGlobalInstructionNote);
    }

    public SaleDocumentListResponse(@NotNull String str, @NotNull List<SaleDocumentListModel> list, int i, int i2, @Nullable String str2) {
        Intrinsics.checkParameterIsNotNull(str, "Error");
        Intrinsics.checkParameterIsNotNull(list, "TitleInstructionItemList");
        this.Error = str;
        this.TitleInstructionItemList = list;
        this.ItemCount = i;
        this.ShowTitleHandlingInstructionInfoScreen = i2;
        this.BuyerGlobalInstructionNote = str2;
    }

    @NotNull
    public final String getError() {
        return this.Error;
    }

    @NotNull
    public final List<SaleDocumentListModel> getTitleInstructionItemList() {
        return this.TitleInstructionItemList;
    }

    public final int getItemCount() {
        return this.ItemCount;
    }

    public final int getShowTitleHandlingInstructionInfoScreen() {
        return this.ShowTitleHandlingInstructionInfoScreen;
    }

    @Nullable
    public final String getBuyerGlobalInstructionNote() {
        return this.BuyerGlobalInstructionNote;
    }
}
