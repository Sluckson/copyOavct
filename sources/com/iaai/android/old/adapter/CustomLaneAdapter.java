package com.iaai.android.old.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.iaai.android.C2723R;
import com.iaai.android.old.models.FilterSelect;
import java.util.ArrayList;
import java.util.List;

public class CustomLaneAdapter extends BaseAdapter {
    LayoutInflater inflater = null;
    List<FilterSelect> items = new ArrayList();

    public long getItemId(int i) {
        return 0;
    }

    public CustomLaneAdapter(Context context, List<FilterSelect> list) {
        this.inflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.items = list;
    }

    public int getCount() {
        return this.items.size();
    }

    public Object getItem(int i) {
        return this.items.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.inflater.inflate(C2723R.C2728layout.custom_fragment_sort_row, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.item = (TextView) view.findViewById(C2723R.C2726id.sort_name);
            viewHolder.tick = (ImageView) view.findViewById(C2723R.C2726id.img_tick);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if (this.items.get(i).getSel_isSelected().equalsIgnoreCase("true")) {
            viewHolder.tick.setVisibility(0);
        } else {
            viewHolder.tick.setVisibility(4);
        }
        viewHolder.item.setText(this.items.get(i).sel_label);
        return view;
    }

    private class ViewHolder {
        TextView item;
        ImageView tick;

        private ViewHolder() {
        }
    }
}
