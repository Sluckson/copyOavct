package com.iaai.android.old.activities;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.iaai.android.C2723R;
import com.iaai.android.old.activities.EmailIDConfirmationActivity;

public class EmailIDConfirmationActivity$$ViewBinder<T extends EmailIDConfirmationActivity> implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t, Object obj) {
        return new InnerUnbinder(t, finder, obj);
    }

    /* compiled from: EmailIDConfirmationActivity$$ViewBinder */
    protected static class InnerUnbinder<T extends EmailIDConfirmationActivity> implements Unbinder {
        protected T target;

        protected InnerUnbinder(T t, Finder finder, Object obj) {
            this.target = t;
            t.current_login_id = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.current_login_id, "field 'current_login_id'", TextView.class);
            t.new_login_id = (EditText) finder.findRequiredViewAsType(obj, C2723R.C2726id.new_login_id, "field 'new_login_id'", EditText.class);
            t.confirm_id = (EditText) finder.findRequiredViewAsType(obj, C2723R.C2726id.confirm_id, "field 'confirm_id'", EditText.class);
            t.continue_layout = (LinearLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.continue_layout, "field 'continue_layout'", LinearLayout.class);
            t.txt_continue_btn = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.txt_continue_btn, "field 'txt_continue_btn'", TextView.class);
        }

        public void unbind() {
            T t = this.target;
            if (t != null) {
                t.current_login_id = null;
                t.new_login_id = null;
                t.confirm_id = null;
                t.continue_layout = null;
                t.txt_continue_btn = null;
                this.target = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }
}
