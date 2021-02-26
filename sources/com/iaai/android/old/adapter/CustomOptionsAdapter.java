package com.iaai.android.old.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.iaai.android.C2723R;
import com.iaai.android.old.models.FilterSort;
import java.util.ArrayList;
import java.util.List;

public class CustomOptionsAdapter extends BaseAdapter {

    /* renamed from: c */
    Context f509c;
    LayoutInflater inflater = null;
    List<FilterSort> items = new ArrayList();

    public long getItemId(int i) {
        return 0;
    }

    public CustomOptionsAdapter(Context context, List<FilterSort> list) {
        this.inflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.items = list;
        this.f509c = context;
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
            view = this.inflater.inflate(C2723R.C2728layout.item_list_content, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.item = (TextView) view.findViewById(C2723R.C2726id.option);
            viewHolder.img = (ImageView) view.findViewById(C2723R.C2726id.img_option);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if (this.items.get(i).isSelected) {
            viewHolder.item.setTextColor(this.f509c.getResources().getColor(C2723R.C2724color.iaa_clear_filter_blue));
        } else {
            viewHolder.item.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        viewHolder.img.setImageResource(this.items.get(i).filterResID);
        viewHolder.item.setText(this.items.get(i).label);
        return view;
    }

    private class ViewHolder {
        ImageView img;
        TextView item;

        private ViewHolder() {
        }
    }
}
