package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.filter.FilterSubValues;
import com.iaai.android.bdt.model.filter.FilterValues;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.NewDateHelper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001?BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012.\u0010\u0007\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\bj\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0005`\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rH\u0016J2\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010!2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\rH\u0016J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\rH\u0016J\b\u0010(\u001a\u00020\rH\u0016J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\rH\u0016J*\u0010*\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010!2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010,\u001a\u00020\u0019H\u0016J\u0018\u0010-\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006J\u000e\u00102\u001a\u00020/2\u0006\u0010\u0012\u001a\u00020\u0013J&\u00103\u001a\u00020/2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\r2\u0006\u00107\u001a\u00020\r2\u0006\u00108\u001a\u00020\u0006J&\u00109\u001a\u00020/2\u0006\u0010:\u001a\u0002052\u0006\u00106\u001a\u00020\r2\u0006\u00107\u001a\u00020\r2\u0006\u0010;\u001a\u00020\u0006J(\u0010<\u001a\u00020/2\u0006\u00106\u001a\u00020\r2\u0006\u00107\u001a\u00020\r2\u0006\u0010=\u001a\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R6\u0010\u0007\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\bj\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0005`\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006@"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/filter/FilterListExpandableListAdapter;", "Landroid/widget/BaseExpandableListAdapter;", "context", "Landroid/content/Context;", "expandableListTitle", "", "", "expandableListDetail", "Ljava/util/LinkedHashMap;", "Lcom/iaai/android/bdt/model/filter/FilterValues;", "Lkotlin/collections/LinkedHashMap;", "(Landroid/content/Context;Ljava/util/List;Ljava/util/LinkedHashMap;)V", "groupPosition", "", "getGroupPosition", "()I", "setGroupPosition", "(I)V", "onItemClickListener", "Lcom/iaai/android/bdt/feature/findVehiclePage/filter/FilterListExpandableListAdapter$OnFilterItemClickListener;", "getOnItemClickListener", "()Lcom/iaai/android/bdt/feature/findVehiclePage/filter/FilterListExpandableListAdapter$OnFilterItemClickListener;", "setOnItemClickListener", "(Lcom/iaai/android/bdt/feature/findVehiclePage/filter/FilterListExpandableListAdapter$OnFilterItemClickListener;)V", "areAllItemsEnabled", "", "getChild", "", "listPosition", "expandedListPosition", "getChildId", "", "getChildView", "Landroid/view/View;", "isLastChild", "convertView", "parent", "Landroid/view/ViewGroup;", "getChildrenCount", "getGroup", "getGroupCount", "getGroupId", "getGroupView", "isExpanded", "hasStableIds", "isChildSelectable", "onClickRemoveFilter", "", "filterTitle", "refinerValue", "setClickListenter", "setYearEndDate", "etFilterEndYear", "Landroid/widget/TextView;", "groupPos", "childPos", "startYear", "setYearStartDate", "etFilterStartYear", "endYear", "updateListOnSelectItem", "year", "filterCount", "OnFilterItemClickListener", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FilterListExpandableListAdapter.kt */
public final class FilterListExpandableListAdapter extends BaseExpandableListAdapter {
    private final Context context;
    private final LinkedHashMap<String, List<FilterValues>> expandableListDetail;
    private final List<String> expandableListTitle;
    private int groupPosition = -1;
    @NotNull
    public OnFilterItemClickListener onItemClickListener;

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/filter/FilterListExpandableListAdapter$OnFilterItemClickListener;", "", "onChildItemClick", "", "parentPosition", "", "childPosition", "year", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: FilterListExpandableListAdapter.kt */
    public interface OnFilterItemClickListener {
        void onChildItemClick(int i, int i2, @NotNull String str);
    }

    public boolean areAllItemsEnabled() {
        return true;
    }

    public long getChildId(int i, int i2) {
        return (long) i2;
    }

    public long getGroupId(int i) {
        return (long) i;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    public FilterListExpandableListAdapter(@NotNull Context context2, @NotNull List<String> list, @NotNull LinkedHashMap<String, List<FilterValues>> linkedHashMap) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(list, "expandableListTitle");
        Intrinsics.checkParameterIsNotNull(linkedHashMap, "expandableListDetail");
        this.context = context2;
        this.expandableListTitle = list;
        this.expandableListDetail = linkedHashMap;
    }

    @NotNull
    public final OnFilterItemClickListener getOnItemClickListener() {
        OnFilterItemClickListener onFilterItemClickListener = this.onItemClickListener;
        if (onFilterItemClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onItemClickListener");
        }
        return onFilterItemClickListener;
    }

    public final void setOnItemClickListener(@NotNull OnFilterItemClickListener onFilterItemClickListener) {
        Intrinsics.checkParameterIsNotNull(onFilterItemClickListener, "<set-?>");
        this.onItemClickListener = onFilterItemClickListener;
    }

    public final int getGroupPosition() {
        return this.groupPosition;
    }

    public final void setGroupPosition(int i) {
        this.groupPosition = i;
    }

    @NotNull
    public Object getChild(int i, int i2) {
        List<FilterValues> list = this.expandableListDetail.get(this.expandableListTitle.get(i));
        if (list == null) {
            Intrinsics.throwNpe();
        }
        return list.get(i2);
    }

    public final void setClickListenter(@NotNull OnFilterItemClickListener onFilterItemClickListener) {
        Intrinsics.checkParameterIsNotNull(onFilterItemClickListener, "onItemClickListener");
        this.onItemClickListener = onFilterItemClickListener;
    }

    @NotNull
    public View getChildView(int i, int i2, boolean z, @Nullable View view, @NotNull ViewGroup viewGroup) {
        View view2;
        int i3 = i2;
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        Object child = getChild(i, i2);
        if (child != null) {
            FilterValues filterValues = (FilterValues) child;
            String str = null;
            if (view == null) {
                Object systemService = this.context.getSystemService("layout_inflater");
                if (systemService != null) {
                    view2 = ((LayoutInflater) systemService).inflate(C2723R.C2728layout.row_item_filter_list_item, (ViewGroup) null);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
                }
            } else {
                view2 = view;
            }
            if (view2 == null) {
                Intrinsics.throwNpe();
            }
            View findViewById = view2.findViewById(C2723R.C2726id.clContainer);
            View findViewById2 = view2.findViewById(C2723R.C2726id.dividerView);
            View findViewById3 = view2.findViewById(C2723R.C2726id.layoutYearContainer);
            TextView textView = (TextView) view2.findViewById(C2723R.C2726id.et_filter_start_year);
            TextView textView2 = (TextView) view2.findViewById(C2723R.C2726id.et_filter_end_year);
            String displayText = filterValues.getDisplayText();
            if (StringsKt.equals(displayText, "Year", true) || StringsKt.equals$default(displayText, "Año", false, 2, (Object) null)) {
                Intrinsics.checkExpressionValueIsNotNull(findViewById3, "cl_year_container");
                findViewById3.setVisibility(0);
                Intrinsics.checkExpressionValueIsNotNull(findViewById, "clContainer");
                findViewById.setVisibility(8);
                Intrinsics.checkExpressionValueIsNotNull(textView, "etFilterStartYear");
                textView.setHint("1900");
                Intrinsics.checkExpressionValueIsNotNull(textView2, "etFilterEndYear");
                textView2.setHint(NewDateHelper.INSTANCE.getCurrentYear());
                CharSequence valuesId = filterValues.getValuesId();
                if (valuesId == null || valuesId.length() == 0) {
                    textView.setText("");
                    textView2.setText("");
                    textView.setHint("1900");
                    textView2.setHint(NewDateHelper.INSTANCE.getCurrentYear());
                } else {
                    String valuesId2 = filterValues.getValuesId();
                    Boolean valueOf = valuesId2 != null ? Boolean.valueOf(StringsKt.contains((CharSequence) valuesId2, (CharSequence) "-", true)) : null;
                    if (valueOf == null) {
                        Intrinsics.throwNpe();
                    }
                    if (valueOf.booleanValue()) {
                        String valuesId3 = filterValues.getValuesId();
                        List split$default = valuesId3 != null ? StringsKt.split$default((CharSequence) valuesId3, new String[]{"-"}, false, 0, 6, (Object) null) : null;
                        textView.setText(split$default != null ? (String) split$default.get(0) : null);
                        if (split$default != null) {
                            str = (String) split$default.get(1);
                        }
                        textView2.setText(str);
                    } else {
                        textView.setText("");
                        textView2.setText("");
                        textView.setHint("1900");
                        textView2.setHint(NewDateHelper.INSTANCE.getCurrentYear());
                    }
                }
            } else {
                Intrinsics.checkExpressionValueIsNotNull(findViewById3, "cl_year_container");
                findViewById3.setVisibility(8);
                Intrinsics.checkExpressionValueIsNotNull(findViewById, "clContainer");
                findViewById.setVisibility(0);
                View findViewById4 = view2.findViewById(C2723R.C2726id.tvFilterText);
                if (findViewById4 != null) {
                    ((TextView) findViewById4).setText(filterValues.getValuesId());
                    if (getChildrenCount(i) - 1 == i3) {
                        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "dividerView");
                        findViewById2.setVisibility(0);
                    } else {
                        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "dividerView");
                        findViewById2.setVisibility(8);
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
                }
            }
            findViewById.setSelected(filterValues.isSelected());
            findViewById.setOnClickListener(new FilterListExpandableListAdapter$getChildView$1(this, i3, i));
            int i4 = i;
            int i5 = i2;
            textView.setOnClickListener(new FilterListExpandableListAdapter$getChildView$2(this, textView, i4, i5, textView2));
            textView2.setOnClickListener(new FilterListExpandableListAdapter$getChildView$3(this, textView2, i4, i5, textView));
            return view2;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.model.filter.FilterValues");
    }

    public final void setYearStartDate(@NotNull TextView textView, int i, int i2, @NotNull String str) {
        TextView textView2 = textView;
        Intrinsics.checkParameterIsNotNull(textView2, "etFilterStartYear");
        String str2 = str;
        Intrinsics.checkParameterIsNotNull(str2, "endYear");
        Calendar instance = Calendar.getInstance();
        instance.add(1, -10);
        int i3 = instance.get(5);
        int i4 = instance.get(2);
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = instance.get(1);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this.context, 16973939, new FilterListExpandableListAdapter$setYearStartDate$dpd$1(this, intRef, textView2, str2, i, i2), intRef.element, i4, i3);
        DatePicker datePicker = datePickerDialog.getDatePicker();
        Intrinsics.checkExpressionValueIsNotNull(datePicker, "dpd.datePicker");
        datePicker.setMaxDate(new Date().getTime());
        datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(this.context.getResources().getColor(C2723R.C2724color.bdt_transparent)));
        datePickerDialog.show();
        DatePicker datePicker2 = datePickerDialog.getDatePicker();
        Intrinsics.checkExpressionValueIsNotNull(datePicker2, "dpd.datePicker");
        datePicker2.setDescendantFocusability(393216);
        DatePicker datePicker3 = datePickerDialog.getDatePicker();
        Intrinsics.checkExpressionValueIsNotNull(datePicker3, "picker");
        datePicker3.setCalendarViewShown(false);
        NumberPicker numberPicker = (NumberPicker) datePicker3.findViewById(Resources.getSystem().getIdentifier("day", "id", "android"));
        NumberPicker numberPicker2 = (NumberPicker) datePicker3.findViewById(Resources.getSystem().getIdentifier("month", "id", "android"));
        if (numberPicker != null && numberPicker2 != null) {
            numberPicker.setVisibility(8);
            numberPicker2.setVisibility(8);
        }
    }

    public final void setYearEndDate(@NotNull TextView textView, int i, int i2, @NotNull String str) {
        TextView textView2 = textView;
        Intrinsics.checkParameterIsNotNull(textView2, "etFilterEndYear");
        String str2 = str;
        Intrinsics.checkParameterIsNotNull(str2, Constants_MVVM.EXTRA_START_YEAR);
        Calendar instance = Calendar.getInstance();
        int i3 = instance.get(5);
        int i4 = instance.get(2);
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = instance.get(1);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this.context, 16973939, new FilterListExpandableListAdapter$setYearEndDate$dpd$1(this, intRef, textView2, str2, i, i2), intRef.element, i4, i3);
        Calendar instance2 = Calendar.getInstance();
        instance2.add(1, 1);
        DatePicker datePicker = datePickerDialog.getDatePicker();
        Intrinsics.checkExpressionValueIsNotNull(datePicker, "dpd.datePicker");
        Intrinsics.checkExpressionValueIsNotNull(instance2, "cal");
        datePicker.setMaxDate(instance2.getTimeInMillis());
        datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(this.context.getResources().getColor(C2723R.C2724color.bdt_transparent)));
        datePickerDialog.show();
        DatePicker datePicker2 = datePickerDialog.getDatePicker();
        Intrinsics.checkExpressionValueIsNotNull(datePicker2, "dpd.datePicker");
        datePicker2.setDescendantFocusability(393216);
        DatePicker datePicker3 = datePickerDialog.getDatePicker();
        Intrinsics.checkExpressionValueIsNotNull(datePicker3, "picker");
        datePicker3.setCalendarViewShown(false);
        NumberPicker numberPicker = (NumberPicker) datePicker3.findViewById(Resources.getSystem().getIdentifier("day", "id", "android"));
        NumberPicker numberPicker2 = (NumberPicker) datePicker3.findViewById(Resources.getSystem().getIdentifier("month", "id", "android"));
        if (numberPicker != null && numberPicker2 != null) {
            numberPicker.setVisibility(8);
            numberPicker2.setVisibility(8);
        }
    }

    public static /* synthetic */ void updateListOnSelectItem$default(FilterListExpandableListAdapter filterListExpandableListAdapter, int i, int i2, String str, int i3, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        filterListExpandableListAdapter.updateListOnSelectItem(i, i2, str, i3);
    }

    public final void updateListOnSelectItem(int i, int i2, @NotNull String str, int i3) {
        int i4 = i;
        Intrinsics.checkParameterIsNotNull(str, "year");
        List<FilterValues> list = this.expandableListDetail.get(this.expandableListTitle.get(i4));
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i5 = 0;
            for (Object next : list) {
                int i6 = i5 + 1;
                if (i5 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                FilterValues filterValues = (FilterValues) next;
                if (StringsKt.equals(filterValues.getDisplayText(), this.context.getString(C2723R.string.bdt_lbl_year), true) || StringsKt.equals(filterValues.getDisplayText(), ExifInterface.TAG_MAKE, true)) {
                    int i7 = i2;
                    arrayList.add(new FilterValues(filterValues.getDisplayText(), Integer.valueOf(i3), (List<FilterSubValues>) null, str, true));
                } else if (i5 == i2) {
                    arrayList.add(new FilterValues(filterValues.getDisplayText(), Integer.valueOf(i3), (List<FilterSubValues>) null, filterValues.getValuesId(), true));
                } else {
                    arrayList.add(new FilterValues(filterValues.getDisplayText(), Integer.valueOf(i3), (List<FilterSubValues>) null, filterValues.getValuesId(), false));
                }
                i5 = i6;
            }
            this.expandableListDetail.put(this.expandableListTitle.get(i4), arrayList);
            notifyDataSetChanged();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.iaai.android.bdt.model.filter.FilterValues>");
    }

    public final void onClickRemoveFilter(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, Constants_MVVM.EXTRA_FILTER_TITLE);
        Intrinsics.checkParameterIsNotNull(str2, "refinerValue");
        if (this.expandableListDetail.containsKey(str)) {
            List<FilterValues> list = this.expandableListDetail.get(str);
            if (list != null) {
                List<FilterValues> list2 = list;
                ArrayList arrayList = new ArrayList();
                this.groupPosition = -1;
                int i = 0;
                for (FilterValues filterValues : list2) {
                    if (StringsKt.equals(filterValues.getDisplayText(), this.context.getString(C2723R.string.bdt_lbl_year), true)) {
                        filterValues.setValuesId(str2);
                        filterValues.setSelected(false);
                        arrayList.add(filterValues);
                    } else if (StringsKt.equals(filterValues.getDisplayText(), ExifInterface.TAG_MAKE, true) || StringsKt.equals(filterValues.getDisplayText(), ExifInterface.TAG_MODEL, true)) {
                        filterValues.setValuesId(str2);
                        filterValues.setSelected(false);
                        arrayList.add(filterValues);
                    } else {
                        if (i == 0) {
                            filterValues.setSelected(true);
                            arrayList.add(filterValues);
                            i++;
                        }
                        if (StringsKt.equals(filterValues.getValuesId(), str2, true)) {
                            filterValues.setSelected(false);
                            arrayList.add(filterValues);
                        } else {
                            arrayList.add(filterValues);
                        }
                    }
                    i++;
                }
                this.expandableListDetail.put(str, list2);
                notifyDataSetChanged();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.iaai.android.bdt.model.filter.FilterValues>");
        }
    }

    public int getChildrenCount(int i) {
        List<FilterValues> list = this.expandableListDetail.get(this.expandableListTitle.get(i));
        if (list == null) {
            Intrinsics.throwNpe();
        }
        if (list.size() > 10 || StringsKt.equals(this.expandableListTitle.get(i), "make", true) || StringsKt.equals(this.expandableListTitle.get(i), "Make & Model", true)) {
            return 0;
        }
        if (StringsKt.equals(this.expandableListTitle.get(i), this.context.getString(C2723R.string.bdt_lbl_year), true)) {
            return 1;
        }
        List<FilterValues> list2 = this.expandableListDetail.get(this.expandableListTitle.get(i));
        if (list2 == null) {
            Intrinsics.throwNpe();
        }
        return list2.size();
    }

    @NotNull
    public Object getGroup(int i) {
        return this.expandableListTitle.get(i);
    }

    public int getGroupCount() {
        return this.expandableListTitle.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x012d, code lost:
        r7.setVisibility(0);
        r7.setText(java.lang.String.valueOf(r9.getCount()));
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getGroupView(int r17, boolean r18, @org.jetbrains.annotations.Nullable android.view.View r19, @org.jetbrains.annotations.NotNull android.view.ViewGroup r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            java.lang.String r2 = "parent"
            r3 = r20
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r2)
            java.lang.Object r2 = r16.getGroup(r17)
            if (r2 == 0) goto L_0x0201
            java.lang.String r2 = (java.lang.String) r2
            r3 = 0
            if (r19 != 0) goto L_0x0032
            android.content.Context r4 = r0.context
            java.lang.String r5 = "layout_inflater"
            java.lang.Object r4 = r4.getSystemService(r5)
            if (r4 == 0) goto L_0x002a
            android.view.LayoutInflater r4 = (android.view.LayoutInflater) r4
            r5 = 2131493091(0x7f0c00e3, float:1.8609652E38)
            android.view.View r4 = r4.inflate(r5, r3)
            goto L_0x0034
        L_0x002a:
            kotlin.TypeCastException r1 = new kotlin.TypeCastException
            java.lang.String r2 = "null cannot be cast to non-null type android.view.LayoutInflater"
            r1.<init>(r2)
            throw r1
        L_0x0032:
            r4 = r19
        L_0x0034:
            if (r4 != 0) goto L_0x0039
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0039:
            r5 = 2131297429(0x7f090495, float:1.8212803E38)
            android.view.View r5 = r4.findViewById(r5)
            java.lang.String r6 = "null cannot be cast to non-null type android.widget.TextView"
            if (r5 == 0) goto L_0x01fb
            android.widget.TextView r5 = (android.widget.TextView) r5
            r7 = 2131298855(0x7f090a27, float:1.8215695E38)
            android.view.View r7 = r4.findViewById(r7)
            if (r7 == 0) goto L_0x01f5
            android.widget.TextView r7 = (android.widget.TextView) r7
            r6 = 2131297268(0x7f0903f4, float:1.8212476E38)
            android.view.View r6 = r4.findViewById(r6)
            if (r6 == 0) goto L_0x01ed
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            java.util.LinkedHashMap<java.lang.String, java.util.List<com.iaai.android.bdt.model.filter.FilterValues>> r8 = r0.expandableListDetail
            java.util.List<java.lang.String> r9 = r0.expandableListTitle
            java.lang.Object r9 = r9.get(r1)
            java.lang.Object r8 = r8.get(r9)
            if (r8 == 0) goto L_0x01e5
            java.util.ArrayList r8 = (java.util.ArrayList) r8
            int r9 = r8.size()
            java.lang.String r10 = "Make & Model"
            r11 = 10
            r13 = 0
            r14 = 1
            if (r9 >= r11) goto L_0x00d2
            java.util.Iterator r8 = r8.iterator()
            r9 = 0
        L_0x007d:
            boolean r15 = r8.hasNext()
            if (r15 == 0) goto L_0x0146
            java.lang.Object r15 = r8.next()
            com.iaai.android.bdt.model.filter.FilterValues r15 = (com.iaai.android.bdt.model.filter.FilterValues) r15
            java.lang.String r3 = r15.getDisplayText()
            java.lang.String r11 = "Year"
            boolean r3 = kotlin.text.StringsKt.equals(r3, r11, r14)
            if (r3 != 0) goto L_0x00bc
            java.lang.String r3 = r15.getDisplayText()
            android.content.Context r11 = r0.context
            r12 = 2131820675(0x7f110083, float:1.9274072E38)
            java.lang.String r11 = r11.getString(r12)
            boolean r3 = kotlin.text.StringsKt.equals(r3, r11, r14)
            if (r3 == 0) goto L_0x00a9
            goto L_0x00bc
        L_0x00a9:
            boolean r3 = r15.isSelected()
            if (r3 == 0) goto L_0x00b6
            if (r9 == 0) goto L_0x00b6
            r7.setVisibility(r13)
            goto L_0x0146
        L_0x00b6:
            r3 = 8
            r7.setVisibility(r3)
            goto L_0x00cc
        L_0x00bc:
            r3 = 8
            boolean r11 = r15.isSelected()
            if (r11 == 0) goto L_0x00c9
            r7.setVisibility(r13)
            goto L_0x0146
        L_0x00c9:
            r7.setVisibility(r3)
        L_0x00cc:
            int r9 = r9 + 1
            r3 = 0
            r11 = 10
            goto L_0x007d
        L_0x00d2:
            java.util.Iterator r3 = r8.iterator()
            r8 = 0
        L_0x00d7:
            boolean r9 = r3.hasNext()
            if (r9 == 0) goto L_0x0146
            java.lang.Object r9 = r3.next()
            com.iaai.android.bdt.model.filter.FilterValues r9 = (com.iaai.android.bdt.model.filter.FilterValues) r9
            java.lang.String r11 = r9.getDisplayText()
            java.lang.String r12 = "Make"
            boolean r11 = kotlin.text.StringsKt.equals(r11, r12, r14)
            if (r11 != 0) goto L_0x0118
            java.lang.String r11 = r9.getDisplayText()
            java.lang.String r12 = "Model"
            boolean r11 = kotlin.text.StringsKt.equals(r11, r12, r14)
            if (r11 != 0) goto L_0x0118
            java.lang.String r11 = r9.getDisplayText()
            boolean r11 = kotlin.text.StringsKt.equals(r11, r10, r14)
            if (r11 == 0) goto L_0x0106
            goto L_0x0118
        L_0x0106:
            boolean r9 = r9.isSelected()
            if (r9 == 0) goto L_0x0112
            if (r8 == 0) goto L_0x0112
            r7.setVisibility(r13)
            goto L_0x0146
        L_0x0112:
            r9 = 8
            r7.setVisibility(r9)
            goto L_0x0143
        L_0x0118:
            boolean r11 = r9.isSelected()
            if (r11 == 0) goto L_0x013e
            if (r8 == 0) goto L_0x013e
            java.lang.Integer r11 = r9.getCount()
            if (r11 != 0) goto L_0x0127
            goto L_0x012d
        L_0x0127:
            int r11 = r11.intValue()
            if (r11 == 0) goto L_0x013e
        L_0x012d:
            r7.setVisibility(r13)
            java.lang.Integer r3 = r9.getCount()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r7.setText(r3)
            goto L_0x0146
        L_0x013e:
            r9 = 8
            r7.setVisibility(r9)
        L_0x0143:
            int r8 = r8 + 1
            goto L_0x00d7
        L_0x0146:
            java.lang.String r3 = "make"
            r7 = 2131231125(0x7f080195, float:1.8078322E38)
            if (r18 == 0) goto L_0x0195
            java.util.LinkedHashMap<java.lang.String, java.util.List<com.iaai.android.bdt.model.filter.FilterValues>> r8 = r0.expandableListDetail
            java.util.List<java.lang.String> r9 = r0.expandableListTitle
            java.lang.Object r9 = r9.get(r1)
            java.lang.Object r8 = r8.get(r9)
            if (r8 != 0) goto L_0x015e
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x015e:
            java.util.List r8 = (java.util.List) r8
            int r8 = r8.size()
            r9 = 10
            if (r8 <= r9) goto L_0x016d
            r6.setImageResource(r7)
            goto L_0x01db
        L_0x016d:
            java.util.List<java.lang.String> r8 = r0.expandableListTitle
            java.lang.Object r8 = r8.get(r1)
            java.lang.String r8 = (java.lang.String) r8
            boolean r3 = kotlin.text.StringsKt.equals(r8, r3, r14)
            if (r3 == 0) goto L_0x0191
            java.util.List<java.lang.String> r3 = r0.expandableListTitle
            java.lang.Object r1 = r3.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = kotlin.text.StringsKt.equals(r1, r10, r14)
            if (r1 != 0) goto L_0x018a
            goto L_0x0191
        L_0x018a:
            r1 = 2131231373(0x7f08028d, float:1.8078825E38)
            r6.setImageResource(r1)
            goto L_0x01db
        L_0x0191:
            r6.setImageResource(r7)
            goto L_0x01db
        L_0x0195:
            java.util.List<java.lang.String> r8 = r0.expandableListTitle
            java.lang.Object r8 = r8.get(r1)
            java.lang.String r8 = (java.lang.String) r8
            boolean r3 = kotlin.text.StringsKt.equals(r8, r3, r14)
            if (r3 != 0) goto L_0x01d8
            java.util.List<java.lang.String> r3 = r0.expandableListTitle
            java.lang.Object r3 = r3.get(r1)
            java.lang.String r3 = (java.lang.String) r3
            boolean r3 = kotlin.text.StringsKt.equals(r3, r10, r14)
            if (r3 == 0) goto L_0x01b2
            goto L_0x01d8
        L_0x01b2:
            java.util.LinkedHashMap<java.lang.String, java.util.List<com.iaai.android.bdt.model.filter.FilterValues>> r3 = r0.expandableListDetail
            java.util.List<java.lang.String> r8 = r0.expandableListTitle
            java.lang.Object r1 = r8.get(r1)
            java.lang.Object r1 = r3.get(r1)
            if (r1 != 0) goto L_0x01c3
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x01c3:
            java.util.List r1 = (java.util.List) r1
            int r1 = r1.size()
            r3 = 10
            if (r1 <= r3) goto L_0x01d1
            r6.setImageResource(r7)
            goto L_0x01db
        L_0x01d1:
            r1 = 2131231371(0x7f08028b, float:1.8078821E38)
            r6.setImageResource(r1)
            goto L_0x01db
        L_0x01d8:
            r6.setImageResource(r7)
        L_0x01db:
            r1 = 0
            r5.setTypeface(r1, r14)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r5.setText(r2)
            return r4
        L_0x01e5:
            kotlin.TypeCastException r1 = new kotlin.TypeCastException
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.collections.ArrayList<com.iaai.android.bdt.model.filter.FilterValues> /* = java.util.ArrayList<com.iaai.android.bdt.model.filter.FilterValues> */"
            r1.<init>(r2)
            throw r1
        L_0x01ed:
            kotlin.TypeCastException r1 = new kotlin.TypeCastException
            java.lang.String r2 = "null cannot be cast to non-null type android.widget.ImageView"
            r1.<init>(r2)
            throw r1
        L_0x01f5:
            kotlin.TypeCastException r1 = new kotlin.TypeCastException
            r1.<init>(r6)
            throw r1
        L_0x01fb:
            kotlin.TypeCastException r1 = new kotlin.TypeCastException
            r1.<init>(r6)
            throw r1
        L_0x0201:
            kotlin.TypeCastException r1 = new kotlin.TypeCastException
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.String"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.findVehiclePage.filter.FilterListExpandableListAdapter.getGroupView(int, boolean, android.view.View, android.view.ViewGroup):android.view.View");
    }
}
