package com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavArgs;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J4\u0010\u0014\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/reviewPayment/ToBePaidReviewFragmentArgs;", "Landroidx/navigation/NavArgs;", "selectedItemsList", "", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "cdfFee", "", "payPalAccountDetailID", "", "([Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;FI)V", "getCdfFee", "()F", "getPayPalAccountDetailID", "()I", "getSelectedItemsList", "()[Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "[Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "component1", "component2", "component3", "copy", "([Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;FI)Lcom/iaai/android/bdt/feature/myAccount/toBePaid/reviewPayment/ToBePaidReviewFragmentArgs;", "equals", "", "other", "", "hashCode", "toBundle", "Landroid/os/Bundle;", "toString", "", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ToBePaidReviewFragmentArgs.kt */
public final class ToBePaidReviewFragmentArgs implements NavArgs {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final float cdfFee;
    private final int payPalAccountDetailID;
    @Nullable
    private final PaymentDue[] selectedItemsList;

    public ToBePaidReviewFragmentArgs() {
        this((PaymentDue[]) null, 0.0f, 0, 7, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static /* synthetic */ ToBePaidReviewFragmentArgs copy$default(ToBePaidReviewFragmentArgs toBePaidReviewFragmentArgs, PaymentDue[] paymentDueArr, float f, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            paymentDueArr = toBePaidReviewFragmentArgs.selectedItemsList;
        }
        if ((i2 & 2) != 0) {
            f = toBePaidReviewFragmentArgs.cdfFee;
        }
        if ((i2 & 4) != 0) {
            i = toBePaidReviewFragmentArgs.payPalAccountDetailID;
        }
        return toBePaidReviewFragmentArgs.copy(paymentDueArr, f, i);
    }

    @JvmStatic
    @NotNull
    public static final ToBePaidReviewFragmentArgs fromBundle(@NotNull Bundle bundle) {
        return Companion.fromBundle(bundle);
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
    public final ToBePaidReviewFragmentArgs copy(@Nullable PaymentDue[] paymentDueArr, float f, int i) {
        return new ToBePaidReviewFragmentArgs(paymentDueArr, f, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof ToBePaidReviewFragmentArgs) {
                ToBePaidReviewFragmentArgs toBePaidReviewFragmentArgs = (ToBePaidReviewFragmentArgs) obj;
                if (Intrinsics.areEqual((Object) this.selectedItemsList, (Object) toBePaidReviewFragmentArgs.selectedItemsList) && Float.compare(this.cdfFee, toBePaidReviewFragmentArgs.cdfFee) == 0) {
                    if (this.payPalAccountDetailID == toBePaidReviewFragmentArgs.payPalAccountDetailID) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        PaymentDue[] paymentDueArr = this.selectedItemsList;
        return ((((paymentDueArr != null ? Arrays.hashCode(paymentDueArr) : 0) * 31) + Float.valueOf(this.cdfFee).hashCode()) * 31) + Integer.valueOf(this.payPalAccountDetailID).hashCode();
    }

    @NotNull
    public String toString() {
        return "ToBePaidReviewFragmentArgs(selectedItemsList=" + Arrays.toString(this.selectedItemsList) + ", cdfFee=" + this.cdfFee + ", payPalAccountDetailID=" + this.payPalAccountDetailID + ")";
    }

    public ToBePaidReviewFragmentArgs(@Nullable PaymentDue[] paymentDueArr, float f, int i) {
        this.selectedItemsList = paymentDueArr;
        this.cdfFee = f;
        this.payPalAccountDetailID = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ToBePaidReviewFragmentArgs(PaymentDue[] paymentDueArr, float f, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
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
    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArray("selectedItemsList", (Parcelable[]) this.selectedItemsList);
        bundle.putFloat("cdfFee", this.cdfFee);
        bundle.putInt("payPalAccountDetailID", this.payPalAccountDetailID);
        return bundle;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/reviewPayment/ToBePaidReviewFragmentArgs$Companion;", "", "()V", "fromBundle", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/reviewPayment/ToBePaidReviewFragmentArgs;", "bundle", "Landroid/os/Bundle;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ToBePaidReviewFragmentArgs.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: type inference failed for: r0v10, types: [java.lang.Object[]] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragmentArgs fromBundle(@org.jetbrains.annotations.NotNull android.os.Bundle r7) {
            /*
                r6 = this;
                java.lang.String r0 = "bundle"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
                java.lang.Class<com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragmentArgs> r0 = com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragmentArgs.class
                java.lang.ClassLoader r0 = r0.getClassLoader()
                r7.setClassLoader(r0)
                java.lang.String r0 = "selectedItemsList"
                boolean r1 = r7.containsKey(r0)
                r2 = 0
                r3 = 0
                if (r1 == 0) goto L_0x0056
                android.os.Parcelable[] r0 = r7.getParcelableArray(r0)
                if (r0 == 0) goto L_0x0058
                java.util.ArrayList r1 = new java.util.ArrayList
                int r2 = r0.length
                r1.<init>(r2)
                java.util.Collection r1 = (java.util.Collection) r1
                int r2 = r0.length
                r4 = 0
            L_0x0028:
                if (r4 >= r2) goto L_0x003e
                r5 = r0[r4]
                if (r5 == 0) goto L_0x0036
                com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue r5 = (com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue) r5
                r1.add(r5)
                int r4 = r4 + 1
                goto L_0x0028
            L_0x0036:
                kotlin.TypeCastException r7 = new kotlin.TypeCastException
                java.lang.String r0 = "null cannot be cast to non-null type com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue"
                r7.<init>(r0)
                throw r7
            L_0x003e:
                java.util.List r1 = (java.util.List) r1
                java.util.Collection r1 = (java.util.Collection) r1
                com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue[] r0 = new com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue[r3]
                java.lang.Object[] r0 = r1.toArray(r0)
                if (r0 == 0) goto L_0x004e
                r2 = r0
                com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue[] r2 = (com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue[]) r2
                goto L_0x0058
            L_0x004e:
                kotlin.TypeCastException r7 = new kotlin.TypeCastException
                java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T>"
                r7.<init>(r0)
                throw r7
            L_0x0056:
                com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue[] r2 = (com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue[]) r2
            L_0x0058:
                java.lang.String r0 = "cdfFee"
                boolean r1 = r7.containsKey(r0)
                if (r1 == 0) goto L_0x0065
                float r0 = r7.getFloat(r0)
                goto L_0x0067
            L_0x0065:
                r0 = 1065353216(0x3f800000, float:1.0)
            L_0x0067:
                java.lang.String r1 = "payPalAccountDetailID"
                boolean r4 = r7.containsKey(r1)
                if (r4 == 0) goto L_0x0073
                int r3 = r7.getInt(r1)
            L_0x0073:
                com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragmentArgs r7 = new com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragmentArgs
                r7.<init>(r2, r0, r3)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragmentArgs.Companion.fromBundle(android.os.Bundle):com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragmentArgs");
        }
    }
}
