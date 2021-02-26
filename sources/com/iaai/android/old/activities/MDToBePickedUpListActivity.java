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
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
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
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
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
import com.google.inject.Injector;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.feature.productDetail.ProductDetailActivity;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.managers.ToBePickedUpManager;
import com.iaai.android.old.models.MDVehicle;
import com.iaai.android.old.models.ScopeDetail;
import com.iaai.android.old.models.ToBePickedUpList;
import com.iaai.android.old.models.ToBePickedUpVehicles;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.constants.SortOption;
import com.iaai.android.old.utils.http.RestClient;
import com.iaai.android.old.utils.p016ui.MDActivityHelper;
import com.iaai.android.old.utils.p016ui.SimpleDividerItemDecoration;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.squareup.otto.Bus;
import com.squareup.picasso.Picasso;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import p052cz.msebera.android.httpclient.Header;
import roboguice.util.Strings;

public class MDToBePickedUpListActivity extends MDAbstractActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static String KEY_EMPTY_VISIBLE = "empty_state";
    public static String KEY_IS_SELECT_AVAILABLE = "is_select_available";
    public static String KEY_PULLOUT_AVAILABLE = "is_pullout_available";
    public static String KEY_SELECTED_INDEX = "selected_index";
    public static String KEY_SORT_BY = "sort_by";
    public static String KEY_TOBEPICKED_SIZE = "tobepicked_size";
    public static String KEY_VEHICLE_LIST_DATA = "vehicle_list";
    public static final int LIST_MODE_VEHICLE = 0;
    public int SORT_DIRECTION;
    IaaiApplication application;
    public RestClient client;
    FrameLayout detailContainer;
    @BindView(2131296914)
    TextView empty;
    EndlessRecyclerViewScrollListener endlessRecyclerViewScrollListener;
    @BindView(2131296644)
    FloatingActionButton fab;
    /* access modifiers changed from: private */
    public boolean isMenuOptionNotAvaliable;
    boolean isMyItemOnly;
    /* access modifiers changed from: private */
    public boolean isMyPulloutAvailable;
    private boolean isSelectAvailable;
    /* access modifiers changed from: private */
    public int listMode = 0;
    public boolean mLandscape;
    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String unused = MDToBePickedUpListActivity.this.sortBy = intent.getStringExtra("filter-sort-by");
            if (MDToBePickedUpListActivity.this.mTwoPane) {
                int unused2 = MDToBePickedUpListActivity.this.selected_index = 0;
            }
            MDToBePickedUpListActivity mDToBePickedUpListActivity = MDToBePickedUpListActivity.this;
            mDToBePickedUpListActivity.sortWatchList(mDToBePickedUpListActivity.sortBy, true, false);
        }
    };
    public boolean mTwoPane;
    @BindView(2131297955)
    ProgressBar progressBar;
    View recyclerView;
    RefreshToBePickedUpListReceiver refreshToBePickedUpListReceiver;
    protected final List<ScopeDetail> scopeList = new ArrayList();
    private SortOption selectedSort;
    /* access modifiers changed from: private */
    public int selected_index;
    public SessionManager sessionManager;
    /* access modifiers changed from: private */
    public SimpleItemRecyclerViewAdapter simpleItemRecyclerViewAdapter;
    /* access modifiers changed from: private */
    public String sortBy = "";
    public String sortWithDirection = "";
    ToBePickedUpManager toBePickedUpManager;
    private Toolbar toolbar;
    private int totalToBePicked;
    ArrayList<ToBePickedUpVehicles> vehicles = null;
    String year_make_model_se = "";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_mdpresale_list);
        ButterKnife.bind((Activity) this);
        overridePendingTransition(C2723R.anim.push_left_in, C2723R.anim.no_change);
        Bundle extras = getIntent().getExtras();
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
        this.isMyItemOnly = getIntent().getBooleanExtra("isMyItemOnly", false);
        Bundle extras = getIntent().getExtras();
        this.totalToBePicked = extras.getInt(Constants.WATCHING_SIZE);
        if (extras != null) {
            ActionBar supportActionBar = getSupportActionBar();
            supportActionBar.setTitle((CharSequence) getTitle() + " (" + this.totalToBePicked + ")");
        } else {
            getSupportActionBar().setTitle(getTitle());
        }
        IAASharedPreference.setMyAccountCount(this, Constants.KEY_FOR_TBPU_COUNT_MYACCOUNT, this.totalToBePicked);
        this.application = (IaaiApplication) getApplication();
        Injector injector = this.application.getInjector();
        this.recyclerView = findViewById(C2723R.C2726id.mdpresale_list);
        this.simpleItemRecyclerViewAdapter = new SimpleItemRecyclerViewAdapter(this);
        setupRecyclerView((RecyclerView) this.recyclerView);
        RecyclerView recyclerView2 = (RecyclerView) this.recyclerView;
        recyclerView2.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(linearLayoutManager);
        this.endlessRecyclerViewScrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            public void onLoadMore(int i, int i2) {
                MDToBePickedUpListActivity.this.vehicles.add((Object) null);
                MDToBePickedUpListActivity.this.simpleItemRecyclerViewAdapter.notifyItemInserted(MDToBePickedUpListActivity.this.vehicles.size() - 1);
                MDToBePickedUpListActivity mDToBePickedUpListActivity = MDToBePickedUpListActivity.this;
                mDToBePickedUpListActivity.sortWatchList(mDToBePickedUpListActivity.sortBy, false, true);
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
        this.client = (RestClient) injector.getInstance(RestClient.class);
        this.sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();
        IAASharedPreference.setDashBoardCount(this, Constants_MVVM.KEY_FOR_TBPU_COUNT_MYACCOUNT, this.totalToBePicked);
        this.toBePickedUpManager = (ToBePickedUpManager) injector.getInstance(ToBePickedUpManager.class);
        LocalBroadcastManager.getInstance(this).registerReceiver(this.mMessageReceiver, new IntentFilter("filter-applied"));
        if (Build.VERSION.SDK_INT >= 24) {
            bundle = IaaiApplication.getSavedInstance(3);
        }
        if (bundle != null) {
            if (bundle.getBoolean(KEY_EMPTY_VISIBLE) || this.totalToBePicked <= 0) {
                this.empty.setVisibility(0);
            } else {
                this.empty.setVisibility(8);
            }
            this.selected_index = bundle.getInt(KEY_SELECTED_INDEX);
            this.vehicles = bundle.getParcelableArrayList(KEY_VEHICLE_LIST_DATA);
            this.isSelectAvailable = bundle.getBoolean(KEY_IS_SELECT_AVAILABLE);
            this.isMyPulloutAvailable = bundle.getBoolean(KEY_PULLOUT_AVAILABLE);
            this.totalToBePicked = bundle.getInt(KEY_TOBEPICKED_SIZE);
            ArrayList<ToBePickedUpVehicles> arrayList = this.vehicles;
            if (arrayList == null) {
                getToBePickedData(false);
            } else {
                this.simpleItemRecyclerViewAdapter.setUpVehicleListData(arrayList);
                this.sortBy = bundle.getString(KEY_SORT_BY);
                updateOptionMenuText(this.sortBy);
            }
        } else {
            if (this.totalToBePicked <= 0) {
                this.empty.setVisibility(0);
            } else {
                this.empty.setVisibility(8);
            }
            getToBePickedData(false);
        }
        this.refreshToBePickedUpListReceiver = new RefreshToBePickedUpListReceiver();
        registerReceiver(this.refreshToBePickedUpListReceiver, new IntentFilter(Constants.INTENT_ACTION_REFRESH_TOBE_PICKEDUP_LIST));
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(KEY_EMPTY_VISIBLE, this.empty.isShown());
        bundle.putInt(KEY_SELECTED_INDEX, this.selected_index);
        bundle.putParcelableArrayList(KEY_VEHICLE_LIST_DATA, this.vehicles);
        bundle.putString(KEY_SORT_BY, this.sortBy);
        bundle.putBoolean(KEY_IS_SELECT_AVAILABLE, this.isSelectAvailable);
        bundle.putBoolean(KEY_PULLOUT_AVAILABLE, this.isMyPulloutAvailable);
        bundle.putInt(KEY_TOBEPICKED_SIZE, this.totalToBePicked);
        if (Build.VERSION.SDK_INT >= 24) {
            IaaiApplication.putSavedInstance(3, bundle);
            bundle.clear();
            return;
        }
        super.onSaveInstanceState(bundle);
    }

    private void getToBePickedDataForSelectionScreen(final boolean z) {
        final Dialog showLoadingDialog = MDActivityHelper.showLoadingDialog(this);
        if (this.selectedSort == null) {
            this.selectedSort = SortOption.SORT_BY_ACTION_DUE_ASC;
        }
        this.toBePickedUpManager.loadToBePickedUpInfoWithSort(this.isMyItemOnly, 1, 2000, this.selectedSort, new AsyncHttpResponseHandler() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                ToBePickedUpList toBePickedUpList = (ToBePickedUpList) new Gson().fromJson(new String(bArr), ToBePickedUpList.class);
                if (toBePickedUpList != null) {
                    MDToBePickedUpListActivity.this.navigateToSelectionScreen(z, toBePickedUpList.vehicleArrayList);
                }
                showLoadingDialog.dismiss();
            }

            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                MDToBePickedUpListActivity mDToBePickedUpListActivity = MDToBePickedUpListActivity.this;
                mDToBePickedUpListActivity.navigateToSelectionScreen(z, mDToBePickedUpListActivity.vehicles);
                showLoadingDialog.dismiss();
            }
        });
    }

    /* access modifiers changed from: private */
    public void getToBePickedData(final boolean z) {
        SimpleItemRecyclerViewAdapter simpleItemRecyclerViewAdapter2 = this.simpleItemRecyclerViewAdapter;
        int itemCount = simpleItemRecyclerViewAdapter2 != null ? simpleItemRecyclerViewAdapter2.getItemCount() : 0;
        if (itemCount != 0) {
            itemCount -= this.isMyPulloutAvailable ? 3 : 2;
        }
        if (!z) {
            this.progressBar.setVisibility(0);
        }
        if (this.selectedSort == null) {
            this.selectedSort = SortOption.SORT_BY_ACTION_DUE_ASC;
        }
        this.toBePickedUpManager.loadToBePickedUpInfoWithSort(this.isMyItemOnly, itemCount + 1, 30, this.selectedSort, new AsyncHttpResponseHandler() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                ToBePickedUpList toBePickedUpList = (ToBePickedUpList) new Gson().fromJson(new String(bArr), ToBePickedUpList.class);
                if (toBePickedUpList != null) {
                    MDToBePickedUpListActivity.this.handleToBePickedUpData(toBePickedUpList, z);
                }
            }

            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                if (!z) {
                    MDToBePickedUpListActivity.this.progressBar.setVisibility(8);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void sortWatchList(String str, boolean z, boolean z2) {
        this.sortWithDirection = str;
        this.selectedSort = SortOption.fromWSString(updateOptionMenuText(str));
        if (z) {
            this.simpleItemRecyclerViewAdapter.setUpVehicleListData((List<ToBePickedUpVehicles>) null);
        }
        getToBePickedData(z2);
    }

    private String updateOptionMenuText(String str) {
        this.sortWithDirection = str;
        int i = -1;
        for (Map.Entry next : IaaiApplication.selectedFilters.entrySet()) {
            if (next.getKey().equals("sort")) {
                i = Integer.parseInt((String) next.getValue());
            }
        }
        if (i == 0) {
            String str2 = str + " Ascending";
            this.sortWithDirection = getString(C2723R.string.lbl_srt_branch);
            this.SORT_DIRECTION = 0;
            return str2;
        } else if (i == 1) {
            String str3 = str + " Descending";
            this.sortWithDirection = getString(C2723R.string.lbl_srt_branch);
            this.SORT_DIRECTION = 1;
            return str3;
        } else if (i == 2) {
            String str4 = str + " Ascending";
            this.sortWithDirection = getString(C2723R.string.filter_option_action_due);
            this.SORT_DIRECTION = 0;
            return str4;
        } else if (i != 3) {
            this.sortWithDirection = getString(C2723R.string.filter_option_action_due);
            this.SORT_DIRECTION = 0;
            return "ActionDue Ascending";
        } else {
            String str5 = str + " Descending";
            this.sortWithDirection = getString(C2723R.string.filter_option_action_due);
            this.SORT_DIRECTION = 1;
            return str5;
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.refreshToBePickedUpListReceiver);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mMessageReceiver);
        if (isFinishing()) {
            IaaiApplication.selectedFilters.clear();
            IaaiApplication.isfromDateSelected = false;
            IaaiApplication.isToDateSelected = false;
            IaaiApplication.isLaneFilterSelected = false;
            IaaiApplication.isFirstTimeForFilterDone = false;
        }
    }

    private void setupRecyclerView(@NonNull final RecyclerView recyclerView2) {
        recyclerView2.setAdapter(this.simpleItemRecyclerViewAdapter);
        recyclerView2.addItemDecoration(new SimpleDividerItemDecoration(this));
        this.fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                recyclerView2.smoothScrollToPosition(0);
                MDToBePickedUpListActivity.this.fab.hide();
            }
        });
        recyclerView2.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 0 && recyclerView.canScrollVertically(-1)) {
                    MDToBePickedUpListActivity.this.fab.show();
                }
                super.onScrollStateChanged(recyclerView, i);
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                if (i2 > 0 || (i2 < 0 && MDToBePickedUpListActivity.this.fab.isShown())) {
                    MDToBePickedUpListActivity.this.fab.hide();
                }
            }
        });
    }

    public class SimpleItemRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
        private int TYPE_FOOTER = 0;
        private int TYPE_HEADER = 0;
        private int TYPE_ITEM = 0;
        private int TYPE_MY_PULLOUT = 0;
        Context contextForPicasso;
        private List<ToBePickedUpVehicles> mValues;

        private boolean isPositionHeader(int i) {
            return i == 0;
        }

        private boolean isPositionMyPullout(int i) {
            return i == 1;
        }

        public SimpleItemRecyclerViewAdapter(Context context) {
            this.contextForPicasso = context;
            if (MDToBePickedUpListActivity.this.isMyPulloutAvailable) {
                this.TYPE_HEADER = 0;
                this.TYPE_MY_PULLOUT = 1;
                this.TYPE_ITEM = 2;
                this.TYPE_FOOTER = 3;
                return;
            }
            this.TYPE_HEADER = 0;
            this.TYPE_MY_PULLOUT = 99;
            this.TYPE_ITEM = 1;
            this.TYPE_FOOTER = 2;
        }

        public void setUpVehicleListData(List<ToBePickedUpVehicles> list) {
            this.mValues = list;
            notifyDataSetChanged();
        }

        public void clearAdapter() {
            this.mValues.clear();
            notifyDataSetChanged();
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == this.TYPE_HEADER) {
                return new VHHeader(LayoutInflater.from(viewGroup.getContext()).inflate(C2723R.C2728layout.sales_list_header, viewGroup, false));
            }
            if (i == this.TYPE_ITEM) {
                return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C2723R.C2728layout.mdpresale_list_content, viewGroup, false));
            }
            if (i == this.TYPE_MY_PULLOUT) {
                return new VHMyPullout(LayoutInflater.from(viewGroup.getContext()).inflate(C2723R.C2728layout.md_tobepicked_my_pullout, viewGroup, false));
            }
            if (i == this.TYPE_FOOTER) {
                return new VHFooter(LayoutInflater.from(viewGroup.getContext()).inflate(C2723R.C2728layout.load_more_progresbar_layout, viewGroup, false));
            }
            throw new RuntimeException("there is no type that matches the type " + i + " + make sure your using types correctly");
        }

        class VHHeader extends ViewHolder {
            TextView txtTitle;

            public VHHeader(View view) {
                super(view);
                this.txtTitle = (TextView) view.findViewById(C2723R.C2726id.search_results_filter);
            }
        }

        class VHMyPullout extends ViewHolder {
            TextView txtMyPullout;

            public VHMyPullout(View view) {
                super(view);
                this.txtMyPullout = (TextView) view.findViewById(C2723R.C2726id.edt_md_my_pullout);
            }
        }

        class VHFooter extends ViewHolder {
            ProgressBar progressBar;

            public VHFooter(View view) {
                super(view);
                this.progressBar = (ProgressBar) view.findViewById(C2723R.C2726id.progressBar1);
            }
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            final ViewHolder viewHolder2 = viewHolder;
            final int i2 = i;
            String str = "";
            Date date = null;
            if (viewHolder2 instanceof VHHeader) {
                VHHeader vHHeader = (VHHeader) viewHolder2;
                if (MDToBePickedUpListActivity.this.sortWithDirection.equals(str)) {
                    vHHeader.txtTitle.setText(MDToBePickedUpListActivity.this.getString(C2723R.string.filter_option_action_due) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    vHHeader.txtTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, MDToBePickedUpListActivity.this.getResources().getDrawable(C2723R.C2725drawable.ic_sort_num_asc_blue), (Drawable) null);
                } else {
                    Drawable checkSortWithDirection = checkSortWithDirection(MDToBePickedUpListActivity.this.sortWithDirection);
                    vHHeader.txtTitle.setText(MDToBePickedUpListActivity.this.sortWithDirection + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    vHHeader.txtTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, checkSortWithDirection, (Drawable) null);
                }
                vHHeader.txtTitle.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(MDToBePickedUpListActivity.this.getApplicationContext(), ToBePickedSortActivity.class);
                        intent.putExtra(Constants.LISTING_TYPE, Constants.LIST_TOBE_PICKED);
                        MDToBePickedUpListActivity.this.startActivity(intent);
                    }
                });
            } else if (viewHolder2 instanceof VHMyPullout) {
                ((VHMyPullout) viewHolder2).txtMyPullout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        MDToBePickedUpListActivity.this.startActivity(new Intent(MDToBePickedUpListActivity.this, ToBePickedUpMyPulloutListActivity.class));
                    }
                });
            } else if (!(viewHolder2 instanceof VHFooter) && (viewHolder2 instanceof ViewHolder)) {
                if (MDToBePickedUpListActivity.this.isMyPulloutAvailable) {
                    viewHolder2.mItem = this.mValues.get(i2 - 2);
                } else {
                    viewHolder2.mItem = this.mValues.get(i2 - 1);
                }
                if (viewHolder2.mItem != null) {
                    viewHolder2.pre_sale_row_1.setText(viewHolder2.mItem.toString());
                }
                viewHolder2.star_image.setVisibility(8);
                if (!viewHolder2.mItem.pin.equals("0")) {
                    str = " | " + MDToBePickedUpListActivity.this.getString(C2723R.string.lbl_pin) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + viewHolder2.mItem.pin;
                }
                String str2 = viewHolder2.mItem.actionDate;
                new Date();
                if (str2 != null) {
                    date = MDToBePickedUpListActivity.this.getDate(str2);
                    new Date();
                }
                Date resetTodayDateTimeToMidNight = AppUtils.resetTodayDateTimeToMidNight();
                if (date == null || resetTodayDateTimeToMidNight == null) {
                    viewHolder2.pre_sale_row_2.setText("C.O.D");
                } else if (date.compareTo(resetTodayDateTimeToMidNight) > 0) {
                    long time = (date.getTime() - resetTodayDateTimeToMidNight.getTime()) / 86400000;
                    if (time == 0) {
                        viewHolder2.pre_sale_row_2.setText(MDToBePickedUpListActivity.this.getSpannedString(this.contextForPicasso.getString(C2723R.string.lbl_srt_due) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.contextForPicasso.getString(C2723R.string.lbl_today) + str, false));
                    } else if (time == 1) {
                        viewHolder2.pre_sale_row_2.setText(this.contextForPicasso.getString(C2723R.string.lbl_srt_due) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.contextForPicasso.getString(C2723R.string.lbl_tomorrow) + str);
                    } else {
                        String format = new SimpleDateFormat(Constants.DATE_PATTERN_MD_LOCATION_SHORT).format(date);
                        viewHolder2.pre_sale_row_2.setText(format + str);
                    }
                } else if (date.compareTo(resetTodayDateTimeToMidNight) < 0) {
                    long time2 = (resetTodayDateTimeToMidNight.getTime() - date.getTime()) / 86400000;
                    if (time2 == 0) {
                        viewHolder2.pre_sale_row_2.setText(MDToBePickedUpListActivity.this.getSpannedString(this.contextForPicasso.getString(C2723R.string.lbl_srt_due) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.contextForPicasso.getString(C2723R.string.lbl_today) + str, false));
                    } else if (time2 == 1) {
                        viewHolder2.pre_sale_row_2.setText(MDToBePickedUpListActivity.this.getSpannedString(this.contextForPicasso.getString(C2723R.string.lbl_yesterday) + str, true));
                    } else {
                        viewHolder2.pre_sale_row_2.setText(MDToBePickedUpListActivity.this.getSpannedString(this.contextForPicasso.getString(C2723R.string.tobe_pickedup_passdue) + " (" + time2 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.contextForPicasso.getString(C2723R.string.tobe_pickedup_days) + ")" + str, true));
                    }
                } else if (date.compareTo(resetTodayDateTimeToMidNight) == 0) {
                    viewHolder2.pre_sale_row_2.setText(MDToBePickedUpListActivity.this.getSpannedString(this.contextForPicasso.getString(C2723R.string.lbl_srt_due) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.contextForPicasso.getString(C2723R.string.lbl_today) + str, false));
                }
                if (viewHolder2.mItem.laneItemNumber == null || Strings.isEmpty(viewHolder2.mItem.laneItemNumber.trim()) || viewHolder2.mItem.laneItemNumber.trim().toLowerCase().contains("tbd")) {
                    viewHolder2.pre_sale_row_4.setText(viewHolder2.mItem.branchName);
                } else {
                    viewHolder2.pre_sale_row_4.setText(viewHolder2.mItem.branchName + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + viewHolder2.mItem.laneItemNumber);
                }
                viewHolder2.pre_sale_row_3_left.setVisibility(8);
                viewHolder2.pre_sale_row_3_right.setVisibility(8);
                if (TextUtils.isEmpty(viewHolder2.mItem.imageUrl)) {
                    Picasso.get().load((int) C2723R.C2725drawable.ic_image_na).into(viewHolder2.img_vehicle_image);
                } else {
                    Picasso.get().load(viewHolder2.mItem.imageUrl).resize(160, 120).onlyScaleDown().placeholder((int) C2723R.C2725drawable.progress_animation).error((int) C2723R.C2725drawable.ic_image_na).into(viewHolder2.img_vehicle_image);
                }
                if (MDToBePickedUpListActivity.this.mTwoPane) {
                    if (i2 - (MDToBePickedUpListActivity.this.isMyPulloutAvailable ? 2 : 1) == MDToBePickedUpListActivity.this.selected_index) {
                        viewHolder2.mView.setSelected(true);
                    } else {
                        viewHolder2.mView.setSelected(false);
                    }
                }
                viewHolder2.mView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        SimpleItemRecyclerViewAdapter.this.notifyDataSetChanged();
                        if (MDToBePickedUpListActivity.this.isMyPulloutAvailable) {
                            int unused = MDToBePickedUpListActivity.this.selected_index = i2 - 2;
                        } else {
                            int unused2 = MDToBePickedUpListActivity.this.selected_index = i2 - 1;
                        }
                        ToBePickedUpVehicles toBePickedUpVehicles = viewHolder2.mItem;
                        if (toBePickedUpVehicles.itemId == null || TextUtils.isEmpty(toBePickedUpVehicles.itemId) || toBePickedUpVehicles.itemId.equals("0")) {
                            Toast.makeText(MDToBePickedUpListActivity.this, MDToBePickedUpListActivity.this.getString(C2723R.string.unable_to_select_vehicle), 0).show();
                            return;
                        }
                        TextView textView = viewHolder2.pre_sale_row_1;
                        Bundle bundle = new Bundle();
                        if (toBePickedUpVehicles.laneItemNumber == null) {
                            toBePickedUpVehicles.laneItemNumber = "";
                        }
                        MDVehicle access$900 = MDToBePickedUpListActivity.this.convertToBePickedToMDVehicle(toBePickedUpVehicles);
                        MDToBePickedUpListActivity.this.year_make_model_se = viewHolder2.mItem.toString();
                        bundle.putParcelable(Constants.EXTRA_VEHICLE, access$900);
                        bundle.putInt(Constants.EXTRA_LIST_MODE, MDToBePickedUpListActivity.this.listMode);
                        bundle.putInt(Constants.EXTRA_POSTSALE_LIST_TYPE, Constants.LIST_TOBE_PICKED);
                        bundle.putString(Constants.EXTRA_YEAR_MAKE_MODEL, MDToBePickedUpListActivity.this.year_make_model_se);
                        if (MDToBePickedUpListActivity.this.listMode == 0) {
                            bundle.putBoolean(Constants.EXTRA_FROM_FAST, true);
                        } else {
                            bundle.putBoolean(Constants.EXTRA_FROM_FAST, false);
                        }
                        bundle.putString(Constants.EXTRA_TOBEPICKED_ACTION_DATE, toBePickedUpVehicles.actionDate);
                        Intent intent = new Intent(MDToBePickedUpListActivity.this, ProductDetailActivity.class);
                        intent.addCategory("android.intent.category.DEFAULT");
                        intent.putExtra(Constants.EXTRA_ITEM_ID, toBePickedUpVehicles.itemId);
                        intent.putExtra("isFromSearchVehicle", false);
                        intent.putExtra(Constants.EXTRA_YEAR_MAKE_MODEL, MDToBePickedUpListActivity.this.year_make_model_se);
                        MDToBePickedUpListActivity.this.startActivity(intent);
                        MDToBePickedUpListActivity.this.detailContainer.setVisibility(0);
                        MDToBePickedUpListActivity.this.fab.setVisibility(4);
                        boolean unused3 = MDToBePickedUpListActivity.this.isMenuOptionNotAvaliable = true;
                        MDToBePickedUpListActivity.this.invalidateOptionsMenu();
                    }
                });
            }
        }

        public int getItemViewType(int i) {
            if (isPositionHeader(i)) {
                return this.TYPE_HEADER;
            }
            if (MDToBePickedUpListActivity.this.isMyPulloutAvailable && isPositionMyPullout(i)) {
                return this.TYPE_MY_PULLOUT;
            }
            if (isPositionFooter(i)) {
                return this.TYPE_FOOTER;
            }
            return this.TYPE_ITEM;
        }

        private Drawable checkSortWithDirection(String str) {
            if (str.equalsIgnoreCase(MDToBePickedUpListActivity.this.getString(C2723R.string.headerDefaultSortAuction)) || str.equalsIgnoreCase(MDToBePickedUpListActivity.this.getString(C2723R.string.lbl_sort_by_make_desc)) || str.equalsIgnoreCase(MDToBePickedUpListActivity.this.getString(C2723R.string.lbl_srt_branch)) || str.equalsIgnoreCase(MDToBePickedUpListActivity.this.getString(C2723R.string.lbl_srt_bidder)) || str.equalsIgnoreCase(MDToBePickedUpListActivity.this.getString(C2723R.string.lbl_srt_year_make_model))) {
                if (MDToBePickedUpListActivity.this.SORT_DIRECTION == 0) {
                    return MDToBePickedUpListActivity.this.getResources().getDrawable(C2723R.C2725drawable.ic_sort_alpha_asc_blue);
                }
                return MDToBePickedUpListActivity.this.getResources().getDrawable(C2723R.C2725drawable.ic_sort_alpha_desc_blue);
            } else if (MDToBePickedUpListActivity.this.SORT_DIRECTION == 0) {
                return MDToBePickedUpListActivity.this.getResources().getDrawable(C2723R.C2725drawable.ic_sort_num_asc_blue);
            } else {
                return MDToBePickedUpListActivity.this.getResources().getDrawable(C2723R.C2725drawable.ic_sort_num_desc_blue);
            }
        }

        private boolean isPositionFooter(int i) {
            if (MDToBePickedUpListActivity.this.isMyPulloutAvailable) {
                if (this.mValues.get(i - 2) == null) {
                    return true;
                }
                return false;
            } else if (this.mValues.get(i - 1) == null) {
                return true;
            } else {
                return false;
            }
        }

        public int getItemCount() {
            if (MDToBePickedUpListActivity.this.isMyPulloutAvailable) {
                List<ToBePickedUpVehicles> list = this.mValues;
                if (list != null) {
                    return list.size() + 2;
                }
                return 0;
            }
            List<ToBePickedUpVehicles> list2 = this.mValues;
            if (list2 != null) {
                return list2.size() + 1;
            }
            return 0;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final ImageView img_vehicle_image;
            public ToBePickedUpVehicles mItem;
            public final View mView;
            public final TextView pre_sale_row_1;
            public final TextView pre_sale_row_2;
            public final TextView pre_sale_row_3_left;
            public final TextView pre_sale_row_3_right;
            public final TextView pre_sale_row_4;
            public final ImageView star_image;

            public ViewHolder(View view) {
                super(view);
                this.mView = view;
                this.pre_sale_row_1 = (TextView) view.findViewById(C2723R.C2726id.pre_sale_row_1);
                this.pre_sale_row_2 = (TextView) view.findViewById(C2723R.C2726id.pre_sale_row_2);
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

    /* access modifiers changed from: private */
    public Spannable getSpannedString(String str, boolean z) {
        int i;
        SpannableString spannableString = new SpannableString(str);
        if (z) {
            i = getResources().getColor(C2723R.C2724color.tobepickedup_past_date);
        } else {
            i = getResources().getColor(C2723R.C2724color.tobepickedup_today);
        }
        if (str.contains("|")) {
            spannableString.setSpan(new ForegroundColorSpan(i), 0, str.indexOf("|"), 33);
        } else {
            spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
        }
        return spannableString;
    }

    /* access modifiers changed from: private */
    public MDVehicle convertToBePickedToMDVehicle(ToBePickedUpVehicles toBePickedUpVehicles) {
        MDVehicle mDVehicle = new MDVehicle();
        mDVehicle.itemId = toBePickedUpVehicles.itemId;
        mDVehicle.make = toBePickedUpVehicles.make;
        mDVehicle.model = toBePickedUpVehicles.model;
        mDVehicle.year = toBePickedUpVehicles.year;
        mDVehicle.branchCode = toBePickedUpVehicles.branchNumber;
        mDVehicle.branchName = toBePickedUpVehicles.branchName;
        mDVehicle.lane = toBePickedUpVehicles.laneItemNumber;
        mDVehicle.imageUrl = toBePickedUpVehicles.imageUrl;
        return mDVehicle;
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

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C2723R.C2729menu.md_tobepicked, menu);
        if (this.isMenuOptionNotAvaliable) {
            menu.findItem(C2723R.C2726id.menu_select).setVisible(false);
            menu.findItem(C2723R.C2726id.menu_select_all).setVisible(false);
            menu.findItem(C2723R.C2726id.menu_help).setVisible(false);
            return true;
        } else if (this.isSelectAvailable) {
            return true;
        } else {
            menu.findItem(C2723R.C2726id.menu_select).setVisible(false);
            menu.findItem(C2723R.C2726id.menu_select_all).setVisible(false);
            menu.findItem(C2723R.C2726id.menu_help).setVisible(false);
            return true;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
                    onBackPressed();
                    break;
                } else {
                    finish();
                    overridePendingTransition(C2723R.anim.none, C2723R.anim.push_right_out);
                    break;
                }
            case C2723R.C2726id.menu_help:
                openDialog();
                break;
            case C2723R.C2726id.menu_select:
                if (isSelectButtonEnable(this.vehicles)) {
                    getToBePickedDataForSelectionScreen(false);
                    break;
                }
                break;
            case C2723R.C2726id.menu_select_all:
                if (isSelectButtonEnable(this.vehicles)) {
                    getToBePickedDataForSelectionScreen(true);
                    break;
                }
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    /* access modifiers changed from: private */
    public void navigateToSelectionScreen(boolean z, ArrayList<ToBePickedUpVehicles> arrayList) {
        if (z) {
            Intent intent = new Intent(this, ToBePickedUpSelectionActivity.class);
            intent.putParcelableArrayListExtra("vehiclesList", arrayList);
            intent.putExtra("all_selected", true);
            startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(this, ToBePickedUpSelectionActivity.class);
        intent2.putParcelableArrayListExtra("vehiclesList", arrayList);
        startActivity(intent2);
    }

    private boolean isSelectButtonEnable(ArrayList<ToBePickedUpVehicles> arrayList) {
        if (arrayList != null) {
            Iterator<ToBePickedUpVehicles> it = arrayList.iterator();
            while (it.hasNext()) {
                if (Integer.parseInt(it.next().pin) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void setMDListTitle() {
        if (this.totalToBePicked != 0) {
            ActionBar supportActionBar = getSupportActionBar();
            supportActionBar.setTitle((CharSequence) getTitle() + " (" + this.totalToBePicked + ")");
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
            this.isMenuOptionNotAvaliable = false;
            invalidateOptionsMenu();
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: private */
    public void handleToBePickedUpData(ToBePickedUpList toBePickedUpList, boolean z) {
        if (toBePickedUpList.vehicleArrayList == null || toBePickedUpList.vehicleArrayList.size() <= 0) {
            ArrayList<ToBePickedUpVehicles> arrayList = this.vehicles;
            if (arrayList != null) {
                arrayList.remove(arrayList.size() - 1);
                this.simpleItemRecyclerViewAdapter.notifyItemRemoved(this.vehicles.size());
                this.simpleItemRecyclerViewAdapter.notifyDataSetChanged();
            }
            if (!z) {
                this.empty.setVisibility(0);
            }
        } else {
            this.empty.setVisibility(8);
            ArrayList<ToBePickedUpVehicles> arrayList2 = this.vehicles;
            if (arrayList2 != null) {
                arrayList2.remove(arrayList2.size() - 1);
                this.simpleItemRecyclerViewAdapter.notifyItemRemoved(this.vehicles.size());
                this.simpleItemRecyclerViewAdapter.notifyDataSetChanged();
            }
            if (z) {
                this.vehicles.addAll(toBePickedUpList.vehicleArrayList);
            } else {
                this.vehicles = toBePickedUpList.vehicleArrayList;
            }
            this.simpleItemRecyclerViewAdapter.setUpVehicleListData(this.vehicles);
            if (this.sessionManager.isCurrentSessionUserOwner()) {
                if (toBePickedUpList.branchEnabledForPullout) {
                    this.isSelectAvailable = true;
                    invalidateOptionsMenu();
                } else {
                    this.isSelectAvailable = false;
                    invalidateOptionsMenu();
                }
            }
            if (this.sessionManager.isCurrentSessionUserOwner()) {
                if (toBePickedUpList.ShowMyVehicles) {
                    this.isMyPulloutAvailable = true;
                } else {
                    this.isMyPulloutAvailable = false;
                }
            }
            if (this.sessionManager.isCurrentSessionUserOwner() && toBePickedUpList.branchEnabledForPullout && !IAASharedPreference.getPrefForTips(this)) {
                openDialog();
                IAASharedPreference.setPrefForTips(this, true);
            }
            if (!z) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this, C2723R.anim.custom_push_left_in_animation);
                loadAnimation.setDuration(750);
                this.recyclerView.startAnimation(loadAnimation);
            }
            this.endlessRecyclerViewScrollListener.setLoaded();
        }
        if (!z) {
            this.progressBar.setVisibility(8);
        }
    }

    class RefreshToBePickedUpListReceiver extends BroadcastReceiver {
        RefreshToBePickedUpListReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Constants.INTENT_ACTION_REFRESH_TOBE_PICKEDUP_LIST)) {
                MDToBePickedUpListActivity.this.simpleItemRecyclerViewAdapter.clearAdapter();
                MDToBePickedUpListActivity mDToBePickedUpListActivity = MDToBePickedUpListActivity.this;
                mDToBePickedUpListActivity.vehicles = null;
                mDToBePickedUpListActivity.getToBePickedData(false);
            }
        }
    }

    /* access modifiers changed from: private */
    public Date getDate(String str) {
        try {
            return new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa", Locale.getDefault()).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setMDProductDetailTitle() {
        getSupportActionBar().setTitle((int) C2723R.string.vehicle_detail_title);
    }

    private void openDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View inflate = getLayoutInflater().inflate(C2723R.C2728layout.tips_dialog, (ViewGroup) null);
        builder.setView(inflate);
        builder.setTitle(getString(C2723R.string.lbl_tips_and_tutorials));
        builder.setPositiveButton(getResources().getString(C2723R.string.lbl_close), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        WebView webView = (WebView) inflate.findViewById(C2723R.C2726id.webview);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(true);
            settings.setAllowUniversalAccessFromFileURLs(true);
        }
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAppCacheEnabled(false);
        settings.setCacheMode(2);
        webView.clearHistory();
        webView.clearFormData();
        webView.clearCache(true);
        Uri parse = Uri.parse("file:///android_asset/evp/pullout-tutorial.pdf");
        webView.loadUrl("file:///android_asset/pdfviewer/index.html?file=" + parse);
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                Uri parse = Uri.parse("file:///android_asset/TermsofUse.pdf");
                webView.loadUrl("file:///android_asset/pdfviewer/index.html?file=" + parse);
                return true;
            }
        });
        builder.create().show();
    }
}
