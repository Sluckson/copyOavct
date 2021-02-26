package com.iaai.android.bdt.feature.account.buyNowOfferList;

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
import androidx.lifecycle.LiveData;
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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.model.MyAccount.BuyNowOfferListResponse;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.InternetUtil;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import dagger.android.support.AndroidSupportInjection;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 Y2\u00020\u0001:\u0001YB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0004H\u0002J\b\u0010B\u001a\u00020@H\u0002J\b\u0010C\u001a\u00020@H\u0002J\b\u0010D\u001a\u00020@H\u0002J\u0012\u0010E\u001a\u00020@2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u0010\u0010H\u001a\u00020@2\u0006\u0010I\u001a\u00020JH\u0016J\u0012\u0010K\u001a\u00020@2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J&\u0010L\u001a\u0004\u0018\u0001012\u0006\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\b\u0010Q\u001a\u00020@H\u0016J\b\u0010R\u001a\u00020@H\u0016J\u0010\u0010S\u001a\u00020@2\u0006\u0010-\u001a\u00020\rH\u0002J\u0006\u0010T\u001a\u00020@J\u000e\u0010U\u001a\u00020@2\u0006\u0010-\u001a\u00020\rJ\u0010\u0010V\u001a\u00020@2\u0006\u0010W\u001a\u00020\u0017H\u0002J\b\u0010X\u001a\u00020@H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u000e\u00106\u001a\u000207X.¢\u0006\u0002\n\u0000R\u001e\u00108\u001a\u0002098\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/buyNowOfferList/BuyNowOfferListFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "buyNowOfferCloseTime", "buyNowOfferListActivity", "Lcom/iaai/android/bdt/feature/account/buyNowOfferList/BuyNowOfferListActivity;", "buyNowOfferListAdapter", "Lcom/iaai/android/bdt/feature/account/buyNowOfferList/BuyNowOfferListAdapter;", "closeTime", "currentCount", "", "errorType", "Lcom/iaai/android/bdt/base/BaseFragment$ErrorType;", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "isError", "", "isFristTime", "isTablet", "()Z", "setTablet", "(Z)V", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "sortBy", "getSortBy", "()Ljava/lang/String;", "setSortBy", "(Ljava/lang/String;)V", "sortDirection", "getSortDirection", "()I", "setSortDirection", "(I)V", "totalCount", "totalCountWatchDashBoard", "userId", "viewBuyOfferList", "Landroid/view/View;", "getViewBuyOfferList", "()Landroid/view/View;", "setViewBuyOfferList", "(Landroid/view/View;)V", "viewModel", "Lcom/iaai/android/bdt/feature/account/buyNowOfferList/BuyNowOfferListViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "year_make_model", "addHeaderToAuctionSalesList", "", "errorMessage", "checkNetworkConnection", "fetchBuyNowOfferList", "initializeRecycler", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onStart", "setDashBoardCountAtSharePreference", "setToolBarTitle", "setToolbarCount", "showLoadingIndicator", "loading", "subscribeToViewModel", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BuyNowOfferListFragment.kt */
public final class BuyNowOfferListFragment extends BaseFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final String TAG = BuyNowOfferListFragment.class.getSimpleName();
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public String buyNowOfferCloseTime = "";
    /* access modifiers changed from: private */
    public BuyNowOfferListActivity buyNowOfferListActivity;
    /* access modifiers changed from: private */
    public BuyNowOfferListAdapter buyNowOfferListAdapter;
    /* access modifiers changed from: private */
    public String closeTime = "";
    /* access modifiers changed from: private */
    public int currentCount;
    /* access modifiers changed from: private */
    public BaseFragment.ErrorType errorType;
    @Nullable
    private Intent intent;
    /* access modifiers changed from: private */
    public boolean isError;
    private boolean isFristTime = true;
    private boolean isTablet;
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
    @Nullable
    private View viewBuyOfferList;
    /* access modifiers changed from: private */
    public BuyNowOfferListViewModel viewModel;
    @Inject
    @NotNull
    public ViewModelProvider.Factory viewModelFactory;
    /* access modifiers changed from: private */
    public String year_make_model = "";

    @JvmStatic
    @NotNull
    public static final BuyNowOfferListFragment newInstance(@NotNull String str, @NotNull String str2) {
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

    public static final /* synthetic */ BuyNowOfferListActivity access$getBuyNowOfferListActivity$p(BuyNowOfferListFragment buyNowOfferListFragment) {
        BuyNowOfferListActivity buyNowOfferListActivity2 = buyNowOfferListFragment.buyNowOfferListActivity;
        if (buyNowOfferListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyNowOfferListActivity");
        }
        return buyNowOfferListActivity2;
    }

    public static final /* synthetic */ BuyNowOfferListAdapter access$getBuyNowOfferListAdapter$p(BuyNowOfferListFragment buyNowOfferListFragment) {
        BuyNowOfferListAdapter buyNowOfferListAdapter2 = buyNowOfferListFragment.buyNowOfferListAdapter;
        if (buyNowOfferListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyNowOfferListAdapter");
        }
        return buyNowOfferListAdapter2;
    }

    public static final /* synthetic */ BaseFragment.ErrorType access$getErrorType$p(BuyNowOfferListFragment buyNowOfferListFragment) {
        BaseFragment.ErrorType errorType2 = buyNowOfferListFragment.errorType;
        if (errorType2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorType");
        }
        return errorType2;
    }

    public static final /* synthetic */ BuyNowOfferListViewModel access$getViewModel$p(BuyNowOfferListFragment buyNowOfferListFragment) {
        BuyNowOfferListViewModel buyNowOfferListViewModel = buyNowOfferListFragment.viewModel;
        if (buyNowOfferListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return buyNowOfferListViewModel;
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
    public final View getViewBuyOfferList() {
        return this.viewBuyOfferList;
    }

    public final void setViewBuyOfferList(@Nullable View view) {
        this.viewBuyOfferList = view;
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
        BuyNowOfferListActivity buyNowOfferListActivity2 = this.buyNowOfferListActivity;
        if (buyNowOfferListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyNowOfferListActivity");
        }
        FragmentActivity fragmentActivity = buyNowOfferListActivity2;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(BuyNowOfferListViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(bu…istViewModel::class.java)");
        this.viewModel = (BuyNowOfferListViewModel) viewModel2;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.buyNowOfferListActivity = (BuyNowOfferListActivity) activity;
            if (context instanceof BuyNowOfferListActivity) {
                this.buyNowOfferListActivity = (BuyNowOfferListActivity) context;
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListActivity");
    }

    public void onStart() {
        super.onStart();
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        BuyNowOfferListActivity buyNowOfferListActivity2 = this.buyNowOfferListActivity;
        if (buyNowOfferListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyNowOfferListActivity");
        }
        this.isTablet = buyNowOfferListActivity2.getResources().getBoolean(C2723R.bool.isTabletPhone);
        if (this.viewBuyOfferList == null) {
            if (this.isTablet) {
                ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.activity_buy_now_offer_list_land, viewGroup, false);
                Intrinsics.checkExpressionValueIsNotNull(inflate, "mBinding");
                this.viewBuyOfferList = inflate.getRoot();
            } else {
                ViewDataBinding inflate2 = DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.fragment_buy_now_offer_list, viewGroup, false);
                Intrinsics.checkExpressionValueIsNotNull(inflate2, "mBinding");
                this.viewBuyOfferList = inflate2.getRoot();
            }
        }
        return this.viewBuyOfferList;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        BuyNowOfferListActivity buyNowOfferListActivity2 = this.buyNowOfferListActivity;
        if (buyNowOfferListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyNowOfferListActivity");
        }
        ImageView imageView = (ImageView) buyNowOfferListActivity2._$_findCachedViewById(C2723R.C2726id.arrow_left_buy_now);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "buyNowOfferListActivity.arrow_left_buy_now");
        imageView.setVisibility(8);
        BuyNowOfferListActivity buyNowOfferListActivity3 = this.buyNowOfferListActivity;
        if (buyNowOfferListActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyNowOfferListActivity");
        }
        ImageView imageView2 = (ImageView) buyNowOfferListActivity3._$_findCachedViewById(C2723R.C2726id.arrow_right_buy_now);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, "buyNowOfferListActivity.arrow_right_buy_now");
        imageView2.setVisibility(8);
        BuyNowOfferListActivity buyNowOfferListActivity4 = this.buyNowOfferListActivity;
        if (buyNowOfferListActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyNowOfferListActivity");
        }
        RelativeLayout relativeLayout = (RelativeLayout) buyNowOfferListActivity4._$_findCachedViewById(C2723R.C2726id.buynow_toolbar_relativelayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "buyNowOfferListActivity.…ow_toolbar_relativelayout");
        relativeLayout.setGravity(GravityCompat.START);
        BuyNowOfferListActivity buyNowOfferListActivity5 = this.buyNowOfferListActivity;
        if (buyNowOfferListActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyNowOfferListActivity");
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) buyNowOfferListActivity5._$_findCachedViewById(C2723R.C2726id.buynow_toolbar_relativelayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "buyNowOfferListActivity.…ow_toolbar_relativelayout");
        relativeLayout2.setGravity(3);
        BuyNowOfferListActivity buyNowOfferListActivity6 = this.buyNowOfferListActivity;
        if (buyNowOfferListActivity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyNowOfferListActivity");
        }
        buyNowOfferListActivity6.getIvStockShare().setVisibility(8);
        if (this.isTablet) {
            BuyNowOfferListActivity buyNowOfferListActivity7 = this.buyNowOfferListActivity;
            if (buyNowOfferListActivity7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("buyNowOfferListActivity");
            }
            NavController findNavController = Navigation.findNavController(buyNowOfferListActivity7, C2723R.C2726id.auction_sales_nav_container);
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
        BuyNowOfferListActivity buyNowOfferListActivity8 = this.buyNowOfferListActivity;
        if (buyNowOfferListActivity8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyNowOfferListActivity");
        }
        Application application = buyNowOfferListActivity8.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "buyNowOfferListActivity.application");
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
            initializeRecycler();
            checkNetworkConnection();
        }
        setToolBarTitle();
    }

    public final void setToolBarTitle() {
        BuyNowOfferListActivity buyNowOfferListActivity2 = this.buyNowOfferListActivity;
        if (buyNowOfferListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyNowOfferListActivity");
        }
        buyNowOfferListActivity2.getToolbar_title().setText(getResources().getString(C2723R.string.lbl_buy_now_offer));
        setToolbarCount(this.totalCount);
    }

    public final void setToolbarCount(int i) {
        this.totalCount = i;
        BuyNowOfferListActivity buyNowOfferListActivity2 = this.buyNowOfferListActivity;
        if (buyNowOfferListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyNowOfferListActivity");
        }
        buyNowOfferListActivity2.getToolbar_sub_title().setVisibility(0);
        BuyNowOfferListActivity buyNowOfferListActivity3 = this.buyNowOfferListActivity;
        if (buyNowOfferListActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyNowOfferListActivity");
        }
        TextView toolbar_sub_title = buyNowOfferListActivity3.getToolbar_sub_title();
        toolbar_sub_title.setText(i + " Results");
    }

    /* access modifiers changed from: private */
    public final void setDashBoardCountAtSharePreference(int i) {
        BuyNowOfferListActivity buyNowOfferListActivity2 = this.buyNowOfferListActivity;
        if (buyNowOfferListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyNowOfferListActivity");
        }
        IAASharedPreference.setDashBoardCount(buyNowOfferListActivity2, Constants_MVVM.KEY_FOR_BUY_NOW_OFFER_COUNT_MYACCOUNT, i);
    }

    /* access modifiers changed from: private */
    public final void fetchBuyNowOfferList() {
        BuyNowOfferListViewModel buyNowOfferListViewModel = this.viewModel;
        if (buyNowOfferListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        String currentSessionUserId = sessionManager2.getCurrentSessionUserId();
        if (currentSessionUserId == null) {
            currentSessionUserId = "";
        }
        buyNowOfferListViewModel.fetchBuyNowOfferList(currentSessionUserId, 1);
        BuyNowOfferListViewModel buyNowOfferListViewModel2 = this.viewModel;
        if (buyNowOfferListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        buyNowOfferListViewModel2.loadBuyNowOfferCloseTime();
        showLoadingIndicator(true);
        subscribeToViewModel();
    }

    private final void checkNetworkConnection() {
        if (InternetUtil.INSTANCE.isInternetOn()) {
            fetchBuyNowOfferList();
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
        InternetUtil.INSTANCE.observe(this, new BuyNowOfferListFragment$checkNetworkConnection$1(this));
    }

    private final void initializeRecycler() {
        this.isFristTime = false;
        BuyNowOfferListActivity buyNowOfferListActivity2 = this.buyNowOfferListActivity;
        if (buyNowOfferListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyNowOfferListActivity");
        }
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(buyNowOfferListActivity2, 1);
        BuyNowOfferListActivity buyNowOfferListActivity3 = this.buyNowOfferListActivity;
        if (buyNowOfferListActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyNowOfferListActivity");
        }
        Application application = buyNowOfferListActivity3.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "buyNowOfferListActivity.application");
        Drawable drawable = ContextCompat.getDrawable(application.getApplicationContext(), C2723R.C2725drawable.line_decoration);
        if (drawable == null) {
            Intrinsics.throwNpe();
        }
        dividerItemDecoration.setDrawable(drawable);
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvBuyNowOfferList)).addItemDecoration(dividerItemDecoration);
        BuyNowOfferListViewModel buyNowOfferListViewModel = this.viewModel;
        if (buyNowOfferListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity!!");
        Context applicationContext = activity.getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "activity!!.applicationContext");
        this.buyNowOfferListAdapter = new BuyNowOfferListAdapter(buyNowOfferListViewModel, applicationContext, new BuyNowOfferListFragment$initializeRecycler$1(this));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvBuyNowOfferList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvBuyNowOfferList");
        BuyNowOfferListAdapter buyNowOfferListAdapter2 = this.buyNowOfferListAdapter;
        if (buyNowOfferListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyNowOfferListAdapter");
        }
        recyclerView.setAdapter(buyNowOfferListAdapter2);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvBuyNowOfferList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvBuyNowOfferList");
        BuyNowOfferListActivity buyNowOfferListActivity4 = this.buyNowOfferListActivity;
        if (buyNowOfferListActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buyNowOfferListActivity");
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(buyNowOfferListActivity4));
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvBuyNowOfferList)).addOnScrollListener(new BuyNowOfferListFragment$initializeRecycler$2(this));
        ((FloatingActionButton) _$_findCachedViewById(C2723R.C2726id.fab)).setOnClickListener(new BuyNowOfferListFragment$initializeRecycler$3(this));
    }

    private final void subscribeToViewModel() {
        BuyNowOfferListViewModel buyNowOfferListViewModel = this.viewModel;
        if (buyNowOfferListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        buyNowOfferListViewModel.getBuyNowOfferListError().observe(lifecycleOwner, new BuyNowOfferListFragment$subscribeToViewModel$1(this));
        BuyNowOfferListViewModel buyNowOfferListViewModel2 = this.viewModel;
        if (buyNowOfferListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        buyNowOfferListViewModel2.getResultLiveData().observe(lifecycleOwner, new BuyNowOfferListFragment$subscribeToViewModel$2(this));
        BuyNowOfferListViewModel buyNowOfferListViewModel3 = this.viewModel;
        if (buyNowOfferListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        buyNowOfferListViewModel3.getBuyNowOfferCloseTime().observe(lifecycleOwner, new BuyNowOfferListFragment$subscribeToViewModel$3(this));
        BuyNowOfferListViewModel buyNowOfferListViewModel4 = this.viewModel;
        if (buyNowOfferListViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        buyNowOfferListViewModel4.getNetworkState().observe(lifecycleOwner, BuyNowOfferListFragment$subscribeToViewModel$4.INSTANCE);
        BuyNowOfferListViewModel buyNowOfferListViewModel5 = this.viewModel;
        if (buyNowOfferListViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        buyNowOfferListViewModel5.getScrollSearchListToTop().observe(lifecycleOwner, new BuyNowOfferListFragment$subscribeToViewModel$5(this));
        BuyNowOfferListViewModel buyNowOfferListViewModel6 = this.viewModel;
        if (buyNowOfferListViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LiveData<BuyNowOfferListResponse> buyNowListResponse = buyNowOfferListViewModel6.getBuyNowListResponse();
        if (buyNowListResponse != null) {
            buyNowListResponse.observe(lifecycleOwner, new BuyNowOfferListFragment$subscribeToViewModel$6(this));
        }
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

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/buyNowOfferList/BuyNowOfferListFragment$Companion;", "", "()V", "newInstance", "Lcom/iaai/android/bdt/feature/account/buyNowOfferList/BuyNowOfferListFragment;", "param1", "", "param2", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: BuyNowOfferListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final BuyNowOfferListFragment newInstance(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkParameterIsNotNull(str, "param1");
            Intrinsics.checkParameterIsNotNull(str2, "param2");
            BuyNowOfferListFragment buyNowOfferListFragment = new BuyNowOfferListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("param1", str);
            bundle.putString("param2", str2);
            buyNowOfferListFragment.setArguments(bundle);
            return buyNowOfferListFragment;
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
            int[] r3 = com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListFragment.WhenMappings.$EnumSwitchMapping$0
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
            com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListAdapter r6 = r5.buyNowOfferListAdapter
            java.lang.String r1 = "buyNowOfferListAdapter"
            if (r6 != 0) goto L_0x010d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x010d:
            r6.setHeaderItem(r0)
            com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListAdapter r6 = r5.buyNowOfferListAdapter
            if (r6 != 0) goto L_0x0117
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0117:
            r6.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListFragment.addHeaderToAuctionSalesList(java.lang.String):void");
    }

    public void onDestroy() {
        super.onDestroy();
        BuyNowOfferListViewModel buyNowOfferListViewModel = this.viewModel;
        if (buyNowOfferListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        buyNowOfferListViewModel.disposeElements();
    }
}
