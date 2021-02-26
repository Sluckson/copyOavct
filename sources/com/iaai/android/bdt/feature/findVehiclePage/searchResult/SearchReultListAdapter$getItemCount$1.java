package com.iaai.android.bdt.feature.findVehiclePage.searchResult;

import com.iaai.android.bdt.model.auctionSalesList.AuctionSalesListHeader;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SearchResultListAdapter.kt */
final class SearchReultListAdapter$getItemCount$1 extends MutablePropertyReference0 {
    SearchReultListAdapter$getItemCount$1(SearchReultListAdapter searchReultListAdapter) {
        super(searchReultListAdapter);
    }

    public String getName() {
        return "auctionSalesListHeader";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(SearchReultListAdapter.class);
    }

    public String getSignature() {
        return "getAuctionSalesListHeader()Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListHeader;";
    }

    @Nullable
    public Object get() {
        return ((SearchReultListAdapter) this.receiver).getAuctionSalesListHeader();
    }

    public void set(@Nullable Object obj) {
        ((SearchReultListAdapter) this.receiver).setAuctionSalesListHeader((AuctionSalesListHeader) obj);
    }
}
