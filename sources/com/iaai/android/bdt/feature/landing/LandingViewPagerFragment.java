package com.iaai.android.bdt.feature.landing;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.feature.productDetail.ViewPagerAdapter;
import com.iaai.android.bdt.utils.BDTUtils;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.databinding.ViewPagerProductDetailBinding;
import com.iaai.android.old.utils.IAASharedPreference;
import dagger.android.support.AndroidSupportInjection;
import java.util.ArrayList;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0017J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000¨\u0006*"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/LandingViewPagerFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "()V", "adapter", "Lcom/iaai/android/bdt/feature/productDetail/ViewPagerAdapter;", "baseActivity", "Lcom/iaai/android/bdt/base/BaseActivity;", "itemIdList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "itemPosition", "", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "tenantList", "getTenantList", "()Ljava/util/ArrayList;", "setTenantList", "(Ljava/util/ArrayList;)V", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "updateToolbar", "pos", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: LandingViewPagerFragment.kt */
public final class LandingViewPagerFragment extends BaseFragment {
    private HashMap _$_findViewCache;
    private ViewPagerAdapter adapter;
    /* access modifiers changed from: private */
    public BaseActivity baseActivity;
    /* access modifiers changed from: private */
    public ArrayList<String> itemIdList = new ArrayList<>();
    private int itemPosition;
    @Inject
    @NotNull
    public SessionManager sessionManager;
    @NotNull
    private ArrayList<String> tenantList = new ArrayList<>();
    /* access modifiers changed from: private */
    public ViewPager viewPager;

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

    public static final /* synthetic */ BaseActivity access$getBaseActivity$p(LandingViewPagerFragment landingViewPagerFragment) {
        BaseActivity baseActivity2 = landingViewPagerFragment.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        return baseActivity2;
    }

    public static final /* synthetic */ ViewPager access$getViewPager$p(LandingViewPagerFragment landingViewPagerFragment) {
        ViewPager viewPager2 = landingViewPagerFragment.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        return viewPager2;
    }

    @NotNull
    public final ArrayList<String> getTenantList() {
        return this.tenantList;
    }

    public final void setTenantList(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.tenantList = arrayList;
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

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.baseActivity = (LandingBRESectionActivity) activity;
            if (context instanceof LandingBRESectionActivity) {
                this.baseActivity = (BaseActivity) context;
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.landing.LandingBRESectionActivity");
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (IAASharedPreference.getIsLoggedInPreferencesMVVM(getContext()).booleanValue()) {
            SessionManager sessionManager2 = this.sessionManager;
            if (sessionManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            if (!Intrinsics.areEqual((Object) sessionManager2.getCurrentSessionBuyerId(), (Object) "0")) {
                return;
            }
        }
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        Toast.makeText(baseActivity2, getString(C2723R.string.bdt_lbl_to_check_user), 1).show();
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        ViewPagerProductDetailBinding viewPagerProductDetailBinding = (ViewPagerProductDetailBinding) DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.view_pager_product_detail, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(viewPagerProductDetailBinding, "mBinding");
        return viewPagerProductDetailBinding.getRoot();
    }

    @RequiresApi(23)
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            Intrinsics.throwNpe();
        }
        ArrayList<String> stringArrayList = arguments.getStringArrayList(Constants_MVVM.EXTRA_ITEM_IDS_LIST);
        Intrinsics.checkExpressionValueIsNotNull(stringArrayList, "arguments!!.getStringArr…MVVM.EXTRA_ITEM_IDS_LIST)");
        this.itemIdList = stringArrayList;
        Bundle arguments2 = getArguments();
        if (arguments2 == null) {
            Intrinsics.throwNpe();
        }
        this.itemPosition = arguments2.getInt(Constants_MVVM.EXTRA_ITEM_POSITION);
        Bundle arguments3 = getArguments();
        if (arguments3 == null) {
            Intrinsics.throwNpe();
        }
        if (arguments3.getStringArrayList("countryCode") != null) {
            Bundle arguments4 = getArguments();
            if (arguments4 == null) {
                Intrinsics.throwNpe();
            }
            ArrayList<String> stringArrayList2 = arguments4.getStringArrayList("countryCode");
            Intrinsics.checkExpressionValueIsNotNull(stringArrayList2, "arguments!!.getStringArr…_MVVM.EXTRA_COUNTRY_CODE)");
            this.tenantList = stringArrayList2;
        }
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        RelativeLayout relativeLayout = (RelativeLayout) baseActivity2._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "baseActivity.toolbar_relativelayout");
        relativeLayout.setVisibility(0);
        BaseActivity baseActivity3 = this.baseActivity;
        if (baseActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        ActionBar supportActionBar = baseActivity3.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        BaseActivity baseActivity4 = this.baseActivity;
        if (baseActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        ActionBar supportActionBar2 = baseActivity4.getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setHomeButtonEnabled(true);
        }
        BaseActivity baseActivity5 = this.baseActivity;
        if (baseActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) baseActivity5._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "baseActivity.prebid_title_layout");
        constraintLayout.setVisibility(8);
        BaseActivity baseActivity6 = this.baseActivity;
        if (baseActivity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        ImageView imageView = (ImageView) baseActivity6._$_findCachedViewById(C2723R.C2726id.ivShareLanding);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "baseActivity.ivShareLanding");
        imageView.setVisibility(0);
        updateToolbar(this.itemPosition);
        BaseActivity baseActivity7 = this.baseActivity;
        if (baseActivity7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        View findViewById = baseActivity7.findViewById(C2723R.C2726id.viewPager2);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "baseActivity.findViewById(R.id.viewPager2)");
        this.viewPager = (ViewPager) findViewById;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(childFragmentManager, "childFragmentManager");
        this.adapter = new ViewPagerAdapter(childFragmentManager, this.itemIdList, this.tenantList);
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        ViewPagerAdapter viewPagerAdapter = this.adapter;
        if (viewPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        viewPager2.setAdapter(viewPagerAdapter);
        ViewPager viewPager3 = this.viewPager;
        if (viewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager3.setCurrentItem(this.itemPosition, true);
        ViewPager viewPager4 = this.viewPager;
        if (viewPager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager4.setOffscreenPageLimit(0);
        ViewPager viewPager5 = this.viewPager;
        if (viewPager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager5.addOnPageChangeListener(new LandingViewPagerFragment$onActivityCreated$1(this));
        BaseActivity baseActivity8 = this.baseActivity;
        if (baseActivity8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        ((ImageView) baseActivity8._$_findCachedViewById(C2723R.C2726id.arrow_left)).setOnClickListener(new LandingViewPagerFragment$onActivityCreated$2(this));
        BaseActivity baseActivity9 = this.baseActivity;
        if (baseActivity9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        ((ImageView) baseActivity9._$_findCachedViewById(C2723R.C2726id.arrow_right)).setOnClickListener(new LandingViewPagerFragment$onActivityCreated$3(this));
    }

    /* access modifiers changed from: private */
    public final void updateToolbar(int i) {
        if (this.itemIdList.size() > 1) {
            BaseActivity baseActivity2 = this.baseActivity;
            if (baseActivity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            TextView textView = (TextView) baseActivity2._$_findCachedViewById(C2723R.C2726id.toolbar_title);
            Intrinsics.checkExpressionValueIsNotNull(textView, "baseActivity.toolbar_title");
            textView.setText(String.valueOf(i + 1) + " of " + BDTUtils.INSTANCE.getCountDisplay(this.itemIdList.size()));
            BaseActivity baseActivity3 = this.baseActivity;
            if (baseActivity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            ((TextView) baseActivity3._$_findCachedViewById(C2723R.C2726id.toolbar_title)).setTextColor(getResources().getColor(C2723R.C2724color.bdt_gray_darker));
            BaseActivity baseActivity4 = this.baseActivity;
            if (baseActivity4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            TextView textView2 = (TextView) baseActivity4._$_findCachedViewById(C2723R.C2726id.toolbar_sub_title);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "baseActivity.toolbar_sub_title");
            textView2.setVisibility(8);
            if (i == 0) {
                BaseActivity baseActivity5 = this.baseActivity;
                if (baseActivity5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
                }
                ImageView imageView = (ImageView) baseActivity5._$_findCachedViewById(C2723R.C2726id.arrow_left);
                Intrinsics.checkExpressionValueIsNotNull(imageView, "baseActivity.arrow_left");
                imageView.setVisibility(0);
                BaseActivity baseActivity6 = this.baseActivity;
                if (baseActivity6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
                }
                ImageView imageView2 = (ImageView) baseActivity6._$_findCachedViewById(C2723R.C2726id.arrow_left);
                Intrinsics.checkExpressionValueIsNotNull(imageView2, "baseActivity.arrow_left");
                imageView2.setEnabled(false);
                BaseActivity baseActivity7 = this.baseActivity;
                if (baseActivity7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
                }
                ((ImageView) baseActivity7._$_findCachedViewById(C2723R.C2726id.arrow_left)).setImageResource(C2723R.C2725drawable.icon_left_arrow_disable);
            } else {
                BaseActivity baseActivity8 = this.baseActivity;
                if (baseActivity8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
                }
                ImageView imageView3 = (ImageView) baseActivity8._$_findCachedViewById(C2723R.C2726id.arrow_left);
                Intrinsics.checkExpressionValueIsNotNull(imageView3, "baseActivity.arrow_left");
                imageView3.setVisibility(0);
                BaseActivity baseActivity9 = this.baseActivity;
                if (baseActivity9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
                }
                ImageView imageView4 = (ImageView) baseActivity9._$_findCachedViewById(C2723R.C2726id.arrow_left);
                Intrinsics.checkExpressionValueIsNotNull(imageView4, "baseActivity.arrow_left");
                imageView4.setEnabled(true);
                BaseActivity baseActivity10 = this.baseActivity;
                if (baseActivity10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
                }
                ((ImageView) baseActivity10._$_findCachedViewById(C2723R.C2726id.arrow_left)).setImageResource(C2723R.C2725drawable.icon_left_arrow);
            }
            if (i == this.itemIdList.size() - 1) {
                BaseActivity baseActivity11 = this.baseActivity;
                if (baseActivity11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
                }
                ImageView imageView5 = (ImageView) baseActivity11._$_findCachedViewById(C2723R.C2726id.arrow_right);
                Intrinsics.checkExpressionValueIsNotNull(imageView5, "baseActivity.arrow_right");
                imageView5.setVisibility(0);
                BaseActivity baseActivity12 = this.baseActivity;
                if (baseActivity12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
                }
                ImageView imageView6 = (ImageView) baseActivity12._$_findCachedViewById(C2723R.C2726id.arrow_right);
                Intrinsics.checkExpressionValueIsNotNull(imageView6, "baseActivity.arrow_right");
                imageView6.setEnabled(false);
                BaseActivity baseActivity13 = this.baseActivity;
                if (baseActivity13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
                }
                ((ImageView) baseActivity13._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_right_arrow_disable);
                return;
            }
            BaseActivity baseActivity14 = this.baseActivity;
            if (baseActivity14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            ImageView imageView7 = (ImageView) baseActivity14._$_findCachedViewById(C2723R.C2726id.arrow_right);
            Intrinsics.checkExpressionValueIsNotNull(imageView7, "baseActivity.arrow_right");
            imageView7.setVisibility(0);
            BaseActivity baseActivity15 = this.baseActivity;
            if (baseActivity15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            ImageView imageView8 = (ImageView) baseActivity15._$_findCachedViewById(C2723R.C2726id.arrow_right);
            Intrinsics.checkExpressionValueIsNotNull(imageView8, "baseActivity.arrow_right");
            imageView8.setEnabled(true);
            BaseActivity baseActivity16 = this.baseActivity;
            if (baseActivity16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            ((ImageView) baseActivity16._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_right_arrow);
            return;
        }
        BaseActivity baseActivity17 = this.baseActivity;
        if (baseActivity17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        TextView textView3 = (TextView) baseActivity17._$_findCachedViewById(C2723R.C2726id.toolbar_sub_title);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "baseActivity.toolbar_sub_title");
        textView3.setVisibility(8);
    }
}
