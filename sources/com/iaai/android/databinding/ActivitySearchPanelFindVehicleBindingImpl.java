package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.iaai.android.C2723R;

public class ActivitySearchPanelFindVehicleBindingImpl extends ActivitySearchPanelFindVehicleBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = new ViewDataBinding.IncludedLayouts(16);
    @Nullable
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    @NonNull
    private final CoordinatorLayout mboundView0;
    @NonNull
    private final LinearLayout mboundView1;
    @Nullable
    private final ContentSearchPanelFindVehicleBinding mboundView11;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    static {
        sIncludes.setIncludes(1, new String[]{"content_search_panel_find_vehicle"}, new int[]{2}, new int[]{C2723R.C2728layout.content_search_panel_find_vehicle});
        sViewsWithIds.put(C2723R.C2726id.toolbar, 3);
        sViewsWithIds.put(C2723R.C2726id.rl_titlebar_conatiner, 4);
        sViewsWithIds.put(C2723R.C2726id.img_back, 5);
        sViewsWithIds.put(C2723R.C2726id.ll_container_search_by, 6);
        sViewsWithIds.put(C2723R.C2726id.tv_searchByVehicle, 7);
        sViewsWithIds.put(C2723R.C2726id.tv_searchByAuction, 8);
        sViewsWithIds.put(C2723R.C2726id.toolbar_header, 9);
        sViewsWithIds.put(C2723R.C2726id.cl_search_container, 10);
        sViewsWithIds.put(C2723R.C2726id.fl_search_container, 11);
        sViewsWithIds.put(C2723R.C2726id.llMicClr, 12);
        sViewsWithIds.put(C2723R.C2726id.img_clear_text, 13);
        sViewsWithIds.put(C2723R.C2726id.img_voice_text, 14);
        sViewsWithIds.put(C2723R.C2726id.new_keyword_search, 15);
    }

    public ActivitySearchPanelFindVehicleBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 16, sIncludes, sViewsWithIds));
    }

    private ActivitySearchPanelFindVehicleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[10], objArr[11], objArr[5], objArr[13], objArr[14], objArr[6], objArr[12], objArr[15], objArr[4], objArr[3], objArr[9], objArr[8], objArr[7]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView1 = objArr[1];
        this.mboundView1.setTag((Object) null);
        this.mboundView11 = objArr[2];
        setContainedBinding(this.mboundView11);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1;
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
            com.iaai.android.databinding.ContentSearchPanelFindVehicleBinding r0 = r6.mboundView11
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
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.databinding.ActivitySearchPanelFindVehicleBindingImpl.hasPendingBindings():boolean");
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
