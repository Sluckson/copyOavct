package com.iaai.android.bdt.feature.account.tobepickedup;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.bdt.feature.account.tobepickedup.ToBePickedUpAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ToBePickedUpAdapter.kt */
final class ToBePickedUpAdapter$onCreateViewHolder$3 implements View.OnClickListener {
    final /* synthetic */ Ref.ObjectRef $holder;
    final /* synthetic */ ToBePickedUpAdapter this$0;

    ToBePickedUpAdapter$onCreateViewHolder$3(ToBePickedUpAdapter toBePickedUpAdapter, Ref.ObjectRef objectRef) {
        this.this$0 = toBePickedUpAdapter;
        this.$holder = objectRef;
    }

    public final void onClick(View view) {
        OnItemClickListener listener = this.this$0.getListener();
        Intrinsics.checkExpressionValueIsNotNull(view, "it");
        listener.onItemClickListener(view, ToBePickedUpAdapter.access$getItem(this.this$0, ((ToBePickedUpAdapter.ResultDataItemViewHolder) ((RecyclerView.ViewHolder) this.$holder.element)).getAdapterPosition() - 1), ((ToBePickedUpAdapter.ResultDataItemViewHolder) ((RecyclerView.ViewHolder) this.$holder.element)).getAdapterPosition() - 1);
    }
}
