package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchMoreFilterAdapter;
import com.iaai.android.bdt.model.fastSearchFilter2.FacetXX;
import com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray;
import com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingGroup;
import com.iaai.android.bdt.utils.BDTUtils;
import com.iaai.android.bdt.utils.Constants_MVVM;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u0012\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u0018\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u000eH\u0016J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0016H\u0002J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u000eH\u0002J \u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0007j\b\u0012\u0004\u0012\u00020\u0013`\tX\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchMoreFilterActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchMoreFilterAdapter$OnItemClickListener;", "()V", "facetType", "", "facetXX", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FacetXX;", "Lkotlin/collections/ArrayList;", "fastSearchMoreFilterAdapter", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchMoreFilterAdapter;", "hintText", "isFacetSelected", "", "parentPosition", "", "tabPosition", "tempSearchMappingArray", "Lcom/iaai/android/bdt/model/fastSearchFilter2/SearchMappingArray;", "checkPreviouslySelected", "createTempCopy", "", "getIntentDataAndUpdateUI", "init", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "facetxx", "isSingleSelect", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "resetUIOnBackPressed", "setSelectFilterEnabled", "isEnabled", "updateListOnSelectItem", "groupPos", "childPos", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchMoreFilterActivity.kt */
public final class FastSearchMoreFilterActivity extends AppCompatActivity implements FastSearchMoreFilterAdapter.OnItemClickListener {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public String facetType = "checkbox";
    /* access modifiers changed from: private */
    public ArrayList<FacetXX> facetXX;
    /* access modifiers changed from: private */
    public FastSearchMoreFilterAdapter fastSearchMoreFilterAdapter;
    private String hintText;
    private boolean isFacetSelected;
    /* access modifiers changed from: private */
    public int parentPosition;
    private int tabPosition;
    private ArrayList<SearchMappingArray> tempSearchMappingArray = new ArrayList<>();

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

    public static final /* synthetic */ ArrayList access$getFacetXX$p(FastSearchMoreFilterActivity fastSearchMoreFilterActivity) {
        ArrayList<FacetXX> arrayList = fastSearchMoreFilterActivity.facetXX;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facetXX");
        }
        return arrayList;
    }

    public static final /* synthetic */ FastSearchMoreFilterAdapter access$getFastSearchMoreFilterAdapter$p(FastSearchMoreFilterActivity fastSearchMoreFilterActivity) {
        FastSearchMoreFilterAdapter fastSearchMoreFilterAdapter2 = fastSearchMoreFilterActivity.fastSearchMoreFilterAdapter;
        if (fastSearchMoreFilterAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchMoreFilterAdapter");
        }
        return fastSearchMoreFilterAdapter2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_fast_search_filter_more_than_ten_refiner);
        init();
        getIntentDataAndUpdateUI();
        this.isFacetSelected = checkPreviouslySelected();
        createTempCopy();
    }

    private final void init() {
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2723R.C2726id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            Intrinsics.throwNpe();
        }
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 == null) {
            Intrinsics.throwNpe();
        }
        supportActionBar2.setDisplayShowTitleEnabled(true);
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(C2723R.C2726id.toolbar);
        Intrinsics.checkExpressionValueIsNotNull(toolbar, "toolbar");
        Intent intent = getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent, "intent");
        Bundle extras = intent.getExtras();
        String str = null;
        toolbar.setTitle((CharSequence) extras != null ? extras.getString(Constants_MVVM.EXTRA_FACETS_TITLE) : null);
        Intent intent2 = getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent2, "intent");
        Bundle extras2 = intent2.getExtras();
        if (extras2 != null) {
            str = extras2.getString(Constants_MVVM.EXTRA_FACETS_TITLE);
        }
        this.hintText = str;
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2723R.C2726id.toolbar));
        setSelectFilterEnabled(false);
    }

    private final void getIntentDataAndUpdateUI() {
        String str;
        Intent intent = getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent, "intent");
        Bundle extras = intent.getExtras();
        String str2 = null;
        ArrayList<FacetXX> parcelableArrayList = extras != null ? extras.getParcelableArrayList(Constants_MVVM.EXTRA_FACETS_ARRAY) : null;
        if (parcelableArrayList != null) {
            this.facetXX = parcelableArrayList;
            Intent intent2 = getIntent();
            Intrinsics.checkExpressionValueIsNotNull(intent2, "intent");
            Bundle extras2 = intent2.getExtras();
            this.parentPosition = extras2 != null ? extras2.getInt(Constants_MVVM.EXTRA_FACETS_PARENT_POSITION) : 0;
            Intent intent3 = getIntent();
            Intrinsics.checkExpressionValueIsNotNull(intent3, "intent");
            Bundle extras3 = intent3.getExtras();
            this.tabPosition = extras3 != null ? extras3.getInt(Constants_MVVM.EXTRA_FACETS_TAB_POSITION) : 0;
            Intent intent4 = getIntent();
            Intrinsics.checkExpressionValueIsNotNull(intent4, "intent");
            Bundle extras4 = intent4.getExtras();
            if (extras4 == null || (str = extras4.getString(Constants_MVVM.EXTRA_FACETS_TYPE)) == null) {
                str = "checkbox";
            }
            this.facetType = str;
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvFilterDataList);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvFilterDataList");
            Context context = this;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.fastSearchMoreFilterAdapter = new FastSearchMoreFilterAdapter(context);
            FastSearchMoreFilterAdapter fastSearchMoreFilterAdapter2 = this.fastSearchMoreFilterAdapter;
            if (fastSearchMoreFilterAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fastSearchMoreFilterAdapter");
            }
            ArrayList<FacetXX> arrayList = this.facetXX;
            if (arrayList == null) {
                Intrinsics.throwUninitializedPropertyAccessException("facetXX");
            }
            List list = arrayList;
            Intent intent5 = getIntent();
            Intrinsics.checkExpressionValueIsNotNull(intent5, "intent");
            Bundle extras5 = intent5.getExtras();
            if (extras5 != null) {
                str2 = extras5.getString(Constants_MVVM.EXTRA_FACETS_TYPE);
            }
            fastSearchMoreFilterAdapter2.facetXXData(list, str2, this.parentPosition);
            FastSearchMoreFilterAdapter fastSearchMoreFilterAdapter3 = this.fastSearchMoreFilterAdapter;
            if (fastSearchMoreFilterAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fastSearchMoreFilterAdapter");
            }
            fastSearchMoreFilterAdapter3.setClickListener(this);
            RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvFilterDataList);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvFilterDataList");
            FastSearchMoreFilterAdapter fastSearchMoreFilterAdapter4 = this.fastSearchMoreFilterAdapter;
            if (fastSearchMoreFilterAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fastSearchMoreFilterAdapter");
            }
            recyclerView2.setAdapter(fastSearchMoreFilterAdapter4);
            ((LinearLayout) _$_findCachedViewById(C2723R.C2726id.llApplyFilterContainer)).setOnClickListener(new FastSearchMoreFilterActivity$getIntentDataAndUpdateUI$1(this));
            EditText editText = (EditText) _$_findCachedViewById(C2723R.C2726id.etSubFilterSearch);
            Intrinsics.checkExpressionValueIsNotNull(editText, "etSubFilterSearch");
            editText.setHint(getResources().getString(C2723R.string.bdt_lbl_sub_filter_search_hint, new Object[]{this.hintText}));
            ((EditText) _$_findCachedViewById(C2723R.C2726id.etSubFilterSearch)).setOnEditorActionListener(new FastSearchMoreFilterActivity$getIntentDataAndUpdateUI$2(this));
            ((EditText) _$_findCachedViewById(C2723R.C2726id.etSubFilterSearch)).addTextChangedListener(new FastSearchMoreFilterActivity$getIntentDataAndUpdateUI$3(this));
            ((ImageView) _$_findCachedViewById(C2723R.C2726id.ivCancel)).setOnClickListener(new FastSearchMoreFilterActivity$getIntentDataAndUpdateUI$4(this));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.iaai.android.bdt.model.fastSearchFilter2.FacetXX> /* = java.util.ArrayList<com.iaai.android.bdt.model.fastSearchFilter2.FacetXX> */");
    }

    private final boolean checkPreviouslySelected() {
        if (Intrinsics.areEqual((Object) this.facetType, (Object) "checkbox")) {
            ArrayList<FacetXX> arrayList = this.facetXX;
            if (arrayList == null) {
                Intrinsics.throwUninitializedPropertyAccessException("facetXX");
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ArrayList<FacetXX> arrayList2 = this.facetXX;
                if (arrayList2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("facetXX");
                }
                FacetXX facetXX2 = arrayList2.get(i);
                Intrinsics.checkExpressionValueIsNotNull(facetXX2, "facetXX[index]");
                if (facetXX2.isSelected()) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void setSelectFilterEnabled(boolean z) {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llApplyFilterContainer);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llApplyFilterContainer");
        linearLayout.setSelected(z);
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llApplyFilterContainer);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "llApplyFilterContainer");
        linearLayout2.setEnabled(z);
    }

    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        if (menuItem.getItemId() == 16908332) {
            resetUIOnBackPressed();
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private final void resetUIOnBackPressed() {
        BDTUtils.INSTANCE.getSearchMappingArray().clear();
        BDTUtils.INSTANCE.getSearchMappingArray().addAll(this.tempSearchMappingArray);
        BDTUtils.INSTANCE.getFilterData(this.tabPosition);
    }

    private final void updateListOnSelectItem(int i, int i2, boolean z) {
        List list = BDTUtils.INSTANCE.getExpandableListDetail().get(BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(i));
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        if (z) {
            if (list != null) {
                int i4 = 0;
                for (Object next : list) {
                    int i5 = i4 + 1;
                    if (i4 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    FacetXX facetXX2 = (FacetXX) next;
                    facetXX2.setSelected(i4 == i2);
                    arrayList.add(facetXX2);
                    i4 = i5;
                }
            }
        } else if (list != null) {
            for (Object next2 : list) {
                int i6 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                FacetXX facetXX3 = (FacetXX) next2;
                if (i3 == i2) {
                    facetXX3.setSelected(!facetXX3.isSelected());
                }
                arrayList.add(facetXX3);
                i3 = i6;
            }
        }
        SearchMappingGroup searchMappingGroup = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(i);
        Intrinsics.checkExpressionValueIsNotNull(searchMappingGroup, "BDTUtils.searchMappingAr…osition].groups[groupPos]");
        BDTUtils.INSTANCE.getExpandableListDetail().put(searchMappingGroup, arrayList);
    }

    private final void createTempCopy() {
        this.tempSearchMappingArray.clear();
        Iterator it = BDTUtils.INSTANCE.getSearchMappingArray().iterator();
        while (it.hasNext()) {
            SearchMappingArray searchMappingArray = (SearchMappingArray) it.next();
            ArrayList arrayList = new ArrayList();
            for (SearchMappingGroup searchMappingGroup : searchMappingArray.getGroups()) {
                ArrayList arrayList2 = new ArrayList();
                for (FacetXX facetXX2 : searchMappingGroup.getListFacet()) {
                    arrayList2.add(new FacetXX(facetXX2.getCount(), facetXX2.getValue(), facetXX2.getRefinerValue(), facetXX2.isSelected()));
                }
                Iterator it2 = it;
                SearchMappingGroup searchMappingGroup2 = r6;
                SearchMappingGroup searchMappingGroup3 = new SearchMappingGroup(searchMappingGroup.getDisplayname(), searchMappingGroup.getGroup(), searchMappingGroup.getMultiselect(), searchMappingGroup.getFiltertype(), searchMappingGroup.getMinvalue(), searchMappingGroup.getMaxvalue(), searchMappingGroup.getSortorder(), arrayList2, searchMappingGroup.isEnabled(), searchMappingGroup.getCustom());
                arrayList.add(searchMappingGroup2);
                it = it2;
            }
            Iterator it3 = it;
            this.tempSearchMappingArray.add(new SearchMappingArray(searchMappingArray.getFilterName(), arrayList));
            it = it3;
        }
    }

    public void onItemClick(@NotNull FacetXX facetXX2, boolean z) {
        int i;
        Intrinsics.checkParameterIsNotNull(facetXX2, "facetxx");
        List list = BDTUtils.INSTANCE.getExpandableListDetail().get(BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(this.parentPosition));
        if (list != null) {
            i = 0;
            int i2 = 0;
            for (Object next : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (Intrinsics.areEqual((Object) ((FacetXX) next).getValue(), (Object) facetXX2.getValue())) {
                    i = i2;
                }
                i2 = i3;
            }
        } else {
            i = 0;
        }
        updateListOnSelectItem(this.parentPosition, i, z);
        setSelectFilterEnabled(false);
        List<FacetXX> list2 = BDTUtils.INSTANCE.getExpandableListDetail().get(BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(this.parentPosition));
        if (list2 != null) {
            for (FacetXX isSelected : list2) {
                if (isSelected.isSelected()) {
                    setSelectFilterEnabled(true);
                }
            }
        }
        if (this.isFacetSelected) {
            setSelectFilterEnabled(true);
        }
    }

    public void onBackPressed() {
        resetUIOnBackPressed();
        super.onBackPressed();
    }
}
