package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.extensions.EditText_ExtensionKt;
import com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref.DeliveryBranchListAdapter;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.model.toBePaid.getDeliveryMethod.GetDeliveryMethodRequest;
import com.iaai.android.bdt.model.toBePaid.getDeliveryMethod.MailAddres;
import com.iaai.android.bdt.model.toBePaid.getDeliveryMethod.RepresentativeInfo;
import com.iaai.android.bdt.model.toBePaid.saleDocument.MailingAddressInfo;
import com.iaai.android.bdt.model.toBePaid.saleDocument.SaveDeliveryRequest;
import com.iaai.android.bdt.model.toBePaid.saleDocument.defaultResponse.TitleInstructionItem;
import com.iaai.android.bdt.utils.BDTUtils;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.InternetUtil;
import dagger.android.AndroidInjection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\rH\u0016J\b\u00100\u001a\u00020.H\u0002J\b\u00101\u001a\u00020\u0006H\u0002J\b\u00102\u001a\u00020.H\u0002J\b\u00103\u001a\u00020.H\u0002J\b\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u000205H\u0002J$\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010:\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010;\u001a\u00020\u0006H\u0002J\b\u0010<\u001a\u00020.H\u0002J\b\u0010=\u001a\u00020.H\u0002J\b\u0010>\u001a\u00020.H\u0002J\b\u0010?\u001a\u00020.H\u0002J\b\u0010@\u001a\u00020.H\u0002J\b\u0010A\u001a\u00020.H\u0002J\u0012\u0010B\u001a\u00020.2\b\u0010C\u001a\u0004\u0018\u00010DH\u0014J\u0010\u0010E\u001a\u00020.2\u0006\u0010F\u001a\u00020\u000fH\u0002J\b\u0010G\u001a\u00020.H\u0002J\u0010\u0010H\u001a\u00020.2\u0006\u0010I\u001a\u00020\u000fH\u0002J\b\u0010J\u001a\u00020.H\u0002R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0005j\b\u0012\u0004\u0012\u00020\u0012`\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0005j\b\u0012\u0004\u0012\u00020\u0015`\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u0005j\b\u0012\u0004\u0012\u00020\u001f`\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u00020(8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006K"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryMethodActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/BottomSheetCallback;", "()V", "branchCodeList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "branchNameList", "companyName", "deliverBranchListAdapter", "Lcom/iaai/android/bdt/feature/account/salesdocument/manageBranchPref/DeliveryBranchListAdapter;", "deliveryMode", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryMethod;", "isAccountValid", "", "isFromBranchList", "mailAddressInfo", "Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/MailAddres;", "ownerName", "representativeInfo", "Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/RepresentativeInfo;", "representativeName", "selectedSalvageSaleIds", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "stockList", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/defaultResponse/TitleInstructionItem;", "titleInstructionTypeCode", "viewModel", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryMethodViewModel;", "getViewModel", "()Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryMethodViewModel;", "setViewModel", "(Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryMethodViewModel;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "addRepresentativeSuccess", "", "deliveryMethod", "checkNetworkConnection", "getAuthString", "getDeliveryMethods", "getIntentData", "getRequestBody", "Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/GetDeliveryMethodRequest;", "getRequestBodyForBranchList", "getRequestBodyForSave", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/SaveDeliveryRequest;", "titleHandlingInstructionCode", "mailAddress", "getStringForAllBranches", "handlePickUpFedExClick", "initializeBranchUI", "initializeOptionsUI", "initializeUI", "isRadioButtonSelectedForFedEx", "isRadioButtonSelectedForPickUp", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showLoadingIndicator", "loading", "subscribeToViewModel", "updateApplyDeliverMethodButton", "isEnable", "updateUI", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryMethodActivity.kt */
public final class DeliveryMethodActivity extends AppCompatActivity implements BottomSheetCallback {
    private HashMap _$_findViewCache;
    private ArrayList<String> branchCodeList = new ArrayList<>();
    private ArrayList<String> branchNameList = new ArrayList<>();
    private String companyName = "";
    private DeliveryBranchListAdapter deliverBranchListAdapter;
    /* access modifiers changed from: private */
    public DeliveryMethod deliveryMode = DeliveryMethod.NONE;
    /* access modifiers changed from: private */
    public boolean isAccountValid;
    private boolean isFromBranchList;
    /* access modifiers changed from: private */
    public ArrayList<MailAddres> mailAddressInfo = new ArrayList<>();
    private String ownerName = "";
    /* access modifiers changed from: private */
    public ArrayList<RepresentativeInfo> representativeInfo = new ArrayList<>();
    private String representativeName = "";
    private ArrayList<String> selectedSalvageSaleIds = new ArrayList<>();
    @Inject
    @NotNull
    public SessionManager sessionManager;
    private ArrayList<TitleInstructionItem> stockList = new ArrayList<>();
    /* access modifiers changed from: private */
    public String titleInstructionTypeCode;
    @NotNull
    public DeliveryMethodViewModel viewModel;
    @Inject
    @NotNull
    public ViewModelProvider.Factory viewModelFactory;

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[DeliveryMethod.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = new int[DeliveryMethod.values().length];

        static {
            $EnumSwitchMapping$0[DeliveryMethod.PICK_UP.ordinal()] = 1;
            $EnumSwitchMapping$0[DeliveryMethod.FED_EX.ordinal()] = 2;
            $EnumSwitchMapping$0[DeliveryMethod.NONE.ordinal()] = 3;
            $EnumSwitchMapping$1[DeliveryMethod.PICK_UP.ordinal()] = 1;
            $EnumSwitchMapping$1[DeliveryMethod.FED_EX.ordinal()] = 2;
            $EnumSwitchMapping$1[DeliveryMethod.NONE.ordinal()] = 3;
        }
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
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
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

    @NotNull
    public final DeliveryMethodViewModel getViewModel() {
        DeliveryMethodViewModel deliveryMethodViewModel = this.viewModel;
        if (deliveryMethodViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return deliveryMethodViewModel;
    }

    public final void setViewModel(@NotNull DeliveryMethodViewModel deliveryMethodViewModel) {
        Intrinsics.checkParameterIsNotNull(deliveryMethodViewModel, "<set-?>");
        this.viewModel = deliveryMethodViewModel;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_document_method);
        FragmentActivity fragmentActivity = this;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(DeliveryMethodViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…hodViewModel::class.java)");
        this.viewModel = (DeliveryMethodViewModel) viewModel2;
        this.deliverBranchListAdapter = new DeliveryBranchListAdapter(this);
        getIntentData();
        initializeUI();
        initializeBranchUI();
        checkNetworkConnection();
        subscribeToViewModel();
    }

    private final void initializeBranchUI() {
        DeliveryBranchListAdapter deliveryBranchListAdapter = this.deliverBranchListAdapter;
        if (deliveryBranchListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deliverBranchListAdapter");
        }
        deliveryBranchListAdapter.setBranchInfoData(this.stockList);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvBranchList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvBranchList");
        DeliveryBranchListAdapter deliveryBranchListAdapter2 = this.deliverBranchListAdapter;
        if (deliveryBranchListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deliverBranchListAdapter");
        }
        recyclerView.setAdapter(deliveryBranchListAdapter2);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvBranchList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvBranchList");
        Application application = getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "this@DeliveryMethodActivity!!.application");
        recyclerView2.setLayoutManager(new LinearLayoutManager(application.getApplicationContext()));
    }

    private final void getIntentData() {
        Intent intent = getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent, "intent");
        Bundle extras = intent.getExtras();
        ArrayList<TitleInstructionItem> parcelableArrayList = extras != null ? extras.getParcelableArrayList(Constants_MVVM.EXTRA_SELECTED_LIST) : null;
        if (parcelableArrayList != null) {
            this.stockList = parcelableArrayList;
            Intent intent2 = getIntent();
            Intrinsics.checkExpressionValueIsNotNull(intent2, "intent");
            Bundle extras2 = intent2.getExtras();
            this.isFromBranchList = extras2 != null ? extras2.getBoolean(Constants_MVVM.EXTRA_IS_FROM_BRANCH_LIST) : false;
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.iaai.android.bdt.model.toBePaid.saleDocument.defaultResponse.TitleInstructionItem> /* = java.util.ArrayList<com.iaai.android.bdt.model.toBePaid.saleDocument.defaultResponse.TitleInstructionItem> */");
    }

    private final void initializeUI() {
        DeliveryMethod deliveryMethod;
        String titleDeliveryMethodCode;
        String titleDeliveryMethodCode2;
        String titleDeliveryMethodCode3;
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.ivClose)).setOnClickListener(new DeliveryMethodActivity$initializeUI$1(this));
        boolean z = false;
        if (this.isFromBranchList) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llBranchList);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llBranchList");
            linearLayout.setVisibility(0);
            View _$_findCachedViewById = _$_findCachedViewById(C2723R.C2726id.viewSeparator);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "viewSeparator");
            _$_findCachedViewById.setVisibility(0);
            if (this.stockList.size() == 1) {
                this.titleInstructionTypeCode = this.stockList.get(0).getTitleDeliveryMethodCode();
                String companyName2 = this.stockList.get(0).getCompanyName();
                if (companyName2 == null) {
                    companyName2 = "";
                }
                this.companyName = companyName2;
                String representativeName2 = this.stockList.get(0).getRepresentativeName();
                if (representativeName2 == null) {
                    representativeName2 = "";
                }
                this.representativeName = representativeName2;
            }
        } else {
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llBranchList);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "llBranchList");
            linearLayout2.setVisibility(8);
            View _$_findCachedViewById2 = _$_findCachedViewById(C2723R.C2726id.viewSeparator);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, "viewSeparator");
            _$_findCachedViewById2.setVisibility(8);
        }
        ((Button) _$_findCachedViewById(C2723R.C2726id.btnApply)).setOnClickListener(new DeliveryMethodActivity$initializeUI$2(this));
        ((LinearLayout) _$_findCachedViewById(C2723R.C2726id.llSetForAll)).setOnClickListener(new DeliveryMethodActivity$initializeUI$3(this));
        if (this.stockList.size() == 1) {
            String titleDeliveryMethodCode4 = this.stockList.get(0).getTitleDeliveryMethodCode();
            if ((titleDeliveryMethodCode4 == null || !titleDeliveryMethodCode4.equals("OPU")) && ((titleDeliveryMethodCode2 = this.stockList.get(0).getTitleDeliveryMethodCode()) == null || !titleDeliveryMethodCode2.equals("RPU"))) {
                String titleDeliveryMethodCode5 = this.stockList.get(0).getTitleDeliveryMethodCode();
                if ((titleDeliveryMethodCode5 == null || !titleDeliveryMethodCode5.equals("IFA")) && ((titleDeliveryMethodCode3 = this.stockList.get(0).getTitleDeliveryMethodCode()) == null || !titleDeliveryMethodCode3.equals("BFA"))) {
                    deliveryMethod = DeliveryMethod.NONE;
                } else {
                    deliveryMethod = DeliveryMethod.FED_EX;
                }
            } else {
                deliveryMethod = DeliveryMethod.PICK_UP;
            }
        } else {
            deliveryMethod = DeliveryMethod.NONE;
        }
        this.deliveryMode = deliveryMethod;
        if (this.stockList.size() == 1 && (titleDeliveryMethodCode = this.stockList.get(0).getTitleDeliveryMethodCode()) != null && titleDeliveryMethodCode.equals("BFA")) {
            CharSequence fedexAccountNumber = this.stockList.get(0).getFedexAccountNumber();
            if (!(fedexAccountNumber == null || fedexAccountNumber.length() == 0) && !StringsKt.equals(this.stockList.get(0).getFedexAccountNumber(), "null", true)) {
                ((EditText) _$_findCachedViewById(C2723R.C2726id.etFedexAccountNo)).setText(this.stockList.get(0).getFedexAccountNumber());
            }
            TitleInstructionItem titleInstructionItem = this.stockList.get(0);
            CharSequence fedexAccountNumber2 = titleInstructionItem != null ? titleInstructionItem.getFedexAccountNumber() : null;
            if (fedexAccountNumber2 == null || fedexAccountNumber2.length() == 0) {
                z = true;
            }
            this.isAccountValid = !z;
        }
        EditText editText = (EditText) _$_findCachedViewById(C2723R.C2726id.etAddNotes);
        Intrinsics.checkExpressionValueIsNotNull(editText, "etAddNotes");
        editText.setOnFocusChangeListener(new DeliveryMethodActivity$initializeUI$4(this));
    }

    /* access modifiers changed from: private */
    public final void getDeliveryMethods() {
        showLoadingIndicator(true);
        if (this.isFromBranchList) {
            DeliveryMethodViewModel deliveryMethodViewModel = this.viewModel;
            if (deliveryMethodViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            deliveryMethodViewModel.getDeliveryMethods(getAuthString(), "android", getRequestBodyForBranchList());
            return;
        }
        DeliveryMethodViewModel deliveryMethodViewModel2 = this.viewModel;
        if (deliveryMethodViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        deliveryMethodViewModel2.getDeliveryMethods(getAuthString(), "android", getRequestBody());
    }

    private final void subscribeToViewModel() {
        DeliveryMethodViewModel deliveryMethodViewModel = this.viewModel;
        if (deliveryMethodViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        deliveryMethodViewModel.getGetDeliveryMethodResponse().observe(lifecycleOwner, new DeliveryMethodActivity$subscribeToViewModel$1(this));
        DeliveryMethodViewModel deliveryMethodViewModel2 = this.viewModel;
        if (deliveryMethodViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        deliveryMethodViewModel2.getGetDeliveryMethodError().observe(lifecycleOwner, new DeliveryMethodActivity$subscribeToViewModel$2(this));
        DeliveryMethodViewModel deliveryMethodViewModel3 = this.viewModel;
        if (deliveryMethodViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        deliveryMethodViewModel3.getSaveDeliveryMethodResponse().observe(lifecycleOwner, new DeliveryMethodActivity$subscribeToViewModel$3(this));
        DeliveryMethodViewModel deliveryMethodViewModel4 = this.viewModel;
        if (deliveryMethodViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        deliveryMethodViewModel4.getSaveDeliveryMethodError().observe(lifecycleOwner, new DeliveryMethodActivity$subscribeToViewModel$4(this));
    }

    private final void checkNetworkConnection() {
        if (InternetUtil.INSTANCE.isInternetOn()) {
            getDeliveryMethods();
        } else {
            InternetUtil.INSTANCE.observe(this, new DeliveryMethodActivity$checkNetworkConnection$1(this));
        }
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

    private final GetDeliveryMethodRequest getRequestBody() {
        String str;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.selectedSalvageSaleIds.clear();
        Iterator it = this.stockList.iterator();
        while (true) {
            str = "";
            if (!it.hasNext()) {
                break;
            }
            TitleInstructionItem titleInstructionItem = (TitleInstructionItem) it.next();
            String ownerName2 = titleInstructionItem.getOwnerName();
            if (ownerName2 != null) {
                str = ownerName2;
            }
            this.ownerName = str;
            this.selectedSalvageSaleIds.add(String.valueOf(titleInstructionItem.getSalvageSaleID()));
            arrayList.add(titleInstructionItem.getBranchName());
            arrayList2.add(String.valueOf(titleInstructionItem.getBranchCode()));
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList3 = new ArrayList();
        for (Object next : arrayList2) {
            if (hashSet.add((String) next)) {
                arrayList3.add(next);
            }
        }
        this.branchCodeList = new ArrayList<>(arrayList3);
        HashSet hashSet2 = new HashSet();
        ArrayList arrayList4 = new ArrayList();
        for (Object next2 : arrayList) {
            if (hashSet2.add((String) next2)) {
                arrayList4.add(next2);
            }
        }
        this.branchNameList = new ArrayList<>(arrayList4);
        return new GetDeliveryMethodRequest(str, this.selectedSalvageSaleIds);
    }

    private final GetDeliveryMethodRequest getRequestBodyForBranchList() {
        String str;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.selectedSalvageSaleIds.clear();
        Iterator it = this.stockList.iterator();
        while (true) {
            str = "";
            if (!it.hasNext()) {
                break;
            }
            TitleInstructionItem titleInstructionItem = (TitleInstructionItem) it.next();
            String ownerName2 = titleInstructionItem.getOwnerName();
            if (ownerName2 != null) {
                str = ownerName2;
            }
            this.ownerName = str;
            arrayList.add(titleInstructionItem.getBranchName());
            arrayList2.add(String.valueOf(titleInstructionItem.getBranchCode()));
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList3 = new ArrayList();
        for (Object next : arrayList2) {
            if (hashSet.add((String) next)) {
                arrayList3.add(next);
            }
        }
        this.branchCodeList = new ArrayList<>(arrayList3);
        HashSet hashSet2 = new HashSet();
        ArrayList arrayList4 = new ArrayList();
        for (Object next2 : arrayList) {
            if (hashSet2.add((String) next2)) {
                arrayList4.add(next2);
            }
        }
        this.branchNameList = new ArrayList<>(arrayList4);
        return new GetDeliveryMethodRequest(str, CollectionsKt.emptyList());
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbGetDelivery);
            Intrinsics.checkExpressionValueIsNotNull(progressBar, "pbGetDelivery");
            progressBar.setVisibility(0);
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbGetDelivery);
        Intrinsics.checkExpressionValueIsNotNull(progressBar2, "pbGetDelivery");
        progressBar2.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void handlePickUpFedExClick() {
        ((Button) _$_findCachedViewById(C2723R.C2726id.btnPickUp)).setOnClickListener(new DeliveryMethodActivity$handlePickUpFedExClick$1(this));
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.btnFedEx)).setOnClickListener(new DeliveryMethodActivity$handlePickUpFedExClick$2(this));
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tvAddRep)).setOnClickListener(new DeliveryMethodActivity$handlePickUpFedExClick$3(this));
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tvAddAddress)).setOnClickListener(new DeliveryMethodActivity$handlePickUpFedExClick$4(this));
    }

    /* access modifiers changed from: private */
    public final String getStringForAllBranches() {
        String str = this.branchNameList.get(0);
        Intrinsics.checkExpressionValueIsNotNull(str, "branchNameList[0]");
        String str2 = str;
        for (int i = 1; i < this.branchNameList.size() - 1; i++) {
            str2 = str2 + ", " + this.branchNameList.get(i);
        }
        if (this.branchNameList.size() <= 1) {
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(getResources().getString(C2723R.string.lbl_and));
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        ArrayList<String> arrayList = this.branchNameList;
        sb.append(arrayList.get(arrayList.size() - 1));
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public final SaveDeliveryRequest getRequestBodyForSave(String str, RepresentativeInfo representativeInfo2, MailAddres mailAddres) {
        MailingAddressInfo mailingAddressInfo;
        String str2;
        if (mailAddres != null) {
            str2 = mailAddres.getAccountNo();
            mailingAddressInfo = new MailingAddressInfo(mailAddres.getAccountNo(), mailAddres.getAddress(), mailAddres.getBusinessName(), mailAddres.getIsSelected(), mailAddres.getPhone(), mailAddres.getUseMailingInd());
        } else {
            mailingAddressInfo = null;
            str2 = "";
        }
        String str3 = str2;
        MailingAddressInfo mailingAddressInfo2 = mailingAddressInfo;
        ImageView imageView = (ImageView) _$_findCachedViewById(C2723R.C2726id.ivSetForAll);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "ivSetForAll");
        if (imageView.isSelected()) {
            EditText editText = (EditText) _$_findCachedViewById(C2723R.C2726id.etAddNotes);
            Intrinsics.checkExpressionValueIsNotNull(editText, "etAddNotes");
            return new SaveDeliveryRequest(this.branchCodeList, this.selectedSalvageSaleIds, str3, editText.getText().toString(), mailingAddressInfo2, "continuetopayment", representativeInfo2, str);
        } else if (this.isFromBranchList) {
            EditText editText2 = (EditText) _$_findCachedViewById(C2723R.C2726id.etAddNotes);
            Intrinsics.checkExpressionValueIsNotNull(editText2, "etAddNotes");
            return new SaveDeliveryRequest(this.branchCodeList, this.selectedSalvageSaleIds, str3, editText2.getText().toString(), mailingAddressInfo2, "continuetopayment", representativeInfo2, str);
        } else {
            EditText editText3 = (EditText) _$_findCachedViewById(C2723R.C2726id.etAddNotes);
            Intrinsics.checkExpressionValueIsNotNull(editText3, "etAddNotes");
            return new SaveDeliveryRequest(CollectionsKt.emptyList(), this.selectedSalvageSaleIds, str3, editText3.getText().toString(), mailingAddressInfo2, "continuetopayment", representativeInfo2, str);
        }
    }

    /* access modifiers changed from: private */
    public final void updateUI() {
        int i = WhenMappings.$EnumSwitchMapping$1[this.deliveryMode.ordinal()];
        if (i == 1) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llPickUp);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llPickUp");
            linearLayout.setVisibility(0);
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.rlFedEx);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "rlFedEx");
            linearLayout2.setVisibility(8);
            LinearLayout linearLayout3 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llAdditionalNotes);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout3, "llAdditionalNotes");
            linearLayout3.setVisibility(0);
            if (this.isFromBranchList) {
                LinearLayout linearLayout4 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llSetForAll);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout4, "llSetForAll");
                linearLayout4.setVisibility(8);
            } else {
                LinearLayout linearLayout5 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llSetForAll);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout5, "llSetForAll");
                linearLayout5.setVisibility(0);
            }
            Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btnApply);
            Intrinsics.checkExpressionValueIsNotNull(button, "btnApply");
            button.setAlpha(1.0f);
            Button button2 = (Button) _$_findCachedViewById(C2723R.C2726id.btnApply);
            Intrinsics.checkExpressionValueIsNotNull(button2, "btnApply");
            button2.setClickable(true);
            Button button3 = (Button) _$_findCachedViewById(C2723R.C2726id.btnPickUp);
            Intrinsics.checkExpressionValueIsNotNull(button3, "btnPickUp");
            button3.setSelected(true);
            ImageButton imageButton = (ImageButton) _$_findCachedViewById(C2723R.C2726id.btnFedEx);
            Intrinsics.checkExpressionValueIsNotNull(imageButton, "btnFedEx");
            imageButton.setSelected(false);
            isRadioButtonSelectedForPickUp();
            ((RadioGroup) _$_findCachedViewById(C2723R.C2726id.rgPickUp)).setOnCheckedChangeListener(new DeliveryMethodActivity$updateUI$1(this));
        } else if (i == 2) {
            LinearLayout linearLayout6 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.rlFedEx);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout6, "rlFedEx");
            linearLayout6.setVisibility(0);
            LinearLayout linearLayout7 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llPickUp);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout7, "llPickUp");
            linearLayout7.setVisibility(8);
            LinearLayout linearLayout8 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llAdditionalNotes);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout8, "llAdditionalNotes");
            linearLayout8.setVisibility(0);
            if (this.isFromBranchList) {
                LinearLayout linearLayout9 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llSetForAll);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout9, "llSetForAll");
                linearLayout9.setVisibility(8);
            } else {
                LinearLayout linearLayout10 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llSetForAll);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout10, "llSetForAll");
                linearLayout10.setVisibility(0);
            }
            Button button4 = (Button) _$_findCachedViewById(C2723R.C2726id.btnApply);
            Intrinsics.checkExpressionValueIsNotNull(button4, "btnApply");
            button4.setAlpha(1.0f);
            Button button5 = (Button) _$_findCachedViewById(C2723R.C2726id.btnApply);
            Intrinsics.checkExpressionValueIsNotNull(button5, "btnApply");
            button5.setClickable(true);
            Button button6 = (Button) _$_findCachedViewById(C2723R.C2726id.btnPickUp);
            Intrinsics.checkExpressionValueIsNotNull(button6, "btnPickUp");
            button6.setSelected(false);
            ImageButton imageButton2 = (ImageButton) _$_findCachedViewById(C2723R.C2726id.btnFedEx);
            Intrinsics.checkExpressionValueIsNotNull(imageButton2, "btnFedEx");
            imageButton2.setSelected(true);
            ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{16842912}}, new int[]{Color.parseColor("#cccccc"), Color.parseColor("#238723")});
            RadioButton radioButton = (RadioButton) _$_findCachedViewById(C2723R.C2726id.rbBFA);
            Intrinsics.checkExpressionValueIsNotNull(radioButton, "rbBFA");
            radioButton.setButtonTintList(colorStateList);
            RadioButton radioButton2 = (RadioButton) _$_findCachedViewById(C2723R.C2726id.rbIFA);
            Intrinsics.checkExpressionValueIsNotNull(radioButton2, "rbIFA");
            radioButton2.setButtonTintList(colorStateList);
            ((RadioButton) _$_findCachedViewById(C2723R.C2726id.rbBFA)).setOnCheckedChangeListener(new DeliveryMethodActivity$updateUI$2(this));
            ((RadioGroup) _$_findCachedViewById(C2723R.C2726id.rgContainer)).setOnCheckedChangeListener(new DeliveryMethodActivity$updateUI$3(this));
            EditText editText = (EditText) _$_findCachedViewById(C2723R.C2726id.etFedexAccountNo);
            Intrinsics.checkExpressionValueIsNotNull(editText, "etFedexAccountNo");
            EditText_ExtensionKt.onChange(editText, new DeliveryMethodActivity$updateUI$4(this));
            String str = this.titleInstructionTypeCode;
            if (str != null && str.equals("IFA")) {
                RadioButton radioButton3 = (RadioButton) _$_findCachedViewById(C2723R.C2726id.rbIFA);
                Intrinsics.checkExpressionValueIsNotNull(radioButton3, "rbIFA");
                radioButton3.setChecked(true);
            }
            String str2 = this.titleInstructionTypeCode;
            if (str2 != null && str2.equals("BFA")) {
                RadioButton radioButton4 = (RadioButton) _$_findCachedViewById(C2723R.C2726id.rbBFA);
                Intrinsics.checkExpressionValueIsNotNull(radioButton4, "rbBFA");
                radioButton4.setChecked(true);
            }
            isRadioButtonSelectedForFedEx();
            ((RadioGroup) _$_findCachedViewById(C2723R.C2726id.rgFedEx)).setOnCheckedChangeListener(new DeliveryMethodActivity$updateUI$5(this));
        } else if (i == 3) {
            LinearLayout linearLayout11 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.rlFedEx);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout11, "rlFedEx");
            linearLayout11.setVisibility(8);
            LinearLayout linearLayout12 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llPickUp);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout12, "llPickUp");
            linearLayout12.setVisibility(8);
            LinearLayout linearLayout13 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llAdditionalNotes);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout13, "llAdditionalNotes");
            linearLayout13.setVisibility(8);
            LinearLayout linearLayout14 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llSetForAll);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout14, "llSetForAll");
            linearLayout14.setVisibility(8);
            Button button7 = (Button) _$_findCachedViewById(C2723R.C2726id.btnApply);
            Intrinsics.checkExpressionValueIsNotNull(button7, "btnApply");
            button7.setAlpha(0.5f);
            Button button8 = (Button) _$_findCachedViewById(C2723R.C2726id.btnApply);
            Intrinsics.checkExpressionValueIsNotNull(button8, "btnApply");
            button8.setClickable(false);
            Button button9 = (Button) _$_findCachedViewById(C2723R.C2726id.btnPickUp);
            Intrinsics.checkExpressionValueIsNotNull(button9, "btnPickUp");
            button9.setSelected(false);
            ImageButton imageButton3 = (ImageButton) _$_findCachedViewById(C2723R.C2726id.btnFedEx);
            Intrinsics.checkExpressionValueIsNotNull(imageButton3, "btnFedEx");
            imageButton3.setSelected(false);
        }
    }

    /* access modifiers changed from: private */
    public final void isRadioButtonSelectedForPickUp() {
        RadioGroup radioGroup = (RadioGroup) _$_findCachedViewById(C2723R.C2726id.rgPickUp);
        Intrinsics.checkExpressionValueIsNotNull(radioGroup, "rgPickUp");
        if (radioGroup.getCheckedRadioButtonId() != -1) {
            updateApplyDeliverMethodButton(true);
        } else {
            updateApplyDeliverMethodButton(false);
        }
    }

    /* access modifiers changed from: private */
    public final void isRadioButtonSelectedForFedEx() {
        RadioGroup radioGroup = (RadioGroup) _$_findCachedViewById(C2723R.C2726id.rgFedEx);
        Intrinsics.checkExpressionValueIsNotNull(radioGroup, "rgFedEx");
        if (radioGroup.getCheckedRadioButtonId() != -1) {
            RadioGroup radioGroup2 = (RadioGroup) _$_findCachedViewById(C2723R.C2726id.rgContainer);
            Intrinsics.checkExpressionValueIsNotNull(radioGroup2, "rgContainer");
            if (radioGroup2.getCheckedRadioButtonId() != -1) {
                RadioGroup radioGroup3 = (RadioGroup) _$_findCachedViewById(C2723R.C2726id.rgContainer);
                Intrinsics.checkExpressionValueIsNotNull(radioGroup3, "rgContainer");
                switch (radioGroup3.getCheckedRadioButtonId()) {
                    case C2723R.C2726id.rbBFA:
                        if (this.isAccountValid) {
                            updateApplyDeliverMethodButton(true);
                            return;
                        } else {
                            updateApplyDeliverMethodButton(false);
                            return;
                        }
                    case C2723R.C2726id.rbIFA:
                        updateApplyDeliverMethodButton(true);
                        return;
                    default:
                        return;
                }
            }
        }
        updateApplyDeliverMethodButton(false);
    }

    /* access modifiers changed from: private */
    public final void updateApplyDeliverMethodButton(boolean z) {
        if (z) {
            Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btnApply);
            Intrinsics.checkExpressionValueIsNotNull(button, "btnApply");
            button.setEnabled(true);
            Button button2 = (Button) _$_findCachedViewById(C2723R.C2726id.btnApply);
            Intrinsics.checkExpressionValueIsNotNull(button2, "btnApply");
            button2.setAlpha(1.0f);
            return;
        }
        Button button3 = (Button) _$_findCachedViewById(C2723R.C2726id.btnApply);
        Intrinsics.checkExpressionValueIsNotNull(button3, "btnApply");
        button3.setEnabled(false);
        Button button4 = (Button) _$_findCachedViewById(C2723R.C2726id.btnApply);
        Intrinsics.checkExpressionValueIsNotNull(button4, "btnApply");
        button4.setAlpha(0.5f);
    }

    /* access modifiers changed from: private */
    public final void initializeOptionsUI() {
        BDTUtils bDTUtils = BDTUtils.INSTANCE;
        Context context = this;
        int i = 0;
        RadioButton radioButton = bDTUtils.getRadioButton(context, this.ownerName + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getResources().getString(C2723R.string.lbl_sale_doc_owner), false, 0);
        String str = this.titleInstructionTypeCode;
        radioButton.setChecked(str != null && str.equals("OPU"));
        RadioGroup radioGroup = (RadioGroup) _$_findCachedViewById(C2723R.C2726id.rgPickUp);
        Intrinsics.checkExpressionValueIsNotNull(radioGroup, "rgPickUp");
        radioGroup.setVisibility(0);
        ((RadioGroup) _$_findCachedViewById(C2723R.C2726id.rgPickUp)).removeAllViews();
        ((RadioGroup) _$_findCachedViewById(C2723R.C2726id.rgPickUp)).addView(radioButton);
        int i2 = 0;
        for (Object next : this.representativeInfo) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            RepresentativeInfo representativeInfo2 = (RepresentativeInfo) next;
            RadioButton radioButton2 = BDTUtils.INSTANCE.getRadioButton(context, representativeInfo2.getRepresentativeName(), false, i3);
            String str2 = this.titleInstructionTypeCode;
            if (str2 != null && str2.equals("RPU")) {
                if (this.isFromBranchList && Intrinsics.areEqual((Object) representativeInfo2.getRepresentativeName(), (Object) this.representativeName)) {
                    representativeInfo2.setIsSelected(true);
                }
                radioButton2.setChecked(representativeInfo2.getIsSelected());
            }
            ((RadioGroup) _$_findCachedViewById(C2723R.C2726id.rgPickUp)).addView(radioButton2);
            i2 = i3;
        }
        if (this.mailAddressInfo.size() > 0) {
            RadioGroup radioGroup2 = (RadioGroup) _$_findCachedViewById(C2723R.C2726id.rgFedEx);
            Intrinsics.checkExpressionValueIsNotNull(radioGroup2, "rgFedEx");
            radioGroup2.setVisibility(0);
        }
        ((RadioGroup) _$_findCachedViewById(C2723R.C2726id.rgFedEx)).removeAllViews();
        for (Object next2 : this.mailAddressInfo) {
            int i4 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            MailAddres mailAddres = (MailAddres) next2;
            RadioButton radioButton3 = BDTUtils.INSTANCE.getRadioButton(context, BDTUtils.INSTANCE.getAddress(mailAddres.getAddress(), mailAddres.getBusinessName()), true, i4);
            if (this.isFromBranchList && Intrinsics.areEqual((Object) mailAddres.getBusinessName(), (Object) this.companyName)) {
                mailAddres.setIsSelected(true);
            }
            radioButton3.setChecked(mailAddres.getIsSelected());
            ((RadioGroup) _$_findCachedViewById(C2723R.C2726id.rgFedEx)).addView(radioButton3);
            i = i4;
        }
    }

    public void addRepresentativeSuccess(@NotNull DeliveryMethod deliveryMethod) {
        Intrinsics.checkParameterIsNotNull(deliveryMethod, "deliveryMethod");
        this.deliveryMode = deliveryMethod;
        checkNetworkConnection();
    }
}
