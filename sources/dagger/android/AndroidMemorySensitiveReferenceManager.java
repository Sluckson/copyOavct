package dagger.android;

import dagger.internal.GwtIncompatible;
import dagger.releasablereferences.TypedReleasableReferenceManager;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;

@Deprecated
@GwtIncompatible
public final class AndroidMemorySensitiveReferenceManager {
    private final Set<TypedReleasableReferenceManager<ReleaseReferencesAt>> managers;

    @Inject
    AndroidMemorySensitiveReferenceManager(Set<TypedReleasableReferenceManager<ReleaseReferencesAt>> set) {
        this.managers = set;
    }

    public void onTrimMemory(int i) {
        Iterator<TypedReleasableReferenceManager<ReleaseReferencesAt>> it = this.managers.iterator();
        while (it.hasNext()) {
            TypedReleasableReferenceManager typedReleasableReferenceManager = (TypedReleasableReferenceManager) it.next();
            if (i >= ((ReleaseReferencesAt) typedReleasableReferenceManager.metadata()).value()) {
                typedReleasableReferenceManager.releaseStrongReferences();
            } else {
                typedReleasableReferenceManager.restoreStrongReferences();
            }
        }
    }
}
