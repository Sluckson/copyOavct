package com.iaai.android.bdt.model.MyAccount;

import com.iaai.android.bdt.model.toBePaid.getDeliveryMethod.RepresentativeInfo;
import com.iaai.android.bdt.model.toBePaid.saleDocument.MailingAddressInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/InsertRepOrAddressRequest;", "", "representativeInfo", "Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/RepresentativeInfo;", "mailingAddressInfo", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/MailingAddressInfo;", "(Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/RepresentativeInfo;Lcom/iaai/android/bdt/model/toBePaid/saleDocument/MailingAddressInfo;)V", "getMailingAddressInfo", "()Lcom/iaai/android/bdt/model/toBePaid/saleDocument/MailingAddressInfo;", "getRepresentativeInfo", "()Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/RepresentativeInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: InsertRepOrAddressRequest.kt */
public final class InsertRepOrAddressRequest {
    @Nullable
    private final MailingAddressInfo mailingAddressInfo;
    @Nullable
    private final RepresentativeInfo representativeInfo;

    @NotNull
    public static /* synthetic */ InsertRepOrAddressRequest copy$default(InsertRepOrAddressRequest insertRepOrAddressRequest, RepresentativeInfo representativeInfo2, MailingAddressInfo mailingAddressInfo2, int i, Object obj) {
        if ((i & 1) != 0) {
            representativeInfo2 = insertRepOrAddressRequest.representativeInfo;
        }
        if ((i & 2) != 0) {
            mailingAddressInfo2 = insertRepOrAddressRequest.mailingAddressInfo;
        }
        return insertRepOrAddressRequest.copy(representativeInfo2, mailingAddressInfo2);
    }

    @Nullable
    public final RepresentativeInfo component1() {
        return this.representativeInfo;
    }

    @Nullable
    public final MailingAddressInfo component2() {
        return this.mailingAddressInfo;
    }

    @NotNull
    public final InsertRepOrAddressRequest copy(@Nullable RepresentativeInfo representativeInfo2, @Nullable MailingAddressInfo mailingAddressInfo2) {
        return new InsertRepOrAddressRequest(representativeInfo2, mailingAddressInfo2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InsertRepOrAddressRequest)) {
            return false;
        }
        InsertRepOrAddressRequest insertRepOrAddressRequest = (InsertRepOrAddressRequest) obj;
        return Intrinsics.areEqual((Object) this.representativeInfo, (Object) insertRepOrAddressRequest.representativeInfo) && Intrinsics.areEqual((Object) this.mailingAddressInfo, (Object) insertRepOrAddressRequest.mailingAddressInfo);
    }

    public int hashCode() {
        RepresentativeInfo representativeInfo2 = this.representativeInfo;
        int i = 0;
        int hashCode = (representativeInfo2 != null ? representativeInfo2.hashCode() : 0) * 31;
        MailingAddressInfo mailingAddressInfo2 = this.mailingAddressInfo;
        if (mailingAddressInfo2 != null) {
            i = mailingAddressInfo2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "InsertRepOrAddressRequest(representativeInfo=" + this.representativeInfo + ", mailingAddressInfo=" + this.mailingAddressInfo + ")";
    }

    public InsertRepOrAddressRequest(@Nullable RepresentativeInfo representativeInfo2, @Nullable MailingAddressInfo mailingAddressInfo2) {
        this.representativeInfo = representativeInfo2;
        this.mailingAddressInfo = mailingAddressInfo2;
    }

    @Nullable
    public final RepresentativeInfo getRepresentativeInfo() {
        return this.representativeInfo;
    }

    @Nullable
    public final MailingAddressInfo getMailingAddressInfo() {
        return this.mailingAddressInfo;
    }
}
