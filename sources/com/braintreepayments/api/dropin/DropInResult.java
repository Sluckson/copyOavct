package com.braintreepayments.api.dropin;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.braintreepayments.api.BraintreeFragment;
import com.braintreepayments.api.GooglePayment;
import com.braintreepayments.api.PaymentMethod;
import com.braintreepayments.api.dropin.utils.PaymentMethodType;
import com.braintreepayments.api.exceptions.InvalidArgumentException;
import com.braintreepayments.api.interfaces.BraintreeErrorListener;
import com.braintreepayments.api.interfaces.BraintreeListener;
import com.braintreepayments.api.interfaces.BraintreeResponseListener;
import com.braintreepayments.api.interfaces.PaymentMethodNoncesUpdatedListener;
import com.braintreepayments.api.internal.BraintreeSharedPreferences;
import com.braintreepayments.api.models.Authorization;
import com.braintreepayments.api.models.ClientToken;
import com.braintreepayments.api.models.PaymentMethodNonce;
import java.util.ArrayList;
import java.util.List;

public class DropInResult implements Parcelable {
    public static final Parcelable.Creator<DropInResult> CREATOR = new Parcelable.Creator<DropInResult>() {
        public DropInResult createFromParcel(Parcel parcel) {
            return new DropInResult(parcel);
        }

        public DropInResult[] newArray(int i) {
            return new DropInResult[i];
        }
    };
    public static final String EXTRA_DROP_IN_RESULT = "com.braintreepayments.api.dropin.EXTRA_DROP_IN_RESULT";
    static final String LAST_USED_PAYMENT_METHOD_TYPE = "com.braintreepayments.api.dropin.LAST_USED_PAYMENT_METHOD_TYPE";
    private String mDeviceData;
    private PaymentMethodNonce mPaymentMethodNonce;
    /* access modifiers changed from: private */
    public PaymentMethodType mPaymentMethodType;

    public interface DropInResultListener {
        void onError(Exception exc);

        void onResult(DropInResult dropInResult);
    }

    public int describeContents() {
        return 0;
    }

    public DropInResult() {
    }

    /* access modifiers changed from: package-private */
    public DropInResult paymentMethodNonce(@Nullable PaymentMethodNonce paymentMethodNonce) {
        if (paymentMethodNonce != null) {
            this.mPaymentMethodType = PaymentMethodType.forType(paymentMethodNonce.getTypeLabel());
        }
        this.mPaymentMethodNonce = paymentMethodNonce;
        return this;
    }

    /* access modifiers changed from: package-private */
    public DropInResult deviceData(@Nullable String str) {
        this.mDeviceData = str;
        return this;
    }

    @Nullable
    public PaymentMethodType getPaymentMethodType() {
        return this.mPaymentMethodType;
    }

    @Nullable
    public PaymentMethodNonce getPaymentMethodNonce() {
        return this.mPaymentMethodNonce;
    }

    @Nullable
    public String getDeviceData() {
        return this.mDeviceData;
    }

    public static void fetchDropInResult(AppCompatActivity appCompatActivity, String str, @NonNull final DropInResultListener dropInResultListener) {
        try {
            if (!(Authorization.fromString(str) instanceof ClientToken)) {
                dropInResultListener.onError(new InvalidArgumentException("DropInResult#fetchDropInResult must be called with a client token"));
                return;
            }
            try {
                final BraintreeFragment newInstance = BraintreeFragment.newInstance(appCompatActivity, str);
                final List<BraintreeListener> listeners = newInstance.getListeners();
                final ListenerHolder listenerHolder = new ListenerHolder();
                C09401 r1 = new BraintreeErrorListener() {
                    public void onError(Exception exc) {
                        DropInResult.resetListeners(newInstance, listenerHolder, listeners);
                        dropInResultListener.onError(exc);
                    }
                };
                listenerHolder.listeners.add(r1);
                C09412 r4 = new PaymentMethodNoncesUpdatedListener() {
                    public void onPaymentMethodNoncesUpdated(List<PaymentMethodNonce> list) {
                        DropInResult.resetListeners(newInstance, listenerHolder, listeners);
                        if (list.size() > 0) {
                            dropInResultListener.onResult(new DropInResult().paymentMethodNonce(list.get(0)));
                            return;
                        }
                        dropInResultListener.onResult(new DropInResult());
                    }
                };
                listenerHolder.listeners.add(r4);
                newInstance.addListener(r1);
                newInstance.addListener(r4);
                final PaymentMethodType forType = PaymentMethodType.forType(BraintreeSharedPreferences.getSharedPreferences(appCompatActivity).getString(LAST_USED_PAYMENT_METHOD_TYPE, (String) null));
                if (forType == PaymentMethodType.GOOGLE_PAYMENT) {
                    final BraintreeFragment braintreeFragment = newInstance;
                    final DropInResultListener dropInResultListener2 = dropInResultListener;
                    GooglePayment.isReadyToPay(newInstance, new BraintreeResponseListener<Boolean>() {
                        public void onResponse(Boolean bool) {
                            if (bool.booleanValue()) {
                                DropInResult.resetListeners(braintreeFragment, listenerHolder, listeners);
                                DropInResult dropInResult = new DropInResult();
                                PaymentMethodType unused = dropInResult.mPaymentMethodType = forType;
                                dropInResultListener2.onResult(dropInResult);
                                return;
                            }
                            PaymentMethod.getPaymentMethodNonces(braintreeFragment);
                        }
                    });
                    return;
                }
                PaymentMethod.getPaymentMethodNonces(newInstance);
            } catch (InvalidArgumentException e) {
                dropInResultListener.onError(e);
            }
        } catch (InvalidArgumentException e2) {
            dropInResultListener.onError(e2);
        }
    }

    static void setLastUsedPaymentMethodType(Context context, PaymentMethodNonce paymentMethodNonce) {
        BraintreeSharedPreferences.getSharedPreferences(context).edit().putString(LAST_USED_PAYMENT_METHOD_TYPE, PaymentMethodType.forType(paymentMethodNonce).getCanonicalName()).apply();
    }

    /* access modifiers changed from: private */
    public static void resetListeners(BraintreeFragment braintreeFragment, ListenerHolder listenerHolder, List<BraintreeListener> list) {
        for (BraintreeListener removeListener : listenerHolder.listeners) {
            braintreeFragment.removeListener(removeListener);
        }
        for (BraintreeListener addListener : list) {
            braintreeFragment.addListener(addListener);
        }
    }

    private static class ListenerHolder {
        public List<BraintreeListener> listeners;

        private ListenerHolder() {
            this.listeners = new ArrayList();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        PaymentMethodType paymentMethodType = this.mPaymentMethodType;
        parcel.writeInt(paymentMethodType == null ? -1 : paymentMethodType.ordinal());
        parcel.writeParcelable(this.mPaymentMethodNonce, i);
        parcel.writeString(this.mDeviceData);
    }

    protected DropInResult(Parcel parcel) {
        PaymentMethodType paymentMethodType;
        int readInt = parcel.readInt();
        if (readInt == -1) {
            paymentMethodType = null;
        } else {
            paymentMethodType = PaymentMethodType.values()[readInt];
        }
        this.mPaymentMethodType = paymentMethodType;
        this.mPaymentMethodNonce = (PaymentMethodNonce) parcel.readParcelable(PaymentMethodNonce.class.getClassLoader());
        this.mDeviceData = parcel.readString();
    }
}
