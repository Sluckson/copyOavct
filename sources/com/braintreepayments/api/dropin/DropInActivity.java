package com.braintreepayments.api.dropin;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.annotation.VisibleForTesting;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.braintreepayments.api.DataCollector;
import com.braintreepayments.api.GooglePayment;
import com.braintreepayments.api.PayPal;
import com.braintreepayments.api.PaymentMethod;
import com.braintreepayments.api.ThreeDSecure;
import com.braintreepayments.api.Venmo;
import com.braintreepayments.api.dropin.adapters.SupportedPaymentMethodsAdapter;
import com.braintreepayments.api.dropin.adapters.VaultedPaymentMethodsAdapter;
import com.braintreepayments.api.dropin.interfaces.AnimationFinishedListener;
import com.braintreepayments.api.dropin.utils.PaymentMethodType;
import com.braintreepayments.api.exceptions.AuthenticationException;
import com.braintreepayments.api.exceptions.AuthorizationException;
import com.braintreepayments.api.exceptions.ConfigurationException;
import com.braintreepayments.api.exceptions.DownForMaintenanceException;
import com.braintreepayments.api.exceptions.GoogleApiClientException;
import com.braintreepayments.api.exceptions.InvalidArgumentException;
import com.braintreepayments.api.exceptions.ServerException;
import com.braintreepayments.api.exceptions.UnexpectedException;
import com.braintreepayments.api.exceptions.UpgradeRequiredException;
import com.braintreepayments.api.interfaces.BraintreeCancelListener;
import com.braintreepayments.api.interfaces.BraintreeErrorListener;
import com.braintreepayments.api.interfaces.BraintreeResponseListener;
import com.braintreepayments.api.interfaces.ConfigurationListener;
import com.braintreepayments.api.interfaces.PaymentMethodNonceCreatedListener;
import com.braintreepayments.api.interfaces.PaymentMethodNoncesUpdatedListener;
import com.braintreepayments.api.models.BraintreeRequestCodes;
import com.braintreepayments.api.models.CardNonce;
import com.braintreepayments.api.models.Configuration;
import com.braintreepayments.api.models.PayPalRequest;
import com.braintreepayments.api.models.PaymentMethodNonce;
import java.util.ArrayList;
import java.util.List;

public class DropInActivity extends BaseActivity implements ConfigurationListener, BraintreeCancelListener, BraintreeErrorListener, SupportedPaymentMethodsAdapter.PaymentMethodSelectedListener, PaymentMethodNoncesUpdatedListener, PaymentMethodNonceCreatedListener {
    private static final int ADD_CARD_REQUEST_CODE = 1;
    private static final int DELETE_PAYMENT_METHOD_NONCE_CODE = 2;
    private static final String EXTRA_DEVICE_DATA = "com.braintreepayments.api.EXTRA_DEVICE_DATA";
    public static final String EXTRA_ERROR = "com.braintreepayments.api.dropin.EXTRA_ERROR";
    static final String EXTRA_PAYMENT_METHOD_NONCES = "com.braintreepayments.api.EXTRA_PAYMENT_METHOD_NONCES";
    private static final String EXTRA_SHEET_SLIDE_UP_PERFORMED = "com.braintreepayments.api.EXTRA_SHEET_SLIDE_UP_PERFORMED";
    private View mBottomSheet;
    /* access modifiers changed from: private */
    public String mDeviceData;
    private ViewSwitcher mLoadingViewSwitcher;
    private boolean mRequestedThreeDSecure;
    private boolean mSheetSlideDownPerformed;
    private boolean mSheetSlideUpPerformed;
    @VisibleForTesting
    protected ListView mSupportedPaymentMethodListView;
    private TextView mSupportedPaymentMethodsHeader;
    private Button mVaultManagerButton;
    private View mVaultedPaymentMethodsContainer;
    private RecyclerView mVaultedPaymentMethodsView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0944R.C0949layout.bt_drop_in_activity);
        this.mBottomSheet = findViewById(C0944R.C0947id.bt_dropin_bottom_sheet);
        this.mLoadingViewSwitcher = (ViewSwitcher) findViewById(C0944R.C0947id.bt_loading_view_switcher);
        this.mSupportedPaymentMethodsHeader = (TextView) findViewById(C0944R.C0947id.bt_supported_payment_methods_header);
        this.mSupportedPaymentMethodListView = (ListView) findViewById(C0944R.C0947id.bt_supported_payment_methods);
        this.mVaultedPaymentMethodsContainer = findViewById(C0944R.C0947id.bt_vaulted_payment_methods_wrapper);
        this.mVaultedPaymentMethodsView = (RecyclerView) findViewById(C0944R.C0947id.bt_vaulted_payment_methods);
        this.mVaultManagerButton = (Button) findViewById(C0944R.C0947id.bt_vault_edit_button);
        this.mVaultedPaymentMethodsView.setLayoutManager(new LinearLayoutManager(this, 0, false));
        new LinearSnapHelper().attachToRecyclerView(this.mVaultedPaymentMethodsView);
        try {
            this.mBraintreeFragment = getBraintreeFragment();
            if (bundle != null) {
                this.mSheetSlideUpPerformed = bundle.getBoolean(EXTRA_SHEET_SLIDE_UP_PERFORMED, false);
                this.mDeviceData = bundle.getString(EXTRA_DEVICE_DATA);
            }
            slideUp();
        } catch (InvalidArgumentException e) {
            finish(e);
        }
    }

    public void onConfigurationFetched(Configuration configuration) {
        this.mConfiguration = configuration;
        if (this.mDropInRequest.shouldCollectDeviceData() && TextUtils.isEmpty(this.mDeviceData)) {
            DataCollector.collectDeviceData(this.mBraintreeFragment, new BraintreeResponseListener<String>() {
                public void onResponse(String str) {
                    String unused = DropInActivity.this.mDeviceData = str;
                }
            });
        }
        if (this.mDropInRequest.isGooglePaymentEnabled()) {
            GooglePayment.isReadyToPay(this.mBraintreeFragment, new BraintreeResponseListener<Boolean>() {
                public void onResponse(Boolean bool) {
                    DropInActivity.this.showSupportedPaymentMethods(bool.booleanValue());
                }
            });
        } else {
            showSupportedPaymentMethods(false);
        }
    }

    /* access modifiers changed from: private */
    public void showSupportedPaymentMethods(boolean z) {
        SupportedPaymentMethodsAdapter supportedPaymentMethodsAdapter = new SupportedPaymentMethodsAdapter(this, this);
        supportedPaymentMethodsAdapter.setup(this.mConfiguration, this.mDropInRequest, z, this.mClientTokenPresent);
        this.mSupportedPaymentMethodListView.setAdapter(supportedPaymentMethodsAdapter);
        this.mLoadingViewSwitcher.setDisplayedChild(1);
        fetchPaymentMethodNonces(false);
    }

    private void handleThreeDSecureFailure() {
        if (this.mRequestedThreeDSecure) {
            this.mRequestedThreeDSecure = false;
            fetchPaymentMethodNonces(true);
        }
    }

    public void onCancel(int i) {
        handleThreeDSecureFailure();
        this.mLoadingViewSwitcher.setDisplayedChild(1);
    }

    public void onError(final Exception exc) {
        handleThreeDSecureFailure();
        if (exc instanceof GoogleApiClientException) {
            showSupportedPaymentMethods(false);
        } else {
            slideDown(new AnimationFinishedListener() {
                public void onAnimationFinished() {
                    Exception exc = exc;
                    if ((exc instanceof AuthenticationException) || (exc instanceof AuthorizationException) || (exc instanceof UpgradeRequiredException)) {
                        DropInActivity.this.mBraintreeFragment.sendAnalyticsEvent("sdk.exit.developer-error");
                    } else if (exc instanceof ConfigurationException) {
                        DropInActivity.this.mBraintreeFragment.sendAnalyticsEvent("sdk.exit.configuration-exception");
                    } else if ((exc instanceof ServerException) || (exc instanceof UnexpectedException)) {
                        DropInActivity.this.mBraintreeFragment.sendAnalyticsEvent("sdk.exit.server-error");
                    } else if (exc instanceof DownForMaintenanceException) {
                        DropInActivity.this.mBraintreeFragment.sendAnalyticsEvent("sdk.exit.server-unavailable");
                    } else {
                        DropInActivity.this.mBraintreeFragment.sendAnalyticsEvent("sdk.exit.sdk-error");
                    }
                    DropInActivity.this.finish(exc);
                }
            });
        }
    }

    public void onPaymentMethodNonceCreated(final PaymentMethodNonce paymentMethodNonce) {
        if (this.mRequestedThreeDSecure || !(paymentMethodNonce instanceof CardNonce) || !shouldRequestThreeDSecureVerification()) {
            slideDown(new AnimationFinishedListener() {
                public void onAnimationFinished() {
                    DropInActivity.this.mBraintreeFragment.sendAnalyticsEvent("sdk.exit.success");
                    DropInResult.setLastUsedPaymentMethodType(DropInActivity.this, paymentMethodNonce);
                    DropInActivity dropInActivity = DropInActivity.this;
                    dropInActivity.finish(paymentMethodNonce, dropInActivity.mDeviceData);
                }
            });
            return;
        }
        this.mRequestedThreeDSecure = true;
        this.mLoadingViewSwitcher.setDisplayedChild(0);
        ThreeDSecure.performVerification(this.mBraintreeFragment, paymentMethodNonce.getNonce(), this.mDropInRequest.getAmount());
    }

    public void onPaymentMethodSelected(PaymentMethodType paymentMethodType) {
        this.mLoadingViewSwitcher.setDisplayedChild(0);
        int i = C093010.f86x920ad36e[paymentMethodType.ordinal()];
        if (i == 1) {
            PayPalRequest payPalRequest = this.mDropInRequest.getPayPalRequest();
            if (payPalRequest == null) {
                payPalRequest = new PayPalRequest();
            }
            if (payPalRequest.getAmount() != null) {
                PayPal.requestOneTimePayment(this.mBraintreeFragment, payPalRequest);
            } else {
                PayPal.requestBillingAgreement(this.mBraintreeFragment, payPalRequest);
            }
        } else if (i == 2) {
            GooglePayment.requestPayment(this.mBraintreeFragment, this.mDropInRequest.getGooglePaymentRequest());
        } else if (i == 3) {
            Venmo.authorizeAccount(this.mBraintreeFragment);
        } else if (i == 4) {
            startActivityForResult(new Intent(this, AddCardActivity.class).putExtra(DropInRequest.EXTRA_CHECKOUT_REQUEST, this.mDropInRequest), 1);
        }
    }

    /* renamed from: com.braintreepayments.api.dropin.DropInActivity$10 */
    static /* synthetic */ class C093010 {

        /* renamed from: $SwitchMap$com$braintreepayments$api$dropin$utils$PaymentMethodType */
        static final /* synthetic */ int[] f86x920ad36e = new int[PaymentMethodType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.braintreepayments.api.dropin.utils.PaymentMethodType[] r0 = com.braintreepayments.api.dropin.utils.PaymentMethodType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f86x920ad36e = r0
                int[] r0 = f86x920ad36e     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.braintreepayments.api.dropin.utils.PaymentMethodType r1 = com.braintreepayments.api.dropin.utils.PaymentMethodType.PAYPAL     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f86x920ad36e     // Catch:{ NoSuchFieldError -> 0x001f }
                com.braintreepayments.api.dropin.utils.PaymentMethodType r1 = com.braintreepayments.api.dropin.utils.PaymentMethodType.GOOGLE_PAYMENT     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f86x920ad36e     // Catch:{ NoSuchFieldError -> 0x002a }
                com.braintreepayments.api.dropin.utils.PaymentMethodType r1 = com.braintreepayments.api.dropin.utils.PaymentMethodType.PAY_WITH_VENMO     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f86x920ad36e     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.braintreepayments.api.dropin.utils.PaymentMethodType r1 = com.braintreepayments.api.dropin.utils.PaymentMethodType.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.braintreepayments.api.dropin.DropInActivity.C093010.<clinit>():void");
        }
    }

    private void fetchPaymentMethodNonces(final boolean z) {
        if (this.mClientTokenPresent) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    if (DropInActivity.this.isFinishing()) {
                        return;
                    }
                    if (!DropInActivity.this.mBraintreeFragment.hasFetchedPaymentMethodNonces() || z) {
                        PaymentMethod.getPaymentMethodNonces(DropInActivity.this.mBraintreeFragment, true);
                        return;
                    }
                    DropInActivity dropInActivity = DropInActivity.this;
                    dropInActivity.onPaymentMethodNoncesUpdated(dropInActivity.mBraintreeFragment.getCachedPaymentMethodNonces());
                }
            }, (long) getResources().getInteger(17694720));
        }
    }

    public void onPaymentMethodNoncesUpdated(List<PaymentMethodNonce> list) {
        if (list.size() > 0) {
            this.mSupportedPaymentMethodsHeader.setText(C0944R.string.bt_other);
            this.mVaultedPaymentMethodsContainer.setVisibility(0);
            this.mVaultedPaymentMethodsView.setAdapter(new VaultedPaymentMethodsAdapter(new PaymentMethodNonceCreatedListener() {
                public void onPaymentMethodNonceCreated(PaymentMethodNonce paymentMethodNonce) {
                    if (paymentMethodNonce instanceof CardNonce) {
                        DropInActivity.this.mBraintreeFragment.sendAnalyticsEvent("vaulted-card.select");
                    }
                    DropInActivity.this.onPaymentMethodNonceCreated(paymentMethodNonce);
                }
            }, list));
            if (this.mDropInRequest.isVaultManagerEnabled()) {
                this.mVaultManagerButton.setVisibility(0);
            }
            for (PaymentMethodNonce paymentMethodNonce : list) {
                if (paymentMethodNonce instanceof CardNonce) {
                    this.mBraintreeFragment.sendAnalyticsEvent("vaulted-card.appear");
                    return;
                }
            }
            return;
        }
        this.mSupportedPaymentMethodsHeader.setText(C0944R.string.bt_select_payment_method);
        this.mVaultedPaymentMethodsContainer.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(EXTRA_SHEET_SLIDE_UP_PERFORMED, this.mSheetSlideUpPerformed);
        bundle.putString(EXTRA_DEVICE_DATA, this.mDeviceData);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, final int i2, final Intent intent) {
        ArrayList parcelableArrayListExtra;
        if (i == 79129) {
            this.mBraintreeFragment.onActivityResult(BraintreeRequestCodes.GOOGLE_PAYMENT, i2, intent);
            return;
        }
        this.mLoadingViewSwitcher.setDisplayedChild(0);
        if (i2 == 0) {
            if (i == 1) {
                fetchPaymentMethodNonces(true);
            }
            this.mLoadingViewSwitcher.setDisplayedChild(1);
        } else if (i == 1) {
            if (i2 == -1) {
                DropInResult dropInResult = (DropInResult) intent.getParcelableExtra(DropInResult.EXTRA_DROP_IN_RESULT);
                DropInResult.setLastUsedPaymentMethodType(this, dropInResult.getPaymentMethodNonce());
                dropInResult.deviceData(this.mDeviceData);
                intent = new Intent().putExtra(DropInResult.EXTRA_DROP_IN_RESULT, dropInResult);
            }
            slideDown(new AnimationFinishedListener() {
                public void onAnimationFinished() {
                    DropInActivity.this.setResult(i2, intent);
                    DropInActivity.this.finish();
                }
            });
        } else if (i == 2) {
            if (i2 == -1) {
                if (!(intent == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra(EXTRA_PAYMENT_METHOD_NONCES)) == null)) {
                    onPaymentMethodNoncesUpdated(parcelableArrayListExtra);
                }
                fetchPaymentMethodNonces(true);
            }
            this.mLoadingViewSwitcher.setDisplayedChild(1);
        }
    }

    public void onBackgroundClicked(View view) {
        onBackPressed();
    }

    public void onBackPressed() {
        if (!this.mSheetSlideDownPerformed) {
            this.mSheetSlideDownPerformed = true;
            this.mBraintreeFragment.sendAnalyticsEvent("sdk.exit.canceled");
            slideDown(new AnimationFinishedListener() {
                public void onAnimationFinished() {
                    DropInActivity.this.finish();
                }
            });
        }
    }

    private void slideUp() {
        if (!this.mSheetSlideUpPerformed) {
            this.mBraintreeFragment.sendAnalyticsEvent("appeared");
            this.mSheetSlideUpPerformed = true;
            this.mBottomSheet.startAnimation(AnimationUtils.loadAnimation(this, C0944R.anim.bt_slide_in_up));
        }
    }

    private void slideDown(final AnimationFinishedListener animationFinishedListener) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, C0944R.anim.bt_slide_out_down);
        loadAnimation.setFillAfter(true);
        if (animationFinishedListener != null) {
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    animationFinishedListener.onAnimationFinished();
                }
            });
        }
        this.mBottomSheet.startAnimation(loadAnimation);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(17432576, 17432577);
    }

    public void onVaultEditButtonClick(View view) {
        startActivityForResult(new Intent(this, VaultManagerActivity.class).putExtra(DropInRequest.EXTRA_CHECKOUT_REQUEST, this.mDropInRequest).putParcelableArrayListExtra(EXTRA_PAYMENT_METHOD_NONCES, new ArrayList(this.mBraintreeFragment.getCachedPaymentMethodNonces())), 2);
        this.mBraintreeFragment.sendAnalyticsEvent("manager.appeared");
    }
}
