package com.iaai.android.bdt.feature.fastSearchFilter.savedSearch;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.iaai.android.bdt.model.savedSearchList.SavedRefinerListResponse;
import com.iaai.android.bdt.model.savedSearchList.SavedSearchListResponse;
import com.iaai.android.databinding.RowItemSavedSearchBinding;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u001e\u0010\u001b\u001a\u00020\u00142\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u001dj\b\u0012\u0004\u0012\u00020\u0010`\u001eR\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/savedSearch/SavedSearchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mContext", "Landroid/content/Context;", "onClickListener", "Lcom/iaai/android/bdt/feature/fastSearchFilter/savedSearch/SavedSearchAdapter$OnClickListener;", "(Landroid/content/Context;Lcom/iaai/android/bdt/feature/fastSearchFilter/savedSearch/SavedSearchAdapter$OnClickListener;)V", "EPOCH_TICKS", "", "getMContext", "()Landroid/content/Context;", "getOnClickListener", "()Lcom/iaai/android/bdt/feature/fastSearchFilter/savedSearch/SavedSearchAdapter$OnClickListener;", "searchList", "", "Lcom/iaai/android/bdt/model/savedSearchList/SavedSearchListResponse;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItemsList", "results", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "OnClickListener", "SavedSearchItemViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SavedSearchAdapter.kt */
public final class SavedSearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /* access modifiers changed from: private */
    public final long EPOCH_TICKS = 621355968000000000L;
    @NotNull
    private final Context mContext;
    @NotNull
    private final OnClickListener onClickListener;
    /* access modifiers changed from: private */
    public List<SavedSearchListResponse> searchList;

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/savedSearch/SavedSearchAdapter$OnClickListener;", "", "onRemoveClicked", "", "searchName", "", "onSavedItemClicked", "refinerListResponse", "Lcom/iaai/android/bdt/model/savedSearchList/SavedSearchListResponse;", "position", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SavedSearchAdapter.kt */
    public interface OnClickListener {
        void onRemoveClicked(@Nullable String str);

        void onSavedItemClicked(@Nullable SavedSearchListResponse savedSearchListResponse, int i);
    }

    public SavedSearchAdapter(@NotNull Context context, @NotNull OnClickListener onClickListener2) {
        Intrinsics.checkParameterIsNotNull(context, "mContext");
        Intrinsics.checkParameterIsNotNull(onClickListener2, "onClickListener");
        this.mContext = context;
        this.onClickListener = onClickListener2;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    @NotNull
    public final OnClickListener getOnClickListener() {
        return this.onClickListener;
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        RowItemSavedSearchBinding inflate = RowItemSavedSearchBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "RowItemSavedSearchBindin…tInflater, parent, false)");
        return new SavedSearchItemViewHolder(this, inflate);
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        List<SavedSearchListResponse> list;
        SavedSearchListResponse savedSearchListResponse;
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (!(!(viewHolder instanceof SavedSearchItemViewHolder) || (list = this.searchList) == null || (savedSearchListResponse = list.get(i)) == null)) {
            ((SavedSearchItemViewHolder) viewHolder).bindTo(savedSearchListResponse, i);
        }
        viewHolder.itemView.setOnClickListener(new SavedSearchAdapter$onBindViewHolder$2(this, viewHolder));
    }

    public final void setItemsList(@NotNull ArrayList<SavedSearchListResponse> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "results");
        this.searchList = arrayList;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        List<SavedSearchListResponse> list = this.searchList;
        if (list == null) {
            return 0;
        }
        if (list == null) {
            Intrinsics.throwNpe();
        }
        return list.size();
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/savedSearch/SavedSearchAdapter$SavedSearchItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemSavedSearchBinding;", "(Lcom/iaai/android/bdt/feature/fastSearchFilter/savedSearch/SavedSearchAdapter;Lcom/iaai/android/databinding/RowItemSavedSearchBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemSavedSearchBinding;", "bindTo", "", "response", "Lcom/iaai/android/bdt/model/savedSearchList/SavedSearchListResponse;", "position", "", "updateSearchText", "refinerListResponse", "Lcom/iaai/android/bdt/model/savedSearchList/SavedRefinerListResponse;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SavedSearchAdapter.kt */
    public final class SavedSearchItemViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private final RowItemSavedSearchBinding binding;
        final /* synthetic */ SavedSearchAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedSearchItemViewHolder(@NotNull SavedSearchAdapter savedSearchAdapter, RowItemSavedSearchBinding rowItemSavedSearchBinding) {
            super(rowItemSavedSearchBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemSavedSearchBinding, "binding");
            this.this$0 = savedSearchAdapter;
            this.binding = rowItemSavedSearchBinding;
        }

        @NotNull
        public final RowItemSavedSearchBinding getBinding() {
            return this.binding;
        }

        public final void bindTo(@NotNull SavedSearchListResponse savedSearchListResponse, int i) {
            String str;
            Intrinsics.checkParameterIsNotNull(savedSearchListResponse, "response");
            TextView textView = this.binding.tvSearchTitle;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvSearchTitle");
            String saveSearchName = savedSearchListResponse.getSaveSearchName();
            if (saveSearchName == null) {
                str = null;
            } else if (saveSearchName != null) {
                str = StringsKt.trim((CharSequence) saveSearchName).toString();
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            textView.setText(str);
            try {
                SavedRefinerListResponse savedRefinerListResponse = (SavedRefinerListResponse) new Gson().fromJson(savedSearchListResponse.getRefiners(), SavedRefinerListResponse.class);
                Log.d("Refiners---", savedRefinerListResponse.toString());
                Intrinsics.checkExpressionValueIsNotNull(savedRefinerListResponse, "refinerListResponse");
                updateSearchText(savedRefinerListResponse);
            } catch (JsonSyntaxException unused) {
                TextView textView2 = this.binding.tvSearchText;
                Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvSearchText");
                textView2.setText("");
            }
            String format = new SimpleDateFormat("MMMM  dd, yyyy").format(Long.valueOf(System.currentTimeMillis()));
            Intrinsics.checkExpressionValueIsNotNull(format, "sdf.format(date)");
            TextView textView3 = this.binding.tvDate;
            Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.tvDate");
            textView3.setText(format);
            TextView textView4 = this.binding.tvRemove;
            Intrinsics.checkExpressionValueIsNotNull(textView4, "binding.tvRemove");
            textView4.setPaintFlags(8);
            this.binding.tvRemove.setOnClickListener(new SavedSearchAdapter$SavedSearchItemViewHolder$bindTo$1(this, savedSearchListResponse));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0099, code lost:
            if ((r9 == null || r9.length() == 0) != false) goto L_0x009d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void updateSearchText(com.iaai.android.bdt.model.savedSearchList.SavedRefinerListResponse r18) {
            /*
                r17 = this;
                r0 = r17
                com.iaai.android.databinding.RowItemSavedSearchBinding r1 = r0.binding
                android.widget.TextView r1 = r1.tvSearchText
                java.lang.String r2 = "binding.tvSearchText"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                java.lang.String r3 = ""
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r1.setText(r3)
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                java.util.List r3 = r18.getSearches()
                java.lang.Iterable r3 = (java.lang.Iterable) r3
                java.util.Iterator r3 = r3.iterator()
                r4 = 0
                r5 = 0
            L_0x0023:
                boolean r6 = r3.hasNext()
                r7 = 1
                if (r6 == 0) goto L_0x00a5
                java.lang.Object r6 = r3.next()
                int r8 = r5 + 1
                if (r5 >= 0) goto L_0x0035
                kotlin.collections.CollectionsKt.throwIndexOverflow()
            L_0x0035:
                com.iaai.android.bdt.model.fastSearchFilter2.Searche r6 = (com.iaai.android.bdt.model.fastSearchFilter2.Searche) r6
                java.util.ArrayList r9 = r6.getFacets()
                java.util.Collection r9 = (java.util.Collection) r9
                if (r9 == 0) goto L_0x0048
                boolean r9 = r9.isEmpty()
                if (r9 == 0) goto L_0x0046
                goto L_0x0048
            L_0x0046:
                r9 = 0
                goto L_0x0049
            L_0x0048:
                r9 = 1
            L_0x0049:
                if (r9 == 0) goto L_0x009c
                java.lang.String r9 = r6.getFullSearch()
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                if (r9 == 0) goto L_0x005c
                int r9 = r9.length()
                if (r9 != 0) goto L_0x005a
                goto L_0x005c
            L_0x005a:
                r9 = 0
                goto L_0x005d
            L_0x005c:
                r9 = 1
            L_0x005d:
                if (r9 == 0) goto L_0x009c
                java.util.ArrayList r9 = r6.getLongDiscretes()
                java.util.Collection r9 = (java.util.Collection) r9
                if (r9 == 0) goto L_0x0070
                boolean r9 = r9.isEmpty()
                if (r9 == 0) goto L_0x006e
                goto L_0x0070
            L_0x006e:
                r9 = 0
                goto L_0x0071
            L_0x0070:
                r9 = 1
            L_0x0071:
                if (r9 == 0) goto L_0x009c
                java.util.ArrayList r9 = r6.getLongRanges()
                java.util.Collection r9 = (java.util.Collection) r9
                if (r9 == 0) goto L_0x0084
                boolean r9 = r9.isEmpty()
                if (r9 == 0) goto L_0x0082
                goto L_0x0084
            L_0x0082:
                r9 = 0
                goto L_0x0085
            L_0x0084:
                r9 = 1
            L_0x0085:
                if (r9 == 0) goto L_0x009c
                java.lang.String r9 = r6.getBreadCrumb()
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                if (r9 == 0) goto L_0x0098
                int r9 = r9.length()
                if (r9 != 0) goto L_0x0096
                goto L_0x0098
            L_0x0096:
                r9 = 0
                goto L_0x0099
            L_0x0098:
                r9 = 1
            L_0x0099:
                if (r9 == 0) goto L_0x009c
                goto L_0x009d
            L_0x009c:
                r7 = 0
            L_0x009d:
                if (r7 != 0) goto L_0x00a2
                r1.add(r5, r6)
            L_0x00a2:
                r5 = r8
                goto L_0x0023
            L_0x00a5:
                java.lang.String r3 = r18.getZipCode()
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                if (r3 == 0) goto L_0x00b6
                boolean r3 = kotlin.text.StringsKt.isBlank(r3)
                if (r3 == 0) goto L_0x00b4
                goto L_0x00b6
            L_0x00b4:
                r3 = 0
                goto L_0x00b7
            L_0x00b6:
                r3 = 1
            L_0x00b7:
                java.lang.String r5 = ", "
                if (r3 != 0) goto L_0x0107
                java.lang.Integer r3 = r18.getMiles()
                if (r3 != 0) goto L_0x00c2
                goto L_0x00c8
            L_0x00c2:
                int r3 = r3.intValue()
                if (r3 == 0) goto L_0x0107
            L_0x00c8:
                com.iaai.android.databinding.RowItemSavedSearchBinding r3 = r0.binding
                android.widget.TextView r3 = r3.tvSearchText
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r2)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r6 = r18.getZipCode()
                r2.append(r6)
                java.lang.String r6 = " < "
                r2.append(r6)
                java.lang.Integer r6 = r18.getMiles()
                r2.append(r6)
                java.lang.String r2 = r2.toString()
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r3.setText(r2)
                java.util.List r2 = r18.getSearches()
                java.util.Collection r2 = (java.util.Collection) r2
                boolean r2 = r2.isEmpty()
                r2 = r2 ^ r7
                if (r2 == 0) goto L_0x0107
                com.iaai.android.databinding.RowItemSavedSearchBinding r2 = r0.binding
                android.widget.TextView r2 = r2.tvSearchText
                r3 = r5
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r2.append(r3)
            L_0x0107:
                r2 = r1
                java.lang.Iterable r2 = (java.lang.Iterable) r2
                java.util.Iterator r2 = r2.iterator()
                r3 = 0
            L_0x010f:
                boolean r6 = r2.hasNext()
                if (r6 == 0) goto L_0x0322
                java.lang.Object r6 = r2.next()
                int r8 = r3 + 1
                if (r3 >= 0) goto L_0x0120
                kotlin.collections.CollectionsKt.throwIndexOverflow()
            L_0x0120:
                com.iaai.android.bdt.model.fastSearchFilter2.Searche r6 = (com.iaai.android.bdt.model.fastSearchFilter2.Searche) r6
                java.lang.String r9 = r6.getFullSearch()
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                if (r9 == 0) goto L_0x0133
                boolean r9 = kotlin.text.StringsKt.isBlank(r9)
                if (r9 == 0) goto L_0x0131
                goto L_0x0133
            L_0x0131:
                r9 = 0
                goto L_0x0134
            L_0x0133:
                r9 = 1
            L_0x0134:
                if (r9 != 0) goto L_0x0145
                com.iaai.android.databinding.RowItemSavedSearchBinding r9 = r0.binding
                android.widget.TextView r9 = r9.tvSearchText
                java.lang.String r6 = r6.getFullSearch()
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                r9.append(r6)
                goto L_0x030e
            L_0x0145:
                java.util.ArrayList r9 = r6.getLongDiscretes()
                java.util.Collection r9 = (java.util.Collection) r9
                if (r9 == 0) goto L_0x0156
                boolean r9 = r9.isEmpty()
                if (r9 == 0) goto L_0x0154
                goto L_0x0156
            L_0x0154:
                r9 = 0
                goto L_0x0157
            L_0x0156:
                r9 = 1
            L_0x0157:
                java.lang.String r10 = "Year:"
                java.lang.String r11 = "Year"
                if (r9 != 0) goto L_0x01ba
                java.util.ArrayList r9 = r6.getLongDiscretes()
                java.lang.Object r9 = r9.get(r4)
                com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes r9 = (com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes) r9
                java.lang.String r9 = r9.getName()
                boolean r9 = kotlin.text.StringsKt.equals(r9, r11, r7)
                if (r9 == 0) goto L_0x019d
                com.iaai.android.databinding.RowItemSavedSearchBinding r9 = r0.binding
                android.widget.TextView r9 = r9.tvSearchText
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                r11.<init>()
                r11.append(r10)
                java.util.ArrayList r6 = r6.getLongDiscretes()
                java.lang.Object r6 = r6.get(r4)
                com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes r6 = (com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes) r6
                long r12 = r6.getValue()
                java.lang.String r6 = java.lang.String.valueOf(r12)
                r11.append(r6)
                java.lang.String r6 = r11.toString()
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                r9.append(r6)
                goto L_0x030e
            L_0x019d:
                com.iaai.android.databinding.RowItemSavedSearchBinding r9 = r0.binding
                android.widget.TextView r9 = r9.tvSearchText
                java.util.ArrayList r6 = r6.getLongDiscretes()
                java.lang.Object r6 = r6.get(r4)
                com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes r6 = (com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes) r6
                long r10 = r6.getValue()
                java.lang.String r6 = java.lang.String.valueOf(r10)
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                r9.append(r6)
                goto L_0x030e
            L_0x01ba:
                java.util.ArrayList r9 = r6.getLongRanges()
                java.util.Collection r9 = (java.util.Collection) r9
                if (r9 == 0) goto L_0x01cb
                boolean r9 = r9.isEmpty()
                if (r9 == 0) goto L_0x01c9
                goto L_0x01cb
            L_0x01c9:
                r9 = 0
                goto L_0x01cc
            L_0x01cb:
                r9 = 1
            L_0x01cc:
                if (r9 != 0) goto L_0x02ef
                java.util.ArrayList r9 = r6.getLongRanges()
                java.lang.Object r9 = r9.get(r4)
                com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r9 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r9
                java.lang.String r9 = r9.getName()
                boolean r9 = kotlin.text.StringsKt.equals(r9, r11, r7)
                r11 = 45
                if (r9 == 0) goto L_0x0220
                com.iaai.android.databinding.RowItemSavedSearchBinding r9 = r0.binding
                android.widget.TextView r9 = r9.tvSearchText
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                r12.append(r10)
                java.util.ArrayList r10 = r6.getLongRanges()
                java.lang.Object r10 = r10.get(r4)
                com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r10 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r10
                long r13 = r10.getFrom()
                r12.append(r13)
                r12.append(r11)
                java.util.ArrayList r6 = r6.getLongRanges()
                java.lang.Object r6 = r6.get(r4)
                com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r6 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r6
                long r10 = r6.getTo()
                r12.append(r10)
                java.lang.String r6 = r12.toString()
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                r9.append(r6)
                goto L_0x030e
            L_0x0220:
                java.util.ArrayList r9 = r6.getLongRanges()
                java.lang.Object r9 = r9.get(r4)
                com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r9 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r9
                java.lang.String r9 = r9.getName()
                java.lang.String r10 = "Cddate"
                boolean r9 = kotlin.text.StringsKt.equals(r9, r10, r7)
                if (r9 == 0) goto L_0x02b7
                java.util.ArrayList r9 = r6.getLongRanges()
                java.lang.Object r9 = r9.get(r4)
                com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r9 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r9
                long r9 = r9.getFrom()
                com.iaai.android.bdt.feature.fastSearchFilter.savedSearch.SavedSearchAdapter r11 = r0.this$0
                long r11 = r11.EPOCH_TICKS
                long r9 = r9 - r11
                r11 = 10000(0x2710, float:1.4013E-41)
                long r11 = (long) r11
                long r9 = r9 / r11
                java.util.ArrayList r6 = r6.getLongRanges()
                java.lang.Object r6 = r6.get(r4)
                com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r6 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r6
                long r13 = r6.getTo()
                com.iaai.android.bdt.feature.fastSearchFilter.savedSearch.SavedSearchAdapter r6 = r0.this$0
                long r15 = r6.EPOCH_TICKS
                long r13 = r13 - r15
                long r13 = r13 / r11
                long r13 = r13 - r9
                java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS
                long r9 = r6.toDays(r13)
                int r6 = (int) r9
                if (r6 == r7) goto L_0x02ab
                r9 = 2
                if (r6 == r9) goto L_0x029f
                r9 = 7
                if (r6 == r9) goto L_0x0293
                r9 = 14
                if (r6 == r9) goto L_0x0286
                com.iaai.android.databinding.RowItemSavedSearchBinding r6 = r0.binding
                android.widget.TextView r6 = r6.tvSearchText
                java.lang.String r9 = "All"
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                r6.append(r9)
                goto L_0x030e
            L_0x0286:
                com.iaai.android.databinding.RowItemSavedSearchBinding r6 = r0.binding
                android.widget.TextView r6 = r6.tvSearchText
                java.lang.String r9 = "Last 14 days"
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                r6.append(r9)
                goto L_0x030e
            L_0x0293:
                com.iaai.android.databinding.RowItemSavedSearchBinding r6 = r0.binding
                android.widget.TextView r6 = r6.tvSearchText
                java.lang.String r9 = "Last 7 days"
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                r6.append(r9)
                goto L_0x030e
            L_0x029f:
                com.iaai.android.databinding.RowItemSavedSearchBinding r6 = r0.binding
                android.widget.TextView r6 = r6.tvSearchText
                java.lang.String r9 = "Last 48 hrs"
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                r6.append(r9)
                goto L_0x030e
            L_0x02ab:
                com.iaai.android.databinding.RowItemSavedSearchBinding r6 = r0.binding
                android.widget.TextView r6 = r6.tvSearchText
                java.lang.String r9 = "Last 24 hrs"
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                r6.append(r9)
                goto L_0x030e
            L_0x02b7:
                com.iaai.android.databinding.RowItemSavedSearchBinding r9 = r0.binding
                android.widget.TextView r9 = r9.tvSearchText
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                java.util.ArrayList r12 = r6.getLongRanges()
                java.lang.Object r12 = r12.get(r4)
                com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r12 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r12
                long r12 = r12.getFrom()
                r10.append(r12)
                r10.append(r11)
                java.util.ArrayList r6 = r6.getLongRanges()
                java.lang.Object r6 = r6.get(r4)
                com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r6 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r6
                long r11 = r6.getTo()
                r10.append(r11)
                java.lang.String r6 = r10.toString()
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                r9.append(r6)
                goto L_0x030e
            L_0x02ef:
                java.util.ArrayList r6 = r6.getFacets()
                if (r6 == 0) goto L_0x030e
                com.iaai.android.bdt.utils.BDTUtils r9 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
                java.lang.Object r6 = r6.get(r4)
                com.iaai.android.bdt.model.fastSearchFilter2.Facet r6 = (com.iaai.android.bdt.model.fastSearchFilter2.Facet) r6
                java.lang.String r6 = r6.getValue()
                java.lang.String r6 = r9.getActualValue(r6)
                com.iaai.android.databinding.RowItemSavedSearchBinding r9 = r0.binding
                android.widget.TextView r9 = r9.tvSearchText
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                r9.append(r6)
            L_0x030e:
                int r6 = r1.size()
                int r6 = r6 - r7
                if (r3 == r6) goto L_0x031f
                com.iaai.android.databinding.RowItemSavedSearchBinding r3 = r0.binding
                android.widget.TextView r3 = r3.tvSearchText
                r6 = r5
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                r3.append(r6)
            L_0x031f:
                r3 = r8
                goto L_0x010f
            L_0x0322:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.fastSearchFilter.savedSearch.SavedSearchAdapter.SavedSearchItemViewHolder.updateSearchText(com.iaai.android.bdt.model.savedSearchList.SavedRefinerListResponse):void");
        }
    }
}
