package com.iaai.android.bdt.feature.myAccount.toBePaid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavArgument;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.Navigation;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.feature.auctionSalesList.OnNextPageLoad;
import com.iaai.android.bdt.model.toBePaid.PayPalPaymentRequest;
import com.iaai.android.bdt.utils.Constants_MVVM;
import dagger.android.AndroidInjection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020&H\u0002J\"\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00142\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\b\u0010-\u001a\u00020&H\u0016J\u0012\u0010.\u001a\u00020&2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020&2\u0006\u00106\u001a\u000200H\u0014J\u000e\u00107\u001a\u00020&2\u0006\u0010\t\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!¨\u00068"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/BDTPaymentActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "()V", "ivStockShare", "Landroid/widget/ImageView;", "getIvStockShare", "()Landroid/widget/ImageView;", "setIvStockShare", "(Landroid/widget/ImageView;)V", "onNextPageLoad", "Lcom/iaai/android/bdt/feature/auctionSalesList/OnNextPageLoad;", "onlyMyItem", "", "palPaymentRequest", "Lcom/iaai/android/bdt/model/toBePaid/PayPalPaymentRequest;", "getPalPaymentRequest", "()Lcom/iaai/android/bdt/model/toBePaid/PayPalPaymentRequest;", "setPalPaymentRequest", "(Lcom/iaai/android/bdt/model/toBePaid/PayPalPaymentRequest;)V", "payPalAccountDetailID", "", "paymentMethod", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "toolbar_sub_title", "Landroid/widget/TextView;", "getToolbar_sub_title", "()Landroid/widget/TextView;", "setToolbar_sub_title", "(Landroid/widget/TextView;)V", "toolbar_title", "getToolbar_title", "setToolbar_title", "initializeToolBar", "", "initializeUI", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onSaveInstanceState", "outState", "setOnNextPageLoad", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BDTPaymentActivity.kt */
public final class BDTPaymentActivity extends BaseActivity {
    private HashMap _$_findViewCache;
    @NotNull
    public ImageView ivStockShare;
    private OnNextPageLoad onNextPageLoad;
    private String onlyMyItem = "0";
    @NotNull
    public PayPalPaymentRequest palPaymentRequest;
    private int payPalAccountDetailID;
    private String paymentMethod = "";
    @NotNull
    public Toolbar toolbar;
    @NotNull
    public TextView toolbar_sub_title;
    @NotNull
    public TextView toolbar_title;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @NotNull
    public final Toolbar getToolbar() {
        Toolbar toolbar2 = this.toolbar;
        if (toolbar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        return toolbar2;
    }

    public final void setToolbar(@NotNull Toolbar toolbar2) {
        Intrinsics.checkParameterIsNotNull(toolbar2, "<set-?>");
        this.toolbar = toolbar2;
    }

    @NotNull
    public final TextView getToolbar_title() {
        TextView textView = this.toolbar_title;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Constants_MVVM.EXTRA_TOOLBAR_TITLE);
        }
        return textView;
    }

    public final void setToolbar_title(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.toolbar_title = textView;
    }

    @NotNull
    public final TextView getToolbar_sub_title() {
        TextView textView = this.toolbar_sub_title;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar_sub_title");
        }
        return textView;
    }

    public final void setToolbar_sub_title(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.toolbar_sub_title = textView;
    }

    @NotNull
    public final ImageView getIvStockShare() {
        ImageView imageView = this.ivStockShare;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivStockShare");
        }
        return imageView;
    }

    public final void setIvStockShare(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.ivStockShare = imageView;
    }

    @NotNull
    public final PayPalPaymentRequest getPalPaymentRequest() {
        PayPalPaymentRequest payPalPaymentRequest = this.palPaymentRequest;
        if (payPalPaymentRequest == null) {
            Intrinsics.throwUninitializedPropertyAccessException("palPaymentRequest");
        }
        return payPalPaymentRequest;
    }

    public final void setPalPaymentRequest(@NotNull PayPalPaymentRequest payPalPaymentRequest) {
        Intrinsics.checkParameterIsNotNull(payPalPaymentRequest, "<set-?>");
        this.palPaymentRequest = payPalPaymentRequest;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        AndroidInjection.inject((Activity) this);
        setContentView((int) C2723R.C2728layout.activity_auctionsales_list_fragment_container);
        String stringExtra = getIntent().getStringExtra(Constants_MVVM.EXTRA_PAYMENT_METHOD);
        Intrinsics.checkExpressionValueIsNotNull(stringExtra, "intent.getStringExtra(Co…VVM.EXTRA_PAYMENT_METHOD)");
        this.paymentMethod = stringExtra;
        String stringExtra2 = getIntent().getStringExtra(Constants_MVVM.EXTRA_TOBPAID_MY_VEHICLES_ONLY);
        Intrinsics.checkExpressionValueIsNotNull(stringExtra2, "intent.getStringExtra(Co…TOBPAID_MY_VEHICLES_ONLY)");
        this.onlyMyItem = stringExtra2;
        Parcelable parcelableExtra = getIntent().getParcelableExtra(Constants_MVVM.EXTRA_PAYMENT_PAYPAL_REQUEST);
        Intrinsics.checkExpressionValueIsNotNull(parcelableExtra, "intent.getParcelableExtr…A_PAYMENT_PAYPAL_REQUEST)");
        this.palPaymentRequest = (PayPalPaymentRequest) parcelableExtra;
        this.payPalAccountDetailID = getIntent().getIntExtra(Constants_MVVM.EXTRA_PAYMENT_PAYPAL_ACCOUNT_DETAIL_ID, 0);
        View findViewById = findViewById(C2723R.C2726id.toolbar);
        if (findViewById != null) {
            this.toolbar = (Toolbar) findViewById;
            View findViewById2 = findViewById(C2723R.C2726id.toolbar_title);
            if (findViewById2 != null) {
                this.toolbar_title = (TextView) findViewById2;
                View findViewById3 = findViewById(C2723R.C2726id.toolbar_sub_title);
                if (findViewById3 != null) {
                    this.toolbar_sub_title = (TextView) findViewById3;
                    View findViewById4 = findViewById(C2723R.C2726id.ivShareAS);
                    if (findViewById4 != null) {
                        this.ivStockShare = (ImageView) findViewById4;
                        initializeUI();
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
    }

    private final void initializeUI() {
        NavController findNavController = Navigation.findNavController(this, C2723R.C2726id.main_nav_host_fragment);
        Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…d.main_nav_host_fragment)");
        NavInflater navInflater = findNavController.getNavInflater();
        Intrinsics.checkExpressionValueIsNotNull(navInflater, "navController.navInflater");
        NavGraph inflate = navInflater.inflate(C2723R.C2730navigation.payment_navigation_graph);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "navInflater.inflate(R.na…payment_navigation_graph)");
        String str = this.paymentMethod;
        boolean areEqual = Intrinsics.areEqual((Object) str, (Object) Constants_MVVM.PaymentMethod.CREDIT_CARD.getValue());
        int i = C2723R.C2726id.SelectCreditCardFragment;
        if (!areEqual && Intrinsics.areEqual((Object) str, (Object) Constants_MVVM.PaymentMethod.PAY_PAL.getValue())) {
            i = C2723R.C2726id.SelectVehiclesFragment;
        }
        initializeToolBar();
        NavArgument build = new NavArgument.Builder().setDefaultValue(this.paymentMethod).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "NavArgument.Builder().se…ue(paymentMethod).build()");
        NavArgument build2 = new NavArgument.Builder().setDefaultValue(this.onlyMyItem).build();
        Intrinsics.checkExpressionValueIsNotNull(build2, "NavArgument.Builder().se…Value(onlyMyItem).build()");
        NavArgument build3 = new NavArgument.Builder().setDefaultValue(Integer.valueOf(this.payPalAccountDetailID)).build();
        Intrinsics.checkExpressionValueIsNotNull(build3, "NavArgument.Builder().se…lAccountDetailID).build()");
        inflate.setStartDestination(i);
        inflate.addArgument(Constants_MVVM.EXTRA_PAYMENT_METHOD, build);
        inflate.addArgument(Constants_MVVM.EXTRA_TOBPAID_MY_VEHICLES_ONLY, build2);
        inflate.addArgument(Constants_MVVM.EXTRA_PAYMENT_PAYPAL_ACCOUNT_DETAIL_ID, build3);
        findNavController.setGraph(inflate);
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.im_pre_bid_close)).setOnClickListener(new BDTPaymentActivity$initializeUI$1(this, findNavController));
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        FragmentManager childFragmentManager;
        List<Fragment> fragments;
        Fragment fragment;
        super.onActivityResult(i, i2, intent);
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(C2723R.C2726id.main_nav_host_fragment);
        if (findFragmentById != null && (childFragmentManager = findFragmentById.getChildFragmentManager()) != null && (fragments = childFragmentManager.getFragments()) != null && (fragment = fragments.get(0)) != null) {
            fragment.onActivityResult(i, i2, intent);
        }
    }

    private final void initializeToolBar() {
        Toolbar toolbar2 = this.toolbar;
        if (toolbar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        setSupportActionBar(toolbar2);
        getWindow().setSoftInputMode(2);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setHomeButtonEnabled(true);
        }
        ActionBar supportActionBar3 = getSupportActionBar();
        if (supportActionBar3 != null) {
            supportActionBar3.setDisplayShowTitleEnabled(true);
        }
        TextView textView = this.toolbar_title;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Constants_MVVM.EXTRA_TOOLBAR_TITLE);
        }
        textView.setText(getResources().getString(C2723R.string.lbl_manage_offers));
        TextView textView2 = this.toolbar_sub_title;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar_sub_title");
        }
        textView2.setVisibility(8);
        ImageView imageView = this.ivStockShare;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivStockShare");
        }
        imageView.setVisibility(8);
    }

    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        NavController findNavController = Navigation.findNavController(this, C2723R.C2726id.main_nav_host_fragment);
        Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…d.main_nav_host_fragment)");
        NavDestination currentDestination = findNavController.getCurrentDestination();
        if (currentDestination == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(currentDestination, "navController.currentDestination!!");
        if (currentDestination.getId() == C2723R.C2726id.toBeConfirmationFragment) {
            setResult(-1);
            finish();
            return true;
        }
        onBackPressed();
        return true;
    }

    public final void setOnNextPageLoad(@NotNull OnNextPageLoad onNextPageLoad2) {
        Intrinsics.checkParameterIsNotNull(onNextPageLoad2, "onNextPageLoad");
        this.onNextPageLoad = onNextPageLoad2;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.clear();
    }

    public void onBackPressed() {
        NavController findNavController = Navigation.findNavController(this, C2723R.C2726id.main_nav_host_fragment);
        Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…d.main_nav_host_fragment)");
        NavDestination currentDestination = findNavController.getCurrentDestination();
        if (currentDestination == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(currentDestination, "navController.currentDestination!!");
        if (currentDestination.getId() == C2723R.C2726id.toBeConfirmationFragment) {
            setResult(-1);
            finish();
            return;
        }
        super.onBackPressed();
    }
}
