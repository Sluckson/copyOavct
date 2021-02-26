package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public class FragmentChromeSectionBindingImpl extends FragmentChromeSectionBinding {
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
        sViewsWithIds.put(C2723R.C2726id.llFactOptionsData, 3);
        sViewsWithIds.put(C2723R.C2726id.tvFactSectionHeader, 4);
        sViewsWithIds.put(C2723R.C2726id.rvFactEquipment, 5);
        sViewsWithIds.put(C2723R.C2726id.llGenEquipmentData, 6);
        sViewsWithIds.put(C2723R.C2726id.tvGenSectionHeader, 7);
        sViewsWithIds.put(C2723R.C2726id.rvGenEquipment, 8);
        sViewsWithIds.put(C2723R.C2726id.llStanEquipmentData, 9);
        sViewsWithIds.put(C2723R.C2726id.tvStanSectionHeader, 10);
        sViewsWithIds.put(C2723R.C2726id.rvStanEquipment, 11);
        sViewsWithIds.put(C2723R.C2726id.llTechSpecsData, 12);
        sViewsWithIds.put(C2723R.C2726id.tvTechSectionHeader, 13);
        sViewsWithIds.put(C2723R.C2726id.rvTechEquipment, 14);
        sViewsWithIds.put(C2723R.C2726id.pbChromeLoading, 15);
    }

    public FragmentChromeSectionBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    private FragmentChromeSectionBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[3], objArr[6], objArr[9], objArr[12], objArr[15], objArr[5], objArr[8], objArr[11], objArr[14], objArr[1], objArr[4], objArr[7], objArr[10], objArr[13], objArr[2]);
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
