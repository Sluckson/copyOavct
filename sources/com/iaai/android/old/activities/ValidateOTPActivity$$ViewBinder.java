package com.iaai.android.old.activities;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.iaai.android.C2723R;
import com.iaai.android.old.activities.ValidateOTPActivity;

public class ValidateOTPActivity$$ViewBinder<T extends ValidateOTPActivity> implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t, Object obj) {
        return new InnerUnbinder(t, finder, obj);
    }

    /* compiled from: ValidateOTPActivity$$ViewBinder */
    protected static class InnerUnbinder<T extends ValidateOTPActivity> implements Unbinder {
        protected T target;

        protected InnerUnbinder(T t, Finder finder, Object obj) {
            this.target = t;
            t.edt_pin = (EditText) finder.findRequiredViewAsType(obj, C2723R.C2726id.edt_pin, "field 'edt_pin'", EditText.class);
            t.confirm_pin_btn = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.confirm_pin_btn, "field 'confirm_pin_btn'", TextView.class);
            t.email_text = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.email_text, "field 'email_text'", TextView.class);
            t.edit_email = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.edit_email, "field 'edit_email'", TextView.class);
            t.verification_msg = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.verification_msg, "field 'verification_msg'", TextView.class);
            t.resend_code_layout = (LinearLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.resend_code_layout, "field 'resend_code_layout'", LinearLayout.class);
        }

        public void unbind() {
            T t = this.target;
            if (t != null) {
                t.edt_pin = null;
                t.confirm_pin_btn = null;
                t.email_text = null;
                t.edit_email = null;
                t.verification_msg = null;
                t.resend_code_layout = null;
                this.target = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }
}
