package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListViewModel;
import com.iaai.android.bdt.feature.viewPager.FastSearchViewModel;
import com.iaai.android.bdt.model.auctionSalesList.ResultData;
import com.iaai.android.bdt.model.fastSearch.Vehicle;
import com.iaai.android.bdt.model.fastSearchFilter2.FormattedResult;

public class ItemAuctionSalesListBindingImpl extends ItemAuctionSalesListBinding {
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
        sViewsWithIds.put(C2723R.C2726id.frameLayout1, 2);
        sViewsWithIds.put(C2723R.C2726id.fl_watch, 3);
        sViewsWithIds.put(C2723R.C2726id.vehicle_image_1, 4);
        sViewsWithIds.put(C2723R.C2726id.fl_unwatch, 5);
        sViewsWithIds.put(C2723R.C2726id.vehicle_image_2, 6);
        sViewsWithIds.put(C2723R.C2726id.llWatch, 7);
        sViewsWithIds.put(C2723R.C2726id.llUnWatch, 8);
        sViewsWithIds.put(C2723R.C2726id.llCAFlag, 9);
        sViewsWithIds.put(C2723R.C2726id.llUKFlag, 10);
        sViewsWithIds.put(C2723R.C2726id.yearMakeModel, 11);
        sViewsWithIds.put(C2723R.C2726id.imgCircle, 12);
        sViewsWithIds.put(C2723R.C2726id.constraintLayout, 13);
        sViewsWithIds.put(C2723R.C2726id.img_arrow_right, 14);
        sViewsWithIds.put(C2723R.C2726id.tvAuctionTime, 15);
        sViewsWithIds.put(C2723R.C2726id.pre_sale_row_3_right, 16);
        sViewsWithIds.put(C2723R.C2726id.pre_sale_row_4_right, 17);
        sViewsWithIds.put(C2723R.C2726id.tvBranchName, 18);
        sViewsWithIds.put(C2723R.C2726id.tv_lane_sales_value, 19);
        sViewsWithIds.put(C2723R.C2726id.tvSeparator, 20);
        sViewsWithIds.put(C2723R.C2726id.tvAisleValue, 21);
        sViewsWithIds.put(C2723R.C2726id.tvLongDataLane, 22);
        sViewsWithIds.put(C2723R.C2726id.tv_primary_damage_value, 23);
        sViewsWithIds.put(C2723R.C2726id.estimateTimeOnBlock, 24);
        sViewsWithIds.put(C2723R.C2726id.tvProviderName, 25);
        sViewsWithIds.put(C2723R.C2726id.tvTitleNotAvailable, 26);
        sViewsWithIds.put(C2723R.C2726id.llBadgeConatiner, 27);
        sViewsWithIds.put(C2723R.C2726id.tvIsPublic, 28);
        sViewsWithIds.put(C2723R.C2726id.tvRunDrive, 29);
        sViewsWithIds.put(C2723R.C2726id.tvOffsite, 30);
        sViewsWithIds.put(C2723R.C2726id.llReceiptConatiner, 31);
        sViewsWithIds.put(C2723R.C2726id.tvOffsiteRelease, 32);
        sViewsWithIds.put(C2723R.C2726id.tvBundledReceipt, 33);
        sViewsWithIds.put(C2723R.C2726id.tvStockReceipt, 34);
    }

    public ItemAuctionSalesListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 35, sIncludes, sViewsWithIds));
    }

    private ItemAuctionSalesListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[13], objArr[24], objArr[5], objArr[3], objArr[2], objArr[14], objArr[12], objArr[27], objArr[9], objArr[31], objArr[10], objArr[8], objArr[7], objArr[0], objArr[1], objArr[16], objArr[17], objArr[21], objArr[15], objArr[18], objArr[33], objArr[28], objArr[19], objArr[22], objArr[30], objArr[32], objArr[23], objArr[25], objArr[29], objArr[20], objArr[34], objArr[26], objArr[4], objArr[6], objArr[11]);
        this.mDirtyFlags = -1;
        this.mainRowLayout.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32;
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
        if (10 == i) {
            setVehicleSearchModel((FastSearchViewModel) obj);
        } else if (3 == i) {
            setFormattedResult((FormattedResult) obj);
        } else if (4 == i) {
            setVehicleData((Vehicle) obj);
        } else if (6 == i) {
            setViewModel((AuctionSalesListViewModel) obj);
        } else if (2 != i) {
            return false;
        } else {
            setResultData((ResultData) obj);
        }
        return true;
    }

    public void setVehicleSearchModel(@Nullable FastSearchViewModel fastSearchViewModel) {
        this.mVehicleSearchModel = fastSearchViewModel;
    }

    public void setFormattedResult(@Nullable FormattedResult formattedResult) {
        this.mFormattedResult = formattedResult;
    }

    public void setVehicleData(@Nullable Vehicle vehicle) {
        this.mVehicleData = vehicle;
    }

    public void setViewModel(@Nullable AuctionSalesListViewModel auctionSalesListViewModel) {
        this.mViewModel = auctionSalesListViewModel;
    }

    public void setResultData(@Nullable ResultData resultData) {
        this.mResultData = resultData;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
    }
}
