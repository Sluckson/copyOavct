package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public class RowItemDeliveryInstructionBindingImpl extends RowItemDeliveryInstructionBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    @NonNull
    private final ConstraintLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        sViewsWithIds.put(C2723R.C2726id.clStockContainer, 1);
        sViewsWithIds.put(C2723R.C2726id.imgLayout, 2);
        sViewsWithIds.put(C2723R.C2726id.vehicleImage, 3);
        sViewsWithIds.put(C2723R.C2726id.ivIsSet, 4);
        sViewsWithIds.put(C2723R.C2726id.ivSelectItem, 5);
        sViewsWithIds.put(C2723R.C2726id.vehicleTitle, 6);
        sViewsWithIds.put(C2723R.C2726id.tvStockLabel, 7);
        sViewsWithIds.put(C2723R.C2726id.tvStockNumber, 8);
        sViewsWithIds.put(C2723R.C2726id.tvBranchInfo, 9);
        sViewsWithIds.put(C2723R.C2726id.tvDeliveryMode, 10);
        sViewsWithIds.put(C2723R.C2726id.viewSeparator2, 11);
    }

    public RowItemDeliveryInstructionBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private RowItemDeliveryInstructionBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1], objArr[2], objArr[4], objArr[5], objArr[9], objArr[10], objArr[7], objArr[8], objArr[3], objArr[6], objArr[11]);
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
