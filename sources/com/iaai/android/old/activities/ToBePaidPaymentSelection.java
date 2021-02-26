package com.iaai.android.old.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentActivity;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.models.ToBePaidBranchFilter;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.constants.ToBePaidSortOptions;
import roboguice.inject.InjectView;

public class ToBePaidPaymentSelection extends AbstractActivity {
    @InjectView(2131299062)
    TextView afcAllowance;
    @InjectView(2131297149)
    ImageView afcArrow;
    @InjectView(2131296406)
    LinearLayout afcBlock;
    private String afcErrorText;
    private String afcLimit;
    @InjectView(2131296408)
    ImageView afcLogo;
    @InjectView(2131296464)
    ImageButton backButton;
    private ToBePaidBranchFilter branchSelection;
    @InjectView(2131297463)
    LinearLayout creditCard;
    @InjectView(2131298909)
    TextView errorText;
    @InjectView(2131297020)
    FrameLayout flCreditCard;
    @InjectView(2131297021)
    FrameLayout flPayPal;
    @InjectView(2131298926)
    TextView header;
    @InjectView(2131299064)
    TextView iPayAllowance;
    private String iPayDailyAllowances;
    private String iPayLimit;
    @InjectView(2131297200)
    LinearLayout ipayBlock;
    @InjectView(2131297201)
    ImageView ipayLogo;
    private boolean isAFCError;
    private boolean isIpayError;
    private String isMyItemOnlyString;
    @InjectView(2131298864)
    TextView lblAfcAllowance;
    @InjectView(2131298943)
    TextView lblIPayAllowance;
    @InjectView(2131298997)
    TextView lblRemainingAllowance;
    @InjectView(2131297498)
    LinearLayout payPal;
    private String paymentOption;
    @InjectView(2131299066)
    TextView remainingAllowance;
    private SessionManager sessionManager;
    private ToBePaidSortOptions sortOptionSelected;
    @InjectView(2131298887)
    TextView txtChooseYourPaymentMethod;
    int vehicleCount;

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        if (ToBePaidActivity.isConfirmationDone) {
            finish();
        }
    }

    public void onBackPressed() {
        setResult(200);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.tobepaid_payment_selection);
        this.sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();
        getIntentData(getIntent());
        initialize();
        if (IaaiApplication.is_credit_card_enable) {
            this.flCreditCard.setVisibility(0);
        } else {
            this.flCreditCard.setVisibility(8);
        }
        if (IaaiApplication.is_pay_pal_enabled) {
            this.flPayPal.setVisibility(0);
        } else {
            this.flPayPal.setVisibility(8);
        }
    }

    private void initialize() {
        this.header.setText(C2723R.string.lbl_payment_information);
        this.afcAllowance.setText(this.afcLimit);
        this.iPayAllowance.setText(this.iPayDailyAllowances);
        this.remainingAllowance.setText(this.iPayLimit);
        this.backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ToBePaidPaymentSelection.this.finish();
                ToBePaidPaymentSelection.this.overridePendingTransition(C2723R.anim.none, C2723R.anim.push_right_out);
            }
        });
        if (this.isIpayError || this.vehicleCount <= 0) {
            if (this.vehicleCount <= 0) {
                this.txtChooseYourPaymentMethod.setText(getString(C2723R.string.no_items_avliable_for_payment));
            }
            this.iPayAllowance.setEnabled(false);
            this.remainingAllowance.setEnabled(false);
            this.ipayLogo.setImageResource(C2723R.C2725drawable.ipay_logo_disable);
            this.lblIPayAllowance.setEnabled(false);
            this.lblRemainingAllowance.setEnabled(false);
            this.ipayBlock.setBackgroundResource(C2723R.C2725drawable.disable_tablecell_bg);
        } else {
            this.ipayBlock.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ToBePaidPaymentSelection.this.openPaymentSelection(Constants.PAYMENT_OPTION_ACH);
                }
            });
        }
        if (this.isAFCError || this.vehicleCount <= 0) {
            this.afcArrow.setVisibility(8);
            this.errorText.setVisibility(0);
            this.errorText.setText(this.afcErrorText);
            this.afcAllowance.setEnabled(false);
            this.afcLogo.setImageResource(C2723R.C2725drawable.ic_afc_logo_disabled);
            this.lblAfcAllowance.setEnabled(false);
            this.afcBlock.setBackgroundResource(C2723R.C2725drawable.disable_tablecell_bg);
        } else {
            this.afcArrow.setVisibility(0);
            this.afcBlock.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ToBePaidPaymentSelection.this.openPaymentSelection(Constants.PAYMENT_OPTION_AFC);
                }
            });
        }
        this.creditCard.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ToBePaidPaymentSelection.this.lambda$initialize$0$ToBePaidPaymentSelection(view);
            }
        });
        this.payPal.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ToBePaidPaymentSelection.this.lambda$initialize$1$ToBePaidPaymentSelection(view);
            }
        });
    }

    public /* synthetic */ void lambda$initialize$0$ToBePaidPaymentSelection(View view) {
        openPaymentSelection(Constants_MVVM.PaymentMethod.CREDIT_CARD.getValue());
    }

    public /* synthetic */ void lambda$initialize$1$ToBePaidPaymentSelection(View view) {
        openPaymentSelection(Constants_MVVM.PaymentMethod.PAY_PAL.getValue());
    }

    private void getIntentData(Intent intent) {
        this.afcLimit = intent.getStringExtra("afc_allowance");
        this.iPayLimit = intent.getStringExtra("ipay_balance");
        this.iPayDailyAllowances = intent.getStringExtra("ipay_allowance");
        this.afcErrorText = intent.getStringExtra("is_afc_error_text");
        this.isIpayError = intent.getBooleanExtra("is_ipay_error", true);
        this.isAFCError = intent.getBooleanExtra("is_afc_error", true);
        this.vehicleCount = intent.getIntExtra(Constants.INTENT_EXTRA_TOBEPAID_VEHICLE_COUNT, 0);
        this.isMyItemOnlyString = intent.getStringExtra(Constants.EXTRA_TOBPAID_MY_VEHICLES_ONLY);
        this.branchSelection = (ToBePaidBranchFilter) intent.getParcelableExtra(Constants.BRANCH_FILTER_SELECTION);
        this.sortOptionSelected = (ToBePaidSortOptions) intent.getSerializableExtra(Constants.SORTING_OPTION_SELECTION);
    }

    /* access modifiers changed from: package-private */
    public void openPaymentSelection(String str) {
        Intent intent;
        if (str.equalsIgnoreCase(Constants_MVVM.PaymentMethod.CREDIT_CARD.getValue()) || str.equalsIgnoreCase(Constants_MVVM.PaymentMethod.PAY_PAL.getValue())) {
            Intent intent2 = new Intent(this, BDTPaymentActivity.class);
            intent2.putExtra(Constants_MVVM.EXTRA_PAYMENT_METHOD, str);
            startActivity(intent2);
            return;
        }
        if (getParent() != null) {
            intent = new Intent(getParent(), ToBePaidSelectionActivity.class);
        } else {
            intent = new Intent(this, ToBePaidSelectionActivity.class);
        }
        intent.putExtra(Constants.EXTRA_PAYMENT_OPTION, str);
        intent.putExtra(Constants.EXTRA_TOBPAID_MY_VEHICLES_ONLY, this.isMyItemOnlyString);
        intent.putExtra(Constants.MY_VEHICLES_ONLY_ARG, this.isMyItemOnlyString);
        intent.addFlags(67108864);
        intent.putExtra(Constants.SORTING_OPTION_SELECTION, this.sortOptionSelected);
        intent.putExtra(Constants.BRANCH_FILTER_SELECTION, this.branchSelection);
        startActivityForResult(intent, 1);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == 300) {
            Log.d("Selection Activity", "Confirmation Done");
        }
    }
}
