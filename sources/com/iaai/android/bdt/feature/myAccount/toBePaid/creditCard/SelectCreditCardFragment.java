package com.iaai.android.bdt.feature.myAccount.toBePaid.creditCard;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentActivity;
import com.iaai.android.databinding.FragmentSelectCreditCardBinding;
import com.iaai.android.old.utils.IAASharedPreference;
import dagger.android.support.AndroidSupportInjection;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006!"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/creditCard/SelectCreditCardFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/creditCard/CardSelectedListener;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "bdtPaymentActivity", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/BDTPaymentActivity;", "creditCardAdapter", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/creditCard/CreditCardAdapter;", "initializeRecycler", "", "initializeUI", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onCardSelected", "card", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/creditCard/DummyCard;", "position", "", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SelectCreditCardFragment.kt */
public final class SelectCreditCardFragment extends BaseFragment implements CardSelectedListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_SAMPLE = "sample";
    private final String TAG = SelectCreditCardFragment.class.getSimpleName();
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public BDTPaymentActivity bdtPaymentActivity;
    private CreditCardAdapter creditCardAdapter;

    @JvmStatic
    @NotNull
    public static final SelectCreditCardFragment newInstance(@NotNull String str) {
        return Companion.newInstance(str);
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

    public static final /* synthetic */ BDTPaymentActivity access$getBdtPaymentActivity$p(SelectCreditCardFragment selectCreditCardFragment) {
        BDTPaymentActivity bDTPaymentActivity = selectCreditCardFragment.bdtPaymentActivity;
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

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/creditCard/SelectCreditCardFragment$Companion;", "", "()V", "KEY_SAMPLE", "", "newInstance", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/creditCard/SelectCreditCardFragment;", "url", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SelectCreditCardFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final SelectCreditCardFragment newInstance(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            SelectCreditCardFragment selectCreditCardFragment = new SelectCreditCardFragment();
            Bundle bundle = new Bundle();
            bundle.putString(SelectCreditCardFragment.KEY_SAMPLE, str);
            selectCreditCardFragment.setArguments(bundle);
            return selectCreditCardFragment;
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        FragmentSelectCreditCardBinding fragmentSelectCreditCardBinding = (FragmentSelectCreditCardBinding) DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.fragment_select_credit_card, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(fragmentSelectCreditCardBinding, "mBinding");
        return fragmentSelectCreditCardBinding.getRoot();
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        initializeUI();
    }

    private final void initializeUI() {
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvToolbarName);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvToolbarName");
        textView.setText(getResources().getString(C2723R.string.lbl_bdt_select_credit_card));
        Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btnSelectCard);
        Intrinsics.checkExpressionValueIsNotNull(button, "btnSelectCard");
        button.setClickable(false);
        Button button2 = (Button) _$_findCachedViewById(C2723R.C2726id.btnSelectCard);
        Intrinsics.checkExpressionValueIsNotNull(button2, "btnSelectCard");
        button2.setAlpha(0.5f);
        initializeRecycler();
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.ivToolbarImg1)).setOnClickListener(new SelectCreditCardFragment$initializeUI$1(this));
        ((Button) _$_findCachedViewById(C2723R.C2726id.btnSelectCard)).setOnClickListener(new SelectCreditCardFragment$initializeUI$2(this));
    }

    private final void initializeRecycler() {
        ArrayList arrayListOf = CollectionsKt.arrayListOf(new DummyCard("(..1234)", "12/2023"), new DummyCard("(..5678)", "01/2023"), new DummyCard("(..6534)", "12/2025"), new DummyCard("(..8765)", "07/2024"));
        BDTPaymentActivity bDTPaymentActivity = this.bdtPaymentActivity;
        if (bDTPaymentActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        this.creditCardAdapter = new CreditCardAdapter(bDTPaymentActivity, this);
        CreditCardAdapter creditCardAdapter2 = this.creditCardAdapter;
        if (creditCardAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("creditCardAdapter");
        }
        creditCardAdapter2.setData(arrayListOf);
        String creditCard = IAASharedPreference.getCreditCard(getContext());
        Intrinsics.checkExpressionValueIsNotNull(creditCard, "lastSelected");
        if (creditCard.length() > 0) {
            int parseInt = Integer.parseInt(creditCard);
            CreditCardAdapter creditCardAdapter3 = this.creditCardAdapter;
            if (creditCardAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("creditCardAdapter");
            }
            creditCardAdapter3.setSelectedIndex(parseInt);
            Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btnSelectCard);
            Intrinsics.checkExpressionValueIsNotNull(button, "btnSelectCard");
            button.setClickable(true);
            Button button2 = (Button) _$_findCachedViewById(C2723R.C2726id.btnSelectCard);
            Intrinsics.checkExpressionValueIsNotNull(button2, "btnSelectCard");
            button2.setAlpha(1.0f);
        }
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvCreditCard);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvCreditCard");
        CreditCardAdapter creditCardAdapter4 = this.creditCardAdapter;
        if (creditCardAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("creditCardAdapter");
        }
        recyclerView.setAdapter(creditCardAdapter4);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvCreditCard);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvCreditCard");
        BDTPaymentActivity bDTPaymentActivity2 = this.bdtPaymentActivity;
        if (bDTPaymentActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(bDTPaymentActivity2, 1, false));
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvCreditCard)).addItemDecoration(new DividerItemDecoration(getContext(), 1));
    }

    public void onCardSelected(@Nullable DummyCard dummyCard, int i) {
        if (i != -1) {
            Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btnSelectCard);
            Intrinsics.checkExpressionValueIsNotNull(button, "btnSelectCard");
            button.setClickable(true);
            Button button2 = (Button) _$_findCachedViewById(C2723R.C2726id.btnSelectCard);
            Intrinsics.checkExpressionValueIsNotNull(button2, "btnSelectCard");
            button2.setAlpha(1.0f);
        } else {
            Button button3 = (Button) _$_findCachedViewById(C2723R.C2726id.btnSelectCard);
            Intrinsics.checkExpressionValueIsNotNull(button3, "btnSelectCard");
            button3.setClickable(false);
            Button button4 = (Button) _$_findCachedViewById(C2723R.C2726id.btnSelectCard);
            Intrinsics.checkExpressionValueIsNotNull(button4, "btnSelectCard");
            button4.setAlpha(0.5f);
        }
        Context context = getContext();
        IAASharedPreference.setCreditCard(context, "" + i);
        StringBuilder sb = new StringBuilder();
        sb.append("CARD SELECTED: ");
        sb.append(dummyCard != null ? dummyCard.getNumber() : null);
        Log.e("LOVY>>", sb.toString());
    }
}
