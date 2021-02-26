package p011io.sethclark.auto.value.json;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
/* renamed from: io.sethclark.auto.value.json.JsonAdapter */
public @interface JsonAdapter {
    /* renamed from: a */
    Class<? extends JsonTypeAdapter<?>> mo66895a();
}
