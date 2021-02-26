package p011io.opencensus.tags;

import p011io.opencensus.common.Scope;
import p011io.opencensus.tags.TagMetadata;

/* renamed from: io.opencensus.tags.TagContextBuilder */
public abstract class TagContextBuilder {
    private static final TagMetadata METADATA_NO_PROPAGATION = TagMetadata.create(TagMetadata.TagTtl.NO_PROPAGATION);
    private static final TagMetadata METADATA_UNLIMITED_PROPAGATION = TagMetadata.create(TagMetadata.TagTtl.UNLIMITED_PROPAGATION);

    public abstract TagContext build();

    public abstract Scope buildScoped();

    @Deprecated
    public abstract TagContextBuilder put(TagKey tagKey, TagValue tagValue);

    public abstract TagContextBuilder remove(TagKey tagKey);

    public TagContextBuilder put(TagKey tagKey, TagValue tagValue, TagMetadata tagMetadata) {
        return put(tagKey, tagValue);
    }

    public final TagContextBuilder putLocal(TagKey tagKey, TagValue tagValue) {
        return put(tagKey, tagValue, METADATA_NO_PROPAGATION);
    }

    public final TagContextBuilder putPropagating(TagKey tagKey, TagValue tagValue) {
        return put(tagKey, tagValue, METADATA_UNLIMITED_PROPAGATION);
    }
}
