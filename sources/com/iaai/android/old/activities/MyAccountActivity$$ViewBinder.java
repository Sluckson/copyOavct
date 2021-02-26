package com.iaai.android.old.activities;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.iaai.android.C2723R;
import com.iaai.android.old.activities.MyAccountActivity;

public class MyAccountActivity$$ViewBinder<T extends MyAccountActivity> implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t, Object obj) {
        return new InnerUnbinder(t, finder, obj);
    }

    /* compiled from: MyAccountActivity$$ViewBinder */
    protected static class InnerUnbinder<T extends MyAccountActivity> implements Unbinder {
        protected T target;

        protected InnerUnbinder(T t, Finder finder, Object obj) {
            this.target = t;
            t.userImage = (ImageView) finder.findRequiredViewAsType(obj, C2723R.C2726id.user_picture, "field 'userImage'", ImageView.class);
            t.userName = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.user_name, "field 'userName'", TextView.class);
            t.buyerIdInfo = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.buyer_id_info, "field 'buyerIdInfo'", TextView.class);
            t.logOut = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.btn_logout, "field 'logOut'", TextView.class);
            t.chkMyVehiclesOnly = (Switch) finder.findRequiredViewAsType(obj, C2723R.C2726id.show_vehicle_switch, "field 'chkMyVehiclesOnly'", Switch.class);
            t.showMYVehicleRelativeLayout = (RelativeLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.showMYVehicleRelativeLayout, "field 'showMYVehicleRelativeLayout'", RelativeLayout.class);
            t.preBidCount = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.prebids_count, "field 'preBidCount'", TextView.class);
            t.preBidNewCount = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.prebid_new_count, "field 'preBidNewCount'", TextView.class);
            t.awardPendingCount = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.award_pending_count, "field 'awardPendingCount'", TextView.class);
            t.awardPendingNewCount = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.award_pending_new_count, "field 'awardPendingNewCount'", TextView.class);
            t.toBePaidCount = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.tobepaid_count, "field 'toBePaidCount'", TextView.class);
            t.toBePaidNewCount = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.tobepaid_new_count, "field 'toBePaidNewCount'", TextView.class);
            t.toBePickedUpCount = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.tobe_pickedup_count, "field 'toBePickedUpCount'", TextView.class);
            t.buyNowOfferCount = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.buy_now_offer_count, "field 'buyNowOfferCount'", TextView.class);
            t.buy_now_offer_new_count = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.buy_now_offer_new_count, "field 'buy_now_offer_new_count'", TextView.class);
            t.toBePickedUpNewCount = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.tobe_pickedup_new_count, "field 'toBePickedUpNewCount'", TextView.class);
            t.alert_count = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.alert_count, "field 'alert_count'", TextView.class);
            t.profile_id = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.profile_id, "field 'profile_id'", TextView.class);
            t.license_and_document_id = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.license_and_document_id, "field 'license_and_document_id'", TextView.class);
            t.upgrade_account_id = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.upgrade_account_id, "field 'upgrade_account_id'", TextView.class);
            t.renewal_id = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.renewal_id, "field 'renewal_id'", TextView.class);
            t.profile_layout = (RelativeLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.profile_layout, "field 'profile_layout'", RelativeLayout.class);
            t.License_and_document_layout = (RelativeLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.License_and_document_layout, "field 'License_and_document_layout'", RelativeLayout.class);
            t.upgrade_account_layout = (RelativeLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.upgrade_account_layout, "field 'upgrade_account_layout'", RelativeLayout.class);
            t.renewal_layout = (RelativeLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.renewal_layout, "field 'renewal_layout'", RelativeLayout.class);
            t.watchingLayout = (RelativeLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.watching_layout, "field 'watchingLayout'", RelativeLayout.class);
            t.preBidLayout = (RelativeLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.prebid_layout, "field 'preBidLayout'", RelativeLayout.class);
            t.wonHistoryLayout = (RelativeLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.won_history_layout, "field 'wonHistoryLayout'", RelativeLayout.class);
            t.awardPendingLayout = (RelativeLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.award_pending_layout, "field 'awardPendingLayout'", RelativeLayout.class);
            t.manageOfferLayout = (RelativeLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.rlManageOfferLayout, "field 'manageOfferLayout'", RelativeLayout.class);
            t.toBePaidLayout = (RelativeLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.tobepaid_layout, "field 'toBePaidLayout'", RelativeLayout.class);
            t.toBePickedUpLayout = (RelativeLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.tobepickedup_layout, "field 'toBePickedUpLayout'", RelativeLayout.class);
            t.lostPreBidLayout = (RelativeLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.lostprebid_layout, "field 'lostPreBidLayout'", RelativeLayout.class);
            t.leave_feedback = (RelativeLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.btn_leave_feedback_myccount, "field 'leave_feedback'", RelativeLayout.class);
            t.alertLayout = (RelativeLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.alert_layout, "field 'alertLayout'", RelativeLayout.class);
            t.myAccountScrollView = (ScrollView) finder.findRequiredViewAsType(obj, C2723R.C2726id.my_account_scroll_view, "field 'myAccountScrollView'", ScrollView.class);
            t.swipeRefreshLayout = (SwipeRefreshLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.swipe_container, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
            t.progressBar = (ProgressBar) finder.findRequiredViewAsType(obj, C2723R.C2726id.progress_bar_my_account, "field 'progressBar'", ProgressBar.class);
            t.buyNowOfferLayout = (RelativeLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.buy_now_offer_layout, "field 'buyNowOfferLayout'", RelativeLayout.class);
            t.manageOfferCount = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.manageoffer_count, "field 'manageOfferCount'", TextView.class);
            t.manageOfferNewCount = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.manageoffer_new_count, "field 'manageOfferNewCount'", TextView.class);
        }

        public void unbind() {
            T t = this.target;
            if (t != null) {
                t.userImage = null;
                t.userName = null;
                t.buyerIdInfo = null;
                t.logOut = null;
                t.chkMyVehiclesOnly = null;
                t.showMYVehicleRelativeLayout = null;
                t.preBidCount = null;
                t.preBidNewCount = null;
                t.awardPendingCount = null;
                t.awardPendingNewCount = null;
                t.toBePaidCount = null;
                t.toBePaidNewCount = null;
                t.toBePickedUpCount = null;
                t.buyNowOfferCount = null;
                t.buy_now_offer_new_count = null;
                t.toBePickedUpNewCount = null;
                t.alert_count = null;
                t.profile_id = null;
                t.license_and_document_id = null;
                t.upgrade_account_id = null;
                t.renewal_id = null;
                t.profile_layout = null;
                t.License_and_document_layout = null;
                t.upgrade_account_layout = null;
                t.renewal_layout = null;
                t.watchingLayout = null;
                t.preBidLayout = null;
                t.wonHistoryLayout = null;
                t.awardPendingLayout = null;
                t.manageOfferLayout = null;
                t.toBePaidLayout = null;
                t.toBePickedUpLayout = null;
                t.lostPreBidLayout = null;
                t.leave_feedback = null;
                t.alertLayout = null;
                t.myAccountScrollView = null;
                t.swipeRefreshLayout = null;
                t.progressBar = null;
                t.buyNowOfferLayout = null;
                t.manageOfferCount = null;
                t.manageOfferNewCount = null;
                this.target = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }
}
