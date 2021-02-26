package com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavDirections;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/reviewPayment/ToBePaidReviewFragmentDirections;", "", "()V", "ActionToBePaidReviewFragmentToConfirmationFragment", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ToBePaidReviewFragmentDirections.kt */
public final class ToBePaidReviewFragmentDirections {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J*\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/reviewPayment/ToBePaidReviewFragmentDirections$ActionToBePaidReviewFragmentToConfirmationFragment;", "Landroidx/navigation/NavDirections;", "selectedItemsList", "", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "cdfFee", "", "([Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;F)V", "getCdfFee", "()F", "getSelectedItemsList", "()[Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "[Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "component1", "component2", "copy", "([Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;F)Lcom/iaai/android/bdt/feature/myAccount/toBePaid/reviewPayment/ToBePaidReviewFragmentDirections$ActionToBePaidReviewFragmentToConfirmationFragment;", "equals", "", "other", "", "getActionId", "", "getArguments", "Landroid/os/Bundle;", "hashCode", "toString", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ToBePaidReviewFragmentDirections.kt */
    private static final class ActionToBePaidReviewFragmentToConfirmationFragment implements NavDirections {
        private final float cdfFee;
        @Nullable
        private final PaymentDue[] selectedItemsList;

        public ActionToBePaidReviewFragmentToConfirmationFragment() {
            this((PaymentDue[]) null, 0.0f, 3, (DefaultConstructorMarker) null);
        }

        @NotNull
        public static /* synthetic */ ActionToBePaidReviewFragmentToConfirmationFragment copy$default(ActionToBePaidReviewFragmentToConfirmationFragment actionToBePaidReviewFragmentToConfirmationFragment, PaymentDue[] paymentDueArr, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                paymentDueArr = actionToBePaidReviewFragmentToConfirmationFragment.selectedItemsList;
            }
            if ((i & 2) != 0) {
                f = actionToBePaidReviewFragmentToConfirmationFragment.cdfFee;
            }
            return actionToBePaidReviewFragmentToConfirmationFragment.copy(paymentDueArr, f);
        }

        @Nullable
        public final PaymentDue[] component1() {
            return this.selectedItemsList;
        }

        public final float component2() {
            return this.cdfFee;
        }

        @NotNull
        public final ActionToBePaidReviewFragmentToConfirmationFragment copy(@Nullable PaymentDue[] paymentDueArr, float f) {
            return new ActionToBePaidReviewFragmentToConfirmationFragment(paymentDueArr, f);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActionToBePaidReviewFragmentToConfirmationFragment)) {
                return false;
            }
            ActionToBePaidReviewFragmentToConfirmationFragment actionToBePaidReviewFragmentToConfirmationFragment = (ActionToBePaidReviewFragmentToConfirmationFragment) obj;
            return Intrinsics.areEqual((Object) this.selectedItemsList, (Object) actionToBePaidReviewFragmentToConfirmationFragment.selectedItemsList) && Float.compare(this.cdfFee, actionToBePaidReviewFragmentToConfirmationFragment.cdfFee) == 0;
        }

        public int getActionId() {
            return C2723R.C2726id.action_toBePaidReviewFragment_to_ConfirmationFragment;
        }

        public int hashCode() {
            PaymentDue[] paymentDueArr = this.selectedItemsList;
            return ((paymentDueArr != null ? Arrays.hashCode(paymentDueArr) : 0) * 31) + Float.valueOf(this.cdfFee).hashCode();
        }

        @NotNull
        public String toString() {
            return "ActionToBePaidReviewFragmentToConfirmationFragment(selectedItemsList=" + Arrays.toString(this.selectedItemsList) + ", cdfFee=" + this.cdfFee + ")";
        }

        public ActionToBePaidReviewFragmentToConfirmationFragment(@Nullable PaymentDue[] paymentDueArr, float f) {
            this.selectedItemsList = paymentDueArr;
            this.cdfFee = f;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ActionToBePaidReviewFragmentToConfirmationFragment(PaymentDue[] paymentDueArr, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : paymentDueArr, (i & 2) != 0 ? 1.0f : f);
        }

        @Nullable
        public final PaymentDue[] getSelectedItemsList() {
            return this.selectedItemsList;
        }

        public final float getCdfFee() {
            return this.cdfFee;
        }

        @NotNull
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("selectedItemsList", (Parcelable[]) this.selectedItemsList);
            bundle.putFloat("cdfFee", this.cdfFee);
            return bundle;
        }
    }

    private ToBePaidReviewFragmentDirections() {
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\n¨\u0006\u000b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/reviewPayment/ToBePaidReviewFragmentDirections$Companion;", "", "()V", "actionToBePaidReviewFragmentToConfirmationFragment", "Landroidx/navigation/NavDirections;", "selectedItemsList", "", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "cdfFee", "", "([Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;F)Landroidx/navigation/NavDirections;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ToBePaidReviewFragmentDirections.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public static /* synthetic */ NavDirections actionToBePaidReviewFragmentToConfirmationFragment$default(Companion companion, PaymentDue[] paymentDueArr, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                paymentDueArr = null;
            }
            if ((i & 2) != 0) {
                f = 1.0f;
            }
            return companion.actionToBePaidReviewFragmentToConfirmationFragment(paymentDueArr, f);
        }

        @NotNull
        public final NavDirections actionToBePaidReviewFragmentToConfirmationFragment(@Nullable PaymentDue[] paymentDueArr, float f) {
            return new ActionToBePaidReviewFragmentToConfirmationFragment(paymentDueArr, f);
        }
    }
}
