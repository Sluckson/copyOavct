package com.braintreepayments.api.dropin.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.braintreepayments.api.dropin.C0944R;
import com.braintreepayments.api.dropin.DropInRequest;
import com.braintreepayments.api.dropin.utils.PaymentMethodType;
import com.braintreepayments.api.models.Configuration;
import java.util.ArrayList;
import java.util.HashSet;

public class SupportedPaymentMethodsAdapter extends BaseAdapter {
    private ArrayList<PaymentMethodType> mAvailablePaymentMethods = new ArrayList<>();
    private Context mContext;
    /* access modifiers changed from: private */
    public PaymentMethodSelectedListener mPaymentMethodSelectedListener;

    public interface PaymentMethodSelectedListener {
        void onPaymentMethodSelected(PaymentMethodType paymentMethodType);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public SupportedPaymentMethodsAdapter(Context context, PaymentMethodSelectedListener paymentMethodSelectedListener) {
        this.mContext = context;
        this.mPaymentMethodSelectedListener = paymentMethodSelectedListener;
    }

    public void setup(Configuration configuration, DropInRequest dropInRequest, boolean z, boolean z2) {
        if (dropInRequest.isPayPalEnabled() && configuration.isPayPalEnabled()) {
            this.mAvailablePaymentMethods.add(PaymentMethodType.PAYPAL);
        }
        if (dropInRequest.isVenmoEnabled() && configuration.getPayWithVenmo().isEnabled(this.mContext)) {
            this.mAvailablePaymentMethods.add(PaymentMethodType.PAY_WITH_VENMO);
        }
        if (dropInRequest.isCardEnabled()) {
            HashSet hashSet = new HashSet(configuration.getCardConfiguration().getSupportedCardTypes());
            if (!z2) {
                hashSet.remove(PaymentMethodType.UNIONPAY.getCanonicalName());
            }
            if (hashSet.size() > 0) {
                this.mAvailablePaymentMethods.add(PaymentMethodType.UNKNOWN);
            }
        }
        if (z && dropInRequest.isGooglePaymentEnabled()) {
            this.mAvailablePaymentMethods.add(PaymentMethodType.GOOGLE_PAYMENT);
        }
    }

    public int getCount() {
        return this.mAvailablePaymentMethods.size();
    }

    public Object getItem(int i) {
        return this.mAvailablePaymentMethods.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(C0944R.C0949layout.bt_payment_method_list_item, viewGroup, false);
        }
        final PaymentMethodType paymentMethodType = this.mAvailablePaymentMethods.get(i);
        ((ImageView) view.findViewById(C0944R.C0947id.bt_payment_method_icon)).setImageResource(paymentMethodType.getDrawable());
        ((TextView) view.findViewById(C0944R.C0947id.bt_payment_method_type)).setText(this.mContext.getString(paymentMethodType.getLocalizedName()));
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SupportedPaymentMethodsAdapter.this.mPaymentMethodSelectedListener.onPaymentMethodSelected(paymentMethodType);
            }
        });
        return view;
    }
}
