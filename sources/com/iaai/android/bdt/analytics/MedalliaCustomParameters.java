package com.iaai.android.bdt.analytics;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo66933d2 = {"Lcom/iaai/android/bdt/analytics/MedalliaCustomParameters;", "", "()V", "MedalliaCustomParametersKeyNames", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: MedalliaCustomParameters.kt */
public final class MedalliaCustomParameters {
    public static final MedalliaCustomParameters INSTANCE = new MedalliaCustomParameters();

    private MedalliaCustomParameters() {
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/analytics/MedalliaCustomParameters$MedalliaCustomParametersKeyNames;", "", "id", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "PAGE_NAME", "EMPLOYER_ID", "BUYER_ID", "USER_ID", "IS_PROD", "PAYMENT_SOURCE", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: MedalliaCustomParameters.kt */
    public enum MedalliaCustomParametersKeyNames {
        PAGE_NAME("Page Name"),
        EMPLOYER_ID("Employer ID"),
        BUYER_ID("Buyer ID"),
        USER_ID("User ID"),
        IS_PROD("IsProd"),
        PAYMENT_SOURCE("payment_source");
        
        @NotNull

        /* renamed from: id */
        private final String f502id;

        private MedalliaCustomParametersKeyNames(String str) {
            this.f502id = str;
        }

        @NotNull
        public final String getId() {
            return this.f502id;
        }
    }
}
