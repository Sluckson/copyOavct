package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.feature.findVehiclePage.filter.SubFilterAdapter;
import com.iaai.android.bdt.model.filter.FilterData;
import com.iaai.android.bdt.model.filter.FilterValues;
import com.iaai.android.bdt.utils.Constants_MVVM;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/filter/SubFilterActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "Lcom/iaai/android/bdt/feature/findVehiclePage/filter/SubFilterAdapter$OnItemClickListener;", "()V", "filterData", "Lcom/iaai/android/bdt/model/filter/FilterData;", "filterValues", "", "Lcom/iaai/android/bdt/model/filter/FilterValues;", "selectedRefiner", "", "subFilterAdapter", "Lcom/iaai/android/bdt/feature/findVehiclePage/filter/SubFilterAdapter;", "title", "hideSoftKeyboard", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "selectedFilter", "position", "", "updateFilterListContent", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SubFilterActivity.kt */
public final class SubFilterActivity extends BaseActivity implements SubFilterAdapter.OnItemClickListener {
    private HashMap _$_findViewCache;
    private FilterData filterData;
    /* access modifiers changed from: private */
    public List<FilterValues> filterValues = new ArrayList();
    /* access modifiers changed from: private */
    public String selectedRefiner;
    /* access modifiers changed from: private */
    public SubFilterAdapter subFilterAdapter;
    private String title;

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

    public static final /* synthetic */ String access$getSelectedRefiner$p(SubFilterActivity subFilterActivity) {
        String str = subFilterActivity.selectedRefiner;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedRefiner");
        }
        return str;
    }

    public static final /* synthetic */ SubFilterAdapter access$getSubFilterAdapter$p(SubFilterActivity subFilterActivity) {
        SubFilterAdapter subFilterAdapter2 = subFilterActivity.subFilterAdapter;
        if (subFilterAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subFilterAdapter");
        }
        return subFilterAdapter2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x002a, code lost:
        r6 = r6.getExtras();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle r6) {
        /*
            r5 = this;
            super.onCreate(r6)
            r6 = 2131492972(0x7f0c006c, float:1.860941E38)
            r5.setContentView((int) r6)
            int r6 = com.iaai.android.C2723R.C2726id.tbSubFilter
            android.view.View r6 = r5._$_findCachedViewById(r6)
            androidx.appcompat.widget.Toolbar r6 = (androidx.appcompat.widget.Toolbar) r6
            r5.setSupportActionBar(r6)
            com.iaai.android.bdt.feature.findVehiclePage.filter.SubFilterAdapter r6 = new com.iaai.android.bdt.feature.findVehiclePage.filter.SubFilterAdapter
            android.content.Context r0 = r5.getApplicationContext()
            java.lang.String r1 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            r6.<init>(r0)
            r5.subFilterAdapter = r6
            android.content.Intent r6 = r5.getIntent()
            if (r6 == 0) goto L_0x0039
            android.os.Bundle r6 = r6.getExtras()
            if (r6 == 0) goto L_0x0039
            java.lang.String r0 = "extra_sub_filter_data"
            android.os.Parcelable r6 = r6.getParcelable(r0)
            com.iaai.android.bdt.model.filter.FilterData r6 = (com.iaai.android.bdt.model.filter.FilterData) r6
            goto L_0x003a
        L_0x0039:
            r6 = 0
        L_0x003a:
            r5.filterData = r6
            android.content.Intent r6 = r5.getIntent()
            java.lang.String r0 = ""
            if (r6 == 0) goto L_0x004d
            java.lang.String r1 = "filterTitle"
            java.lang.String r6 = r6.getStringExtra(r1)
            if (r6 == 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r6 = r0
        L_0x004e:
            r5.title = r6
            android.content.Intent r6 = r5.getIntent()
            if (r6 == 0) goto L_0x005f
            java.lang.String r1 = "display_filter_title"
            java.lang.String r6 = r6.getStringExtra(r1)
            if (r6 == 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r6 = r0
        L_0x0060:
            android.content.Intent r1 = r5.getIntent()
            if (r1 == 0) goto L_0x006f
            java.lang.String r2 = "filterValue"
            java.lang.String r1 = r1.getStringExtra(r2)
            if (r1 == 0) goto L_0x006f
            r0 = r1
        L_0x006f:
            r5.selectedRefiner = r0
            int r0 = com.iaai.android.C2723R.C2726id.tbHeader
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = r6
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            int r0 = com.iaai.android.C2723R.C2726id.etSubFilterSearch
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            android.content.res.Resources r1 = r5.getResources()
            r2 = 2131820667(0x7f11007b, float:1.9274055E38)
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            r3[r4] = r6
            java.lang.String r6 = r1.getString(r2, r3)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r0.setHint(r6)
            com.iaai.android.bdt.model.filter.FilterData r6 = r5.filterData
            if (r6 == 0) goto L_0x00b0
            java.util.List r6 = r6.getFilterValues()
            if (r6 == 0) goto L_0x00b0
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.List r6 = kotlin.collections.CollectionsKt.toMutableList(r6)
            if (r6 == 0) goto L_0x00b0
            goto L_0x00b7
        L_0x00b0:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r6 = (java.util.List) r6
        L_0x00b7:
            r5.filterValues = r6
            int r6 = com.iaai.android.C2723R.C2726id.ivBack
            android.view.View r6 = r5._$_findCachedViewById(r6)
            android.widget.ImageButton r6 = (android.widget.ImageButton) r6
            com.iaai.android.bdt.feature.findVehiclePage.filter.SubFilterActivity$onCreate$1 r0 = new com.iaai.android.bdt.feature.findVehiclePage.filter.SubFilterActivity$onCreate$1
            r0.<init>(r5)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r6.setOnClickListener(r0)
            r5.updateFilterListContent()
            int r6 = com.iaai.android.C2723R.C2726id.etSubFilterSearch
            android.view.View r6 = r5._$_findCachedViewById(r6)
            android.widget.EditText r6 = (android.widget.EditText) r6
            com.iaai.android.bdt.feature.findVehiclePage.filter.SubFilterActivity$onCreate$2 r0 = new com.iaai.android.bdt.feature.findVehiclePage.filter.SubFilterActivity$onCreate$2
            r0.<init>(r5)
            android.widget.TextView$OnEditorActionListener r0 = (android.widget.TextView.OnEditorActionListener) r0
            r6.setOnEditorActionListener(r0)
            int r6 = com.iaai.android.C2723R.C2726id.etSubFilterSearch
            android.view.View r6 = r5._$_findCachedViewById(r6)
            android.widget.EditText r6 = (android.widget.EditText) r6
            com.iaai.android.bdt.feature.findVehiclePage.filter.SubFilterActivity$onCreate$3 r0 = new com.iaai.android.bdt.feature.findVehiclePage.filter.SubFilterActivity$onCreate$3
            r0.<init>(r5)
            android.text.TextWatcher r0 = (android.text.TextWatcher) r0
            r6.addTextChangedListener(r0)
            int r6 = com.iaai.android.C2723R.C2726id.ivCancel
            android.view.View r6 = r5._$_findCachedViewById(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            com.iaai.android.bdt.feature.findVehiclePage.filter.SubFilterActivity$onCreate$4 r0 = new com.iaai.android.bdt.feature.findVehiclePage.filter.SubFilterActivity$onCreate$4
            r0.<init>(r5)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r6.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.findVehiclePage.filter.SubFilterActivity.onCreate(android.os.Bundle):void");
    }

    private final void updateFilterListContent() {
        SubFilterAdapter subFilterAdapter2 = this.subFilterAdapter;
        if (subFilterAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subFilterAdapter");
        }
        List<FilterValues> list = this.filterValues;
        String str = this.selectedRefiner;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedRefiner");
        }
        subFilterAdapter2.setFilterData(list, str);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvSubFilter);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvSubFilter");
        SubFilterAdapter subFilterAdapter3 = this.subFilterAdapter;
        if (subFilterAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subFilterAdapter");
        }
        recyclerView.setAdapter(subFilterAdapter3);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvSubFilter);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvSubFilter");
        recyclerView2.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        SubFilterAdapter subFilterAdapter4 = this.subFilterAdapter;
        if (subFilterAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subFilterAdapter");
        }
        subFilterAdapter4.setClickListener(this);
    }

    /* access modifiers changed from: private */
    public final void hideSoftKeyboard() {
        if (getCurrentFocus() != null) {
            Object systemService = getApplicationContext().getSystemService("input_method");
            if (systemService != null) {
                View currentFocus = getCurrentFocus();
                Intrinsics.checkExpressionValueIsNotNull(currentFocus, "this.currentFocus");
                ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    public void onItemClick(@NotNull FilterValues filterValues2, int i) {
        Intrinsics.checkParameterIsNotNull(filterValues2, "selectedFilter");
        Intent intent = new Intent();
        intent.putExtra(Constants_MVVM.EXTRA_SELECTED_FILTER_DATA, filterValues2);
        String str = this.title;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
        }
        intent.putExtra(Constants_MVVM.EXTRA_FILTER_TITLE, str);
        intent.putExtra(Constants_MVVM.EXTRA_SELECTED_FILTER_VALUE_POS, i);
        setResult(101, intent);
        finish();
    }
}
