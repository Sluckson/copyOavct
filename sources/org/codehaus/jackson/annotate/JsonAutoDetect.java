package org.codehaus.jackson.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

@JacksonAnnotation
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonAutoDetect {
    Visibility creatorVisibility() default Visibility.DEFAULT;

    Visibility fieldVisibility() default Visibility.DEFAULT;

    Visibility getterVisibility() default Visibility.DEFAULT;

    Visibility isGetterVisibility() default Visibility.DEFAULT;

    Visibility setterVisibility() default Visibility.DEFAULT;

    JsonMethod[] value() default {JsonMethod.ALL};

    /* renamed from: org.codehaus.jackson.annotate.JsonAutoDetect$1 */
    static /* synthetic */ class C49021 {

        /* renamed from: $SwitchMap$org$codehaus$jackson$annotate$JsonAutoDetect$Visibility */
        static final /* synthetic */ int[] f5826x87517c95 = new int[Visibility.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                org.codehaus.jackson.annotate.JsonAutoDetect$Visibility[] r0 = org.codehaus.jackson.annotate.JsonAutoDetect.Visibility.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5826x87517c95 = r0
                int[] r0 = f5826x87517c95     // Catch:{ NoSuchFieldError -> 0x0014 }
                org.codehaus.jackson.annotate.JsonAutoDetect$Visibility r1 = org.codehaus.jackson.annotate.JsonAutoDetect.Visibility.ANY     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f5826x87517c95     // Catch:{ NoSuchFieldError -> 0x001f }
                org.codehaus.jackson.annotate.JsonAutoDetect$Visibility r1 = org.codehaus.jackson.annotate.JsonAutoDetect.Visibility.NONE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f5826x87517c95     // Catch:{ NoSuchFieldError -> 0x002a }
                org.codehaus.jackson.annotate.JsonAutoDetect$Visibility r1 = org.codehaus.jackson.annotate.JsonAutoDetect.Visibility.NON_PRIVATE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f5826x87517c95     // Catch:{ NoSuchFieldError -> 0x0035 }
                org.codehaus.jackson.annotate.JsonAutoDetect$Visibility r1 = org.codehaus.jackson.annotate.JsonAutoDetect.Visibility.PROTECTED_AND_PUBLIC     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f5826x87517c95     // Catch:{ NoSuchFieldError -> 0x0040 }
                org.codehaus.jackson.annotate.JsonAutoDetect$Visibility r1 = org.codehaus.jackson.annotate.JsonAutoDetect.Visibility.PUBLIC_ONLY     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.annotate.JsonAutoDetect.C49021.<clinit>():void");
        }
    }

    public enum Visibility {
        ANY,
        NON_PRIVATE,
        PROTECTED_AND_PUBLIC,
        PUBLIC_ONLY,
        NONE,
        DEFAULT;

        public boolean isVisible(Member member) {
            int i = C49021.f5826x87517c95[ordinal()];
            if (i == 1) {
                return true;
            }
            if (i == 2) {
                return false;
            }
            if (i == 3) {
                return !Modifier.isPrivate(member.getModifiers());
            }
            if (i != 4) {
                if (i != 5) {
                    return false;
                }
            } else if (Modifier.isProtected(member.getModifiers())) {
                return true;
            }
            return Modifier.isPublic(member.getModifiers());
        }
    }
}
