package com.iaai.android.old.fragments;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.iaai.android.C2723R;
import com.iaai.android.old.fragments.ContactUsFragment;

public class ContactUsFragment$$ViewBinder<T extends ContactUsFragment> implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t, Object obj) {
        return new InnerUnbinder(t, finder, obj);
    }

    /* compiled from: ContactUsFragment$$ViewBinder */
    protected static class InnerUnbinder<T extends ContactUsFragment> implements Unbinder {
        protected T target;

        protected InnerUnbinder(T t, Finder finder, Object obj) {
            this.target = t;
            t.spnCategory = (Spinner) finder.findRequiredViewAsType(obj, C2723R.C2726id.spn_service_category, "field 'spnCategory'", Spinner.class);
            t.spnBranch = (Spinner) finder.findRequiredViewAsType(obj, C2723R.C2726id.spn_branch, "field 'spnBranch'", Spinner.class);
            t.btnSubmit = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.btn_contactus_submit, "field 'btnSubmit'", TextView.class);
            t.txtFirstName = (EditText) finder.findRequiredViewAsType(obj, C2723R.C2726id.txt_first_name, "field 'txtFirstName'", EditText.class);
            t.txtLastName = (EditText) finder.findRequiredViewAsType(obj, C2723R.C2726id.txt_last_name, "field 'txtLastName'", EditText.class);
            t.txtEmail = (EditText) finder.findRequiredViewAsType(obj, C2723R.C2726id.txt_email, "field 'txtEmail'", EditText.class);
            t.txtPhone = (EditText) finder.findRequiredViewAsType(obj, C2723R.C2726id.txt_phone, "field 'txtPhone'", EditText.class);
            t.txtStock = (EditText) finder.findRequiredViewAsType(obj, C2723R.C2726id.txt_stock, "field 'txtStock'", EditText.class);
            t.txtMsg = (EditText) finder.findRequiredViewAsType(obj, C2723R.C2726id.txt_msg, "field 'txtMsg'", EditText.class);
            t.charLeft = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.txt_char_left, "field 'charLeft'", TextView.class);
        }

        public void unbind() {
            T t = this.target;
            if (t != null) {
                t.spnCategory = null;
                t.spnBranch = null;
                t.btnSubmit = null;
                t.txtFirstName = null;
                t.txtLastName = null;
                t.txtEmail = null;
                t.txtPhone = null;
                t.txtStock = null;
                t.txtMsg = null;
                t.charLeft = null;
                this.target = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }
}
