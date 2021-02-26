package com.iaai.android.bdt.extensions;

import com.lowagie.text.html.HtmlTags;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0001\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0007"}, mo66933d2 = {"toProperCase", "", "s", "getFormattedString", "resetFormattedString", "", "toCamelCase", "app_productionRelease"}, mo66934k = 2, mo66935mv = {1, 1, 13})
/* compiled from: String+Extension.kt */
public final class String_ExtensionKt {
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00cd  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String toCamelCase(@org.jetbrains.annotations.NotNull java.lang.String r14) {
        /*
            java.lang.String r0 = "receiver$0"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r14, r0)
            r0 = r14
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r1 = r0.length()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0012
            r1 = 1
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            if (r1 == 0) goto L_0x0016
            return r14
        L_0x0016:
            kotlin.text.Regex r14 = new kotlin.text.Regex
            java.lang.String r1 = " "
            r14.<init>((java.lang.String) r1)
            java.util.List r14 = r14.split(r0, r3)
            boolean r0 = r14.isEmpty()
            if (r0 != 0) goto L_0x0054
            int r0 = r14.size()
            java.util.ListIterator r0 = r14.listIterator(r0)
        L_0x002f:
            boolean r4 = r0.hasPrevious()
            if (r4 == 0) goto L_0x0054
            java.lang.Object r4 = r0.previous()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 != 0) goto L_0x0045
            r4 = 1
            goto L_0x0046
        L_0x0045:
            r4 = 0
        L_0x0046:
            if (r4 != 0) goto L_0x002f
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            int r0 = r0.nextIndex()
            int r0 = r0 + r2
            java.util.List r14 = kotlin.collections.CollectionsKt.take(r14, r0)
            goto L_0x0058
        L_0x0054:
            java.util.List r14 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0058:
            java.util.Collection r14 = (java.util.Collection) r14
            java.lang.String[] r0 = new java.lang.String[r3]
            java.lang.Object[] r14 = r14.toArray(r0)
            if (r14 == 0) goto L_0x00cd
            java.lang.String[] r14 = (java.lang.String[]) r14
            int r0 = r14.length
            java.lang.String r4 = ""
            r5 = r4
            r4 = 0
        L_0x0069:
            if (r4 >= r0) goto L_0x00cc
            r6 = r14[r4]
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            java.lang.String r13 = "/"
            r8 = r13
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r9 = 2
            r10 = 0
            boolean r8 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r7, (java.lang.CharSequence) r8, (boolean) r3, (int) r9, (java.lang.Object) r10)
            if (r8 == 0) goto L_0x00b3
            java.lang.String[] r8 = new java.lang.String[]{r13}
            r9 = 0
            r10 = 0
            r11 = 6
            r12 = 0
            java.util.List r6 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r7, (java.lang.String[]) r8, (boolean) r9, (int) r10, (int) r11, (java.lang.Object) r12)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r5)
            java.lang.Object r5 = r6.get(r3)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r5 = toProperCase(r5)
            r7.append(r5)
            r7.append(r13)
            java.lang.Object r5 = r6.get(r2)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r5 = toProperCase(r5)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            goto L_0x00c9
        L_0x00b3:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r5)
            java.lang.String r5 = toProperCase(r6)
            r7.append(r5)
            r7.append(r1)
            java.lang.String r5 = r7.toString()
        L_0x00c9:
            int r4 = r4 + 1
            goto L_0x0069
        L_0x00cc:
            return r5
        L_0x00cd:
            kotlin.TypeCastException r14 = new kotlin.TypeCastException
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T>"
            r14.<init>(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.extensions.String_ExtensionKt.toCamelCase(java.lang.String):java.lang.String");
    }

    @NotNull
    public static final String toProperCase(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, HtmlTags.f607S);
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0) || !(!StringsKt.isBlank(charSequence))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, 1);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (substring != null) {
            String upperCase = substring.toUpperCase();
            Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase()");
            sb.append(upperCase);
            String substring2 = str.substring(1);
            Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
            if (substring2 != null) {
                String lowerCase = substring2.toLowerCase();
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
                sb.append(lowerCase);
                return sb.toString();
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @NotNull
    public static final String getFormattedString(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        try {
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) ",", false, 2, (Object) null)) {
                str = new Regex(",").replace((CharSequence) str, "");
            }
            long parseLong = Long.parseLong(str);
            NumberFormat instance = NumberFormat.getInstance(Locale.US);
            if (instance != null) {
                DecimalFormat decimalFormat = (DecimalFormat) instance;
                decimalFormat.applyPattern("#,###,###,###");
                String format = decimalFormat.format(parseLong);
                Intrinsics.checkExpressionValueIsNotNull(format, "formatter.format(longVal)");
                return format;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.text.DecimalFormat");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static final int resetFormattedString(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        return Integer.parseInt(StringsKt.replace$default(StringsKt.replace$default(str, "$", "", false, 4, (Object) null), ",", "", false, 4, (Object) null));
    }
}
