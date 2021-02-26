package com.commonsware.cwac.adapter;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

public class AdapterWrapper extends BaseAdapter {
    private ListAdapter wrapped = null;

    public AdapterWrapper(ListAdapter listAdapter) {
        this.wrapped = listAdapter;
        listAdapter.registerDataSetObserver(new DataSetObserver() {
            public void onChanged() {
                AdapterWrapper.this.notifyDataSetChanged();
            }

            public void onInvalidated() {
                AdapterWrapper.this.notifyDataSetInvalidated();
            }
        });
    }

    public Object getItem(int i) {
        return this.wrapped.getItem(i);
    }

    public int getCount() {
        return this.wrapped.getCount();
    }

    public int getViewTypeCount() {
        return this.wrapped.getViewTypeCount();
    }

    public int getItemViewType(int i) {
        return this.wrapped.getItemViewType(i);
    }

    public boolean areAllItemsEnabled() {
        return this.wrapped.areAllItemsEnabled();
    }

    public boolean isEnabled(int i) {
        return this.wrapped.isEnabled(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.wrapped.getView(i, view, viewGroup);
    }

    public long getItemId(int i) {
        return this.wrapped.getItemId(i);
    }

    /* access modifiers changed from: protected */
    public ListAdapter getWrappedAdapter() {
        return this.wrapped;
    }
}
