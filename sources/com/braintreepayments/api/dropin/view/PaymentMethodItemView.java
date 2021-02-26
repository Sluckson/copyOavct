package com.braintreepayments.api.dropin.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.braintreepayments.api.dropin.C0944R;
import com.braintreepayments.api.dropin.utils.PaymentMethodType;
import com.braintreepayments.api.models.CardNonce;
import com.braintreepayments.api.models.PaymentMethodNonce;

public class PaymentMethodItemView extends LinearLayout {
    private View mDeleteIcon;
    private TextView mDescription;
    private View mDivider;
    private ImageView mIcon;
    private PaymentMethodNonce mPaymentMethodNonce;
    private TextView mTitle;

    public PaymentMethodItemView(Context context) {
        super(context);
        init();
    }

    public PaymentMethodItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PaymentMethodItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    @TargetApi(21)
    public PaymentMethodItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            setOrientation(1);
            LayoutInflater.from(getContext()).inflate(C0944R.C0949layout.bt_vault_manager_list_item, this);
            this.mIcon = (ImageView) findViewById(C0944R.C0947id.bt_payment_method_icon);
            this.mTitle = (TextView) findViewById(C0944R.C0947id.bt_payment_method_title);
            this.mDescription = (TextView) findViewById(C0944R.C0947id.bt_payment_method_description);
            this.mDeleteIcon = findViewById(C0944R.C0947id.bt_payment_method_delete_icon);
            this.mDivider = findViewById(C0944R.C0947id.bt_payment_method_divider);
        }
    }

    public void setPaymentMethod(PaymentMethodNonce paymentMethodNonce, boolean z) {
        this.mPaymentMethodNonce = paymentMethodNonce;
        PaymentMethodType forType = PaymentMethodType.forType(paymentMethodNonce);
        if (z) {
            this.mIcon.setImageResource(forType.getDrawable());
            this.mDeleteIcon.setVisibility(0);
            this.mDivider.setVisibility(0);
        } else {
            this.mIcon.setImageResource(forType.getVaultedDrawable());
            this.mDeleteIcon.setVisibility(8);
            this.mDivider.setVisibility(8);
        }
        this.mTitle.setText(forType.getLocalizedName());
        if (paymentMethodNonce instanceof CardNonce) {
            TextView textView = this.mDescription;
            textView.setText("••• ••" + ((CardNonce) paymentMethodNonce).getLastTwo());
            return;
        }
        this.mDescription.setText(paymentMethodNonce.getDescription());
    }

    public void setOnDeleteIconClick(View.OnClickListener onClickListener) {
        this.mDeleteIcon.setOnClickListener(onClickListener);
    }

    public PaymentMethodNonce getPaymentMethodNonce() {
        return this.mPaymentMethodNonce;
    }
}
