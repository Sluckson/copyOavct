package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public class AcivityMyAccountListBindingImpl extends AcivityMyAccountListBinding {
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
        sViewsWithIds.put(C2723R.C2726id.view_switch, 3);
        sViewsWithIds.put(C2723R.C2726id.showMYVehicleRelativeLayout, 4);
        sViewsWithIds.put(C2723R.C2726id.lbl_show_vehicle, 5);
        sViewsWithIds.put(C2723R.C2726id.show_vehicle_switch, 6);
        sViewsWithIds.put(C2723R.C2726id.pre_sale_layout, 7);
        sViewsWithIds.put(C2723R.C2726id.lbl_pre_sale, 8);
        sViewsWithIds.put(C2723R.C2726id.rl_watching, 9);
        sViewsWithIds.put(C2723R.C2726id.lbl_watching, 10);
        sViewsWithIds.put(C2723R.C2726id.tv_watching_new_count, 11);
        sViewsWithIds.put(C2723R.C2726id.tv_watching_count, 12);
        sViewsWithIds.put(C2723R.C2726id.ll_guest_user, 13);
        sViewsWithIds.put(C2723R.C2726id.btn_upgrade_now, 14);
        sViewsWithIds.put(C2723R.C2726id.rl_pre_bid, 15);
        sViewsWithIds.put(C2723R.C2726id.lbl_pre_bid, 16);
        sViewsWithIds.put(C2723R.C2726id.tv_pre_bid_new_count, 17);
        sViewsWithIds.put(C2723R.C2726id.tv_pre_bid_count, 18);
        sViewsWithIds.put(C2723R.C2726id.ll_post_sale_container, 19);
        sViewsWithIds.put(C2723R.C2726id.rl_post_sale_layout, 20);
        sViewsWithIds.put(C2723R.C2726id.lbl_post_sale, 21);
        sViewsWithIds.put(C2723R.C2726id.view_manage_offer, 22);
        sViewsWithIds.put(C2723R.C2726id.rl_manage_offer, 23);
        sViewsWithIds.put(C2723R.C2726id.lbl_manage_offer, 24);
        sViewsWithIds.put(C2723R.C2726id.tv_manage_offer_new_count, 25);
        sViewsWithIds.put(C2723R.C2726id.tv_manager_offer_count, 26);
        sViewsWithIds.put(C2723R.C2726id.rl_buy_now_offer, 27);
        sViewsWithIds.put(C2723R.C2726id.lbl_buy_now_offer, 28);
        sViewsWithIds.put(C2723R.C2726id.tv_buy_now_new_count, 29);
        sViewsWithIds.put(C2723R.C2726id.tv_buy_now_count, 30);
        sViewsWithIds.put(C2723R.C2726id.rl_award_pending, 31);
        sViewsWithIds.put(C2723R.C2726id.lbl_award_pending, 32);
        sViewsWithIds.put(C2723R.C2726id.tv_award_pending_new_count, 33);
        sViewsWithIds.put(C2723R.C2726id.tv_award_pending_count, 34);
        sViewsWithIds.put(C2723R.C2726id.rl_tobe_paid, 35);
        sViewsWithIds.put(C2723R.C2726id.lbl_to_be_paid, 36);
        sViewsWithIds.put(C2723R.C2726id.tv_tobe_paid_new_count, 37);
        sViewsWithIds.put(C2723R.C2726id.tv_tobe_paid_count, 38);
        sViewsWithIds.put(C2723R.C2726id.rl_tobe_pickedup, 39);
        sViewsWithIds.put(C2723R.C2726id.lbl_to_be_pickedup, 40);
        sViewsWithIds.put(C2723R.C2726id.tv_tobe_picked_up_new_count, 41);
        sViewsWithIds.put(C2723R.C2726id.tv_tobe_picked_up_count, 42);
        sViewsWithIds.put(C2723R.C2726id.rl_sale_document, 43);
        sViewsWithIds.put(C2723R.C2726id.lbl_sale_document, 44);
        sViewsWithIds.put(C2723R.C2726id.tv_sale_document_new_count, 45);
        sViewsWithIds.put(C2723R.C2726id.tv_sale_document_count, 46);
        sViewsWithIds.put(C2723R.C2726id.ll_history_container, 47);
        sViewsWithIds.put(C2723R.C2726id.rl_history_layout, 48);
        sViewsWithIds.put(C2723R.C2726id.lbl__history, 49);
        sViewsWithIds.put(C2723R.C2726id.rl_purchase_history, 50);
        sViewsWithIds.put(C2723R.C2726id.ll_purchase_history, 51);
        sViewsWithIds.put(C2723R.C2726id.lbl_purchase_history, 52);
        sViewsWithIds.put(C2723R.C2726id.tv_sale_purchase_new_count, 53);
        sViewsWithIds.put(C2723R.C2726id.tv_purchase_count, 54);
        sViewsWithIds.put(C2723R.C2726id.rl_lost_pre_bid, 55);
        sViewsWithIds.put(C2723R.C2726id.ll_lost_pre_bid, 56);
        sViewsWithIds.put(C2723R.C2726id.lbl_lost_prebid, 57);
        sViewsWithIds.put(C2723R.C2726id.tv_lost_pre_bid_new_count, 58);
        sViewsWithIds.put(C2723R.C2726id.tv_lost_pre_bid_count, 59);
        sViewsWithIds.put(C2723R.C2726id.ll_notification_container, 60);
        sViewsWithIds.put(C2723R.C2726id.rl_notification_layout, 61);
        sViewsWithIds.put(C2723R.C2726id.notification, 62);
        sViewsWithIds.put(C2723R.C2726id.rl_notification, 63);
        sViewsWithIds.put(C2723R.C2726id.lbl_notification, 64);
        sViewsWithIds.put(C2723R.C2726id.tv_notification_new_count, 65);
        sViewsWithIds.put(C2723R.C2726id.tv_notification_count, 66);
        sViewsWithIds.put(C2723R.C2726id.rl_feedback, 67);
        sViewsWithIds.put(C2723R.C2726id.tv_lable, 68);
    }

    public AcivityMyAccountListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 69, sIncludes, sViewsWithIds));
    }

    private AcivityMyAccountListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[14], objArr[2], objArr[32], objArr[28], objArr[49], objArr[57], objArr[24], objArr[64], objArr[21], objArr[16], objArr[8], objArr[52], objArr[44], objArr[5], objArr[36], objArr[40], objArr[10], objArr[13], objArr[47], objArr[56], objArr[60], objArr[19], objArr[51], objArr[62], objArr[7], objArr[31], objArr[27], objArr[67], objArr[48], objArr[55], objArr[23], objArr[63], objArr[61], objArr[20], objArr[15], objArr[50], objArr[43], objArr[35], objArr[39], objArr[9], objArr[4], objArr[6], objArr[1], objArr[34], objArr[33], objArr[30], objArr[29], objArr[68], objArr[59], objArr[58], objArr[25], objArr[26], objArr[66], objArr[65], objArr[18], objArr[17], objArr[54], objArr[46], objArr[45], objArr[53], objArr[38], objArr[37], objArr[42], objArr[41], objArr[12], objArr[11], objArr[22], objArr[3]);
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
