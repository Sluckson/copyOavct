package com.iaai.android.old.activities;

import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.iaai.android.C2723R;
import com.iaai.android.old.activities.AnnouncementActivity;

public class AnnouncementActivity$$ViewBinder<T extends AnnouncementActivity> implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t, Object obj) {
        return new InnerUnbinder(t, finder, obj);
    }

    /* compiled from: AnnouncementActivity$$ViewBinder */
    protected static class InnerUnbinder<T extends AnnouncementActivity> implements Unbinder {
        protected T target;

        protected InnerUnbinder(T t, Finder finder, Object obj) {
            this.target = t;
            t.toolbar_title = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.toolbar_title, "field 'toolbar_title'", TextView.class);
            t.announcementList = (ListView) finder.findRequiredViewAsType(obj, C2723R.C2726id.announcementList, "field 'announcementList'", ListView.class);
        }

        public void unbind() {
            T t = this.target;
            if (t != null) {
                t.toolbar_title = null;
                t.announcementList = null;
                this.target = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }
}
