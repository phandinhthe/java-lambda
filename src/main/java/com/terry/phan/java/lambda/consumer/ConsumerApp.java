package com.terry.phan.java.lambda.consumer;

public class ConsumerApp {
    public static void main(String... args) {
        MyConsumer<String> myConsumer = s -> System.out.printf("Consuming %s \n", s);
        myConsumer.accept("character 's'");

        MyConsumer<String> afterConsumer = s -> System.out.printf("\t -> Then consume %s \n", s);
        myConsumer.andThen(afterConsumer).accept("character 'S'");

        // MyBiConsumer
        MyBiConsumer<String, String> myBiConsumer = (t, u) -> System.out.printf("Consuming %s and %s \n", t, u);
        myBiConsumer.accept("a", "b");

        MyBiConsumer<String, String> afterBiConsumer = (t, u) -> System.out.printf("\t then consume %s and %s \n", t, u);
        myBiConsumer.andThen(afterBiConsumer).accept("A", "B");

    }
}
