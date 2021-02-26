package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.productDetail.reports.PremiumVehicleReportModel;

public class ActivityPremiumVehicleReportLayoutBindingImpl extends ActivityPremiumVehicleReportLayoutBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    @NonNull
    private final FrameLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        sViewsWithIds.put(C2723R.C2726id.pvrToolbar, 1);
        sViewsWithIds.put(C2723R.C2726id.imgPremiumReport, 2);
        sViewsWithIds.put(C2723R.C2726id.tvPRToolbarHeader, 3);
        sViewsWithIds.put(C2723R.C2726id.wvPVR, 4);
        sViewsWithIds.put(C2723R.C2726id.pvr_pbLoading, 5);
    }

    public ActivityPremiumVehicleReportLayoutBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ActivityPremiumVehicleReportLayoutBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[2], objArr[5], objArr[1], objArr[3], objArr[4]);
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
        if (1 != i) {
            return false;
        }
        setReports((PremiumVehicleReportModel) obj);
        return true;
    }

    public void setReports(@Nullable PremiumVehicleReportModel premiumVehicleReportModel) {
        this.mReports = premiumVehicleReportModel;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
    }
}
