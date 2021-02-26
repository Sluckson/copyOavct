package com.iaai.android.bdt.feature.findVehiclePage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.databinding.RowItemSearchSuggestionsBinding;
import com.iaai.android.old.database.SuggestionsContract;
import com.iaai.android.old.providers.IaaContent;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\"#B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u001c\u0010\u0017\u001a\u00020\u00142\n\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u001c\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0016H\u0016J\u000e\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fJ.\u0010\u001f\u001a\u00020\u00142\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\r0\u0011j\b\u0012\u0004\u0012\u00020\r`\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0005R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0011j\b\u0012\u0004\u0012\u00020\r`\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/SearchSuggestionsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/iaai/android/bdt/feature/findVehiclePage/SearchSuggestionsAdapter$SuggestionHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isRecent", "", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "mSearchText", "", "onItemClickListener", "Lcom/iaai/android/bdt/feature/findVehiclePage/SearchSuggestionsAdapter$OnItemClickListener;", "suggestionsList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "clearAllData", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setClickListener", "setSuggestionData", "suggestionList", "searchText", "OnItemClickListener", "SuggestionHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SearchSuggestionsAdapter.kt */
public final class SearchSuggestionsAdapter extends RecyclerView.Adapter<SuggestionHolder> {
    /* access modifiers changed from: private */
    public boolean isRecent;
    @NotNull
    private Context mContext;
    /* access modifiers changed from: private */
    public String mSearchText = "";
    /* access modifiers changed from: private */
    public OnItemClickListener onItemClickListener;
    private ArrayList<String> suggestionsList = new ArrayList<>();

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/SearchSuggestionsAdapter$OnItemClickListener;", "", "onItemClick", "", "selectedSuggestion", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SearchSuggestionsAdapter.kt */
    public interface OnItemClickListener {
        void onItemClick(@NotNull String str);
    }

    public SearchSuggestionsAdapter(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.mContext = context;
    }

    public static final /* synthetic */ OnItemClickListener access$getOnItemClickListener$p(SearchSuggestionsAdapter searchSuggestionsAdapter) {
        OnItemClickListener onItemClickListener2 = searchSuggestionsAdapter.onItemClickListener;
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

    @NotNull
    public SuggestionHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.row_item_search_suggestions, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…ggestions, parent, false)");
        return new SuggestionHolder(this, (RowItemSearchSuggestionsBinding) inflate);
    }

    public int getItemCount() {
        return this.suggestionsList.size();
    }

    public void onBindViewHolder(@NotNull SuggestionHolder suggestionHolder, int i) {
        Intrinsics.checkParameterIsNotNull(suggestionHolder, "holder");
        String str = this.suggestionsList.get(i);
        Intrinsics.checkExpressionValueIsNotNull(str, "suggestionsList[position]");
        String str2 = str;
        suggestionHolder.bindSuggestion(str2);
        suggestionHolder.itemView.setOnClickListener(new SearchSuggestionsAdapter$onBindViewHolder$1(this, str2));
    }

    public final void setSuggestionData(@NotNull ArrayList<String> arrayList, boolean z, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(arrayList, "suggestionList");
        Intrinsics.checkParameterIsNotNull(str, IaaContent.SearchHistory.SEARCH_TEXT);
        this.suggestionsList = arrayList;
        this.isRecent = z;
        this.mSearchText = str;
    }

    public final void clearAllData() {
        this.suggestionsList.clear();
        notifyDataSetChanged();
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/SearchSuggestionsAdapter$SuggestionHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemSearchSuggestionsBinding;", "(Lcom/iaai/android/bdt/feature/findVehiclePage/SearchSuggestionsAdapter;Lcom/iaai/android/databinding/RowItemSearchSuggestionsBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemSearchSuggestionsBinding;", "setBinding", "(Lcom/iaai/android/databinding/RowItemSearchSuggestionsBinding;)V", "bindSuggestion", "", "suggestions", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SearchSuggestionsAdapter.kt */
    public final class SuggestionHolder extends RecyclerView.ViewHolder {
        @NotNull
        private RowItemSearchSuggestionsBinding binding;
        final /* synthetic */ SearchSuggestionsAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SuggestionHolder(@NotNull SearchSuggestionsAdapter searchSuggestionsAdapter, RowItemSearchSuggestionsBinding rowItemSearchSuggestionsBinding) {
            super(rowItemSearchSuggestionsBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemSearchSuggestionsBinding, "binding");
            this.this$0 = searchSuggestionsAdapter;
            this.binding = rowItemSearchSuggestionsBinding;
        }

        @NotNull
        public final RowItemSearchSuggestionsBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull RowItemSearchSuggestionsBinding rowItemSearchSuggestionsBinding) {
            Intrinsics.checkParameterIsNotNull(rowItemSearchSuggestionsBinding, "<set-?>");
            this.binding = rowItemSearchSuggestionsBinding;
        }

        public final void bindSuggestion(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, SuggestionsContract.Suggestions.TABLE_NAME);
            if (this.this$0.mSearchText.length() > 0) {
                Locale locale = Locale.US;
                Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
                String lowerCase = str.toLowerCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                CharSequence charSequence = lowerCase;
                String access$getMSearchText$p = this.this$0.mSearchText;
                Locale locale2 = Locale.US;
                Intrinsics.checkExpressionValueIsNotNull(locale2, "Locale.US");
                if (access$getMSearchText$p != null) {
                    String lowerCase2 = access$getMSearchText$p.toLowerCase(locale2);
                    Intrinsics.checkExpressionValueIsNotNull(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                    int indexOf$default = StringsKt.indexOf$default(charSequence, lowerCase2, 0, false, 6, (Object) null);
                    int length = this.this$0.mSearchText.length() + indexOf$default;
                    if (indexOf$default != -1) {
                        SpannableString spannableString = new SpannableString(str);
                        spannableString.setSpan(new TextAppearanceSpan((String) null, 0, -1, new ColorStateList(new int[][]{new int[0]}, new int[]{ContextCompat.getColor(this.this$0.getMContext(), C2723R.C2724color.bdt_gray)}), (ColorStateList) null), indexOf$default, length, 33);
                        TextView textView = this.binding.tvSuggestion;
                        Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvSuggestion");
                        textView.setText(spannableString);
                    } else {
                        TextView textView2 = this.binding.tvSuggestion;
                        Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvSuggestion");
                        textView2.setText(str);
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                TextView textView3 = this.binding.tvSuggestion;
                Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.tvSuggestion");
                textView3.setText(str);
            }
            if (this.this$0.isRecent) {
                this.binding.ivSuggestionsIcon.setImageDrawable(this.this$0.getMContext().getResources().getDrawable(C2723R.C2725drawable.ic_clock, (Resources.Theme) null));
            } else {
                this.binding.ivSuggestionsIcon.setImageDrawable(this.this$0.getMContext().getResources().getDrawable(C2723R.C2725drawable.ic_search_find, (Resources.Theme) null));
            }
        }
    }

    public final void setClickListener(@NotNull OnItemClickListener onItemClickListener2) {
        Intrinsics.checkParameterIsNotNull(onItemClickListener2, "onItemClickListener");
        this.onItemClickListener = onItemClickListener2;
    }
}
