package com.iaai.android.bdt.feature.landing;

import com.google.zxing.client.result.ExpandedProductParsedResult;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/CountryCode;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Country_Azerbaijan", "Country_Georgia", "Country_Lebanon", "Country_Armenia", "Country_Ukraine", "Country_Poland", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: CountryCode.kt */
public enum CountryCode {
    Country_Azerbaijan("AZ"),
    Country_Georgia("GE"),
    Country_Lebanon(ExpandedProductParsedResult.POUND),
    Country_Armenia("AM"),
    Country_Ukraine("UA"),
    Country_Poland("PL");
    
    @NotNull
    private final String value;

    private CountryCode(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
