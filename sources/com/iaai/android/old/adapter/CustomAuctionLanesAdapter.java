package com.iaai.android.old.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.iaai.android.C2723R;
import com.iaai.android.old.models.AuctionLanes;
import java.util.ArrayList;

public class CustomAuctionLanesAdapter extends BaseAdapter {
    private ArrayList<AuctionLanes> auctions;
    Context context = null;
    private LayoutInflater mInflater;
    private int previouslySelectedPos;

    public static class ViewHolder {
        public TextView auctionLane;
        public ImageView checkmark;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public CustomAuctionLanesAdapter() {
    }

    public CustomAuctionLanesAdapter(Context context2, ArrayList<AuctionLanes> arrayList, int i) {
        this.context = context2;
        this.auctions = arrayList;
        this.previouslySelectedPos = i;
        this.mInflater = (LayoutInflater) context2.getSystemService("layout_inflater");
    }

    public int getCount() {
        return this.auctions.size();
    }

    public Object getItem(int i) {
        return this.auctions.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = this.mInflater.inflate(C2723R.C2728layout.auction_lanes_list_row, (ViewGroup) null);
            viewHolder.auctionLane = (TextView) view2.findViewById(C2723R.C2726id.auction_name);
            viewHolder.checkmark = (ImageView) view2.findViewById(C2723R.C2726id.checkmark);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.auctionLane.setText(this.auctions.get(i).auctionName);
        if (this.previouslySelectedPos == i) {
            viewHolder.checkmark.setVisibility(0);
        } else {
            viewHolder.checkmark.setVisibility(8);
        }
        return view2;
    }
}
