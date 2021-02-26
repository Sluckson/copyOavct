package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public class ItemBdtPaymentMethodsLayoutBindingImpl extends ItemBdtPaymentMethodsLayoutBinding {
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
        sViewsWithIds.put(C2723R.C2726id.tvPaymentName, 1);
        sViewsWithIds.put(C2723R.C2726id.tvDailyAllowanceLimit, 2);
        sViewsWithIds.put(C2723R.C2726id.tvPayPalFee, 3);
        sViewsWithIds.put(C2723R.C2726id.tvLinkPayPalAccountInfo, 4);
        sViewsWithIds.put(C2723R.C2726id.rbAccountInfo, 5);
        sViewsWithIds.put(C2723R.C2726id.ivAFCInfo1, 6);
        sViewsWithIds.put(C2723R.C2726id.rlAFCInfoLayout, 7);
        sViewsWithIds.put(C2723R.C2726id.rbAFCInfo, 8);
        sViewsWithIds.put(C2723R.C2726id.ivAFCInfo2, 9);
        sViewsWithIds.put(C2723R.C2726id.cbSetAsDefault, 10);
        sViewsWithIds.put(C2723R.C2726id.tvLinkPaymentMethod, 11);
        sViewsWithIds.put(C2723R.C2726id.tvErrorMessage, 12);
    }

    public ItemBdtPaymentMethodsLayoutBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private ItemBdtPaymentMethodsLayoutBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[10], objArr[6], objArr[9], objArr[8], objArr[5], objArr[7], objArr[2], objArr[12], objArr[4], objArr[11], objArr[3], objArr[1]);
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
