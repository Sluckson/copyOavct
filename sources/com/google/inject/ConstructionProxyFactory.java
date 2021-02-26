package com.google.inject;

interface ConstructionProxyFactory<T> {
    ConstructionProxy<T> create();
}
