package com.iaai.android.bdt.feature.productDetail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavArgument;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.Navigation;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.utils.constants.Constants;
import dagger.android.AndroidInjection;
import java.util.ArrayList;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.subjects.CompletableSubject;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u00182\b\u00104\u001a\u0004\u0018\u000105H\u0014J\b\u00106\u001a\u000201H\u0016J\u0012\u00107\u001a\u0002012\b\u00108\u001a\u0004\u0018\u000109H\u0014J\b\u0010:\u001a\u000201H\u0014J\u0010\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u000201H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\tX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020!X.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u000e\u0010)\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u00020+8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006?"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/ProductDetailActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "()V", "branchId", "", "fastSearchParam", "header", "idList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isFromSearchVehicle", "", "Ljava/lang/Boolean;", "itemId", "ivStockShare", "Landroid/widget/ImageView;", "getIvStockShare", "()Landroid/widget/ImageView;", "setIvStockShare", "(Landroid/widget/ImageView;)V", "liveDate", "onDestroyCompletable", "Lio/reactivex/subjects/CompletableSubject;", "position", "", "tenant", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "toolbarSubTitle", "Landroid/widget/TextView;", "getToolbarSubTitle", "()Landroid/widget/TextView;", "setToolbarSubTitle", "(Landroid/widget/TextView;)V", "toolbarTitle", "getToolbarTitle", "setToolbarTitle", "totalCount", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "setActionBar", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailActivity.kt */
public final class ProductDetailActivity extends BaseActivity {
    private HashMap _$_findViewCache;
    private String branchId = "";
    private String fastSearchParam = "";
    private String header = "";
    private ArrayList<String> idList = new ArrayList<>();
    /* access modifiers changed from: private */
    public Boolean isFromSearchVehicle = false;
    private String itemId = "";
    @NotNull
    public ImageView ivStockShare;
    private String liveDate = "";
    private final CompletableSubject onDestroyCompletable;
    private int position;
    private String tenant = "";
    @NotNull
    public Toolbar toolbar;
    @NotNull
    public TextView toolbarSubTitle;
    @NotNull
    public TextView toolbarTitle;
    private int totalCount;
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

    public ProductDetailActivity() {
        CompletableSubject create = CompletableSubject.create();
        if (create == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(create, "CompletableSubject.create()!!");
        this.onDestroyCompletable = create;
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

    @NotNull
    public final TextView getToolbarSubTitle() {
        TextView textView = this.toolbarSubTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbarSubTitle");
        }
        return textView;
    }

    public final void setToolbarSubTitle(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.toolbarSubTitle = textView;
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
        setContentView((int) C2723R.C2728layout.activity_product_detail_fragment_container);
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.im_pre_bid_close)).setOnClickListener(new ProductDetailActivity$onCreate$1(this));
        this.itemId = getIntent().getStringExtra(Constants.EXTRA_ITEM_ID);
        this.header = getIntent().getStringExtra(Constants.EXTRA_YEAR_MAKE_MODEL);
        if (getIntent().getStringExtra("countryCode") != null) {
            this.tenant = getIntent().getStringExtra("countryCode");
        }
        this.isFromSearchVehicle = Boolean.valueOf(getIntent().getBooleanExtra("isFromSearchVehicle", false));
        setActionBar();
        this.totalCount = getIntent().getIntExtra(Constants_MVVM.EXTRA_TOTAL_COUNT, 0);
        this.branchId = getIntent().getStringExtra(Constants_MVVM.EXTRA_BRANCH_ID);
        this.position = getIntent().getIntExtra(Constants_MVVM.EXTRA_ITEM_POSITION, 0);
        this.liveDate = getIntent().getStringExtra(Constants_MVVM.EXTRA_AUCTION_DATE);
        if (Intrinsics.areEqual((Object) this.isFromSearchVehicle, (Object) true)) {
            ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra(Constants_MVVM.EXTRA_ITEM_IDS_LIST);
            Intrinsics.checkExpressionValueIsNotNull(stringArrayListExtra, "intent.getStringArrayLis…MVVM.EXTRA_ITEM_IDS_LIST)");
            this.idList = stringArrayListExtra;
            this.fastSearchParam = getIntent().getStringExtra(Constants_MVVM.EXTRA_FAST_SEARCH_PARAM);
        }
        String str = this.itemId;
        if (str != null) {
            if (str == null) {
                Intrinsics.throwNpe();
            }
            if (str.length() > 0) {
                if (Intrinsics.areEqual((Object) this.isFromSearchVehicle, (Object) true)) {
                    NavController findNavController = Navigation.findNavController(activity, C2723R.C2726id.main_nav_host_product_activity);
                    Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…av_host_product_activity)");
                    NavInflater navInflater = findNavController.getNavInflater();
                    Intrinsics.checkExpressionValueIsNotNull(navInflater, "navController.navInflater");
                    NavGraph inflate = navInflater.inflate(C2723R.C2730navigation.navigation_graph_find_vehicle);
                    Intrinsics.checkExpressionValueIsNotNull(inflate, "navInflater.inflate(R.na…ation_graph_find_vehicle)");
                    NavArgument build = new NavArgument.Builder().setDefaultValue(this.itemId).build();
                    Intrinsics.checkExpressionValueIsNotNull(build, "NavArgument.Builder().se…aultValue(itemId).build()");
                    inflate.addArgument(Constants.EXTRA_ITEM_ID, build);
                    NavArgument build2 = new NavArgument.Builder().setDefaultValue(Integer.valueOf(this.position)).build();
                    Intrinsics.checkExpressionValueIsNotNull(build2, "NavArgument.Builder().se…ltValue(position).build()");
                    inflate.addArgument(Constants_MVVM.EXTRA_ITEM_POSITION, build2);
                    NavArgument build3 = new NavArgument.Builder().setDefaultValue(this.branchId).build();
                    Intrinsics.checkExpressionValueIsNotNull(build3, "NavArgument.Builder().se…ltValue(branchId).build()");
                    inflate.addArgument(Constants_MVVM.EXTRA_BRANCH_ID, build3);
                    NavArgument build4 = new NavArgument.Builder().setDefaultValue(Integer.valueOf(this.totalCount)).build();
                    Intrinsics.checkExpressionValueIsNotNull(build4, "NavArgument.Builder().se…Value(totalCount).build()");
                    inflate.addArgument(Constants_MVVM.EXTRA_TOTAL_COUNT, build4);
                    NavArgument build5 = new NavArgument.Builder().setDefaultValue(this.idList).build();
                    Intrinsics.checkExpressionValueIsNotNull(build5, "NavArgument.Builder().se…aultValue(idList).build()");
                    inflate.addArgument(Constants_MVVM.EXTRA_ITEM_IDS_LIST, build5);
                    NavArgument build6 = new NavArgument.Builder().setDefaultValue(this.fastSearchParam).build();
                    Intrinsics.checkExpressionValueIsNotNull(build6, "NavArgument.Builder().se…(fastSearchParam).build()");
                    inflate.addArgument(Constants_MVVM.EXTRA_FAST_SEARCH_PARAM, build6);
                    NavArgument build7 = new NavArgument.Builder().setDefaultValue(this.tenant).build();
                    Intrinsics.checkExpressionValueIsNotNull(build7, "NavArgument.Builder().se…aultValue(tenant).build()");
                    inflate.addArgument("countryCode", build7);
                    findNavController.setGraph(inflate);
                    return;
                }
                NavController findNavController2 = Navigation.findNavController(activity, C2723R.C2726id.main_nav_host_product_activity);
                Intrinsics.checkExpressionValueIsNotNull(findNavController2, "Navigation.findNavContro…av_host_product_activity)");
                NavInflater navInflater2 = findNavController2.getNavInflater();
                Intrinsics.checkExpressionValueIsNotNull(navInflater2, "navController.navInflater");
                NavGraph inflate2 = navInflater2.inflate(C2723R.C2730navigation.navigation_graph_auction_saleslist);
                Intrinsics.checkExpressionValueIsNotNull(inflate2, "navInflater.inflate(R.na…_graph_auction_saleslist)");
                NavArgument build8 = new NavArgument.Builder().setDefaultValue(this.itemId).build();
                Intrinsics.checkExpressionValueIsNotNull(build8, "NavArgument.Builder().se…aultValue(itemId).build()");
                inflate2.addArgument(Constants.EXTRA_ITEM_ID, build8);
                NavArgument build9 = new NavArgument.Builder().setDefaultValue(this.tenant).build();
                Intrinsics.checkExpressionValueIsNotNull(build9, "NavArgument.Builder().se…aultValue(tenant).build()");
                inflate2.addArgument("countryCode", build9);
                findNavController2.setGraph(inflate2);
                return;
            }
        }
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.emptyView);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "emptyView");
        linearLayout.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void setActionBar() {
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout_fs);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "toolbar_relativelayout_fs");
        relativeLayout.setVisibility(0);
        View findViewById = findViewById(C2723R.C2726id.toolbar);
        if (findViewById != null) {
            this.toolbar = (Toolbar) findViewById;
            Toolbar toolbar2 = this.toolbar;
            if (toolbar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbar");
            }
            setSupportActionBar(toolbar2);
            View findViewById2 = findViewById(C2723R.C2726id.toolbar_title_fs);
            if (findViewById2 != null) {
                this.toolbarTitle = (TextView) findViewById2;
                View findViewById3 = findViewById(C2723R.C2726id.toolbar_sub_title_fs);
                if (findViewById3 != null) {
                    this.toolbarSubTitle = (TextView) findViewById3;
                    View findViewById4 = findViewById(C2723R.C2726id.ivSharePD);
                    if (findViewById4 != null) {
                        this.ivStockShare = (ImageView) findViewById4;
                        ActionBar supportActionBar = getSupportActionBar();
                        if (supportActionBar != null) {
                            supportActionBar.setDisplayHomeAsUpEnabled(true);
                        }
                        ActionBar supportActionBar2 = getSupportActionBar();
                        if (supportActionBar2 != null) {
                            supportActionBar2.setHomeButtonEnabled(true);
                        }
                        TextView textView = this.toolbarTitle;
                        if (textView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("toolbarTitle");
                        }
                        textView.setText(this.header);
                        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.prebid_title_layout_fs);
                        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "prebid_title_layout_fs");
                        constraintLayout.setVisibility(8);
                        TextView textView2 = this.toolbarSubTitle;
                        if (textView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("toolbarSubTitle");
                        }
                        textView2.setVisibility(8);
                        ImageView imageView = this.ivStockShare;
                        if (imageView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("ivStockShare");
                        }
                        imageView.setVisibility(0);
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

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.onDestroyCompletable.onComplete();
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(supportFragmentManager, "supportFragmentManager");
        for (Fragment onActivityResult : supportFragmentManager.getFragments()) {
            onActivityResult.onActivityResult(i, i2, intent);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (!Intrinsics.areEqual((Object) this.isFromSearchVehicle, (Object) true)) {
            setActionBar();
        }
    }
}
