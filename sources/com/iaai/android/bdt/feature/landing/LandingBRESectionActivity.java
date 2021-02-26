package com.iaai.android.bdt.feature.landing;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.Navigation;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.utils.Constants_MVVM;
import dagger.android.AndroidInjection;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0013"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/LandingBRESectionActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "()V", "toolbarTitle", "Landroid/widget/TextView;", "getToolbarTitle", "()Landroid/widget/TextView;", "setToolbarTitle", "(Landroid/widget/TextView;)V", "initializeUI", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: LandingBRESectionActivity.kt */
public final class LandingBRESectionActivity extends BaseActivity {
    private HashMap _$_findViewCache;
    @NotNull
    public TextView toolbarTitle;

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
    public final TextView getToolbarTitle() {
        TextView textView = this.toolbarTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbarTitle");
        }
        return textView;
    }

    public final void setToolbarTitle(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.toolbarTitle = textView;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Activity activity = this;
        AndroidInjection.inject(activity);
        setContentView((int) C2723R.C2728layout.activity_landing_bresection);
        View findViewById = findViewById(C2723R.C2726id.toolbar_title);
        if (findViewById != null) {
            this.toolbarTitle = (TextView) findViewById;
            int intExtra = getIntent().getIntExtra(Constants_MVVM.EXTRA_ITEM_POSITION, 0);
            ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra(Constants_MVVM.EXTRA_ITEM_IDS_LIST);
            initializeUI();
            NavController findNavController = Navigation.findNavController(activity, C2723R.C2726id.landingBreHostFragment);
            Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…d.landingBreHostFragment)");
            NavInflater navInflater = findNavController.getNavInflater();
            Intrinsics.checkExpressionValueIsNotNull(navInflater, "navController.navInflater");
            NavGraph inflate = navInflater.inflate(C2723R.C2730navigation.navigation_graph_landing);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "navInflater.inflate(R.na…navigation_graph_landing)");
            Bundle bundle2 = new Bundle();
            bundle2.putStringArrayList(Constants_MVVM.EXTRA_ITEM_IDS_LIST, stringArrayListExtra);
            bundle2.putInt(Constants_MVVM.EXTRA_ITEM_POSITION, intExtra);
            findNavController.setGraph(inflate, bundle2);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
    }

    private final void initializeUI() {
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2723R.C2726id.landingToolbar));
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
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.toolbar_title);
        Intrinsics.checkExpressionValueIsNotNull(textView, Constants_MVVM.EXTRA_TOOLBAR_TITLE);
        textView.setText(getResources().getString(C2723R.string.lbl_bdt_sales_list));
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.toolbar_sub_title);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "toolbar_sub_title");
        textView2.setVisibility(8);
        ImageView imageView = (ImageView) _$_findCachedViewById(C2723R.C2726id.ivShareLanding);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "ivShareLanding");
        imageView.setVisibility(8);
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.im_pre_bid_close)).setOnClickListener(new LandingBRESectionActivity$initializeUI$1(this));
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
        getResources().getBoolean(C2723R.bool.isTabletPhone);
        super.onBackPressed();
    }
}
