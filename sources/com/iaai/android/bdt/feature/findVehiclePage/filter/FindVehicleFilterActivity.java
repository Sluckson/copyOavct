package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavArgument;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.Navigation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.base.MVVMNavDrawerActivity;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.utils.IAASharedPreference;
import dagger.android.AndroidInjection;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0012\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0014H\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/filter/FindVehicleFilterActivity;", "Lcom/iaai/android/bdt/base/MVVMNavDrawerActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "imgScan", "Landroid/widget/ImageView;", "getImgScan", "()Landroid/widget/ImageView;", "setImgScan", "(Landroid/widget/ImageView;)V", "tvScanLabel", "Landroid/widget/TextView;", "getTvScanLabel", "()Landroid/widget/TextView;", "setTvScanLabel", "(Landroid/widget/TextView;)V", "getDynamicLink", "", "initializeUI", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FindVehicleFilterActivity.kt */
public final class FindVehicleFilterActivity extends MVVMNavDrawerActivity {
    @NotNull
    private final String TAG;
    private HashMap _$_findViewCache;
    @NotNull
    public ImageView imgScan;
    @NotNull
    public TextView tvScanLabel;

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

    public FindVehicleFilterActivity() {
        String simpleName = FindVehicleFilterActivity.class.getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "FindVehicleFilterActivity::class.java.simpleName");
        this.TAG = simpleName;
    }

    @NotNull
    public final TextView getTvScanLabel() {
        TextView textView = this.tvScanLabel;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvScanLabel");
        }
        return textView;
    }

    public final void setTvScanLabel(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.tvScanLabel = textView;
    }

    @NotNull
    public final ImageView getImgScan() {
        ImageView imageView = this.imgScan;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgScan");
        }
        return imageView;
    }

    public final void setImgScan(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.imgScan = imageView;
    }

    @NotNull
    public final String getTAG() {
        return this.TAG;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Activity activity = this;
        AndroidInjection.inject(activity);
        setContentView((int) C2723R.C2728layout.activity_filter_fragment_container);
        super.onCreateDrawer(bundle);
        initializeUI();
        getDynamicLink();
        Context context = this;
        IAASharedPreference.setSelectedFilter(context, "");
        IAASharedPreference.setSelectedMakeModelFilter(context, "");
        Application application = getApplication();
        if (application != null) {
            ((IaaiApplication) application).getInjector();
            View findViewById = findViewById(C2723R.C2726id.tvScanLabel);
            if (findViewById != null) {
                this.tvScanLabel = (TextView) findViewById;
                View findViewById2 = findViewById(C2723R.C2726id.imgScan);
                if (findViewById2 != null) {
                    this.imgScan = (ImageView) findViewById2;
                    super.setUserNameAndBuyerID(getSessionManager());
                    NavController findNavController = Navigation.findNavController(activity, C2723R.C2726id.bdt_filter_main_nav_host_fragment);
                    Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…r_main_nav_host_fragment)");
                    NavInflater navInflater = findNavController.getNavInflater();
                    Intrinsics.checkExpressionValueIsNotNull(navInflater, "navController.navInflater");
                    NavGraph inflate = navInflater.inflate(C2723R.C2730navigation.filter_main_navigation_graph);
                    Intrinsics.checkExpressionValueIsNotNull(inflate, "navInflater.inflate(R.na…er_main_navigation_graph)");
                    Bundle bundle2 = null;
                    if (getIntent().hasExtra(Constants_MVVM.EXTRA_SELECTED_FILTER_DATA)) {
                        NavArgument.Builder builder = new NavArgument.Builder();
                        Intent intent = getIntent();
                        Bundle extras = intent != null ? intent.getExtras() : null;
                        if (extras == null) {
                            Intrinsics.throwNpe();
                        }
                        ArrayList parcelableArrayList = extras.getParcelableArrayList(Constants_MVVM.EXTRA_SELECTED_FILTER_DATA);
                        if (parcelableArrayList != null) {
                            NavArgument build = builder.setDefaultValue(parcelableArrayList).build();
                            Intrinsics.checkExpressionValueIsNotNull(build, "NavArgument.Builder().se…lectedRefinerV2>).build()");
                            inflate.addArgument(Constants_MVVM.EXTRA_SELECTED_FILTER_DATA, build);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2> /* = java.util.ArrayList<com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2> */");
                        }
                    }
                    if (getIntent().hasExtra(Constants_MVVM.EXTRA_SELECTED_MAKE_MODEL_DATA)) {
                        NavArgument.Builder builder2 = new NavArgument.Builder();
                        Intent intent2 = getIntent();
                        if (intent2 != null) {
                            bundle2 = intent2.getExtras();
                        }
                        if (bundle2 == null) {
                            Intrinsics.throwNpe();
                        }
                        ArrayList parcelableArrayList2 = bundle2.getParcelableArrayList(Constants_MVVM.EXTRA_SELECTED_MAKE_MODEL_DATA);
                        if (parcelableArrayList2 != null) {
                            NavArgument build2 = builder2.setDefaultValue(parcelableArrayList2).build();
                            Intrinsics.checkExpressionValueIsNotNull(build2, "NavArgument.Builder().se…lectedRefinerV2>).build()");
                            inflate.addArgument(Constants_MVVM.EXTRA_SELECTED_MAKE_MODEL_DATA, build2);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2> /* = java.util.ArrayList<com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2> */");
                        }
                    }
                    NavArgument build3 = new NavArgument.Builder().setDefaultValue(false).build();
                    Intrinsics.checkExpressionValueIsNotNull(build3, "NavArgument.Builder().se…faultValue(false).build()");
                    inflate.addArgument(Constants_MVVM.EXTRA_IS_FILTERPAGE, build3);
                    NavArgument build4 = new NavArgument.Builder().setDefaultValue(true).build();
                    Intrinsics.checkExpressionValueIsNotNull(build4, "NavArgument.Builder().se…efaultValue(true).build()");
                    inflate.addArgument(Constants_MVVM.EXTRA_IS_FROM_FIND_VEHICLE_PAGE, build4);
                    findNavController.setGraph(inflate);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.IaaiApplication");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        IAAAnalytics.INSTANCE.logScreenName(IAAAnalytics.IAAScreenName.FIND_VEHICLE.getValue(), this);
    }

    private final void initializeUI() {
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(C2723R.C2726id.auction_toolbar);
        Intrinsics.checkExpressionValueIsNotNull(toolbar, "auction_toolbar");
        toolbar.setVisibility(0);
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2723R.C2726id.auction_toolbar));
        Toolbar toolbar2 = (Toolbar) _$_findCachedViewById(C2723R.C2726id.auction_toolbar);
        Intrinsics.checkExpressionValueIsNotNull(toolbar2, "auction_toolbar");
        toolbar2.setTitle((CharSequence) "Find Vehicle");
        getWindow().setSoftInputMode(2);
        NavigationView navigationView = (NavigationView) _$_findCachedViewById(C2723R.C2726id.nav_view);
        Intrinsics.checkExpressionValueIsNotNull(navigationView, "nav_view");
        Intrinsics.checkExpressionValueIsNotNull(navigationView.getMenu(), "nav_view.menu");
    }

    private final void getDynamicLink() {
        Activity activity = this;
        FirebaseDynamicLinks.getInstance().getDynamicLink(getIntent()).addOnSuccessListener(activity, new FindVehicleFilterActivity$getDynamicLink$1(this)).addOnFailureListener(activity, (OnFailureListener) new FindVehicleFilterActivity$getDynamicLink$2(this));
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(@Nullable Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        getDynamicLink();
    }
}
