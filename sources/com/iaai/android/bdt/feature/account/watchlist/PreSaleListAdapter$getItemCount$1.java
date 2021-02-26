package com.iaai.android.bdt.feature.account.watchlist;

import com.iaai.android.bdt.model.auctionSalesList.AuctionSalesListHeader;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: PreSaleListAdapter.kt */
final class PreSaleListAdapter$getItemCount$1 extends MutablePropertyReference0 {
    PreSaleListAdapter$getItemCount$1(PreSaleListAdapter preSaleListAdapter) {
        super(preSaleListAdapter);
    }

    public String getName() {
        return "auctionSalesListHeader";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(PreSaleListAdapter.class);
    }

    public String getSignature() {
        return "getAuctionSalesListHeader()Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListHeader;";
    }

    @Nullable
    public Object get() {
        return ((PreSaleListAdapter) this.receiver).getAuctionSalesListHeader();
    }

    public void set(@Nullable Object obj) {
        ((PreSaleListAdapter) this.receiver).setAuctionSalesListHeader((AuctionSalesListHeader) obj);
    }
}
