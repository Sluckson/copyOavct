package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.auctionmainlist.AuctionLocations;

public class RowItemAuctionMainListViewBindingImpl extends RowItemAuctionMainListViewBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    @NonNull
    private final RelativeLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        sViewsWithIds.put(C2723R.C2726id.card_view, 2);
        sViewsWithIds.put(C2723R.C2726id.section_status, 3);
        sViewsWithIds.put(C2723R.C2726id.txt_auction_phase, 4);
        sViewsWithIds.put(C2723R.C2726id.frameLayout, 5);
        sViewsWithIds.put(C2723R.C2726id.txt_bid_live, 6);
        sViewsWithIds.put(C2723R.C2726id.nf_indicator, 7);
        sViewsWithIds.put(C2723R.C2726id.txt_view_auction, 8);
        sViewsWithIds.put(C2723R.C2726id.section_detail, 9);
        sViewsWithIds.put(C2723R.C2726id.img_public_auction, 10);
        sViewsWithIds.put(C2723R.C2726id.txt_live_date, 11);
        sViewsWithIds.put(C2723R.C2726id.txt_vehicle_count, 12);
    }

    public RowItemAuctionMainListViewBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private RowItemAuctionMainListViewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[2], objArr[5], objArr[10], objArr[7], objArr[9], objArr[3], objArr[4], objArr[6], objArr[11], objArr[1], objArr[12], objArr[8]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.txtName.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
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
        if (8 != i) {
            return false;
        }
        setLocation((AuctionLocations) obj);
        return true;
    }

    public void setLocation(@Nullable AuctionLocations auctionLocations) {
        this.mLocation = auctionLocations;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AuctionLocations auctionLocations = this.mLocation;
        String str = null;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (!(i == 0 || auctionLocations == null)) {
            str = auctionLocations.getName();
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.txtName, str);
        }
    }
}
