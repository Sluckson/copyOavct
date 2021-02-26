package com.iaai.android.bdt.model.announcement;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/announcement/AnnouncementMessage;", "", "enddate", "", "message", "startdate", "subject", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEnddate", "()Ljava/lang/String;", "getMessage", "getStartdate", "getSubject", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AnnouncementMessage.kt */
public final class AnnouncementMessage {
    @NotNull
    private final String enddate;
    @NotNull
    private final String message;
    @NotNull
    private final String startdate;
    @NotNull
    private final String subject;

    @NotNull
    public static /* synthetic */ AnnouncementMessage copy$default(AnnouncementMessage announcementMessage, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = announcementMessage.enddate;
        }
        if ((i & 2) != 0) {
            str2 = announcementMessage.message;
        }
        if ((i & 4) != 0) {
            str3 = announcementMessage.startdate;
        }
        if ((i & 8) != 0) {
            str4 = announcementMessage.subject;
        }
        return announcementMessage.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.enddate;
    }

    @NotNull
    public final String component2() {
        return this.message;
    }

    @NotNull
    public final String component3() {
        return this.startdate;
    }

    @NotNull
    public final String component4() {
        return this.subject;
    }

    @NotNull
    public final AnnouncementMessage copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "enddate");
        Intrinsics.checkParameterIsNotNull(str2, "message");
        Intrinsics.checkParameterIsNotNull(str3, "startdate");
        Intrinsics.checkParameterIsNotNull(str4, "subject");
        return new AnnouncementMessage(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnnouncementMessage)) {
            return false;
        }
        AnnouncementMessage announcementMessage = (AnnouncementMessage) obj;
        return Intrinsics.areEqual((Object) this.enddate, (Object) announcementMessage.enddate) && Intrinsics.areEqual((Object) this.message, (Object) announcementMessage.message) && Intrinsics.areEqual((Object) this.startdate, (Object) announcementMessage.startdate) && Intrinsics.areEqual((Object) this.subject, (Object) announcementMessage.subject);
    }

    public int hashCode() {
        String str = this.enddate;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.message;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.startdate;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.subject;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        return "AnnouncementMessage(enddate=" + this.enddate + ", message=" + this.message + ", startdate=" + this.startdate + ", subject=" + this.subject + ")";
    }

    public AnnouncementMessage(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "enddate");
        Intrinsics.checkParameterIsNotNull(str2, "message");
        Intrinsics.checkParameterIsNotNull(str3, "startdate");
        Intrinsics.checkParameterIsNotNull(str4, "subject");
        this.enddate = str;
        this.message = str2;
        this.startdate = str3;
        this.subject = str4;
    }

    @NotNull
    public final String getEnddate() {
        return this.enddate;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public final String getStartdate() {
        return this.startdate;
    }

    @NotNull
    public final String getSubject() {
        return this.subject;
    }
}
