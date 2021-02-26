package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.extensions.String_ExtensionKt;
import com.iaai.android.bdt.model.filter.MakeModelValues;
import com.iaai.android.databinding.RowMakeItemFilterBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000389:B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\bJ\b\u0010\u001b\u001a\u00020\u0010H\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010H\u0016J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0010H\u0016J\u000e\u0010!\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u0010J\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u0010J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0010H\u0016J\u000e\u0010'\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010(\u001a\u00020\u001f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u0010J(\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020.2\b\b\u0002\u00101\u001a\u00020.J\u001e\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020.J \u00104\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u00103\u001a\u00020.2\b\b\u0002\u00105\u001a\u00020\u0019J\u001e\u00106\u001a\u00020\u001f2\u0006\u00103\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u00100\u001a\u00020.J\u001e\u00107\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020.R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X.¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0005R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006;"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/filter/MakeModelFilterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "filterValues", "", "Lcom/iaai/android/bdt/model/filter/MakeModelValues;", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "onItemClickListener", "Lcom/iaai/android/bdt/feature/findVehiclePage/filter/MakeModelFilterAdapter$OnItemClickListener;", "recentUsedListCount", "", "getRecentUsedListCount", "()I", "setRecentUsedListCount", "(I)V", "selectedPosition", "getSelectedPosition", "setSelectedPosition", "checkMakeExistAfterLimitExceed", "", "makeModels", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onClickAllMake", "onClickModel", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setClickListener", "setFilterData", "results", "setRecentlyCount", "count", "updateActionMakeModelsList", "modelValue", "", "isSelect", "makeName", "makeVaue", "updateAllMakeRecentlyUsedList", "makeValue", "updateMakeList", "isMake", "updateModelList", "updateModelsRecentlyUsedList", "Companion", "MakeViewHolder", "OnItemClickListener", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: MakeModelFilterAdapter.kt */
public final class MakeModelFilterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_ITEM = 1;
    /* access modifiers changed from: private */
    public List<MakeModelValues> filterValues;
    @NotNull
    private Context mContext;
    /* access modifiers changed from: private */
    public OnItemClickListener onItemClickListener;
    private int recentUsedListCount;
    private int selectedPosition = -1;

    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    public MakeModelFilterAdapter(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.mContext = context;
    }

    public static final /* synthetic */ List access$getFilterValues$p(MakeModelFilterAdapter makeModelFilterAdapter) {
        List<MakeModelValues> list = makeModelFilterAdapter.filterValues;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterValues");
        }
        return list;
    }

    public static final /* synthetic */ OnItemClickListener access$getOnItemClickListener$p(MakeModelFilterAdapter makeModelFilterAdapter) {
        OnItemClickListener onItemClickListener2 = makeModelFilterAdapter.onItemClickListener;
        if (onItemClickListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onItemClickListener");
        }
        return onItemClickListener2;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    public final void setMContext(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "<set-?>");
        this.mContext = context;
    }

    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    public final void setSelectedPosition(int i) {
        this.selectedPosition = i;
    }

    public final int getRecentUsedListCount() {
        return this.recentUsedListCount;
    }

    public final void setRecentUsedListCount(int i) {
        this.recentUsedListCount = i;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/filter/MakeModelFilterAdapter$Companion;", "", "()V", "TYPE_HEADER", "", "TYPE_ITEM", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: MakeModelFilterAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof MakeViewHolder) {
            List<MakeModelValues> list = this.filterValues;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterValues");
            }
            String displayText = list.get(i).getDisplayText();
            if (displayText == null) {
                displayText = "";
            }
            List<MakeModelValues> list2 = this.filterValues;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterValues");
            }
            boolean isMake = list2.get(i).isMake();
            List<MakeModelValues> list3 = this.filterValues;
            if (list3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterValues");
            }
            Integer filterCount = list3.get(i).getFilterCount();
            List<MakeModelValues> list4 = this.filterValues;
            if (list4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterValues");
            }
            boolean isSelected = list4.get(i).isSelected();
            boolean z = false;
            if (isMake) {
                View view = viewHolder.itemView;
                Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
                TextView textView = (TextView) view.findViewById(C2723R.C2726id.tvMakeLabel);
                Intrinsics.checkExpressionValueIsNotNull(textView, "holder.itemView.tvMakeLabel");
                textView.setVisibility(0);
                View view2 = viewHolder.itemView;
                Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
                ConstraintLayout constraintLayout = (ConstraintLayout) view2.findViewById(C2723R.C2726id.clContainer);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "holder.itemView.clContainer");
                constraintLayout.setVisibility(8);
            } else {
                View view3 = viewHolder.itemView;
                Intrinsics.checkExpressionValueIsNotNull(view3, "holder.itemView");
                TextView textView2 = (TextView) view3.findViewById(C2723R.C2726id.tvMakeLabel);
                Intrinsics.checkExpressionValueIsNotNull(textView2, "holder.itemView.tvMakeLabel");
                textView2.setVisibility(8);
                View view4 = viewHolder.itemView;
                Intrinsics.checkExpressionValueIsNotNull(view4, "holder.itemView");
                ConstraintLayout constraintLayout2 = (ConstraintLayout) view4.findViewById(C2723R.C2726id.clContainer);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "holder.itemView.clContainer");
                constraintLayout2.setVisibility(0);
            }
            ((MakeViewHolder) viewHolder).bindFilterText(displayText, filterCount != null ? filterCount.intValue() : 0);
            View view5 = viewHolder.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view5, "holder.itemView");
            ConstraintLayout constraintLayout3 = (ConstraintLayout) view5.findViewById(C2723R.C2726id.clContainer);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout3, "holder.itemView.clContainer");
            if (this.selectedPosition == i) {
                z = true;
            }
            constraintLayout3.setSelected(z);
            View view6 = viewHolder.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view6, "holder.itemView");
            ConstraintLayout constraintLayout4 = (ConstraintLayout) view6.findViewById(C2723R.C2726id.clContainer);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout4, "holder.itemView.clContainer");
            constraintLayout4.setSelected(isSelected);
            viewHolder.itemView.setOnClickListener(new MakeModelFilterAdapter$onBindViewHolder$1(this, isMake, viewHolder));
        }
    }

    public final void onClickAllMake(int i) {
        String str;
        String displayText;
        List<MakeModelValues> list = this.filterValues;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterValues");
        }
        MakeModelValues makeInfo = list.get(i).getMakeInfo();
        String str2 = "";
        if (makeInfo == null || (str = makeInfo.getDisplayText()) == null) {
            str = str2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("All ");
        List<MakeModelValues> list2 = this.filterValues;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterValues");
        }
        MakeModelValues makeInfo2 = list2.get(i).getMakeInfo();
        sb.append(makeInfo2 != null ? makeInfo2.getDisplayText() : null);
        String sb2 = sb.toString();
        List<MakeModelValues> list3 = this.filterValues;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterValues");
        }
        MakeModelValues makeModelValues = list3.get(i);
        List<MakeModelValues> list4 = this.filterValues;
        if (list4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterValues");
        }
        makeModelValues.setSelected(!list4.get(i).isSelected());
        notifyItemChanged(i);
        updateModelList(str, i, sb2);
        List<MakeModelValues> list5 = this.filterValues;
        if (list5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterValues");
        }
        if (StringsKt.equals(list5.get(0).getDisplayText(), "Recently used filters", true)) {
            List<MakeModelValues> list6 = this.filterValues;
            if (list6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterValues");
            }
            updateAllMakeRecentlyUsedList(str, list6.get(i).isSelected(), sb2);
            if (i <= this.recentUsedListCount) {
                List<MakeModelValues> list7 = this.filterValues;
                if (list7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("filterValues");
                }
                String displayText2 = list7.get(i).getDisplayText();
                if (displayText2 == null) {
                    displayText2 = str2;
                }
                List<MakeModelValues> list8 = this.filterValues;
                if (list8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("filterValues");
                }
                boolean isSelected = list8.get(i).isSelected();
                List<MakeModelValues> list9 = this.filterValues;
                if (list9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("filterValues");
                }
                MakeModelValues makeInfo3 = list9.get(i).getMakeInfo();
                if (!(makeInfo3 == null || (displayText = makeInfo3.getDisplayText()) == null)) {
                    str2 = displayText;
                }
                updateActionMakeModelsList(displayText2, isSelected, str2, sb2);
            }
        }
        List<MakeModelValues> list10 = this.filterValues;
        if (list10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterValues");
        }
        if (list10.get(i).isSelected()) {
            OnItemClickListener onItemClickListener2 = this.onItemClickListener;
            if (onItemClickListener2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("onItemClickListener");
            }
            List<MakeModelValues> list11 = this.filterValues;
            if (list11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterValues");
            }
            onItemClickListener2.removeSelectedFilter(list11.get(i), str);
        }
    }

    public final void onClickModel(int i) {
        String str;
        String str2;
        String displayText;
        List<MakeModelValues> list = this.filterValues;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterValues");
        }
        MakeModelValues makeModelValues = list.get(this.selectedPosition);
        List<MakeModelValues> list2 = this.filterValues;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterValues");
        }
        makeModelValues.setSelected(!list2.get(i).isSelected());
        notifyItemChanged(this.selectedPosition);
        StringBuilder sb = new StringBuilder();
        sb.append("All ");
        List<MakeModelValues> list3 = this.filterValues;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterValues");
        }
        MakeModelValues makeInfo = list3.get(i).getMakeInfo();
        sb.append(makeInfo != null ? makeInfo.getDisplayText() : null);
        String sb2 = sb.toString();
        List<MakeModelValues> list4 = this.filterValues;
        if (list4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterValues");
        }
        String displayText2 = list4.get(i).getDisplayText();
        if (displayText2 == null) {
            displayText2 = "";
        }
        List<MakeModelValues> list5 = this.filterValues;
        if (list5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterValues");
        }
        MakeModelValues makeInfo2 = list5.get(i).getMakeInfo();
        if (makeInfo2 == null || (displayText = makeInfo2.getDisplayText()) == null) {
            str = "";
        } else {
            str = displayText;
        }
        updateMakeList$default(this, i, sb2, false, 4, (Object) null);
        List<MakeModelValues> list6 = this.filterValues;
        if (list6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterValues");
        }
        if (StringsKt.equals(list6.get(0).getDisplayText(), "Recently used filters", true)) {
            List<MakeModelValues> list7 = this.filterValues;
            if (list7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterValues");
            }
            updateModelsRecentlyUsedList(displayText2, list7.get(i).isSelected(), str);
            if (i <= this.recentUsedListCount) {
                List<MakeModelValues> list8 = this.filterValues;
                if (list8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("filterValues");
                }
                String displayText3 = list8.get(i).getDisplayText();
                if (displayText3 == null) {
                    displayText3 = "";
                }
                List<MakeModelValues> list9 = this.filterValues;
                if (list9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("filterValues");
                }
                boolean isSelected = list9.get(i).isSelected();
                List<MakeModelValues> list10 = this.filterValues;
                if (list10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("filterValues");
                }
                MakeModelValues makeInfo3 = list10.get(i).getMakeInfo();
                if (makeInfo3 == null || (str2 = makeInfo3.getDisplayText()) == null) {
                    str2 = "";
                }
                updateActionMakeModelsList(displayText3, isSelected, str2, sb2);
            }
        }
        OnItemClickListener onItemClickListener2 = this.onItemClickListener;
        if (onItemClickListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onItemClickListener");
        }
        List<MakeModelValues> list11 = this.filterValues;
        if (list11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterValues");
        }
        onItemClickListener2.removeAllMakeSelectedFilter(list11.get(this.selectedPosition), sb2);
    }

    public final boolean checkMakeExistAfterLimitExceed(@NotNull MakeModelValues makeModelValues) {
        Intrinsics.checkParameterIsNotNull(makeModelValues, "makeModels");
        List<MakeModelValues> list = this.filterValues;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterValues");
        }
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            MakeModelValues makeInfo = ((MakeModelValues) next).getMakeInfo();
            String str = null;
            String displayText = makeInfo != null ? makeInfo.getDisplayText() : null;
            MakeModelValues makeInfo2 = makeModelValues.getMakeInfo();
            if (makeInfo2 != null) {
                str = makeInfo2.getDisplayText();
            }
            if (Intrinsics.areEqual((Object) displayText, (Object) str)) {
                arrayList.add(next);
            }
        }
        for (MakeModelValues isSelected : (List) arrayList) {
            if (isSelected.isSelected()) {
                return true;
            }
        }
        return false;
    }

    public final void setRecentlyCount(int i) {
        this.recentUsedListCount = i;
    }

    public final void setFilterData(@NotNull List<MakeModelValues> list) {
        Intrinsics.checkParameterIsNotNull(list, "results");
        this.filterValues = list;
    }

    public static /* synthetic */ void updateMakeList$default(MakeModelFilterAdapter makeModelFilterAdapter, int i, String str, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        makeModelFilterAdapter.updateMakeList(i, str, z);
    }

    public final void updateMakeList(int i, @NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "makeValue");
        List<MakeModelValues> list = this.filterValues;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterValues");
        }
        int i2 = 0;
        for (Object next : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            MakeModelValues makeModelValues = (MakeModelValues) next;
            if (StringsKt.equals(makeModelValues.getDisplayText(), str, true) && makeModelValues.isSelected()) {
                List<MakeModelValues> list2 = this.filterValues;
                if (list2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("filterValues");
                }
                list2.get(i2).setSelected(false);
                notifyItemChanged(i2);
            }
            i2 = i3;
        }
    }

    public final void updateModelList(@NotNull String str, int i, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "makeValue");
        Intrinsics.checkParameterIsNotNull(str2, "makeName");
        List<MakeModelValues> list = this.filterValues;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterValues");
        }
        int i2 = 0;
        for (Object next : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            MakeModelValues makeModelValues = (MakeModelValues) next;
            MakeModelValues makeInfo = makeModelValues.getMakeInfo();
            if (StringsKt.equals(makeInfo != null ? makeInfo.getDisplayText() : null, str, true) && !StringsKt.equals(makeModelValues.getDisplayText(), str2, true) && makeModelValues.isSelected()) {
                List<MakeModelValues> list2 = this.filterValues;
                if (list2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("filterValues");
                }
                list2.get(i2).setSelected(false);
                notifyItemChanged(i2);
            }
            i2 = i3;
        }
    }

    public final void updateAllMakeRecentlyUsedList(@NotNull String str, boolean z, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "makeValue");
        Intrinsics.checkParameterIsNotNull(str2, "makeName");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        List<MakeModelValues> list = this.filterValues;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterValues");
        }
        int i = 0;
        objectRef.element = list.subList(0, this.recentUsedListCount);
        for (Object next : (List) objectRef.element) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (StringsKt.equals(((MakeModelValues) next).getDisplayText(), str2, true)) {
                ((MakeModelValues) ((List) objectRef.element).get(i)).setSelected(z);
                notifyItemChanged(i);
            }
            i = i2;
        }
    }

    public final void updateModelsRecentlyUsedList(@NotNull String str, boolean z, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "modelValue");
        Intrinsics.checkParameterIsNotNull(str2, "makeName");
        List<MakeModelValues> list = this.filterValues;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterValues");
        }
        int i = 0;
        for (Object next : list.subList(0, this.recentUsedListCount)) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            MakeModelValues makeModelValues = (MakeModelValues) next;
            MakeModelValues makeInfo = makeModelValues.getMakeInfo();
            if (StringsKt.equals(makeInfo != null ? makeInfo.getDisplayText() : null, str2, true) && StringsKt.equals(makeModelValues.getDisplayText(), str, true)) {
                List<MakeModelValues> list2 = this.filterValues;
                if (list2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("filterValues");
                }
                list2.get(i).setSelected(z);
                notifyItemChanged(i);
            }
            i = i2;
        }
    }

    public static /* synthetic */ void updateActionMakeModelsList$default(MakeModelFilterAdapter makeModelFilterAdapter, String str, boolean z, String str2, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = "";
        }
        makeModelFilterAdapter.updateActionMakeModelsList(str, z, str2, str3);
    }

    public final void updateActionMakeModelsList(@NotNull String str, boolean z, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "modelValue");
        Intrinsics.checkParameterIsNotNull(str2, "makeName");
        Intrinsics.checkParameterIsNotNull(str3, "makeVaue");
        List<MakeModelValues> list = this.filterValues;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterValues");
        }
        int i = 0;
        for (MakeModelValues makeModelValues : list) {
            List<MakeModelValues> list2 = this.filterValues;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filterValues");
            }
            if (StringsKt.equals(list2.get(i).getDisplayText(), str, true)) {
                List<MakeModelValues> list3 = this.filterValues;
                if (list3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("filterValues");
                }
                MakeModelValues makeInfo = list3.get(i).getMakeInfo();
                if (!StringsKt.equals(makeInfo != null ? makeInfo.getDisplayText() : null, str2, true)) {
                    continue;
                } else {
                    List<MakeModelValues> list4 = this.filterValues;
                    if (list4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("filterValues");
                    }
                    if (z != list4.get(i).isSelected()) {
                        List<MakeModelValues> list5 = this.filterValues;
                        if (list5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("filterValues");
                        }
                        list5.get(i).setSelected(z);
                        notifyItemChanged(i);
                        return;
                    }
                }
            }
            i++;
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.row_make_item_filter, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…em_filter, parent, false)");
        return new MakeViewHolder(this, (RowMakeItemFilterBinding) inflate);
    }

    public final void setClickListener(@NotNull OnItemClickListener onItemClickListener2) {
        Intrinsics.checkParameterIsNotNull(onItemClickListener2, "onItemClickListener");
        this.onItemClickListener = onItemClickListener2;
    }

    public int getItemCount() {
        List<MakeModelValues> list = this.filterValues;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filterValues");
        }
        return list.size();
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/filter/MakeModelFilterAdapter$MakeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowMakeItemFilterBinding;", "(Lcom/iaai/android/bdt/feature/findVehiclePage/filter/MakeModelFilterAdapter;Lcom/iaai/android/databinding/RowMakeItemFilterBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowMakeItemFilterBinding;", "setBinding", "(Lcom/iaai/android/databinding/RowMakeItemFilterBinding;)V", "bindFilterText", "", "filterText", "", "filterCount", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: MakeModelFilterAdapter.kt */
    public final class MakeViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private RowMakeItemFilterBinding binding;
        final /* synthetic */ MakeModelFilterAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MakeViewHolder(@NotNull MakeModelFilterAdapter makeModelFilterAdapter, RowMakeItemFilterBinding rowMakeItemFilterBinding) {
            super(rowMakeItemFilterBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowMakeItemFilterBinding, "binding");
            this.this$0 = makeModelFilterAdapter;
            this.binding = rowMakeItemFilterBinding;
        }

        @NotNull
        public final RowMakeItemFilterBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull RowMakeItemFilterBinding rowMakeItemFilterBinding) {
            Intrinsics.checkParameterIsNotNull(rowMakeItemFilterBinding, "<set-?>");
            this.binding = rowMakeItemFilterBinding;
        }

        public final void bindFilterText(@NotNull String str, int i) {
            Intrinsics.checkParameterIsNotNull(str, "filterText");
            TextView textView = this.binding.tvMakeLabel;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvMakeLabel");
            CharSequence charSequence = str;
            textView.setText(charSequence);
            if (StringsKt.startsWith(str, "All", true)) {
                TextView textView2 = this.binding.tvFilterText;
                Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvFilterText");
                textView2.setText(String_ExtensionKt.toCamelCase(str));
                return;
            }
            TextView textView3 = this.binding.tvFilterText;
            Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.tvFilterText");
            textView3.setText(charSequence);
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\u001a\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bH&J\u001a\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u0005H&¨\u0006\u000e"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/filter/MakeModelFilterAdapter$OnItemClickListener;", "", "getMakeSelectedCount", "", "onItemClick", "", "selectedFilter", "Lcom/iaai/android/bdt/model/filter/MakeModelValues;", "position", "removeAllMakeSelectedFilter", "allMakeModel", "", "removeSelectedFilter", "showErrorMsg", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: MakeModelFilterAdapter.kt */
    public interface OnItemClickListener {
        int getMakeSelectedCount();

        void onItemClick(@NotNull MakeModelValues makeModelValues, int i);

        void removeAllMakeSelectedFilter(@NotNull MakeModelValues makeModelValues, @NotNull String str);

        void removeSelectedFilter(@NotNull MakeModelValues makeModelValues, @NotNull String str);

        void showErrorMsg();

        @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
        /* compiled from: MakeModelFilterAdapter.kt */
        public static final class DefaultImpls {
            public static /* synthetic */ void removeSelectedFilter$default(OnItemClickListener onItemClickListener, MakeModelValues makeModelValues, String str, int i, Object obj) {
                if (obj == null) {
                    if ((i & 2) != 0) {
                        str = "";
                    }
                    onItemClickListener.removeSelectedFilter(makeModelValues, str);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeSelectedFilter");
            }

            public static /* synthetic */ void removeAllMakeSelectedFilter$default(OnItemClickListener onItemClickListener, MakeModelValues makeModelValues, String str, int i, Object obj) {
                if (obj == null) {
                    if ((i & 2) != 0) {
                        str = "";
                    }
                    onItemClickListener.removeAllMakeSelectedFilter(makeModelValues, str);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeAllMakeSelectedFilter");
            }
        }
    }
}
