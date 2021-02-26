package com.iaai.android.old.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Injector;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentMethodActivity;
import com.iaai.android.bdt.feature.productDetail.ProductDetailActivity;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.adapter.MDToBePaidFeesAdapter;
import com.iaai.android.old.managers.ToBePaidManager;
import com.iaai.android.old.models.CompletePaymentInfo;
import com.iaai.android.old.models.Fees;
import com.iaai.android.old.models.FeesInfo;
import com.iaai.android.old.models.MDVehicle;
import com.iaai.android.old.models.ScopeDetail;
import com.iaai.android.old.models.ToBePaidAFCResponse;
import com.iaai.android.old.models.ToBePaidBranchFilter;
import com.iaai.android.old.models.ToBePaidInfo;
import com.iaai.android.old.models.ToBePaidVehicle;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.DateHelper;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.constants.MyVehicleStatus;
import com.iaai.android.old.utils.constants.ToBePaidSortOptions;
import com.iaai.android.old.utils.http.RestClient;
import com.iaai.android.old.utils.p016ui.MDActivityHelper;
import com.iaai.android.old.utils.p016ui.SimpleDividerItemDecoration;
import com.iaai.android.old.utils.p016ui.UiUtils;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.squareup.otto.Bus;
import com.squareup.picasso.Picasso;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import p052cz.msebera.android.httpclient.Header;
import roboguice.util.Strings;

public class MDToBePaidListActivity extends MDAbstractActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected static final String FORMAT_SCOPE = "&scope=%s";
    public static String KEY_AFC_ERROR = "afcError";
    public static String KEY_AFC_LIMIT = "afcLimit";
    public static String KEY_AW_VEHICLE_COUNT = "awvehicleCount";
    public static String KEY_BRANCH_LIST_PARCELABLE = "branchList";
    public static String KEY_BRANCH_SLELECTED_PARCEABLE = "branchSelected";
    public static String KEY_EMPTY_VISIBLE = "empty_state";
    public static String KEY_IAPY_LIMIT = "iPayLimit";
    public static String KEY_IPAY_DALIY_ALLOWANCE = "iPayDailyAllowance";
    public static String KEY_ISAFC_BOOL = "isAfc";
    public static String KEY_ISIAPY = "isIpay";
    public static String KEY_ISMYITEM_ONLY_STRING = "is_myItem_only_string";
    public static String KEY_IS_AFC_ERROR = "isAFCError";
    public static String KEY_IS_MY_ITEM_OLNY = "isMyItemsOnly";
    public static String KEY_IS_PAY_ERROR = "isIpayError";
    public static String KEY_PAYMENT_INFO_PARCEABLE = "paymentInfo";
    public static String KEY_PAYMENT_OPTION = "paymentOption";
    public static String KEY_SELECTED_INDEX = "selected_index";
    public static String KEY_SELECTED_SORT = "selectedSort";
    public static String KEY_SHOW_PAYMENT_SELECTION = "showpaymentSelection";
    public static String KEY_SORT_BY = "sort_by";
    public static String KEY_TOBEPAID_INFO_SERILIZE = "toBePaidInfo";
    public static String KEY_TOTAL_AW_AMOUNT = "total_aw_amount";
    public static String KEY_TOTAL_BID_AMOUNT = "total_bid_amount";
    public static String KEY_VEHICLE_COUNT = "vehicleCount";
    public static String KEY_VEHICLE_LIST_DATA = "vehicle_list";
    public static final int LIST_MODE_VEHICLE = 0;
    public static boolean isConfirmationDone = false;
    public int SORT_DIRECTION;
    String afcError;
    String afcLimit;
    IaaiApplication application;
    /* access modifiers changed from: private */
    public int awvehicleCount;
    List<ToBePaidBranchFilter> branchList;
    public ToBePaidBranchFilter branchSelected;
    public RestClient client;
    @BindView(2131297593)
    LinearLayout creditLimit;
    FrameLayout detailContainer;
    @BindView(2131296871)
    LinearLayout dividerLayout;
    @BindView(2131296914)
    TextView empty;
    EndlessRecyclerViewScrollListener endlessRecyclerViewScrollListener;
    @BindView(2131298909)
    TextView errorText;
    @BindView(2131296644)
    FloatingActionButton fab;
    String iPayDailyAllowance;
    String iPayLimit;
    /* access modifiers changed from: private */
    public boolean isAFCError;
    private boolean isAfc;
    private boolean isIpay;
    /* access modifiers changed from: private */
    public boolean isIpayError;
    /* access modifiers changed from: private */
    public String isMyItemOnlyString;
    public boolean isMyItemsOnly;
    public String laneName = "";
    @BindView(2131297357)
    TextView lblCreditRemaining;
    /* access modifiers changed from: private */
    public int listMode = 0;
    @BindView(2131297598)
    LinearLayout lytProceedToPayment;
    public boolean mLandscape;
    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String unused = MDToBePaidListActivity.this.sortBy = intent.getStringExtra("filter-sort-by");
            if (MDToBePaidListActivity.this.mTwoPane) {
                int unused2 = MDToBePaidListActivity.this.selected_index = 0;
            }
            MDToBePaidListActivity mDToBePaidListActivity = MDToBePaidListActivity.this;
            mDToBePaidListActivity.sortWatchList(mDToBePaidListActivity.sortBy, true, false);
        }
    };
    public boolean mTwoPane;
    @BindView(2131297547)
    LinearLayout methodSelection;
    private MyVehicleStatus myVehicleStatus;
    CompletePaymentInfo paymentInfo;
    @BindView(2131297596)
    LinearLayout paymentInfoSingle;
    @BindView(2131297843)
    ImageView paymentLogo;
    private String paymentOption;
    @BindView(2131297955)
    ProgressBar progressBar;
    View recyclerView;
    protected final List<ScopeDetail> scopeList = new ArrayList();
    private String searchPageSize;
    /* access modifiers changed from: private */
    public ToBePaidSortOptions selectedSort = ToBePaidSortOptions.SORT_BY_DEFAULTC;
    /* access modifiers changed from: private */
    public int selected_index;
    public SessionManager sessionManager;
    boolean shouldAppend = false;
    private boolean showpaymentSelection;
    /* access modifiers changed from: private */
    public SimpleItemRecyclerViewAdapter simpleItemRecyclerViewAdapter;
    /* access modifiers changed from: private */
    public String sortBy = "";
    public String sortWithDirection = "";
    ToBePaidInfo toBePaidInfo;
    ToBePaidManager toBePaidManager;
    private Toolbar toolbar;
    /* access modifiers changed from: private */
    public String total_aw_amount;
    /* access modifiers changed from: private */
    public SpannableString total_due_Spanable;
    public int totalbidAmount;
    @BindView(2131298994)
    TextView txtProceedToPayment;
    @BindView(2131299063)
    TextView valCreditRemaining;
    /* access modifiers changed from: private */
    public int vehicleCount;
    public ArrayList<ToBePaidVehicle> vehicles;
    String year_make_model_se = "";

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_md_tobepaid_layout);
        ButterKnife.bind((Activity) this);
        overridePendingTransition(C2723R.anim.push_left_in, C2723R.anim.no_change);
        Bundle extras = getIntent().getExtras();
        if (getString(C2723R.string.selected_config).equals(Bus.DEFAULT_IDENTIFIER)) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(4);
        }
        this.paymentOption = Constants.PAYMENT_OPTION_ACH;
        this.showpaymentSelection = false;
        this.application = (IaaiApplication) getApplication();
        Injector injector = this.application.getInjector();
        this.client = (RestClient) injector.getInstance(RestClient.class);
        this.sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();
        this.isAfc = this.sessionManager.isCurrentSessionUserAFCEligiable();
        this.paymentInfo = new CompletePaymentInfo();
        ToBePaidSortOptions.refreshAll();
        this.selectedSort = ToBePaidSortOptions.SORT_BY_DEFAULTC;
        this.toBePaidManager = (ToBePaidManager) injector.getInstance(ToBePaidManager.class);
        if (extras != null) {
            init(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (isConfirmationDone) {
            this.sortWithDirection = "";
            this.branchSelected = null;
            this.selectedSort = ToBePaidSortOptions.SORT_BY_DEFAULTC;
            commonResetFilterOption();
            this.simpleItemRecyclerViewAdapter.setUpVehicleListData((List<ToBePaidVehicle>) null);
            loadData((String) null, false);
            isConfirmationDone = false;
        }
    }

    private void init(Bundle bundle) {
        this.toolbar = (Toolbar) findViewById(C2723R.C2726id.toolbar);
        setSupportActionBar(this.toolbar);
        getWindow().setSoftInputMode(2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ActionBar supportActionBar = getSupportActionBar();
            supportActionBar.setTitle((CharSequence) getTitle() + " (" + extras.getInt(Constants.WATCHING_SIZE) + ")");
        } else {
            getSupportActionBar().setTitle(getTitle());
        }
        this.vehicleCount = getIntent().getIntExtra(Constants.WATCHING_SIZE, 0);
        IAASharedPreference.setDashBoardCount(this, Constants_MVVM.KEY_FOR_TOBEPAID_COUNT_MYACCOUNT, this.vehicleCount);
        this.awvehicleCount = getIntent().getIntExtra(Constants.EXTRA_AWARD_PENDING_COUNT, 0);
        String stringExtra = getIntent().getStringExtra(Constants.EXTRA_TOBPAID_TOTAL_DUE);
        this.total_aw_amount = getIntent().getStringExtra(Constants.EXTRA_TOBPAID_AW_AMOUNT);
        this.isMyItemsOnly = getIntent().getBooleanExtra("isMyItemOnly", false);
        updateTotalDueValue(stringExtra);
        if (this.vehicleCount <= 0) {
            this.empty.setVisibility(0);
            this.lytProceedToPayment.setVisibility(8);
        } else {
            this.empty.setVisibility(8);
        }
        this.isMyItemOnlyString = getIntent().getStringExtra(Constants.EXTRA_TOBPAID_MY_VEHICLES_ONLY);
        this.selectedSort = ToBePaidSortOptions.SORT_BY_DEFAULTC;
        this.recyclerView = findViewById(C2723R.C2726id.mdpresale_list);
        this.simpleItemRecyclerViewAdapter = new SimpleItemRecyclerViewAdapter(this);
        setupRecyclerView((RecyclerView) this.recyclerView);
        RecyclerView recyclerView2 = (RecyclerView) this.recyclerView;
        recyclerView2.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(linearLayoutManager);
        this.endlessRecyclerViewScrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            public void onLoadMore(int i, int i2) {
                if (MDToBePaidListActivity.this.branchSelected == null || (MDToBePaidListActivity.this.branchSelected != null && MDToBePaidListActivity.this.branchSelected.BranchCode.equals("0"))) {
                    MDToBePaidListActivity.this.vehicles.add((Object) null);
                    MDToBePaidListActivity.this.simpleItemRecyclerViewAdapter.notifyItemInserted(MDToBePaidListActivity.this.vehicles.size() - 1);
                    MDToBePaidListActivity.this.loadData((String) null, true);
                }
            }
        };
        recyclerView2.addOnScrollListener(this.endlessRecyclerViewScrollListener);
        if (findViewById(C2723R.C2726id.mdpresale_detail_container) != null) {
            this.mTwoPane = true;
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
        LocalBroadcastManager.getInstance(this).registerReceiver(this.mMessageReceiver, new IntentFilter("filter-applied"));
        if (bundle != null) {
            retainVariablesValueAfterOrienationChange(bundle);
        } else {
            loadData((String) null, false);
        }
    }

    private void retainVariablesValueAfterOrienationChange(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 24) {
            bundle = IaaiApplication.getSavedInstance(2);
        }
        if (bundle != null) {
            if (bundle.getBoolean(KEY_EMPTY_VISIBLE)) {
                this.empty.setVisibility(0);
            } else {
                this.empty.setVisibility(8);
            }
            this.selected_index = bundle.getInt(KEY_SELECTED_INDEX);
            this.totalbidAmount = bundle.getInt(KEY_TOTAL_BID_AMOUNT);
            this.vehicles = bundle.getParcelableArrayList(KEY_VEHICLE_LIST_DATA);
            this.isAfc = bundle.getBoolean(KEY_ISAFC_BOOL);
            this.isIpay = bundle.getBoolean(KEY_ISIAPY);
            this.isIpayError = bundle.getBoolean(KEY_IS_PAY_ERROR);
            this.isAFCError = bundle.getBoolean(KEY_IS_AFC_ERROR);
            this.isMyItemsOnly = bundle.getBoolean(KEY_IS_MY_ITEM_OLNY);
            this.iPayLimit = bundle.getString(KEY_IAPY_LIMIT);
            this.afcLimit = bundle.getString(KEY_AFC_LIMIT);
            this.iPayDailyAllowance = bundle.getString(KEY_IPAY_DALIY_ALLOWANCE);
            this.afcError = bundle.getString(KEY_AFC_ERROR);
            this.isMyItemOnlyString = bundle.getString(KEY_ISMYITEM_ONLY_STRING);
            this.total_aw_amount = bundle.getString(KEY_TOTAL_AW_AMOUNT);
            this.vehicleCount = bundle.getInt(KEY_VEHICLE_COUNT);
            this.awvehicleCount = bundle.getInt(KEY_AW_VEHICLE_COUNT);
            this.branchSelected = (ToBePaidBranchFilter) bundle.getParcelable(KEY_BRANCH_SLELECTED_PARCEABLE);
            this.paymentInfo = (CompletePaymentInfo) bundle.getParcelable(KEY_PAYMENT_INFO_PARCEABLE);
            this.branchList = bundle.getParcelableArrayList(KEY_BRANCH_LIST_PARCELABLE);
            this.selectedSort = (ToBePaidSortOptions) bundle.getSerializable(KEY_SELECTED_SORT);
            this.toBePaidInfo = (ToBePaidInfo) bundle.getParcelable(KEY_TOBEPAID_INFO_SERILIZE);
            ArrayList<ToBePaidVehicle> arrayList = this.vehicles;
            if (arrayList == null) {
                loadData((String) null, false);
                return;
            }
            this.simpleItemRecyclerViewAdapter.setUpVehicleListData(arrayList);
            this.sortBy = bundle.getString(KEY_SORT_BY);
            loadDailyLimits(Constants.PAYMENT_OPTION_AFC);
            updateSortNFilterText(this.sortBy);
        }
    }

    private void updateTotalDueValue(String str) {
        if (str == null || str.length() <= 0) {
            this.total_due_Spanable = new SpannableString("");
        } else {
            this.total_due_Spanable = new SpannableString(str);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(KEY_EMPTY_VISIBLE, this.empty.isShown());
        bundle.putInt(KEY_SELECTED_INDEX, this.selected_index);
        bundle.putInt(KEY_TOTAL_BID_AMOUNT, this.totalbidAmount);
        bundle.putParcelableArrayList(KEY_VEHICLE_LIST_DATA, this.vehicles);
        bundle.putString(KEY_SORT_BY, this.sortBy);
        bundle.putBoolean(KEY_ISAFC_BOOL, this.isAfc);
        bundle.putBoolean(KEY_ISIAPY, this.isIpay);
        bundle.putBoolean(KEY_IS_PAY_ERROR, this.isIpayError);
        bundle.putBoolean(KEY_IS_AFC_ERROR, this.isAFCError);
        bundle.putBoolean(KEY_IS_MY_ITEM_OLNY, this.isMyItemsOnly);
        bundle.putString(KEY_IAPY_LIMIT, this.iPayLimit);
        bundle.putString(KEY_AFC_LIMIT, this.afcLimit);
        bundle.putString(KEY_IPAY_DALIY_ALLOWANCE, this.iPayDailyAllowance);
        bundle.putString(KEY_AFC_ERROR, this.afcError);
        bundle.putString(KEY_ISMYITEM_ONLY_STRING, this.isMyItemOnlyString);
        bundle.putString(KEY_TOTAL_AW_AMOUNT, this.total_aw_amount);
        bundle.putInt(KEY_VEHICLE_COUNT, this.vehicleCount);
        bundle.putInt(KEY_AW_VEHICLE_COUNT, this.awvehicleCount);
        bundle.putParcelable(KEY_BRANCH_SLELECTED_PARCEABLE, this.branchSelected);
        bundle.putParcelable(KEY_PAYMENT_INFO_PARCEABLE, this.paymentInfo);
        bundle.putParcelableArrayList(KEY_BRANCH_LIST_PARCELABLE, (ArrayList) this.branchList);
        bundle.putSerializable(KEY_SELECTED_SORT, this.selectedSort);
        bundle.putParcelable(KEY_TOBEPAID_INFO_SERILIZE, this.toBePaidInfo);
        if (Build.VERSION.SDK_INT >= 24) {
            IaaiApplication.putSavedInstance(2, bundle);
            bundle.clear();
            return;
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: private */
    public void sortWatchList(String str, boolean z, boolean z2) {
        this.sortWithDirection = str;
        String updateSortNFilterText = updateSortNFilterText(str);
        if (z) {
            this.simpleItemRecyclerViewAdapter.setUpVehicleListData((List<ToBePaidVehicle>) null);
        }
        this.selectedSort = ToBePaidSortOptions.fromWSString(updateSortNFilterText);
        loadData((String) null, false);
    }

    private String updateSortNFilterText(String str) {
        this.sortWithDirection = str;
        int i = 0;
        int i2 = -1;
        for (Map.Entry next : IaaiApplication.selectedFilters.entrySet()) {
            if (next.getKey().equals("sort")) {
                i2 = Integer.parseInt((String) next.getValue());
            }
            if (next.getKey().equals(Constants.KEY_FOR_TOBEPAID_BRANCH_FILTER_SELECTION)) {
                i = Integer.parseInt((String) next.getValue());
            }
        }
        List<ToBePaidBranchFilter> list = this.branchList;
        if (list != null) {
            this.branchSelected = list.get(i);
        }
        switch (i2) {
            case 0:
                String str2 = str + " Ascending";
                this.sortWithDirection = getString(C2723R.string.lbl_srt_bidder);
                this.SORT_DIRECTION = 0;
                return str2;
            case 1:
                String str3 = str + " Descending";
                this.sortWithDirection = getString(C2723R.string.lbl_srt_bidder);
                this.SORT_DIRECTION = 1;
                return str3;
            case 2:
                String str4 = str + " Ascending";
                this.sortWithDirection = getString(C2723R.string.lbl_srt_branch);
                this.SORT_DIRECTION = 0;
                return str4;
            case 3:
                String str5 = str + " Descending";
                this.sortWithDirection = getString(C2723R.string.lbl_srt_branch);
                this.SORT_DIRECTION = 1;
                return str5;
            case 4:
                String str6 = str + " Ascending";
                this.sortWithDirection = getString(C2723R.string.lbl_srt_due_date);
                this.SORT_DIRECTION = 0;
                return str6;
            case 5:
                String str7 = str + " Descending";
                this.sortWithDirection = getString(C2723R.string.lbl_srt_due_date);
                this.SORT_DIRECTION = 1;
                return str7;
            case 6:
                String str8 = str + " Ascending";
                this.sortWithDirection = getString(C2723R.string.lbl_srt_total_price);
                this.SORT_DIRECTION = 0;
                return str8;
            case 7:
                String str9 = str + " Descending";
                this.sortWithDirection = getString(C2723R.string.lbl_srt_total_price);
                this.SORT_DIRECTION = 1;
                return str9;
            default:
                String str10 = str + " Ascending";
                this.sortWithDirection = getString(C2723R.string.lbl_srt_due_date);
                this.SORT_DIRECTION = 0;
                return str10;
        }
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

    /* access modifiers changed from: private */
    public void loadData(String str, final boolean z) {
        int i;
        ToBePaidBranchFilter toBePaidBranchFilter = this.branchSelected;
        if (toBePaidBranchFilter != null) {
            str = toBePaidBranchFilter.BranchCode;
        }
        String str2 = str;
        if (this.selectedSort == null) {
            this.selectedSort = ToBePaidSortOptions.SORT_BY_DEFAULTC;
        }
        SimpleItemRecyclerViewAdapter simpleItemRecyclerViewAdapter2 = this.simpleItemRecyclerViewAdapter;
        if (simpleItemRecyclerViewAdapter2 != null) {
            i = simpleItemRecyclerViewAdapter2.getItemCount();
        } else {
            i = 0;
        }
        if (i != 0) {
            i -= 3;
        }
        if (!z) {
            this.progressBar.setVisibility(0);
        }
        int i2 = (str2 == null || str2.equals("0")) ? i + 30 : 2000;
        this.toBePaidManager.loadToBePaidInfoWithPagination(this.isMyItemOnlyString, "" + (i + 1), "" + i2, this.selectedSort, Constants.PAYMENT_OPTION_ACH, str2, new AsyncHttpResponseHandler() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                Gson gson = new Gson();
                String str = new String(bArr);
                try {
                    MDToBePaidListActivity.this.toBePaidInfo = (ToBePaidInfo) gson.fromJson(str, ToBePaidInfo.class);
                } catch (Exception e) {
                    MDToBePaidListActivity.this.progressBar.setVisibility(8);
                    e.printStackTrace();
                }
                if (MDToBePaidListActivity.this.toBePaidInfo != null) {
                    if (MDToBePaidListActivity.this.toBePaidInfo.getTobePaidList() == null || MDToBePaidListActivity.this.toBePaidInfo.getTobePaidList().size() <= 0) {
                        if (MDToBePaidListActivity.this.vehicles != null) {
                            MDToBePaidListActivity.this.vehicles.remove(MDToBePaidListActivity.this.vehicles.size() - 1);
                            MDToBePaidListActivity.this.simpleItemRecyclerViewAdapter.notifyItemRemoved(MDToBePaidListActivity.this.vehicles.size());
                            MDToBePaidListActivity.this.simpleItemRecyclerViewAdapter.notifyDataSetChanged();
                        }
                        if (!z) {
                            MDToBePaidListActivity.this.empty.setVisibility(0);
                        }
                    } else {
                        MDToBePaidListActivity.this.empty.setVisibility(8);
                        if (MDToBePaidListActivity.this.vehicles != null) {
                            MDToBePaidListActivity.this.vehicles.remove(MDToBePaidListActivity.this.vehicles.size() - 1);
                            MDToBePaidListActivity.this.simpleItemRecyclerViewAdapter.notifyItemRemoved(MDToBePaidListActivity.this.vehicles.size());
                            MDToBePaidListActivity.this.simpleItemRecyclerViewAdapter.notifyDataSetChanged();
                        }
                        if (z) {
                            MDToBePaidListActivity.this.vehicles.addAll(MDToBePaidListActivity.this.toBePaidInfo.getTobePaidList());
                        } else {
                            MDToBePaidListActivity mDToBePaidListActivity = MDToBePaidListActivity.this;
                            mDToBePaidListActivity.vehicles = (ArrayList) mDToBePaidListActivity.toBePaidInfo.getTobePaidList();
                        }
                        MDToBePaidListActivity.this.simpleItemRecyclerViewAdapter.setUpVehicleListData(MDToBePaidListActivity.this.vehicles);
                        if (!z) {
                            Animation loadAnimation = AnimationUtils.loadAnimation(MDToBePaidListActivity.this, C2723R.anim.custom_push_left_in_animation);
                            loadAnimation.setDuration(750);
                            MDToBePaidListActivity.this.recyclerView.startAnimation(loadAnimation);
                        }
                        MDToBePaidListActivity.this.endlessRecyclerViewScrollListener.setLoaded();
                        MDToBePaidListActivity.this.paymentInfo.isIpay = MDToBePaidListActivity.this.toBePaidInfo.isIPay();
                        MDToBePaidListActivity.this.paymentInfo.iPayRemaining = MDToBePaidListActivity.this.toBePaidInfo.getDailyBalance();
                        MDToBePaidListActivity.this.paymentInfo.iPayDailyAllowance = MDToBePaidListActivity.this.toBePaidInfo.getDailyAllowance();
                        MDToBePaidListActivity.this.loadDailyLimits(Constants.PAYMENT_OPTION_AFC);
                    }
                    if (!z) {
                        MDToBePaidListActivity.this.progressBar.setVisibility(8);
                    }
                }
            }

            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                Toast.makeText(MDToBePaidListActivity.this.getApplicationContext(), C2723R.string.msg_network_error, 0).show();
                MDToBePaidListActivity.this.progressBar.setVisibility(8);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void loadDailyLimits(String str) {
        if (this.isAfc) {
            this.toBePaidManager.loadToBePaidInfo(this.isMyItemOnlyString, this.selectedSort, str, (String) null, new AsyncHttpResponseHandler() {
                public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                    ToBePaidInfo toBePaidInfo = (ToBePaidInfo) new Gson().fromJson(new String(bArr), ToBePaidInfo.class);
                    MDToBePaidListActivity.this.paymentInfo.isAfc = MDToBePaidListActivity.this.toBePaidInfo.isAFC();
                    if (MDToBePaidListActivity.this.toBePaidInfo.isAFC()) {
                        MDToBePaidListActivity.this.paymentInfo.afcCredit = MDToBePaidListActivity.this.toBePaidInfo.getAFCResponseList().getAvailableCredit();
                    }
                    MDToBePaidListActivity mDToBePaidListActivity = MDToBePaidListActivity.this;
                    mDToBePaidListActivity.updatePaymentInformation(mDToBePaidListActivity.paymentInfo, toBePaidInfo);
                }

                public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                    ToBePaidInfo toBePaidInfo = new ToBePaidInfo();
                    toBePaidInfo.isAFC = true;
                    toBePaidInfo.AFCResponseList = new ToBePaidAFCResponse();
                    toBePaidInfo.AFCResponseList.ErrorFlag = 1;
                    toBePaidInfo.AFCResponseList.AvailableCredit = BigDecimal.ZERO;
                    MDToBePaidListActivity.this.paymentInfo.isAfc = true;
                    MDToBePaidListActivity mDToBePaidListActivity = MDToBePaidListActivity.this;
                    mDToBePaidListActivity.updatePaymentInformation(mDToBePaidListActivity.paymentInfo, toBePaidInfo);
                    Toast.makeText(MDToBePaidListActivity.this, C2723R.string.msg_network_error, 0).show();
                }
            }, false);
            return;
        }
        CompletePaymentInfo completePaymentInfo = this.paymentInfo;
        completePaymentInfo.isAfc = false;
        updatePaymentInformation(completePaymentInfo, (ToBePaidInfo) null);
    }

    public void changeButtonNamesAFC(ToBePaidInfo toBePaidInfo2) {
        if (toBePaidInfo2 == null) {
            this.isAfc = false;
        } else if (!this.sessionManager.isCurrentSessionUserAFCEligiable()) {
            this.isAfc = false;
        } else if (!toBePaidInfo2.isAFC() || toBePaidInfo2.getAFCResponseList().getErrorFlag() == 2 || !this.sessionManager.isCurrentSessionUserOwner()) {
            this.isAfc = false;
        } else if (this.sessionManager.isCurrentSessionUserOwner() && (toBePaidInfo2.getAFCResponseList().getAvailableCredit().floatValue() <= 0.0f || toBePaidInfo2.getAFCResponseList().getErrorFlag() != 0)) {
            this.isAfc = true;
            this.afcLimit = UiUtils.formatCurrency(toBePaidInfo2.getAFCResponseList().getAvailableCredit());
            if (toBePaidInfo2.getAFCResponseList().getErrorFlag() == 0 && toBePaidInfo2.getAFCResponseList().getAvailableCredit().floatValue() == 0.0f) {
                this.isAFCError = true;
                this.afcError = String.format(getAFCErrorMessage(20), new Object[]{toBePaidInfo2.getAFCResponseList().DealerPhone});
            } else if (toBePaidInfo2.getAFCResponseList().getErrorFlag() == 3) {
                this.isAFCError = true;
                this.afcError = String.format(getAFCErrorMessage(toBePaidInfo2.getAFCResponseList().getErrorFlag()), new Object[]{toBePaidInfo2.getAFCResponseList().DealerPhone});
            } else {
                this.isAFCError = true;
                this.afcError = getAFCErrorMessage(toBePaidInfo2.getAFCResponseList().getErrorFlag());
            }
        } else if (this.sessionManager.isCurrentSessionUserOwner()) {
            this.isAfc = true;
            this.afcLimit = UiUtils.formatCurrency(toBePaidInfo2.getAFCResponseList().getAvailableCredit());
            this.isAFCError = false;
        }
    }

    public void updateSelectionMessage() {
        if (this.isIpay || this.isAfc) {
            this.methodSelection.setVisibility(0);
            if (this.isAfc && !this.isIpay) {
                this.paymentInfoSingle.setVisibility(0);
                this.lblCreditRemaining.setText(getString(C2723R.string.lbl_remaining_daily_allowancecol));
                this.valCreditRemaining.setText(this.afcLimit);
                this.paymentLogo.setImageResource(C2723R.C2725drawable.afc_logo);
                this.lytProceedToPayment.setVisibility(8);
                if (this.isAFCError || this.vehicleCount <= 0) {
                    this.errorText.setVisibility(0);
                    this.errorText.setText(this.afcError);
                    addpaddingToLayout(this.creditLimit, 0.0f);
                    this.methodSelection.setBackgroundResource(C2723R.C2725drawable.disable_tablecell_bg);
                    this.paymentLogo.setImageResource(C2723R.C2725drawable.afc_logo_disable);
                    this.txtProceedToPayment.setEnabled(false);
                    this.lblCreditRemaining.setEnabled(false);
                    this.valCreditRemaining.setEnabled(false);
                    this.lytProceedToPayment.setVisibility(8);
                    return;
                }
                this.errorText.setVisibility(8);
                addpaddingToLayout(this.creditLimit, 10.0f);
                this.methodSelection.setBackgroundResource(0);
                this.methodSelection.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        MDToBePaidListActivity.this.openPaymentSelection(Constants.PAYMENT_OPTION_AFC);
                    }
                });
            } else if (this.isIpay && !this.isAfc) {
                this.paymentInfoSingle.setVisibility(0);
                this.lblCreditRemaining.setText(getString(C2723R.string.lbl_remaining_daily_allowancecol));
                this.valCreditRemaining.setText(this.iPayLimit);
                this.paymentLogo.setImageResource(C2723R.C2725drawable.ipay_logo);
                this.lytProceedToPayment.setVisibility(8);
                if (this.isIpayError || this.vehicleCount <= 0) {
                    this.methodSelection.setBackgroundResource(C2723R.C2725drawable.disable_tablecell_bg);
                    this.paymentLogo.setImageResource(C2723R.C2725drawable.ipay_logo_disable);
                    this.txtProceedToPayment.setEnabled(false);
                    this.lblCreditRemaining.setEnabled(false);
                    this.valCreditRemaining.setEnabled(false);
                    this.lytProceedToPayment.setVisibility(8);
                    return;
                }
                this.methodSelection.setBackgroundResource(0);
                this.methodSelection.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        MDToBePaidListActivity.this.openPaymentSelection(Constants.PAYMENT_OPTION_ACH);
                    }
                });
            } else if (this.isAfc && this.isIpay) {
                this.lytProceedToPayment.setVisibility(0);
                this.paymentInfoSingle.setVisibility(8);
                this.methodSelection.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(MDToBePaidListActivity.this, ToBePaidPaymentSelection.class);
                        intent.putExtra(Constants.EXTRA_TOBPAID_MY_VEHICLES_ONLY, MDToBePaidListActivity.this.isMyItemOnlyString);
                        intent.putExtra(Constants.MY_VEHICLES_ONLY_ARG, MDToBePaidListActivity.this.isMyItemOnlyString);
                        intent.putExtra("ipay_balance", MDToBePaidListActivity.this.iPayLimit);
                        intent.putExtra("ipay_allowance", MDToBePaidListActivity.this.iPayDailyAllowance);
                        intent.putExtra("afc_allowance", MDToBePaidListActivity.this.afcLimit);
                        intent.putExtra("is_afc_error", MDToBePaidListActivity.this.isAFCError);
                        intent.putExtra("is_ipay_error", MDToBePaidListActivity.this.isIpayError);
                        intent.putExtra("is_afc_error_text", MDToBePaidListActivity.this.afcError);
                        intent.putExtra(Constants.INTENT_EXTRA_TOBEPAID_VEHICLE_COUNT, MDToBePaidListActivity.this.vehicleCount);
                        intent.putExtra(Constants.BRANCH_FILTER_SELECTION, MDToBePaidListActivity.this.branchSelected);
                        intent.putExtra(Constants.SORTING_OPTION_SELECTION, MDToBePaidListActivity.this.selectedSort);
                        MDToBePaidListActivity.this.startActivity(intent);
                    }
                });
            }
        } else {
            this.methodSelection.setVisibility(8);
            this.dividerLayout.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    public void openPaymentSelection(String str) {
        Intent intent = new Intent(this, ToBePaidSelectionActivity.class);
        intent.putExtra(Constants.EXTRA_PAYMENT_OPTION, str);
        intent.putExtra(Constants.EXTRA_TOBPAID_MY_VEHICLES_ONLY, this.isMyItemOnlyString);
        intent.putExtra(Constants.MY_VEHICLES_ONLY_ARG, this.isMyItemOnlyString);
        intent.putExtra(Constants.SORTING_OPTION_SELECTION, this.selectedSort);
        intent.putExtra(Constants.BRANCH_FILTER_SELECTION, this.branchSelected);
        startActivityForResult(intent, 1);
    }

    public void changeButtonNamesACH(CompletePaymentInfo completePaymentInfo) {
        if (!completePaymentInfo.isIpay) {
            this.isIpay = false;
            this.isIpayError = true;
        } else if (completePaymentInfo.iPayRemaining.floatValue() <= 0.0f) {
            this.isIpay = true;
            this.isIpayError = true;
            this.iPayLimit = removeNegativeValaue(UiUtils.formatCurrency(completePaymentInfo.iPayRemaining));
            this.iPayDailyAllowance = removeNegativeValaue(UiUtils.formatCurrency(completePaymentInfo.iPayDailyAllowance));
        } else {
            this.isIpay = true;
            this.isIpayError = false;
            this.iPayLimit = UiUtils.formatCurrency(completePaymentInfo.iPayRemaining, true);
            this.iPayDailyAllowance = UiUtils.formatCurrency(completePaymentInfo.iPayDailyAllowance);
        }
    }

    private String removeNegativeValaue(String str) {
        return (!str.startsWith("(") || !str.endsWith(")")) ? str : str.replace("(", "-").substring(0, str.length() - 1);
    }

    public void addpaddingToLayout(LinearLayout linearLayout, float f) {
        linearLayout.setPadding(0, (int) ((f * getResources().getDisplayMetrics().density) + 0.5f), 0, 0);
    }

    public void updatePaymentInformation(CompletePaymentInfo completePaymentInfo, ToBePaidInfo toBePaidInfo2) {
        changeButtonNamesACH(completePaymentInfo);
        changeButtonNamesAFC(toBePaidInfo2);
        if (IaaiApplication.is_new_select_payment_enabled) {
            updateNewSelectionMsg();
        } else {
            updateSelectionMessage();
        }
    }

    private void updateNewSelectionMsg() {
        if (this.sessionManager.isCurrentlbsBrokerBidderIndicator()) {
            this.methodSelection.setVisibility(8);
            this.lytProceedToPayment.setVisibility(8);
            this.paymentInfoSingle.setVisibility(8);
            return;
        }
        this.methodSelection.setVisibility(0);
        this.lytProceedToPayment.setVisibility(0);
        this.paymentInfoSingle.setVisibility(8);
        this.methodSelection.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MDToBePaidListActivity.this.lambda$updateNewSelectionMsg$0$MDToBePaidListActivity(view);
            }
        });
    }

    public /* synthetic */ void lambda$updateNewSelectionMsg$0$MDToBePaidListActivity(View view) {
        Intent intent = new Intent(this, BDTPaymentMethodActivity.class);
        intent.putExtra("ipay_balance", this.iPayLimit);
        intent.putExtra("ipay_allowance", this.iPayDailyAllowance);
        intent.putExtra("afc_allowance", this.afcLimit);
        intent.putExtra("is_afc_error_text", this.afcError);
        intent.putExtra("is_afc_error", this.isAFCError);
        intent.putExtra("is_ipay_error", this.isIpayError);
        intent.putExtra(Constants_MVVM.EXTRA_IS_AFC, this.isAfc);
        intent.putExtra(Constants_MVVM.EXTRA_IS_IPAY, this.isIpay);
        intent.putExtra(Constants.EXTRA_TOBPAID_MY_VEHICLES_ONLY, this.isMyItemOnlyString);
        intent.putExtra(Constants.MY_VEHICLES_ONLY_ARG, this.isMyItemOnlyString);
        intent.putExtra(Constants.INTENT_EXTRA_TOBEPAID_VEHICLE_COUNT, this.vehicleCount);
        intent.putExtra(Constants.BRANCH_FILTER_SELECTION, this.branchSelected);
        intent.putExtra(Constants.SORTING_OPTION_SELECTION, this.selectedSort);
        startActivity(intent);
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

    public String getAFCErrorMessage(int i) {
        if (i == 1) {
            return getString(C2723R.string.afc_no_responce);
        }
        if (i == 2) {
            return getString(C2723R.string.afc_delear_not_found);
        }
        if (i == 3) {
            return getString(C2723R.string.afc_no_credit_available);
        }
        if (i == 5) {
            return getString(C2723R.string.afc_no_responce);
        }
        if (i == 6) {
            return getString(C2723R.string.afc_no_responce);
        }
        if (i == 15) {
            return getString(C2723R.string.afc_finance_pending);
        }
        if (i != 20) {
            return getString(C2723R.string.afc_no_credit_available);
        }
        return getString(C2723R.string.afc_no_credit_available);
    }

    public void setMDProductDetailTitle() {
        getSupportActionBar().setTitle((int) C2723R.string.vehicle_detail_title);
    }

    private void setupRecyclerView(@NonNull final RecyclerView recyclerView2) {
        recyclerView2.setAdapter(this.simpleItemRecyclerViewAdapter);
        recyclerView2.addItemDecoration(new SimpleDividerItemDecoration(this));
        this.fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                recyclerView2.smoothScrollToPosition(0);
                MDToBePaidListActivity.this.fab.hide();
            }
        });
        recyclerView2.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 0 && recyclerView.canScrollVertically(-1)) {
                    MDToBePaidListActivity.this.fab.show();
                }
                super.onScrollStateChanged(recyclerView, i);
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                if (i2 > 0 || (i2 < 0 && MDToBePaidListActivity.this.fab.isShown())) {
                    MDToBePaidListActivity.this.fab.hide();
                }
            }
        });
    }

    public class SimpleItemRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
        private static final int TYPE_FOOTER = 3;
        private static final int TYPE_HEADER = 0;
        private static final int TYPE_ITEM = 2;
        private static final int TYPE_TOTAL_DUE = 1;
        Context contextForPicasso;
        String guid;
        private List<ToBePaidVehicle> mValues;

        private boolean isPositionHeader(int i) {
            return i == 0;
        }

        private boolean isPositionTotalDue(int i) {
            return i == 1;
        }

        public SimpleItemRecyclerViewAdapter(Context context) {
            this.contextForPicasso = context;
        }

        public void setUpVehicleListData(List<ToBePaidVehicle> list) {
            this.mValues = list;
            notifyDataSetChanged();
            if (MDToBePaidListActivity.this.toBePaidInfo != null) {
                this.guid = MDToBePaidListActivity.this.toBePaidInfo.getGuidIdentifier();
            }
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                return new VHHeader(LayoutInflater.from(viewGroup.getContext()).inflate(C2723R.C2728layout.sales_list_header, viewGroup, false));
            }
            if (i == 1) {
                return new VHTotalDue(LayoutInflater.from(viewGroup.getContext()).inflate(C2723R.C2728layout.tobe_paid_totaldue_layout, viewGroup, false));
            }
            if (i == 2) {
                return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C2723R.C2728layout.mdpresale_list_content, viewGroup, false));
            }
            if (i == 3) {
                return new VHFooter(LayoutInflater.from(viewGroup.getContext()).inflate(C2723R.C2728layout.load_more_progresbar_layout, viewGroup, false));
            }
            throw new RuntimeException("there is no type that matches the type " + i + " + make sure your using types correctly");
        }

        class VHHeader extends ViewHolder {
            RelativeLayout layout_total;
            TextView txtTitle;
            TextView txttotalbidamount;

            public VHHeader(View view) {
                super(view);
                this.txtTitle = (TextView) view.findViewById(C2723R.C2726id.search_results_filter);
                this.txttotalbidamount = (TextView) view.findViewById(C2723R.C2726id.total_bid_amount);
                this.layout_total = (RelativeLayout) view.findViewById(C2723R.C2726id.layout_total_pending);
            }
        }

        class VHTotalDue extends ViewHolder {
            TextView award_pending_amount;
            TextView total_due_amount;

            public VHTotalDue(View view) {
                super(view);
                this.total_due_amount = (TextView) view.findViewById(C2723R.C2726id.total_due_amount);
                this.award_pending_amount = (TextView) view.findViewById(C2723R.C2726id.award_pending_amount);
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
                setSortFilterText((VHHeader) viewHolder);
            } else if (!(viewHolder instanceof VHFooter)) {
                if (viewHolder instanceof VHTotalDue) {
                    VHTotalDue vHTotalDue = (VHTotalDue) viewHolder;
                    vHTotalDue.award_pending_amount.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            MyVehicleStatus myVehicleStatus = MyVehicleStatus.AWARD_PENDING;
                            Intent intent = new Intent(MDToBePaidListActivity.this, MDAwardPendingListActivity.class);
                            intent.addCategory("android.intent.category.DEFAULT");
                            intent.putExtra("status", myVehicleStatus);
                            intent.putExtra("isMyItemOnly", MDToBePaidListActivity.this.isMyItemsOnly);
                            intent.putExtra(Constants.WATCHING_SIZE, MDToBePaidListActivity.this.awvehicleCount);
                            intent.putExtra(Constants.PRE_SALE_TYPE, Constants.LIST_AWARD_PENDING);
                            MDToBePaidListActivity.this.startActivity(intent);
                        }
                    });
                    vHTotalDue.total_due_amount.setText(MDToBePaidListActivity.this.total_due_Spanable);
                    vHTotalDue.award_pending_amount.setText(MDToBePaidListActivity.this.total_aw_amount);
                } else if (viewHolder instanceof ViewHolder) {
                    int i2 = i - 2;
                    viewHolder.mItem = this.mValues.get(i2);
                    if (viewHolder.mItem != null) {
                        viewHolder.star_image.setVisibility(8);
                        viewHolder.pre_sale_row_1.setText(viewHolder.mItem.getMake());
                        viewHolder.pre_sale_row_2.setTextColor(MDToBePaidListActivity.this.getResources().getColor(C2723R.C2724color.productdtl_action_area_btn_select_color));
                        viewHolder.pre_sale_row_2.setText(UiUtils.formatCurrencyFromString("" + viewHolder.mItem.TotalDue, true));
                        if (viewHolder.mItem.isPartialPaymentInd()) {
                            viewHolder.pre_sale_row_2.setCompoundDrawablesWithIntrinsicBounds(0, 0, C2723R.C2725drawable.ic_partial_payment, 0);
                            viewHolder.pre_sale_row_2.setCompoundDrawablePadding(AppUtils.convertDpToPixels(4.0f, MDToBePaidListActivity.this));
                        } else {
                            viewHolder.pre_sale_row_2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        }
                        viewHolder.pre_sale_row_2_right.setVisibility(0);
                        setDateString(viewHolder);
                        viewHolder.pre_sale_row_3_left.setVisibility(8);
                        viewHolder.pre_sale_row_3_right.setText(viewHolder.mItem.BidderName);
                        viewHolder.pre_sale_row_2.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                SimpleItemRecyclerViewAdapter.this.loadFeesInfo(viewHolder.mItem.RowNumber, SimpleItemRecyclerViewAdapter.this.guid, viewHolder.mItem.getMake(), viewHolder.mItem.isPartialPaymentInd(), viewHolder.mItem.getPartiallyPaid(), viewHolder.mItem.BidAmount);
                            }
                        });
                    }
                    if (viewHolder.mItem.slot == null || Strings.isEmpty(viewHolder.mItem.slot.trim()) || viewHolder.mItem.slot.trim().toLowerCase().contains("tbd")) {
                        viewHolder.pre_sale_row_4.setText(viewHolder.mItem.Branchname);
                    } else {
                        String trim = viewHolder.mItem.slot.trim();
                        if (viewHolder.mItem.AuctionLane != null && viewHolder.mItem.AuctionLane.trim() != "") {
                            viewHolder.pre_sale_row_4.setText(viewHolder.mItem.Branchname + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + viewHolder.mItem.AuctionLane.trim() + "-" + trim);
                        } else if (trim.contains("-")) {
                            viewHolder.pre_sale_row_4.setText(viewHolder.mItem.Branchname + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + trim);
                        } else {
                            viewHolder.pre_sale_row_4.setText(viewHolder.mItem.Branchname + " #" + trim);
                        }
                    }
                    if (TextUtils.isEmpty(viewHolder.mItem.imageurl)) {
                        Picasso.get().load((int) C2723R.C2725drawable.ic_image_na).into(viewHolder.img_vehicle_image);
                    } else {
                        Picasso.get().load(viewHolder.mItem.imageurl).resize(160, 120).onlyScaleDown().placeholder((int) C2723R.C2725drawable.progress_animation).error((int) C2723R.C2725drawable.ic_image_na).into(viewHolder.img_vehicle_image);
                    }
                    if (MDToBePaidListActivity.this.mTwoPane) {
                        if (i2 == MDToBePaidListActivity.this.selected_index) {
                            viewHolder.mView.setSelected(true);
                        } else {
                            viewHolder.mView.setSelected(false);
                        }
                    }
                    viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            SimpleItemRecyclerViewAdapter.this.notifyDataSetChanged();
                            int unused = MDToBePaidListActivity.this.selected_index = i - 2;
                            ToBePaidVehicle toBePaidVehicle = viewHolder.mItem;
                            MDVehicle mDVehicle = new MDVehicle();
                            if (toBePaidVehicle.Itemid == null || TextUtils.isEmpty(toBePaidVehicle.Itemid)) {
                                Toast.makeText(MDToBePaidListActivity.this, MDToBePaidListActivity.this.getString(C2723R.string.unable_to_select_vehicle), 0).show();
                                return;
                            }
                            mDVehicle.itemId = toBePaidVehicle.Itemid;
                            mDVehicle.make = toBePaidVehicle.Make;
                            mDVehicle.model = toBePaidVehicle.Model;
                            mDVehicle.year = toBePaidVehicle.Year;
                            mDVehicle.branchCode = toBePaidVehicle.BranchCode;
                            mDVehicle.branchName = toBePaidVehicle.Branchname;
                            mDVehicle.lane = toBePaidVehicle.AuctionLane;
                            TextView textView = viewHolder.pre_sale_row_1;
                            Bundle bundle = new Bundle();
                            if (mDVehicle.lane == null) {
                                mDVehicle.lane = "";
                            }
                            MDToBePaidListActivity.this.year_make_model_se = viewHolder.mItem.getMake();
                            bundle.putParcelable(Constants.EXTRA_VEHICLE, mDVehicle);
                            bundle.putInt(Constants.EXTRA_PAGE_TYPE, mDVehicle.status);
                            bundle.putInt(Constants.EXTRA_LIST_MODE, MDToBePaidListActivity.this.listMode);
                            bundle.putInt(Constants.EXTRA_POSTSALE_LIST_TYPE, Constants.LIST_TOBE_PAID);
                            bundle.putString(Constants.EXTRA_YEAR_MAKE_MODEL, MDToBePaidListActivity.this.year_make_model_se);
                            bundle.putString(Constants.EXTRA_PAYMENT_DUE, UiUtils.formatCurrency(toBePaidVehicle.TotalDue, true));
                            bundle.putString(Constants.EXTRA_DUE_DATE, toBePaidVehicle.PaymentDueDate);
                            bundle.putString(Constants.EXTRA_PICK_UP_DATE, toBePaidVehicle.PickUpduedate);
                            bundle.putBoolean(Constants.EXTRA_IS_PATRIALLY_PAID, toBePaidVehicle.PartialPaymentInd);
                            if (MDToBePaidListActivity.this.listMode == 0) {
                                bundle.putBoolean(Constants.EXTRA_FROM_FAST, true);
                            } else {
                                bundle.putBoolean(Constants.EXTRA_FROM_FAST, false);
                            }
                            Intent intent = new Intent(MDToBePaidListActivity.this, ProductDetailActivity.class);
                            intent.addCategory("android.intent.category.DEFAULT");
                            intent.putExtra(Constants.EXTRA_ITEM_ID, mDVehicle.itemId);
                            intent.putExtra("isFromSearchVehicle", false);
                            intent.putExtra(Constants.EXTRA_YEAR_MAKE_MODEL, MDToBePaidListActivity.this.year_make_model_se);
                            MDToBePaidListActivity.this.startActivity(intent);
                            MDToBePaidListActivity.this.detailContainer.setVisibility(0);
                            MDToBePaidListActivity.this.fab.setVisibility(4);
                        }
                    });
                }
            }
        }

        public int getItemViewType(int i) {
            if (isPositionHeader(i)) {
                return 0;
            }
            if (isPositionTotalDue(i)) {
                return 1;
            }
            return isPositionFooter(i) ? 3 : 2;
        }

        private boolean isPositionFooter(int i) {
            return this.mValues.get(i + -2) == null;
        }

        public int getItemCount() {
            List<ToBePaidVehicle> list = this.mValues;
            if (list != null) {
                return list.size() + 2;
            }
            return 0;
        }

        private void setSortFilterText(VHHeader vHHeader) {
            String updateSortFilterlabel = updateSortFilterlabel();
            Drawable checkSortWithDirection = checkSortWithDirection(MDToBePaidListActivity.this.sortWithDirection);
            TextView textView = vHHeader.txtTitle;
            textView.setText(updateSortFilterlabel + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            vHHeader.txtTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, checkSortWithDirection, (Drawable) null);
            vHHeader.txtTitle.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    SimpleItemRecyclerViewAdapter.this.createBranchFilter();
                }
            });
        }

        private Drawable checkSortWithDirection(String str) {
            if (str.equalsIgnoreCase(MDToBePaidListActivity.this.getString(C2723R.string.headerDefaultSortAuction)) || str.equalsIgnoreCase(MDToBePaidListActivity.this.getString(C2723R.string.lbl_sort_by_make_desc)) || str.equalsIgnoreCase(MDToBePaidListActivity.this.getString(C2723R.string.lbl_srt_bidder)) || str.equalsIgnoreCase(MDToBePaidListActivity.this.getString(C2723R.string.lbl_srt_branch))) {
                if (MDToBePaidListActivity.this.SORT_DIRECTION == 0) {
                    return MDToBePaidListActivity.this.getResources().getDrawable(C2723R.C2725drawable.ic_sort_alpha_asc_blue);
                }
                return MDToBePaidListActivity.this.getResources().getDrawable(C2723R.C2725drawable.ic_sort_alpha_desc_blue);
            } else if (MDToBePaidListActivity.this.SORT_DIRECTION == 0) {
                return MDToBePaidListActivity.this.getResources().getDrawable(C2723R.C2725drawable.ic_sort_num_asc_blue);
            } else {
                return MDToBePaidListActivity.this.getResources().getDrawable(C2723R.C2725drawable.ic_sort_num_desc_blue);
            }
        }

        private String updateSortFilterlabel() {
            String str = MDToBePaidListActivity.this.getString(C2723R.string.lbl_all) + ", " + MDToBePaidListActivity.this.getString(C2723R.string.lbl_srt_due) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + MDToBePaidListActivity.this.getString(C2723R.string.due_descending);
            if (MDToBePaidListActivity.this.sortWithDirection.equals("") && MDToBePaidListActivity.this.branchSelected == null) {
                return MDToBePaidListActivity.this.getString(C2723R.string.lbl_all) + ", " + MDToBePaidListActivity.this.getString(C2723R.string.lbl_srt_due_date) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
            } else if (!MDToBePaidListActivity.this.sortWithDirection.equals("") && MDToBePaidListActivity.this.branchSelected == null) {
                return MDToBePaidListActivity.this.getString(C2723R.string.lbl_all) + ", " + MDToBePaidListActivity.this.sortWithDirection;
            } else if (!MDToBePaidListActivity.this.sortWithDirection.equals("") || MDToBePaidListActivity.this.branchSelected == null) {
                if (MDToBePaidListActivity.this.sortWithDirection.equals("") || MDToBePaidListActivity.this.branchSelected == null) {
                    return str;
                }
                if (MDToBePaidListActivity.this.branchSelected.BranchCode.equals("0")) {
                    return MDToBePaidListActivity.this.getString(C2723R.string.lbl_all) + ", " + MDToBePaidListActivity.this.sortWithDirection;
                }
                return MDToBePaidListActivity.this.branchSelected.BranchName + ", " + MDToBePaidListActivity.this.sortWithDirection;
            } else if (MDToBePaidListActivity.this.branchSelected.BranchCode.equals("0")) {
                return MDToBePaidListActivity.this.getString(C2723R.string.lbl_all) + ", " + MDToBePaidListActivity.this.getString(C2723R.string.lbl_srt_due_date) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + MDToBePaidListActivity.this.getString(C2723R.string.up_arrow);
            } else {
                return MDToBePaidListActivity.this.branchSelected.BranchName + ", " + MDToBePaidListActivity.this.getString(C2723R.string.lbl_srt_due_date) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + MDToBePaidListActivity.this.getString(C2723R.string.up_arrow);
            }
        }

        public void showFeesDialog(Context context, ArrayList<FeesInfo> arrayList, String str, boolean z, BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            BigDecimal bigDecimal3 = new BigDecimal(0);
            Iterator<FeesInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                bigDecimal3 = bigDecimal3.add(it.next().Feevalue);
            }
            if (bigDecimal2.intValue() != 0) {
                bigDecimal3 = bigDecimal3.add(bigDecimal2);
                FeesInfo feesInfo = new FeesInfo();
                feesInfo.FeeLabel = MDToBePaidListActivity.this.getString(C2723R.string.lbl_srt_bid_amount);
                feesInfo.Feevalue = bigDecimal2;
                arrayList.add(0, feesInfo);
            }
            if (z) {
                bigDecimal3 = bigDecimal3.subtract(bigDecimal);
                FeesInfo feesInfo2 = new FeesInfo();
                feesInfo2.FeeLabel = MDToBePaidListActivity.this.getString(C2723R.string.partially_paid_fees_text);
                feesInfo2.Feevalue = bigDecimal;
                feesInfo2.isPartiallyPaid = true;
                arrayList.add(feesInfo2);
            }
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(C2723R.C2728layout.dialog_tobepaid_fees_layout, (ViewGroup) null);
            ((TextView) linearLayout.findViewById(C2723R.C2726id.txt_fees_total)).setText(UiUtils.formatCurrency(bigDecimal3, true));
            ((ListView) linearLayout.findViewById(C2723R.C2726id.fees_list)).setAdapter(new MDToBePaidFeesAdapter(context, arrayList));
            ((TextView) linearLayout.findViewById(C2723R.C2726id.txt_dailog_year_make_model)).setText(str);
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(C2723R.string.fees_and_taxes);
            builder.setView(linearLayout).setCancelable(true).setPositiveButton(C2723R.string.lbl_OK_lower, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            builder.create().show();
        }

        /* access modifiers changed from: private */
        public void loadFeesInfo(int i, String str, String str2, boolean z, BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            final Dialog showLoadingDialog = MDActivityHelper.showLoadingDialog(MDToBePaidListActivity.this);
            final String str3 = str2;
            final boolean z2 = z;
            final BigDecimal bigDecimal3 = bigDecimal;
            final BigDecimal bigDecimal4 = bigDecimal2;
            int i2 = i;
            String str4 = str;
            MDToBePaidListActivity.this.toBePaidManager.loadToBePaidFeesInfo(MDToBePaidListActivity.this.isMyItemOnlyString, i, str, new AsyncHttpResponseHandler() {
                public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                    Fees fees = (Fees) new Gson().fromJson(new String(bArr), Fees.class);
                    if (fees.FeesList.length > 0) {
                        ArrayList arrayList = new ArrayList(Arrays.asList(fees.FeesList));
                        SimpleItemRecyclerViewAdapter simpleItemRecyclerViewAdapter = SimpleItemRecyclerViewAdapter.this;
                        simpleItemRecyclerViewAdapter.showFeesDialog(MDToBePaidListActivity.this, arrayList, str3, z2, bigDecimal3, bigDecimal4);
                    }
                    showLoadingDialog.dismiss();
                }

                public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                    Toast.makeText(MDToBePaidListActivity.this.getApplicationContext(), C2723R.string.msg_network_error, 0).show();
                    showLoadingDialog.dismiss();
                }
            });
        }

        public void createBranchFilter() {
            final Dialog showLoadingDialog = MDActivityHelper.showLoadingDialog(MDToBePaidListActivity.this);
            MDToBePaidListActivity.this.toBePaidManager.getBranch(MDToBePaidListActivity.this.isMyItemOnlyString, "0", new AsyncHttpResponseHandler() {
                public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                    String str = new String(bArr);
                    Type type = new TypeToken<List<ToBePaidBranchFilter>>() {
                    }.getType();
                    MDToBePaidListActivity.this.branchList = (List) new Gson().fromJson(str, type);
                    SimpleItemRecyclerViewAdapter simpleItemRecyclerViewAdapter = SimpleItemRecyclerViewAdapter.this;
                    ArrayList<String> branchNames = simpleItemRecyclerViewAdapter.getBranchNames(MDToBePaidListActivity.this.branchList);
                    Intent intent = new Intent(MDToBePaidListActivity.this.getApplicationContext(), ToBePaidSortActivity.class);
                    intent.putExtra(Constants.LISTING_TYPE, Constants.LIST_TOBE_PAID);
                    intent.putStringArrayListExtra(Constants.EXTRA_TOBPAID_BRANCH_FILTER, branchNames);
                    MDToBePaidListActivity.this.startActivity(intent);
                    showLoadingDialog.dismiss();
                }

                public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                    Toast.makeText(MDToBePaidListActivity.this.getApplicationContext(), C2723R.string.msg_network_error, 0).show();
                    showLoadingDialog.dismiss();
                }
            });
        }

        public ArrayList<String> getBranchNames(List<ToBePaidBranchFilter> list) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (ToBePaidBranchFilter toBePaidBranchFilter : list) {
                arrayList.add(toBePaidBranchFilter.BranchName);
            }
            return arrayList;
        }

        public void setDateString(ViewHolder viewHolder) {
            ViewHolder viewHolder2 = viewHolder;
            if (viewHolder2.mItem.PaymentDueDate == null) {
                viewHolder2.pre_sale_row_2_right.setText("");
            } else if (viewHolder2.mItem.PaymentDueDate.equals("")) {
                viewHolder2.pre_sale_row_2_right.setText("");
            } else {
                String str = viewHolder2.mItem.PaymentDueDate;
                Date date = null;
                new Date();
                if (str != null) {
                    date = DateHelper.getDate(str);
                    new Date();
                }
                Date resetTodayDateTimeToMidNight = AppUtils.resetTodayDateTimeToMidNight();
                if (date == null || resetTodayDateTimeToMidNight == null) {
                    viewHolder2.pre_sale_row_2_right.setText("");
                } else if (date.compareTo(resetTodayDateTimeToMidNight) > 0) {
                    long time = (date.getTime() - resetTodayDateTimeToMidNight.getTime()) / 86400000;
                    if (time == 0) {
                        String str2 = " | " + this.contextForPicasso.getString(C2723R.string.lbl_srt_due) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.contextForPicasso.getString(C2723R.string.lbl_today);
                        SpannableString spannableString = new SpannableString(str2);
                        spannableString.setSpan(new ForegroundColorSpan(MDToBePaidListActivity.this.getResources().getColor(C2723R.C2724color.tobepickedup_today)), str2.indexOf("|") + 1, str2.length(), 33);
                        viewHolder2.pre_sale_row_2_right.setText(spannableString);
                    } else if (time == 1) {
                        viewHolder2.pre_sale_row_2_right.setText(" | " + this.contextForPicasso.getString(C2723R.string.lbl_srt_due) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.contextForPicasso.getString(C2723R.string.lbl_tomorrow));
                    } else {
                        String format = new SimpleDateFormat(Constants.DATE_PATTERN_MD_LOCATION_SHORT).format(date);
                        viewHolder2.pre_sale_row_2_right.setText(" | " + format);
                    }
                } else if (date.compareTo(resetTodayDateTimeToMidNight) < 0) {
                    long time2 = (resetTodayDateTimeToMidNight.getTime() - date.getTime()) / 86400000;
                    if (time2 == 0) {
                        String str3 = " | " + this.contextForPicasso.getString(C2723R.string.lbl_srt_due) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.contextForPicasso.getString(C2723R.string.lbl_today);
                        SpannableString spannableString2 = new SpannableString(str3);
                        spannableString2.setSpan(new ForegroundColorSpan(MDToBePaidListActivity.this.getResources().getColor(C2723R.C2724color.tobepickedup_today)), str3.indexOf("|") + 1, str3.length(), 33);
                        viewHolder2.pre_sale_row_2_right.setText(spannableString2);
                    } else if (time2 == 1) {
                        String str4 = " | " + this.contextForPicasso.getString(C2723R.string.lbl_yesterday);
                        SpannableString spannableString3 = new SpannableString(str4);
                        spannableString3.setSpan(new ForegroundColorSpan(MDToBePaidListActivity.this.getResources().getColor(C2723R.C2724color.tobepickedup_past_date)), str4.indexOf("|") + 1, str4.length(), 33);
                        viewHolder2.pre_sale_row_2_right.setText(spannableString3);
                    } else {
                        String str5 = " | " + this.contextForPicasso.getString(C2723R.string.tobe_pickedup_passdue) + " (" + time2 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.contextForPicasso.getString(C2723R.string.tobe_pickedup_days) + ")";
                        SpannableString spannableString4 = new SpannableString(str5);
                        spannableString4.setSpan(new ForegroundColorSpan(MDToBePaidListActivity.this.getResources().getColor(C2723R.C2724color.tobepickedup_past_date)), str5.indexOf("|") + 1, str5.length(), 33);
                        viewHolder2.pre_sale_row_2_right.setText(spannableString4);
                    }
                } else if (date.compareTo(resetTodayDateTimeToMidNight) == 0) {
                    String str6 = " | " + this.contextForPicasso.getString(C2723R.string.lbl_srt_due) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.contextForPicasso.getString(C2723R.string.lbl_today);
                    SpannableString spannableString5 = new SpannableString(str6);
                    spannableString5.setSpan(new ForegroundColorSpan(MDToBePaidListActivity.this.getResources().getColor(C2723R.C2724color.tobepickedup_today)), str6.indexOf("|") + 1, str6.length(), 33);
                    viewHolder2.pre_sale_row_2_right.setText(spannableString5);
                }
            }
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final ImageView img_vehicle_image;
            public ToBePaidVehicle mItem;
            public final View mView;
            public final TextView pre_sale_row_1;
            public final TextView pre_sale_row_2;
            public final TextView pre_sale_row_2_right;
            public final TextView pre_sale_row_3_left;
            public final TextView pre_sale_row_3_right;
            public final TextView pre_sale_row_4;
            public final ImageView star_image;

            public ViewHolder(View view) {
                super(view);
                this.mView = view;
                this.pre_sale_row_1 = (TextView) view.findViewById(C2723R.C2726id.pre_sale_row_1);
                this.pre_sale_row_2 = (TextView) view.findViewById(C2723R.C2726id.pre_sale_row_2);
                this.pre_sale_row_2_right = (TextView) view.findViewById(C2723R.C2726id.pre_sale_row_2_right);
                this.pre_sale_row_4 = (TextView) view.findViewById(C2723R.C2726id.pre_sale_row_4);
                this.pre_sale_row_3_left = (TextView) view.findViewById(C2723R.C2726id.pre_sale_row_3_left);
                this.pre_sale_row_3_right = (TextView) view.findViewById(C2723R.C2726id.pre_sale_row_3_right);
                this.img_vehicle_image = (ImageView) view.findViewById(C2723R.C2726id.vehicle_image);
                this.star_image = (ImageView) view.findViewById(C2723R.C2726id.image);
            }

            public String toString() {
                return super.toString() + " '" + this.pre_sale_row_1.getText() + "'";
            }
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

    /* access modifiers changed from: protected */
    public void setMDListTitle() {
        if (this.vehicleCount != 0) {
            ActionBar supportActionBar = getSupportActionBar();
            supportActionBar.setTitle((CharSequence) getTitle() + " (" + this.vehicleCount + ")");
            return;
        }
        getSupportActionBar().setTitle(getTitle());
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
