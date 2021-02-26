package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListViewModel;
import com.iaai.android.bdt.model.auctionSalesList.ResultData;

public class RowItemSalesLdocumentHeaderBindingImpl extends RowItemSalesLdocumentHeaderBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    @NonNull
    private final RelativeLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        sViewsWithIds.put(C2723R.C2726id.empty_view, 2);
        sViewsWithIds.put(C2723R.C2726id.cl_title_container, 3);
        sViewsWithIds.put(C2723R.C2726id.tv_SalesDocTitle1, 4);
        sViewsWithIds.put(C2723R.C2726id.tv_SalesDocTitle2, 5);
        sViewsWithIds.put(C2723R.C2726id.tv_SalesDocManageBranch, 6);
        sViewsWithIds.put(C2723R.C2726id.cl_document_status_container, 7);
        sViewsWithIds.put(C2723R.C2726id.tv_DocumentStatus, 8);
        sViewsWithIds.put(C2723R.C2726id.ll_document_status, 9);
        sViewsWithIds.put(C2723R.C2726id.tv_all_status, 10);
        sViewsWithIds.put(C2723R.C2726id.tv_open_status, 11);
        sViewsWithIds.put(C2723R.C2726id.tv_close_status, 12);
        sViewsWithIds.put(C2723R.C2726id.layout_sort_container, 13);
        sViewsWithIds.put(C2723R.C2726id.iv_sort, 14);
        sViewsWithIds.put(C2723R.C2726id.tv_SortLabel, 15);
        sViewsWithIds.put(C2723R.C2726id.img_filter, 16);
        sViewsWithIds.put(C2723R.C2726id.tv_filter_label, 17);
        sViewsWithIds.put(C2723R.C2726id.tv_filterCount, 18);
        sViewsWithIds.put(C2723R.C2726id.header_mdlost_prebid, 19);
        sViewsWithIds.put(C2723R.C2726id.viewHeader, 20);
    }

    public RowItemSalesLdocumentHeaderBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 21, sIncludes, sViewsWithIds));
    }

    private RowItemSalesLdocumentHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[7], objArr[1], objArr[3], objArr[2], objArr[19], objArr[16], objArr[14], objArr[13], objArr[9], objArr[10], objArr[12], objArr[8], objArr[18], objArr[17], objArr[11], objArr[6], objArr[4], objArr[5], objArr[15], objArr[20]);
        this.mDirtyFlags = -1;
        this.clEmptyView.setTag((Object) null);
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
            setViewModel((AuctionSalesListViewModel) obj);
        } else if (2 != i) {
            return false;
        } else {
            setResultData((ResultData) obj);
        }
        return true;
    }

    public void setViewModel(@Nullable AuctionSalesListViewModel auctionSalesListViewModel) {
        this.mViewModel = auctionSalesListViewModel;
    }

    public void setResultData(@Nullable ResultData resultData) {
        this.mResultData = resultData;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
    }
}
