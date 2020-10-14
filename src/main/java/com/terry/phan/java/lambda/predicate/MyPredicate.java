package com.terry.phan.java.lambda.predicate;

import java.util.Objects;

@FunctionalInterface
public interface MyPredicate<T> {
    boolean test(T t);

    default MyPredicate<T> and(MyPredicate<T> other) {
        Objects.requireNonNull(other);
        return t -> (test(t) && other.test(t));
    }

    default MyPredicate<T> or(MyPredicate<T> other) {
        Objects.requireNonNull(other);
        return t -> (test(t) || other.test(t));
    }

    default MyPredicate<T> negate() {
        return t -> !test(t);
    }

    static <T> MyPredicate<T> isEqual(Object targetRef) {
        if (Objects.isNull(targetRef)) return Objects::isNull;

        return t -> (t.equals(targetRef));
    }

    static <T> MyPredicate<T> not(MyPredicate<T> predicate) {
        Objects.requireNonNull(predicate);
        return predicate.negate();
    }

}
