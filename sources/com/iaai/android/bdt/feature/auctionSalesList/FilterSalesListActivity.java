package com.iaai.android.bdt.feature.auctionSalesList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.feature.auctionSalesList.ClearFilterAdapter;
import com.iaai.android.bdt.feature.auctionSalesList.LaneAdapter;
import com.iaai.android.bdt.model.auctionSalesList.ClearFilter;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.NewDateHelper;
import com.iaai.android.old.utils.IAASharedPreference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\fH\u0002J\u0012\u0010\"\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\b\u0010%\u001a\u00020\u001dH\u0016J\b\u0010&\u001a\u00020\u001dH\u0016J\b\u0010'\u001a\u00020\u001dH\u0016J\b\u0010(\u001a\u00020\u001dH\u0014J\b\u0010)\u001a\u00020\u001dH\u0002J\b\u0010*\u001a\u00020\u001dH\u0002J<\u0010+\u001a\u00020\u001d2\u001a\u0010,\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\n2\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00100\bj\b\u0012\u0004\u0012\u00020\u0010`\nH\u0002J\b\u0010.\u001a\u00020\u001dH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00100\bj\b\u0012\u0004\u0012\u00020\u0010`\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionSalesList/FilterSalesListActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "Lcom/iaai/android/bdt/feature/auctionSalesList/ClearFilterAdapter$OnItemClickListener;", "Lcom/iaai/android/bdt/feature/auctionSalesList/LaneAdapter$OnItemClickListener;", "()V", "clearFilterAdapter", "Lcom/iaai/android/bdt/feature/auctionSalesList/ClearFilterAdapter;", "clearFilterList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/auctionSalesList/ClearFilter;", "Lkotlin/collections/ArrayList;", "endYear", "", "isClearFilter", "", "lane", "", "getLane", "()Ljava/lang/String;", "setLane", "(Ljava/lang/String;)V", "laneAdapter", "Lcom/iaai/android/bdt/feature/auctionSalesList/LaneAdapter;", "laneList", "lossType", "lossTypeItemPosition", "screenName", "startYear", "OnItemSelected", "", "position", "initializeUI", "lossTypeSelector", "lossTypeItem", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFilterLaneCancelClick", "onFilterLossTypeCancelClick", "onFilterYearCancelClick", "onResume", "setFilterCountVisibilty", "updateClearFilterUI", "updateLaneUI", "lanes", "lanesListCount", "viewClickListener", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FilterSalesListActivity.kt */
public final class FilterSalesListActivity extends BaseActivity implements ClearFilterAdapter.OnItemClickListener, LaneAdapter.OnItemClickListener {
    private HashMap _$_findViewCache;
    private ClearFilterAdapter clearFilterAdapter;
    private ArrayList<ClearFilter> clearFilterList = new ArrayList<>();
    /* access modifiers changed from: private */
    public int endYear;
    /* access modifiers changed from: private */
    public boolean isClearFilter;
    @NotNull
    private String lane = "";
    /* access modifiers changed from: private */
    public LaneAdapter laneAdapter;
    private ArrayList<String> laneList = new ArrayList<>();
    /* access modifiers changed from: private */
    public String lossType = "";
    /* access modifiers changed from: private */
    public int lossTypeItemPosition;
    private String screenName = "";
    /* access modifiers changed from: private */
    public int startYear;

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

    public static final /* synthetic */ LaneAdapter access$getLaneAdapter$p(FilterSalesListActivity filterSalesListActivity) {
        LaneAdapter laneAdapter2 = filterSalesListActivity.laneAdapter;
        if (laneAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("laneAdapter");
        }
        return laneAdapter2;
    }

    @NotNull
    public final String getLane() {
        return this.lane;
    }

    public final void setLane(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.lane = str;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_sales_list_filter_sort);
        initializeUI();
        Context applicationContext = getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
        this.clearFilterAdapter = new ClearFilterAdapter(applicationContext);
        Context applicationContext2 = getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext2, "applicationContext");
        this.laneAdapter = new LaneAdapter(applicationContext2);
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra(Constants_MVVM.EXTRA_LANE_LIST);
        ArrayList<String> stringArrayListExtra2 = getIntent().getStringArrayListExtra(Constants_MVVM.EXTRA_LANE_COUNT);
        Intent intent = getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent, "intent");
        String string = intent.getExtras().getString("screen_name");
        Intrinsics.checkExpressionValueIsNotNull(string, "intent.extras.getString(…s_MVVM.EXTRA_SCREEN_NAME)");
        this.screenName = string;
        Intrinsics.checkExpressionValueIsNotNull(stringArrayListExtra2, "lanesCount");
        updateLaneUI(stringArrayListExtra, stringArrayListExtra2);
        updateClearFilterUI();
        viewClickListener();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        IAAAnalytics.INSTANCE.logScreenName(this.screenName, this);
    }

    private final void initializeUI() {
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2723R.C2726id.toolbar));
        getWindow().setSoftInputMode(2);
        setFilterCountVisibilty();
        lossTypeSelector(IAASharedPreference.getLossTypeItemPosFilterPreferencesMVVM(getApplicationContext()));
    }

    private final void setFilterCountVisibilty() {
        String lossLypeFilterPreferencesMVVM = IAASharedPreference.getLossLypeFilterPreferencesMVVM(getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(lossLypeFilterPreferencesMVVM, "IAASharedPreference.getL…sMVVM(applicationContext)");
        boolean z = true;
        if (lossLypeFilterPreferencesMVVM.length() > 0) {
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_LossTypeCount);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tv_LossTypeCount");
            textView.setVisibility(0);
        } else {
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_LossTypeCount);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "tv_LossTypeCount");
            textView2.setVisibility(8);
        }
        String laneFilterPreferencesMVVM = IAASharedPreference.getLaneFilterPreferencesMVVM(getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(laneFilterPreferencesMVVM, "IAASharedPreference.getL…sMVVM(applicationContext)");
        if (laneFilterPreferencesMVVM.length() > 0) {
            TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_LaneCount);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "tv_LaneCount");
            textView3.setVisibility(0);
        } else {
            TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_LaneCount);
            Intrinsics.checkExpressionValueIsNotNull(textView4, "tv_LaneCount");
            textView4.setVisibility(8);
        }
        String yearFilterPreferencesMVVM = IAASharedPreference.getYearFilterPreferencesMVVM(getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(yearFilterPreferencesMVVM, "IAASharedPreference.getY…sMVVM(applicationContext)");
        if (yearFilterPreferencesMVVM.length() <= 0) {
            z = false;
        }
        if (z) {
            TextView textView5 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_yearCount);
            Intrinsics.checkExpressionValueIsNotNull(textView5, "tv_yearCount");
            textView5.setVisibility(0);
            return;
        }
        TextView textView6 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_yearCount);
        Intrinsics.checkExpressionValueIsNotNull(textView6, "tv_yearCount");
        textView6.setVisibility(8);
    }

    private final void updateLaneUI(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList == null) {
            Intrinsics.throwNpe();
        }
        if (arrayList.size() > 2) {
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.cl_lane_top_container);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "cl_lane_top_container");
            constraintLayout.setVisibility(0);
            View _$_findCachedViewById = _$_findCachedViewById(C2723R.C2726id.view_lane);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "view_lane");
            _$_findCachedViewById.setVisibility(0);
        } else {
            ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.cl_lane_top_container);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "cl_lane_top_container");
            constraintLayout2.setVisibility(8);
            View _$_findCachedViewById2 = _$_findCachedViewById(C2723R.C2726id.view_lane);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, "view_lane");
            _$_findCachedViewById2.setVisibility(8);
        }
        LaneAdapter laneAdapter2 = this.laneAdapter;
        if (laneAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("laneAdapter");
        }
        laneAdapter2.setLaneData(arrayList, arrayList2);
        LaneAdapter laneAdapter3 = this.laneAdapter;
        if (laneAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("laneAdapter");
        }
        laneAdapter3.setClickListener(this);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rv_lane);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rv_lane");
        LaneAdapter laneAdapter4 = this.laneAdapter;
        if (laneAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("laneAdapter");
        }
        recyclerView.setAdapter(laneAdapter4);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rv_lane);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rv_lane");
        recyclerView2.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            int indexOf = arrayList.indexOf(it.next());
            if (StringsKt.equals(arrayList.get(indexOf), IAASharedPreference.getLaneFilterPreferencesMVVM(getApplicationContext()), false)) {
                LaneAdapter laneAdapter5 = this.laneAdapter;
                if (laneAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("laneAdapter");
                }
                laneAdapter5.setSelected_position(indexOf);
                return;
            }
        }
    }

    private final void updateClearFilterUI() {
        if (!IAASharedPreference.getYearFilterPreferencesMVVM(getApplicationContext()).equals("")) {
            String yearFilterPreferencesMVVM = IAASharedPreference.getYearFilterPreferencesMVVM(getApplicationContext());
            Intrinsics.checkExpressionValueIsNotNull(yearFilterPreferencesMVVM, "IAASharedPreference.getY…sMVVM(applicationContext)");
            this.clearFilterList.add(new ClearFilter(yearFilterPreferencesMVVM, "Year"));
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.et_start_year);
            Intrinsics.checkExpressionValueIsNotNull(textView, "et_start_year");
            textView.setText(IAASharedPreference.getStartYearFilterPreferencesMVVM(getApplicationContext()));
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.et_end_year);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "et_end_year");
            textView2.setText(IAASharedPreference.getEndYearFilterPreferencesMVVM(getApplicationContext()));
            String startYearFilterPreferencesMVVM = IAASharedPreference.getStartYearFilterPreferencesMVVM(getApplicationContext());
            Intrinsics.checkExpressionValueIsNotNull(startYearFilterPreferencesMVVM, "(IAASharedPreference.get…MVVM(applicationContext))");
            this.startYear = Integer.parseInt(startYearFilterPreferencesMVVM);
            String endYearFilterPreferencesMVVM = IAASharedPreference.getEndYearFilterPreferencesMVVM(getApplicationContext());
            Intrinsics.checkExpressionValueIsNotNull(endYearFilterPreferencesMVVM, "(IAASharedPreference.get…MVVM(applicationContext))");
            this.endYear = Integer.parseInt(endYearFilterPreferencesMVVM);
        } else {
            TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.et_start_year);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "et_start_year");
            textView3.setHint("1900");
            TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.et_end_year);
            Intrinsics.checkExpressionValueIsNotNull(textView4, "et_end_year");
            textView4.setHint(NewDateHelper.INSTANCE.getCurrentYear());
        }
        if (!IAASharedPreference.getLaneFilterPreferencesMVVM(getApplicationContext()).equals("")) {
            String laneFilterPreferencesMVVM = IAASharedPreference.getLaneFilterPreferencesMVVM(getApplicationContext());
            Intrinsics.checkExpressionValueIsNotNull(laneFilterPreferencesMVVM, "IAASharedPreference.getL…sMVVM(applicationContext)");
            this.clearFilterList.add(new ClearFilter(laneFilterPreferencesMVVM, "Lane"));
        }
        if (!IAASharedPreference.getLossLypeFilterPreferencesMVVM(getApplicationContext()).equals("")) {
            String lossLypeFilterPreferencesMVVM = IAASharedPreference.getLossLypeFilterPreferencesMVVM(getApplicationContext());
            Intrinsics.checkExpressionValueIsNotNull(lossLypeFilterPreferencesMVVM, "IAASharedPreference.getL…sMVVM(applicationContext)");
            this.clearFilterList.add(new ClearFilter(lossLypeFilterPreferencesMVVM, "LossType"));
        }
        if (this.clearFilterList.size() > 0) {
            TextView textView5 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvClearfilterSales);
            Intrinsics.checkExpressionValueIsNotNull(textView5, "tvClearfilterSales");
            textView5.setVisibility(0);
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.cl_clearFilter_container);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "cl_clearFilter_container");
            constraintLayout.setVisibility(0);
        } else {
            TextView textView6 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvClearfilterSales);
            Intrinsics.checkExpressionValueIsNotNull(textView6, "tvClearfilterSales");
            textView6.setVisibility(8);
            ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.cl_clearFilter_container);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "cl_clearFilter_container");
            constraintLayout2.setVisibility(8);
        }
        ClearFilterAdapter clearFilterAdapter2 = this.clearFilterAdapter;
        if (clearFilterAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clearFilterAdapter");
        }
        clearFilterAdapter2.setclearFilterList(this.clearFilterList);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rv_clearFilter);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rv_clearFilter");
        ClearFilterAdapter clearFilterAdapter3 = this.clearFilterAdapter;
        if (clearFilterAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clearFilterAdapter");
        }
        recyclerView.setAdapter(clearFilterAdapter3);
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getApplicationContext());
        flexboxLayoutManager.setFlexWrap(1);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rv_clearFilter);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rv_clearFilter");
        recyclerView2.setLayoutManager(flexboxLayoutManager);
        ClearFilterAdapter clearFilterAdapter4 = this.clearFilterAdapter;
        if (clearFilterAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clearFilterAdapter");
        }
        clearFilterAdapter4.setClickListener(this);
    }

    public void OnItemSelected(int i, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, Constants_MVVM.EXTRA_LANE);
        this.lane = str;
        if (i != 0) {
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_LaneCount);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tv_LaneCount");
            textView.setVisibility(0);
            return;
        }
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_LaneCount);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tv_LaneCount");
        textView2.setVisibility(8);
    }

    public void onFilterLaneCancelClick() {
        ClearFilterAdapter clearFilterAdapter2 = this.clearFilterAdapter;
        if (clearFilterAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clearFilterAdapter");
        }
        if (clearFilterAdapter2.getItemCount() == 0) {
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvClearfilterSales);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tvClearfilterSales");
            textView.setVisibility(8);
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.cl_clearFilter_container);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "cl_clearFilter_container");
            constraintLayout.setVisibility(8);
        }
        LaneAdapter laneAdapter2 = this.laneAdapter;
        if (laneAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("laneAdapter");
        }
        laneAdapter2.setSelected_position(0);
        LaneAdapter laneAdapter3 = this.laneAdapter;
        if (laneAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("laneAdapter");
        }
        laneAdapter3.notifyDataSetChanged();
        this.lane = "";
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_LaneCount);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tv_LaneCount");
        textView2.setVisibility(8);
    }

    public void onFilterLossTypeCancelClick() {
        ClearFilterAdapter clearFilterAdapter2 = this.clearFilterAdapter;
        if (clearFilterAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clearFilterAdapter");
        }
        if (clearFilterAdapter2.getItemCount() == 0) {
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvClearfilterSales);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tvClearfilterSales");
            textView.setVisibility(8);
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.cl_clearFilter_container);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "cl_clearFilter_container");
            constraintLayout.setVisibility(8);
        }
        lossTypeSelector(0);
        this.lossType = "";
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_LossTypeCount);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tv_LossTypeCount");
        textView2.setVisibility(8);
    }

    public void onFilterYearCancelClick() {
        ClearFilterAdapter clearFilterAdapter2 = this.clearFilterAdapter;
        if (clearFilterAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clearFilterAdapter");
        }
        if (clearFilterAdapter2.getItemCount() == 0) {
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvClearfilterSales);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tvClearfilterSales");
            textView.setVisibility(8);
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.cl_clearFilter_container);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "cl_clearFilter_container");
            constraintLayout.setVisibility(8);
        }
        this.startYear = 0;
        this.endYear = 0;
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.et_start_year);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "et_start_year");
        textView2.setHint("1900");
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.et_end_year);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "et_end_year");
        textView3.setHint(NewDateHelper.INSTANCE.getCurrentYear());
        TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.et_start_year);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "et_start_year");
        textView4.setText("");
        TextView textView5 = (TextView) _$_findCachedViewById(C2723R.C2726id.et_end_year);
        Intrinsics.checkExpressionValueIsNotNull(textView5, "et_end_year");
        textView5.setText("");
        TextView textView6 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_yearCount);
        Intrinsics.checkExpressionValueIsNotNull(textView6, "tv_yearCount");
        textView6.setVisibility(8);
    }

    private final void viewClickListener() {
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_allLossType_container)).setOnClickListener(new FilterSalesListActivity$viewClickListener$1(this));
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Collision_container)).setOnClickListener(new FilterSalesListActivity$viewClickListener$2(this));
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Fire_container)).setOnClickListener(new FilterSalesListActivity$viewClickListener$3(this));
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Theft_container)).setOnClickListener(new FilterSalesListActivity$viewClickListener$4(this));
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Water_container)).setOnClickListener(new FilterSalesListActivity$viewClickListener$5(this));
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Other_container)).setOnClickListener(new FilterSalesListActivity$viewClickListener$6(this));
        ((ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.cl_year_top_container)).setOnClickListener(new FilterSalesListActivity$viewClickListener$7(this));
        ((ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.cl_lane_top_container)).setOnClickListener(new FilterSalesListActivity$viewClickListener$8(this));
        ((ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.cl_loss_type_top_container)).setOnClickListener(new FilterSalesListActivity$viewClickListener$9(this));
        ((LinearLayout) _$_findCachedViewById(C2723R.C2726id.ll_applyFilter_container)).setOnClickListener(new FilterSalesListActivity$viewClickListener$10(this));
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.img_back)).setOnClickListener(new FilterSalesListActivity$viewClickListener$11(this));
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tvClearfilterSales)).setOnClickListener(new FilterSalesListActivity$viewClickListener$12(this));
        ((TextView) _$_findCachedViewById(C2723R.C2726id.et_start_year)).setOnClickListener(new FilterSalesListActivity$viewClickListener$13(this));
        ((TextView) _$_findCachedViewById(C2723R.C2726id.et_end_year)).setOnClickListener(new FilterSalesListActivity$viewClickListener$14(this));
    }

    /* access modifiers changed from: private */
    public final void lossTypeSelector(int i) {
        int i2 = i;
        if (i2 == 0) {
            this.lossTypeItemPosition = 0;
            RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Collision_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "layout_Collision_container");
            relativeLayout.setSelected(false);
            RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Fire_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "layout_Fire_container");
            relativeLayout2.setSelected(false);
            RelativeLayout relativeLayout3 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Theft_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout3, "layout_Theft_container");
            relativeLayout3.setSelected(false);
            RelativeLayout relativeLayout4 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Water_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout4, "layout_Water_container");
            relativeLayout4.setSelected(false);
            RelativeLayout relativeLayout5 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Other_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout5, "layout_Other_container");
            relativeLayout5.setSelected(false);
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_collision);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tv_collision");
            textView.setSelected(false);
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_fire);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "tv_fire");
            textView2.setSelected(false);
            TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_theft);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "tv_theft");
            textView3.setSelected(false);
            TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_water);
            Intrinsics.checkExpressionValueIsNotNull(textView4, "tv_water");
            textView4.setSelected(false);
            TextView textView5 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_other);
            Intrinsics.checkExpressionValueIsNotNull(textView5, "tv_other");
            textView5.setSelected(false);
            RelativeLayout relativeLayout6 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_allLossType_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout6, "layout_allLossType_container");
            relativeLayout6.setSelected(true);
            TextView textView6 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_allLossType);
            Intrinsics.checkExpressionValueIsNotNull(textView6, "tv_allLossType");
            textView6.setSelected(true);
            this.lossType = "";
        } else if (i2 == 1) {
            this.lossTypeItemPosition = 1;
            RelativeLayout relativeLayout7 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_allLossType_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout7, "layout_allLossType_container");
            relativeLayout7.setSelected(false);
            RelativeLayout relativeLayout8 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Fire_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout8, "layout_Fire_container");
            relativeLayout8.setSelected(false);
            RelativeLayout relativeLayout9 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Theft_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout9, "layout_Theft_container");
            relativeLayout9.setSelected(false);
            RelativeLayout relativeLayout10 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Water_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout10, "layout_Water_container");
            relativeLayout10.setSelected(false);
            RelativeLayout relativeLayout11 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Other_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout11, "layout_Other_container");
            relativeLayout11.setSelected(false);
            TextView textView7 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_allLossType);
            Intrinsics.checkExpressionValueIsNotNull(textView7, "tv_allLossType");
            textView7.setSelected(false);
            TextView textView8 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_fire);
            Intrinsics.checkExpressionValueIsNotNull(textView8, "tv_fire");
            textView8.setSelected(false);
            TextView textView9 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_theft);
            Intrinsics.checkExpressionValueIsNotNull(textView9, "tv_theft");
            textView9.setSelected(false);
            TextView textView10 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_water);
            Intrinsics.checkExpressionValueIsNotNull(textView10, "tv_water");
            textView10.setSelected(false);
            TextView textView11 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_other);
            Intrinsics.checkExpressionValueIsNotNull(textView11, "tv_other");
            textView11.setSelected(false);
            RelativeLayout relativeLayout12 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Collision_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout12, "layout_Collision_container");
            relativeLayout12.setSelected(true);
            TextView textView12 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_collision);
            Intrinsics.checkExpressionValueIsNotNull(textView12, "tv_collision");
            textView12.setSelected(true);
            this.lossType = "Collision";
        } else if (i2 == 2) {
            this.lossTypeItemPosition = 2;
            RelativeLayout relativeLayout13 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_allLossType_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout13, "layout_allLossType_container");
            relativeLayout13.setSelected(false);
            RelativeLayout relativeLayout14 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Collision_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout14, "layout_Collision_container");
            relativeLayout14.setSelected(false);
            RelativeLayout relativeLayout15 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Theft_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout15, "layout_Theft_container");
            relativeLayout15.setSelected(false);
            RelativeLayout relativeLayout16 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Water_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout16, "layout_Water_container");
            relativeLayout16.setSelected(false);
            RelativeLayout relativeLayout17 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Other_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout17, "layout_Other_container");
            relativeLayout17.setSelected(false);
            TextView textView13 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_allLossType);
            Intrinsics.checkExpressionValueIsNotNull(textView13, "tv_allLossType");
            textView13.setSelected(false);
            TextView textView14 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_collision);
            Intrinsics.checkExpressionValueIsNotNull(textView14, "tv_collision");
            textView14.setSelected(false);
            TextView textView15 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_theft);
            Intrinsics.checkExpressionValueIsNotNull(textView15, "tv_theft");
            textView15.setSelected(false);
            TextView textView16 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_water);
            Intrinsics.checkExpressionValueIsNotNull(textView16, "tv_water");
            textView16.setSelected(false);
            TextView textView17 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_other);
            Intrinsics.checkExpressionValueIsNotNull(textView17, "tv_other");
            textView17.setSelected(false);
            RelativeLayout relativeLayout18 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Fire_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout18, "layout_Fire_container");
            relativeLayout18.setSelected(true);
            TextView textView18 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_fire);
            Intrinsics.checkExpressionValueIsNotNull(textView18, "tv_fire");
            textView18.setSelected(true);
            this.lossType = "Fire";
        } else if (i2 == 3) {
            this.lossTypeItemPosition = 3;
            RelativeLayout relativeLayout19 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_allLossType_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout19, "layout_allLossType_container");
            relativeLayout19.setSelected(false);
            RelativeLayout relativeLayout20 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Collision_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout20, "layout_Collision_container");
            relativeLayout20.setSelected(false);
            RelativeLayout relativeLayout21 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Fire_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout21, "layout_Fire_container");
            relativeLayout21.setSelected(false);
            RelativeLayout relativeLayout22 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Water_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout22, "layout_Water_container");
            relativeLayout22.setSelected(false);
            RelativeLayout relativeLayout23 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Other_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout23, "layout_Other_container");
            relativeLayout23.setSelected(false);
            TextView textView19 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_allLossType);
            Intrinsics.checkExpressionValueIsNotNull(textView19, "tv_allLossType");
            textView19.setSelected(false);
            TextView textView20 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_collision);
            Intrinsics.checkExpressionValueIsNotNull(textView20, "tv_collision");
            textView20.setSelected(false);
            TextView textView21 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_fire);
            Intrinsics.checkExpressionValueIsNotNull(textView21, "tv_fire");
            textView21.setSelected(false);
            TextView textView22 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_water);
            Intrinsics.checkExpressionValueIsNotNull(textView22, "tv_water");
            textView22.setSelected(false);
            TextView textView23 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_other);
            Intrinsics.checkExpressionValueIsNotNull(textView23, "tv_other");
            textView23.setSelected(false);
            RelativeLayout relativeLayout24 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Theft_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout24, "layout_Theft_container");
            relativeLayout24.setSelected(true);
            TextView textView24 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_theft);
            Intrinsics.checkExpressionValueIsNotNull(textView24, "tv_theft");
            textView24.setSelected(true);
            this.lossType = "Theft";
        } else if (i2 == 4) {
            this.lossTypeItemPosition = 4;
            RelativeLayout relativeLayout25 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_allLossType_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout25, "layout_allLossType_container");
            relativeLayout25.setSelected(false);
            RelativeLayout relativeLayout26 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Collision_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout26, "layout_Collision_container");
            relativeLayout26.setSelected(false);
            RelativeLayout relativeLayout27 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Fire_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout27, "layout_Fire_container");
            relativeLayout27.setSelected(false);
            RelativeLayout relativeLayout28 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Theft_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout28, "layout_Theft_container");
            relativeLayout28.setSelected(false);
            RelativeLayout relativeLayout29 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Other_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout29, "layout_Other_container");
            relativeLayout29.setSelected(false);
            TextView textView25 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_allLossType);
            Intrinsics.checkExpressionValueIsNotNull(textView25, "tv_allLossType");
            textView25.setSelected(false);
            TextView textView26 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_collision);
            Intrinsics.checkExpressionValueIsNotNull(textView26, "tv_collision");
            textView26.setSelected(false);
            TextView textView27 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_fire);
            Intrinsics.checkExpressionValueIsNotNull(textView27, "tv_fire");
            textView27.setSelected(false);
            TextView textView28 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_theft);
            Intrinsics.checkExpressionValueIsNotNull(textView28, "tv_theft");
            textView28.setSelected(false);
            TextView textView29 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_other);
            Intrinsics.checkExpressionValueIsNotNull(textView29, "tv_other");
            textView29.setSelected(false);
            RelativeLayout relativeLayout30 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Water_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout30, "layout_Water_container");
            relativeLayout30.setSelected(true);
            TextView textView30 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_water);
            Intrinsics.checkExpressionValueIsNotNull(textView30, "tv_water");
            textView30.setSelected(true);
            this.lossType = "Water";
        } else if (i2 == 5) {
            this.lossTypeItemPosition = 5;
            RelativeLayout relativeLayout31 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_allLossType_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout31, "layout_allLossType_container");
            relativeLayout31.setSelected(false);
            RelativeLayout relativeLayout32 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Collision_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout32, "layout_Collision_container");
            relativeLayout32.setSelected(false);
            RelativeLayout relativeLayout33 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Fire_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout33, "layout_Fire_container");
            relativeLayout33.setSelected(false);
            RelativeLayout relativeLayout34 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Theft_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout34, "layout_Theft_container");
            relativeLayout34.setSelected(false);
            RelativeLayout relativeLayout35 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Water_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout35, "layout_Water_container");
            relativeLayout35.setSelected(false);
            TextView textView31 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_allLossType);
            Intrinsics.checkExpressionValueIsNotNull(textView31, "tv_allLossType");
            textView31.setSelected(false);
            TextView textView32 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_collision);
            Intrinsics.checkExpressionValueIsNotNull(textView32, "tv_collision");
            textView32.setSelected(false);
            TextView textView33 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_fire);
            Intrinsics.checkExpressionValueIsNotNull(textView33, "tv_fire");
            textView33.setSelected(false);
            TextView textView34 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_theft);
            Intrinsics.checkExpressionValueIsNotNull(textView34, "tv_theft");
            textView34.setSelected(false);
            TextView textView35 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_water);
            Intrinsics.checkExpressionValueIsNotNull(textView35, "tv_water");
            textView35.setSelected(false);
            RelativeLayout relativeLayout36 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.layout_Other_container);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout36, "layout_Other_container");
            relativeLayout36.setSelected(true);
            TextView textView36 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_other);
            Intrinsics.checkExpressionValueIsNotNull(textView36, "tv_other");
            textView36.setSelected(true);
            this.lossType = "Other";
        }
        if (i2 == 0) {
            TextView textView37 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_LossTypeCount);
            Intrinsics.checkExpressionValueIsNotNull(textView37, "tv_LossTypeCount");
            textView37.setVisibility(8);
            return;
        }
        TextView textView38 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_LossTypeCount);
        Intrinsics.checkExpressionValueIsNotNull(textView38, "tv_LossTypeCount");
        textView38.setVisibility(0);
    }
}
