package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public class FragmentFilterBindingImpl extends FragmentFilterBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    @NonNull
    private final LinearLayout mboundView2;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        sViewsWithIds.put(C2723R.C2726id.toolbar, 3);
        sViewsWithIds.put(C2723R.C2726id.img_back, 4);
        sViewsWithIds.put(C2723R.C2726id.toolbar_header, 5);
        sViewsWithIds.put(C2723R.C2726id.tvClearFilter, 6);
        sViewsWithIds.put(C2723R.C2726id.layout_border_line_clearfilter_top, 7);
        sViewsWithIds.put(C2723R.C2726id.expandableListView, 8);
        sViewsWithIds.put(C2723R.C2726id.ll_applyFilter_container, 9);
        sViewsWithIds.put(C2723R.C2726id.tv_applyfilter, 10);
        sViewsWithIds.put(C2723R.C2726id.pbLoadingFilterList, 11);
    }

    public FragmentFilterBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private FragmentFilterBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[0], objArr[8], objArr[4], objArr[7], objArr[9], objArr[1], objArr[11], objArr[3], objArr[5], objArr[10], objArr[6]);
        this.mDirtyFlags = -1;
        this.coordinatorLayoutParent.setTag((Object) null);
        this.main.setTag((Object) null);
        this.mboundView2 = objArr[2];
        this.mboundView2.setTag((Object) null);
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
