package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public class OldActivityBdtLoginBindingImpl extends OldActivityBdtLoginBinding {
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
        sViewsWithIds.put(C2723R.C2726id.relativelayout, 2);
        sViewsWithIds.put(C2723R.C2726id.ivClear, 3);
        sViewsWithIds.put(C2723R.C2726id.login_layout, 4);
        sViewsWithIds.put(C2723R.C2726id.tvLogin, 5);
        sViewsWithIds.put(C2723R.C2726id.tvForgotPassword, 6);
        sViewsWithIds.put(C2723R.C2726id.txt_input_layout_username, 7);
        sViewsWithIds.put(C2723R.C2726id.etUserName, 8);
        sViewsWithIds.put(C2723R.C2726id.txt_input_layout_password, 9);
        sViewsWithIds.put(C2723R.C2726id.etPassword, 10);
        sViewsWithIds.put(C2723R.C2726id.linearLayout, 11);
        sViewsWithIds.put(C2723R.C2726id.tvTerms, 12);
        sViewsWithIds.put(C2723R.C2726id.card_view1, 13);
        sViewsWithIds.put(C2723R.C2726id.register_now_layout, 14);
        sViewsWithIds.put(C2723R.C2726id.tvRegisterNow, 15);
        sViewsWithIds.put(C2723R.C2726id.contact_us_layout, 16);
        sViewsWithIds.put(C2723R.C2726id.tvContactUs, 17);
        sViewsWithIds.put(C2723R.C2726id.pbLogin, 18);
        sViewsWithIds.put(C2723R.C2726id.toolbar, 19);
    }

    public OldActivityBdtLoginBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 20, sIncludes, sViewsWithIds));
    }

    private OldActivityBdtLoginBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1], objArr[13], objArr[16], objArr[10], objArr[8], objArr[3], objArr[11], objArr[4], objArr[18], objArr[14], objArr[2], objArr[19], objArr[17], objArr[6], objArr[5], objArr[15], objArr[12], objArr[9], objArr[7]);
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
