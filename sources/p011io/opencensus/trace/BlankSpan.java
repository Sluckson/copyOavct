package p011io.opencensus.trace;

import com.lowagie.text.ElementTags;
import java.util.EnumSet;
import java.util.Map;
import javax.annotation.concurrent.Immutable;
import p011io.opencensus.internal.Utils;
import p011io.opencensus.trace.Span;

@Immutable
/* renamed from: io.opencensus.trace.BlankSpan */
public final class BlankSpan extends Span {
    public static final BlankSpan INSTANCE = new BlankSpan();

    @Deprecated
    public void addNetworkEvent(NetworkEvent networkEvent) {
    }

    public String toString() {
        return "BlankSpan";
    }

    private BlankSpan() {
        super(SpanContext.INVALID, (EnumSet<Span.Options>) null);
    }

    public void putAttribute(String str, AttributeValue attributeValue) {
        Utils.checkNotNull(str, "key");
        Utils.checkNotNull(attributeValue, "value");
    }

    public void putAttributes(Map<String, AttributeValue> map) {
        Utils.checkNotNull(map, "attributes");
    }

    public void addAnnotation(String str, Map<String, AttributeValue> map) {
        Utils.checkNotNull(str, "description");
        Utils.checkNotNull(map, "attributes");
    }

    public void addAnnotation(Annotation annotation) {
        Utils.checkNotNull(annotation, ElementTags.ANNOTATION);
    }

    public void addMessageEvent(MessageEvent messageEvent) {
        Utils.checkNotNull(messageEvent, "messageEvent");
    }

    public void addLink(Link link) {
        Utils.checkNotNull(link, "link");
    }

    public void setStatus(Status status) {
        Utils.checkNotNull(status, "status");
    }

    public void end(EndSpanOptions endSpanOptions) {
        Utils.checkNotNull(endSpanOptions, "options");
    }
}
