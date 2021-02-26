package com.iaai.android.old.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;
import com.google.gson.Gson;
import com.iaai.android.C2723R;
import com.iaai.android.old.activities.ToBePaidActivity;
import com.iaai.android.old.activities.ToBePaidSelectionActivity;
import com.iaai.android.old.adapter.FeeAdapter;
import com.iaai.android.old.adapter.ToBePaidListAdapter;
import com.iaai.android.old.managers.ToBePaidManager;
import com.iaai.android.old.models.CompletePaymentInfo;
import com.iaai.android.old.models.Fees;
import com.iaai.android.old.models.GetFeesResult;
import com.iaai.android.old.models.ToBePaidAFCResponse;
import com.iaai.android.old.models.ToBePaidBranchFilter;
import com.iaai.android.old.models.ToBePaidInfo;
import com.iaai.android.old.utils.ICommand;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.constants.ToBePaidSortOptions;
import com.iaai.android.old.utils.p016ui.ActivityHelper;
import com.iaai.android.old.utils.p016ui.MDActivityHelper;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.makeramen.segmented.SegmentedRadioGroup;
import java.math.BigDecimal;
import p052cz.msebera.android.httpclient.Header;
import roboguice.application.RoboApplication;

public class ToBePaidFragment extends Fragment {
    /* access modifiers changed from: private */
    public Activity activity;
    ToBePaidListAdapter adapter;
    private ToBePaidBranchFilter branchSelection;
    private boolean isAfc;
    /* access modifiers changed from: private */
    public String isMyItemOnlyString;
    ListView listView;
    ICommand<GetFeesResult> onFeesClicked = new ICommand<GetFeesResult>() {
        public void execute(final GetFeesResult getFeesResult) {
            final Dialog showLoadingDialog = MDActivityHelper.showLoadingDialog(getFeesResult.activity);
            ToBePaidFragment.this.toBePaidManager.loadToBePaidFeesInfo(ToBePaidFragment.this.isMyItemOnlyString, getFeesResult.rowNo, getFeesResult.guid, new AsyncHttpResponseHandler() {
                public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                    Fees fees = (Fees) new Gson().fromJson(new String(bArr), Fees.class);
                    if (fees.FeesList.length > 0) {
                        getFeesResult.gridView.setAdapter(new FeeAdapter(getFeesResult.activity, C2723R.C2728layout.tobepaid_fees_row, fees.getFeesList()));
                    }
                    showLoadingDialog.dismiss();
                }

                public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                    Toast.makeText(ToBePaidFragment.this.getActivity().getApplicationContext(), C2723R.string.msg_network_error, 0).show();
                    showLoadingDialog.dismiss();
                }
            });
        }
    };
    /* access modifiers changed from: private */
    public Button paymentButton;
    /* access modifiers changed from: private */
    public CompletePaymentInfo paymentInfo;
    /* access modifiers changed from: private */
    public String paymentOption;
    /* access modifiers changed from: private */
    public ToBePaidSortOptions selectedSort = ToBePaidSortOptions.SORT_BY_DEFAULTC;
    private int selectedSortDirection = 0;
    /* access modifiers changed from: private */
    public boolean showpaymentSelection;
    private ToBePaidSortOptions sortOptionSelected;
    private ToBePaidActivity toBePaidActivity;
    ToBePaidInfo toBePaidInfo;
    ToBePaidManager toBePaidManager;
    private ToBePaidSelectionActivity toBePaidSelectionActivity;

    public void displayCreditsLimit() {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C2723R.C2728layout.tobepaid_fragment, viewGroup, false);
    }

    public void onAttach(Activity activity2) {
        super.onAttach(activity2);
        try {
            this.activity = activity2;
            if (activity2 instanceof ToBePaidActivity) {
                this.toBePaidActivity = (ToBePaidActivity) activity2;
            } else if (activity2 instanceof ToBePaidSelectionActivity) {
                this.toBePaidSelectionActivity = (ToBePaidSelectionActivity) activity2;
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.isMyItemOnlyString = getArguments().getString(Constants.MY_VEHICLES_ONLY_ARG);
            this.paymentOption = getArguments().getString(Constants.EXTRA_PAYMENT_OPTION);
            this.showpaymentSelection = getArguments().getBoolean(Constants.SHOW_PAYMENT_SELECTION, false);
            this.isAfc = getArguments().getBoolean(Constants.IS_AFC, false);
            this.branchSelection = (ToBePaidBranchFilter) getArguments().getParcelable(Constants.BRANCH_FILTER_SELECTION);
            this.sortOptionSelected = (ToBePaidSortOptions) getArguments().getSerializable(Constants.SORTING_OPTION_SELECTION);
        }
        this.paymentInfo = new CompletePaymentInfo();
        ToBePaidSortOptions.refreshAll();
        this.selectedSort = ToBePaidSortOptions.SORT_BY_DEFAULTC;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        SegmentedRadioGroup segmentedRadioGroup = (SegmentedRadioGroup) getView().findViewById(C2723R.C2726id.seg_to_be_paid_srt);
        final RadioButton radioButton = (RadioButton) getView().findViewById(C2723R.C2726id.button_srt_due);
        final RadioButton radioButton2 = (RadioButton) getView().findViewById(C2723R.C2726id.button_srt_price);
        final RadioButton radioButton3 = (RadioButton) getView().findViewById(C2723R.C2726id.button_srt_branch);
        this.listView = (ListView) getView().findViewById(C2723R.C2726id.list);
        this.toBePaidManager = (ToBePaidManager) ((RoboApplication) getActivity().getApplication()).getInjector().getInstance(ToBePaidManager.class);
        this.paymentButton = (Button) getView().findViewById(C2723R.C2726id.btn_payment);
        radioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ToBePaidFragment.this.selectedSort == ToBePaidSortOptions.SORT_BY_DUE_DATE_ASC || ToBePaidFragment.this.selectedSort == ToBePaidSortOptions.SORT_BY_DEFAULTC) {
                    ToBePaidSortOptions unused = ToBePaidFragment.this.selectedSort = ToBePaidSortOptions.SORT_BY_DUE_DATE_DESC;
                    radioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, C2723R.C2725drawable.sorting_down, 0);
                    radioButton3.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    radioButton2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                } else {
                    ToBePaidSortOptions unused2 = ToBePaidFragment.this.selectedSort = ToBePaidSortOptions.SORT_BY_DUE_DATE_ASC;
                    radioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, C2723R.C2725drawable.sorting_up, 0);
                    radioButton3.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    radioButton2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }
                ToBePaidFragment.this.resetAllValues();
                ToBePaidFragment.this.loadData();
            }
        });
        radioButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ToBePaidFragment.this.selectedSort == ToBePaidSortOptions.SORT_BY_BRANCH_ASC) {
                    ToBePaidSortOptions unused = ToBePaidFragment.this.selectedSort = ToBePaidSortOptions.SORT_BY_BRANCH_DESC;
                    radioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    radioButton3.setCompoundDrawablesWithIntrinsicBounds(0, 0, C2723R.C2725drawable.sorting_down, 0);
                    radioButton2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                } else {
                    ToBePaidSortOptions unused2 = ToBePaidFragment.this.selectedSort = ToBePaidSortOptions.SORT_BY_BRANCH_ASC;
                    radioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    radioButton3.setCompoundDrawablesWithIntrinsicBounds(0, 0, C2723R.C2725drawable.sorting_up, 0);
                    radioButton2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }
                ToBePaidFragment.this.resetAllValues();
                ToBePaidFragment.this.loadData();
            }
        });
        radioButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ToBePaidFragment.this.selectedSort == ToBePaidSortOptions.SORT_BY_PRICE_ASC) {
                    ToBePaidSortOptions unused = ToBePaidFragment.this.selectedSort = ToBePaidSortOptions.SORT_BY_PRICE_DESC;
                    radioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    radioButton3.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    radioButton2.setCompoundDrawablesWithIntrinsicBounds(0, 0, C2723R.C2725drawable.sorting_down, 0);
                } else {
                    ToBePaidSortOptions unused2 = ToBePaidFragment.this.selectedSort = ToBePaidSortOptions.SORT_BY_PRICE_ASC;
                    radioButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    radioButton3.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    radioButton2.setCompoundDrawablesWithIntrinsicBounds(0, 0, C2723R.C2725drawable.sorting_up, 0);
                }
                ToBePaidFragment.this.resetAllValues();
                ToBePaidFragment.this.loadData();
            }
        });
        sortingSelection(this.sortOptionSelected);
        ToBePaidBranchFilter toBePaidBranchFilter = this.branchSelection;
        if (toBePaidBranchFilter != null) {
            loadData(toBePaidBranchFilter.BranchCode);
        } else {
            loadData();
        }
    }

    /* access modifiers changed from: private */
    public void loadData() {
        loadData((String) null);
    }

    private void loadData(String str) {
        final Dialog showLoadingDialog = MDActivityHelper.showLoadingDialog(getActivity());
        this.toBePaidManager.loadToBePaidInfo(this.isMyItemOnlyString, this.selectedSort, this.paymentOption, str, new AsyncHttpResponseHandler() {
            /* JADX WARNING: Code restructure failed: missing block: B:11:0x0062, code lost:
                if (r1.this$0.toBePaidInfo.isIPay() == false) goto L_0x0089;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0085, code lost:
                if (r1.this$0.toBePaidInfo.isAFC() == false) goto L_0x0089;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onSuccess(int r2, p052cz.msebera.android.httpclient.Header[] r3, byte[] r4) {
                /*
                    r1 = this;
                    com.google.gson.Gson r2 = new com.google.gson.Gson
                    r2.<init>()
                    java.lang.String r3 = new java.lang.String
                    r3.<init>(r4)
                    com.iaai.android.old.fragments.ToBePaidFragment r4 = com.iaai.android.old.fragments.ToBePaidFragment.this
                    java.lang.Class<com.iaai.android.old.models.ToBePaidInfo> r0 = com.iaai.android.old.models.ToBePaidInfo.class
                    java.lang.Object r2 = r2.fromJson((java.lang.String) r3, r0)
                    com.iaai.android.old.models.ToBePaidInfo r2 = (com.iaai.android.old.models.ToBePaidInfo) r2
                    r4.toBePaidInfo = r2
                    com.iaai.android.old.fragments.ToBePaidFragment r2 = com.iaai.android.old.fragments.ToBePaidFragment.this
                    com.iaai.android.old.models.ToBePaidInfo r2 = r2.toBePaidInfo
                    if (r2 == 0) goto L_0x00ff
                    com.iaai.android.old.fragments.ToBePaidFragment r2 = com.iaai.android.old.fragments.ToBePaidFragment.this
                    com.iaai.android.old.models.ToBePaidInfo r2 = r2.toBePaidInfo
                    java.util.List r2 = r2.getTobePaidList()
                    if (r2 == 0) goto L_0x00f9
                    com.iaai.android.old.fragments.ToBePaidFragment r2 = com.iaai.android.old.fragments.ToBePaidFragment.this
                    com.iaai.android.old.models.ToBePaidInfo r2 = r2.toBePaidInfo
                    java.util.List r2 = r2.getTobePaidList()
                    int r2 = r2.size()
                    if (r2 <= 0) goto L_0x00f9
                    com.iaai.android.old.fragments.ToBePaidFragment r2 = com.iaai.android.old.fragments.ToBePaidFragment.this
                    boolean r2 = r2.showpaymentSelection
                    java.lang.String r3 = "AFC"
                    if (r2 == 0) goto L_0x00b7
                    r2 = 0
                    com.iaai.android.old.fragments.ToBePaidFragment r4 = com.iaai.android.old.fragments.ToBePaidFragment.this
                    java.lang.String r4 = r4.paymentOption
                    java.lang.String r0 = "ACH"
                    boolean r4 = r4.equals(r0)
                    r0 = 1
                    if (r4 == 0) goto L_0x0065
                    com.iaai.android.old.fragments.ToBePaidFragment r3 = com.iaai.android.old.fragments.ToBePaidFragment.this
                    android.widget.Button r3 = r3.paymentButton
                    r4 = 2131821616(0x7f110430, float:1.927598E38)
                    r3.setText(r4)
                    com.iaai.android.old.fragments.ToBePaidFragment r3 = com.iaai.android.old.fragments.ToBePaidFragment.this
                    com.iaai.android.old.models.ToBePaidInfo r3 = r3.toBePaidInfo
                    boolean r3 = r3.isIPay()
                    if (r3 != 0) goto L_0x0088
                    goto L_0x0089
                L_0x0065:
                    com.iaai.android.old.fragments.ToBePaidFragment r4 = com.iaai.android.old.fragments.ToBePaidFragment.this
                    java.lang.String r4 = r4.paymentOption
                    boolean r3 = r4.equals(r3)
                    if (r3 == 0) goto L_0x0088
                    com.iaai.android.old.fragments.ToBePaidFragment r3 = com.iaai.android.old.fragments.ToBePaidFragment.this
                    android.widget.Button r3 = r3.paymentButton
                    r4 = 2131821444(0x7f110384, float:1.9275631E38)
                    r3.setText(r4)
                    com.iaai.android.old.fragments.ToBePaidFragment r3 = com.iaai.android.old.fragments.ToBePaidFragment.this
                    com.iaai.android.old.models.ToBePaidInfo r3 = r3.toBePaidInfo
                    boolean r3 = r3.isAFC()
                    if (r3 != 0) goto L_0x0088
                    goto L_0x0089
                L_0x0088:
                    r0 = 0
                L_0x0089:
                    if (r0 == 0) goto L_0x00a5
                    android.content.Intent r2 = new android.content.Intent
                    r2.<init>()
                    com.iaai.android.old.fragments.ToBePaidFragment r3 = com.iaai.android.old.fragments.ToBePaidFragment.this
                    android.app.Activity r3 = r3.activity
                    r4 = 100
                    r3.setResult(r4, r2)
                    com.iaai.android.old.fragments.ToBePaidFragment r2 = com.iaai.android.old.fragments.ToBePaidFragment.this
                    android.app.Activity r2 = r2.activity
                    r2.finish()
                    goto L_0x00b1
                L_0x00a5:
                    com.iaai.android.old.fragments.ToBePaidFragment r2 = com.iaai.android.old.fragments.ToBePaidFragment.this
                    com.iaai.android.old.models.ToBePaidInfo r3 = r2.toBePaidInfo
                    r2.displaySearchResult(r3)
                    com.iaai.android.old.fragments.ToBePaidFragment r2 = com.iaai.android.old.fragments.ToBePaidFragment.this
                    r2.updateValuesOnScreen()
                L_0x00b1:
                    android.app.Dialog r2 = r0
                    r2.dismiss()
                    goto L_0x0104
                L_0x00b7:
                    com.iaai.android.old.fragments.ToBePaidFragment r2 = com.iaai.android.old.fragments.ToBePaidFragment.this
                    com.iaai.android.old.models.ToBePaidInfo r4 = r2.toBePaidInfo
                    r2.displaySearchResult(r4)
                    com.iaai.android.old.fragments.ToBePaidFragment r2 = com.iaai.android.old.fragments.ToBePaidFragment.this
                    com.iaai.android.old.models.CompletePaymentInfo r2 = r2.paymentInfo
                    com.iaai.android.old.fragments.ToBePaidFragment r4 = com.iaai.android.old.fragments.ToBePaidFragment.this
                    com.iaai.android.old.models.ToBePaidInfo r4 = r4.toBePaidInfo
                    boolean r4 = r4.isIPay()
                    r2.isIpay = r4
                    com.iaai.android.old.fragments.ToBePaidFragment r2 = com.iaai.android.old.fragments.ToBePaidFragment.this
                    com.iaai.android.old.models.CompletePaymentInfo r2 = r2.paymentInfo
                    com.iaai.android.old.fragments.ToBePaidFragment r4 = com.iaai.android.old.fragments.ToBePaidFragment.this
                    com.iaai.android.old.models.ToBePaidInfo r4 = r4.toBePaidInfo
                    java.math.BigDecimal r4 = r4.getDailyBalance()
                    r2.iPayRemaining = r4
                    com.iaai.android.old.fragments.ToBePaidFragment r2 = com.iaai.android.old.fragments.ToBePaidFragment.this
                    com.iaai.android.old.models.CompletePaymentInfo r2 = r2.paymentInfo
                    com.iaai.android.old.fragments.ToBePaidFragment r4 = com.iaai.android.old.fragments.ToBePaidFragment.this
                    com.iaai.android.old.models.ToBePaidInfo r4 = r4.toBePaidInfo
                    java.math.BigDecimal r4 = r4.getDailyAllowance()
                    r2.iPayDailyAllowance = r4
                    com.iaai.android.old.fragments.ToBePaidFragment r2 = com.iaai.android.old.fragments.ToBePaidFragment.this
                    r2.loadDailyLimits(r3)
                    android.app.Dialog r2 = r0
                    r2.dismiss()
                    goto L_0x0104
                L_0x00f9:
                    android.app.Dialog r2 = r0
                    r2.dismiss()
                    goto L_0x0104
                L_0x00ff:
                    android.app.Dialog r2 = r0
                    r2.dismiss()
                L_0x0104:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.old.fragments.ToBePaidFragment.C32234.onSuccess(int, cz.msebera.android.httpclient.Header[], byte[]):void");
            }

            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                if (ToBePaidFragment.this.isAdded()) {
                    Toast.makeText(ToBePaidFragment.this.getActivity().getApplicationContext(), C2723R.string.msg_network_error, 0).show();
                }
                showLoadingDialog.dismiss();
            }
        }, true);
    }

    /* access modifiers changed from: package-private */
    public void loadDailyLimits(String str) {
        final Dialog showLoadingDialog = MDActivityHelper.showLoadingDialog(getActivity());
        if (this.isAfc) {
            this.toBePaidManager.loadToBePaidInfo(this.isMyItemOnlyString, this.selectedSort, str, (String) null, new AsyncHttpResponseHandler() {
                public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                    ToBePaidInfo toBePaidInfo = (ToBePaidInfo) new Gson().fromJson(new String(bArr), ToBePaidInfo.class);
                    ToBePaidFragment.this.paymentInfo.isAfc = ToBePaidFragment.this.toBePaidInfo.isAFC();
                    if (ToBePaidFragment.this.toBePaidInfo.isAFC()) {
                        ToBePaidFragment.this.paymentInfo.afcCredit = ToBePaidFragment.this.toBePaidInfo.getAFCResponseList().getAvailableCredit();
                    }
                    ToBePaidFragment toBePaidFragment = ToBePaidFragment.this;
                    toBePaidFragment.displayCreditsLimit(toBePaidFragment.paymentInfo, toBePaidInfo);
                    showLoadingDialog.dismiss();
                }

                public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                    ToBePaidInfo toBePaidInfo = new ToBePaidInfo();
                    toBePaidInfo.isAFC = true;
                    toBePaidInfo.AFCResponseList = new ToBePaidAFCResponse();
                    toBePaidInfo.AFCResponseList.ErrorFlag = 1;
                    toBePaidInfo.AFCResponseList.AvailableCredit = BigDecimal.ZERO;
                    ToBePaidFragment.this.paymentInfo.isAfc = true;
                    ToBePaidFragment toBePaidFragment = ToBePaidFragment.this;
                    toBePaidFragment.displayCreditsLimit(toBePaidFragment.paymentInfo, toBePaidInfo);
                    Toast.makeText(ToBePaidFragment.this.getActivity().getApplicationContext(), C2723R.string.msg_network_error, 0).show();
                    showLoadingDialog.dismiss();
                }
            }, true);
            return;
        }
        CompletePaymentInfo completePaymentInfo = this.paymentInfo;
        completePaymentInfo.isAfc = false;
        displayCreditsLimit(completePaymentInfo, (ToBePaidInfo) null);
        showLoadingDialog.dismiss();
    }

    public void displaySearchResult(ToBePaidInfo toBePaidInfo2) {
        this.adapter = new ToBePaidListAdapter(toBePaidInfo2, this.isMyItemOnlyString, this.onFeesClicked, this.activity, this.showpaymentSelection, this);
        this.listView.setAdapter(this.adapter);
        ActivityHelper.dismissDialog(this.activity);
    }

    public void displayCreditsLimit(String str, ToBePaidInfo toBePaidInfo2) {
        if (this.toBePaidActivity != null && !str.equals(Constants.PAYMENT_OPTION_AFC)) {
            str.equals(Constants.PAYMENT_OPTION_ACH);
        }
    }

    public void displayCreditsLimit(CompletePaymentInfo completePaymentInfo, ToBePaidInfo toBePaidInfo2) {
        ToBePaidActivity toBePaidActivity2 = this.toBePaidActivity;
        if (toBePaidActivity2 != null) {
            toBePaidActivity2.updatePaymentInformation(completePaymentInfo, toBePaidInfo2);
        }
    }

    public void updateValuesOnScreen() {
        ToBePaidSelectionActivity toBePaidSelectionActivity2 = this.toBePaidSelectionActivity;
        if (toBePaidSelectionActivity2 != null) {
            toBePaidSelectionActivity2.updateValues(this.toBePaidInfo);
        }
    }

    public void resetAllValues() {
        ToBePaidSelectionActivity toBePaidSelectionActivity2 = this.toBePaidSelectionActivity;
        if (toBePaidSelectionActivity2 != null) {
            toBePaidSelectionActivity2.resetDetails();
        }
    }

    public void isCheckedAll(boolean z) {
        this.adapter.isCheckedAll(z);
        this.adapter.notifyDataSetChanged();
    }

    public void updateSelection(int i, boolean z) {
        ToBePaidSelectionActivity toBePaidSelectionActivity2 = this.toBePaidSelectionActivity;
        if (toBePaidSelectionActivity2 != null) {
            toBePaidSelectionActivity2.updateSelection(i, z);
        } else {
            ToBePaidActivity toBePaidActivity2 = this.toBePaidActivity;
        }
    }

    public void sortingSelection(ToBePaidSortOptions toBePaidSortOptions) {
        if (toBePaidSortOptions != null) {
            this.sortOptionSelected = toBePaidSortOptions;
            if (toBePaidSortOptions.sortByParamValue.equals(Constants.TO_BE_PAID_SRT_DUE)) {
                if (toBePaidSortOptions.isAscending) {
                    this.selectedSort = ToBePaidSortOptions.SORT_BY_DUE_DATE_ASC;
                } else {
                    this.selectedSort = ToBePaidSortOptions.SORT_BY_DUE_DATE_DESC;
                }
            } else if (toBePaidSortOptions.sortByParamValue.equals(Constants.TO_BE_PAID_SRT_PRICE)) {
                if (toBePaidSortOptions.isAscending) {
                    this.selectedSort = ToBePaidSortOptions.SORT_BY_PRICE_ASC;
                } else {
                    this.selectedSort = ToBePaidSortOptions.SORT_BY_PRICE_DESC;
                }
            } else if (toBePaidSortOptions.sortByParamValue.equals(Constants.TO_BE_PAID_SRT_BIDDER)) {
                if (toBePaidSortOptions.isAscending) {
                    this.selectedSort = ToBePaidSortOptions.SORT_BY_BIDDER_ASC;
                } else {
                    this.selectedSort = ToBePaidSortOptions.SORT_BY_BIDDER_DSC;
                }
            } else if (toBePaidSortOptions.sortByParamValue.equals(Constants.TO_BE_PAID_SRT_BRANCH)) {
                if (toBePaidSortOptions.isAscending) {
                    this.selectedSort = ToBePaidSortOptions.SORT_BY_BRANCH_ASC;
                } else {
                    this.selectedSort = ToBePaidSortOptions.SORT_BY_BRANCH_DESC;
                }
            }
            resetAllValues();
            ToBePaidBranchFilter toBePaidBranchFilter = this.branchSelection;
            if (toBePaidBranchFilter != null) {
                loadData(toBePaidBranchFilter.BranchCode);
            } else {
                loadData();
            }
        }
    }

    public void getBranchFiltering(ToBePaidBranchFilter toBePaidBranchFilter) {
        this.branchSelection = toBePaidBranchFilter;
        resetAllValues();
        loadData(toBePaidBranchFilter.BranchCode);
    }
}
