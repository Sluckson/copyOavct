package com.iaai.android.old.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.model.login.BDTLoginResponse;
import com.iaai.android.old.adapter.FeeAdapter;
import com.iaai.android.old.adapter.ToBePaidListAdapter;
import com.iaai.android.old.adapter.ToBePaidReviewAdapter;
import com.iaai.android.old.managers.ToBePaidManager;
import com.iaai.android.old.models.Fees;
import com.iaai.android.old.models.GetFeesResult;
import com.iaai.android.old.models.ToBePaidConfirmation;
import com.iaai.android.old.models.ToBePaidInfo;
import com.iaai.android.old.utils.ICommand;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.ActivityHelper;
import com.iaai.android.old.utils.p016ui.IDialogContainer;
import com.iaai.android.old.utils.p016ui.MDActivityHelper;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.util.ArrayList;
import p052cz.msebera.android.httpclient.Header;
import roboguice.application.RoboApplication;
import roboguice.inject.InjectView;

public class ToBePaidReviewActivity extends AbstractActivity implements IDialogContainer {
    ToBePaidListAdapter adapter;
    ToBePaidReviewAdapter adapterNew;
    String afcHeader;
    @InjectView(2131296464)
    ImageButton backButton;
    String finance;
    @InjectView(2131298919)
    TextView financeAmount;
    @InjectView(2131298921)
    TextView financeType;
    String guidIdentifier;
    @InjectView(2131298926)
    TextView header;
    private boolean isActivityInFront;
    String isMyItemOnlyString;
    @InjectView(2131297527)
    LinearLayout llToBePaidPassword;
    Dialog mDialog;
    ICommand<GetFeesResult> onFeesClicked = new ICommand<GetFeesResult>() {
        public void execute(final GetFeesResult getFeesResult) {
            final Dialog showLoadingDialog = MDActivityHelper.showLoadingDialog(getFeesResult.activity);
            ToBePaidReviewActivity.this.toBePaidManager.loadToBePaidFeesInfo(ToBePaidReviewActivity.this.isMyItemOnlyString, getFeesResult.rowNo, getFeesResult.guid, new AsyncHttpResponseHandler() {
                public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                    getFeesResult.gridView.setAdapter(new FeeAdapter(getFeesResult.activity, C2723R.C2728layout.tobepaid_fees_row, ((Fees) new Gson().fromJson(new String(bArr), Fees.class)).getFeesList()));
                    showLoadingDialog.dismiss();
                }

                public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                    Toast.makeText(ToBePaidReviewActivity.this.getApplicationContext(), C2723R.string.msg_network_error, 0).show();
                    showLoadingDialog.dismiss();
                }
            });
        }
    };
    @InjectView(2131298979)
    EditText password;
    TextWatcher passwordWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (!TextUtils.isEmpty(editable)) {
                ToBePaidReviewActivity.this.submitButton.setEnabled(true);
                ToBePaidReviewActivity.this.submitButton.setBackgroundResource(C2723R.C2725drawable.btn_green_normal);
                return;
            }
            ToBePaidReviewActivity.this.submitButton.setEnabled(false);
            ToBePaidReviewActivity.this.submitButton.setBackgroundResource(C2723R.C2725drawable.btn_green_disabled);
        }
    };
    @InjectView(2131297279)
    ImageView paymentLogo;
    @InjectView(2131298981)
    TextView paymentMehod;
    @InjectView(2131297553)
    LinearLayout paymentMehodLayout;
    String paymentMethodType;
    public String paymentOption;
    @InjectView(2131298223)
    ListView selectionList;
    ArrayList<String> selectionRowNumbers;
    SessionManager sessionManager;
    @InjectView(2131296655)
    Button submitButton;
    View.OnClickListener submitListener = new View.OnClickListener() {
        public void onClick(View view) {
            if (ToBePaidReviewActivity.this.isNetworkConnectionAvailable()) {
                ActivityHelper.closeSoftKeyboard(ToBePaidReviewActivity.this);
                final Dialog showLoadingDialog = MDActivityHelper.showLoadingDialog(ToBePaidReviewActivity.this);
                ToBePaidReviewActivity.this.toBePaidManager.login(ToBePaidReviewActivity.this.sessionManager.getCurrentSessionUsername(), ToBePaidReviewActivity.this.password.getText().toString(), new AsyncHttpResponseHandler() {
                    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                        BDTLoginResponse bDTLoginResponse = (BDTLoginResponse) new Gson().fromJson(new String(bArr), BDTLoginResponse.class);
                        Dialog dialog = showLoadingDialog;
                        if (dialog != null) {
                            dialog.dismiss();
                        }
                        if (bDTLoginResponse.getUserID() == null || bDTLoginResponse.getUserID().isEmpty()) {
                            ActivityHelper.showAlert((Activity) ToBePaidReviewActivity.this, ToBePaidReviewActivity.this.getString(C2723R.string.lbl_wrong_password_header), ToBePaidReviewActivity.this.getString(C2723R.string.lbl_wrong_password_message), (ICommand<DialogInterface>) new ICommand<DialogInterface>() {
                                public void execute(DialogInterface dialogInterface) {
                                    dialogInterface.dismiss();
                                }
                            });
                        } else {
                            ToBePaidReviewActivity.this.loginSuccessful();
                        }
                    }

                    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                        Dialog dialog = showLoadingDialog;
                        if (dialog != null) {
                            dialog.dismiss();
                        }
                        MDActivityHelper.showAlert((Activity) ToBePaidReviewActivity.this, ToBePaidReviewActivity.this.getString(C2723R.string.lbl_wrong_password_header), ToBePaidReviewActivity.this.getString(C2723R.string.lbl_wrong_password_message), (ICommand<DialogInterface>) new ICommand<DialogInterface>() {
                            public void execute(DialogInterface dialogInterface) {
                                dialogInterface.dismiss();
                            }
                        });
                    }
                });
                return;
            }
            Toast.makeText(ToBePaidReviewActivity.this.getApplicationContext(), C2723R.string.msg_network_error, 0).show();
        }
    };
    ToBePaidInfo toBePaidInfo;
    ToBePaidManager toBePaidManager;
    @InjectView(2131299082)
    TextView vehicleCount;

    public Context getContext() {
        return this;
    }

    public boolean isDialogHandled() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.to_be_paid_review);
        this.sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();
        getIntentData(getIntent());
        initialize();
        loadData();
    }

    /* access modifiers changed from: package-private */
    public void getIntentData(Intent intent) {
        this.paymentOption = intent.getStringExtra(Constants.EXTRA_PAYMENT_OPTION);
        this.selectionRowNumbers = intent.getStringArrayListExtra(Constants.EXTRA_ROW_SELECTION);
        this.guidIdentifier = intent.getStringExtra(Constants.EXTRA_GUID_IDENTIFIER);
        this.isMyItemOnlyString = intent.getStringExtra(Constants.MY_VEHICLES_ONLY_ARG);
        this.finance = intent.getStringExtra(Constants.FINANCE_AMOUNT);
        this.paymentMethodType = intent.getStringExtra(Constants.PAYMENT_METHOD_SELECTION_TYPE);
        this.afcHeader = intent.getStringExtra(Constants.AFC_PAYMENT_METHOD_SELCTION);
    }

    private void initialize() {
        this.toBePaidManager = (ToBePaidManager) ((RoboApplication) getApplication()).getInjector().getInstance(ToBePaidManager.class);
        this.header.setText(C2723R.string.lbl_payment_review);
        if (this.paymentOption.equals(Constants.PAYMENT_OPTION_ACH)) {
            this.paymentLogo.setImageResource(C2723R.C2725drawable.ipay_logo);
            this.paymentMehodLayout.setVisibility(8);
            this.paymentMehod.setText(C2723R.string.btn_lbl_ipay);
        } else if (this.paymentOption.equals(Constants.PAYMENT_OPTION_AFC)) {
            this.paymentLogo.setImageResource(C2723R.C2725drawable.afc_logo);
            this.financeType.setText(this.afcHeader);
            this.paymentMehod.setText(C2723R.string.btn_lbl_afc);
        }
        this.financeAmount.setText(this.finance);
        this.submitButton.setEnabled(false);
        this.submitButton.setOnClickListener(this.submitListener);
        this.password.addTextChangedListener(this.passwordWatcher);
        this.backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ToBePaidReviewActivity.this.setResult(200);
                ToBePaidReviewActivity.this.finish();
                ToBePaidReviewActivity.this.overridePendingTransition(C2723R.anim.none, C2723R.anim.push_right_out);
            }
        });
    }

    public void onBackPressed() {
        setResult(200);
        finish();
    }

    /* access modifiers changed from: private */
    public void loginSuccessful() {
        this.password.setText("");
        ActivityHelper.closeSoftKeyboard(this);
        Intent intent = new Intent(this, ToBePaidConfirmationActivity.class);
        intent.putExtra(Constants.EXTRA_PAYMENT_OPTION, this.paymentOption);
        intent.putStringArrayListExtra(Constants.EXTRA_ROW_SELECTION, this.selectionRowNumbers);
        intent.putExtra(Constants.EXTRA_GUID_IDENTIFIER, this.guidIdentifier);
        intent.putExtra(Constants.MY_VEHICLES_ONLY_ARG, this.isMyItemOnlyString);
        intent.putExtra(Constants.FINANCE_AMOUNT, this.finance);
        intent.putExtra(Constants.PAYMENT_METHOD_SELECTION_TYPE, this.paymentMethodType);
        intent.putExtra(Constants.AFC_PAYMENT_METHOD_SELCTION, this.afcHeader);
        intent.putParcelableArrayListExtra(Constants.VEHICLE_LIST_CONFIRMATION, this.toBePaidInfo.tobePaidList);
        if (!(this.toBePaidInfo.AFCResponseList == null || this.toBePaidInfo.AFCResponseList.DealerPhone == null || TextUtils.isEmpty(this.toBePaidInfo.AFCResponseList.DealerPhone))) {
            intent.putExtra(Constants.AFC_DEALER_PHONE, this.toBePaidInfo.AFCResponseList.DealerPhone);
        }
        startActivityForResult(intent, 1);
    }

    private void loadData() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.selectionRowNumbers.size(); i++) {
            if (i == this.selectionRowNumbers.size() - 1) {
                sb.append(this.selectionRowNumbers.get(i));
            } else {
                sb.append(this.selectionRowNumbers.get(i) + ",");
            }
        }
        final Dialog showLoadingDialog = MDActivityHelper.showLoadingDialog(this);
        this.toBePaidManager.getIpayInfoSpecificTerm(sb.toString(), this.guidIdentifier, this.paymentMethodType, new AsyncHttpResponseHandler() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                Gson gson = new Gson();
                String str = new String(bArr);
                ToBePaidReviewActivity.this.toBePaidInfo = (ToBePaidInfo) gson.fromJson(str, ToBePaidInfo.class);
                showLoadingDialog.dismiss();
                if (ToBePaidReviewActivity.this.toBePaidInfo.tobePaidList != null) {
                    ToBePaidReviewActivity toBePaidReviewActivity = ToBePaidReviewActivity.this;
                    toBePaidReviewActivity.displaySearchResult(toBePaidReviewActivity.toBePaidInfo);
                } else if (ToBePaidReviewActivity.this.toBePaidInfo.getAFCResponseList().ErrorMessage != null) {
                    ToBePaidReviewActivity.this.llToBePaidPassword.setVisibility(8);
                    ToBePaidReviewActivity toBePaidReviewActivity2 = ToBePaidReviewActivity.this;
                    Toast.makeText(toBePaidReviewActivity2, toBePaidReviewActivity2.toBePaidInfo.getAFCResponseList().ErrorMessage, 1).show();
                }
            }

            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                Toast.makeText(ToBePaidReviewActivity.this.getApplicationContext(), C2723R.string.msg_network_error, 0).show();
                showLoadingDialog.dismiss();
            }
        });
    }

    public void displaySearchResult(ToBePaidInfo toBePaidInfo2) {
        TextView textView = this.vehicleCount;
        textView.setText(toBePaidInfo2.tobePaidList.size() + "");
        ActivityHelper.dismissDialog(this);
        this.adapterNew = new ToBePaidReviewAdapter(this, toBePaidInfo2.tobePaidList, false, (ToBePaidConfirmation) null);
        this.selectionList.setAdapter(this.adapterNew);
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

    /* access modifiers changed from: package-private */
    public boolean isNetworkConnectionAvailable() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        NetworkInfo.State state = activeNetworkInfo.getState();
        if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
            return true;
        }
        return false;
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
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == 300) {
            setResult(300);
            finish();
        }
    }
}
