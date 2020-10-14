package com.terry.phan.java.lambda.consumer;

import java.util.Objects;

public interface MyBiConsumer<T, U> {
    void accept(T t, U u);

    default MyBiConsumer<T, U> andThen(MyBiConsumer<? super T, ? super U> after) {
        Objects.requireNonNull(after);
        return (t, u) -> {
            accept(t, u);
            after.accept(t, u);
        };
    }
}
