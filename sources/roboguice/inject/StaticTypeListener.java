package roboguice.inject;

import com.google.inject.spi.TypeListener;

public interface StaticTypeListener extends TypeListener {
    void requestStaticInjection(Class<?>... clsArr);
}
