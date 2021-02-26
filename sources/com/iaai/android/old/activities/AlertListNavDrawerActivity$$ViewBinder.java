package com.iaai.android.old.activities;

import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.iaai.android.C2723R;
import com.iaai.android.old.activities.AlertListNavDrawerActivity;

public class AlertListNavDrawerActivity$$ViewBinder<T extends AlertListNavDrawerActivity> implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t, Object obj) {
        return new InnerUnbinder(t, finder, obj);
    }

    /* compiled from: AlertListNavDrawerActivity$$ViewBinder */
    protected static class InnerUnbinder<T extends AlertListNavDrawerActivity> implements Unbinder {
        protected T target;

        protected InnerUnbinder(T t, Finder finder, Object obj) {
            this.target = t;
            t.textViewEmpty = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.empty_textview, "field 'textViewEmpty'", TextView.class);
            t.alert_list = (ListView) finder.findRequiredViewAsType(obj, C2723R.C2726id.alert_list, "field 'alert_list'", ListView.class);
        }

        public void unbind() {
            T t = this.target;
            if (t != null) {
                t.textViewEmpty = null;
                t.alert_list = null;
                this.target = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }
}
