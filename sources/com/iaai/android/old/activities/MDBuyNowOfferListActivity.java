package com.iaai.android.old.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.inject.Injector;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.feature.productDetail.ProductDetailActivity;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.managers.BuyNowOfferListManager;
import com.iaai.android.old.models.BuyNowOffer;
import com.iaai.android.old.models.BuyNowOfferVehicleList;
import com.iaai.android.old.models.MDVehicle;
import com.iaai.android.old.utils.DateFormatThreadLocal;
import com.iaai.android.old.utils.DateHelper;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.http.RestClient;
import com.iaai.android.old.utils.p016ui.SimpleDividerItemDecoration;
import com.iaai.android.old.utils.p016ui.UiUtils;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.squareup.otto.Bus;
import com.squareup.picasso.Picasso;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import p052cz.msebera.android.httpclient.Header;

public class MDBuyNowOfferListActivity extends MDAbstractActivity {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static String KEY_EMPTY_VISIBLE = "empty_state";
    public static String KEY_IS_SELECT_AVAILABLE = "is_select_available";
    public static String KEY_PULLOUT_AVAILABLE = "is_pullout_available";
    public static String KEY_SELECTED_INDEX = "selected_index";
    public static String KEY_TOBEPICKED_SIZE = "tobepicked_size";
    public static String KEY_VEHICLE_LIST_DATA = "vehicle_list";
    public static final int LIST_MODE_VEHICLE = 0;
    public static int buyNowPageSize = 30;
    IaaiApplication application;
    /* access modifiers changed from: private */
    public int buyNowOfferCount;
    BuyNowOfferListManager buyNowOfferListManager;
    String buyNowOfferLocalTime = "";
    String buyNowOfferLocalTimeForVehicleDetail = "";
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
    private boolean isMyPulloutAvailable;
    private boolean isSelectAvailable;
    /* access modifiers changed from: private */
    public int listMode = 0;
    public boolean mLandscape;
    public boolean mTwoPane;
    @BindView(2131297955)
    ProgressBar progressBar;
    View recyclerView;
    /* access modifiers changed from: private */
    public int selected_index;
    public SessionManager sessionManager;
    /* access modifiers changed from: private */
    public SimpleItemRecyclerViewAdapter simpleItemRecyclerViewAdapter;
    private Toolbar toolbar;
    ArrayList<BuyNowOfferVehicleList> vehicles = null;
    String year_make_model_se = "";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_mdbuynowoffer_list);
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
        getIntent();
        Bundle extras = getIntent().getExtras();
        this.buyNowOfferCount = extras.getInt(Constants.KEY_FOR_BUY_NOW_OFFER_COUNT_MYACCOUNT);
        if (extras != null) {
            ActionBar supportActionBar = getSupportActionBar();
            supportActionBar.setTitle((CharSequence) getTitle() + " (" + this.buyNowOfferCount + ")");
        } else {
            getSupportActionBar().setTitle(getTitle());
        }
        this.application = (IaaiApplication) getApplication();
        Injector injector = this.application.getInjector();
        this.sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();
        IAASharedPreference.setDashBoardCount(this, Constants_MVVM.KEY_FOR_BUY_NOW_OFFER_COUNT_MYACCOUNT, this.buyNowOfferCount);
        this.recyclerView = findViewById(C2723R.C2726id.mdpresale_list);
        this.simpleItemRecyclerViewAdapter = new SimpleItemRecyclerViewAdapter(this);
        setupRecyclerView((RecyclerView) this.recyclerView);
        RecyclerView recyclerView2 = (RecyclerView) this.recyclerView;
        recyclerView2.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(linearLayoutManager);
        this.endlessRecyclerViewScrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            public void onLoadMore(int i, int i2) {
                MDBuyNowOfferListActivity.this.vehicles.add((Object) null);
                MDBuyNowOfferListActivity.this.simpleItemRecyclerViewAdapter.notifyItemInserted(MDBuyNowOfferListActivity.this.vehicles.size() - 1);
                try {
                    MDBuyNowOfferListActivity.this.pullBuyNowOfferData(true);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
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
        this.sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();
        this.client = (RestClient) injector.getInstance(RestClient.class);
        this.buyNowOfferListManager = (BuyNowOfferListManager) injector.getInstance(BuyNowOfferListManager.class);
        if (Build.VERSION.SDK_INT >= 24) {
            bundle = IaaiApplication.getSavedInstance(6);
        }
        if (bundle != null) {
            if (bundle.getBoolean(KEY_EMPTY_VISIBLE)) {
                this.empty.setVisibility(0);
            } else {
                this.empty.setVisibility(8);
            }
            this.selected_index = bundle.getInt(KEY_SELECTED_INDEX);
            this.vehicles = bundle.getParcelableArrayList(KEY_VEHICLE_LIST_DATA);
            this.isSelectAvailable = bundle.getBoolean(KEY_IS_SELECT_AVAILABLE);
            this.buyNowOfferCount = bundle.getInt(KEY_TOBEPICKED_SIZE);
            ArrayList<BuyNowOfferVehicleList> arrayList = this.vehicles;
            if (arrayList == null) {
                try {
                    pullBuyNowOfferData(false);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else {
                this.simpleItemRecyclerViewAdapter.setUpVehicleListData(arrayList);
            }
        } else {
            try {
                pullBuyNowOfferData(false);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(KEY_EMPTY_VISIBLE, this.empty.isShown());
        bundle.putInt(KEY_SELECTED_INDEX, this.selected_index);
        bundle.putParcelableArrayList(KEY_VEHICLE_LIST_DATA, this.vehicles);
        bundle.putBoolean(KEY_IS_SELECT_AVAILABLE, this.isSelectAvailable);
        bundle.putBoolean(KEY_PULLOUT_AVAILABLE, this.isMyPulloutAvailable);
        bundle.putInt(KEY_TOBEPICKED_SIZE, this.buyNowOfferCount);
        if (Build.VERSION.SDK_INT >= 24) {
            IaaiApplication.putSavedInstance(3, bundle);
            bundle.clear();
            return;
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: private */
    public void pullBuyNowOfferData(boolean z) throws UnsupportedEncodingException {
        getBuyNowOfferTime(z);
    }

    /* access modifiers changed from: private */
    public void getBuyNowOfferData(final boolean z) throws UnsupportedEncodingException {
        int i = buyNowPageSize;
        SimpleItemRecyclerViewAdapter simpleItemRecyclerViewAdapter2 = this.simpleItemRecyclerViewAdapter;
        int itemCount = simpleItemRecyclerViewAdapter2 != null ? simpleItemRecyclerViewAdapter2.getItemCount() : 0;
        if (itemCount != 0) {
            itemCount--;
        }
        if (!z) {
            this.progressBar.setVisibility(0);
        }
        int i2 = itemCount == 0 ? 1 : itemCount + 1;
        String currentSessionUserId = this.sessionManager.getCurrentSessionUserId();
        if (currentSessionUserId == null) {
            currentSessionUserId = this.sessionManager.getLastLoginUserId();
        }
        try {
            this.buyNowOfferListManager.getBuyNowOfferList(getApplicationContext(), currentSessionUserId, i, i2, new AsyncHttpResponseHandler() {
                public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                    BuyNowOffer buyNowOffer = (BuyNowOffer) new Gson().fromJson(new String(bArr), BuyNowOffer.class);
                    int unused = MDBuyNowOfferListActivity.this.buyNowOfferCount = buyNowOffer.BuyNowOfferCount;
                    if (buyNowOffer.buyNowOfferList != null) {
                        BuyNowOfferVehicleList[] buyNowOfferVehicleListArr = buyNowOffer.buyNowOfferList;
                        ArrayList arrayList = new ArrayList();
                        for (BuyNowOfferVehicleList add : buyNowOfferVehicleListArr) {
                            arrayList.add(add);
                        }
                        if (arrayList.size() > 0 && MDBuyNowOfferListActivity.this.buyNowOfferCount != 0) {
                            MDBuyNowOfferListActivity.this.getSupportActionBar().setTitle((CharSequence) MDBuyNowOfferListActivity.this.getTitle() + " (" + MDBuyNowOfferListActivity.this.buyNowOfferCount + ")");
                        } else if (MDBuyNowOfferListActivity.this.buyNowOfferCount != 0) {
                            MDBuyNowOfferListActivity.this.getSupportActionBar().setTitle((CharSequence) MDBuyNowOfferListActivity.this.getTitle() + " (" + MDBuyNowOfferListActivity.this.buyNowOfferCount + ")");
                        } else {
                            MDBuyNowOfferListActivity.this.getSupportActionBar().setTitle((CharSequence) MDBuyNowOfferListActivity.this.getTitle() + " (" + 0 + ")");
                        }
                        if (buyNowOffer != null) {
                            MDBuyNowOfferListActivity.this.handleBuyNowOfferUpData(arrayList, z);
                            return;
                        }
                        return;
                    }
                    MDBuyNowOfferListActivity.this.progressBar.setVisibility(8);
                    MDBuyNowOfferListActivity.this.empty.setVisibility(0);
                }

                public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                    if (!z) {
                        MDBuyNowOfferListActivity.this.progressBar.setVisibility(8);
                    }
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
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
                MDBuyNowOfferListActivity.this.fab.hide();
            }
        });
        recyclerView2.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 0 && recyclerView.canScrollVertically(-1)) {
                    MDBuyNowOfferListActivity.this.fab.show();
                }
                super.onScrollStateChanged(recyclerView, i);
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                if (i2 > 0 || (i2 < 0 && MDBuyNowOfferListActivity.this.fab.isShown())) {
                    MDBuyNowOfferListActivity.this.fab.hide();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public Date convertStringToDate(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Locale locale = IaaiApplication.getInstance().getResources().getConfiguration().locale;
                if (!locale.getLanguage().startsWith("ar")) {
                    if (!locale.getLanguage().startsWith("ko") && !locale.getLanguage().startsWith(Constants_MVVM.EXTRA_SPANISH_CODE)) {
                        if (!locale.getLanguage().startsWith("ch")) {
                            return ((DateFormat) new DateFormatThreadLocal(Constants.DATE_PATTERN_DATE_TIME).get()).parse(str);
                        }
                    }
                }
                return new SimpleDateFormat(Constants.DATE_PATTERN_DATE_TIME, Locale.ENGLISH).parse(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private void getBuyNowOfferTime(final boolean z) {
        try {
            this.buyNowOfferListManager.getBuyNowOfferTime(this, new AsyncHttpResponseHandler() {
                public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                    String str = new String(bArr);
                    if (str.indexOf(34) != -1) {
                        str = str.substring(1, str.length() - 1);
                    }
                    MDBuyNowOfferListActivity mDBuyNowOfferListActivity = MDBuyNowOfferListActivity.this;
                    mDBuyNowOfferListActivity.buyNowOfferLocalTime = str;
                    Date access$400 = mDBuyNowOfferListActivity.convertStringToDate(mDBuyNowOfferListActivity.buyNowOfferLocalTime);
                    if (access$400 != null) {
                        Date dateInTimeZone = DateHelper.toDateInTimeZone(DateHelper.toDateInTimeZone(access$400, Constants.TIMEZONE_SERVER), Calendar.getInstance().getTimeZone());
                        MDBuyNowOfferListActivity.this.buyNowOfferLocalTime = DateHelper.format(dateInTimeZone, Constants.DATE_PATTERN_DATE_TIME);
                    }
                    String replace = DateHelper.convertFormat(MDBuyNowOfferListActivity.this.buyNowOfferLocalTime, Constants.DATE_PATTERN_DATE_TIME, Constants.DATE_PATTERN_BNO).replace("AM", "am").replace("PM", "pm");
                    MDBuyNowOfferListActivity mDBuyNowOfferListActivity2 = MDBuyNowOfferListActivity.this;
                    mDBuyNowOfferListActivity2.buyNowOfferLocalTimeForVehicleDetail = replace;
                    try {
                        mDBuyNowOfferListActivity2.getBuyNowOfferData(z);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }

                public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                    try {
                        MDBuyNowOfferListActivity.this.getBuyNowOfferData(z);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public class SimpleItemRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
        private int TYPE_FOOTER = 1;
        private int TYPE_ITEM = 0;
        Context contextForPicasso;
        private List<BuyNowOfferVehicleList> mValues;

        public SimpleItemRecyclerViewAdapter(Context context) {
            this.contextForPicasso = context;
        }

        public void setUpVehicleListData(ArrayList<BuyNowOfferVehicleList> arrayList) {
            this.mValues = arrayList;
            notifyDataSetChanged();
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == this.TYPE_ITEM) {
                return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C2723R.C2728layout.mdpresale_list_content, viewGroup, false));
            }
            if (i == this.TYPE_FOOTER) {
                return new VHFooter(LayoutInflater.from(viewGroup.getContext()).inflate(C2723R.C2728layout.load_more_progresbar_layout, viewGroup, false));
            }
            throw new RuntimeException("there is no type that matches the type " + i + " + make sure your using types correctly");
        }

        class VHFooter extends ViewHolder {
            ProgressBar progressBar;

            public VHFooter(View view) {
                super(view);
                this.progressBar = (ProgressBar) view.findViewById(C2723R.C2726id.progressBar1);
            }
        }

        public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
            if (!(viewHolder instanceof VHFooter) && (viewHolder instanceof ViewHolder)) {
                viewHolder.mItem = this.mValues.get(i);
                if (viewHolder.mItem != null) {
                    TextView textView = viewHolder.pre_sale_row_1;
                    textView.setText(viewHolder.mItem.Year + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + viewHolder.mItem.Make + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + viewHolder.mItem.Model);
                    viewHolder.pre_sale_row_2.setText(UiUtils.formatCurrencyFromString(viewHolder.mItem.OfferAmount, false));
                    String replace = DateHelper.convertFormat(MDBuyNowOfferListActivity.this.buyNowOfferLocalTime, Constants.DATE_PATTERN_DATE_TIME, Constants.DATE_PATTERN_BNO).replace("AM", "am").replace("PM", "pm");
                    TextView textView2 = viewHolder.pre_sale_row_3_right;
                    textView2.setText("Expires at " + replace);
                    viewHolder.pre_sale_row_4.setText(viewHolder.mItem.BranchName);
                }
                viewHolder.star_image.setVisibility(8);
                viewHolder.pre_sale_row_3_left.setVisibility(8);
                viewHolder.pre_sale_row_3_right.setVisibility(0);
                Picasso picasso = Picasso.get();
                picasso.load(MDBuyNowOfferListActivity.this.getApplication().getResources().getString(C2723R.string.base_https_url_vehicle_thumbnail) + MDBuyNowOfferListActivity.this.getApplication().getResources().getString(C2723R.string.vehicle_thumbnail_url_for_buy_now_offer, new Object[]{viewHolder.mItem.SalvageId})).placeholder((int) C2723R.C2725drawable.progress_animation).error((int) C2723R.C2725drawable.ic_image_na).into(viewHolder.img_vehicle_image);
                if (MDBuyNowOfferListActivity.this.mTwoPane) {
                    if (i == MDBuyNowOfferListActivity.this.selected_index) {
                        viewHolder.mView.setSelected(true);
                    } else {
                        viewHolder.mView.setSelected(false);
                    }
                }
                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        SimpleItemRecyclerViewAdapter.this.notifyDataSetChanged();
                        int unused = MDBuyNowOfferListActivity.this.selected_index = i;
                        BuyNowOfferVehicleList buyNowOfferVehicleList = viewHolder.mItem;
                        TextView textView = viewHolder.pre_sale_row_1;
                        Bundle bundle = new Bundle();
                        if (buyNowOfferVehicleList.LaneItemNumber == null) {
                            buyNowOfferVehicleList.LaneItemNumber = "";
                        }
                        MDVehicle access$700 = MDBuyNowOfferListActivity.this.convertBuyNowOfferToMDVehicle(buyNowOfferVehicleList);
                        MDBuyNowOfferListActivity mDBuyNowOfferListActivity = MDBuyNowOfferListActivity.this;
                        mDBuyNowOfferListActivity.year_make_model_se = viewHolder.mItem.Year + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + viewHolder.mItem.Make + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + viewHolder.mItem.Model;
                        bundle.putParcelable(Constants.EXTRA_VEHICLE, access$700);
                        bundle.putString(Constants.EXTRA_BUY_NOW_OFFER, buyNowOfferVehicleList.OfferAmount);
                        bundle.putString(Constants.EXTRA_BUY_NOW_OFFER_EXPIRED_TIME, MDBuyNowOfferListActivity.this.buyNowOfferLocalTimeForVehicleDetail);
                        bundle.putInt(Constants.EXTRA_LIST_MODE, MDBuyNowOfferListActivity.this.listMode);
                        bundle.putInt(Constants.EXTRA_POSTSALE_LIST_TYPE, Constants.LIST_TOBE_PICKED);
                        bundle.putString(Constants.EXTRA_YEAR_MAKE_MODEL, MDBuyNowOfferListActivity.this.year_make_model_se);
                        bundle.putBoolean(Constants.EXTRA_FROM_BUY_NOW_OFFER, true);
                        if (MDBuyNowOfferListActivity.this.listMode == 0) {
                            bundle.putBoolean(Constants.EXTRA_FROM_FAST, true);
                        } else {
                            bundle.putBoolean(Constants.EXTRA_FROM_FAST, false);
                        }
                        bundle.putString(Constants.EXTRA_TOBEPICKED_ACTION_DATE, buyNowOfferVehicleList.AuctionCloseTime);
                        Intent intent = new Intent(MDBuyNowOfferListActivity.this, ProductDetailActivity.class);
                        intent.addCategory("android.intent.category.DEFAULT");
                        intent.putExtra(Constants.EXTRA_ITEM_ID, access$700.itemId);
                        intent.putExtra(Constants.EXTRA_YEAR_MAKE_MODEL, MDBuyNowOfferListActivity.this.year_make_model_se);
                        MDBuyNowOfferListActivity.this.startActivity(intent);
                        MDBuyNowOfferListActivity.this.detailContainer.setVisibility(0);
                        MDBuyNowOfferListActivity.this.fab.setVisibility(4);
                        boolean unused2 = MDBuyNowOfferListActivity.this.isMenuOptionNotAvaliable = true;
                        MDBuyNowOfferListActivity.this.invalidateOptionsMenu();
                    }
                });
            }
        }

        public int getItemViewType(int i) {
            if (isPositionFooter(i)) {
                return this.TYPE_FOOTER;
            }
            return this.TYPE_ITEM;
        }

        private boolean isPositionFooter(int i) {
            return this.mValues.get(i) == null;
        }

        public int getItemCount() {
            List<BuyNowOfferVehicleList> list = this.mValues;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final ImageView img_vehicle_image;
            public BuyNowOfferVehicleList mItem;
            public final View mView;
            public final TextView pre_sale_row_1;
            public final TextView pre_sale_row_2;
            public final TextView pre_sale_row_3_left;
            public final TextView pre_sale_row_3_right;
            public final TextView pre_sale_row_4;
            public final TextView pre_sale_row_5;
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
                this.pre_sale_row_5 = (TextView) view.findViewById(C2723R.C2726id.pre_sale_row_5);
                this.star_image = (ImageView) view.findViewById(C2723R.C2726id.image);
            }

            public String toString() {
                return super.toString() + " '" + this.pre_sale_row_1.getText() + "'";
            }
        }
    }

    /* access modifiers changed from: private */
    public MDVehicle convertBuyNowOfferToMDVehicle(BuyNowOfferVehicleList buyNowOfferVehicleList) {
        MDVehicle mDVehicle = new MDVehicle();
        mDVehicle.itemId = buyNowOfferVehicleList.ItemId;
        mDVehicle.make = buyNowOfferVehicleList.Make;
        mDVehicle.model = buyNowOfferVehicleList.Model;
        mDVehicle.year = buyNowOfferVehicleList.Year;
        mDVehicle.branchCode = buyNowOfferVehicleList.Branchnumber;
        mDVehicle.branchName = buyNowOfferVehicleList.BranchName;
        mDVehicle.lane = buyNowOfferVehicleList.LaneItemNumber;
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
            int i3;
            this.totalItemCount = this.mLayoutManager.getItemCount();
            this.lastVisibleItem = ((LinearLayoutManager) this.mLayoutManager).findLastVisibleItemPosition();
            if (this.totalItemCount + this.visibleThreshold > MDBuyNowOfferListActivity.buyNowPageSize && !this.isLoading && (i3 = this.totalItemCount) <= this.lastVisibleItem + this.visibleThreshold) {
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
        if (this.buyNowOfferCount != 0) {
            ActionBar supportActionBar = getSupportActionBar();
            supportActionBar.setTitle((CharSequence) getTitle() + " (" + this.buyNowOfferCount + ")");
            return;
        }
        getSupportActionBar().setTitle(getTitle());
    }

    public void onBackPressed() {
        View view = this.recyclerView;
        if (view != null && view.getVisibility() == 4) {
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
    public void handleBuyNowOfferUpData(ArrayList<BuyNowOfferVehicleList> arrayList, boolean z) {
        if (arrayList == null || arrayList.size() <= 0) {
            ArrayList<BuyNowOfferVehicleList> arrayList2 = this.vehicles;
            if (arrayList2 != null) {
                arrayList2.remove(arrayList2.size() - 1);
                this.simpleItemRecyclerViewAdapter.notifyItemRemoved(this.vehicles.size());
                this.simpleItemRecyclerViewAdapter.notifyDataSetChanged();
            }
            if (!z) {
                this.empty.setVisibility(0);
            }
        } else {
            this.empty.setVisibility(8);
            ArrayList<BuyNowOfferVehicleList> arrayList3 = this.vehicles;
            if (arrayList3 != null && arrayList3.size() > 0) {
                ArrayList<BuyNowOfferVehicleList> arrayList4 = this.vehicles;
                arrayList4.remove(arrayList4.size() - 1);
                this.simpleItemRecyclerViewAdapter.notifyItemRemoved(this.vehicles.size());
                this.simpleItemRecyclerViewAdapter.notifyDataSetChanged();
            }
            if (z) {
                this.vehicles.addAll(arrayList);
            } else {
                this.vehicles = arrayList;
            }
            this.simpleItemRecyclerViewAdapter.setUpVehicleListData(this.vehicles);
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

    public void setMDProductDetailTitle() {
        getSupportActionBar().setTitle((int) C2723R.string.vehicle_detail_title);
    }
}
