package com.iaai.android.old.activities;

import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.iaai.android.C2723R;
import com.iaai.android.old.activities.ToBePickedUpSelectionActivity;

public class ToBePickedUpSelectionActivity$$ViewBinder<T extends ToBePickedUpSelectionActivity> implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t, Object obj) {
        return new InnerUnbinder(t, finder, obj);
    }

    /* compiled from: ToBePickedUpSelectionActivity$$ViewBinder */
    protected static class InnerUnbinder<T extends ToBePickedUpSelectionActivity> implements Unbinder {
        protected T target;

        protected InnerUnbinder(T t, Finder finder, Object obj) {
            this.target = t;
            t.btnCreatePullout = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.btn_create_pullout, "field 'btnCreatePullout'", TextView.class);
            t.tobepickedListView = (ListView) finder.findRequiredViewAsType(obj, C2723R.C2726id.to_be_picked_up_listview, "field 'tobepickedListView'", ListView.class);
        }

        public void unbind() {
            T t = this.target;
            if (t != null) {
                t.btnCreatePullout = null;
                t.tobepickedListView = null;
                this.target = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }
}
