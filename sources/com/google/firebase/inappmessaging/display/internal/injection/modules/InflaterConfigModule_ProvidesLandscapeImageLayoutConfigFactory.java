package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.util.DisplayMetrics;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InflaterConfigModule_ProvidesLandscapeImageLayoutConfigFactory implements Factory<InAppMessageLayoutConfig> {
    private final Provider<DisplayMetrics> displayMetricsProvider;
    private final InflaterConfigModule module;

    public InflaterConfigModule_ProvidesLandscapeImageLayoutConfigFactory(InflaterConfigModule inflaterConfigModule, Provider<DisplayMetrics> provider) {
        this.module = inflaterConfigModule;
        this.displayMetricsProvider = provider;
    }

    public InAppMessageLayoutConfig get() {
        return providesLandscapeImageLayoutConfig(this.module, this.displayMetricsProvider.get());
    }

    public static InflaterConfigModule_ProvidesLandscapeImageLayoutConfigFactory create(InflaterConfigModule inflaterConfigModule, Provider<DisplayMetrics> provider) {
        return new InflaterConfigModule_ProvidesLandscapeImageLayoutConfigFactory(inflaterConfigModule, provider);
    }

    public static InAppMessageLayoutConfig providesLandscapeImageLayoutConfig(InflaterConfigModule inflaterConfigModule, DisplayMetrics displayMetrics) {
        return (InAppMessageLayoutConfig) Preconditions.checkNotNull(inflaterConfigModule.providesLandscapeImageLayoutConfig(displayMetrics), "Cannot return null from a non-@Nullable @Provides method");
    }
}
