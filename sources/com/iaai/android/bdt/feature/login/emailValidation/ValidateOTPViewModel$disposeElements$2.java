package com.iaai.android.bdt.feature.login.emailValidation;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ValidateOTPViewModel.kt */
final class ValidateOTPViewModel$disposeElements$2 extends MutablePropertyReference0 {
    ValidateOTPViewModel$disposeElements$2(ValidateOTPViewModel validateOTPViewModel) {
        super(validateOTPViewModel);
    }

    public String getName() {
        return "disposableObserverGenerateOTP";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ValidateOTPViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserverGenerateOTP()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return ValidateOTPViewModel.access$getDisposableObserverGenerateOTP$p((ValidateOTPViewModel) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((ValidateOTPViewModel) this.receiver).disposableObserverGenerateOTP = (DisposableObserver) obj;
    }
}
