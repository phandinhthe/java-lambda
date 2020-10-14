package com.terry.phan.java.lambda.predicate;

public class PredicateApp {
    public static void main(String[] args) {
        String input = "a";
        int inputInt = 97;

        MyPredicate<String> predicate = p -> p.equals("a");

        if (predicate.test(input)) {
            System.out.println(String.format("Input is %s", input));
        }

        MyPredicate<String> andPredicate = predicate.and(s -> (int) s.charAt(0) == inputInt);
        if (andPredicate.test(input)) {
            System.out.println(String.format("Input is '%s' and position in ASCII is %d", input, inputInt));
        }

        MyPredicate<String> orPredicate = predicate.or(s -> s.equals("A"));
        if (orPredicate.test(input)) {
            System.out.println(String.format("Input is '%s' or '%s'", input, "A"));
        }

        MyPredicate<String> negatePredicate = predicate.negate();
        if (negatePredicate.test("A")) {
            System.out.println(String.format("Input is '%s', not '%s'", "A", input));
        }

        if (MyPredicate.not(negatePredicate).test(input)) {
            System.out.println(String.format("Testing static not(), Input is %s", input));
        }

        if (MyPredicate.isEqual("a").test(input)) {
            System.out.println(String.format("Testing method isEqual, source is '%s' and target is '%s'", input, "a"));
        }
    }
}
