package com.iaai.android.bdt.feature.productDetail.vehicleimage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.productDetail.biddingInfo.Image;
import com.iaai.android.bdt.utils.NonHDImagesMode;
import com.iaai.android.databinding.RowItemVehicleImageNonHdBinding;
import com.iaai.android.old.utils.constants.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001&B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u001c\u0010\u001c\u001a\u00020\u001d2\n\u0010\u001e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J\u001c\u0010 \u001a\u00060\u0002R\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001aH\u0016J\u0014\u0010$\u001a\u00020\u001d2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/vehicleimage/VehicleImagesNonHDAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/iaai/android/bdt/feature/productDetail/vehicleimage/VehicleImagesNonHDAdapter$ViewHolder;", "context", "Landroid/content/Context;", "mode", "Lcom/iaai/android/bdt/utils/NonHDImagesMode;", "listener", "Lcom/iaai/android/bdt/feature/productDetail/vehicleimage/CustomImageClickListener;", "(Landroid/content/Context;Lcom/iaai/android/bdt/utils/NonHDImagesMode;Lcom/iaai/android/bdt/feature/productDetail/vehicleimage/CustomImageClickListener;)V", "getListener", "()Lcom/iaai/android/bdt/feature/productDetail/vehicleimage/CustomImageClickListener;", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "getMode", "()Lcom/iaai/android/bdt/utils/NonHDImagesMode;", "setMode", "(Lcom/iaai/android/bdt/utils/NonHDImagesMode;)V", "vehicleImagesList", "", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/Image;", "getItem", "long", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "results", "ViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: VehicleImagesNonHDAdapter.kt */
public final class VehicleImagesNonHDAdapter extends RecyclerView.Adapter<ViewHolder> {
    @NotNull
    private final CustomImageClickListener listener;
    @NotNull
    private Context mContext;
    @NotNull
    private NonHDImagesMode mode;
    private List<Image> vehicleImagesList;

    public VehicleImagesNonHDAdapter(@NotNull Context context, @NotNull NonHDImagesMode nonHDImagesMode, @NotNull CustomImageClickListener customImageClickListener) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(nonHDImagesMode, Constants.EXTRA_MODE);
        Intrinsics.checkParameterIsNotNull(customImageClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listener = customImageClickListener;
        this.mContext = context;
        this.mode = nonHDImagesMode;
    }

    @NotNull
    public final CustomImageClickListener getListener() {
        return this.listener;
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
    public final NonHDImagesMode getMode() {
        return this.mode;
    }

    public final void setMode(@NotNull NonHDImagesMode nonHDImagesMode) {
        Intrinsics.checkParameterIsNotNull(nonHDImagesMode, "<set-?>");
        this.mode = nonHDImagesMode;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        List<Image> list = this.vehicleImagesList;
        if (list == null) {
            Intrinsics.throwNpe();
        }
        viewHolder.bind(list.get(i));
    }

    public final void setData(@NotNull List<Image> list) {
        Intrinsics.checkParameterIsNotNull(list, "results");
        this.vehicleImagesList = list;
    }

    @NotNull
    public final Image getItem(int i) {
        List<Image> list = this.vehicleImagesList;
        Image image = list != null ? list.get(i) : null;
        if (image == null) {
            Intrinsics.throwNpe();
        }
        return image;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.row_item_vehicle_image_non_hd, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…, parent, false\n        )");
        ViewHolder viewHolder = new ViewHolder(this, (RowItemVehicleImageNonHdBinding) inflate);
        viewHolder.itemView.setOnClickListener(new VehicleImagesNonHDAdapter$onCreateViewHolder$1(this, viewHolder));
        return viewHolder;
    }

    public int getItemCount() {
        List<Image> list = this.vehicleImagesList;
        if (list == null) {
            return 0;
        }
        if (list == null) {
            Intrinsics.throwNpe();
        }
        return list.size();
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/vehicleimage/VehicleImagesNonHDAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/RowItemVehicleImageNonHdBinding;", "(Lcom/iaai/android/bdt/feature/productDetail/vehicleimage/VehicleImagesNonHDAdapter;Lcom/iaai/android/databinding/RowItemVehicleImageNonHdBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/RowItemVehicleImageNonHdBinding;", "setBinding", "(Lcom/iaai/android/databinding/RowItemVehicleImageNonHdBinding;)V", "bind", "", "image", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/Image;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: VehicleImagesNonHDAdapter.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private RowItemVehicleImageNonHdBinding binding;
        final /* synthetic */ VehicleImagesNonHDAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull VehicleImagesNonHDAdapter vehicleImagesNonHDAdapter, RowItemVehicleImageNonHdBinding rowItemVehicleImageNonHdBinding) {
            super(rowItemVehicleImageNonHdBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(rowItemVehicleImageNonHdBinding, "binding");
            this.this$0 = vehicleImagesNonHDAdapter;
            this.binding = rowItemVehicleImageNonHdBinding;
        }

        @NotNull
        public final RowItemVehicleImageNonHdBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull RowItemVehicleImageNonHdBinding rowItemVehicleImageNonHdBinding) {
            Intrinsics.checkParameterIsNotNull(rowItemVehicleImageNonHdBinding, "<set-?>");
            this.binding = rowItemVehicleImageNonHdBinding;
        }

        public final void bind(@NotNull Image image) {
            Intrinsics.checkParameterIsNotNull(image, "image");
            RequestOptions placeholder = new RequestOptions().centerCrop().error((int) C2723R.C2725drawable.ic_image_na).diskCacheStrategy(DiskCacheStrategy.ALL).priority(Priority.HIGH).placeholder((int) C2723R.C2725drawable.progress_animation);
            if (this.this$0.getMode() == NonHDImagesMode.LIST_VIEW) {
                LinearLayout linearLayout = this.binding.llGrid;
                Intrinsics.checkExpressionValueIsNotNull(linearLayout, "binding.llGrid");
                linearLayout.setVisibility(8);
                LinearLayout linearLayout2 = this.binding.llList;
                Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "binding.llList");
                linearLayout2.setVisibility(0);
                Glide.with((View) this.binding.vehicleImagesList).load(image.getUrl()).apply(placeholder).into(this.binding.vehicleImagesList);
                return;
            }
            LinearLayout linearLayout3 = this.binding.llGrid;
            Intrinsics.checkExpressionValueIsNotNull(linearLayout3, "binding.llGrid");
            linearLayout3.setVisibility(0);
            LinearLayout linearLayout4 = this.binding.llList;
            Intrinsics.checkExpressionValueIsNotNull(linearLayout4, "binding.llList");
            linearLayout4.setVisibility(8);
            Glide.with((View) this.binding.vehicleImagesGrid).load(image.getUrl()).apply(placeholder).into(this.binding.vehicleImagesGrid);
        }
    }
}
