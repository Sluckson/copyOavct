package com.braintreepayments.api.dropin.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.braintreepayments.api.dropin.C0944R;
import com.braintreepayments.api.dropin.utils.PaymentMethodType;
import com.braintreepayments.api.interfaces.PaymentMethodNonceCreatedListener;
import com.braintreepayments.api.models.CardNonce;
import com.braintreepayments.api.models.PaymentMethodNonce;
import java.util.List;

public class VaultedPaymentMethodsAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<PaymentMethodNonce> mPaymentMethodNonces;
    /* access modifiers changed from: private */
    public PaymentMethodNonceCreatedListener mSelectedListener;

    public VaultedPaymentMethodsAdapter(PaymentMethodNonceCreatedListener paymentMethodNonceCreatedListener, List<PaymentMethodNonce> list) {
        this.mSelectedListener = paymentMethodNonceCreatedListener;
        this.mPaymentMethodNonces = list;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C0944R.C0949layout.bt_vaulted_payment_method_card, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final PaymentMethodNonce paymentMethodNonce = this.mPaymentMethodNonces.get(i);
        PaymentMethodType forType = PaymentMethodType.forType(paymentMethodNonce);
        viewHolder.icon.setImageResource(forType.getVaultedDrawable());
        viewHolder.title.setText(forType.getLocalizedName());
        if (paymentMethodNonce instanceof CardNonce) {
            TextView textView = viewHolder.description;
            textView.setText("••• ••" + ((CardNonce) paymentMethodNonce).getLastTwo());
        } else {
            viewHolder.description.setText(paymentMethodNonce.getDescription());
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VaultedPaymentMethodsAdapter.this.mSelectedListener.onPaymentMethodNonceCreated(paymentMethodNonce);
            }
        });
    }

    public int getItemCount() {
        return this.mPaymentMethodNonces.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView description;
        public ImageView icon;
        public TextView title;

        ViewHolder(View view) {
            super(view);
            this.icon = (ImageView) view.findViewById(C0944R.C0947id.bt_payment_method_icon);
            this.title = (TextView) view.findViewById(C0944R.C0947id.bt_payment_method_title);
            this.description = (TextView) view.findViewById(C0944R.C0947id.bt_payment_method_description);
        }
    }
}
