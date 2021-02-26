package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.fastSearchFilter2.FormattedResult;

public class RowItemFastSearchRefinerHeaderBindingImpl extends RowItemFastSearchRefinerHeaderBinding {
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

    static {
        sViewsWithIds.put(C2723R.C2726id.empty_view, 2);
        sViewsWithIds.put(C2723R.C2726id.layout_sort_container, 3);
        sViewsWithIds.put(C2723R.C2726id.iv_sort, 4);
        sViewsWithIds.put(C2723R.C2726id.tv_SortLabel, 5);
        sViewsWithIds.put(C2723R.C2726id.img_filter, 6);
        sViewsWithIds.put(C2723R.C2726id.tv_filter_label, 7);
        sViewsWithIds.put(C2723R.C2726id.tv_filterCount, 8);
        sViewsWithIds.put(C2723R.C2726id.rlSearchSelectedRefiner, 9);
        sViewsWithIds.put(C2723R.C2726id.rvSearchSelectedRefiner, 10);
    }

    public RowItemFastSearchRefinerHeaderBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private RowItemFastSearchRefinerHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1], objArr[2], objArr[6], objArr[4], objArr[3], objArr[9], objArr[10], objArr[8], objArr[7], objArr[5]);
        this.mDirtyFlags = -1;
        this.clEmptyView.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
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

    public boolean setVariable(int i, @Nullable Object obj) {
        if (3 != i) {
            return false;
        }
        setFormattedResult((FormattedResult) obj);
        return true;
    }

    public void setFormattedResult(@Nullable FormattedResult formattedResult) {
        this.mFormattedResult = formattedResult;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
    }
}
