package dagger.android.support;

import androidx.fragment.app.Fragment;
import dagger.MapKey;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@MapKey
@Target({ElementType.METHOD})
public @interface FragmentKey {
    Class<? extends Fragment> value();
}
