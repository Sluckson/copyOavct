package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public class ActivitySaleDocListBindingImpl extends ActivitySaleDocListBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    @NonNull
    private final LinearLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        sViewsWithIds.put(C2723R.C2726id.app_bar, 1);
        sViewsWithIds.put(C2723R.C2726id.toolbar, 2);
        sViewsWithIds.put(C2723R.C2726id.toolbar_relativelayout, 3);
        sViewsWithIds.put(C2723R.C2726id.arrow_right, 4);
        sViewsWithIds.put(C2723R.C2726id.toolbar_title, 5);
        sViewsWithIds.put(C2723R.C2726id.toolbar_sub_title, 6);
        sViewsWithIds.put(C2723R.C2726id.arrow_left, 7);
        sViewsWithIds.put(C2723R.C2726id.btnReviewPayment, 8);
        sViewsWithIds.put(C2723R.C2726id.llNotSet, 9);
        sViewsWithIds.put(C2723R.C2726id.rvNotSetInstructions, 10);
        sViewsWithIds.put(C2723R.C2726id.llSet, 11);
        sViewsWithIds.put(C2723R.C2726id.separatorSet, 12);
        sViewsWithIds.put(C2723R.C2726id.rvSetInstructions, 13);
        sViewsWithIds.put(C2723R.C2726id.viewSeparator1, 14);
        sViewsWithIds.put(C2723R.C2726id.pbReviewPayment, 15);
    }

    public ActivitySaleDocListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    private ActivitySaleDocListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1], objArr[7], objArr[4], objArr[8], objArr[9], objArr[11], objArr[15], objArr[10], objArr[13], objArr[12], objArr[2], objArr[3], objArr[6], objArr[5], objArr[14]);
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
