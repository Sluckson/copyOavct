package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListViewModel;
import com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList;

public class ItemHeaderManageOfferListBindingImpl extends ItemHeaderManageOfferListBinding {
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

    static {
        sViewsWithIds.put(C2723R.C2726id.tvManageOfferVehicleCount, 1);
        sViewsWithIds.put(C2723R.C2726id.vehicleCountSeparator, 2);
        sViewsWithIds.put(C2723R.C2726id.layout_sort_container, 3);
        sViewsWithIds.put(C2723R.C2726id.iv_sort, 4);
        sViewsWithIds.put(C2723R.C2726id.tv_SortLabel, 5);
        sViewsWithIds.put(C2723R.C2726id.llFilter, 6);
        sViewsWithIds.put(C2723R.C2726id.img_filter, 7);
        sViewsWithIds.put(C2723R.C2726id.tvFilter, 8);
        sViewsWithIds.put(C2723R.C2726id.view13, 9);
    }

    public ItemHeaderManageOfferListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ItemHeaderManageOfferListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[7], objArr[4], objArr[3], objArr[6], objArr[8], objArr[1], objArr[5], objArr[2], objArr[9]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
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
        if (6 == i) {
            setViewModel((ManageOfferListViewModel) obj);
        } else if (7 != i) {
            return false;
        } else {
            setMobileNegotiation((MobileNegotiationsList) obj);
        }
        return true;
    }

    public void setViewModel(@Nullable ManageOfferListViewModel manageOfferListViewModel) {
        this.mViewModel = manageOfferListViewModel;
    }

    public void setMobileNegotiation(@Nullable MobileNegotiationsList mobileNegotiationsList) {
        this.mMobileNegotiation = mobileNegotiationsList;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
    }
}
