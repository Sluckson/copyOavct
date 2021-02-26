package com.iaai.android.old.activities;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.inject.Injector;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.feature.productDetail.ProductDetailActivity;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.models.MDVehicle;
import com.iaai.android.old.models.MDVehicleSearchResult;
import com.iaai.android.old.models.ScopeDetail;
import com.iaai.android.old.utils.DateHelper;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.constants.SortOption;
import com.iaai.android.old.utils.http.RestClient;
import com.iaai.android.old.utils.p016ui.SimpleDividerItemDecoration;
import com.squareup.otto.Bus;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import roboguice.util.C5058Ln;
import roboguice.util.Strings;

public abstract class MDAbstractListActivity extends MDAbstractActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected static final String FORMAT_SCOPE = "&scope=%s";
    public static String KEY_EMPTY_VISIBLE = "empty_state";
    public static String KEY_SELECTED_INDEX = "selectedindex";
    public static String KEY_SORT_BY = "sort_by";
    public static String KEY_TOTAL_BID_AMOUNT = "total_bid_amount";
    public static String KEY_VEHICLE_LIST_DATA = "vehicle_list";
    public static final int LIST_MODE_VEHICLE = 0;
    public int SORT_DIRECTION;
    IaaiApplication application;
    int bidder_amount;
    String bidder_name = "";
    public RestClient client;
    String date_paid = "";
    FrameLayout detailContainer;
    LinearLayout divider_won;
    @BindView(2131296914)
    TextView empty;
    EndlessRecyclerViewScrollListener endlessRecyclerViewScrollListener;
    @BindView(2131296644)
    FloatingActionButton fab;
    boolean isMyItemsOnly;
    public String laneName = "";
    /* access modifiers changed from: private */
    public int listMode = 0;
    public int list_count;
    int lostamount;
    public boolean mLandscape;
    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String unused = MDAbstractListActivity.this.sortBy = intent.getStringExtra("filter-sort-by");
            if (MDAbstractListActivity.this.mTwoPane) {
                int unused2 = MDAbstractListActivity.this.selected_index = 0;
            }
            MDAbstractListActivity mDAbstractListActivity = MDAbstractListActivity.this;
            mDAbstractListActivity.sortWatchList(mDAbstractListActivity.sortBy, true, false);
        }
    };
    public boolean mTwoPane;
    int max_paid_amount;
    int myVehicleStatus;
    String picked_up_date = "";
    @BindView(2131297955)
    ProgressBar progressBar;
    String receipt_description = "";
    String receipt_no;
    View recyclerView;
    protected final List<ScopeDetail> scopeList = new ArrayList();
    private String searchPageSize;
    /* access modifiers changed from: private */
    public int selected_index;
    public SessionManager sessionManager;
    /* access modifiers changed from: private */
    public SimpleItemRecyclerViewAdapter simpleItemRecyclerViewAdapter;
    /* access modifiers changed from: private */
    public String sortBy = "";
    public String sortWithDirection = "";
    private Toolbar toolbar;
    public int totalbidAmount;
    public ArrayList<MDVehicle> vehicles;
    int winning_amount;
    SearchView wonSearchView;
    TextView won_no_vehicle_text_view;
    String year_make_model_se = "";

    /* access modifiers changed from: protected */
    public abstract int getListType();

    /* access modifiers changed from: package-private */
    public abstract void handleFilterClick();

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract void setDataToLeftViewOfListHeader(SimpleItemRecyclerViewAdapter.VHHeader vHHeader, int i);

    /* access modifiers changed from: protected */
    public abstract void setDefaultSortTitle(SimpleItemRecyclerViewAdapter.VHHeader vHHeader, String str);

    /* access modifiers changed from: protected */
    public abstract void setMDListTitle();

    public abstract void setMDProductDetailTitle();

    public abstract void setMDYearMakeModelTitle();

    /* access modifiers changed from: protected */
    public abstract void setRowUI(SimpleItemRecyclerViewAdapter.ViewHolder viewHolder);

    /* access modifiers changed from: protected */
    public abstract String setSortSelectionValue(int i, String str);

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_mdpresale_list);
        ButterKnife.bind((Activity) this);
        overridePendingTransition(C2723R.anim.push_left_in, C2723R.anim.no_change);
        this.sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();
        Bundle extras = getIntent().getExtras();
        this.myVehicleStatus = getIntent().getIntExtra("status", 0);
        this.isMyItemsOnly = getIntent().getBooleanExtra("isMyItemOnly", false);
        this.list_count = getIntent().getIntExtra(Constants.WATCHING_SIZE, 0);
        int i = this.myVehicleStatus;
        if (i == 1) {
            IAASharedPreference.setMyAccountCount(this, Constants_MVVM.KEY_FOR_WATCHING_COUNT_MYACCOUNT, this.list_count);
        } else if (i == 15) {
            IAASharedPreference.setMyAccountCount(this, Constants_MVVM.KEY_FOR_AWARD_PENDING_COUNT_MYACCOUNT, this.list_count);
        } else if (i == 50) {
            IAASharedPreference.setMyAccountCount(this, Constants_MVVM.KEY_FOR_LOST_PREBID_COUNT_MYACCOUNT, this.list_count);
        } else if (i == 55) {
            IAASharedPreference.setMyAccountCount(this, Constants_MVVM.KEY_FOR_PURCHASE_HISTORY_COUNT_MYACCOUNT, this.list_count);
        } else if (i == 60) {
            IAASharedPreference.setDashBoardCount(this, Constants_MVVM.KEY_FOR_PREBID_COUNT_MYACCOUNT, this.list_count);
        }
        if (getString(C2723R.string.selected_config).equals(Bus.DEFAULT_IDENTIFIER)) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(4);
        }
        if (extras != null) {
            init(bundle);
        }
    }

    private void init(Bundle bundle) {
        this.toolbar = (Toolbar) findViewById(C2723R.C2726id.toolbar);
        setSupportActionBar(this.toolbar);
        getWindow().setSoftInputMode(2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        setMDListTitle();
        Injector injector = ((IaaiApplication) getApplication()).getInjector();
        this.recyclerView = findViewById(C2723R.C2726id.mdpresale_list);
        this.wonSearchView = (SearchView) findViewById(C2723R.C2726id.keyword_search_won);
        this.won_no_vehicle_text_view = (TextView) findViewById(C2723R.C2726id.empty_view_won_history);
        this.divider_won = (LinearLayout) findViewById(C2723R.C2726id.divider_layout);
        if (getListType() == Constants.LIST_WON_HISTORY) {
            this.wonSearchView.setIconifiedByDefault(false);
            this.wonSearchView.setVisibility(0);
            this.divider_won.setVisibility(0);
            this.wonSearchView.setQueryHint(getResources().getString(C2723R.string.won_history_keyword_hint_text));
            SearchView searchView = this.wonSearchView;
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) searchView.findViewById(searchView.getContext().getResources().getIdentifier("android:id/search_src_text", (String) null, (String) null));
            autoCompleteTextView.setInputType(1);
            autoCompleteTextView.setFilters(new InputFilter[]{new InputFilter() {
                public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                    if (!charSequence.equals("") && !charSequence.toString().matches("[a-zA-Z0-9-' ]+")) {
                        return "";
                    }
                    return charSequence;
                }
            }});
        } else {
            this.wonSearchView.setVisibility(8);
            this.divider_won.setVisibility(8);
        }
        ((ImageView) this.wonSearchView.findViewById(this.wonSearchView.getContext().getResources().getIdentifier("android:id/search_close_btn", (String) null, (String) null))).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MDAbstractListActivity.this.wonSearchView != null) {
                    MDAbstractListActivity.this.wonSearchView.setIconifiedByDefault(false);
                    MDAbstractListActivity.this.wonSearchView.setFocusable(false);
                    MDAbstractListActivity.this.wonSearchView.setQuery("", false);
                }
                new VehicleSearchAsyncTask(false, "").execute(new Object[]{""});
                MDAbstractListActivity.this.hideSoftKeyBoard();
            }
        });
        this.wonSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextChange(String str) {
                return false;
            }

            public boolean onQueryTextSubmit(String str) {
                MDAbstractListActivity.this.commonResetFilterOption();
                MDAbstractListActivity mDAbstractListActivity = MDAbstractListActivity.this;
                mDAbstractListActivity.sortWithDirection = "";
                new VehicleSearchAsyncTask(false, str).execute(new Object[]{""});
                MDAbstractListActivity.this.wonSearchView.clearFocus();
                return true;
            }
        });
        this.simpleItemRecyclerViewAdapter = new SimpleItemRecyclerViewAdapter(this);
        setupRecyclerView((RecyclerView) this.recyclerView);
        RecyclerView recyclerView2 = (RecyclerView) this.recyclerView;
        recyclerView2.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(linearLayoutManager);
        this.endlessRecyclerViewScrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            public void onLoadMore(int i, int i2) {
                MDAbstractListActivity.this.vehicles.add((Object) null);
                MDAbstractListActivity.this.simpleItemRecyclerViewAdapter.notifyItemInserted(MDAbstractListActivity.this.vehicles.size() - 1);
                MDAbstractListActivity mDAbstractListActivity = MDAbstractListActivity.this;
                mDAbstractListActivity.sortWatchList(mDAbstractListActivity.sortBy, false, true);
            }
        };
        recyclerView2.addOnScrollListener(this.endlessRecyclerViewScrollListener);
        if (findViewById(C2723R.C2726id.mdpresale_detail_container) != null) {
            this.mTwoPane = false;
        } else {
            this.mTwoPane = false;
            this.detailContainer = (FrameLayout) findViewById(C2723R.C2726id.md_listing_detail_container);
        }
        if (getResources().getConfiguration().orientation == 2) {
            this.mLandscape = true;
        } else {
            this.mLandscape = false;
        }
        this.searchPageSize = getString(C2723R.string.vehicle_result_count);
        this.client = (RestClient) injector.getInstance(RestClient.class);
        LocalBroadcastManager.getInstance(this).registerReceiver(this.mMessageReceiver, new IntentFilter("filter-applied"));
        if (bundle != null) {
            if (bundle.getBoolean(KEY_EMPTY_VISIBLE)) {
                this.empty.setVisibility(0);
            } else {
                this.empty.setVisibility(8);
            }
            this.selected_index = bundle.getInt(KEY_SELECTED_INDEX);
            this.totalbidAmount = bundle.getInt(KEY_TOTAL_BID_AMOUNT);
            if (this.selected_index == -1) {
                this.selected_index = 0;
            }
            this.vehicles = bundle.getParcelableArrayList(KEY_VEHICLE_LIST_DATA);
            ArrayList<MDVehicle> arrayList = this.vehicles;
            if (arrayList == null) {
                new VehicleSearchAsyncTask(false, "").execute(new Object[]{""});
                return;
            }
            this.simpleItemRecyclerViewAdapter.setUpVehicleListData(arrayList);
            this.sortBy = bundle.getString(KEY_SORT_BY);
            updateSortNFilterText(this.sortBy);
            return;
        }
        new VehicleSearchAsyncTask(false, "").execute(new Object[]{""});
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

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(KEY_EMPTY_VISIBLE, this.empty.isShown());
        bundle.putInt(KEY_SELECTED_INDEX, this.selected_index);
        bundle.putInt(KEY_TOTAL_BID_AMOUNT, this.totalbidAmount);
        bundle.putParcelableArrayList(KEY_VEHICLE_LIST_DATA, this.vehicles);
        bundle.putString(KEY_SORT_BY, this.sortBy);
        int i = Build.VERSION.SDK_INT;
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: private */
    public void sortWatchList(String str, boolean z, boolean z2) {
        this.sortWithDirection = str;
        String updateSortNFilterText = updateSortNFilterText(str);
        ScopeDetail scopeDetail = new ScopeDetail();
        String str2 = this.laneName;
        scopeDetail.name = str2;
        scopeDetail.localizedName = str2;
        if (z) {
            this.simpleItemRecyclerViewAdapter.setUpVehicleListData((List<MDVehicle>) null);
        }
        new VehicleSearchAsyncTask(z2, "").execute(new Object[]{scopeDetail, SortOption.fromWSString(updateSortNFilterText)});
    }

    private String updateSortNFilterText(String str) {
        String str2;
        String str3;
        this.sortWithDirection = str;
        int i = -1;
        for (Map.Entry next : IaaiApplication.selectedFilters.entrySet()) {
            if (next.getKey().equals("laneValue")) {
                this.laneName = (String) next.getValue();
            }
            if (next.getKey().equals("sort")) {
                i = Integer.parseInt((String) next.getValue());
            }
        }
        switch (i) {
            case 0:
                str2 = str + " Ascending";
                this.sortWithDirection = getString(C2723R.string.filter_auction_date);
                this.SORT_DIRECTION = 0;
                break;
            case 1:
                str2 = str + " Descending";
                this.sortWithDirection = getString(C2723R.string.filter_auction_date);
                this.SORT_DIRECTION = 1;
                break;
            case 2:
                str2 = str + " Ascending";
                this.sortWithDirection = getString(C2723R.string.headerDefaultSortAuction);
                this.SORT_DIRECTION = 0;
                break;
            case 3:
                str2 = str + " Descending";
                this.sortWithDirection = getString(C2723R.string.lbl_sort_by_make_desc);
                this.SORT_DIRECTION = 1;
                break;
            case 4:
                str3 = str + " Ascending";
                this.sortWithDirection = getString(C2723R.string.odo_meter);
                this.SORT_DIRECTION = 0;
                break;
            case 5:
                str3 = str + " Descending";
                this.sortWithDirection = getString(C2723R.string.odo_meter);
                this.SORT_DIRECTION = 1;
                break;
            case 6:
                str2 = str + " Ascending";
                this.sortWithDirection = getString(C2723R.string.year);
                this.SORT_DIRECTION = 0;
                break;
            case 7:
                str2 = str + " Descending";
                this.sortWithDirection = getString(C2723R.string.year);
                this.SORT_DIRECTION = 1;
                break;
            default:
                this.sortWithDirection = getString(C2723R.string.filter_auction_date);
                this.SORT_DIRECTION = 0;
                str2 = "AuctionDate Ascending";
                break;
        }
        str2 = str3;
        String sortSelectionValue = setSortSelectionValue(i, str);
        return sortSelectionValue != null ? sortSelectionValue : str2;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mMessageReceiver);
        if (isFinishing()) {
            IaaiApplication.selectedFilters.clear();
            IaaiApplication.isfromDateSelected = false;
            IaaiApplication.isToDateSelected = false;
            IaaiApplication.isLaneFilterSelected = false;
            IaaiApplication.isFirstTimeForFilterDone = false;
        }
    }

    /* access modifiers changed from: package-private */
    public MDVehicleSearchResult loadSearchResult(ScopeDetail scopeDetail, SortOption sortOption, Location location, String str, String str2) {
        String str3;
        int i;
        SortOption.refreshAll();
        getIntent();
        String str4 = "";
        if (sortOption == null) {
            str3 = str4;
        } else {
            str3 = sortOption.toWsParamString();
        }
        SimpleItemRecyclerViewAdapter simpleItemRecyclerViewAdapter2 = this.simpleItemRecyclerViewAdapter;
        if (simpleItemRecyclerViewAdapter2 != null) {
            i = simpleItemRecyclerViewAdapter2.getItemCount();
        } else {
            i = 0;
        }
        if (i != 0) {
            i -= 2;
        }
        String valueOf = String.valueOf(i + 1);
        String valueOf2 = String.valueOf(this.myVehicleStatus);
        Object[] objArr = new Object[5];
        objArr[0] = this.sessionManager.getCurrentSessionUserId();
        objArr[1] = this.isMyItemsOnly ? IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE : "0";
        objArr[2] = valueOf;
        objArr[3] = this.searchPageSize;
        objArr[4] = valueOf2;
        String string = getString(C2723R.string.service_path_my_vehicle, objArr);
        if (!str2.equals(str4)) {
            str4 = "&keyword=" + str2;
        }
        return (MDVehicleSearchResult) executeSearch(string + str3 + str4, MDVehicleSearchResult.class, true);
    }

    /* access modifiers changed from: package-private */
    public <T> T executeSearch(String str, Class<? extends T> cls, boolean z) {
        try {
            C5058Ln.m4829d("Execute vehicle search. url[%s]", str);
            return this.client.execute(str, cls, z);
        } catch (Exception e) {
            C5058Ln.m4834e(e, "vehicle search failed", new Object[0]);
            return null;
        }
    }

    private void setupRecyclerView(@NonNull final RecyclerView recyclerView2) {
        recyclerView2.setAdapter(this.simpleItemRecyclerViewAdapter);
        recyclerView2.addItemDecoration(new SimpleDividerItemDecoration(this));
        this.fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                recyclerView2.smoothScrollToPosition(0);
                MDAbstractListActivity.this.fab.hide();
            }
        });
        recyclerView2.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 0 && recyclerView.canScrollVertically(-1)) {
                    MDAbstractListActivity.this.fab.show();
                }
                super.onScrollStateChanged(recyclerView, i);
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                if (i2 > 0 || (i2 < 0 && MDAbstractListActivity.this.fab.isShown())) {
                    MDAbstractListActivity.this.fab.hide();
                }
            }
        });
    }

    public class SimpleItemRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
        private static final int TYPE_FOOTER = 2;
        private static final int TYPE_HEADER = 0;
        private static final int TYPE_ITEM = 1;
        Context contextForPicasso;
        private List<MDVehicle> mValues;

        private boolean isPositionHeader(int i) {
            return i == 0;
        }

        public SimpleItemRecyclerViewAdapter(Context context) {
            this.contextForPicasso = context;
        }

        public void setUpVehicleListData(List<MDVehicle> list) {
            this.mValues = list;
            notifyDataSetChanged();
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                return new VHHeader(LayoutInflater.from(viewGroup.getContext()).inflate(C2723R.C2728layout.sales_list_header, viewGroup, false));
            }
            if (i == 1) {
                return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C2723R.C2728layout.mdpresale_list_content, viewGroup, false));
            }
            if (i == 2) {
                return new VHFooter(LayoutInflater.from(viewGroup.getContext()).inflate(C2723R.C2728layout.load_more_progresbar_layout, viewGroup, false));
            }
            throw new RuntimeException("there is no type that matches the type " + i + " + make sure your using types correctly");
        }

        class VHHeader extends ViewHolder {
            TextView labletotalpending;
            RelativeLayout layout_total;
            TextView txtTitle;
            TextView txttotalbidamount;

            public VHHeader(View view) {
                super(view);
                this.txtTitle = (TextView) view.findViewById(C2723R.C2726id.search_results_filter);
                this.txttotalbidamount = (TextView) view.findViewById(C2723R.C2726id.total_bid_amount);
                this.layout_total = (RelativeLayout) view.findViewById(C2723R.C2726id.layout_total_pending);
                this.labletotalpending = (TextView) view.findViewById(C2723R.C2726id.label_total_pending);
            }
        }

        class VHFooter extends ViewHolder {
            ProgressBar progressBar;

            public VHFooter(View view) {
                super(view);
                this.progressBar = (ProgressBar) view.findViewById(C2723R.C2726id.progressBar1);
            }
        }

        public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
            if (viewHolder instanceof VHHeader) {
                VHHeader vHHeader = (VHHeader) viewHolder;
                if (MDAbstractListActivity.this.sortWithDirection.equals("")) {
                    vHHeader.txtTitle.setText(MDAbstractListActivity.this.getString(C2723R.string.filter_auction_date) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    vHHeader.txtTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, MDAbstractListActivity.this.getResources().getDrawable(C2723R.C2725drawable.ic_sort_num_asc_blue), (Drawable) null);
                } else {
                    MDAbstractListActivity mDAbstractListActivity = MDAbstractListActivity.this;
                    Drawable access$500 = mDAbstractListActivity.checkSortWithDirection(mDAbstractListActivity.sortWithDirection);
                    vHHeader.txtTitle.setText(MDAbstractListActivity.this.sortWithDirection + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    vHHeader.txtTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, access$500, (Drawable) null);
                }
                MDAbstractListActivity mDAbstractListActivity2 = MDAbstractListActivity.this;
                mDAbstractListActivity2.setDefaultSortTitle(vHHeader, mDAbstractListActivity2.sortWithDirection);
                MDAbstractListActivity mDAbstractListActivity3 = MDAbstractListActivity.this;
                mDAbstractListActivity3.setDataToLeftViewOfListHeader(vHHeader, mDAbstractListActivity3.totalbidAmount);
                vHHeader.txtTitle.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        MDAbstractListActivity.this.handleFilterClick();
                    }
                });
            } else if (!(viewHolder instanceof VHFooter) && (viewHolder instanceof ViewHolder)) {
                int i2 = i - 1;
                viewHolder.mItem = this.mValues.get(i2);
                if (viewHolder.mItem != null) {
                    viewHolder.pre_sale_row_1.setText(viewHolder.mItem.toString());
                }
                if (viewHolder.mItem.slot == null || Strings.isEmpty(viewHolder.mItem.slot.trim()) || viewHolder.mItem.slot.trim().toLowerCase().contains("tbd")) {
                    viewHolder.pre_sale_row_4.setText(viewHolder.mItem.branchName);
                } else {
                    String trim = viewHolder.mItem.slot.trim();
                    if (viewHolder.mItem.lane != null && viewHolder.mItem.lane.trim() != "") {
                        viewHolder.pre_sale_row_4.setText(viewHolder.mItem.branchName + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + viewHolder.mItem.lane.trim() + "-" + trim);
                    } else if (trim.contains("-")) {
                        viewHolder.pre_sale_row_4.setText(viewHolder.mItem.branchName + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + trim);
                    } else {
                        viewHolder.pre_sale_row_4.setText(viewHolder.mItem.branchName + " #" + trim);
                    }
                }
                if (viewHolder.mItem.timedAuctionRowIndicator) {
                    viewHolder.pre_sale_row_5.setVisibility(0);
                } else {
                    viewHolder.pre_sale_row_5.setVisibility(8);
                }
                if (viewHolder.mItem.PredictedTimeOnBlock == null || viewHolder.mItem.PredictedTimeOnBlock.length() <= 0) {
                    viewHolder.pre_sale_row_6.setVisibility(8);
                } else {
                    String eTOBDateFormat = DateHelper.getETOBDateFormat(viewHolder.mItem.PredictedTimeOnBlock);
                    viewHolder.pre_sale_row_6.setVisibility(0);
                    viewHolder.pre_sale_row_6.setText(MDAbstractListActivity.this.getString(C2723R.string.lbl_bdt_estimate_time, new Object[]{eTOBDateFormat}));
                }
                if (TextUtils.isEmpty(viewHolder.mItem.imageUrl)) {
                    Picasso.get().load((int) C2723R.C2725drawable.ic_image_na).into(viewHolder.img_vehicle_image);
                } else {
                    Picasso.get().load(viewHolder.mItem.imageUrl).resize(160, 120).onlyScaleDown().placeholder((int) C2723R.C2725drawable.progress_animation).error((int) C2723R.C2725drawable.ic_image_na).into(viewHolder.img_vehicle_image);
                }
                if (MDAbstractListActivity.this.mTwoPane) {
                    if (i2 == MDAbstractListActivity.this.selected_index) {
                        viewHolder.mView.setSelected(true);
                    } else {
                        viewHolder.mView.setSelected(false);
                    }
                }
                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        SimpleItemRecyclerViewAdapter.this.notifyDataSetChanged();
                        int unused = MDAbstractListActivity.this.selected_index = i - 1;
                        MDVehicle mDVehicle = viewHolder.mItem;
                        if (mDVehicle.itemId == null || TextUtils.isEmpty(mDVehicle.itemId) || mDVehicle.itemId.equals("0")) {
                            Toast.makeText(MDAbstractListActivity.this, MDAbstractListActivity.this.getString(C2723R.string.unable_to_select_vehicle), 0).show();
                            return;
                        }
                        TextView textView = viewHolder.pre_sale_row_1;
                        Bundle bundle = new Bundle();
                        if (mDVehicle.lane == null) {
                            mDVehicle.lane = "";
                        }
                        MDAbstractListActivity.this.year_make_model_se = viewHolder.mItem.toString();
                        MDAbstractListActivity.this.picked_up_date = viewHolder.mItem.pickedupdatestring;
                        MDAbstractListActivity.this.date_paid = viewHolder.mItem.datepaidstring;
                        MDAbstractListActivity.this.max_paid_amount = viewHolder.mItem.bidamount;
                        MDAbstractListActivity.this.receipt_no = viewHolder.mItem.receiptNo;
                        MDAbstractListActivity.this.receipt_description = viewHolder.mItem.receiptDescription;
                        MDAbstractListActivity.this.bidder_name = viewHolder.mItem.biddername;
                        MDAbstractListActivity.this.bidder_amount = viewHolder.mItem.bidamount;
                        MDAbstractListActivity.this.winning_amount = viewHolder.mItem.win_amount;
                        bundle.putParcelable(Constants.EXTRA_VEHICLE, mDVehicle);
                        bundle.putInt(Constants.EXTRA_PAGE_TYPE, mDVehicle.status);
                        bundle.putInt(Constants.EXTRA_LIST_MODE, MDAbstractListActivity.this.listMode);
                        bundle.putInt(Constants.EXTRA_POSTSALE_LIST_TYPE, MDAbstractListActivity.this.getListType());
                        bundle.putString(Constants.EXTRA_YEAR_MAKE_MODEL, MDAbstractListActivity.this.year_make_model_se);
                        bundle.putString(Constants.EXTRA_PICKED_UP_DATE, MDAbstractListActivity.this.picked_up_date);
                        bundle.putString(Constants.EXTRA_DATE_PAID, MDAbstractListActivity.this.date_paid);
                        bundle.putInt("bidamount", MDAbstractListActivity.this.max_paid_amount);
                        bundle.putString(Constants.EXTRA_RECEIPT_NO, MDAbstractListActivity.this.receipt_no);
                        bundle.putString(Constants.EXTRA_RECEIPT_DESCRIPTION, MDAbstractListActivity.this.receipt_description);
                        bundle.putInt("bidamount", MDAbstractListActivity.this.bidder_amount);
                        bundle.putInt(Constants.EXTRA_WINNING_AMOUNT, MDAbstractListActivity.this.winning_amount);
                        bundle.putString(Constants.EXTRA_BIDDER_NAME, MDAbstractListActivity.this.bidder_name);
                        if (MDAbstractListActivity.this.listMode == 0) {
                            bundle.putBoolean(Constants.EXTRA_FROM_FAST, true);
                        } else {
                            bundle.putBoolean(Constants.EXTRA_FROM_FAST, false);
                        }
                        Intent intent = new Intent(MDAbstractListActivity.this, ProductDetailActivity.class);
                        intent.addCategory("android.intent.category.DEFAULT");
                        intent.putExtra(Constants.EXTRA_ITEM_ID, mDVehicle.itemId);
                        intent.putExtra("isFromSearchVehicle", false);
                        intent.putExtra(Constants.EXTRA_YEAR_MAKE_MODEL, MDAbstractListActivity.this.year_make_model_se);
                        MDAbstractListActivity.this.startActivity(intent);
                        MDAbstractListActivity.this.detailContainer.setVisibility(0);
                        MDAbstractListActivity.this.fab.setVisibility(4);
                    }
                });
                MDAbstractListActivity.this.setRowUI(viewHolder);
            }
        }

        public int getItemViewType(int i) {
            if (isPositionHeader(i)) {
                return 0;
            }
            return isPositionFooter(i) ? 2 : 1;
        }

        private boolean isPositionFooter(int i) {
            return this.mValues.get(i - 1) == null;
        }

        public int getItemCount() {
            List<MDVehicle> list = this.mValues;
            if (list != null) {
                return list.size() + 1;
            }
            return 0;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final ImageView img_vehicle_image;
            public MDVehicle mItem;
            public final View mView;
            public final TextView pre_sale_row_1;
            public final TextView pre_sale_row_2;
            public final TextView pre_sale_row_3_left;
            public final TextView pre_sale_row_3_left_1;
            public final TextView pre_sale_row_3_right;
            public final TextView pre_sale_row_4;
            public final TextView pre_sale_row_5;
            public final TextView pre_sale_row_6;
            public final ImageView star_image;
            public final TextView titleNotYetAvailable;
            public final SearchView won_search_view;

            public ViewHolder(View view) {
                super(view);
                this.mView = view;
                this.pre_sale_row_1 = (TextView) view.findViewById(C2723R.C2726id.pre_sale_row_1);
                this.pre_sale_row_6 = (TextView) view.findViewById(C2723R.C2726id.pre_sale_row_6);
                this.pre_sale_row_2 = (TextView) view.findViewById(C2723R.C2726id.pre_sale_row_2);
                this.pre_sale_row_4 = (TextView) view.findViewById(C2723R.C2726id.pre_sale_row_4);
                this.pre_sale_row_5 = (TextView) view.findViewById(C2723R.C2726id.pre_sale_row_5);
                this.pre_sale_row_3_left = (TextView) view.findViewById(C2723R.C2726id.pre_sale_row_3_left);
                this.pre_sale_row_3_left_1 = (TextView) view.findViewById(C2723R.C2726id.pre_sale_row_3_left_1);
                this.pre_sale_row_3_right = (TextView) view.findViewById(C2723R.C2726id.pre_sale_row_3_right);
                this.img_vehicle_image = (ImageView) view.findViewById(C2723R.C2726id.vehicle_image);
                this.star_image = (ImageView) view.findViewById(C2723R.C2726id.image);
                this.won_search_view = (SearchView) view.findViewById(C2723R.C2726id.keyword_search_won);
                this.titleNotYetAvailable = (TextView) view.findViewById(C2723R.C2726id.tvTitleNotAvailableYet);
            }

            public String toString() {
                return super.toString() + " '" + this.pre_sale_row_1.getText() + "'";
            }
        }
    }

    /* access modifiers changed from: private */
    public Drawable checkSortWithDirection(String str) {
        if (str.equalsIgnoreCase(getString(C2723R.string.headerDefaultSortAuction)) || str.equalsIgnoreCase(getString(C2723R.string.lbl_sort_by_make_desc)) || str.equalsIgnoreCase(getString(C2723R.string.lbl_srt_branch)) || str.equalsIgnoreCase(getString(C2723R.string.lbl_srt_bidder)) || str.equalsIgnoreCase(getString(C2723R.string.lbl_srt_year_make_model))) {
            if (this.SORT_DIRECTION == 0) {
                return getResources().getDrawable(C2723R.C2725drawable.ic_sort_alpha_asc_blue);
            }
            return getResources().getDrawable(C2723R.C2725drawable.ic_sort_alpha_desc_blue);
        } else if (this.SORT_DIRECTION == 0) {
            return getResources().getDrawable(C2723R.C2725drawable.ic_sort_num_asc_blue);
        } else {
            return getResources().getDrawable(C2723R.C2725drawable.ic_sort_num_desc_blue);
        }
    }

    public class VehicleSearchAsyncTask extends AsyncTask<Object, String, MDVehicleSearchResult> {
        String keyword;
        boolean shouldAppend = false;

        VehicleSearchAsyncTask(boolean z, String str) {
            this.shouldAppend = z;
            this.keyword = str;
        }

        /* access modifiers changed from: protected */
        public MDVehicleSearchResult doInBackground(Object... objArr) {
            if (objArr.length > 1) {
                return MDAbstractListActivity.this.loadSearchResult(objArr[0], objArr[1], (Location) null, "", this.keyword);
            }
            return MDAbstractListActivity.this.loadSearchResult((ScopeDetail) null, (SortOption) null, (Location) null, "", this.keyword);
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            MDAbstractListActivity.this.hideSoftKeyBoard();
            if (!this.shouldAppend) {
                MDAbstractListActivity.this.progressBar.setVisibility(0);
            }
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(MDVehicleSearchResult mDVehicleSearchResult) {
            if (mDVehicleSearchResult == null || mDVehicleSearchResult.vehicles == null || mDVehicleSearchResult.vehicles.size() <= 0) {
                if (MDAbstractListActivity.this.getListType() == Constants.LIST_WON_HISTORY && !this.keyword.equals("") && !this.shouldAppend) {
                    MDAbstractListActivity mDAbstractListActivity = MDAbstractListActivity.this;
                    mDAbstractListActivity.vehicles = null;
                    mDAbstractListActivity.simpleItemRecyclerViewAdapter.setUpVehicleListData(MDAbstractListActivity.this.vehicles);
                }
                if (MDAbstractListActivity.this.vehicles != null) {
                    MDAbstractListActivity.this.vehicles.remove(MDAbstractListActivity.this.vehicles.size() - 1);
                    MDAbstractListActivity.this.simpleItemRecyclerViewAdapter.notifyItemRemoved(MDAbstractListActivity.this.vehicles.size());
                    MDAbstractListActivity.this.simpleItemRecyclerViewAdapter.notifyDataSetChanged();
                }
                if (!this.shouldAppend) {
                    if (!this.keyword.equals("")) {
                        MDAbstractListActivity.this.won_no_vehicle_text_view.setVisibility(0);
                    } else {
                        MDAbstractListActivity.this.empty.setVisibility(0);
                    }
                }
            } else {
                MDAbstractListActivity.this.empty.setVisibility(8);
                MDAbstractListActivity.this.won_no_vehicle_text_view.setVisibility(8);
                if (MDAbstractListActivity.this.vehicles != null) {
                    MDAbstractListActivity.this.vehicles.remove(MDAbstractListActivity.this.vehicles.size() - 1);
                    MDAbstractListActivity.this.simpleItemRecyclerViewAdapter.notifyItemRemoved(MDAbstractListActivity.this.vehicles.size());
                    MDAbstractListActivity.this.simpleItemRecyclerViewAdapter.notifyDataSetChanged();
                }
                if (this.shouldAppend) {
                    MDAbstractListActivity.this.vehicles.addAll(mDVehicleSearchResult.vehicles);
                } else {
                    MDAbstractListActivity.this.vehicles = (ArrayList) mDVehicleSearchResult.vehicles;
                }
                MDAbstractListActivity.this.totalbidAmount = mDVehicleSearchResult.totalBidAmount;
                MDAbstractListActivity.this.simpleItemRecyclerViewAdapter.setUpVehicleListData(MDAbstractListActivity.this.vehicles);
                if (!this.shouldAppend) {
                    Animation loadAnimation = AnimationUtils.loadAnimation(MDAbstractListActivity.this, C2723R.anim.custom_push_left_in_animation);
                    loadAnimation.setDuration(750);
                    MDAbstractListActivity.this.recyclerView.startAnimation(loadAnimation);
                }
                MDAbstractListActivity.this.endlessRecyclerViewScrollListener.setLoaded();
                MDAbstractListActivity.this.updateScopeList(mDVehicleSearchResult.getNonEmptyScopes());
            }
            MDAbstractListActivity.this.hideSoftKeyBoard();
            if (!this.shouldAppend) {
                MDAbstractListActivity.this.progressBar.setVisibility(8);
            }
            super.onPostExecute(mDVehicleSearchResult);
        }
    }

    /* access modifiers changed from: private */
    public void hideSoftKeyBoard() {
        if (getListType() == Constants.LIST_WON_HISTORY) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.wonSearchView.getWindowToken(), 0);
        }
    }

    public abstract class EndlessRecyclerViewScrollListener extends RecyclerView.OnScrollListener {
        private int currentPage = 0;
        private boolean isLoading;
        private int lastVisibleItem;
        RecyclerView.LayoutManager mLayoutManager;
        private int previousTotalItemCount = 0;
        private int startingPageIndex = 0;
        private int totalItemCount;
        private int visibleThreshold = 5;

        public abstract void onLoadMore(int i, int i2);

        public EndlessRecyclerViewScrollListener(LinearLayoutManager linearLayoutManager) {
            this.mLayoutManager = linearLayoutManager;
        }

        public EndlessRecyclerViewScrollListener(GridLayoutManager gridLayoutManager) {
            this.mLayoutManager = gridLayoutManager;
            this.visibleThreshold *= gridLayoutManager.getSpanCount();
        }

        public EndlessRecyclerViewScrollListener(StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.mLayoutManager = staggeredGridLayoutManager;
            this.visibleThreshold *= staggeredGridLayoutManager.getSpanCount();
        }

        public int getLastVisibleItem(int[] iArr) {
            int i = 0;
            for (int i2 = 0; i2 < iArr.length; i2++) {
                if (i2 == 0) {
                    i = iArr[i2];
                } else if (iArr[i2] > i) {
                    i = iArr[i2];
                }
            }
            return i;
        }

        public void setLoaded() {
            this.isLoading = false;
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            this.totalItemCount = this.mLayoutManager.getItemCount();
            this.lastVisibleItem = ((LinearLayoutManager) this.mLayoutManager).findLastVisibleItemPosition();
            int i3 = this.totalItemCount;
            int i4 = this.visibleThreshold;
            if (i3 + i4 > 30 && !this.isLoading && i3 <= this.lastVisibleItem + i4) {
                onLoadMore(this.currentPage, i3);
                this.isLoading = true;
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                finish();
                overridePendingTransition(C2723R.anim.none, C2723R.anim.push_right_out);
            } else {
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    /* access modifiers changed from: package-private */
    public void updateScopeList(List<ScopeDetail> list) {
        this.scopeList.clear();
        if (list != null) {
            this.scopeList.addAll(list);
        }
    }

    public void onBackPressed() {
        if (this.recyclerView.getVisibility() == 4) {
            this.recyclerView.setVisibility(0);
        }
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            setMDListTitle();
        }
        super.onBackPressed();
    }
}
