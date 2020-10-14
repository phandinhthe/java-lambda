package com.terry.phan.java.lambda.supply;

public class SupplierApp {
    public static void main(String ... args) {
        MySupplier<String> toUpperA = () -> "A";
        System.out.println("Supplier to upper character a is: " + toUpperA.get());
    }
}
