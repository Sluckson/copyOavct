package com.medallia.digital.mobilesdk;

/* renamed from: com.medallia.digital.mobilesdk.n5 */
class C3652n5 {

    /* renamed from: com.medallia.digital.mobilesdk.n5$a */
    static /* synthetic */ class C3653a {

        /* renamed from: a */
        static final /* synthetic */ int[] f1592a = new int[C3640m5.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|(3:11|12|14)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.medallia.digital.mobilesdk.m5[] r0 = com.medallia.digital.mobilesdk.C3640m5.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1592a = r0
                int[] r0 = f1592a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.medallia.digital.mobilesdk.m5 r1 = com.medallia.digital.mobilesdk.C3640m5.Fade     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f1592a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.medallia.digital.mobilesdk.m5 r1 = com.medallia.digital.mobilesdk.C3640m5.SlideDown     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f1592a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.medallia.digital.mobilesdk.m5 r1 = com.medallia.digital.mobilesdk.C3640m5.SlideUp     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f1592a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.medallia.digital.mobilesdk.m5 r1 = com.medallia.digital.mobilesdk.C3640m5.SlideLeft     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f1592a     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.medallia.digital.mobilesdk.m5 r1 = com.medallia.digital.mobilesdk.C3640m5.SlideRight     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r0 = f1592a     // Catch:{ NoSuchFieldError -> 0x004b }
                com.medallia.digital.mobilesdk.m5 r1 = com.medallia.digital.mobilesdk.C3640m5.f1506g     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.medallia.digital.mobilesdk.C3652n5.C3653a.<clinit>():void");
        }
    }

    C3652n5() {
    }

    /* renamed from: a */
    protected static C3539g2 m1374a(C3640m5 m5Var) {
        if (m5Var == null) {
            return new C3539g2(C3417R.anim.medallia_from_fade_in, C3417R.anim.medallia_to_fade_out);
        }
        switch (C3653a.f1592a[m5Var.ordinal()]) {
            case 1:
                return new C3539g2(C3417R.anim.medallia_from_fade_in, C3417R.anim.medallia_to_fade_out);
            case 2:
                return new C3539g2(C3417R.anim.medallia_slide_from_up, C3417R.anim.medallia_background_alpha);
            case 3:
                return new C3539g2(C3417R.anim.medallia_slide_from_down, C3417R.anim.medallia_background_alpha);
            case 4:
                return new C3539g2(C3417R.anim.medallia_slide_from_right, C3417R.anim.medallia_slide_to_left);
            case 5:
                return new C3539g2(C3417R.anim.medallia_slide_from_left, C3417R.anim.medallia_slide_to_right);
            case 6:
                return new C3539g2(0, 0);
            default:
                return new C3539g2(C3417R.anim.medallia_from_fade_in, C3417R.anim.medallia_to_fade_out);
        }
    }

    /* renamed from: b */
    protected static C3539g2 m1375b(C3640m5 m5Var) {
        if (m5Var == null) {
            return new C3539g2(C3417R.anim.medallia_from_fade_out, C3417R.anim.medallia_to_fade_in);
        }
        switch (C3653a.f1592a[m5Var.ordinal()]) {
            case 1:
                return new C3539g2(C3417R.anim.medallia_from_fade_out, C3417R.anim.medallia_to_fade_in);
            case 2:
                return new C3539g2(C3417R.anim.medallia_background_alpha, C3417R.anim.medallia_slide_to_down);
            case 3:
                return new C3539g2(C3417R.anim.medallia_background_alpha, C3417R.anim.medallia_slide_up_down);
            case 4:
                return new C3539g2(C3417R.anim.medallia_slide_from_left, C3417R.anim.medallia_slide_to_right);
            case 5:
                return new C3539g2(C3417R.anim.medallia_slide_from_right, C3417R.anim.medallia_slide_to_left);
            case 6:
                return new C3539g2(0, 0);
            default:
                return new C3539g2(C3417R.anim.medallia_from_fade_out, C3417R.anim.medallia_to_fade_in);
        }
    }
}
