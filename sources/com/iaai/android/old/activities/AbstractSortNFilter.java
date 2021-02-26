package com.iaai.android.old.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.adapter.CustomOptionsAdapter;
import com.iaai.android.old.fragments.DateFilterFragment;
import com.iaai.android.old.fragments.LaneFilterFragment;
import com.iaai.android.old.fragments.SortFragment;
import com.iaai.android.old.fragments.ToBePaidBranchFilterFragment;
import com.iaai.android.old.models.FilterModel;
import com.iaai.android.old.models.FilterSelect;
import com.iaai.android.old.models.FilterSort;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.constants.Constants;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractSortNFilter extends AppCompatActivity implements SortFragment.OnSortFilterInteractionListener, LaneFilterFragment.OnLaneFilterInteractionListener, DateFilterFragment.OnDateInteractionListener, ToBePaidBranchFilterFragment.OnToBePaidBranchFilterInteractionListener {
    static int count;
    public CustomOptionsAdapter adapter;
    TextView btnApply;
    TextView btnLeaveFeedback;
    TextView btnReset;
    protected CoordinatorLayout coordinatorLayout;
    DateFilterFragment dateFilterFragment;
    protected FilterModel filterModel;
    FilterSort filterSort1;
    FilterSort filterSort2;
    FilterSort filterSort3;
    protected int initialLanePosition;
    protected int initialSortPosition;
    LaneFilterFragment laneFilterFragment;
    int listType;
    ListView listView;
    protected boolean mTwoPane;
    SortFragment sortFragment;
    ToBePaidBranchFilterFragment tobepaidFilterFragment;

    /* access modifiers changed from: package-private */
    public abstract void applyFilters();

    /* access modifiers changed from: package-private */
    public abstract void createFiltersNOptions();

    /* access modifiers changed from: package-private */
    public abstract void resetFilters();

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_item_list);
        overridePendingTransition(C2723R.anim.slide_up_new, C2723R.anim.no_change);
        Toolbar toolbar = (Toolbar) findViewById(C2723R.C2726id.toolbar);
        setSupportActionBar(toolbar);
        ((ImageButton) toolbar.findViewById(C2723R.C2726id.img_back)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                IaaiApplication.selectedSortPosition = AbstractSortNFilter.this.initialSortPosition;
                HashMap<String, String> hashMap = IaaiApplication.selectedFilters;
                hashMap.put("sort", "" + AbstractSortNFilter.this.initialSortPosition);
                AbstractSortNFilter.this.finish();
                AbstractSortNFilter.this.overridePendingTransition(C2723R.anim.no_change, C2723R.anim.slide_down_new);
            }
        });
        ((TextView) toolbar.findViewById(C2723R.C2726id.toolbar_header)).setText(getString(C2723R.string.lbl_menu_sort));
        ((ImageButton) toolbar.findViewById(C2723R.C2726id.btn_edit)).setVisibility(8);
        this.initialSortPosition = IaaiApplication.selectedSortPosition;
        this.initialLanePosition = IaaiApplication.selectedLanePosition;
        this.coordinatorLayout = (CoordinatorLayout) findViewById(C2723R.C2726id.coordinatorlayout);
        this.btnApply = (TextView) findViewById(C2723R.C2726id.bottom_btn_apply);
        this.btnReset = (TextView) findViewById(C2723R.C2726id.bottom_btn_reset);
        if (IaaiApplication.isFirstTimeForFilterDone) {
            this.btnReset.setEnabled(true);
        } else {
            this.btnReset.setEnabled(false);
        }
        this.btnApply.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AbstractSortNFilter.this.applyFilters();
            }
        });
        this.btnReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AbstractSortNFilter.this.resetFilters();
            }
        });
        this.listType = getIntent().getIntExtra(Constants.LISTING_TYPE, -1);
        this.btnLeaveFeedback = (TextView) findViewById(C2723R.C2726id.btn_leave_feedback);
        this.btnLeaveFeedback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AppUtils.showFeedBackDialog(view.getContext(), (IaaiApplication) AbstractSortNFilter.this.getApplication(), AbstractSortNFilter.this.coordinatorLayout, AbstractSortNFilter.this.listType);
            }
        });
        this.listView = (ListView) findViewById(C2723R.C2726id.item_list);
        this.filterModel = new FilterModel();
        this.filterModel.filterSorts = new ArrayList<>();
        if (findViewById(C2723R.C2726id.item_detail_container) != null) {
            this.mTwoPane = true;
        }
        createFiltersNOptions();
        ((LinearLayout) findViewById(C2723R.C2726id.layout_feedback)).setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public FilterSort createMainList(String str, int i, boolean z) {
        FilterSort filterSort = new FilterSort();
        filterSort.label = str;
        filterSort.filterResID = i;
        filterSort.isSelected = z;
        return filterSort;
    }

    /* access modifiers changed from: protected */
    public FilterSelect createSelectList(String str, boolean z, String str2) {
        FilterSelect filterSelect = new FilterSelect();
        filterSelect.sel_label = str;
        filterSelect.sel_isSelected = String.valueOf(z);
        filterSelect.setValue(str2);
        return filterSelect;
    }

    /* access modifiers changed from: protected */
    public FilterSelect createSelectListWithImage(String str, boolean z, String str2, int i) {
        FilterSelect filterSelect = new FilterSelect();
        filterSelect.sel_label = str;
        filterSelect.sel_isSelected = String.valueOf(z);
        filterSelect.setValue(str2);
        filterSelect.setResID(i);
        return filterSelect;
    }

    public void onSortInteraction(int i) {
        if (IaaiApplication.selectedSortPosition != i) {
            IaaiApplication.selectedSortPosition = i;
            this.btnReset.setEnabled(true);
            this.btnApply.setEnabled(true);
        }
    }

    public void onZIPCodeEnter() {
        this.btnReset.setEnabled(true);
        this.btnApply.setEnabled(true);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        IaaiApplication.isDateFragmentSelected = false;
        IaaiApplication.isLaneFragmentSelected = false;
        IaaiApplication.isToBePaidBranchFragmentSelected = false;
        IaaiApplication.isResetApplied = false;
    }

    public void onToBePaidBranchInteraction(int i) {
        if (IaaiApplication.selectedtobepaidbranchfilterPosition != i) {
            IaaiApplication.selectedtobepaidbranchfilterPosition = i;
            this.btnReset.setEnabled(true);
            this.btnApply.setEnabled(true);
            return;
        }
        this.btnReset.setEnabled(false);
        this.btnApply.setEnabled(false);
    }

    public void onLaneInteraction(int i) {
        if (IaaiApplication.selectedLanePosition != i) {
            IaaiApplication.selectedLanePosition = i;
            this.btnReset.setEnabled(true);
            this.btnApply.setEnabled(true);
            return;
        }
        this.btnReset.setEnabled(false);
        this.btnApply.setEnabled(false);
    }

    public void onDateInteraction() {
        if (IaaiApplication.isDateModified && IaaiApplication.isfromDateSelected) {
            this.btnReset.setEnabled(true);
            this.btnApply.setEnabled(true);
        } else if (IaaiApplication.isDateModified && IaaiApplication.isToDateSelected) {
            this.btnReset.setEnabled(true);
            this.btnApply.setEnabled(true);
        } else if (IaaiApplication.isfromDateSelected && IaaiApplication.isToDateSelected) {
            this.btnReset.setEnabled(true);
            this.btnApply.setEnabled(true);
        }
    }

    public void displayFirstDefaultSelectedFilter() {
        FilterSort filterSort = this.filterSort1;
        filterSort.isSelected = true;
        filterSort.filterResID = C2723R.C2725drawable.img_sort;
        this.sortFragment = new SortFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("arraylist", this.filterSort1.filterSelects);
        bundle.putInt(Constants.LISTING_TYPE, this.listType);
        this.sortFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(C2723R.C2726id.item_detail_container, this.sortFragment).commit();
        this.adapter.notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.initialSortPosition = IaaiApplication.selectedSortPosition;
    }

    /* access modifiers changed from: protected */
    public void commonResetFilterOption() {
        IaaiApplication.isResetApplied = true;
        IaaiApplication.isfromDateSelected = false;
        IaaiApplication.isToDateSelected = false;
        IaaiApplication.isLaneFilterSelected = false;
        IaaiApplication.isToBePaidBranchFragmentSelected = false;
        IaaiApplication.selectedFilters.clear();
        IaaiApplication.isFirstTimeForFilterDone = false;
    }
}
