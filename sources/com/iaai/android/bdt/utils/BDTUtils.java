package com.iaai.android.bdt.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.gson.Gson;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.model.fastSearchFilter2.FacetXX;
import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchResponse2;
import com.iaai.android.bdt.model.fastSearchFilter2.Refiner;
import com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray;
import com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingGroup;
import com.iaai.android.bdt.model.filter.MakeModelValues;
import com.iaai.android.bdt.model.sort.SortOptionData;
import com.iaai.android.bdt.model.toBePaid.getDeliveryMethod.Address;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020+J\u0018\u00101\u001a\u00020+2\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010+J\u000e\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020\u001bJ\u0016\u00107\u001a\u00020+2\u0006\u00108\u001a\u00020+2\u0006\u00109\u001a\u00020:J\u001e\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010\u0007J\u0016\u0010>\u001a\u00020+2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BJ\u000e\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u001bJ\u0016\u0010F\u001a\u00020D2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JJ\u0006\u0010K\u001a\u00020DJ\u000e\u0010L\u001a\u00020+2\u0006\u0010M\u001a\u00020\u001bJ\u001a\u0010N\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+0<2\u0006\u0010=\u001a\u00020\u0007J\u0016\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u001b2\u0006\u0010R\u001a\u00020\u001bJ(\u0010S\u001a\u00020T2\u0006\u0010?\u001a\u00020@2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010U\u001a\u00020.2\u0006\u0010V\u001a\u00020\u001bJ(\u0010W\u001a\u00020T2\u0006\u0010?\u001a\u00020@2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010V\u001a\u00020\u001b2\u0006\u0010X\u001a\u00020.J\u0010\u0010Y\u001a\u00020Z2\b\u0010=\u001a\u0004\u0018\u00010\u0007J\"\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020\\0<2\u0006\u0010]\u001a\u00020\\2\u0006\u0010^\u001a\u00020\\J\u0016\u0010_\u001a\u00020+2\u0006\u0010`\u001a\u00020+2\u0006\u00109\u001a\u00020:J\u0018\u0010a\u001a\u00020\u001b2\u0006\u0010G\u001a\u00020H2\u0006\u0010b\u001a\u00020\u000fH\u0002J\u0016\u0010c\u001a\u00020D2\u0006\u0010G\u001a\u00020H2\u0006\u0010d\u001a\u00020JJ(\u0010e\u001a\u00020D2\u0006\u0010E\u001a\u00020\u001b2\u0006\u0010f\u001a\u00020\u001b2\u0006\u0010g\u001a\u00020\u001b2\b\u0010=\u001a\u0004\u0018\u00010\u0007J(\u0010h\u001a\u00020D2\u0006\u0010E\u001a\u00020\u001b2\u0006\u0010f\u001a\u00020\u001b2\u0006\u0010g\u001a\u00020\u001b2\b\u0010=\u001a\u0004\u0018\u00010\u0007J&\u0010i\u001a\u00020D2\u0006\u0010E\u001a\u00020\u001b2\u0006\u0010f\u001a\u00020\u001b2\u0006\u0010g\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u0007J\u0010\u0010j\u001a\u00020D2\b\u0010k\u001a\u0004\u0018\u00010\u0007J&\u0010l\u001a\u00020m2\u0006\u0010E\u001a\u00020\u001b2\u0006\u0010f\u001a\u00020\u001b2\u0006\u0010g\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fRB\u0010\r\u001a*\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00100\u000ej\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0010`\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015RB\u0010\u0016\u001a*\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00100\u000ej\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0010`\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R2\u0010\u0019\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\n\"\u0004\b\u001d\u0010\fR\"\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\n\"\u0004\b \u0010\fR*\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\n\"\u0004\b#\u0010\fR \u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\n\"\u0004\b'\u0010\f¨\u0006n"}, mo66933d2 = {"Lcom/iaai/android/bdt/utils/BDTUtils;", "", "()V", "EPOCH_TICKS", "", "auctionDateFromQL", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FacetXX;", "Lkotlin/collections/ArrayList;", "getAuctionDateFromQL", "()Ljava/util/ArrayList;", "setAuctionDateFromQL", "(Ljava/util/ArrayList;)V", "expandableListDetail", "Ljava/util/LinkedHashMap;", "Lcom/iaai/android/bdt/model/fastSearchFilter2/SearchMappingGroup;", "", "Lkotlin/collections/LinkedHashMap;", "getExpandableListDetail", "()Ljava/util/LinkedHashMap;", "setExpandableListDetail", "(Ljava/util/LinkedHashMap;)V", "expandableListDetailPC", "getExpandableListDetailPC", "setExpandableListDetailPC", "globalIndicesList", "Lkotlin/Triple;", "", "getGlobalIndicesList", "setGlobalIndicesList", "globalItemList", "getGlobalItemList", "setGlobalItemList", "popularCategories", "getPopularCategories", "setPopularCategories", "searchMappingArray", "Lcom/iaai/android/bdt/model/fastSearchFilter2/SearchMappingArray;", "getSearchMappingArray", "setSearchMappingArray", "createToBePaidSortOptions", "Lcom/iaai/android/bdt/model/sort/SortOptionData;", "displayText", "", "position", "isSelected", "", "getActualValue", "value", "getAddress", "address", "Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/Address;", "name", "getCountDisplay", "count", "getDisplayName", "parent_displayName", "resources", "Landroid/content/res/Resources;", "getDistance", "Lkotlin/Pair;", "facetXX", "getErrorType", "context", "Landroid/content/Context;", "errorType", "Lcom/iaai/android/bdt/base/BaseFragment$ErrorType;", "getFilterData", "", "tabPosition", "getFilterMapping", "activity", "Landroid/app/Activity;", "fastSearchResponse", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchResponse2;", "getFilterPopularCategories", "getFormattedNumber", "number", "getMakeModel", "getNearestValueToStep", "", "userInput", "stepsize", "getRadioButton", "Landroid/widget/RadioButton;", "isAddress", "id", "getRadioButtonForFilter", "isChecked", "getSearchesObj", "Lcom/iaai/android/bdt/model/fastSearchFilter2/Searche;", "getTotalInclusiveOfCDF", "", "amount", "cdfFee", "showDisplayNameForPopularRefiner", "displayValue", "updateCustomFilterMapping", "searchMappingGroup", "updateFacetJson", "fastSearchResponse2", "updateGlobalFilterFromSS", "groupPos", "childPos", "updateGlobalFilterMapping", "updateGlobalFilterMappingForDistance", "updateGlobalPopularCategoryMapping", "item", "updateMappingForMakeModel", "Lcom/iaai/android/bdt/model/filter/MakeModelValues;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BDTUtils.kt */
public final class BDTUtils {
    private static final long EPOCH_TICKS = 621355968000000000L;
    public static final BDTUtils INSTANCE = new BDTUtils();
    @NotNull
    private static ArrayList<FacetXX> auctionDateFromQL = new ArrayList<>();
    @NotNull
    public static LinkedHashMap<SearchMappingGroup, List<FacetXX>> expandableListDetail;
    @NotNull
    public static LinkedHashMap<SearchMappingGroup, List<FacetXX>> expandableListDetailPC;
    @NotNull
    private static ArrayList<Triple<Integer, Integer, Integer>> globalIndicesList = new ArrayList<>();
    @NotNull
    private static ArrayList<FacetXX> globalItemList = new ArrayList<>();
    @NotNull
    private static ArrayList<FacetXX> popularCategories = new ArrayList<>();
    @NotNull
    private static ArrayList<SearchMappingArray> searchMappingArray = new ArrayList<>();

    private BDTUtils() {
    }

    @NotNull
    public final ArrayList<SearchMappingArray> getSearchMappingArray() {
        return searchMappingArray;
    }

    public final void setSearchMappingArray(@NotNull ArrayList<SearchMappingArray> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        searchMappingArray = arrayList;
    }

    @NotNull
    public final LinkedHashMap<SearchMappingGroup, List<FacetXX>> getExpandableListDetail() {
        LinkedHashMap<SearchMappingGroup, List<FacetXX>> linkedHashMap = expandableListDetail;
        if (linkedHashMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandableListDetail");
        }
        return linkedHashMap;
    }

    public final void setExpandableListDetail(@NotNull LinkedHashMap<SearchMappingGroup, List<FacetXX>> linkedHashMap) {
        Intrinsics.checkParameterIsNotNull(linkedHashMap, "<set-?>");
        expandableListDetail = linkedHashMap;
    }

    @NotNull
    public final LinkedHashMap<SearchMappingGroup, List<FacetXX>> getExpandableListDetailPC() {
        LinkedHashMap<SearchMappingGroup, List<FacetXX>> linkedHashMap = expandableListDetailPC;
        if (linkedHashMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandableListDetailPC");
        }
        return linkedHashMap;
    }

    public final void setExpandableListDetailPC(@NotNull LinkedHashMap<SearchMappingGroup, List<FacetXX>> linkedHashMap) {
        Intrinsics.checkParameterIsNotNull(linkedHashMap, "<set-?>");
        expandableListDetailPC = linkedHashMap;
    }

    @NotNull
    public final ArrayList<FacetXX> getGlobalItemList() {
        return globalItemList;
    }

    public final void setGlobalItemList(@NotNull ArrayList<FacetXX> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        globalItemList = arrayList;
    }

    @NotNull
    public final ArrayList<Triple<Integer, Integer, Integer>> getGlobalIndicesList() {
        return globalIndicesList;
    }

    public final void setGlobalIndicesList(@NotNull ArrayList<Triple<Integer, Integer, Integer>> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        globalIndicesList = arrayList;
    }

    @NotNull
    public final ArrayList<FacetXX> getAuctionDateFromQL() {
        return auctionDateFromQL;
    }

    public final void setAuctionDateFromQL(@NotNull ArrayList<FacetXX> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        auctionDateFromQL = arrayList;
    }

    @NotNull
    public final ArrayList<FacetXX> getPopularCategories() {
        return popularCategories;
    }

    public final void setPopularCategories(@NotNull ArrayList<FacetXX> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        popularCategories = arrayList;
    }

    @NotNull
    public final String getCountDisplay(int i) {
        String valueOf = String.valueOf(i);
        if (51 <= i && 100 >= i) {
            return "50+";
        }
        if (101 <= i && 500 >= i) {
            return "100+";
        }
        return i > 500 ? "500+" : valueOf;
    }

    @NotNull
    public final SortOptionData createToBePaidSortOptions(@NotNull String str, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "displayText");
        switch (i) {
            case 0:
                return new SortOptionData(str, Constants.TO_BE_PAID_SRT_DUE, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
            case 1:
                return new SortOptionData(str, Constants.TO_BE_PAID_SRT_DUE, "0", z);
            case 2:
                return new SortOptionData(str, Constants.TO_BE_PAID_SRT_BRANCH, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
            case 3:
                return new SortOptionData(str, Constants.TO_BE_PAID_SRT_BRANCH, "0", z);
            case 4:
                return new SortOptionData(str, "BidAmount", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
            case 5:
                return new SortOptionData(str, "BidAmount", "0", z);
            case 6:
                return new SortOptionData(str, "DateWon", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
            case 7:
                return new SortOptionData(str, "DateWon", "0", z);
            default:
                return new SortOptionData(str, Constants.TO_BE_PAID_SRT_DUE, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
        }
    }

    @NotNull
    public final Pair<Double, Double> getTotalInclusiveOfCDF(double d, double d2) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        double d3 = (d / 100.0d) * d2;
        String format = decimalFormat.format(d + d3);
        Intrinsics.checkExpressionValueIsNotNull(format, "df.format(totalAmount)");
        Double valueOf = Double.valueOf(Double.parseDouble(format));
        String format2 = decimalFormat.format(d3);
        Intrinsics.checkExpressionValueIsNotNull(format2, "df.format(cdfAmount)");
        return new Pair<>(valueOf, Double.valueOf(Double.parseDouble(format2)));
    }

    @NotNull
    public final String getAddress(@NotNull Address address, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(address, "address");
        CharSequence charSequence = str;
        boolean z = false;
        String str2 = "";
        if (!(charSequence == null || charSequence.length() == 0)) {
            str2 = str2 + str;
        }
        CharSequence address1 = address.getAddress1();
        if (!(address1 == null || address1.length() == 0)) {
            str2 = str2 + "\n" + address.getAddress1();
        }
        CharSequence address2 = address.getAddress2();
        if (!(address2 == null || address2.length() == 0)) {
            str2 = str2 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + address.getAddress2();
        }
        CharSequence city = address.getCity();
        if (!(city == null || city.length() == 0)) {
            str2 = str2 + "\n" + address.getCity();
        }
        CharSequence state = address.getState();
        if (!(state == null || state.length() == 0)) {
            str2 = str2 + ", " + address.getState();
        }
        CharSequence country = address.getCountry();
        if (!(country == null || country.length() == 0)) {
            str2 = str2 + ", " + address.getCountry();
        }
        CharSequence zipCode = address.getZipCode();
        if (zipCode == null || zipCode.length() == 0) {
            z = true;
        }
        if (z) {
            return str2;
        }
        return str2 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + address.getZipCode();
    }

    @NotNull
    public final RadioButton getRadioButton(@NotNull Context context, @Nullable String str, boolean z, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 10, 0, 10);
        RadioButton radioButton = new RadioButton(context);
        radioButton.setId(View.generateViewId());
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            radioButton.setText("");
        } else {
            radioButton.setText(charSequence);
        }
        radioButton.setLayoutParams(layoutParams);
        radioButton.setButtonTintList(new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{16842912}}, new int[]{Color.parseColor("#cccccc"), Color.parseColor("#238723")}));
        radioButton.setTypeface(Typeface.SANS_SERIF, 0);
        radioButton.setTextSize(14.0f);
        radioButton.setTextColor(context.getResources().getColor(C2723R.C2724color.bdt_gray_darker));
        radioButton.setId(i);
        return radioButton;
    }

    @NotNull
    public final RadioButton getRadioButtonForFilter(@NotNull Context context, @Nullable String str, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 14, 0, 14);
        RadioButton radioButton = new RadioButton(context);
        radioButton.setId(View.generateViewId());
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            radioButton.setText("");
        } else {
            radioButton.setText(charSequence);
        }
        radioButton.setLayoutParams(layoutParams);
        radioButton.setButtonTintList(new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{16842912}}, new int[]{Color.parseColor("#cccccc"), Color.parseColor("#238723")}));
        radioButton.setTypeface(Typeface.SANS_SERIF, 0);
        radioButton.setTextSize(14.0f);
        radioButton.setTextColor(context.getResources().getColor(C2723R.C2724color.bdt_gray_darker));
        radioButton.setId(i);
        radioButton.setChecked(z);
        return radioButton;
    }

    public final void getFilterData(int i) {
        expandableListDetail = new LinkedHashMap<>();
        LinkedHashMap<SearchMappingGroup, List<FacetXX>> linkedHashMap = expandableListDetail;
        if (linkedHashMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandableListDetail");
        }
        linkedHashMap.clear();
        if (i == 0) {
            for (SearchMappingGroup searchMappingGroup : searchMappingArray.get(0).getGroups()) {
                LinkedHashMap<SearchMappingGroup, List<FacetXX>> linkedHashMap2 = expandableListDetail;
                if (linkedHashMap2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("expandableListDetail");
                }
                linkedHashMap2.put(searchMappingGroup, searchMappingGroup.getListFacet());
            }
        } else if (i == 1) {
            for (SearchMappingGroup searchMappingGroup2 : searchMappingArray.get(1).getGroups()) {
                LinkedHashMap<SearchMappingGroup, List<FacetXX>> linkedHashMap3 = expandableListDetail;
                if (linkedHashMap3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("expandableListDetail");
                }
                linkedHashMap3.put(searchMappingGroup2, searchMappingGroup2.getListFacet());
            }
        }
    }

    public final void updateGlobalFilterMapping(int i, int i2, int i3, @Nullable FacetXX facetXX) {
        getFilterData(i);
        LinkedHashMap<SearchMappingGroup, List<FacetXX>> linkedHashMap = expandableListDetail;
        if (linkedHashMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandableListDetail");
        }
        List list = linkedHashMap.get(searchMappingArray.get(i).getGroups().get(i2));
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            int i4 = 0;
            for (Object next : list) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                FacetXX facetXX2 = (FacetXX) next;
                if (Intrinsics.areEqual((Object) facetXX != null ? facetXX.getValue() : null, (Object) facetXX2.getValue())) {
                    facetXX2.setSelected(!facetXX2.isSelected());
                }
                arrayList.add(facetXX2);
                i4 = i5;
            }
        }
        LinkedHashMap<SearchMappingGroup, List<FacetXX>> linkedHashMap2 = expandableListDetail;
        if (linkedHashMap2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandableListDetail");
        }
        SearchMappingGroup searchMappingGroup = searchMappingArray.get(i).getGroups().get(i2);
        Intrinsics.checkExpressionValueIsNotNull(searchMappingGroup, "searchMappingArray[tabPosition].groups[groupPos]");
        linkedHashMap2.put(searchMappingGroup, arrayList);
    }

    public final void updateGlobalFilterMappingForDistance(int i, int i2, int i3, @NotNull FacetXX facetXX) {
        String str;
        Intrinsics.checkParameterIsNotNull(facetXX, "facetXX");
        getFilterData(i);
        LinkedHashMap<SearchMappingGroup, List<FacetXX>> linkedHashMap = expandableListDetail;
        if (linkedHashMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandableListDetail");
        }
        List list = linkedHashMap.get(searchMappingArray.get(i).getGroups().get(i2));
        ArrayList arrayList = new ArrayList();
        Pair<Integer, Integer> distance = getDistance(facetXX);
        String valueOf = String.valueOf(distance != null ? distance.getSecond() : null);
        if (Intrinsics.areEqual((Object) valueOf, (Object) "10000")) {
            str = "Nationwide";
        } else {
            str = valueOf + " miles";
        }
        if (list != null) {
            int i4 = 0;
            for (Object next : list) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                FacetXX facetXX2 = (FacetXX) next;
                if (Intrinsics.areEqual((Object) str, (Object) facetXX2.getValue())) {
                    facetXX2.setSelected(!facetXX2.isSelected());
                    arrayList.add(facetXX);
                } else {
                    arrayList.add(facetXX2);
                }
                i4 = i5;
            }
        }
        LinkedHashMap<SearchMappingGroup, List<FacetXX>> linkedHashMap2 = expandableListDetail;
        if (linkedHashMap2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandableListDetail");
        }
        SearchMappingGroup searchMappingGroup = searchMappingArray.get(i).getGroups().get(i2);
        Intrinsics.checkExpressionValueIsNotNull(searchMappingGroup, "searchMappingArray[tabPosition].groups[groupPos]");
        linkedHashMap2.put(searchMappingGroup, arrayList);
        searchMappingArray.get(i).getGroups().get(i2).setListFacet(arrayList);
    }

    @NotNull
    public final MakeModelValues updateMappingForMakeModel(int i, int i2, int i3, @NotNull FacetXX facetXX) {
        Intrinsics.checkParameterIsNotNull(facetXX, "facetXX");
        getFilterData(i);
        LinkedHashMap<SearchMappingGroup, List<FacetXX>> linkedHashMap = expandableListDetail;
        if (linkedHashMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandableListDetail");
        }
        List list = linkedHashMap.get(searchMappingArray.get(i).getGroups().get(i2));
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            int i4 = 0;
            for (Object next : list) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                FacetXX facetXX2 = (FacetXX) next;
                facetXX2.setSelected(true);
                arrayList.add(facetXX2);
                i4 = i5;
            }
        }
        LinkedHashMap<SearchMappingGroup, List<FacetXX>> linkedHashMap2 = expandableListDetail;
        if (linkedHashMap2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandableListDetail");
        }
        SearchMappingGroup searchMappingGroup = searchMappingArray.get(i).getGroups().get(i2);
        Intrinsics.checkExpressionValueIsNotNull(searchMappingGroup, "searchMappingArray[tabPosition].groups[groupPos]");
        linkedHashMap2.put(searchMappingGroup, arrayList);
        searchMappingArray.get(i).getGroups().get(i2).setListFacet(arrayList);
        Pair<String, String> makeModel = getMakeModel(facetXX);
        return new MakeModelValues(makeModel.getSecond(), "", false, new MakeModelValues(makeModel.getFirst(), "", true, (MakeModelValues) null, 0, true), 0, true);
    }

    @NotNull
    public final String getErrorType(@NotNull Context context, @NotNull BaseFragment.ErrorType errorType) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(errorType, "errorType");
        switch (errorType) {
            case NO_INTERNET:
                String string = context.getString(C2723R.string.lbl_msg_no_internet_connection);
                Intrinsics.checkExpressionValueIsNotNull(string, "context.getString(com.ia…g_no_internet_connection)");
                return string;
            case NETWORK_ERROR:
                String string2 = context.getString(C2723R.string.msg_prd_network_error);
                Intrinsics.checkExpressionValueIsNotNull(string2, "context.getString(com.ia…ng.msg_prd_network_error)");
                return string2;
            case NO_STOCKS:
                String string3 = context.getString(C2723R.string.bdt_auction_error_type_no_stock);
                Intrinsics.checkExpressionValueIsNotNull(string3, "context.getString(com.ia…tion_error_type_no_stock)");
                return string3;
            case NO_AUCTION:
                String string4 = context.getString(C2723R.string.bdt_auction_error_type_no_auction);
                Intrinsics.checkExpressionValueIsNotNull(string4, "context.getString(com.ia…on_error_type_no_auction)");
                return string4;
            case NO_VEHICLE_INFO:
                String string5 = context.getString(C2723R.string.bdt_auction_error_type_no_auction);
                Intrinsics.checkExpressionValueIsNotNull(string5, "context.getString(com.ia…on_error_type_no_auction)");
                return string5;
            case NO_SEARCH_RESULT:
                String string6 = context.getString(C2723R.string.bdt_lbl_error_msg_no_item_found);
                Intrinsics.checkExpressionValueIsNotNull(string6, "context.getString(com.ia…_error_msg_no_item_found)");
                return string6;
            default:
                return "";
        }
    }

    public final void updateFacetJson(@NotNull Activity activity, @NotNull FastSearchResponse2 fastSearchResponse2) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(fastSearchResponse2, "fastSearchResponse2");
        if (fastSearchResponse2.getSearch().getResult().getFacets() != null && (!fastSearchResponse2.getSearch().getResult().getFacets().isEmpty())) {
            String json = new Gson().toJson((Object) fastSearchResponse2);
            IaaiApplication.loadNewRefinerFirstTime = false;
            Context context = activity;
            IAASharedPreference.setFacetJson(context, json);
            IAASharedPreference.setNewFacetTimeStamp(context, System.currentTimeMillis());
        }
        auctionDateFromQL.clear();
        int i = 0;
        for (Object next : fastSearchResponse2.getQuickfilters().getRefiners()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Refiner refiner = (Refiner) next;
            if (i == 3 || i == 4 || i == 12 || i == 13) {
                ArrayList<FacetXX> arrayList = auctionDateFromQL;
                String displayName = refiner.getDisplayName();
                arrayList.add(new FacetXX(0, displayName, refiner.getRefinerTypeValue() + '~' + refiner.getRefinerValue(), false));
            }
            i = i2;
        }
        popularCategories.clear();
        int i3 = 0;
        for (Object next2 : fastSearchResponse2.getQuickfilters().getRefiners()) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Refiner refiner2 = (Refiner) next2;
            ArrayList<FacetXX> arrayList2 = popularCategories;
            String displayName2 = refiner2.getDisplayName();
            arrayList2.add(new FacetXX(0, displayName2, refiner2.getRefinerTypeValue() + '~' + refiner2.getRefinerValue(), false));
            i3 = i4;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.util.ArrayList<com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void getFilterMapping(@org.jetbrains.annotations.NotNull android.app.Activity r21, @org.jetbrains.annotations.NotNull com.iaai.android.bdt.model.fastSearchFilter2.FastSearchResponse2 r22) {
        /*
            r20 = this;
            r0 = r21
            java.lang.String r1 = "activity"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r0, r1)
            java.lang.String r1 = "fastSearchResponse"
            r2 = r22
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r1)
            com.google.gson.Gson r1 = new com.google.gson.Gson
            r1.<init>()
            r3 = r0
            android.content.Context r3 = (android.content.Context) r3
            java.lang.String r3 = com.iaai.android.old.utils.IAASharedPreference.getSearchMappingData(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList<com.iaai.android.bdt.model.fastSearchFilter2.FacetXX> r6 = auctionDateFromQL
            r6.clear()
            java.lang.String r6 = "json"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r6)
            r6 = r3
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            r7 = 0
            r8 = 1
            if (r6 <= 0) goto L_0x003b
            r6 = 1
            goto L_0x003c
        L_0x003b:
            r6 = 0
        L_0x003c:
            if (r6 == 0) goto L_0x0053
            com.iaai.android.bdt.utils.BDTUtils$getFilterMapping$1 r4 = new com.iaai.android.bdt.utils.BDTUtils$getFilterMapping$1
            r4.<init>()
            java.lang.reflect.Type r4 = r4.getType()
            java.lang.Object r1 = r1.fromJson((java.lang.String) r3, (java.lang.reflect.Type) r4)
            java.lang.String r3 = "gson.fromJson<ArrayList<…MappingArray>>() {}.type)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
            r4 = r1
            java.util.ArrayList r4 = (java.util.ArrayList) r4
        L_0x0053:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.iaai.android.bdt.model.fastSearchFilter2.Quickfilters r3 = r22.getQuickfilters()
            java.util.List r3 = r3.getRefiners()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
            r6 = 0
        L_0x0067:
            boolean r9 = r3.hasNext()
            java.lang.String r10 = "activity.resources"
            if (r9 == 0) goto L_0x00ea
            java.lang.Object r9 = r3.next()
            int r11 = r6 + 1
            if (r6 >= 0) goto L_0x007a
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x007a:
            com.iaai.android.bdt.model.fastSearchFilter2.Refiner r9 = (com.iaai.android.bdt.model.fastSearchFilter2.Refiner) r9
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r12 = new com.iaai.android.bdt.model.fastSearchFilter2.FacetXX
            com.iaai.android.bdt.utils.BDTUtils r13 = INSTANCE
            java.lang.String r14 = r9.getDisplayName()
            android.content.res.Resources r15 = r21.getResources()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r15, r10)
            java.lang.String r10 = r13.showDisplayNameForPopularRefiner(r14, r15)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = r9.getRefinerTypeValue()
            r13.append(r14)
            r14 = 126(0x7e, float:1.77E-43)
            r13.append(r14)
            java.lang.String r15 = r9.getRefinerValue()
            r13.append(r15)
            java.lang.String r13 = r13.toString()
            r12.<init>(r7, r10, r13, r7)
            r1.add(r12)
            r10 = 3
            if (r6 == r10) goto L_0x00bf
            r10 = 4
            if (r6 == r10) goto L_0x00bf
            r10 = 12
            if (r6 == r10) goto L_0x00bf
            r10 = 13
            if (r6 != r10) goto L_0x00e7
        L_0x00bf:
            java.util.ArrayList<com.iaai.android.bdt.model.fastSearchFilter2.FacetXX> r6 = auctionDateFromQL
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r10 = new com.iaai.android.bdt.model.fastSearchFilter2.FacetXX
            java.lang.String r12 = r9.getDisplayName()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r15 = r9.getRefinerTypeValue()
            r13.append(r15)
            r13.append(r14)
            java.lang.String r9 = r9.getRefinerValue()
            r13.append(r9)
            java.lang.String r9 = r13.toString()
            r10.<init>(r7, r12, r9, r7)
            r6.add(r10)
        L_0x00e7:
            r6 = r11
            goto L_0x0067
        L_0x00ea:
            r3 = r4
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
            r6 = 0
        L_0x00f2:
            boolean r9 = r3.hasNext()
            if (r9 == 0) goto L_0x031b
            java.lang.Object r9 = r3.next()
            int r11 = r6 + 1
            if (r6 >= 0) goto L_0x0103
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0103:
            com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray r9 = (com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray) r9
            java.util.ArrayList r6 = r9.getGroups()
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
            r12 = 0
        L_0x0110:
            boolean r13 = r6.hasNext()
            if (r13 == 0) goto L_0x0305
            java.lang.Object r13 = r6.next()
            int r14 = r12 + 1
            if (r12 >= 0) goto L_0x0121
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0121:
            com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingGroup r13 = (com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingGroup) r13
            java.lang.String r12 = r13.getGroup()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            if (r12 == 0) goto L_0x0134
            int r12 = r12.length()
            if (r12 != 0) goto L_0x0132
            goto L_0x0134
        L_0x0132:
            r12 = 0
            goto L_0x0135
        L_0x0134:
            r12 = 1
        L_0x0135:
            if (r12 == 0) goto L_0x013c
            r5.add(r13)
            goto L_0x02fc
        L_0x013c:
            boolean r12 = r13.getCustom()
            if (r12 == 0) goto L_0x0163
            com.iaai.android.bdt.utils.BDTUtils r12 = INSTANCE
            java.lang.String r15 = r13.getDisplayname()
            android.content.res.Resources r7 = r21.getResources()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r10)
            java.lang.String r7 = r12.getDisplayName(r15, r7)
            r13.setDisplayname(r7)
            com.iaai.android.bdt.utils.BDTUtils r7 = INSTANCE
            int r7 = r7.updateCustomFilterMapping(r0, r13)
            if (r7 > 0) goto L_0x02fc
            r5.add(r13)
            goto L_0x02fc
        L_0x0163:
            java.lang.String r7 = r13.getGroup()
            java.lang.String r12 = "TBOIndicator"
            boolean r7 = kotlin.text.StringsKt.equals(r7, r12, r8)
            if (r7 == 0) goto L_0x01ae
            com.iaai.android.bdt.utils.BDTUtils r7 = INSTANCE
            java.lang.String r15 = r13.getDisplayname()
            android.content.res.Resources r12 = r21.getResources()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r12, r10)
            java.lang.String r7 = r7.getDisplayName(r15, r12)
            r13.setDisplayname(r7)
            r13.setEnabled(r8)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r13.setListFacet(r7)
            android.content.res.Resources r7 = r21.getResources()
            r12 = 2131822210(0x7f110682, float:1.9277185E38)
            java.lang.CharSequence r7 = r7.getText(r12)
            java.lang.String r7 = r7.toString()
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r12 = new com.iaai.android.bdt.model.fastSearchFilter2.FacetXX
            r8 = 0
            r15 = 123(0x7b, float:1.72E-43)
            r12.<init>(r15, r7, r7, r8)
            java.util.ArrayList r7 = r13.getListFacet()
            r7.add(r12)
            goto L_0x02fc
        L_0x01ae:
            java.lang.String r7 = r13.getGroup()
            java.lang.String r8 = "Series"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            r12 = 1
            r7 = r7 ^ r12
            java.lang.String r15 = "BuynowRange"
            if (r7 == 0) goto L_0x01ca
            java.lang.String r7 = r13.getGroup()
            boolean r7 = kotlin.text.StringsKt.equals(r7, r15, r12)
            if (r7 != 0) goto L_0x01ca
            r7 = 1
            goto L_0x01cb
        L_0x01ca:
            r7 = 0
        L_0x01cb:
            r13.setEnabled(r7)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r13.setListFacet(r7)
            com.iaai.android.bdt.utils.BDTUtils r7 = INSTANCE
            java.lang.String r12 = r13.getDisplayname()
            android.content.res.Resources r0 = r21.getResources()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r10)
            java.lang.String r0 = r7.getDisplayName(r12, r0)
            r13.setDisplayname(r0)
            com.iaai.android.bdt.model.fastSearchFilter2.Search r0 = r22.getSearch()
            com.iaai.android.bdt.model.fastSearchFilter2.Result r0 = r0.getResult()
            java.util.List r0 = r0.getFacets()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
            r7 = 0
        L_0x01fd:
            boolean r12 = r0.hasNext()
            if (r12 == 0) goto L_0x02fc
            java.lang.Object r12 = r0.next()
            int r18 = r7 + 1
            if (r7 >= 0) goto L_0x020e
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x020e:
            com.iaai.android.bdt.model.fastSearchFilter2.FacetX r12 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetX) r12
            java.lang.String r7 = r12.getGroup()
            r19 = r0
            java.lang.String r0 = r13.getGroup()
            r2 = 1
            boolean r0 = kotlin.text.StringsKt.equals(r7, r0, r2)
            if (r0 == 0) goto L_0x02f4
            java.util.List r0 = r12.getFacets()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0230
            r5.add(r13)
            goto L_0x02f4
        L_0x0230:
            java.lang.String r0 = r13.getGroup()
            boolean r0 = kotlin.text.StringsKt.equals(r0, r8, r2)
            if (r0 == 0) goto L_0x024b
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r0 = new com.iaai.android.bdt.model.fastSearchFilter2.FacetXX
            r7 = 123(0x7b, float:1.72E-43)
            r12 = 0
            r0.<init>(r7, r8, r8, r12)
            java.util.ArrayList r12 = r13.getListFacet()
            r12.add(r0)
            goto L_0x02f4
        L_0x024b:
            r7 = 123(0x7b, float:1.72E-43)
            java.lang.String r0 = r13.getGroup()
            java.lang.String r7 = "AuctionType"
            boolean r0 = kotlin.text.StringsKt.equals(r0, r7, r2)
            if (r0 == 0) goto L_0x027e
            java.util.List r0 = r12.getFacets()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0263:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x02f4
            java.lang.Object r2 = r0.next()
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r2 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r2
            java.lang.String r7 = r13.getGroup()
            r2.setRefinerValue(r7)
            java.util.ArrayList r7 = r13.getListFacet()
            r7.add(r2)
            goto L_0x0263
        L_0x027e:
            java.lang.String r0 = r13.getGroup()
            r2 = 1
            boolean r0 = kotlin.text.StringsKt.equals(r0, r15, r2)
            if (r0 == 0) goto L_0x02ae
            java.util.List r0 = r12.getFacets()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0293:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x02f4
            java.lang.Object r2 = r0.next()
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r2 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r2
            java.lang.String r7 = r13.getGroup()
            r2.setRefinerValue(r7)
            java.util.ArrayList r7 = r13.getListFacet()
            r7.add(r2)
            goto L_0x0293
        L_0x02ae:
            java.util.List r0 = r12.getFacets()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x02b8:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x02d3
            java.lang.Object r2 = r0.next()
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r2 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r2
            java.lang.String r7 = r13.getGroup()
            r2.setRefinerValue(r7)
            java.util.ArrayList r7 = r13.getListFacet()
            r7.add(r2)
            goto L_0x02b8
        L_0x02d3:
            java.util.ArrayList r0 = r13.getListFacet()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            com.iaai.android.bdt.utils.BDTUtils$$special$$inlined$sortedBy$1 r2 = new com.iaai.android.bdt.utils.BDTUtils$$special$$inlined$sortedBy$1
            r2.<init>()
            java.util.Comparator r2 = (java.util.Comparator) r2
            java.util.List r0 = kotlin.collections.CollectionsKt.sortedWith(r0, r2)
            java.util.ArrayList r2 = r13.getListFacet()
            r2.clear()
            java.util.ArrayList r2 = r13.getListFacet()
            java.util.Collection r0 = (java.util.Collection) r0
            r2.addAll(r0)
        L_0x02f4:
            r2 = r22
            r7 = r18
            r0 = r19
            goto L_0x01fd
        L_0x02fc:
            r0 = r21
            r2 = r22
            r12 = r14
            r7 = 0
            r8 = 1
            goto L_0x0110
        L_0x0305:
            java.util.ArrayList r0 = r9.getGroups()
            r2 = r5
            java.util.Collection r2 = (java.util.Collection) r2
            r0.removeAll(r2)
            r5.clear()
            r0 = r21
            r2 = r22
            r6 = r11
            r7 = 0
            r8 = 1
            goto L_0x00f2
        L_0x031b:
            com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray r0 = new com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray
            r2 = 1
            com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingGroup[] r3 = new com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingGroup[r2]
            com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingGroup r5 = new com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingGroup
            r12 = 0
            r6 = 0
            java.lang.Integer r14 = java.lang.Integer.valueOf(r6)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r2)
            r16 = 0
            r18 = 0
            r19 = 0
            java.lang.String r10 = "QuickLinkCategories"
            java.lang.String r11 = "QuickLinkCategories"
            java.lang.String r13 = "radio"
            r9 = r5
            r17 = r1
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r1 = 0
            r3[r1] = r5
            java.util.ArrayList r1 = kotlin.collections.CollectionsKt.arrayListOf(r3)
            java.lang.String r2 = "Quick Filter"
            r0.<init>(r2, r1)
            r4.add(r0)
            searchMappingArray = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.utils.BDTUtils.getFilterMapping(android.app.Activity, com.iaai.android.bdt.model.fastSearchFilter2.FastSearchResponse2):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int updateCustomFilterMapping(android.app.Activity r17, com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingGroup r18) {
        /*
            r16 = this;
            r0 = r18
            r1 = 1
            r0.setEnabled(r1)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r0.setListFacet(r2)
            java.lang.String r2 = r18.getGroup()
            java.lang.String r3 = "Odometer"
            boolean r2 = kotlin.text.StringsKt.equals(r2, r3, r1)
            r3 = 123(0x7b, float:1.72E-43)
            r4 = 0
            if (r2 == 0) goto L_0x0033
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r1 = new com.iaai.android.bdt.model.fastSearchFilter2.FacetXX
            java.lang.String r2 = r18.getGroup()
            java.lang.String r5 = r18.getGroup()
            r1.<init>(r3, r2, r5, r4)
            java.util.ArrayList r2 = r18.getListFacet()
            r2.add(r1)
            goto L_0x01a4
        L_0x0033:
            java.lang.String r2 = r18.getGroup()
            java.lang.String r5 = "ACV"
            boolean r2 = kotlin.text.StringsKt.equals(r2, r5, r1)
            if (r2 == 0) goto L_0x0055
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r1 = new com.iaai.android.bdt.model.fastSearchFilter2.FacetXX
            java.lang.String r2 = r18.getGroup()
            java.lang.String r5 = r18.getGroup()
            r1.<init>(r3, r2, r5, r4)
            java.util.ArrayList r2 = r18.getListFacet()
            r2.add(r1)
            goto L_0x01a4
        L_0x0055:
            java.lang.String r2 = r18.getGroup()
            java.lang.String r5 = "Cddate"
            boolean r2 = kotlin.text.StringsKt.equals(r2, r5, r1)
            if (r2 == 0) goto L_0x008a
            android.content.res.Resources r1 = r17.getResources()
            r2 = 2130903057(0x7f030011, float:1.7412921E38)
            java.lang.String[] r1 = r1.getStringArray(r2)
            java.lang.String r2 = "activity.resources.getSt…ay.new_inventory_refiner)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            int r2 = r1.length
            r5 = 0
        L_0x0073:
            if (r5 >= r2) goto L_0x01a4
            r6 = r1[r5]
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r7 = new com.iaai.android.bdt.model.fastSearchFilter2.FacetXX
            java.lang.String r8 = r18.getGroup()
            r7.<init>(r3, r6, r8, r4)
            java.util.ArrayList r6 = r18.getListFacet()
            r6.add(r7)
            int r5 = r5 + 1
            goto L_0x0073
        L_0x008a:
            java.lang.String r2 = r18.getGroup()
            java.lang.String r5 = "LiveDateTime"
            boolean r2 = kotlin.text.StringsKt.equals(r2, r5, r1)
            if (r2 == 0) goto L_0x015b
            java.util.ArrayList<com.iaai.android.bdt.model.fastSearchFilter2.FacetXX> r2 = auctionDateFromQL
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
            r3 = 0
        L_0x009f:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x01a4
            java.lang.Object r5 = r2.next()
            int r6 = r3 + 1
            if (r3 >= 0) goto L_0x00b0
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x00b0:
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r5 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r5
            if (r3 == 0) goto L_0x00c0
            if (r3 != r1) goto L_0x00b7
            goto L_0x00c0
        L_0x00b7:
            java.util.ArrayList r3 = r18.getListFacet()
            r3.add(r5)
            goto L_0x0158
        L_0x00c0:
            java.lang.String r3 = r5.getValue()
            r7 = r3
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            java.lang.String r3 = " "
            java.lang.String[] r8 = new java.lang.String[]{r3}
            r9 = 0
            r10 = 0
            r11 = 6
            r12 = 0
            java.util.List r3 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r7, (java.lang.String[]) r8, (boolean) r9, (int) r10, (int) r11, (java.lang.Object) r12)
            java.lang.String r7 = r5.getRefinerValue()
            java.lang.String r8 = ", "
            r9 = 0
            if (r7 == 0) goto L_0x00ee
            r10 = r7
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            java.lang.String[] r11 = new java.lang.String[]{r8}
            r12 = 0
            r13 = 0
            r14 = 6
            r15 = 0
            java.util.List r7 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r10, (java.lang.String[]) r11, (boolean) r12, (int) r13, (int) r14, (java.lang.Object) r15)
            goto L_0x00ef
        L_0x00ee:
            r7 = r9
        L_0x00ef:
            int r10 = r3.size()
            if (r10 != r1) goto L_0x0127
            java.util.ArrayList r10 = r18.getListFacet()
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r11 = new com.iaai.android.bdt.model.fastSearchFilter2.FacetXX
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.Object r3 = r3.get(r4)
            java.lang.String r3 = (java.lang.String) r3
            r12.append(r3)
            r12.append(r8)
            if (r7 == 0) goto L_0x0115
            java.lang.Object r3 = r7.get(r1)
            r9 = r3
            java.lang.String r9 = (java.lang.String) r9
        L_0x0115:
            r12.append(r9)
            java.lang.String r3 = r12.toString()
            java.lang.String r5 = r5.getRefinerValue()
            r11.<init>(r4, r3, r5, r4)
            r10.add(r11)
            goto L_0x0158
        L_0x0127:
            java.util.ArrayList r10 = r18.getListFacet()
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r11 = new com.iaai.android.bdt.model.fastSearchFilter2.FacetXX
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.Object r3 = r3.get(r1)
            java.lang.String r3 = (java.lang.String) r3
            r12.append(r3)
            r12.append(r8)
            if (r7 == 0) goto L_0x0147
            java.lang.Object r3 = r7.get(r1)
            r9 = r3
            java.lang.String r9 = (java.lang.String) r9
        L_0x0147:
            r12.append(r9)
            java.lang.String r3 = r12.toString()
            java.lang.String r5 = r5.getRefinerValue()
            r11.<init>(r4, r3, r5, r4)
            r10.add(r11)
        L_0x0158:
            r3 = r6
            goto L_0x009f
        L_0x015b:
            java.lang.String r2 = r18.getGroup()
            java.lang.String r5 = "Zip_Miles"
            boolean r2 = kotlin.text.StringsKt.equals(r2, r5, r1)
            if (r2 == 0) goto L_0x018c
            android.content.res.Resources r1 = r17.getResources()
            r2 = 2130903081(0x7f030029, float:1.741297E38)
            java.lang.String[] r1 = r1.getStringArray(r2)
            java.lang.String r2 = "activity.resources.getSt….array.zip_miles_refiner)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            int r2 = r1.length
            r5 = 0
        L_0x0179:
            if (r5 >= r2) goto L_0x01a4
            r6 = r1[r5]
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r7 = new com.iaai.android.bdt.model.fastSearchFilter2.FacetXX
            r7.<init>(r3, r6, r6, r4)
            java.util.ArrayList r6 = r18.getListFacet()
            r6.add(r7)
            int r5 = r5 + 1
            goto L_0x0179
        L_0x018c:
            java.lang.String r2 = r18.getGroup()
            java.lang.String r5 = "year"
            boolean r1 = kotlin.text.StringsKt.equals(r2, r5, r1)
            if (r1 == 0) goto L_0x01a4
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r1 = new com.iaai.android.bdt.model.fastSearchFilter2.FacetXX
            r1.<init>(r3, r5, r5, r4)
            java.util.ArrayList r2 = r18.getListFacet()
            r2.add(r1)
        L_0x01a4:
            java.util.ArrayList r0 = r18.getListFacet()
            int r0 = r0.size()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.utils.BDTUtils.updateCustomFilterMapping(android.app.Activity, com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingGroup):int");
    }

    public final void getFilterPopularCategories() {
        expandableListDetailPC = new LinkedHashMap<>();
        LinkedHashMap<SearchMappingGroup, List<FacetXX>> linkedHashMap = expandableListDetailPC;
        if (linkedHashMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandableListDetailPC");
        }
        linkedHashMap.clear();
        LinkedHashMap<SearchMappingGroup, List<FacetXX>> linkedHashMap2 = expandableListDetailPC;
        if (linkedHashMap2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandableListDetailPC");
        }
        SearchMappingGroup searchMappingGroup = searchMappingArray.get(2).getGroups().get(0);
        Intrinsics.checkExpressionValueIsNotNull(searchMappingGroup, "searchMappingArray[2].groups[0]");
        linkedHashMap2.put(searchMappingGroup, searchMappingArray.get(2).getGroups().get(0).getListFacet());
    }

    public final void updateGlobalPopularCategoryMapping(@Nullable FacetXX facetXX) {
        ArrayList<FacetXX> listFacet = searchMappingArray.get(2).getGroups().get(0).getListFacet();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object next : listFacet) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            FacetXX facetXX2 = (FacetXX) next;
            if (StringsKt.equals(facetXX2.getRefinerValue(), facetXX != null ? facetXX.getRefinerValue() : null, true)) {
                facetXX2.setSelected(!facetXX2.isSelected());
            }
            arrayList.add(facetXX2);
            i = i2;
        }
        LinkedHashMap<SearchMappingGroup, List<FacetXX>> linkedHashMap = expandableListDetailPC;
        if (linkedHashMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandableListDetailPC");
        }
        SearchMappingGroup searchMappingGroup = searchMappingArray.get(2).getGroups().get(0);
        Intrinsics.checkExpressionValueIsNotNull(searchMappingGroup, "searchMappingArray[2].groups[0]");
        linkedHashMap.put(searchMappingGroup, arrayList);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r12 = r12.getRefinerValue();
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.Pair<java.lang.Integer, java.lang.Integer> getDistance(@org.jetbrains.annotations.Nullable com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r12) {
        /*
            r11 = this;
            kotlin.Pair r0 = new kotlin.Pair
            r1 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            r0.<init>(r2, r2)
            r2 = 0
            if (r12 == 0) goto L_0x0025
            java.lang.String r12 = r12.getRefinerValue()
            if (r12 == 0) goto L_0x0025
            r3 = r12
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.String r12 = "~"
            java.lang.String[] r4 = new java.lang.String[]{r12}
            r5 = 0
            r6 = 0
            r7 = 6
            r8 = 0
            java.util.List r12 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r3, (java.lang.String[]) r4, (boolean) r5, (int) r6, (int) r7, (java.lang.Object) r8)
            goto L_0x0026
        L_0x0025:
            r12 = r2
        L_0x0026:
            r3 = r12
            java.util.Collection r3 = (java.util.Collection) r3
            r4 = 1
            if (r3 == 0) goto L_0x0035
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r3 = 0
            goto L_0x0036
        L_0x0035:
            r3 = 1
        L_0x0036:
            if (r3 != 0) goto L_0x008c
            java.lang.Object r3 = r12.get(r4)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = java.lang.Integer.parseInt(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r5 = 2
            kotlin.Pair r0 = kotlin.Pair.copy$default(r0, r3, r2, r5, r2)
            java.lang.Object r12 = r12.get(r5)
            r5 = r12
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.String r12 = " "
            java.lang.String[] r6 = new java.lang.String[]{r12}
            r7 = 0
            r8 = 0
            r9 = 6
            r10 = 0
            java.util.List r12 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r5, (java.lang.String[]) r6, (boolean) r7, (int) r8, (int) r9, (java.lang.Object) r10)
            java.lang.Object r3 = r12.get(r1)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r5 = "Nationwide"
            boolean r3 = kotlin.text.StringsKt.equals(r3, r5, r4)
            if (r3 == 0) goto L_0x0079
            r12 = 10000(0x2710, float:1.4013E-41)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            kotlin.Pair r12 = kotlin.Pair.copy$default(r0, r2, r12, r4, r2)
            goto L_0x008b
        L_0x0079:
            java.lang.Object r12 = r12.get(r1)
            java.lang.String r12 = (java.lang.String) r12
            int r12 = java.lang.Integer.parseInt(r12)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            kotlin.Pair r12 = kotlin.Pair.copy$default(r0, r2, r12, r4, r2)
        L_0x008b:
            r0 = r12
        L_0x008c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.utils.BDTUtils.getDistance(com.iaai.android.bdt.model.fastSearchFilter2.FacetXX):kotlin.Pair");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r22.getRefinerValue();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.iaai.android.bdt.model.fastSearchFilter2.Searche getSearchesObj(@org.jetbrains.annotations.Nullable com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r22) {
        /*
            r21 = this;
            java.lang.String r0 = ""
            if (r22 == 0) goto L_0x000c
            java.lang.String r1 = r22.getRefinerValue()
            if (r1 == 0) goto L_0x000c
            r7 = r1
            goto L_0x000d
        L_0x000c:
            r7 = r0
        L_0x000d:
            if (r22 == 0) goto L_0x0017
            java.lang.String r1 = r22.getValue()
            if (r1 == 0) goto L_0x0017
            r11 = r1
            goto L_0x0018
        L_0x0017:
            r11 = r0
        L_0x0018:
            r0 = 1
            java.lang.String r1 = "Odometer"
            boolean r1 = kotlin.text.StringsKt.equals(r7, r1, r0)
            java.lang.String r2 = "-"
            r8 = 0
            if (r1 == 0) goto L_0x00ae
            r12 = r11
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            java.lang.String r1 = " "
            java.lang.String[] r13 = new java.lang.String[]{r1}
            r14 = 0
            r15 = 0
            r16 = 6
            r17 = 0
            java.util.List r1 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r12, (java.lang.String[]) r13, (boolean) r14, (int) r15, (int) r16, (java.lang.Object) r17)
            java.lang.Object r3 = r1.get(r8)
            r9 = r3
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            java.lang.String[] r10 = new java.lang.String[]{r2}
            r11 = 0
            r12 = 0
            r13 = 6
            r14 = 0
            java.util.List r3 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r9, (java.lang.String[]) r10, (boolean) r11, (int) r12, (int) r13, (java.lang.Object) r14)
            java.lang.Object r3 = r3.get(r8)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r1 = r1.get(r8)
            r9 = r1
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            java.lang.String[] r10 = new java.lang.String[]{r2}
            java.util.List r1 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r9, (java.lang.String[]) r10, (boolean) r11, (int) r12, (int) r13, (java.lang.Object) r14)
            java.lang.Object r1 = r1.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r1)
            if (r2 == 0) goto L_0x008a
            long r1 = java.lang.Long.parseLong(r3)
            com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes r3 = new com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes
            r3.<init>(r7, r1)
            com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes[] r0 = new com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes[r0]
            r0[r8] = r3
            java.util.ArrayList r13 = kotlin.collections.CollectionsKt.arrayListOf(r0)
            com.iaai.android.bdt.model.fastSearchFilter2.Searche r0 = new com.iaai.android.bdt.model.fastSearchFilter2.Searche
            r11 = 0
            r14 = 0
            java.lang.String r10 = ""
            java.lang.String r12 = ""
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14)
            goto L_0x0583
        L_0x008a:
            long r3 = java.lang.Long.parseLong(r3)
            long r5 = java.lang.Long.parseLong(r1)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r1 = new com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData
            r2 = r1
            r2.<init>(r3, r5, r7)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData[] r0 = new com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData[r0]
            r0[r8] = r1
            java.util.ArrayList r7 = kotlin.collections.CollectionsKt.arrayListOf(r0)
            com.iaai.android.bdt.model.fastSearchFilter2.Searche r0 = new com.iaai.android.bdt.model.fastSearchFilter2.Searche
            r4 = 0
            r6 = 0
            java.lang.String r3 = ""
            java.lang.String r5 = ""
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x0583
        L_0x00ae:
            java.lang.String r1 = "ACV"
            boolean r1 = kotlin.text.StringsKt.startsWith(r7, r1, r0)
            java.lang.String r3 = "~"
            if (r1 == 0) goto L_0x0146
            r12 = r7
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            java.lang.String[] r13 = new java.lang.String[]{r3}
            r14 = 0
            r15 = 0
            r16 = 6
            r17 = 0
            java.util.List r1 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r12, (java.lang.String[]) r13, (boolean) r14, (int) r15, (int) r16, (java.lang.Object) r17)
            java.lang.Object r3 = r1.get(r8)
            r14 = r3
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r1 = r1.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String[] r16 = new java.lang.String[]{r2}
            r17 = 0
            r18 = 0
            r19 = 6
            r20 = 0
            r15 = r1
            java.util.List r3 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r15, (java.lang.String[]) r16, (boolean) r17, (int) r18, (int) r19, (java.lang.Object) r20)
            java.lang.Object r3 = r3.get(r8)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String[] r16 = new java.lang.String[]{r2}
            java.util.List r1 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r15, (java.lang.String[]) r16, (boolean) r17, (int) r18, (int) r19, (java.lang.Object) r20)
            java.lang.Object r1 = r1.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r1)
            if (r2 == 0) goto L_0x0122
            long r1 = java.lang.Long.parseLong(r3)
            com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes r3 = new com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes
            r3.<init>(r14, r1)
            com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes[] r0 = new com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes[r0]
            r0[r8] = r3
            java.util.ArrayList r13 = kotlin.collections.CollectionsKt.arrayListOf(r0)
            com.iaai.android.bdt.model.fastSearchFilter2.Searche r0 = new com.iaai.android.bdt.model.fastSearchFilter2.Searche
            r11 = 0
            r14 = 0
            java.lang.String r10 = ""
            java.lang.String r12 = ""
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14)
            goto L_0x0583
        L_0x0122:
            long r10 = java.lang.Long.parseLong(r3)
            long r12 = java.lang.Long.parseLong(r1)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r1 = new com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData
            r9 = r1
            r9.<init>(r10, r12, r14)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData[] r0 = new com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData[r0]
            r0[r8] = r1
            java.util.ArrayList r7 = kotlin.collections.CollectionsKt.arrayListOf(r0)
            com.iaai.android.bdt.model.fastSearchFilter2.Searche r0 = new com.iaai.android.bdt.model.fastSearchFilter2.Searche
            r4 = 0
            r6 = 0
            java.lang.String r3 = ""
            java.lang.String r5 = ""
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x0583
        L_0x0146:
            java.lang.String r1 = "year"
            boolean r1 = kotlin.text.StringsKt.equals(r7, r1, r0)
            if (r1 == 0) goto L_0x01d6
            java.lang.String r1 = "Year:"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String r1 = kotlin.text.StringsKt.removePrefix((java.lang.String) r11, (java.lang.CharSequence) r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String[] r10 = new java.lang.String[]{r2}
            r11 = 0
            r12 = 0
            r13 = 6
            r14 = 0
            r9 = r1
            java.util.List r3 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r9, (java.lang.String[]) r10, (boolean) r11, (int) r12, (int) r13, (java.lang.Object) r14)
            java.lang.Object r3 = r3.get(r8)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String[] r10 = new java.lang.String[]{r2}
            java.util.List r1 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r9, (java.lang.String[]) r10, (boolean) r11, (int) r12, (int) r13, (java.lang.Object) r14)
            java.lang.Object r1 = r1.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r1)
            if (r2 == 0) goto L_0x01a0
            long r1 = java.lang.Long.parseLong(r3)
            com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes r3 = new com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes
            java.lang.String r4 = "Year"
            r3.<init>(r4, r1)
            com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes[] r0 = new com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes[r0]
            r0[r8] = r3
            java.util.ArrayList r13 = kotlin.collections.CollectionsKt.arrayListOf(r0)
            com.iaai.android.bdt.model.fastSearchFilter2.Searche r0 = new com.iaai.android.bdt.model.fastSearchFilter2.Searche
            r11 = 0
            r14 = 0
            java.lang.String r10 = ""
            java.lang.String r12 = ""
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14)
            goto L_0x0583
        L_0x01a0:
            long r9 = java.lang.Long.parseLong(r3)
            long r11 = java.lang.Long.parseLong(r1)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r7 = new com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData
            java.lang.String r6 = "Year"
            r1 = r7
            r2 = r9
            r4 = r11
            r1.<init>(r2, r4, r6)
            int r1 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r1 <= 0) goto L_0x01c0
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r7 = new com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData
            java.lang.String r6 = "Year"
            r1 = r7
            r2 = r11
            r4 = r9
            r1.<init>(r2, r4, r6)
        L_0x01c0:
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData[] r0 = new com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData[r0]
            r0[r8] = r7
            java.util.ArrayList r6 = kotlin.collections.CollectionsKt.arrayListOf(r0)
            com.iaai.android.bdt.model.fastSearchFilter2.Searche r0 = new com.iaai.android.bdt.model.fastSearchFilter2.Searche
            r3 = 0
            r5 = 0
            java.lang.String r2 = ""
            java.lang.String r4 = ""
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x0583
        L_0x01d6:
            java.lang.String r1 = "Cddate"
            boolean r1 = kotlin.text.StringsKt.equals(r7, r1, r0)
            if (r1 == 0) goto L_0x03dd
            java.lang.String r1 = "All"
            boolean r1 = kotlin.text.StringsKt.equals(r11, r1, r0)
            if (r1 == 0) goto L_0x0207
            com.iaai.android.bdt.model.fastSearchFilter2.Searche r1 = new com.iaai.android.bdt.model.fastSearchFilter2.Searche
            com.iaai.android.bdt.model.fastSearchFilter2.Facet[] r0 = new com.iaai.android.bdt.model.fastSearchFilter2.Facet[r0]
            com.iaai.android.bdt.model.fastSearchFilter2.Facet r2 = new com.iaai.android.bdt.model.fastSearchFilter2.Facet
            java.lang.String r3 = "Default"
            java.lang.String r4 = "True"
            r2.<init>(r3, r4)
            r0[r8] = r2
            java.util.ArrayList r14 = kotlin.collections.CollectionsKt.arrayListOf(r0)
            r16 = 0
            r17 = 0
            java.lang.String r13 = ""
            java.lang.String r15 = ""
            r12 = r1
            r12.<init>(r13, r14, r15, r16, r17)
            goto L_0x0471
        L_0x0207:
            java.lang.String r1 = "Last 24 hrs"
            boolean r1 = kotlin.text.StringsKt.equals(r11, r1, r0)
            r2 = 6
            r9 = 32
            java.lang.String r10 = "CDDATE"
            r3 = 10000(0x2710, float:1.4013E-41)
            java.lang.String r4 = "Calendar.getInstance(Constants.TIMEZONE_SERVER)"
            r5 = 621355968000000000(0x89f7ff5f7b58000, double:3.8160345866415605E-267)
            if (r1 == 0) goto L_0x0274
            java.util.TimeZone r1 = com.iaai.android.old.utils.constants.Constants.TIMEZONE_SERVER
            java.util.Calendar r1 = java.util.Calendar.getInstance(r1)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
            long r11 = r1.getTimeInMillis()
            long r3 = (long) r3
            long r11 = r11 * r3
            long r11 = r11 + r5
            r13 = -1
            r1.add(r2, r13)
            long r1 = r1.getTimeInMillis()
            long r1 = r1 * r3
            long r3 = r1 + r5
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r1 = new com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData
            r2 = r1
            r5 = r11
            r2.<init>(r3, r5, r7)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData[] r0 = new com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData[r0]
            r0[r8] = r1
            java.util.ArrayList r7 = kotlin.collections.CollectionsKt.arrayListOf(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            long r2 = r1.getFrom()
            r0.append(r2)
            r0.append(r9)
            long r1 = r1.getTo()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r10, r0)
            com.iaai.android.bdt.model.fastSearchFilter2.Searche r0 = new com.iaai.android.bdt.model.fastSearchFilter2.Searche
            r4 = 0
            r6 = 0
            java.lang.String r3 = ""
            java.lang.String r5 = ""
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x0583
        L_0x0274:
            java.lang.String r1 = "Last 48 hrs"
            boolean r1 = kotlin.text.StringsKt.equals(r11, r1, r0)
            if (r1 == 0) goto L_0x02d3
            java.util.TimeZone r1 = com.iaai.android.old.utils.constants.Constants.TIMEZONE_SERVER
            java.util.Calendar r1 = java.util.Calendar.getInstance(r1)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
            long r11 = r1.getTimeInMillis()
            long r3 = (long) r3
            long r11 = r11 * r3
            long r11 = r11 + r5
            r13 = -2
            r1.add(r2, r13)
            long r1 = r1.getTimeInMillis()
            long r1 = r1 * r3
            long r3 = r1 + r5
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r1 = new com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData
            r2 = r1
            r5 = r11
            r2.<init>(r3, r5, r7)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData[] r0 = new com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData[r0]
            r0[r8] = r1
            java.util.ArrayList r7 = kotlin.collections.CollectionsKt.arrayListOf(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            long r2 = r1.getFrom()
            r0.append(r2)
            r0.append(r9)
            long r1 = r1.getTo()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r10, r0)
            com.iaai.android.bdt.model.fastSearchFilter2.Searche r0 = new com.iaai.android.bdt.model.fastSearchFilter2.Searche
            r4 = 0
            r6 = 0
            java.lang.String r3 = ""
            java.lang.String r5 = ""
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x0583
        L_0x02d3:
            java.lang.String r1 = "Last 7 days"
            boolean r1 = kotlin.text.StringsKt.equals(r11, r1, r0)
            if (r1 == 0) goto L_0x0332
            java.util.TimeZone r1 = com.iaai.android.old.utils.constants.Constants.TIMEZONE_SERVER
            java.util.Calendar r1 = java.util.Calendar.getInstance(r1)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
            long r11 = r1.getTimeInMillis()
            long r3 = (long) r3
            long r11 = r11 * r3
            long r11 = r11 + r5
            r13 = -7
            r1.add(r2, r13)
            long r1 = r1.getTimeInMillis()
            long r1 = r1 * r3
            long r3 = r1 + r5
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r1 = new com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData
            r2 = r1
            r5 = r11
            r2.<init>(r3, r5, r7)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData[] r0 = new com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData[r0]
            r0[r8] = r1
            java.util.ArrayList r7 = kotlin.collections.CollectionsKt.arrayListOf(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            long r2 = r1.getFrom()
            r0.append(r2)
            r0.append(r9)
            long r1 = r1.getTo()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r10, r0)
            com.iaai.android.bdt.model.fastSearchFilter2.Searche r0 = new com.iaai.android.bdt.model.fastSearchFilter2.Searche
            r4 = 0
            r6 = 0
            java.lang.String r3 = ""
            java.lang.String r5 = ""
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x0583
        L_0x0332:
            java.lang.String r1 = "Last 14 days"
            boolean r1 = kotlin.text.StringsKt.equals(r11, r1, r0)
            if (r1 == 0) goto L_0x0392
            java.util.TimeZone r1 = com.iaai.android.old.utils.constants.Constants.TIMEZONE_SERVER
            java.util.Calendar r1 = java.util.Calendar.getInstance(r1)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
            long r11 = r1.getTimeInMillis()
            long r3 = (long) r3
            long r11 = r11 * r3
            long r11 = r11 + r5
            r13 = -14
            r1.add(r2, r13)
            long r1 = r1.getTimeInMillis()
            long r1 = r1 * r3
            long r3 = r1 + r5
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r1 = new com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData
            r2 = r1
            r5 = r11
            r2.<init>(r3, r5, r7)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData[] r0 = new com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData[r0]
            r0[r8] = r1
            java.util.ArrayList r7 = kotlin.collections.CollectionsKt.arrayListOf(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            long r2 = r1.getFrom()
            r0.append(r2)
            r0.append(r9)
            long r1 = r1.getTo()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r10, r0)
            com.iaai.android.bdt.model.fastSearchFilter2.Searche r0 = new com.iaai.android.bdt.model.fastSearchFilter2.Searche
            r4 = 0
            r6 = 0
            java.lang.String r3 = ""
            java.lang.String r5 = ""
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x0583
        L_0x0392:
            java.util.TimeZone r1 = com.iaai.android.old.utils.constants.Constants.TIMEZONE_SERVER
            java.util.Calendar r1 = java.util.Calendar.getInstance(r1)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
            long r1 = r1.getTimeInMillis()
            long r3 = (long) r3
            long r1 = r1 * r3
            long r5 = r5 + r1
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r1 = new com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData
            r2 = r1
            r3 = r5
            r2.<init>(r3, r5, r7)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData[] r0 = new com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData[r0]
            r0[r8] = r1
            java.util.ArrayList r7 = kotlin.collections.CollectionsKt.arrayListOf(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            long r2 = r1.getFrom()
            r0.append(r2)
            r0.append(r9)
            long r1 = r1.getTo()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r10, r0)
            com.iaai.android.bdt.model.fastSearchFilter2.Searche r0 = new com.iaai.android.bdt.model.fastSearchFilter2.Searche
            r4 = 0
            r6 = 0
            java.lang.String r3 = ""
            java.lang.String r5 = ""
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x0583
        L_0x03dd:
            java.lang.String r1 = "LiveDateTime"
            boolean r1 = kotlin.text.StringsKt.startsWith(r7, r1, r0)
            if (r1 == 0) goto L_0x041e
            r12 = r7
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            java.lang.String[] r13 = new java.lang.String[]{r3}
            r14 = 0
            r15 = 0
            r16 = 6
            r17 = 0
            java.util.List r1 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r12, (java.lang.String[]) r13, (boolean) r14, (int) r15, (int) r16, (java.lang.Object) r17)
            java.lang.Object r2 = r1.get(r8)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r1 = r1.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            com.iaai.android.bdt.model.fastSearchFilter2.Searche r3 = new com.iaai.android.bdt.model.fastSearchFilter2.Searche
            com.iaai.android.bdt.model.fastSearchFilter2.Facet[] r0 = new com.iaai.android.bdt.model.fastSearchFilter2.Facet[r0]
            com.iaai.android.bdt.model.fastSearchFilter2.Facet r4 = new com.iaai.android.bdt.model.fastSearchFilter2.Facet
            r4.<init>(r2, r1)
            r0[r8] = r4
            java.util.ArrayList r11 = kotlin.collections.CollectionsKt.arrayListOf(r0)
            r13 = 0
            r14 = 0
            java.lang.String r10 = ""
            java.lang.String r12 = ""
            r9 = r3
            r9.<init>(r10, r11, r12, r13, r14)
            r0 = r3
            goto L_0x0583
        L_0x041e:
            java.lang.String r1 = "keyword"
            boolean r1 = kotlin.text.StringsKt.equals(r7, r1, r0)
            if (r1 == 0) goto L_0x0437
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            r12 = 0
            r13 = 0
            com.iaai.android.bdt.model.fastSearchFilter2.Searche r0 = new com.iaai.android.bdt.model.fastSearchFilter2.Searche
            java.lang.String r9 = ""
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13)
            goto L_0x0583
        L_0x0437:
            java.lang.String r1 = "quicklinks"
            boolean r1 = kotlin.text.StringsKt.startsWith(r7, r1, r0)
            java.lang.String r2 = "QuickLinkCategories"
            if (r1 == 0) goto L_0x0474
            com.iaai.android.bdt.model.fastSearchFilter2.Searche r1 = new com.iaai.android.bdt.model.fastSearchFilter2.Searche
            com.iaai.android.bdt.model.fastSearchFilter2.Facet[] r4 = new com.iaai.android.bdt.model.fastSearchFilter2.Facet[r0]
            com.iaai.android.bdt.model.fastSearchFilter2.Facet r5 = new com.iaai.android.bdt.model.fastSearchFilter2.Facet
            r9 = r7
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            java.lang.String[] r10 = new java.lang.String[]{r3}
            r11 = 0
            r12 = 0
            r13 = 6
            r14 = 0
            java.util.List r3 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r9, (java.lang.String[]) r10, (boolean) r11, (int) r12, (int) r13, (java.lang.Object) r14)
            java.lang.Object r0 = r3.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r5.<init>(r2, r0)
            r4[r8] = r5
            java.util.ArrayList r14 = kotlin.collections.CollectionsKt.arrayListOf(r4)
            r16 = 0
            r17 = 0
            java.lang.String r13 = ""
            java.lang.String r15 = ""
            r12 = r1
            r12.<init>(r13, r14, r15, r16, r17)
        L_0x0471:
            r0 = r1
            goto L_0x0583
        L_0x0474:
            java.lang.String r1 = "AuctionType"
            boolean r1 = kotlin.text.StringsKt.startsWith(r7, r1, r0)
            if (r1 == 0) goto L_0x04ef
            r1 = r7
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String[] r13 = new java.lang.String[]{r3}
            r14 = 0
            r15 = 0
            r16 = 6
            r17 = 0
            r12 = r1
            java.util.List r2 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r12, (java.lang.String[]) r13, (boolean) r14, (int) r15, (int) r16, (java.lang.Object) r17)
            int r2 = r2.size()
            if (r2 != r0) goto L_0x04b0
            com.iaai.android.bdt.model.fastSearchFilter2.Searche r1 = new com.iaai.android.bdt.model.fastSearchFilter2.Searche
            com.iaai.android.bdt.model.fastSearchFilter2.Facet[] r0 = new com.iaai.android.bdt.model.fastSearchFilter2.Facet[r0]
            com.iaai.android.bdt.model.fastSearchFilter2.Facet r2 = new com.iaai.android.bdt.model.fastSearchFilter2.Facet
            r2.<init>(r7, r11)
            r0[r8] = r2
            java.util.ArrayList r14 = kotlin.collections.CollectionsKt.arrayListOf(r0)
            r16 = 0
            r17 = 0
            java.lang.String r13 = ""
            java.lang.String r15 = ""
            r12 = r1
            r12.<init>(r13, r14, r15, r16, r17)
            goto L_0x0471
        L_0x04b0:
            com.iaai.android.bdt.model.fastSearchFilter2.Searche r9 = new com.iaai.android.bdt.model.fastSearchFilter2.Searche
            com.iaai.android.bdt.model.fastSearchFilter2.Facet[] r2 = new com.iaai.android.bdt.model.fastSearchFilter2.Facet[r0]
            com.iaai.android.bdt.model.fastSearchFilter2.Facet r4 = new com.iaai.android.bdt.model.fastSearchFilter2.Facet
            java.lang.String[] r13 = new java.lang.String[]{r3}
            r14 = 0
            r15 = 0
            r16 = 6
            r17 = 0
            r12 = r1
            java.util.List r5 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r12, (java.lang.String[]) r13, (boolean) r14, (int) r15, (int) r16, (java.lang.Object) r17)
            java.lang.Object r5 = r5.get(r8)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String[] r13 = new java.lang.String[]{r3}
            java.util.List r1 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r12, (java.lang.String[]) r13, (boolean) r14, (int) r15, (int) r16, (java.lang.Object) r17)
            java.lang.Object r0 = r1.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r4.<init>(r5, r0)
            r2[r8] = r4
            java.util.ArrayList r4 = kotlin.collections.CollectionsKt.arrayListOf(r2)
            r6 = 0
            r7 = 0
            java.lang.String r3 = ""
            java.lang.String r5 = ""
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7)
        L_0x04ec:
            r0 = r9
            goto L_0x0583
        L_0x04ef:
            boolean r1 = kotlin.text.StringsKt.startsWith(r7, r2, r0)
            if (r1 == 0) goto L_0x0568
            boolean r1 = kotlin.text.StringsKt.equals(r7, r2, r0)
            if (r1 == 0) goto L_0x052a
            java.lang.String r1 = "Buy Now"
            boolean r1 = kotlin.text.StringsKt.equals(r11, r1, r0)
            if (r1 == 0) goto L_0x0506
            java.lang.String r11 = "I-Buy Fast"
            goto L_0x0510
        L_0x0506:
            java.lang.String r1 = "Clear Title"
            boolean r1 = kotlin.text.StringsKt.equals(r11, r1, r0)
            if (r1 == 0) goto L_0x0510
            java.lang.String r11 = "Clean Title Vehicles"
        L_0x0510:
            com.iaai.android.bdt.model.fastSearchFilter2.Searche r9 = new com.iaai.android.bdt.model.fastSearchFilter2.Searche
            com.iaai.android.bdt.model.fastSearchFilter2.Facet[] r0 = new com.iaai.android.bdt.model.fastSearchFilter2.Facet[r0]
            com.iaai.android.bdt.model.fastSearchFilter2.Facet r1 = new com.iaai.android.bdt.model.fastSearchFilter2.Facet
            r1.<init>(r7, r11)
            r0[r8] = r1
            java.util.ArrayList r3 = kotlin.collections.CollectionsKt.arrayListOf(r0)
            r5 = 0
            r6 = 0
            java.lang.String r2 = ""
            java.lang.String r4 = ""
            r1 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x04ec
        L_0x052a:
            com.iaai.android.bdt.model.fastSearchFilter2.Searche r1 = new com.iaai.android.bdt.model.fastSearchFilter2.Searche
            com.iaai.android.bdt.model.fastSearchFilter2.Facet[] r2 = new com.iaai.android.bdt.model.fastSearchFilter2.Facet[r0]
            com.iaai.android.bdt.model.fastSearchFilter2.Facet r4 = new com.iaai.android.bdt.model.fastSearchFilter2.Facet
            r5 = r7
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.String[] r10 = new java.lang.String[]{r3}
            r11 = 0
            r12 = 0
            r13 = 6
            r14 = 0
            r9 = r5
            java.util.List r6 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r9, (java.lang.String[]) r10, (boolean) r11, (int) r12, (int) r13, (java.lang.Object) r14)
            java.lang.Object r6 = r6.get(r8)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String[] r10 = new java.lang.String[]{r3}
            java.util.List r3 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r9, (java.lang.String[]) r10, (boolean) r11, (int) r12, (int) r13, (java.lang.Object) r14)
            java.lang.Object r0 = r3.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r4.<init>(r6, r0)
            r2[r8] = r4
            java.util.ArrayList r12 = kotlin.collections.CollectionsKt.arrayListOf(r2)
            r15 = 0
            java.lang.String r11 = ""
            java.lang.String r13 = ""
            r10 = r1
            r10.<init>(r11, r12, r13, r14, r15)
            goto L_0x0471
        L_0x0568:
            com.iaai.android.bdt.model.fastSearchFilter2.Searche r1 = new com.iaai.android.bdt.model.fastSearchFilter2.Searche
            com.iaai.android.bdt.model.fastSearchFilter2.Facet[] r0 = new com.iaai.android.bdt.model.fastSearchFilter2.Facet[r0]
            com.iaai.android.bdt.model.fastSearchFilter2.Facet r2 = new com.iaai.android.bdt.model.fastSearchFilter2.Facet
            r2.<init>(r7, r11)
            r0[r8] = r2
            java.util.ArrayList r4 = kotlin.collections.CollectionsKt.arrayListOf(r0)
            r6 = 0
            r7 = 0
            java.lang.String r3 = ""
            java.lang.String r5 = ""
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x0471
        L_0x0583:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.utils.BDTUtils.getSearchesObj(com.iaai.android.bdt.model.fastSearchFilter2.FacetXX):com.iaai.android.bdt.model.fastSearchFilter2.Searche");
    }

    @NotNull
    public final String getDisplayName(@NotNull String str, @NotNull Resources resources) {
        Intrinsics.checkParameterIsNotNull(str, "parent_displayName");
        Intrinsics.checkParameterIsNotNull(resources, "resources");
        if (StringsKt.equals(str, "Vehicle Type", true)) {
            String string = resources.getString(C2723R.string.lbl_vehicle_type);
            Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(com.….string.lbl_vehicle_type)");
            return string;
        } else if (StringsKt.equals(str, "Transmission", true)) {
            String string2 = resources.getString(C2723R.string.lbl_tranmission);
            Intrinsics.checkExpressionValueIsNotNull(string2, "resources.getString(com.…R.string.lbl_tranmission)");
            return string2;
        } else if (StringsKt.equals(str, "Loss Type", true)) {
            String string3 = resources.getString(C2723R.string.lbl_loss_type);
            Intrinsics.checkExpressionValueIsNotNull(string3, "resources.getString(com.…d.R.string.lbl_loss_type)");
            return string3;
        } else if (StringsKt.equals(str, "Odometer", true)) {
            String string4 = resources.getString(C2723R.string.odo_meter);
            Intrinsics.checkExpressionValueIsNotNull(string4, "resources.getString(com.…droid.R.string.odo_meter)");
            return string4;
        } else if (StringsKt.equals(str, "State", true)) {
            String string5 = resources.getString(C2723R.string.lbl_state);
            Intrinsics.checkExpressionValueIsNotNull(string5, "resources.getString(com.…droid.R.string.lbl_state)");
            return string5;
        } else if (StringsKt.equals(str, "Buyer Type", true)) {
            String string6 = resources.getString(C2723R.string.lbl_buyer_type);
            Intrinsics.checkExpressionValueIsNotNull(string6, "resources.getString(com.….R.string.lbl_buyer_type)");
            return string6;
        } else if (StringsKt.equals(str, "Automobile Type", true)) {
            String string7 = resources.getString(C2723R.string.lbl_automobile_types);
            Intrinsics.checkExpressionValueIsNotNull(string7, "resources.getString(com.…ing.lbl_automobile_types)");
            return string7;
        } else if (StringsKt.equals(str, "Sale Document", true)) {
            String string8 = resources.getString(C2723R.string.lbl_sale_document);
            Intrinsics.checkExpressionValueIsNotNull(string8, "resources.getString(com.…string.lbl_sale_document)");
            return string8;
        } else if (StringsKt.equals(str, "Primary Damage", true)) {
            String string9 = resources.getString(C2723R.string.lbl_primary_damage);
            Intrinsics.checkExpressionValueIsNotNull(string9, "resources.getString(com.…tring.lbl_primary_damage)");
            return string9;
        } else if (StringsKt.equals(str, "Start Code", true)) {
            String string10 = resources.getString(C2723R.string.lbl_start_code);
            Intrinsics.checkExpressionValueIsNotNull(string10, "resources.getString(com.….R.string.lbl_start_code)");
            return string10;
        } else if (StringsKt.equals(str, "Equipment Type", true)) {
            String string11 = resources.getString(C2723R.string.lbl_equipment_types);
            Intrinsics.checkExpressionValueIsNotNull(string11, "resources.getString(com.…ring.lbl_equipment_types)");
            return string11;
        } else if (StringsKt.equals(str, ExifInterface.TAG_MAKE, true)) {
            String string12 = resources.getString(C2723R.string.lbl_make);
            Intrinsics.checkExpressionValueIsNotNull(string12, "resources.getString(com.…ndroid.R.string.lbl_make)");
            return string12;
        } else if (StringsKt.equals(str, ExifInterface.TAG_MODEL, true)) {
            String string13 = resources.getString(C2723R.string.lbl_model);
            Intrinsics.checkExpressionValueIsNotNull(string13, "resources.getString(com.…droid.R.string.lbl_model)");
            return string13;
        } else if (StringsKt.equals(str, "Interior Color", true)) {
            String string14 = resources.getString(C2723R.string.lbl_interior_color);
            Intrinsics.checkExpressionValueIsNotNull(string14, "resources.getString(com.…tring.lbl_interior_color)");
            return string14;
        } else if (StringsKt.equals(str, "Fuel Type", true)) {
            String string15 = resources.getString(C2723R.string.lbl_fuel_type);
            Intrinsics.checkExpressionValueIsNotNull(string15, "resources.getString(com.…d.R.string.lbl_fuel_type)");
            return string15;
        } else if (StringsKt.equals(str, "Cylinders", true)) {
            String string16 = resources.getString(C2723R.string.cylinders);
            Intrinsics.checkExpressionValueIsNotNull(string16, "resources.getString(com.…droid.R.string.cylinders)");
            return string16;
        } else if (StringsKt.equals(str, "Exterior Color", true)) {
            String string17 = resources.getString(C2723R.string.lbl_exterior_color);
            Intrinsics.checkExpressionValueIsNotNull(string17, "resources.getString(com.…tring.lbl_exterior_color)");
            return string17;
        } else if (StringsKt.equals(str, "Drive Line Type", true)) {
            String string18 = resources.getString(C2723R.string.lbl_drive_line_type);
            Intrinsics.checkExpressionValueIsNotNull(string18, "resources.getString(com.…ring.lbl_drive_line_type)");
            return string18;
        } else if (StringsKt.equals(str, "Country of Origin", true)) {
            String string19 = resources.getString(C2723R.string.lbl_country_of_orign);
            Intrinsics.checkExpressionValueIsNotNull(string19, "resources.getString(com.…ing.lbl_country_of_orign)");
            return string19;
        } else if (StringsKt.equals(str, "Air Bags", true)) {
            String string20 = resources.getString(C2723R.string.lbl_air_bags);
            Intrinsics.checkExpressionValueIsNotNull(string20, "resources.getString(com.…id.R.string.lbl_air_bags)");
            return string20;
        } else if (StringsKt.equals(str, "Key", true)) {
            String string21 = resources.getString(C2723R.string.lbl_key);
            Intrinsics.checkExpressionValueIsNotNull(string21, "resources.getString(com.…android.R.string.lbl_key)");
            return string21;
        } else if (StringsKt.equals(str, Constants.TO_BE_PAID_SRT_BRANCH, true)) {
            String string22 = resources.getString(C2723R.string.lbl_branch_name);
            Intrinsics.checkExpressionValueIsNotNull(string22, "resources.getString(com.…R.string.lbl_branch_name)");
            return string22;
        } else if (StringsKt.equals(str, "Body Style", true)) {
            String string23 = resources.getString(C2723R.string.lbl_body_style);
            Intrinsics.checkExpressionValueIsNotNull(string23, "resources.getString(com.….R.string.lbl_body_style)");
            return string23;
        } else if (StringsKt.equals(str, "Actual Cash Value", true)) {
            String string24 = resources.getString(C2723R.string.lbl_actual_cash);
            Intrinsics.checkExpressionValueIsNotNull(string24, "resources.getString(com.…R.string.lbl_actual_cash)");
            return string24;
        } else if (StringsKt.equals(str, "Price", true)) {
            String string25 = resources.getString(C2723R.string.lbl_srt_price);
            Intrinsics.checkExpressionValueIsNotNull(string25, "resources.getString(com.…d.R.string.lbl_srt_price)");
            return string25;
        } else if (StringsKt.equals(str, "Auction Week", true)) {
            String string26 = resources.getString(C2723R.string.lbl_auction_week);
            Intrinsics.checkExpressionValueIsNotNull(string26, "resources.getString(com.….string.lbl_auction_week)");
            return string26;
        } else if (StringsKt.equals(str, "Auction Day", true)) {
            String string27 = resources.getString(C2723R.string.lbl_auctiona_day);
            Intrinsics.checkExpressionValueIsNotNull(string27, "resources.getString(com.….string.lbl_auctiona_day)");
            return string27;
        } else if (StringsKt.equals(str, "Region", true)) {
            String string28 = resources.getString(C2723R.string.lbl_region);
            Intrinsics.checkExpressionValueIsNotNull(string28, "resources.getString(com.…roid.R.string.lbl_region)");
            return string28;
        } else if (StringsKt.equals(str, "Remarketing Seller", true)) {
            String string29 = resources.getString(C2723R.string.lbl_remarketing);
            Intrinsics.checkExpressionValueIsNotNull(string29, "resources.getString(com.…R.string.lbl_remarketing)");
            return string29;
        } else if (StringsKt.equals(str, "Year", true)) {
            String string30 = resources.getString(C2723R.string.bdt_lbl_year);
            Intrinsics.checkExpressionValueIsNotNull(string30, "resources.getString(com.…id.R.string.bdt_lbl_year)");
            return string30;
        } else if (StringsKt.equals(str, "Make & Model", true)) {
            String string31 = resources.getString(C2723R.string.lbl_bdt_filter_make_model_title);
            Intrinsics.checkExpressionValueIsNotNull(string31, "resources.getString(com.…_filter_make_model_title)");
            return string31;
        } else if (StringsKt.equals(str, "Seller Type", true)) {
            String string32 = resources.getString(C2723R.string.bdt_lbl_filter_seller_type);
            Intrinsics.checkExpressionValueIsNotNull(string32, "resources.getString(com.…t_lbl_filter_seller_type)");
            return string32;
        } else if (StringsKt.equals(str, "Vehicle Assignment", true)) {
            String string33 = resources.getString(C2723R.string.bdt_lbl_filter_vehicle_assigment);
            Intrinsics.checkExpressionValueIsNotNull(string33, "resources.getString(com.…filter_vehicle_assigment)");
            return string33;
        } else if (StringsKt.equals(str, "Assigned Vehicles", true)) {
            String string34 = resources.getString(C2723R.string.lbl_assigned_vehicles);
            Intrinsics.checkExpressionValueIsNotNull(string34, "resources.getString(com.…ng.lbl_assigned_vehicles)");
            return string34;
        } else if (StringsKt.equals(str, "New Inventory", true)) {
            String string35 = resources.getString(C2723R.string.lbl_new_inventory);
            Intrinsics.checkExpressionValueIsNotNull(string35, "resources.getString(com.…string.lbl_new_inventory)");
            return string35;
        } else if (StringsKt.equals(str, "Driveline Type", true)) {
            String string36 = resources.getString(C2723R.string.lbl_driveline_type);
            Intrinsics.checkExpressionValueIsNotNull(string36, "resources.getString(com.…tring.lbl_driveline_type)");
            return string36;
        } else if (StringsKt.equals(str, "Airbags", true)) {
            String string37 = resources.getString(C2723R.string.lbl_Airbags);
            Intrinsics.checkExpressionValueIsNotNull(string37, "resources.getString(com.…oid.R.string.lbl_Airbags)");
            return string37;
        } else if (StringsKt.equals(str, "Damage", true)) {
            String string38 = resources.getString(C2723R.string.lbl_damage);
            Intrinsics.checkExpressionValueIsNotNull(string38, "resources.getString(com.…roid.R.string.lbl_damage)");
            return string38;
        } else if (StringsKt.equals(str, "Keys", true)) {
            String string39 = resources.getString(C2723R.string.lbl_keys);
            Intrinsics.checkExpressionValueIsNotNull(string39, "resources.getString(com.…ndroid.R.string.lbl_keys)");
            return string39;
        } else if (StringsKt.equals(str, "Vehicle Subtype", true)) {
            String string40 = resources.getString(C2723R.string.lbl_vehicle_subtype);
            Intrinsics.checkExpressionValueIsNotNull(string40, "resources.getString(com.…ring.lbl_vehicle_subtype)");
            return string40;
        } else if (StringsKt.equals(str, "Auction Type", true)) {
            String string41 = resources.getString(C2723R.string.lbl_auction_type);
            Intrinsics.checkExpressionValueIsNotNull(string41, "resources.getString(com.….string.lbl_auction_type)");
            return string41;
        } else if (StringsKt.equals(str, "Buy Now Price", true)) {
            String string42 = resources.getString(C2723R.string.bdt_lbl_buy_now_price);
            Intrinsics.checkExpressionValueIsNotNull(string42, "resources.getString(com.…ng.bdt_lbl_buy_now_price)");
            return string42;
        } else if (StringsKt.equals(str, "Distance", true)) {
            String string43 = resources.getString(C2723R.string.lbl_distance);
            Intrinsics.checkExpressionValueIsNotNull(string43, "resources.getString(com.…id.R.string.lbl_distance)");
            return string43;
        } else if (StringsKt.equals(str, "Title Not Yet Available", true)) {
            String string44 = resources.getString(C2723R.string.lbl_title_not_yet_available);
            Intrinsics.checkExpressionValueIsNotNull(string44, "resources.getString(com.…_title_not_yet_available)");
            return string44;
        } else if (StringsKt.equals(str, "Who Can Bid", true)) {
            String string45 = resources.getString(C2723R.string.bdt_lbl_who_can_bid);
            Intrinsics.checkExpressionValueIsNotNull(string45, "resources.getString(com.…ring.bdt_lbl_who_can_bid)");
            return string45;
        } else if (StringsKt.equals(str, "Availability", true)) {
            String string46 = resources.getString(C2723R.string.lbl_availability);
            Intrinsics.checkExpressionValueIsNotNull(string46, "resources.getString(com.….string.lbl_availability)");
            return string46;
        } else if (StringsKt.equals(str, "Market", true)) {
            String string47 = resources.getString(C2723R.string.lbl_fast_market);
            Intrinsics.checkExpressionValueIsNotNull(string47, "resources.getString(com.…R.string.lbl_fast_market)");
            return string47;
        } else if (!StringsKt.equals(str, "Auction Date", true)) {
            return str;
        } else {
            String string48 = resources.getString(C2723R.string.lbl_auction_date);
            Intrinsics.checkExpressionValueIsNotNull(string48, "resources.getString(com.….string.lbl_auction_date)");
            return string48;
        }
    }

    @NotNull
    public final String showDisplayNameForPopularRefiner(@NotNull String str, @NotNull Resources resources) {
        Intrinsics.checkParameterIsNotNull(str, "displayValue");
        Intrinsics.checkParameterIsNotNull(resources, "resources");
        if (StringsKt.equals(str, "Buy Now", true)) {
            String string = resources.getString(C2723R.string.bdt_lbl_buy_now);
            Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(com.…R.string.bdt_lbl_buy_now)");
            return string;
        } else if (StringsKt.equals(str, "Run & Drive", true)) {
            String string2 = resources.getString(C2723R.string.bdt_product_dtl_run_drive);
            Intrinsics.checkExpressionValueIsNotNull(string2, "resources.getString(com.…dt_product_dtl_run_drive)");
            return string2;
        } else if (StringsKt.equals(str, "Clear Title", true)) {
            String string3 = resources.getString(C2723R.string.bdt_refiner_clean_title);
            Intrinsics.checkExpressionValueIsNotNull(string3, "resources.getString(com.….bdt_refiner_clean_title)");
            return string3;
        } else if (StringsKt.equals(str, "Available to the Public", true)) {
            String string4 = resources.getString(C2723R.string.bdt_lbl_available_for_public);
            Intrinsics.checkExpressionValueIsNotNull(string4, "resources.getString(com.…lbl_available_for_public)");
            return string4;
        } else if (StringsKt.equals(str, "Flood/Water", true)) {
            String string5 = resources.getString(C2723R.string.bdt_lbl_flood_water);
            Intrinsics.checkExpressionValueIsNotNull(string5, "resources.getString(com.…ring.bdt_lbl_flood_water)");
            return string5;
        } else if (StringsKt.equals(str, "Repossession", true)) {
            String string6 = resources.getString(C2723R.string.bdt_lbl_repossession);
            Intrinsics.checkExpressionValueIsNotNull(string6, "resources.getString(com.…ing.bdt_lbl_repossession)");
            return string6;
        } else if (StringsKt.equals(str, "Recovered Theft", true)) {
            String string7 = resources.getString(C2723R.string.bdt_lbl_recovered_theft);
            Intrinsics.checkExpressionValueIsNotNull(string7, "resources.getString(com.….bdt_lbl_recovered_theft)");
            return string7;
        } else if (StringsKt.equals(str, "Remarketing", true)) {
            String string8 = resources.getString(C2723R.string.bdt_lbl_marketing);
            Intrinsics.checkExpressionValueIsNotNull(string8, "resources.getString(com.…string.bdt_lbl_marketing)");
            return string8;
        } else if (StringsKt.equals(str, "Today", true)) {
            String string9 = resources.getString(C2723R.string.bdt_lbl_today);
            Intrinsics.checkExpressionValueIsNotNull(string9, "resources.getString(com.…d.R.string.bdt_lbl_today)");
            return string9;
        } else if (StringsKt.equals(str, "Monday", true)) {
            String string10 = resources.getString(C2723R.string.bdt_lbl_monday);
            Intrinsics.checkExpressionValueIsNotNull(string10, "resources.getString(com.….R.string.bdt_lbl_monday)");
            return string10;
        } else if (StringsKt.equals(str, "Specialty", true)) {
            String string11 = resources.getString(C2723R.string.bdt_lbl_speciality);
            Intrinsics.checkExpressionValueIsNotNull(string11, "resources.getString(com.…tring.bdt_lbl_speciality)");
            return string11;
        } else if (StringsKt.equals(str, "Tomorrow", true)) {
            String string12 = resources.getString(C2723R.string.bdt_lbl_tomorrow);
            Intrinsics.checkExpressionValueIsNotNull(string12, "resources.getString(com.….string.bdt_lbl_tomorrow)");
            return string12;
        } else if (StringsKt.equals(str, "This Week", true)) {
            String string13 = resources.getString(C2723R.string.bdt_lbl_this_week);
            Intrinsics.checkExpressionValueIsNotNull(string13, "resources.getString(com.…string.bdt_lbl_this_week)");
            return string13;
        } else if (StringsKt.equals(str, "Next Week", true)) {
            String string14 = resources.getString(C2723R.string.bdt_lbl_next_week);
            Intrinsics.checkExpressionValueIsNotNull(string14, "resources.getString(com.…string.bdt_lbl_next_week)");
            return string14;
        } else if (StringsKt.equals(str, "Timed Auctions", true)) {
            String string15 = resources.getString(C2723R.string.bdt_lbl_timed_auction);
            Intrinsics.checkExpressionValueIsNotNull(string15, "resources.getString(com.…ng.bdt_lbl_timed_auction)");
            return string15;
        } else if (StringsKt.equals(str, "Timed Auction", true)) {
            String string16 = resources.getString(C2723R.string.bdt_lbl_timed_auction);
            Intrinsics.checkExpressionValueIsNotNull(string16, "resources.getString(com.…ng.bdt_lbl_timed_auction)");
            return string16;
        } else if (StringsKt.equals(str, "ACE CA Vehicles", true)) {
            String string17 = resources.getString(C2723R.string.bdt_lbl_ace_ca_vehicles);
            Intrinsics.checkExpressionValueIsNotNull(string17, "resources.getString(com.….bdt_lbl_ace_ca_vehicles)");
            return string17;
        } else if (StringsKt.equals(str, "Auction Today", true)) {
            String string18 = resources.getString(C2723R.string.lbl_auction_today);
            Intrinsics.checkExpressionValueIsNotNull(string18, "resources.getString(com.…string.lbl_auction_today)");
            return string18;
        } else if (StringsKt.equals(str, "Auction Tomorrow", true)) {
            String string19 = resources.getString(C2723R.string.lbl_auction_tomorrow);
            Intrinsics.checkExpressionValueIsNotNull(string19, "resources.getString(com.…ing.lbl_auction_tomorrow)");
            return string19;
        } else if (!StringsKt.equals(str, "Available to Public", true)) {
            return str;
        } else {
            String string20 = resources.getString(C2723R.string.lbl_available_to_public);
            Intrinsics.checkExpressionValueIsNotNull(string20, "resources.getString(com.….lbl_available_to_public)");
            return string20;
        }
    }

    @NotNull
    public final String getActualValue(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "value");
        int hashCode = str.hashCode();
        if (hashCode == 1278259878) {
            return str.equals("Clean Title Vehicles") ? "Clear Title" : str;
        }
        if (hashCode != 2059642586) {
            if (hashCode != 2124286714 || !str.equals("I-Buy Fast")) {
                return str;
            }
        } else if (!str.equals("I-buy Fast")) {
            return str;
        }
        return "Buy Now";
    }

    public final float getNearestValueToStep(int i, int i2) {
        int roundToInt = MathKt.roundToInt((double) (i / i2)) * i2;
        int i3 = i2 + roundToInt;
        if (i - roundToInt > i3 - i) {
            Log.e("ROUND UPPER", String.valueOf(i3));
            return (float) i3;
        }
        Log.e("ROUND LOWER", String.valueOf(roundToInt));
        return (float) roundToInt;
    }

    @NotNull
    public final String getFormattedNumber(int i) {
        NumberFormat instance = NumberFormat.getInstance(Locale.US);
        Intrinsics.checkExpressionValueIsNotNull(instance, "NumberFormat.getInstance(Locale.US)");
        String format = instance.format(Integer.valueOf(i));
        return format != null ? format : "";
    }

    public final void updateGlobalFilterFromSS(int i, int i2, int i3, @Nullable FacetXX facetXX) {
        ArrayList<FacetXX> listFacet = searchMappingArray.get(i).getGroups().get(i2).getListFacet();
        if (facetXX == null) {
            facetXX = new FacetXX(123, "Odometer", "Odometer", false);
        }
        listFacet.set(0, facetXX);
        getFilterData(i);
    }

    @NotNull
    public final Pair<String, String> getMakeModel(@NotNull FacetXX facetXX) {
        List list;
        Intrinsics.checkParameterIsNotNull(facetXX, "facetXX");
        String refinerValue = facetXX.getRefinerValue();
        if (refinerValue != null) {
            list = StringsKt.split$default((CharSequence) refinerValue, new char[]{'~'}, false, 0, 6, (Object) null);
        } else {
            list = null;
        }
        if (list != null && list.size() == 3) {
            return new Pair<>((String) list.get(1), (String) list.get(2));
        }
        if (list == null || list.size() != 2) {
            return new Pair<>("", "");
        }
        return new Pair<>((String) list.get(1), "");
    }
}
