package com.iaai.android.old.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.iaai.android.C2723R;
import com.iaai.android.old.models.ToBePaidConfirmation;
import com.iaai.android.old.models.ToBePaidInfo;
import com.iaai.android.old.models.ToBePaidVehicle;
import java.util.ArrayList;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class ToBePaidReviewAdapter extends BaseAdapter {
    private boolean isConfirmation;
    private Context mContext;
    private ToBePaidConfirmation toBePaidConfirmation;
    private ToBePaidInfo toBePaidInfo;
    private ArrayList<ToBePaidVehicle> tobePaidList;

    public long getItemId(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public ToBePaidReviewAdapter(Context context, ToBePaidInfo toBePaidInfo2) {
        this.mContext = context;
        this.toBePaidInfo = toBePaidInfo2;
    }

    public ToBePaidReviewAdapter(Context context, ArrayList<ToBePaidVehicle> arrayList, boolean z, ToBePaidConfirmation toBePaidConfirmation2) {
        this.mContext = context;
        this.tobePaidList = arrayList;
        this.isConfirmation = z;
        this.toBePaidConfirmation = this.toBePaidConfirmation;
    }

    public int getCount() {
        if (this.isConfirmation) {
            return this.tobePaidList.size() + 2;
        }
        return this.tobePaidList.size();
    }

    public Object getItem(int i) {
        return this.tobePaidList.get(i);
    }

    public int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ToBePaidReviewHolder toBePaidReviewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(C2723R.C2728layout.tobepaid_review_row, viewGroup, false);
            toBePaidReviewHolder = new ToBePaidReviewHolder();
            toBePaidReviewHolder.ymm = (TextView) view.findViewById(C2723R.C2726id.txt_year_make_model_tbp);
            toBePaidReviewHolder.stockNo = (TextView) view.findViewById(C2723R.C2726id.txt_stock_no);
            toBePaidReviewHolder.vin = (TextView) view.findViewById(C2723R.C2726id.txt_vin_tbp);
            toBePaidReviewHolder.branch = (TextView) view.findViewById(C2723R.C2726id.txt_branch_tbp);
            toBePaidReviewHolder.amount = (TextView) view.findViewById(C2723R.C2726id.txt_amount);
            view.setTag(toBePaidReviewHolder);
        } else {
            toBePaidReviewHolder = (ToBePaidReviewHolder) view.getTag();
        }
        ToBePaidVehicle toBePaidVehicle = this.tobePaidList.get(i);
        toBePaidReviewHolder.ymm.setText(toBePaidVehicle.getMake());
        toBePaidReviewHolder.stockNo.setText(toBePaidVehicle.getStockNumber());
        toBePaidReviewHolder.vin.setText(toBePaidVehicle.getVIN());
        toBePaidReviewHolder.branch.setText(toBePaidVehicle.getBranchnameNoComma(this.mContext));
        if (toBePaidVehicle.isPartialPaymentInd()) {
            TextView textView = toBePaidReviewHolder.amount;
            textView.setText(this.mContext.getString(C2723R.string.lbl_balance_due) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + toBePaidVehicle.getTotalDueString());
        } else {
            TextView textView2 = toBePaidReviewHolder.amount;
            textView2.setText(this.mContext.getString(C2723R.string.lbl_total_due) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + toBePaidVehicle.getTotalDueString());
        }
        return view;
    }

    static class ToBePaidReviewHolder {
        TextView amount;
        TextView branch;
        TextView stockNo;
        TextView vin;
        TextView ymm;

        ToBePaidReviewHolder() {
        }
    }
}
