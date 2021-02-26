package com.iaai.android.bdt.model.logIAAError;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JG\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/logIAAError/LogIAAErrorRequest;", "", "UserID", "", "MethodName", "Request", "Response", "Description", "HTTPStatus", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getHTTPStatus", "getMethodName", "getRequest", "getResponse", "getUserID", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: LogIAAErrorRequest.kt */
public final class LogIAAErrorRequest {
    @NotNull
    private final String Description;
    @NotNull
    private final String HTTPStatus;
    @NotNull
    private final String MethodName;
    @NotNull
    private final String Request;
    @NotNull
    private final String Response;
    @Nullable
    private final String UserID;

    @NotNull
    public static /* synthetic */ LogIAAErrorRequest copy$default(LogIAAErrorRequest logIAAErrorRequest, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = logIAAErrorRequest.UserID;
        }
        if ((i & 2) != 0) {
            str2 = logIAAErrorRequest.MethodName;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = logIAAErrorRequest.Request;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = logIAAErrorRequest.Response;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = logIAAErrorRequest.Description;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = logIAAErrorRequest.HTTPStatus;
        }
        return logIAAErrorRequest.copy(str, str7, str8, str9, str10, str6);
    }

    @Nullable
    public final String component1() {
        return this.UserID;
    }

    @NotNull
    public final String component2() {
        return this.MethodName;
    }

    @NotNull
    public final String component3() {
        return this.Request;
    }

    @NotNull
    public final String component4() {
        return this.Response;
    }

    @NotNull
    public final String component5() {
        return this.Description;
    }

    @NotNull
    public final String component6() {
        return this.HTTPStatus;
    }

    @NotNull
    public final LogIAAErrorRequest copy(@Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkParameterIsNotNull(str2, "MethodName");
        Intrinsics.checkParameterIsNotNull(str3, "Request");
        Intrinsics.checkParameterIsNotNull(str4, "Response");
        Intrinsics.checkParameterIsNotNull(str5, "Description");
        Intrinsics.checkParameterIsNotNull(str6, "HTTPStatus");
        return new LogIAAErrorRequest(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogIAAErrorRequest)) {
            return false;
        }
        LogIAAErrorRequest logIAAErrorRequest = (LogIAAErrorRequest) obj;
        return Intrinsics.areEqual((Object) this.UserID, (Object) logIAAErrorRequest.UserID) && Intrinsics.areEqual((Object) this.MethodName, (Object) logIAAErrorRequest.MethodName) && Intrinsics.areEqual((Object) this.Request, (Object) logIAAErrorRequest.Request) && Intrinsics.areEqual((Object) this.Response, (Object) logIAAErrorRequest.Response) && Intrinsics.areEqual((Object) this.Description, (Object) logIAAErrorRequest.Description) && Intrinsics.areEqual((Object) this.HTTPStatus, (Object) logIAAErrorRequest.HTTPStatus);
    }

    public int hashCode() {
        String str = this.UserID;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.MethodName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.Request;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.Response;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.Description;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.HTTPStatus;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode5 + i;
    }

    @NotNull
    public String toString() {
        return "LogIAAErrorRequest(UserID=" + this.UserID + ", MethodName=" + this.MethodName + ", Request=" + this.Request + ", Response=" + this.Response + ", Description=" + this.Description + ", HTTPStatus=" + this.HTTPStatus + ")";
    }

    public LogIAAErrorRequest(@Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkParameterIsNotNull(str2, "MethodName");
        Intrinsics.checkParameterIsNotNull(str3, "Request");
        Intrinsics.checkParameterIsNotNull(str4, "Response");
        Intrinsics.checkParameterIsNotNull(str5, "Description");
        Intrinsics.checkParameterIsNotNull(str6, "HTTPStatus");
        this.UserID = str;
        this.MethodName = str2;
        this.Request = str3;
        this.Response = str4;
        this.Description = str5;
        this.HTTPStatus = str6;
    }

    @Nullable
    public final String getUserID() {
        return this.UserID;
    }

    @NotNull
    public final String getMethodName() {
        return this.MethodName;
    }

    @NotNull
    public final String getRequest() {
        return this.Request;
    }

    @NotNull
    public final String getResponse() {
        return this.Response;
    }

    @NotNull
    public final String getDescription() {
        return this.Description;
    }

    @NotNull
    public final String getHTTPStatus() {
        return this.HTTPStatus;
    }
}
