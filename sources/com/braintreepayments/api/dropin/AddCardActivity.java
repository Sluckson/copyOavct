package com.braintreepayments.api.dropin;

import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ViewSwitcher;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import com.braintreepayments.api.Card;
import com.braintreepayments.api.ThreeDSecure;
import com.braintreepayments.api.UnionPay;
import com.braintreepayments.api.dropin.interfaces.AddPaymentUpdateListener;
import com.braintreepayments.api.dropin.view.AddCardView;
import com.braintreepayments.api.dropin.view.EditCardView;
import com.braintreepayments.api.dropin.view.EnrollmentCardView;
import com.braintreepayments.api.exceptions.AuthenticationException;
import com.braintreepayments.api.exceptions.AuthorizationException;
import com.braintreepayments.api.exceptions.ConfigurationException;
import com.braintreepayments.api.exceptions.DownForMaintenanceException;
import com.braintreepayments.api.exceptions.ErrorWithResponse;
import com.braintreepayments.api.exceptions.InvalidArgumentException;
import com.braintreepayments.api.exceptions.ServerException;
import com.braintreepayments.api.exceptions.UnexpectedException;
import com.braintreepayments.api.exceptions.UpgradeRequiredException;
import com.braintreepayments.api.interfaces.BraintreeCancelListener;
import com.braintreepayments.api.interfaces.BraintreeErrorListener;
import com.braintreepayments.api.interfaces.ConfigurationListener;
import com.braintreepayments.api.interfaces.PaymentMethodNonceCreatedListener;
import com.braintreepayments.api.interfaces.UnionPayListener;
import com.braintreepayments.api.models.CardBuilder;
import com.braintreepayments.api.models.Configuration;
import com.braintreepayments.api.models.PaymentMethodNonce;
import com.braintreepayments.api.models.UnionPayCapabilities;
import com.braintreepayments.api.models.UnionPayCardBuilder;
import com.braintreepayments.cardform.view.CardForm;

public class AddCardActivity extends BaseActivity implements ConfigurationListener, AddPaymentUpdateListener, PaymentMethodNonceCreatedListener, BraintreeErrorListener, BraintreeCancelListener, UnionPayListener {
    private static final int CARD_ENTRY = 2;
    private static final int DETAILS_ENTRY = 3;
    private static final int ENROLLMENT_ENTRY = 4;
    private static final String EXTRA_ENROLLMENT_ID = "com.braintreepayments.api.EXTRA_ENROLLMENT_ID";
    private static final String EXTRA_STATE = "com.braintreepayments.api.EXTRA_STATE";
    private static final int LOADING = 1;
    private ActionBar mActionBar;
    private AddCardView mAddCardView;
    private EditCardView mEditCardView;
    private EnrollmentCardView mEnrollmentCardView;
    private String mEnrollmentId;
    private int mState = 2;
    private boolean mUnionPayCard;
    private boolean mUnionPayDebitCard;
    private ViewSwitcher mViewSwitcher;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0944R.C0949layout.bt_add_card_activity);
        this.mViewSwitcher = (ViewSwitcher) findViewById(C0944R.C0947id.bt_loading_view_switcher);
        this.mAddCardView = (AddCardView) findViewById(C0944R.C0947id.bt_add_card_view);
        this.mEditCardView = (EditCardView) findViewById(C0944R.C0947id.bt_edit_card_view);
        this.mEnrollmentCardView = (EnrollmentCardView) findViewById(C0944R.C0947id.bt_enrollment_card_view);
        this.mEnrollmentCardView.setup(this);
        setSupportActionBar((Toolbar) findViewById(C0944R.C0947id.bt_toolbar));
        this.mActionBar = getSupportActionBar();
        this.mActionBar.setDisplayHomeAsUpEnabled(true);
        this.mAddCardView.setAddPaymentUpdatedListener(this);
        this.mEditCardView.setAddPaymentUpdatedListener(this);
        this.mEnrollmentCardView.setAddPaymentUpdatedListener(this);
        if (bundle != null) {
            this.mState = bundle.getInt(EXTRA_STATE);
            this.mEnrollmentId = bundle.getString(EXTRA_ENROLLMENT_ID);
        } else {
            this.mState = 2;
        }
        this.mAddCardView.getCardForm().maskCardNumber(this.mDropInRequest.shouldMaskCardNumber());
        this.mEditCardView.getCardForm().maskCardNumber(this.mDropInRequest.shouldMaskCardNumber());
        this.mEditCardView.getCardForm().maskCvv(this.mDropInRequest.shouldMaskSecurityCode());
        enterState(1);
        try {
            this.mBraintreeFragment = getBraintreeFragment();
            this.mBraintreeFragment.sendAnalyticsEvent("card.selected");
        } catch (InvalidArgumentException e) {
            finish(e);
        }
    }

    public void onConfigurationFetched(Configuration configuration) {
        this.mConfiguration = configuration;
        this.mAddCardView.setup(this, configuration, this.mClientTokenPresent);
        this.mEditCardView.setup(this, configuration, this.mDropInRequest);
        setState(1, this.mState);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(EXTRA_STATE, this.mState);
        bundle.putString(EXTRA_ENROLLMENT_ID, this.mEnrollmentId);
    }

    public void onPaymentUpdated(View view) {
        setState(this.mState, determineNextState(view));
    }

    private void setState(int i, int i2) {
        if (i != i2) {
            leaveState(i);
            enterState(i2);
            this.mState = i2;
        }
    }

    private void leaveState(int i) {
        if (i == 1) {
            this.mViewSwitcher.setDisplayedChild(1);
        } else if (i == 2) {
            this.mAddCardView.setVisibility(8);
        } else if (i == 3) {
            this.mEditCardView.setVisibility(8);
        } else if (i == 4) {
            this.mEnrollmentCardView.setVisibility(8);
        }
    }

    private void enterState(int i) {
        if (i == 1) {
            this.mActionBar.setTitle(C0944R.string.bt_card_details);
            this.mViewSwitcher.setDisplayedChild(0);
        } else if (i == 2) {
            this.mActionBar.setTitle(C0944R.string.bt_card_details);
            this.mAddCardView.setVisibility(0);
        } else if (i == 3) {
            this.mActionBar.setTitle(C0944R.string.bt_card_details);
            this.mEditCardView.setCardNumber(this.mAddCardView.getCardForm().getCardNumber());
            this.mEditCardView.useUnionPay(this, this.mUnionPayCard, this.mUnionPayDebitCard);
            this.mEditCardView.setVisibility(0);
        } else if (i == 4) {
            this.mActionBar.setTitle(C0944R.string.bt_confirm_enrollment);
            EnrollmentCardView enrollmentCardView = this.mEnrollmentCardView;
            enrollmentCardView.setPhoneNumber(PhoneNumberUtils.formatNumber(this.mEditCardView.getCardForm().getCountryCode() + this.mEditCardView.getCardForm().getMobileNumber()));
            this.mEnrollmentCardView.setVisibility(0);
        }
    }

    public void onBackRequested(View view) {
        if (view.getId() == this.mEditCardView.getId()) {
            setState(3, 2);
        } else if (view.getId() == this.mEnrollmentCardView.getId()) {
            setState(4, 3);
        }
    }

    private int determineNextState(View view) {
        int i = this.mState;
        if (view.getId() != this.mAddCardView.getId() || TextUtils.isEmpty(this.mAddCardView.getCardForm().getCardNumber())) {
            if (view.getId() == this.mEditCardView.getId()) {
                if (!this.mUnionPayCard) {
                    int i2 = this.mState;
                    createCard();
                    return i2;
                } else if (!TextUtils.isEmpty(this.mEnrollmentId)) {
                    return 4;
                } else {
                    enrollUnionPayCard();
                    return i;
                }
            } else if (view.getId() != this.mEnrollmentCardView.getId()) {
                return i;
            } else {
                int i3 = this.mState;
                if (this.mEnrollmentCardView.hasFailedEnrollment()) {
                    enrollUnionPayCard();
                    return i3;
                }
                createCard();
                return i3;
            }
        } else if (!this.mConfiguration.getUnionPay().isEnabled() || !this.mClientTokenPresent) {
            this.mEditCardView.useUnionPay(this, false, false);
            return 3;
        } else {
            UnionPay.fetchCapabilities(this.mBraintreeFragment, this.mAddCardView.getCardForm().getCardNumber());
            return i;
        }
    }

    private void enrollUnionPayCard() {
        UnionPay.enroll(this.mBraintreeFragment, ((UnionPayCardBuilder) ((UnionPayCardBuilder) ((UnionPayCardBuilder) ((UnionPayCardBuilder) ((UnionPayCardBuilder) new UnionPayCardBuilder().cardNumber(this.mEditCardView.getCardForm().getCardNumber())).expirationMonth(this.mEditCardView.getCardForm().getExpirationMonth())).expirationYear(this.mEditCardView.getCardForm().getExpirationYear())).cvv(this.mEditCardView.getCardForm().getCvv())).postalCode(this.mEditCardView.getCardForm().getPostalCode())).mobileCountryCode(this.mEditCardView.getCardForm().getCountryCode()).mobilePhoneNumber(this.mEditCardView.getCardForm().getMobileNumber()));
    }

    /* access modifiers changed from: protected */
    public void createCard() {
        CardForm cardForm = this.mEditCardView.getCardForm();
        if (this.mUnionPayCard) {
            UnionPay.tokenize(this.mBraintreeFragment, ((UnionPayCardBuilder) ((UnionPayCardBuilder) ((UnionPayCardBuilder) ((UnionPayCardBuilder) ((UnionPayCardBuilder) ((UnionPayCardBuilder) new UnionPayCardBuilder().cardholderName(cardForm.getCardholderName())).cardNumber(cardForm.getCardNumber())).expirationMonth(cardForm.getExpirationMonth())).expirationYear(cardForm.getExpirationYear())).cvv(cardForm.getCvv())).postalCode(cardForm.getPostalCode())).mobileCountryCode(cardForm.getCountryCode()).mobilePhoneNumber(cardForm.getMobileNumber()).enrollmentId(this.mEnrollmentId).smsCode(this.mEnrollmentCardView.getSmsCode()));
            return;
        }
        CardBuilder cardBuilder = (CardBuilder) ((CardBuilder) ((CardBuilder) ((CardBuilder) ((CardBuilder) ((CardBuilder) ((CardBuilder) new CardBuilder().cardholderName(cardForm.getCardholderName())).cardNumber(cardForm.getCardNumber())).expirationMonth(cardForm.getExpirationMonth())).expirationYear(cardForm.getExpirationYear())).cvv(cardForm.getCvv())).postalCode(cardForm.getPostalCode())).validate(this.mClientTokenPresent && cardForm.isSaveCardCheckBoxChecked());
        if (shouldRequestThreeDSecureVerification()) {
            ThreeDSecure.performVerification(this.mBraintreeFragment, cardBuilder, this.mDropInRequest.getAmount());
        } else {
            Card.tokenize(this.mBraintreeFragment, cardBuilder);
        }
    }

    public void onPaymentMethodNonceCreated(PaymentMethodNonce paymentMethodNonce) {
        this.mBraintreeFragment.sendAnalyticsEvent("sdk.exit.success");
        finish(paymentMethodNonce, (String) null);
    }

    public void onCapabilitiesFetched(UnionPayCapabilities unionPayCapabilities) {
        this.mUnionPayCard = unionPayCapabilities.isUnionPay();
        this.mUnionPayDebitCard = unionPayCapabilities.isDebit();
        if (!this.mUnionPayCard || unionPayCapabilities.isSupported()) {
            setState(this.mState, 3);
        } else {
            this.mAddCardView.showCardNotSupportedError();
        }
    }

    public void onSmsCodeSent(String str, boolean z) {
        this.mEnrollmentId = str;
        if (!z || this.mState == 4) {
            createCard();
        } else {
            onPaymentUpdated(this.mEditCardView);
        }
    }

    public void onCancel(int i) {
        if (i == 13487) {
            this.mEditCardView.setVisibility(0);
        }
    }

    public void onError(Exception exc) {
        if (exc instanceof ErrorWithResponse) {
            ErrorWithResponse errorWithResponse = (ErrorWithResponse) exc;
            if (this.mEnrollmentCardView.isEnrollmentError(errorWithResponse)) {
                setState(this.mState, 4);
                this.mEnrollmentCardView.setErrors(errorWithResponse);
                return;
            }
            this.mEditCardView.setErrors(errorWithResponse);
            if (this.mAddCardView.isCardNumberError(errorWithResponse)) {
                this.mAddCardView.setErrors(errorWithResponse);
                setState(this.mState, 2);
                return;
            }
            setState(this.mState, 3);
            return;
        }
        if ((exc instanceof AuthenticationException) || (exc instanceof AuthorizationException) || (exc instanceof UpgradeRequiredException)) {
            this.mBraintreeFragment.sendAnalyticsEvent("sdk.exit.developer-error");
        } else if (exc instanceof ConfigurationException) {
            this.mBraintreeFragment.sendAnalyticsEvent("sdk.exit.configuration-exception");
        } else if ((exc instanceof ServerException) || (exc instanceof UnexpectedException)) {
            this.mBraintreeFragment.sendAnalyticsEvent("sdk.exit.server-error");
        } else if (exc instanceof DownForMaintenanceException) {
            this.mBraintreeFragment.sendAnalyticsEvent("sdk.exit.server-unavailable");
        }
        finish(exc);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        if (!this.mAddCardView.getCardForm().isCardScanningAvailable()) {
            return true;
        }
        getMenuInflater().inflate(C0944R.C0950menu.bt_card_io, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == C0944R.C0947id.bt_card_io_button) {
            this.mAddCardView.getCardForm().scanCard(this);
            return true;
        } else if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            setResult(0);
            finish();
            return true;
        }
    }
}
