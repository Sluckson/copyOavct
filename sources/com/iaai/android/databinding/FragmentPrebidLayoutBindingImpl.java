package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.productDetail.ProductDetailViewModel;
import com.iaai.android.bdt.model.productDetail.biddingInfo.BiddingInformation;

public class FragmentPrebidLayoutBindingImpl extends FragmentPrebidLayoutBinding {
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
        sViewsWithIds.put(C2723R.C2726id.place_pre_bid_main_layout, 1);
        sViewsWithIds.put(C2723R.C2726id.place_bid_year_make_model, 2);
        sViewsWithIds.put(C2723R.C2726id.stock_label, 3);
        sViewsWithIds.put(C2723R.C2726id.branch_label, 4);
        sViewsWithIds.put(C2723R.C2726id.label_vehicle_location, 5);
        sViewsWithIds.put(C2723R.C2726id.value_stock, 6);
        sViewsWithIds.put(C2723R.C2726id.value_prebid_branch, 7);
        sViewsWithIds.put(C2723R.C2726id.value_vehicle_location, 8);
        sViewsWithIds.put(C2723R.C2726id.group, 9);
        sViewsWithIds.put(C2723R.C2726id.view, 10);
        sViewsWithIds.put(C2723R.C2726id.textView12, 11);
        sViewsWithIds.put(C2723R.C2726id.pre_bid_starting_label, 12);
        sViewsWithIds.put(C2723R.C2726id.textView14, 13);
        sViewsWithIds.put(C2723R.C2726id.prebid_current_bid, 14);
        sViewsWithIds.put(C2723R.C2726id.prebid_starting_bid, 15);
        sViewsWithIds.put(C2723R.C2726id.prebid_time_remaining, 16);
        sViewsWithIds.put(C2723R.C2726id.linearLayout2, 17);
        sViewsWithIds.put(C2723R.C2726id.txt_max_bid_layout, 18);
        sViewsWithIds.put(C2723R.C2726id.txt_max_bid, 19);
        sViewsWithIds.put(C2723R.C2726id.txt_increment_bid, 20);
        sViewsWithIds.put(C2723R.C2726id.view1, 21);
        sViewsWithIds.put(C2723R.C2726id.prebid_award_label, 22);
        sViewsWithIds.put(C2723R.C2726id.prebid_payment_due_label, 23);
        sViewsWithIds.put(C2723R.C2726id.prebid_sales_text_layout, 24);
        sViewsWithIds.put(C2723R.C2726id.textView2, 25);
        sViewsWithIds.put(C2723R.C2726id.tv_prebid_sales_text_msg, 26);
        sViewsWithIds.put(C2723R.C2726id.prebid_go_to_tax_form, 27);
        sViewsWithIds.put(C2723R.C2726id.prebid_pickup_due, 28);
        sViewsWithIds.put(C2723R.C2726id.prebid_payment_due_value, 29);
        sViewsWithIds.put(C2723R.C2726id.prebid_pickup_value, 30);
        sViewsWithIds.put(C2723R.C2726id.view3, 31);
        sViewsWithIds.put(C2723R.C2726id.prebid_submit_button, 32);
        sViewsWithIds.put(C2723R.C2726id.pre_bid_review_and_confirm_layout, 33);
        sViewsWithIds.put(C2723R.C2726id.imageView, 34);
        sViewsWithIds.put(C2723R.C2726id.textView4, 35);
        sViewsWithIds.put(C2723R.C2726id.textView5, 36);
        sViewsWithIds.put(C2723R.C2726id.prebid_review_my_max_bid, 37);
        sViewsWithIds.put(C2723R.C2726id.prebid_review_vehicle_location, 38);
        sViewsWithIds.put(C2723R.C2726id.prebid_review_branch, 39);
        sViewsWithIds.put(C2723R.C2726id.prebid_review_stock, 40);
        sViewsWithIds.put(C2723R.C2726id.prebid_review_vehicle, 41);
        sViewsWithIds.put(C2723R.C2726id.prebid_review_currentbid, 42);
        sViewsWithIds.put(C2723R.C2726id.textView8, 43);
        sViewsWithIds.put(C2723R.C2726id.textView16, 44);
        sViewsWithIds.put(C2723R.C2726id.textView15, 45);
        sViewsWithIds.put(C2723R.C2726id.textView11, 46);
        sViewsWithIds.put(C2723R.C2726id.textView10, 47);
        sViewsWithIds.put(C2723R.C2726id.textView7, 48);
        sViewsWithIds.put(C2723R.C2726id.btn_pre_bid_confirm, 49);
        sViewsWithIds.put(C2723R.C2726id.btn_pre_bid_review_edit, 50);
        sViewsWithIds.put(C2723R.C2726id.view4, 51);
        sViewsWithIds.put(C2723R.C2726id.pre_bid_submitted_layout, 52);
        sViewsWithIds.put(C2723R.C2726id.pre_bid_submitted_branch, 53);
        sViewsWithIds.put(C2723R.C2726id.textView21, 54);
        sViewsWithIds.put(C2723R.C2726id.textView20, 55);
        sViewsWithIds.put(C2723R.C2726id.imageView2, 56);
        sViewsWithIds.put(C2723R.C2726id.tvSubmitted, 57);
        sViewsWithIds.put(C2723R.C2726id.textView18, 58);
        sViewsWithIds.put(C2723R.C2726id.textView23, 59);
        sViewsWithIds.put(C2723R.C2726id.textView22, 60);
        sViewsWithIds.put(C2723R.C2726id.textView19, 61);
        sViewsWithIds.put(C2723R.C2726id.pre_bid_submitted_close_button, 62);
        sViewsWithIds.put(C2723R.C2726id.view5, 63);
        sViewsWithIds.put(C2723R.C2726id.pre_bid_submitted_stock, 64);
        sViewsWithIds.put(C2723R.C2726id.pre_bid_submitted_vehicle_location, 65);
        sViewsWithIds.put(C2723R.C2726id.pre_bid_submitted_my_max, 66);
        sViewsWithIds.put(C2723R.C2726id.pre_bid_submitted_current_bid, 67);
        sViewsWithIds.put(C2723R.C2726id.pre_bid_pbLoading, 68);
    }

    public FragmentPrebidLayoutBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 69, sIncludes, sViewsWithIds));
    }

    private FragmentPrebidLayoutBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[4], objArr[49], objArr[50], objArr[9], objArr[34], objArr[56], objArr[5], objArr[17], objArr[2], objArr[1], objArr[68], objArr[33], objArr[12], objArr[53], objArr[62], objArr[67], objArr[52], objArr[66], objArr[64], objArr[65], objArr[22], objArr[14], objArr[27], objArr[23], objArr[29], objArr[28], objArr[30], objArr[39], objArr[42], objArr[37], objArr[40], objArr[41], objArr[38], objArr[24], objArr[15], objArr[32], objArr[16], objArr[3], objArr[47], objArr[46], objArr[11], objArr[13], objArr[45], objArr[44], objArr[58], objArr[61], objArr[25], objArr[55], objArr[54], objArr[60], objArr[59], objArr[35], objArr[36], objArr[48], objArr[43], objArr[26], objArr[57], objArr[20], objArr[19], objArr[18], objArr[7], objArr[6], objArr[8], objArr[10], objArr[21], objArr[31], objArr[51], objArr[63]);
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
        if (5 == i) {
            setBiddingInfo((BiddingInformation) obj);
        } else if (6 != i) {
            return false;
        } else {
            setViewModel((ProductDetailViewModel) obj);
        }
        return true;
    }

    public void setBiddingInfo(@Nullable BiddingInformation biddingInformation) {
        this.mBiddingInfo = biddingInformation;
    }

    public void setViewModel(@Nullable ProductDetailViewModel productDetailViewModel) {
        this.mViewModel = productDetailViewModel;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
    }
}
