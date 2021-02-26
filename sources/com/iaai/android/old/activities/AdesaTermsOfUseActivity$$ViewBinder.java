package com.iaai.android.old.activities;

import android.webkit.WebView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.iaai.android.C2723R;
import com.iaai.android.old.activities.AdesaTermsOfUseActivity;

public class AdesaTermsOfUseActivity$$ViewBinder<T extends AdesaTermsOfUseActivity> implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t, Object obj) {
        return new InnerUnbinder(t, finder, obj);
    }

    /* compiled from: AdesaTermsOfUseActivity$$ViewBinder */
    protected static class InnerUnbinder<T extends AdesaTermsOfUseActivity> implements Unbinder {
        protected T target;

        protected InnerUnbinder(T t, Finder finder, Object obj) {
            this.target = t;
            t.accept_terms_and_condition_btn = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.accept_terms_and_condition_btn, "field 'accept_terms_and_condition_btn'", TextView.class);
            t.txt_decline_btn = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.txt_decline_btn, "field 'txt_decline_btn'", TextView.class);
            t.txt_terms_and_condition = (WebView) finder.findRequiredViewAsType(obj, C2723R.C2726id.txt_terms_and_condition, "field 'txt_terms_and_condition'", WebView.class);
        }

        public void unbind() {
            T t = this.target;
            if (t != null) {
                t.accept_terms_and_condition_btn = null;
                t.txt_decline_btn = null;
                t.txt_terms_and_condition = null;
                this.target = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }
}
