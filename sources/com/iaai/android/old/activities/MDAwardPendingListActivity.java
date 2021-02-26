package com.iaai.android.old.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.activities.MDAbstractListActivity;
import com.iaai.android.old.models.ScopeDetail;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.UiUtils;
import java.util.ArrayList;
import java.util.Map;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class MDAwardPendingListActivity extends MDAbstractListActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* access modifiers changed from: package-private */
    public void handleFilterClick() {
        ArrayList arrayList = new ArrayList();
        if (this.scopeList != null) {
            for (int i = 0; i < this.scopeList.size(); i++) {
                arrayList.add(((ScopeDetail) this.scopeList.get(i)).name);
            }
        }
        Intent intent = new Intent(getApplicationContext(), AwardPendingSortActivity.class);
        intent.putExtra(Constants.LISTING_TYPE, getListType());
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public int getListType() {
        return Constants.LIST_AWARD_PENDING;
    }

    /* access modifiers changed from: protected */
    public void setRowUI(MDAbstractListActivity.SimpleItemRecyclerViewAdapter.ViewHolder viewHolder) {
        viewHolder.star_image.setVisibility(8);
        TextView textView = viewHolder.pre_sale_row_2;
        textView.setText(UiUtils.formatCurrencyFromString("" + viewHolder.mItem.bidamount, false) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getString(C2723R.string.award_pending) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + viewHolder.mItem.providerName);
        viewHolder.pre_sale_row_3_left.setVisibility(8);
        TextView textView2 = viewHolder.pre_sale_row_3_right;
        textView2.setText(this.sessionManager.getCurrentSessionFName() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.sessionManager.getCurrentSessionLName());
        if (viewHolder.mItem.biddername != null) {
            viewHolder.pre_sale_row_3_right.setText(viewHolder.mItem.biddername);
        } else {
            viewHolder.pre_sale_row_3_right.setText("");
        }
    }

    /* access modifiers changed from: protected */
    public void setMDListTitle() {
        if (this.list_count != 0) {
            IAASharedPreference.setMyAccountCount(this, Constants.KEY_FOR_AWARD_PENDING_COUNT_MYACCOUNT, this.list_count);
            ActionBar supportActionBar = getSupportActionBar();
            supportActionBar.setTitle((CharSequence) getTitle() + " (" + this.list_count + ")");
            return;
        }
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
        TextView textView = vHHeader.txttotalbidamount;
        textView.setText(UiUtils.formatCurrencyFromString("" + i, false));
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
                this.sortWithDirection = getString(C2723R.string.itemID);
                this.SORT_DIRECTION = 0;
                return str9;
            case 7:
                String str10 = str + " Descending";
                this.sortWithDirection = getString(C2723R.string.itemID);
                this.SORT_DIRECTION = 1;
                return str10;
            case 8:
                String str11 = str + " Ascending";
                this.sortWithDirection = getString(C2723R.string.lbl_srt_year_make_model);
                this.SORT_DIRECTION = 0;
                return str11;
            case 9:
                String str12 = str + " Descending";
                this.sortWithDirection = getString(C2723R.string.lbl_srt_year_make_model);
                this.SORT_DIRECTION = 1;
                return str12;
            default:
                this.sortWithDirection = getString(C2723R.string.lbl_srt_bid_amount);
                this.SORT_DIRECTION = 0;
                return "BidAmount Ascending";
        }
    }
}
