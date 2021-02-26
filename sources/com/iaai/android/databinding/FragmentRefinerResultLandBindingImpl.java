package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public class FragmentRefinerResultLandBindingImpl extends FragmentRefinerResultLandBinding {
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
        sViewsWithIds.put(C2723R.C2726id.vwSeparatorToolbar, 1);
        sViewsWithIds.put(C2723R.C2726id.cl_search_container, 2);
        sViewsWithIds.put(C2723R.C2726id.llMicClr, 3);
        sViewsWithIds.put(C2723R.C2726id.img_clear_text, 4);
        sViewsWithIds.put(C2723R.C2726id.img_voice_text, 5);
        sViewsWithIds.put(C2723R.C2726id.ed_search_result, 6);
        sViewsWithIds.put(C2723R.C2726id.flContainer, 7);
        sViewsWithIds.put(C2723R.C2726id.rvResultList, 8);
        sViewsWithIds.put(C2723R.C2726id.pbRefinerResult, 9);
        sViewsWithIds.put(C2723R.C2726id.fab, 10);
        sViewsWithIds.put(C2723R.C2726id.tvEmptyMessage, 11);
    }

    public FragmentRefinerResultLandBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private FragmentRefinerResultLandBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[2], objArr[6], objArr[10], objArr[7], objArr[4], objArr[5], objArr[3], objArr[9], objArr[8], objArr[11], objArr[1]);
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
