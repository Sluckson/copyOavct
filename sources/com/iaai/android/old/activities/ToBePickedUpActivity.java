package com.iaai.android.old.activities;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.view.PointerIconCompat;
import com.google.gson.Gson;
import com.google.inject.Inject;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.old.managers.ToBePickedUpManager;
import com.iaai.android.old.models.ToBePickedUpList;
import com.iaai.android.old.models.ToBePickedUpVehicles;
import com.iaai.android.old.models.Vehicle;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.ActivityHelper;
import com.iaai.android.old.utils.p016ui.MDActivityHelper;
import com.iaai.android.old.widgets.CustomPopupWindow;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.squareup.picasso.Picasso;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import p052cz.msebera.android.httpclient.Header;
import roboguice.inject.InjectView;

public class ToBePickedUpActivity extends AbstractListActivity {
    private ImageButton btnBack;
    /* access modifiers changed from: private */
    public ImageButton btnMenu;
    private TextView btnMyPullouts;
    /* access modifiers changed from: private */
    public CardView cardView;
    boolean isMyItemOnly;
    boolean isShowMyVehicles;
    CustomPopupWindow popupWindow;
    RefreshToBePickedUpListReceiver refreshToBePickedUpListReceiver;
    /* access modifiers changed from: private */
    @InjectView(2131298418)
    public TextView searchResultsHeader;
    SessionManager sessionManager;
    @Inject
    ToBePickedUpManager toBePickedUpManager;
    ArrayList<ToBePickedUpVehicles> vehicleArrayList = null;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_tobepickedup);
        this.sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();
        this.cardView = (CardView) ((LayoutInflater) getSystemService("layout_inflater")).inflate(C2723R.C2728layout.listheader_tobepickedup, (ViewGroup) null);
        this.btnMyPullouts = (TextView) this.cardView.findViewById(C2723R.C2726id.btn_my_pullouts);
        this.btnMyPullouts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ActivityHelper.pushActivityToGroup(ToBePickedUpActivity.this, new Intent(ToBePickedUpActivity.this, ToBePickedUpMyPulloutListActivity.class));
            }
        });
        this.btnBack = (ImageButton) findViewById(C2723R.C2726id.img_back);
        this.btnMenu = (ImageButton) findViewById(C2723R.C2726id.img_menu);
        this.isMyItemOnly = getIntent().getBooleanExtra("isMyItemOnly", false);
        getToBePickedData();
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (ToBePickedUpActivity.this.isShowMyVehicles) {
                    i--;
                }
                Intent intent = new Intent(Constants.INTENT_ACTION_VEHICLE_DETAILS);
                Vehicle vehicle = new Vehicle();
                vehicle.itemId = ToBePickedUpActivity.this.vehicleArrayList.get(i).itemId;
                vehicle.make = ToBePickedUpActivity.this.vehicleArrayList.get(i).make;
                vehicle.model = ToBePickedUpActivity.this.vehicleArrayList.get(i).model;
                vehicle.year = ToBePickedUpActivity.this.vehicleArrayList.get(i).year;
                vehicle.branchCode = ToBePickedUpActivity.this.vehicleArrayList.get(i).branchNumber;
                vehicle.branchName = ToBePickedUpActivity.this.vehicleArrayList.get(i).branchName;
                vehicle.lane = ToBePickedUpActivity.this.vehicleArrayList.get(i).laneItemNumber;
                vehicle.imageUrl = ToBePickedUpActivity.this.vehicleArrayList.get(i).imageUrl;
                intent.putExtra(Constants.EXTRA_VEHICLE, vehicle);
                intent.putExtra(Constants.EXTRA_PAGE_TYPE, 0);
                intent.putExtra(Constants.EXTRA_LIST_MODE, 2);
                intent.putExtra(Constants.EXTRA_FROM_FAST, false);
                ActivityHelper.pushActivityToGroup(ToBePickedUpActivity.this, intent);
            }
        });
        this.btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ToBePickedUpActivity.this.finish();
            }
        });
        this.btnMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ToBePickedUpActivity.this.popupWindow != null) {
                    ToBePickedUpActivity.this.popupWindow.showBiggerTextForToBePickedUp(ToBePickedUpActivity.this.btnMenu);
                }
            }
        });
        this.refreshToBePickedUpListReceiver = new RefreshToBePickedUpListReceiver();
        registerReceiver(this.refreshToBePickedUpListReceiver, new IntentFilter(Constants.INTENT_ACTION_REFRESH_TOBE_PICKEDUP_LIST));
    }

    class RefreshToBePickedUpListReceiver extends BroadcastReceiver {
        RefreshToBePickedUpListReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Constants.INTENT_ACTION_REFRESH_TOBE_PICKEDUP_LIST)) {
                ToBePickedUpActivity.this.getToBePickedData();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        CustomPopupWindow customPopupWindow = this.popupWindow;
        if (customPopupWindow != null) {
            customPopupWindow.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.refreshToBePickedUpListReceiver);
    }

    /* access modifiers changed from: private */
    public boolean isSelectButtonEnable(ArrayList<ToBePickedUpVehicles> arrayList) {
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

    /* access modifiers changed from: private */
    public void getToBePickedData() {
        final Dialog showProgressDialog = MDActivityHelper.showProgressDialog(this, getString(C2723R.string.msg_Loading));
        this.toBePickedUpManager.loadToBePickedUpInfo(this.isMyItemOnly, 0, 0, new AsyncHttpResponseHandler() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                ToBePickedUpList toBePickedUpList = (ToBePickedUpList) new Gson().fromJson(new String(bArr), ToBePickedUpList.class);
                if (toBePickedUpList != null) {
                    ToBePickedUpActivity.this.vehicleArrayList = toBePickedUpList.vehicleArrayList;
                    if (ToBePickedUpActivity.this.vehicleArrayList != null && ToBePickedUpActivity.this.vehicleArrayList.size() > 0) {
                        ToBePickedUpActivity toBePickedUpActivity = ToBePickedUpActivity.this;
                        ToBePickedUpActivity.this.setListAdapter(new ToBePickedAdapter(toBePickedUpActivity.vehicleArrayList, ToBePickedUpActivity.this.getApplicationContext()));
                        if (ToBePickedUpActivity.this.sessionManager.isCurrentSessionUserOwner() && toBePickedUpList.branchEnabledForPullout) {
                            ToBePickedUpActivity.this.buildOverflow(toBePickedUpList);
                        }
                    }
                    if (ToBePickedUpActivity.this.sessionManager.isCurrentSessionUserOwner()) {
                        ListView listView = ToBePickedUpActivity.this.getListView();
                        if (!toBePickedUpList.ShowMyVehicles) {
                            listView.removeHeaderView(ToBePickedUpActivity.this.cardView);
                            ToBePickedUpActivity.this.cardView.setVisibility(8);
                            ToBePickedUpActivity.this.isShowMyVehicles = false;
                        } else if (listView.getHeaderViewsCount() < 1) {
                            listView.addHeaderView(ToBePickedUpActivity.this.cardView);
                            ToBePickedUpActivity.this.cardView.setVisibility(0);
                            ToBePickedUpActivity.this.isShowMyVehicles = true;
                        }
                    }
                    TextView access$400 = ToBePickedUpActivity.this.searchResultsHeader;
                    access$400.setText(ToBePickedUpActivity.this.getString(C2723R.string.lbl_pick_up) + "(" + ToBePickedUpActivity.this.vehicleArrayList.size() + ")");
                    showProgressDialog.dismiss();
                    if (ToBePickedUpActivity.this.sessionManager.isCurrentSessionUserOwner() && toBePickedUpList.branchEnabledForPullout && !IAASharedPreference.getPrefForTips(ToBePickedUpActivity.this)) {
                        ToBePickedUpActivity.this.openDialog();
                        IAASharedPreference.setPrefForTips(ToBePickedUpActivity.this, true);
                    }
                }
            }

            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                showProgressDialog.dismiss();
            }
        });
    }

    class ToBePickedAdapter extends BaseAdapter {
        Context context;
        private LayoutInflater inflater;
        ArrayList<ToBePickedUpVehicles> toBePickedUpVehicles;

        public Object getItem(int i) {
            return null;
        }

        public long getItemId(int i) {
            return 0;
        }

        ToBePickedAdapter() {
        }

        ToBePickedAdapter(ArrayList<ToBePickedUpVehicles> arrayList, Context context2) {
            this.context = context2;
            this.toBePickedUpVehicles = arrayList;
            this.inflater = (LayoutInflater) context2.getSystemService("layout_inflater");
        }

        public int getCount() {
            return this.toBePickedUpVehicles.size();
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            ViewHolder viewHolder;
            int i2 = i;
            Date date = null;
            if (view == null) {
                viewHolder = new ViewHolder();
                view2 = this.inflater.inflate(C2723R.C2728layout.custom_tobepickedup_row, (ViewGroup) null);
                view2.setVisibility(0);
                viewHolder.stockID = (TextView) view2.findViewById(C2723R.C2726id.lbl_stock_id);
                viewHolder.branchName = (TextView) view2.findViewById(C2723R.C2726id.lbl_branchname);
                viewHolder.vin = (TextView) view2.findViewById(C2723R.C2726id.lbl_vin);
                viewHolder.ymm = (TextView) view2.findViewById(C2723R.C2726id.lbl_ymm);
                viewHolder.actionDue = (TextView) view2.findViewById(C2723R.C2726id.lbl_action_due);
                viewHolder.imgThumb = (ImageView) view2.findViewById(C2723R.C2726id.img_vehicle_thumb);
                viewHolder.fees = (TextView) view2.findViewById(C2723R.C2726id.lbl_fees);
                viewHolder.lane = (TextView) view2.findViewById(C2723R.C2726id.lbl_lane);
                viewHolder.pin = (TextView) view2.findViewById(C2723R.C2726id.lbl_pin);
                viewHolder.lbl_action = (TextView) view2.findViewById(C2723R.C2726id.lbl_action);
                view2.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
                view2 = view;
            }
            String str = this.toBePickedUpVehicles.get(i2).imageUrl;
            if (TextUtils.isEmpty(str)) {
                Picasso.get().load((int) C2723R.C2725drawable.ic_image_na).into(viewHolder.imgThumb);
            } else {
                Picasso.get().load(str).resize(96, 72).onlyScaleDown().placeholder((int) C2723R.C2725drawable.progress_animation).error((int) C2723R.C2725drawable.ic_image_na).into(viewHolder.imgThumb);
            }
            viewHolder.stockID.setText(this.toBePickedUpVehicles.get(i2).stockNumber);
            viewHolder.lane.setText(this.toBePickedUpVehicles.get(i2).laneItemNumber);
            viewHolder.branchName.setText(this.toBePickedUpVehicles.get(i2).branchName);
            viewHolder.vin.setText(this.toBePickedUpVehicles.get(i2).vin);
            viewHolder.ymm.setText(this.toBePickedUpVehicles.get(i2).yearMakeModel);
            viewHolder.lbl_action.setVisibility(8);
            viewHolder.actionDue.setBackgroundColor(this.context.getResources().getColor(C2723R.C2724color.dash_bg));
            viewHolder.actionDue.setTextColor(this.context.getResources().getColor(C2723R.C2724color.tab_black));
            if (this.toBePickedUpVehicles.get(i2).pin.equals("0")) {
                viewHolder.pin.setText("");
            } else {
                TextView textView = viewHolder.pin;
                textView.setText(ToBePickedUpActivity.this.getString(C2723R.string.lbl_pin) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.toBePickedUpVehicles.get(i2).pin);
            }
            String str2 = this.toBePickedUpVehicles.get(i2).actionDate;
            Date date2 = new Date();
            if (str2 != null) {
                date = ToBePickedUpActivity.this.getDate(str2);
                date2 = new Date();
            }
            if (date == null) {
                viewHolder.actionDue.setText("C.O.D");
                viewHolder.actionDue.setBackgroundColor(this.context.getResources().getColor(C2723R.C2724color.dash_bg));
            } else if (date.compareTo(date2) > 0) {
                long time = (date.getTime() - date2.getTime()) / 86400000;
                if (time == 0) {
                    viewHolder.actionDue.setTextColor(this.context.getResources().getColor(C2723R.C2724color.dash_bg));
                    viewHolder.actionDue.setBackgroundResource(C2723R.C2725drawable.tomorrow_round_rect_bg);
                    TextView textView2 = viewHolder.actionDue;
                    textView2.setText(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.context.getString(C2723R.string.lbl_today) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                } else if (time == 1) {
                    viewHolder.actionDue.setText(this.context.getString(C2723R.string.lbl_tomorrow));
                } else {
                    viewHolder.actionDue.setText(new SimpleDateFormat(Constants.DATE_PATTERN_MD_LOCATION_SHORT).format(date));
                }
            } else if (date.compareTo(date2) < 0) {
                long time2 = (date2.getTime() - date.getTime()) / 86400000;
                if (time2 != 0) {
                    viewHolder.lbl_action.setVisibility(0);
                    viewHolder.lbl_action.setText(this.context.getString(C2723R.string.tobe_pickedup_passdue));
                    viewHolder.actionDue.setTextColor(this.context.getResources().getColor(C2723R.C2724color.dash_bg));
                    viewHolder.actionDue.setBackgroundResource(C2723R.C2725drawable.pass_due_round_rect_bg);
                    if (time2 == 1) {
                        TextView textView3 = viewHolder.actionDue;
                        textView3.setText(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.context.getString(C2723R.string.lbl_yesterday) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    } else {
                        TextView textView4 = viewHolder.actionDue;
                        textView4.setText(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + time2 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.context.getString(C2723R.string.tobe_pickedup_days) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    }
                } else {
                    viewHolder.actionDue.setTextColor(this.context.getResources().getColor(C2723R.C2724color.dash_bg));
                    viewHolder.actionDue.setBackgroundResource(C2723R.C2725drawable.tomorrow_round_rect_bg);
                    TextView textView5 = viewHolder.actionDue;
                    textView5.setText(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.context.getString(C2723R.string.lbl_today) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                }
            } else if (date.compareTo(date2) == 0) {
                viewHolder.actionDue.setTextColor(this.context.getResources().getColor(C2723R.C2724color.dash_bg));
                viewHolder.actionDue.setBackgroundResource(C2723R.C2725drawable.tomorrow_round_rect_bg);
                TextView textView6 = viewHolder.actionDue;
                textView6.setText(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.context.getString(C2723R.string.lbl_today) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            }
            return view2;
        }
    }

    class ViewHolder {
        TextView actionDue;
        TextView branchName;
        TextView fees;
        ImageView imgThumb;
        TextView lane;
        TextView lbl_action;
        TextView pin;
        TextView stockID;
        TextView vin;
        TextView ymm;

        ViewHolder() {
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

    /* access modifiers changed from: private */
    public void buildOverflow(ToBePickedUpList toBePickedUpList) {
        this.popupWindow = new CustomPopupWindow(this);
        if (isSelectButtonEnable(this.vehicleArrayList)) {
            this.popupWindow.addPopupItemUsingString(getResources().getString(C2723R.string.lbl_menu_select), PointerIconCompat.TYPE_HELP);
            this.popupWindow.addPopupItemUsingString(getResources().getString(C2723R.string.lbl_menu_select_all), PointerIconCompat.TYPE_WAIT);
        } else {
            this.popupWindow.addPopupItemWithDisableState(getResources().getString(C2723R.string.lbl_menu_select), PointerIconCompat.TYPE_HELP);
            this.popupWindow.addPopupItemWithDisableState(getResources().getString(C2723R.string.lbl_menu_select_all), PointerIconCompat.TYPE_WAIT);
        }
        this.popupWindow.addPopupItemUsingString(getResources().getString(C2723R.string.lbl_menu_help), 1002);
        this.popupWindow.setOnPopupItemClickListener(new CustomPopupWindow.OnPopupItemClickListener() {
            public void onItemClick(String str, int i) {
                switch (i) {
                    case 1002:
                        ToBePickedUpActivity.this.openDialog();
                        return;
                    case PointerIconCompat.TYPE_HELP:
                        ToBePickedUpActivity toBePickedUpActivity = ToBePickedUpActivity.this;
                        if (toBePickedUpActivity.isSelectButtonEnable(toBePickedUpActivity.vehicleArrayList)) {
                            Intent intent = new Intent(ToBePickedUpActivity.this, ToBePickedUpSelectionActivity.class);
                            intent.putParcelableArrayListExtra("vehiclesList", ToBePickedUpActivity.this.vehicleArrayList);
                            ActivityHelper.pushActivityToGroup(ToBePickedUpActivity.this, intent);
                            return;
                        }
                        return;
                    case PointerIconCompat.TYPE_WAIT:
                        ToBePickedUpActivity toBePickedUpActivity2 = ToBePickedUpActivity.this;
                        if (toBePickedUpActivity2.isSelectButtonEnable(toBePickedUpActivity2.vehicleArrayList)) {
                            Intent intent2 = new Intent(ToBePickedUpActivity.this, ToBePickedUpSelectionActivity.class);
                            intent2.putParcelableArrayListExtra("vehiclesList", ToBePickedUpActivity.this.vehicleArrayList);
                            intent2.putExtra("all_selected", true);
                            ActivityHelper.pushActivityToGroup(ToBePickedUpActivity.this, intent2);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void openDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getParent());
        View inflate = getParent().getLayoutInflater().inflate(C2723R.C2728layout.tips_dialog, (ViewGroup) null);
        builder.setView(inflate);
        builder.setTitle((CharSequence) getString(C2723R.string.lbl_tips_and_tutorials));
        builder.setPositiveButton((CharSequence) getResources().getString(C2723R.string.lbl_close), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
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
