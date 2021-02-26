package com.iaai.android.old.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.iaai.android.C2723R;
import com.iaai.android.old.models.BidHistory;
import com.iaai.android.old.utils.DateHelper;
import com.iaai.android.old.utils.constants.Constants;
import java.text.NumberFormat;
import java.util.List;

public class BidHistoryExpandableListAdapter extends BaseExpandableListAdapter {
    private Context _context;
    private List<BidHistory> bidHistoryList;

    public long getChildId(int i, int i2) {
        return (long) i2;
    }

    public int getGroupCount() {
        return 1;
    }

    public long getGroupId(int i) {
        return (long) i;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    public BidHistoryExpandableListAdapter(Context context, List<BidHistory> list) {
        this._context = context;
        this.bidHistoryList = list;
    }

    public Object getChild(int i, int i2) {
        return this.bidHistoryList.get(i2);
    }

    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        BidHistory bidHistory = (BidHistory) getChild(i, i2);
        if (view == null) {
            view = ((LayoutInflater) this._context.getSystemService("layout_inflater")).inflate(C2723R.C2728layout.bid_history_item, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.txtAmount.setText(NumberFormat.getCurrencyInstance().format((long) bidHistory.amount));
        viewHolder.txtUser.setText(bidHistory.username);
        if (bidHistory.username.equals("You")) {
            viewHolder.txtUser.setText(C2723R.string.txt_you);
        } else {
            viewHolder.txtUser.setText(C2723R.string.txt_not_you);
        }
        viewHolder.txtDate.setText(DateHelper.format(bidHistory.date, Constants.DATE_PATTERN_MD_BID_HISTORY).replace(",", "at"));
        return view;
    }

    private static class ViewHolder {
        /* access modifiers changed from: private */
        public TextView txtAmount;
        /* access modifiers changed from: private */
        public TextView txtDate;
        /* access modifiers changed from: private */
        public TextView txtUser;

        public ViewHolder(View view) {
            this.txtAmount = (TextView) view.findViewById(C2723R.C2726id.txt_amount);
            this.txtUser = (TextView) view.findViewById(C2723R.C2726id.txt_user);
            this.txtDate = (TextView) view.findViewById(C2723R.C2726id.txt_date);
        }
    }

    public int getChildrenCount(int i) {
        return this.bidHistoryList.size();
    }

    public Object getGroup(int i) {
        return new String(this._context.getString(C2723R.string.lbl_bid_history));
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        String str = (String) getGroup(i);
        if (view == null) {
            view = ((LayoutInflater) this._context.getSystemService("layout_inflater")).inflate(C2723R.C2728layout.bid_history_group, (ViewGroup) null);
        }
        ImageView imageView = (ImageView) view.findViewById(C2723R.C2726id.img_header_arrow);
        if (z) {
            imageView.setImageResource(C2723R.C2725drawable.arrow_up);
        } else {
            imageView.setImageResource(C2723R.C2725drawable.arrow_down);
        }
        ((TextView) view.findViewById(C2723R.C2726id.lbl_bid_history_header)).setText(str);
        return view;
    }
}
