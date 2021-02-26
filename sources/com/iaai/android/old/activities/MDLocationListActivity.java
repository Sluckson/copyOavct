package com.iaai.android.old.activities;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.inject.Injector;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.fragments.AdditionalStateReqPDFFragment;
import com.iaai.android.old.fragments.MDLocationDetailFragment;
import com.iaai.android.old.managers.CurrentLocationManager;
import com.iaai.android.old.managers.MasterDetailLocationManager;
import com.iaai.android.old.models.BranchLocationInfo;
import com.iaai.android.old.models.LocationInfo;
import com.iaai.android.old.models.LoginState;
import com.iaai.android.old.utils.DateHelper;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.http.NetworkUtil;
import com.iaai.android.old.utils.p016ui.MDActivityHelper;
import com.iaai.android.old.utils.p016ui.SimpleDividerItemDecoration;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.squareup.otto.Subscribe;
import com.squareup.picasso.Picasso;
import java.util.List;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import p052cz.msebera.android.httpclient.Header;
import roboguice.util.C5058Ln;

public class MDLocationListActivity extends MainNavDrawerActivity implements MDLocationDetailFragment.OnAdditionalStatePDF {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static String KEY_CURRENT_LOCATION = "currentLocation";
    public static String KEY_IS_LOAD_DEFAULT = "load_default";
    public static String KEY_IS_NEARME_PUBLIC_IND_BRANCH = "isNearMeForPublicIndBranch";
    public static String KEY_IS_NEAR_ME_ACTIVE = "isNearMeActive";
    public static String KEY_IS_PUBLIC_IND_BRANCH = "isPublicIndBranch";
    public static String KEY_KEYWORD_SEARCH = "keyword_search";
    public static String KEY_LOACTION_LIST_DATA = "location_list";
    public static String KEY_NEAR_ME_ENABLE = "isNearMeEnable";
    public static String KEY_SELECTED_INDEX = "selected_index";
    public static String KEY_SHOULD_APPLY_CLEAR_FLITER = "shouldApplyClearFilter";
    /* access modifiers changed from: private */
    public ImageView btn_near_me_location;
    TextView clear_filters;
    Location currentLocation = null;
    private CurrentLocationBroadcastReceiver currentLocationBroadcastReceiver;
    private CurrentLocationManager currentLocationManager;
    /* access modifiers changed from: private */
    public TextView empty_view;
    /* access modifiers changed from: private */
    public boolean isLoadDefaultLocation;
    /* access modifiers changed from: private */
    public boolean isNearMeActive = false;
    boolean isNearMeForPublicIndBranch = false;
    boolean isPublicIndBranch = false;
    /* access modifiers changed from: private */
    public EditText keyword_search;
    /* access modifiers changed from: private */
    public LinearLayout llMainLayout;
    Dialog location_loadingDialog;
    BranchLocationInfo mBranchLocationInfo;
    /* access modifiers changed from: private */
    public boolean mTwoPane;
    MasterDetailLocationManager masterDetailLocationManager;
    /* access modifiers changed from: private */
    public RecyclerView mdlocation_list;
    CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            MDLocationListActivity mDLocationListActivity = MDLocationListActivity.this;
            mDLocationListActivity.isPublicIndBranch = z;
            int length = mDLocationListActivity.keyword_search.getText().toString().length();
            if (z) {
                boolean unused = MDLocationListActivity.this.shouldApplyClearFilter = true;
                MDLocationListActivity.this.clear_filters.setEnabled(true);
            } else if (!MDLocationListActivity.this.isNearMeActive && length == 0) {
                boolean unused2 = MDLocationListActivity.this.shouldApplyClearFilter = false;
                MDLocationListActivity.this.clear_filters.setEnabled(false);
            }
            if (MDLocationListActivity.this.isNearMeActive) {
                MDLocationListActivity mDLocationListActivity2 = MDLocationListActivity.this;
                mDLocationListActivity2.getLocationList("latlong", mDLocationListActivity2.currentLocation, MDLocationListActivity.this.isPublicIndBranch);
                return;
            }
            MDLocationListActivity mDLocationListActivity3 = MDLocationListActivity.this;
            mDLocationListActivity3.getLocationList(mDLocationListActivity3.keyword_search.getText().toString(), (Location) null, MDLocationListActivity.this.isPublicIndBranch);
        }
    };
    int selected_index;
    /* access modifiers changed from: private */
    public boolean shouldApplyClearFilter = false;
    SimpleItemRecyclerViewAdapter simpleItemRecyclerViewAdapter;
    Switch switchPublicCanBuy;

    private void initi(Bundle bundle) {
        this.switchPublicCanBuy = (Switch) findViewById(C2723R.C2726id.switch_public_can_buy);
        this.switchPublicCanBuy.setOnCheckedChangeListener(this.onCheckedChangeListener);
        this.mNavigationView.getMenu().findItem(C2723R.C2726id.drawer_menu_location).setChecked(true);
        this.currentLocationBroadcastReceiver = new CurrentLocationBroadcastReceiver();
        Injector injector = ((IaaiApplication) getApplication()).getInjector();
        this.currentLocationManager = (CurrentLocationManager) injector.getInstance(CurrentLocationManager.class);
        super.setUserNameAndBuyerID(this.sessionManager);
        this.empty_view = (TextView) findViewById(C2723R.C2726id.empty_view);
        this.mdlocation_list = (RecyclerView) findViewById(C2723R.C2726id.mdlocation_list);
        this.btn_near_me_location = (ImageView) findViewById(C2723R.C2726id.btn_near_me_location);
        this.keyword_search = (EditText) findViewById(C2723R.C2726id.keyword_search);
        this.clear_filters = (TextView) findViewById(C2723R.C2726id.clear_filters);
        this.clear_filters.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int length = MDLocationListActivity.this.keyword_search.getText().toString().length();
                if (MDLocationListActivity.this.shouldApplyClearFilter) {
                    MDLocationListActivity.this.clear_filters.setEnabled(false);
                    boolean unused = MDLocationListActivity.this.shouldApplyClearFilter = false;
                }
                if (length > 0) {
                    MDLocationListActivity.this.keyword_search.setText("");
                    boolean unused2 = MDLocationListActivity.this.isLoadDefaultLocation = true;
                }
                MDLocationListActivity.this.btn_near_me_location.setImageResource(C2723R.C2725drawable.ic_target);
                boolean unused3 = MDLocationListActivity.this.isNearMeActive = false;
                MDLocationListActivity mDLocationListActivity = MDLocationListActivity.this;
                mDLocationListActivity.isNearMeForPublicIndBranch = false;
                mDLocationListActivity.getLocationList("", (Location) null, mDLocationListActivity.isPublicIndBranch);
                MDLocationListActivity mDLocationListActivity2 = MDLocationListActivity.this;
                mDLocationListActivity2.selected_index = 0;
                mDLocationListActivity2.switchPublicCanBuy.setChecked(false);
            }
        });
        ((ImageView) findViewById(C2723R.C2726id.search_button)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MDLocationListActivity.this.keyword_search.getText().toString().length() > 0) {
                    boolean unused = MDLocationListActivity.this.isNearMeActive = false;
                    boolean unused2 = MDLocationListActivity.this.shouldApplyClearFilter = true;
                    MDLocationListActivity.this.clear_filters.setEnabled(true);
                    MDLocationListActivity.this.btn_near_me_location.setImageResource(C2723R.C2725drawable.ic_target);
                    MDLocationListActivity.this.btn_near_me_location.setEnabled(true);
                    String obj = MDLocationListActivity.this.keyword_search.getText().toString();
                    MDLocationListActivity mDLocationListActivity = MDLocationListActivity.this;
                    mDLocationListActivity.getLocationList(obj, (Location) null, mDLocationListActivity.isPublicIndBranch);
                    MDLocationListActivity.this.selected_index = 0;
                }
                MDLocationListActivity.this.isNearMeForPublicIndBranch = false;
            }
        });
        this.keyword_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 && MDLocationListActivity.this.keyword_search.getText().toString().length() > 0) {
                    boolean unused = MDLocationListActivity.this.isNearMeActive = false;
                    boolean unused2 = MDLocationListActivity.this.shouldApplyClearFilter = true;
                    MDLocationListActivity.this.clear_filters.setEnabled(true);
                    MDLocationListActivity.this.btn_near_me_location.setImageResource(C2723R.C2725drawable.ic_target);
                    MDLocationListActivity.this.btn_near_me_location.setEnabled(true);
                    String obj = MDLocationListActivity.this.keyword_search.getText().toString();
                    MDLocationListActivity mDLocationListActivity = MDLocationListActivity.this;
                    mDLocationListActivity.getLocationList(obj, (Location) null, mDLocationListActivity.isPublicIndBranch);
                    MDLocationListActivity.this.selected_index = 0;
                }
                return false;
            }
        });
        this.btn_near_me_location.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MDLocationListActivity.this.checkLocationPermission();
            }
        });
        View findViewById = findViewById(C2723R.C2726id.mdlocation_list);
        this.simpleItemRecyclerViewAdapter = new SimpleItemRecyclerViewAdapter(this);
        setupRecyclerView((RecyclerView) findViewById);
        if (findViewById(C2723R.C2726id.mdlocation_detail_container) != null) {
            this.mTwoPane = true;
            this.llMainLayout = (LinearLayout) findViewById(C2723R.C2726id.llMainLayout);
        }
        this.masterDetailLocationManager = (MasterDetailLocationManager) injector.getInstance(MasterDetailLocationManager.class);
        this.selected_index = 0;
        this.isLoadDefaultLocation = true;
        if (bundle != null) {
            this.keyword_search.setText(bundle.getCharSequence(KEY_KEYWORD_SEARCH));
            this.shouldApplyClearFilter = bundle.getBoolean(KEY_SHOULD_APPLY_CLEAR_FLITER);
            this.clear_filters.setEnabled(this.shouldApplyClearFilter);
            this.isNearMeActive = bundle.getBoolean(KEY_IS_NEAR_ME_ACTIVE);
            if (bundle.getBoolean(KEY_NEAR_ME_ENABLE)) {
                this.btn_near_me_location.setImageResource(C2723R.C2725drawable.ic_target);
            } else {
                this.btn_near_me_location.setImageResource(C2723R.C2725drawable.ic_target_active);
            }
            this.isLoadDefaultLocation = bundle.getBoolean(KEY_IS_LOAD_DEFAULT);
            this.selected_index = bundle.getInt(KEY_SELECTED_INDEX);
            this.mBranchLocationInfo = (BranchLocationInfo) bundle.getParcelable(KEY_LOACTION_LIST_DATA);
            BranchLocationInfo branchLocationInfo = this.mBranchLocationInfo;
            if (branchLocationInfo != null) {
                this.simpleItemRecyclerViewAdapter.setUpLocationListData(branchLocationInfo.branchInfo_array);
            }
            this.currentLocation = (Location) bundle.getParcelable(KEY_CURRENT_LOCATION);
            this.isNearMeForPublicIndBranch = bundle.getBoolean(KEY_IS_NEARME_PUBLIC_IND_BRANCH);
            this.isPublicIndBranch = bundle.getBoolean(KEY_IS_PUBLIC_IND_BRANCH);
            this.switchPublicCanBuy.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
            this.switchPublicCanBuy.setChecked(this.isPublicIndBranch);
            this.switchPublicCanBuy.setOnCheckedChangeListener(this.onCheckedChangeListener);
            return;
        }
        checkLocationPermission();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_mdlocation_list);
        super.onCreateDrawer(bundle);
        IaaiApplication.getBus().register(this);
        initi(bundle);
    }

    @Subscribe
    public void onLoginEventChanged(LoginState loginState) {
        super.updateNavigationHeader(loginState.isLogin());
        super.updateLoginNavigationMenu();
        super.handleLogOnNavigation(loginState.isLogin());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        IaaiApplication.getBus().unregister(this);
    }

    private void fetchCurrentLocation() {
        if (this.isNearMeActive) {
            this.isNearMeActive = false;
            if (!this.isPublicIndBranch) {
                this.shouldApplyClearFilter = false;
                this.clear_filters.setEnabled(false);
            }
            this.keyword_search.setText("");
            this.btn_near_me_location.setImageResource(C2723R.C2725drawable.ic_target);
            if (this.isLoadDefaultLocation) {
                getLocationList("", (Location) null, this.isPublicIndBranch);
                this.isLoadDefaultLocation = false;
                return;
            }
            return;
        }
        this.location_loadingDialog = MDActivityHelper.showProgressDialog(this, getString(C2723R.string.msg_Loading));
        registerReceiver(this.currentLocationBroadcastReceiver, this.currentLocationManager.getBroadcastIntentFilter());
        this.currentLocationManager.refreshCurrentLocation(this);
    }

    /* access modifiers changed from: private */
    public void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 2);
        } else {
            fetchCurrentLocation();
        }
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i != 2) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            handleCurrentLocationNotAvailable();
        } else {
            fetchCurrentLocation();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putCharSequence(KEY_KEYWORD_SEARCH, this.keyword_search.getText());
        bundle.putBoolean(KEY_SHOULD_APPLY_CLEAR_FLITER, this.shouldApplyClearFilter);
        bundle.putBoolean(KEY_IS_NEAR_ME_ACTIVE, this.isNearMeActive);
        bundle.putBoolean(KEY_NEAR_ME_ENABLE, this.btn_near_me_location.isEnabled());
        bundle.putBoolean(KEY_IS_LOAD_DEFAULT, this.isLoadDefaultLocation);
        bundle.putInt(KEY_SELECTED_INDEX, this.selected_index);
        bundle.putParcelable(KEY_LOACTION_LIST_DATA, this.mBranchLocationInfo);
        bundle.putParcelable(KEY_CURRENT_LOCATION, this.currentLocation);
        bundle.putBoolean(KEY_IS_NEARME_PUBLIC_IND_BRANCH, this.isNearMeForPublicIndBranch);
        bundle.putBoolean(KEY_IS_PUBLIC_IND_BRANCH, this.isPublicIndBranch);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: package-private */
    public void handleCurrentLocationBroadcastResult(Location location) {
        this.location_loadingDialog.dismiss();
        this.shouldApplyClearFilter = true;
        this.clear_filters.setEnabled(true);
        try {
            unregisterReceiver(this.currentLocationBroadcastReceiver);
        } catch (Exception unused) {
        }
        this.isNearMeActive = true;
        this.btn_near_me_location.setImageResource(C2723R.C2725drawable.ic_target_active);
        this.keyword_search.setText("");
        getLocationList("latlong", location, this.isPublicIndBranch);
        this.isLoadDefaultLocation = true;
        this.isNearMeForPublicIndBranch = true;
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        try {
            unregisterReceiver(this.currentLocationBroadcastReceiver);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void handleCurrentLocationNotAvailable() {
        Dialog dialog = this.location_loadingDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.shouldApplyClearFilter = false;
        this.clear_filters.setEnabled(false);
        Toast.makeText(this, C2723R.string.msg_location_na_use_search, 1).show();
        if (this.isLoadDefaultLocation) {
            getLocationList("", (Location) null, this.isPublicIndBranch);
            this.isLoadDefaultLocation = false;
        }
        this.isNearMeActive = false;
        this.isNearMeForPublicIndBranch = false;
        this.keyword_search.setText("");
    }

    public void hideSoftKeyboard() {
        if (getCurrentFocus() != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    public void OnAdditionalStatePDFListener(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(AdditionalStateReqPDFFragment.ARG_PDF_URL, str);
        AdditionalStateReqPDFFragment additionalStateReqPDFFragment = new AdditionalStateReqPDFFragment();
        additionalStateReqPDFFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add((int) C2723R.C2726id.mdlocation_detail_container, (Fragment) additionalStateReqPDFFragment).addToBackStack((String) null).commit();
    }

    class CurrentLocationBroadcastReceiver extends BroadcastReceiver {
        CurrentLocationBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (Constants.INTENT_CURRENT_LOCATION_UPDATE.equals(intent.getAction())) {
                MDLocationListActivity.this.currentLocation = (Location) intent.getParcelableExtra("location");
                MDLocationListActivity mDLocationListActivity = MDLocationListActivity.this;
                mDLocationListActivity.handleCurrentLocationBroadcastResult(mDLocationListActivity.currentLocation);
            } else if (Constants.INTENT_CURRENT_LOCATION_NOT_AVAILABLE.equals(intent.getAction())) {
                MDLocationListActivity.this.handleCurrentLocationNotAvailable();
            }
        }
    }

    /* access modifiers changed from: private */
    public void getLocationList(String str, Location location, boolean z) {
        if (NetworkUtil.isNetworkAvailable(getApplicationContext())) {
            final Dialog showProgressDialog = MDActivityHelper.showProgressDialog(this, getString(C2723R.string.msg_Loading));
            this.masterDetailLocationManager.getLocationList(z, this, str, location, new AsyncHttpResponseHandler() {
                public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                    BranchLocationInfo branchLocationInfo;
                    try {
                        branchLocationInfo = (BranchLocationInfo) new Gson().fromJson(new String(bArr), BranchLocationInfo.class);
                    } catch (Exception e) {
                        e.printStackTrace();
                        branchLocationInfo = null;
                    }
                    if (branchLocationInfo != null) {
                        MDLocationListActivity mDLocationListActivity = MDLocationListActivity.this;
                        mDLocationListActivity.mBranchLocationInfo = branchLocationInfo;
                        mDLocationListActivity.selected_index = 0;
                        if (branchLocationInfo.branchInfo_array.size() > 0) {
                            MDLocationListActivity.this.mdlocation_list.setVisibility(0);
                            MDLocationListActivity.this.empty_view.setVisibility(8);
                            MDLocationListActivity.this.simpleItemRecyclerViewAdapter.setUpLocationListData(branchLocationInfo.branchInfo_array);
                            if (MDLocationListActivity.this.mTwoPane) {
                                MDLocationListActivity.this.llMainLayout.setVisibility(0);
                                MDLocationListActivity.this.findViewById(C2723R.C2726id.mdlocation_detail_container).setVisibility(0);
                                Bundle bundle = new Bundle();
                                bundle.putString("item_id", branchLocationInfo.branchInfo_array.get(0).branchCode);
                                bundle.putString(MDLocationDetailFragment.ARG_BRANCH_NAME, branchLocationInfo.branchInfo_array.get(0).branchName);
                                MDLocationDetailFragment mDLocationDetailFragment = new MDLocationDetailFragment();
                                mDLocationDetailFragment.setArguments(bundle);
                                MDLocationListActivity.this.getSupportFragmentManager().beginTransaction().replace(C2723R.C2726id.mdlocation_detail_container, mDLocationDetailFragment).commitAllowingStateLoss();
                            }
                        } else if (MDLocationListActivity.this.mTwoPane) {
                            MDLocationListActivity.this.llMainLayout.setVisibility(8);
                            MDLocationListActivity.this.empty_view.setVisibility(0);
                        } else {
                            MDLocationListActivity.this.mdlocation_list.setVisibility(8);
                            MDLocationListActivity.this.empty_view.setVisibility(0);
                        }
                    }
                    showProgressDialog.dismiss();
                    MDLocationListActivity.this.hideSoftKeyboard();
                }

                public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                    showProgressDialog.dismiss();
                    MDLocationListActivity.this.hideSoftKeyboard();
                }
            });
        }
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(this.simpleItemRecyclerViewAdapter);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
    }

    public class SimpleItemRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
        Context contextForPicasso;
        private List<LocationInfo> mValues;

        public SimpleItemRecyclerViewAdapter(Context context) {
            this.contextForPicasso = context;
        }

        public void setUpLocationListData(List<LocationInfo> list) {
            this.mValues = list;
            notifyDataSetChanged();
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C2723R.C2728layout.mdlocation_list_content, viewGroup, false));
        }

        public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
            viewHolder.mItem = this.mValues.get(i);
            viewHolder.tv_branch_name.setText(viewHolder.mItem.branchName);
            String str = viewHolder.mItem.branchStreet;
            if (viewHolder.mItem.branchStreet != null) {
                str = viewHolder.mItem.branchStreet.trim();
            }
            TextView textView = viewHolder.tv_address_branch_street;
            textView.setText(str + ", " + viewHolder.mItem.branchCity + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + viewHolder.mItem.branchState_Display);
            String str2 = viewHolder.mItem.branchNextAuctionDate;
            if (str2.equalsIgnoreCase("")) {
                TextView textView2 = viewHolder.tv_city_zip;
                textView2.setText(MDLocationListActivity.this.getString(C2723R.string.location_next_auction_text) + " : TBD");
            } else {
                TextView textView3 = viewHolder.tv_city_zip;
                textView3.setText(MDLocationListActivity.this.getString(C2723R.string.location_next_auction_text) + " : " + DateHelper.format(DateHelper.getDateFromString(str2), Constants.DATE_PATTERN_MD_LOCATION_SHORT));
            }
            if (viewHolder.mItem.branch_Public_Ind.equalsIgnoreCase("true")) {
                viewHolder.tv_public_ind.setVisibility(0);
            } else {
                viewHolder.tv_public_ind.setVisibility(4);
            }
            if (TextUtils.isEmpty(viewHolder.mItem.branchImage)) {
                C5058Ln.m4838v("vehicle[%s] imageURL[]", viewHolder.mItem.branchImage);
                Picasso.get().load((int) C2723R.C2725drawable.no_image_hd).into(viewHolder.img_branch_image);
            } else {
                C5058Ln.m4838v("vehicle[%s] imageURL[%s]", viewHolder.mItem.branchImage, viewHolder.mItem.branchImage);
                Picasso.get().load(viewHolder.mItem.branchImage).resize(160, 120).onlyScaleDown().placeholder((int) C2723R.C2725drawable.progress_animation).error((int) C2723R.C2725drawable.no_image_hd).into(viewHolder.img_branch_image);
            }
            if (MDLocationListActivity.this.mTwoPane) {
                if (i == MDLocationListActivity.this.selected_index) {
                    viewHolder.mView.setSelected(true);
                } else {
                    viewHolder.mView.setSelected(false);
                }
            }
            viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (MDLocationListActivity.this.mTwoPane) {
                        SimpleItemRecyclerViewAdapter.this.notifyDataSetChanged();
                        MDLocationListActivity.this.selected_index = i;
                        Bundle bundle = new Bundle();
                        bundle.putString("item_id", viewHolder.mItem.branchCode);
                        bundle.putString(MDLocationDetailFragment.ARG_BRANCH_NAME, viewHolder.mItem.branchName);
                        MDLocationDetailFragment mDLocationDetailFragment = new MDLocationDetailFragment();
                        mDLocationDetailFragment.setArguments(bundle);
                        MDLocationListActivity.this.getSupportFragmentManager().beginTransaction().replace(C2723R.C2726id.mdlocation_detail_container, mDLocationDetailFragment).commit();
                        return;
                    }
                    Context context = view.getContext();
                    Intent intent = new Intent(context, MDLocationDetailActivity.class);
                    intent.putExtra("item_id", viewHolder.mItem.branchCode);
                    intent.putExtra(MDLocationDetailFragment.ARG_BRANCH_NAME, viewHolder.mItem.branchName);
                    context.startActivity(intent);
                }
            });
        }

        public int getItemCount() {
            List<LocationInfo> list = this.mValues;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final ImageView img_branch_image;
            public LocationInfo mItem;
            public final View mView;
            public final TextView tv_address_branch_street;
            public final TextView tv_branch_name;
            public final TextView tv_city_zip;
            public final TextView tv_public_ind;

            public ViewHolder(View view) {
                super(view);
                this.mView = view;
                this.tv_branch_name = (TextView) view.findViewById(C2723R.C2726id.tv_branch_name);
                this.tv_address_branch_street = (TextView) view.findViewById(C2723R.C2726id.address_branch_street);
                this.tv_city_zip = (TextView) view.findViewById(C2723R.C2726id.city_zip);
                this.tv_public_ind = (TextView) view.findViewById(C2723R.C2726id.tv_public_ind);
                this.img_branch_image = (ImageView) view.findViewById(C2723R.C2726id.branch_image);
            }

            public String toString() {
                return super.toString() + " '" + this.tv_branch_name.getText() + "'";
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
