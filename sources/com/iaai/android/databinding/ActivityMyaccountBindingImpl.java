package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.account.MyAccountViewModel;

public class ActivityMyaccountBindingImpl extends ActivityMyaccountBinding {
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

    static {
        sViewsWithIds.put(C2723R.C2726id.swipe_container, 1);
        sViewsWithIds.put(C2723R.C2726id.my_account_scroll_view, 2);
        sViewsWithIds.put(C2723R.C2726id.relative_layout_user, 3);
        sViewsWithIds.put(C2723R.C2726id.user_picture, 4);
        sViewsWithIds.put(C2723R.C2726id.user_name, 5);
        sViewsWithIds.put(C2723R.C2726id.lbl_buyer_id, 6);
        sViewsWithIds.put(C2723R.C2726id.buyer_id_info, 7);
        sViewsWithIds.put(C2723R.C2726id.btn_logout, 8);
        sViewsWithIds.put(C2723R.C2726id.showMYVehicleRelativeLayout, 9);
        sViewsWithIds.put(C2723R.C2726id.lbl_show_vehicle, 10);
        sViewsWithIds.put(C2723R.C2726id.show_vehicle_switch, 11);
        sViewsWithIds.put(C2723R.C2726id.registration_card_view, 12);
        sViewsWithIds.put(C2723R.C2726id.profile_layout, 13);
        sViewsWithIds.put(C2723R.C2726id.profile_id, 14);
        sViewsWithIds.put(C2723R.C2726id.License_and_document_layout, 15);
        sViewsWithIds.put(C2723R.C2726id.license_and_document_id, 16);
        sViewsWithIds.put(C2723R.C2726id.upgrade_account_layout, 17);
        sViewsWithIds.put(C2723R.C2726id.upgrade_account_id, 18);
        sViewsWithIds.put(C2723R.C2726id.renewal_layout, 19);
        sViewsWithIds.put(C2723R.C2726id.renewal_id, 20);
        sViewsWithIds.put(C2723R.C2726id.pre_sale_layout, 21);
        sViewsWithIds.put(C2723R.C2726id.lbl_presale, 22);
        sViewsWithIds.put(C2723R.C2726id.card_view, 23);
        sViewsWithIds.put(C2723R.C2726id.watching_layout, 24);
        sViewsWithIds.put(C2723R.C2726id.icon_watching, 25);
        sViewsWithIds.put(C2723R.C2726id.lbl_watching, 26);
        sViewsWithIds.put(C2723R.C2726id.prebid_layout, 27);
        sViewsWithIds.put(C2723R.C2726id.icon_prebid, 28);
        sViewsWithIds.put(C2723R.C2726id.lbl_prebid, 29);
        sViewsWithIds.put(C2723R.C2726id.prebid_new_count, 30);
        sViewsWithIds.put(C2723R.C2726id.prebids_count, 31);
        sViewsWithIds.put(C2723R.C2726id.post_sale_layout, 32);
        sViewsWithIds.put(C2723R.C2726id.card_view2, 33);
        sViewsWithIds.put(C2723R.C2726id.rlManageOfferLayout, 34);
        sViewsWithIds.put(C2723R.C2726id.icon_manageoffer, 35);
        sViewsWithIds.put(C2723R.C2726id.lbl_manageoffer, 36);
        sViewsWithIds.put(C2723R.C2726id.manageoffer_new_count, 37);
        sViewsWithIds.put(C2723R.C2726id.manageoffer_count, 38);
        sViewsWithIds.put(C2723R.C2726id.award_pending_layout, 39);
        sViewsWithIds.put(C2723R.C2726id.icon_awardpending, 40);
        sViewsWithIds.put(C2723R.C2726id.lbl_awardpending, 41);
        sViewsWithIds.put(C2723R.C2726id.award_pending_new_count, 42);
        sViewsWithIds.put(C2723R.C2726id.award_pending_count, 43);
        sViewsWithIds.put(C2723R.C2726id.tobepaid_layout, 44);
        sViewsWithIds.put(C2723R.C2726id.icon_prebids, 45);
        sViewsWithIds.put(C2723R.C2726id.tobepaid_new_count, 46);
        sViewsWithIds.put(C2723R.C2726id.tobepaid_count, 47);
        sViewsWithIds.put(C2723R.C2726id.lbl_tobepaid, 48);
        sViewsWithIds.put(C2723R.C2726id.buy_now_offer_layout, 49);
        sViewsWithIds.put(C2723R.C2726id.icon_buy_now_offer, 50);
        sViewsWithIds.put(C2723R.C2726id.lbl_buy_now_offer, 51);
        sViewsWithIds.put(C2723R.C2726id.buy_now_offer_new_count, 52);
        sViewsWithIds.put(C2723R.C2726id.buy_now_offer_count, 53);
        sViewsWithIds.put(C2723R.C2726id.tobepickedup_layout, 54);
        sViewsWithIds.put(C2723R.C2726id.icon_tobepickedup, 55);
        sViewsWithIds.put(C2723R.C2726id.lbl_tobepickedup, 56);
        sViewsWithIds.put(C2723R.C2726id.tobe_pickedup_new_count, 57);
        sViewsWithIds.put(C2723R.C2726id.tobe_pickedup_count, 58);
        sViewsWithIds.put(C2723R.C2726id.history_layout, 59);
        sViewsWithIds.put(C2723R.C2726id.lbl_history, 60);
        sViewsWithIds.put(C2723R.C2726id.card_view3, 61);
        sViewsWithIds.put(C2723R.C2726id.won_history_layout, 62);
        sViewsWithIds.put(C2723R.C2726id.icon_wonHistory, 63);
        sViewsWithIds.put(C2723R.C2726id.lbl_wonhistory, 64);
        sViewsWithIds.put(C2723R.C2726id.lostprebid_layout, 65);
        sViewsWithIds.put(C2723R.C2726id.icon_lost_prebids, 66);
        sViewsWithIds.put(C2723R.C2726id.lost_prebidsnew_count, 67);
        sViewsWithIds.put(C2723R.C2726id.lbl_lostorebid, 68);
        sViewsWithIds.put(C2723R.C2726id.card_view4, 69);
        sViewsWithIds.put(C2723R.C2726id.alert_layout, 70);
        sViewsWithIds.put(C2723R.C2726id.alert_icon, 71);
        sViewsWithIds.put(C2723R.C2726id.alert_count, 72);
        sViewsWithIds.put(C2723R.C2726id.card_view5, 73);
        sViewsWithIds.put(C2723R.C2726id.btn_leave_feedback_myccount, 74);
        sViewsWithIds.put(C2723R.C2726id.progress_bar_my_account, 75);
    }

    public ActivityMyaccountBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 76, sIncludes, sViewsWithIds));
    }

    private ActivityMyaccountBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[15], objArr[72], objArr[71], objArr[70], objArr[43], objArr[39], objArr[42], objArr[74], objArr[8], objArr[53], objArr[49], objArr[52], objArr[7], objArr[23], objArr[33], objArr[61], objArr[69], objArr[73], objArr[59], objArr[40], objArr[50], objArr[66], objArr[35], objArr[28], objArr[45], objArr[55], objArr[25], objArr[63], objArr[41], objArr[51], objArr[6], objArr[60], objArr[68], objArr[36], objArr[29], objArr[22], objArr[10], objArr[48], objArr[56], objArr[26], objArr[64], objArr[16], objArr[67], objArr[65], objArr[38], objArr[37], objArr[2], objArr[32], objArr[21], objArr[27], objArr[30], objArr[31], objArr[14], objArr[13], objArr[75], objArr[12], objArr[3], objArr[20], objArr[19], objArr[34], objArr[9], objArr[11], objArr[1], objArr[58], objArr[57], objArr[47], objArr[44], objArr[46], objArr[54], objArr[18], objArr[17], objArr[5], objArr[4], objArr[24], objArr[62]);
        this.mDirtyFlags = -1;
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
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
        if (6 != i) {
            return false;
        }
        setViewModel((MyAccountViewModel) obj);
        return true;
    }

    public void setViewModel(@Nullable MyAccountViewModel myAccountViewModel) {
        this.mViewModel = myAccountViewModel;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
    }
}
