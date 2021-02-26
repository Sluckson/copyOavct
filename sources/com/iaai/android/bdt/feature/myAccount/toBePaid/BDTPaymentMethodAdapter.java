package com.iaai.android.bdt.feature.myAccount.toBePaid;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.toBePaid.PaymentMethodInformation;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.databinding.ItemBdtPaymentMethodsLayoutBinding;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001'B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010\u001a\u001a\u00020\u0012H\u0016J\u001c\u0010\u001b\u001a\u00020\u001c2\n\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0012H\u0016J\u001c\u0010\u001f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0012H\u0016J\u001e\u0010#\u001a\u00020\u001c2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010J\u000e\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u0012J\u000e\u0010&\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0012R\u001a\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006("}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/BDTPaymentMethodAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/BDTPaymentMethodAdapter$ViewHolder;", "context", "Landroid/content/Context;", "paymentMethodSelection", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/PaymentMethodSelectionListener;", "(Landroid/content/Context;Lcom/iaai/android/bdt/feature/myAccount/toBePaid/PaymentMethodSelectionListener;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "paymentMethodInformationList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/toBePaid/PaymentMethodInformation;", "Lkotlin/collections/ArrayList;", "selectedPosition", "", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "convertDpToPixel", "", "dp", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "setSelectedIndex", "selectedIndex", "updateRowUI", "ViewHolder", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BDTPaymentMethodAdapter.kt */
public final class BDTPaymentMethodAdapter extends RecyclerView.Adapter<ViewHolder> {
    @NotNull
    private Context mContext;
    /* access modifiers changed from: private */
    public ArrayList<PaymentMethodInformation> paymentMethodInformationList;
    /* access modifiers changed from: private */
    public final PaymentMethodSelectionListener paymentMethodSelection;
    private int selectedPosition = -1;

    public BDTPaymentMethodAdapter(@NotNull Context context, @NotNull PaymentMethodSelectionListener paymentMethodSelectionListener) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(paymentMethodSelectionListener, "paymentMethodSelection");
        this.paymentMethodSelection = paymentMethodSelectionListener;
        this.mContext = context;
    }

    public static final /* synthetic */ ArrayList access$getPaymentMethodInformationList$p(BDTPaymentMethodAdapter bDTPaymentMethodAdapter) {
        ArrayList<PaymentMethodInformation> arrayList = bDTPaymentMethodAdapter.paymentMethodInformationList;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentMethodInformationList");
        }
        return arrayList;
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

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        ArrayList<PaymentMethodInformation> arrayList = this.paymentMethodInformationList;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentMethodInformationList");
        }
        if (arrayList == null) {
            Intrinsics.throwNpe();
        }
        PaymentMethodInformation paymentMethodInformation = arrayList.get(i);
        Intrinsics.checkExpressionValueIsNotNull(paymentMethodInformation, "paymentMethodInformationList!![position]");
        PaymentMethodInformation paymentMethodInformation2 = paymentMethodInformation;
        viewHolder.bindVehicle(paymentMethodInformation2);
        viewHolder.itemView.setOnClickListener(new BDTPaymentMethodAdapter$onBindViewHolder$1(this, viewHolder));
        View view = viewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
        ((RadioButton) view.findViewById(C2723R.C2726id.rbAFCInfo)).setOnClickListener(new BDTPaymentMethodAdapter$onBindViewHolder$2(this, i));
        View view2 = viewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
        ((TextView) view2.findViewById(C2723R.C2726id.tvLinkPaymentMethod)).setOnClickListener(new BDTPaymentMethodAdapter$onBindViewHolder$3(this, i));
        View view3 = viewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view3, "holder.itemView");
        ((RadioButton) view3.findViewById(C2723R.C2726id.rbAccountInfo)).setOnClickListener(new BDTPaymentMethodAdapter$onBindViewHolder$4(this, viewHolder));
        View view4 = viewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view4, "holder.itemView");
        ((TextView) view4.findViewById(C2723R.C2726id.tvPaymentName)).setOnClickListener(new BDTPaymentMethodAdapter$onBindViewHolder$5(this, paymentMethodInformation2));
        View view5 = viewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view5, "holder.itemView");
        ((ImageView) view5.findViewById(C2723R.C2726id.ivAFCInfo1)).setOnClickListener(new BDTPaymentMethodAdapter$onBindViewHolder$6(this));
        View view6 = viewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view6, "holder.itemView");
        ((ImageView) view6.findViewById(C2723R.C2726id.ivAFCInfo2)).setOnClickListener(new BDTPaymentMethodAdapter$onBindViewHolder$7(this));
        View view7 = viewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view7, "holder.itemView");
        ((CheckBox) view7.findViewById(C2723R.C2726id.cbSetAsDefault)).setOnClickListener(new BDTPaymentMethodAdapter$onBindViewHolder$8(this, viewHolder));
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), C2723R.C2728layout.item_bdt_payment_methods_layout, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…, parent, false\n        )");
        return new ViewHolder(this, (ItemBdtPaymentMethodsLayoutBinding) inflate);
    }

    public int getItemCount() {
        ArrayList<PaymentMethodInformation> arrayList = this.paymentMethodInformationList;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentMethodInformationList");
        }
        return arrayList.size();
    }

    public final void updateRowUI(int i) {
        this.selectedPosition = i;
        ArrayList<PaymentMethodInformation> arrayList = this.paymentMethodInformationList;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentMethodInformationList");
        }
        if (arrayList.get(this.selectedPosition).getErrorText().length() == 0) {
            ArrayList<PaymentMethodInformation> arrayList2 = this.paymentMethodInformationList;
            if (arrayList2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paymentMethodInformationList");
            }
            if (arrayList2.get(this.selectedPosition).getLinkPaymentMethodText().length() == 0) {
                ArrayList<PaymentMethodInformation> arrayList3 = this.paymentMethodInformationList;
                if (arrayList3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("paymentMethodInformationList");
                }
                for (PaymentMethodInformation paymentMethodInformation : arrayList3) {
                    String paymentMethodName = paymentMethodInformation.getPaymentMethodName();
                    ArrayList<PaymentMethodInformation> arrayList4 = this.paymentMethodInformationList;
                    if (arrayList4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("paymentMethodInformationList");
                    }
                    if (Intrinsics.areEqual((Object) paymentMethodName, (Object) arrayList4.get(this.selectedPosition).getPaymentMethodName())) {
                        paymentMethodInformation.setSelected(true);
                        paymentMethodInformation.setCheckBoxVisible(true);
                        if (paymentMethodInformation.isSelectedAFCBuyGo()) {
                            paymentMethodInformation.setSelectedAFCBuyGo(false);
                        }
                    } else {
                        paymentMethodInformation.setSelected(false);
                        paymentMethodInformation.setCheckBoxVisible(false);
                        paymentMethodInformation.setSelectedAFCBuyGo(false);
                    }
                    paymentMethodInformation.setSetAsDefault(false);
                }
                ArrayList<PaymentMethodInformation> arrayList5 = this.paymentMethodInformationList;
                if (arrayList5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("paymentMethodInformationList");
                }
                setData(arrayList5);
                notifyDataSetChanged();
                PaymentMethodSelectionListener paymentMethodSelectionListener = this.paymentMethodSelection;
                ArrayList<PaymentMethodInformation> arrayList6 = this.paymentMethodInformationList;
                if (arrayList6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("paymentMethodInformationList");
                }
                PaymentMethodInformation paymentMethodInformation2 = arrayList6.get(this.selectedPosition);
                Intrinsics.checkExpressionValueIsNotNull(paymentMethodInformation2, "paymentMethodInformationList[selectedPosition]");
                paymentMethodSelectionListener.onPaymentSelection(paymentMethodInformation2, this.selectedPosition);
            }
        }
    }

    public final void setData(@NotNull ArrayList<PaymentMethodInformation> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "paymentMethodInformationList");
        this.paymentMethodInformationList = arrayList;
    }

    public final void setSelectedIndex(int i) {
        this.selectedPosition = i;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/BDTPaymentMethodAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iaai/android/databinding/ItemBdtPaymentMethodsLayoutBinding;", "(Lcom/iaai/android/bdt/feature/myAccount/toBePaid/BDTPaymentMethodAdapter;Lcom/iaai/android/databinding/ItemBdtPaymentMethodsLayoutBinding;)V", "getBinding", "()Lcom/iaai/android/databinding/ItemBdtPaymentMethodsLayoutBinding;", "setBinding", "(Lcom/iaai/android/databinding/ItemBdtPaymentMethodsLayoutBinding;)V", "bindVehicle", "", "paymentMethodInformation", "Lcom/iaai/android/bdt/model/toBePaid/PaymentMethodInformation;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: BDTPaymentMethodAdapter.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private ItemBdtPaymentMethodsLayoutBinding binding;
        final /* synthetic */ BDTPaymentMethodAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull BDTPaymentMethodAdapter bDTPaymentMethodAdapter, ItemBdtPaymentMethodsLayoutBinding itemBdtPaymentMethodsLayoutBinding) {
            super(itemBdtPaymentMethodsLayoutBinding.getRoot());
            Intrinsics.checkParameterIsNotNull(itemBdtPaymentMethodsLayoutBinding, "binding");
            this.this$0 = bDTPaymentMethodAdapter;
            this.binding = itemBdtPaymentMethodsLayoutBinding;
        }

        @NotNull
        public final ItemBdtPaymentMethodsLayoutBinding getBinding() {
            return this.binding;
        }

        public final void setBinding(@NotNull ItemBdtPaymentMethodsLayoutBinding itemBdtPaymentMethodsLayoutBinding) {
            Intrinsics.checkParameterIsNotNull(itemBdtPaymentMethodsLayoutBinding, "<set-?>");
            this.binding = itemBdtPaymentMethodsLayoutBinding;
        }

        public final void bindVehicle(@NotNull PaymentMethodInformation paymentMethodInformation) {
            Intrinsics.checkParameterIsNotNull(paymentMethodInformation, "paymentMethodInformation");
            TextView textView = this.binding.tvPaymentName;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvPaymentName");
            textView.setText(paymentMethodInformation.getPaymentMethodName());
            TextView textView2 = this.binding.tvDailyAllowanceLimit;
            Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvDailyAllowanceLimit");
            textView2.setText(paymentMethodInformation.getDailyAllowance());
            RadioButton radioButton = this.binding.rbAccountInfo;
            Intrinsics.checkExpressionValueIsNotNull(radioButton, "binding.rbAccountInfo");
            radioButton.setText(paymentMethodInformation.getAccountInfo());
            TextView textView3 = this.binding.tvDailyAllowanceLimit;
            Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.tvDailyAllowanceLimit");
            textView3.setVisibility(0);
            LinearLayout linearLayout = this.binding.rlAFCInfoLayout;
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "binding.rlAFCInfoLayout");
            linearLayout.setVisibility(8);
            ImageView imageView = this.binding.ivAFCInfo1;
            Intrinsics.checkExpressionValueIsNotNull(imageView, "binding.ivAFCInfo1");
            imageView.setVisibility(8);
            ImageView imageView2 = this.binding.ivAFCInfo2;
            Intrinsics.checkExpressionValueIsNotNull(imageView2, "binding.ivAFCInfo2");
            imageView2.setVisibility(8);
            TextView textView4 = this.binding.tvErrorMessage;
            Intrinsics.checkExpressionValueIsNotNull(textView4, "binding.tvErrorMessage");
            textView4.setVisibility(8);
            TextView textView5 = this.binding.tvLinkPaymentMethod;
            Intrinsics.checkExpressionValueIsNotNull(textView5, "binding.tvLinkPaymentMethod");
            textView5.setVisibility(8);
            TextView textView6 = this.binding.tvPayPalFee;
            Intrinsics.checkExpressionValueIsNotNull(textView6, "binding.tvPayPalFee");
            textView6.setVisibility(8);
            TextView textView7 = this.binding.tvLinkPayPalAccountInfo;
            Intrinsics.checkExpressionValueIsNotNull(textView7, "binding.tvLinkPayPalAccountInfo");
            textView7.setVisibility(8);
            this.binding.tvPaymentName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.binding.rbAccountInfo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{16842912}}, new int[]{Color.parseColor("#cccccc"), Color.parseColor("#238723")});
            RadioButton radioButton2 = this.binding.rbAccountInfo;
            Intrinsics.checkExpressionValueIsNotNull(radioButton2, "binding.rbAccountInfo");
            radioButton2.setButtonTintList(colorStateList);
            this.binding.rbAccountInfo.invalidate();
            RadioButton radioButton3 = this.binding.rbAFCInfo;
            Intrinsics.checkExpressionValueIsNotNull(radioButton3, "binding.rbAFCInfo");
            radioButton3.setButtonTintList(colorStateList);
            this.binding.rbAFCInfo.invalidate();
            if (paymentMethodInformation.getErrorText().length() > 0) {
                RadioButton radioButton4 = this.binding.rbAccountInfo;
                Intrinsics.checkExpressionValueIsNotNull(radioButton4, "binding.rbAccountInfo");
                radioButton4.setEnabled(false);
                RadioButton radioButton5 = this.binding.rbAFCInfo;
                Intrinsics.checkExpressionValueIsNotNull(radioButton5, "binding.rbAFCInfo");
                radioButton5.setEnabled(false);
                RadioButton radioButton6 = this.binding.rbAFCInfo;
                Intrinsics.checkExpressionValueIsNotNull(radioButton6, "binding.rbAFCInfo");
                radioButton6.setAlpha(0.5f);
                RadioButton radioButton7 = this.binding.rbAccountInfo;
                Intrinsics.checkExpressionValueIsNotNull(radioButton7, "binding.rbAccountInfo");
                radioButton7.setAlpha(0.5f);
                TextView textView8 = this.binding.tvErrorMessage;
                Intrinsics.checkExpressionValueIsNotNull(textView8, "binding.tvErrorMessage");
                textView8.setVisibility(0);
                TextView textView9 = this.binding.tvErrorMessage;
                Intrinsics.checkExpressionValueIsNotNull(textView9, "binding.tvErrorMessage");
                textView9.setText(paymentMethodInformation.getErrorText());
                CheckBox checkBox = this.binding.cbSetAsDefault;
                Intrinsics.checkExpressionValueIsNotNull(checkBox, "binding.cbSetAsDefault");
                checkBox.setChecked(false);
                RadioButton radioButton8 = this.binding.rbAccountInfo;
                Intrinsics.checkExpressionValueIsNotNull(radioButton8, "binding.rbAccountInfo");
                radioButton8.setChecked(false);
                RadioButton radioButton9 = this.binding.rbAFCInfo;
                Intrinsics.checkExpressionValueIsNotNull(radioButton9, "binding.rbAFCInfo");
                radioButton9.setChecked(false);
            } else {
                RadioButton radioButton10 = this.binding.rbAccountInfo;
                Intrinsics.checkExpressionValueIsNotNull(radioButton10, "binding.rbAccountInfo");
                radioButton10.setEnabled(true);
                RadioButton radioButton11 = this.binding.rbAFCInfo;
                Intrinsics.checkExpressionValueIsNotNull(radioButton11, "binding.rbAFCInfo");
                radioButton11.setEnabled(true);
                RadioButton radioButton12 = this.binding.rbAFCInfo;
                Intrinsics.checkExpressionValueIsNotNull(radioButton12, "binding.rbAFCInfo");
                radioButton12.setAlpha(1.0f);
                TextView textView10 = this.binding.tvErrorMessage;
                Intrinsics.checkExpressionValueIsNotNull(textView10, "binding.tvErrorMessage");
                textView10.setVisibility(8);
                CheckBox checkBox2 = this.binding.cbSetAsDefault;
                Intrinsics.checkExpressionValueIsNotNull(checkBox2, "binding.cbSetAsDefault");
                checkBox2.setChecked(paymentMethodInformation.isSetAsDefault());
                RadioButton radioButton13 = this.binding.rbAccountInfo;
                Intrinsics.checkExpressionValueIsNotNull(radioButton13, "binding.rbAccountInfo");
                radioButton13.setChecked(paymentMethodInformation.isSelected());
                RadioButton radioButton14 = this.binding.rbAFCInfo;
                Intrinsics.checkExpressionValueIsNotNull(radioButton14, "binding.rbAFCInfo");
                radioButton14.setChecked(paymentMethodInformation.isSelectedAFCBuyGo());
            }
            String value = paymentMethodInformation.getPaymentMethodType().getValue();
            if (Intrinsics.areEqual((Object) value, (Object) Constants_MVVM.PaymentMethod.PAY_PAL.getValue())) {
                if (paymentMethodInformation.getLinkPaymentMethodText().length() > 0) {
                    TextView textView11 = this.binding.tvLinkPaymentMethod;
                    Intrinsics.checkExpressionValueIsNotNull(textView11, "binding.tvLinkPaymentMethod");
                    textView11.setVisibility(0);
                    RadioButton radioButton15 = this.binding.rbAccountInfo;
                    Intrinsics.checkExpressionValueIsNotNull(radioButton15, "binding.rbAccountInfo");
                    radioButton15.setEnabled(false);
                    RadioButton radioButton16 = this.binding.rbAccountInfo;
                    Intrinsics.checkExpressionValueIsNotNull(radioButton16, "binding.rbAccountInfo");
                    radioButton16.setAlpha(0.5f);
                    TextView textView12 = this.binding.tvLinkPayPalAccountInfo;
                    Intrinsics.checkExpressionValueIsNotNull(textView12, "binding.tvLinkPayPalAccountInfo");
                    textView12.setVisibility(0);
                    RadioButton radioButton17 = this.binding.rbAccountInfo;
                    Intrinsics.checkExpressionValueIsNotNull(radioButton17, "binding.rbAccountInfo");
                    radioButton17.setChecked(false);
                } else {
                    TextView textView13 = this.binding.tvLinkPaymentMethod;
                    Intrinsics.checkExpressionValueIsNotNull(textView13, "binding.tvLinkPaymentMethod");
                    textView13.setVisibility(8);
                    RadioButton radioButton18 = this.binding.rbAccountInfo;
                    Intrinsics.checkExpressionValueIsNotNull(radioButton18, "binding.rbAccountInfo");
                    radioButton18.setEnabled(true);
                    RadioButton radioButton19 = this.binding.rbAccountInfo;
                    Intrinsics.checkExpressionValueIsNotNull(radioButton19, "binding.rbAccountInfo");
                    radioButton19.setAlpha(1.0f);
                    TextView textView14 = this.binding.tvLinkPayPalAccountInfo;
                    Intrinsics.checkExpressionValueIsNotNull(textView14, "binding.tvLinkPayPalAccountInfo");
                    textView14.setVisibility(8);
                    RadioButton radioButton20 = this.binding.rbAccountInfo;
                    Intrinsics.checkExpressionValueIsNotNull(radioButton20, "binding.rbAccountInfo");
                    radioButton20.setChecked(paymentMethodInformation.isSelected());
                }
                TextView textView15 = this.binding.tvDailyAllowanceLimit;
                Intrinsics.checkExpressionValueIsNotNull(textView15, "binding.tvDailyAllowanceLimit");
                textView15.setVisibility(0);
                TextView textView16 = this.binding.tvPayPalFee;
                Intrinsics.checkExpressionValueIsNotNull(textView16, "binding.tvPayPalFee");
                textView16.setVisibility(0);
                TextView textView17 = this.binding.tvPayPalFee;
                Intrinsics.checkExpressionValueIsNotNull(textView17, "binding.tvPayPalFee");
                textView17.setText(this.this$0.getMContext().getString(C2723R.string.lbl_cdf_may_apply));
                TextView textView18 = this.binding.tvLinkPayPalAccountInfo;
                Intrinsics.checkExpressionValueIsNotNull(textView18, "binding.tvLinkPayPalAccountInfo");
                textView18.setText(this.this$0.getMContext().getString(C2723R.string.lbl_link_paypal_account_info));
                TextView textView19 = this.binding.tvLinkPaymentMethod;
                Intrinsics.checkExpressionValueIsNotNull(textView19, "binding.tvLinkPaymentMethod");
                TextView textView20 = this.binding.tvLinkPaymentMethod;
                Intrinsics.checkExpressionValueIsNotNull(textView20, "binding.tvLinkPaymentMethod");
                textView19.setPaintFlags(textView20.getPaintFlags() | 8);
                TextView textView21 = this.binding.tvLinkPaymentMethod;
                Intrinsics.checkExpressionValueIsNotNull(textView21, "binding.tvLinkPaymentMethod");
                textView21.setText(paymentMethodInformation.getLinkPaymentMethodText());
                RadioButton radioButton21 = this.binding.rbAccountInfo;
                Intrinsics.checkExpressionValueIsNotNull(radioButton21, "binding.rbAccountInfo");
                radioButton21.setText("");
                this.binding.rbAccountInfo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.this$0.getMContext().getDrawable(C2723R.C2725drawable.ic_paypal_logo), (Drawable) null);
            } else if (Intrinsics.areEqual((Object) value, (Object) Constants_MVVM.PaymentMethod.CREDIT_CARD.getValue())) {
                this.binding.rbAccountInfo.setCompoundDrawablesWithIntrinsicBounds(this.this$0.getMContext().getDrawable(C2723R.C2725drawable.ic_cc_visa), (Drawable) null, (Drawable) null, (Drawable) null);
            } else if (Intrinsics.areEqual((Object) value, (Object) Constants_MVVM.PaymentMethod.ACH.getValue())) {
                RadioButton radioButton22 = this.binding.rbAccountInfo;
                Intrinsics.checkExpressionValueIsNotNull(radioButton22, "binding.rbAccountInfo");
                radioButton22.setText("");
                this.binding.rbAccountInfo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.this$0.getMContext().getDrawable(C2723R.C2725drawable.ic_ipay_logo), (Drawable) null);
            } else if (Intrinsics.areEqual((Object) value, (Object) Constants_MVVM.PaymentMethod.AFC.getValue())) {
                LinearLayout linearLayout2 = this.binding.rlAFCInfoLayout;
                Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "binding.rlAFCInfoLayout");
                linearLayout2.setVisibility(0);
                ImageView imageView3 = this.binding.ivAFCInfo1;
                Intrinsics.checkExpressionValueIsNotNull(imageView3, "binding.ivAFCInfo1");
                imageView3.setVisibility(0);
                ImageView imageView4 = this.binding.ivAFCInfo2;
                Intrinsics.checkExpressionValueIsNotNull(imageView4, "binding.ivAFCInfo2");
                imageView4.setVisibility(0);
                RadioButton radioButton23 = this.binding.rbAFCInfo;
                Intrinsics.checkExpressionValueIsNotNull(radioButton23, "binding.rbAFCInfo");
                radioButton23.setText(paymentMethodInformation.getAccountInfoAfc());
                Drawable drawable = this.this$0.getMContext().getDrawable(C2723R.C2725drawable.ic_info_gray_darker);
                Drawable drawable2 = this.this$0.getMContext().getDrawable(C2723R.C2725drawable.ic_bdt_afc);
                this.binding.tvPaymentName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
                RadioButton radioButton24 = this.binding.rbAccountInfo;
                Intrinsics.checkExpressionValueIsNotNull(radioButton24, "binding.rbAccountInfo");
                BDTPaymentMethodAdapter bDTPaymentMethodAdapter = this.this$0;
                radioButton24.setCompoundDrawablePadding((int) bDTPaymentMethodAdapter.convertDpToPixel(10.0f, bDTPaymentMethodAdapter.getMContext()));
                this.this$0.getMContext();
                this.binding.rbAccountInfo.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    public final float convertDpToPixel(float f, @NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
        return f * (((float) resources.getDisplayMetrics().densityDpi) / ((float) 160));
    }
}
