package p011io.opencensus.trace.export;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import p011io.opencensus.common.Timestamp;
import p011io.opencensus.internal.Utils;
import p011io.opencensus.trace.Annotation;
import p011io.opencensus.trace.AttributeValue;
import p011io.opencensus.trace.BaseMessageEvent;
import p011io.opencensus.trace.Link;
import p011io.opencensus.trace.MessageEvent;
import p011io.opencensus.trace.NetworkEvent;
import p011io.opencensus.trace.Span;
import p011io.opencensus.trace.SpanContext;
import p011io.opencensus.trace.SpanId;
import p011io.opencensus.trace.Status;
import p011io.opencensus.trace.internal.BaseMessageEventUtils;

@Immutable
/* renamed from: io.opencensus.trace.export.SpanData */
public abstract class SpanData {
    public abstract TimedEvents<Annotation> getAnnotations();

    public abstract Attributes getAttributes();

    @Nullable
    public abstract Integer getChildSpanCount();

    public abstract SpanContext getContext();

    @Nullable
    public abstract Timestamp getEndTimestamp();

    @Nullable
    public abstract Boolean getHasRemoteParent();

    @Nullable
    public abstract Span.Kind getKind();

    public abstract Links getLinks();

    public abstract TimedEvents<MessageEvent> getMessageEvents();

    public abstract String getName();

    @Nullable
    public abstract SpanId getParentSpanId();

    public abstract Timestamp getStartTimestamp();

    @Nullable
    public abstract Status getStatus();

    @Deprecated
    public static SpanData create(SpanContext spanContext, @Nullable SpanId spanId, @Nullable Boolean bool, String str, Timestamp timestamp, Attributes attributes, TimedEvents<Annotation> timedEvents, TimedEvents<? extends BaseMessageEvent> timedEvents2, Links links, @Nullable Integer num, @Nullable Status status, @Nullable Timestamp timestamp2) {
        return create(spanContext, spanId, bool, str, (Span.Kind) null, timestamp, attributes, timedEvents, timedEvents2, links, num, status, timestamp2);
    }

    public static SpanData create(SpanContext spanContext, @Nullable SpanId spanId, @Nullable Boolean bool, String str, @Nullable Span.Kind kind, Timestamp timestamp, Attributes attributes, TimedEvents<Annotation> timedEvents, TimedEvents<? extends BaseMessageEvent> timedEvents2, Links links, @Nullable Integer num, @Nullable Status status, @Nullable Timestamp timestamp2) {
        Utils.checkNotNull(timedEvents2, "messageOrNetworkEvents");
        ArrayList arrayList = new ArrayList();
        for (TimedEvent next : timedEvents2.getEvents()) {
            BaseMessageEvent baseMessageEvent = (BaseMessageEvent) next.getEvent();
            if (baseMessageEvent instanceof MessageEvent) {
                arrayList.add(next);
            } else {
                arrayList.add(TimedEvent.create(next.getTimestamp(), BaseMessageEventUtils.asMessageEvent(baseMessageEvent)));
            }
        }
        return new AutoValue_SpanData(spanContext, spanId, bool, str, kind, timestamp, attributes, timedEvents, TimedEvents.create(arrayList, timedEvents2.getDroppedEventsCount()), links, num, status, timestamp2);
    }

    @Deprecated
    public TimedEvents<NetworkEvent> getNetworkEvents() {
        TimedEvents<MessageEvent> messageEvents = getMessageEvents();
        ArrayList arrayList = new ArrayList();
        for (TimedEvent next : messageEvents.getEvents()) {
            arrayList.add(TimedEvent.create(next.getTimestamp(), BaseMessageEventUtils.asNetworkEvent((BaseMessageEvent) next.getEvent())));
        }
        return TimedEvents.create(arrayList, messageEvents.getDroppedEventsCount());
    }

    SpanData() {
    }

    @Immutable
    /* renamed from: io.opencensus.trace.export.SpanData$TimedEvent */
    public static abstract class TimedEvent<T> {
        public abstract T getEvent();

        public abstract Timestamp getTimestamp();

        public static <T> TimedEvent<T> create(Timestamp timestamp, T t) {
            return new AutoValue_SpanData_TimedEvent(timestamp, t);
        }

        TimedEvent() {
        }
    }

    @Immutable
    /* renamed from: io.opencensus.trace.export.SpanData$TimedEvents */
    public static abstract class TimedEvents<T> {
        public abstract int getDroppedEventsCount();

        public abstract List<TimedEvent<T>> getEvents();

        public static <T> TimedEvents<T> create(List<TimedEvent<T>> list, int i) {
            return new AutoValue_SpanData_TimedEvents(Collections.unmodifiableList(new ArrayList((Collection) Utils.checkNotNull(list, "events"))), i);
        }

        TimedEvents() {
        }
    }

    @Immutable
    /* renamed from: io.opencensus.trace.export.SpanData$Attributes */
    public static abstract class Attributes {
        public abstract Map<String, AttributeValue> getAttributeMap();

        public abstract int getDroppedAttributesCount();

        public static Attributes create(Map<String, AttributeValue> map, int i) {
            return new AutoValue_SpanData_Attributes(Collections.unmodifiableMap(new HashMap((Map) Utils.checkNotNull(map, "attributeMap"))), i);
        }

        Attributes() {
        }
    }

    @Immutable
    /* renamed from: io.opencensus.trace.export.SpanData$Links */
    public static abstract class Links {
        public abstract int getDroppedLinksCount();

        public abstract List<Link> getLinks();

        public static Links create(List<Link> list, int i) {
            return new AutoValue_SpanData_Links(Collections.unmodifiableList(new ArrayList((Collection) Utils.checkNotNull(list, "links"))), i);
        }

        Links() {
        }
    }
}
