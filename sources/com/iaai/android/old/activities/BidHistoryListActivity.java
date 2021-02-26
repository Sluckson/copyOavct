package com.iaai.android.old.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.iaai.android.C2723R;
import com.iaai.android.old.models.BidHistory;
import com.iaai.android.old.utils.DateHelper;
import com.iaai.android.old.utils.constants.Constants;
import java.text.NumberFormat;
import java.util.List;
import roboguice.inject.InjectView;

public class BidHistoryListActivity extends AbstractListActivity {
    private BidHistory[] bidHistories;
    @InjectView(2131298184)
    private TextView txtHeader;

    /* access modifiers changed from: protected */
    public int[] getMenuIds() {
        return null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.search_results);
        this.txtHeader.setText(C2723R.string.lbl_bid_history);
        setListAdapter(new BidHistoryAdaptor(this, C2723R.C2728layout.bid_history_row, getIntent().getParcelableArrayListExtra(Constants.EXTRA_RESULT)));
    }

    private static class BidHistoryAdaptor extends ArrayAdapter<BidHistory> {
        private int resId;

        private static class ViewHolder {
            private TextView txtAmount;
            private TextView txtDate;
            private TextView txtUser;

            public ViewHolder(View view) {
                this.txtAmount = (TextView) view.findViewById(C2723R.C2726id.txt_amount);
                this.txtUser = (TextView) view.findViewById(C2723R.C2726id.txt_user);
                this.txtDate = (TextView) view.findViewById(C2723R.C2726id.txt_date);
            }

            public void update(BidHistory bidHistory) {
                this.txtAmount.setText(NumberFormat.getCurrencyInstance().format((long) bidHistory.amount));
                this.txtUser.setText(bidHistory.username);
                this.txtDate.setText(DateHelper.formatAuctionDate(bidHistory.date));
            }
        }

        public BidHistoryAdaptor(Context context, int i, List<BidHistory> list) {
            super(context, i, list);
            this.resId = i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = View.inflate(getContext(), this.resId, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.update((BidHistory) getItem(i));
            return view;
        }
    }
}
