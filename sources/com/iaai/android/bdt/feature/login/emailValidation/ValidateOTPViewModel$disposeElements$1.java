package com.iaai.android.bdt.feature.login.emailValidation;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.observers.DisposableObserver;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ValidateOTPViewModel.kt */
final class ValidateOTPViewModel$disposeElements$1 extends MutablePropertyReference0 {
    ValidateOTPViewModel$disposeElements$1(ValidateOTPViewModel validateOTPViewModel) {
        super(validateOTPViewModel);
    }

    public String getName() {
        return "disposableObserverValidateOTP";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ValidateOTPViewModel.class);
    }

    public String getSignature() {
        return "getDisposableObserverValidateOTP()Lio/reactivex/observers/DisposableObserver;";
    }

    @Nullable
    public Object get() {
        return ((ValidateOTPViewModel) this.receiver).getDisposableObserverValidateOTP();
    }

    public void set(@Nullable Object obj) {
        ((ValidateOTPViewModel) this.receiver).setDisposableObserverValidateOTP((DisposableObserver) obj);
    }
}
