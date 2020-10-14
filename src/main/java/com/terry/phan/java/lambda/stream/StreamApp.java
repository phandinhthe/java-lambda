package com.terry.phan.java.lambda.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApp {

    private static Function<Map.Entry<String, List<String>>, Stream<? extends String>> streamFunction;

    public static void main(String... args) {
        List<String> list = List.of("1", "1", "2", "3", "4", "5");

        String output = list.stream().filter(Predicate.isEqual("1")).findAny().orElse("No output");
        System.out.printf("Testing stream, filter to find the first string equal '%s': '%s' \n", "1", output);

        output = list.stream().filter(Predicate.isEqual("1")).collect(Collectors.joining(" "));
        System.out.printf("Testing stream, filter to find all strings equal '%s': '%s' \n", "1", output);

        List<Integer> integers = list.stream().filter(Predicate.isEqual("1")).map(Integer::valueOf)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.printf("Testing stream, filter to find all strings equal '%s' and map to integers: '%s' \n", "1", integers);

        Map<String, List<String>> map = Map.of("1", list, "2", list);

        streamFunction = entry -> entry.getValue().parallelStream();
        Stream<String> mappedDistinctStream = map.entrySet().parallelStream()
                .flatMap(streamFunction).distinct();
        List<String> mappedOutput = mappedDistinctStream.collect(Collectors.toCollection(ArrayList::new));
        System.out.printf("Testing stream and flatmap, collect all distinct elements: %s \n", mappedOutput);


        Map<Integer, List<Integer>> groupedMap =  list.stream().map(Integer::valueOf)
                .collect(Collectors.groupingBy(t -> t.intValue() % 2 == 0 ? 2 : 1, Collectors.toList()));

        System.out.printf("Testing collectors and groupingBy, group odd and even: %s\n", groupedMap);
    }
}
