package com.iaai.android.bdt.feature.landing.recommendedVehicles;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/recommendedVehicles/BadgeType;", "", "id", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "BRE_BADGE", "BRE_BADGE_ACV", "BRE_BADGE_AGE", "BRE_BADGE_FOREIGN", "BRE_BADGE_MAKE_MODEL", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BadgeType.kt */
public enum BadgeType {
    BRE_BADGE("SaleDocType"),
    BRE_BADGE_ACV("ACV"),
    BRE_BADGE_AGE("Age"),
    BRE_BADGE_FOREIGN("ForeignDomestic"),
    BRE_BADGE_MAKE_MODEL("MakeModel");
    
    @NotNull

    /* renamed from: id */
    private final String f503id;

    private BadgeType(String str) {
        this.f503id = str;
    }

    @NotNull
    public final String getId() {
        return this.f503id;
    }
}
