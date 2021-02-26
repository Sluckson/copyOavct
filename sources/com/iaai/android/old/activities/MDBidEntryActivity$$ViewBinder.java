package com.iaai.android.old.activities;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.iaai.android.C2723R;
import com.iaai.android.old.activities.MDBidEntryActivity;

public class MDBidEntryActivity$$ViewBinder<T extends MDBidEntryActivity> implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t, Object obj) {
        return new InnerUnbinder(t, finder, obj);
    }

    /* compiled from: MDBidEntryActivity$$ViewBinder */
    protected static class InnerUnbinder<T extends MDBidEntryActivity> implements Unbinder {
        protected T target;

        protected InnerUnbinder(T t, Finder finder, Object obj) {
            this.target = t;
            t.txtCurrentHighAmountLabel = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.txt_current_high_amount_label, "field 'txtCurrentHighAmountLabel'", TextView.class);
            t.txtCurrentHighAmount = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.txt_current_high, "field 'txtCurrentHighAmount'", TextView.class);
            t.txtTimeLeft = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.txt_time_left, "field 'txtTimeLeft'", TextView.class);
            t.sectionNoOfBid = finder.findRequiredView(obj, C2723R.C2726id.section_no_of_bid, "field 'sectionNoOfBid'");
            t.txtMaxBid = (EditText) finder.findRequiredViewAsType(obj, C2723R.C2726id.txt_max_bid, "field 'txtMaxBid'", EditText.class);
            t.btnSubmit = (Button) finder.findRequiredViewAsType(obj, C2723R.C2726id.btn_submit, "field 'btnSubmit'", Button.class);
            t.txtCurrentHighBidder = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.txt_current_high_bidder, "field 'txtCurrentHighBidder'", TextView.class);
        }

        public void unbind() {
            T t = this.target;
            if (t != null) {
                t.txtCurrentHighAmountLabel = null;
                t.txtCurrentHighAmount = null;
                t.txtTimeLeft = null;
                t.sectionNoOfBid = null;
                t.txtMaxBid = null;
                t.btnSubmit = null;
                t.txtCurrentHighBidder = null;
                this.target = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }
}
