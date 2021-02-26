package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.fastSearchFilter2.FacetXX;
import com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingGroup;
import com.iaai.android.bdt.utils.BDTUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001@B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J0\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J0\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0016J\u0018\u0010%\u001a\u00020&2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0016J\b\u0010'\u001a\u00020\u0006H\u0016J2\u0010(\u001a\u00020)2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00152\b\u0010+\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0016J\u0010\u0010/\u001a\u0002002\u0006\u0010#\u001a\u00020\u0006H\u0016J\b\u00101\u001a\u00020\u0006H\u0016J\u0010\u00102\u001a\u00020&2\u0006\u0010#\u001a\u00020\u0006H\u0016J*\u00103\u001a\u00020)2\u0006\u0010#\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00152\b\u0010+\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020-H\u0016J\b\u00105\u001a\u00020\u0015H\u0016J\u0018\u00106\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0016J\u000e\u00107\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\nJ\u000e\u00108\u001a\u00020\u00172\u0006\u00109\u001a\u00020\u0006J\u001e\u0010:\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u0015J\u0018\u0010=\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010>\u001a\u00020?H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eRB\u0010\u000f\u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00110\u0010j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0011`\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchExpandableAdapter;", "Landroid/widget/BaseExpandableListAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "groupPosition", "", "maxValYr", "minValYr", "onItemClickListener", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchExpandableAdapter$OnFilterItemClickListener;", "getOnItemClickListener", "()Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchExpandableAdapter$OnFilterItemClickListener;", "setOnItemClickListener", "(Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchExpandableAdapter$OnFilterItemClickListener;)V", "sliderList", "Ljava/util/ArrayList;", "Lkotlin/Triple;", "Lkotlin/collections/ArrayList;", "tabPosition", "areAllItemsEnabled", "", "createCustomNumberPicker", "", "textView", "Landroid/widget/TextView;", "minValue", "maxValue", "isMin", "groupPos", "createDatePicker", "minYear", "maxYear", "getChild", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FacetXX;", "listPosition", "expandedListPosition", "getChildId", "", "getChildTypeCount", "getChildView", "Landroid/view/View;", "isLastChild", "convertView", "parent", "Landroid/view/ViewGroup;", "getChildrenCount", "getGroup", "Lcom/iaai/android/bdt/model/fastSearchFilter2/SearchMappingGroup;", "getGroupCount", "getGroupId", "getGroupView", "isExpanded", "hasStableIds", "isChildSelectable", "setClickListener", "setTabPosition", "position", "updateListOnSelectItem", "childPos", "isSingleSelect", "updateListOnSelectItemForSlider", "range", "", "OnFilterItemClickListener", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchExpandableAdapter.kt */
public final class FastSearchExpandableAdapter extends BaseExpandableListAdapter {
    private final Context context;
    private int groupPosition = -1;
    /* access modifiers changed from: private */
    public int maxValYr;
    /* access modifiers changed from: private */
    public int minValYr;
    @NotNull
    public OnFilterItemClickListener onItemClickListener;
    private ArrayList<Triple<Integer, Integer, Integer>> sliderList = new ArrayList<>();
    /* access modifiers changed from: private */
    public int tabPosition;

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchExpandableAdapter$OnFilterItemClickListener;", "", "onGroupClearClick", "", "parentPosition", "", "onMultiSelectItemClick", "childPosition", "isSelected", "", "onRadioItemClick", "onSliderItemClick", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: FastSearchExpandableAdapter.kt */
    public interface OnFilterItemClickListener {
        void onGroupClearClick(int i);

        void onMultiSelectItemClick(int i, int i2, boolean z);

        void onRadioItemClick(int i, int i2);

        void onSliderItemClick(int i);
    }

    public boolean areAllItemsEnabled() {
        return true;
    }

    public long getChildId(int i, int i2) {
        return (long) i2;
    }

    public int getChildTypeCount() {
        return 4;
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

    public FastSearchExpandableAdapter(@NotNull Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
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

    @NotNull
    public FacetXX getChild(int i, int i2) {
        List<FacetXX> list = BDTUtils.INSTANCE.getExpandableListDetail().get(BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(i));
        if (list == null) {
            Intrinsics.throwNpe();
        }
        return (FacetXX) list.get(i2);
    }

    public final void setClickListener(@NotNull OnFilterItemClickListener onFilterItemClickListener) {
        Intrinsics.checkParameterIsNotNull(onFilterItemClickListener, "onItemClickListener");
        this.onItemClickListener = onFilterItemClickListener;
    }

    @NotNull
    public View getChildView(int i, int i2, boolean z, @Nullable View view, @NotNull ViewGroup viewGroup) {
        int i3 = i;
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        String filtertype = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(i3).getFiltertype();
        Object systemService = this.context.getSystemService("layout_inflater");
        if (systemService != null) {
            LayoutInflater layoutInflater = (LayoutInflater) systemService;
            int i4 = 0;
            if (StringsKt.equals(filtertype, "checkbox", true)) {
                View inflate = layoutInflater.inflate(C2723R.C2728layout.row_item_fast_search_filter_facet_checkbox, (ViewGroup) null);
                if (inflate == null) {
                    Intrinsics.throwNpe();
                }
                View findViewById = inflate.findViewById(C2723R.C2726id.tvMultiSelectValue);
                if (findViewById != null) {
                    TextView textView = (TextView) findViewById;
                    ImageView imageView = (ImageView) inflate.findViewById(C2723R.C2726id.ivCheck);
                    FacetXX child = getChild(i, i2);
                    textView.setTypeface(Typeface.SANS_SERIF, 0);
                    textView.setText(child.getValue());
                    textView.setTextColor(ContextCompat.getColor(this.context, C2723R.C2724color.bdt_gray_darker));
                    Intrinsics.checkExpressionValueIsNotNull(imageView, "ivCheck");
                    imageView.setSelected(child.isSelected());
                    ((ConstraintLayout) inflate.findViewById(C2723R.C2726id.llMultiSelect)).setOnClickListener(new FastSearchExpandableAdapter$getChildView$1(this, imageView, i3, i2));
                    return inflate;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
            int i5 = i2;
            if (StringsKt.equals(filtertype, "radio", true)) {
                View inflate2 = layoutInflater.inflate(C2723R.C2728layout.row_item_fast_search_filter_facet_radio_button, (ViewGroup) null);
                if (inflate2 == null) {
                    Intrinsics.throwNpe();
                }
                View findViewById2 = inflate2.findViewById(C2723R.C2726id.rgContainer);
                if (findViewById2 != null) {
                    RadioGroup radioGroup = (RadioGroup) findViewById2;
                    List list = BDTUtils.INSTANCE.getExpandableListDetail().get(BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(i3));
                    if (list != null) {
                        for (Object next : list) {
                            int i6 = i4 + 1;
                            if (i4 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            FacetXX facetXX = (FacetXX) next;
                            radioGroup.addView(BDTUtils.INSTANCE.getRadioButtonForFilter(this.context, facetXX.getValue(), i4, facetXX.isSelected()));
                            i4 = i6;
                        }
                    }
                    radioGroup.setOnCheckedChangeListener(new FastSearchExpandableAdapter$getChildView$3(this, list, i3));
                    return inflate2;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.RadioGroup");
            } else if (StringsKt.equals(filtertype, "slider", true)) {
                View inflate3 = layoutInflater.inflate(C2723R.C2728layout.row_item_fast_search_filter_facet_range, (ViewGroup) null);
                if (inflate3 == null) {
                    Intrinsics.throwNpe();
                }
                View findViewById3 = inflate3.findViewById(C2723R.C2726id.llContainer);
                if (findViewById3 != null) {
                    ((LinearLayout) findViewById3).setVisibility(8);
                    return inflate3;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout");
            } else if (StringsKt.equals(filtertype, "year", true)) {
                View inflate4 = layoutInflater.inflate(C2723R.C2728layout.row_item_fast_search_filter_facet_range, (ViewGroup) null);
                BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(i3).getGroup();
                if (inflate4 == null) {
                    Intrinsics.throwNpe();
                }
                View findViewById4 = inflate4.findViewById(C2723R.C2726id.tvStart);
                if (findViewById4 != null) {
                    TextView textView2 = (TextView) findViewById4;
                    View findViewById5 = inflate4.findViewById(C2723R.C2726id.tvEnd);
                    if (findViewById5 != null) {
                        TextView textView3 = (TextView) findViewById5;
                        FacetXX facetXX2 = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(i3).getListFacet().get(0);
                        Intrinsics.checkExpressionValueIsNotNull(facetXX2, "BDTUtils.searchMappingAr…istPosition].listFacet[0]");
                        FacetXX facetXX3 = facetXX2;
                        List split$default = StringsKt.split$default((CharSequence) facetXX3.getValue(), new String[]{"-"}, false, 0, 6, (Object) null);
                        if (!facetXX3.isSelected() || split$default.size() <= 1) {
                            Integer minvalue = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(i3).getMinvalue();
                            if (minvalue != null) {
                                this.minValYr = minvalue.intValue();
                            }
                            Integer maxvalue = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(i3).getMaxvalue();
                            if (maxvalue != null) {
                                this.maxValYr = maxvalue.intValue();
                            }
                        } else {
                            String removePrefix = StringsKt.removePrefix((String) split$default.get(0), (CharSequence) "Year:");
                            if (removePrefix != null) {
                                this.minValYr = Integer.parseInt(StringsKt.trim((CharSequence) removePrefix).toString());
                                this.maxValYr = Integer.parseInt((String) split$default.get(1));
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                            }
                        }
                        textView2.setText(String.valueOf(this.minValYr));
                        textView3.setText(String.valueOf(this.maxValYr));
                        textView2.setOnClickListener(new FastSearchExpandableAdapter$getChildView$6(this, i3, textView2));
                        textView3.setOnClickListener(new FastSearchExpandableAdapter$getChildView$7(this, i3, textView3));
                        return inflate4;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            } else if (view != null) {
                return view;
            } else {
                View inflate5 = layoutInflater.inflate(C2723R.C2728layout.row_item_fast_search_filter_facet_checkbox, (ViewGroup) null);
                if (inflate5 == null) {
                    Intrinsics.throwNpe();
                }
                View findViewById6 = inflate5.findViewById(C2723R.C2726id.tvMultiSelectValue);
                if (findViewById6 != null) {
                    TextView textView4 = (TextView) findViewById6;
                    FacetXX child2 = getChild(i, i2);
                    textView4.setTypeface(Typeface.SANS_SERIF, 0);
                    textView4.setText(child2.getValue());
                    textView4.setTextColor(ContextCompat.getColor(this.context, C2723R.C2724color.bdt_gray_darker));
                    return inflate5;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
        }
    }

    public int getChildrenCount(int i) {
        if (!BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(i).isEnabled()) {
            return 0;
        }
        if (StringsKt.equals(BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(i).getFiltertype(), "slider", true) || StringsKt.equals(BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(i).getFiltertype(), "radio", true) || StringsKt.equals(BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(i).getFiltertype(), "year", true) || StringsKt.equals(BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(i).getFiltertype(), "ZipMiles", true)) {
            return 1;
        }
        List list = BDTUtils.INSTANCE.getExpandableListDetail().get(BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(i));
        Integer valueOf = list != null ? Integer.valueOf(list.size()) : null;
        if (valueOf == null) {
            Intrinsics.throwNpe();
        }
        return valueOf.intValue();
    }

    @NotNull
    public SearchMappingGroup getGroup(int i) {
        SearchMappingGroup searchMappingGroup = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(i);
        Intrinsics.checkExpressionValueIsNotNull(searchMappingGroup, "BDTUtils.searchMappingAr…ion].groups[listPosition]");
        return searchMappingGroup;
    }

    public int getGroupCount() {
        return BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().size();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0191, code lost:
        if (r0.equals("radio") != false) goto L_0x01ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01a1, code lost:
        if (r0.equals("ZipMiles") != false) goto L_0x01ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01aa, code lost:
        if (r0.equals("slider") != false) goto L_0x01ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01ac, code lost:
        if (r1 == null) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01ae, code lost:
        r11 = r1.iterator();
        r13 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01b9, code lost:
        if (r11.hasNext() == false) goto L_0x01ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01c5, code lost:
        if (((com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r11.next()).isSelected() == false) goto L_0x01b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01c7, code lost:
        r13 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01c9, code lost:
        r13 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01ca, code lost:
        if (r13 == false) goto L_0x01d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01cc, code lost:
        r3.setVisibility(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01d0, code lost:
        r3.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01d3, code lost:
        r3.setOnClickListener(new com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchExpandableAdapter$getGroupView$3(r9, r10));
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getGroupView(int r10, boolean r11, @org.jetbrains.annotations.Nullable android.view.View r12, @org.jetbrains.annotations.NotNull android.view.ViewGroup r13) {
        /*
            r9 = this;
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r13, r0)
            com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingGroup r13 = r9.getGroup((int) r10)
            if (r12 != 0) goto L_0x0028
            android.content.Context r12 = r9.context
            java.lang.String r0 = "layout_inflater"
            java.lang.Object r12 = r12.getSystemService(r0)
            if (r12 == 0) goto L_0x0020
            android.view.LayoutInflater r12 = (android.view.LayoutInflater) r12
            r0 = 2131493301(0x7f0c01b5, float:1.8610078E38)
            r1 = 0
            android.view.View r12 = r12.inflate(r0, r1)
            goto L_0x0028
        L_0x0020:
            kotlin.TypeCastException r10 = new kotlin.TypeCastException
            java.lang.String r11 = "null cannot be cast to non-null type android.view.LayoutInflater"
            r10.<init>(r11)
            throw r10
        L_0x0028:
            if (r12 != 0) goto L_0x002d
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x002d:
            r0 = 2131298553(0x7f0908f9, float:1.8215082E38)
            android.view.View r0 = r12.findViewById(r0)
            java.lang.String r1 = "null cannot be cast to non-null type android.widget.TextView"
            if (r0 == 0) goto L_0x01f2
            android.widget.TextView r0 = (android.widget.TextView) r0
            r2 = 2131297268(0x7f0903f4, float:1.8212476E38)
            android.view.View r2 = r12.findViewById(r2)
            if (r2 == 0) goto L_0x01ea
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r3 = 2131298495(0x7f0908bf, float:1.8214965E38)
            android.view.View r3 = r12.findViewById(r3)
            if (r3 == 0) goto L_0x01e4
            android.widget.TextView r3 = (android.widget.TextView) r3
            r4 = 2131298671(0x7f09096f, float:1.8215322E38)
            android.view.View r4 = r12.findViewById(r4)
            if (r4 == 0) goto L_0x01de
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.String r1 = r13.getDisplayname()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            android.content.Context r1 = r9.context
            r5 = 2131099697(0x7f060031, float:1.7811755E38)
            int r1 = androidx.core.content.ContextCompat.getColor(r1, r5)
            r0.setTextColor(r1)
            boolean r1 = r13.isEnabled()
            r5 = 8
            r6 = 1
            r7 = 0
            if (r1 != 0) goto L_0x00d2
            java.lang.String r10 = r13.getGroup()
            java.lang.String r11 = "BuynowRange"
            boolean r10 = kotlin.text.StringsKt.equals(r10, r11, r6)
            if (r10 == 0) goto L_0x0090
            android.content.Context r10 = r9.context
            r11 = 2131821317(0x7f110305, float:1.9275374E38)
            java.lang.String r10 = r10.getString(r11)
            goto L_0x00a8
        L_0x0090:
            java.lang.String r10 = r13.getGroup()
            java.lang.String r11 = "Series"
            boolean r10 = kotlin.text.StringsKt.equals(r10, r11, r6)
            if (r10 == 0) goto L_0x00a6
            android.content.Context r10 = r9.context
            r11 = 2131821747(0x7f1104b3, float:1.9276246E38)
            java.lang.String r10 = r10.getString(r11)
            goto L_0x00a8
        L_0x00a6:
            java.lang.String r10 = ""
        L_0x00a8:
            r2.setVisibility(r5)
            android.graphics.Typeface r11 = android.graphics.Typeface.SANS_SERIF
            r0.setTypeface(r11, r7)
            r11 = 1056964608(0x3f000000, float:0.5)
            r0.setAlpha(r11)
            java.lang.String r11 = "subText"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r11)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r11 = kotlin.text.StringsKt.isBlank(r10)
            r11 = r11 ^ r6
            if (r11 == 0) goto L_0x00ca
            r4.setVisibility(r7)
            r4.setText(r10)
            goto L_0x00cd
        L_0x00ca:
            r4.setVisibility(r5)
        L_0x00cd:
            r3.setVisibility(r5)
            goto L_0x01dd
        L_0x00d2:
            r2.setVisibility(r7)
            android.graphics.Typeface r1 = android.graphics.Typeface.SANS_SERIF
            r0.setTypeface(r1, r6)
            r1 = 1065353216(0x3f800000, float:1.0)
            r0.setAlpha(r1)
            r4.setVisibility(r5)
            r3.setVisibility(r7)
            com.iaai.android.bdt.utils.BDTUtils r0 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r0 = r0.getSearchMappingArray()
            int r1 = r9.tabPosition
            java.lang.Object r0 = r0.get(r1)
            com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray r0 = (com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray) r0
            java.util.ArrayList r0 = r0.getGroups()
            java.lang.Object r0 = r0.get(r10)
            com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingGroup r0 = (com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingGroup) r0
            java.lang.String r0 = r0.getFiltertype()
            com.iaai.android.bdt.utils.BDTUtils r1 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.LinkedHashMap r1 = r1.getExpandableListDetail()
            com.iaai.android.bdt.utils.BDTUtils r4 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r4 = r4.getSearchMappingArray()
            int r8 = r9.tabPosition
            java.lang.Object r4 = r4.get(r8)
            com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray r4 = (com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray) r4
            java.util.ArrayList r4 = r4.getGroups()
            java.lang.Object r4 = r4.get(r10)
            java.lang.Object r1 = r1.get(r4)
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x012a
            int r4 = r1.size()
            goto L_0x012b
        L_0x012a:
            r4 = 0
        L_0x012b:
            r8 = 10
            if (r4 >= r8) goto L_0x0158
            java.lang.String r4 = r13.getGroup()
            java.lang.String r8 = "Zip_Miles"
            boolean r4 = kotlin.text.StringsKt.equals(r4, r8, r6)
            if (r4 != 0) goto L_0x0158
            java.lang.String r13 = r13.getFiltertype()
            java.lang.String r4 = "Slider"
            boolean r13 = kotlin.text.StringsKt.equals(r13, r4, r6)
            if (r13 == 0) goto L_0x0148
            goto L_0x0158
        L_0x0148:
            if (r11 == 0) goto L_0x0151
            r11 = 2131231373(0x7f08028d, float:1.8078825E38)
            r2.setImageResource(r11)
            goto L_0x015e
        L_0x0151:
            r11 = 2131231371(0x7f08028b, float:1.8078821E38)
            r2.setImageResource(r11)
            goto L_0x015e
        L_0x0158:
            r11 = 2131231125(0x7f080195, float:1.8078322E38)
            r2.setImageResource(r11)
        L_0x015e:
            int r11 = r0.hashCode()
            switch(r11) {
                case -899647263: goto L_0x01a4;
                case -81442691: goto L_0x019b;
                case 3704893: goto L_0x0194;
                case 108270587: goto L_0x018b;
                case 1536891843: goto L_0x0166;
                default: goto L_0x0165;
            }
        L_0x0165:
            goto L_0x01c9
        L_0x0166:
            java.lang.String r11 = "checkbox"
            boolean r11 = r0.equals(r11)
            if (r11 == 0) goto L_0x01c9
            if (r1 == 0) goto L_0x01c9
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r11 = r1.iterator()
            r13 = 0
        L_0x0177:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x01ca
            java.lang.Object r0 = r11.next()
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r0 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r0
            boolean r0 = r0.isSelected()
            if (r0 == 0) goto L_0x0177
            r13 = 1
            goto L_0x0177
        L_0x018b:
            java.lang.String r11 = "radio"
            boolean r11 = r0.equals(r11)
            if (r11 == 0) goto L_0x01c9
            goto L_0x01ac
        L_0x0194:
            java.lang.String r11 = "year"
            boolean r11 = r0.equals(r11)
            goto L_0x01c9
        L_0x019b:
            java.lang.String r11 = "ZipMiles"
            boolean r11 = r0.equals(r11)
            if (r11 == 0) goto L_0x01c9
            goto L_0x01ac
        L_0x01a4:
            java.lang.String r11 = "slider"
            boolean r11 = r0.equals(r11)
            if (r11 == 0) goto L_0x01c9
        L_0x01ac:
            if (r1 == 0) goto L_0x01c9
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r11 = r1.iterator()
            r13 = 0
        L_0x01b5:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x01ca
            java.lang.Object r0 = r11.next()
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r0 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r0
            boolean r0 = r0.isSelected()
            if (r0 == 0) goto L_0x01b5
            r13 = 1
            goto L_0x01b5
        L_0x01c9:
            r13 = 0
        L_0x01ca:
            if (r13 == 0) goto L_0x01d0
            r3.setVisibility(r7)
            goto L_0x01d3
        L_0x01d0:
            r3.setVisibility(r5)
        L_0x01d3:
            com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchExpandableAdapter$getGroupView$3 r11 = new com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchExpandableAdapter$getGroupView$3
            r11.<init>(r9, r10)
            android.view.View$OnClickListener r11 = (android.view.View.OnClickListener) r11
            r3.setOnClickListener(r11)
        L_0x01dd:
            return r12
        L_0x01de:
            kotlin.TypeCastException r10 = new kotlin.TypeCastException
            r10.<init>(r1)
            throw r10
        L_0x01e4:
            kotlin.TypeCastException r10 = new kotlin.TypeCastException
            r10.<init>(r1)
            throw r10
        L_0x01ea:
            kotlin.TypeCastException r10 = new kotlin.TypeCastException
            java.lang.String r11 = "null cannot be cast to non-null type android.widget.ImageView"
            r10.<init>(r11)
            throw r10
        L_0x01f2:
            kotlin.TypeCastException r10 = new kotlin.TypeCastException
            r10.<init>(r1)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchExpandableAdapter.getGroupView(int, boolean, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public final void updateListOnSelectItem(int i, int i2, boolean z) {
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
                    FacetXX facetXX = (FacetXX) next;
                    facetXX.setSelected(i4 == i2);
                    arrayList.add(facetXX);
                    i4 = i5;
                }
            }
        } else if (list != null) {
            for (Object next2 : list) {
                int i6 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                FacetXX facetXX2 = (FacetXX) next2;
                if (i3 == i2) {
                    facetXX2.setSelected(!facetXX2.isSelected());
                }
                arrayList.add(facetXX2);
                i3 = i6;
            }
        }
        SearchMappingGroup searchMappingGroup = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(i);
        Intrinsics.checkExpressionValueIsNotNull(searchMappingGroup, "BDTUtils.searchMappingAr…osition].groups[groupPos]");
        BDTUtils.INSTANCE.getExpandableListDetail().put(searchMappingGroup, arrayList);
        notifyDataSetChanged();
    }

    public final void setTabPosition(int i) {
        this.tabPosition = i;
        BDTUtils.INSTANCE.getFilterData(this.tabPosition);
    }

    /* access modifiers changed from: private */
    public final void createDatePicker(TextView textView, int i, int i2, boolean z, int i3) {
        Calendar instance = Calendar.getInstance();
        int i4 = instance.get(5);
        int i5 = instance.get(2);
        int i6 = instance.get(1);
        int i7 = instance.get(1) - i;
        int i8 = i2 - instance.get(1);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this.context, 16973939, new FastSearchExpandableAdapter$createDatePicker$dpd$1(this, textView, z, i3), i6, i5, i4);
        Window window = datePickerDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(this.context.getResources().getColor(C2723R.C2724color.bdt_transparent)));
        }
        instance.add(1, -i7);
        DatePicker datePicker = datePickerDialog.getDatePicker();
        Intrinsics.checkExpressionValueIsNotNull(datePicker, "dpd.datePicker");
        Intrinsics.checkExpressionValueIsNotNull(instance, "calendar");
        datePicker.setMinDate(instance.getTimeInMillis());
        instance.add(1, i7 + i8);
        DatePicker datePicker2 = datePickerDialog.getDatePicker();
        Intrinsics.checkExpressionValueIsNotNull(datePicker2, "dpd.datePicker");
        datePicker2.setMaxDate(instance.getTimeInMillis());
        datePickerDialog.show();
        DatePicker datePicker3 = datePickerDialog.getDatePicker();
        Intrinsics.checkExpressionValueIsNotNull(datePicker3, "dpd.datePicker");
        datePicker3.setDescendantFocusability(393216);
        DatePicker datePicker4 = datePickerDialog.getDatePicker();
        Intrinsics.checkExpressionValueIsNotNull(datePicker4, "picker");
        datePicker4.setCalendarViewShown(false);
        NumberPicker numberPicker = (NumberPicker) datePicker4.findViewById(Resources.getSystem().getIdentifier("day", "id", "android"));
        NumberPicker numberPicker2 = (NumberPicker) datePicker4.findViewById(Resources.getSystem().getIdentifier("month", "id", "android"));
        if (numberPicker != null && numberPicker2 != null) {
            numberPicker.setVisibility(8);
            numberPicker2.setVisibility(8);
        }
    }

    private final void createCustomNumberPicker(TextView textView, int i, int i2, boolean z, int i3) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (Triple) null;
        int i4 = 0;
        for (Object next : this.sliderList) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (((Number) ((Triple) next).getFirst()).intValue() == i3) {
                objectRef.element = (Triple) this.sliderList.get(i4);
            }
            i4 = i5;
        }
        ArrayList arrayList = new ArrayList();
        IntProgression step = RangesKt.step((IntProgression) new IntRange(0, i2), 10000);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if (step2 <= 0 ? first >= last : first <= last) {
            while (true) {
                arrayList.add(String.valueOf(first));
                if (first == last) {
                    break;
                }
                first += step2;
            }
        }
        Dialog dialog = new Dialog(this.context);
        dialog.setContentView(C2723R.C2728layout.custom_number_picker);
        View findViewById = dialog.findViewById(C2723R.C2726id.numberPicker1);
        if (findViewById != null) {
            NumberPicker numberPicker = (NumberPicker) findViewById;
            numberPicker.setMinValue(i);
            numberPicker.setMaxValue(arrayList.size() - 1);
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                numberPicker.setDisplayedValues((String[]) array);
                numberPicker.setWrapSelectorWheel(false);
                numberPicker.setDescendantFocusability(393216);
                View findViewById2 = dialog.findViewById(C2723R.C2726id.btnOk);
                if (findViewById2 != null) {
                    Button button = (Button) findViewById2;
                    View findViewById3 = dialog.findViewById(C2723R.C2726id.btnCancel);
                    if (findViewById3 != null) {
                        numberPicker.setOnClickListener(FastSearchExpandableAdapter$createCustomNumberPicker$2.INSTANCE);
                        ((Button) findViewById3).setOnClickListener(new FastSearchExpandableAdapter$createCustomNumberPicker$3(dialog));
                        button.setOnClickListener(new FastSearchExpandableAdapter$createCustomNumberPicker$4(this, numberPicker, textView, objectRef, z, i3, dialog));
                        dialog.show();
                        Window window = dialog.getWindow();
                        if (window != null) {
                            window.setLayout(-2, -2);
                            return;
                        }
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.Button");
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.Button");
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.NumberPicker");
    }

    /* access modifiers changed from: private */
    public final void updateListOnSelectItemForSlider(int i, String str) {
        ArrayList<FacetXX> listFacet = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(i).getListFacet();
        ArrayList arrayList = new ArrayList();
        if (listFacet != null) {
            int i2 = 0;
            for (Object next : listFacet) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                FacetXX facetXX = (FacetXX) next;
                facetXX.setSelected(true);
                facetXX.setValue(str);
                arrayList.add(facetXX);
                i2 = i3;
            }
        }
        SearchMappingGroup searchMappingGroup = BDTUtils.INSTANCE.getSearchMappingArray().get(this.tabPosition).getGroups().get(i);
        Intrinsics.checkExpressionValueIsNotNull(searchMappingGroup, "BDTUtils.searchMappingAr…osition].groups[groupPos]");
        BDTUtils.INSTANCE.getExpandableListDetail().put(searchMappingGroup, arrayList);
        notifyDataSetChanged();
        OnFilterItemClickListener onFilterItemClickListener = this.onItemClickListener;
        if (onFilterItemClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onItemClickListener");
        }
        onFilterItemClickListener.onSliderItemClick(i);
    }
}
