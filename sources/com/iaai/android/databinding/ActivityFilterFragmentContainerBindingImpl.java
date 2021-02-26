package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public class ActivityFilterFragmentContainerBindingImpl extends ActivityFilterFragmentContainerBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        sViewsWithIds.put(C2723R.C2726id.frameLayout, 1);
        sViewsWithIds.put(C2723R.C2726id.auction_toolbar, 2);
        sViewsWithIds.put(C2723R.C2726id.tvScanLabel, 3);
        sViewsWithIds.put(C2723R.C2726id.tvTitleFilter, 4);
        sViewsWithIds.put(C2723R.C2726id.imgScan, 5);
        sViewsWithIds.put(C2723R.C2726id.frFragmentcontent, 6);
        sViewsWithIds.put(C2723R.C2726id.nav_view, 7);
    }

    public ActivityFilterFragmentContainerBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ActivityFilterFragmentContainerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[2], objArr[6], objArr[1], objArr[5], objArr[0], objArr[7], objArr[3], objArr[4]);
        this.mDirtyFlags = -1;
        this.navDrawer.setTag((Object) null);
        View view2 = view;
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
