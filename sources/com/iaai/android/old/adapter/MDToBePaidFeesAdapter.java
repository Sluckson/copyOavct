package com.iaai.android.old.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.iaai.android.C2723R;
import com.iaai.android.old.models.FeesInfo;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.p016ui.UiUtils;
import java.util.ArrayList;

public class MDToBePaidFeesAdapter extends BaseAdapter {
    Context context;
    ArrayList<FeesInfo> fees;

    public long getItemId(int i) {
        return 0;
    }

    public MDToBePaidFeesAdapter(Context context2, ArrayList<FeesInfo> arrayList) {
        this.context = context2;
        this.fees = arrayList;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(C2723R.C2728layout.tobe_paid_fees_row_layout, (ViewGroup) null);
            viewHolder = new ViewHolder();
            viewHolder.row_text_label = (TextView) view.findViewById(C2723R.C2726id.label_fees);
            viewHolder.row_text_value = (TextView) view.findViewById(C2723R.C2726id.value_fees);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        TextView textView = viewHolder.row_text_label;
        textView.setText(this.fees.get(i).FeeLabel + " :");
        if (this.fees.get(i).isPartiallyPaid) {
            viewHolder.row_text_label.setCompoundDrawablesWithIntrinsicBounds(C2723R.C2725drawable.ic_partial_payment, 0, 0, 0);
            viewHolder.row_text_label.setCompoundDrawablePadding(AppUtils.convertDpToPixels(4.0f, this.context));
            viewHolder.row_text_value.setTextColor(this.context.getResources().getColor(C2723R.C2724color.tobepaid_paritial_payment));
            TextView textView2 = viewHolder.row_text_value;
            textView2.setText("-" + UiUtils.formatCurrency(this.fees.get(i).Feevalue, true));
        } else {
            viewHolder.row_text_label.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            viewHolder.row_text_value.setTextColor(this.context.getResources().getColor(C2723R.C2724color.tobepaid_dialog_fees_label_color));
            viewHolder.row_text_value.setText(UiUtils.formatCurrency(this.fees.get(i).Feevalue, true));
        }
        return view;
    }

    public class ViewHolder {
        TextView row_text_label;
        TextView row_text_value;

        public ViewHolder() {
        }
    }

    public int getCount() {
        return this.fees.size();
    }

    public FeesInfo getItem(int i) {
        return this.fees.get(i);
    }
}
