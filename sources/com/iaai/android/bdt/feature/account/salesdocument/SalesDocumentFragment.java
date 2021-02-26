package com.iaai.android.bdt.feature.account.salesdocument;

import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.iaai.android.BuildConfig;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref.ManageBranchPrefActivity;
import com.iaai.android.bdt.feature.auctionSalesList.SortListActivity;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.model.MyAccount.SaleDocumentListModel;
import com.iaai.android.bdt.model.MyAccount.SaleDocumentRequestBody;
import com.iaai.android.bdt.model.sort.SortOptionData;
import com.iaai.android.bdt.model.toBePaid.saleDocument.defaultResponse.TitleInstructionItem;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.InternetUtil;
import com.iaai.android.bdt.utils.NewDateHelper;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import com.lowagie.text.html.HtmlTags;
import com.lowagie.text.pdf.PdfBoolean;
import dagger.android.support.AndroidSupportInjection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u0005H\u0002J\b\u0010^\u001a\u00020\\H\u0002J \u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\u00052\u0006\u0010b\u001a\u00020\u000e2\u0006\u0010c\u001a\u00020\u0019H\u0002J\b\u0010d\u001a\u00020\\H\u0002J\u0010\u0010e\u001a\u00020\\2\u0006\u0010f\u001a\u00020\u0019H\u0002J\b\u0010g\u001a\u00020\\H\u0002J\b\u0010h\u001a\u00020\\H\u0002J\b\u0010i\u001a\u00020jH\u0002J\u0012\u0010k\u001a\u00020\\2\b\u0010l\u001a\u0004\u0018\u00010mH\u0016J\"\u0010n\u001a\u00020\\2\u0006\u0010o\u001a\u00020\u000e2\u0006\u0010p\u001a\u00020\u000e2\b\u0010q\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010r\u001a\u00020\\2\u0006\u0010s\u001a\u00020tH\u0016J\b\u0010u\u001a\u00020\\H\u0016J\b\u0010v\u001a\u00020\\H\u0016J\u0012\u0010w\u001a\u00020\\2\b\u0010l\u001a\u0004\u0018\u00010mH\u0016J&\u0010x\u001a\u0004\u0018\u00010U2\u0006\u0010y\u001a\u00020z2\b\u0010{\u001a\u0004\u0018\u00010|2\b\u0010l\u001a\u0004\u0018\u00010mH\u0016J\u0018\u0010}\u001a\u00020\\2\u000e\u0010F\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010GH\u0016J\b\u0010~\u001a\u00020\\H\u0016J\u001b\u0010\u001a\u00020\\2\t\u0010\u0001\u001a\u0004\u0018\u00010'2\u0006\u0010b\u001a\u00020\u000eH\u0016J\t\u0010\u0001\u001a\u00020\\H\u0016J\u0012\u0010\u0001\u001a\u00020\\2\u0007\u0010\u0001\u001a\u00020\u0005H\u0016J\u0014\u0010\u0001\u001a\u00020\\2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0005H\u0016J\t\u0010\u0001\u001a\u00020\\H\u0002J\u000f\u0010\u0001\u001a\u00020\\2\u0006\u0010D\u001a\u00020\u000eJ\u0012\u0010\u0001\u001a\u00020\\2\u0007\u0010\u0001\u001a\u00020\u0019H\u0002J\t\u0010\u0001\u001a\u00020\\H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\u00050\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R \u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X.¢\u0006\u0002\n\u0000R\u001e\u00100\u001a\u0002018\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0007\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001d\"\u0004\b<\u0010\u001fR\u001e\u0010=\u001a\u0012\u0012\u0004\u0012\u00020?0>j\b\u0012\u0004\u0012\u00020?`@X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010A\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0007\"\u0004\bC\u00109R\u000e\u0010D\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R \u0010F\u001a\b\u0012\u0004\u0012\u00020'0GX.¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u000e\u0010L\u001a\u00020MX.¢\u0006\u0002\n\u0000R\u001e\u0010N\u001a\u00020O8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001c\u0010T\u001a\u0004\u0018\u00010UX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u000e\u0010Z\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/salesdocument/SalesDocumentFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/iaai/android/bdt/feature/account/salesdocument/SalesDocumentClickListener;", "()V", "CONTENT_TYPE", "", "getCONTENT_TYPE", "()Ljava/lang/String;", "PAYPAL_API_KEY", "getPAYPAL_API_KEY", "TAG", "kotlin.jvm.PlatformType", "action", "currentCount", "", "errorType", "Lcom/iaai/android/bdt/base/BaseFragment$ErrorType;", "indexToUpdate", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "isError", "", "isFristTime", "isLoggedIn", "isTablet", "()Z", "setTablet", "(Z)V", "itemIdWatch", "", "lastSelectedSort", "param1", "param2", "saleDocumentListModelList", "", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocumentListModel;", "getSaleDocumentListModelList", "()Ljava/util/List;", "setSaleDocumentListModelList", "(Ljava/util/List;)V", "salesDocumentActivity", "Lcom/iaai/android/bdt/feature/account/salesdocument/SalesDocumentActivity;", "salesDocumentListAdapter", "Lcom/iaai/android/bdt/feature/account/salesdocument/SalesDocumentListAdapter;", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "sortBy", "getSortBy", "setSortBy", "(Ljava/lang/String;)V", "sortDirection", "getSortDirection", "setSortDirection", "stockList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/defaultResponse/TitleInstructionItem;", "Lkotlin/collections/ArrayList;", "titleStatus", "getTitleStatus", "setTitleStatus", "totalCount", "userId", "vehicleList", "Landroidx/paging/PagedList;", "getVehicleList", "()Landroidx/paging/PagedList;", "setVehicleList", "(Landroidx/paging/PagedList;)V", "viewModel", "Lcom/iaai/android/bdt/feature/account/salesdocument/SaleDocumentViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "viewWatchList", "Landroid/view/View;", "getViewWatchList", "()Landroid/view/View;", "setViewWatchList", "(Landroid/view/View;)V", "year_make_model", "addHeaderToAuctionSalesList", "", "errorMessage", "checkNetworkConnection", "createSortOptionData", "Lcom/iaai/android/bdt/model/sort/SortOptionData;", "displayText", "position", "isSelected", "fetchSaleDocBranchList", "fetchSalesDocument", "isFilterApplied", "initializeRecycler", "initializeUI", "makeRequestBody", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocumentRequestBody;", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "onAttach", "context", "Landroid/content/Context;", "onBranchPrefClick", "onChangeMethodClick", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDocumentSelect", "onFilterClick", "onSalesDocumentClick", "salesDocument", "onSortClick", "onTabStatusClick", "status", "onTrackingIdClick", "trackingNumber", "resetUI", "setToolbarCount", "showLoadingIndicator", "loading", "subscribeToViewModel", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SalesDocumentFragment.kt */
public final class SalesDocumentFragment extends Fragment implements SalesDocumentClickListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final String CONTENT_TYPE = "application/json";
    @NotNull
    private final String PAYPAL_API_KEY = Constants_MVVM.SEARCH_API_KEY;
    /* access modifiers changed from: private */
    public final String TAG = SalesDocumentFragment.class.getSimpleName();
    private HashMap _$_findViewCache;
    private String action = "";
    /* access modifiers changed from: private */
    public int currentCount;
    /* access modifiers changed from: private */
    public BaseFragment.ErrorType errorType;
    private int indexToUpdate;
    @Nullable
    private Intent intent;
    /* access modifiers changed from: private */
    public boolean isError;
    private boolean isFristTime = true;
    private boolean isLoggedIn;
    private boolean isTablet;
    private long itemIdWatch;
    private int lastSelectedSort = 4;
    private String param1;
    private String param2;
    @NotNull
    public List<SaleDocumentListModel> saleDocumentListModelList;
    /* access modifiers changed from: private */
    public SalesDocumentActivity salesDocumentActivity;
    /* access modifiers changed from: private */
    public SalesDocumentListAdapter salesDocumentListAdapter;
    @Inject
    @NotNull
    public SessionManager sessionManager;
    @Nullable
    private String sortBy = "TitleDeliveryMethodCode";
    private boolean sortDirection = true;
    /* access modifiers changed from: private */
    public ArrayList<TitleInstructionItem> stockList = new ArrayList<>();
    @NotNull
    private String titleStatus = "All";
    private int totalCount;
    private String userId = "";
    @NotNull
    public PagedList<SaleDocumentListModel> vehicleList;
    /* access modifiers changed from: private */
    public SaleDocumentViewModel viewModel;
    @Inject
    @NotNull
    public ViewModelProvider.Factory viewModelFactory;
    @Nullable
    private View viewWatchList;
    private String year_make_model = "";

    @JvmStatic
    @NotNull
    public static final SalesDocumentFragment newInstance(@NotNull String str, @NotNull String str2) {
        return Companion.newInstance(str, str2);
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

    public static final /* synthetic */ BaseFragment.ErrorType access$getErrorType$p(SalesDocumentFragment salesDocumentFragment) {
        BaseFragment.ErrorType errorType2 = salesDocumentFragment.errorType;
        if (errorType2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorType");
        }
        return errorType2;
    }

    public static final /* synthetic */ SalesDocumentActivity access$getSalesDocumentActivity$p(SalesDocumentFragment salesDocumentFragment) {
        SalesDocumentActivity salesDocumentActivity2 = salesDocumentFragment.salesDocumentActivity;
        if (salesDocumentActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
        }
        return salesDocumentActivity2;
    }

    public static final /* synthetic */ SalesDocumentListAdapter access$getSalesDocumentListAdapter$p(SalesDocumentFragment salesDocumentFragment) {
        SalesDocumentListAdapter salesDocumentListAdapter2 = salesDocumentFragment.salesDocumentListAdapter;
        if (salesDocumentListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentListAdapter");
        }
        return salesDocumentListAdapter2;
    }

    public static final /* synthetic */ SaleDocumentViewModel access$getViewModel$p(SalesDocumentFragment salesDocumentFragment) {
        SaleDocumentViewModel saleDocumentViewModel = salesDocumentFragment.viewModel;
        if (saleDocumentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return saleDocumentViewModel;
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
    public final PagedList<SaleDocumentListModel> getVehicleList() {
        PagedList<SaleDocumentListModel> pagedList = this.vehicleList;
        if (pagedList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vehicleList");
        }
        return pagedList;
    }

    public final void setVehicleList(@NotNull PagedList<SaleDocumentListModel> pagedList) {
        Intrinsics.checkParameterIsNotNull(pagedList, "<set-?>");
        this.vehicleList = pagedList;
    }

    @Nullable
    public final View getViewWatchList() {
        return this.viewWatchList;
    }

    public final void setViewWatchList(@Nullable View view) {
        this.viewWatchList = view;
    }

    @NotNull
    public final List<SaleDocumentListModel> getSaleDocumentListModelList() {
        List<SaleDocumentListModel> list = this.saleDocumentListModelList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saleDocumentListModelList");
        }
        return list;
    }

    public final void setSaleDocumentListModelList(@NotNull List<SaleDocumentListModel> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.saleDocumentListModelList = list;
    }

    @NotNull
    public final String getTitleStatus() {
        return this.titleStatus;
    }

    public final void setTitleStatus(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.titleStatus = str;
    }

    @Nullable
    public final String getSortBy() {
        return this.sortBy;
    }

    public final void setSortBy(@Nullable String str) {
        this.sortBy = str;
    }

    public final boolean getSortDirection() {
        return this.sortDirection;
    }

    public final void setSortDirection(boolean z) {
        this.sortDirection = z;
    }

    public final boolean isTablet() {
        return this.isTablet;
    }

    public final void setTablet(boolean z) {
        this.isTablet = z;
    }

    @NotNull
    public final String getPAYPAL_API_KEY() {
        return this.PAYPAL_API_KEY;
    }

    @NotNull
    public final String getCONTENT_TYPE() {
        return this.CONTENT_TYPE;
    }

    @Nullable
    public final Intent getIntent() {
        return this.intent;
    }

    public final void setIntent(@Nullable Intent intent2) {
        this.intent = intent2;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        SalesDocumentActivity salesDocumentActivity2 = this.salesDocumentActivity;
        if (salesDocumentActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
        }
        FragmentActivity fragmentActivity = salesDocumentActivity2;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(SaleDocumentViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(sa…entViewModel::class.java)");
        this.viewModel = (SaleDocumentViewModel) viewModel2;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.salesDocumentActivity = (SalesDocumentActivity) activity;
            if (context instanceof SalesDocumentActivity) {
                this.salesDocumentActivity = (SalesDocumentActivity) context;
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentActivity");
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        SalesDocumentActivity salesDocumentActivity2 = this.salesDocumentActivity;
        if (salesDocumentActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
        }
        this.isTablet = salesDocumentActivity2.getResources().getBoolean(C2723R.bool.isTabletPhone);
        if (this.viewWatchList == null) {
            ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.fragment_sales_document, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "mBinding");
            this.viewWatchList = inflate.getRoot();
        }
        return this.viewWatchList;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        SalesDocumentActivity salesDocumentActivity2 = this.salesDocumentActivity;
        if (salesDocumentActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
        }
        ImageView imageView = (ImageView) salesDocumentActivity2._$_findCachedViewById(C2723R.C2726id.arrow_left);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "salesDocumentActivity.arrow_left");
        imageView.setVisibility(8);
        SalesDocumentActivity salesDocumentActivity3 = this.salesDocumentActivity;
        if (salesDocumentActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
        }
        ImageView imageView2 = (ImageView) salesDocumentActivity3._$_findCachedViewById(C2723R.C2726id.arrow_right);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, "salesDocumentActivity.arrow_right");
        imageView2.setVisibility(8);
        SalesDocumentActivity salesDocumentActivity4 = this.salesDocumentActivity;
        if (salesDocumentActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
        }
        RelativeLayout relativeLayout = (RelativeLayout) salesDocumentActivity4._$_findCachedViewById(C2723R.C2726id.sale_doc_toolbar_relativelayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "salesDocumentActivity.sa…oc_toolbar_relativelayout");
        relativeLayout.setGravity(GravityCompat.START);
        SalesDocumentActivity salesDocumentActivity5 = this.salesDocumentActivity;
        if (salesDocumentActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) salesDocumentActivity5._$_findCachedViewById(C2723R.C2726id.sale_doc_toolbar_relativelayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "salesDocumentActivity.sa…oc_toolbar_relativelayout");
        relativeLayout2.setGravity(3);
        SalesDocumentActivity salesDocumentActivity6 = this.salesDocumentActivity;
        if (salesDocumentActivity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
        }
        salesDocumentActivity6.getIvStockShare().setVisibility(8);
        SalesDocumentActivity salesDocumentActivity7 = this.salesDocumentActivity;
        if (salesDocumentActivity7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
        }
        Application application = salesDocumentActivity7.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "salesDocumentActivity.application");
        String userIdPreferencesMVVM = IAASharedPreference.getUserIdPreferencesMVVM(application.getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(userIdPreferencesMVVM, "IAASharedPreference.getU…ation.applicationContext)");
        this.userId = userIdPreferencesMVVM;
        if (this.isFristTime) {
            initializeRecycler();
            initializeUI();
            resetUI();
            checkNetworkConnection();
        }
        setToolbarCount(this.totalCount);
    }

    private final void initializeUI() {
        ((Button) _$_findCachedViewById(C2723R.C2726id.btnCheckOut)).setOnClickListener(new SalesDocumentFragment$initializeUI$1(this));
    }

    private final void resetUI() {
        Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btnCheckOut);
        Intrinsics.checkExpressionValueIsNotNull(button, "btnCheckOut");
        button.setClickable(false);
        Button button2 = (Button) _$_findCachedViewById(C2723R.C2726id.btnCheckOut);
        Intrinsics.checkExpressionValueIsNotNull(button2, "btnCheckOut");
        button2.setAlpha(0.5f);
    }

    private final void initializeRecycler() {
        this.isFristTime = false;
        SalesDocumentActivity salesDocumentActivity2 = this.salesDocumentActivity;
        if (salesDocumentActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
        }
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(salesDocumentActivity2, 1);
        SalesDocumentActivity salesDocumentActivity3 = this.salesDocumentActivity;
        if (salesDocumentActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
        }
        Application application = salesDocumentActivity3.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "salesDocumentActivity.application");
        Drawable drawable = ContextCompat.getDrawable(application.getApplicationContext(), C2723R.C2725drawable.line_decoration);
        if (drawable == null) {
            Intrinsics.throwNpe();
        }
        dividerItemDecoration.setDrawable(drawable);
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvSalDocList)).addItemDecoration(dividerItemDecoration);
        SalesDocumentActivity salesDocumentActivity4 = this.salesDocumentActivity;
        if (salesDocumentActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
        }
        this.salesDocumentListAdapter = new SalesDocumentListAdapter(salesDocumentActivity4, this);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvSalDocList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvSalDocList");
        SalesDocumentListAdapter salesDocumentListAdapter2 = this.salesDocumentListAdapter;
        if (salesDocumentListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentListAdapter");
        }
        recyclerView.setAdapter(salesDocumentListAdapter2);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvSalDocList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvSalDocList");
        SalesDocumentActivity salesDocumentActivity5 = this.salesDocumentActivity;
        if (salesDocumentActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(salesDocumentActivity5));
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvSalDocList)).addOnScrollListener(new SalesDocumentFragment$initializeRecycler$1(this));
        ((FloatingActionButton) _$_findCachedViewById(C2723R.C2726id.fab)).setOnClickListener(new SalesDocumentFragment$initializeRecycler$2(this));
    }

    private final SortOptionData createSortOptionData(String str, int i, boolean z) {
        if (i == 0) {
            return new SortOptionData(str, "VehicleDescription", "true", z);
        }
        if (i == 1) {
            return new SortOptionData(str, "VehicleDescription", PdfBoolean.FALSE, z);
        }
        if (i == 2) {
            return new SortOptionData(str, Constants.TO_BE_PAID_SRT_BRANCH, "true", z);
        }
        if (i == 3) {
            return new SortOptionData(str, Constants.TO_BE_PAID_SRT_BRANCH, PdfBoolean.FALSE, z);
        }
        if (i == 4) {
            return new SortOptionData(str, "TitleDeliveryMethodCode", "true", z);
        }
        if (i != 5) {
            return new SortOptionData(str, "TitleDeliveryMethodCode", "true", z);
        }
        return new SortOptionData(str, "TitleDeliveryMethodCode", PdfBoolean.FALSE, z);
    }

    private final void checkNetworkConnection() {
        if (InternetUtil.INSTANCE.isInternetOn()) {
            fetchSalesDocument(false);
            fetchSaleDocBranchList();
            return;
        }
        this.errorType = BaseFragment.ErrorType.NO_INTERNET;
        this.isError = true;
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
        InternetUtil.INSTANCE.observe(this, new SalesDocumentFragment$checkNetworkConnection$1(this));
    }

    /* access modifiers changed from: private */
    public final void fetchSaleDocBranchList() {
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
        SalesDocumentActivity salesDocumentActivity2 = this.salesDocumentActivity;
        if (salesDocumentActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
        }
        String deviceId = AppUtils.getDeviceId(salesDocumentActivity2);
        if (deviceId == null) {
            deviceId = "";
        }
        saleDocumentViewModel.getSaleDocBranchList(format, deviceId, "android", this.PAYPAL_API_KEY, this.CONTENT_TYPE, String.valueOf(BuildConfig.VERSION_CODE));
    }

    /* access modifiers changed from: private */
    public final void fetchSalesDocument(boolean z) {
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
        SalesDocumentActivity salesDocumentActivity2 = this.salesDocumentActivity;
        if (salesDocumentActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
        }
        String deviceId = AppUtils.getDeviceId(salesDocumentActivity2);
        if (deviceId == null) {
            deviceId = "";
        }
        saleDocumentViewModel.getSaleDocumentList(format, deviceId, "android", this.PAYPAL_API_KEY, this.CONTENT_TYPE, String.valueOf(BuildConfig.VERSION_CODE), makeRequestBody(), z);
        showLoadingIndicator(true);
        subscribeToViewModel();
    }

    private final SaleDocumentRequestBody makeRequestBody() {
        List arrayList = new ArrayList();
        String str = this.titleStatus;
        String str2 = this.sortBy;
        if (str2 == null) {
            str2 = "";
        }
        return new SaleDocumentRequestBody(arrayList, str, 1, 30, str2, this.sortDirection, 0);
    }

    private final void subscribeToViewModel() {
        SaleDocumentViewModel saleDocumentViewModel = this.viewModel;
        if (saleDocumentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        saleDocumentViewModel.getSalesDocumentListError().observe(lifecycleOwner, new SalesDocumentFragment$subscribeToViewModel$1(this));
        SaleDocumentViewModel saleDocumentViewModel2 = this.viewModel;
        if (saleDocumentViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        saleDocumentViewModel2.getResultLiveData().observe(lifecycleOwner, new SalesDocumentFragment$subscribeToViewModel$2(this));
        SaleDocumentViewModel saleDocumentViewModel3 = this.viewModel;
        if (saleDocumentViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        saleDocumentViewModel3.getNetworkState().observe(lifecycleOwner, SalesDocumentFragment$subscribeToViewModel$3.INSTANCE);
        SaleDocumentViewModel saleDocumentViewModel4 = this.viewModel;
        if (saleDocumentViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        saleDocumentViewModel4.getScrollSearchListToTop().observe(lifecycleOwner, new SalesDocumentFragment$subscribeToViewModel$4(this));
        SaleDocumentViewModel saleDocumentViewModel5 = this.viewModel;
        if (saleDocumentViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        saleDocumentViewModel5.getSaleDocumentListResponse().observe(lifecycleOwner, new SalesDocumentFragment$subscribeToViewModel$5(this));
        SaleDocumentViewModel saleDocumentViewModel6 = this.viewModel;
        if (saleDocumentViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        saleDocumentViewModel6.getSaleDocBranchResponse().observe(lifecycleOwner, new SalesDocumentFragment$subscribeToViewModel$6(this));
    }

    public final void setToolbarCount(int i) {
        this.totalCount = i;
        SalesDocumentActivity salesDocumentActivity2 = this.salesDocumentActivity;
        if (salesDocumentActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
        }
        salesDocumentActivity2.getToolbar_title().setText(getString(C2723R.string.title_bdt_sale_document));
        SalesDocumentActivity salesDocumentActivity3 = this.salesDocumentActivity;
        if (salesDocumentActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
        }
        salesDocumentActivity3.getToolbar_sub_title().setVisibility(8);
        SalesDocumentActivity salesDocumentActivity4 = this.salesDocumentActivity;
        if (salesDocumentActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
        }
        TextView toolbar_sub_title = salesDocumentActivity4.getToolbar_sub_title();
        toolbar_sub_title.setText(i + " Results");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        r4 = r4.getExtras();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r3, int r4, @org.jetbrains.annotations.Nullable android.content.Intent r5) {
        /*
            r2 = this;
            r0 = 41
            if (r3 == r0) goto L_0x0005
            goto L_0x000e
        L_0x0005:
            r3 = -1
            if (r4 != r3) goto L_0x000e
            r2.resetUI()
            r2.checkNetworkConnection()
        L_0x000e:
            r3 = 1
            if (r4 == r3) goto L_0x0014
            r0 = 2
            if (r4 != r0) goto L_0x0071
        L_0x0014:
            if (r5 == 0) goto L_0x0071
            r2.intent = r5
            android.content.Intent r4 = r2.intent
            r5 = 0
            r0 = 0
            if (r4 == 0) goto L_0x002f
            android.os.Bundle r4 = r4.getExtras()
            if (r4 == 0) goto L_0x002f
            java.lang.String r1 = "search_selected_sort_position"
            int r4 = r4.getInt(r1, r5)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x0030
        L_0x002f:
            r4 = r0
        L_0x0030:
            if (r4 != 0) goto L_0x0035
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0035:
            int r4 = r4.intValue()
            r2.lastSelectedSort = r4
            android.content.Intent r4 = r2.intent
            if (r4 == 0) goto L_0x004c
            android.os.Bundle r4 = r4.getExtras()
            if (r4 == 0) goto L_0x004c
            java.lang.String r1 = "sortDirection"
            java.lang.String r4 = r4.getString(r1)
            goto L_0x004d
        L_0x004c:
            r4 = r0
        L_0x004d:
            java.lang.String r1 = "true"
            boolean r4 = kotlin.text.StringsKt.equals(r4, r1, r3)
            if (r4 == 0) goto L_0x0058
            r2.sortDirection = r3
            goto L_0x005a
        L_0x0058:
            r2.sortDirection = r5
        L_0x005a:
            android.content.Intent r4 = r2.intent
            if (r4 == 0) goto L_0x006c
            android.os.Bundle r4 = r4.getExtras()
            if (r4 == 0) goto L_0x006c
            java.lang.String r5 = "sortBy"
            java.lang.String r0 = ""
            java.lang.String r0 = r4.getString(r5, r0)
        L_0x006c:
            r2.sortBy = r0
            r2.fetchSalesDocument(r3)
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentFragment.onActivityResult(int, int, android.content.Intent):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r0.getBooleanExtra(com.iaai.android.bdt.utils.Constants_MVVM.EXTRA_IS_FILTER_APPLIED, false) == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0039, code lost:
        if (r0.getBooleanExtra(com.iaai.android.bdt.utils.Constants_MVVM.EXTRA_IS_SORT_APPLIED, false) != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003b, code lost:
        r0 = com.iaai.android.old.utils.IAASharedPreference.getYearFilterPreferencesMVVM(getActivity());
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, "IAASharedPreference.getY…PreferencesMVVM(activity)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0051, code lost:
        if (r0.length() <= 0) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0056, code lost:
        r0 = com.iaai.android.old.utils.IAASharedPreference.getLaneFilterPreferencesMVVM(getActivity());
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, "IAASharedPreference.getL…PreferencesMVVM(activity)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006b, code lost:
        if (r0.length() <= 0) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0070, code lost:
        r0 = com.iaai.android.old.utils.IAASharedPreference.getLossLypeFilterPreferencesMVVM(getActivity());
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, "IAASharedPreference.getL…PreferencesMVVM(activity)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0083, code lost:
        if (r0.length() <= 0) goto L_0x0086;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void addHeaderToAuctionSalesList(java.lang.String r6) {
        /*
            r5 = this;
            android.content.Intent r0 = r5.intent
            if (r0 == 0) goto L_0x0087
            if (r0 != 0) goto L_0x0009
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0009:
            java.lang.String r1 = "isFilterApplied"
            boolean r0 = r0.hasExtra(r1)
            r2 = 0
            if (r0 == 0) goto L_0x001f
            android.content.Intent r0 = r5.intent
            if (r0 != 0) goto L_0x0019
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0019:
            boolean r0 = r0.getBooleanExtra(r1, r2)
            if (r0 != 0) goto L_0x003b
        L_0x001f:
            android.content.Intent r0 = r5.intent
            if (r0 != 0) goto L_0x0026
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0026:
            java.lang.String r1 = "isSortApplied"
            boolean r0 = r0.hasExtra(r1)
            if (r0 == 0) goto L_0x0087
            android.content.Intent r0 = r5.intent
            if (r0 != 0) goto L_0x0035
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0035:
            boolean r0 = r0.getBooleanExtra(r1, r2)
            if (r0 == 0) goto L_0x0087
        L_0x003b:
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r0 = com.iaai.android.old.utils.IAASharedPreference.getYearFilterPreferencesMVVM(r0)
            java.lang.String r1 = "IAASharedPreference.getY…PreferencesMVVM(activity)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            r1 = 1
            if (r0 <= 0) goto L_0x0055
            r0 = 1
            goto L_0x0056
        L_0x0055:
            r0 = 0
        L_0x0056:
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r0 = com.iaai.android.old.utils.IAASharedPreference.getLaneFilterPreferencesMVVM(r0)
            java.lang.String r3 = "IAASharedPreference.getL…PreferencesMVVM(activity)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x006f
            r0 = 1
            goto L_0x0070
        L_0x006f:
            r0 = 0
        L_0x0070:
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r0 = com.iaai.android.old.utils.IAASharedPreference.getLossLypeFilterPreferencesMVVM(r0)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0086
            goto L_0x0087
        L_0x0086:
            r1 = 0
        L_0x0087:
            com.iaai.android.bdt.model.auctionSalesList.AuctionSalesListHeader r0 = new com.iaai.android.bdt.model.auctionSalesList.AuctionSalesListHeader
            r0.<init>()
            boolean r1 = r5.isError
            r0.setError(r1)
            boolean r1 = r5.isError
            if (r1 == 0) goto L_0x0104
            com.iaai.android.bdt.base.BaseFragment$ErrorType r1 = r5.errorType
            java.lang.String r2 = "errorType"
            if (r1 != 0) goto L_0x009e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x009e:
            int[] r3 = com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentFragment.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r3[r1]
            java.lang.String r3 = "getString(R.string.bdt_a…on_error_type_no_auction)"
            r4 = 2131820628(0x7f110054, float:1.9273976E38)
            switch(r1) {
                case 1: goto L_0x00eb;
                case 2: goto L_0x00de;
                case 3: goto L_0x00d1;
                case 4: goto L_0x00c9;
                case 5: goto L_0x00c1;
                case 6: goto L_0x00b4;
                case 7: goto L_0x00f7;
                default: goto L_0x00ae;
            }
        L_0x00ae:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L_0x00b4:
            r6 = 2131820640(0x7f110060, float:1.9274E38)
            java.lang.String r6 = r5.getString(r6)
            java.lang.String r1 = "getString(R.string.bdt_l…_error_msg_no_item_found)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r1)
            goto L_0x00f7
        L_0x00c1:
            java.lang.String r6 = r5.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r3)
            goto L_0x00f7
        L_0x00c9:
            java.lang.String r6 = r5.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r3)
            goto L_0x00f7
        L_0x00d1:
            r6 = 2131820629(0x7f110055, float:1.9273978E38)
            java.lang.String r6 = r5.getString(r6)
            java.lang.String r1 = "getString(R.string.bdt_a…tion_error_type_no_stock)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r1)
            goto L_0x00f7
        L_0x00de:
            r6 = 2131820656(0x7f110070, float:1.9274033E38)
            java.lang.String r6 = r5.getString(r6)
            java.lang.String r1 = "getString(R.string.bdt_lbl_msg_prd_network_error)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r1)
            goto L_0x00f7
        L_0x00eb:
            r6 = 2131821566(0x7f1103fe, float:1.9275879E38)
            java.lang.String r6 = r5.getString(r6)
            java.lang.String r1 = "getString(R.string.lbl_msg_no_internet_connection)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r1)
        L_0x00f7:
            r0.setErrorMessage(r6)
            com.iaai.android.bdt.base.BaseFragment$ErrorType r6 = r5.errorType
            if (r6 != 0) goto L_0x0101
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x0101:
            r0.setErrorType(r6)
        L_0x0104:
            com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentListAdapter r6 = r5.salesDocumentListAdapter
            java.lang.String r1 = "salesDocumentListAdapter"
            if (r6 != 0) goto L_0x010d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x010d:
            r6.setHeaderItem(r0)
            com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentListAdapter r6 = r5.salesDocumentListAdapter
            if (r6 != 0) goto L_0x0117
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0117:
            r6.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentFragment.addHeaderToAuctionSalesList(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbLoadingAuctionSaleList);
            Intrinsics.checkExpressionValueIsNotNull(progressBar, "pbLoadingAuctionSaleList");
            progressBar.setVisibility(0);
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbLoadingAuctionSaleList);
        Intrinsics.checkExpressionValueIsNotNull(progressBar2, "pbLoadingAuctionSaleList");
        progressBar2.setVisibility(8);
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/salesdocument/SalesDocumentFragment$Companion;", "", "()V", "newInstance", "Lcom/iaai/android/bdt/feature/account/salesdocument/SalesDocumentFragment;", "param1", "", "param2", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SalesDocumentFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final SalesDocumentFragment newInstance(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkParameterIsNotNull(str, "param1");
            Intrinsics.checkParameterIsNotNull(str2, "param2");
            SalesDocumentFragment salesDocumentFragment = new SalesDocumentFragment();
            Bundle bundle = new Bundle();
            bundle.putString("param1", str);
            bundle.putString("param2", str2);
            salesDocumentFragment.setArguments(bundle);
            return salesDocumentFragment;
        }
    }

    public void onDocumentSelect(@Nullable PagedList<SaleDocumentListModel> pagedList) {
        List<SaleDocumentListModel> list;
        if (pagedList != null) {
            Collection arrayList = new ArrayList();
            for (Object next : pagedList) {
                if (((SaleDocumentListModel) next).isSelected()) {
                    arrayList.add(next);
                }
            }
            list = (List) arrayList;
        } else {
            list = null;
        }
        if (list == null) {
            Intrinsics.throwNpe();
        }
        this.saleDocumentListModelList = list;
        if (!list.isEmpty()) {
            Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btnCheckOut);
            Intrinsics.checkExpressionValueIsNotNull(button, "btnCheckOut");
            button.setClickable(true);
            Button button2 = (Button) _$_findCachedViewById(C2723R.C2726id.btnCheckOut);
            Intrinsics.checkExpressionValueIsNotNull(button2, "btnCheckOut");
            button2.setAlpha(1.0f);
            return;
        }
        resetUI();
    }

    public void onChangeMethodClick() {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public void onTrackingIdClick(@Nullable String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://www.fedex.com/apps/fedextrack/?action=track&tracknumbers=");
        if (str == null) {
            str = "";
        }
        sb.append(str);
        String sb2 = sb.toString();
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse(sb2));
        try {
            startActivity(intent2);
        } catch (ActivityNotFoundException unused) {
            Intent intent3 = new Intent("android.intent.action.VIEW");
            intent3.setData(Uri.parse(sb2));
            startActivity(intent3);
        }
    }

    public void onSortClick() {
        Intent intent2 = new Intent(getActivity(), SortListActivity.class);
        ArrayList arrayList = new ArrayList();
        String[] stringArray = getResources().getStringArray(C2723R.array.sort_item_sale_document_list);
        Intrinsics.checkExpressionValueIsNotNull(stringArray, "resources.getStringArray…_item_sale_document_list)");
        int length = stringArray.length;
        for (int i = 0; i < length; i++) {
            String str = stringArray[i];
            if (i == this.lastSelectedSort) {
                Intrinsics.checkExpressionValueIsNotNull(str, HtmlTags.f607S);
                arrayList.add(createSortOptionData(str, i, true));
            } else {
                Intrinsics.checkExpressionValueIsNotNull(str, HtmlTags.f607S);
                arrayList.add(createSortOptionData(str, i, false));
            }
        }
        intent2.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SORT_LIST, arrayList);
        intent2.putExtra(Constants_MVVM.EXTRA_SORT_FROM, 3);
        intent2.putExtra("screen_name", IAAAnalytics.IAAScreenName.WATCH_LIST_SORT.getValue());
        startActivityForResult(intent2, 2);
    }

    public void onFilterClick() {
        throw new NotImplementedError("An operation is not implemented: " + "Not yet implemented");
    }

    public void onSalesDocumentClick(@Nullable SaleDocumentListModel saleDocumentListModel, int i) {
        String valueOf = String.valueOf(saleDocumentListModel != null ? saleDocumentListModel.getOAAuctionItemId() : null);
        Bundle bundle = new Bundle();
        bundle.putString(Constants.EXTRA_ITEM_ID, valueOf);
        ArrayList arrayList = new ArrayList();
        PagedList<SaleDocumentListModel> pagedList = this.vehicleList;
        if (pagedList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vehicleList");
        }
        for (SaleDocumentListModel oAAuctionItemId : pagedList) {
            arrayList.add(String.valueOf(oAAuctionItemId.getOAAuctionItemId()));
        }
        bundle.putStringArrayList(Constants_MVVM.EXTRA_ITEM_IDS_LIST, arrayList);
        bundle.putString(Constants_MVVM.EXTRA_AUCTION_DATE, "");
        bundle.putString(Constants_MVVM.EXTRA_BRANCH_ID, "");
        PagedList<SaleDocumentListModel> pagedList2 = this.vehicleList;
        if (pagedList2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vehicleList");
        }
        bundle.putInt(Constants_MVVM.EXTRA_CURRENT_COUNT, pagedList2.size());
        PagedList<SaleDocumentListModel> pagedList3 = this.vehicleList;
        if (pagedList3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vehicleList");
        }
        bundle.putInt(Constants_MVVM.EXTRA_TOTAL_COUNT, pagedList3.size());
        bundle.putInt(Constants_MVVM.EXTRA_ITEM_POSITION, i);
        bundle.putString(Constants_MVVM.EXTRA_FAST_SEARCH_PARAM, "");
        SalesDocumentActivity salesDocumentActivity2 = this.salesDocumentActivity;
        if (salesDocumentActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
        }
        NavController findNavController = Navigation.findNavController(salesDocumentActivity2, C2723R.C2726id.sales_document_nav_host_fragment);
        Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…cument_nav_host_fragment)");
        findNavController.navigate((int) C2723R.C2726id.action_ACFragment_to_View_Pager_PDFragment, bundle);
        if (this.totalCount > 1) {
            SalesDocumentActivity salesDocumentActivity3 = this.salesDocumentActivity;
            if (salesDocumentActivity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
            }
            RelativeLayout relativeLayout = (RelativeLayout) salesDocumentActivity3._$_findCachedViewById(C2723R.C2726id.sale_doc_toolbar_relativelayout);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "salesDocumentActivity.sa…oc_toolbar_relativelayout");
            relativeLayout.setGravity(GravityCompat.END);
            SalesDocumentActivity salesDocumentActivity4 = this.salesDocumentActivity;
            if (salesDocumentActivity4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
            }
            RelativeLayout relativeLayout2 = (RelativeLayout) salesDocumentActivity4._$_findCachedViewById(C2723R.C2726id.sale_doc_toolbar_relativelayout);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "salesDocumentActivity.sa…oc_toolbar_relativelayout");
            relativeLayout2.setGravity(5);
            SalesDocumentActivity salesDocumentActivity5 = this.salesDocumentActivity;
            if (salesDocumentActivity5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
            }
            TextView toolbar_title = salesDocumentActivity5.getToolbar_title();
            toolbar_title.setText(String.valueOf(i + 1) + " of " + NewDateHelper.INSTANCE.formattedVehicleCount(this.totalCount));
            SalesDocumentActivity salesDocumentActivity6 = this.salesDocumentActivity;
            if (salesDocumentActivity6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
            }
            salesDocumentActivity6.getToolbar_title().setTextColor(getResources().getColor(C2723R.C2724color.bdt_gray_darker));
            SalesDocumentActivity salesDocumentActivity7 = this.salesDocumentActivity;
            if (salesDocumentActivity7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
            }
            salesDocumentActivity7.getToolbar_sub_title().setVisibility(8);
            return;
        }
        SalesDocumentActivity salesDocumentActivity8 = this.salesDocumentActivity;
        if (salesDocumentActivity8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
        }
        salesDocumentActivity8.getToolbar_title().setText(this.year_make_model);
        SalesDocumentActivity salesDocumentActivity9 = this.salesDocumentActivity;
        if (salesDocumentActivity9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
        }
        salesDocumentActivity9.getToolbar_sub_title().setVisibility(8);
    }

    public void onTabStatusClick(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "status");
        if (!StringsKt.equals(this.titleStatus, str, false)) {
            this.titleStatus = str;
            resetUI();
            fetchSalesDocument(true);
        }
    }

    public void onBranchPrefClick() {
        SalesDocumentActivity salesDocumentActivity2 = this.salesDocumentActivity;
        if (salesDocumentActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentActivity");
        }
        this.intent = new Intent(salesDocumentActivity2, ManageBranchPrefActivity.class);
        startActivityForResult(this.intent, 111);
    }
}
