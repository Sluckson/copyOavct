package com.iaai.android.bdt.feature.applaunch;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class MakeModelViewModel_Factory implements Factory<MakeModelViewModel> {
    private final Provider<MakeModelMasterRepository> repositoryProvider;

    public MakeModelViewModel_Factory(Provider<MakeModelMasterRepository> provider) {
        this.repositoryProvider = provider;
    }

    public MakeModelViewModel get() {
        return provideInstance(this.repositoryProvider);
    }

    public static MakeModelViewModel provideInstance(Provider<MakeModelMasterRepository> provider) {
        return new MakeModelViewModel(provider.get());
    }

    public static MakeModelViewModel_Factory create(Provider<MakeModelMasterRepository> provider) {
        return new MakeModelViewModel_Factory(provider);
    }

    public static MakeModelViewModel newMakeModelViewModel(MakeModelMasterRepository makeModelMasterRepository) {
        return new MakeModelViewModel(makeModelMasterRepository);
    }
}
