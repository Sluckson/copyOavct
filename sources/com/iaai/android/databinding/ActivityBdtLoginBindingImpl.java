package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public class ActivityBdtLoginBindingImpl extends ActivityBdtLoginBinding {
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
        sViewsWithIds.put(C2723R.C2726id.ivIAALogo, 1);
        sViewsWithIds.put(C2723R.C2726id.ivCloseLogin, 2);
        sViewsWithIds.put(C2723R.C2726id.tvLabelSignIn, 3);
        sViewsWithIds.put(C2723R.C2726id.tvRegisterNow, 4);
        sViewsWithIds.put(C2723R.C2726id.relativelayout, 5);
        sViewsWithIds.put(C2723R.C2726id.rlLoginContainer, 6);
        sViewsWithIds.put(C2723R.C2726id.ivClear, 7);
        sViewsWithIds.put(C2723R.C2726id.txt_input_layout_username, 8);
        sViewsWithIds.put(C2723R.C2726id.etUserName, 9);
        sViewsWithIds.put(C2723R.C2726id.txt_input_layout_password, 10);
        sViewsWithIds.put(C2723R.C2726id.etPassword, 11);
        sViewsWithIds.put(C2723R.C2726id.login_layout, 12);
        sViewsWithIds.put(C2723R.C2726id.tvLogin, 13);
        sViewsWithIds.put(C2723R.C2726id.tvForgotPassword, 14);
        sViewsWithIds.put(C2723R.C2726id.pbLogin, 15);
    }

    public ActivityBdtLoginBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    private ActivityBdtLoginBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[11], objArr[9], objArr[7], objArr[2], objArr[1], objArr[12], objArr[15], objArr[5], objArr[6], objArr[14], objArr[3], objArr[13], objArr[4], objArr[10], objArr[8]);
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
