package com.terry.phan.java.lambda.consumer;

import java.util.Objects;

@FunctionalInterface
public interface MyConsumer<T> {
    void accept(T t);

    default MyConsumer<T> andThen(MyConsumer<T> after) {
        Objects.requireNonNull(after);
        return t -> {
            accept(t);
            after.accept(t);
        };
    }
}
