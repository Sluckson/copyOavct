package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.account.MyAccountViewModel;

public class ActivityBdtMyAccountLayoutBindingImpl extends ActivityBdtMyAccountLayoutBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = new ViewDataBinding.IncludedLayouts(5);
    @Nullable
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    @NonNull
    private final LinearLayout mboundView1;
    @Nullable
    private final AcivityBdtMyAccountBinding mboundView11;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        sIncludes.setIncludes(1, new String[]{"acivity_bdt_my_account"}, new int[]{2}, new int[]{C2723R.C2728layout.acivity_bdt_my_account});
        sViewsWithIds.put(C2723R.C2726id.auction_toolbar, 3);
        sViewsWithIds.put(C2723R.C2726id.nav_view, 4);
    }

    public ActivityBdtMyAccountLayoutBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ActivityBdtMyAccountLayoutBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[3], objArr[0], objArr[4]);
        this.mDirtyFlags = -1;
        this.mboundView1 = objArr[1];
        this.mboundView1.setTag((Object) null);
        this.mboundView11 = objArr[2];
        setContainedBinding(this.mboundView11);
        this.navDrawer.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
        }
        this.mboundView11.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.mboundView11.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.mDirtyFlags     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            com.iaai.android.databinding.AcivityBdtMyAccountBinding r0 = r6.mboundView11
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.databinding.ActivityBdtMyAccountLayoutBindingImpl.hasPendingBindings():boolean");
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        if (6 != i) {
            return false;
        }
        setViewModel((MyAccountViewModel) obj);
        return true;
    }

    public void setViewModel(@Nullable MyAccountViewModel myAccountViewModel) {
        this.mViewModel = myAccountViewModel;
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mboundView11.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        executeBindingsOn(this.mboundView11);
    }
}
