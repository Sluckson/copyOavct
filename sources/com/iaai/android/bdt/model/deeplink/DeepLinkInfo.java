package com.iaai.android.bdt.model.deeplink;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/deeplink/DeepLinkInfo;", "", "deep_link_name", "", "deep_link_path", "(Ljava/lang/String;Ljava/lang/String;)V", "getDeep_link_name", "()Ljava/lang/String;", "setDeep_link_name", "(Ljava/lang/String;)V", "getDeep_link_path", "setDeep_link_path", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: DeepLinkInfo.kt */
public final class DeepLinkInfo {
    @Nullable
    private String deep_link_name;
    @Nullable
    private String deep_link_path;

    @NotNull
    public static /* synthetic */ DeepLinkInfo copy$default(DeepLinkInfo deepLinkInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deepLinkInfo.deep_link_name;
        }
        if ((i & 2) != 0) {
            str2 = deepLinkInfo.deep_link_path;
        }
        return deepLinkInfo.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.deep_link_name;
    }

    @Nullable
    public final String component2() {
        return this.deep_link_path;
    }

    @NotNull
    public final DeepLinkInfo copy(@Nullable String str, @Nullable String str2) {
        return new DeepLinkInfo(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeepLinkInfo)) {
            return false;
        }
        DeepLinkInfo deepLinkInfo = (DeepLinkInfo) obj;
        return Intrinsics.areEqual((Object) this.deep_link_name, (Object) deepLinkInfo.deep_link_name) && Intrinsics.areEqual((Object) this.deep_link_path, (Object) deepLinkInfo.deep_link_path);
    }

    public int hashCode() {
        String str = this.deep_link_name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.deep_link_path;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "DeepLinkInfo(deep_link_name=" + this.deep_link_name + ", deep_link_path=" + this.deep_link_path + ")";
    }

    public DeepLinkInfo(@Nullable String str, @Nullable String str2) {
        this.deep_link_name = str;
        this.deep_link_path = str2;
    }

    @Nullable
    public final String getDeep_link_name() {
        return this.deep_link_name;
    }

    public final void setDeep_link_name(@Nullable String str) {
        this.deep_link_name = str;
    }

    @Nullable
    public final String getDeep_link_path() {
        return this.deep_link_path;
    }

    public final void setDeep_link_path(@Nullable String str) {
        this.deep_link_path = str;
    }
}
