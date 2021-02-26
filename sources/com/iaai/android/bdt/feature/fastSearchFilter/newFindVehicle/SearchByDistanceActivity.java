package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
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
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0016J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0012H\u0002J$\u0010\u0018\u001a\u00020\n2\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u0018\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/SearchByDistanceActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "()V", "checkedId", "", "parentPosition", "postalCode", "", "tabPosition", "getIntentDataAndUpdateUI", "", "hideKeyboard", "initializeUI", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "setDistanceEnabled", "isEnabled", "setSelectFilterEnabled", "updateDistanceSpinner", "distanceList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateListOnSelectItemForZipMiles", "groupPos", "childPos", "updateUIForRadio", "btn", "Landroid/widget/RadioButton;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SearchByDistanceActivity.kt */
public final class SearchByDistanceActivity extends BaseActivity {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public int checkedId;
    /* access modifiers changed from: private */
    public int parentPosition;
    private String postalCode;
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

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_search_by_distance);
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
        String str = null;
        toolbar.setTitle((CharSequence) extras != null ? extras.getString(Constants_MVVM.EXTRA_FACETS_TITLE) : null);
        Intent intent2 = getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent2, "intent");
        Bundle extras2 = intent2.getExtras();
        if (extras2 != null) {
            str = extras2.getString(Constants_MVVM.EXTRA_POSTAL_CODE);
        }
        this.postalCode = str;
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2723R.C2726id.toolbar));
    }

    private final void getIntentDataAndUpdateUI() {
        Intent intent = getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent, "intent");
        Bundle extras = intent.getExtras();
        this.parentPosition = extras != null ? extras.getInt(Constants_MVVM.EXTRA_FACETS_PARENT_POSITION) : 0;
        Intent intent2 = getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent2, "intent");
        Bundle extras2 = intent2.getExtras();
        this.tabPosition = extras2 != null ? extras2.getInt(Constants_MVVM.EXTRA_FACETS_TAB_POSITION) : 0;
        CharSequence charSequence = this.postalCode;
        if (charSequence == null || charSequence.length() == 0) {
            EditText editText = (EditText) _$_findCachedViewById(C2723R.C2726id.etPostalValue);
            Intrinsics.checkExpressionValueIsNotNull(editText, "etPostalValue");
            editText.setHint("ZIP Code");
            setSelectFilterEnabled(false);
            setDistanceEnabled(false);
            ImageView imageView = (ImageView) _$_findCachedViewById(C2723R.C2726id.ivCancel);
            Intrinsics.checkExpressionValueIsNotNull(imageView, "ivCancel");
            imageView.setVisibility(8);
        } else {
            ((EditText) _$_findCachedViewById(C2723R.C2726id.etPostalValue)).setText(this.postalCode);
            setSelectFilterEnabled(true);
            setDistanceEnabled(true);
            ImageView imageView2 = (ImageView) _$_findCachedViewById(C2723R.C2726id.ivCancel);
            Intrinsics.checkExpressionValueIsNotNull(imageView2, "ivCancel");
            imageView2.setVisibility(0);
        }
        List list = BDTUtils.INSTANCE.getExpandableListDetail().get(BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(this.parentPosition));
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            int i = 0;
            for (Object next : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                FacetXX facetXX = (FacetXX) next;
                List split$default = StringsKt.split$default((CharSequence) facetXX.getValue(), new String[]{"< "}, false, 0, 6, (Object) null);
                if (facetXX.isSelected()) {
                    this.checkedId = i;
                }
                if (split$default.size() > 1) {
                    arrayList.add(StringsKt.replace$default((String) split$default.get(1), "mi", "miles", false, 4, (Object) null));
                } else {
                    arrayList.add(split$default.get(0));
                }
                i = i2;
            }
        }
        updateDistanceSpinner(arrayList);
        ((LinearLayout) _$_findCachedViewById(C2723R.C2726id.llApplyFilterContainer)).setOnClickListener(new SearchByDistanceActivity$getIntentDataAndUpdateUI$2(this));
        ((EditText) _$_findCachedViewById(C2723R.C2726id.etPostalValue)).addTextChangedListener(new SearchByDistanceActivity$getIntentDataAndUpdateUI$3(this));
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.ivCancel)).setOnClickListener(new SearchByDistanceActivity$getIntentDataAndUpdateUI$4(this));
    }

    /* access modifiers changed from: private */
    public final void setDistanceEnabled(boolean z) {
        if (z) {
            Spinner spinner = (Spinner) _$_findCachedViewById(C2723R.C2726id.spDistance);
            Intrinsics.checkExpressionValueIsNotNull(spinner, "spDistance");
            spinner.setClickable(z);
            ((Spinner) _$_findCachedViewById(C2723R.C2726id.spDistance)).setBackgroundResource(C2723R.C2725drawable.bg_spinner_sale_doc_enable);
            ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.llDistance)).setBackgroundResource(C2723R.C2725drawable.rep_spinner_round_rect_bg);
            Spinner spinner2 = (Spinner) _$_findCachedViewById(C2723R.C2726id.spDistance);
            Intrinsics.checkExpressionValueIsNotNull(spinner2, "spDistance");
            spinner2.setEnabled(z);
            return;
        }
        Spinner spinner3 = (Spinner) _$_findCachedViewById(C2723R.C2726id.spDistance);
        Intrinsics.checkExpressionValueIsNotNull(spinner3, "spDistance");
        spinner3.setClickable(z);
        Spinner spinner4 = (Spinner) _$_findCachedViewById(C2723R.C2726id.spDistance);
        Intrinsics.checkExpressionValueIsNotNull(spinner4, "spDistance");
        spinner4.setEnabled(z);
        ((Spinner) _$_findCachedViewById(C2723R.C2726id.spDistance)).setBackgroundResource(C2723R.C2725drawable.bg_spinner_sale_doc_disable);
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.llDistance)).setBackgroundResource(C2723R.C2725drawable.rep_spinner_round_rect_bg_disable);
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

    private final void updateUIForRadio(RadioButton radioButton, boolean z) {
        if (z) {
            radioButton.setEnabled(true);
            radioButton.setAlpha(1.0f);
            return;
        }
        radioButton.setEnabled(false);
        radioButton.setAlpha(0.5f);
    }

    private final void updateDistanceSpinner(ArrayList<String> arrayList) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Context context = this;
        if (arrayList != null) {
            objectRef.element = new ArrayAdapter(context, 17367048, arrayList);
            ((ArrayAdapter) objectRef.element).setDropDownViewResource(17367049);
            Spinner spinner = (Spinner) _$_findCachedViewById(C2723R.C2726id.spDistance);
            spinner.setAdapter((ArrayAdapter) objectRef.element);
            spinner.setSelection(this.checkedId, false);
            spinner.setOnItemSelectedListener(new C2740xdc58d7ff(this, objectRef));
            spinner.setGravity(17);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
    }

    /* access modifiers changed from: private */
    public final void updateListOnSelectItemForZipMiles(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        List list = BDTUtils.INSTANCE.getExpandableListDetail().get(BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(i3));
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            int i5 = 0;
            for (Object next : list) {
                int i6 = i5 + 1;
                if (i5 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                FacetXX facetXX = (FacetXX) next;
                facetXX.setSelected(i5 == i4);
                if (i5 == i4) {
                    Log.e("TEST", "ZIP " + facetXX.getRefinerValue());
                    List split$default = StringsKt.split$default((CharSequence) facetXX.getValue(), new String[]{"< "}, false, 0, 6, (Object) null);
                    if (split$default.size() > 1) {
                        StringBuilder sb = new StringBuilder();
                        EditText editText = (EditText) _$_findCachedViewById(C2723R.C2726id.etPostalValue);
                        Intrinsics.checkExpressionValueIsNotNull(editText, "etPostalValue");
                        sb.append(editText.getText());
                        sb.append(" < ");
                        sb.append(StringsKt.replace$default((String) split$default.get(1), "miles", "mi", false, 4, (Object) null));
                        facetXX.setValue(sb.toString());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Distance~");
                        EditText editText2 = (EditText) _$_findCachedViewById(C2723R.C2726id.etPostalValue);
                        Intrinsics.checkExpressionValueIsNotNull(editText2, "etPostalValue");
                        sb2.append(editText2.getText());
                        sb2.append('~');
                        sb2.append((String) split$default.get(1));
                        facetXX.setRefinerValue(sb2.toString());
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        EditText editText3 = (EditText) _$_findCachedViewById(C2723R.C2726id.etPostalValue);
                        Intrinsics.checkExpressionValueIsNotNull(editText3, "etPostalValue");
                        sb3.append(editText3.getText());
                        sb3.append(" < ");
                        sb3.append(StringsKt.replace$default((String) split$default.get(0), "miles", "mi", false, 4, (Object) null));
                        facetXX.setValue(sb3.toString());
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Distance~");
                        EditText editText4 = (EditText) _$_findCachedViewById(C2723R.C2726id.etPostalValue);
                        Intrinsics.checkExpressionValueIsNotNull(editText4, "etPostalValue");
                        sb4.append(editText4.getText());
                        sb4.append('~');
                        sb4.append((String) split$default.get(0));
                        facetXX.setRefinerValue(sb4.toString());
                    }
                }
                arrayList.add(facetXX);
                i5 = i6;
            }
        }
        SearchMappingGroup searchMappingGroup = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(i3);
        Intrinsics.checkExpressionValueIsNotNull(searchMappingGroup, "BDTUtils.searchMappingAr…osition].groups[groupPos]");
        BDTUtils.INSTANCE.getExpandableListDetail().put(searchMappingGroup, arrayList);
    }

    public void onBackPressed() {
        super.onBackPressed();
        hideKeyboard();
    }

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
}
