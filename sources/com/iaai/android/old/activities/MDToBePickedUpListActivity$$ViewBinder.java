package com.iaai.android.old.activities;

import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.iaai.android.C2723R;
import com.iaai.android.old.activities.MDToBePickedUpListActivity;

public class MDToBePickedUpListActivity$$ViewBinder<T extends MDToBePickedUpListActivity> implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t, Object obj) {
        return new InnerUnbinder(t, finder, obj);
    }

    /* compiled from: MDToBePickedUpListActivity$$ViewBinder */
    protected static class InnerUnbinder<T extends MDToBePickedUpListActivity> implements Unbinder {
        protected T target;

        protected InnerUnbinder(T t, Finder finder, Object obj) {
            this.target = t;
            t.fab = (FloatingActionButton) finder.findRequiredViewAsType(obj, C2723R.C2726id.btn_presale_fab, "field 'fab'", FloatingActionButton.class);
            t.empty = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.empty_view, "field 'empty'", TextView.class);
            t.progressBar = (ProgressBar) finder.findRequiredViewAsType(obj, C2723R.C2726id.progress_bar_presale_watching, "field 'progressBar'", ProgressBar.class);
        }

        public void unbind() {
            T t = this.target;
            if (t != null) {
                t.fab = null;
                t.empty = null;
                t.progressBar = null;
                this.target = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }
}
