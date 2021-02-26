package com.iaai.android.old.activities;

import android.webkit.WebView;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.iaai.android.C2723R;
import com.iaai.android.old.activities.ForgotPasswordActivity;

public class ForgotPasswordActivity$$ViewBinder<T extends ForgotPasswordActivity> implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t, Object obj) {
        return new InnerUnbinder(t, finder, obj);
    }

    /* compiled from: ForgotPasswordActivity$$ViewBinder */
    protected static class InnerUnbinder<T extends ForgotPasswordActivity> implements Unbinder {
        protected T target;

        protected InnerUnbinder(T t, Finder finder, Object obj) {
            this.target = t;
            t.btnClose = (Button) finder.findRequiredViewAsType(obj, C2723R.C2726id.btn_close, "field 'btnClose'", Button.class);
            t.forgotPasswordView = (WebView) finder.findRequiredViewAsType(obj, C2723R.C2726id.forgot_password_webview, "field 'forgotPasswordView'", WebView.class);
        }

        public void unbind() {
            T t = this.target;
            if (t != null) {
                t.btnClose = null;
                t.forgotPasswordView = null;
                this.target = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }
}
