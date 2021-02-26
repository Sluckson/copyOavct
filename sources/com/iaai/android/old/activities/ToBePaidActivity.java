package com.iaai.android.old.activities;

import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.old.fragments.ToBePaidFragment;
import com.iaai.android.old.managers.LoginStateChangeEventListener;
import com.iaai.android.old.managers.OnLoginStateChangeEvent;
import com.iaai.android.old.managers.ToBePaidManager;
import com.iaai.android.old.models.CompletePaymentInfo;
import com.iaai.android.old.models.ToBePaidBranchFilter;
import com.iaai.android.old.models.ToBePaidInfo;
import com.iaai.android.old.utils.ICommand;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.constants.ToBePaidSortOptions;
import com.iaai.android.old.utils.p016ui.ActivityHelper;
import com.iaai.android.old.utils.p016ui.CloseSoftKeyboardEnforcer;
import com.iaai.android.old.utils.p016ui.UiUtils;
import com.iaai.android.old.widgets.CustomPopupWindow;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.lang.reflect.Type;
import java.util.List;
import p052cz.msebera.android.httpclient.Header;
import roboguice.event.Observes;
import roboguice.inject.InjectView;

public class ToBePaidActivity extends AbstractActivity {
    public static ToBePaidBranchFilter branchSelected = null;
    public static boolean isConfirmationDone = false;
    public static boolean isSortingOrFilterChange = false;
    public static ToBePaidSortOptions sortOptionSelected;
    String afcError;
    String afcLimit;
    @InjectView(2131296464)
    ImageButton backButton;
    @InjectView(2131296509)
    TextView brachSelection;
    ICommand<String> brachSelectionCallBack = new ICommand<String>() {
        public void execute(String str) {
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= ToBePaidActivity.this.branchList.size()) {
                    break;
                } else if (str.equals(ToBePaidActivity.this.branchList.get(i2).BranchName)) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            Log.d("Branch Selection", str + " : " + i);
            ToBePaidActivity.this.brachSelection.setText(str);
            ToBePaidActivity.branchSelected = ToBePaidActivity.this.branchList.get(i);
            ToBePaidActivity.this.toBePaidFragment.getBranchFiltering(ToBePaidActivity.this.branchList.get(i));
        }
    };
    List<ToBePaidBranchFilter> branchList;
    @Inject
    private CloseSoftKeyboardEnforcer closeSoftKeyboardEnforcer;
    @InjectView(2131297593)
    LinearLayout creditLimit;
    @InjectView(2131296871)
    LinearLayout dividerLayout;
    @InjectView(2131298909)
    TextView errorText;
    @InjectView(2131298910)
    TextView errorTextFull;
    @InjectView(2131298926)
    private TextView header;
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
    boolean isPopupClicked = false;
    @InjectView(2131297357)
    TextView lblCreditRemaining;
    @Inject
    private LoginStateChangeEventListener loginStateChangeEventListener;
    @InjectView(2131297598)
    LinearLayout lytProceedToPayment;
    @InjectView(2131296512)
    ImageButton menuSelection;
    @InjectView(2131297547)
    LinearLayout methodSelection;
    @InjectView(2131297596)
    LinearLayout paymentInfoSingle;
    @InjectView(2131297843)
    ImageView paymentLogo;
    boolean popupStatus = false;
    CustomPopupWindow popupWindow;
    private ToBePaidSortOptions selectedSort = ToBePaidSortOptions.SORT_BY_DEFAULTC;
    private int selectedSortDirection = 0;
    private SessionManager sessionManager;
    @InjectView(2131298253)
    TextView sortSelection;
    @InjectView(2131298251)
    LinearLayout sorting;
    ICommand<ToBePaidSortOptions> sortingCommand = new ICommand<ToBePaidSortOptions>() {
        public void execute(ToBePaidSortOptions toBePaidSortOptions) {
            Log.d("Sorting Option", "sort " + toBePaidSortOptions);
            ToBePaidActivity.sortOptionSelected = toBePaidSortOptions;
            ToBePaidActivity.this.sortSelection.setText(toBePaidSortOptions.displayedName);
            ToBePaidActivity.this.toBePaidFragment.sortingSelection(toBePaidSortOptions);
        }
    };
    BroadcastReceiver timeoutBroadCastReciver;
    ToBePaidFragment toBePaidFragment;
    @Inject
    ToBePaidManager toBePaidManager;
    ToBePaidSortOptions[] tobePaidSortOption;
    @InjectView(2131297774)
    TextView txtNoVehiclesFound;
    @InjectView(2131298994)
    TextView txtProceedToPayment;
    @InjectView(2131299063)
    TextView valCreditRemaining;
    /* access modifiers changed from: private */
    public int vehicleCount;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.tobepaid_activity);
        this.sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();
        sortOptionSelected = null;
        branchSelected = null;
        ToBePaidSortOptions.refreshAll();
        this.selectedSort = ToBePaidSortOptions.SORT_BY_DEFAULTC;
        commitIntentData(getIntent());
        initialize();
        this.errorTextFull.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ToBePaidActivity.this.errorTextFull.setVisibility(8);
                ToBePaidActivity.this.errorText.setVisibility(0);
            }
        });
        this.errorText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ToBePaidActivity.this.errorTextFull.setVisibility(0);
                ToBePaidActivity.this.errorTextFull.setText(ToBePaidActivity.this.errorText.getText());
                ToBePaidActivity.this.errorText.setVisibility(8);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (isConfirmationDone) {
            sortOptionSelected = null;
            branchSelected = null;
            updateSortingAndFilteringValues();
            loadToBePaidList();
            isConfirmationDone = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        if (isSortingOrFilterChange) {
            updateSortingAndFilteringValues();
            loadToBePaidList();
            isSortingOrFilterChange = false;
        }
    }

    private void initialize() {
        this.backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ToBePaidActivity.this.finish();
                ToBePaidActivity.this.overridePendingTransition(C2723R.anim.none, C2723R.anim.push_right_out);
            }
        });
        this.sorting.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        this.tobePaidSortOption = ToBePaidSortOptions.TOBEPAID_SORT_OPTION;
        this.popupWindow = new CustomPopupWindow(this);
        this.popupWindow.addPopupItem(C2723R.string.lbl_branch_filtering);
        this.popupWindow.addPopupItem(C2723R.string.lbl_sorting);
        this.popupWindow.setOnPopupItemClickListener(new CustomPopupWindow.OnPopupItemClickListener() {
            public void onItemClick(String str, int i) {
                if (str.equalsIgnoreCase(ToBePaidActivity.this.getString(C2723R.string.lbl_sorting))) {
                    ToBePaidActivity toBePaidActivity = ToBePaidActivity.this;
                    ActivityHelper.promptSelection(toBePaidActivity, C2723R.string.lbl_sort_by, toBePaidActivity.tobePaidSortOption, ToBePaidActivity.this.sortingCommand, C2723R.string.lbl_cancel);
                } else if (str.equalsIgnoreCase(ToBePaidActivity.this.getString(C2723R.string.lbl_branch_filtering))) {
                    ToBePaidActivity.this.createBranchFilter();
                }
            }
        });
        this.menuSelection.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ToBePaidActivity.this.popupWindow.show(ToBePaidActivity.this.menuSelection);
            }
        });
        this.popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                if (ToBePaidActivity.this.isPopupClicked) {
                    ToBePaidActivity.this.popupStatus = true;
                }
            }
        });
        this.menuSelection.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    if (ToBePaidActivity.this.popupStatus) {
                        ToBePaidActivity.this.isPopupClicked = false;
                    }
                } else if (motionEvent.getAction() == 1) {
                    if (!ToBePaidActivity.this.isPopupClicked) {
                        ToBePaidActivity.this.popupWindow.show(ToBePaidActivity.this.menuSelection);
                        ToBePaidActivity.this.popupStatus = false;
                    }
                    ToBePaidActivity.this.isPopupClicked = true;
                }
                return true;
            }
        });
        this.sorting.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ToBePaidActivity.this.popupWindow.show(ToBePaidActivity.this.menuSelection);
            }
        });
        this.sortSelection.setText(ToBePaidSortOptions.SORT_BY_DEFAULTC.displayedName);
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
        ActivityHelper.showLoadingDialog(this);
        this.toBePaidManager.getBranch(this.isMyItemOnlyString, "0", new AsyncHttpResponseHandler() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                String str = new String(bArr);
                Type type = new TypeToken<List<ToBePaidBranchFilter>>() {
                }.getType();
                ToBePaidActivity.this.branchList = (List) new Gson().fromJson(str, type);
                ToBePaidActivity toBePaidActivity = ToBePaidActivity.this;
                ActivityHelper.promptSelection(toBePaidActivity, C2723R.string.lbl_filter_by_branch, toBePaidActivity.getBranchNames(toBePaidActivity.branchList), ToBePaidActivity.this.brachSelectionCallBack, C2723R.string.lbl_cancel);
                ActivityHelper.dismissDialog(ToBePaidActivity.this);
            }

            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                Toast.makeText(ToBePaidActivity.this.getApplicationContext(), C2723R.string.msg_network_error, 0).show();
                ActivityHelper.dismissDialog(ToBePaidActivity.this);
            }
        });
    }

    public void updateSortingAndFilteringValues() {
        ToBePaidBranchFilter toBePaidBranchFilter = branchSelected;
        if (toBePaidBranchFilter != null) {
            this.brachSelection.setText(toBePaidBranchFilter.BranchName);
        } else {
            this.brachSelection.setText(C2723R.string.lbl_all);
        }
        ToBePaidSortOptions toBePaidSortOptions = sortOptionSelected;
        if (toBePaidSortOptions != null) {
            this.sortSelection.setText(toBePaidSortOptions.displayedName);
            return;
        }
        sortOptionSelected = this.tobePaidSortOption[0];
        this.sortSelection.setText(sortOptionSelected.displayedName);
    }

    /* access modifiers changed from: package-private */
    public void openPaymentSelection(String str) {
        Intent intent = new Intent(getParent(), ToBePaidSelectionActivity.class);
        intent.putExtra(Constants.EXTRA_PAYMENT_OPTION, str);
        intent.putExtra(Constants.EXTRA_TOBPAID_MY_VEHICLES_ONLY, this.isMyItemOnlyString);
        intent.putExtra(Constants.MY_VEHICLES_ONLY_ARG, this.isMyItemOnlyString);
        intent.putExtra(Constants.SORTING_OPTION_SELECTION, sortOptionSelected);
        intent.putExtra(Constants.BRANCH_FILTER_SELECTION, branchSelected);
        startActivityForResult(intent, 1);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == 100) {
            ActivityHelper.showConfirmationDialog(this, Constants.TOBEPAID_DILOG_HEADER, Constants.TOBEPAID_DILOG_MESSAGE, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
        } else if (i2 == 200) {
            Log.d("ToBePaid Landing Page", "Refresh Content of this screen.");
        }
    }

    private void handleLoginStateChange(@Observes OnLoginStateChangeEvent onLoginStateChangeEvent) {
        if (!onLoginStateChangeEvent.isLoggedIn) {
            finish();
        }
    }

    private void commitIntentData(Intent intent) {
        intent.getStringExtra("url");
        Integer.toString(intent.getIntExtra("count", 0));
        this.vehicleCount = intent.getIntExtra("count", 0);
        if (this.vehicleCount <= 0) {
            this.txtNoVehiclesFound.setVisibility(0);
            this.lytProceedToPayment.setVisibility(8);
        } else {
            this.txtNoVehiclesFound.setVisibility(8);
        }
        this.isMyItemOnlyString = intent.getStringExtra(Constants.EXTRA_TOBPAID_MY_VEHICLES_ONLY);
        loadToBePaidList();
    }

    public void loadToBePaidList() {
        this.toBePaidFragment = new ToBePaidFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.MY_VEHICLES_ONLY_ARG, this.isMyItemOnlyString);
        bundle.putString(Constants.EXTRA_PAYMENT_OPTION, Constants.PAYMENT_OPTION_ACH);
        bundle.putBoolean(Constants.IS_AFC, this.sessionManager.isCurrentSessionUserAFCEligiable());
        bundle.putBoolean(Constants.SHOW_PAYMENT_SELECTION, false);
        bundle.putParcelable(Constants.BRANCH_FILTER_SELECTION, branchSelected);
        bundle.putSerializable(Constants.SORTING_OPTION_SELECTION, sortOptionSelected);
        this.toBePaidFragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(C2723R.C2726id.fragment_container, this.toBePaidFragment).commit();
    }

    public void changeButtonNamesAFC(ToBePaidInfo toBePaidInfo) {
        if (toBePaidInfo == null) {
            this.isAfc = false;
        } else if (!this.sessionManager.isCurrentSessionUserAFCEligiable()) {
            this.isAfc = false;
        } else if (!toBePaidInfo.isAFC() || toBePaidInfo.getAFCResponseList().getErrorFlag() == 2 || !this.sessionManager.isCurrentSessionUserOwner()) {
            this.isAfc = false;
        } else if (this.sessionManager.isCurrentSessionUserOwner() && (toBePaidInfo.getAFCResponseList().getAvailableCredit().floatValue() <= 0.0f || toBePaidInfo.getAFCResponseList().getErrorFlag() != 0)) {
            this.isAfc = true;
            this.afcLimit = UiUtils.formatCurrency(toBePaidInfo.getAFCResponseList().getAvailableCredit());
            if (toBePaidInfo.getAFCResponseList().getErrorFlag() == 0 && toBePaidInfo.getAFCResponseList().getAvailableCredit().floatValue() == 0.0f) {
                this.isAFCError = true;
                this.afcError = String.format(getAFCErrorMessage(20), new Object[]{toBePaidInfo.getAFCResponseList().DealerPhone});
            } else if (toBePaidInfo.getAFCResponseList().getErrorFlag() == 3) {
                this.isAFCError = true;
                this.afcError = String.format(getAFCErrorMessage(toBePaidInfo.getAFCResponseList().getErrorFlag()), new Object[]{toBePaidInfo.getAFCResponseList().DealerPhone});
            } else {
                this.isAFCError = true;
                this.afcError = getAFCErrorMessage(toBePaidInfo.getAFCResponseList().getErrorFlag());
            }
        } else if (this.sessionManager.isCurrentSessionUserOwner()) {
            this.isAfc = true;
            this.afcLimit = UiUtils.formatCurrency(toBePaidInfo.getAFCResponseList().getAvailableCredit());
            this.isAFCError = false;
        }
    }

    public void updateSelectionMessage() {
        if (this.isIpay || this.isAfc) {
            this.methodSelection.setVisibility(0);
            if (this.isAfc && !this.isIpay) {
                this.paymentInfoSingle.setVisibility(0);
                this.lblCreditRemaining.setText(getString(C2723R.string.available_credit));
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
                        ToBePaidActivity.this.openPaymentSelection(Constants.PAYMENT_OPTION_AFC);
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
                        ToBePaidActivity.this.openPaymentSelection(Constants.PAYMENT_OPTION_ACH);
                    }
                });
            } else if (this.isAfc && this.isIpay) {
                this.lytProceedToPayment.setVisibility(0);
                this.paymentInfoSingle.setVisibility(8);
                this.methodSelection.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(ToBePaidActivity.this.getParent(), ToBePaidPaymentSelection.class);
                        intent.putExtra(Constants.EXTRA_TOBPAID_MY_VEHICLES_ONLY, ToBePaidActivity.this.isMyItemOnlyString);
                        intent.putExtra(Constants.MY_VEHICLES_ONLY_ARG, ToBePaidActivity.this.isMyItemOnlyString);
                        intent.putExtra("ipay_balance", ToBePaidActivity.this.iPayLimit);
                        intent.putExtra("ipay_allowance", ToBePaidActivity.this.iPayDailyAllowance);
                        intent.putExtra("afc_allowance", ToBePaidActivity.this.afcLimit);
                        intent.putExtra("is_afc_error", ToBePaidActivity.this.isAFCError);
                        intent.putExtra("is_ipay_error", ToBePaidActivity.this.isIpayError);
                        intent.putExtra("is_afc_error_text", ToBePaidActivity.this.afcError);
                        intent.putExtra(Constants.INTENT_EXTRA_TOBEPAID_VEHICLE_COUNT, ToBePaidActivity.this.vehicleCount);
                        intent.putExtra(Constants.BRANCH_FILTER_SELECTION, ToBePaidActivity.branchSelected);
                        intent.putExtra(Constants.SORTING_OPTION_SELECTION, ToBePaidActivity.sortOptionSelected);
                        ActivityHelper.pushActivityToGroup(ToBePaidActivity.this, intent);
                    }
                });
            }
        } else {
            this.methodSelection.setVisibility(8);
            this.dividerLayout.setVisibility(8);
        }
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

    public void updatePaymentInformation(CompletePaymentInfo completePaymentInfo, ToBePaidInfo toBePaidInfo) {
        changeButtonNamesACH(completePaymentInfo);
        changeButtonNamesAFC(toBePaidInfo);
        updateSelectionMessage();
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

    public void onBackPressed() {
        if (this.popupWindow.isShowing()) {
            this.popupWindow.dismiss();
        } else {
            super.onBackPressed();
        }
    }
}
