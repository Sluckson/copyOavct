package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.iaai.android.C2723R;

public class FragmentBdtFindVehicleLayoutBindingImpl extends FragmentBdtFindVehicleLayoutBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = new ViewDataBinding.IncludedLayouts(3);
    @Nullable
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    @Nullable
    private final FragmentFindVehicleSearchLayoutBinding mboundView0;
    @NonNull
    private final FrameLayout mboundView01;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        sIncludes.setIncludes(0, new String[]{"fragment_find_vehicle_search_layout"}, new int[]{1}, new int[]{C2723R.C2728layout.fragment_find_vehicle_search_layout});
        sViewsWithIds.put(C2723R.C2726id.pbFilter, 2);
    }

    public FragmentBdtFindVehicleLayoutBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private FragmentBdtFindVehicleLayoutBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[2]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[1];
        setContainedBinding(this.mboundView0);
        this.mboundView01 = objArr[0];
        this.mboundView01.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1;
        }
        this.mboundView0.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.mboundView0.hasPendingBindings() == false) goto L_0x0016;
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
            com.iaai.android.databinding.FragmentFindVehicleSearchLayoutBinding r0 = r6.mboundView0
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
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.databinding.FragmentBdtFindVehicleLayoutBindingImpl.hasPendingBindings():boolean");
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mboundView0.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        executeBindingsOn(this.mboundView0);
    }
}
