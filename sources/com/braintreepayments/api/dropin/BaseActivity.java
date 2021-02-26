package com.braintreepayments.api.dropin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.braintreepayments.api.BraintreeFragment;
import com.braintreepayments.api.exceptions.InvalidArgumentException;
import com.braintreepayments.api.models.Authorization;
import com.braintreepayments.api.models.ClientToken;
import com.braintreepayments.api.models.Configuration;
import com.braintreepayments.api.models.PaymentMethodNonce;
import org.json.JSONException;

public class BaseActivity extends AppCompatActivity {
    static final String EXTRA_CONFIGURATION_DATA = "com.braintreepayments.api.EXTRA_CONFIGURATION_DATA";
    protected BraintreeFragment mBraintreeFragment;
    protected boolean mClientTokenPresent;
    protected Configuration mConfiguration;
    protected DropInRequest mDropInRequest;

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            try {
                this.mConfiguration = Configuration.fromJson(bundle.getString(EXTRA_CONFIGURATION_DATA));
            } catch (JSONException unused) {
            }
        }
        this.mDropInRequest = (DropInRequest) getIntent().getParcelableExtra(DropInRequest.EXTRA_CHECKOUT_REQUEST);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Configuration configuration = this.mConfiguration;
        if (configuration != null) {
            bundle.putString(EXTRA_CONFIGURATION_DATA, configuration.toJson());
        }
    }

    /* access modifiers changed from: protected */
    public BraintreeFragment getBraintreeFragment() throws InvalidArgumentException {
        if (!TextUtils.isEmpty(this.mDropInRequest.getAuthorization())) {
            try {
                this.mClientTokenPresent = Authorization.fromString(this.mDropInRequest.getAuthorization()) instanceof ClientToken;
            } catch (InvalidArgumentException unused) {
                this.mClientTokenPresent = false;
            }
            return BraintreeFragment.newInstance(this, this.mDropInRequest.getAuthorization());
        }
        throw new InvalidArgumentException("A client token or tokenization key must be specified in the " + DropInRequest.class.getSimpleName());
    }

    /* access modifiers changed from: protected */
    public boolean shouldRequestThreeDSecureVerification() {
        return this.mDropInRequest.shouldRequestThreeDSecureVerification() && !TextUtils.isEmpty(this.mDropInRequest.getAmount()) && this.mConfiguration.isThreeDSecureEnabled();
    }

    /* access modifiers changed from: protected */
    public void finish(PaymentMethodNonce paymentMethodNonce, String str) {
        setResult(-1, new Intent().putExtra(DropInResult.EXTRA_DROP_IN_RESULT, new DropInResult().paymentMethodNonce(paymentMethodNonce).deviceData(str)));
        finish();
    }

    /* access modifiers changed from: protected */
    public void finish(Exception exc) {
        setResult(1, new Intent().putExtra(DropInActivity.EXTRA_ERROR, exc));
        finish();
    }
}
