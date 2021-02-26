package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public class ActivityAuctionMainBindingImpl extends ActivityAuctionMainBinding {
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
        sViewsWithIds.put(C2723R.C2726id.auction_toolbar, 2);
        sViewsWithIds.put(C2723R.C2726id.nav_view, 3);
    }

    public ActivityAuctionMainBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private ActivityAuctionMainBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[2], objArr[1], objArr[0], objArr[3]);
        this.mDirtyFlags = -1;
        this.frameLayout.setTag((Object) null);
        this.navDrawer.setTag((Object) null);
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
