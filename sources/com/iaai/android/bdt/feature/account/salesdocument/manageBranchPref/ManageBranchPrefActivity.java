package com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.extensions.Activity_ExtensionKt;
import com.iaai.android.bdt.feature.account.salesdocument.SaleDocumentViewModel;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.DeliveryMethodActivity;
import com.iaai.android.bdt.model.MyAccount.AddressInfo;
import com.iaai.android.bdt.model.MyAccount.BranchModel;
import com.iaai.android.bdt.model.MyAccount.MBRequestBody;
import com.iaai.android.bdt.model.MyAccount.MailAddressInfo;
import com.iaai.android.bdt.model.MyAccount.ManageBranchModel;
import com.iaai.android.bdt.model.MyAccount.ManageBranchPrefRequestBody;
import com.iaai.android.bdt.model.MyAccount.ManageBranchPrefResponse;
import com.iaai.android.bdt.model.toBePaid.saleDocument.defaultResponse.TitleInstructionItem;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.InternetUtil;
import com.iaai.android.old.utils.AppUtils;
import dagger.android.AndroidInjection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0004H\u0002J\b\u0010?\u001a\u00020=H\u0002J\b\u0010@\u001a\u00020=H\u0002J\u0010\u0010A\u001a\u00020=2\u0006\u0010B\u001a\u00020\u0004H\u0002J\b\u0010C\u001a\u00020DH\u0002J\b\u0010E\u001a\u00020=H\u0002J\b\u0010F\u001a\u00020=H\u0002J\b\u0010G\u001a\u00020=H\u0002J\"\u0010H\u001a\u00020=2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020J2\b\u0010L\u001a\u0004\u0018\u00010\u0016H\u0014J\u0012\u0010M\u001a\u00020=2\b\u0010N\u001a\u0004\u0018\u00010OH\u0014J\u0010\u0010P\u001a\u00020\u00122\u0006\u0010Q\u001a\u00020RH\u0016J\b\u0010S\u001a\u00020=H\u0002J\u0010\u0010T\u001a\u00020=2\u0006\u0010U\u001a\u00020\u0012H\u0002J\b\u0010V\u001a\u00020=H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\"\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020!8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u0012\u0012\u0004\u0012\u00020'0\fj\b\u0012\u0004\u0012\u00020'`\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020)X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u00104\u001a\u000205X.¢\u0006\u0002\n\u0000R\u001e\u00106\u001a\u0002078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006W"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/salesdocument/manageBranchPref/ManageBranchPrefActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "CONTENT_TYPE", "", "getCONTENT_TYPE", "()Ljava/lang/String;", "PAYPAL_API_KEY", "getPAYPAL_API_KEY", "TAG", "kotlin.jvm.PlatformType", "branchList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/MyAccount/BranchModel;", "Lkotlin/collections/ArrayList;", "errorType", "Lcom/iaai/android/bdt/base/BaseFragment$ErrorType;", "isError", "", "isFristTime", "isFromSetDelivery", "mIntent", "Landroid/content/Intent;", "getMIntent", "()Landroid/content/Intent;", "setMIntent", "(Landroid/content/Intent;)V", "manageBranchListAdapter", "Lcom/iaai/android/bdt/feature/account/salesdocument/manageBranchPref/ManageBranchListAdapter;", "manageBranchPrefResponse", "Lcom/iaai/android/bdt/model/MyAccount/ManageBranchPrefResponse;", "selectedBranchList", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "stockList", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/defaultResponse/TitleInstructionItem;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "toolbar_title", "Landroid/widget/TextView;", "getToolbar_title", "()Landroid/widget/TextView;", "setToolbar_title", "(Landroid/widget/TextView;)V", "viewModel", "Lcom/iaai/android/bdt/feature/account/salesdocument/SaleDocumentViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "addHeaderToAuctionSalesList", "", "errorMessage", "checkNetworkConnection", "fetchSaleDocManagePrefBranchList", "filter", "text", "getRequestBody", "Lcom/iaai/android/bdt/model/MyAccount/MBRequestBody;", "handledSelectedBrachData", "initializeRecycler", "initializeUI", "onActivityResult", "requestCode", "", "resultCode", "data", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "resetUI", "showLoadingIndicator", "loading", "subscribeToViewModel", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ManageBranchPrefActivity.kt */
public final class ManageBranchPrefActivity extends AppCompatActivity {
    @NotNull
    private final String CONTENT_TYPE = "application/json";
    @NotNull
    private final String PAYPAL_API_KEY = Constants_MVVM.SEARCH_API_KEY;
    /* access modifiers changed from: private */
    public final String TAG = ManageBranchPrefActivity.class.getSimpleName();
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public ArrayList<BranchModel> branchList;
    private BaseFragment.ErrorType errorType;
    /* access modifiers changed from: private */
    public boolean isError;
    private boolean isFristTime = true;
    /* access modifiers changed from: private */
    public boolean isFromSetDelivery;
    @Nullable
    private Intent mIntent;
    /* access modifiers changed from: private */
    public ManageBranchListAdapter manageBranchListAdapter;
    /* access modifiers changed from: private */
    public ManageBranchPrefResponse manageBranchPrefResponse;
    /* access modifiers changed from: private */
    public ArrayList<BranchModel> selectedBranchList;
    @Inject
    @NotNull
    public SessionManager sessionManager;
    private ArrayList<TitleInstructionItem> stockList = new ArrayList<>();
    @NotNull
    public Toolbar toolbar;
    @NotNull
    public TextView toolbar_title;
    private SaleDocumentViewModel viewModel;
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

    public static final /* synthetic */ ManageBranchListAdapter access$getManageBranchListAdapter$p(ManageBranchPrefActivity manageBranchPrefActivity) {
        ManageBranchListAdapter manageBranchListAdapter2 = manageBranchPrefActivity.manageBranchListAdapter;
        if (manageBranchListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageBranchListAdapter");
        }
        return manageBranchListAdapter2;
    }

    public static final /* synthetic */ ManageBranchPrefResponse access$getManageBranchPrefResponse$p(ManageBranchPrefActivity manageBranchPrefActivity) {
        ManageBranchPrefResponse manageBranchPrefResponse2 = manageBranchPrefActivity.manageBranchPrefResponse;
        if (manageBranchPrefResponse2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageBranchPrefResponse");
        }
        return manageBranchPrefResponse2;
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

    @Nullable
    public final Intent getMIntent() {
        return this.mIntent;
    }

    public final void setMIntent(@Nullable Intent intent) {
        this.mIntent = intent;
    }

    @NotNull
    public final String getPAYPAL_API_KEY() {
        return this.PAYPAL_API_KEY;
    }

    @NotNull
    public final String getCONTENT_TYPE() {
        return this.CONTENT_TYPE;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.acivity_manage_branch_pref);
        View findViewById = findViewById(C2723R.C2726id.toolbar);
        if (findViewById != null) {
            this.toolbar = (Toolbar) findViewById;
            View findViewById2 = findViewById(C2723R.C2726id.toolbar_title);
            if (findViewById2 != null) {
                this.toolbar_title = (TextView) findViewById2;
                FragmentActivity fragmentActivity = this;
                ViewModelProvider.Factory factory = this.viewModelFactory;
                if (factory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
                }
                ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(SaleDocumentViewModel.class);
                Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…entViewModel::class.java)");
                this.viewModel = (SaleDocumentViewModel) viewModel2;
                initializeUI();
                initializeRecycler();
                checkNetworkConnection();
                subscribeToViewModel();
                ((Button) _$_findCachedViewById(C2723R.C2726id.btnCheckOut)).setOnClickListener(new ManageBranchPrefActivity$onCreate$1(this));
                resetUI();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
    }

    /* access modifiers changed from: private */
    public final void resetUI() {
        Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btnCheckOut);
        Intrinsics.checkExpressionValueIsNotNull(button, "btnCheckOut");
        button.setClickable(false);
        Button button2 = (Button) _$_findCachedViewById(C2723R.C2726id.btnCheckOut);
        Intrinsics.checkExpressionValueIsNotNull(button2, "btnCheckOut");
        button2.setAlpha(0.5f);
    }

    /* access modifiers changed from: private */
    public final void handledSelectedBrachData() {
        String str;
        this.stockList.clear();
        ArrayList<BranchModel> arrayList = this.selectedBranchList;
        if (arrayList != null) {
            String str2 = "";
            String str3 = str2;
            String str4 = str3;
            String str5 = str4;
            for (BranchModel branchModel : arrayList) {
                String assignedToCode = branchModel.getAssignedToCode();
                if (Intrinsics.areEqual((Object) assignedToCode, (Object) Constants_MVVM.BranchAssignCode.BFA.getValue())) {
                    ManageBranchPrefResponse manageBranchPrefResponse2 = this.manageBranchPrefResponse;
                    if (manageBranchPrefResponse2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("manageBranchPrefResponse");
                    }
                    str3 = String.valueOf(manageBranchPrefResponse2.getPickup().getOwnerPickup().getDisplayName());
                    ManageBranchPrefResponse manageBranchPrefResponse3 = this.manageBranchPrefResponse;
                    if (manageBranchPrefResponse3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("manageBranchPrefResponse");
                    }
                    ArrayList<ManageBranchModel> buyerFedex = manageBranchPrefResponse3.getMail().getBuyerFedex();
                    if (buyerFedex != null) {
                        for (ManageBranchModel manageBranchModel : buyerFedex) {
                            if (Intrinsics.areEqual((Object) branchModel.getAssignedToCode(), (Object) manageBranchModel.getTypeCode()) && Intrinsics.areEqual((Object) branchModel.getAssignedToName(), (Object) manageBranchModel.getDisplayName())) {
                                str2 = String.valueOf(manageBranchModel.getCompanyName());
                                str5 = String.valueOf(manageBranchModel.getDisplayName());
                            }
                        }
                    }
                } else if (Intrinsics.areEqual((Object) assignedToCode, (Object) Constants_MVVM.BranchAssignCode.OPU.getValue())) {
                    ManageBranchPrefResponse manageBranchPrefResponse4 = this.manageBranchPrefResponse;
                    if (manageBranchPrefResponse4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("manageBranchPrefResponse");
                    }
                    str3 = String.valueOf(manageBranchPrefResponse4.getPickup().getOwnerPickup().getDisplayName());
                } else if (Intrinsics.areEqual((Object) assignedToCode, (Object) Constants_MVVM.BranchAssignCode.IFA.getValue())) {
                    ManageBranchPrefResponse manageBranchPrefResponse5 = this.manageBranchPrefResponse;
                    if (manageBranchPrefResponse5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("manageBranchPrefResponse");
                    }
                    String valueOf = String.valueOf(manageBranchPrefResponse5.getPickup().getOwnerPickup().getDisplayName());
                    ManageBranchPrefResponse manageBranchPrefResponse6 = this.manageBranchPrefResponse;
                    if (manageBranchPrefResponse6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("manageBranchPrefResponse");
                    }
                    String valueOf2 = String.valueOf(manageBranchPrefResponse6.getMail().getIaaFedEx().getCompanyName());
                    str3 = valueOf;
                    str2 = valueOf2;
                } else if (Intrinsics.areEqual((Object) assignedToCode, (Object) Constants_MVVM.BranchAssignCode.RPU.getValue())) {
                    ManageBranchPrefResponse manageBranchPrefResponse7 = this.manageBranchPrefResponse;
                    if (manageBranchPrefResponse7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("manageBranchPrefResponse");
                    }
                    str3 = String.valueOf(manageBranchPrefResponse7.getPickup().getOwnerPickup().getDisplayName());
                    ManageBranchPrefResponse manageBranchPrefResponse8 = this.manageBranchPrefResponse;
                    if (manageBranchPrefResponse8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("manageBranchPrefResponse");
                    }
                    List<ManageBranchModel> representativePickup = manageBranchPrefResponse8.getPickup().getRepresentativePickup();
                    if (representativePickup != null) {
                        for (ManageBranchModel manageBranchModel2 : representativePickup) {
                            if (Intrinsics.areEqual((Object) branchModel.getAssignedToCode(), (Object) manageBranchModel2.getTypeCode()) && Intrinsics.areEqual((Object) branchModel.getAssignedToName(), (Object) manageBranchModel2.getDisplayName())) {
                                str4 = String.valueOf(branchModel.getAssignedToName());
                            }
                        }
                    }
                }
                Integer branchCode = branchModel.getBranchCode();
                int intValue = branchCode != null ? branchCode.intValue() : 0;
                String branchName = branchModel.getBranchName();
                if (branchName != null) {
                    str = branchName;
                } else {
                    str = "";
                }
                this.stockList.add(new TitleInstructionItem((String) null, (String) null, (String) null, intValue, str, 0, (String) null, 0, (String) null, str2, (String) null, (String) null, 0, str5, false, false, false, 0, false, str3, (String) null, false, str4, 0, 0, 0, false, branchModel.getAssignedToState(), "", branchModel.getAssignedToCode(), (String) null, (String) null, (String) null, (String) null, "", "", (String) null, (String) null, branchModel.isSelected()));
            }
        }
        Collection arrayList2 = new ArrayList();
        for (Object next : this.stockList) {
            if (((TitleInstructionItem) next).isSelected()) {
                arrayList2.add(next);
            }
        }
        Intent intent = new Intent(this, DeliveryMethodActivity.class);
        intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_LIST, (ArrayList) ((List) arrayList2));
        intent.putExtra(Constants_MVVM.EXTRA_IS_FROM_BRANCH_LIST, Constants_MVVM.SetDeliveryAction.IS_FROM_BRANCH_LIST.getValue());
        startActivityForResult(intent, 42);
    }

    /* access modifiers changed from: private */
    public final void filter(String str) {
        ArrayList<BranchModel> arrayList;
        ArrayList arrayList2 = new ArrayList();
        if (Intrinsics.areEqual((Object) str, (Object) "")) {
            ArrayList<BranchModel> arrayList3 = this.selectedBranchList;
            if (arrayList3 != null) {
                arrayList3.clear();
            }
            Activity_ExtensionKt.hideSoftKeyboard(this);
        }
        ArrayList<BranchModel> arrayList4 = this.branchList;
        if (arrayList4 != null) {
            for (BranchModel branchModel : arrayList4) {
                String branchName = branchModel.getBranchName();
                if (branchName == null) {
                    Intrinsics.throwNpe();
                }
                if (StringsKt.contains((CharSequence) branchName, (CharSequence) str, true)) {
                    arrayList2.add(branchModel);
                }
                if (Intrinsics.areEqual((Object) str, (Object) "") && branchModel.isSelected() && (arrayList = this.selectedBranchList) != null) {
                    arrayList.add(branchModel);
                }
                if (branchModel.isSelected()) {
                    Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btnCheckOut);
                    Intrinsics.checkExpressionValueIsNotNull(button, "btnCheckOut");
                    button.setClickable(true);
                    Button button2 = (Button) _$_findCachedViewById(C2723R.C2726id.btnCheckOut);
                    Intrinsics.checkExpressionValueIsNotNull(button2, "btnCheckOut");
                    button2.setAlpha(1.0f);
                }
            }
        }
        ManageBranchListAdapter manageBranchListAdapter2 = this.manageBranchListAdapter;
        if (manageBranchListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageBranchListAdapter");
        }
        manageBranchListAdapter2.setBranchFilterData(arrayList2);
    }

    private final void checkNetworkConnection() {
        if (InternetUtil.INSTANCE.isInternetOn()) {
            fetchSaleDocManagePrefBranchList();
            return;
        }
        this.errorType = BaseFragment.ErrorType.NO_INTERNET;
        this.isError = true;
        addHeaderToAuctionSalesList("");
        IAAAnalytics iAAAnalytics = IAAAnalytics.INSTANCE;
        StringBuilder sb = new StringBuilder();
        sb.append("dashboard.svc/myvehicles/userid/");
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        sb.append(sessionManager2.getCurrentSessionUserId());
        sb.append("/");
        iAAAnalytics.logNetworkEvent(sb.toString(), false, "", BaseFragment.ErrorType.NO_INTERNET.getValue());
        InternetUtil.INSTANCE.observe(this, new ManageBranchPrefActivity$checkNetworkConnection$1(this));
    }

    private final void initializeRecycler() {
        Context context = this;
        this.manageBranchListAdapter = new ManageBranchListAdapter(context, new ManageBranchPrefActivity$initializeRecycler$1(this));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvManageBranchList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvManageBranchList");
        ManageBranchListAdapter manageBranchListAdapter2 = this.manageBranchListAdapter;
        if (manageBranchListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageBranchListAdapter");
        }
        recyclerView.setAdapter(manageBranchListAdapter2);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvManageBranchList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvManageBranchList");
        recyclerView2.setLayoutManager(new LinearLayoutManager(context));
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvManageBranchList)).addOnScrollListener(new ManageBranchPrefActivity$initializeRecycler$2(this));
        ((FloatingActionButton) _$_findCachedViewById(C2723R.C2726id.fab)).setOnClickListener(new ManageBranchPrefActivity$initializeRecycler$3(this));
    }

    /* access modifiers changed from: private */
    public final void fetchSaleDocManagePrefBranchList() {
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
        SaleDocumentViewModel saleDocumentViewModel = this.viewModel;
        if (saleDocumentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        String deviceId = AppUtils.getDeviceId(this);
        if (deviceId == null) {
            deviceId = "";
        }
        saleDocumentViewModel.getSaleDocManageBranchList(format, deviceId, "android", this.PAYPAL_API_KEY, this.CONTENT_TYPE, String.valueOf(1), getRequestBody());
        showLoadingIndicator(true);
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbLoadingManageBranchList);
            Intrinsics.checkExpressionValueIsNotNull(progressBar, "pbLoadingManageBranchList");
            progressBar.setVisibility(0);
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbLoadingManageBranchList);
        Intrinsics.checkExpressionValueIsNotNull(progressBar2, "pbLoadingManageBranchList");
        progressBar2.setVisibility(8);
    }

    private final MBRequestBody getRequestBody() {
        return new MBRequestBody(new ManageBranchPrefRequestBody((String) null, (String) null, (String) null, new MailAddressInfo((String) null, (Boolean) null, new AddressInfo((String) null, (String) null, (String) null, (String) null, (String) null, (String) null), (Boolean) null, (String) null, (String) null)));
    }

    private final void subscribeToViewModel() {
        SaleDocumentViewModel saleDocumentViewModel = this.viewModel;
        if (saleDocumentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        saleDocumentViewModel.getSaleDocManageBranchResponse().observe(lifecycleOwner, new ManageBranchPrefActivity$subscribeToViewModel$1(this));
        SaleDocumentViewModel saleDocumentViewModel2 = this.viewModel;
        if (saleDocumentViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        saleDocumentViewModel2.getSaleDocManageBranchListError().observe(lifecycleOwner, new ManageBranchPrefActivity$subscribeToViewModel$2(this));
    }

    private final void initializeUI() {
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
        textView.setText(getResources().getString(C2723R.string.lbl_manage_branch_title));
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.ivToolTip)).setOnClickListener(new ManageBranchPrefActivity$initializeUI$1(this));
    }

    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        Activity_ExtensionKt.hideSoftKeyboard(this);
        return true;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
        if (r0.getBooleanExtra(com.iaai.android.bdt.utils.Constants_MVVM.EXTRA_IS_FILTER_APPLIED, false) == false) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0045, code lost:
        if (r0.getBooleanExtra(com.iaai.android.bdt.utils.Constants_MVVM.EXTRA_IS_SORT_APPLIED, false) != false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0047, code lost:
        r0 = r5;
        r1 = com.iaai.android.old.utils.IAASharedPreference.getYearFilterPreferencesMVVM(r0);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, "IAASharedPreference.getY…ManageBranchPrefActivity)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005a, code lost:
        if (r1.length() <= 0) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005f, code lost:
        r1 = com.iaai.android.old.utils.IAASharedPreference.getLaneFilterPreferencesMVVM(r0);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, "IAASharedPreference.getL…ManageBranchPrefActivity)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006e, code lost:
        if (r1.length() <= 0) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0073, code lost:
        r0 = com.iaai.android.old.utils.IAASharedPreference.getLossLypeFilterPreferencesMVVM(r0);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, "IAASharedPreference.getL…ManageBranchPrefActivity)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0080, code lost:
        if (r0.length() <= 0) goto L_0x0083;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void addHeaderToAuctionSalesList(java.lang.String r6) {
        /*
            r5 = this;
            android.content.Intent r0 = r5.getIntent()
            if (r0 == 0) goto L_0x0083
            android.content.Intent r0 = r5.getIntent()
            if (r0 != 0) goto L_0x000f
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x000f:
            java.lang.String r1 = "isFilterApplied"
            boolean r0 = r0.hasExtra(r1)
            r2 = 0
            if (r0 == 0) goto L_0x0027
            android.content.Intent r0 = r5.getIntent()
            if (r0 != 0) goto L_0x0021
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0021:
            boolean r0 = r0.getBooleanExtra(r1, r2)
            if (r0 != 0) goto L_0x0047
        L_0x0027:
            android.content.Intent r0 = r5.getIntent()
            if (r0 != 0) goto L_0x0030
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0030:
            java.lang.String r1 = "isSortApplied"
            boolean r0 = r0.hasExtra(r1)
            if (r0 == 0) goto L_0x0083
            android.content.Intent r0 = r5.getIntent()
            if (r0 != 0) goto L_0x0041
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0041:
            boolean r0 = r0.getBooleanExtra(r1, r2)
            if (r0 == 0) goto L_0x0083
        L_0x0047:
            r0 = r5
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r1 = com.iaai.android.old.utils.IAASharedPreference.getYearFilterPreferencesMVVM(r0)
            java.lang.String r3 = "IAASharedPreference.getY…ManageBranchPrefActivity)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            r3 = 1
            if (r1 <= 0) goto L_0x005e
            r1 = 1
            goto L_0x005f
        L_0x005e:
            r1 = 0
        L_0x005f:
            java.lang.String r1 = com.iaai.android.old.utils.IAASharedPreference.getLaneFilterPreferencesMVVM(r0)
            java.lang.String r4 = "IAASharedPreference.getL…ManageBranchPrefActivity)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0072
            r1 = 1
            goto L_0x0073
        L_0x0072:
            r1 = 0
        L_0x0073:
            java.lang.String r0 = com.iaai.android.old.utils.IAASharedPreference.getLossLypeFilterPreferencesMVVM(r0)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r4)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0083
            r2 = 1
        L_0x0083:
            com.iaai.android.bdt.model.auctionSalesList.AuctionSalesListHeader r0 = new com.iaai.android.bdt.model.auctionSalesList.AuctionSalesListHeader
            r0.<init>()
            boolean r1 = r5.isError
            r0.setError(r1)
            boolean r1 = r5.isError
            if (r1 == 0) goto L_0x0100
            com.iaai.android.bdt.base.BaseFragment$ErrorType r1 = r5.errorType
            java.lang.String r2 = "errorType"
            if (r1 != 0) goto L_0x009a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x009a:
            int[] r3 = com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref.ManageBranchPrefActivity.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r3[r1]
            java.lang.String r3 = "getString(R.string.bdt_a…on_error_type_no_auction)"
            r4 = 2131820628(0x7f110054, float:1.9273976E38)
            switch(r1) {
                case 1: goto L_0x00e7;
                case 2: goto L_0x00da;
                case 3: goto L_0x00cd;
                case 4: goto L_0x00c5;
                case 5: goto L_0x00bd;
                case 6: goto L_0x00b0;
                case 7: goto L_0x00f3;
                default: goto L_0x00aa;
            }
        L_0x00aa:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L_0x00b0:
            r6 = 2131820640(0x7f110060, float:1.9274E38)
            java.lang.String r6 = r5.getString(r6)
            java.lang.String r1 = "getString(R.string.bdt_l…_error_msg_no_item_found)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r1)
            goto L_0x00f3
        L_0x00bd:
            java.lang.String r6 = r5.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r3)
            goto L_0x00f3
        L_0x00c5:
            java.lang.String r6 = r5.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r3)
            goto L_0x00f3
        L_0x00cd:
            r6 = 2131820629(0x7f110055, float:1.9273978E38)
            java.lang.String r6 = r5.getString(r6)
            java.lang.String r1 = "getString(R.string.bdt_a…tion_error_type_no_stock)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r1)
            goto L_0x00f3
        L_0x00da:
            r6 = 2131820656(0x7f110070, float:1.9274033E38)
            java.lang.String r6 = r5.getString(r6)
            java.lang.String r1 = "getString(R.string.bdt_lbl_msg_prd_network_error)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r1)
            goto L_0x00f3
        L_0x00e7:
            r6 = 2131821566(0x7f1103fe, float:1.9275879E38)
            java.lang.String r6 = r5.getString(r6)
            java.lang.String r1 = "getString(R.string.lbl_msg_no_internet_connection)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r1)
        L_0x00f3:
            r0.setErrorMessage(r6)
            com.iaai.android.bdt.base.BaseFragment$ErrorType r6 = r5.errorType
            if (r6 != 0) goto L_0x00fd
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x00fd:
            r0.setErrorType(r6)
        L_0x0100:
            com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref.ManageBranchListAdapter r6 = r5.manageBranchListAdapter
            java.lang.String r1 = "manageBranchListAdapter"
            if (r6 != 0) goto L_0x0109
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0109:
            r6.setHeaderItem(r0)
            com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref.ManageBranchListAdapter r6 = r5.manageBranchListAdapter
            if (r6 != 0) goto L_0x0113
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0113:
            r6.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref.ManageBranchPrefActivity.addHeaderToAuctionSalesList(java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        r2 = r2.getExtras();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r2, int r3, @org.jetbrains.annotations.Nullable android.content.Intent r4) {
        /*
            r1 = this;
            super.onActivityResult(r2, r3, r4)
            r0 = 42
            if (r2 == r0) goto L_0x0008
            goto L_0x002c
        L_0x0008:
            r2 = -1
            if (r3 != r2) goto L_0x002c
            if (r4 == 0) goto L_0x0023
            r1.mIntent = r4
            android.content.Intent r2 = r1.mIntent
            if (r2 == 0) goto L_0x0020
            android.os.Bundle r2 = r2.getExtras()
            if (r2 == 0) goto L_0x0020
            java.lang.String r3 = "extra_is_from_set_delivery"
            boolean r2 = r2.getBoolean(r3)
            goto L_0x0021
        L_0x0020:
            r2 = 0
        L_0x0021:
            r1.isFromSetDelivery = r2
        L_0x0023:
            r1.resetUI()
            com.iaai.android.bdt.extensions.Activity_ExtensionKt.hideSoftKeyboard(r1)
            r1.checkNetworkConnection()
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref.ManageBranchPrefActivity.onActivityResult(int, int, android.content.Intent):void");
    }
}
