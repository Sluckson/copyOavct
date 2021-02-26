package com.iaai.android.old.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.iaai.android.C2723R;
import com.iaai.android.old.adapter.CustomAuctionLanesAdapter;
import com.iaai.android.old.models.AuctionLanes;
import java.util.ArrayList;

public class AuctionLanesList extends Activity {
    CustomAuctionLanesAdapter adapter;
    ArrayList<AuctionLanes> auctionLanesArrayList;
    ListView auctionLanesListView;
    TextView auctionNotAvailable;
    ImageView btnBack;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2723R.C2728layout.activity_auction_lanes_list);
        Bundle extras = getIntent().getExtras();
        int i = extras != null ? extras.getInt("POSITION_IN_LIST") : -1;
        this.btnBack = (ImageView) findViewById(C2723R.C2726id.btn_back_auction_lanes);
        this.btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AuctionLanesList.this.finish();
            }
        });
        this.auctionLanesArrayList = getIntent().getParcelableArrayListExtra("AuctionLanesList");
        this.auctionLanesListView = (ListView) findViewById(C2723R.C2726id.auction_lanes_list);
        this.auctionNotAvailable = (TextView) findViewById(C2723R.C2726id.auction_not_available);
        ArrayList<AuctionLanes> arrayList = this.auctionLanesArrayList;
        if (arrayList == null || arrayList.size() <= 0) {
            this.auctionNotAvailable.setVisibility(0);
        } else {
            this.adapter = new CustomAuctionLanesAdapter(this, this.auctionLanesArrayList, i);
            this.auctionLanesListView.setAdapter(this.adapter);
            this.auctionNotAvailable.setVisibility(8);
        }
        this.auctionLanesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AuctionLanes auctionLanes = AuctionLanesList.this.auctionLanesArrayList.get(i);
                Intent intent = new Intent();
                intent.putExtra("AL_BRANCHNUMBER", auctionLanes.branchNumber);
                intent.putExtra("AL_AUCTIONLANE", auctionLanes.auctionLane);
                intent.putExtra("AL_POSITION_IN_LIST", i);
                AuctionLanesList.this.setResult(1002, intent);
                AuctionLanesList.this.finish();
            }
        });
    }
}
