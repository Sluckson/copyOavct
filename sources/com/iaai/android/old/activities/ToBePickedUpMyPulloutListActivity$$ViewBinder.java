package com.iaai.android.old.activities;

import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.iaai.android.C2723R;
import com.iaai.android.old.activities.ToBePickedUpMyPulloutListActivity;

public class ToBePickedUpMyPulloutListActivity$$ViewBinder<T extends ToBePickedUpMyPulloutListActivity> implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t, Object obj) {
        return new InnerUnbinder(t, finder, obj);
    }

    /* compiled from: ToBePickedUpMyPulloutListActivity$$ViewBinder */
    protected static class InnerUnbinder<T extends ToBePickedUpMyPulloutListActivity> implements Unbinder {
        protected T target;

        protected InnerUnbinder(T t, Finder finder, Object obj) {
            this.target = t;
            t.pulloutlist = (ListView) finder.findRequiredViewAsType(obj, C2723R.C2726id.my_pullout_list, "field 'pulloutlist'", ListView.class);
        }

        public void unbind() {
            T t = this.target;
            if (t != null) {
                t.pulloutlist = null;
                this.target = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }
}
