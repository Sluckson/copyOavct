package dagger.android;

/* renamed from: dagger.android.AutoAnnotation_ReleaseReferencesAtCreator_createReleaseReferencesAt */
final class C4370x2f53ae92 implements ReleaseReferencesAt {
    private final int value;

    C4370x2f53ae92(int i) {
        this.value = i;
    }

    public Class<? extends ReleaseReferencesAt> annotationType() {
        return ReleaseReferencesAt.class;
    }

    public int value() {
        return this.value;
    }

    public String toString() {
        return "@dagger.android.ReleaseReferencesAt(" + this.value + ')';
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReleaseReferencesAt) || this.value != ((ReleaseReferencesAt) obj).value()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.value ^ 1335633679;
    }
}
