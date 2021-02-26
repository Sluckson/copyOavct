package com.commonsware.cwac.merge;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.SectionIndexer;
import com.commonsware.cwac.sacklist.SackOfViewsAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MergeAdapter extends BaseAdapter implements SectionIndexer {
    protected PieceStateRoster pieces = new PieceStateRoster();

    public boolean areAllItemsEnabled() {
        return false;
    }

    public void addAdapter(ListAdapter listAdapter) {
        this.pieces.add(listAdapter);
        listAdapter.registerDataSetObserver(new CascadeDataSetObserver());
    }

    public void addView(View view) {
        addView(view, false);
    }

    public void addView(View view, boolean z) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(view);
        addViews(arrayList, z);
    }

    public void addViews(List<View> list) {
        addViews(list, false);
    }

    public void addViews(List<View> list, boolean z) {
        if (z) {
            addAdapter(new EnabledSackAdapter(list));
        } else {
            addAdapter(new SackOfViewsAdapter(list));
        }
    }

    public Object getItem(int i) {
        for (ListAdapter next : getPieces()) {
            int count = next.getCount();
            if (i < count) {
                return next.getItem(i);
            }
            i -= count;
        }
        return null;
    }

    public ListAdapter getAdapter(int i) {
        for (ListAdapter next : getPieces()) {
            int count = next.getCount();
            if (i < count) {
                return next;
            }
            i -= count;
        }
        return null;
    }

    public int getCount() {
        int i = 0;
        for (ListAdapter count : getPieces()) {
            i += count.getCount();
        }
        return i;
    }

    public int getViewTypeCount() {
        int i = 0;
        for (PieceState pieceState : this.pieces.getRawPieces()) {
            i += pieceState.adapter.getViewTypeCount();
        }
        return Math.max(i, 1);
    }

    public int getItemViewType(int i) {
        int i2 = 0;
        for (PieceState next : this.pieces.getRawPieces()) {
            if (next.isActive) {
                int count = next.adapter.getCount();
                if (i < count) {
                    return i2 + next.adapter.getItemViewType(i);
                }
                i -= count;
            }
            i2 += next.adapter.getViewTypeCount();
        }
        return -1;
    }

    public boolean isEnabled(int i) {
        for (ListAdapter next : getPieces()) {
            int count = next.getCount();
            if (i < count) {
                return next.isEnabled(i);
            }
            i -= count;
        }
        return false;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        for (ListAdapter next : getPieces()) {
            int count = next.getCount();
            if (i < count) {
                return next.getView(i, view, viewGroup);
            }
            i -= count;
        }
        return null;
    }

    public long getItemId(int i) {
        for (ListAdapter next : getPieces()) {
            int count = next.getCount();
            if (i < count) {
                return next.getItemId(i);
            }
            i -= count;
        }
        return -1;
    }

    public int getPositionForSection(int i) {
        int i2 = 0;
        for (ListAdapter next : getPieces()) {
            if (next instanceof SectionIndexer) {
                SectionIndexer sectionIndexer = (SectionIndexer) next;
                Object[] sections = sectionIndexer.getSections();
                int length = sections != null ? sections.length : 0;
                if (i < length) {
                    return i2 + sectionIndexer.getPositionForSection(i);
                }
                if (sections != null) {
                    i -= length;
                }
            }
            i2 += next.getCount();
        }
        return 0;
    }

    public int getSectionForPosition(int i) {
        Object[] sections;
        int i2 = 0;
        for (ListAdapter next : getPieces()) {
            int count = next.getCount();
            if (i >= count) {
                if ((next instanceof SectionIndexer) && (sections = ((SectionIndexer) next).getSections()) != null) {
                    i2 += sections.length;
                }
                i -= count;
            } else if (next instanceof SectionIndexer) {
                return i2 + ((SectionIndexer) next).getSectionForPosition(i);
            } else {
                return 0;
            }
        }
        return 0;
    }

    public Object[] getSections() {
        Object[] sections;
        ArrayList arrayList = new ArrayList();
        for (ListAdapter next : getPieces()) {
            if ((next instanceof SectionIndexer) && (sections = ((SectionIndexer) next).getSections()) != null) {
                Collections.addAll(arrayList, sections);
            }
        }
        if (arrayList.size() == 0) {
            return new String[0];
        }
        return arrayList.toArray(new Object[0]);
    }

    public void setActive(ListAdapter listAdapter, boolean z) {
        this.pieces.setActive(listAdapter, z);
        notifyDataSetChanged();
    }

    public void setActive(View view, boolean z) {
        this.pieces.setActive(view, z);
        notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public List<ListAdapter> getPieces() {
        return this.pieces.getPieces();
    }

    private static class PieceState {
        ListAdapter adapter;
        boolean isActive = true;

        PieceState(ListAdapter listAdapter, boolean z) {
            this.adapter = listAdapter;
            this.isActive = z;
        }
    }

    private static class PieceStateRoster {
        protected ArrayList<ListAdapter> active;
        protected ArrayList<PieceState> pieces;

        private PieceStateRoster() {
            this.pieces = new ArrayList<>();
            this.active = null;
        }

        /* access modifiers changed from: package-private */
        public void add(ListAdapter listAdapter) {
            this.pieces.add(new PieceState(listAdapter, true));
        }

        /* access modifiers changed from: package-private */
        public void setActive(ListAdapter listAdapter, boolean z) {
            Iterator<PieceState> it = this.pieces.iterator();
            while (it.hasNext()) {
                PieceState next = it.next();
                if (next.adapter == listAdapter) {
                    next.isActive = z;
                    this.active = null;
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setActive(View view, boolean z) {
            Iterator<PieceState> it = this.pieces.iterator();
            while (it.hasNext()) {
                PieceState next = it.next();
                if ((next.adapter instanceof SackOfViewsAdapter) && ((SackOfViewsAdapter) next.adapter).hasView(view)) {
                    next.isActive = z;
                    this.active = null;
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public List<PieceState> getRawPieces() {
            return this.pieces;
        }

        /* access modifiers changed from: package-private */
        public List<ListAdapter> getPieces() {
            if (this.active == null) {
                this.active = new ArrayList<>();
                Iterator<PieceState> it = this.pieces.iterator();
                while (it.hasNext()) {
                    PieceState next = it.next();
                    if (next.isActive) {
                        this.active.add(next.adapter);
                    }
                }
            }
            return this.active;
        }
    }

    private static class EnabledSackAdapter extends SackOfViewsAdapter {
        public boolean areAllItemsEnabled() {
            return true;
        }

        public boolean isEnabled(int i) {
            return true;
        }

        public EnabledSackAdapter(List<View> list) {
            super(list);
        }
    }

    private class CascadeDataSetObserver extends DataSetObserver {
        private CascadeDataSetObserver() {
        }

        public void onChanged() {
            MergeAdapter.this.notifyDataSetChanged();
        }

        public void onInvalidated() {
            MergeAdapter.this.notifyDataSetInvalidated();
        }
    }
}
