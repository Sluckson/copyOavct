package com.iaai.android.bdt.feature.fastSearchFilter.savedSearch;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.bdt.feature.fastSearchFilter.savedSearch.SavedSearchAdapter;
import com.iaai.android.bdt.model.savedSearchList.SavedSearchListResponse;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SavedSearchAdapter.kt */
final class SavedSearchAdapter$onBindViewHolder$2 implements View.OnClickListener {
    final /* synthetic */ RecyclerView.ViewHolder $holder;
    final /* synthetic */ SavedSearchAdapter this$0;

    SavedSearchAdapter$onBindViewHolder$2(SavedSearchAdapter savedSearchAdapter, RecyclerView.ViewHolder viewHolder) {
        this.this$0 = savedSearchAdapter;
        this.$holder = viewHolder;
    }

    public final void onClick(View view) {
        SavedSearchAdapter.OnClickListener onClickListener = this.this$0.getOnClickListener();
        List access$getSearchList$p = this.this$0.searchList;
        onClickListener.onSavedItemClicked(access$getSearchList$p != null ? (SavedSearchListResponse) access$getSearchList$p.get(this.$holder.getAdapterPosition()) : null, this.$holder.getAdapterPosition());
    }
}
