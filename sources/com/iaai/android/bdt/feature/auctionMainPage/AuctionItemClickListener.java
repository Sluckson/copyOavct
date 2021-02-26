package com.iaai.android.bdt.feature.auctionMainPage;

import android.view.View;
import com.iaai.android.bdt.model.auctionmainlist.AuctionLocations;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionMainPage/AuctionItemClickListener;", "", "onAuctionClick", "", "v", "Landroid/view/View;", "data", "Lcom/iaai/android/bdt/model/auctionmainlist/AuctionLocations;", "onAuctionJoinNowClick", "isBidLive", "", "onAuctionViewListClick", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionItemClickListener.kt */
public interface AuctionItemClickListener {
    void onAuctionClick(@NotNull View view, @NotNull AuctionLocations auctionLocations);

    void onAuctionJoinNowClick(@NotNull View view, @NotNull AuctionLocations auctionLocations, boolean z);

    void onAuctionViewListClick(@NotNull View view, @NotNull AuctionLocations auctionLocations);
}
