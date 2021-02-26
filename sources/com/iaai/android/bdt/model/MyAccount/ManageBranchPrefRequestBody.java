package com.iaai.android.bdt.model.MyAccount;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/ManageBranchPrefRequestBody;", "", "titleHandlingInstructionCode", "", "accountnumber", "representativeName", "mailAddressInfo", "Lcom/iaai/android/bdt/model/MyAccount/MailAddressInfo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/iaai/android/bdt/model/MyAccount/MailAddressInfo;)V", "getAccountnumber", "()Ljava/lang/String;", "getMailAddressInfo", "()Lcom/iaai/android/bdt/model/MyAccount/MailAddressInfo;", "getRepresentativeName", "getTitleHandlingInstructionCode", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ManageBranchPrefRequestBody.kt */
public final class ManageBranchPrefRequestBody {
    @Nullable
    private final String accountnumber;
    @NotNull
    private final MailAddressInfo mailAddressInfo;
    @Nullable
    private final String representativeName;
    @Nullable
    private final String titleHandlingInstructionCode;

    @NotNull
    public static /* synthetic */ ManageBranchPrefRequestBody copy$default(ManageBranchPrefRequestBody manageBranchPrefRequestBody, String str, String str2, String str3, MailAddressInfo mailAddressInfo2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = manageBranchPrefRequestBody.titleHandlingInstructionCode;
        }
        if ((i & 2) != 0) {
            str2 = manageBranchPrefRequestBody.accountnumber;
        }
        if ((i & 4) != 0) {
            str3 = manageBranchPrefRequestBody.representativeName;
        }
        if ((i & 8) != 0) {
            mailAddressInfo2 = manageBranchPrefRequestBody.mailAddressInfo;
        }
        return manageBranchPrefRequestBody.copy(str, str2, str3, mailAddressInfo2);
    }

    @Nullable
    public final String component1() {
        return this.titleHandlingInstructionCode;
    }

    @Nullable
    public final String component2() {
        return this.accountnumber;
    }

    @Nullable
    public final String component3() {
        return this.representativeName;
    }

    @NotNull
    public final MailAddressInfo component4() {
        return this.mailAddressInfo;
    }

    @NotNull
    public final ManageBranchPrefRequestBody copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull MailAddressInfo mailAddressInfo2) {
        Intrinsics.checkParameterIsNotNull(mailAddressInfo2, "mailAddressInfo");
        return new ManageBranchPrefRequestBody(str, str2, str3, mailAddressInfo2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ManageBranchPrefRequestBody)) {
            return false;
        }
        ManageBranchPrefRequestBody manageBranchPrefRequestBody = (ManageBranchPrefRequestBody) obj;
        return Intrinsics.areEqual((Object) this.titleHandlingInstructionCode, (Object) manageBranchPrefRequestBody.titleHandlingInstructionCode) && Intrinsics.areEqual((Object) this.accountnumber, (Object) manageBranchPrefRequestBody.accountnumber) && Intrinsics.areEqual((Object) this.representativeName, (Object) manageBranchPrefRequestBody.representativeName) && Intrinsics.areEqual((Object) this.mailAddressInfo, (Object) manageBranchPrefRequestBody.mailAddressInfo);
    }

    public int hashCode() {
        String str = this.titleHandlingInstructionCode;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.accountnumber;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.representativeName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        MailAddressInfo mailAddressInfo2 = this.mailAddressInfo;
        if (mailAddressInfo2 != null) {
            i = mailAddressInfo2.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        return "ManageBranchPrefRequestBody(titleHandlingInstructionCode=" + this.titleHandlingInstructionCode + ", accountnumber=" + this.accountnumber + ", representativeName=" + this.representativeName + ", mailAddressInfo=" + this.mailAddressInfo + ")";
    }

    public ManageBranchPrefRequestBody(@Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull MailAddressInfo mailAddressInfo2) {
        Intrinsics.checkParameterIsNotNull(mailAddressInfo2, "mailAddressInfo");
        this.titleHandlingInstructionCode = str;
        this.accountnumber = str2;
        this.representativeName = str3;
        this.mailAddressInfo = mailAddressInfo2;
    }

    @Nullable
    public final String getTitleHandlingInstructionCode() {
        return this.titleHandlingInstructionCode;
    }

    @Nullable
    public final String getAccountnumber() {
        return this.accountnumber;
    }

    @Nullable
    public final String getRepresentativeName() {
        return this.representativeName;
    }

    @NotNull
    public final MailAddressInfo getMailAddressInfo() {
        return this.mailAddressInfo;
    }
}
