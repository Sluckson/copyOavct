package com.iaai.android.bdt.model.toBePaid.saleDocument.defaultResponse;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/saleDocument/defaultResponse/GetSaleDocListResponse;", "Landroid/os/Parcelable;", "Error", "", "ItemCount", "", "TitleInstructionItemList", "", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/defaultResponse/TitleInstructionItem;", "(Ljava/lang/String;ILjava/util/List;)V", "getError", "()Ljava/lang/String;", "getItemCount", "()I", "getTitleInstructionItemList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Parcelize
/* compiled from: GetSaleDocListResponse.kt */
public final class GetSaleDocListResponse implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @NotNull
    private final String Error;
    private final int ItemCount;
    @NotNull
    private final List<TitleInstructionItem> TitleInstructionItemList;

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList.add((TitleInstructionItem) TitleInstructionItem.CREATOR.createFromParcel(parcel));
                readInt2--;
            }
            return new GetSaleDocListResponse(readString, readInt, arrayList);
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new GetSaleDocListResponse[i];
        }
    }

    @NotNull
    public static /* synthetic */ GetSaleDocListResponse copy$default(GetSaleDocListResponse getSaleDocListResponse, String str, int i, List<TitleInstructionItem> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = getSaleDocListResponse.Error;
        }
        if ((i2 & 2) != 0) {
            i = getSaleDocListResponse.ItemCount;
        }
        if ((i2 & 4) != 0) {
            list = getSaleDocListResponse.TitleInstructionItemList;
        }
        return getSaleDocListResponse.copy(str, i, list);
    }

    @NotNull
    public final String component1() {
        return this.Error;
    }

    public final int component2() {
        return this.ItemCount;
    }

    @NotNull
    public final List<TitleInstructionItem> component3() {
        return this.TitleInstructionItemList;
    }

    @NotNull
    public final GetSaleDocListResponse copy(@NotNull String str, int i, @NotNull List<TitleInstructionItem> list) {
        Intrinsics.checkParameterIsNotNull(str, "Error");
        Intrinsics.checkParameterIsNotNull(list, "TitleInstructionItemList");
        return new GetSaleDocListResponse(str, i, list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof GetSaleDocListResponse) {
                GetSaleDocListResponse getSaleDocListResponse = (GetSaleDocListResponse) obj;
                if (Intrinsics.areEqual((Object) this.Error, (Object) getSaleDocListResponse.Error)) {
                    if (!(this.ItemCount == getSaleDocListResponse.ItemCount) || !Intrinsics.areEqual((Object) this.TitleInstructionItemList, (Object) getSaleDocListResponse.TitleInstructionItemList)) {
                        return false;
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
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + Integer.valueOf(this.ItemCount).hashCode()) * 31;
        List<TitleInstructionItem> list = this.TitleInstructionItemList;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "GetSaleDocListResponse(Error=" + this.Error + ", ItemCount=" + this.ItemCount + ", TitleInstructionItemList=" + this.TitleInstructionItemList + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.Error);
        parcel.writeInt(this.ItemCount);
        List<TitleInstructionItem> list = this.TitleInstructionItemList;
        parcel.writeInt(list.size());
        for (TitleInstructionItem writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, 0);
        }
    }

    public GetSaleDocListResponse(@NotNull String str, int i, @NotNull List<TitleInstructionItem> list) {
        Intrinsics.checkParameterIsNotNull(str, "Error");
        Intrinsics.checkParameterIsNotNull(list, "TitleInstructionItemList");
        this.Error = str;
        this.ItemCount = i;
        this.TitleInstructionItemList = list;
    }

    @NotNull
    public final String getError() {
        return this.Error;
    }

    public final int getItemCount() {
        return this.ItemCount;
    }

    @NotNull
    public final List<TitleInstructionItem> getTitleInstructionItemList() {
        return this.TitleInstructionItemList;
    }
}
