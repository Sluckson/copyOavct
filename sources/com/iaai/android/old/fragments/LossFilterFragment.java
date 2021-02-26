package com.iaai.android.old.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.iaai.android.C2723R;
import com.iaai.android.old.models.FilterSelect;
import com.lowagie.text.pdf.PdfBoolean;
import java.util.ArrayList;
import java.util.List;

public class LossFilterFragment extends Fragment {
    CustomLossAdapter adapter;
    public List<FilterSelect> filterSelects;
    /* access modifiers changed from: private */
    public ListView listLoss;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C2723R.C2728layout.fragment_loss_filter, viewGroup, false);
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.filterSelects = new ArrayList();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.filterSelects = arguments.getParcelableArrayList("arraylist");
        }
        this.listLoss = (ListView) getActivity().findViewById(C2723R.C2726id.fragment_list_loss);
        this.adapter = new CustomLossAdapter(getActivity(), this.filterSelects);
        this.listLoss.setAdapter(this.adapter);
        this.listLoss.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                for (int i2 = 0; i2 < LossFilterFragment.this.filterSelects.size(); i2++) {
                    if (i2 == i) {
                        LossFilterFragment.this.filterSelects.get(i2).setSel_isSelected("true");
                        LossFilterFragment.this.filterSelects.get(i2).setValue(LossFilterFragment.this.listLoss.getItemAtPosition(i).toString().trim());
                    } else {
                        LossFilterFragment.this.filterSelects.get(i2).setSel_isSelected(PdfBoolean.FALSE);
                        LossFilterFragment.this.filterSelects.get(i2).setValue("");
                    }
                }
                LossFilterFragment.this.adapter.notifyDataSetChanged();
            }
        });
    }

    private class CustomLossAdapter extends BaseAdapter {
        LayoutInflater inflater = null;
        List<FilterSelect> items = new ArrayList();

        public long getItemId(int i) {
            return 0;
        }

        public CustomLossAdapter(Context context, List<FilterSelect> list) {
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
}
