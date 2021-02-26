package com.iaai.android.bdt.model.MyAccount;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000f¨\u0006\u001d"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/WatchListResponse;", "", "()V", "listModel", "", "Lcom/iaai/android/bdt/model/MyAccount/WatchListModel;", "getListModel", "()Ljava/util/List;", "setListModel", "(Ljava/util/List;)V", "selectedsortdirection", "", "getSelectedsortdirection", "()Ljava/lang/String;", "setSelectedsortdirection", "(Ljava/lang/String;)V", "selectedsortoption", "getSelectedsortoption", "setSelectedsortoption", "totalbidamount", "", "getTotalbidamount", "()Ljava/lang/Integer;", "setTotalbidamount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "totalcount", "getTotalcount", "setTotalcount", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: WatchListResponse.kt */
public final class WatchListResponse {
    @Nullable
    @SerializedName("list")
    @Expose
    private List<WatchListModel> listModel;
    @SerializedName("selectedsortdirection")
    @Nullable
    @Expose
    private String selectedsortdirection;
    @SerializedName("selectedsortoption")
    @Nullable
    @Expose
    private String selectedsortoption;
    @SerializedName("totalbidamount")
    @Nullable
    @Expose
    private Integer totalbidamount;
    @SerializedName("totalcount")
    @Nullable
    @Expose
    private String totalcount = "0";

    @Nullable
    public final List<WatchListModel> getListModel() {
        return this.listModel;
    }

    public final void setListModel(@Nullable List<WatchListModel> list) {
        this.listModel = list;
    }

    @Nullable
    public final String getSelectedsortdirection() {
        return this.selectedsortdirection;
    }

    public final void setSelectedsortdirection(@Nullable String str) {
        this.selectedsortdirection = str;
    }

    @Nullable
    public final String getSelectedsortoption() {
        return this.selectedsortoption;
    }

    public final void setSelectedsortoption(@Nullable String str) {
        this.selectedsortoption = str;
    }

    @Nullable
    public final Integer getTotalbidamount() {
        return this.totalbidamount;
    }

    public final void setTotalbidamount(@Nullable Integer num) {
        this.totalbidamount = num;
    }

    @Nullable
    public final String getTotalcount() {
        return this.totalcount;
    }

    public final void setTotalcount(@Nullable String str) {
        this.totalcount = str;
    }
}
