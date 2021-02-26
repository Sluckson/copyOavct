package com.iaai.android.bdt.utils;

import android.view.View;
import com.iaai.android.bdt.model.MyAccount.WatchListModel;
import com.iaai.android.bdt.model.auctionSalesList.ResultData;
import com.iaai.android.bdt.model.auctionmainlist.AuctionLocations;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J0\u0010\u0012\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J \u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u000bH&J \u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\u001d"}, mo66933d2 = {"Lcom/iaai/android/bdt/utils/CustomItemClickListener;", "", "onAuctionListItemClick", "", "v", "Landroid/view/View;", "data", "Lcom/iaai/android/bdt/model/auctionmainlist/AuctionLocations;", "onAuctionSaleItemClick", "Lcom/iaai/android/bdt/model/MyAccount/WatchListModel;", "position", "", "Lcom/iaai/android/bdt/model/auctionSalesList/ResultData;", "onBidLiveItemClick", "onClickBidSalesList", "isBidLive", "", "onFilterItemClick", "onReceiptItemClick", "receiptNo", "", "isReceipt", "receiptSubjectLine", "salvageID", "onSortItemClick", "onUnWatchItemClick", "itemClick", "", "onWatchItemClick", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: CustomItemClickListener.kt */
public interface CustomItemClickListener {
    void onAuctionListItemClick(@NotNull View view, @NotNull AuctionLocations auctionLocations);

    void onAuctionSaleItemClick(@NotNull View view, @Nullable WatchListModel watchListModel, int i);

    void onAuctionSaleItemClick(@NotNull View view, @Nullable ResultData resultData, int i);

    void onBidLiveItemClick(@NotNull View view, @NotNull AuctionLocations auctionLocations);

    void onClickBidSalesList(int i, boolean z);

    void onFilterItemClick(int i);

    void onReceiptItemClick(int i, @NotNull String str, boolean z, @NotNull String str2, @NotNull String str3);

    void onSortItemClick(int i);

    void onUnWatchItemClick(@NotNull View view, long j, int i);

    void onWatchItemClick(@NotNull View view, long j, int i);
}
