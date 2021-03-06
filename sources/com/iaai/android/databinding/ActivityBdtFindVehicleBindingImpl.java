package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public class ActivityBdtFindVehicleBindingImpl extends ActivityBdtFindVehicleBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    @NonNull
    private final LinearLayout mboundView1;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        sViewsWithIds.put(C2723R.C2726id.llDashBoardLayout, 2);
        sViewsWithIds.put(C2723R.C2726id.frameLayout, 3);
        sViewsWithIds.put(C2723R.C2726id.auction_toolbar, 4);
        sViewsWithIds.put(C2723R.C2726id.layout_border_line_date, 5);
        sViewsWithIds.put(C2723R.C2726id.llAnnouncement, 6);
        sViewsWithIds.put(C2723R.C2726id.tvAnnouncementMessage, 7);
        sViewsWithIds.put(C2723R.C2726id.vwAnnouncementBorder, 8);
        sViewsWithIds.put(C2723R.C2726id.vwSignInBorder, 9);
        sViewsWithIds.put(C2723R.C2726id.cl_flagConatiner, 10);
        sViewsWithIds.put(C2723R.C2726id.img_flag, 11);
        sViewsWithIds.put(C2723R.C2726id.tv_flaglabel, 12);
        sViewsWithIds.put(C2723R.C2726id.tv_gethelp, 13);
        sViewsWithIds.put(C2723R.C2726id.frSignInCreateAccount, 14);
        sViewsWithIds.put(C2723R.C2726id.btnCreateOrSignIn, 15);
        sViewsWithIds.put(C2723R.C2726id.fragment_content, 16);
        sViewsWithIds.put(C2723R.C2726id.llAds, 17);
        sViewsWithIds.put(C2723R.C2726id.webViewAds, 18);
        sViewsWithIds.put(C2723R.C2726id.ivIaaAds, 19);
        sViewsWithIds.put(C2723R.C2726id.llRecommendedVehicleLayout, 20);
        sViewsWithIds.put(C2723R.C2726id.nav_view, 21);
    }

    public ActivityBdtFindVehicleBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 22, sIncludes, sViewsWithIds));
    }

    private ActivityBdtFindVehicleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[4], objArr[15], objArr[10], objArr[14], objArr[16], objArr[3], objArr[11], objArr[19], objArr[5], objArr[17], objArr[6], objArr[2], objArr[20], objArr[0], objArr[21], objArr[7], objArr[12], objArr[13], objArr[8], objArr[9], objArr[18]);
        this.mDirtyFlags = -1;
        this.mboundView1 = objArr[1];
        this.mboundView1.setTag((Object) null);
        this.navDrawer.setTag((Object) null);
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
