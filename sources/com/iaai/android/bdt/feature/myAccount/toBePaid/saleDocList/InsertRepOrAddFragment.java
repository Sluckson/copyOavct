package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textfield.TextInputLayout;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.extensions.EditText_ExtensionKt;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.model.MyAccount.InsertRepOrAddressRequest;
import com.iaai.android.bdt.model.MyAccount.SaleDocCountryStateModel;
import com.iaai.android.bdt.model.toBePaid.getDeliveryMethod.Address;
import com.iaai.android.bdt.model.toBePaid.getDeliveryMethod.RepresentativeInfo;
import com.iaai.android.bdt.model.toBePaid.saleDocument.MailingAddressInfo;
import dagger.android.support.AndroidSupportInjection;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 V2\u00020\u0001:\u0001VB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\fH\u0002J\b\u00105\u001a\u00020-H\u0002J\b\u00106\u001a\u000203H\u0002J\b\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u000208H\u0002J \u0010:\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010;\u001a\u000203H\u0002J\b\u0010<\u001a\u00020-H\u0002J\u0012\u0010=\u001a\u00020-2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0010\u0010@\u001a\u00020-2\u0006\u0010A\u001a\u00020BH\u0016J\u0012\u0010C\u001a\u00020-2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0012\u0010D\u001a\u00020E2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J*\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010H\u001a\u00020I2\n\b\u0001\u0010J\u001a\u0004\u0018\u00010K2\n\b\u0001\u0010>\u001a\u0004\u0018\u00010?H\u0017J\u0010\u0010L\u001a\u00020-2\u0006\u0010M\u001a\u00020\u0012H\u0002J\b\u0010N\u001a\u00020-H\u0002J,\u0010O\u001a\u00020-2\u001a\u0010P\u001a\u0016\u0012\u0004\u0012\u000203\u0018\u00010\bj\n\u0012\u0004\u0012\u000203\u0018\u0001`\n2\u0006\u0010Q\u001a\u00020\fH\u0002J$\u0010R\u001a\u00020-2\u001a\u0010S\u001a\u0016\u0012\u0004\u0012\u000203\u0018\u00010\bj\n\u0012\u0004\u0012\u000203\u0018\u0001`\nH\u0002J\u0018\u0010T\u001a\u00020-2\u0006\u00104\u001a\u00020\f2\u0006\u0010U\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020!X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020'8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006W"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/InsertRepOrAddFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "bottomSheetCallback", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/BottomSheetCallback;", "deliveryMethod", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryMethod;", "(Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/BottomSheetCallback;Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryMethod;)V", "countryFilteredList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocCountryStateModel;", "Lkotlin/collections/ArrayList;", "countryIndex", "", "countryMainList", "deliveryMethodActivity", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryMethodActivity;", "filterStateList", "isAddressValid", "", "isCityValid", "isCountryValid", "isNameValid", "isPhoneValid", "isStateValid", "isZIPValid", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "stateIndex", "viewModel", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/InsertRepOrAddViewModel;", "getViewModel", "()Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/InsertRepOrAddViewModel;", "setViewModel", "(Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/InsertRepOrAddViewModel;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "addValidationOnEditText", "", "textInputLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "editText", "Landroid/widget/EditText;", "errorMessage", "", "editTextType", "fetchCountryStateList", "getAuthString", "getMailRequestBody", "Lcom/iaai/android/bdt/model/MyAccount/InsertRepOrAddressRequest;", "getRepRequestBody", "getStateListBasedOnCountry", "countryCode", "initializeUI", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "showLoadingIndicator", "loading", "subscribeToViewModel", "updateCountrySpinner", "countryList", "usPosition", "updateStateSpinner", "stateList", "updateValidationFlag", "isValid", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: InsertRepOrAddFragment.kt */
public final class InsertRepOrAddFragment extends BottomSheetDialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public final BottomSheetCallback bottomSheetCallback;
    /* access modifiers changed from: private */
    public ArrayList<SaleDocCountryStateModel> countryFilteredList = new ArrayList<>();
    /* access modifiers changed from: private */
    public int countryIndex;
    /* access modifiers changed from: private */
    public ArrayList<SaleDocCountryStateModel> countryMainList = new ArrayList<>();
    /* access modifiers changed from: private */
    public final DeliveryMethod deliveryMethod;
    /* access modifiers changed from: private */
    public DeliveryMethodActivity deliveryMethodActivity;
    /* access modifiers changed from: private */
    public ArrayList<SaleDocCountryStateModel> filterStateList = new ArrayList<>();
    private boolean isAddressValid;
    private boolean isCityValid;
    private boolean isCountryValid;
    private boolean isNameValid;
    private boolean isPhoneValid;
    private boolean isStateValid;
    private boolean isZIPValid;
    @Inject
    @NotNull
    public SessionManager sessionManager;
    /* access modifiers changed from: private */
    public int stateIndex;
    @NotNull
    public InsertRepOrAddViewModel viewModel;
    @Inject
    @NotNull
    public ViewModelProvider.Factory viewModelFactory;

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

    public InsertRepOrAddFragment(@NotNull BottomSheetCallback bottomSheetCallback2, @NotNull DeliveryMethod deliveryMethod2) {
        Intrinsics.checkParameterIsNotNull(bottomSheetCallback2, "bottomSheetCallback");
        Intrinsics.checkParameterIsNotNull(deliveryMethod2, "deliveryMethod");
        this.bottomSheetCallback = bottomSheetCallback2;
        this.deliveryMethod = deliveryMethod2;
    }

    public static final /* synthetic */ DeliveryMethodActivity access$getDeliveryMethodActivity$p(InsertRepOrAddFragment insertRepOrAddFragment) {
        DeliveryMethodActivity deliveryMethodActivity2 = insertRepOrAddFragment.deliveryMethodActivity;
        if (deliveryMethodActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deliveryMethodActivity");
        }
        return deliveryMethodActivity2;
    }

    @NotNull
    public final ViewModelProvider.Factory getViewModelFactory() {
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return factory;
    }

    public final void setViewModelFactory(@NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkParameterIsNotNull(factory, "<set-?>");
        this.viewModelFactory = factory;
    }

    @NotNull
    public final InsertRepOrAddViewModel getViewModel() {
        InsertRepOrAddViewModel insertRepOrAddViewModel = this.viewModel;
        if (insertRepOrAddViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return insertRepOrAddViewModel;
    }

    public final void setViewModel(@NotNull InsertRepOrAddViewModel insertRepOrAddViewModel) {
        Intrinsics.checkParameterIsNotNull(insertRepOrAddViewModel, "<set-?>");
        this.viewModel = insertRepOrAddViewModel;
    }

    @NotNull
    public final SessionManager getSessionManager() {
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        return sessionManager2;
    }

    public final void setSessionManager(@NotNull SessionManager sessionManager2) {
        Intrinsics.checkParameterIsNotNull(sessionManager2, "<set-?>");
        this.sessionManager = sessionManager2;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.deliveryMethodActivity = (DeliveryMethodActivity) activity;
            if (context instanceof DeliveryMethodActivity) {
                this.deliveryMethodActivity = (DeliveryMethodActivity) context;
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.DeliveryMethodActivity");
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Fragment fragment = this;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m16of(fragment, factory).get(InsertRepOrAddViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…AddViewModel::class.java)");
        this.viewModel = (InsertRepOrAddViewModel) viewModel2;
    }

    @Nullable
    @androidx.annotation.Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable @androidx.annotation.Nullable ViewGroup viewGroup, @Nullable @androidx.annotation.Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(C2723R.C2728layout.fragment_insert_rep_or_add, viewGroup, false);
    }

    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        if (onCreateDialog != null) {
            BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) onCreateDialog;
            bottomSheetDialog.setOnShowListener(new InsertRepOrAddFragment$onCreateDialog$1(bottomSheetDialog));
            return bottomSheetDialog;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        fetchCountryStateList();
        initializeUI();
        subscribeToViewModel();
    }

    private final void fetchCountryStateList() {
        InsertRepOrAddViewModel insertRepOrAddViewModel = this.viewModel;
        if (insertRepOrAddViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        insertRepOrAddViewModel.getCountryStateList();
    }

    private final void initializeUI() {
        Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btnSave);
        Intrinsics.checkExpressionValueIsNotNull(button, "btnSave");
        button.setEnabled(false);
        Button button2 = (Button) _$_findCachedViewById(C2723R.C2726id.btnSave);
        Intrinsics.checkExpressionValueIsNotNull(button2, "btnSave");
        button2.setAlpha(0.5f);
        TextInputLayout textInputLayout = (TextInputLayout) _$_findCachedViewById(C2723R.C2726id.tlName);
        Intrinsics.checkExpressionValueIsNotNull(textInputLayout, "tlName");
        EditText editText = (EditText) _$_findCachedViewById(C2723R.C2726id.etName);
        Intrinsics.checkExpressionValueIsNotNull(editText, "etName");
        String string = getString(C2723R.string.lbl_error_valid_representative);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.lbl_error_valid_representative)");
        addValidationOnEditText(textInputLayout, editText, string, 1);
        TextInputLayout textInputLayout2 = (TextInputLayout) _$_findCachedViewById(C2723R.C2726id.tlStreetAddress);
        Intrinsics.checkExpressionValueIsNotNull(textInputLayout2, "tlStreetAddress");
        EditText editText2 = (EditText) _$_findCachedViewById(C2723R.C2726id.etAddress);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "etAddress");
        String string2 = getString(C2723R.string.lbl_error_valid_address);
        Intrinsics.checkExpressionValueIsNotNull(string2, "getString(R.string.lbl_error_valid_address)");
        addValidationOnEditText(textInputLayout2, editText2, string2, 2);
        TextInputLayout textInputLayout3 = (TextInputLayout) _$_findCachedViewById(C2723R.C2726id.tlCity);
        Intrinsics.checkExpressionValueIsNotNull(textInputLayout3, "tlCity");
        EditText editText3 = (EditText) _$_findCachedViewById(C2723R.C2726id.etCity);
        Intrinsics.checkExpressionValueIsNotNull(editText3, "etCity");
        String string3 = getString(C2723R.string.lbl_error_valid_city);
        Intrinsics.checkExpressionValueIsNotNull(string3, "getString(R.string.lbl_error_valid_city)");
        addValidationOnEditText(textInputLayout3, editText3, string3, 3);
        TextInputLayout textInputLayout4 = (TextInputLayout) _$_findCachedViewById(C2723R.C2726id.tlZipCode);
        Intrinsics.checkExpressionValueIsNotNull(textInputLayout4, "tlZipCode");
        EditText editText4 = (EditText) _$_findCachedViewById(C2723R.C2726id.etZip);
        Intrinsics.checkExpressionValueIsNotNull(editText4, "etZip");
        String string4 = getString(C2723R.string.lbl_error_valid_zipcode);
        Intrinsics.checkExpressionValueIsNotNull(string4, "getString(R.string.lbl_error_valid_zipcode)");
        addValidationOnEditText(textInputLayout4, editText4, string4, 4);
        TextInputLayout textInputLayout5 = (TextInputLayout) _$_findCachedViewById(C2723R.C2726id.tlPhone);
        Intrinsics.checkExpressionValueIsNotNull(textInputLayout5, "tlPhone");
        EditText editText5 = (EditText) _$_findCachedViewById(C2723R.C2726id.etPhone);
        Intrinsics.checkExpressionValueIsNotNull(editText5, "etPhone");
        String string5 = getString(C2723R.string.lbl_error_valid_phone);
        Intrinsics.checkExpressionValueIsNotNull(string5, "getString(R.string.lbl_error_valid_phone)");
        addValidationOnEditText(textInputLayout5, editText5, string5, 5);
        ((Button) _$_findCachedViewById(C2723R.C2726id.btnCancel)).setOnClickListener(new InsertRepOrAddFragment$initializeUI$1(this));
        ((Button) _$_findCachedViewById(C2723R.C2726id.btnSave)).setOnClickListener(new InsertRepOrAddFragment$initializeUI$2(this));
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(C2723R.string.lbl_rep_state));
        updateStateSpinner(arrayList);
        if (this.deliveryMethod == DeliveryMethod.FED_EX) {
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvHeader);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tvHeader");
            textView.setText(getString(C2723R.string.lbl_name_add_new_address));
            TextInputLayout textInputLayout6 = (TextInputLayout) _$_findCachedViewById(C2723R.C2726id.tlName);
            Intrinsics.checkExpressionValueIsNotNull(textInputLayout6, "tlName");
            textInputLayout6.setHint((CharSequence) getString(C2723R.string.lbl_name_or_business_name));
            TextInputLayout textInputLayout7 = (TextInputLayout) _$_findCachedViewById(C2723R.C2726id.tlBusinessName);
            Intrinsics.checkExpressionValueIsNotNull(textInputLayout7, "tlBusinessName");
            textInputLayout7.setVisibility(8);
            RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rlCountry);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "rlCountry");
            relativeLayout.setVisibility(0);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(getString(C2723R.string.lbl_rep_country));
            updateCountrySpinner(arrayList2, 0);
        }
    }

    /* access modifiers changed from: private */
    public final InsertRepOrAddressRequest getRepRequestBody() {
        EditText editText = (EditText) _$_findCachedViewById(C2723R.C2726id.etAddress);
        Intrinsics.checkExpressionValueIsNotNull(editText, "etAddress");
        String obj = editText.getText().toString();
        EditText editText2 = (EditText) _$_findCachedViewById(C2723R.C2726id.etAptOrSuite);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "etAptOrSuite");
        String obj2 = editText2.getText().toString();
        EditText editText3 = (EditText) _$_findCachedViewById(C2723R.C2726id.etCity);
        Intrinsics.checkExpressionValueIsNotNull(editText3, "etCity");
        String obj3 = editText3.getText().toString();
        String stateName = this.filterStateList.get(this.stateIndex).getStateName();
        EditText editText4 = (EditText) _$_findCachedViewById(C2723R.C2726id.etZip);
        Intrinsics.checkExpressionValueIsNotNull(editText4, "etZip");
        Address address = new Address(obj, obj2, obj3, "US", stateName, editText4.getText().toString());
        EditText editText5 = (EditText) _$_findCachedViewById(C2723R.C2726id.etPhone);
        Intrinsics.checkExpressionValueIsNotNull(editText5, "etPhone");
        BigDecimal bigDecimal = new BigDecimal(editText5.getText().toString());
        EditText editText6 = (EditText) _$_findCachedViewById(C2723R.C2726id.etBusinessName);
        Intrinsics.checkExpressionValueIsNotNull(editText6, "etBusinessName");
        String obj4 = editText6.getText().toString();
        EditText editText7 = (EditText) _$_findCachedViewById(C2723R.C2726id.etName);
        Intrinsics.checkExpressionValueIsNotNull(editText7, "etName");
        return new InsertRepOrAddressRequest(new RepresentativeInfo(address, obj4, "", true, bigDecimal, editText7.getText().toString()), (MailingAddressInfo) null);
    }

    /* access modifiers changed from: private */
    public final InsertRepOrAddressRequest getMailRequestBody() {
        String countryName = this.countryFilteredList.get(this.countryIndex).getCountryName();
        this.filterStateList.get(this.stateIndex).getStateName();
        String stateName = StringsKt.equals(countryName, "United States", true) ? this.filterStateList.get(this.stateIndex).getStateName() : "";
        EditText editText = (EditText) _$_findCachedViewById(C2723R.C2726id.etAddress);
        Intrinsics.checkExpressionValueIsNotNull(editText, "etAddress");
        String obj = editText.getText().toString();
        EditText editText2 = (EditText) _$_findCachedViewById(C2723R.C2726id.etAptOrSuite);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "etAptOrSuite");
        String obj2 = editText2.getText().toString();
        EditText editText3 = (EditText) _$_findCachedViewById(C2723R.C2726id.etCity);
        Intrinsics.checkExpressionValueIsNotNull(editText3, "etCity");
        String obj3 = editText3.getText().toString();
        EditText editText4 = (EditText) _$_findCachedViewById(C2723R.C2726id.etZip);
        Intrinsics.checkExpressionValueIsNotNull(editText4, "etZip");
        Address address = new Address(obj, obj2, obj3, countryName, stateName, editText4.getText().toString());
        EditText editText5 = (EditText) _$_findCachedViewById(C2723R.C2726id.etPhone);
        Intrinsics.checkExpressionValueIsNotNull(editText5, "etPhone");
        BigDecimal bigDecimal = new BigDecimal(editText5.getText().toString());
        EditText editText6 = (EditText) _$_findCachedViewById(C2723R.C2726id.etName);
        Intrinsics.checkExpressionValueIsNotNull(editText6, "etName");
        return new InsertRepOrAddressRequest((RepresentativeInfo) null, new MailingAddressInfo("", address, editText6.getText().toString(), true, bigDecimal, false));
    }

    /* access modifiers changed from: private */
    public final void updateStateSpinner(ArrayList<String> arrayList) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        DeliveryMethodActivity deliveryMethodActivity2 = this.deliveryMethodActivity;
        if (deliveryMethodActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deliveryMethodActivity");
        }
        Context context = deliveryMethodActivity2;
        if (arrayList != null) {
            objectRef.element = new ArrayAdapter(context, 17367048, arrayList);
            ((ArrayAdapter) objectRef.element).setDropDownViewResource(17367049);
            Spinner spinner = (Spinner) _$_findCachedViewById(C2723R.C2726id.spState);
            spinner.setAdapter((ArrayAdapter) objectRef.element);
            spinner.setSelection(0, false);
            spinner.setOnItemSelectedListener(new InsertRepOrAddFragment$updateStateSpinner$$inlined$with$lambda$1(this, objectRef));
            spinner.setGravity(17);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
    }

    /* access modifiers changed from: private */
    public final void updateCountrySpinner(ArrayList<String> arrayList, int i) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        DeliveryMethodActivity deliveryMethodActivity2 = this.deliveryMethodActivity;
        if (deliveryMethodActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deliveryMethodActivity");
        }
        Context context = deliveryMethodActivity2;
        if (arrayList != null) {
            objectRef.element = new ArrayAdapter(context, 17367048, arrayList);
            ((ArrayAdapter) objectRef.element).setDropDownViewResource(17367049);
            Spinner spinner = (Spinner) _$_findCachedViewById(C2723R.C2726id.spCountry);
            spinner.setAdapter((ArrayAdapter) objectRef.element);
            spinner.setSelection(i, false);
            spinner.setOnItemSelectedListener(new C2753x2973add3(this, objectRef, i));
            spinner.setGravity(17);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
    }

    /* access modifiers changed from: private */
    public final String getAuthString() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[2];
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        objArr[0] = sessionManager2.getCurrentSessionUsername();
        SessionManager sessionManager3 = this.sessionManager;
        if (sessionManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        objArr[1] = sessionManager3.getCurrentSessionPassword();
        String format = String.format("%s:%s", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        return format;
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbSave);
            Intrinsics.checkExpressionValueIsNotNull(progressBar, "pbSave");
            progressBar.setVisibility(0);
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbSave);
        Intrinsics.checkExpressionValueIsNotNull(progressBar2, "pbSave");
        progressBar2.setVisibility(8);
    }

    private final void addValidationOnEditText(TextInputLayout textInputLayout, EditText editText, String str, int i) {
        EditText_ExtensionKt.onChange(editText, new InsertRepOrAddFragment$addValidationOnEditText$1(this, textInputLayout, str, i));
    }

    /* access modifiers changed from: private */
    public final void updateValidationFlag(int i, boolean z) {
        switch (i) {
            case 1:
                this.isNameValid = z;
                break;
            case 2:
                this.isAddressValid = z;
                break;
            case 3:
                this.isCityValid = z;
                break;
            case 4:
                this.isZIPValid = z;
                break;
            case 5:
                this.isPhoneValid = z;
                break;
            case 6:
                this.isStateValid = z;
                break;
            case 7:
                this.isCountryValid = z;
                break;
        }
        if (this.deliveryMethod == DeliveryMethod.FED_EX) {
            if (!this.isNameValid || !this.isAddressValid || !this.isCityValid || !this.isZIPValid || !this.isPhoneValid || !this.isCountryValid) {
                Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btnSave);
                Intrinsics.checkExpressionValueIsNotNull(button, "btnSave");
                button.setEnabled(false);
                Button button2 = (Button) _$_findCachedViewById(C2723R.C2726id.btnSave);
                Intrinsics.checkExpressionValueIsNotNull(button2, "btnSave");
                button2.setAlpha(0.5f);
            } else if (this.isStateValid) {
                Button button3 = (Button) _$_findCachedViewById(C2723R.C2726id.btnSave);
                Intrinsics.checkExpressionValueIsNotNull(button3, "btnSave");
                button3.setEnabled(true);
                Button button4 = (Button) _$_findCachedViewById(C2723R.C2726id.btnSave);
                Intrinsics.checkExpressionValueIsNotNull(button4, "btnSave");
                button4.setAlpha(1.0f);
            } else {
                Button button5 = (Button) _$_findCachedViewById(C2723R.C2726id.btnSave);
                Intrinsics.checkExpressionValueIsNotNull(button5, "btnSave");
                button5.setEnabled(false);
                Button button6 = (Button) _$_findCachedViewById(C2723R.C2726id.btnSave);
                Intrinsics.checkExpressionValueIsNotNull(button6, "btnSave");
                button6.setAlpha(0.5f);
            }
        } else if (!this.isNameValid || !this.isAddressValid || !this.isCityValid || !this.isZIPValid || !this.isPhoneValid || !this.isStateValid) {
            Button button7 = (Button) _$_findCachedViewById(C2723R.C2726id.btnSave);
            Intrinsics.checkExpressionValueIsNotNull(button7, "btnSave");
            button7.setEnabled(false);
            Button button8 = (Button) _$_findCachedViewById(C2723R.C2726id.btnSave);
            Intrinsics.checkExpressionValueIsNotNull(button8, "btnSave");
            button8.setAlpha(0.5f);
        } else {
            Button button9 = (Button) _$_findCachedViewById(C2723R.C2726id.btnSave);
            Intrinsics.checkExpressionValueIsNotNull(button9, "btnSave");
            button9.setEnabled(true);
            Button button10 = (Button) _$_findCachedViewById(C2723R.C2726id.btnSave);
            Intrinsics.checkExpressionValueIsNotNull(button10, "btnSave");
            button10.setAlpha(1.0f);
        }
    }

    /* access modifiers changed from: private */
    public final ArrayList<SaleDocCountryStateModel> getStateListBasedOnCountry(String str) {
        ArrayList<SaleDocCountryStateModel> arrayList = new ArrayList<>();
        for (SaleDocCountryStateModel saleDocCountryStateModel : this.countryMainList) {
            if (Intrinsics.areEqual((Object) saleDocCountryStateModel.getCountryCode(), (Object) str)) {
                arrayList.add(saleDocCountryStateModel);
            }
        }
        List list = arrayList;
        if (list.size() > 1) {
            CollectionsKt.sortWith(list, new C2751xf879d052());
        }
        return arrayList;
    }

    private final void subscribeToViewModel() {
        InsertRepOrAddViewModel insertRepOrAddViewModel = this.viewModel;
        if (insertRepOrAddViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        insertRepOrAddViewModel.getCountryStateResponse().observe(lifecycleOwner, new InsertRepOrAddFragment$subscribeToViewModel$1(this));
        InsertRepOrAddViewModel insertRepOrAddViewModel2 = this.viewModel;
        if (insertRepOrAddViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        insertRepOrAddViewModel2.getCountryStateError().observe(lifecycleOwner, InsertRepOrAddFragment$subscribeToViewModel$2.INSTANCE);
        InsertRepOrAddViewModel insertRepOrAddViewModel3 = this.viewModel;
        if (insertRepOrAddViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        insertRepOrAddViewModel3.getAddRepAddressResponse().observe(lifecycleOwner, new InsertRepOrAddFragment$subscribeToViewModel$3(this));
        InsertRepOrAddViewModel insertRepOrAddViewModel4 = this.viewModel;
        if (insertRepOrAddViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        insertRepOrAddViewModel4.getAddRepAddressError().observe(lifecycleOwner, new InsertRepOrAddFragment$subscribeToViewModel$4(this));
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/InsertRepOrAddFragment$Companion;", "", "()V", "newInstance", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/InsertRepOrAddFragment;", "bottomSheetCallback", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/BottomSheetCallback;", "deliveryMethod", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryMethod;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: InsertRepOrAddFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final InsertRepOrAddFragment newInstance(@NotNull BottomSheetCallback bottomSheetCallback, @NotNull DeliveryMethod deliveryMethod) {
            Intrinsics.checkParameterIsNotNull(bottomSheetCallback, "bottomSheetCallback");
            Intrinsics.checkParameterIsNotNull(deliveryMethod, "deliveryMethod");
            return new InsertRepOrAddFragment(bottomSheetCallback, deliveryMethod);
        }
    }
}
