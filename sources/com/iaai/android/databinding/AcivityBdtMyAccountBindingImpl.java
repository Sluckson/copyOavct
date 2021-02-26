package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public class AcivityBdtMyAccountBindingImpl extends AcivityBdtMyAccountBinding {
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

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        sViewsWithIds.put(C2723R.C2726id.swipe_container, 1);
        sViewsWithIds.put(C2723R.C2726id.frameLayout, 2);
        sViewsWithIds.put(C2723R.C2726id.layout_border_line_date, 3);
        sViewsWithIds.put(C2723R.C2726id.user_picture, 4);
        sViewsWithIds.put(C2723R.C2726id.relative_layout_user, 5);
        sViewsWithIds.put(C2723R.C2726id.tv_user_name, 6);
        sViewsWithIds.put(C2723R.C2726id.ll_buyer_id_info, 7);
        sViewsWithIds.put(C2723R.C2726id.lbl_buyer_id, 8);
        sViewsWithIds.put(C2723R.C2726id.tv_buyer_id_info, 9);
        sViewsWithIds.put(C2723R.C2726id.tv_logout, 10);
        sViewsWithIds.put(C2723R.C2726id.tl_my_account, 11);
        sViewsWithIds.put(C2723R.C2726id.viewPager2, 12);
        sViewsWithIds.put(C2723R.C2726id.pb_my_account, 13);
    }

    public AcivityBdtMyAccountBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 14, sIncludes, sViewsWithIds));
    }

    private AcivityBdtMyAccountBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[2], objArr[3], objArr[8], objArr[7], objArr[13], objArr[5], objArr[1], objArr[11], objArr[9], objArr[10], objArr[6], objArr[4], objArr[12]);
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
