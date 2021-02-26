package com.iaai.android.bdt.feature.productDetail.chromeSection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.productDetail.chromeSection.Attribute;
import com.iaai.android.bdt.model.productDetail.chromeSection.GroupData;
import com.iaai.android.bdt.model.productDetail.chromeSection.HeaderValue;
import com.iaai.android.bdt.model.productDetail.chromeSection.TechSpecsData;
import com.iaai.android.bdt.utils.ChromeSectionMode;
import com.iaai.android.databinding.RowItemChromeDataLayoutBinding;
import com.iaai.android.old.utils.constants.Constants;
import com.lowagie.text.xml.TagMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001'B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u001c\u0010\u001a\u001a\u00020\u001b2\n\u0010\u001c\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J\u001c\u0010\u001e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0019H\u0016J\u0014\u0010\"\u001a\u00020\u001b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0014\u0010$\u001a\u00020\u001b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0014\u0010%\u001a\u00020\u001b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0014\u0010&\u001a\u00020\u001b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170\tR\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006("}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/chromeSection/ChromeSectionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/iaai/android/bdt/feature/productDetail/chromeSection/ChromeSectionAdapter$ViewHolder;", "context", "Landroid/content/Context;", "mode", "Lcom/iaai/android/bdt/utils/ChromeSectionMode;", "(Landroid/content/Context;Lcom/iaai/android/bdt/utils/ChromeSectionMode;)V", "factOptionsAttributeList", "", "Lcom/iaai/android/bdt/model/productDetail/chromeSection/Attribute;", "genEquipmentAttributesList", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "getMode", "()Lcom/iaai/android/bdt/utils/ChromeSectionMode;", "setMode", "(Lcom/iaai/android/bdt/utils/ChromeSectionMode;)V", "stanEquipmentAttributesList", "techSpecificationsList", "Lcom/iaai/android/bdt/model/productDetail/chromeSection/TechSpecsData;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setFactOptionsAttributeList", "results", "setGenEquipmentAttributeList", "setStanEquipmentAttributeList", "setTechSpecificationsList", "ViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ChromeSectionAdapter.kt */
public final class ChromeSectionAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Attribute> factOptionsAttributeList;
    private List<Attribute> genEquipmentAttributesList;
    @NotNull
    private Context mContext;
    @NotNull
    private ChromeSectionMode mode;
    private List<Attribute> stanEquipmentAttributesList;
    private List<TechSpecsData> techSpecificationsList;

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[ChromeSectionMode.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = new int[ChromeSectionMode.values().length];

        static {
            $EnumSwitchMapping$0[ChromeSectionMode.FACT_OPTIONS.ordinal()] = 1;
            $EnumSwitchMapping$0[ChromeSectionMode.GEN_EQUIPMENT.ordinal()] = 2;
            $EnumSwitchMapping$0[ChromeSectionMode.STAN_EQUIPMENT.ordinal()] = 3;
            $EnumSwitchMapping$0[ChromeSectionMode.TECH_SPECIFICATIONS.ordinal()] = 4;
            $EnumSwitchMapping$1[ChromeSectionMode.FACT_OPTIONS.ordinal()] = 1;
            $EnumSwitchMapping$1[ChromeSectionMode.GEN_EQUIPMENT.ordinal()] = 2;
            $EnumSwitchMapping$1[ChromeSectionMode.STAN_EQUIPMENT.ordinal()] = 3;
            $EnumSwitchMapping$1[ChromeSectionMode.TECH_SPECIFICATIONS.ordinal()] = 4;
        }
    }

    public ChromeSectionAdapter(@NotNull Context context, @NotNull ChromeSectionMode chromeSectionMode) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(chromeSectionMode, Constants.EXTRA_MODE);
        this.mode = chromeSectionMode;
        this.mContext = context;
    }

    @NotNull
    public final ChromeSectionMode getMode() {
        return this.mode;
    }

    public final void setMode(@NotNull ChromeSectionMode chromeSectionMode) {
        Intrinsics.checkParameterIsNotNull(chromeSectionMode, "<set-?>");
        this.mode = chromeSectionMode;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    public final void setMContext(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "<set-?>");
        this.mContext = context;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()];
        if (i2 == 1) {
            List<Attribute> list = this.factOptionsAttributeList;
            if (list == null) {
                Intrinsics.throwNpe();
            }
            viewHolder.bindFactOptions(list.get(i));
        } else if (i2 == 2) {
            List<Attribute> list2 = this.genEquipmentAttributesList;
            if (list2 == null) {
                Intrinsics.throwNpe();
            }
            viewHolder.bindGenEquipment(list2.get(i));
        } else if (i2 == 3) {
            List<Attribute> list3 = this.stanEquipmentAttributesList;
            if (list3 == null) {
                Intrinsics.throwNpe();
            }
            viewHolder.bindStanEquipment(list3.get(i));
        } else if (i2 == 4) {
            List<TechSpecsData> list4 = this.techSpecificationsList;
            if (list4 == null) {
                Intrinsics.throwNpe();
            }
            viewHolder.bindTechSpecifications(list4.get(i));
        }
    }

    public final void setFactOptionsAttributeList(@NotNull List<Attribute> list) {
        Intrinsics.checkParameterIsNotNull(list, "results");
        this.factOptionsAttributeList = list;
    }

    public final void setGenEquipmentAttributeList(@NotNull List<Attribute> list) {
        Intrinsics.checkParameterIsNotNull(list, "results");
        this.genEquipmentAttributesList = list;
    }

    public final void setStanEquipmentAttributeList(@NotNull List<Attribute> list) {
        Intrinsics.checkParameterIsNotNull(list, "results");
        this.stanEquipmentAttributesList = list;
    }

    public final void setTechSpecificationsList(@NotNull List<TechSpecsData> list) {
        Intrinsics.checkParameterIsNotNull(list, "results");
        this.techSpecificationsList = list;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.row_item_chrome_data_layout, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…, parent, false\n        )");
        return new ViewHolder(this, (RowItemChromeDataLayoutBinding) inflate);
    }

    public int getItemCount() {
        int i = WhenMappings.$EnumSwitchMapping$1[this.mode.ordinal()];
        if (i == 1) {
            List<Attribute> list = this.factOptionsAttributeList;
            if (list == null) {
                return 0;
            }
            if (list == null) {
                Intrinsics.throwNpe();
            }
            return list.size();
        } else if (i == 2) {
            List<Attribute> list2 = this.genEquipmentAttributesList;
            if (list2 == null) {
                return 0;
            }
            if (list2 == null) {
                Intrinsics.throwNpe();
            }
            return list2.size();
        } else if (i == 3) {
            List<Attribute> list3 = this.stanEquipmentAttributesList;
            if (list3 == null) {
                return 0;
            }
            if (list3 == null) {
                Intrinsics.throwNpe();
            }
            return list3.size();
        } else if (i == 4) {
            List<TechSpecsData> list4 = this.techSpecificationsList;
            if (list4 == null) {
                return 0;
            }
            if (list4 == null) {
                Intrinsics.throwNpe();
            }
            return list4.size();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/chromeSection/ChromeSectionAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemChromeDataLayoutBinding;", "(Lcom/iaai/android/bdt/feature/productDetail/chromeSection/ChromeSectionAdapter;Lcom/iaai/android/databinding/RowItemChromeDataLayoutBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemChromeDataLayoutBinding;", "setBinding", "(Lcom/iaai/android/databinding/RowItemChromeDataLayoutBinding;)V", "bindFactOptions", "", "attribute", "Lcom/iaai/android/bdt/model/productDetail/chromeSection/Attribute;", "bindGenEquipment", "bindStanEquipment", "bindTechSpecifications", "techSpecsData", "Lcom/iaai/android/bdt/model/productDetail/chromeSection/TechSpecsData;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ChromeSectionAdapter.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private RowItemChromeDataLayoutBinding binding;
        final /* synthetic */ ChromeSectionAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull ChromeSectionAdapter chromeSectionAdapter, RowItemChromeDataLayoutBinding rowItemChromeDataLayoutBinding) {
            super(rowItemChromeDataLayoutBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemChromeDataLayoutBinding, "binding");
            this.this$0 = chromeSectionAdapter;
            this.binding = rowItemChromeDataLayoutBinding;
        }

        @NotNull
        public final RowItemChromeDataLayoutBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull RowItemChromeDataLayoutBinding rowItemChromeDataLayoutBinding) {
            Intrinsics.checkParameterIsNotNull(rowItemChromeDataLayoutBinding, "<set-?>");
            this.binding = rowItemChromeDataLayoutBinding;
        }

        public final void bindFactOptions(@NotNull Attribute attribute) {
            Intrinsics.checkParameterIsNotNull(attribute, TagMap.AttributeHandler.ATTRIBUTE);
            TextView textView = this.binding.tvAttributeName;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvAttributeName");
            String name = attribute.getName();
            if (name != null) {
                String upperCase = name.toUpperCase();
                Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase()");
                textView.setText(upperCase);
                String str = "";
                for (String str2 : attribute.getValues()) {
                    str = str + str2 + "\n";
                }
                TextView textView2 = this.binding.tvAttributeValue;
                Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvAttributeValue");
                textView2.setText(str);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }

        public final void bindGenEquipment(@NotNull Attribute attribute) {
            Intrinsics.checkParameterIsNotNull(attribute, TagMap.AttributeHandler.ATTRIBUTE);
            TextView textView = this.binding.tvAttributeName;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvAttributeName");
            String name = attribute.getName();
            if (name != null) {
                String upperCase = name.toUpperCase();
                Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase()");
                textView.setText(upperCase);
                String str = "";
                for (String str2 : attribute.getValues()) {
                    str = str + str2 + "\n";
                }
                TextView textView2 = this.binding.tvAttributeValue;
                Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvAttributeValue");
                textView2.setText(str);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }

        public final void bindStanEquipment(@NotNull Attribute attribute) {
            Intrinsics.checkParameterIsNotNull(attribute, TagMap.AttributeHandler.ATTRIBUTE);
            TextView textView = this.binding.tvAttributeName;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvAttributeName");
            String name = attribute.getName();
            if (name != null) {
                String upperCase = name.toUpperCase();
                Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase()");
                textView.setText(upperCase);
                String str = "";
                for (String str2 : attribute.getValues()) {
                    str = str + str2 + "\n";
                }
                TextView textView2 = this.binding.tvAttributeValue;
                Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvAttributeValue");
                textView2.setText(str);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }

        public final void bindTechSpecifications(@NotNull TechSpecsData techSpecsData) {
            Intrinsics.checkParameterIsNotNull(techSpecsData, "techSpecsData");
            TextView textView = this.binding.tvAttributeName;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvAttributeName");
            String groupName = techSpecsData.getGroupName();
            if (groupName != null) {
                String upperCase = groupName.toUpperCase();
                Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase()");
                textView.setText(upperCase);
                String str = "";
                for (GroupData headerValue : techSpecsData.getGroupData()) {
                    for (HeaderValue headerValue2 : headerValue.getHeaderValue()) {
                        str = str + (headerValue2.getTitleName() + "-" + headerValue2.getValue() + "-" + headerValue2.getMeasurement()) + "\n";
                    }
                }
                TextView textView2 = this.binding.tvAttributeValue;
                Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvAttributeValue");
                textView2.setText(str);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
    }
}
