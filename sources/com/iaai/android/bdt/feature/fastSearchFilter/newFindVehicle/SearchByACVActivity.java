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
import com.iaai.android.bdt.extensions.String_ExtensionKt;
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
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020+H\u0002J\b\u0010-\u001a\u00020+H\u0002J\b\u0010.\u001a\u00020+H\u0016J\u0012\u0010/\u001a\u00020+2\b\u00100\u001a\u0004\u0018\u000101H\u0014J\u0010\u00102\u001a\u00020\n2\u0006\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020\nH\u0002J\b\u00107\u001a\u00020+H\u0002J \u00108\u001a\u00020+2\u0006\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u0004H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010R\u000e\u0010\u0016\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R&\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u000e\"\u0004\b(\u0010\u0010R\u000e\u0010)\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/SearchByACVActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "()V", "facetName", "", "getFacetName", "()Ljava/lang/String;", "setFacetName", "(Ljava/lang/String;)V", "isFromEdit", "", "maxInputValue", "", "getMaxInputValue", "()I", "setMaxInputValue", "(I)V", "maxValue", "", "minInputValue", "getMinInputValue", "setMinInputValue", "minValue", "parentPosition", "slValue", "Lkotlin/Pair;", "getSlValue", "()Lkotlin/Pair;", "setSlValue", "(Lkotlin/Pair;)V", "sliderEndVal", "getSliderEndVal", "()F", "setSliderEndVal", "(F)V", "sliderStartVal", "getSliderStartVal", "setSliderStartVal", "stepSize", "getStepSize", "setStepSize", "tabPosition", "getIntentDataAndUpdateUI", "", "hideKeyboard", "initializeUI", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "setSelectFilterEnabled", "isEnabled", "sliderEditTextUpdate", "updateListOnSelectItemForSlider", "groupPos", "displayText", "range", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SearchByACVActivity.kt */
public final class SearchByACVActivity extends BaseActivity {
    private HashMap _$_findViewCache;
    @NotNull
    private String facetName = "";
    /* access modifiers changed from: private */
    public boolean isFromEdit;
    private int maxInputValue = 100000;
    /* access modifiers changed from: private */
    public float maxValue = 100000.0f;
    private int minInputValue;
    /* access modifiers changed from: private */
    public float minValue;
    /* access modifiers changed from: private */
    public int parentPosition;
    @NotNull
    private Pair<Integer, Integer> slValue = new Pair<>(0, 0);
    private float sliderEndVal = 100000.0f;
    private float sliderStartVal;
    private int stepSize = 500;
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

    public final int getStepSize() {
        return this.stepSize;
    }

    public final void setStepSize(int i) {
        this.stepSize = i;
    }

    @NotNull
    public final String getFacetName() {
        return this.facetName;
    }

    public final void setFacetName(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.facetName = str;
    }

    public final int getMinInputValue() {
        return this.minInputValue;
    }

    public final void setMinInputValue(int i) {
        this.minInputValue = i;
    }

    public final int getMaxInputValue() {
        return this.maxInputValue;
    }

    public final void setMaxInputValue(int i) {
        this.maxInputValue = i;
    }

    public final float getSliderStartVal() {
        return this.sliderStartVal;
    }

    public final void setSliderStartVal(float f) {
        this.sliderStartVal = f;
    }

    public final float getSliderEndVal() {
        return this.sliderEndVal;
    }

    public final void setSliderEndVal(float f) {
        this.sliderEndVal = f;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_search_by_acv);
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
        toolbar.setTitle((CharSequence) getResources().getString(C2723R.string.lbl_bdt_actual_cash_value));
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2723R.C2726id.toolbar));
    }

    private final void getIntentDataAndUpdateUI() {
        String str;
        ArrayList arrayList;
        Pair<Integer, Integer> pair;
        String str2;
        setSelectFilterEnabled(false);
        Intent intent = getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent, "intent");
        Bundle extras = intent.getExtras();
        this.parentPosition = extras != null ? extras.getInt(Constants_MVVM.EXTRA_FACETS_PARENT_POSITION) : 0;
        Intent intent2 = getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent2, "intent");
        Bundle extras2 = intent2.getExtras();
        this.tabPosition = extras2 != null ? extras2.getInt(Constants_MVVM.EXTRA_FACETS_TAB_POSITION) : 0;
        FacetXX facetXX = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(this.parentPosition).getListFacet().get(0);
        Intrinsics.checkExpressionValueIsNotNull(facetXX, "BDTUtils.searchMappingAr…entPosition].listFacet[0]");
        FacetXX facetXX2 = facetXX;
        String refinerValue = facetXX2.getRefinerValue();
        List list = null;
        List split$default = refinerValue != null ? StringsKt.split$default((CharSequence) refinerValue, new String[]{"~"}, false, 0, 6, (Object) null) : null;
        if (split$default == null || (str = (String) split$default.get(0)) == null) {
            str = "";
        }
        this.facetName = str;
        if ((split$default != null ? split$default.size() : 0) > 1) {
            if (!(split$default == null || (str2 = (String) split$default.get(1)) == null)) {
                list = StringsKt.split$default((CharSequence) str2, new String[]{"-"}, false, 0, 6, (Object) null);
            }
            if (list != null) {
                arrayList = (ArrayList) list;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
            }
        } else {
            arrayList = CollectionsKt.arrayListOf(this.facetName);
        }
        Integer minvalue = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(this.parentPosition).getMinvalue();
        this.minValue = minvalue != null ? (float) minvalue.intValue() : 0.0f;
        Integer maxvalue = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(this.parentPosition).getMaxvalue();
        this.maxValue = maxvalue != null ? (float) maxvalue.intValue() : 100000.0f;
        RangeSlider rangeSlider = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
        Intrinsics.checkExpressionValueIsNotNull(rangeSlider, "continuousSlider");
        rangeSlider.setValueFrom((float) 0);
        RangeSlider rangeSlider2 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
        Intrinsics.checkExpressionValueIsNotNull(rangeSlider2, "continuousSlider");
        rangeSlider2.setValueTo((float) 100000);
        if (!facetXX2.isSelected() || arrayList.size() <= 1) {
            pair = this.slValue.copy(Integer.valueOf((int) this.minValue), Integer.valueOf((int) this.maxValue));
        } else {
            Pair<Integer, Integer> pair2 = this.slValue;
            Object obj = arrayList.get(0);
            Intrinsics.checkExpressionValueIsNotNull(obj, "temp[0]");
            Integer valueOf = Integer.valueOf(Integer.parseInt((String) obj));
            Object obj2 = arrayList.get(1);
            Intrinsics.checkExpressionValueIsNotNull(obj2, "temp[1]");
            pair = pair2.copy(valueOf, Integer.valueOf(Integer.parseInt((String) obj2)));
        }
        this.slValue = pair;
        sliderEditTextUpdate();
        ((EditText) _$_findCachedViewById(C2723R.C2726id.etStart)).setText(Typography.dollar + String_ExtensionKt.getFormattedString(String.valueOf(this.slValue.getFirst().intValue())));
        ((EditText) _$_findCachedViewById(C2723R.C2726id.etEnd)).setText(Typography.dollar + String_ExtensionKt.getFormattedString(String.valueOf(this.slValue.getSecond().intValue())));
        EditText editText = (EditText) _$_findCachedViewById(C2723R.C2726id.etStart);
        Intrinsics.checkExpressionValueIsNotNull(editText, "etStart");
        ((EditText) _$_findCachedViewById(C2723R.C2726id.etStart)).setSelection(editText.getText().length());
        EditText editText2 = (EditText) _$_findCachedViewById(C2723R.C2726id.etEnd);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "etEnd");
        ((EditText) _$_findCachedViewById(C2723R.C2726id.etEnd)).setSelection(editText2.getText().length());
        ((RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider)).addOnChangeListener(new SearchByACVActivity$getIntentDataAndUpdateUI$1(this));
        ((RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider)).addOnSliderTouchListener(new SearchByACVActivity$getIntentDataAndUpdateUI$2(this));
        ((EditText) _$_findCachedViewById(C2723R.C2726id.etStart)).setOnEditorActionListener(new SearchByACVActivity$getIntentDataAndUpdateUI$3(this));
        ((EditText) _$_findCachedViewById(C2723R.C2726id.etEnd)).setOnEditorActionListener(new SearchByACVActivity$getIntentDataAndUpdateUI$4(this));
        EditText editText3 = (EditText) _$_findCachedViewById(C2723R.C2726id.etStart);
        Intrinsics.checkExpressionValueIsNotNull(editText3, "etStart");
        editText3.setOnFocusChangeListener(new SearchByACVActivity$getIntentDataAndUpdateUI$5(this));
        EditText editText4 = (EditText) _$_findCachedViewById(C2723R.C2726id.etEnd);
        Intrinsics.checkExpressionValueIsNotNull(editText4, "etEnd");
        editText4.setOnFocusChangeListener(new SearchByACVActivity$getIntentDataAndUpdateUI$6(this));
        ((EditText) _$_findCachedViewById(C2723R.C2726id.etStart)).addTextChangedListener(new SearchByACVActivity$getIntentDataAndUpdateUI$7(this));
        ((EditText) _$_findCachedViewById(C2723R.C2726id.etEnd)).addTextChangedListener(new SearchByACVActivity$getIntentDataAndUpdateUI$8(this));
        ((LinearLayout) _$_findCachedViewById(C2723R.C2726id.llApplyFilterContainer)).setOnClickListener(new SearchByACVActivity$getIntentDataAndUpdateUI$9(this));
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.ivCancel1)).setOnClickListener(new SearchByACVActivity$getIntentDataAndUpdateUI$10(this));
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.ivCancel2)).setOnClickListener(new SearchByACVActivity$getIntentDataAndUpdateUI$11(this));
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
    public final void updateListOnSelectItemForSlider(int i, String str, String str2) {
        ArrayList<FacetXX> listFacet = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(i).getListFacet();
        ArrayList arrayList = new ArrayList();
        String group = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(i).getGroup();
        int i2 = 0;
        for (Object next : listFacet) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            FacetXX facetXX = (FacetXX) next;
            facetXX.setSelected(true);
            facetXX.setValue(str);
            facetXX.setRefinerValue(group + '~' + str2);
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
                float nearestValueToStep = BDTUtils.INSTANCE.getNearestValueToStep(this.slValue.getSecond().intValue(), this.stepSize);
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
                float nearestValueToStep2 = BDTUtils.INSTANCE.getNearestValueToStep(this.slValue.getSecond().intValue(), this.stepSize);
                RangeSlider rangeSlider10 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
                Intrinsics.checkExpressionValueIsNotNull(rangeSlider10, "continuousSlider");
                ((RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider)).setValues(Float.valueOf(rangeSlider10.getValueTo()), Float.valueOf(nearestValueToStep2));
            }
        } else if (this.slValue.getSecond().floatValue() < this.minValue) {
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
                float nearestValueToStep3 = BDTUtils.INSTANCE.getNearestValueToStep(this.slValue.getFirst().intValue(), this.stepSize);
                RangeSlider rangeSlider15 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
                Intrinsics.checkExpressionValueIsNotNull(rangeSlider15, "continuousSlider");
                ((RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider)).setValues(Float.valueOf(nearestValueToStep3), Float.valueOf(rangeSlider15.getValueFrom()));
            }
        } else if (this.slValue.getSecond().floatValue() > this.maxValue) {
            if (((float) this.slValue.getFirst().intValue()) < this.minValue) {
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
                float nearestValueToStep4 = BDTUtils.INSTANCE.getNearestValueToStep(this.slValue.getFirst().intValue(), this.stepSize);
                RangeSlider rangeSlider20 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
                Intrinsics.checkExpressionValueIsNotNull(rangeSlider20, "continuousSlider");
                ((RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider)).setValues(Float.valueOf(nearestValueToStep4), Float.valueOf(rangeSlider20.getValueTo()));
            }
        } else if (this.slValue.getFirst().intValue() > 100000) {
            if (this.slValue.getSecond().intValue() > 100000) {
                RangeSlider rangeSlider21 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
                Intrinsics.checkExpressionValueIsNotNull(rangeSlider21, "continuousSlider");
                RangeSlider rangeSlider22 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
                Intrinsics.checkExpressionValueIsNotNull(rangeSlider22, "continuousSlider");
                ((RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider)).setValues(Float.valueOf(rangeSlider21.getValueTo()), Float.valueOf(rangeSlider22.getValueTo()));
                return;
            }
            float nearestValueToStep5 = BDTUtils.INSTANCE.getNearestValueToStep(this.slValue.getSecond().intValue(), this.stepSize);
            RangeSlider rangeSlider23 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
            Intrinsics.checkExpressionValueIsNotNull(rangeSlider23, "continuousSlider");
            ((RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider)).setValues(Float.valueOf(rangeSlider23.getValueTo()), Float.valueOf(nearestValueToStep5));
        } else if (this.slValue.getSecond().intValue() <= 100000) {
            ((RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider)).setValues(Float.valueOf(BDTUtils.INSTANCE.getNearestValueToStep(this.slValue.getFirst().intValue(), this.stepSize)), Float.valueOf(BDTUtils.INSTANCE.getNearestValueToStep(this.slValue.getSecond().intValue(), this.stepSize)));
        } else if (this.slValue.getFirst().intValue() > 100000) {
            RangeSlider rangeSlider24 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
            Intrinsics.checkExpressionValueIsNotNull(rangeSlider24, "continuousSlider");
            RangeSlider rangeSlider25 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
            Intrinsics.checkExpressionValueIsNotNull(rangeSlider25, "continuousSlider");
            ((RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider)).setValues(Float.valueOf(rangeSlider24.getValueTo()), Float.valueOf(rangeSlider25.getValueTo()));
        } else {
            float nearestValueToStep6 = BDTUtils.INSTANCE.getNearestValueToStep(this.slValue.getFirst().intValue(), this.stepSize);
            RangeSlider rangeSlider26 = (RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider);
            Intrinsics.checkExpressionValueIsNotNull(rangeSlider26, "continuousSlider");
            ((RangeSlider) _$_findCachedViewById(C2723R.C2726id.continuousSlider)).setValues(Float.valueOf(nearestValueToStep6), Float.valueOf(rangeSlider26.getValueTo()));
        }
    }
}
