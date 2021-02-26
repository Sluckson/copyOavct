package com.iaai.android.old.activities;

import android.webkit.WebView;
import android.widget.ImageButton;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.iaai.android.C2723R;
import com.iaai.android.old.activities.Vehicle360ImageActivity;

public class Vehicle360ImageActivity$$ViewBinder<T extends Vehicle360ImageActivity> implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t, Object obj) {
        return new InnerUnbinder(t, finder, obj);
    }

    /* compiled from: Vehicle360ImageActivity$$ViewBinder */
    protected static class InnerUnbinder<T extends Vehicle360ImageActivity> implements Unbinder {
        protected T target;

        protected InnerUnbinder(T t, Finder finder, Object obj) {
            this.target = t;
            t.image_360_webview = (WebView) finder.findRequiredViewAsType(obj, C2723R.C2726id.image_360_webview, "field 'image_360_webview'", WebView.class);
            t.img_close = (ImageButton) finder.findRequiredViewAsType(obj, C2723R.C2726id.img_close, "field 'img_close'", ImageButton.class);
        }

        public void unbind() {
            T t = this.target;
            if (t != null) {
                t.image_360_webview = null;
                t.img_close = null;
                this.target = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }
}
