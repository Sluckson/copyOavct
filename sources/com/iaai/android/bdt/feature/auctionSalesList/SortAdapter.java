package com.iaai.android.bdt.feature.auctionSalesList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.sort.SortOptionData;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.databinding.LayoutSortLocationZipBinding;
import com.iaai.android.databinding.RowItemSortLayoutBinding;
import com.iaai.android.old.utils.IAASharedPreference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001:\u0004./01B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\u0018\u0010 \u001a\u00020!2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\"\u001a\u00020#J\u001c\u0010$\u001a\u00020!2\n\u0010%\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\u001c\u0010&\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0007H\u0016J\u000e\u0010*\u001a\u00020!2\u0006\u0010\u0013\u001a\u00020\u0014J*\u0010+\u001a\u00020!2\u001a\u0010,\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u001c2\u0006\u0010-\u001a\u00020\rR\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0005R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001cX\u000e¢\u0006\u0002\n\u0000¨\u00062"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionSalesList/SortAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/iaai/android/bdt/feature/auctionSalesList/SortAdapter$BaseViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TYPE_HEADER", "", "getTYPE_HEADER", "()I", "TYPE_ITEM", "getTYPE_ITEM", "isEditAvailable", "", "isFromSearch", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "onItemClickListener", "Lcom/iaai/android/bdt/feature/auctionSalesList/SortAdapter$OnItemClickListener;", "selectedPosition", "getSelectedPosition", "setSelectedPosition", "(I)V", "sortItemList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/sort/SortOptionData;", "Lkotlin/collections/ArrayList;", "getItemCount", "getItemViewType", "position", "hideKeyboardFrom", "", "view", "Landroid/view/View;", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setClickListener", "setSortOptionData", "results", "isFromSearchPage", "BaseViewHolder", "OnItemClickListener", "ViewHolder", "ViewHolderHeader", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SortAdapter.kt */
public final class SortAdapter extends RecyclerView.Adapter<BaseViewHolder<?>> {
    private final int TYPE_HEADER;
    private final int TYPE_ITEM;
    /* access modifiers changed from: private */
    public boolean isEditAvailable;
    private boolean isFromSearch;
    @NotNull
    private Context mContext;
    /* access modifiers changed from: private */
    public OnItemClickListener onItemClickListener;
    private int selectedPosition;
    /* access modifiers changed from: private */
    public ArrayList<SortOptionData> sortItemList = new ArrayList<>();

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionSalesList/SortAdapter$OnItemClickListener;", "", "onItemClick", "", "sortItem", "Lcom/iaai/android/bdt/model/sort/SortOptionData;", "position", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SortAdapter.kt */
    public interface OnItemClickListener {
        void onItemClick(@NotNull SortOptionData sortOptionData, int i);
    }

    public SortAdapter(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.mContext = context;
        this.TYPE_ITEM = 1;
    }

    public static final /* synthetic */ OnItemClickListener access$getOnItemClickListener$p(SortAdapter sortAdapter) {
        OnItemClickListener onItemClickListener2 = sortAdapter.onItemClickListener;
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

    public final int getTYPE_HEADER() {
        return this.TYPE_HEADER;
    }

    public final int getTYPE_ITEM() {
        return this.TYPE_ITEM;
    }

    public void onBindViewHolder(@NotNull BaseViewHolder<?> baseViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "holder");
        ArrayList<SortOptionData> arrayList = this.sortItemList;
        if (arrayList == null) {
            Intrinsics.throwNpe();
        }
        SortOptionData sortOptionData = arrayList.get(i);
        Intrinsics.checkExpressionValueIsNotNull(sortOptionData, "sortItemList!![position]");
        SortOptionData sortOptionData2 = sortOptionData;
        int itemViewType = getItemViewType(i);
        if (itemViewType == this.TYPE_HEADER) {
            baseViewHolder.bind(sortOptionData2);
        } else if (itemViewType == this.TYPE_ITEM) {
            View view = baseViewHolder.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C2723R.C2726id.layout_sort_container);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "holder.itemView.layout_sort_container");
            linearLayout.setSelected(sortOptionData2.isSelected());
            baseViewHolder.itemView.setOnClickListener(new SortAdapter$onBindViewHolder$1(this, baseViewHolder));
            baseViewHolder.bind(sortOptionData2);
        }
    }

    public final void setSortOptionData(@Nullable ArrayList<SortOptionData> arrayList, boolean z) {
        if (arrayList == null) {
            Intrinsics.throwNpe();
        }
        this.sortItemList = arrayList;
        this.isFromSearch = z;
    }

    public int getItemViewType(int i) {
        return (i != 0 || !this.isFromSearch) ? this.TYPE_ITEM : this.TYPE_HEADER;
    }

    @NotNull
    public BaseViewHolder<?> onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == this.TYPE_HEADER) {
            ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.layout_sort_location_zip, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…ation_zip, parent, false)");
            return new ViewHolderHeader(this, (LayoutSortLocationZipBinding) inflate);
        } else if (i == this.TYPE_ITEM) {
            ViewDataBinding inflate2 = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.row_item_sort_layout, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, "DataBindingUtil.inflate(…rt_layout, parent, false)");
            return new ViewHolder(this, (RowItemSortLayoutBinding) inflate2);
        } else {
            throw new IllegalArgumentException("Invalid view type");
        }
    }

    public final void setClickListener(@NotNull OnItemClickListener onItemClickListener2) {
        Intrinsics.checkParameterIsNotNull(onItemClickListener2, "onItemClickListener");
        this.onItemClickListener = onItemClickListener2;
    }

    public int getItemCount() {
        ArrayList<SortOptionData> arrayList = this.sortItemList;
        if (arrayList == null) {
            return 0;
        }
        if (arrayList == null) {
            Intrinsics.throwNpe();
        }
        return arrayList.size();
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionSalesList/SortAdapter$BaseViewHolder;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "item", "Lcom/iaai/android/bdt/model/sort/SortOptionData;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SortAdapter.kt */
    public static abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
        public abstract void bind(@NotNull SortOptionData sortOptionData);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BaseViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkParameterIsNotNull(view, "itemView");
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionSalesList/SortAdapter$ViewHolder;", "Lcom/iaai/android/bdt/feature/auctionSalesList/SortAdapter$BaseViewHolder;", "Lcom/iaai/android/bdt/model/sort/SortOptionData;", "binding", "Lcom/iaai/android/databinding/RowItemSortLayoutBinding;", "(Lcom/iaai/android/bdt/feature/auctionSalesList/SortAdapter;Lcom/iaai/android/databinding/RowItemSortLayoutBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemSortLayoutBinding;", "setBinding", "(Lcom/iaai/android/databinding/RowItemSortLayoutBinding;)V", "bind", "", "item", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SortAdapter.kt */
    public final class ViewHolder extends BaseViewHolder<SortOptionData> {
        @NotNull
        private RowItemSortLayoutBinding binding;
        final /* synthetic */ SortAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ViewHolder(@org.jetbrains.annotations.NotNull com.iaai.android.bdt.feature.auctionSalesList.SortAdapter r2, com.iaai.android.databinding.RowItemSortLayoutBinding r3) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
                r1.this$0 = r2
                android.view.View r2 = r3.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r0)
                r1.<init>(r2)
                r1.binding = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.auctionSalesList.SortAdapter.ViewHolder.<init>(com.iaai.android.bdt.feature.auctionSalesList.SortAdapter, com.iaai.android.databinding.RowItemSortLayoutBinding):void");
        }

        @NotNull
        public final RowItemSortLayoutBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull RowItemSortLayoutBinding rowItemSortLayoutBinding) {
            Intrinsics.checkParameterIsNotNull(rowItemSortLayoutBinding, "<set-?>");
            this.binding = rowItemSortLayoutBinding;
        }

        public void bind(@NotNull SortOptionData sortOptionData) {
            Intrinsics.checkParameterIsNotNull(sortOptionData, "item");
            TextView textView = this.binding.tvSort;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvSort");
            textView.setText(sortOptionData.getDisplayText());
        }
    }

    public final void hideKeyboardFrom(@Nullable Context context, @NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        view.clearFocus();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        Object systemService = context.getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionSalesList/SortAdapter$ViewHolderHeader;", "Lcom/iaai/android/bdt/feature/auctionSalesList/SortAdapter$BaseViewHolder;", "Lcom/iaai/android/bdt/model/sort/SortOptionData;", "binding", "Lcom/iaai/android/databinding/LayoutSortLocationZipBinding;", "(Lcom/iaai/android/bdt/feature/auctionSalesList/SortAdapter;Lcom/iaai/android/databinding/LayoutSortLocationZipBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/LayoutSortLocationZipBinding;", "setBinding", "(Lcom/iaai/android/databinding/LayoutSortLocationZipBinding;)V", "enteredZip", "", "bind", "", "item", "inVisibleApplyButton", "visibleApplyButton", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SortAdapter.kt */
    public final class ViewHolderHeader extends BaseViewHolder<SortOptionData> {
        @NotNull
        private LayoutSortLocationZipBinding binding;
        /* access modifiers changed from: private */
        public String enteredZip = "";
        final /* synthetic */ SortAdapter this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ViewHolderHeader(@org.jetbrains.annotations.NotNull com.iaai.android.bdt.feature.auctionSalesList.SortAdapter r2, com.iaai.android.databinding.LayoutSortLocationZipBinding r3) {
            /*
                r1 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
                r1.this$0 = r2
                android.view.View r2 = r3.getRoot()
                java.lang.String r0 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r0)
                r1.<init>(r2)
                r1.binding = r3
                java.lang.String r2 = ""
                r1.enteredZip = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.auctionSalesList.SortAdapter.ViewHolderHeader.<init>(com.iaai.android.bdt.feature.auctionSalesList.SortAdapter, com.iaai.android.databinding.LayoutSortLocationZipBinding):void");
        }

        @NotNull
        public final LayoutSortLocationZipBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull LayoutSortLocationZipBinding layoutSortLocationZipBinding) {
            Intrinsics.checkParameterIsNotNull(layoutSortLocationZipBinding, "<set-?>");
            this.binding = layoutSortLocationZipBinding;
        }

        public void bind(@NotNull SortOptionData sortOptionData) {
            Intrinsics.checkParameterIsNotNull(sortOptionData, "item");
            String lastUsedZipCode = IAASharedPreference.getLastUsedZipCode(this.this$0.getMContext());
            Intrinsics.checkExpressionValueIsNotNull(lastUsedZipCode, "IAASharedPreference.getLastUsedZipCode(mContext)");
            this.enteredZip = lastUsedZipCode;
            if (!(this.enteredZip.length() > 0) || this.this$0.isEditAvailable) {
                visibleApplyButton();
            } else {
                inVisibleApplyButton();
            }
            SortAdapter sortAdapter = this.this$0;
            Context mContext = sortAdapter.getMContext();
            EditText editText = this.binding.enterZipCode;
            Intrinsics.checkExpressionValueIsNotNull(editText, "binding.enterZipCode");
            sortAdapter.hideKeyboardFrom(mContext, editText);
            if (Intrinsics.areEqual((Object) sortOptionData.getDisplayText(), (Object) Constants_MVVM.SORT_MY_LOCATION_KEY)) {
                TextView textView = this.binding.locationSort;
                Intrinsics.checkExpressionValueIsNotNull(textView, "binding.locationSort");
                textView.setSelected(true);
            } else if (Intrinsics.areEqual((Object) sortOptionData.getDisplayText(), (Object) Constants_MVVM.SORT_ZIPCODE_KEY) && !this.this$0.isEditAvailable) {
                RelativeLayout relativeLayout = this.binding.rlZipCodeMain;
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "binding.rlZipCodeMain");
                relativeLayout.setSelected(true);
                String lastUsedZipCode2 = IAASharedPreference.getLastUsedZipCode(this.this$0.getMContext());
                Intrinsics.checkExpressionValueIsNotNull(lastUsedZipCode2, "IAASharedPreference.getLastUsedZipCode(mContext)");
                this.enteredZip = lastUsedZipCode2;
                this.binding.tvSortZip.setTextColor(this.this$0.getMContext().getResources().getColor(C2723R.C2724color.bdt_white));
                this.binding.tvZipCodeLabel.setTextColor(this.this$0.getMContext().getResources().getColor(C2723R.C2724color.bdt_white));
                inVisibleApplyButton();
            }
            this.binding.locationSort.setOnClickListener(new SortAdapter$ViewHolderHeader$bind$1(this));
            this.binding.rlZipCodeMain.setOnClickListener(new SortAdapter$ViewHolderHeader$bind$2(this));
            this.binding.btnZipApply.setOnClickListener(new SortAdapter$ViewHolderHeader$bind$3(this));
            this.binding.tvEditZip.setOnClickListener(new SortAdapter$ViewHolderHeader$bind$4(this));
            this.binding.enterZipCode.addTextChangedListener(new SortAdapter$ViewHolderHeader$bind$5(this));
            this.binding.enterZipCode.setOnClickListener(new SortAdapter$ViewHolderHeader$bind$6(this));
        }

        /* access modifiers changed from: private */
        public final void inVisibleApplyButton() {
            LinearLayout linearLayout = this.binding.llApplyZip;
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "binding.llApplyZip");
            linearLayout.setVisibility(8);
            TextView textView = this.binding.tvEditZip;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvEditZip");
            textView.setVisibility(0);
            View view = this.binding.viewEditZipDivider;
            Intrinsics.checkExpressionValueIsNotNull(view, "binding.viewEditZipDivider");
            view.setVisibility(0);
            TextView textView2 = this.binding.tvSortZip;
            Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvSortZip");
            textView2.setText(this.enteredZip);
            TextView textView3 = this.binding.tvSortZip;
            Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.tvSortZip");
            textView3.setVisibility(0);
        }

        /* access modifiers changed from: private */
        public final void visibleApplyButton() {
            LinearLayout linearLayout = this.binding.llApplyZip;
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "binding.llApplyZip");
            linearLayout.setVisibility(0);
            TextView textView = this.binding.tvEditZip;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvEditZip");
            textView.setVisibility(8);
            View view = this.binding.viewEditZipDivider;
            Intrinsics.checkExpressionValueIsNotNull(view, "binding.viewEditZipDivider");
            view.setVisibility(8);
            this.binding.enterZipCode.setText("");
            Button button = this.binding.btnZipApply;
            Intrinsics.checkExpressionValueIsNotNull(button, "binding.btnZipApply");
            button.setEnabled(false);
            Button button2 = this.binding.btnZipApply;
            Intrinsics.checkExpressionValueIsNotNull(button2, "binding.btnZipApply");
            button2.setAlpha(0.5f);
            RelativeLayout relativeLayout = this.binding.rlZipCodeMain;
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "binding.rlZipCodeMain");
            relativeLayout.setSelected(false);
            this.binding.tvSortZip.setTextColor(this.this$0.getMContext().getResources().getColor(C2723R.C2724color.bdt_gray_darkest));
            this.binding.tvZipCodeLabel.setTextColor(this.this$0.getMContext().getResources().getColor(C2723R.C2724color.bdt_gray_darkest));
        }
    }
}
