package com.google.android.apps.analytics.easytracking;

import android.content.Context;
import android.util.Log;

public class ParameterLoaderImpl implements ParameterLoader {
    private final Context ctx;

    public ParameterLoaderImpl(Context context) {
        if (context != null) {
            this.ctx = context;
            return;
        }
        throw new NullPointerException("Context cannot be null");
    }

    private int getResourceIdForType(String str, String str2) {
        Context context = this.ctx;
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, str2, this.ctx.getPackageName());
    }

    public boolean getBoolean(String str) {
        int resourceIdForType = getResourceIdForType(str, "bool");
        if (resourceIdForType == 0) {
            return false;
        }
        return "true".equalsIgnoreCase(this.ctx.getString(resourceIdForType));
    }

    public int getInt(String str, int i) {
        int resourceIdForType = getResourceIdForType(str, "integer");
        if (resourceIdForType == 0) {
            return i;
        }
        try {
            return Integer.parseInt(this.ctx.getString(resourceIdForType));
        } catch (NumberFormatException unused) {
            Log.w(EasyTracker.LOG_TAG, "NumberFormatException parsing " + this.ctx.getString(resourceIdForType));
            return i;
        }
    }

    public String getString(String str) {
        int resourceIdForType = getResourceIdForType(str, "string");
        if (resourceIdForType == 0) {
            return null;
        }
        return this.ctx.getString(resourceIdForType);
    }
}
