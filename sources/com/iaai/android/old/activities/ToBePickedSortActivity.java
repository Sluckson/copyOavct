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

public class ToBePickedSortActivity extends AbstractSortNFilter {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* access modifiers changed from: package-private */
    public void createFiltersNOptions() {
        this.filterSort1 = createMainList(getString(C2723R.string.lbl_menu_sort), C2723R.C2725drawable.img_sort_black, false);
        FilterSelect createSelectListWithImage = createSelectListWithImage(getString(C2723R.string.filter_option_action_due), false, getString(C2723R.string.filter_option_action_due), C2723R.C2725drawable.icon_sort_num_asc);
        FilterSelect createSelectListWithImage2 = createSelectListWithImage(getString(C2723R.string.filter_option_action_due), false, getString(C2723R.string.filter_option_action_due), C2723R.C2725drawable.icon_sort_num_desc);
        FilterSelect createSelectListWithImage3 = createSelectListWithImage(getString(C2723R.string.lbl_srt_branch), false, getString(C2723R.string.lbl_srt_branch), C2723R.C2725drawable.icon_sort_alpha_asc);
        FilterSelect createSelectListWithImage4 = createSelectListWithImage(getString(C2723R.string.lbl_srt_branch), false, getString(C2723R.string.lbl_srt_branch), C2723R.C2725drawable.icon_sort_alpha_desc);
        this.filterSort1.filterSelects = new ArrayList<>();
        this.filterSort1.filterSelects.add(createSelectListWithImage3);
        this.filterSort1.filterSelects.add(createSelectListWithImage4);
        this.filterSort1.filterSelects.add(createSelectListWithImage);
        this.filterSort1.filterSelects.add(createSelectListWithImage2);
        this.filterModel.filterSorts.add(this.filterSort1);
        this.adapter = new CustomOptionsAdapter(getApplicationContext(), this.filterModel.filterSorts);
        this.listView.setAdapter(this.adapter);
        displayFirstDefaultSelectedFilter();
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (ToBePickedSortActivity.this.mTwoPane) {
                    Bundle bundle = new Bundle();
                    if (i == 0) {
                        ToBePickedSortActivity.this.filterSort1.isSelected = true;
                        ToBePickedSortActivity.this.filterSort1.filterResID = C2723R.C2725drawable.img_sort;
                        bundle.putParcelableArrayList("arraylist", ToBePickedSortActivity.this.filterSort1.filterSelects);
                        bundle.putInt(Constants.LISTING_TYPE, ToBePickedSortActivity.this.listType);
                        ToBePickedSortActivity.this.sortFragment.getArguments().putAll(bundle);
                        ToBePickedSortActivity.this.getSupportFragmentManager().beginTransaction().replace(C2723R.C2726id.item_detail_container, ToBePickedSortActivity.this.sortFragment).commit();
                        ToBePickedSortActivity.this.adapter.notifyDataSetChanged();
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
                if (i == Constants.DEFAULT_SORT_OPTION_FOR_POSTSALE) {
                    this.sortFragment.filterSelects.get(i).setSel_isSelected("true");
                } else {
                    this.sortFragment.filterSelects.get(i).setSel_isSelected(PdfBoolean.FALSE);
                }
            }
            this.sortFragment.adapter.notifyDataSetChanged();
        }
        int i2 = Constants.DEFAULT_SORT_OPTION_FOR_POSTSALE;
        IaaiApplication.selectedSortPosition = i2;
        this.initialSortPosition = i2;
        applyFilters();
    }

    /* access modifiers changed from: package-private */
    public void applyFilters() {
        String str;
        int i = 0;
        while (true) {
            str = "ActionDue";
            if (i >= this.sortFragment.filterSelects.size()) {
                break;
            } else if (!this.sortFragment.filterSelects.get(i).getSel_isSelected().equalsIgnoreCase("true")) {
                i++;
            } else if (i == 0 || i == 1) {
                str = Constants.TO_BE_PAID_SRT_BRANCH;
            } else if (i != 2) {
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