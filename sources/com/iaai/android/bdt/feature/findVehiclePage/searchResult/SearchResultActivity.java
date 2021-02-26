package com.iaai.android.bdt.feature.findVehiclePage.searchResult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavArgument;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.Navigation;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.feature.auctionSalesList.OnNextPageLoad;
import com.iaai.android.bdt.model.quickFilter.QuickFilterResponse;
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

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0012\u0010\u001f\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020!H\u0014J\u000e\u0010(\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u0006)"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/searchResult/SearchResultActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "()V", "ivStockShare", "Landroid/widget/ImageView;", "getIvStockShare", "()Landroid/widget/ImageView;", "setIvStockShare", "(Landroid/widget/ImageView;)V", "onNextPageLoad", "Lcom/iaai/android/bdt/feature/auctionSalesList/OnNextPageLoad;", "searchInput", "", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "toolbar_sub_title", "Landroid/widget/TextView;", "getToolbar_sub_title", "()Landroid/widget/TextView;", "setToolbar_sub_title", "(Landroid/widget/TextView;)V", "toolbar_title", "getToolbar_title", "setToolbar_title", "initializeUI", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onSaveInstanceState", "outState", "setOnNextPageLoad", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SearchResultActivity.kt */
public final class SearchResultActivity extends BaseActivity {
    private HashMap _$_findViewCache;
    @NotNull
    public ImageView ivStockShare;
    private OnNextPageLoad onNextPageLoad;
    private String searchInput = "";
    @NotNull
    public Toolbar toolbar;
    @NotNull
    public TextView toolbar_sub_title;
    @NotNull
    public TextView toolbar_title;

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
    public final ImageView getIvStockShare() {
        ImageView imageView = this.ivStockShare;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivStockShare");
        }
        return imageView;
    }

    public final void setIvStockShare(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.ivStockShare = imageView;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        Activity activity = this;
        AndroidInjection.inject(activity);
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_auctionsales_list_fragment_container);
        View findViewById = findViewById(C2723R.C2726id.toolbar);
        if (findViewById != null) {
            this.toolbar = (Toolbar) findViewById;
            View findViewById2 = findViewById(C2723R.C2726id.toolbar_title);
            if (findViewById2 != null) {
                this.toolbar_title = (TextView) findViewById2;
                View findViewById3 = findViewById(C2723R.C2726id.toolbar_sub_title);
                if (findViewById3 != null) {
                    this.toolbar_sub_title = (TextView) findViewById3;
                    View findViewById4 = findViewById(C2723R.C2726id.ivShareAS);
                    if (findViewById4 != null) {
                        this.ivStockShare = (ImageView) findViewById4;
                        String stringExtra = getIntent().getStringExtra(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY);
                        if (stringExtra == null) {
                            stringExtra = "";
                        }
                        this.searchInput = stringExtra;
                        IAASharedPreference.setRefinerSearch(getApplicationContext(), this.searchInput);
                        QuickFilterResponse quickFilterResponse = (QuickFilterResponse) getIntent().getParcelableExtra(Constants_MVVM.EXTRA_QUICK_FILTER_SELECTED_VALUE);
                        initializeUI();
                        NavController findNavController = Navigation.findNavController(activity, C2723R.C2726id.main_nav_host_fragment);
                        Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…d.main_nav_host_fragment)");
                        NavInflater navInflater = findNavController.getNavInflater();
                        Intrinsics.checkExpressionValueIsNotNull(navInflater, "navController.navInflater");
                        NavGraph inflate = navInflater.inflate(C2723R.C2730navigation.search_result_navigation_graph);
                        Intrinsics.checkExpressionValueIsNotNull(inflate, "navInflater.inflate(R.na…_result_navigation_graph)");
                        NavArgument build = new NavArgument.Builder().setDefaultValue(this.searchInput).build();
                        Intrinsics.checkExpressionValueIsNotNull(build, "NavArgument.Builder().se…alue(searchInput).build()");
                        inflate.addArgument(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY, build);
                        if (quickFilterResponse != null) {
                            NavArgument build2 = new NavArgument.Builder().setDefaultValue(quickFilterResponse).build();
                            Intrinsics.checkExpressionValueIsNotNull(build2, "NavArgument.Builder().se…alue(quickFilter).build()");
                            inflate.addArgument(Constants_MVVM.EXTRA_QUICK_FILTER_SELECTED_VALUE, build2);
                        }
                        if (getIntent().hasExtra(Constants_MVVM.EXTRA_SELECTED_FILTER_DATA)) {
                            NavArgument.Builder builder = new NavArgument.Builder();
                            Intent intent = getIntent();
                            Intrinsics.checkExpressionValueIsNotNull(intent, "intent");
                            ArrayList parcelableArrayList = intent.getExtras().getParcelableArrayList(Constants_MVVM.EXTRA_SELECTED_FILTER_DATA);
                            if (parcelableArrayList != null) {
                                NavArgument build3 = builder.setDefaultValue(parcelableArrayList).build();
                                Intrinsics.checkExpressionValueIsNotNull(build3, "NavArgument.Builder().se…SelectedRefiner>).build()");
                                inflate.addArgument(Constants_MVVM.EXTRA_SELECTED_FILTER_DATA, build3);
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.iaai.android.bdt.model.fastSearch.SelectedRefiner> /* = java.util.ArrayList<com.iaai.android.bdt.model.fastSearch.SelectedRefiner> */");
                            }
                        }
                        if (getIntent().hasExtra(Constants_MVVM.EXTRA_SELECTED_MAKE_MODEL_DATA)) {
                            NavArgument.Builder builder2 = new NavArgument.Builder();
                            Intent intent2 = getIntent();
                            Intrinsics.checkExpressionValueIsNotNull(intent2, "intent");
                            ArrayList parcelableArrayList2 = intent2.getExtras().getParcelableArrayList(Constants_MVVM.EXTRA_SELECTED_MAKE_MODEL_DATA);
                            if (parcelableArrayList2 != null) {
                                NavArgument build4 = builder2.setDefaultValue(parcelableArrayList2).build();
                                Intrinsics.checkExpressionValueIsNotNull(build4, "NavArgument.Builder().se…SelectedRefiner>).build()");
                                inflate.addArgument(Constants_MVVM.EXTRA_SELECTED_MAKE_MODEL_DATA, build4);
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.iaai.android.bdt.model.fastSearch.SelectedRefiner> /* = java.util.ArrayList<com.iaai.android.bdt.model.fastSearch.SelectedRefiner> */");
                            }
                        }
                        if (getIntent().hasExtra(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY)) {
                            NavArgument build5 = new NavArgument.Builder().setDefaultValue(this.searchInput).build();
                            Intrinsics.checkExpressionValueIsNotNull(build5, "NavArgument.Builder().se…alue(searchInput).build()");
                            inflate.addArgument(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY, build5);
                        }
                        if (getIntent().hasExtra(Constants_MVVM.EXTRA_MAKE_MODEL_GROUP_POSITION)) {
                            NavArgument.Builder builder3 = new NavArgument.Builder();
                            Intent intent3 = getIntent();
                            Intrinsics.checkExpressionValueIsNotNull(intent3, "intent");
                            NavArgument build6 = builder3.setDefaultValue(Integer.valueOf(intent3.getExtras().getInt(Constants_MVVM.EXTRA_MAKE_MODEL_GROUP_POSITION))).build();
                            Intrinsics.checkExpressionValueIsNotNull(build6, "NavArgument.Builder().se…_GROUP_POSITION)).build()");
                            inflate.addArgument(Constants_MVVM.EXTRA_MAKE_MODEL_GROUP_POSITION, build6);
                        }
                        if (getIntent().hasExtra(Constants_MVVM.EXTRA_MAKE_MODEL_GROUP_POSITION)) {
                            NavArgument.Builder builder4 = new NavArgument.Builder();
                            Intent intent4 = getIntent();
                            Intrinsics.checkExpressionValueIsNotNull(intent4, "intent");
                            NavArgument build7 = builder4.setDefaultValue(Boolean.valueOf(intent4.getExtras().getBoolean(Constants_MVVM.EXTRA_IS_FROM_FIND_VEHICLE_PAGE))).build();
                            Intrinsics.checkExpressionValueIsNotNull(build7, "NavArgument.Builder().se…ND_VEHICLE_PAGE)).build()");
                            inflate.addArgument(Constants_MVVM.EXTRA_IS_FROM_FIND_VEHICLE_PAGE, build7);
                        }
                        if (getIntent().hasExtra(Constants_MVVM.EXTRA_IS_FROM_FIND_VEHICLE_PAGE)) {
                            NavArgument.Builder builder5 = new NavArgument.Builder();
                            Intent intent5 = getIntent();
                            Intrinsics.checkExpressionValueIsNotNull(intent5, "intent");
                            NavArgument build8 = builder5.setDefaultValue(Boolean.valueOf(intent5.getExtras().getBoolean(Constants_MVVM.EXTRA_IS_FROM_FIND_VEHICLE_PAGE))).build();
                            Intrinsics.checkExpressionValueIsNotNull(build8, "NavArgument.Builder().se…ND_VEHICLE_PAGE)).build()");
                            inflate.addArgument(Constants_MVVM.EXTRA_IS_FROM_FIND_VEHICLE_PAGE, build8);
                        }
                        if (getIntent().hasExtra(Constants_MVVM.EXTRA_THIS_WEEK)) {
                            NavArgument.Builder builder6 = new NavArgument.Builder();
                            Intent intent6 = getIntent();
                            Intrinsics.checkExpressionValueIsNotNull(intent6, "intent");
                            NavArgument build9 = builder6.setDefaultValue(intent6.getExtras().getString(Constants_MVVM.EXTRA_THIS_WEEK)).build();
                            Intrinsics.checkExpressionValueIsNotNull(build9, "NavArgument.Builder().se…EXTRA_THIS_WEEK)).build()");
                            inflate.addArgument(Constants_MVVM.EXTRA_THIS_WEEK, build9);
                        }
                        if (getIntent().hasExtra(Constants_MVVM.EXTRA_NEXT_WEEK)) {
                            NavArgument.Builder builder7 = new NavArgument.Builder();
                            Intent intent7 = getIntent();
                            Intrinsics.checkExpressionValueIsNotNull(intent7, "intent");
                            NavArgument build10 = builder7.setDefaultValue(intent7.getExtras().getString(Constants_MVVM.EXTRA_NEXT_WEEK)).build();
                            Intrinsics.checkExpressionValueIsNotNull(build10, "NavArgument.Builder().se…EXTRA_NEXT_WEEK)).build()");
                            inflate.addArgument(Constants_MVVM.EXTRA_NEXT_WEEK, build10);
                        }
                        findNavController.setGraph(inflate);
                        ((ImageView) _$_findCachedViewById(C2723R.C2726id.im_pre_bid_close)).setOnClickListener(new SearchResultActivity$onCreate$1(this));
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
    }

    public final void setOnNextPageLoad(@NotNull OnNextPageLoad onNextPageLoad2) {
        Intrinsics.checkParameterIsNotNull(onNextPageLoad2, "onNextPageLoad");
        this.onNextPageLoad = onNextPageLoad2;
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
        textView.setText(getResources().getString(C2723R.string.lbl_search));
        TextView textView2 = this.toolbar_sub_title;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar_sub_title");
        }
        textView2.setVisibility(8);
        ImageView imageView = this.ivStockShare;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivStockShare");
        }
        imageView.setVisibility(8);
    }

    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        NavController findNavController = Navigation.findNavController(this, C2723R.C2726id.main_nav_host_fragment);
        Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…d.main_nav_host_fragment)");
        if (!findNavController.popBackStack()) {
            Intent intent = new Intent();
            intent.putExtra(Constants_MVVM.EXTRA_IS_LANDING_PAGE, true);
            intent.putExtra(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY, IAASharedPreference.getRefinerSearch(getApplicationContext()));
            setResult(103, intent);
            finish();
        }
        return true;
    }

    public void onBackPressed() {
        if (getResources().getBoolean(C2723R.bool.isTabletPhone)) {
            NavController findNavController = Navigation.findNavController(this, C2723R.C2726id.auction_sales_nav_container);
            Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…tion_sales_nav_container)");
            if (!findNavController.popBackStack()) {
                super.onBackPressed();
                return;
            }
            return;
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.clear();
    }
}
