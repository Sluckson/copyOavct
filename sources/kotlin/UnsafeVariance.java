package kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;

@MustBeDocumented
@Target(allowedTargets = {AnnotationTarget.TYPE})
@Retention(AnnotationRetention.SOURCE)
@Documented
@java.lang.annotation.Target({})
@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, mo66933d2 = {"Lkotlin/UnsafeVariance;", "", "kotlin-stdlib"}, mo66934k = 1, mo66935mv = {1, 1, 16})
@java.lang.annotation.Retention(RetentionPolicy.SOURCE)
/* compiled from: Annotations.kt */
public @interface UnsafeVariance {
}
