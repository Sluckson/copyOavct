package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.feature.findVehiclePage.filter.MakeModelFilterAdapter;
import com.iaai.android.bdt.model.filter.FilterData;
import com.iaai.android.bdt.model.filter.FilterSubValues;
import com.iaai.android.bdt.model.filter.FilterValues;
import com.iaai.android.bdt.model.filter.MakeModelValues;
import com.iaai.android.bdt.utils.AppPreferences;
import com.iaai.android.bdt.utils.Constants_MVVM;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0006\u0010\u001e\u001a\u00020\u001cJ\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020\u0014H\u0002J\b\u0010$\u001a\u00020\u0014H\u0002J\b\u0010%\u001a\u00020\u0014H\u0002J\b\u0010&\u001a\u00020\u0014H\u0002J\u0012\u0010'\u001a\u00020\u00142\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\u0018\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u001cH\u0016J\b\u0010-\u001a\u00020\u0014H\u0002J\u0018\u0010.\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u0019H\u0016J\u0010\u00100\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\u0019H\u0002J\u0018\u00101\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u0019H\u0016J\u0010\u00102\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\u0019H\u0002J\b\u00103\u001a\u00020\u0014H\u0002J\u0010\u00104\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u0017H\u0002J\b\u00106\u001a\u00020\u0014H\u0016J\b\u00107\u001a\u00020\u0014H\u0002J\b\u00108\u001a\u00020\u0014H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\b0\nj\b\u0012\u0004\u0012\u00020\b`\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\b0\nj\b\u0012\u0004\u0012\u00020\b`\u000bX\u000e¢\u0006\u0002\n\u0000¨\u00069"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/filter/MakeModelFilterActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "Lcom/iaai/android/bdt/feature/findVehiclePage/filter/MakeModelFilterAdapter$OnItemClickListener;", "()V", "filterData", "Lcom/iaai/android/bdt/model/filter/FilterData;", "filterMakeModelValues", "", "Lcom/iaai/android/bdt/model/filter/MakeModelValues;", "lastSelectedModel", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLastSelectedModel", "()Ljava/util/ArrayList;", "setLastSelectedModel", "(Ljava/util/ArrayList;)V", "makeModelFilterAdapter", "Lcom/iaai/android/bdt/feature/findVehiclePage/filter/MakeModelFilterAdapter;", "selectedFilterList", "clearSearch", "", "closeMakeModelFilter", "getIsModelLastSelected", "", "modelDisplaytext", "", "makeDisplay", "getLastSelectedModelCount", "", "getMakeSelectedCount", "getRecentlyUsedCount", "getSearchInfo", "p0", "Landroid/text/SpannableStringBuilder;", "getSelectedMakeModelsCount", "hideSoftKeyboard", "inlineSearch", "keywordSearch", "onClickSelectFilter", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "selectedFilter", "position", "populateMakeModelData", "removeAllMakeSelectedFilter", "allMakeModel", "removeMakeModelFromLastSelected", "removeSelectedFilter", "removeSelectedMakeModelFilter", "setFilterCount", "setSelectFilterEnabled", "isEnabled", "showErrorMsg", "updateFilterListContent", "updateRecentlyUsedList", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: MakeModelFilterActivity.kt */
public final class MakeModelFilterActivity extends BaseActivity implements MakeModelFilterAdapter.OnItemClickListener {
    private HashMap _$_findViewCache;
    private FilterData filterData;
    /* access modifiers changed from: private */
    public List<MakeModelValues> filterMakeModelValues = new ArrayList();
    @NotNull
    private ArrayList<MakeModelValues> lastSelectedModel = new ArrayList<>();
    /* access modifiers changed from: private */
    public MakeModelFilterAdapter makeModelFilterAdapter;
    /* access modifiers changed from: private */
    public ArrayList<MakeModelValues> selectedFilterList = new ArrayList<>();

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

    public static final /* synthetic */ MakeModelFilterAdapter access$getMakeModelFilterAdapter$p(MakeModelFilterActivity makeModelFilterActivity) {
        MakeModelFilterAdapter makeModelFilterAdapter2 = makeModelFilterActivity.makeModelFilterAdapter;
        if (makeModelFilterAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("makeModelFilterAdapter");
        }
        return makeModelFilterAdapter2;
    }

    @NotNull
    public final ArrayList<MakeModelValues> getLastSelectedModel() {
        return this.lastSelectedModel;
    }

    public final void setLastSelectedModel(@NotNull ArrayList<MakeModelValues> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.lastSelectedModel = arrayList;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        List<MakeModelValues> list;
        ArrayList<MakeModelValues> arrayList;
        String str;
        Bundle extras;
        Bundle extras2;
        ArrayList parcelableArrayList;
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_make_model_filter);
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2723R.C2726id.tbMakeModelFilter));
        Context applicationContext = getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
        this.makeModelFilterAdapter = new MakeModelFilterAdapter(applicationContext);
        this.filterData = (FilterData) new Gson().fromJson(new AppPreferences(this).getValueString(Constants_MVVM.EXTRA_MAKE_MODEL_FILTER_DATA), FilterData.class);
        Intent intent = getIntent();
        if (intent == null || (extras2 = intent.getExtras()) == null || (parcelableArrayList = extras2.getParcelableArrayList(Constants_MVVM.EXTRA_RECENTALY_USED_MAKE_MODEL_FILTER_DATA)) == null) {
            list = new ArrayList<>();
        } else {
            list = parcelableArrayList;
        }
        this.filterMakeModelValues = list;
        Intent intent2 = getIntent();
        if (intent2 == null || (extras = intent2.getExtras()) == null || (arrayList = extras.getParcelableArrayList(Constants_MVVM.EXTRA_LAST_SELECTED_MAKE_MODEL)) == null) {
            arrayList = new ArrayList<>();
        }
        this.lastSelectedModel = arrayList;
        Intent intent3 = getIntent();
        if (intent3 == null || (str = intent3.getStringExtra(Constants_MVVM.EXTRA_DISPLAY_FILTER_TITLE)) == null) {
            str = "";
        }
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tbHeader)).setText(str);
        ((EditText) _$_findCachedViewById(C2723R.C2726id.etMakeModelFilterSearch)).setHint(getResources().getString(C2723R.string.bdt_lbl_sub_filter_search_hint, new Object[]{str}));
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvMakeModelFilter)).addOnScrollListener(new MakeModelFilterActivity$onCreate$1(this));
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.fabMakeModel)).setOnClickListener(new MakeModelFilterActivity$onCreate$2(this));
        setSelectFilterEnabled(false);
        updateRecentlyUsedList();
        setFilterCount();
        onClickSelectFilter();
        populateMakeModelData();
        keywordSearch();
        clearSearch();
        updateFilterListContent();
        inlineSearch();
        closeMakeModelFilter();
    }

    private final void updateRecentlyUsedList() {
        String displayText;
        if (this.lastSelectedModel.size() > 0) {
            for (MakeModelValues next : this.filterMakeModelValues) {
                String displayText2 = next.getDisplayText();
                String str = "";
                if (displayText2 == null) {
                    displayText2 = str;
                }
                MakeModelValues makeInfo = next.getMakeInfo();
                if (!(makeInfo == null || (displayText = makeInfo.getDisplayText()) == null)) {
                    str = displayText;
                }
                next.setSelected(getIsModelLastSelected(displayText2, str));
            }
            return;
        }
        for (MakeModelValues selected : this.filterMakeModelValues) {
            selected.setSelected(false);
        }
    }

    public final int getRecentlyUsedCount() {
        if ((!this.filterMakeModelValues.isEmpty()) && StringsKt.equals(this.filterMakeModelValues.get(0).getDisplayText(), "Recently used filters", true)) {
            int i = 0;
            for (MakeModelValues makeModelValues : this.filterMakeModelValues) {
                if (i != 0 && this.filterMakeModelValues.get(i).isMake()) {
                    return i;
                }
                i++;
            }
        }
        return 0;
    }

    public final boolean getIsModelLastSelected(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "modelDisplaytext");
        Intrinsics.checkParameterIsNotNull(str2, "makeDisplay");
        Iterator<MakeModelValues> it = this.lastSelectedModel.iterator();
        while (it.hasNext()) {
            MakeModelValues next = it.next();
            if (StringsKt.equals(next.getDisplayText(), str, true)) {
                MakeModelValues makeInfo = next.getMakeInfo();
                if (StringsKt.equals(makeInfo != null ? makeInfo.getDisplayText() : null, str2, true)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void onClickSelectFilter() {
        ((LinearLayout) _$_findCachedViewById(C2723R.C2726id.ll_applyFilter_container)).setOnClickListener(new MakeModelFilterActivity$onClickSelectFilter$1(this));
    }

    private final void setFilterCount() {
        if (getSelectedMakeModelsCount() > 0 || getLastSelectedModelCount() > 0) {
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvSelectedFilterCount);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tvSelectedFilterCount");
            textView.setVisibility(0);
            String valueOf = String.valueOf(getSelectedMakeModelsCount() + getLastSelectedModelCount());
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvSelectedFilterCount);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "tvSelectedFilterCount");
            textView2.setText(getString(C2723R.string.lbl_bdt_filter_make_model_title_selected, new Object[]{valueOf}));
            return;
        }
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvSelectedFilterCount);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "tvSelectedFilterCount");
        textView3.setVisibility(8);
    }

    private final int getLastSelectedModelCount() {
        Collection arrayList = new ArrayList();
        for (Object next : this.lastSelectedModel) {
            boolean z = true;
            if (!((MakeModelValues) next).isSelected()) {
                z = false;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        return ((List) arrayList).size();
    }

    private final int getSelectedMakeModelsCount() {
        Collection arrayList = new ArrayList();
        for (Object next : this.selectedFilterList) {
            boolean z = true;
            if (!((MakeModelValues) next).isSelected()) {
                z = false;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        return ((List) arrayList).size();
    }

    private final void setSelectFilterEnabled(boolean z) {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.ll_applyFilter_container);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "ll_applyFilter_container");
        linearLayout.setSelected(z);
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.ll_applyFilter_container);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "ll_applyFilter_container");
        linearLayout2.setEnabled(z);
    }

    private final void populateMakeModelData() {
        List<FilterValues> filterValues;
        List<FilterSubValues> filterSubValues;
        FilterData filterData2 = this.filterData;
        if (filterData2 != null && (filterValues = filterData2.getFilterValues()) != null) {
            for (FilterValues filterValues2 : filterValues) {
                MakeModelValues makeModelValues = new MakeModelValues(filterValues2.getDisplayText(), filterValues2.getValuesId(), true, (MakeModelValues) null, filterValues2.getCount(), false);
                this.filterMakeModelValues.add(makeModelValues);
                Collection filterSubValues2 = filterValues2.getFilterSubValues();
                if (!(filterSubValues2 == null || filterSubValues2.isEmpty()) && (filterSubValues = filterValues2.getFilterSubValues()) != null) {
                    for (FilterSubValues filterSubValues3 : filterSubValues) {
                        String displayText = filterSubValues3.getDisplayText();
                        String str = "";
                        if (displayText == null) {
                            displayText = str;
                        }
                        String displayText2 = filterValues2.getDisplayText();
                        if (displayText2 != null) {
                            str = displayText2;
                        }
                        this.filterMakeModelValues.add(new MakeModelValues(filterSubValues3.getDisplayText(), filterSubValues3.getValuesId(), false, makeModelValues, filterSubValues3.getCount(), getIsModelLastSelected(displayText, str)));
                    }
                }
            }
        }
    }

    private final void closeMakeModelFilter() {
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.ivBack)).setOnClickListener(new MakeModelFilterActivity$closeMakeModelFilter$1(this));
    }

    private final void clearSearch() {
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.ivMakeModelCancel)).setOnClickListener(new MakeModelFilterActivity$clearSearch$1(this));
    }

    private final void keywordSearch() {
        ((EditText) _$_findCachedViewById(C2723R.C2726id.etMakeModelFilterSearch)).setOnEditorActionListener(new MakeModelFilterActivity$keywordSearch$1(this));
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

    private final void inlineSearch() {
        ((EditText) _$_findCachedViewById(C2723R.C2726id.etMakeModelFilterSearch)).addTextChangedListener(new MakeModelFilterActivity$inlineSearch$1(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x002c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void getSearchInfo(android.text.SpannableStringBuilder r8) {
        /*
            r7 = this;
            kotlin.text.Regex r0 = new kotlin.text.Regex
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "\\b"
            r1.append(r2)
            r1.append(r8)
            java.lang.String r8 = "[a-zA-Z0-9]*\\b"
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            kotlin.text.RegexOption r1 = kotlin.text.RegexOption.IGNORE_CASE
            r0.<init>((java.lang.String) r8, (kotlin.text.RegexOption) r1)
            java.util.List<com.iaai.android.bdt.model.filter.MakeModelValues> r8 = r7.filterMakeModelValues
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r8 = r8.iterator()
        L_0x002c:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L_0x0067
            java.lang.Object r2 = r8.next()
            r3 = r2
            com.iaai.android.bdt.model.filter.MakeModelValues r3 = (com.iaai.android.bdt.model.filter.MakeModelValues) r3
            java.lang.String r4 = r3.getDisplayText()
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x0042
            goto L_0x0043
        L_0x0042:
            r4 = r5
        L_0x0043:
            boolean r4 = com.iaai.android.bdt.extensions.Regex_ExtensionKt.filterSearch(r0, r4)
            if (r4 != 0) goto L_0x0060
            com.iaai.android.bdt.model.filter.MakeModelValues r3 = r3.getMakeInfo()
            if (r3 == 0) goto L_0x0056
            java.lang.String r3 = r3.getDisplayText()
            if (r3 == 0) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r3 = r5
        L_0x0057:
            boolean r3 = com.iaai.android.bdt.extensions.Regex_ExtensionKt.filterSearch(r0, r3)
            if (r3 == 0) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r3 = 0
            goto L_0x0061
        L_0x0060:
            r3 = 1
        L_0x0061:
            if (r3 == 0) goto L_0x002c
            r1.add(r2)
            goto L_0x002c
        L_0x0067:
            java.util.List r1 = (java.util.List) r1
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.List r0 = kotlin.collections.CollectionsKt.reversed(r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0086:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x00b2
            java.lang.Object r3 = r0.next()
            r4 = r3
            com.iaai.android.bdt.model.filter.MakeModelValues r4 = (com.iaai.android.bdt.model.filter.MakeModelValues) r4
            kotlin.Pair r5 = new kotlin.Pair
            java.lang.String r6 = r4.getDisplayText()
            com.iaai.android.bdt.model.filter.MakeModelValues r4 = r4.getMakeInfo()
            if (r4 == 0) goto L_0x00a4
            java.lang.String r4 = r4.getDisplayText()
            goto L_0x00a5
        L_0x00a4:
            r4 = 0
        L_0x00a5:
            r5.<init>(r6, r4)
            boolean r4 = r1.add(r5)
            if (r4 == 0) goto L_0x0086
            r2.add(r3)
            goto L_0x0086
        L_0x00b2:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.List r0 = kotlin.collections.CollectionsKt.reversed(r2)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x00c0:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00e7
            java.lang.Object r1 = r0.next()
            com.iaai.android.bdt.model.filter.MakeModelValues r1 = (com.iaai.android.bdt.model.filter.MakeModelValues) r1
            com.iaai.android.bdt.model.filter.MakeModelValues r2 = r1.getMakeInfo()
            if (r2 == 0) goto L_0x00e3
            com.iaai.android.bdt.model.filter.MakeModelValues r2 = r1.getMakeInfo()
            boolean r2 = r8.contains(r2)
            if (r2 != 0) goto L_0x00e3
            com.iaai.android.bdt.model.filter.MakeModelValues r2 = r1.getMakeInfo()
            r8.add(r2)
        L_0x00e3:
            r8.add(r1)
            goto L_0x00c0
        L_0x00e7:
            com.iaai.android.bdt.feature.findVehiclePage.filter.MakeModelFilterAdapter r0 = r7.makeModelFilterAdapter
            java.lang.String r1 = "makeModelFilterAdapter"
            if (r0 != 0) goto L_0x00f0
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x00f0:
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.List r8 = kotlin.collections.CollectionsKt.toMutableList(r8)
            r0.setFilterData(r8)
            com.iaai.android.bdt.feature.findVehiclePage.filter.MakeModelFilterAdapter r8 = r7.makeModelFilterAdapter
            if (r8 != 0) goto L_0x0100
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0100:
            r8.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.findVehiclePage.filter.MakeModelFilterActivity.getSearchInfo(android.text.SpannableStringBuilder):void");
    }

    private final void updateFilterListContent() {
        MakeModelFilterAdapter makeModelFilterAdapter2 = this.makeModelFilterAdapter;
        if (makeModelFilterAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("makeModelFilterAdapter");
        }
        makeModelFilterAdapter2.setFilterData(this.filterMakeModelValues);
        MakeModelFilterAdapter makeModelFilterAdapter3 = this.makeModelFilterAdapter;
        if (makeModelFilterAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("makeModelFilterAdapter");
        }
        makeModelFilterAdapter3.setRecentlyCount(getRecentlyUsedCount());
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvMakeModelFilter);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvMakeModelFilter");
        MakeModelFilterAdapter makeModelFilterAdapter4 = this.makeModelFilterAdapter;
        if (makeModelFilterAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("makeModelFilterAdapter");
        }
        recyclerView.setAdapter(makeModelFilterAdapter4);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvMakeModelFilter);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvMakeModelFilter");
        recyclerView2.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        MakeModelFilterAdapter makeModelFilterAdapter5 = this.makeModelFilterAdapter;
        if (makeModelFilterAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("makeModelFilterAdapter");
        }
        makeModelFilterAdapter5.setClickListener(this);
    }

    public void onItemClick(@NotNull MakeModelValues makeModelValues, int i) {
        Intrinsics.checkParameterIsNotNull(makeModelValues, "selectedFilter");
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.ll_applyFilter_container);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "ll_applyFilter_container");
        if (!linearLayout.isEnabled()) {
            setSelectFilterEnabled(true);
        }
        this.selectedFilterList.add(makeModelValues);
        setFilterCount();
    }

    public void removeSelectedFilter(@NotNull MakeModelValues makeModelValues, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(makeModelValues, "selectedFilter");
        Intrinsics.checkParameterIsNotNull(str, "allMakeModel");
        if (str.length() == 0) {
            this.selectedFilterList.remove(makeModelValues);
            String displayText = makeModelValues.getDisplayText();
            if (displayText == null) {
                displayText = "";
            }
            removeMakeModelFromLastSelected(displayText);
        } else {
            removeSelectedMakeModelFilter(str);
        }
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.ll_applyFilter_container);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "ll_applyFilter_container");
        if (!linearLayout.isEnabled()) {
            setSelectFilterEnabled(true);
        }
        setFilterCount();
    }

    public void removeAllMakeSelectedFilter(@NotNull MakeModelValues makeModelValues, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(makeModelValues, "selectedFilter");
        Intrinsics.checkParameterIsNotNull(str, "allMakeModel");
        Iterator<MakeModelValues> it = this.selectedFilterList.iterator();
        Intrinsics.checkExpressionValueIsNotNull(it, "selectedFilterList.iterator()");
        while (it.hasNext()) {
            MakeModelValues next = it.next();
            if (StringsKt.equals(next.getDisplayText(), str, true) && next.isSelected()) {
                it.remove();
            }
        }
    }

    public void showErrorMsg() {
        Context context = this;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(View.inflate(context, C2723R.C2728layout.custom_dialog_make_model, (ViewGroup) null));
        builder.setPositiveButton((CharSequence) getString(C2723R.string.lbl_OK), (DialogInterface.OnClickListener) MakeModelFilterActivity$showErrorMsg$1.INSTANCE);
        AlertDialog create = builder.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "builder.create()");
        create.show();
    }

    private final void removeSelectedMakeModelFilter(String str) {
        Iterator<MakeModelValues> it = this.selectedFilterList.iterator();
        Intrinsics.checkExpressionValueIsNotNull(it, "selectedFilterList.iterator()");
        while (true) {
            String str2 = null;
            if (!it.hasNext()) {
                break;
            }
            MakeModelValues makeInfo = it.next().getMakeInfo();
            if (makeInfo != null) {
                str2 = makeInfo.getDisplayText();
            }
            if (StringsKt.equals(str2, str, true)) {
                it.remove();
            }
        }
        Iterator<MakeModelValues> it2 = this.lastSelectedModel.iterator();
        while (it2.hasNext()) {
            MakeModelValues next = it2.next();
            MakeModelValues makeInfo2 = next.getMakeInfo();
            if (StringsKt.equals(makeInfo2 != null ? makeInfo2.getDisplayText() : null, str, true)) {
                next.setSelected(false);
            }
        }
    }

    private final void removeMakeModelFromLastSelected(String str) {
        Iterator<MakeModelValues> it = this.lastSelectedModel.iterator();
        while (it.hasNext()) {
            MakeModelValues next = it.next();
            if (StringsKt.equals(next.getDisplayText(), str, true)) {
                next.setSelected(false);
            }
        }
    }

    public int getMakeSelectedCount() {
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        Iterator it = this.selectedFilterList.iterator();
        while (true) {
            String str = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            MakeModelValues makeInfo = ((MakeModelValues) next).getMakeInfo();
            if (makeInfo != null) {
                str = makeInfo.getDisplayText();
            }
            if (hashSet.add(str)) {
                arrayList.add(next);
            }
        }
        List list = arrayList;
        HashSet hashSet2 = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for (Object next2 : this.lastSelectedModel) {
            MakeModelValues makeInfo2 = ((MakeModelValues) next2).getMakeInfo();
            if (hashSet2.add(makeInfo2 != null ? makeInfo2.getDisplayText() : null)) {
                arrayList2.add(next2);
            }
        }
        Collection arrayList3 = new ArrayList();
        for (Object next3 : arrayList2) {
            if (((MakeModelValues) next3).isSelected()) {
                arrayList3.add(next3);
            }
        }
        return list.size() + ((List) arrayList3).size();
    }
}
