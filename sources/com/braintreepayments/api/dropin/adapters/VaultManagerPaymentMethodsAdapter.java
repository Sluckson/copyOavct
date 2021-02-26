package com.braintreepayments.api.dropin.adapters;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.braintreepayments.api.dropin.view.PaymentMethodItemView;
import com.braintreepayments.api.models.PaymentMethodNonce;
import java.util.ArrayList;
import java.util.List;

public class VaultManagerPaymentMethodsAdapter extends RecyclerView.Adapter<ViewHolder> {
    /* access modifiers changed from: private */
    public View.OnClickListener mClickListener;
    private final List<PaymentMethodNonce> mPaymentMethodNonces = new ArrayList();

    public VaultManagerPaymentMethodsAdapter(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(new PaymentMethodItemView(viewGroup.getContext()));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final PaymentMethodItemView paymentMethodItemView = (PaymentMethodItemView) viewHolder.itemView;
        paymentMethodItemView.setPaymentMethod(this.mPaymentMethodNonces.get(i), true);
        paymentMethodItemView.setOnDeleteIconClick(new View.OnClickListener() {
            public void onClick(View view) {
                if (VaultManagerPaymentMethodsAdapter.this.mClickListener != null) {
                    VaultManagerPaymentMethodsAdapter.this.mClickListener.onClick(paymentMethodItemView);
                }
            }
        });
    }

    public PaymentMethodNonce getPaymentMethodNonce(int i) {
        return this.mPaymentMethodNonces.get(i);
    }

    public void paymentMethodDeleted(PaymentMethodNonce paymentMethodNonce) {
        int indexOf = this.mPaymentMethodNonces.indexOf(paymentMethodNonce);
        this.mPaymentMethodNonces.remove(indexOf);
        notifyItemRemoved(indexOf);
    }

    public int getItemCount() {
        return this.mPaymentMethodNonces.size();
    }

    public void setPaymentMethodNonces(List<PaymentMethodNonce> list) {
        this.mPaymentMethodNonces.clear();
        this.mPaymentMethodNonces.addAll(list);
    }

    public ArrayList<PaymentMethodNonce> getPaymentMethodNonces() {
        return new ArrayList<>(this.mPaymentMethodNonces);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ViewHolder(View view) {
            super(view);
        }
    }
}
