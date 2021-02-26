package com.iaai.android.bdt.factory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Singleton
@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012 \u0010\u0002\u001a\u001c\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u0003¢\u0006\u0002\u0010\u0007J%\u0010\b\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u0004H\u0016¢\u0006\u0002\u0010\u000bR(\u0010\u0002\u001a\u001c\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo66933d2 = {"Lcom/iaai/android/bdt/factory/AppViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModels", "", "Ljava/lang/Class;", "Landroidx/lifecycle/ViewModel;", "Ljavax/inject/Provider;", "(Ljava/util/Map;)V", "create", "T", "modelClass", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AppViewModelFactory.kt */
public final class AppViewModelFactory implements ViewModelProvider.Factory {
    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModels;

    @Inject
    public AppViewModelFactory(@NotNull Map<Class<? extends ViewModel>, Provider<ViewModel>> map) {
        Intrinsics.checkParameterIsNotNull(map, "viewModels");
        this.viewModels = map;
    }

    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(cls, "modelClass");
        Provider provider = this.viewModels.get(cls);
        if (provider == null) {
            Iterator it = this.viewModels.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (cls.isAssignableFrom((Class) ((Map.Entry) obj).getKey())) {
                    break;
                }
            }
            Map.Entry entry = (Map.Entry) obj;
            provider = entry != null ? (Provider) entry.getValue() : null;
        }
        if (provider != null) {
            try {
                T t = provider.get();
                if (t != null) {
                    return (ViewModel) t;
                }
                throw new TypeCastException("null cannot be cast to non-null type T");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new IllegalArgumentException("unknown model class " + cls);
        }
    }
}
