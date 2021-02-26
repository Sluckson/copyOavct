package com.iaai.android.bdt.feature.landing.recommendedVehicles;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.feature.landing.BDTLandingPageActivity;
import com.iaai.android.bdt.model.recommendedVehicles.RecommendedVehiclesResponse;
import com.iaai.android.databinding.FragmentRecommendedVehiclesBinding;
import dagger.android.support.AndroidSupportInjection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0014\u0010 \u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/recommendedVehicles/RecommendedVehiclesFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "Lcom/iaai/android/bdt/feature/landing/recommendedVehicles/VehicleClickListener;", "()V", "bdtLandingPageActivity", "Lcom/iaai/android/bdt/feature/landing/BDTLandingPageActivity;", "recommendedVehiclesAdapter", "Lcom/iaai/android/bdt/feature/landing/recommendedVehicles/RecommendedVehiclesAdapter;", "vehiclesList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/recommendedVehicles/RecommendedVehiclesResponse;", "Lkotlin/collections/ArrayList;", "initializeRecycler", "", "vehicleList", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onBadgeIconClick", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onRecommendedVehicleClick", "position", "", "setData", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: RecommendedVehiclesFragment.kt */
public final class RecommendedVehiclesFragment extends BaseFragment implements VehicleClickListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private HashMap _$_findViewCache;
    private BDTLandingPageActivity bdtLandingPageActivity;
    private RecommendedVehiclesAdapter recommendedVehiclesAdapter;
    private ArrayList<RecommendedVehiclesResponse> vehiclesList = new ArrayList<>();

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

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.bdtLandingPageActivity = (BDTLandingPageActivity) activity;
            if (context instanceof BDTLandingPageActivity) {
                this.bdtLandingPageActivity = (BDTLandingPageActivity) context;
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.landing.BDTLandingPageActivity");
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        FragmentRecommendedVehiclesBinding fragmentRecommendedVehiclesBinding = (FragmentRecommendedVehiclesBinding) DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.fragment_recommended_vehicles, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(fragmentRecommendedVehiclesBinding, "mBinding");
        return fragmentRecommendedVehiclesBinding.getRoot();
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    private final void initializeRecycler(List<RecommendedVehiclesResponse> list) {
        this.vehiclesList = new ArrayList<>(list);
        BDTLandingPageActivity bDTLandingPageActivity = this.bdtLandingPageActivity;
        if (bDTLandingPageActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
        }
        this.recommendedVehiclesAdapter = new RecommendedVehiclesAdapter(bDTLandingPageActivity, this);
        RecommendedVehiclesAdapter recommendedVehiclesAdapter2 = this.recommendedVehiclesAdapter;
        if (recommendedVehiclesAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recommendedVehiclesAdapter");
        }
        recommendedVehiclesAdapter2.setData(this.vehiclesList);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvRecommendedVehicles);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvRecommendedVehicles");
        RecommendedVehiclesAdapter recommendedVehiclesAdapter3 = this.recommendedVehiclesAdapter;
        if (recommendedVehiclesAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recommendedVehiclesAdapter");
        }
        recyclerView.setAdapter(recommendedVehiclesAdapter3);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvRecommendedVehicles);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvRecommendedVehicles");
        BDTLandingPageActivity bDTLandingPageActivity2 = this.bdtLandingPageActivity;
        if (bDTLandingPageActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(bDTLandingPageActivity2, 0, false));
    }

    public final void setData(@NotNull List<RecommendedVehiclesResponse> list) {
        Intrinsics.checkParameterIsNotNull(list, "vehicleList");
        initializeRecycler(list);
    }

    public void onRecommendedVehicleClick(int i) {
        BDTLandingPageActivity bDTLandingPageActivity = this.bdtLandingPageActivity;
        if (bDTLandingPageActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
        }
        bDTLandingPageActivity.getRecommendedVehicleClicked(i, this.vehiclesList);
    }

    public void onBadgeIconClick() {
        BDTLandingPageActivity bDTLandingPageActivity = this.bdtLandingPageActivity;
        if (bDTLandingPageActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
        }
        CustomPopUpDialog customPopUpDialog = new CustomPopUpDialog(bDTLandingPageActivity);
        Window window = customPopUpDialog.getWindow();
        if (window != null) {
            window.setGravity(48);
        }
        customPopUpDialog.show();
        customPopUpDialog.setCanceledOnTouchOutside(false);
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/recommendedVehicles/RecommendedVehiclesFragment$Companion;", "", "()V", "newInstance", "Lcom/iaai/android/bdt/feature/landing/recommendedVehicles/RecommendedVehiclesFragment;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: RecommendedVehiclesFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RecommendedVehiclesFragment newInstance() {
            return new RecommendedVehiclesFragment();
        }
    }
}
