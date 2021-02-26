package com.iaai.android.bdt.model.toBePaid.getDeliveryMethod;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0001\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0001HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/TitleHandlingInstructionMail;", "", "MailAddress", "", "Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/MailAddres;", "TitleInstructionID", "TitleInstructionTypeCode", "", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/String;)V", "getMailAddress", "()Ljava/util/List;", "getTitleInstructionID", "()Ljava/lang/Object;", "getTitleInstructionTypeCode", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: TitleHandlingInstructionMail.kt */
public final class TitleHandlingInstructionMail {
    @NotNull
    private final List<MailAddres> MailAddress;
    @NotNull
    private final Object TitleInstructionID;
    @Nullable
    private final String TitleInstructionTypeCode;

    @NotNull
    public static /* synthetic */ TitleHandlingInstructionMail copy$default(TitleHandlingInstructionMail titleHandlingInstructionMail, List<MailAddres> list, Object obj, String str, int i, Object obj2) {
        if ((i & 1) != 0) {
            list = titleHandlingInstructionMail.MailAddress;
        }
        if ((i & 2) != 0) {
            obj = titleHandlingInstructionMail.TitleInstructionID;
        }
        if ((i & 4) != 0) {
            str = titleHandlingInstructionMail.TitleInstructionTypeCode;
        }
        return titleHandlingInstructionMail.copy(list, obj, str);
    }

    @NotNull
    public final List<MailAddres> component1() {
        return this.MailAddress;
    }

    @NotNull
    public final Object component2() {
        return this.TitleInstructionID;
    }

    @Nullable
    public final String component3() {
        return this.TitleInstructionTypeCode;
    }

    @NotNull
    public final TitleHandlingInstructionMail copy(@NotNull List<MailAddres> list, @NotNull Object obj, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(list, "MailAddress");
        Intrinsics.checkParameterIsNotNull(obj, "TitleInstructionID");
        return new TitleHandlingInstructionMail(list, obj, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TitleHandlingInstructionMail)) {
            return false;
        }
        TitleHandlingInstructionMail titleHandlingInstructionMail = (TitleHandlingInstructionMail) obj;
        return Intrinsics.areEqual((Object) this.MailAddress, (Object) titleHandlingInstructionMail.MailAddress) && Intrinsics.areEqual(this.TitleInstructionID, titleHandlingInstructionMail.TitleInstructionID) && Intrinsics.areEqual((Object) this.TitleInstructionTypeCode, (Object) titleHandlingInstructionMail.TitleInstructionTypeCode);
    }

    public int hashCode() {
        List<MailAddres> list = this.MailAddress;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Object obj = this.TitleInstructionID;
        int hashCode2 = (hashCode + (obj != null ? obj.hashCode() : 0)) * 31;
        String str = this.TitleInstructionTypeCode;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        return "TitleHandlingInstructionMail(MailAddress=" + this.MailAddress + ", TitleInstructionID=" + this.TitleInstructionID + ", TitleInstructionTypeCode=" + this.TitleInstructionTypeCode + ")";
    }

    public TitleHandlingInstructionMail(@NotNull List<MailAddres> list, @NotNull Object obj, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(list, "MailAddress");
        Intrinsics.checkParameterIsNotNull(obj, "TitleInstructionID");
        this.MailAddress = list;
        this.TitleInstructionID = obj;
        this.TitleInstructionTypeCode = str;
    }

    @NotNull
    public final List<MailAddres> getMailAddress() {
        return this.MailAddress;
    }

    @NotNull
    public final Object getTitleInstructionID() {
        return this.TitleInstructionID;
    }

    @Nullable
    public final String getTitleInstructionTypeCode() {
        return this.TitleInstructionTypeCode;
    }
}
