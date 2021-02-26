package com.iaai.android.bdt.feature.account.tobepickedup;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavArgument;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.model.sort.SortOptionData;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.InternetUtil;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import dagger.android.support.AndroidSupportInjection;
import java.util.Arrays;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 b2\u00020\u0001:\u0001bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0004H\u0002J\b\u0010B\u001a\u00020@H\u0002J \u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u0011H\u0002J\b\u0010H\u001a\u00020@H\u0002J\b\u0010I\u001a\u00020@H\u0002J\u0012\u0010J\u001a\u00020@2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\"\u0010M\u001a\u00020@2\u0006\u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u00072\b\u0010P\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010Q\u001a\u00020@2\u0006\u0010R\u001a\u00020SH\u0016J\u0012\u0010T\u001a\u00020@2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J&\u0010U\u001a\u0004\u0018\u0001092\u0006\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010Y2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\b\u0010Z\u001a\u00020@H\u0016J\b\u0010[\u001a\u00020@H\u0016J\u0010\u0010\\\u001a\u00020@2\u0006\u0010-\u001a\u00020\u0007H\u0002J\u0006\u0010]\u001a\u00020@J\u000e\u0010^\u001a\u00020@2\u0006\u0010-\u001a\u00020\u0007J\u0010\u0010_\u001a\u00020@2\u0006\u0010`\u001a\u00020\u0011H\u0002J\b\u0010a\u001a\u00020@H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X.¢\u0006\u0002\n\u0000R\u001e\u00102\u001a\u0002038\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006c"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/tobepickedup/ToBePickedUpListFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "currentCount", "", "errorType", "Lcom/iaai/android/bdt/base/BaseFragment$ErrorType;", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "isError", "", "isFristTime", "isMyItemsOnly", "isTablet", "()Z", "setTablet", "(Z)V", "lastSelectedSort", "preSaleAdapter", "Lcom/iaai/android/bdt/feature/account/tobepickedup/ToBePickedUpAdapter;", "preSaleListAccountActivity", "Lcom/iaai/android/bdt/feature/account/tobepickedup/ToPickedUpAccountActivity;", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "sortBy", "getSortBy", "()Ljava/lang/String;", "setSortBy", "(Ljava/lang/String;)V", "sortDirection", "getSortDirection", "()I", "setSortDirection", "(I)V", "totalCount", "totalCountWatchDashBoard", "userId", "viewModel", "Lcom/iaai/android/bdt/feature/account/tobepickedup/ToBePickedUpViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "viewWatchList", "Landroid/view/View;", "getViewWatchList", "()Landroid/view/View;", "setViewWatchList", "(Landroid/view/View;)V", "year_make_model", "addHeaderToAuctionSalesList", "", "errorMessage", "checkNetworkConnection", "createSortOptionData", "Lcom/iaai/android/bdt/model/sort/SortOptionData;", "displayText", "position", "isSelected", "fetchWatchList", "initializeRecycler", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onStart", "setDashBoardCountAtSharePreference", "setToolBarTitle", "setToolbarCount", "showLoadingIndicator", "loading", "subscribeToViewModel", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ToBePickedUpFragment.kt */
public final class ToBePickedUpListFragment extends BaseFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final String TAG = ToBePickedUpListFragment.class.getSimpleName();
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public int currentCount;
    /* access modifiers changed from: private */
    public BaseFragment.ErrorType errorType;
    @Nullable
    private Intent intent;
    /* access modifiers changed from: private */
    public boolean isError;
    private boolean isFristTime = true;
    private boolean isMyItemsOnly;
    private boolean isTablet;
    /* access modifiers changed from: private */
    public int lastSelectedSort = 2;
    /* access modifiers changed from: private */
    public ToBePickedUpAdapter preSaleAdapter;
    /* access modifiers changed from: private */
    public ToPickedUpAccountActivity preSaleListAccountActivity;
    @Inject
    @NotNull
    public SessionManager sessionManager;
    @Nullable
    private String sortBy;
    private int sortDirection;
    /* access modifiers changed from: private */
    public int totalCount;
    private int totalCountWatchDashBoard;
    private String userId = "";
    /* access modifiers changed from: private */
    public ToBePickedUpViewModel viewModel;
    @Inject
    @NotNull
    public ViewModelProvider.Factory viewModelFactory;
    @Nullable
    private View viewWatchList;
    /* access modifiers changed from: private */
    public String year_make_model = "";

    @JvmStatic
    @NotNull
    public static final ToBePickedUpListFragment newInstance(@NotNull String str, @NotNull String str2) {
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

    public static final /* synthetic */ BaseFragment.ErrorType access$getErrorType$p(ToBePickedUpListFragment toBePickedUpListFragment) {
        BaseFragment.ErrorType errorType2 = toBePickedUpListFragment.errorType;
        if (errorType2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorType");
        }
        return errorType2;
    }

    public static final /* synthetic */ ToBePickedUpAdapter access$getPreSaleAdapter$p(ToBePickedUpListFragment toBePickedUpListFragment) {
        ToBePickedUpAdapter toBePickedUpAdapter = toBePickedUpListFragment.preSaleAdapter;
        if (toBePickedUpAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleAdapter");
        }
        return toBePickedUpAdapter;
    }

    public static final /* synthetic */ ToPickedUpAccountActivity access$getPreSaleListAccountActivity$p(ToBePickedUpListFragment toBePickedUpListFragment) {
        ToPickedUpAccountActivity toPickedUpAccountActivity = toBePickedUpListFragment.preSaleListAccountActivity;
        if (toPickedUpAccountActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListAccountActivity");
        }
        return toPickedUpAccountActivity;
    }

    public static final /* synthetic */ ToBePickedUpViewModel access$getViewModel$p(ToBePickedUpListFragment toBePickedUpListFragment) {
        ToBePickedUpViewModel toBePickedUpViewModel = toBePickedUpListFragment.viewModel;
        if (toBePickedUpViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return toBePickedUpViewModel;
    }

    @Nullable
    public final String getSortBy() {
        return this.sortBy;
    }

    public final void setSortBy(@Nullable String str) {
        this.sortBy = str;
    }

    public final int getSortDirection() {
        return this.sortDirection;
    }

    public final void setSortDirection(int i) {
        this.sortDirection = i;
    }

    public final boolean isTablet() {
        return this.isTablet;
    }

    public final void setTablet(boolean z) {
        this.isTablet = z;
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
    public final View getViewWatchList() {
        return this.viewWatchList;
    }

    public final void setViewWatchList(@Nullable View view) {
        this.viewWatchList = view;
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
        ToPickedUpAccountActivity toPickedUpAccountActivity = this.preSaleListAccountActivity;
        if (toPickedUpAccountActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListAccountActivity");
        }
        FragmentActivity fragmentActivity = toPickedUpAccountActivity;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(ToBePickedUpViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(pr…dUpViewModel::class.java)");
        this.viewModel = (ToBePickedUpViewModel) viewModel2;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.preSaleListAccountActivity = (ToPickedUpAccountActivity) activity;
            if (context instanceof ToPickedUpAccountActivity) {
                this.preSaleListAccountActivity = (ToPickedUpAccountActivity) context;
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.tobepickedup.ToPickedUpAccountActivity");
    }

    public void onStart() {
        super.onStart();
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        ToPickedUpAccountActivity toPickedUpAccountActivity = this.preSaleListAccountActivity;
        if (toPickedUpAccountActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListAccountActivity");
        }
        this.isTablet = toPickedUpAccountActivity.getResources().getBoolean(C2723R.bool.isTabletPhone);
        if (this.viewWatchList == null) {
            if (this.isTablet) {
                ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.activity_watch_list_land, viewGroup, false);
                Intrinsics.checkExpressionValueIsNotNull(inflate, "mBinding");
                this.viewWatchList = inflate.getRoot();
            } else {
                ViewDataBinding inflate2 = DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.fragment_watch_list, viewGroup, false);
                Intrinsics.checkExpressionValueIsNotNull(inflate2, "mBinding");
                this.viewWatchList = inflate2.getRoot();
            }
        }
        return this.viewWatchList;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        ToPickedUpAccountActivity toPickedUpAccountActivity = this.preSaleListAccountActivity;
        if (toPickedUpAccountActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListAccountActivity");
        }
        ImageView imageView = (ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_tobePickUp);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "preSaleListAccountActivity.arrow_left_tobePickUp");
        imageView.setVisibility(8);
        ToPickedUpAccountActivity toPickedUpAccountActivity2 = this.preSaleListAccountActivity;
        if (toPickedUpAccountActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListAccountActivity");
        }
        ImageView imageView2 = (ImageView) toPickedUpAccountActivity2._$_findCachedViewById(C2723R.C2726id.arrow_right_tobePickUp);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, "preSaleListAccountActivity.arrow_right_tobePickUp");
        imageView2.setVisibility(8);
        ToPickedUpAccountActivity toPickedUpAccountActivity3 = this.preSaleListAccountActivity;
        if (toPickedUpAccountActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListAccountActivity");
        }
        RelativeLayout relativeLayout = (RelativeLayout) toPickedUpAccountActivity3._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout_toPickUp);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "preSaleListAccountActivi…r_relativelayout_toPickUp");
        relativeLayout.setGravity(GravityCompat.START);
        ToPickedUpAccountActivity toPickedUpAccountActivity4 = this.preSaleListAccountActivity;
        if (toPickedUpAccountActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListAccountActivity");
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) toPickedUpAccountActivity4._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout_toPickUp);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "preSaleListAccountActivi…r_relativelayout_toPickUp");
        relativeLayout2.setGravity(3);
        ToPickedUpAccountActivity toPickedUpAccountActivity5 = this.preSaleListAccountActivity;
        if (toPickedUpAccountActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListAccountActivity");
        }
        toPickedUpAccountActivity5.getIvStockShare().setVisibility(8);
        if (this.isTablet) {
            ToPickedUpAccountActivity toPickedUpAccountActivity6 = this.preSaleListAccountActivity;
            if (toPickedUpAccountActivity6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preSaleListAccountActivity");
            }
            NavController findNavController = Navigation.findNavController(toPickedUpAccountActivity6, C2723R.C2726id.auction_sales_nav_container);
            Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…tion_sales_nav_container)");
            NavInflater navInflater = findNavController.getNavInflater();
            Intrinsics.checkExpressionValueIsNotNull(navInflater, "navController.navInflater");
            NavGraph inflate = navInflater.inflate(C2723R.C2730navigation.navigation_graph_auction_saleslist);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "navInflater.inflate(R.na…_graph_auction_saleslist)");
            NavArgument build = new NavArgument.Builder().setDefaultValue("34567845").build();
            Intrinsics.checkExpressionValueIsNotNull(build, "NavArgument.Builder().se…aultValue(itemId).build()");
            inflate.addArgument(Constants.EXTRA_ITEM_ID, build);
            findNavController.setGraph(inflate);
        }
        ToPickedUpAccountActivity toPickedUpAccountActivity7 = this.preSaleListAccountActivity;
        if (toPickedUpAccountActivity7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListAccountActivity");
        }
        Application application = toPickedUpAccountActivity7.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "preSaleListAccountActivity.application");
        String userIdPreferencesMVVM = IAASharedPreference.getUserIdPreferencesMVVM(application.getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(userIdPreferencesMVVM, "IAASharedPreference.getU…ation.applicationContext)");
        this.userId = userIdPreferencesMVVM;
        if (this.isFristTime) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                Intrinsics.throwNpe();
            }
            this.totalCount = arguments.getInt(Constants.WATCHING_SIZE);
            this.totalCountWatchDashBoard = this.totalCount;
            Bundle arguments2 = getArguments();
            if (arguments2 == null) {
                Intrinsics.throwNpe();
            }
            if (arguments2.containsKey("isMyItemOnly")) {
                Bundle arguments3 = getArguments();
                if (arguments3 == null) {
                    Intrinsics.throwNpe();
                }
                this.isMyItemsOnly = arguments3.getBoolean("isMyItemOnly", false);
            }
        }
        if (this.isFristTime) {
            initializeRecycler();
            checkNetworkConnection();
        }
        setToolBarTitle();
    }

    public final void setToolBarTitle() {
        ToPickedUpAccountActivity toPickedUpAccountActivity = this.preSaleListAccountActivity;
        if (toPickedUpAccountActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListAccountActivity");
        }
        toPickedUpAccountActivity.getToolbar_title().setText(getResources().getString(C2723R.string.lbl_pick_up));
        setToolbarCount(this.totalCount);
    }

    public final void setToolbarCount(int i) {
        this.totalCount = i;
        ToPickedUpAccountActivity toPickedUpAccountActivity = this.preSaleListAccountActivity;
        if (toPickedUpAccountActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListAccountActivity");
        }
        toPickedUpAccountActivity.getToolbar_sub_title().setVisibility(0);
        ToPickedUpAccountActivity toPickedUpAccountActivity2 = this.preSaleListAccountActivity;
        if (toPickedUpAccountActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListAccountActivity");
        }
        TextView toolbar_sub_title = toPickedUpAccountActivity2.getToolbar_sub_title();
        toolbar_sub_title.setText(i + " Results");
    }

    /* access modifiers changed from: private */
    public final void setDashBoardCountAtSharePreference(int i) {
        ToPickedUpAccountActivity toPickedUpAccountActivity = this.preSaleListAccountActivity;
        if (toPickedUpAccountActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListAccountActivity");
        }
        IAASharedPreference.setDashBoardCount(toPickedUpAccountActivity, Constants_MVVM.KEY_FOR_TBPU_COUNT_MYACCOUNT, i);
    }

    /* access modifiers changed from: private */
    public final void fetchWatchList() {
        String str;
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
        ToBePickedUpViewModel toBePickedUpViewModel = this.viewModel;
        if (toBePickedUpViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SessionManager sessionManager4 = this.sessionManager;
        if (sessionManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        String currentSessionUserId = sessionManager4.getCurrentSessionUserId();
        String str2 = currentSessionUserId != null ? currentSessionUserId : "";
        boolean z = this.isMyItemsOnly;
        String str3 = this.sortBy;
        if (str3 != null) {
            str = str3;
        } else {
            str = "";
        }
        toBePickedUpViewModel.fetchToBePickedUpList(format, str2, 1, z, str, this.sortDirection);
        showLoadingIndicator(true);
        subscribeToViewModel();
    }

    private final void checkNetworkConnection() {
        if (InternetUtil.INSTANCE.isInternetOn()) {
            fetchWatchList();
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
        InternetUtil.INSTANCE.observe(this, new ToBePickedUpListFragment$checkNetworkConnection$1(this));
    }

    private final void initializeRecycler() {
        this.isFristTime = false;
        ToPickedUpAccountActivity toPickedUpAccountActivity = this.preSaleListAccountActivity;
        if (toPickedUpAccountActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListAccountActivity");
        }
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(toPickedUpAccountActivity, 1);
        ToPickedUpAccountActivity toPickedUpAccountActivity2 = this.preSaleListAccountActivity;
        if (toPickedUpAccountActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListAccountActivity");
        }
        Application application = toPickedUpAccountActivity2.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "preSaleListAccountActivity.application");
        Drawable drawable = ContextCompat.getDrawable(application.getApplicationContext(), C2723R.C2725drawable.line_decoration);
        if (drawable == null) {
            Intrinsics.throwNpe();
        }
        dividerItemDecoration.setDrawable(drawable);
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvWatchList)).addItemDecoration(dividerItemDecoration);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity!!");
        Context applicationContext = activity.getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "activity!!.applicationContext");
        this.preSaleAdapter = new ToBePickedUpAdapter(applicationContext, new ToBePickedUpListFragment$initializeRecycler$1(this));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvWatchList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvWatchList");
        ToBePickedUpAdapter toBePickedUpAdapter = this.preSaleAdapter;
        if (toBePickedUpAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleAdapter");
        }
        recyclerView.setAdapter(toBePickedUpAdapter);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvWatchList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvWatchList");
        ToPickedUpAccountActivity toPickedUpAccountActivity3 = this.preSaleListAccountActivity;
        if (toPickedUpAccountActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListAccountActivity");
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(toPickedUpAccountActivity3));
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvWatchList)).addOnScrollListener(new ToBePickedUpListFragment$initializeRecycler$2(this));
        ((FloatingActionButton) _$_findCachedViewById(C2723R.C2726id.fab)).setOnClickListener(new ToBePickedUpListFragment$initializeRecycler$3(this));
    }

    private final void subscribeToViewModel() {
        ToBePickedUpViewModel toBePickedUpViewModel = this.viewModel;
        if (toBePickedUpViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        toBePickedUpViewModel.getResultLiveData().observe(lifecycleOwner, new ToBePickedUpListFragment$subscribeToViewModel$1(this));
        ToBePickedUpViewModel toBePickedUpViewModel2 = this.viewModel;
        if (toBePickedUpViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        toBePickedUpViewModel2.getNetworkState().observe(lifecycleOwner, ToBePickedUpListFragment$subscribeToViewModel$2.INSTANCE);
        ToBePickedUpViewModel toBePickedUpViewModel3 = this.viewModel;
        if (toBePickedUpViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        toBePickedUpViewModel3.getScrollSearchListToTop().observe(lifecycleOwner, new ToBePickedUpListFragment$subscribeToViewModel$3(this));
        ToBePickedUpViewModel toBePickedUpViewModel4 = this.viewModel;
        if (toBePickedUpViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        toBePickedUpViewModel4.getPreSalesListResponse().observe(lifecycleOwner, new ToBePickedUpListFragment$subscribeToViewModel$4(this));
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

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/tobepickedup/ToBePickedUpListFragment$Companion;", "", "()V", "newInstance", "Lcom/iaai/android/bdt/feature/account/tobepickedup/ToBePickedUpListFragment;", "param1", "", "param2", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ToBePickedUpFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final ToBePickedUpListFragment newInstance(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkParameterIsNotNull(str, "param1");
            Intrinsics.checkParameterIsNotNull(str2, "param2");
            ToBePickedUpListFragment toBePickedUpListFragment = new ToBePickedUpListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("param1", str);
            bundle.putString("param2", str2);
            toBePickedUpListFragment.setArguments(bundle);
            return toBePickedUpListFragment;
        }
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
            int[] r3 = com.iaai.android.bdt.feature.account.tobepickedup.ToBePickedUpListFragment.WhenMappings.$EnumSwitchMapping$0
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
            com.iaai.android.bdt.feature.account.tobepickedup.ToBePickedUpAdapter r6 = r5.preSaleAdapter
            java.lang.String r1 = "preSaleAdapter"
            if (r6 != 0) goto L_0x010d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x010d:
            r6.setHeaderItem(r0)
            com.iaai.android.bdt.feature.account.tobepickedup.ToBePickedUpAdapter r6 = r5.preSaleAdapter
            if (r6 != 0) goto L_0x0117
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0117:
            r6.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.account.tobepickedup.ToBePickedUpListFragment.addHeaderToAuctionSalesList(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
        r2 = r2.getExtras();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r2, int r3, @org.jetbrains.annotations.Nullable android.content.Intent r4) {
        /*
            r1 = this;
            r2 = 1
            if (r3 == r2) goto L_0x0006
            r2 = 2
            if (r3 != r2) goto L_0x0061
        L_0x0006:
            if (r4 == 0) goto L_0x0061
            r1.intent = r4
            android.content.Intent r2 = r1.intent
            r3 = 0
            if (r2 == 0) goto L_0x0021
            android.os.Bundle r2 = r2.getExtras()
            if (r2 == 0) goto L_0x0021
            r4 = 0
            java.lang.String r0 = "search_selected_sort_position"
            int r2 = r2.getInt(r0, r4)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0022
        L_0x0021:
            r2 = r3
        L_0x0022:
            if (r2 != 0) goto L_0x0027
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0027:
            int r2 = r2.intValue()
            r1.lastSelectedSort = r2
            android.content.Intent r2 = r1.intent
            if (r2 == 0) goto L_0x003e
            android.os.Bundle r2 = r2.getExtras()
            if (r2 == 0) goto L_0x003e
            java.lang.String r4 = "sortDirection"
            java.lang.String r2 = r2.getString(r4)
            goto L_0x003f
        L_0x003e:
            r2 = r3
        L_0x003f:
            if (r2 != 0) goto L_0x0044
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0044:
            int r2 = java.lang.Integer.parseInt(r2)
            r1.sortDirection = r2
            android.content.Intent r2 = r1.intent
            if (r2 == 0) goto L_0x005c
            android.os.Bundle r2 = r2.getExtras()
            if (r2 == 0) goto L_0x005c
            java.lang.String r3 = "sortBy"
            java.lang.String r4 = ""
            java.lang.String r3 = r2.getString(r3, r4)
        L_0x005c:
            r1.sortBy = r3
            r1.fetchWatchList()
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.account.tobepickedup.ToBePickedUpListFragment.onActivityResult(int, int, android.content.Intent):void");
    }

    /* access modifiers changed from: private */
    public final SortOptionData createSortOptionData(String str, int i, boolean z) {
        if (i == 0) {
            return new SortOptionData(str, Constants.TO_BE_PAID_SRT_BRANCH, "0", z);
        }
        if (i == 1) {
            return new SortOptionData(str, Constants.TO_BE_PAID_SRT_BRANCH, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
        }
        if (i == 2) {
            return new SortOptionData(str, "ActionDue", "0", z);
        }
        if (i != 3) {
            return new SortOptionData(str, "ActionDue", "0", z);
        }
        return new SortOptionData(str, "ActionDue", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
    }

    public void onDestroy() {
        super.onDestroy();
        ToBePickedUpViewModel toBePickedUpViewModel = this.viewModel;
        if (toBePickedUpViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        toBePickedUpViewModel.disposeElements();
    }
}
