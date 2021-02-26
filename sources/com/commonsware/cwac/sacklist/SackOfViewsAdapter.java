package com.commonsware.cwac.sacklist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

public class SackOfViewsAdapter extends BaseAdapter {
    private List<View> views = null;

    public boolean areAllItemsEnabled() {
        return false;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return i;
    }

    public boolean isEnabled(int i) {
        return false;
    }

    public SackOfViewsAdapter(int i) {
        this.views = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.views.add((Object) null);
        }
    }

    public SackOfViewsAdapter(List<View> list) {
        this.views = list;
    }

    public Object getItem(int i) {
        return this.views.get(i);
    }

    public int getCount() {
        return this.views.size();
    }

    public int getViewTypeCount() {
        return getCount();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = this.views.get(i);
        if (view2 != null) {
            return view2;
        }
        View newView = newView(i, viewGroup);
        this.views.set(i, newView);
        return newView;
    }

    public boolean hasView(View view) {
        return this.views.contains(view);
    }

    /* access modifiers changed from: protected */
    public View newView(int i, ViewGroup viewGroup) {
        throw new RuntimeException("You must override newView()!");
    }
}
