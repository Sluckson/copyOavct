package com.iaai.android.old.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.adapter.CustomOptionsAdapter;
import com.iaai.android.old.models.FilterSelect;
import com.iaai.android.old.utils.constants.Constants;
import com.lowagie.text.pdf.PdfBoolean;
import java.util.ArrayList;
import java.util.Iterator;

public class AwardPendingSortActivity extends AbstractSortNFilter {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* access modifiers changed from: package-private */
    public void createFiltersNOptions() {
        this.filterSort1 = createMainList(getString(C2723R.string.lbl_menu_sort), C2723R.C2725drawable.img_sort_black, false);
        FilterSelect createSelectListWithImage = createSelectListWithImage(getString(C2723R.string.lbl_srt_bid_amount), false, getString(C2723R.string.lbl_srt_bid_amount), C2723R.C2725drawable.icon_sort_num_asc);
        FilterSelect createSelectListWithImage2 = createSelectListWithImage(getString(C2723R.string.lbl_srt_bid_amount), false, getString(C2723R.string.lbl_srt_bid_amount), C2723R.C2725drawable.icon_sort_num_desc);
        FilterSelect createSelectListWithImage3 = createSelectListWithImage(getString(C2723R.string.lbl_srt_branch), false, getString(C2723R.string.lbl_srt_branch), C2723R.C2725drawable.icon_sort_alpha_asc);
        FilterSelect createSelectListWithImage4 = createSelectListWithImage(getString(C2723R.string.lbl_srt_branch), false, getString(C2723R.string.lbl_srt_branch), C2723R.C2725drawable.icon_sort_alpha_desc);
        FilterSelect createSelectListWithImage5 = createSelectListWithImage(getString(C2723R.string.itemID), false, getString(C2723R.string.itemID), C2723R.C2725drawable.icon_sort_num_asc);
        FilterSelect createSelectListWithImage6 = createSelectListWithImage(getString(C2723R.string.itemID), false, getString(C2723R.string.itemID), C2723R.C2725drawable.icon_sort_num_desc);
        FilterSelect createSelectListWithImage7 = createSelectListWithImage(getString(C2723R.string.lbl_srt_year_make_model), false, getString(C2723R.string.lbl_srt_year_make_model), C2723R.C2725drawable.icon_sort_alpha_asc);
        FilterSelect createSelectListWithImage8 = createSelectListWithImage(getString(C2723R.string.lbl_srt_year_make_model), false, getString(C2723R.string.lbl_srt_year_make_model), C2723R.C2725drawable.icon_sort_alpha_desc);
        FilterSelect createSelectListWithImage9 = createSelectListWithImage(getString(C2723R.string.lbl_srt_bidder), false, getString(C2723R.string.lbl_srt_bidder), C2723R.C2725drawable.icon_sort_alpha_asc);
        FilterSelect createSelectListWithImage10 = createSelectListWithImage(getString(C2723R.string.lbl_srt_bidder), false, getString(C2723R.string.lbl_srt_bidder), C2723R.C2725drawable.icon_sort_alpha_desc);
        this.filterSort1.filterSelects = new ArrayList<>();
        this.filterSort1.filterSelects.add(createSelectListWithImage);
        this.filterSort1.filterSelects.add(createSelectListWithImage2);
        this.filterSort1.filterSelects.add(createSelectListWithImage9);
        this.filterSort1.filterSelects.add(createSelectListWithImage10);
        this.filterSort1.filterSelects.add(createSelectListWithImage3);
        this.filterSort1.filterSelects.add(createSelectListWithImage4);
        this.filterSort1.filterSelects.add(createSelectListWithImage5);
        this.filterSort1.filterSelects.add(createSelectListWithImage6);
        this.filterSort1.filterSelects.add(createSelectListWithImage7);
        this.filterSort1.filterSelects.add(createSelectListWithImage8);
        this.filterModel.filterSorts.add(this.filterSort1);
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("lanes");
        if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
            this.filterSort3 = createMainList(getString(C2723R.string.lbl_lane), C2723R.C2725drawable.img_lane_black, false);
            this.filterSort3.filterSelects = new ArrayList<>();
            Iterator<String> it = stringArrayListExtra.iterator();
            while (it.hasNext()) {
                String next = it.next();
                this.filterSort3.filterSelects.add(createSelectList(next, false, next));
            }
            this.filterModel.filterSorts.add(this.filterSort3);
        }
        this.adapter = new CustomOptionsAdapter(getApplicationContext(), this.filterModel.filterSorts);
        this.listView.setAdapter(this.adapter);
        displayFirstDefaultSelectedFilter();
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (AwardPendingSortActivity.this.mTwoPane) {
                    Bundle bundle = new Bundle();
                    if (i == 0) {
                        AwardPendingSortActivity.this.filterSort1.isSelected = true;
                        AwardPendingSortActivity.this.filterSort1.filterResID = C2723R.C2725drawable.img_sort;
                        bundle.putParcelableArrayList("arraylist", AwardPendingSortActivity.this.filterSort1.filterSelects);
                        bundle.putInt(Constants.LISTING_TYPE, AwardPendingSortActivity.this.listType);
                        AwardPendingSortActivity.this.sortFragment.getArguments().putAll(bundle);
                        AwardPendingSortActivity.this.getSupportFragmentManager().beginTransaction().replace(C2723R.C2726id.item_detail_container, AwardPendingSortActivity.this.sortFragment).commit();
                        AwardPendingSortActivity.this.adapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void resetFilters() {
        commonResetFilterOption();
        Intent intent = new Intent("filter-applied");
        intent.putExtra("filter-sort-by", "BidAmount");
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
        if (this.sortFragment.filterSelects != null) {
            for (int i = 0; i < this.sortFragment.filterSelects.size(); i++) {
                if (this.listType == Constants.LIST_AWARD_PENDING) {
                    if (i == Constants.DEFAULT_SORT_OPTION_FOR_AWARDPENDING) {
                        this.sortFragment.filterSelects.get(i).setSel_isSelected("true");
                    } else {
                        this.sortFragment.filterSelects.get(i).setSel_isSelected(PdfBoolean.FALSE);
                    }
                }
            }
            this.sortFragment.adapter.notifyDataSetChanged();
        }
        int i2 = Constants.DEFAULT_SORT_OPTION_FOR_AWARDPENDING;
        IaaiApplication.selectedSortPosition = i2;
        this.initialSortPosition = i2;
        applyFilters();
    }

    /* access modifiers changed from: package-private */
    public void applyFilters() {
        String str;
        int i = 0;
        while (true) {
            str = "";
            if (i >= this.sortFragment.filterSelects.size()) {
                break;
            } else if (this.sortFragment.filterSelects.get(i).getSel_isSelected().equalsIgnoreCase("true")) {
                switch (i) {
                    case 0:
                    case 1:
                        str = "BidAmount";
                        break;
                    case 2:
                    case 3:
                        str = Constants.TO_BE_PAID_SRT_BIDDER;
                        break;
                    case 4:
                    case 5:
                        str = Constants.TO_BE_PAID_SRT_BRANCH;
                        break;
                    case 6:
                    case 7:
                        str = "AuctionItem";
                        break;
                    case 8:
                    case 9:
                        str = "Description";
                        break;
                }
            } else {
                i++;
            }
        }
        Intent intent = new Intent("filter-applied");
        intent.putExtra("filter-sort-by", str);
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
        if (this.initialSortPosition != IaaiApplication.selectedSortPosition) {
            IaaiApplication.isFirstTimeForFilterDone = true;
        }
        finish();
        overridePendingTransition(C2723R.anim.no_change, C2723R.anim.slide_down_new);
    }
}
