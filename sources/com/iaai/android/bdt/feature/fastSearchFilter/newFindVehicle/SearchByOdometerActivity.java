package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.slider.RangeSlider;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.model.fastSearchFilter2.FacetXX;
import com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingGroup;
import com.iaai.android.bdt.utils.BDTUtils;
import com.iaai.android.bdt.utils.Constants_MVVM;
import dagger.android.AndroidInjection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\u0012\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J\b\u0010 \u001a\u00020\u0014H\u0002J\u0018\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/SearchByOdometerActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "()V", "isFromEdit", "", "maxValue", "", "minValue", "odometerValue", "", "parentPosition", "", "slValue", "Lkotlin/Pair;", "getSlValue", "()Lkotlin/Pair;", "setSlValue", "(Lkotlin/Pair;)V", "tabPosition", "getIntentDataAndUpdateUI", "", "hideKeyboard", "initializeUI", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "setSelectFilterEnabled", "isEnabled", "sliderEditTextUpdate", "updateListOnSelectItemForSlider", "groupPos", "range", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SearchByOdometerActivity.kt */
public final class SearchByOdometerActivity extends BaseActivity {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public boolean isFromEdit;
    private float maxValue = 150000.0f;
    private float minValue;
    private String odometerValue = "";
    /* access modifiers changed from: private */
    public int parentPosition;
    @NotNull
    private Pair<Integer, Integer> slValue = new Pair<>(0, 0);
    private int tabPosition;

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
    public final Pair<Integer, Integer> getSlValue() {
        return this.slValue;
    }

    public final void setSlValue(@NotNull Pair<Integer, Integer> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "<set-?>");
        this.slValue = pair;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_search_by_odometer);
        initializeUI();
        getIntentDataAndUpdateUI();
    }

    private final void initializeUI() {
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
        toolbar.setTitle((CharSequence) extras != null ? extras.getString(Constants_MVVM.EXTRA_FACETS_TITLE) : null);
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2723R.C2726id.toolbar));
    }

    private final void getIntentDataAndUpdateUI() {
        String str;
        setSelectFilterEnabled(false);
        Intent intent = getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent, "intent");
        Bundle extras = intent.getExtras();
        this.parentPosition = extras != null ? extras.getInt(Constants_MVVM.EXTRA_FACETS_PARENT_POSITION) : 0;
        Intent intent2 = getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent2, "intent");
        Bundle extras2 = intent2.getExtras();
        this.tabPosition = extras2 != null ? extras2.getInt(Constants_MVVM.EXTRA_FACETS_TAB_POSITION) : 0;
        Intent intent3 = getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent3, "intent");
        Bundle extras3 = intent3.getExtras();
        if (extras3 == null || (str = extras3.getString(Constants_MVVM.EXTRA_SLIDER_VALUE)) == null) {
            str = "";
        }
        this.odometerValue = str;
        FacetXX facetXX = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(this.parentPosition).getListFacet().get(0);
        Intrinsics.checkExpressionValueIsNotNull(facetXX, "BDTUtils.searchMappingAr…entPosition].listFacet[0]");
        FacetXX facetXX2 = facetXX;
        List split$default = StringsKt.split$default((CharSequence) StringsKt.split$default((CharSequence) facetXX2.getValue(), new String[]{MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR}, false, 0, 6, (Object) null).get(0), new String[]{"-"}, false, 0, 6, (Object) null);
        Integer minvalue = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(this.parentPosition).getMinvalue();
        this.minValue = minvalue != null ? (float) minvalue.intValue() : 0.0f;
        Integer maxvalue = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(this.parentPosition).getMaxvalue();
        this.maxValue = maxvalue != null ? (float) maxvalue.intValue() : 150000.0f;
        RangeSlider rangeSlider = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
        Intrinsics.checkExpressionValueIsNotNull(rangeSlider, "continuousSlider");
        rangeSlider.setValueFrom(this.minValue);
        RangeSlider rangeSlider2 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
        Intrinsics.checkExpressionValueIsNotNull(rangeSlider2, "continuousSlider");
        rangeSlider2.setValueTo(this.maxValue);
        if (!facetXX2.isSelected() || split$default.size() <= 1) {
            Integer minvalue2 = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(this.parentPosition).getMinvalue();
            if (minvalue2 != null) {
                this.slValue = Pair.copy$default(this.slValue, Integer.valueOf(minvalue2.intValue()), (Object) null, 2, (Object) null);
            }
            Integer maxvalue2 = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(this.parentPosition).getMaxvalue();
            if (maxvalue2 != null) {
                this.slValue = Pair.copy$default(this.slValue, (Object) null, Integer.valueOf(maxvalue2.intValue()), 1, (Object) null);
            }
        } else {
            this.slValue = this.slValue.copy(Integer.valueOf(Integer.parseInt((String) split$default.get(0))), Integer.valueOf(Integer.parseInt((String) split$default.get(1))));
        }
        sliderEditTextUpdate();
        ((EditText) _$_findCachedViewById(C2723R.C2726id.etStart)).setText(String.valueOf(this.slValue.getFirst().intValue()));
        ((EditText) _$_findCachedViewById(C2723R.C2726id.etEnd)).setText(String.valueOf(this.slValue.getSecond().intValue()));
        ((EditText) _$_findCachedViewById(C2723R.C2726id.etStart)).setSelection(0);
        EditText editText = (EditText) _$_findCachedViewById(C2723R.C2726id.etEnd);
        Intrinsics.checkExpressionValueIsNotNull(editText, "etEnd");
        ((EditText) _$_findCachedViewById(C2723R.C2726id.etEnd)).setSelection(editText.getText().length());
        ((RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider)).addOnChangeListener(new SearchByOdometerActivity$getIntentDataAndUpdateUI$3(this));
        ((RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider)).addOnSliderTouchListener(new SearchByOdometerActivity$getIntentDataAndUpdateUI$4(this));
        ((EditText) _$_findCachedViewById(C2723R.C2726id.etStart)).setOnEditorActionListener(new SearchByOdometerActivity$getIntentDataAndUpdateUI$5(this));
        ((EditText) _$_findCachedViewById(C2723R.C2726id.etEnd)).setOnEditorActionListener(new SearchByOdometerActivity$getIntentDataAndUpdateUI$6(this));
        EditText editText2 = (EditText) _$_findCachedViewById(C2723R.C2726id.etStart);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "etStart");
        editText2.setOnFocusChangeListener(new SearchByOdometerActivity$getIntentDataAndUpdateUI$7(this));
        EditText editText3 = (EditText) _$_findCachedViewById(C2723R.C2726id.etEnd);
        Intrinsics.checkExpressionValueIsNotNull(editText3, "etEnd");
        editText3.setOnFocusChangeListener(new SearchByOdometerActivity$getIntentDataAndUpdateUI$8(this));
        ((EditText) _$_findCachedViewById(C2723R.C2726id.etStart)).addTextChangedListener(new SearchByOdometerActivity$getIntentDataAndUpdateUI$9(this));
        ((EditText) _$_findCachedViewById(C2723R.C2726id.etEnd)).addTextChangedListener(new SearchByOdometerActivity$getIntentDataAndUpdateUI$10(this));
        ((LinearLayout) _$_findCachedViewById(C2723R.C2726id.llApplyFilterContainer)).setOnClickListener(new SearchByOdometerActivity$getIntentDataAndUpdateUI$11(this));
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.ivCancel1)).setOnClickListener(new SearchByOdometerActivity$getIntentDataAndUpdateUI$12(this));
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.ivCancel2)).setOnClickListener(new SearchByOdometerActivity$getIntentDataAndUpdateUI$13(this));
    }

    /* access modifiers changed from: private */
    public final void setSelectFilterEnabled(boolean z) {
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
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* access modifiers changed from: private */
    public final void updateListOnSelectItemForSlider(int i, String str) {
        ArrayList<FacetXX> listFacet = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(i).getListFacet();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object next : listFacet) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            FacetXX facetXX = (FacetXX) next;
            facetXX.setSelected(true);
            facetXX.setValue(str + " mi");
            arrayList.add(facetXX);
            i2 = i3;
        }
        SearchMappingGroup searchMappingGroup = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(i);
        Intrinsics.checkExpressionValueIsNotNull(searchMappingGroup, "BDTUtils.searchMappingAr…osition].groups[groupPos]");
        BDTUtils.INSTANCE.getExpandableListDetail().put(searchMappingGroup, arrayList);
    }

    public void onBackPressed() {
        super.onBackPressed();
        hideKeyboard();
    }

    /* access modifiers changed from: private */
    public final void hideKeyboard() {
        Object systemService = getSystemService("input_method");
        if (systemService != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            if (inputMethodManager.isActive() && getCurrentFocus() != null) {
                View currentFocus = getCurrentFocus();
                inputMethodManager.hideSoftInputFromWindow(currentFocus != null ? currentFocus.getWindowToken() : null, 0);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    /* access modifiers changed from: private */
    public final void sliderEditTextUpdate() {
        hideKeyboard();
        if (this.slValue.getFirst().floatValue() < this.minValue) {
            if (((float) this.slValue.getSecond().intValue()) < this.minValue) {
                RangeSlider rangeSlider = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
                Intrinsics.checkExpressionValueIsNotNull(rangeSlider, "continuousSlider");
                RangeSlider rangeSlider2 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
                Intrinsics.checkExpressionValueIsNotNull(rangeSlider2, "continuousSlider");
                ((RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider)).setValues(Float.valueOf(rangeSlider.getValueFrom()), Float.valueOf(rangeSlider2.getValueFrom()));
            } else if (((float) this.slValue.getSecond().intValue()) > this.maxValue) {
                RangeSlider rangeSlider3 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
                Intrinsics.checkExpressionValueIsNotNull(rangeSlider3, "continuousSlider");
                RangeSlider rangeSlider4 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
                Intrinsics.checkExpressionValueIsNotNull(rangeSlider4, "continuousSlider");
                ((RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider)).setValues(Float.valueOf(rangeSlider3.getValueFrom()), Float.valueOf(rangeSlider4.getValueTo()));
            } else {
                float nearestValueToStep = BDTUtils.INSTANCE.getNearestValueToStep(this.slValue.getSecond().intValue(), 10000);
                RangeSlider rangeSlider5 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
                Intrinsics.checkExpressionValueIsNotNull(rangeSlider5, "continuousSlider");
                ((RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider)).setValues(Float.valueOf(rangeSlider5.getValueFrom()), Float.valueOf(nearestValueToStep));
            }
        } else if (this.slValue.getFirst().floatValue() > this.maxValue) {
            if (((float) this.slValue.getSecond().intValue()) < this.minValue) {
                RangeSlider rangeSlider6 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
                Intrinsics.checkExpressionValueIsNotNull(rangeSlider6, "continuousSlider");
                RangeSlider rangeSlider7 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
                Intrinsics.checkExpressionValueIsNotNull(rangeSlider7, "continuousSlider");
                ((RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider)).setValues(Float.valueOf(rangeSlider6.getValueTo()), Float.valueOf(rangeSlider7.getValueFrom()));
            } else if (((float) this.slValue.getSecond().intValue()) > this.maxValue) {
                RangeSlider rangeSlider8 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
                Intrinsics.checkExpressionValueIsNotNull(rangeSlider8, "continuousSlider");
                RangeSlider rangeSlider9 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
                Intrinsics.checkExpressionValueIsNotNull(rangeSlider9, "continuousSlider");
                ((RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider)).setValues(Float.valueOf(rangeSlider8.getValueTo()), Float.valueOf(rangeSlider9.getValueTo()));
            } else {
                float nearestValueToStep2 = BDTUtils.INSTANCE.getNearestValueToStep(this.slValue.getSecond().intValue(), 10000);
                RangeSlider rangeSlider10 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
                Intrinsics.checkExpressionValueIsNotNull(rangeSlider10, "continuousSlider");
                ((RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider)).setValues(Float.valueOf(rangeSlider10.getValueTo()), Float.valueOf(nearestValueToStep2));
            }
        } else if (((float) this.slValue.getSecond().intValue()) < this.minValue) {
            if (((float) this.slValue.getFirst().intValue()) < this.minValue) {
                RangeSlider rangeSlider11 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
                Intrinsics.checkExpressionValueIsNotNull(rangeSlider11, "continuousSlider");
                RangeSlider rangeSlider12 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
                Intrinsics.checkExpressionValueIsNotNull(rangeSlider12, "continuousSlider");
                ((RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider)).setValues(Float.valueOf(rangeSlider11.getValueFrom()), Float.valueOf(rangeSlider12.getValueFrom()));
            } else if (((float) this.slValue.getFirst().intValue()) > this.maxValue) {
                RangeSlider rangeSlider13 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
                Intrinsics.checkExpressionValueIsNotNull(rangeSlider13, "continuousSlider");
                RangeSlider rangeSlider14 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
                Intrinsics.checkExpressionValueIsNotNull(rangeSlider14, "continuousSlider");
                ((RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider)).setValues(Float.valueOf(rangeSlider13.getValueTo()), Float.valueOf(rangeSlider14.getValueFrom()));
            } else {
                float nearestValueToStep3 = BDTUtils.INSTANCE.getNearestValueToStep(this.slValue.getFirst().intValue(), 10000);
                RangeSlider rangeSlider15 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
                Intrinsics.checkExpressionValueIsNotNull(rangeSlider15, "continuousSlider");
                ((RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider)).setValues(Float.valueOf(nearestValueToStep3), Float.valueOf(rangeSlider15.getValueFrom()));
            }
        } else if (((float) this.slValue.getSecond().intValue()) <= this.maxValue) {
            ((RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider)).setValues(Float.valueOf(BDTUtils.INSTANCE.getNearestValueToStep(this.slValue.getFirst().intValue(), 10000)), Float.valueOf(BDTUtils.INSTANCE.getNearestValueToStep(this.slValue.getSecond().intValue(), 10000)));
        } else if (((float) this.slValue.getFirst().intValue()) < this.minValue) {
            RangeSlider rangeSlider16 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
            Intrinsics.checkExpressionValueIsNotNull(rangeSlider16, "continuousSlider");
            RangeSlider rangeSlider17 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
            Intrinsics.checkExpressionValueIsNotNull(rangeSlider17, "continuousSlider");
            ((RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider)).setValues(Float.valueOf(rangeSlider16.getValueFrom()), Float.valueOf(rangeSlider17.getValueTo()));
        } else if (((float) this.slValue.getFirst().intValue()) > this.maxValue) {
            RangeSlider rangeSlider18 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
            Intrinsics.checkExpressionValueIsNotNull(rangeSlider18, "continuousSlider");
            RangeSlider rangeSlider19 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
            Intrinsics.checkExpressionValueIsNotNull(rangeSlider19, "continuousSlider");
            ((RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider)).setValues(Float.valueOf(rangeSlider18.getValueTo()), Float.valueOf(rangeSlider19.getValueTo()));
        } else {
            float nearestValueToStep4 = BDTUtils.INSTANCE.getNearestValueToStep(this.slValue.getFirst().intValue(), 10000);
            RangeSlider rangeSlider20 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
            Intrinsics.checkExpressionValueIsNotNull(rangeSlider20, "continuousSlider");
            ((RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider)).setValues(Float.valueOf(nearestValueToStep4), Float.valueOf(rangeSlider20.getValueTo()));
        }
    }
}
