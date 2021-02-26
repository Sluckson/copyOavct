package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.Navigation;
import com.google.android.material.navigation.NavigationView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.MVVMNavDrawerActivity;
import com.iaai.android.bdt.utils.Constants_MVVM;
import dagger.android.AndroidInjection;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0012\u0010\u001b\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u0012\u0010\u001e\u001a\u00020\u00192\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u0019H\u0014J\b\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006$"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterActivity;", "Lcom/iaai/android/bdt/base/MVVMNavDrawerActivity;", "()V", "fastSearchFilterFragment", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterFragment;", "imgClose", "Landroid/widget/ImageView;", "getImgClose", "()Landroid/widget/ImageView;", "setImgClose", "(Landroid/widget/ImageView;)V", "isFilterPage", "", "()Z", "setFilterPage", "(Z)V", "isFromLandingPageSearch", "setFromLandingPageSearch", "tvClearFastSearch", "Landroid/widget/TextView;", "getTvClearFastSearch", "()Landroid/widget/TextView;", "setTvClearFastSearch", "(Landroid/widget/TextView;)V", "initializeUI", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "updateUIForFilterPage", "updateUIForFindVehicle", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchFilterActivity.kt */
public final class FastSearchFilterActivity extends MVVMNavDrawerActivity {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public FastSearchFilterFragment fastSearchFilterFragment;
    @NotNull
    public ImageView imgClose;
    private boolean isFilterPage;
    private boolean isFromLandingPageSearch;
    @NotNull
    public TextView tvClearFastSearch;

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

    public static final /* synthetic */ FastSearchFilterFragment access$getFastSearchFilterFragment$p(FastSearchFilterActivity fastSearchFilterActivity) {
        FastSearchFilterFragment fastSearchFilterFragment2 = fastSearchFilterActivity.fastSearchFilterFragment;
        if (fastSearchFilterFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterFragment");
        }
        return fastSearchFilterFragment2;
    }

    @NotNull
    public final TextView getTvClearFastSearch() {
        TextView textView = this.tvClearFastSearch;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvClearFastSearch");
        }
        return textView;
    }

    public final void setTvClearFastSearch(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.tvClearFastSearch = textView;
    }

    @NotNull
    public final ImageView getImgClose() {
        ImageView imageView = this.imgClose;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgClose");
        }
        return imageView;
    }

    public final void setImgClose(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.imgClose = imageView;
    }

    public final boolean isFilterPage() {
        return this.isFilterPage;
    }

    public final void setFilterPage(boolean z) {
        this.isFilterPage = z;
    }

    public final boolean isFromLandingPageSearch() {
        return this.isFromLandingPageSearch;
    }

    public final void setFromLandingPageSearch(boolean z) {
        this.isFromLandingPageSearch = z;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        AndroidInjection.inject((Activity) this);
        setContentView((int) C2723R.C2728layout.activity_fast_search_filter);
        super.onCreateDrawer(bundle);
        initializeUI();
    }

    private final void initializeUI() {
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(C2723R.C2726id.auction_toolbar);
        Intrinsics.checkExpressionValueIsNotNull(toolbar, "auction_toolbar");
        toolbar.setVisibility(0);
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2723R.C2726id.auction_toolbar));
        Toolbar toolbar2 = (Toolbar) _$_findCachedViewById(C2723R.C2726id.auction_toolbar);
        Intrinsics.checkExpressionValueIsNotNull(toolbar2, "auction_toolbar");
        toolbar2.setTitle((CharSequence) getString(C2723R.string.lbl_search));
        getWindow().setSoftInputMode(2);
        NavigationView navigationView = (NavigationView) _$_findCachedViewById(C2723R.C2726id.nav_view);
        Intrinsics.checkExpressionValueIsNotNull(navigationView, "nav_view");
        Menu menu = navigationView.getMenu();
        Intrinsics.checkExpressionValueIsNotNull(menu, "nav_view.menu");
        MenuItem findItem = menu.findItem(C2723R.C2726id.drawer_menu_fast_search);
        Intrinsics.checkExpressionValueIsNotNull(findItem, "menuItem");
        boolean z = true;
        findItem.setChecked(true);
        View findViewById = findViewById(C2723R.C2726id.imgClose);
        if (findViewById != null) {
            this.imgClose = (ImageView) findViewById;
            View findViewById2 = findViewById(C2723R.C2726id.tvClearFastSearch);
            if (findViewById2 != null) {
                this.tvClearFastSearch = (TextView) findViewById2;
                NavController findNavController = Navigation.findNavController(this, C2723R.C2726id.nav_host_fast_search);
                Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro….id.nav_host_fast_search)");
                NavInflater navInflater = findNavController.getNavInflater();
                Intrinsics.checkExpressionValueIsNotNull(navInflater, "navController.navInflater");
                NavGraph inflate = navInflater.inflate(C2723R.C2730navigation.navigation_fast_search_filter);
                Intrinsics.checkExpressionValueIsNotNull(inflate, "navInflater.inflate(R.na…ation_fast_search_filter)");
                inflate.setStartDestination(C2723R.C2726id.FastSearchFilterFragment);
                findNavController.setGraph(inflate);
                Intent intent = getIntent();
                this.isFilterPage = intent != null && intent.getBooleanExtra(Constants_MVVM.EXTRA_IS_FILTERPAGE, false);
                Intent intent2 = getIntent();
                if (intent2 == null || !intent2.getBooleanExtra(Constants_MVVM.EXTRA_IS_FROM_LANDING_PAGE_SEARCH, false)) {
                    z = false;
                }
                this.isFromLandingPageSearch = z;
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(@Nullable Intent intent) {
        super.onNewIntent(intent);
        boolean z = true;
        if (intent == null || !intent.getBooleanExtra(Constants_MVVM.EXTRA_IS_FILTERPAGE, false)) {
            z = false;
        }
        this.isFilterPage = z;
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(C2723R.C2726id.nav_host_fast_search);
        if (findFragmentById == null) {
            Intrinsics.throwNpe();
        }
        FragmentManager childFragmentManager = findFragmentById.getChildFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(childFragmentManager, "navHostFragment!!.childFragmentManager");
        Fragment fragment = childFragmentManager.getFragments().get(0);
        if (fragment != null) {
            this.fastSearchFilterFragment = (FastSearchFilterFragment) fragment;
            FastSearchFilterFragment fastSearchFilterFragment2 = this.fastSearchFilterFragment;
            if (fastSearchFilterFragment2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterFragment");
            }
            fastSearchFilterFragment2.createTempCopy();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterFragment");
    }

    private final void updateUIForFilterPage() {
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(C2723R.C2726id.auction_toolbar);
        Intrinsics.checkExpressionValueIsNotNull(toolbar, "auction_toolbar");
        toolbar.setTitle((CharSequence) getString(C2723R.string.title_filters));
        ImageView imageView = this.imgClose;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgClose");
        }
        imageView.setVisibility(0);
        if (this.fastSearchFilterFragment == null) {
            Fragment findFragmentById = getSupportFragmentManager().findFragmentById(C2723R.C2726id.nav_host_fast_search);
            if (findFragmentById == null) {
                Intrinsics.throwNpe();
            }
            FragmentManager childFragmentManager = findFragmentById.getChildFragmentManager();
            Intrinsics.checkExpressionValueIsNotNull(childFragmentManager, "navHostFragment!!.childFragmentManager");
            Fragment fragment = childFragmentManager.getFragments().get(0);
            if (fragment != null) {
                this.fastSearchFilterFragment = (FastSearchFilterFragment) fragment;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterFragment");
            }
        }
        FastSearchFilterFragment fastSearchFilterFragment2 = this.fastSearchFilterFragment;
        if (fastSearchFilterFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterFragment");
        }
        fastSearchFilterFragment2.updateUIForFilterPage(this.isFilterPage);
        ImageView imageView2 = this.imgClose;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgClose");
        }
        imageView2.setOnClickListener(new FastSearchFilterActivity$updateUIForFilterPage$2(this));
        NavigationView navigationView = (NavigationView) _$_findCachedViewById(C2723R.C2726id.nav_view);
        Intrinsics.checkExpressionValueIsNotNull(navigationView, "nav_view");
        navigationView.setVisibility(8);
        super.hideNavDrawer(false);
    }

    private final void updateUIForFindVehicle() {
        super.hideNavDrawer(true);
        ImageView imageView = this.imgClose;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgClose");
        }
        imageView.setVisibility(8);
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(C2723R.C2726id.auction_toolbar);
        Intrinsics.checkExpressionValueIsNotNull(toolbar, "auction_toolbar");
        toolbar.setTitle((CharSequence) getString(C2723R.string.lbl_search));
        if (this.fastSearchFilterFragment != null) {
            FastSearchFilterFragment fastSearchFilterFragment2 = this.fastSearchFilterFragment;
            if (fastSearchFilterFragment2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterFragment");
            }
            if (fastSearchFilterFragment2 != null) {
                fastSearchFilterFragment2.updateUIForFilterPage(false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.isFilterPage) {
            updateUIForFilterPage();
        } else {
            updateUIForFindVehicle();
        }
    }

    public void onBackPressed() {
        if (this.isFilterPage) {
            if (this.isFromLandingPageSearch) {
                FastSearchFilterFragment fastSearchFilterFragment2 = this.fastSearchFilterFragment;
                if (fastSearchFilterFragment2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterFragment");
                }
                fastSearchFilterFragment2.resetUIOnBackPressed();
                finish();
            } else {
                FastSearchFilterFragment fastSearchFilterFragment3 = this.fastSearchFilterFragment;
                if (fastSearchFilterFragment3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fastSearchFilterFragment");
                }
                fastSearchFilterFragment3.navigateToFilterResultScreen(true);
            }
            this.isFilterPage = false;
            return;
        }
        super.onBackPressed();
    }
}
