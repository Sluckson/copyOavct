package com.iaai.android.bdt.feature.account.buyNowOfferList;

import com.iaai.android.bdt.model.auctionSalesList.AuctionSalesListHeader;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BuyNowOfferListAdapter.kt */
final class BuyNowOfferListAdapter$getItemCount$1 extends MutablePropertyReference0 {
    BuyNowOfferListAdapter$getItemCount$1(BuyNowOfferListAdapter buyNowOfferListAdapter) {
        super(buyNowOfferListAdapter);
    }

    public String getName() {
        return "auctionSalesListHeader";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(BuyNowOfferListAdapter.class);
    }

    public String getSignature() {
        return "getAuctionSalesListHeader()Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListHeader;";
    }

    @Nullable
    public Object get() {
        return ((BuyNowOfferListAdapter) this.receiver).getAuctionSalesListHeader();
    }

    public void set(@Nullable Object obj) {
        ((BuyNowOfferListAdapter) this.receiver).setAuctionSalesListHeader((AuctionSalesListHeader) obj);
    }
}
