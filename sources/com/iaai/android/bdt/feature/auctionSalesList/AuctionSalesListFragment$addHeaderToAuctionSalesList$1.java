package com.iaai.android.bdt.feature.auctionSalesList;

import com.iaai.android.bdt.model.auctionSalesList.AuctionDetails;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: AuctionSalesListFragment.kt */
final class AuctionSalesListFragment$addHeaderToAuctionSalesList$1 extends MutablePropertyReference0 {
    AuctionSalesListFragment$addHeaderToAuctionSalesList$1(AuctionSalesListFragment auctionSalesListFragment) {
        super(auctionSalesListFragment);
    }

    public String getName() {
        return "auctionDetails";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(AuctionSalesListFragment.class);
    }

    public String getSignature() {
        return "getAuctionDetails()Lcom/iaai/android/bdt/model/auctionSalesList/AuctionDetails;";
    }

    @Nullable
    public Object get() {
        return AuctionSalesListFragment.access$getAuctionDetails$p((AuctionSalesListFragment) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((AuctionSalesListFragment) this.receiver).auctionDetails = (AuctionDetails) obj;
    }
}
