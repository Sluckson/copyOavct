package com.google.inject;

import com.google.inject.internal.Errors;
import com.google.inject.internal.ErrorsException;

interface Initializable<T> {
    T get(Errors errors) throws ErrorsException;
}
