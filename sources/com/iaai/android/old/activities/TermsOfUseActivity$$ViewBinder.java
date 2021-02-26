package com.iaai.android.old.activities;

import android.webkit.WebView;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.iaai.android.C2723R;
import com.iaai.android.old.activities.TermsOfUseActivity;

public class TermsOfUseActivity$$ViewBinder<T extends TermsOfUseActivity> implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t, Object obj) {
        return new InnerUnbinder(t, finder, obj);
    }

    /* compiled from: TermsOfUseActivity$$ViewBinder */
    protected static class InnerUnbinder<T extends TermsOfUseActivity> implements Unbinder {
        protected T target;

        protected InnerUnbinder(T t, Finder finder, Object obj) {
            this.target = t;
            t.accept = (Button) finder.findRequiredViewAsType(obj, C2723R.C2726id.btn_accept, "field 'accept'", Button.class);
            t.terms_of_use_webview = (WebView) finder.findRequiredViewAsType(obj, C2723R.C2726id.terms_and_conditions, "field 'terms_of_use_webview'", WebView.class);
        }

        public void unbind() {
            T t = this.target;
            if (t != null) {
                t.accept = null;
                t.terms_of_use_webview = null;
                this.target = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }
}
