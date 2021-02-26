package com.iaai.android.bdt.feature.landing.recommendedVehicles;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.recommendedVehicles.RecommendedVehiclesResponse;
import com.iaai.android.databinding.RowItemRecommendedVehiclesBinding;
import com.iaai.android.old.utils.constants.Constants;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001dB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u001e\u0010\u001b\u001a\u00020\u00142\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010R\u001a\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/recommendedVehicles/RecommendedVehiclesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/iaai/android/bdt/feature/landing/recommendedVehicles/RecommendedVehiclesAdapter$ViewHolder;", "context", "Landroid/content/Context;", "vehicleClickListener", "Lcom/iaai/android/bdt/feature/landing/recommendedVehicles/VehicleClickListener;", "(Landroid/content/Context;Lcom/iaai/android/bdt/feature/landing/recommendedVehicles/VehicleClickListener;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "vehicleList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/recommendedVehicles/RecommendedVehiclesResponse;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "recommendedVehicle", "ViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: RecommendedVehiclesAdapter.kt */
public final class RecommendedVehiclesAdapter extends RecyclerView.Adapter<ViewHolder> {
    @NotNull
    private Context mContext;
    /* access modifiers changed from: private */
    public final VehicleClickListener vehicleClickListener;
    private ArrayList<RecommendedVehiclesResponse> vehicleList;

    public RecommendedVehiclesAdapter(@NotNull Context context, @NotNull VehicleClickListener vehicleClickListener2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(vehicleClickListener2, "vehicleClickListener");
        this.vehicleClickListener = vehicleClickListener2;
        this.mContext = context;
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
        ArrayList<RecommendedVehiclesResponse> arrayList = this.vehicleList;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vehicleList");
        }
        if (arrayList == null) {
            Intrinsics.throwNpe();
        }
        RecommendedVehiclesResponse recommendedVehiclesResponse = arrayList.get(i);
        Intrinsics.checkExpressionValueIsNotNull(recommendedVehiclesResponse, "vehicleList!![position]");
        viewHolder.bindVehicle(recommendedVehiclesResponse);
        viewHolder.itemView.setOnClickListener(new RecommendedVehiclesAdapter$onBindViewHolder$1(this, viewHolder));
        viewHolder.getBinding().ivBadgeInd.setOnClickListener(new RecommendedVehiclesAdapter$onBindViewHolder$2(this));
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.row_item_recommended_vehicles, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…, parent, false\n        )");
        return new ViewHolder(this, (RowItemRecommendedVehiclesBinding) inflate);
    }

    public int getItemCount() {
        ArrayList<RecommendedVehiclesResponse> arrayList = this.vehicleList;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vehicleList");
        }
        return arrayList.size();
    }

    public final void setData(@NotNull ArrayList<RecommendedVehiclesResponse> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "recommendedVehicle");
        this.vehicleList = arrayList;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/recommendedVehicles/RecommendedVehiclesAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemRecommendedVehiclesBinding;", "(Lcom/iaai/android/bdt/feature/landing/recommendedVehicles/RecommendedVehiclesAdapter;Lcom/iaai/android/databinding/RowItemRecommendedVehiclesBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemRecommendedVehiclesBinding;", "setBinding", "(Lcom/iaai/android/databinding/RowItemRecommendedVehiclesBinding;)V", "bindVehicle", "", "vehicle", "Lcom/iaai/android/bdt/model/recommendedVehicles/RecommendedVehiclesResponse;", "updateBadgeUI", "badgeType", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: RecommendedVehiclesAdapter.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private RowItemRecommendedVehiclesBinding binding;
        final /* synthetic */ RecommendedVehiclesAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull RecommendedVehiclesAdapter recommendedVehiclesAdapter, RowItemRecommendedVehiclesBinding rowItemRecommendedVehiclesBinding) {
            super(rowItemRecommendedVehiclesBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemRecommendedVehiclesBinding, "binding");
            this.this$0 = recommendedVehiclesAdapter;
            this.binding = rowItemRecommendedVehiclesBinding;
        }

        @NotNull
        public final RowItemRecommendedVehiclesBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull RowItemRecommendedVehiclesBinding rowItemRecommendedVehiclesBinding) {
            Intrinsics.checkParameterIsNotNull(rowItemRecommendedVehiclesBinding, "<set-?>");
            this.binding = rowItemRecommendedVehiclesBinding;
        }

        public final void bindVehicle(@NotNull RecommendedVehiclesResponse recommendedVehiclesResponse) {
            Intrinsics.checkParameterIsNotNull(recommendedVehiclesResponse, Constants.EXTRA_VEHICLE);
            TextView textView = this.binding.tvHeaderVehicles;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvHeaderVehicles");
            textView.setText(recommendedVehiclesResponse.getTitle());
            TextView textView2 = this.binding.tvMessageVehicles;
            Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvMessageVehicles");
            textView2.setText(recommendedVehiclesResponse.getBranchName() + ", " + recommendedVehiclesResponse.getState());
            updateBadgeUI(this.binding, recommendedVehiclesResponse.getBadgeType());
            if (Build.VERSION.SDK_INT > 25) {
                Glide.with(this.this$0.getMContext()).load(recommendedVehiclesResponse.getThumbnailUrl()).apply(new RequestOptions().centerCrop().error((int) C2723R.C2725drawable.ic_image_na).diskCacheStrategy(DiskCacheStrategy.ALL).priority(Priority.HIGH).placeholder((int) C2723R.C2725drawable.progress_animation)).into(this.binding.ivVehicle);
                return;
            }
            Picasso.get().load(recommendedVehiclesResponse.getThumbnailUrl()).networkPolicy(NetworkPolicy.NO_CACHE, new NetworkPolicy[0]).memoryPolicy(MemoryPolicy.NO_CACHE, new MemoryPolicy[0]).resize(WOWZMediaConfig.DEFAULT_VIDEO_FRAME_HEIGHT, 360).onlyScaleDown().placeholder((int) C2723R.C2725drawable.progress_animation).error((int) C2723R.C2725drawable.ic_image_na).into(this.binding.ivVehicle);
        }

        private final void updateBadgeUI(RowItemRecommendedVehiclesBinding rowItemRecommendedVehiclesBinding, String str) {
            if (Intrinsics.areEqual((Object) str, (Object) BadgeType.BRE_BADGE_MAKE_MODEL.getId())) {
                rowItemRecommendedVehiclesBinding.ivBadgeInd.setImageDrawable(ContextCompat.getDrawable(this.this$0.getMContext(), C2723R.C2725drawable.ic_bre_badge_make_model));
            } else if (Intrinsics.areEqual((Object) str, (Object) BadgeType.BRE_BADGE_FOREIGN.getId())) {
                rowItemRecommendedVehiclesBinding.ivBadgeInd.setImageDrawable(ContextCompat.getDrawable(this.this$0.getMContext(), C2723R.C2725drawable.ic_bre_badge_foreign));
            } else if (Intrinsics.areEqual((Object) str, (Object) BadgeType.BRE_BADGE.getId())) {
                rowItemRecommendedVehiclesBinding.ivBadgeInd.setImageDrawable(ContextCompat.getDrawable(this.this$0.getMContext(), C2723R.C2725drawable.ic_bre_badge));
            } else if (Intrinsics.areEqual((Object) str, (Object) BadgeType.BRE_BADGE_ACV.getId())) {
                rowItemRecommendedVehiclesBinding.ivBadgeInd.setImageDrawable(ContextCompat.getDrawable(this.this$0.getMContext(), C2723R.C2725drawable.ic_bre_badge_acv));
            } else if (Intrinsics.areEqual((Object) str, (Object) BadgeType.BRE_BADGE_AGE.getId())) {
                rowItemRecommendedVehiclesBinding.ivBadgeInd.setImageDrawable(ContextCompat.getDrawable(this.this$0.getMContext(), C2723R.C2725drawable.ic_bre_badge_age));
            }
        }
    }
}
