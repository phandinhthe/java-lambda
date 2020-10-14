package com.terry.phan.java.lambda.function;

import java.util.Objects;

@FunctionalInterface
public interface MyFunction<T, R> {
    R apply(T t);

    default <V> MyFunction<T, V> andThen(MyFunction<R, V> after) {
        Objects.requireNonNull(after);
        return t -> {
            R r = apply(t);
            return after.apply(r);
        };
    }

    default <V> MyFunction<V, R> compose(MyFunction<V, T> before) {
        Objects.requireNonNull(before);
        return (v) -> {
            T t = before.apply(v);
            return apply(t);
        };
    }
}
