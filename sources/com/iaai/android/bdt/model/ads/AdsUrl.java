package com.iaai.android.bdt.model.ads;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J#\u0010\n\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/ads/AdsUrl;", "", "adsUrl", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getAdsUrl", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AdsUrl.kt */
public final class AdsUrl {
    @NotNull
    private final ArrayList<String> adsUrl;

    @NotNull
    public static /* synthetic */ AdsUrl copy$default(AdsUrl adsUrl2, ArrayList<String> arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = adsUrl2.adsUrl;
        }
        return adsUrl2.copy(arrayList);
    }

    @NotNull
    public final ArrayList<String> component1() {
        return this.adsUrl;
    }

    @NotNull
    public final AdsUrl copy(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "adsUrl");
        return new AdsUrl(arrayList);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof AdsUrl) && Intrinsics.areEqual((Object) this.adsUrl, (Object) ((AdsUrl) obj).adsUrl);
        }
        return true;
    }

    public int hashCode() {
        ArrayList<String> arrayList = this.adsUrl;
        if (arrayList != null) {
            return arrayList.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "AdsUrl(adsUrl=" + this.adsUrl + ")";
    }

    public AdsUrl(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "adsUrl");
        this.adsUrl = arrayList;
    }

    @NotNull
    public final ArrayList<String> getAdsUrl() {
        return this.adsUrl;
    }
}
