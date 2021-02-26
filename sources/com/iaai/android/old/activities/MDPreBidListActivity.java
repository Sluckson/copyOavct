package com.iaai.android.old.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.iaai.android.C2723R;
import com.iaai.android.old.activities.MDAbstractListActivity;
import com.iaai.android.old.models.ScopeDetail;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MDPreBidListActivity extends MDAbstractListActivity {
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
        return Constants.LIST_PREBID;
    }

    /* access modifiers changed from: protected */
    public void setRowUI(MDAbstractListActivity.SimpleItemRecyclerViewAdapter.ViewHolder viewHolder) {
        String format = (viewHolder.mItem.currentHighAmount == null || viewHolder.mItem.currentHighAmount.intValue() == 0) ? "" : new DecimalFormat("$##,###,###.##").format(viewHolder.mItem.currentHighAmount);
        if (viewHolder.mItem.prebidStatusColor.contains("Green")) {
            TextView textView = viewHolder.pre_sale_row_2;
            textView.setText(format + " (" + viewHolder.mItem.prebidStatus + ")");
            viewHolder.pre_sale_row_2.setTextColor(getResources().getColor(C2723R.C2724color.auction_winning));
        } else if (viewHolder.mItem.prebidStatusColor.contains("Red")) {
            TextView textView2 = viewHolder.pre_sale_row_2;
            textView2.setText(format + " (" + viewHolder.mItem.prebidStatus + ")");
            viewHolder.pre_sale_row_2.setTextColor(getResources().getColor(C2723R.C2724color.auction_losing));
        }
        viewHolder.pre_sale_row_3_left.setVisibility(8);
        viewHolder.pre_sale_row_3_right.setText(viewHolder.mItem.biddername);
        if (viewHolder.mItem.tBOInd == null || !viewHolder.mItem.tBOInd.booleanValue()) {
            viewHolder.titleNotYetAvailable.setVisibility(8);
        } else {
            viewHolder.titleNotYetAvailable.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public void setMDListTitle() {
        if (this.list_count != 0) {
            IAASharedPreference.setMyAccountCount(this, Constants.KEY_FOR_PREBID_COUNT_MYACCOUNT, this.list_count);
            ActionBar supportActionBar = getSupportActionBar();
            supportActionBar.setTitle((CharSequence) getString(C2723R.string.lbl_prebid) + " (" + this.list_count + ")");
            return;
        }
        getSupportActionBar().setTitle((CharSequence) getString(C2723R.string.lbl_prebid));
    }

    public void setMDProductDetailTitle() {
        getSupportActionBar().setTitle((int) C2723R.string.vehicle_detail_title);
    }

    public void setMDYearMakeModelTitle() {
        getSupportActionBar().setTitle((CharSequence) this.year_make_model_se);
    }
}
