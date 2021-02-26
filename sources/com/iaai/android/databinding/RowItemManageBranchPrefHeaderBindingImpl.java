package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public class RowItemManageBranchPrefHeaderBindingImpl extends RowItemManageBranchPrefHeaderBinding {
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
        sViewsWithIds.put(C2723R.C2726id.empty_view, 2);
        sViewsWithIds.put(C2723R.C2726id.search_section, 3);
        sViewsWithIds.put(C2723R.C2726id.lbl_select_branch, 4);
        sViewsWithIds.put(C2723R.C2726id.rl_branch_search, 5);
        sViewsWithIds.put(C2723R.C2726id.etBranchSearch, 6);
        sViewsWithIds.put(C2723R.C2726id.ivBranchClear, 7);
        sViewsWithIds.put(C2723R.C2726id.viewHeader, 8);
    }

    public RowItemManageBranchPrefHeaderBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private RowItemManageBranchPrefHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1], objArr[2], objArr[6], objArr[7], objArr[4], objArr[5], objArr[3], objArr[8]);
        this.mDirtyFlags = -1;
        this.clEmptyView.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
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
