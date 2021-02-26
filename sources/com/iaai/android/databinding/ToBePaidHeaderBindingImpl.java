package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public class ToBePaidHeaderBindingImpl extends ToBePaidHeaderBinding {
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

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        sViewsWithIds.put(C2723R.C2726id.tvStep1, 1);
        sViewsWithIds.put(C2723R.C2726id.ivAFCMsg, 2);
        sViewsWithIds.put(C2723R.C2726id.rlPaymentMethod, 3);
        sViewsWithIds.put(C2723R.C2726id.ivSelectPayment, 4);
        sViewsWithIds.put(C2723R.C2726id.tvPaymentMsg, 5);
        sViewsWithIds.put(C2723R.C2726id.tvSelectPayment, 6);
        sViewsWithIds.put(C2723R.C2726id.tvPaymentMethodTitle, 7);
        sViewsWithIds.put(C2723R.C2726id.tvChangePayment, 8);
        sViewsWithIds.put(C2723R.C2726id.tvPaymentMode, 9);
        sViewsWithIds.put(C2723R.C2726id.tvStep2, 10);
        sViewsWithIds.put(C2723R.C2726id.rlStep2, 11);
        sViewsWithIds.put(C2723R.C2726id.llSort, 12);
        sViewsWithIds.put(C2723R.C2726id.tvSort, 13);
        sViewsWithIds.put(C2723R.C2726id.tvSortValue, 14);
        sViewsWithIds.put(C2723R.C2726id.tvFilter, 15);
        sViewsWithIds.put(C2723R.C2726id.img_filter, 16);
        sViewsWithIds.put(C2723R.C2726id.viewSeparator1, 17);
        sViewsWithIds.put(C2723R.C2726id.tvCountAndDue, 18);
        sViewsWithIds.put(C2723R.C2726id.tvToBePaid, 19);
        sViewsWithIds.put(C2723R.C2726id.llSelectAll, 20);
        sViewsWithIds.put(C2723R.C2726id.tvSelectAll, 21);
        sViewsWithIds.put(C2723R.C2726id.tvSelectMsg, 22);
        sViewsWithIds.put(C2723R.C2726id.viewSeparator2, 23);
        sViewsWithIds.put(C2723R.C2726id.tvAFCMsg, 24);
    }

    public ToBePaidHeaderBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 25, sIncludes, sViewsWithIds));
    }

    private ToBePaidHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[16], objArr[2], objArr[4], objArr[20], objArr[12], objArr[3], objArr[11], objArr[24], objArr[8], objArr[18], objArr[15], objArr[7], objArr[9], objArr[5], objArr[21], objArr[22], objArr[6], objArr[13], objArr[14], objArr[1], objArr[10], objArr[19], objArr[17], objArr[23]);
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
