package butterknife.internal;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;

public enum Finder {
    VIEW {
        public View findOptionalView(Object obj, int i) {
            return ((View) obj).findViewById(i);
        }

        public Context getContext(Object obj) {
            return ((View) obj).getContext();
        }

        /* access modifiers changed from: protected */
        public String getResourceEntryName(Object obj, int i) {
            if (((View) obj).isInEditMode()) {
                return "<unavailable while editing>";
            }
            return Finder.super.getResourceEntryName(obj, i);
        }
    },
    ACTIVITY {
        public View findOptionalView(Object obj, int i) {
            return ((Activity) obj).findViewById(i);
        }

        public Context getContext(Object obj) {
            return (Activity) obj;
        }
    },
    DIALOG {
        public View findOptionalView(Object obj, int i) {
            return ((Dialog) obj).findViewById(i);
        }

        public Context getContext(Object obj) {
            return ((Dialog) obj).getContext();
        }
    };

    public final <T> T castParam(Object obj, String str, int i, String str2, int i2) {
        return obj;
    }

    public final <T> T castView(View view, int i, String str) {
        return view;
    }

    public abstract View findOptionalView(Object obj, int i);

    public abstract Context getContext(Object obj);

    public final <T> T findOptionalViewAsType(Object obj, int i, String str, Class<T> cls) {
        View findOptionalView = findOptionalView(obj, i);
        try {
            return cls.cast(findOptionalView);
        } catch (ClassCastException e) {
            String resourceEntryName = getResourceEntryName(findOptionalView, i);
            throw new IllegalStateException("View '" + resourceEntryName + "' with ID " + i + " for " + str + " was of the wrong type. See cause for more info.", e);
        }
    }

    public final View findRequiredView(Object obj, int i, String str) {
        View findOptionalView = findOptionalView(obj, i);
        if (findOptionalView != null) {
            return findOptionalView;
        }
        String resourceEntryName = getResourceEntryName(obj, i);
        throw new IllegalStateException("Required view '" + resourceEntryName + "' with ID " + i + " for " + str + " was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation.");
    }

    public final <T> T findRequiredViewAsType(Object obj, int i, String str, Class<T> cls) {
        View findRequiredView = findRequiredView(obj, i, str);
        try {
            return cls.cast(findRequiredView);
        } catch (ClassCastException e) {
            String resourceEntryName = getResourceEntryName(findRequiredView, i);
            throw new IllegalStateException("View '" + resourceEntryName + "' with ID " + i + " for " + str + " was of the wrong type. See cause for more info.", e);
        }
    }

    /* access modifiers changed from: protected */
    public String getResourceEntryName(Object obj, int i) {
        return getContext(obj).getResources().getResourceEntryName(i);
    }
}
