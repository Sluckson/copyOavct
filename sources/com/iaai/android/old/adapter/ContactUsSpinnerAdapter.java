package com.iaai.android.old.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.iaai.android.C2723R;
import java.util.List;

public class ContactUsSpinnerAdapter extends BaseAdapter {
    List<String> branchArray;
    Context context;
    LayoutInflater inflater;
    boolean isSpinnerEnable = true;
    private int mSelectedIndex = -1;

    public long getItemId(int i) {
        return (long) i;
    }

    public ContactUsSpinnerAdapter() {
    }

    public ContactUsSpinnerAdapter(Context context2, List<String> list) {
        this.context = context2;
        this.branchArray = list;
        this.inflater = LayoutInflater.from(context2);
    }

    public int getCount() {
        return this.branchArray.size();
    }

    public Object getItem(int i) {
        if (i <= this.branchArray.size()) {
            return this.branchArray.get(i);
        }
        return this.branchArray.get(0);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return getCustomView(i, view, viewGroup);
    }

    public void setSelection(int i) {
        this.mSelectedIndex = i;
        notifyDataSetChanged();
    }

    public int getSelection() {
        return this.mSelectedIndex;
    }

    public void isSpinnerEnable(boolean z) {
        this.isSpinnerEnable = z;
        notifyDataSetChanged();
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) super.getDropDownView(i, view, viewGroup);
        if (i == this.mSelectedIndex) {
            textView.setTypeface((Typeface) null, 1);
        } else {
            textView.setTypeface((Typeface) null, 0);
        }
        return textView;
    }

    public View getCustomView(int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        String str = (String) getItem(i);
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = this.inflater.inflate(C2723R.C2728layout.classic_search_spinner_adapter_layout, viewGroup, false);
            viewHolder.label = (TextView) view2.findViewById(C2723R.C2726id.name_entry);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.label.setText(str);
        if (this.isSpinnerEnable) {
            viewHolder.label.setEnabled(true);
            viewHolder.label.setTextColor(view2.getResources().getColor(C2723R.C2724color.iaa_black));
        } else {
            viewHolder.label.setEnabled(false);
            viewHolder.label.setTextColor(view2.getResources().getColor(C2723R.C2724color.iaa_text_disable));
        }
        return view2;
    }

    private class ViewHolder {
        TextView label;

        private ViewHolder() {
        }
    }

    public List<String> branchArraygetDefaultRefinerArrayList() {
        return this.branchArray;
    }
}
