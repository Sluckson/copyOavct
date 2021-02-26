package com.iaai.android.old.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.old.analytics.AnalyticUtils;
import com.iaai.android.old.analytics.classes.AnalyticInfo;
import com.iaai.android.old.fragments.ToBePaidFragment;
import com.iaai.android.old.managers.ToBePaidManager;
import com.iaai.android.old.models.ToBePaidBranchFilter;
import com.iaai.android.old.models.ToBePaidInfo;
import com.iaai.android.old.models.ToBePaidVehicle;
import com.iaai.android.old.utils.ICommand;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.constants.ToBePaidSortOptions;
import com.iaai.android.old.utils.p016ui.ActivityHelper;
import com.iaai.android.old.utils.p016ui.IDialogContainer;
import com.iaai.android.old.utils.p016ui.MDActivityHelper;
import com.iaai.android.old.utils.p016ui.UiUtils;
import com.iaai.android.old.widgets.CustomPopupWindow;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import p052cz.msebera.android.httpclient.Header;
import roboguice.application.RoboApplication;
import roboguice.inject.InjectView;

public class ToBePaidSelectionActivity extends AbstractActivity implements IDialogContainer {
    @InjectView(2131296464)
    ImageButton backButton;
    ICommand<String> brachSelectionCallBack = new ICommand<String>() {
        public void execute(String str) {
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= ToBePaidSelectionActivity.this.branchList.size()) {
                    break;
                } else if (str.equals(ToBePaidSelectionActivity.this.branchList.get(i2).BranchName)) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            Log.d("Branch Selection", str + " : " + i);
            ToBePaidSelectionActivity.this.brachSelectionView.setText(str);
            ToBePaidSelectionActivity.this.toBePaidFragment.getBranchFiltering(ToBePaidSelectionActivity.this.branchList.get(i));
            ToBePaidSelectionActivity toBePaidSelectionActivity = ToBePaidSelectionActivity.this;
            toBePaidSelectionActivity.branchSelected = toBePaidSelectionActivity.branchList.get(i);
            ToBePaidActivity.isSortingOrFilterChange = true;
        }
    };
    @InjectView(2131296509)
    TextView brachSelectionView;
    List<ToBePaidBranchFilter> branchList;
    public ToBePaidBranchFilter branchSelected;
    @InjectView(2131296511)
    LinearLayout branchSorting;
    IntentFilter filter = new IntentFilter(Constants.INTENT_TIMEOUT);
    @InjectView(2131298926)
    TextView header;
    public boolean isActivityInFront;
    public String isMyItemOnlyString;
    boolean isSelectAll;
    Dialog mDialog;
    @InjectView(2131296512)
    ImageButton menuSelection;
    @InjectView(2131296639)
    Button paymentButton;
    View.OnClickListener paymentClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            if (view.isEnabled()) {
                Intent intent = new Intent();
                if (ToBePaidSelectionActivity.this.paymentOption.equals(Constants.PAYMENT_OPTION_ACH)) {
                    intent.setClass(ToBePaidSelectionActivity.this, ToBePaidReviewActivity.class);
                    intent.putExtra(Constants.EXTRA_PAYMENT_OPTION, ToBePaidSelectionActivity.this.paymentOption);
                    intent.putStringArrayListExtra(Constants.EXTRA_ROW_SELECTION, ToBePaidSelectionActivity.this.selectionRowNumber);
                    intent.putExtra(Constants.EXTRA_GUID_IDENTIFIER, ToBePaidSelectionActivity.this.toBePaidInfo.getGuidIdentifier());
                    intent.putExtra(Constants.MY_VEHICLES_ONLY_ARG, ToBePaidSelectionActivity.this.isMyItemOnlyString);
                    intent.putExtra(Constants.FINANCE_AMOUNT, UiUtils.formatCurrency(ToBePaidSelectionActivity.this.selected));
                    intent.putExtra(Constants.PAYMENT_METHOD_SELECTION_TYPE, Constants.PAYMENT_OPTION_ACH);
                    intent.addFlags(67108864);
                    ToBePaidSelectionActivity.this.startActivityForResult(intent, 1);
                } else if (ToBePaidSelectionActivity.this.paymentOption.equals(Constants.PAYMENT_OPTION_AFC)) {
                    intent.setClass(ToBePaidSelectionActivity.this, AFCMethodsActivity.class);
                    intent.putExtra(Constants.STOCKS_COUNT, ToBePaidSelectionActivity.this.totalCount + "");
                    intent.putExtra(Constants.FINANCE_AMOUNT, UiUtils.formatCurrency(ToBePaidSelectionActivity.this.selected));
                    intent.putExtra(Constants.EXTRA_GUID_IDENTIFIER, ToBePaidSelectionActivity.this.toBePaidInfo.getRequestId());
                    intent.putStringArrayListExtra(Constants.EXTRA_ROW_SELECTION, ToBePaidSelectionActivity.this.selectionRowNumber);
                    intent.putExtra(Constants.MY_VEHICLES_ONLY_ARG, ToBePaidSelectionActivity.this.isMyItemOnlyString);
                    intent.addFlags(67108864);
                    ToBePaidSelectionActivity.this.startActivityForResult(intent, 1);
                }
            }
        }
    };
    public String paymentOption;
    CustomPopupWindow popupWindow;
    BigDecimal remaining = new BigDecimal(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    @InjectView(2131298077)
    LinearLayout row1;
    @InjectView(2131298820)
    TextView row1Label;
    @InjectView(2131298821)
    TextView row1Value;
    @InjectView(2131298078)
    LinearLayout row2;
    @InjectView(2131298822)
    TextView row2Label;
    @InjectView(2131298823)
    TextView row2Value;
    @InjectView(2131298079)
    LinearLayout row3;
    @InjectView(2131298824)
    TextView row3Label;
    @InjectView(2131298825)
    TextView row3Value;
    @InjectView(2131298218)
    CheckBox selectAll;
    CompoundButton.OnCheckedChangeListener selectAllListener = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ToBePaidSelectionActivity toBePaidSelectionActivity = ToBePaidSelectionActivity.this;
            toBePaidSelectionActivity.isSelectAll = z;
            toBePaidSelectionActivity.toBePaidFragment.isCheckedAll(z);
            ToBePaidSelectionActivity.this.calculateSelectAllAmount(z);
        }
    };
    BigDecimal selected = new BigDecimal(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    ArrayList<String> selectionRowNumber = new ArrayList<>();
    @InjectView(2131298222)
    LinearLayout selectionView;
    SessionManager sessionManager;
    public ToBePaidSortOptions sortOptionSelected;
    @InjectView(2131298253)
    TextView sortSelection;
    @InjectView(2131298251)
    LinearLayout sorting;
    ICommand<ToBePaidSortOptions> sortingCommand = new ICommand<ToBePaidSortOptions>() {
        public void execute(ToBePaidSortOptions toBePaidSortOptions) {
            Log.d("Sorting Option", "sort " + toBePaidSortOptions);
            ToBePaidSelectionActivity.this.sortSelection.setText(toBePaidSortOptions.displayedName);
            ToBePaidSelectionActivity.this.toBePaidFragment.sortingSelection(toBePaidSortOptions);
            ToBePaidSelectionActivity.this.resetDetails();
            ToBePaidSelectionActivity.this.sortOptionSelected = toBePaidSortOptions;
            ToBePaidActivity.isSortingOrFilterChange = true;
        }
    };
    ToBePaidFragment toBePaidFragment;
    ToBePaidInfo toBePaidInfo;
    ToBePaidManager toBePaidManager;
    ToBePaidSortOptions[] tobePaidSortOption;
    int totalCount;

    public Context getContext() {
        return this;
    }

    public boolean isDialogHandled() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.tobepaid_selection_activity);
        this.sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();
        overridePendingTransition(C2723R.anim.push_left_in, C2723R.anim.none);
        getIntentData(getIntent());
        initialize();
        loaddata();
    }

    private void initialize() {
        this.toBePaidManager = (ToBePaidManager) ((RoboApplication) getApplication()).getInjector().getInstance(ToBePaidManager.class);
        this.selectAll.setOnCheckedChangeListener(this.selectAllListener);
        this.selectAll.setEnabled(false);
        this.backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ToBePaidSelectionActivity.this.setResult(300);
                ToBePaidSelectionActivity.this.finish();
                ToBePaidSelectionActivity.this.overridePendingTransition(C2723R.anim.none, C2723R.anim.push_right_out);
            }
        });
        this.popupWindow = new CustomPopupWindow(this);
        this.popupWindow.addPopupItem(C2723R.string.lbl_branch_filtering);
        this.popupWindow.addPopupItem(C2723R.string.lbl_sorting);
        this.popupWindow.setOnPopupItemClickListener(new CustomPopupWindow.OnPopupItemClickListener() {
            public void onItemClick(String str, int i) {
                if (str.equalsIgnoreCase(ToBePaidSelectionActivity.this.getString(C2723R.string.lbl_sorting))) {
                    ToBePaidSelectionActivity toBePaidSelectionActivity = ToBePaidSelectionActivity.this;
                    ActivityHelper.promptSelection(toBePaidSelectionActivity, C2723R.string.lbl_sort_by, toBePaidSelectionActivity.tobePaidSortOption, ToBePaidSelectionActivity.this.sortingCommand, C2723R.string.lbl_cancel);
                } else if (str.equalsIgnoreCase(ToBePaidSelectionActivity.this.getString(C2723R.string.lbl_branch_filtering))) {
                    ToBePaidSelectionActivity.this.createBranchFilter();
                }
            }
        });
        this.menuSelection.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ToBePaidSelectionActivity.this.popupWindow.show(ToBePaidSelectionActivity.this.menuSelection);
            }
        });
        ToBePaidSortOptions.refreshAll();
        this.tobePaidSortOption = ToBePaidSortOptions.TOBEPAID_SORT_OPTION;
        this.sorting.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ToBePaidSelectionActivity.this.popupWindow.show(ToBePaidSelectionActivity.this.menuSelection);
            }
        });
        ToBePaidSortOptions toBePaidSortOptions = this.sortOptionSelected;
        if (toBePaidSortOptions != null) {
            this.sortSelection.setText(toBePaidSortOptions.displayedName);
        } else {
            this.sortSelection.setText(ToBePaidSortOptions.SORT_BY_DEFAULTC.displayedName);
        }
        ToBePaidBranchFilter toBePaidBranchFilter = this.branchSelected;
        if (toBePaidBranchFilter != null) {
            this.brachSelectionView.setText(toBePaidBranchFilter.BranchName);
        }
        this.paymentButton.setOnClickListener(this.paymentClickListener);
        AnalyticInfo analyticInfo = new AnalyticInfo(this.sessionManager.getCurrentSessionUserId() != null ? Integer.parseInt(this.sessionManager.getCurrentSessionUserId()) : 0, 0, 0, 5, System.currentTimeMillis(), "");
        if (this.paymentOption.equals(Constants.PAYMENT_OPTION_ACH)) {
            this.header.setText(C2723R.string.lbl_pay_with_ipay);
            this.row1Label.setText(C2723R.string.lbl_remaining_daily_allowance);
            this.row2Label.setText(C2723R.string.lbl_remaining);
            analyticInfo.setAnalyticsTypeID(7);
            AnalyticUtils.logAnalytics(this, analyticInfo);
        } else if (this.paymentOption.equals(Constants.PAYMENT_OPTION_AFC)) {
            this.header.setText(C2723R.string.lbl_pay_with_afc);
            this.row1Label.setText(C2723R.string.lbl_remaining_daily_allowance);
            this.row2Label.setText(C2723R.string.lbl_remaining);
            analyticInfo.setAnalyticsTypeID(5);
            AnalyticUtils.logAnalytics(this, analyticInfo);
        }
        resetDetails();
        this.row3Label.setText(getString(C2723R.string.lbl_amount_selected, new Object[]{0}));
    }

    public String[] getBranchNames(List<ToBePaidBranchFilter> list) {
        String[] strArr = new String[list.size()];
        int i = 0;
        for (ToBePaidBranchFilter toBePaidBranchFilter : list) {
            strArr[i] = toBePaidBranchFilter.BranchName;
            i++;
        }
        return strArr;
    }

    public void createBranchFilter() {
        final Dialog showLoadingDialog = MDActivityHelper.showLoadingDialog(this);
        this.toBePaidManager.getBranch(this.isMyItemOnlyString, "0", new AsyncHttpResponseHandler() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                Type type = new TypeToken<List<ToBePaidBranchFilter>>() {
                }.getType();
                String str = new String(bArr);
                ToBePaidSelectionActivity.this.branchList = (List) new Gson().fromJson(str, type);
                ToBePaidSelectionActivity toBePaidSelectionActivity = ToBePaidSelectionActivity.this;
                ActivityHelper.promptSelection(toBePaidSelectionActivity, C2723R.string.lbl_filter_by_branch, toBePaidSelectionActivity.getBranchNames(toBePaidSelectionActivity.branchList), ToBePaidSelectionActivity.this.brachSelectionCallBack, C2723R.string.lbl_cancel);
                showLoadingDialog.dismiss();
            }

            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                showLoadingDialog.dismiss();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void getIntentData(Intent intent) {
        this.paymentOption = intent.getStringExtra(Constants.EXTRA_PAYMENT_OPTION);
        this.isMyItemOnlyString = intent.getStringExtra(Constants.EXTRA_TOBPAID_MY_VEHICLES_ONLY);
        this.branchSelected = (ToBePaidBranchFilter) intent.getParcelableExtra(Constants.BRANCH_FILTER_SELECTION);
        this.sortOptionSelected = (ToBePaidSortOptions) intent.getSerializableExtra(Constants.SORTING_OPTION_SELECTION);
    }

    /* access modifiers changed from: package-private */
    public void loaddata() {
        this.toBePaidFragment = new ToBePaidFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.MY_VEHICLES_ONLY_ARG, this.isMyItemOnlyString);
        bundle.putString(Constants.EXTRA_PAYMENT_OPTION, this.paymentOption);
        bundle.putString(Constants.EXTRA_PAYMENT_OPTION, this.paymentOption);
        bundle.putBoolean(Constants.SHOW_PAYMENT_SELECTION, true);
        bundle.putParcelable(Constants.BRANCH_FILTER_SELECTION, this.branchSelected);
        bundle.putSerializable(Constants.SORTING_OPTION_SELECTION, this.sortOptionSelected);
        this.toBePaidFragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(C2723R.C2726id.fragment_container_tobepaid_selection, this.toBePaidFragment).commit();
    }

    public void resetDetails() {
        this.selectAll.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        this.selectAll.setChecked(false);
        this.row1Value.setText(UiUtils.formatCurrency(new BigDecimal(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)));
        this.remaining = BigDecimal.ZERO;
        this.row2Value.setText(UiUtils.formatCurrency(this.remaining));
        this.row2Value.setTextColor(getResources().getColor(C2723R.C2724color.iaa_black));
        this.selected = BigDecimal.ZERO;
        this.row3Value.setText(UiUtils.formatCurrency(this.selected));
        this.selectAll.setOnCheckedChangeListener(this.selectAllListener);
        this.paymentButton.setBackgroundResource(C2723R.C2725drawable.btn_green_disabled);
        this.totalCount = 0;
        this.row3Label.setText(getString(C2723R.string.lbl_amount_selected, new Object[]{Integer.valueOf(this.totalCount)}));
        this.selectionRowNumber.clear();
        this.paymentButton.setEnabled(false);
    }

    public void updateValues(ToBePaidInfo toBePaidInfo2) {
        this.toBePaidInfo = toBePaidInfo2;
        this.selectAll.setEnabled(true);
        if (this.remaining.compareTo(BigDecimal.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) == 0) {
            if (this.paymentOption.equals(Constants.PAYMENT_OPTION_ACH)) {
                this.remaining = toBePaidInfo2.getDailyBalance();
            } else if (this.paymentOption.equals(Constants.PAYMENT_OPTION_AFC)) {
                this.remaining = toBePaidInfo2.getAFCResponseList().getAvailableCredit();
            }
        }
        if (this.paymentOption.equals(Constants.PAYMENT_OPTION_ACH)) {
            this.row1Value.setText(UiUtils.formatCurrency(toBePaidInfo2.getDailyBalance()));
            this.row2Value.setText(UiUtils.formatCurrency(this.remaining));
            this.row3Value.setText(UiUtils.formatCurrency(this.selected));
        } else if (this.paymentOption.equals(Constants.PAYMENT_OPTION_AFC)) {
            this.row1Value.setText(UiUtils.formatCurrency(toBePaidInfo2.getAFCResponseList().getAvailableCredit()));
            this.row2Value.setText(UiUtils.formatCurrency(this.remaining));
            this.row3Value.setText(UiUtils.formatCurrency(this.selected));
        }
    }

    public void calculateSelectAllAmount(boolean z) {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (this.paymentOption.equals(Constants.PAYMENT_OPTION_ACH)) {
            bigDecimal = this.toBePaidInfo.getDailyBalance();
        } else if (this.paymentOption.equals(Constants.PAYMENT_OPTION_AFC)) {
            bigDecimal = this.toBePaidInfo.getAFCResponseList().getAvailableCredit();
        }
        if (z) {
            this.row3Value.setText(UiUtils.formatCurrency(calculateAll()));
            this.row3Label.setText(getString(C2723R.string.lbl_amount_selected, new Object[]{Integer.valueOf(this.totalCount)}));
            this.remaining = bigDecimal;
            this.remaining = this.remaining.subtract(this.selected);
        } else {
            this.totalCount = 0;
            this.selectionRowNumber.clear();
            this.selected = new BigDecimal(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            this.row3Value.setText(UiUtils.formatCurrency(this.selected));
            this.row3Label.setText(getString(C2723R.string.lbl_amount_selected, new Object[]{Integer.valueOf(this.totalCount)}));
            this.remaining = bigDecimal;
        }
        if (this.remaining.signum() < 0) {
            this.row2Value.setText(removeNegativeValaue(UiUtils.formatCurrency(this.remaining)));
            this.row2Value.setTextColor(getResources().getColor(C2723R.C2724color.iaa_red));
        } else {
            this.row2Value.setText(UiUtils.formatCurrency(this.remaining));
            this.row2Value.setTextColor(getResources().getColor(C2723R.C2724color.iaa_black));
        }
        getPaymentButtonStatus();
    }

    private String removeNegativeValaue(String str) {
        return (!str.startsWith("(") || !str.endsWith(")")) ? str : str.replace("(", "-").substring(0, str.length() - 1);
    }

    public void updateSelection(int i, boolean z) {
        ToBePaidVehicle toBePaidVehicle = this.toBePaidInfo.getTobePaidList().get(i);
        BigDecimal availableCredit = this.paymentOption.equals(Constants.PAYMENT_OPTION_AFC) ? this.toBePaidInfo.getAFCResponseList().getAvailableCredit() : this.toBePaidInfo.getDailyBalance();
        if (this.isSelectAll) {
            if (z) {
                this.totalCount++;
                this.selected = this.selected.add(toBePaidVehicle.getTotalDue());
                this.remaining = availableCredit.subtract(this.selected);
                if (!this.selectionRowNumber.contains(toBePaidVehicle.getRowNumber() + "")) {
                    this.selectionRowNumber.add(toBePaidVehicle.getRowNumber() + "");
                }
            } else {
                this.totalCount--;
                this.selected = this.selected.subtract(toBePaidVehicle.getTotalDue());
                this.remaining = availableCredit.subtract(this.selected);
                if (this.selectionRowNumber.contains(toBePaidVehicle.getRowNumber() + "")) {
                    this.selectionRowNumber.remove(toBePaidVehicle.getRowNumber() + "");
                }
                selectAllCheckBoxStatusUpdate(false);
            }
        } else if (z) {
            this.totalCount++;
            this.selected = this.selected.add(toBePaidVehicle.getTotalDue());
            this.remaining = availableCredit.subtract(this.selected);
            if (!this.selectionRowNumber.contains(toBePaidVehicle.getRowNumber() + "")) {
                this.selectionRowNumber.add(toBePaidVehicle.getRowNumber() + "");
                toBePaidVehicle.getRowNumber();
            }
        } else {
            this.totalCount--;
            this.selected = this.selected.subtract(toBePaidVehicle.getTotalDue());
            this.remaining = availableCredit.subtract(this.selected);
            if (this.selectionRowNumber.contains(toBePaidVehicle.getRowNumber() + "")) {
                this.selectionRowNumber.remove(toBePaidVehicle.getRowNumber() + "");
            }
            selectAllCheckBoxStatusUpdate(false);
        }
        this.row3Value.setText(UiUtils.formatCurrency(this.selected));
        if (this.remaining.signum() < 0) {
            this.row2Value.setText(removeNegativeValaue(UiUtils.formatCurrency(this.remaining)));
            this.row2Value.setTextColor(getResources().getColor(C2723R.C2724color.iaa_red));
        } else {
            this.row2Value.setText(UiUtils.formatCurrency(this.remaining));
            this.row2Value.setTextColor(getResources().getColor(C2723R.C2724color.iaa_black));
        }
        this.row3Label.setText(getString(C2723R.string.lbl_amount_selected, new Object[]{Integer.valueOf(this.totalCount)}));
        getPaymentButtonStatus();
    }

    private void selectAllCheckBoxStatusUpdate(boolean z) {
        this.selectAll.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        this.selectAll.setChecked(z);
        this.selectAll.setOnCheckedChangeListener(this.selectAllListener);
        if (!z) {
            this.isSelectAll = false;
        }
    }

    private BigDecimal calculateAll() {
        this.selected = new BigDecimal(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        this.totalCount = 0;
        this.selectionRowNumber.clear();
        for (int i = 0; i < this.toBePaidInfo.getTobePaidList().size(); i++) {
            ToBePaidVehicle toBePaidVehicle = this.toBePaidInfo.getTobePaidList().get(i);
            if (toBePaidVehicle.isEnabledRow() && !toBePaidVehicle.isAlaskaInd() && ((!this.toBePaidInfo.isAFC() || toBePaidVehicle.isAFCEligibleOnSoldDate()) && ((!this.toBePaidInfo.isAFC() || !toBePaidVehicle.isPartialPaymentInd()) && ((!this.toBePaidInfo.isAFC() || toBePaidVehicle.getTowFee().floatValue() <= 250.0f) && ((!this.toBePaidInfo.isAFC() || toBePaidVehicle.getBidAmount().floatValue() > 0.0f) && ((!this.toBePaidInfo.isAFC() || toBePaidVehicle.isAFCEligibleOnSoldDate() || toBePaidVehicle.getBidAmount().floatValue() <= 0.0f) && !toBePaidVehicle.isFinancedItem() && (TextUtils.isEmpty(toBePaidVehicle.ReferenceNumber.trim()) || toBePaidVehicle.isEnabledRow()))))))) {
                this.totalCount++;
                this.selected = this.selected.add(toBePaidVehicle.getTotalDue());
                this.selectionRowNumber.add(toBePaidVehicle.getRowNumber() + "");
            }
        }
        return this.selected;
    }

    public void getPaymentButtonStatus() {
        if (this.paymentOption.equals(Constants.PAYMENT_OPTION_ACH)) {
            if (this.remaining.compareTo(this.toBePaidInfo.getDailyBalance()) == 0 || this.remaining.signum() < 0) {
                this.paymentButton.setBackgroundResource(C2723R.C2725drawable.btn_green_disabled);
                this.paymentButton.setEnabled(false);
                return;
            }
            this.paymentButton.setBackgroundResource(C2723R.C2725drawable.btn_green_normal);
            this.paymentButton.setEnabled(true);
        } else if (!this.paymentOption.equals(Constants.PAYMENT_OPTION_AFC)) {
        } else {
            if (this.remaining.compareTo(this.toBePaidInfo.AFCResponseList.getAvailableCredit()) == 0 || this.remaining.signum() < 0) {
                this.paymentButton.setBackgroundResource(C2723R.C2725drawable.btn_green_disabled);
                this.paymentButton.setEnabled(false);
                return;
            }
            this.paymentButton.setBackgroundResource(C2723R.C2725drawable.btn_green_normal);
            this.paymentButton.setEnabled(true);
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public void setDialog(Dialog dialog) {
        this.mDialog = dialog;
    }

    /* access modifiers changed from: package-private */
    public void handleTimeout() {
        if (this.isActivityInFront) {
            ActivityHelper.showAlert((Activity) this, getString(C2723R.string.timeout_header), getString(C2723R.string.timeout_message), (ICommand<DialogInterface>) new ICommand<DialogInterface>() {
                public void execute(DialogInterface dialogInterface) {
                    this.finish();
                }
            });
        } else {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.isActivityInFront = true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.isActivityInFront = false;
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == 300) {
            Log.d("Selection Activity", "Confirmation Done from Review");
            finish();
        }
    }
}
