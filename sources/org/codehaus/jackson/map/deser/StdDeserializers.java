package org.codehaus.jackson.map.deser;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.Type;
import java.util.GregorianCalendar;
import java.util.HashMap;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.deser.StdDeserializer;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;

class StdDeserializers {
    final HashMap<JavaType, JsonDeserializer<Object>> _deserializers = new HashMap<>();

    private StdDeserializers() {
        add(new UntypedObjectDeserializer());
        StdDeserializer.StringDeserializer stringDeserializer = new StdDeserializer.StringDeserializer();
        add(stringDeserializer, String.class);
        add(stringDeserializer, CharSequence.class);
        add(new StdDeserializer.ClassDeserializer());
        add(new StdDeserializer.BooleanDeserializer(Boolean.class, (Boolean) null));
        add(new StdDeserializer.ByteDeserializer(Byte.class, (Byte) null));
        add(new StdDeserializer.ShortDeserializer(Short.class, (Short) null));
        add(new StdDeserializer.CharacterDeserializer(Character.class, (Character) null));
        add(new StdDeserializer.IntegerDeserializer(Integer.class, (Integer) null));
        add(new StdDeserializer.LongDeserializer(Long.class, (Long) null));
        add(new StdDeserializer.FloatDeserializer(Float.class, (Float) null));
        add(new StdDeserializer.DoubleDeserializer(Double.class, (Double) null));
        add(new StdDeserializer.BooleanDeserializer(Boolean.TYPE, Boolean.FALSE));
        add(new StdDeserializer.ByteDeserializer(Byte.TYPE, (byte) 0));
        add(new StdDeserializer.ShortDeserializer(Short.TYPE, 0));
        add(new StdDeserializer.CharacterDeserializer(Character.TYPE, 0));
        add(new StdDeserializer.IntegerDeserializer(Integer.TYPE, 0));
        add(new StdDeserializer.LongDeserializer(Long.TYPE, 0L));
        add(new StdDeserializer.FloatDeserializer(Float.TYPE, Float.valueOf(0.0f)));
        add(new StdDeserializer.DoubleDeserializer(Double.TYPE, Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)));
        add(new StdDeserializer.NumberDeserializer());
        add(new StdDeserializer.BigDecimalDeserializer());
        add(new StdDeserializer.BigIntegerDeserializer());
        add(new DateDeserializer());
        add(new StdDeserializer.SqlDateDeserializer());
        add(new TimestampDeserializer());
        add(new StdDeserializer.CalendarDeserializer());
        add(new StdDeserializer.CalendarDeserializer(GregorianCalendar.class), GregorianCalendar.class);
        for (FromStringDeserializer<?> add : FromStringDeserializer.all()) {
            add(add);
        }
        add(new StdDeserializer.StackTraceElementDeserializer());
        add(new StdDeserializer.TokenBufferDeserializer());
        add(new StdDeserializer.AtomicBooleanDeserializer());
    }

    public static HashMap<JavaType, JsonDeserializer<Object>> constructAll() {
        return new StdDeserializers()._deserializers;
    }

    private void add(StdDeserializer<?> stdDeserializer) {
        add(stdDeserializer, stdDeserializer.getValueClass());
    }

    private void add(StdDeserializer<?> stdDeserializer, Class<?> cls) {
        this._deserializers.put(TypeFactory.defaultInstance().constructType((Type) cls), stdDeserializer);
    }
}
