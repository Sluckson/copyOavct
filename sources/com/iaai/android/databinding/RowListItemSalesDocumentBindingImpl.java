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

public class RowListItemSalesDocumentBindingImpl extends RowListItemSalesDocumentBinding {
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
        sViewsWithIds.put(C2723R.C2726id.tvStockNumber, 5);
        sViewsWithIds.put(C2723R.C2726id.tvVinNumber, 6);
        sViewsWithIds.put(C2723R.C2726id.tvBranchName, 7);
        sViewsWithIds.put(C2723R.C2726id.tvOwnerName, 8);
        sViewsWithIds.put(C2723R.C2726id.tvFedEx, 9);
        sViewsWithIds.put(C2723R.C2726id.tvTitleStatus, 10);
        sViewsWithIds.put(C2723R.C2726id.llReviewFees, 11);
        sViewsWithIds.put(C2723R.C2726id.tvReviewFees, 12);
        sViewsWithIds.put(C2723R.C2726id.ivTotalDueArrow, 13);
        sViewsWithIds.put(C2723R.C2726id.ivArrowRight, 14);
        sViewsWithIds.put(C2723R.C2726id.ClReviewDetailsContainer, 15);
        sViewsWithIds.put(C2723R.C2726id.tvNotesFromBranch, 16);
        sViewsWithIds.put(C2723R.C2726id.llTrackingId, 17);
        sViewsWithIds.put(C2723R.C2726id.tvTitleFedex, 18);
        sViewsWithIds.put(C2723R.C2726id.tvTrackingId, 19);
        sViewsWithIds.put(C2723R.C2726id.tvNotesFromBranchValue, 20);
        sViewsWithIds.put(C2723R.C2726id.tvNotesForBranch, 21);
        sViewsWithIds.put(C2723R.C2726id.tvNotesForBranchValue, 22);
        sViewsWithIds.put(C2723R.C2726id.viewSeparator2, 23);
    }

    public RowListItemSalesDocumentBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 24, sIncludes, sViewsWithIds));
    }

    private RowListItemSalesDocumentBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[15], objArr[1], objArr[14], objArr[13], objArr[11], objArr[17], objArr[3], objArr[7], objArr[9], objArr[21], objArr[22], objArr[16], objArr[20], objArr[8], objArr[12], objArr[5], objArr[18], objArr[10], objArr[19], objArr[6], objArr[2], objArr[4], objArr[23]);
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
