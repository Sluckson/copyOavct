package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.productDetail.ProductDetailViewModel;
import com.iaai.android.bdt.model.productDetail.biddingInfo.BiddingInformation;

public class FragmentCostCalculatorLayoutBindingImpl extends FragmentCostCalculatorLayoutBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    @NonNull
    private final FrameLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        sViewsWithIds.put(C2723R.C2726id.tv_estimated_cost, 1);
        sViewsWithIds.put(C2723R.C2726id.tv_cost_value, 2);
        sViewsWithIds.put(C2723R.C2726id.estimate_label, 3);
        sViewsWithIds.put(C2723R.C2726id.view, 4);
        sViewsWithIds.put(C2723R.C2726id.bid_amount_label, 5);
        sViewsWithIds.put(C2723R.C2726id.linearLayout2, 6);
        sViewsWithIds.put(C2723R.C2726id.lbl_estimated_bid_amount, 7);
        sViewsWithIds.put(C2723R.C2726id.txt_bid_amount_layout, 8);
        sViewsWithIds.put(C2723R.C2726id.txt_max_bid, 9);
        sViewsWithIds.put(C2723R.C2726id.txt_increment_bid_amount, 10);
        sViewsWithIds.put(C2723R.C2726id.btnViewEstimate, 11);
        sViewsWithIds.put(C2723R.C2726id.viewCostBreakDown, 12);
        sViewsWithIds.put(C2723R.C2726id.costBreakDown, 13);
        sViewsWithIds.put(C2723R.C2726id.tv_cost_break_down, 14);
        sViewsWithIds.put(C2723R.C2726id.rvCostBreakDown, 15);
        sViewsWithIds.put(C2723R.C2726id.btnRemoveEdit, 16);
        sViewsWithIds.put(C2723R.C2726id.view1, 17);
        sViewsWithIds.put(C2723R.C2726id.llCostInfo, 18);
        sViewsWithIds.put(C2723R.C2726id.tvLabelTotalCost, 19);
        sViewsWithIds.put(C2723R.C2726id.tvValueTotalCost, 20);
        sViewsWithIds.put(C2723R.C2726id.tv_deliver_transport_lable, 21);
        sViewsWithIds.put(C2723R.C2726id.linearLayout3, 22);
        sViewsWithIds.put(C2723R.C2726id.txt_zip_code_layout, 23);
        sViewsWithIds.put(C2723R.C2726id.txt_zip_code, 24);
        sViewsWithIds.put(C2723R.C2726id.btnGetQuote, 25);
        sViewsWithIds.put(C2723R.C2726id.cost_cal_pbLoading, 26);
    }

    public FragmentCostCalculatorLayoutBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 27, sIncludes, sViewsWithIds));
    }

    private FragmentCostCalculatorLayoutBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[5], objArr[25], objArr[16], objArr[11], objArr[13], objArr[26], objArr[3], objArr[7], objArr[6], objArr[22], objArr[18], objArr[15], objArr[14], objArr[2], objArr[21], objArr[1], objArr[19], objArr[20], objArr[8], objArr[10], objArr[9], objArr[24], objArr[23], objArr[4], objArr[17], objArr[12]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
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
        if (5 == i) {
            setBiddingInfo((BiddingInformation) obj);
        } else if (6 != i) {
            return false;
        } else {
            setViewModel((ProductDetailViewModel) obj);
        }
        return true;
    }

    public void setBiddingInfo(@Nullable BiddingInformation biddingInformation) {
        this.mBiddingInfo = biddingInformation;
    }

    public void setViewModel(@Nullable ProductDetailViewModel productDetailViewModel) {
        this.mViewModel = productDetailViewModel;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
    }
}
