package com.iaai.android.old.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.activities.MDAbstractListActivity;
import com.iaai.android.old.models.ScopeDetail;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.UiUtils;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class MDLostPreBidListActivity extends MDAbstractListActivity {
    MDLostPreBidListActivity activity;
    Bundle bundle;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle2) {
        this.bundle = getIntent().getExtras();
        super.onCreate(bundle2);
    }

    /* access modifiers changed from: package-private */
    public void handleFilterClick() {
        ArrayList arrayList = new ArrayList();
        if (this.scopeList != null) {
            for (int i = 0; i < this.scopeList.size(); i++) {
                arrayList.add(((ScopeDetail) this.scopeList.get(i)).name);
            }
        }
        Intent intent = new Intent(getApplicationContext(), LostPreBidSortActivity.class);
        intent.putExtra(Constants.LISTING_TYPE, getListType());
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public int getListType() {
        return Constants.LIST_LOST_PREBID;
    }

    /* access modifiers changed from: protected */
    public void setRowUI(MDAbstractListActivity.SimpleItemRecyclerViewAdapter.ViewHolder viewHolder) {
        viewHolder.star_image.setVisibility(8);
        String language = Locale.getDefault().getLanguage();
        if (language.equals("en")) {
            TextView textView = viewHolder.pre_sale_row_2;
            StringBuilder sb = new StringBuilder();
            sb.append(viewHolder.mItem.biddername);
            sb.append("'s ");
            sb.append(getString(C2723R.string.lbl_lost_bid));
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb.append(UiUtils.formatCurrencyFromString("" + viewHolder.mItem.bidamount, false));
            textView.setText(sb.toString());
        } else if (language.equals(Constants_MVVM.EXTRA_SPANISH_CODE)) {
            TextView textView2 = viewHolder.pre_sale_row_2;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getString(C2723R.string.lbl_lost_bid));
            sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb2.append(viewHolder.mItem.biddername);
            sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb2.append(UiUtils.formatCurrencyFromString("" + viewHolder.mItem.bidamount, false));
            textView2.setText(sb2.toString());
        }
        viewHolder.pre_sale_row_3_left.setVisibility(8);
        TextView textView3 = viewHolder.pre_sale_row_3_right;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(getString(C2723R.string.winning_bid));
        sb3.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb3.append(UiUtils.formatCurrencyFromString("" + viewHolder.mItem.win_amount, false));
        textView3.setText(sb3.toString());
    }

    /* access modifiers changed from: protected */
    public void setMDListTitle() {
        getSupportActionBar().setTitle(getTitle());
    }

    public void setMDProductDetailTitle() {
        getSupportActionBar().setTitle((int) C2723R.string.vehicle_detail_title);
    }

    public void setMDYearMakeModelTitle() {
        getSupportActionBar().setTitle((CharSequence) this.year_make_model_se);
    }

    /* access modifiers changed from: protected */
    public void setDataToLeftViewOfListHeader(MDAbstractListActivity.SimpleItemRecyclerViewAdapter.VHHeader vHHeader, int i) {
        vHHeader.layout_total.setVisibility(0);
        vHHeader.labletotalpending.setText(getString(C2723R.string.header_mdlost_prebid));
    }

    /* access modifiers changed from: protected */
    public void setDefaultSortTitle(MDAbstractListActivity.SimpleItemRecyclerViewAdapter.VHHeader vHHeader, String str) {
        if (str.equals("")) {
            TextView textView = vHHeader.txtTitle;
            textView.setText(getString(C2723R.string.lbl_srt_bid_amount) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            return;
        }
        TextView textView2 = vHHeader.txtTitle;
        textView2.setText(str + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
    }

    /* access modifiers changed from: protected */
    public String setSortSelectionValue(int i, String str) {
        this.sortWithDirection = str;
        for (Map.Entry next : IaaiApplication.selectedFilters.entrySet()) {
            if (next.getKey().equals("laneValue")) {
                this.laneName = (String) next.getValue();
            }
            if (next.getKey().equals("sort")) {
                Integer.parseInt((String) next.getValue());
            }
            if (next.getKey().equals("sortValue")) {
                String str2 = (String) next.getValue();
                if (str2.indexOf(32) != -1) {
                    str2.substring(0, str2.indexOf(32));
                }
            }
        }
        switch (i) {
            case 0:
                String str3 = str + " Ascending";
                this.sortWithDirection = getString(C2723R.string.lbl_srt_bid_amount);
                this.SORT_DIRECTION = 0;
                return str3;
            case 1:
                String str4 = str + " Descending";
                this.sortWithDirection = getString(C2723R.string.lbl_srt_bid_amount);
                this.SORT_DIRECTION = 1;
                return str4;
            case 2:
                String str5 = str + " Ascending";
                this.sortWithDirection = getString(C2723R.string.lbl_srt_bidder);
                this.SORT_DIRECTION = 0;
                return str5;
            case 3:
                String str6 = str + " Descending";
                this.sortWithDirection = getString(C2723R.string.lbl_srt_bidder);
                this.SORT_DIRECTION = 1;
                return str6;
            case 4:
                String str7 = str + " Ascending";
                this.sortWithDirection = getString(C2723R.string.lbl_srt_branch);
                this.SORT_DIRECTION = 0;
                return str7;
            case 5:
                String str8 = str + " Descending";
                this.sortWithDirection = getString(C2723R.string.lbl_srt_branch);
                this.SORT_DIRECTION = 1;
                return str8;
            case 6:
                String str9 = str + " Ascending";
                this.sortWithDirection = getString(C2723R.string.headerDefaultSortAuction);
                this.SORT_DIRECTION = 0;
                return str9;
            case 7:
                String str10 = str + " Descending";
                this.sortWithDirection = getString(C2723R.string.lbl_sort_by_make_desc);
                this.SORT_DIRECTION = 1;
                return str10;
            case 8:
                String str11 = str + " Ascending";
                this.sortWithDirection = getString(C2723R.string.year);
                this.SORT_DIRECTION = 0;
                return str11;
            case 9:
                String str12 = str + " Descending";
                this.sortWithDirection = getString(C2723R.string.year);
                this.SORT_DIRECTION = 1;
                return str12;
            default:
                String str13 = str + " Ascending";
                this.sortWithDirection = getString(C2723R.string.lbl_srt_bid_amount);
                this.SORT_DIRECTION = 0;
                return str13;
        }
    }
}
