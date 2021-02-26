package com.commonsware.cwac.merge;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import java.util.List;

public class MergeSpinnerAdapter extends MergeAdapter {
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        for (ListAdapter next : getPieces()) {
            int count = next.getCount();
            if (i < count) {
                return ((SpinnerAdapter) next).getDropDownView(i, view, viewGroup);
            }
            i -= count;
        }
        return null;
    }

    public void addView(View view) {
        throw new RuntimeException("Not supported with MergeSpinnerAdapter");
    }

    public void addView(View view, boolean z) {
        throw new RuntimeException("Not supported with MergeSpinnerAdapter");
    }

    public void addViews(List<View> list) {
        throw new RuntimeException("Not supported with MergeSpinnerAdapter");
    }

    public void addViews(List<View> list, boolean z) {
        throw new RuntimeException("Not supported with MergeSpinnerAdapter");
    }
}
