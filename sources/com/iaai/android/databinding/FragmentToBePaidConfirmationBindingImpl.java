package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public class FragmentToBePaidConfirmationBindingImpl extends FragmentToBePaidConfirmationBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    @NonNull
    private final ConstraintLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        sViewsWithIds.put(C2723R.C2726id.btnMakeAnotherPayment, 1);
        sViewsWithIds.put(C2723R.C2726id.svContainer, 2);
        sViewsWithIds.put(C2723R.C2726id.rlHeader, 3);
        sViewsWithIds.put(C2723R.C2726id.viewSeparator1, 4);
        sViewsWithIds.put(C2723R.C2726id.ivCheck, 5);
        sViewsWithIds.put(C2723R.C2726id.tvThankYou, 6);
        sViewsWithIds.put(C2723R.C2726id.tvPartialInfo, 7);
        sViewsWithIds.put(C2723R.C2726id.llPartiallyPaid, 8);
        sViewsWithIds.put(C2723R.C2726id.tvErrorMessage, 9);
        sViewsWithIds.put(C2723R.C2726id.rvFailureVehicle, 10);
        sViewsWithIds.put(C2723R.C2726id.tvViewAllFailure, 11);
        sViewsWithIds.put(C2723R.C2726id.llPaymentInfo, 12);
        sViewsWithIds.put(C2723R.C2726id.tvItemPaid, 13);
        sViewsWithIds.put(C2723R.C2726id.tvItemToPaid, 14);
        sViewsWithIds.put(C2723R.C2726id.tvTotalAmount, 15);
        sViewsWithIds.put(C2723R.C2726id.rvConfirmVehicle, 16);
        sViewsWithIds.put(C2723R.C2726id.tvViewAll, 17);
        sViewsWithIds.put(C2723R.C2726id.tvPaymentMethod, 18);
        sViewsWithIds.put(C2723R.C2726id.tvTransportText, 19);
    }

    public FragmentToBePaidConfirmationBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 20, sIncludes, sViewsWithIds));
    }

    private FragmentToBePaidConfirmationBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1], objArr[5], objArr[8], objArr[12], objArr[3], objArr[16], objArr[10], objArr[2], objArr[9], objArr[13], objArr[14], objArr[7], objArr[18], objArr[6], objArr[15], objArr[19], objArr[17], objArr[11], objArr[4]);
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
