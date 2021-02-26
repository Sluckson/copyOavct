package com.iaai.android.bdt.injection.module;

import androidx.lifecycle.ViewModel;
import dagger.MapKey;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.METHOD})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION})
@MapKey
@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0010\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003R\u0017\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, mo66933d2 = {"Lcom/iaai/android/bdt/injection/module/ViewModelKey;", "", "value", "Lkotlin/reflect/KClass;", "Landroidx/lifecycle/ViewModel;", "()Ljava/lang/Class;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: ViewModelKey.kt */
public @interface ViewModelKey {
    Class<? extends ViewModel> value();
}
