package kotlin.math;

import kotlin.Metadata;
import kotlin.jvm.JvmField;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo66933d2 = {"Lkotlin/math/Constants;", "", "()V", "LN2", "", "epsilon", "taylor_2_bound", "taylor_n_bound", "upper_taylor_2_bound", "upper_taylor_n_bound", "kotlin-stdlib"}, mo66934k = 1, mo66935mv = {1, 1, 16})
/* compiled from: MathJVM.kt */
final class Constants {
    public static final Constants INSTANCE = new Constants();
    @JvmField
    public static final double LN2 = Math.log(2.0d);
    @JvmField
    public static final double epsilon = Math.ulp(1.0d);
    @JvmField
    public static final double taylor_2_bound = Math.sqrt(epsilon);
    @JvmField
    public static final double taylor_n_bound = Math.sqrt(taylor_2_bound);
    @JvmField
    public static final double upper_taylor_2_bound;
    @JvmField
    public static final double upper_taylor_n_bound;

    static {
        double d = (double) 1;
        upper_taylor_2_bound = d / taylor_2_bound;
        upper_taylor_n_bound = d / taylor_n_bound;
    }

    private Constants() {
    }
}
