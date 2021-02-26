package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.navigation.NavArgument;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.Navigation;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.utils.Constants_MVVM;
import dagger.android.AndroidInjection;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\t\u001a\u00020\u0006H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/filter/FilterActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "()V", "screenName", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FilterActivity.kt */
public final class FilterActivity extends BaseActivity {
    private HashMap _$_findViewCache;
    private String screenName = "";

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

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        Activity activity = this;
        AndroidInjection.inject(activity);
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_filter_fragment_container);
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
            Bundle extras2 = intent2 != null ? intent2.getExtras() : null;
            if (extras2 == null) {
                Intrinsics.throwNpe();
            }
            ArrayList parcelableArrayList2 = extras2.getParcelableArrayList(Constants_MVVM.EXTRA_SELECTED_MAKE_MODEL_DATA);
            if (parcelableArrayList2 != null) {
                NavArgument build2 = builder2.setDefaultValue(parcelableArrayList2).build();
                Intrinsics.checkExpressionValueIsNotNull(build2, "NavArgument.Builder().se…lectedRefinerV2>).build()");
                inflate.addArgument(Constants_MVVM.EXTRA_SELECTED_MAKE_MODEL_DATA, build2);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2> /* = java.util.ArrayList<com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2> */");
            }
        }
        if (getIntent().hasExtra(Constants_MVVM.EXTRA_MAKE_MODEL_GROUP_POSITION)) {
            NavArgument.Builder builder3 = new NavArgument.Builder();
            Intent intent3 = getIntent();
            Intrinsics.checkExpressionValueIsNotNull(intent3, "intent");
            NavArgument build3 = builder3.setDefaultValue(Integer.valueOf(intent3.getExtras().getInt(Constants_MVVM.EXTRA_MAKE_MODEL_GROUP_POSITION))).build();
            Intrinsics.checkExpressionValueIsNotNull(build3, "NavArgument.Builder().se…_GROUP_POSITION)).build()");
            inflate.addArgument(Constants_MVVM.EXTRA_MAKE_MODEL_GROUP_POSITION, build3);
        }
        if (getIntent().hasExtra(Constants_MVVM.EXTRA_IS_FROM_FIND_VEHICLE_PAGE)) {
            NavArgument.Builder builder4 = new NavArgument.Builder();
            Intent intent4 = getIntent();
            Intrinsics.checkExpressionValueIsNotNull(intent4, "intent");
            NavArgument build4 = builder4.setDefaultValue(Boolean.valueOf(intent4.getExtras().getBoolean(Constants_MVVM.EXTRA_IS_FROM_FIND_VEHICLE_PAGE))).build();
            Intrinsics.checkExpressionValueIsNotNull(build4, "NavArgument.Builder().se…ND_VEHICLE_PAGE)).build()");
            inflate.addArgument(Constants_MVVM.EXTRA_IS_FROM_FIND_VEHICLE_PAGE, build4);
        }
        if (getIntent().hasExtra("screen_name")) {
            Intent intent5 = getIntent();
            Intrinsics.checkExpressionValueIsNotNull(intent5, "intent");
            String string = intent5.getExtras().getString("screen_name");
            Intrinsics.checkExpressionValueIsNotNull(string, "intent.extras.getString(…s_MVVM.EXTRA_SCREEN_NAME)");
            this.screenName = string;
            NavArgument build5 = new NavArgument.Builder().setDefaultValue(this.screenName).build();
            Intrinsics.checkExpressionValueIsNotNull(build5, "NavArgument.Builder().se…Value(screenName).build()");
            inflate.addArgument("screen_name", build5);
        }
        NavArgument build6 = new NavArgument.Builder().setDefaultValue(true).build();
        Intrinsics.checkExpressionValueIsNotNull(build6, "NavArgument.Builder().se…efaultValue(true).build()");
        inflate.addArgument(Constants_MVVM.EXTRA_IS_FILTERPAGE, build6);
        NavArgument.Builder builder5 = new NavArgument.Builder();
        Intent intent6 = getIntent();
        if (intent6 != null) {
            bundle2 = intent6.getExtras();
        }
        if (bundle2 == null) {
            Intrinsics.throwNpe();
        }
        NavArgument build7 = builder5.setDefaultValue(bundle2.getString(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY)).build();
        Intrinsics.checkExpressionValueIsNotNull(build7, "NavArgument.Builder().se…EARCH_INPUT_KEY)).build()");
        inflate.addArgument(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY, build7);
        findNavController.setGraph(inflate);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        IAAAnalytics.INSTANCE.logScreenName(this.screenName, this);
    }
}
