package com.braintreepayments.api.dropin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ViewSwitcher;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.braintreepayments.api.PaymentMethod;
import com.braintreepayments.api.dropin.adapters.VaultManagerPaymentMethodsAdapter;
import com.braintreepayments.api.dropin.view.PaymentMethodItemView;
import com.braintreepayments.api.exceptions.InvalidArgumentException;
import com.braintreepayments.api.exceptions.PaymentMethodDeleteException;
import com.braintreepayments.api.interfaces.BraintreeErrorListener;
import com.braintreepayments.api.interfaces.PaymentMethodNonceDeletedListener;
import com.braintreepayments.api.models.PaymentMethodNonce;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class VaultManagerActivity extends BaseActivity implements PaymentMethodNonceDeletedListener, BraintreeErrorListener, View.OnClickListener {
    @VisibleForTesting
    protected VaultManagerPaymentMethodsAdapter mAdapter = new VaultManagerPaymentMethodsAdapter(this);
    /* access modifiers changed from: private */
    public ViewSwitcher mLoadingViewSwitcher;

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        ArrayList arrayList;
        super.onCreate(bundle);
        setContentView(C0944R.C0949layout.bt_vault_management_activity);
        this.mLoadingViewSwitcher = (ViewSwitcher) findViewById(C0944R.C0947id.bt_loading_view_switcher);
        RecyclerView recyclerView = (RecyclerView) findViewById(C0944R.C0947id.bt_vault_manager_list);
        findViewById(C0944R.C0947id.bt_vault_manager_close).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VaultManagerActivity.this.finish();
            }
        });
        try {
            this.mBraintreeFragment = getBraintreeFragment();
        } catch (InvalidArgumentException e) {
            finish(e);
        }
        if (bundle == null) {
            arrayList = getIntent().getParcelableArrayListExtra("com.braintreepayments.api.EXTRA_PAYMENT_METHOD_NONCES");
        } else {
            arrayList = bundle.getParcelableArrayList("com.braintreepayments.api.EXTRA_PAYMENT_METHOD_NONCES");
        }
        this.mAdapter.setPaymentMethodNonces(arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        recyclerView.setAdapter(this.mAdapter);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.setStatusBarColor(0);
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("com.braintreepayments.api.EXTRA_PAYMENT_METHOD_NONCES", this.mAdapter.getPaymentMethodNonces());
    }

    public void onPaymentMethodNonceDeleted(PaymentMethodNonce paymentMethodNonce) {
        this.mAdapter.paymentMethodDeleted(paymentMethodNonce);
        this.mBraintreeFragment.sendAnalyticsEvent("manager.delete.succeeded");
        setResult(-1, new Intent().putExtra("com.braintreepayments.api.EXTRA_PAYMENT_METHOD_NONCES", this.mAdapter.getPaymentMethodNonces()));
        this.mLoadingViewSwitcher.setDisplayedChild(0);
    }

    public void onError(Exception exc) {
        if (exc instanceof PaymentMethodDeleteException) {
            Snackbar.make(findViewById(C0944R.C0947id.bt_base_view), C0944R.string.bt_vault_manager_delete_failure, 0).show();
            this.mBraintreeFragment.sendAnalyticsEvent("manager.delete.failed");
            this.mLoadingViewSwitcher.setDisplayedChild(0);
            return;
        }
        this.mBraintreeFragment.sendAnalyticsEvent("manager.unknown.failed");
        finish(exc);
    }

    public void onClick(View view) {
        if (view instanceof PaymentMethodItemView) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final PaymentMethodNonce paymentMethodNonce = ((PaymentMethodItemView) view).getPaymentMethodNonce();
            PaymentMethodItemView paymentMethodItemView = new PaymentMethodItemView(this);
            paymentMethodItemView.setPaymentMethod(paymentMethodNonce, false);
            new AlertDialog.Builder(this, C0944R.C0951style.Theme_AppCompat_Light_Dialog_Alert).setTitle(C0944R.string.bt_delete_confirmation_title).setMessage(C0944R.string.bt_delete_confirmation_description).setView((View) paymentMethodItemView).setPositiveButton(C0944R.string.bt_delete, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    atomicBoolean.set(true);
                    VaultManagerActivity.this.mBraintreeFragment.sendAnalyticsEvent("manager.delete.confirmation.positive");
                    PaymentMethod.deletePaymentMethod(VaultManagerActivity.this.mBraintreeFragment, paymentMethodNonce);
                    VaultManagerActivity.this.mLoadingViewSwitcher.setDisplayedChild(1);
                }
            }).setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!atomicBoolean.get()) {
                        VaultManagerActivity.this.mBraintreeFragment.sendAnalyticsEvent("manager.delete.confirmation.negative");
                    }
                }
            }).setNegativeButton(C0944R.string.bt_cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).create().show();
        }
    }

    public void onBackPressed() {
        if (this.mLoadingViewSwitcher.getDisplayedChild() == 0) {
            super.onBackPressed();
        }
    }
}
