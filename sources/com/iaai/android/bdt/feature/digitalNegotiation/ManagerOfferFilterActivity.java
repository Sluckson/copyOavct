package com.iaai.android.bdt.feature.digitalNegotiation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferFilterAdapter;
import com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList;
import com.iaai.android.bdt.utils.Constants_MVVM;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/digitalNegotiation/ManagerOfferFilterActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferFilterAdapter$OnItemClickListener;", "()V", "manageOfferFilterAdapter", "Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferFilterAdapter;", "offersList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/digitalNegotiation/MobileNegotiationsList;", "Lkotlin/collections/ArrayList;", "selectedFilter", "Lcom/iaai/android/bdt/feature/digitalNegotiation/FilterSelected;", "initializeRecycler", "", "initializeUI", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "filterSelected", "position", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ManagerOfferFilterActivity.kt */
public final class ManagerOfferFilterActivity extends BaseActivity implements ManageOfferFilterAdapter.OnItemClickListener {
    private HashMap _$_findViewCache;
    private ManageOfferFilterAdapter manageOfferFilterAdapter;
    private ArrayList<MobileNegotiationsList> offersList = new ArrayList<>();
    /* access modifiers changed from: private */
    public FilterSelected selectedFilter = FilterSelected.ALL;

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
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_manager_offer_filter);
        Intent intent = getIntent();
        Serializable serializable = null;
        Serializable serializableExtra = intent != null ? intent.getSerializableExtra(Constants_MVVM.SELECTED_MANAGE_OFFER_FILTER) : null;
        if (serializableExtra != null) {
            this.selectedFilter = (FilterSelected) serializableExtra;
            Intent intent2 = getIntent();
            if (intent2 != null) {
                serializable = intent2.getSerializableExtra(Constants_MVVM.MANAGER_OFFERS_LIST);
            }
            if (serializable != null) {
                this.offersList = (ArrayList) serializable;
                initializeUI();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList> /* = java.util.ArrayList<com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList> */");
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.digitalNegotiation.FilterSelected");
    }

    private final void initializeUI() {
        initializeRecycler();
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.ibClose)).setOnClickListener(new ManagerOfferFilterActivity$initializeUI$1(this));
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tvClearFilter)).setOnClickListener(new ManagerOfferFilterActivity$initializeUI$2(this));
        ((LinearLayout) _$_findCachedViewById(C2723R.C2726id.llApplyContainer)).setOnClickListener(new ManagerOfferFilterActivity$initializeUI$3(this));
    }

    /* access modifiers changed from: private */
    public final void initializeRecycler() {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
        this.manageOfferFilterAdapter = new ManageOfferFilterAdapter(applicationContext);
        ManageOfferFilterAdapter manageOfferFilterAdapter2 = this.manageOfferFilterAdapter;
        if (manageOfferFilterAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferFilterAdapter");
        }
        manageOfferFilterAdapter2.setSelectedFilter(this.selectedFilter);
        ManageOfferFilterAdapter manageOfferFilterAdapter3 = this.manageOfferFilterAdapter;
        if (manageOfferFilterAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferFilterAdapter");
        }
        manageOfferFilterAdapter3.setNegotiationList(this.offersList);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvFilter);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvFilter");
        ManageOfferFilterAdapter manageOfferFilterAdapter4 = this.manageOfferFilterAdapter;
        if (manageOfferFilterAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferFilterAdapter");
        }
        recyclerView.setAdapter(manageOfferFilterAdapter4);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvFilter);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvFilter");
        recyclerView2.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        ManageOfferFilterAdapter manageOfferFilterAdapter5 = this.manageOfferFilterAdapter;
        if (manageOfferFilterAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferFilterAdapter");
        }
        manageOfferFilterAdapter5.setClickListener(this);
    }

    public void onItemClick(@NotNull FilterSelected filterSelected, int i) {
        Intrinsics.checkParameterIsNotNull(filterSelected, "filterSelected");
        this.selectedFilter = filterSelected;
    }
}
