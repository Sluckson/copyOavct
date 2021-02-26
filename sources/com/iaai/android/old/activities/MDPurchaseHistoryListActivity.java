package com.iaai.android.old.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.braintreepayments.api.models.PayPalRequest;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.activities.MDAbstractListActivity;
import com.iaai.android.old.models.ScopeDetail;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.UiUtils;
import java.util.ArrayList;
import java.util.Map;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class MDPurchaseHistoryListActivity extends MDAbstractListActivity {
    MDPurchaseHistoryListActivity activity;
    boolean isReceipt;
    String receipt_subject_line;
    String salvageID;

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
        if (this.wonSearchView != null) {
            if (!this.wonSearchView.isIconified()) {
                this.wonSearchView.setIconified(true);
            }
            this.wonSearchView.setFocusable(false);
        }
        Intent intent = new Intent(getApplicationContext(), WonHistorySortActivity.class);
        intent.putExtra(Constants.LISTING_TYPE, getListType());
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public int getListType() {
        return Constants.LIST_WON_HISTORY;
    }

    /* access modifiers changed from: protected */
    public void setRowUI(final MDAbstractListActivity.SimpleItemRecyclerViewAdapter.ViewHolder viewHolder) {
        viewHolder.star_image.setVisibility(8);
        if (viewHolder.pre_sale_row_2 != null) {
            TextView textView = viewHolder.pre_sale_row_2;
            textView.setText(UiUtils.formatCurrencyFromString("" + viewHolder.mItem.bidamount, true) + " | " + getString(C2723R.string.date_paid) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + viewHolder.mItem.datepaidstring);
        } else {
            viewHolder.pre_sale_row_2.setText("");
        }
        viewHolder.pre_sale_row_3_left.setVisibility(0);
        viewHolder.pre_sale_row_3_left_1.setVisibility(0);
        if (viewHolder.pre_sale_row_3_right == null) {
            viewHolder.pre_sale_row_3_right.setText("");
        } else if (!viewHolder.mItem.pickedupdatestring.equalsIgnoreCase("")) {
            TextView textView2 = viewHolder.pre_sale_row_3_right;
            textView2.setText(" | " + getString(C2723R.string.picked_up_date) + "" + viewHolder.mItem.pickedupdatestring);
        }
        final String str = viewHolder.mItem.receiptNo;
        this.receipt_subject_line = viewHolder.mItem.receiptDescription;
        viewHolder.pre_sale_row_3_left.setText(" Stock");
        viewHolder.pre_sale_row_3_left_1.setText(" Receipt");
        viewHolder.pre_sale_row_3_left.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MDPurchaseHistoryListActivity mDPurchaseHistoryListActivity = MDPurchaseHistoryListActivity.this;
                mDPurchaseHistoryListActivity.receipt_no = str;
                mDPurchaseHistoryListActivity.isReceipt = false;
                mDPurchaseHistoryListActivity.salvageID = viewHolder.mItem.salvage_Id;
                MDPurchaseHistoryListActivity mDPurchaseHistoryListActivity2 = MDPurchaseHistoryListActivity.this;
                mDPurchaseHistoryListActivity2.checkWriteStoragePermission(mDPurchaseHistoryListActivity2.receipt_subject_line);
            }
        });
        viewHolder.pre_sale_row_3_left_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MDPurchaseHistoryListActivity mDPurchaseHistoryListActivity = MDPurchaseHistoryListActivity.this;
                mDPurchaseHistoryListActivity.receipt_no = str;
                mDPurchaseHistoryListActivity.isReceipt = true;
                mDPurchaseHistoryListActivity.salvageID = viewHolder.mItem.salvage_Id;
                MDPurchaseHistoryListActivity mDPurchaseHistoryListActivity2 = MDPurchaseHistoryListActivity.this;
                mDPurchaseHistoryListActivity2.checkWriteStoragePermission(mDPurchaseHistoryListActivity2.receipt_subject_line);
            }
        });
    }

    private void navigateToReceiptPage(String str) {
        Intent intent = new Intent(this, AFCTermsPage.class);
        intent.putExtra("receipt_url", getString(C2723R.string.service_path_get_vehicle__new_receipt, new Object[]{this.receipt_no, this.isReceipt ? PayPalRequest.INTENT_ORDER : "stock", this.salvageID}));
        intent.putExtra("receipt_email_subject_line", str);
        intent.putExtra("pdf_receipt", true);
        intent.putExtra("report_title", this.receipt_no);
        intent.putExtra("asap_salvage_id", this.salvageID);
        intent.putExtra("receipt_type", this.isReceipt);
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public void checkWriteStoragePermission(String str) {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3);
        } else {
            navigateToReceiptPage(str);
        }
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i != 3) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            AppUtils.showEnablePermissionMessage(true, this, (Fragment) null, "android.permission.WRITE_EXTERNAL_STORAGE", 3);
        } else {
            navigateToReceiptPage(this.receipt_subject_line);
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

    /* access modifiers changed from: protected */
    public void setDataToLeftViewOfListHeader(MDAbstractListActivity.SimpleItemRecyclerViewAdapter.VHHeader vHHeader, int i) {
        vHHeader.layout_total.setVisibility(0);
        vHHeader.labletotalpending.setText(getString(C2723R.string.header_mdwon_history));
    }

    /* access modifiers changed from: protected */
    public void setDefaultSortTitle(MDAbstractListActivity.SimpleItemRecyclerViewAdapter.VHHeader vHHeader, String str) {
        if (str.equals("")) {
            TextView textView = vHHeader.txtTitle;
            textView.setText(getString(C2723R.string.lbl_srt_date_paid) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            vHHeader.txtTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getResources().getDrawable(C2723R.C2725drawable.ic_sort_num_desc_blue), (Drawable) null);
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
                this.sortWithDirection = getString(C2723R.string.lbl_srt_branch);
                this.SORT_DIRECTION = 0;
                return str3;
            case 1:
                String str4 = str + " Descending";
                this.sortWithDirection = getString(C2723R.string.lbl_srt_branch);
                this.SORT_DIRECTION = 1;
                return str4;
            case 2:
                String str5 = str + " Ascending";
                this.sortWithDirection = getString(C2723R.string.lbl_srt_date_paid);
                this.SORT_DIRECTION = 0;
                return str5;
            case 3:
                String str6 = str + " Descending";
                this.sortWithDirection = getString(C2723R.string.lbl_srt_date_paid);
                this.SORT_DIRECTION = 1;
                return str6;
            case 4:
                String str7 = str + " Ascending";
                this.sortWithDirection = getString(C2723R.string.headerDefaultSortAuction);
                this.SORT_DIRECTION = 0;
                return str7;
            case 5:
                String str8 = str + " Descending";
                this.sortWithDirection = getString(C2723R.string.lbl_sort_by_make_desc);
                this.SORT_DIRECTION = 1;
                return str8;
            case 6:
                String str9 = str + " Ascending";
                this.sortWithDirection = getString(C2723R.string.year);
                this.SORT_DIRECTION = 0;
                return str9;
            case 7:
                String str10 = str + " Descending";
                this.sortWithDirection = getString(C2723R.string.year);
                this.SORT_DIRECTION = 1;
                return str10;
            default:
                String str11 = str + "Descending";
                this.sortWithDirection = getString(C2723R.string.lbl_srt_date_paid);
                this.SORT_DIRECTION = 1;
                return str11;
        }
    }
}
