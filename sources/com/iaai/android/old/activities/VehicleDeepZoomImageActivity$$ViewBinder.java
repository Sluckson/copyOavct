package com.iaai.android.old.activities;

import android.webkit.WebView;
import android.widget.ImageButton;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.iaai.android.C2723R;
import com.iaai.android.old.activities.VehicleDeepZoomImageActivity;

public class VehicleDeepZoomImageActivity$$ViewBinder<T extends VehicleDeepZoomImageActivity> implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t, Object obj) {
        return new InnerUnbinder(t, finder, obj);
    }

    /* compiled from: VehicleDeepZoomImageActivity$$ViewBinder */
    protected static class InnerUnbinder<T extends VehicleDeepZoomImageActivity> implements Unbinder {
        protected T target;

        protected InnerUnbinder(T t, Finder finder, Object obj) {
            this.target = t;
            t.deep_zoom_webview = (WebView) finder.findRequiredViewAsType(obj, C2723R.C2726id.deep_zoom_webview, "field 'deep_zoom_webview'", WebView.class);
            t.img_close = (ImageButton) finder.findRequiredViewAsType(obj, C2723R.C2726id.img_close, "field 'img_close'", ImageButton.class);
            t.left_button = (ImageButton) finder.findRequiredViewAsType(obj, C2723R.C2726id.left_button, "field 'left_button'", ImageButton.class);
            t.right_button = (ImageButton) finder.findRequiredViewAsType(obj, C2723R.C2726id.right_button, "field 'right_button'", ImageButton.class);
        }

        public void unbind() {
            T t = this.target;
            if (t != null) {
                t.deep_zoom_webview = null;
                t.img_close = null;
                t.left_button = null;
                t.right_button = null;
                this.target = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }
}
