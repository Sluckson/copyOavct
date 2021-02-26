package com.iaai.android.bdt.feature.myAccount.toBePaid;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue;
import com.iaai.android.bdt.utils.BDTUtils;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.utils.p016ui.UiUtils;
import dagger.android.support.AndroidSupportInjection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\u0012\u0010#\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(H\u0016J&\u0010)\u001a\u0004\u0018\u00010\u001d2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000¨\u0006."}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/ToBePaidConfirmationFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "()V", "amtIncludingCDF", "Lkotlin/Pair;", "", "bdtPaymentActivity", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/BDTPaymentActivity;", "cdfFee", "getCdfFee", "()D", "cdfFee$delegate", "Lkotlin/Lazy;", "failureList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "Lkotlin/collections/ArrayList;", "isViewAllSelectedFailure", "", "isViewAllSelectedSuccess", "selectedItemsList", "", "getSelectedItemsList", "()Ljava/util/List;", "selectedItemsList$delegate", "successList", "", "totalAmountDue", "viewSaleList", "Landroid/view/View;", "getTotalAmountDue", "", "initializeFailureRecycler", "initializeSuccessRecycler", "initializeUI", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ToBePaidConfirmationFragment.kt */
public final class ToBePaidConfirmationFragment extends BaseFragment {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ToBePaidConfirmationFragment.class), "selectedItemsList", "getSelectedItemsList()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ToBePaidConfirmationFragment.class), "cdfFee", "getCdfFee()D"))};
    private HashMap _$_findViewCache;
    private Pair<Double, Double> amtIncludingCDF;
    /* access modifiers changed from: private */
    public BDTPaymentActivity bdtPaymentActivity;
    private final Lazy cdfFee$delegate = LazyKt.lazy(new ToBePaidConfirmationFragment$cdfFee$2(this));
    private ArrayList<PaymentDue> failureList = new ArrayList<>();
    /* access modifiers changed from: private */
    public boolean isViewAllSelectedFailure;
    /* access modifiers changed from: private */
    public boolean isViewAllSelectedSuccess;
    private final Lazy selectedItemsList$delegate = LazyKt.lazy(new ToBePaidConfirmationFragment$selectedItemsList$2(this));
    private List<PaymentDue> successList = new ArrayList();
    private double totalAmountDue;
    private View viewSaleList;

    private final double getCdfFee() {
        Lazy lazy = this.cdfFee$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return ((Number) lazy.getValue()).doubleValue();
    }

    private final List<PaymentDue> getSelectedItemsList() {
        Lazy lazy = this.selectedItemsList$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (List) lazy.getValue();
    }

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
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public ToBePaidConfirmationFragment() {
        Double valueOf = Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        this.amtIncludingCDF = new Pair<>(valueOf, valueOf);
    }

    public static final /* synthetic */ BDTPaymentActivity access$getBdtPaymentActivity$p(ToBePaidConfirmationFragment toBePaidConfirmationFragment) {
        BDTPaymentActivity bDTPaymentActivity = toBePaidConfirmationFragment.bdtPaymentActivity;
        if (bDTPaymentActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        return bDTPaymentActivity;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.bdtPaymentActivity = (BDTPaymentActivity) activity;
            if (context instanceof BDTPaymentActivity) {
                this.bdtPaymentActivity = (BDTPaymentActivity) context;
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentActivity");
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        if (this.viewSaleList == null) {
            ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.fragment_to_be_paid_confirmation, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "mBinding");
            this.viewSaleList = inflate.getRoot();
        }
        return this.viewSaleList;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        List list;
        super.onActivityCreated(bundle);
        BDTPaymentActivity bDTPaymentActivity = this.bdtPaymentActivity;
        if (bDTPaymentActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        ImageView imageView = (ImageView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "bdtPaymentActivity.arrow_left");
        imageView.setVisibility(8);
        BDTPaymentActivity bDTPaymentActivity2 = this.bdtPaymentActivity;
        if (bDTPaymentActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        ImageView imageView2 = (ImageView) bDTPaymentActivity2._$_findCachedViewById(C2723R.C2726id.arrow_right);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, "bdtPaymentActivity.arrow_right");
        imageView2.setVisibility(8);
        BDTPaymentActivity bDTPaymentActivity3 = this.bdtPaymentActivity;
        if (bDTPaymentActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        RelativeLayout relativeLayout = (RelativeLayout) bDTPaymentActivity3._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "bdtPaymentActivity.toolbar_relativelayout");
        relativeLayout.setVisibility(8);
        BDTPaymentActivity bDTPaymentActivity4 = this.bdtPaymentActivity;
        if (bDTPaymentActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        bDTPaymentActivity4.getToolbar_sub_title().setVisibility(8);
        BDTPaymentActivity bDTPaymentActivity5 = this.bdtPaymentActivity;
        if (bDTPaymentActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        ActionBar supportActionBar = bDTPaymentActivity5.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(false);
        }
        BDTPaymentActivity bDTPaymentActivity6 = this.bdtPaymentActivity;
        if (bDTPaymentActivity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        ActionBar supportActionBar2 = bDTPaymentActivity6.getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setHomeButtonEnabled(false);
        }
        List<PaymentDue> selectedItemsList = getSelectedItemsList();
        List list2 = null;
        if (selectedItemsList != null) {
            Collection arrayList = new ArrayList();
            for (Object next : selectedItemsList) {
                if (((PaymentDue) next).isPaymentSuccess()) {
                    arrayList.add(next);
                }
            }
            list = (List) arrayList;
        } else {
            list = null;
        }
        this.successList = new ArrayList(list);
        List<PaymentDue> selectedItemsList2 = getSelectedItemsList();
        if (selectedItemsList2 != null) {
            Collection arrayList2 = new ArrayList();
            for (Object next2 : selectedItemsList2) {
                if (!((PaymentDue) next2).isPaymentSuccess()) {
                    arrayList2.add(next2);
                }
            }
            list2 = (List) arrayList2;
        }
        this.failureList = new ArrayList<>(list2);
        getTotalAmountDue();
        initializeUI();
        initializeSuccessRecycler();
        initializeFailureRecycler();
    }

    private final void initializeUI() {
        int i;
        int i2;
        BDTPaymentActivity bDTPaymentActivity = this.bdtPaymentActivity;
        if (bDTPaymentActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        RelativeLayout relativeLayout = (RelativeLayout) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "bdtPaymentActivity.toolbar_relativelayout");
        relativeLayout.setVisibility(8);
        BDTPaymentActivity bDTPaymentActivity2 = this.bdtPaymentActivity;
        if (bDTPaymentActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        ActionBar supportActionBar = bDTPaymentActivity2.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(false);
        }
        BDTPaymentActivity bDTPaymentActivity3 = this.bdtPaymentActivity;
        if (bDTPaymentActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        ActionBar supportActionBar2 = bDTPaymentActivity3.getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setHomeButtonEnabled(false);
        }
        BDTPaymentActivity bDTPaymentActivity4 = this.bdtPaymentActivity;
        if (bDTPaymentActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        bDTPaymentActivity4.getToolbar().setBackgroundColor(-1);
        BDTPaymentActivity bDTPaymentActivity5 = this.bdtPaymentActivity;
        if (bDTPaymentActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) bDTPaymentActivity5._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "bdtPaymentActivity.prebid_title_layout");
        constraintLayout.setVisibility(0);
        BDTPaymentActivity bDTPaymentActivity6 = this.bdtPaymentActivity;
        if (bDTPaymentActivity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        bDTPaymentActivity6.getIvStockShare().setVisibility(8);
        BDTPaymentActivity bDTPaymentActivity7 = this.bdtPaymentActivity;
        if (bDTPaymentActivity7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        TextView textView = (TextView) bDTPaymentActivity7._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
        Intrinsics.checkExpressionValueIsNotNull(textView, "bdtPaymentActivity.prebid_page_title");
        textView.setText(getResources().getString(C2723R.string.lbl_to_paid_confirmation));
        ((Button) _$_findCachedViewById(C2723R.C2726id.btnMakeAnotherPayment)).setOnClickListener(new ToBePaidConfirmationFragment$initializeUI$1(this));
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvItemToPaid);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tvItemToPaid");
        boolean z = true;
        textView2.setText(getResources().getString(C2723R.string.lbl_items_paid, new Object[]{String.valueOf(this.successList.size())}));
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvTotalAmount);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "tvTotalAmount");
        textView3.setText(UiUtils.formatCurrencyFromString(String.valueOf(this.amtIncludingCDF.getFirst().doubleValue()), true));
        Collection collection = this.failureList;
        if (collection == null || collection.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llPartiallyPaid);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llPartiallyPaid");
            linearLayout.setVisibility(8);
            TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvPartialInfo);
            Intrinsics.checkExpressionValueIsNotNull(textView4, "tvPartialInfo");
            textView4.setVisibility(8);
        } else {
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llPartiallyPaid);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "llPartiallyPaid");
            linearLayout2.setVisibility(0);
            TextView textView5 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvPartialInfo);
            Intrinsics.checkExpressionValueIsNotNull(textView5, "tvPartialInfo");
            textView5.setVisibility(0);
            Collection collection2 = this.failureList;
            if (collection2 == null || collection2.isEmpty()) {
                TextView textView6 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvViewAllFailure);
                Intrinsics.checkExpressionValueIsNotNull(textView6, "tvViewAllFailure");
                textView6.setVisibility(8);
            } else if (this.failureList.size() > 5) {
                TextView textView7 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvViewAllFailure);
                Intrinsics.checkExpressionValueIsNotNull(textView7, "tvViewAllFailure");
                textView7.setVisibility(0);
            } else {
                TextView textView8 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvViewAllFailure);
                Intrinsics.checkExpressionValueIsNotNull(textView8, "tvViewAllFailure");
                textView8.setVisibility(8);
            }
            TextView textView9 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvPartialInfo);
            Intrinsics.checkExpressionValueIsNotNull(textView9, "tvPartialInfo");
            textView9.setText(getResources().getString(C2723R.string.lbl_partial_payment_info, new Object[]{String.valueOf(this.failureList.size())}));
            SpannableString spannableString = new SpannableString(getResources().getString(C2723R.string.lbl_partial_payment_error, new Object[]{String.valueOf(this.failureList.size())}));
            if (Intrinsics.areEqual((Object) Utils.getLanguage(), (Object) Constants_MVVM.EXTRA_SPANISH_CODE)) {
                String string = getResources().getString(C2723R.string.lbl_partial_payment_error, new Object[]{String.valueOf(this.failureList.size())});
                Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.st…lureList.size.toString())");
                i2 = StringsKt.indexOf$default((CharSequence) string, "Servicio al comprador", 0, false, 6, (Object) null);
                i = i2 + 21;
            } else {
                String string2 = getResources().getString(C2723R.string.lbl_partial_payment_error, new Object[]{String.valueOf(this.failureList.size())});
                Intrinsics.checkExpressionValueIsNotNull(string2, "resources.getString(R.st…lureList.size.toString())");
                i2 = StringsKt.indexOf$default((CharSequence) string2, "Buyer Services", 0, false, 6, (Object) null);
                i = i2 + 14;
            }
            ToBePaidConfirmationFragment$initializeUI$clickSpan$1 toBePaidConfirmationFragment$initializeUI$clickSpan$1 = new ToBePaidConfirmationFragment$initializeUI$clickSpan$1(this);
            spannableString.setSpan(new UnderlineSpan(), i2, i, 0);
            spannableString.setSpan(toBePaidConfirmationFragment$initializeUI$clickSpan$1, i2, i, 18);
            TextView textView10 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvErrorMessage);
            Intrinsics.checkExpressionValueIsNotNull(textView10, "tvErrorMessage");
            textView10.setText(spannableString);
            TextView textView11 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvErrorMessage);
            Intrinsics.checkExpressionValueIsNotNull(textView11, "tvErrorMessage");
            textView11.setMovementMethod(LinkMovementMethod.getInstance());
            TextView textView12 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvErrorMessage);
            FragmentActivity activity = getActivity();
            if (activity == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(activity, "activity!!");
            textView12.setLinkTextColor(ContextCompat.getColor(activity.getApplicationContext(), C2723R.C2724color.iaa_black));
        }
        Collection collection3 = this.successList;
        if (collection3 != null && !collection3.isEmpty()) {
            z = false;
        }
        if (z) {
            TextView textView13 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvViewAll);
            Intrinsics.checkExpressionValueIsNotNull(textView13, "tvViewAll");
            textView13.setVisibility(8);
        } else if (this.successList.size() > 5) {
            TextView textView14 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvViewAll);
            Intrinsics.checkExpressionValueIsNotNull(textView14, "tvViewAll");
            textView14.setVisibility(0);
        } else {
            TextView textView15 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvViewAll);
            Intrinsics.checkExpressionValueIsNotNull(textView15, "tvViewAll");
            textView15.setVisibility(8);
        }
    }

    private final void initializeSuccessRecycler() {
        Context context = getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
        ConfirmPaymentAdapter confirmPaymentAdapter = new ConfirmPaymentAdapter(context);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvConfirmVehicle);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvConfirmVehicle");
        recyclerView.setAdapter(confirmPaymentAdapter);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvConfirmVehicle);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvConfirmVehicle");
        Context context2 = getContext();
        if (context2 == null) {
            Intrinsics.throwNpe();
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(context2));
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvConfirmVehicle)).setHasFixedSize(true);
        confirmPaymentAdapter.setItemsList(this.successList);
        confirmPaymentAdapter.shouldDisplayAll(this.isViewAllSelectedSuccess);
        confirmPaymentAdapter.notifyDataSetChanged();
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tvViewAll)).setOnClickListener(new ToBePaidConfirmationFragment$initializeSuccessRecycler$1(this, confirmPaymentAdapter));
    }

    private final void initializeFailureRecycler() {
        Context context = getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
        ConfirmPaymentAdapter confirmPaymentAdapter = new ConfirmPaymentAdapter(context);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvFailureVehicle);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvFailureVehicle");
        recyclerView.setAdapter(confirmPaymentAdapter);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvFailureVehicle);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvFailureVehicle");
        Context context2 = getContext();
        if (context2 == null) {
            Intrinsics.throwNpe();
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(context2));
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvFailureVehicle)).setHasFixedSize(true);
        confirmPaymentAdapter.setItemsList(this.failureList);
        confirmPaymentAdapter.shouldDisplayAll(this.isViewAllSelectedFailure);
        confirmPaymentAdapter.notifyDataSetChanged();
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tvViewAllFailure)).setOnClickListener(new ToBePaidConfirmationFragment$initializeFailureRecycler$1(this, confirmPaymentAdapter));
    }

    private final void getTotalAmountDue() {
        this.totalAmountDue = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (PaymentDue totalDue : this.successList) {
            this.totalAmountDue += totalDue.getTotalDue();
        }
        this.amtIncludingCDF = BDTUtils.INSTANCE.getTotalInclusiveOfCDF(this.totalAmountDue, getCdfFee());
    }
}
