package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public class ContentSortSalesListBindingImpl extends ContentSortSalesListBinding {
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
        sViewsWithIds.put(C2723R.C2726id.tv_item_low_to_high, 1);
        sViewsWithIds.put(C2723R.C2726id.view1, 2);
        sViewsWithIds.put(C2723R.C2726id.tv_item_high_to_low, 3);
        sViewsWithIds.put(C2723R.C2726id.view2, 4);
        sViewsWithIds.put(C2723R.C2726id.tv_a_to_z, 5);
        sViewsWithIds.put(C2723R.C2726id.view3, 6);
        sViewsWithIds.put(C2723R.C2726id.tv_z_to_a, 7);
        sViewsWithIds.put(C2723R.C2726id.view4, 8);
        sViewsWithIds.put(C2723R.C2726id.tv_make_a_to_z, 9);
        sViewsWithIds.put(C2723R.C2726id.view5, 10);
        sViewsWithIds.put(C2723R.C2726id.tv_make_z_to_a, 11);
        sViewsWithIds.put(C2723R.C2726id.view6, 12);
        sViewsWithIds.put(C2723R.C2726id.tv_odometer_low_to_high, 13);
        sViewsWithIds.put(C2723R.C2726id.view7, 14);
        sViewsWithIds.put(C2723R.C2726id.tv_odometer_high_to_low, 15);
        sViewsWithIds.put(C2723R.C2726id.view8, 16);
        sViewsWithIds.put(C2723R.C2726id.tv_year_low_to_high, 17);
        sViewsWithIds.put(C2723R.C2726id.view_lane, 18);
        sViewsWithIds.put(C2723R.C2726id.tv_year_high_to_low, 19);
        sViewsWithIds.put(C2723R.C2726id.view10, 20);
    }

    public ContentSortSalesListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 21, sIncludes, sViewsWithIds));
    }

    private ContentSortSalesListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[5], objArr[3], objArr[1], objArr[9], objArr[11], objArr[15], objArr[13], objArr[19], objArr[17], objArr[7], objArr[2], objArr[20], objArr[4], objArr[6], objArr[8], objArr[10], objArr[12], objArr[14], objArr[16], objArr[18]);
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
