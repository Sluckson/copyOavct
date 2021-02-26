package com.iaai.android.old.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.adapter.CustomOptionsAdapter;
import com.iaai.android.old.fragments.DateFilterFragment;
import com.iaai.android.old.fragments.LaneFilterFragment;
import com.iaai.android.old.fragments.SortFragment;
import com.iaai.android.old.models.FilterModel;
import com.iaai.android.old.models.FilterSelect;
import com.iaai.android.old.models.FilterSort;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.constants.Constants;
import com.lowagie.text.pdf.PdfBoolean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SortNFilterActivity extends AppCompatActivity implements SortFragment.OnSortFilterInteractionListener, LaneFilterFragment.OnLaneFilterInteractionListener, DateFilterFragment.OnDateInteractionListener {
    static int count;
    public CustomOptionsAdapter adapter;
    TextView btnApply;
    TextView btnLeaveFeedback;
    TextView btnReset;
    /* access modifiers changed from: private */
    public CoordinatorLayout coordinatorLayout;
    DateFilterFragment dateFilterFragment;
    FilterSort filterSort1;
    FilterSort filterSort2;
    FilterSort filterSort3;
    private int initialLanePosition;
    private int initialSortPosition;
    LaneFilterFragment laneFilterFragment;
    int listType;
    ListView listView;
    /* access modifiers changed from: private */
    public boolean mTwoPane;
    SortFragment sortFragment;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_item_list);
        overridePendingTransition(C2723R.anim.abc_slide_in_bottom, C2723R.anim.no_change);
        this.initialSortPosition = IaaiApplication.selectedSortPosition;
        this.initialLanePosition = IaaiApplication.selectedLanePosition;
        this.coordinatorLayout = (CoordinatorLayout) findViewById(C2723R.C2726id.coordinatorlayout);
        Toolbar toolbar = (Toolbar) findViewById(C2723R.C2726id.toolbar);
        setSupportActionBar(toolbar);
        ((ImageButton) toolbar.findViewById(C2723R.C2726id.img_back)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SortNFilterActivity.this.finish();
                SortNFilterActivity.this.overridePendingTransition(C2723R.anim.no_change, C2723R.anim.slide_down_new);
            }
        });
        ((TextView) toolbar.findViewById(C2723R.C2726id.toolbar_header)).setText(getString(C2723R.string.lbl_menu_sort));
        ((ImageButton) toolbar.findViewById(C2723R.C2726id.btn_edit)).setVisibility(8);
        this.btnApply = (TextView) findViewById(C2723R.C2726id.bottom_btn_apply);
        this.btnReset = (TextView) findViewById(C2723R.C2726id.bottom_btn_reset);
        if (IaaiApplication.isFirstTimeForFilterDone) {
            this.btnReset.setEnabled(true);
        } else {
            this.btnReset.setEnabled(false);
        }
        this.btnApply.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SortNFilterActivity.this.applyFilters();
            }
        });
        this.btnReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SortNFilterActivity.this.resetFilters();
            }
        });
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("lanes");
        this.listType = getIntent().getIntExtra(Constants.LISTING_TYPE, -1);
        this.btnLeaveFeedback = (TextView) findViewById(C2723R.C2726id.btn_leave_feedback);
        this.btnLeaveFeedback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AppUtils.showFeedBackDialog(view.getContext(), (IaaiApplication) SortNFilterActivity.this.getApplication(), SortNFilterActivity.this.coordinatorLayout, SortNFilterActivity.this.listType);
            }
        });
        ((LinearLayout) findViewById(C2723R.C2726id.layout_feedback)).setVisibility(8);
        this.listView = (ListView) findViewById(C2723R.C2726id.item_list);
        FilterModel filterModel = new FilterModel();
        filterModel.filterSorts = new ArrayList<>();
        if (this.listType == Constants.LIST_WATCHING || this.listType == Constants.LIST_PREBID) {
            this.filterSort1 = createMainList(getString(C2723R.string.lbl_menu_sort), C2723R.C2725drawable.img_sort_black, false);
            FilterSelect createSelectList = createSelectList(getString(C2723R.string.headerDefaultSortAuction), false, getString(C2723R.string.headerDefaultSortAuction));
            FilterSelect createSelectList2 = createSelectList(getString(C2723R.string.lbl_sort_by_make_desc), false, getString(C2723R.string.lbl_sort_by_make_desc));
            FilterSelect createSelectList3 = createSelectList(getString(C2723R.string.odo_meter) + " ↑ ", false, getString(C2723R.string.odo_meter));
            FilterSelect createSelectList4 = createSelectList(getString(C2723R.string.odo_meter) + " ↓ ", false, getString(C2723R.string.odo_meter));
            FilterSelect createSelectList5 = createSelectList(getString(C2723R.string.lbl_Auction_Date) + " ↑ ", false, getString(C2723R.string.lbl_Auction_Date));
            FilterSelect createSelectList6 = createSelectList(getString(C2723R.string.lbl_Auction_Date) + " ↓ ", false, getString(C2723R.string.lbl_Auction_Date));
            FilterSelect createSelectList7 = createSelectList(getString(C2723R.string.year) + " ↑ ", false, getString(C2723R.string.year));
            FilterSelect createSelectList8 = createSelectList(getString(C2723R.string.year) + " ↓ ", false, getString(C2723R.string.year));
            this.filterSort1.filterSelects = new ArrayList<>();
            this.filterSort1.filterSelects.add(createSelectList);
            this.filterSort1.filterSelects.add(createSelectList2);
            this.filterSort1.filterSelects.add(createSelectList3);
            this.filterSort1.filterSelects.add(createSelectList4);
            this.filterSort1.filterSelects.add(createSelectList5);
            this.filterSort1.filterSelects.add(createSelectList6);
            this.filterSort1.filterSelects.add(createSelectList7);
            this.filterSort1.filterSelects.add(createSelectList8);
            filterModel.filterSorts.add(this.filterSort1);
            if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                this.filterSort3 = createMainList(getString(C2723R.string.lbl_lane), C2723R.C2725drawable.img_lane_black, false);
                this.filterSort3.filterSelects = new ArrayList<>();
                Iterator<String> it = stringArrayListExtra.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    this.filterSort3.filterSelects.add(createSelectList(next, false, next));
                }
                filterModel.filterSorts.add(this.filterSort3);
            }
        } else if (this.listType == Constants.LIST_AWARD_PENDING) {
            this.filterSort1 = createMainList(getString(C2723R.string.lbl_menu_sort), C2723R.C2725drawable.img_sort_black, false);
            FilterSelect createSelectList9 = createSelectList(getString(C2723R.string.lbl_srt_bid_amount) + " ↑ ", false, getString(C2723R.string.lbl_srt_bid_amount));
            FilterSelect createSelectList10 = createSelectList(getString(C2723R.string.lbl_srt_bid_amount) + " ↓ ", false, getString(C2723R.string.lbl_srt_bid_amount));
            FilterSelect createSelectList11 = createSelectList(getString(C2723R.string.lbl_srt_branch) + " ↑ ", false, getString(C2723R.string.lbl_srt_branch));
            FilterSelect createSelectList12 = createSelectList(getString(C2723R.string.lbl_srt_branch) + " ↓ ", false, getString(C2723R.string.lbl_srt_branch));
            FilterSelect createSelectList13 = createSelectList(getString(C2723R.string.itemID) + " ↑ ", false, getString(C2723R.string.itemID));
            FilterSelect createSelectList14 = createSelectList(getString(C2723R.string.itemID) + " ↓ ", false, getString(C2723R.string.itemID));
            FilterSelect createSelectList15 = createSelectList(getString(C2723R.string.lbl_srt_year_make_model) + " ↑ ", false, getString(C2723R.string.lbl_srt_year_make_model));
            FilterSelect createSelectList16 = createSelectList(getString(C2723R.string.lbl_srt_year_make_model) + " ↓ ", false, getString(C2723R.string.lbl_srt_year_make_model));
            FilterSelect createSelectList17 = createSelectList(getString(C2723R.string.lbl_srt_bidder) + " ↑ ", false, getString(C2723R.string.lbl_srt_bidder));
            FilterSelect createSelectList18 = createSelectList(getString(C2723R.string.lbl_srt_bidder) + " ↓ ", false, getString(C2723R.string.lbl_srt_bidder));
            this.filterSort1.filterSelects = new ArrayList<>();
            this.filterSort1.filterSelects.add(createSelectList9);
            this.filterSort1.filterSelects.add(createSelectList10);
            this.filterSort1.filterSelects.add(createSelectList11);
            this.filterSort1.filterSelects.add(createSelectList12);
            this.filterSort1.filterSelects.add(createSelectList13);
            this.filterSort1.filterSelects.add(createSelectList14);
            this.filterSort1.filterSelects.add(createSelectList15);
            this.filterSort1.filterSelects.add(createSelectList16);
            this.filterSort1.filterSelects.add(createSelectList17);
            this.filterSort1.filterSelects.add(createSelectList18);
            filterModel.filterSorts.add(this.filterSort1);
            if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                this.filterSort3 = createMainList(getString(C2723R.string.lbl_lane), C2723R.C2725drawable.img_lane_black, false);
                this.filterSort3.filterSelects = new ArrayList<>();
                Iterator<String> it2 = stringArrayListExtra.iterator();
                while (it2.hasNext()) {
                    String next2 = it2.next();
                    this.filterSort3.filterSelects.add(createSelectList(next2, false, next2));
                }
                filterModel.filterSorts.add(this.filterSort3);
            }
        } else if (this.listType == Constants.LIST_AUCTION_SALES) {
            this.filterSort1 = createMainList(getString(C2723R.string.lbl_menu_sort), C2723R.C2725drawable.img_sort_black, false);
            FilterSelect createSelectListWithImage = createSelectListWithImage(getString(C2723R.string.lbl_lane), false, getString(C2723R.string.lbl_lane), C2723R.C2725drawable.icon_sort_alpha_asc);
            FilterSelect createSelectListWithImage2 = createSelectListWithImage(getString(C2723R.string.lbl_lane), false, getString(C2723R.string.lbl_lane), C2723R.C2725drawable.icon_sort_alpha_desc);
            FilterSelect createSelectListWithImage3 = createSelectListWithImage(getString(C2723R.string.itemID), false, getString(C2723R.string.itemID), C2723R.C2725drawable.icon_sort_num_asc);
            FilterSelect createSelectListWithImage4 = createSelectListWithImage(getString(C2723R.string.itemID), false, getString(C2723R.string.itemID), C2723R.C2725drawable.icon_sort_num_desc);
            FilterSelect createSelectListWithImage5 = createSelectListWithImage(getString(C2723R.string.lbl_make), false, getString(C2723R.string.headerDefaultSortAuction), C2723R.C2725drawable.icon_sort_alpha_asc);
            FilterSelect createSelectListWithImage6 = createSelectListWithImage(getString(C2723R.string.lbl_make), false, getString(C2723R.string.lbl_sort_by_make_desc), C2723R.C2725drawable.icon_sort_alpha_desc);
            FilterSelect createSelectListWithImage7 = createSelectListWithImage(getString(C2723R.string.odo_meter), false, getString(C2723R.string.odo_meter), C2723R.C2725drawable.icon_sort_num_asc);
            FilterSelect createSelectListWithImage8 = createSelectListWithImage(getString(C2723R.string.odo_meter), false, getString(C2723R.string.odo_meter), C2723R.C2725drawable.icon_sort_num_desc);
            FilterSelect createSelectListWithImage9 = createSelectListWithImage(getString(C2723R.string.year), false, getString(C2723R.string.year), C2723R.C2725drawable.icon_sort_num_asc);
            FilterSelect createSelectListWithImage10 = createSelectListWithImage(getString(C2723R.string.year), false, getString(C2723R.string.year), C2723R.C2725drawable.icon_sort_num_desc);
            this.filterSort1.filterSelects = new ArrayList<>();
            this.filterSort1.filterSelects.add(createSelectListWithImage3);
            this.filterSort1.filterSelects.add(createSelectListWithImage4);
            this.filterSort1.filterSelects.add(createSelectListWithImage);
            this.filterSort1.filterSelects.add(createSelectListWithImage2);
            this.filterSort1.filterSelects.add(createSelectListWithImage5);
            this.filterSort1.filterSelects.add(createSelectListWithImage6);
            this.filterSort1.filterSelects.add(createSelectListWithImage7);
            this.filterSort1.filterSelects.add(createSelectListWithImage8);
            this.filterSort1.filterSelects.add(createSelectListWithImage9);
            this.filterSort1.filterSelects.add(createSelectListWithImage10);
            filterModel.filterSorts.add(this.filterSort1);
            this.filterSort2 = createMainList(getString(C2723R.string.year), C2723R.C2725drawable.img_year_black, false);
            FilterSelect createSelectList19 = createSelectList("ToYear", false, "");
            FilterSelect createSelectList20 = createSelectList("FromYear", false, "");
            this.filterSort2.filterSelects = new ArrayList<>();
            this.filterSort2.filterSelects.add(createSelectList19);
            this.filterSort2.filterSelects.add(createSelectList20);
            filterModel.filterSorts.add(this.filterSort2);
            this.filterSort3 = createMainList(getString(C2723R.string.lbl_lane), C2723R.C2725drawable.img_lane_black, false);
            this.filterSort3.filterSelects = new ArrayList<>();
            if (stringArrayListExtra != null) {
                Iterator<String> it3 = stringArrayListExtra.iterator();
                while (it3.hasNext()) {
                    String next3 = it3.next();
                    this.filterSort3.filterSelects.add(createSelectList(next3, false, next3));
                }
            }
            filterModel.filterSorts.add(this.filterSort3);
        }
        this.adapter = new CustomOptionsAdapter(getApplicationContext(), filterModel.filterSorts);
        this.listView.setAdapter(this.adapter);
        displayFirstDefaultSelectedFilter();
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (SortNFilterActivity.this.mTwoPane) {
                    Bundle bundle = new Bundle();
                    if (i == 0) {
                        SortNFilterActivity.this.filterSort1.isSelected = true;
                        SortNFilterActivity.this.filterSort1.filterResID = C2723R.C2725drawable.img_sort;
                        if (SortNFilterActivity.this.filterSort2 != null) {
                            SortNFilterActivity.this.filterSort2.isSelected = false;
                            SortNFilterActivity.this.filterSort2.filterResID = C2723R.C2725drawable.img_year_black;
                        }
                        if (SortNFilterActivity.this.filterSort3 != null) {
                            SortNFilterActivity.this.filterSort3.isSelected = false;
                            SortNFilterActivity.this.filterSort3.filterResID = C2723R.C2725drawable.img_lane_black;
                        }
                        bundle.putParcelableArrayList("arraylist", SortNFilterActivity.this.filterSort1.filterSelects);
                        bundle.putInt(Constants.LISTING_TYPE, SortNFilterActivity.this.listType);
                        SortNFilterActivity.this.sortFragment.getArguments().putAll(bundle);
                        SortNFilterActivity.this.getSupportFragmentManager().beginTransaction().replace(C2723R.C2726id.item_detail_container, SortNFilterActivity.this.sortFragment).commit();
                        SortNFilterActivity.this.adapter.notifyDataSetChanged();
                    } else if (i == 1) {
                        SortNFilterActivity.this.dateFilterFragment = new DateFilterFragment();
                        SortNFilterActivity.this.filterSort2.isSelected = true;
                        SortNFilterActivity.this.filterSort2.filterResID = C2723R.C2725drawable.img_year;
                        SortNFilterActivity.this.filterSort1.isSelected = false;
                        SortNFilterActivity.this.filterSort1.filterResID = C2723R.C2725drawable.img_sort_black;
                        if (SortNFilterActivity.this.filterSort3 != null) {
                            SortNFilterActivity.this.filterSort3.isSelected = false;
                            SortNFilterActivity.this.filterSort3.filterResID = C2723R.C2725drawable.img_lane_black;
                        }
                        bundle.putParcelableArrayList("arraylist", SortNFilterActivity.this.filterSort2.filterSelects);
                        SortNFilterActivity.this.dateFilterFragment.setArguments(bundle);
                        SortNFilterActivity.this.getSupportFragmentManager().beginTransaction().replace(C2723R.C2726id.item_detail_container, SortNFilterActivity.this.dateFilterFragment).commit();
                        SortNFilterActivity.this.adapter.notifyDataSetChanged();
                    } else if (i == 2) {
                        SortNFilterActivity.this.laneFilterFragment = new LaneFilterFragment();
                        SortNFilterActivity.this.filterSort3.isSelected = true;
                        SortNFilterActivity.this.filterSort3.filterResID = C2723R.C2725drawable.img_lane;
                        SortNFilterActivity.this.filterSort1.isSelected = false;
                        SortNFilterActivity.this.filterSort1.filterResID = C2723R.C2725drawable.img_sort_black;
                        SortNFilterActivity.this.filterSort2.isSelected = false;
                        SortNFilterActivity.this.filterSort2.filterResID = C2723R.C2725drawable.img_year_black;
                        bundle.putParcelableArrayList("arraylist", SortNFilterActivity.this.filterSort3.filterSelects);
                        SortNFilterActivity.this.laneFilterFragment.setArguments(bundle);
                        SortNFilterActivity.this.getSupportFragmentManager().beginTransaction().replace(C2723R.C2726id.item_detail_container, SortNFilterActivity.this.laneFilterFragment).commit();
                        SortNFilterActivity.this.adapter.notifyDataSetChanged();
                    }
                }
            }
        });
        if (findViewById(C2723R.C2726id.item_detail_container) != null) {
            this.mTwoPane = true;
        }
    }

    private FilterSort createMainList(String str, int i, boolean z) {
        FilterSort filterSort = new FilterSort();
        filterSort.label = str;
        filterSort.filterResID = i;
        filterSort.isSelected = z;
        return filterSort;
    }

    private FilterSelect createSelectList(String str, boolean z, String str2) {
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

    public void resetFilters() {
        IaaiApplication.isResetApplied = true;
        IaaiApplication.isfromDateSelected = false;
        IaaiApplication.isToDateSelected = false;
        IaaiApplication.isLaneFilterSelected = false;
        IaaiApplication.selectedFilters.clear();
        Intent intent = new Intent("filter-applied");
        intent.putExtra("filter-count", 0);
        if (this.listType == Constants.LIST_WATCHING || this.listType == Constants.LIST_PREBID) {
            intent.putExtra("filter-sort-by", "Auction Date");
        } else if (this.listType == Constants.LIST_AWARD_PENDING) {
            intent.putExtra("filter-sort-by", "BidAmount");
        } else if (this.listType == Constants.LIST_AUCTION_SALES) {
            intent.putExtra("filter-sort-by", "Item#");
        } else if (this.listType == Constants.LIST_WON_HISTORY || this.listType == Constants.LIST_LOST_PREBID) {
            intent.putExtra("filter-sort-by", getString(C2723R.string.headerDefaultSortAuction));
        }
        if (this.sortFragment.filterSelects != null) {
            for (int i = 0; i < this.sortFragment.filterSelects.size(); i++) {
                if (this.listType == Constants.LIST_WATCHING || this.listType == Constants.LIST_PREBID) {
                    if (i == 4) {
                        this.sortFragment.filterSelects.get(i).setSel_isSelected("true");
                    } else {
                        this.sortFragment.filterSelects.get(i).setSel_isSelected(PdfBoolean.FALSE);
                    }
                } else if (this.listType == Constants.LIST_AWARD_PENDING) {
                    if (i == Constants.DEFAULT_SORT_OPTION_FOR_AWARDPENDING) {
                        this.sortFragment.filterSelects.get(i).setSel_isSelected("true");
                    } else {
                        this.sortFragment.filterSelects.get(i).setSel_isSelected(PdfBoolean.FALSE);
                    }
                } else if (this.listType == Constants.LIST_AUCTION_SALES) {
                    if (i == 0) {
                        this.sortFragment.filterSelects.get(i).setSel_isSelected("true");
                    } else {
                        this.sortFragment.filterSelects.get(i).setSel_isSelected(PdfBoolean.FALSE);
                    }
                } else if (this.listType == Constants.LIST_WON_HISTORY || this.listType == Constants.LIST_LOST_PREBID) {
                    if (i == 0) {
                        this.sortFragment.filterSelects.get(i).setSel_isSelected("true");
                    } else {
                        this.sortFragment.filterSelects.get(i).setSel_isSelected(PdfBoolean.FALSE);
                    }
                }
            }
            this.sortFragment.adapter.notifyDataSetChanged();
        }
        if (IaaiApplication.isLaneFragmentSelected) {
            for (int i2 = 0; i2 < this.laneFilterFragment.filterSelects.size(); i2++) {
                if (i2 == 0) {
                    this.laneFilterFragment.filterSelects.get(i2).setSel_isSelected("true");
                } else {
                    this.laneFilterFragment.filterSelects.get(i2).setSel_isSelected(PdfBoolean.FALSE);
                }
            }
            this.laneFilterFragment.adapter.notifyDataSetChanged();
        }
        if (IaaiApplication.isDateFragmentSelected) {
            this.dateFilterFragment.filterSelects.get(0).setSel_isSelected(PdfBoolean.FALSE);
            this.dateFilterFragment.filterSelects.get(0).setValue("");
            this.dateFilterFragment.filterSelects.get(1).setSel_isSelected(PdfBoolean.FALSE);
            this.dateFilterFragment.filterSelects.get(1).setValue("");
        }
        if (this.listType == Constants.LIST_WATCHING || this.listType == Constants.LIST_PREBID) {
            IaaiApplication.selectedSortPosition = 4;
            this.initialSortPosition = 4;
        } else if (this.listType == Constants.LIST_AWARD_PENDING) {
            int i3 = Constants.DEFAULT_SORT_OPTION_FOR_AWARDPENDING;
            IaaiApplication.selectedSortPosition = i3;
            this.initialSortPosition = i3;
        } else if (this.listType == Constants.LIST_AUCTION_SALES) {
            IaaiApplication.selectedSortPosition = 2;
            this.initialSortPosition = 2;
        } else if (this.listType == Constants.LIST_WON_HISTORY || this.listType == Constants.LIST_LOST_PREBID) {
            IaaiApplication.selectedSortPosition = 0;
            this.initialSortPosition = 0;
        }
        IaaiApplication.selectedLanePosition = 0;
        this.initialLanePosition = 0;
        IaaiApplication.isFirstTimeForFilterDone = false;
        IaaiApplication.isDateModified = false;
        applyFilters();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005b, code lost:
        r4 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005d, code lost:
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005f, code lost:
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0061, code lost:
        r4 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0063, code lost:
        r4 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007e, code lost:
        if (com.iaai.android.IaaiApplication.isLaneFilterSelected == false) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0080, code lost:
        count++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0085, code lost:
        r1 = new android.content.Intent("filter-applied");
        r1.putExtra("filter-count", count);
        r1.putExtra("filter-sort-by", r4);
        androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a7, code lost:
        if (r9.initialSortPosition == com.iaai.android.IaaiApplication.selectedSortPosition) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a9, code lost:
        com.iaai.android.IaaiApplication.isFirstTimeForFilterDone = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00af, code lost:
        if (r9.initialLanePosition == com.iaai.android.IaaiApplication.selectedLanePosition) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b1, code lost:
        com.iaai.android.IaaiApplication.isFirstTimeForFilterDone = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b5, code lost:
        if (com.iaai.android.IaaiApplication.isfromDateSelected == false) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b9, code lost:
        if (com.iaai.android.IaaiApplication.isToDateSelected == false) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00bb, code lost:
        com.iaai.android.IaaiApplication.isFirstTimeForFilterDone = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00bd, code lost:
        com.iaai.android.IaaiApplication.isDateModified = false;
        finish();
        overridePendingTransition(com.iaai.android.C2723R.anim.no_change, com.iaai.android.C2723R.anim.slide_down_new);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00cb, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void applyFilters() {
        /*
            r9 = this;
            r0 = 0
            count = r0
            boolean r1 = com.iaai.android.IaaiApplication.isfromDateSelected
            r2 = 1
            if (r1 == 0) goto L_0x0011
            boolean r1 = com.iaai.android.IaaiApplication.isToDateSelected
            if (r1 == 0) goto L_0x0011
            int r1 = count
            int r1 = r1 + r2
            count = r1
        L_0x0011:
            r1 = 0
        L_0x0012:
            com.iaai.android.old.fragments.SortFragment r3 = r9.sortFragment
            java.util.List<com.iaai.android.old.models.FilterSelect> r3 = r3.filterSelects
            int r3 = r3.size()
            java.lang.String r4 = ""
            if (r1 >= r3) goto L_0x007c
            com.iaai.android.old.fragments.SortFragment r3 = r9.sortFragment
            java.util.List<com.iaai.android.old.models.FilterSelect> r3 = r3.filterSelects
            java.lang.Object r3 = r3.get(r1)
            com.iaai.android.old.models.FilterSelect r3 = (com.iaai.android.old.models.FilterSelect) r3
            java.lang.String r3 = r3.getSel_isSelected()
            java.lang.String r5 = "true"
            boolean r3 = r3.equalsIgnoreCase(r5)
            if (r3 == 0) goto L_0x0079
            int r3 = r9.listType
            int r5 = com.iaai.android.old.utils.constants.Constants.LIST_WATCHING
            java.lang.String r6 = "Year"
            java.lang.String r7 = "Odometer"
            java.lang.String r8 = "Make"
            if (r3 == r5) goto L_0x0073
            int r3 = r9.listType
            int r5 = com.iaai.android.old.utils.constants.Constants.LIST_PREBID
            if (r3 != r5) goto L_0x0047
            goto L_0x0073
        L_0x0047:
            int r3 = r9.listType
            int r5 = com.iaai.android.old.utils.constants.Constants.LIST_AWARD_PENDING
            if (r3 != r5) goto L_0x0065
            java.lang.String r3 = "Bidder"
            java.lang.String r5 = "Description"
            java.lang.String r6 = "AuctionItem#"
            java.lang.String r7 = "Branch"
            java.lang.String r8 = "BidAmount"
            switch(r1) {
                case 0: goto L_0x0063;
                case 1: goto L_0x0063;
                case 2: goto L_0x0061;
                case 3: goto L_0x0061;
                case 4: goto L_0x005f;
                case 5: goto L_0x005f;
                case 6: goto L_0x005d;
                case 7: goto L_0x005d;
                case 8: goto L_0x005b;
                case 9: goto L_0x005b;
                default: goto L_0x005a;
            }
        L_0x005a:
            goto L_0x007c
        L_0x005b:
            r4 = r3
            goto L_0x007c
        L_0x005d:
            r4 = r5
            goto L_0x007c
        L_0x005f:
            r4 = r6
            goto L_0x007c
        L_0x0061:
            r4 = r7
            goto L_0x007c
        L_0x0063:
            r4 = r8
            goto L_0x007c
        L_0x0065:
            int r3 = r9.listType
            int r5 = com.iaai.android.old.utils.constants.Constants.LIST_AUCTION_SALES
            if (r3 != r5) goto L_0x0079
            java.lang.String r3 = "Lane"
            java.lang.String r5 = "Item#"
            switch(r1) {
                case 0: goto L_0x005d;
                case 1: goto L_0x005d;
                case 2: goto L_0x005b;
                case 3: goto L_0x005b;
                case 4: goto L_0x0063;
                case 5: goto L_0x0063;
                case 6: goto L_0x0061;
                case 7: goto L_0x0061;
                case 8: goto L_0x005f;
                case 9: goto L_0x005f;
                default: goto L_0x0072;
            }
        L_0x0072:
            goto L_0x007c
        L_0x0073:
            java.lang.String r3 = "Auction"
            switch(r1) {
                case 0: goto L_0x0063;
                case 1: goto L_0x0063;
                case 2: goto L_0x0061;
                case 3: goto L_0x0061;
                case 4: goto L_0x005b;
                case 5: goto L_0x005b;
                case 6: goto L_0x005f;
                case 7: goto L_0x005f;
                default: goto L_0x0078;
            }
        L_0x0078:
            goto L_0x007c
        L_0x0079:
            int r1 = r1 + 1
            goto L_0x0012
        L_0x007c:
            boolean r1 = com.iaai.android.IaaiApplication.isLaneFilterSelected
            if (r1 == 0) goto L_0x0085
            int r1 = count
            int r1 = r1 + r2
            count = r1
        L_0x0085:
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r3 = "filter-applied"
            r1.<init>(r3)
            int r3 = count
            java.lang.String r5 = "filter-count"
            r1.putExtra(r5, r3)
            java.lang.String r3 = "filter-sort-by"
            r1.putExtra(r3, r4)
            android.content.Context r3 = r9.getApplicationContext()
            androidx.localbroadcastmanager.content.LocalBroadcastManager r3 = androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(r3)
            r3.sendBroadcast(r1)
            int r1 = r9.initialSortPosition
            int r3 = com.iaai.android.IaaiApplication.selectedSortPosition
            if (r1 == r3) goto L_0x00ab
            com.iaai.android.IaaiApplication.isFirstTimeForFilterDone = r2
        L_0x00ab:
            int r1 = r9.initialLanePosition
            int r3 = com.iaai.android.IaaiApplication.selectedLanePosition
            if (r1 == r3) goto L_0x00b3
            com.iaai.android.IaaiApplication.isFirstTimeForFilterDone = r2
        L_0x00b3:
            boolean r1 = com.iaai.android.IaaiApplication.isfromDateSelected
            if (r1 == 0) goto L_0x00bd
            boolean r1 = com.iaai.android.IaaiApplication.isToDateSelected
            if (r1 == 0) goto L_0x00bd
            com.iaai.android.IaaiApplication.isFirstTimeForFilterDone = r2
        L_0x00bd:
            com.iaai.android.IaaiApplication.isDateModified = r0
            r9.finish()
            r0 = 2130772035(0x7f010043, float:1.7147177E38)
            r1 = 2130772042(0x7f01004a, float:1.7147191E38)
            r9.overridePendingTransition(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.old.activities.SortNFilterActivity.applyFilters():void");
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            overridePendingTransition(C2723R.anim.none, C2723R.anim.abc_slide_out_bottom);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onSortInteraction(int i) {
        if (IaaiApplication.selectedSortPosition != i) {
            IaaiApplication.selectedSortPosition = i;
            this.btnReset.setEnabled(true);
            this.btnApply.setEnabled(true);
            return;
        }
        this.btnReset.setEnabled(false);
        this.btnApply.setEnabled(false);
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
        IaaiApplication.isResetApplied = false;
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

    public void onBackPressed() {
        super.onBackPressed();
        if (this.initialSortPosition != IaaiApplication.selectedSortPosition) {
            this.sortFragment.filterSelects.get(IaaiApplication.selectedSortPosition).setSel_isSelected(PdfBoolean.FALSE);
            IaaiApplication.selectedSortPosition = this.initialSortPosition;
            this.sortFragment.filterSelects.get(this.initialSortPosition).setSel_isSelected("true");
            HashMap<String, String> hashMap = IaaiApplication.selectedFilters;
            hashMap.put("sort", "" + this.initialSortPosition);
        }
    }
}
