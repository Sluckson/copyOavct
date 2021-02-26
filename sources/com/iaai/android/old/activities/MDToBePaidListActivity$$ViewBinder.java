package com.iaai.android.old.activities;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.iaai.android.C2723R;
import com.iaai.android.old.activities.MDToBePaidListActivity;

public class MDToBePaidListActivity$$ViewBinder<T extends MDToBePaidListActivity> implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t, Object obj) {
        return new InnerUnbinder(t, finder, obj);
    }

    /* compiled from: MDToBePaidListActivity$$ViewBinder */
    protected static class InnerUnbinder<T extends MDToBePaidListActivity> implements Unbinder {
        protected T target;

        protected InnerUnbinder(T t, Finder finder, Object obj) {
            this.target = t;
            t.fab = (FloatingActionButton) finder.findRequiredViewAsType(obj, C2723R.C2726id.btn_presale_fab, "field 'fab'", FloatingActionButton.class);
            t.empty = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.empty_view, "field 'empty'", TextView.class);
            t.progressBar = (ProgressBar) finder.findRequiredViewAsType(obj, C2723R.C2726id.progress_bar_presale_watching, "field 'progressBar'", ProgressBar.class);
            t.errorText = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.txt_error, "field 'errorText'", TextView.class);
            t.methodSelection = (LinearLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.ll_method_selection, "field 'methodSelection'", LinearLayout.class);
            t.paymentInfoSingle = (LinearLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.lyt_payment_details_single, "field 'paymentInfoSingle'", LinearLayout.class);
            t.paymentLogo = (ImageView) finder.findRequiredViewAsType(obj, C2723R.C2726id.payment_logo, "field 'paymentLogo'", ImageView.class);
            t.lblCreditRemaining = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.lbl_credit_remaining, "field 'lblCreditRemaining'", TextView.class);
            t.valCreditRemaining = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.val_credit_remaining, "field 'valCreditRemaining'", TextView.class);
            t.txtProceedToPayment = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.txt_proceed_to_payment, "field 'txtProceedToPayment'", TextView.class);
            t.lytProceedToPayment = (LinearLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.lyt_proceede_to_pay, "field 'lytProceedToPayment'", LinearLayout.class);
            t.dividerLayout = (LinearLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.divider_layout, "field 'dividerLayout'", LinearLayout.class);
            t.creditLimit = (LinearLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.lyt_credit_limit, "field 'creditLimit'", LinearLayout.class);
        }

        public void unbind() {
            T t = this.target;
            if (t != null) {
                t.fab = null;
                t.empty = null;
                t.progressBar = null;
                t.errorText = null;
                t.methodSelection = null;
                t.paymentInfoSingle = null;
                t.paymentLogo = null;
                t.lblCreditRemaining = null;
                t.valCreditRemaining = null;
                t.txtProceedToPayment = null;
                t.lytProceedToPayment = null;
                t.dividerLayout = null;
                t.creditLimit = null;
                this.target = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }
}
