package com.iaai.android.bdt.feature.findVehiclePage;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListActivity;
import com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity;
import com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.SelectedRefinerIndicesModel;
import com.iaai.android.bdt.feature.findVehiclePage.SearchSuggestionsAdapter;
import com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity;
import com.iaai.android.bdt.model.fastSearch.MakeModelMaster;
import com.iaai.android.bdt.model.fastSearch.Refiner;
import com.iaai.android.bdt.model.fastSearch.RefinerX;
import com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2;
import com.iaai.android.bdt.model.fastSearchFilter2.FacetXX;
import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchResponse2;
import com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray;
import com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingGroup;
import com.iaai.android.bdt.utils.BDTUtils;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0002J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\bH\u0002J\b\u0010$\u001a\u00020\u001cH\u0002J\u0006\u0010%\u001a\u00020\u001cJ\b\u0010&\u001a\u00020\u001cH\u0002J\b\u0010'\u001a\u00020\u001cH\u0002J\"\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\u0012\u0010-\u001a\u00020\u001c2\b\u0010.\u001a\u0004\u0018\u00010/H\u0014J\u0010\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\bH\u0016J\b\u00102\u001a\u00020\u001cH\u0014J\b\u00103\u001a\u00020\u001cH\u0002J\b\u00104\u001a\u00020\u001cH\u0002J8\u00105\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010+\u001a\u00020\bH\u0002J \u00107\u001a\u00020\u001c2\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0002J\u0010\u00108\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\bH\u0002J\b\u00109\u001a\u00020\u001cH\u0002J\b\u0010:\u001a\u00020\u001cH\u0002J\b\u0010;\u001a\u00020\u001cH\u0002J\u0010\u0010<\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0007j\b\u0012\u0004\u0012\u00020\u0011`\tX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0007j\b\u0012\u0004\u0012\u00020\u0016`\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/SearchPanelFindVehicleActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/iaai/android/bdt/feature/findVehiclePage/SearchSuggestionsAdapter$OnItemClickListener;", "()V", "REQ_CODE_SPEECH_INPUT", "", "branchList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "isFromAuctionSearch", "", "isFromFilterPage", "Ljava/lang/Boolean;", "isFromFindVehiclePage", "isFromSearchByVehicle", "masterMakeModel", "Lcom/iaai/android/bdt/model/fastSearch/MakeModelMaster;", "recentSearchListAuctions", "recentSearchListVehicles", "refinerJSON", "refinerList", "Lcom/iaai/android/bdt/model/fastSearch/Refiner;", "searchKeyword", "searchSuggestionsAdapter", "Lcom/iaai/android/bdt/feature/findVehiclePage/SearchSuggestionsAdapter;", "suggestionsList", "getMasterDataForMakeModel", "", "getRecentSearchData", "getSearchInfo", "p0", "Landroid/text/SpannableStringBuilder;", "getSuggestionsList", "getSuggestionsListUsingFacets", "facetJSON", "hideSoftKeyboard", "init", "initializeRecentlySelected", "initializeRecycler", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "selectedSuggestion", "onResume", "performSearch", "promptSpeechInput", "saveRecentInPref", "recentList", "saveRecentSearchInPreference", "setRecentSearchData", "setSearchHint", "setSearchTab", "showSoftKeyboard", "updateRecyclerViewUI", "isVisible", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SearchPanelFindVehicleActivity.kt */
public final class SearchPanelFindVehicleActivity extends AppCompatActivity implements SearchSuggestionsAdapter.OnItemClickListener {
    private final int REQ_CODE_SPEECH_INPUT = 100;
    private HashMap _$_findViewCache;
    private ArrayList<String> branchList = new ArrayList<>();
    private boolean isFromAuctionSearch;
    private Boolean isFromFilterPage = false;
    private boolean isFromFindVehiclePage;
    /* access modifiers changed from: private */
    public Boolean isFromSearchByVehicle = false;
    private ArrayList<MakeModelMaster> masterMakeModel = new ArrayList<>();
    private ArrayList<String> recentSearchListAuctions = new ArrayList<>();
    private ArrayList<String> recentSearchListVehicles = new ArrayList<>();
    private String refinerJSON = "";
    private ArrayList<Refiner> refinerList = new ArrayList<>();
    /* access modifiers changed from: private */
    public String searchKeyword = "";
    /* access modifiers changed from: private */
    public SearchSuggestionsAdapter searchSuggestionsAdapter;
    private final ArrayList<String> suggestionsList = new ArrayList<>();

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

    public static final /* synthetic */ SearchSuggestionsAdapter access$getSearchSuggestionsAdapter$p(SearchPanelFindVehicleActivity searchPanelFindVehicleActivity) {
        SearchSuggestionsAdapter searchSuggestionsAdapter2 = searchPanelFindVehicleActivity.searchSuggestionsAdapter;
        if (searchSuggestionsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchSuggestionsAdapter");
        }
        return searchSuggestionsAdapter2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_search_panel_find_vehicle);
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2723R.C2726id.toolbar));
        boolean z = false;
        this.isFromSearchByVehicle = Boolean.valueOf(getIntent().getBooleanExtra(Constants_MVVM.EXTRA_SEARCH_BY_VEHICLE, false));
        this.isFromFindVehiclePage = getIntent().getBooleanExtra(Constants_MVVM.EXTRA_IS_FROM_FIND_VEHICLE_PAGE, false);
        this.isFromFilterPage = Boolean.valueOf(getIntent().getBooleanExtra(Constants_MVVM.EXTRA_IS_FILTERPAGE, false));
        this.searchKeyword = getIntent().getStringExtra(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY);
        this.isFromAuctionSearch = getIntent().getBooleanExtra(Constants_MVVM.EXTRA_IS_AUCTION_SEARCH, false);
        IAASharedPreference.setRefinerSearch(getApplicationContext(), this.searchKeyword);
        if (this.isFromFindVehiclePage || this.isFromAuctionSearch) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.ll_container_search_by);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "ll_container_search_by");
            linearLayout.setVisibility(8);
        } else {
            setSearchTab();
        }
        initializeRecycler();
        init();
        if (IaaiApplication.is_new_fast_Search) {
            String facetJson = IAASharedPreference.getFacetJson(this);
            Intrinsics.checkExpressionValueIsNotNull(facetJson, "facetJSON");
            if (facetJson.length() > 0) {
                z = true;
            }
            if (z) {
                this.suggestionsList.add("test");
                getSuggestionsListUsingFacets(facetJson);
                return;
            }
            return;
        }
        String refinerJson = IAASharedPreference.getRefinerJson(this);
        Intrinsics.checkExpressionValueIsNotNull(refinerJson, "IAASharedPreference.getRefinerJson(this)");
        this.refinerJSON = refinerJson;
        if (this.refinerJSON.length() > 0) {
            z = true;
        }
        if (z) {
            getSuggestionsList();
        }
    }

    /* access modifiers changed from: private */
    public final void setSearchHint() {
        Boolean bool = this.isFromSearchByVehicle;
        if (bool == null) {
            Intrinsics.throwNpe();
        }
        if (bool.booleanValue()) {
            EditText editText = (EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search);
            Intrinsics.checkExpressionValueIsNotNull(editText, "new_keyword_search");
            editText.setHint(getString(C2723R.string.hint_search_vehicle));
            return;
        }
        EditText editText2 = (EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "new_keyword_search");
        editText2.setHint(getString(C2723R.string.hint_search_auction));
    }

    public final void init() {
        setSearchHint();
        ((EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search)).requestFocus();
        ((EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search)).setText(this.searchKeyword);
        ((EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search)).setOnEditorActionListener(new SearchPanelFindVehicleActivity$init$1(this));
        ((EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search)).addTextChangedListener(new SearchPanelFindVehicleActivity$init$2(this));
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.img_voice_text)).setOnClickListener(new SearchPanelFindVehicleActivity$init$3(this));
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.img_clear_text)).setOnClickListener(new SearchPanelFindVehicleActivity$init$4(this));
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tv_searchByVehicle)).setOnClickListener(new SearchPanelFindVehicleActivity$init$5(this));
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tv_searchByAuction)).setOnClickListener(new SearchPanelFindVehicleActivity$init$6(this));
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.img_back)).setOnClickListener(new SearchPanelFindVehicleActivity$init$7(this));
    }

    /* access modifiers changed from: private */
    public final void promptSpeechInput() {
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        intent.putExtra("android.speech.extra.LANGUAGE", Locale.getDefault());
        Boolean bool = this.isFromSearchByVehicle;
        if (bool == null) {
            Intrinsics.throwNpe();
        }
        if (bool.booleanValue()) {
            intent.putExtra("android.speech.extra.PROMPT", getString(C2723R.string.hint_search_vehicle));
        } else {
            intent.putExtra("android.speech.extra.PROMPT", getString(C2723R.string.hint_search_auction));
        }
        try {
            startActivityForResult(intent, this.REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(getApplicationContext(), getString(C2723R.string.speech_not_supported), 0).show();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == this.REQ_CODE_SPEECH_INPUT) {
            if (i2 == -1 && intent != null) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("android.speech.extra.RESULTS");
                ((EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search)).setText(stringArrayListExtra.get(0));
                ((EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search)).requestFocus();
                showSoftKeyboard();
                IAASharedPreference.setRefinerSearch(getApplicationContext(), stringArrayListExtra.get(0));
            }
        } else if (i == 103 && intent != null && intent.hasExtra(Constants_MVVM.EXTRA_IS_LANDING_PAGE) && intent.getBooleanExtra(Constants_MVVM.EXTRA_IS_LANDING_PAGE, false)) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.searchKeyword = IAASharedPreference.getRefinerSearch(getApplicationContext());
        ((EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search)).setText(this.searchKeyword);
        EditText editText = (EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search);
        Intrinsics.checkExpressionValueIsNotNull(editText, "new_keyword_search");
        ((EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search)).setSelection(editText.getText().length());
    }

    /* access modifiers changed from: private */
    public final void setSearchTab() {
        Boolean bool = this.isFromSearchByVehicle;
        if (bool == null) {
            Intrinsics.throwNpe();
        }
        if (bool.booleanValue()) {
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_searchByVehicle);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tv_searchByVehicle");
            textView.setBackground(getResources().getDrawable(C2723R.C2725drawable.vin_rounded_corner_button));
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_searchByAuction);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "tv_searchByAuction");
            textView2.setBackground(getResources().getDrawable(C2723R.C2725drawable.vin_rounded_corner_button_desable));
            ((TextView) _$_findCachedViewById(C2723R.C2726id.tv_searchByAuction)).setTextColor(ContextCompat.getColor(getApplicationContext(), C2723R.C2724color.bdt_gray_dark));
            ((TextView) _$_findCachedViewById(C2723R.C2726id.tv_searchByVehicle)).setTextColor(ContextCompat.getColor(getApplicationContext(), C2723R.C2724color.bdt_red));
            return;
        }
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_searchByAuction);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "tv_searchByAuction");
        textView3.setBackground(getResources().getDrawable(C2723R.C2725drawable.vin_rounded_corner_button));
        TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_searchByVehicle);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "tv_searchByVehicle");
        textView4.setBackground(getResources().getDrawable(C2723R.C2725drawable.vin_rounded_corner_button_desable));
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tv_searchByVehicle)).setTextColor(ContextCompat.getColor(getApplicationContext(), C2723R.C2724color.bdt_gray_dark));
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tv_searchByAuction)).setTextColor(ContextCompat.getColor(getApplicationContext(), C2723R.C2724color.bdt_red));
    }

    private final void initializeRecycler() {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
        this.searchSuggestionsAdapter = new SearchSuggestionsAdapter(applicationContext);
        SearchSuggestionsAdapter searchSuggestionsAdapter2 = this.searchSuggestionsAdapter;
        if (searchSuggestionsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchSuggestionsAdapter");
        }
        searchSuggestionsAdapter2.setClickListener(this);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rv_searchSuggestion);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rv_searchSuggestion");
        SearchSuggestionsAdapter searchSuggestionsAdapter3 = this.searchSuggestionsAdapter;
        if (searchSuggestionsAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchSuggestionsAdapter");
        }
        recyclerView.setAdapter(searchSuggestionsAdapter3);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rv_searchSuggestion);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rv_searchSuggestion");
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        initializeRecentlySelected();
    }

    private final void showSoftKeyboard() {
        if (getCurrentFocus() != null) {
            Object systemService = getSystemService("input_method");
            if (systemService != null) {
                ((InputMethodManager) systemService).showSoftInput(getCurrentFocus(), 1);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    /* access modifiers changed from: private */
    public final void hideSoftKeyboard() {
        if (getCurrentFocus() != null) {
            Object systemService = getApplicationContext().getSystemService("input_method");
            if (systemService != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                View currentFocus = getCurrentFocus();
                if (currentFocus == null) {
                    Intrinsics.throwNpe();
                }
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    private final void getSuggestionsList() {
        getMasterDataForMakeModel();
        Object fromJson = new Gson().fromJson(this.refinerJSON, new SearchPanelFindVehicleActivity$getSuggestionsList$1().getType());
        Intrinsics.checkExpressionValueIsNotNull(fromJson, "gson.fromJson(refinerJSO…List<Refiner>>() {}.type)");
        this.refinerList = (ArrayList) fromJson;
        Iterator<Refiner> it = this.refinerList.iterator();
        while (it.hasNext()) {
            Refiner next = it.next();
            if (StringsKt.equals(next.getDisplayName(), ExifInterface.TAG_MAKE, true) || StringsKt.equals(next.getDisplayName(), ExifInterface.TAG_MODEL, true)) {
                if (StringsKt.equals(next.getDisplayName(), ExifInterface.TAG_MAKE, true)) {
                    for (RefinerX refinerX : next.getRefiners()) {
                        ArrayList<String> arrayList = this.suggestionsList;
                        String displayName = refinerX.getDisplayName();
                        if (displayName != null) {
                            arrayList.add(StringsKt.trim((CharSequence) displayName).toString());
                            Iterator<MakeModelMaster> it2 = this.masterMakeModel.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    MakeModelMaster next2 = it2.next();
                                    String make = next2.getMake();
                                    String displayName2 = refinerX.getDisplayName();
                                    if (displayName2 == null) {
                                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                                    } else if (StringsKt.equals(make, StringsKt.trim((CharSequence) displayName2).toString(), true)) {
                                        List<String> models = next2.getModels();
                                        if (models == null) {
                                            Intrinsics.throwNpe();
                                        }
                                        for (String next3 : models) {
                                            if (next3.length() > 0) {
                                                ArrayList<String> arrayList2 = this.suggestionsList;
                                                StringBuilder sb = new StringBuilder();
                                                String displayName3 = refinerX.getDisplayName();
                                                if (displayName3 != null) {
                                                    sb.append(StringsKt.trim((CharSequence) displayName3).toString());
                                                    sb.append(' ');
                                                    sb.append(next3);
                                                    arrayList2.add(sb.toString());
                                                } else {
                                                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                                                }
                                            }
                                        }
                                        continue;
                                    }
                                }
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (!StringsKt.equals(next.getDisplayName(), "Popular Categories", true) && !StringsKt.equals(next.getDisplayName(), "QuickLinks", true) && !StringsKt.equals(next.getDisplayName(), "Assigned Vehicles", true) && !StringsKt.equals(next.getDisplayName(), "Auction Week", true)) {
                for (RefinerX next4 : next.getRefiners()) {
                    if (StringsKt.equals(next.getDisplayName(), Constants.TO_BE_PAID_SRT_BRANCH, true) || StringsKt.equals(next.getDisplayName(), "State", true)) {
                        this.branchList.add(next4.getDisplayName());
                    }
                    this.suggestionsList.add(next4.getDisplayName());
                }
            }
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList3 = new ArrayList();
        for (Object next5 : this.suggestionsList) {
            String str = (String) next5;
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            } else if (hashSet.add(StringsKt.trim((CharSequence) str).toString())) {
                arrayList3.add(next5);
            }
        }
        this.suggestionsList.clear();
        this.suggestionsList.addAll(CollectionsKt.sortedWith(arrayList3, new C2742x96891f5b()));
    }

    private final void getSuggestionsListUsingFacets(String str) {
        if (BDTUtils.INSTANCE.getSearchMappingArray().size() == 0) {
            FastSearchResponse2 fastSearchResponse2 = (FastSearchResponse2) new Gson().fromJson(str, FastSearchResponse2.class);
            Intrinsics.checkExpressionValueIsNotNull(fastSearchResponse2, "fastSearchResponse2");
            BDTUtils.INSTANCE.getFilterMapping(this, fastSearchResponse2);
        }
        getMasterDataForMakeModel();
        int i = 0;
        for (Object next : BDTUtils.INSTANCE.getSearchMappingArray()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SearchMappingArray searchMappingArray = (SearchMappingArray) next;
            Iterator<SearchMappingGroup> it = BDTUtils.INSTANCE.getSearchMappingArray().get(i).getGroups().iterator();
            while (it.hasNext()) {
                SearchMappingGroup next2 = it.next();
                if (StringsKt.equals(next2.getGroup(), ExifInterface.TAG_MAKE, true) || StringsKt.equals(next2.getGroup(), ExifInterface.TAG_MODEL, true)) {
                    if (StringsKt.equals(next2.getGroup(), ExifInterface.TAG_MAKE, true)) {
                        for (FacetXX facetXX : next2.getListFacet()) {
                            ArrayList<String> arrayList = this.suggestionsList;
                            String value = facetXX.getValue();
                            if (value != null) {
                                arrayList.add(StringsKt.trim((CharSequence) value).toString());
                                Iterator<MakeModelMaster> it2 = this.masterMakeModel.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        MakeModelMaster next3 = it2.next();
                                        String make = next3.getMake();
                                        String value2 = facetXX.getValue();
                                        if (value2 == null) {
                                            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                                        } else if (StringsKt.equals(make, StringsKt.trim((CharSequence) value2).toString(), true)) {
                                            List<String> models = next3.getModels();
                                            if (models == null) {
                                                Intrinsics.throwNpe();
                                            }
                                            for (String next4 : models) {
                                                if (next4.length() > 0) {
                                                    ArrayList<String> arrayList2 = this.suggestionsList;
                                                    StringBuilder sb = new StringBuilder();
                                                    String value3 = facetXX.getValue();
                                                    if (value3 != null) {
                                                        sb.append(StringsKt.trim((CharSequence) value3).toString());
                                                        sb.append(' ');
                                                        sb.append(next4);
                                                        arrayList2.add(sb.toString());
                                                    } else {
                                                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                                                    }
                                                }
                                            }
                                            continue;
                                        }
                                    }
                                }
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                            }
                        }
                        continue;
                    } else {
                        continue;
                    }
                } else if (!StringsKt.equals(next2.getGroup(), "Popular Categories", true) && !StringsKt.equals(next2.getGroup(), "QuickLinks", true) && !StringsKt.equals(next2.getGroup(), "Assigned Vehicles", true) && !StringsKt.equals(next2.getGroup(), "Auction Week", true)) {
                    Iterator<FacetXX> it3 = next2.getListFacet().iterator();
                    while (it3.hasNext()) {
                        FacetXX next5 = it3.next();
                        if (StringsKt.equals(next2.getGroup(), "BranchName", true) || StringsKt.equals(next2.getGroup(), "VehicleState", true)) {
                            this.branchList.add(next5.getValue());
                        }
                        this.suggestionsList.add(next5.getValue());
                    }
                }
            }
            i = i2;
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList3 = new ArrayList();
        for (Object next6 : this.suggestionsList) {
            String str2 = (String) next6;
            if (str2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            } else if (hashSet.add(StringsKt.trim((CharSequence) str2).toString())) {
                arrayList3.add(next6);
            }
        }
        this.suggestionsList.clear();
        this.suggestionsList.addAll(CollectionsKt.sortedWith(arrayList3, new C2743x7f6fa85()));
    }

    private final void getMasterDataForMakeModel() {
        Gson gson = new Gson();
        String makeModelMasterData = IAASharedPreference.getMakeModelMasterData(this);
        Intrinsics.checkExpressionValueIsNotNull(makeModelMasterData, "json");
        if (makeModelMasterData.length() > 0) {
            Object fromJson = gson.fromJson(makeModelMasterData, new SearchPanelFindVehicleActivity$getMasterDataForMakeModel$1().getType());
            Intrinsics.checkExpressionValueIsNotNull(fromJson, "gson.fromJson(json, obje…eModelMaster>>() {}.type)");
            this.masterMakeModel = (ArrayList) fromJson;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.util.List} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void getSearchInfo(android.text.SpannableStringBuilder r9) {
        /*
            r8 = this;
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            r1 = 0
            r2 = 1
            kotlin.text.Regex r3 = new kotlin.text.Regex     // Catch:{ Exception -> 0x00a4 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a4 }
            r4.<init>()     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r5 = "\\b"
            r4.append(r5)     // Catch:{ Exception -> 0x00a4 }
            r4.append(r9)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r5 = "[a-zA-Z0-9]*\\b"
            r4.append(r5)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00a4 }
            kotlin.text.RegexOption r5 = kotlin.text.RegexOption.IGNORE_CASE     // Catch:{ Exception -> 0x00a4 }
            r3.<init>((java.lang.String) r4, (kotlin.text.RegexOption) r5)     // Catch:{ Exception -> 0x00a4 }
            java.lang.Boolean r4 = r8.isFromSearchByVehicle     // Catch:{ Exception -> 0x00a4 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r2)     // Catch:{ Exception -> 0x00a4 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)     // Catch:{ Exception -> 0x00a4 }
            if (r4 != 0) goto L_0x006b
            boolean r4 = r8.isFromFindVehiclePage     // Catch:{ Exception -> 0x00a4 }
            if (r4 == 0) goto L_0x0034
            goto L_0x006b
        L_0x0034:
            java.util.ArrayList<java.lang.String> r4 = r8.branchList     // Catch:{ Exception -> 0x00a4 }
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch:{ Exception -> 0x00a4 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x00a4 }
            r5.<init>()     // Catch:{ Exception -> 0x00a4 }
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ Exception -> 0x00a4 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x00a4 }
        L_0x0043:
            boolean r6 = r4.hasNext()     // Catch:{ Exception -> 0x00a4 }
            if (r6 == 0) goto L_0x005a
            java.lang.Object r6 = r4.next()     // Catch:{ Exception -> 0x00a4 }
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x00a4 }
            boolean r7 = com.iaai.android.bdt.extensions.Regex_ExtensionKt.filterSearch(r3, r7)     // Catch:{ Exception -> 0x00a4 }
            if (r7 == 0) goto L_0x0043
            r5.add(r6)     // Catch:{ Exception -> 0x00a4 }
            goto L_0x0043
        L_0x005a:
            r3 = r5
            java.util.List r3 = (java.util.List) r3     // Catch:{ Exception -> 0x00a4 }
            boolean r0 = r3.isEmpty()     // Catch:{ Exception -> 0x00a2 }
            if (r0 == 0) goto L_0x0067
            r8.updateRecyclerViewUI(r1)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00b2
        L_0x0067:
            r8.updateRecyclerViewUI(r2)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00b2
        L_0x006b:
            java.util.ArrayList<java.lang.String> r4 = r8.suggestionsList     // Catch:{ Exception -> 0x00a4 }
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch:{ Exception -> 0x00a4 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x00a4 }
            r5.<init>()     // Catch:{ Exception -> 0x00a4 }
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ Exception -> 0x00a4 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x00a4 }
        L_0x007a:
            boolean r6 = r4.hasNext()     // Catch:{ Exception -> 0x00a4 }
            if (r6 == 0) goto L_0x0091
            java.lang.Object r6 = r4.next()     // Catch:{ Exception -> 0x00a4 }
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x00a4 }
            boolean r7 = com.iaai.android.bdt.extensions.Regex_ExtensionKt.filterSearch(r3, r7)     // Catch:{ Exception -> 0x00a4 }
            if (r7 == 0) goto L_0x007a
            r5.add(r6)     // Catch:{ Exception -> 0x00a4 }
            goto L_0x007a
        L_0x0091:
            r3 = r5
            java.util.List r3 = (java.util.List) r3     // Catch:{ Exception -> 0x00a4 }
            boolean r0 = r3.isEmpty()     // Catch:{ Exception -> 0x00a2 }
            if (r0 == 0) goto L_0x009e
            r8.updateRecyclerViewUI(r1)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00b2
        L_0x009e:
            r8.updateRecyclerViewUI(r2)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00b2
        L_0x00a2:
            goto L_0x00a5
        L_0x00a4:
            r3 = r0
        L_0x00a5:
            boolean r0 = r3.isEmpty()
            if (r0 == 0) goto L_0x00af
            r8.updateRecyclerViewUI(r1)
            goto L_0x00b2
        L_0x00af:
            r8.updateRecyclerViewUI(r2)
        L_0x00b2:
            com.iaai.android.bdt.feature.findVehiclePage.SearchSuggestionsAdapter r0 = r8.searchSuggestionsAdapter
            java.lang.String r2 = "searchSuggestionsAdapter"
            if (r0 != 0) goto L_0x00bb
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x00bb:
            java.util.ArrayList r4 = new java.util.ArrayList
            java.util.Collection r3 = (java.util.Collection) r3
            r4.<init>(r3)
            java.lang.String r9 = r9.toString()
            java.lang.String r3 = "p0.toString()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r3)
            r0.setSuggestionData(r4, r1, r9)
            com.iaai.android.bdt.feature.findVehiclePage.SearchSuggestionsAdapter r9 = r8.searchSuggestionsAdapter
            if (r9 != 0) goto L_0x00d5
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x00d5:
            r9.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.findVehiclePage.SearchPanelFindVehicleActivity.getSearchInfo(android.text.SpannableStringBuilder):void");
    }

    public void onItemClick(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "selectedSuggestion");
        ((EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search)).setText(str);
        EditText editText = (EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search);
        Intrinsics.checkExpressionValueIsNotNull(editText, "new_keyword_search");
        ((EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search)).setSelection(editText.getText().length());
        performSearch();
    }

    private final void updateRecyclerViewUI(boolean z) {
        if (z) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.clSuggestions);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "clSuggestions");
            linearLayout.setVisibility(0);
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvSuggestionLabel);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tvSuggestionLabel");
            textView.setVisibility(0);
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvSuggestionLabel);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "tvSuggestionLabel");
            textView2.setText(getResources().getString(C2723R.string.lbl_suggestions));
            View _$_findCachedViewById = _$_findCachedViewById(C2723R.C2726id.emptySuggestions);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "emptySuggestions");
            _$_findCachedViewById.setVisibility(8);
        } else if (!z) {
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.clSuggestions);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "clSuggestions");
            linearLayout2.setVisibility(8);
            View _$_findCachedViewById2 = _$_findCachedViewById(C2723R.C2726id.emptySuggestions);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, "emptySuggestions");
            _$_findCachedViewById2.setVisibility(0);
            View _$_findCachedViewById3 = _$_findCachedViewById(C2723R.C2726id.emptySuggestions);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById3, "emptySuggestions");
            TextView textView3 = (TextView) _$_findCachedViewById3.findViewById(C2723R.C2726id.errorTitle);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "emptySuggestions.errorTitle");
            textView3.setText(getResources().getString(C2723R.string.lbl_no_suggestions));
        }
    }

    /* access modifiers changed from: private */
    public final void initializeRecentlySelected() {
        if (getRecentSearchData().size() > 0) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.clSuggestions);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "clSuggestions");
            linearLayout.setVisibility(0);
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvSuggestionLabel);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tvSuggestionLabel");
            textView.setVisibility(0);
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvSuggestionLabel);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "tvSuggestionLabel");
            textView2.setText(getResources().getString(C2723R.string.lbl_try_searching));
            if (this.isFromFindVehiclePage || Intrinsics.areEqual((Object) this.isFromSearchByVehicle, (Object) true)) {
                SearchSuggestionsAdapter searchSuggestionsAdapter2 = this.searchSuggestionsAdapter;
                if (searchSuggestionsAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchSuggestionsAdapter");
                }
                searchSuggestionsAdapter2.setSuggestionData(this.recentSearchListVehicles, true, "");
            } else {
                SearchSuggestionsAdapter searchSuggestionsAdapter3 = this.searchSuggestionsAdapter;
                if (searchSuggestionsAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchSuggestionsAdapter");
                }
                searchSuggestionsAdapter3.setSuggestionData(this.recentSearchListAuctions, true, "");
            }
            SearchSuggestionsAdapter searchSuggestionsAdapter4 = this.searchSuggestionsAdapter;
            if (searchSuggestionsAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchSuggestionsAdapter");
            }
            searchSuggestionsAdapter4.notifyDataSetChanged();
            return;
        }
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvSuggestionLabel);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "tvSuggestionLabel");
        textView3.setVisibility(8);
        SearchSuggestionsAdapter searchSuggestionsAdapter5 = this.searchSuggestionsAdapter;
        if (searchSuggestionsAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchSuggestionsAdapter");
        }
        searchSuggestionsAdapter5.clearAllData();
    }

    private final void setRecentSearchData(String str) {
        ArrayList<String> arrayList;
        if (this.isFromFindVehiclePage || Intrinsics.areEqual((Object) this.isFromSearchByVehicle, (Object) true)) {
            arrayList = saveRecentInPref(this.recentSearchListVehicles, str);
        } else {
            arrayList = saveRecentInPref(this.recentSearchListAuctions, str);
        }
        saveRecentSearchInPreference(arrayList);
    }

    private final void saveRecentSearchInPreference(ArrayList<String> arrayList) {
        String json = new Gson().toJson((Object) arrayList);
        if (this.isFromFindVehiclePage || Intrinsics.areEqual((Object) this.isFromSearchByVehicle, (Object) true)) {
            IAASharedPreference.setRecentSearchDataVehicles(this, json);
        } else {
            IAASharedPreference.setRecentSearchDataAuction(this, json);
        }
    }

    private final ArrayList<String> getRecentSearchData() {
        Gson gson = new Gson();
        boolean z = false;
        if (this.isFromFindVehiclePage || Intrinsics.areEqual((Object) this.isFromSearchByVehicle, (Object) true)) {
            String recentSearchDataVehicles = IAASharedPreference.getRecentSearchDataVehicles(this);
            Intrinsics.checkExpressionValueIsNotNull(recentSearchDataVehicles, "json");
            if (recentSearchDataVehicles.length() > 0) {
                z = true;
            }
            if (z) {
                Object fromJson = gson.fromJson(recentSearchDataVehicles, new SearchPanelFindVehicleActivity$getRecentSearchData$1().getType());
                Intrinsics.checkExpressionValueIsNotNull(fromJson, "gson.fromJson(json, obje…<List<String>>() {}.type)");
                this.recentSearchListVehicles = (ArrayList) fromJson;
            }
            return this.recentSearchListVehicles;
        }
        String recentSearchDataAuction = IAASharedPreference.getRecentSearchDataAuction(this);
        Intrinsics.checkExpressionValueIsNotNull(recentSearchDataAuction, "json");
        if (recentSearchDataAuction.length() > 0) {
            z = true;
        }
        if (z) {
            Object fromJson2 = gson.fromJson(recentSearchDataAuction, new SearchPanelFindVehicleActivity$getRecentSearchData$2().getType());
            Intrinsics.checkExpressionValueIsNotNull(fromJson2, "gson.fromJson(json, obje…<List<String>>() {}.type)");
            this.recentSearchListAuctions = (ArrayList) fromJson2;
        }
        return this.recentSearchListAuctions;
    }

    private final ArrayList<String> saveRecentInPref(ArrayList<String> arrayList, String str) {
        if (arrayList.size() == 0) {
            arrayList.add(str);
        } else if (arrayList.contains(str)) {
            int indexOf = arrayList.indexOf(str);
            if (indexOf != -1) {
                arrayList.remove(indexOf);
            }
            arrayList.add(0, str);
        } else if (arrayList.size() < 3) {
            arrayList.add(0, str);
        } else {
            arrayList.remove(2);
            arrayList.add(0, str);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final void performSearch() {
        hideSoftKeyboard();
        EditText editText = (EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search);
        Intrinsics.checkExpressionValueIsNotNull(editText, "new_keyword_search");
        boolean z = true;
        if (editText.getText().toString().length() > 0) {
            if (this.isFromFindVehiclePage || Intrinsics.areEqual((Object) this.isFromSearchByVehicle, (Object) true)) {
                this.recentSearchListVehicles = getRecentSearchData();
            } else {
                this.recentSearchListAuctions = getRecentSearchData();
            }
            EditText editText2 = (EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search);
            Intrinsics.checkExpressionValueIsNotNull(editText2, "new_keyword_search");
            setRecentSearchData(editText2.getText().toString());
        }
        if (Intrinsics.areEqual((Object) this.isFromFilterPage, (Object) true)) {
            if (this.isFromFindVehiclePage || Intrinsics.areEqual((Object) this.isFromSearchByVehicle, (Object) true)) {
                Intent intent = new Intent();
                EditText editText3 = (EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search);
                Intrinsics.checkExpressionValueIsNotNull(editText3, "new_keyword_search");
                intent.putExtra(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY, editText3.getText().toString());
                setResult(104, intent);
                finish();
                return;
            }
            Intent intent2 = new Intent(getApplicationContext(), BDTAuctionMainListActivity.class);
            EditText editText4 = (EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search);
            Intrinsics.checkExpressionValueIsNotNull(editText4, "new_keyword_search");
            intent2.putExtra(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY, editText4.getText().toString());
            startActivity(intent2);
        } else if (Intrinsics.areEqual((Object) this.isFromSearchByVehicle, (Object) true)) {
            if (IaaiApplication.is_new_fast_Search) {
                Intent intent3 = new Intent(getApplicationContext(), RefinerResultActivity.class);
                EditText editText5 = (EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search);
                Intrinsics.checkExpressionValueIsNotNull(editText5, "new_keyword_search");
                FacetXX facetXX = new FacetXX(0, editText5.getText().toString(), "keyword", true);
                ArrayList arrayList = new ArrayList();
                arrayList.add(facetXX);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(new SelectedRefinerIndicesModel(4, 0, "keyword".hashCode()));
                intent3.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_FACETS, arrayList);
                intent3.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_INDICES, arrayList2);
                intent3.putExtra(Constants_MVVM.EXTRA_IS_FROM_LANDING_PAGE_SEARCH, true);
                startActivity(intent3);
                return;
            }
            Intent intent4 = new Intent(getApplicationContext(), SearchResultActivity.class);
            EditText editText6 = (EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search);
            Intrinsics.checkExpressionValueIsNotNull(editText6, "new_keyword_search");
            intent4.putExtra(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY, editText6.getText().toString());
            intent4.putExtra(Constants_MVVM.EXTRA_IS_FROM_FIND_VEHICLE_PAGE, this.isFromFindVehiclePage);
            if (getIntent().hasExtra(Constants_MVVM.EXTRA_SELECTED_FILTER_DATA)) {
                ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_FILTER_DATA);
                if (parcelableArrayListExtra != null) {
                    intent4.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_FILTER_DATA, parcelableArrayListExtra);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.iaai.android.bdt.model.fastSearch.SelectedRefiner> /* = java.util.ArrayList<com.iaai.android.bdt.model.fastSearch.SelectedRefiner> */");
                }
            } else {
                EditText editText7 = (EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search);
                Intrinsics.checkExpressionValueIsNotNull(editText7, "new_keyword_search");
                if (editText7.getText().toString().length() <= 0) {
                    z = false;
                }
                if (z) {
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    EditText editText8 = (EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search);
                    Intrinsics.checkExpressionValueIsNotNull(editText8, "new_keyword_search");
                    arrayList4.add(editText8.getText().toString());
                    arrayList3.add(new SelectedRefinerV2("RefinerSearch", arrayList4, false, 4, (DefaultConstructorMarker) null));
                    intent4.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_FILTER_DATA, arrayList3);
                }
            }
            if (getIntent().hasExtra(Constants_MVVM.EXTRA_MAKE_MODEL_GROUP_POSITION)) {
                intent4.putExtra(Constants_MVVM.EXTRA_MAKE_MODEL_GROUP_POSITION, getIntent().getIntExtra(Constants_MVVM.EXTRA_MAKE_MODEL_GROUP_POSITION, 0));
            }
            startActivityForResult(intent4, 103);
        } else if (this.isFromAuctionSearch) {
            Intent intent5 = new Intent();
            EditText editText9 = (EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search);
            Intrinsics.checkExpressionValueIsNotNull(editText9, "new_keyword_search");
            intent5.putExtra(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY, editText9.getText().toString());
            setResult(104, intent5);
            finish();
        } else {
            Intent intent6 = new Intent(getApplicationContext(), BDTAuctionMainListActivity.class);
            EditText editText10 = (EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search);
            Intrinsics.checkExpressionValueIsNotNull(editText10, "new_keyword_search");
            intent6.putExtra(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY, editText10.getText().toString());
            startActivity(intent6);
        }
    }
}
