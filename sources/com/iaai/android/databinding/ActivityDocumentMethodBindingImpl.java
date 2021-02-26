package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public class ActivityDocumentMethodBindingImpl extends ActivityDocumentMethodBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    @NonNull
    private final LinearLayout mboundView0;
    @NonNull
    private final LinearLayout mboundView1;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        sViewsWithIds.put(C2723R.C2726id.optionsLayout, 2);
        sViewsWithIds.put(C2723R.C2726id.app_bar, 3);
        sViewsWithIds.put(C2723R.C2726id.toolbar, 4);
        sViewsWithIds.put(C2723R.C2726id.prebid_title_layout, 5);
        sViewsWithIds.put(C2723R.C2726id.ivClose, 6);
        sViewsWithIds.put(C2723R.C2726id.tvTitle, 7);
        sViewsWithIds.put(C2723R.C2726id.btnApply, 8);
        sViewsWithIds.put(C2723R.C2726id.llBranchList, 9);
        sViewsWithIds.put(C2723R.C2726id.ivToolTip, 10);
        sViewsWithIds.put(C2723R.C2726id.rvBranchList, 11);
        sViewsWithIds.put(C2723R.C2726id.viewSeparator, 12);
        sViewsWithIds.put(C2723R.C2726id.viewSeparator1, 13);
        sViewsWithIds.put(C2723R.C2726id.pbGetDelivery, 14);
    }

    public ActivityDocumentMethodBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private ActivityDocumentMethodBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[3], objArr[8], objArr[6], objArr[10], objArr[9], objArr[2], objArr[14], objArr[5], objArr[11], objArr[4], objArr[7], objArr[12], objArr[13]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView1 = objArr[1];
        this.mboundView1.setTag((Object) null);
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
