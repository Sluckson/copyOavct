package com.iaai.android.bdt.feature.productDetail.chromeSection;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.extensions.Context_ExtensionKt;
import com.iaai.android.bdt.extensions.String_ExtensionKt;
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListActivity;
import com.iaai.android.bdt.model.productDetail.chromeSection.ChromeData;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.InternetUtil;
import com.iaai.android.databinding.FragmentChromeSectionBinding;
import dagger.android.support.AndroidSupportInjection;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0012\u0010\u0018\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\u0016H\u0002J\u0012\u0010)\u001a\u00020\u00162\b\u0010*\u001a\u0004\u0018\u00010+H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/chromeSection/ChromeSectionFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "baseActivity", "Lcom/iaai/android/bdt/base/BaseActivity;", "chromeSectionAdapter", "Lcom/iaai/android/bdt/feature/productDetail/chromeSection/ChromeSectionAdapter;", "itemId", "viewModel", "Lcom/iaai/android/bdt/feature/productDetail/chromeSection/ChromeSectionViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "vinNumber", "yearModel", "checkNetworkConnection", "", "getChromeData", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "showLoadingIndicator", "loading", "", "subscribeToViewModel", "updateChromeSectionUI", "chromeData", "Lcom/iaai/android/bdt/model/productDetail/chromeSection/ChromeData;", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ChromeSectionFragment.kt */
public final class ChromeSectionFragment extends BaseFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_SAMPLE = "sample";
    private final String TAG = ChromeSectionFragment.class.getSimpleName();
    private HashMap _$_findViewCache;
    private BaseActivity baseActivity;
    private ChromeSectionAdapter chromeSectionAdapter;
    private String itemId = "";
    private ChromeSectionViewModel viewModel;
    @Inject
    @NotNull
    public ViewModelProvider.Factory viewModelFactory;
    private String vinNumber = "";
    private String yearModel = "";

    @JvmStatic
    @NotNull
    public static final ChromeSectionFragment newInstance(@NotNull String str) {
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

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/chromeSection/ChromeSectionFragment$Companion;", "", "()V", "KEY_SAMPLE", "", "newInstance", "Lcom/iaai/android/bdt/feature/productDetail/chromeSection/ChromeSectionFragment;", "url", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ChromeSectionFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final ChromeSectionFragment newInstance(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            ChromeSectionFragment chromeSectionFragment = new ChromeSectionFragment();
            Bundle bundle = new Bundle();
            bundle.putString(ChromeSectionFragment.KEY_SAMPLE, str);
            chromeSectionFragment.setArguments(bundle);
            return chromeSectionFragment;
        }
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.baseActivity = (BaseActivity) activity;
            if (context instanceof BaseActivity) {
                this.baseActivity = (BaseActivity) context;
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.base.BaseActivity");
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Fragment fragment = this;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m16of(fragment, factory).get(ChromeSectionViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…ionViewModel::class.java)");
        this.viewModel = (ChromeSectionViewModel) viewModel2;
        IAAAnalytics iAAAnalytics = IAAAnalytics.INSTANCE;
        String value = IAAAnalytics.IAAScreenName.CHROME_DATA.getValue();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity!!");
        iAAAnalytics.logScreenName(value, activity, this);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        FragmentChromeSectionBinding fragmentChromeSectionBinding = (FragmentChromeSectionBinding) DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.fragment_chrome_section, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(fragmentChromeSectionBinding, "mBinding");
        return fragmentChromeSectionBinding.getRoot();
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            Intrinsics.throwNpe();
        }
        String string = arguments.getString(Constants_MVVM.EXTRA_VIN_NUMBER);
        if (string == null) {
            string = "";
        }
        this.vinNumber = string;
        Bundle arguments2 = getArguments();
        if (arguments2 == null) {
            Intrinsics.throwNpe();
        }
        String string2 = arguments2.getString(Constants_MVVM.EXTRA_YEAR_MAKE_MODEL);
        if (string2 == null) {
            string2 = "";
        }
        this.yearModel = string2;
        Bundle arguments3 = getArguments();
        if (arguments3 == null) {
            Intrinsics.throwNpe();
        }
        String string3 = arguments3.getString(Constants_MVVM.EXTRA_ITEM_ID);
        if (string3 == null) {
            string3 = "";
        }
        this.itemId = string3;
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvYearModel);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvYearModel");
        textView.setText(String_ExtensionKt.toCamelCase(this.yearModel));
        subscribeToViewModel();
        checkNetworkConnection();
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        if (baseActivity2 instanceof AuctionSalesListActivity) {
            BaseActivity baseActivity3 = this.baseActivity;
            if (baseActivity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            if (baseActivity3 != null) {
                AuctionSalesListActivity auctionSalesListActivity = (AuctionSalesListActivity) baseActivity3;
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListActivity");
        }
    }

    private final void checkNetworkConnection() {
        if (InternetUtil.INSTANCE.isInternetOn()) {
            getChromeData();
            return;
        }
        Context context = getContext();
        if (context != null) {
            String string = getResources().getString(C2723R.string.lbl_msg_no_internet_connection);
            Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.st…g_no_internet_connection)");
            Context_ExtensionKt.showToast(context, string);
        }
    }

    private final void getChromeData() {
        ChromeSectionViewModel chromeSectionViewModel = this.viewModel;
        if (chromeSectionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        chromeSectionViewModel.getChromeDataByItemId(this.itemId);
    }

    private final void subscribeToViewModel() {
        ChromeSectionViewModel chromeSectionViewModel = this.viewModel;
        if (chromeSectionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<Boolean> showLoading = chromeSectionViewModel.getShowLoading();
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        showLoading.observe(baseActivity2, new ChromeSectionFragment$subscribeToViewModel$1(this));
        ChromeSectionViewModel chromeSectionViewModel2 = this.viewModel;
        if (chromeSectionViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<ChromeData> chromeDataResponse = chromeSectionViewModel2.getChromeDataResponse();
        BaseActivity baseActivity3 = this.baseActivity;
        if (baseActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        chromeDataResponse.observe(baseActivity3, new ChromeSectionFragment$subscribeToViewModel$2(this));
        ChromeSectionViewModel chromeSectionViewModel3 = this.viewModel;
        if (chromeSectionViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<String> chromeDataError = chromeSectionViewModel3.getChromeDataError();
        BaseActivity baseActivity4 = this.baseActivity;
        if (baseActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        chromeDataError.observe(baseActivity4, new ChromeSectionFragment$subscribeToViewModel$3(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0046, code lost:
        r7 = r10.getFactOptionsData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateChromeSectionUI(com.iaai.android.bdt.model.productDetail.chromeSection.ChromeData r10) {
        /*
            r9 = this;
            if (r10 == 0) goto L_0x000f
            com.iaai.android.bdt.model.productDetail.chromeSection.FactOptionsData r0 = r10.getFactOptionsData()
            if (r0 == 0) goto L_0x000f
            java.util.List r0 = r0.getAttributes()
            if (r0 == 0) goto L_0x000f
            goto L_0x0013
        L_0x000f:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0013:
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ 1
            r1 = 0
            java.lang.String r2 = "baseActivity!!.application.applicationContext"
            r3 = 0
            java.lang.String r4 = "chromeSectionAdapter"
            java.lang.String r5 = "baseActivity!!.application"
            java.lang.String r6 = "baseActivity"
            if (r0 == 0) goto L_0x00dc
            int r0 = com.iaai.android.C2723R.C2726id.llFactOptionsData
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            java.lang.String r7 = "llFactOptionsData"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r7)
            r0.setVisibility(r3)
            int r0 = com.iaai.android.C2723R.C2726id.tvFactSectionHeader
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r7 = "tvFactSectionHeader"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r7)
            if (r10 == 0) goto L_0x0051
            com.iaai.android.bdt.model.productDetail.chromeSection.FactOptionsData r7 = r10.getFactOptionsData()
            if (r7 == 0) goto L_0x0051
            java.lang.String r7 = r7.getCategoryName()
            goto L_0x0052
        L_0x0051:
            r7 = r1
        L_0x0052:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r0.setText(r7)
            com.iaai.android.bdt.feature.productDetail.chromeSection.ChromeSectionAdapter r0 = new com.iaai.android.bdt.feature.productDetail.chromeSection.ChromeSectionAdapter
            com.iaai.android.bdt.base.BaseActivity r7 = r9.baseActivity
            if (r7 != 0) goto L_0x0060
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
        L_0x0060:
            if (r7 != 0) goto L_0x0065
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0065:
            android.app.Application r7 = r7.getApplication()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r5)
            android.content.Context r7 = r7.getApplicationContext()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r2)
            com.iaai.android.bdt.utils.ChromeSectionMode r8 = com.iaai.android.bdt.utils.ChromeSectionMode.FACT_OPTIONS
            r0.<init>(r7, r8)
            r9.chromeSectionAdapter = r0
            com.iaai.android.bdt.feature.productDetail.chromeSection.ChromeSectionAdapter r0 = r9.chromeSectionAdapter
            if (r0 != 0) goto L_0x0081
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
        L_0x0081:
            if (r10 == 0) goto L_0x0090
            com.iaai.android.bdt.model.productDetail.chromeSection.FactOptionsData r7 = r10.getFactOptionsData()
            if (r7 == 0) goto L_0x0090
            java.util.List r7 = r7.getAttributes()
            if (r7 == 0) goto L_0x0090
            goto L_0x0094
        L_0x0090:
            java.util.List r7 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0094:
            r0.setFactOptionsAttributeList(r7)
            int r0 = com.iaai.android.C2723R.C2726id.rvFactEquipment
            android.view.View r0 = r9._$_findCachedViewById(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            java.lang.String r7 = "rvFactEquipment"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r7)
            com.iaai.android.bdt.feature.productDetail.chromeSection.ChromeSectionAdapter r8 = r9.chromeSectionAdapter
            if (r8 != 0) goto L_0x00ab
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
        L_0x00ab:
            androidx.recyclerview.widget.RecyclerView$Adapter r8 = (androidx.recyclerview.widget.RecyclerView.Adapter) r8
            r0.setAdapter(r8)
            int r0 = com.iaai.android.C2723R.C2726id.rvFactEquipment
            android.view.View r0 = r9._$_findCachedViewById(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r7)
            androidx.recyclerview.widget.LinearLayoutManager r7 = new androidx.recyclerview.widget.LinearLayoutManager
            com.iaai.android.bdt.base.BaseActivity r8 = r9.baseActivity
            if (r8 != 0) goto L_0x00c4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
        L_0x00c4:
            if (r8 != 0) goto L_0x00c9
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00c9:
            android.app.Application r8 = r8.getApplication()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r5)
            android.content.Context r8 = r8.getApplicationContext()
            r7.<init>(r8)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r7 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r7
            r0.setLayoutManager(r7)
        L_0x00dc:
            if (r10 == 0) goto L_0x00eb
            com.iaai.android.bdt.model.productDetail.chromeSection.GenEquipmentData r0 = r10.getGenEquipmentData()
            if (r0 == 0) goto L_0x00eb
            java.util.List r0 = r0.getAttributes()
            if (r0 == 0) goto L_0x00eb
            goto L_0x00ef
        L_0x00eb:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x00ef:
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x01ae
            int r0 = com.iaai.android.C2723R.C2726id.llGenEquipmentData
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            java.lang.String r7 = "llGenEquipmentData"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r7)
            r0.setVisibility(r3)
            int r0 = com.iaai.android.C2723R.C2726id.tvGenSectionHeader
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r7 = "tvGenSectionHeader"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r7)
            if (r10 == 0) goto L_0x0123
            com.iaai.android.bdt.model.productDetail.chromeSection.GenEquipmentData r7 = r10.getGenEquipmentData()
            if (r7 == 0) goto L_0x0123
            java.lang.String r7 = r7.getCategoryName()
            goto L_0x0124
        L_0x0123:
            r7 = r1
        L_0x0124:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r0.setText(r7)
            com.iaai.android.bdt.feature.productDetail.chromeSection.ChromeSectionAdapter r0 = new com.iaai.android.bdt.feature.productDetail.chromeSection.ChromeSectionAdapter
            com.iaai.android.bdt.base.BaseActivity r7 = r9.baseActivity
            if (r7 != 0) goto L_0x0132
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
        L_0x0132:
            if (r7 != 0) goto L_0x0137
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0137:
            android.app.Application r7 = r7.getApplication()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r5)
            android.content.Context r7 = r7.getApplicationContext()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r2)
            com.iaai.android.bdt.utils.ChromeSectionMode r8 = com.iaai.android.bdt.utils.ChromeSectionMode.GEN_EQUIPMENT
            r0.<init>(r7, r8)
            r9.chromeSectionAdapter = r0
            com.iaai.android.bdt.feature.productDetail.chromeSection.ChromeSectionAdapter r0 = r9.chromeSectionAdapter
            if (r0 != 0) goto L_0x0153
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
        L_0x0153:
            if (r10 == 0) goto L_0x0162
            com.iaai.android.bdt.model.productDetail.chromeSection.GenEquipmentData r7 = r10.getGenEquipmentData()
            if (r7 == 0) goto L_0x0162
            java.util.List r7 = r7.getAttributes()
            if (r7 == 0) goto L_0x0162
            goto L_0x0166
        L_0x0162:
            java.util.List r7 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0166:
            r0.setGenEquipmentAttributeList(r7)
            int r0 = com.iaai.android.C2723R.C2726id.rvGenEquipment
            android.view.View r0 = r9._$_findCachedViewById(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            java.lang.String r7 = "rvGenEquipment"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r7)
            com.iaai.android.bdt.feature.productDetail.chromeSection.ChromeSectionAdapter r8 = r9.chromeSectionAdapter
            if (r8 != 0) goto L_0x017d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
        L_0x017d:
            androidx.recyclerview.widget.RecyclerView$Adapter r8 = (androidx.recyclerview.widget.RecyclerView.Adapter) r8
            r0.setAdapter(r8)
            int r0 = com.iaai.android.C2723R.C2726id.rvGenEquipment
            android.view.View r0 = r9._$_findCachedViewById(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r7)
            androidx.recyclerview.widget.LinearLayoutManager r7 = new androidx.recyclerview.widget.LinearLayoutManager
            com.iaai.android.bdt.base.BaseActivity r8 = r9.baseActivity
            if (r8 != 0) goto L_0x0196
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
        L_0x0196:
            if (r8 != 0) goto L_0x019b
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x019b:
            android.app.Application r8 = r8.getApplication()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r5)
            android.content.Context r8 = r8.getApplicationContext()
            r7.<init>(r8)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r7 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r7
            r0.setLayoutManager(r7)
        L_0x01ae:
            if (r10 == 0) goto L_0x01bd
            com.iaai.android.bdt.model.productDetail.chromeSection.StanEquipmentData r0 = r10.getStanEquipmentData()
            if (r0 == 0) goto L_0x01bd
            java.util.List r0 = r0.getAttributes()
            if (r0 == 0) goto L_0x01bd
            goto L_0x01c1
        L_0x01bd:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x01c1:
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x027e
            int r0 = com.iaai.android.C2723R.C2726id.llStanEquipmentData
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            java.lang.String r7 = "llStanEquipmentData"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r7)
            r0.setVisibility(r3)
            int r0 = com.iaai.android.C2723R.C2726id.tvStanSectionHeader
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r7 = "tvStanSectionHeader"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r7)
            if (r10 == 0) goto L_0x01f4
            com.iaai.android.bdt.model.productDetail.chromeSection.StanEquipmentData r7 = r10.getStanEquipmentData()
            if (r7 == 0) goto L_0x01f4
            java.lang.String r1 = r7.getCategoryName()
        L_0x01f4:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            com.iaai.android.bdt.feature.productDetail.chromeSection.ChromeSectionAdapter r0 = new com.iaai.android.bdt.feature.productDetail.chromeSection.ChromeSectionAdapter
            com.iaai.android.bdt.base.BaseActivity r1 = r9.baseActivity
            if (r1 != 0) goto L_0x0202
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
        L_0x0202:
            if (r1 != 0) goto L_0x0207
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0207:
            android.app.Application r1 = r1.getApplication()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r5)
            android.content.Context r1 = r1.getApplicationContext()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            com.iaai.android.bdt.utils.ChromeSectionMode r7 = com.iaai.android.bdt.utils.ChromeSectionMode.STAN_EQUIPMENT
            r0.<init>(r1, r7)
            r9.chromeSectionAdapter = r0
            com.iaai.android.bdt.feature.productDetail.chromeSection.ChromeSectionAdapter r0 = r9.chromeSectionAdapter
            if (r0 != 0) goto L_0x0223
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
        L_0x0223:
            if (r10 == 0) goto L_0x0232
            com.iaai.android.bdt.model.productDetail.chromeSection.StanEquipmentData r1 = r10.getStanEquipmentData()
            if (r1 == 0) goto L_0x0232
            java.util.List r1 = r1.getAttributes()
            if (r1 == 0) goto L_0x0232
            goto L_0x0236
        L_0x0232:
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0236:
            r0.setStanEquipmentAttributeList(r1)
            int r0 = com.iaai.android.C2723R.C2726id.rvStanEquipment
            android.view.View r0 = r9._$_findCachedViewById(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            java.lang.String r1 = "rvStanEquipment"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            com.iaai.android.bdt.feature.productDetail.chromeSection.ChromeSectionAdapter r7 = r9.chromeSectionAdapter
            if (r7 != 0) goto L_0x024d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
        L_0x024d:
            androidx.recyclerview.widget.RecyclerView$Adapter r7 = (androidx.recyclerview.widget.RecyclerView.Adapter) r7
            r0.setAdapter(r7)
            int r0 = com.iaai.android.C2723R.C2726id.rvStanEquipment
            android.view.View r0 = r9._$_findCachedViewById(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            androidx.recyclerview.widget.LinearLayoutManager r1 = new androidx.recyclerview.widget.LinearLayoutManager
            com.iaai.android.bdt.base.BaseActivity r7 = r9.baseActivity
            if (r7 != 0) goto L_0x0266
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
        L_0x0266:
            if (r7 != 0) goto L_0x026b
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x026b:
            android.app.Application r7 = r7.getApplication()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r5)
            android.content.Context r7 = r7.getApplicationContext()
            r1.<init>(r7)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r1
            r0.setLayoutManager(r1)
        L_0x027e:
            if (r10 == 0) goto L_0x0287
            java.util.List r0 = r10.getTechSpecsData()
            if (r0 == 0) goto L_0x0287
            goto L_0x028b
        L_0x0287:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x028b:
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x0338
            int r0 = com.iaai.android.C2723R.C2726id.llTechSpecsData
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            java.lang.String r1 = "llTechSpecsData"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            r0.setVisibility(r3)
            int r0 = com.iaai.android.C2723R.C2726id.tvTechSectionHeader
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "tvTechSectionHeader"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.String r1 = "Technical Specifications"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            com.iaai.android.bdt.feature.productDetail.chromeSection.ChromeSectionAdapter r0 = new com.iaai.android.bdt.feature.productDetail.chromeSection.ChromeSectionAdapter
            com.iaai.android.bdt.base.BaseActivity r1 = r9.baseActivity
            if (r1 != 0) goto L_0x02c2
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
        L_0x02c2:
            if (r1 != 0) goto L_0x02c7
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x02c7:
            android.app.Application r1 = r1.getApplication()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r5)
            android.content.Context r1 = r1.getApplicationContext()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            com.iaai.android.bdt.utils.ChromeSectionMode r2 = com.iaai.android.bdt.utils.ChromeSectionMode.TECH_SPECIFICATIONS
            r0.<init>(r1, r2)
            r9.chromeSectionAdapter = r0
            com.iaai.android.bdt.feature.productDetail.chromeSection.ChromeSectionAdapter r0 = r9.chromeSectionAdapter
            if (r0 != 0) goto L_0x02e3
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
        L_0x02e3:
            if (r10 == 0) goto L_0x02ec
            java.util.List r10 = r10.getTechSpecsData()
            if (r10 == 0) goto L_0x02ec
            goto L_0x02f0
        L_0x02ec:
            java.util.List r10 = kotlin.collections.CollectionsKt.emptyList()
        L_0x02f0:
            r0.setTechSpecificationsList(r10)
            int r10 = com.iaai.android.C2723R.C2726id.rvTechEquipment
            android.view.View r10 = r9._$_findCachedViewById(r10)
            androidx.recyclerview.widget.RecyclerView r10 = (androidx.recyclerview.widget.RecyclerView) r10
            java.lang.String r0 = "rvTechEquipment"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r0)
            com.iaai.android.bdt.feature.productDetail.chromeSection.ChromeSectionAdapter r1 = r9.chromeSectionAdapter
            if (r1 != 0) goto L_0x0307
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
        L_0x0307:
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = (androidx.recyclerview.widget.RecyclerView.Adapter) r1
            r10.setAdapter(r1)
            int r10 = com.iaai.android.C2723R.C2726id.rvTechEquipment
            android.view.View r10 = r9._$_findCachedViewById(r10)
            androidx.recyclerview.widget.RecyclerView r10 = (androidx.recyclerview.widget.RecyclerView) r10
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r0)
            androidx.recyclerview.widget.LinearLayoutManager r0 = new androidx.recyclerview.widget.LinearLayoutManager
            com.iaai.android.bdt.base.BaseActivity r1 = r9.baseActivity
            if (r1 != 0) goto L_0x0320
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
        L_0x0320:
            if (r1 != 0) goto L_0x0325
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0325:
            android.app.Application r1 = r1.getApplication()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r5)
            android.content.Context r1 = r1.getApplicationContext()
            r0.<init>(r1)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r0
            r10.setLayoutManager(r0)
        L_0x0338:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.productDetail.chromeSection.ChromeSectionFragment.updateChromeSectionUI(com.iaai.android.bdt.model.productDetail.chromeSection.ChromeData):void");
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbChromeLoading);
            Intrinsics.checkExpressionValueIsNotNull(progressBar, "pbChromeLoading");
            progressBar.setVisibility(0);
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbChromeLoading);
        Intrinsics.checkExpressionValueIsNotNull(progressBar2, "pbChromeLoading");
        progressBar2.setVisibility(8);
    }
}
