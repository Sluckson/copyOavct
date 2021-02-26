package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue;

public class RowListItemSelectVehiclesBindingImpl extends RowListItemSelectVehiclesBinding {
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

    static {
        sViewsWithIds.put(C2723R.C2726id.clToBePaidContainer, 1);
        sViewsWithIds.put(C2723R.C2726id.vehicleImage, 2);
        sViewsWithIds.put(C2723R.C2726id.rowItemRadioBtn, 3);
        sViewsWithIds.put(C2723R.C2726id.vehicleTitle, 4);
        sViewsWithIds.put(C2723R.C2726id.tvCCStockNo, 5);
        sViewsWithIds.put(C2723R.C2726id.tvTotalDue, 6);
        sViewsWithIds.put(C2723R.C2726id.tvPartialPaid, 7);
        sViewsWithIds.put(C2723R.C2726id.tvStockLabel, 8);
        sViewsWithIds.put(C2723R.C2726id.tvStockNumber, 9);
        sViewsWithIds.put(C2723R.C2726id.tvBranchInfo, 10);
        sViewsWithIds.put(C2723R.C2726id.tvUsername, 11);
        sViewsWithIds.put(C2723R.C2726id.tvBidWonMethod, 12);
        sViewsWithIds.put(C2723R.C2726id.tvReviewFees, 13);
        sViewsWithIds.put(C2723R.C2726id.ivTotalDueArrow, 14);
        sViewsWithIds.put(C2723R.C2726id.ivArrowRight, 15);
        sViewsWithIds.put(C2723R.C2726id.tvDueDate, 16);
        sViewsWithIds.put(C2723R.C2726id.llFeeCreditCardLayout, 17);
        sViewsWithIds.put(C2723R.C2726id.viewSeparator2, 18);
    }

    public RowListItemSelectVehiclesBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 19, sIncludes, sViewsWithIds));
    }

    private RowListItemSelectVehiclesBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1], objArr[15], objArr[14], objArr[17], objArr[3], objArr[12], objArr[10], objArr[5], objArr[16], objArr[7], objArr[13], objArr[8], objArr[9], objArr[6], objArr[11], objArr[2], objArr[4], objArr[18]);
        this.mDirtyFlags = -1;
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
        if (9 != i) {
            return false;
        }
        setPaymentDue((PaymentDue) obj);
        return true;
    }

    public void setPaymentDue(@Nullable PaymentDue paymentDue) {
        this.mPaymentDue = paymentDue;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
    }
}
