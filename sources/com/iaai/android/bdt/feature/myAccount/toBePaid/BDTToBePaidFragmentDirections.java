package com.iaai.android.bdt.feature.myAccount.toBePaid;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/BDTToBePaidFragmentDirections;", "", "()V", "ActionToBePaidFragmentToBePaidReviewFragment", "ActionToBePaidFragmentToDeliveryInstructionFragment", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BDTToBePaidFragmentDirections.kt */
public final class BDTToBePaidFragmentDirections {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J4\u0010\u0014\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\b\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/BDTToBePaidFragmentDirections$ActionToBePaidFragmentToDeliveryInstructionFragment;", "Landroidx/navigation/NavDirections;", "selectedItemsList", "", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "cdfFee", "", "payPalAccountDetailID", "", "([Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;FI)V", "getCdfFee", "()F", "getPayPalAccountDetailID", "()I", "getSelectedItemsList", "()[Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "[Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "component1", "component2", "component3", "copy", "([Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;FI)Lcom/iaai/android/bdt/feature/myAccount/toBePaid/BDTToBePaidFragmentDirections$ActionToBePaidFragmentToDeliveryInstructionFragment;", "equals", "", "other", "", "getActionId", "getArguments", "Landroid/os/Bundle;", "hashCode", "toString", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: BDTToBePaidFragmentDirections.kt */
    private static final class ActionToBePaidFragmentToDeliveryInstructionFragment implements NavDirections {
        private final float cdfFee;
        private final int payPalAccountDetailID;
        @Nullable
        private final PaymentDue[] selectedItemsList;

        public ActionToBePaidFragmentToDeliveryInstructionFragment() {
            this((PaymentDue[]) null, 0.0f, 0, 7, (DefaultConstructorMarker) null);
        }

        @NotNull
        public static /* synthetic */ ActionToBePaidFragmentToDeliveryInstructionFragment copy$default(ActionToBePaidFragmentToDeliveryInstructionFragment actionToBePaidFragmentToDeliveryInstructionFragment, PaymentDue[] paymentDueArr, float f, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                paymentDueArr = actionToBePaidFragmentToDeliveryInstructionFragment.selectedItemsList;
            }
            if ((i2 & 2) != 0) {
                f = actionToBePaidFragmentToDeliveryInstructionFragment.cdfFee;
            }
            if ((i2 & 4) != 0) {
                i = actionToBePaidFragmentToDeliveryInstructionFragment.payPalAccountDetailID;
            }
            return actionToBePaidFragmentToDeliveryInstructionFragment.copy(paymentDueArr, f, i);
        }

        @Nullable
        public final PaymentDue[] component1() {
            return this.selectedItemsList;
        }

        public final float component2() {
            return this.cdfFee;
        }

        public final int component3() {
            return this.payPalAccountDetailID;
        }

        @NotNull
        public final ActionToBePaidFragmentToDeliveryInstructionFragment copy(@Nullable PaymentDue[] paymentDueArr, float f, int i) {
            return new ActionToBePaidFragmentToDeliveryInstructionFragment(paymentDueArr, f, i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof ActionToBePaidFragmentToDeliveryInstructionFragment) {
                    ActionToBePaidFragmentToDeliveryInstructionFragment actionToBePaidFragmentToDeliveryInstructionFragment = (ActionToBePaidFragmentToDeliveryInstructionFragment) obj;
                    if (Intrinsics.areEqual((Object) this.selectedItemsList, (Object) actionToBePaidFragmentToDeliveryInstructionFragment.selectedItemsList) && Float.compare(this.cdfFee, actionToBePaidFragmentToDeliveryInstructionFragment.cdfFee) == 0) {
                        if (this.payPalAccountDetailID == actionToBePaidFragmentToDeliveryInstructionFragment.payPalAccountDetailID) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int getActionId() {
            return C2723R.C2726id.action_toBePaidFragment_to_DeliveryInstructionFragment;
        }

        public int hashCode() {
            PaymentDue[] paymentDueArr = this.selectedItemsList;
            return ((((paymentDueArr != null ? Arrays.hashCode(paymentDueArr) : 0) * 31) + Float.valueOf(this.cdfFee).hashCode()) * 31) + Integer.valueOf(this.payPalAccountDetailID).hashCode();
        }

        @NotNull
        public String toString() {
            return "ActionToBePaidFragmentToDeliveryInstructionFragment(selectedItemsList=" + Arrays.toString(this.selectedItemsList) + ", cdfFee=" + this.cdfFee + ", payPalAccountDetailID=" + this.payPalAccountDetailID + ")";
        }

        public ActionToBePaidFragmentToDeliveryInstructionFragment(@Nullable PaymentDue[] paymentDueArr, float f, int i) {
            this.selectedItemsList = paymentDueArr;
            this.cdfFee = f;
            this.payPalAccountDetailID = i;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ActionToBePaidFragmentToDeliveryInstructionFragment(PaymentDue[] paymentDueArr, float f, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : paymentDueArr, (i2 & 2) != 0 ? 1.0f : f, (i2 & 4) != 0 ? 0 : i);
        }

        @Nullable
        public final PaymentDue[] getSelectedItemsList() {
            return this.selectedItemsList;
        }

        public final float getCdfFee() {
            return this.cdfFee;
        }

        public final int getPayPalAccountDetailID() {
            return this.payPalAccountDetailID;
        }

        @NotNull
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("selectedItemsList", (Parcelable[]) this.selectedItemsList);
            bundle.putFloat("cdfFee", this.cdfFee);
            bundle.putInt("payPalAccountDetailID", this.payPalAccountDetailID);
            return bundle;
        }
    }

    private BDTToBePaidFragmentDirections() {
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J4\u0010\u0014\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\b\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/BDTToBePaidFragmentDirections$ActionToBePaidFragmentToBePaidReviewFragment;", "Landroidx/navigation/NavDirections;", "selectedItemsList", "", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "cdfFee", "", "payPalAccountDetailID", "", "([Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;FI)V", "getCdfFee", "()F", "getPayPalAccountDetailID", "()I", "getSelectedItemsList", "()[Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "[Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "component1", "component2", "component3", "copy", "([Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;FI)Lcom/iaai/android/bdt/feature/myAccount/toBePaid/BDTToBePaidFragmentDirections$ActionToBePaidFragmentToBePaidReviewFragment;", "equals", "", "other", "", "getActionId", "getArguments", "Landroid/os/Bundle;", "hashCode", "toString", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: BDTToBePaidFragmentDirections.kt */
    private static final class ActionToBePaidFragmentToBePaidReviewFragment implements NavDirections {
        private final float cdfFee;
        private final int payPalAccountDetailID;
        @Nullable
        private final PaymentDue[] selectedItemsList;

        public ActionToBePaidFragmentToBePaidReviewFragment() {
            this((PaymentDue[]) null, 0.0f, 0, 7, (DefaultConstructorMarker) null);
        }

        @NotNull
        public static /* synthetic */ ActionToBePaidFragmentToBePaidReviewFragment copy$default(ActionToBePaidFragmentToBePaidReviewFragment actionToBePaidFragmentToBePaidReviewFragment, PaymentDue[] paymentDueArr, float f, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                paymentDueArr = actionToBePaidFragmentToBePaidReviewFragment.selectedItemsList;
            }
            if ((i2 & 2) != 0) {
                f = actionToBePaidFragmentToBePaidReviewFragment.cdfFee;
            }
            if ((i2 & 4) != 0) {
                i = actionToBePaidFragmentToBePaidReviewFragment.payPalAccountDetailID;
            }
            return actionToBePaidFragmentToBePaidReviewFragment.copy(paymentDueArr, f, i);
        }

        @Nullable
        public final PaymentDue[] component1() {
            return this.selectedItemsList;
        }

        public final float component2() {
            return this.cdfFee;
        }

        public final int component3() {
            return this.payPalAccountDetailID;
        }

        @NotNull
        public final ActionToBePaidFragmentToBePaidReviewFragment copy(@Nullable PaymentDue[] paymentDueArr, float f, int i) {
            return new ActionToBePaidFragmentToBePaidReviewFragment(paymentDueArr, f, i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof ActionToBePaidFragmentToBePaidReviewFragment) {
                    ActionToBePaidFragmentToBePaidReviewFragment actionToBePaidFragmentToBePaidReviewFragment = (ActionToBePaidFragmentToBePaidReviewFragment) obj;
                    if (Intrinsics.areEqual((Object) this.selectedItemsList, (Object) actionToBePaidFragmentToBePaidReviewFragment.selectedItemsList) && Float.compare(this.cdfFee, actionToBePaidFragmentToBePaidReviewFragment.cdfFee) == 0) {
                        if (this.payPalAccountDetailID == actionToBePaidFragmentToBePaidReviewFragment.payPalAccountDetailID) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int getActionId() {
            return C2723R.C2726id.action_toBePaidFragment_toBePaidReviewFragment;
        }

        public int hashCode() {
            PaymentDue[] paymentDueArr = this.selectedItemsList;
            return ((((paymentDueArr != null ? Arrays.hashCode(paymentDueArr) : 0) * 31) + Float.valueOf(this.cdfFee).hashCode()) * 31) + Integer.valueOf(this.payPalAccountDetailID).hashCode();
        }

        @NotNull
        public String toString() {
            return "ActionToBePaidFragmentToBePaidReviewFragment(selectedItemsList=" + Arrays.toString(this.selectedItemsList) + ", cdfFee=" + this.cdfFee + ", payPalAccountDetailID=" + this.payPalAccountDetailID + ")";
        }

        public ActionToBePaidFragmentToBePaidReviewFragment(@Nullable PaymentDue[] paymentDueArr, float f, int i) {
            this.selectedItemsList = paymentDueArr;
            this.cdfFee = f;
            this.payPalAccountDetailID = i;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ActionToBePaidFragmentToBePaidReviewFragment(PaymentDue[] paymentDueArr, float f, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : paymentDueArr, (i2 & 2) != 0 ? 1.0f : f, (i2 & 4) != 0 ? 0 : i);
        }

        @Nullable
        public final PaymentDue[] getSelectedItemsList() {
            return this.selectedItemsList;
        }

        public final float getCdfFee() {
            return this.cdfFee;
        }

        public final int getPayPalAccountDetailID() {
            return this.payPalAccountDetailID;
        }

        @NotNull
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("selectedItemsList", (Parcelable[]) this.selectedItemsList);
            bundle.putFloat("cdfFee", this.cdfFee);
            bundle.putInt("payPalAccountDetailID", this.payPalAccountDetailID);
            return bundle;
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J1\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ1\u0010\u000e\u001a\u00020\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\r¨\u0006\u000f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/BDTToBePaidFragmentDirections$Companion;", "", "()V", "actionACFragmentToViewPagerPDFragment", "Landroidx/navigation/NavDirections;", "actionToBePaidFragmentToBePaidReviewFragment", "selectedItemsList", "", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "cdfFee", "", "payPalAccountDetailID", "", "([Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;FI)Landroidx/navigation/NavDirections;", "actionToBePaidFragmentToDeliveryInstructionFragment", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: BDTToBePaidFragmentDirections.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final NavDirections actionACFragmentToViewPagerPDFragment() {
            return new ActionOnlyNavDirections(C2723R.C2726id.action_ACFragment_to_View_Pager_PDFragment);
        }

        @NotNull
        public static /* synthetic */ NavDirections actionToBePaidFragmentToDeliveryInstructionFragment$default(Companion companion, PaymentDue[] paymentDueArr, float f, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                paymentDueArr = null;
            }
            if ((i2 & 2) != 0) {
                f = 1.0f;
            }
            if ((i2 & 4) != 0) {
                i = 0;
            }
            return companion.actionToBePaidFragmentToDeliveryInstructionFragment(paymentDueArr, f, i);
        }

        @NotNull
        public final NavDirections actionToBePaidFragmentToDeliveryInstructionFragment(@Nullable PaymentDue[] paymentDueArr, float f, int i) {
            return new ActionToBePaidFragmentToDeliveryInstructionFragment(paymentDueArr, f, i);
        }

        @NotNull
        public static /* synthetic */ NavDirections actionToBePaidFragmentToBePaidReviewFragment$default(Companion companion, PaymentDue[] paymentDueArr, float f, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                paymentDueArr = null;
            }
            if ((i2 & 2) != 0) {
                f = 1.0f;
            }
            if ((i2 & 4) != 0) {
                i = 0;
            }
            return companion.actionToBePaidFragmentToBePaidReviewFragment(paymentDueArr, f, i);
        }

        @NotNull
        public final NavDirections actionToBePaidFragmentToBePaidReviewFragment(@Nullable PaymentDue[] paymentDueArr, float f, int i) {
            return new ActionToBePaidFragmentToBePaidReviewFragment(paymentDueArr, f, i);
        }
    }
}
