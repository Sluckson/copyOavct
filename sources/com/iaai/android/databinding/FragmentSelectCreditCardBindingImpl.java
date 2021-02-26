package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public class FragmentSelectCreditCardBindingImpl extends FragmentSelectCreditCardBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    @NonNull
    private final LinearLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        sViewsWithIds.put(C2723R.C2726id.selectCCToolBar, 1);
        sViewsWithIds.put(C2723R.C2726id.rlDailyAllowable, 2);
        sViewsWithIds.put(C2723R.C2726id.tvDailyAllowable, 3);
        sViewsWithIds.put(C2723R.C2726id.tvDailyAllowableValue, 4);
        sViewsWithIds.put(C2723R.C2726id.rlAllowanceUsed, 5);
        sViewsWithIds.put(C2723R.C2726id.tvAllowanceUsed, 6);
        sViewsWithIds.put(C2723R.C2726id.tvAllowanceUsedValue, 7);
        sViewsWithIds.put(C2723R.C2726id.rlRemainingAllowance, 8);
        sViewsWithIds.put(C2723R.C2726id.tvRemainingAllowance, 9);
        sViewsWithIds.put(C2723R.C2726id.tvRemainingAllowanceValue, 10);
        sViewsWithIds.put(C2723R.C2726id.view1, 11);
        sViewsWithIds.put(C2723R.C2726id.view2, 12);
        sViewsWithIds.put(C2723R.C2726id.view3, 13);
        sViewsWithIds.put(C2723R.C2726id.view4, 14);
        sViewsWithIds.put(C2723R.C2726id.tvCashDiscount, 15);
        sViewsWithIds.put(C2723R.C2726id.tvCreditCardOptions, 16);
        sViewsWithIds.put(C2723R.C2726id.view5, 17);
        sViewsWithIds.put(C2723R.C2726id.rvCreditCard, 18);
        sViewsWithIds.put(C2723R.C2726id.btnSelectCard, 19);
    }

    public FragmentSelectCreditCardBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 20, sIncludes, sViewsWithIds));
    }

    private FragmentSelectCreditCardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[19], objArr[5], objArr[2], objArr[8], objArr[18], objArr[1], objArr[6], objArr[7], objArr[15], objArr[16], objArr[3], objArr[4], objArr[9], objArr[10], objArr[11], objArr[12], objArr[13], objArr[14], objArr[17]);
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
