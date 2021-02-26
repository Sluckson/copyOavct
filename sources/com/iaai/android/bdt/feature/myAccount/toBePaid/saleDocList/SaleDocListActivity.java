package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.BuildConfig;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue;
import com.iaai.android.bdt.model.toBePaid.saleDocument.GetSaleDocListRequest;
import com.iaai.android.bdt.model.toBePaid.saleDocument.RowModelForSetSaleDoc;
import com.iaai.android.bdt.model.toBePaid.saleDocument.defaultResponse.TitleInstructionItem;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.InternetUtil;
import com.iaai.android.old.utils.AppUtils;
import dagger.android.AndroidInjection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010/\u001a\u000200H\u0002J\u0016\u00101\u001a\b\u0012\u0004\u0012\u000203022\u0006\u00104\u001a\u000205H\u0002J\u0016\u00106\u001a\u0002002\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000508H\u0002J\b\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u000200H\u0002J\b\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u000200H\u0002J\b\u0010?\u001a\u000200H\u0002J\b\u0010@\u001a\u000200H\u0002J\b\u0010A\u001a\u000200H\u0002J\"\u0010B\u001a\u0002002\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020D2\b\u0010F\u001a\u0004\u0018\u00010GH\u0014J\u0012\u0010H\u001a\u0002002\b\u0010I\u001a\u0004\u0018\u00010JH\u0014J\u0010\u0010K\u001a\u0002052\u0006\u0010L\u001a\u00020MH\u0016J\u0010\u0010N\u001a\u0002002\u0006\u0010O\u001a\u000205H\u0002J\b\u0010P\u001a\u000200H\u0002J\b\u0010Q\u001a\u000200H\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0004j\b\u0012\u0004\u0012\u00020\n`\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001bX.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020$X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020*8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006R"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/SaleDocListActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "()V", "notSetList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/defaultResponse/TitleInstructionItem;", "Lkotlin/collections/ArrayList;", "notSetSaleDocAdapter", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/NotSetSaleDocAdapter;", "selectedItemList", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "setList", "setSaleDocAdapter", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/SetSaleDocAdapter;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "toolbar_sub_title", "Landroid/widget/TextView;", "getToolbar_sub_title", "()Landroid/widget/TextView;", "setToolbar_sub_title", "(Landroid/widget/TextView;)V", "toolbar_title", "getToolbar_title", "setToolbar_title", "viewModel", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/SaleDocListViewModel;", "getViewModel", "()Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/SaleDocListViewModel;", "setViewModel", "(Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/SaleDocListViewModel;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "checkNetworkConnection", "", "createSetSaleDocData", "", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/RowModelForSetSaleDoc;", "isSet", "", "filterResponse", "titleInstructionItemList", "", "getAuthString", "", "getIntentData", "getRequestBody", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/GetSaleDocListRequest;", "getSaleDocList", "initializeRecycler", "initializeToolBar", "initializeUI", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "showLoadingIndicator", "loading", "subscribeToViewModel", "updateRecyclerUI", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SaleDocListActivity.kt */
public final class SaleDocListActivity extends BaseActivity {
    private HashMap _$_findViewCache;
    private ArrayList<TitleInstructionItem> notSetList = new ArrayList<>();
    private NotSetSaleDocAdapter notSetSaleDocAdapter;
    private ArrayList<PaymentDue> selectedItemList = new ArrayList<>();
    @Inject
    @NotNull
    public SessionManager sessionManager;
    private ArrayList<TitleInstructionItem> setList = new ArrayList<>();
    private SetSaleDocAdapter setSaleDocAdapter;
    @NotNull
    public Toolbar toolbar;
    @NotNull
    public TextView toolbar_sub_title;
    @NotNull
    public TextView toolbar_title;
    @NotNull
    public SaleDocListViewModel viewModel;
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
    public final SaleDocListViewModel getViewModel() {
        SaleDocListViewModel saleDocListViewModel = this.viewModel;
        if (saleDocListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return saleDocListViewModel;
    }

    public final void setViewModel(@NotNull SaleDocListViewModel saleDocListViewModel) {
        Intrinsics.checkParameterIsNotNull(saleDocListViewModel, "<set-?>");
        this.viewModel = saleDocListViewModel;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        AndroidInjection.inject((Activity) this);
        setContentView((int) C2723R.C2728layout.activity_sale_doc_list);
        FragmentActivity fragmentActivity = this;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(SaleDocListViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…istViewModel::class.java)");
        this.viewModel = (SaleDocListViewModel) viewModel2;
        getIntentData();
        initializeUI();
        checkNetworkConnection();
        subscribeToViewModel();
    }

    private final void getIntentData() {
        Intent intent = getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent, "intent");
        Bundle extras = intent.getExtras();
        ArrayList<PaymentDue> parcelableArrayList = extras != null ? extras.getParcelableArrayList(Constants_MVVM.EXTRA_SELECTED_LIST) : null;
        if (parcelableArrayList != null) {
            this.selectedItemList = parcelableArrayList;
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue> /* = java.util.ArrayList<com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue> */");
    }

    private final void initializeUI() {
        initializeToolBar();
        initializeRecycler();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    private final void initializeToolBar() {
        View findViewById = findViewById(C2723R.C2726id.toolbar);
        if (findViewById != null) {
            this.toolbar = (Toolbar) findViewById;
            View findViewById2 = findViewById(C2723R.C2726id.toolbar_title);
            if (findViewById2 != null) {
                this.toolbar_title = (TextView) findViewById2;
                View findViewById3 = findViewById(C2723R.C2726id.toolbar_sub_title);
                if (findViewById3 != null) {
                    this.toolbar_sub_title = (TextView) findViewById3;
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
                    textView.setText(getResources().getString(C2723R.string.lbl_set_document_delivery_method));
                    TextView textView2 = this.toolbar_sub_title;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("toolbar_sub_title");
                    }
                    textView2.setVisibility(8);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
    }

    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    /* access modifiers changed from: private */
    public final void getSaleDocList() {
        showLoadingIndicator(true);
        SaleDocListViewModel saleDocListViewModel = this.viewModel;
        if (saleDocListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        String authString = getAuthString();
        String deviceId = AppUtils.getDeviceId(this);
        Intrinsics.checkExpressionValueIsNotNull(deviceId, "AppUtils.getDeviceId(this)");
        saleDocListViewModel.getSaleDocList(authString, deviceId, "android", String.valueOf(BuildConfig.VERSION_CODE), getRequestBody());
    }

    private final void subscribeToViewModel() {
        SaleDocListViewModel saleDocListViewModel = this.viewModel;
        if (saleDocListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        saleDocListViewModel.getGetSaleDocListResponse().observe(lifecycleOwner, new SaleDocListActivity$subscribeToViewModel$1(this));
        SaleDocListViewModel saleDocListViewModel2 = this.viewModel;
        if (saleDocListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        saleDocListViewModel2.getGetSaleDocListGroupError().observe(lifecycleOwner, new SaleDocListActivity$subscribeToViewModel$2(this));
    }

    private final void initializeRecycler() {
        Context context = this;
        this.setSaleDocAdapter = new SetSaleDocAdapter(context);
        this.notSetSaleDocAdapter = new NotSetSaleDocAdapter(context);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvSetInstructions);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvSetInstructions");
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvSetInstructions);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvSetInstructions");
        SetSaleDocAdapter setSaleDocAdapter2 = this.setSaleDocAdapter;
        if (setSaleDocAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("setSaleDocAdapter");
        }
        recyclerView2.setAdapter(setSaleDocAdapter2);
        RecyclerView recyclerView3 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvNotSetInstructions);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView3, "rvNotSetInstructions");
        recyclerView3.setLayoutManager(new LinearLayoutManager(context));
        RecyclerView recyclerView4 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvNotSetInstructions);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView4, "rvNotSetInstructions");
        NotSetSaleDocAdapter notSetSaleDocAdapter2 = this.notSetSaleDocAdapter;
        if (notSetSaleDocAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notSetSaleDocAdapter");
        }
        recyclerView4.setAdapter(notSetSaleDocAdapter2);
    }

    private final void checkNetworkConnection() {
        if (InternetUtil.INSTANCE.isInternetOn()) {
            getSaleDocList();
            return;
        }
        displayError(BaseActivity.ErrorType.NO_INTERNET, "");
        InternetUtil.INSTANCE.observe(this, new SaleDocListActivity$checkNetworkConnection$1(this));
    }

    private final String getAuthString() {
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

    private final GetSaleDocListRequest getRequestBody() {
        ArrayList arrayList = new ArrayList();
        for (PaymentDue salvageSaleId : this.selectedItemList) {
            arrayList.add(String.valueOf(salvageSaleId.getSalvageSaleId()));
        }
        return new GetSaleDocListRequest(arrayList, "All", 1, arrayList.size(), "TitleDeliveryMethodCode", true, 0);
    }

    private final List<RowModelForSetSaleDoc> createSetSaleDocData(boolean z) {
        List<RowModelForSetSaleDoc> arrayList = new ArrayList<>();
        if (z) {
            Map linkedHashMap = new LinkedHashMap();
            for (Object next : this.setList) {
                String branchName = ((TitleInstructionItem) next).getBranchName();
                Object obj = linkedHashMap.get(branchName);
                if (obj == null) {
                    obj = new ArrayList();
                    linkedHashMap.put(branchName, obj);
                }
                ((List) obj).add(next);
            }
            for (Map.Entry entry : new LinkedHashMap(linkedHashMap).entrySet()) {
                Object key = entry.getKey();
                Intrinsics.checkExpressionValueIsNotNull(key, "it.key");
                arrayList.add(new RowModelForSetSaleDoc(1, (String) key, false, 4, (DefaultConstructorMarker) null));
                Object value = entry.getValue();
                Intrinsics.checkExpressionValueIsNotNull(value, "it.value");
                for (TitleInstructionItem rowModelForSetSaleDoc : (Iterable) value) {
                    arrayList.add(new RowModelForSetSaleDoc(2, rowModelForSetSaleDoc, false, 4, (DefaultConstructorMarker) null));
                }
            }
        } else {
            Map linkedHashMap2 = new LinkedHashMap();
            for (Object next2 : this.notSetList) {
                String branchName2 = ((TitleInstructionItem) next2).getBranchName();
                Object obj2 = linkedHashMap2.get(branchName2);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap2.put(branchName2, obj2);
                }
                ((List) obj2).add(next2);
            }
            for (Map.Entry entry2 : new LinkedHashMap(linkedHashMap2).entrySet()) {
                Object key2 = entry2.getKey();
                Intrinsics.checkExpressionValueIsNotNull(key2, "it.key");
                arrayList.add(new RowModelForSetSaleDoc(1, (String) key2, false, 4, (DefaultConstructorMarker) null));
                Object value2 = entry2.getValue();
                Intrinsics.checkExpressionValueIsNotNull(value2, "it.value");
                for (TitleInstructionItem rowModelForSetSaleDoc2 : (Iterable) value2) {
                    arrayList.add(new RowModelForSetSaleDoc(2, rowModelForSetSaleDoc2, false, 4, (DefaultConstructorMarker) null));
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final void filterResponse(List<TitleInstructionItem> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (TitleInstructionItem titleInstructionItem : list) {
            if (titleInstructionItem.getTitleDeliveryMethodCode() == null) {
                arrayList2.add(titleInstructionItem);
            } else {
                arrayList.add(titleInstructionItem);
            }
        }
        this.notSetList.clear();
        this.setList.clear();
        this.setList = new ArrayList<>(CollectionsKt.sortedWith(arrayList, new SaleDocListActivity$filterResponse$$inlined$compareBy$1()));
        this.notSetList = new ArrayList<>(CollectionsKt.sortedWith(arrayList2, new SaleDocListActivity$filterResponse$$inlined$compareBy$2()));
    }

    /* access modifiers changed from: private */
    public final void updateRecyclerUI() {
        Collection collection = this.setList;
        if (collection == null || collection.isEmpty()) {
            Collection collection2 = this.notSetList;
            if (collection2 == null || collection2.isEmpty()) {
                LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llSet);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llSet");
                linearLayout.setVisibility(8);
                LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llNotSet);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "llNotSet");
                linearLayout2.setVisibility(8);
                return;
            }
        }
        if (this.setList.size() != 0) {
            LinearLayout linearLayout3 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llSet);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout3, "llSet");
            linearLayout3.setVisibility(0);
            Collection collection3 = this.notSetList;
            if (collection3 == null || collection3.isEmpty()) {
                View _$_findCachedViewById = _$_findCachedViewById(C2723R.C2726id.separatorSet);
                Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "separatorSet");
                _$_findCachedViewById.setVisibility(8);
            } else {
                View _$_findCachedViewById2 = _$_findCachedViewById(C2723R.C2726id.separatorSet);
                Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, "separatorSet");
                _$_findCachedViewById2.setVisibility(0);
            }
            SetSaleDocAdapter setSaleDocAdapter2 = this.setSaleDocAdapter;
            if (setSaleDocAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("setSaleDocAdapter");
            }
            setSaleDocAdapter2.setData(createSetSaleDocData(true));
            SetSaleDocAdapter setSaleDocAdapter3 = this.setSaleDocAdapter;
            if (setSaleDocAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("setSaleDocAdapter");
            }
            setSaleDocAdapter3.notifyDataSetChanged();
        }
        if (this.notSetList.size() != 0) {
            LinearLayout linearLayout4 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llNotSet);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout4, "llNotSet");
            linearLayout4.setVisibility(0);
            NotSetSaleDocAdapter notSetSaleDocAdapter2 = this.notSetSaleDocAdapter;
            if (notSetSaleDocAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notSetSaleDocAdapter");
            }
            notSetSaleDocAdapter2.setData(createSetSaleDocData(false));
            NotSetSaleDocAdapter notSetSaleDocAdapter3 = this.notSetSaleDocAdapter;
            if (notSetSaleDocAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notSetSaleDocAdapter");
            }
            notSetSaleDocAdapter3.notifyDataSetChanged();
            Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btnReviewPayment);
            Intrinsics.checkExpressionValueIsNotNull(button, "btnReviewPayment");
            button.setAlpha(0.5f);
            Button button2 = (Button) _$_findCachedViewById(C2723R.C2726id.btnReviewPayment);
            Intrinsics.checkExpressionValueIsNotNull(button2, "btnReviewPayment");
            button2.setClickable(false);
            return;
        }
        Button button3 = (Button) _$_findCachedViewById(C2723R.C2726id.btnReviewPayment);
        Intrinsics.checkExpressionValueIsNotNull(button3, "btnReviewPayment");
        button3.setAlpha(1.0f);
        Button button4 = (Button) _$_findCachedViewById(C2723R.C2726id.btnReviewPayment);
        Intrinsics.checkExpressionValueIsNotNull(button4, "btnReviewPayment");
        button4.setClickable(true);
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbReviewPayment);
            Intrinsics.checkExpressionValueIsNotNull(progressBar, "pbReviewPayment");
            progressBar.setVisibility(0);
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbReviewPayment);
        Intrinsics.checkExpressionValueIsNotNull(progressBar2, "pbReviewPayment");
        progressBar2.setVisibility(8);
    }
}
