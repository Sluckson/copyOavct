package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListViewModel;
import com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList;

public class ItemManageOfferListBindingImpl extends ItemManageOfferListBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        sViewsWithIds.put(C2723R.C2726id.parent_item, 1);
        sViewsWithIds.put(C2723R.C2726id.tvStockNoValue, 2);
        sViewsWithIds.put(C2723R.C2726id.tvYearMakeModel, 3);
        sViewsWithIds.put(C2723R.C2726id.tvStockNo, 4);
        sViewsWithIds.put(C2723R.C2726id.tvBranchNameLane, 5);
        sViewsWithIds.put(C2723R.C2726id.tvDigitalNegotiationDateTime, 6);
        sViewsWithIds.put(C2723R.C2726id.ivVehicleThumbnail, 7);
        sViewsWithIds.put(C2723R.C2726id.linearLayout5, 8);
        sViewsWithIds.put(C2723R.C2726id.ivInfo, 9);
        sViewsWithIds.put(C2723R.C2726id.tvSellerCounterOffer, 10);
        sViewsWithIds.put(C2723R.C2726id.clActionAreaLayout, 11);
        sViewsWithIds.put(C2723R.C2726id.tvYourHighestBidLable, 12);
        sViewsWithIds.put(C2723R.C2726id.tvYourHighestBidLable2, 13);
        sViewsWithIds.put(C2723R.C2726id.tvYourHighBid, 14);
        sViewsWithIds.put(C2723R.C2726id.tvSellerOfferAmount, 15);
        sViewsWithIds.put(C2723R.C2726id.btnKeepMyBid, 16);
        sViewsWithIds.put(C2723R.C2726id.btnRaiseMyBid, 17);
        sViewsWithIds.put(C2723R.C2726id.btnBuyIt, 18);
        sViewsWithIds.put(C2723R.C2726id.tvWhyThisIs, 19);
        sViewsWithIds.put(C2723R.C2726id.llBidHistory, 20);
        sViewsWithIds.put(C2723R.C2726id.ivArrowDown, 21);
        sViewsWithIds.put(C2723R.C2726id.tvBidHistory, 22);
        sViewsWithIds.put(C2723R.C2726id.llBidHistoryDetails, 23);
    }

    public ItemManageOfferListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 24, sIncludes, sViewsWithIds));
    }

    private ItemManageOfferListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[18], objArr[16], objArr[17], objArr[11], objArr[21], objArr[9], objArr[7], objArr[8], objArr[20], objArr[23], objArr[0], objArr[1], objArr[22], objArr[5], objArr[6], objArr[10], objArr[15], objArr[4], objArr[2], objArr[19], objArr[3], objArr[14], objArr[12], objArr[13]);
        this.mDirtyFlags = -1;
        this.mainRowLayout.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        if (6 == i) {
            setViewModel((ManageOfferListViewModel) obj);
        } else if (7 != i) {
            return false;
        } else {
            setMobileNegotiation((MobileNegotiationsList) obj);
        }
        return true;
    }

    public void setViewModel(@Nullable ManageOfferListViewModel manageOfferListViewModel) {
        this.mViewModel = manageOfferListViewModel;
    }

    public void setMobileNegotiation(@Nullable MobileNegotiationsList mobileNegotiationsList) {
        this.mMobileNegotiation = mobileNegotiationsList;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
    }
}
