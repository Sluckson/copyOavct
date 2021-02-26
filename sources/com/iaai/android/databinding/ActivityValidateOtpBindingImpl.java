package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public class ActivityValidateOtpBindingImpl extends ActivityValidateOtpBinding {
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
        sViewsWithIds.put(C2723R.C2726id.llPIN, 2);
        sViewsWithIds.put(C2723R.C2726id.etPIN, 3);
        sViewsWithIds.put(C2723R.C2726id.llConfirmPIN, 4);
        sViewsWithIds.put(C2723R.C2726id.tvConfirmPIN, 5);
        sViewsWithIds.put(C2723R.C2726id.layout_edit_email, 6);
        sViewsWithIds.put(C2723R.C2726id.tvEmail, 7);
        sViewsWithIds.put(C2723R.C2726id.tvEditEmail, 8);
        sViewsWithIds.put(C2723R.C2726id.llResendPIN, 9);
        sViewsWithIds.put(C2723R.C2726id.tvResend, 10);
        sViewsWithIds.put(C2723R.C2726id.tvVerificationMsg, 11);
        sViewsWithIds.put(C2723R.C2726id.tvEnterPIN, 12);
        sViewsWithIds.put(C2723R.C2726id.pbConfirmPIN, 13);
        sViewsWithIds.put(C2723R.C2726id.toolbar, 14);
    }

    public ActivityValidateOtpBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 15, sIncludes, sViewsWithIds));
    }

    private ActivityValidateOtpBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1], objArr[3], objArr[6], objArr[4], objArr[2], objArr[9], objArr[13], objArr[14], objArr[5], objArr[8], objArr[7], objArr[12], objArr[10], objArr[11]);
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
