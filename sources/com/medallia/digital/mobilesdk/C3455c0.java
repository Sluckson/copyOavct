package com.medallia.digital.mobilesdk;

import java.lang.reflect.Field;
import java.util.List;

/* renamed from: com.medallia.digital.mobilesdk.c0 */
class C3455c0 {
    C3455c0() {
    }

    private void handleUseCases(Field field) {
        if (field.get(this) instanceof C3455c0) {
            ((C3455c0) field.get(this)).validateFields();
        } else if (field.get(this) instanceof List) {
            for (Object next : (List) field.get(this)) {
                if (next instanceof C3455c0) {
                    ((C3455c0) next).validateFields();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void validateFields() {
        for (Field field : getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                if (field.get(this) == null) {
                    C3490e3.m666f(field.getName() + " data is missing");
                } else {
                    handleUseCases(field);
                }
            } catch (IllegalAccessException e) {
                C3490e3.m663c(e.getMessage());
            } catch (Throwable th) {
                field.setAccessible(false);
                throw th;
            }
            field.setAccessible(false);
        }
    }
}
