package com.braintreepayments.api;

import android.content.Intent;
import android.net.Uri;
import com.braintreepayments.api.exceptions.BraintreeException;
import com.braintreepayments.api.exceptions.ErrorWithResponse;
import com.braintreepayments.api.exceptions.InvalidArgumentException;
import com.braintreepayments.api.interfaces.ConfigurationListener;
import com.braintreepayments.api.interfaces.HttpResponseCallback;
import com.braintreepayments.api.interfaces.PaymentMethodNonceCallback;
import com.braintreepayments.api.internal.BraintreeHttpClient;
import com.braintreepayments.api.internal.ManifestValidator;
import com.braintreepayments.api.models.BraintreeRequestCodes;
import com.braintreepayments.api.models.CardBuilder;
import com.braintreepayments.api.models.Configuration;
import com.braintreepayments.api.models.PaymentMethodNonce;
import com.braintreepayments.api.models.ThreeDSecureAuthenticationResponse;
import com.braintreepayments.api.models.ThreeDSecureLookup;
import com.braintreepayments.api.models.ThreeDSecureRequest;
import org.json.JSONException;
import p052cz.msebera.android.httpclient.HttpStatus;

public class ThreeDSecure {
    private static final String THREE_D_SECURE_ASSETS_PATH = "/mobile/three-d-secure-redirect/0.1.5";

    public static void performVerification(final BraintreeFragment braintreeFragment, CardBuilder cardBuilder, final String str) {
        TokenizationClient.tokenize(braintreeFragment, cardBuilder, new PaymentMethodNonceCallback() {
            public void success(PaymentMethodNonce paymentMethodNonce) {
                ThreeDSecure.performVerification(braintreeFragment, paymentMethodNonce.getNonce(), str);
            }

            public void failure(Exception exc) {
                braintreeFragment.postCallback(exc);
            }
        });
    }

    public static void performVerification(BraintreeFragment braintreeFragment, String str, String str2) {
        performVerification(braintreeFragment, new ThreeDSecureRequest().nonce(str).amount(str2));
    }

    public static void performVerification(final BraintreeFragment braintreeFragment, final ThreeDSecureRequest threeDSecureRequest) {
        if (threeDSecureRequest.getAmount() == null || threeDSecureRequest.getNonce() == null) {
            braintreeFragment.postCallback((Exception) new InvalidArgumentException("The ThreeDSecureRequest nonce and amount cannot be null"));
        } else {
            braintreeFragment.waitForConfiguration(new ConfigurationListener() {
                public void onConfigurationFetched(Configuration configuration) {
                    if (!configuration.isThreeDSecureEnabled()) {
                        braintreeFragment.postCallback((Exception) new BraintreeException("Three D Secure is not enabled in the control panel"));
                    } else if (!ManifestValidator.isUrlSchemeDeclaredInAndroidManifest(braintreeFragment.getApplicationContext(), braintreeFragment.getReturnUrlScheme(), BraintreeBrowserSwitchActivity.class)) {
                        braintreeFragment.sendAnalyticsEvent("three-d-secure.invalid-manifest");
                        braintreeFragment.postCallback((Exception) new BraintreeException("BraintreeBrowserSwitchActivity missing, incorrectly configured in AndroidManifest.xml or another app defines the same browser switch url as this app. See https://developers.braintreepayments.com/guides/client-sdk/android/v2#browser-switch for the correct configuration"));
                    } else {
                        BraintreeHttpClient httpClient = braintreeFragment.getHttpClient();
                        httpClient.post(TokenizationClient.versionedPath("payment_methods/" + threeDSecureRequest.getNonce() + "/three_d_secure/lookup"), threeDSecureRequest.build(), new HttpResponseCallback() {
                            public void success(String str) {
                                try {
                                    ThreeDSecureLookup fromJson = ThreeDSecureLookup.fromJson(str);
                                    if (fromJson.getAcsUrl() != null) {
                                        ThreeDSecure.launchBrowserSwitch(braintreeFragment, fromJson);
                                    } else {
                                        braintreeFragment.postCallback((PaymentMethodNonce) fromJson.getCardNonce());
                                    }
                                } catch (JSONException e) {
                                    braintreeFragment.postCallback((Exception) e);
                                }
                            }

                            public void failure(Exception exc) {
                                braintreeFragment.postCallback(exc);
                            }
                        });
                    }
                }
            });
        }
    }

    protected static void onActivityResult(BraintreeFragment braintreeFragment, int i, Intent intent) {
        if (i == -1) {
            ThreeDSecureAuthenticationResponse fromJson = ThreeDSecureAuthenticationResponse.fromJson(intent.getData().getQueryParameter("auth_response"));
            if (fromJson.isSuccess()) {
                braintreeFragment.postCallback((PaymentMethodNonce) fromJson.getCardNonce());
            } else if (fromJson.getException() != null) {
                braintreeFragment.postCallback((Exception) new BraintreeException(fromJson.getException()));
            } else {
                braintreeFragment.postCallback((Exception) new ErrorWithResponse(HttpStatus.SC_UNPROCESSABLE_ENTITY, fromJson.getErrors()));
            }
        }
    }

    /* access modifiers changed from: private */
    public static void launchBrowserSwitch(BraintreeFragment braintreeFragment, ThreeDSecureLookup threeDSecureLookup) {
        String str = braintreeFragment.getConfiguration().getAssetsUrl() + THREE_D_SECURE_ASSETS_PATH;
        braintreeFragment.browserSwitch((int) BraintreeRequestCodes.THREE_D_SECURE, Uri.parse(str + "/index.html").buildUpon().appendQueryParameter("AcsUrl", threeDSecureLookup.getAcsUrl()).appendQueryParameter("PaReq", threeDSecureLookup.getPareq()).appendQueryParameter("MD", threeDSecureLookup.getMd()).appendQueryParameter("TermUrl", threeDSecureLookup.getTermUrl()).appendQueryParameter("ReturnUrl", String.format("%s/redirect.html?redirect_url=%s://x-callback-url/braintree/threedsecure?", new Object[]{str, braintreeFragment.getReturnUrlScheme()})).build().toString());
    }
}
