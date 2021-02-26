package com.iaai.android.old.activities;

import android.content.Intent;
import android.os.Bundle;
import com.iaai.android.C2723R;
import com.iaai.android.old.activities.MDAbstractListActivity;
import com.iaai.android.old.models.ScopeDetail;
import com.iaai.android.old.utils.constants.Constants;
import java.util.ArrayList;

public class MDWatchingListActivity extends MDAbstractListActivity {
    /* access modifiers changed from: protected */
    public void setDataToLeftViewOfListHeader(MDAbstractListActivity.SimpleItemRecyclerViewAdapter.VHHeader vHHeader, int i) {
    }

    /* access modifiers changed from: protected */
    public void setDefaultSortTitle(MDAbstractListActivity.SimpleItemRecyclerViewAdapter.VHHeader vHHeader, String str) {
    }

    /* access modifiers changed from: protected */
    public String setSortSelectionValue(int i, String str) {
        return null;
    }

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
        Intent intent = new Intent(getApplicationContext(), PreSaleSortActivity.class);
        intent.putExtra(Constants.LISTING_TYPE, getListType());
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public int getListType() {
        return Constants.LIST_WATCHING;
    }

    /* access modifiers changed from: protected */
    public void setRowUI(MDAbstractListActivity.SimpleItemRecyclerViewAdapter.ViewHolder viewHolder) {
        String str;
        String str2;
        if (viewHolder.mItem.lossType == null || viewHolder.mItem.lossType.isEmpty()) {
            str = viewHolder.mItem.primaryDamage;
        } else {
            str = viewHolder.mItem.lossType + "/" + viewHolder.mItem.primaryDamage;
        }
        viewHolder.pre_sale_row_2.setText(str);
        viewHolder.pre_sale_row_3_left.setVisibility(8);
        Integer valueOf = Integer.valueOf(viewHolder.mItem.odometerInt);
        if (valueOf.intValue() > 999) {
            str2 = (valueOf.intValue() / 1000) + "k mi ";
        } else {
            str2 = "0-1k mi ";
        }
        viewHolder.pre_sale_row_3_right.setText(str2);
        if (viewHolder.mItem.tBOInd == null || !viewHolder.mItem.tBOInd.booleanValue()) {
            viewHolder.titleNotYetAvailable.setVisibility(8);
        } else {
            viewHolder.titleNotYetAvailable.setVisibility(0);
        }
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
}
