package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public class AcivityAccountSettingListBindingImpl extends AcivityAccountSettingListBinding {
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
        sViewsWithIds.put(C2723R.C2726id.svDataContainer, 1);
        sViewsWithIds.put(C2723R.C2726id.frameLayout, 2);
        sViewsWithIds.put(C2723R.C2726id.rl_profile, 3);
        sViewsWithIds.put(C2723R.C2726id.profile, 4);
        sViewsWithIds.put(C2723R.C2726id.profile_view, 5);
        sViewsWithIds.put(C2723R.C2726id.rl_additional_bidder, 6);
        sViewsWithIds.put(C2723R.C2726id.iv_additional_bidder, 7);
        sViewsWithIds.put(C2723R.C2726id.additional_bidder, 8);
        sViewsWithIds.put(C2723R.C2726id.rl_license_document, 9);
        sViewsWithIds.put(C2723R.C2726id.iv_license_doc, 10);
        sViewsWithIds.put(C2723R.C2726id.my_subscriptions_view, 11);
        sViewsWithIds.put(C2723R.C2726id.rl_my_subscriptions, 12);
        sViewsWithIds.put(C2723R.C2726id.iv_my_subscriptions, 13);
        sViewsWithIds.put(C2723R.C2726id.license_and_document_view, 14);
        sViewsWithIds.put(C2723R.C2726id.rl_upgrade_account, 15);
        sViewsWithIds.put(C2723R.C2726id.iv_upgrade_account, 16);
        sViewsWithIds.put(C2723R.C2726id.upgrade_account_view, 17);
        sViewsWithIds.put(C2723R.C2726id.rl_renewal, 18);
        sViewsWithIds.put(C2723R.C2726id.iv_renewal, 19);
        sViewsWithIds.put(C2723R.C2726id.renewal_view, 20);
        sViewsWithIds.put(C2723R.C2726id.rl_setting, 21);
        sViewsWithIds.put(C2723R.C2726id.iv_settting, 22);
        sViewsWithIds.put(C2723R.C2726id.rl_help, 23);
        sViewsWithIds.put(C2723R.C2726id.iv_help, 24);
        sViewsWithIds.put(C2723R.C2726id.viewHelpLineSeparator, 25);
        sViewsWithIds.put(C2723R.C2726id.rl_contact_us, 26);
        sViewsWithIds.put(C2723R.C2726id.iv_contact, 27);
        sViewsWithIds.put(C2723R.C2726id.rl_feedback, 28);
        sViewsWithIds.put(C2723R.C2726id.tv_lable, 29);
    }

    public AcivityAccountSettingListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 30, sIncludes, sViewsWithIds));
    }

    private AcivityAccountSettingListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[8], objArr[2], objArr[7], objArr[27], objArr[24], objArr[10], objArr[13], objArr[19], objArr[22], objArr[16], objArr[14], objArr[11], objArr[4], objArr[5], objArr[20], objArr[6], objArr[26], objArr[28], objArr[23], objArr[9], objArr[12], objArr[3], objArr[18], objArr[21], objArr[15], objArr[1], objArr[29], objArr[17], objArr[25]);
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
