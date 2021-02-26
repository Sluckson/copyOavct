package com.iaai.android.bdt.feature.fastSearchFilter.savedSearch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.model.savedSearchList.SavedSearchListResponse;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.InternetUtil;
import com.iaai.android.old.utils.AppUtils;
import dagger.android.AndroidInjection;
import java.util.Arrays;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u001cH\u0002J\u0012\u0010!\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\b\u0010$\u001a\u00020\u001cH\u0016J\u0012\u0010%\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010'H\u0014J\u0010\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\nH\u0002J\b\u0010-\u001a\u00020\u001cH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006."}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/savedSearch/SavedSearchActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "()V", "CONTENT_TYPE", "", "getCONTENT_TYPE", "()Ljava/lang/String;", "errorType", "Lcom/iaai/android/bdt/base/BaseFragment$ErrorType;", "isError", "", "savedSearchAdapter", "Lcom/iaai/android/bdt/feature/fastSearchFilter/savedSearch/SavedSearchAdapter;", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "viewModel", "Lcom/iaai/android/bdt/feature/fastSearchFilter/savedSearch/SavedSearchListViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "checkNetworkConnection", "", "deleteSavedSearch", "searchName", "fetchSavedSearchList", "initializeRecycler", "navigateToResultPageNew", "savedSearchResponse", "Lcom/iaai/android/bdt/model/savedSearchList/SavedSearchListResponse;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "showLoadingIndicator", "loading", "subscribeToViewModel", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SavedSearchActivity.kt */
public final class SavedSearchActivity extends BaseActivity {
    @NotNull
    private final String CONTENT_TYPE = "application/json";
    private HashMap _$_findViewCache;
    private BaseFragment.ErrorType errorType;
    private boolean isError;
    /* access modifiers changed from: private */
    public SavedSearchAdapter savedSearchAdapter;
    @Inject
    @NotNull
    public SessionManager sessionManager;
    private SavedSearchListViewModel viewModel;
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

    public static final /* synthetic */ SavedSearchAdapter access$getSavedSearchAdapter$p(SavedSearchActivity savedSearchActivity) {
        SavedSearchAdapter savedSearchAdapter2 = savedSearchActivity.savedSearchAdapter;
        if (savedSearchAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedSearchAdapter");
        }
        return savedSearchAdapter2;
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
    public final String getCONTENT_TYPE() {
        return this.CONTENT_TYPE;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_saved_search_list);
        FragmentActivity fragmentActivity = this;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(SavedSearchListViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…istViewModel::class.java)");
        this.viewModel = (SavedSearchListViewModel) viewModel2;
        initializeRecycler();
        checkNetworkConnection();
        subscribeToViewModel();
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.img_back)).setOnClickListener(new SavedSearchActivity$onCreate$1(this));
    }

    private final void initializeRecycler() {
        Context context = this;
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvSavedSearchList)).addItemDecoration(new DividerItemDecoration(context, 1));
        this.savedSearchAdapter = new SavedSearchAdapter(context, new SavedSearchActivity$initializeRecycler$1(this));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvSavedSearchList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvSavedSearchList");
        SavedSearchAdapter savedSearchAdapter2 = this.savedSearchAdapter;
        if (savedSearchAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedSearchAdapter");
        }
        recyclerView.setAdapter(savedSearchAdapter2);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvSavedSearchList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvSavedSearchList");
        recyclerView2.setVerticalScrollBarEnabled(true);
        RecyclerView recyclerView3 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvSavedSearchList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView3, "rvSavedSearchList");
        recyclerView3.setLayoutManager(new LinearLayoutManager(context));
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvSavedSearchList)).addOnScrollListener(new SavedSearchActivity$initializeRecycler$2(this));
        ((FloatingActionButton) _$_findCachedViewById(C2723R.C2726id.savedSearchFab)).setOnClickListener(new SavedSearchActivity$initializeRecycler$3(this));
    }

    /* access modifiers changed from: private */
    public final void navigateToResultPageNew(SavedSearchListResponse savedSearchListResponse) {
        Intent intent = new Intent();
        intent.putExtra(Constants_MVVM.EXTRA_IS_FROM_LANDING_PAGE_SEARCH, true);
        intent.putExtra(Constants_MVVM.EXTRA_SAVED_SEARCH_PARAM, new Gson().toJson((Object) savedSearchListResponse));
        setResult(106, intent);
        finish();
    }

    private final void checkNetworkConnection() {
        if (InternetUtil.INSTANCE.isInternetOn()) {
            fetchSavedSearchList();
            return;
        }
        this.errorType = BaseFragment.ErrorType.NO_INTERNET;
        this.isError = true;
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.emptyRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "emptyRecyclerView");
        linearLayout.setVisibility(0);
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.errorTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "errorTitle");
        textView.setText(BaseFragment.ErrorType.NO_INTERNET.toString());
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.errorBody);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "errorBody");
        textView2.setText(getString(C2723R.string.lbl_msg_no_internet_connection));
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
        InternetUtil.INSTANCE.observe(this, new SavedSearchActivity$checkNetworkConnection$1(this));
    }

    /* access modifiers changed from: private */
    public final void fetchSavedSearchList() {
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
        SavedSearchListViewModel savedSearchListViewModel = this.viewModel;
        if (savedSearchListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        String deviceId = AppUtils.getDeviceId(this);
        if (deviceId == null) {
            deviceId = "";
        }
        savedSearchListViewModel.getSavedSearchList(format, deviceId, "android", Constants_MVVM.SEARCH_API_KEY, this.CONTENT_TYPE, String.valueOf(1));
        showLoadingIndicator(true);
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbSavedSearch);
            if (progressBar != null) {
                progressBar.setVisibility(0);
                return;
            }
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbSavedSearch);
        if (progressBar2 != null) {
            progressBar2.setVisibility(8);
        }
    }

    private final void subscribeToViewModel() {
        SavedSearchListViewModel savedSearchListViewModel = this.viewModel;
        if (savedSearchListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        savedSearchListViewModel.getSavedSearchListResponse().observe(lifecycleOwner, new SavedSearchActivity$subscribeToViewModel$1(this));
        SavedSearchListViewModel savedSearchListViewModel2 = this.viewModel;
        if (savedSearchListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        savedSearchListViewModel2.getSavedSearchListError().observe(lifecycleOwner, new SavedSearchActivity$subscribeToViewModel$2(this));
        SavedSearchListViewModel savedSearchListViewModel3 = this.viewModel;
        if (savedSearchListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        savedSearchListViewModel3.getDeleteSavedSearch().observe(lifecycleOwner, new SavedSearchActivity$subscribeToViewModel$3(this));
        SavedSearchListViewModel savedSearchListViewModel4 = this.viewModel;
        if (savedSearchListViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        savedSearchListViewModel4.getDeleteSavedSearchError().observe(lifecycleOwner, SavedSearchActivity$subscribeToViewModel$4.INSTANCE);
    }

    /* access modifiers changed from: private */
    public final void deleteSavedSearch(String str) {
        String str2;
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
        SavedSearchListViewModel savedSearchListViewModel = this.viewModel;
        if (savedSearchListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        String str3 = this.CONTENT_TYPE;
        String deviceId = AppUtils.getDeviceId(this);
        String str4 = deviceId != null ? deviceId : "";
        String valueOf = String.valueOf(1);
        if (str != null) {
            str2 = str;
        } else {
            str2 = "";
        }
        savedSearchListViewModel.deleteSavedSearch(str3, format, "android", str4, Constants_MVVM.SEARCH_API_KEY, valueOf, str2);
    }

    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}
