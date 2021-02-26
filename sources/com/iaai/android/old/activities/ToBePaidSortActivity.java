package com.iaai.android.old.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.adapter.CustomOptionsAdapter;
import com.iaai.android.old.fragments.ToBePaidBranchFilterFragment;
import com.iaai.android.old.models.FilterSelect;
import com.iaai.android.old.utils.constants.Constants;
import com.lowagie.text.pdf.PdfBoolean;
import java.util.ArrayList;
import java.util.Iterator;

public class ToBePaidSortActivity extends AbstractSortNFilter {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* access modifiers changed from: package-private */
    public void createFiltersNOptions() {
        this.filterSort1 = createMainList(getString(C2723R.string.lbl_menu_sort), C2723R.C2725drawable.img_sort_black, false);
        FilterSelect createSelectListWithImage = createSelectListWithImage(getString(C2723R.string.lbl_srt_due_date), false, getString(C2723R.string.lbl_srt_due_date), C2723R.C2725drawable.icon_sort_num_asc);
        FilterSelect createSelectListWithImage2 = createSelectListWithImage(getString(C2723R.string.lbl_srt_due_date), false, getString(C2723R.string.lbl_srt_due_date), C2723R.C2725drawable.icon_sort_num_desc);
        FilterSelect createSelectListWithImage3 = createSelectListWithImage(getString(C2723R.string.lbl_srt_total_price), false, getString(C2723R.string.lbl_srt_total_price), C2723R.C2725drawable.icon_sort_num_asc);
        FilterSelect createSelectListWithImage4 = createSelectListWithImage(getString(C2723R.string.lbl_srt_total_price), false, getString(C2723R.string.lbl_srt_total_price), C2723R.C2725drawable.icon_sort_num_desc);
        FilterSelect createSelectListWithImage5 = createSelectListWithImage(getString(C2723R.string.lbl_srt_bidder), false, getString(C2723R.string.lbl_srt_bidder), C2723R.C2725drawable.icon_sort_alpha_asc);
        FilterSelect createSelectListWithImage6 = createSelectListWithImage(getString(C2723R.string.lbl_srt_bidder), false, getString(C2723R.string.lbl_srt_bidder), C2723R.C2725drawable.icon_sort_alpha_desc);
        FilterSelect createSelectListWithImage7 = createSelectListWithImage(getString(C2723R.string.lbl_srt_branch), false, getString(C2723R.string.lbl_srt_branch), C2723R.C2725drawable.icon_sort_alpha_asc);
        FilterSelect createSelectListWithImage8 = createSelectListWithImage(getString(C2723R.string.lbl_srt_branch), false, getString(C2723R.string.lbl_srt_branch), C2723R.C2725drawable.icon_sort_alpha_desc);
        this.filterSort1.filterSelects = new ArrayList<>();
        this.filterSort1.filterSelects.add(createSelectListWithImage5);
        this.filterSort1.filterSelects.add(createSelectListWithImage6);
        this.filterSort1.filterSelects.add(createSelectListWithImage7);
        this.filterSort1.filterSelects.add(createSelectListWithImage8);
        this.filterSort1.filterSelects.add(createSelectListWithImage);
        this.filterSort1.filterSelects.add(createSelectListWithImage2);
        this.filterSort1.filterSelects.add(createSelectListWithImage3);
        this.filterSort1.filterSelects.add(createSelectListWithImage4);
        this.filterModel.filterSorts.add(this.filterSort1);
        this.tobepaidFilterFragment = new ToBePaidBranchFilterFragment();
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra(Constants.EXTRA_TOBPAID_BRANCH_FILTER);
        if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
            this.filterSort3 = createMainList(getString(C2723R.string.lbl_srt_branch), C2723R.C2725drawable.ic_branch, false);
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
                if (ToBePaidSortActivity.this.mTwoPane) {
                    Bundle bundle = new Bundle();
                    if (i == 0) {
                        ToBePaidSortActivity.this.filterSort1.isSelected = true;
                        ToBePaidSortActivity.this.filterSort1.filterResID = C2723R.C2725drawable.img_sort;
                        ToBePaidSortActivity.this.filterSort3.isSelected = false;
                        ToBePaidSortActivity.this.filterSort3.filterResID = C2723R.C2725drawable.ic_branch;
                        bundle.putParcelableArrayList("arraylist", ToBePaidSortActivity.this.filterSort1.filterSelects);
                        bundle.putInt(Constants.LISTING_TYPE, ToBePaidSortActivity.this.listType);
                        ToBePaidSortActivity.this.sortFragment.getArguments().putAll(bundle);
                        ToBePaidSortActivity.this.getSupportFragmentManager().beginTransaction().replace(C2723R.C2726id.item_detail_container, ToBePaidSortActivity.this.sortFragment).commit();
                        ToBePaidSortActivity.this.adapter.notifyDataSetChanged();
                    } else if (i == 1) {
                        ToBePaidSortActivity.this.filterSort3.isSelected = true;
                        ToBePaidSortActivity.this.filterSort3.filterResID = C2723R.C2725drawable.ic_branch_active;
                        ToBePaidSortActivity.this.filterSort1.isSelected = false;
                        ToBePaidSortActivity.this.filterSort1.filterResID = C2723R.C2725drawable.img_sort_black;
                        bundle.putParcelableArrayList("arraylist", ToBePaidSortActivity.this.filterSort3.filterSelects);
                        if (ToBePaidSortActivity.this.tobepaidFilterFragment.getArguments() != null) {
                            ToBePaidSortActivity.this.tobepaidFilterFragment.getArguments().putAll(bundle);
                        } else {
                            ToBePaidSortActivity.this.tobepaidFilterFragment.setArguments(bundle);
                        }
                        ToBePaidSortActivity.this.getSupportFragmentManager().beginTransaction().replace(C2723R.C2726id.item_detail_container, ToBePaidSortActivity.this.tobepaidFilterFragment).commit();
                        ToBePaidSortActivity.this.adapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void resetFilters() {
        commonResetFilterOption();
        if (this.sortFragment.filterSelects != null) {
            for (int i = 0; i < this.sortFragment.filterSelects.size(); i++) {
                if (this.listType == Constants.LIST_TOBE_PAID) {
                    if (i == Constants.DEFAULT_SORT_OPTION_FOR_TOBEPAID) {
                        this.sortFragment.filterSelects.get(i).setSel_isSelected("true");
                    } else {
                        this.sortFragment.filterSelects.get(i).setSel_isSelected(PdfBoolean.FALSE);
                    }
                }
            }
            this.sortFragment.adapter.notifyDataSetChanged();
        }
        int i2 = Constants.DEFAULT_SORT_OPTION_FOR_TOBEPAID;
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
                        str = Constants.TO_BE_PAID_SRT_BIDDER;
                        break;
                    case 2:
                    case 3:
                        str = Constants.TO_BE_PAID_SRT_BRANCH;
                        break;
                    case 4:
                    case 5:
                        str = Constants.TO_BE_PAID_SRT_DUE;
                        break;
                    case 6:
                    case 7:
                        str = Constants.TO_BE_PAID_SRT_PRICE;
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