package com.iaai.android.old.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.iaai.android.C2723R;

public class FeeAdapter<String> extends ArrayAdapter<String> {
    Context context;
    String[] fees;

    public FeeAdapter(Context context2, int i, String[] stringArr) {
        super(context2, i, stringArr);
        this.context = context2;
        this.fees = stringArr;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(C2723R.C2728layout.tobepaid_fees_row, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(C2723R.C2726id.lbl_fees_row);
        textView.setText((CharSequence) this.fees[i]);
        textView.setSelected(true);
        return view;
    }

    public int getCount() {
        return this.fees.length;
    }

    public String getItem(int i) {
        return this.fees[i];
    }
}
