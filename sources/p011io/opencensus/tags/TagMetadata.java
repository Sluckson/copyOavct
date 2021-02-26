package p011io.opencensus.tags;

import javax.annotation.concurrent.Immutable;

@Immutable
/* renamed from: io.opencensus.tags.TagMetadata */
public abstract class TagMetadata {
    public abstract TagTtl getTagTtl();

    TagMetadata() {
    }

    public static TagMetadata create(TagTtl tagTtl) {
        return new AutoValue_TagMetadata(tagTtl);
    }

    /* renamed from: io.opencensus.tags.TagMetadata$TagTtl */
    public enum TagTtl {
        NO_PROPAGATION(0),
        UNLIMITED_PROPAGATION(-1);
        
        private final int hops;

        private TagTtl(int i) {
            this.hops = i;
        }
    }
}
