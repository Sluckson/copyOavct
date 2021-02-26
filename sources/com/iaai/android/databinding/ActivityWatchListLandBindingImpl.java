package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public class ActivityWatchListLandBindingImpl extends ActivityWatchListLandBinding {
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

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        sViewsWithIds.put(C2723R.C2726id.vw_separtor_toolbar, 1);
        sViewsWithIds.put(C2723R.C2726id.rl_stock_vin_search, 2);
        sViewsWithIds.put(C2723R.C2726id.etVinSearch, 3);
        sViewsWithIds.put(C2723R.C2726id.ivSearchClear, 4);
        sViewsWithIds.put(C2723R.C2726id.vw_separtor, 5);
        sViewsWithIds.put(C2723R.C2726id.main, 6);
        sViewsWithIds.put(C2723R.C2726id.rvWatchList, 7);
        sViewsWithIds.put(C2723R.C2726id.pbLoadingAuctionSaleList, 8);
        sViewsWithIds.put(C2723R.C2726id.fab, 9);
        sViewsWithIds.put(C2723R.C2726id.tvEmptyMessage, 10);
    }

    public ActivityWatchListLandBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ActivityWatchListLandBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[3], objArr[9], objArr[4], objArr[6], objArr[8], objArr[2], objArr[7], objArr[10], objArr[5], objArr[1]);
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
