package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public class FragmentBuyNowBindingImpl extends FragmentBuyNowBinding {
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

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        sViewsWithIds.put(C2723R.C2726id.svBuyNowContainer, 1);
        sViewsWithIds.put(C2723R.C2726id.tvYearModel, 2);
        sViewsWithIds.put(C2723R.C2726id.tvStockNumber, 3);
        sViewsWithIds.put(C2723R.C2726id.tvBranchName, 4);
        sViewsWithIds.put(C2723R.C2726id.tvVehicleLocation, 5);
        sViewsWithIds.put(C2723R.C2726id.tvBuyPrice, 6);
        sViewsWithIds.put(C2723R.C2726id.tvTimeLeftToBuy, 7);
        sViewsWithIds.put(C2723R.C2726id.tvAwardMessage, 8);
        sViewsWithIds.put(C2723R.C2726id.tvPaymentDue, 9);
        sViewsWithIds.put(C2723R.C2726id.tvPickUpBy, 10);
        sViewsWithIds.put(C2723R.C2726id.btnSubmit, 11);
        sViewsWithIds.put(C2723R.C2726id.rvCongratulationsContainer, 12);
        sViewsWithIds.put(C2723R.C2726id.ivCongratulations, 13);
        sViewsWithIds.put(C2723R.C2726id.tvCongratulations, 14);
        sViewsWithIds.put(C2723R.C2726id.tvCongratsMessage, 15);
        sViewsWithIds.put(C2723R.C2726id.btnClose, 16);
        sViewsWithIds.put(C2723R.C2726id.pbLoading, 17);
    }

    public FragmentBuyNowBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 18, sIncludes, sViewsWithIds));
    }

    private FragmentBuyNowBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[16], objArr[11], objArr[13], objArr[17], objArr[12], objArr[1], objArr[8], objArr[4], objArr[6], objArr[15], objArr[14], objArr[9], objArr[10], objArr[3], objArr[7], objArr[5], objArr[2]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1;
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

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
    }
}
