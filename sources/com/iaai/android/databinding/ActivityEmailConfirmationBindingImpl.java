package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public class ActivityEmailConfirmationBindingImpl extends ActivityEmailConfirmationBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    @NonNull
    private final CoordinatorLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        sViewsWithIds.put(C2723R.C2726id.card_view, 1);
        sViewsWithIds.put(C2723R.C2726id.llNewLogin, 2);
        sViewsWithIds.put(C2723R.C2726id.etLoginID, 3);
        sViewsWithIds.put(C2723R.C2726id.llConfirmLogin, 4);
        sViewsWithIds.put(C2723R.C2726id.etConfirmID, 5);
        sViewsWithIds.put(C2723R.C2726id.llContinue, 6);
        sViewsWithIds.put(C2723R.C2726id.tvContinue, 7);
        sViewsWithIds.put(C2723R.C2726id.tvUpdate, 8);
        sViewsWithIds.put(C2723R.C2726id.tvConfirmEmail, 9);
        sViewsWithIds.put(C2723R.C2726id.tvCurrentLoginID, 10);
        sViewsWithIds.put(C2723R.C2726id.tvLoginID, 11);
        sViewsWithIds.put(C2723R.C2726id.pbEmailConfirmation, 12);
        sViewsWithIds.put(C2723R.C2726id.toolbar, 13);
    }

    public ActivityEmailConfirmationBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    private ActivityEmailConfirmationBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1], objArr[5], objArr[3], objArr[4], objArr[6], objArr[2], objArr[12], objArr[13], objArr[9], objArr[7], objArr[10], objArr[11], objArr[8]);
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
