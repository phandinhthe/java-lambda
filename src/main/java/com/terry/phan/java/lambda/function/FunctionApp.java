package com.terry.phan.java.lambda.function;

import java.util.Locale;

public class FunctionApp {

    public static final String input = "CyBeRdRaGoN";

    public static void main(String ... args) {
        MyFunction<String, String> toUpperCase = t -> t.toUpperCase();
        System.out.printf("Upper case of '%s' is '%s' \n", input, toUpperCase.apply(input));

        MyFunction<String, String> toUpperCaseChinese = t -> t.toUpperCase(Locale.JAPAN);
        System.out.printf("\t Upper case chinese of '%s' is '%s' \n", input, toUpperCase.andThen(toUpperCaseChinese).apply(input));
    }
}
