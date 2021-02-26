package com.iaai.android.old.activities;

import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.iaai.android.C2723R;
import com.iaai.android.old.activities.ToBePaidConfirmationActivity;

public class ToBePaidConfirmationActivity$$ViewBinder<T extends ToBePaidConfirmationActivity> implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t, Object obj) {
        return new InnerUnbinder(t, finder, obj);
    }

    /* compiled from: ToBePaidConfirmationActivity$$ViewBinder */
    protected static class InnerUnbinder<T extends ToBePaidConfirmationActivity> implements Unbinder {
        protected T target;

        protected InnerUnbinder(T t, Finder finder, Object obj) {
            this.target = t;
            t.selectionList = (ListView) finder.findRequiredViewAsType(obj, C2723R.C2726id.selection_list, "field 'selectionList'", ListView.class);
            t.financeAmount = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.txt_finance_count, "field 'financeAmount'", TextView.class);
            t.afcHeaderView = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.afc_header, "field 'afcHeaderView'", TextView.class);
            t.paymentType = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.payment_type, "field 'paymentType'", TextView.class);
            t.finalSuccessCount = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.txt_confirm_vehicle_count, "field 'finalSuccessCount'", TextView.class);
            t.paymentReceived = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.txt_final_payment, "field 'paymentReceived'", TextView.class);
            t.paymentData = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.txt_date, "field 'paymentData'", TextView.class);
            t.shareBtn = (ImageButton) finder.findRequiredViewAsType(obj, C2723R.C2726id.btn_share, "field 'shareBtn'", ImageButton.class);
            t.doneTxt = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.txt_done, "field 'doneTxt'", TextView.class);
            t.shareParent = (LinearLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.ll_share_parent, "field 'shareParent'", LinearLayout.class);
            t.paymentInfo = (LinearLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.ll_payment_info, "field 'paymentInfo'", LinearLayout.class);
        }

        public void unbind() {
            T t = this.target;
            if (t != null) {
                t.selectionList = null;
                t.financeAmount = null;
                t.afcHeaderView = null;
                t.paymentType = null;
                t.finalSuccessCount = null;
                t.paymentReceived = null;
                t.paymentData = null;
                t.shareBtn = null;
                t.doneTxt = null;
                t.shareParent = null;
                t.paymentInfo = null;
                this.target = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }
}
